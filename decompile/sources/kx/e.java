package kx;

import android.content.Context;
import java.io.File;
import java.io.FilenameFilter;

public class e {
    public static String[] a(Context context) {
        return a(d.c(context), new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.contains(".txt");
            }
        });
    }

    public static String[] a(String str, FilenameFilter filenameFilter) {
        File file = new File(str);
        try {
            file.mkdirs();
            if (file.exists()) {
                return file.list(filenameFilter);
            }
        } catch (SecurityException e2) {
            e2.printStackTrace();
        }
        return new String[0];
    }

    public static String[] b(Context context) {
        return a(d.d(context), new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.contains(".txt");
            }
        });
    }

    public static String[] c(Context context) {
        return a(d.b(context), new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.contains(".param");
            }
        });
    }

    public static String[] d(Context context) {
        return a(d.w(context), new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.contains(".xml");
            }
        });
    }
}
