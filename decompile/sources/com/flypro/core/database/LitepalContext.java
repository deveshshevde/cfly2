package com.flypro.core.database;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Environment;
import com.flypro.core.util.c;
import ea.a;
import java.io.File;
import java.io.IOException;

public class LitepalContext extends ContextWrapper {
    static final String[] PERMISSIONS = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    private c permissionChecker = new c(this);

    public LitepalContext(Context context) {
        super(context);
    }

    public File getExternalFilesDir(String str) {
        if (!"mounted".equals(Environment.getExternalStorageState()) || this.permissionChecker.a(PERMISSIONS)) {
            return super.getExternalFilesDir(str);
        }
        File file = new File(a.d(getApplicationContext()).replace("//", "/"));
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
