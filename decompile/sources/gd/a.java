package gd;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.d;
import com.google.android.exoplayer2.util.q;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f28428a = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* renamed from: b  reason: collision with root package name */
    private final q f28429b = new q();

    /* renamed from: c  reason: collision with root package name */
    private final StringBuilder f28430c = new StringBuilder();

    private static char a(q qVar, int i2) {
        return (char) qVar.f17159a[i2];
    }

    static String a(q qVar, StringBuilder sb) {
        b(qVar);
        if (qVar.b() == 0) {
            return null;
        }
        String d2 = d(qVar, sb);
        if (!"".equals(d2)) {
            return d2;
        }
        StringBuilder sb2 = new StringBuilder(1);
        sb2.append((char) qVar.h());
        return sb2.toString();
    }

    private static void a(q qVar, d dVar, StringBuilder sb) {
        b(qVar);
        String d2 = d(qVar, sb);
        if (!"".equals(d2) && ":".equals(a(qVar, sb))) {
            b(qVar);
            String c2 = c(qVar, sb);
            if (c2 != null && !"".equals(c2)) {
                int d3 = qVar.d();
                String a2 = a(qVar, sb);
                if (!";".equals(a2)) {
                    if ("}".equals(a2)) {
                        qVar.c(d3);
                    } else {
                        return;
                    }
                }
                if ("color".equals(d2)) {
                    dVar.a(d.b(c2));
                } else if ("background-color".equals(d2)) {
                    dVar.b(d.b(c2));
                } else if ("text-decoration".equals(d2)) {
                    if ("underline".equals(c2)) {
                        dVar.a(true);
                    }
                } else if ("font-family".equals(d2)) {
                    dVar.d(c2);
                } else if ("font-weight".equals(d2)) {
                    if ("bold".equals(c2)) {
                        dVar.b(true);
                    }
                } else if ("font-style".equals(d2) && "italic".equals(c2)) {
                    dVar.c(true);
                }
            }
        }
    }

    private void a(d dVar, String str) {
        if (!"".equals(str)) {
            int indexOf = str.indexOf(91);
            if (indexOf != -1) {
                Matcher matcher = f28428a.matcher(str.substring(indexOf));
                if (matcher.matches()) {
                    dVar.c(matcher.group(1));
                }
                str = str.substring(0, indexOf);
            }
            String[] a2 = ad.a(str, "\\.");
            String str2 = a2[0];
            int indexOf2 = str2.indexOf(35);
            if (indexOf2 != -1) {
                dVar.b(str2.substring(0, indexOf2));
                dVar.a(str2.substring(indexOf2 + 1));
            } else {
                dVar.b(str2);
            }
            if (a2.length > 1) {
                dVar.a((String[]) ad.a((T[]) a2, 1, a2.length));
            }
        }
    }

    private static String b(q qVar, StringBuilder sb) {
        b(qVar);
        if (qVar.b() < 5 || !"::cue".equals(qVar.e(5))) {
            return null;
        }
        int d2 = qVar.d();
        String a2 = a(qVar, sb);
        if (a2 == null) {
            return null;
        }
        if ("{".equals(a2)) {
            qVar.c(d2);
            return "";
        }
        String d3 = "(".equals(a2) ? d(qVar) : null;
        if (!")".equals(a(qVar, sb))) {
            return null;
        }
        return d3;
    }

    static void b(q qVar) {
        while (true) {
            boolean z2 = true;
            while (qVar.b() > 0 && z2) {
                if (!e(qVar) && !f(qVar)) {
                    z2 = false;
                }
            }
            return;
        }
    }

    private static String c(q qVar, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        boolean z2 = false;
        while (!z2) {
            int d2 = qVar.d();
            String a2 = a(qVar, sb);
            if (a2 == null) {
                return null;
            }
            if ("}".equals(a2) || ";".equals(a2)) {
                qVar.c(d2);
                z2 = true;
            } else {
                sb2.append(a2);
            }
        }
        return sb2.toString();
    }

    static void c(q qVar) {
        do {
        } while (!TextUtils.isEmpty(qVar.B()));
    }

    private static String d(q qVar) {
        int d2 = qVar.d();
        int c2 = qVar.c();
        boolean z2 = false;
        while (d2 < c2 && !z2) {
            int i2 = d2 + 1;
            z2 = ((char) qVar.f17159a[d2]) == ')';
            d2 = i2;
        }
        return qVar.e((d2 - 1) - qVar.d()).trim();
    }

    private static String d(q qVar, StringBuilder sb) {
        boolean z2 = false;
        sb.setLength(0);
        int d2 = qVar.d();
        int c2 = qVar.c();
        while (d2 < c2 && !z2) {
            char c3 = (char) qVar.f17159a[d2];
            if ((c3 < 'A' || c3 > 'Z') && ((c3 < 'a' || c3 > 'z') && !((c3 >= '0' && c3 <= '9') || c3 == '#' || c3 == '-' || c3 == '.' || c3 == '_'))) {
                z2 = true;
            } else {
                d2++;
                sb.append(c3);
            }
        }
        qVar.d(d2 - qVar.d());
        return sb.toString();
    }

    private static boolean e(q qVar) {
        char a2 = a(qVar, qVar.d());
        if (a2 != 9 && a2 != 10 && a2 != 12 && a2 != 13 && a2 != ' ') {
            return false;
        }
        qVar.d(1);
        return true;
    }

    private static boolean f(q qVar) {
        int d2 = qVar.d();
        int c2 = qVar.c();
        byte[] bArr = qVar.f17159a;
        if (d2 + 2 > c2) {
            return false;
        }
        int i2 = d2 + 1;
        if (bArr[d2] != 47) {
            return false;
        }
        int i3 = i2 + 1;
        if (bArr[i2] != 42) {
            return false;
        }
        while (true) {
            int i4 = i3 + 1;
            if (i4 >= c2) {
                qVar.d(c2 - qVar.d());
                return true;
            } else if (((char) bArr[i3]) == '*' && ((char) bArr[i4]) == '/') {
                i3 = i4 + 1;
                c2 = i3;
            } else {
                i3 = i4;
            }
        }
    }

    public List<d> a(q qVar) {
        this.f28430c.setLength(0);
        int d2 = qVar.d();
        c(qVar);
        this.f28429b.a(qVar.f17159a, qVar.d());
        this.f28429b.c(d2);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String b2 = b(this.f28429b, this.f28430c);
            if (b2 == null || !"{".equals(a(this.f28429b, this.f28430c))) {
                return arrayList;
            }
            d dVar = new d();
            a(dVar, b2);
            String str = null;
            boolean z2 = false;
            while (!z2) {
                int d3 = this.f28429b.d();
                String a2 = a(this.f28429b, this.f28430c);
                boolean z3 = a2 == null || "}".equals(a2);
                if (!z3) {
                    this.f28429b.c(d3);
                    a(this.f28429b, dVar, this.f28430c);
                }
                str = a2;
                z2 = z3;
            }
            if ("}".equals(str)) {
                arrayList.add(dVar);
            }
        }
    }
}
