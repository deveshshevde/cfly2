package iq;

import android.content.Context;
import com.liulishuo.filedownloader.exception.PathConflictException;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import com.liulishuo.filedownloader.y;
import java.io.File;
import java.io.IOException;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static Context f29056a;

    public interface a {
        int a(int i2, String str, String str2, long j2);
    }

    public interface b {
        im.b a(String str) throws IOException;
    }

    /* renamed from: iq.c$c  reason: collision with other inner class name */
    public interface C0196c {
        in.a a();
    }

    public interface d {
        int a(int i2, String str, String str2, boolean z2);

        int a(String str, String str2, boolean z2);
    }

    public interface e {
        ip.a a(File file) throws IOException;

        boolean a();
    }

    public static Context a() {
        return f29056a;
    }

    public static void a(Context context) {
        f29056a = context;
    }

    public static boolean a(int i2, long j2, String str, String str2, y yVar) {
        int a2;
        if (str2 == null || str == null || (a2 = yVar.a(str, i2)) == 0) {
            return false;
        }
        com.liulishuo.filedownloader.message.c.a().a(com.liulishuo.filedownloader.message.d.a(i2, j2, (Throwable) new PathConflictException(a2, str, str2)));
        return true;
    }

    public static boolean a(int i2, FileDownloadModel fileDownloadModel, y yVar, boolean z2) {
        if (!yVar.a(fileDownloadModel)) {
            return false;
        }
        com.liulishuo.filedownloader.message.c.a().a(com.liulishuo.filedownloader.message.d.a(i2, fileDownloadModel.g(), fileDownloadModel.h(), z2));
        return true;
    }

    public static boolean a(int i2, String str, boolean z2, boolean z3) {
        if (!z2 && str != null) {
            File file = new File(str);
            if (file.exists()) {
                com.liulishuo.filedownloader.message.c.a().a(com.liulishuo.filedownloader.message.d.a(i2, file, z3));
                return true;
            }
        }
        return false;
    }
}
