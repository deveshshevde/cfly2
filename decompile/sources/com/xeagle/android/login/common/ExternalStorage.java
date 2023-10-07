package com.xeagle.android.login.common;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.IOException;

public class ExternalStorage {
    protected static String NO_MEDIA_FILE_NAME = ".nomedia";
    private static final String TAG = "ExternalStorage";
    private static ExternalStorage instance;
    private Context context;
    private boolean hasPermission = true;
    private String sdkStorageRoot = null;

    private ExternalStorage() {
    }

    private boolean checkPermission(Context context2) {
        String str;
        if (context2 == null) {
            str = "checkMPermission context null";
        } else if (context2.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", context2.getApplicationInfo().packageName) == 0) {
            return true;
        } else {
            str = "without permission to access storage";
        }
        Log.e(TAG, str);
        return false;
    }

    private void createNoMediaFile(String str) {
        File file = new File(str + "/" + NO_MEDIA_FILE_NAME);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private void createSubFolders() {
        File file = new File(this.sdkStorageRoot);
        if (file.exists() && !file.isDirectory()) {
            file.delete();
        }
        boolean z2 = true;
        for (StorageType storageType : StorageType.values()) {
            z2 &= makeDirectory(this.sdkStorageRoot + storageType.getStoragePath());
        }
        if (z2) {
            createNoMediaFile(this.sdkStorageRoot);
        }
    }

    public static synchronized ExternalStorage getInstance() {
        ExternalStorage externalStorage;
        synchronized (ExternalStorage.class) {
            if (instance == null) {
                instance = new ExternalStorage();
            }
            externalStorage = instance;
        }
        return externalStorage;
    }

    private long getResidualSpace(String str) {
        try {
            StatFs statFs = new StatFs(str);
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    private void loadStorageState(Context context2) {
        String path = Environment.getExternalStorageDirectory().getPath();
        this.sdkStorageRoot = path + "/" + context2.getPackageName() + "/";
    }

    private boolean makeDirectory(String str) {
        File file = new File(str);
        boolean exists = file.exists();
        return !exists ? file.mkdirs() : exists;
    }

    private String pathForName(String str, StorageType storageType, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder(getDirectoryByDirType(storageType));
        if (!z2) {
            sb.append(str);
        }
        String sb2 = sb.toString();
        File file = new File(sb2);
        return z3 ? (!file.exists() || ((!z2 || !file.isDirectory()) && (z2 || file.isDirectory()))) ? "" : sb2 : sb2;
    }

    public boolean checkStorageValid() {
        if (this.hasPermission) {
            return true;
        }
        boolean checkPermission = checkPermission(this.context);
        this.hasPermission = checkPermission;
        if (checkPermission) {
            Log.i(TAG, "get permission to access storage");
            createSubFolders();
        }
        return this.hasPermission;
    }

    public long getAvailableExternalSize() {
        return getResidualSpace(this.sdkStorageRoot);
    }

    public String getDirectoryByDirType(StorageType storageType) {
        return this.sdkStorageRoot + storageType.getStoragePath();
    }

    public String getReadPath(String str, StorageType storageType) {
        return TextUtils.isEmpty(str) ? "" : pathForName(str, storageType, false, true);
    }

    public String getWritePath(String str, StorageType storageType) {
        return pathForName(str, storageType, false, false);
    }

    public void init(Context context2, String str) {
        this.context = context2;
        this.hasPermission = checkPermission(context2);
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (file.exists() && !file.isFile()) {
                this.sdkStorageRoot = str;
                if (!str.endsWith("/")) {
                    this.sdkStorageRoot = str + "/";
                }
            }
        }
        if (TextUtils.isEmpty(this.sdkStorageRoot)) {
            loadStorageState(context2);
        }
        createSubFolders();
    }

    public boolean isSdkStorageReady() {
        if (this.sdkStorageRoot.startsWith(Environment.getExternalStorageDirectory().getAbsolutePath())) {
            return Environment.getExternalStorageState().equals("mounted");
        }
        return true;
    }
}
