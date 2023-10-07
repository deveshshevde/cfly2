package com.xeagle.android.login.common;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

public class StorageUtil {
    public static final long K = 1024;
    public static final long M = 1048576;
    static final long THRESHOLD_MIN_SPCAE = 20971520;
    private static final long THRESHOLD_WARNING_SPACE = 104857600;

    public static void checkValid() {
        ExternalStorage.getInstance().checkStorageValid();
    }

    public static String getDirectoryByDirType(StorageType storageType) {
        return ExternalStorage.getInstance().getDirectoryByDirType(storageType);
    }

    public static String getReadPath(String str, StorageType storageType) {
        return ExternalStorage.getInstance().getReadPath(str, storageType);
    }

    public static String getSystemImagePath() {
        String absolutePath;
        StringBuilder sb;
        if (Build.VERSION.SDK_INT > 7) {
            absolutePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();
            sb = new StringBuilder();
        } else {
            absolutePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
            sb = new StringBuilder();
        }
        sb.append(absolutePath);
        sb.append("/nim/");
        return sb.toString();
    }

    public static String getWritePath(Context context, String str, StorageType storageType) {
        return getWritePath(context, str, storageType, true);
    }

    private static String getWritePath(Context context, String str, StorageType storageType, boolean z2) {
        String writePath = ExternalStorage.getInstance().getWritePath(str, storageType);
        if (TextUtils.isEmpty(writePath)) {
            return null;
        }
        File parentFile = new File(writePath).getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        return writePath;
    }

    public static String getWritePath(String str, StorageType storageType) {
        return getWritePath((Context) null, str, storageType, false);
    }

    public static boolean hasEnoughSpaceForWrite(Context context, StorageType storageType, boolean z2) {
        return ExternalStorage.getInstance().isSdkStorageReady() && ExternalStorage.getInstance().getAvailableExternalSize() >= storageType.getStorageMinSize();
    }

    public static void init(Context context, String str) {
        ExternalStorage.getInstance().init(context, str);
    }

    public static boolean isExternalStorageExist() {
        return ExternalStorage.getInstance().isSdkStorageReady();
    }

    public static boolean isInvalidVideoFile(String str) {
        return str.toLowerCase().endsWith(".3gp") || str.toLowerCase().endsWith(".mp4");
    }
}
