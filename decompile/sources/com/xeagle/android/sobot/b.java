package com.xeagle.android.sobot;

import android.os.Environment;
import java.io.File;
import java.io.IOException;

public class b {
    public static File a(String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return file;
    }

    public static boolean a() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static boolean a(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.delete();
        }
        return false;
    }
}
