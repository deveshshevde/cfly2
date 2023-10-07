package ea;

import android.content.Context;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class d {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f26844a = true;

    public static FileOutputStream a(Context context, String str) throws FileNotFoundException {
        File file = new File(a.b(context));
        file.mkdirs();
        File file2 = new File(file, str);
        if (file2.exists()) {
            file2.delete();
        }
        return new FileOutputStream(file2);
    }

    public static FileOutputStream b(Context context, String str) throws FileNotFoundException {
        File file = new File(a.e(context));
        file.mkdirs();
        File file2 = new File(file, str);
        if (file2.exists()) {
            file2.delete();
        }
        return new FileOutputStream(file2);
    }

    public static File c(Context context, String str) {
        File file = new File(a.c(context));
        file.mkdirs();
        return new File(file, str);
    }
}
