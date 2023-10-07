package ea;

import android.content.Context;
import java.io.File;
import java.io.FilenameFilter;

public class b {
    public static String[] a(Context context) {
        return a(a.b(context), new FilenameFilter() {
            public boolean accept(File file, String str) {
                return str.contains(".rec");
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
}
