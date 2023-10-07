package nd;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.List;
import okhttp3.ab;
import okhttp3.l;
import okhttp3.m;
import okhttp3.s;
import okhttp3.t;
import okio.ByteString;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final ByteString f31376a = ByteString.a("\"\\");

    /* renamed from: b  reason: collision with root package name */
    private static final ByteString f31377b = ByteString.a("\t ,=");

    public static int a(String str, int i2) {
        while (i2 < str.length() && ((r0 = str.charAt(i2)) == ' ' || r0 == 9)) {
            i2++;
        }
        return i2;
    }

    public static int a(String str, int i2, String str2) {
        while (i2 < str.length() && str2.indexOf(str.charAt(i2)) == -1) {
            i2++;
        }
        return i2;
    }

    private static long a(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static long a(ab abVar) {
        return a(abVar.f());
    }

    public static long a(s sVar) {
        return a(sVar.a("Content-Length"));
    }

    public static void a(m mVar, t tVar, s sVar) {
        if (mVar != m.f32278a) {
            List<l> a2 = l.a(tVar, sVar);
            if (!a2.isEmpty()) {
                mVar.a(tVar, a2);
            }
        }
    }

    public static int b(String str, int i2) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return SubsamplingScaleImageView.TILE_SIZE_AUTO;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i2;
        }
    }

    public static boolean b(ab abVar) {
        if (abVar.a().b().equals("HEAD")) {
            return false;
        }
        int b2 = abVar.b();
        return (((b2 >= 100 && b2 < 200) || b2 == 204 || b2 == 304) && a(abVar) == -1 && !"chunked".equalsIgnoreCase(abVar.a("Transfer-Encoding"))) ? false : true;
    }
}
