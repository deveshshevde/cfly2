package kw;

import java.io.File;

public class a {
    public static boolean a(File file) {
        if (file.isDirectory()) {
            String[] list = file.list();
            for (String file2 : list) {
                if (!a(new File(file, file2))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.delete();
    }
}
