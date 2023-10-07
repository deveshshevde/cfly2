package cp;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;

public class c implements b {
    private String a(Throwable th) {
        StringWriter stringWriter = new StringWriter(256);
        PrintWriter printWriter = new PrintWriter(stringWriter, false);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    private void a(int i2, String str, String str2) {
        int length = str2.length() / 4000;
        if (length > 0) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                int i5 = i4 + 4000;
                b(i2, str, str2.substring(i4, i5));
                i3++;
                i4 = i5;
            }
            str2 = str2.substring(i4, str2.length());
        }
        b(i2, str, str2);
    }

    private void b(int i2, String str, String str2) {
        if (i2 == 3) {
            Log.d(str, str2);
        } else if (i2 == 4) {
            Log.i(str, str2);
        } else if (i2 == 5) {
            Log.w(str, str2);
        } else if (i2 == 6) {
            Log.e(str, str2);
        } else if (i2 != 7) {
            Log.v(str, str2);
        } else {
            Log.wtf(str, str2);
        }
    }

    public void a(int i2, String str, String str2, Throwable th) {
        if (str2 != null && str2.length() == 0) {
            str2 = null;
        }
        if (str2 == null) {
            if (th != null) {
                str2 = a(th);
            } else {
                return;
            }
        } else if (th != null) {
            str2 = str2 + "\n" + a(th);
        }
        a(i2, str, str2);
    }
}
