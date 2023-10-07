package com.xeagle.android.login.database;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Environment;
import com.xeagle.android.utils.permission.a;
import java.io.File;
import java.io.IOException;
import kx.d;

public class LitepalContext extends ContextWrapper {
    static final String[] PERMISSIONS = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    private a permissionChecker = new a(this);

    public LitepalContext(Context context) {
        super(context);
    }

    public File getExternalFilesDir(String str) {
        if (!"mounted".equals(Environment.getExternalStorageState()) || this.permissionChecker.a(PERMISSIONS)) {
            return super.getExternalFilesDir(str);
        }
        File file = new File(d.e(getApplicationContext()).replace("//", "/"));
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return file;
    }
}
