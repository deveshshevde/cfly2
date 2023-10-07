package gd;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.q;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f28461a = Pattern.compile("^NOTE([ \t].*)?$");

    public static long a(String str) throws NumberFormatException {
        String[] b2 = ad.b(str, "\\.");
        long j2 = 0;
        for (String parseLong : ad.a(b2[0], ":")) {
            j2 = (j2 * 60) + Long.parseLong(parseLong);
        }
        long j3 = j2 * 1000;
        if (b2.length == 2) {
            j3 += Long.parseLong(b2[1]);
        }
        return j3 * 1000;
    }

    public static void a(q qVar) throws ParserException {
        int d2 = qVar.d();
        if (!b(qVar)) {
            qVar.c(d2);
            String valueOf = String.valueOf(qVar.B());
            throw new ParserException(valueOf.length() != 0 ? "Expected WEBVTT. Got ".concat(valueOf) : new String("Expected WEBVTT. Got "));
        }
    }

    public static float b(String str) throws NumberFormatException {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }

    public static boolean b(q qVar) {
        String B = qVar.B();
        return B != null && B.startsWith("WEBVTT");
    }

    public static Matcher c(q qVar) {
        String B;
        while (true) {
            String B2 = qVar.B();
            if (B2 == null) {
                return null;
            }
            if (f28461a.matcher(B2).matches()) {
                do {
                    B = qVar.B();
                    if (B == null) {
                        break;
                    }
                } while (B.isEmpty());
            } else {
                Matcher matcher = f.f28446a.matcher(B2);
                if (matcher.matches()) {
                    return matcher;
                }
            }
        }
    }
}
