package fz;

import android.graphics.PointF;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.k;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f28334a;

    /* renamed from: b  reason: collision with root package name */
    public final int f28335b;

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f28336a;

        /* renamed from: b  reason: collision with root package name */
        public final int f28337b;

        /* renamed from: c  reason: collision with root package name */
        public final int f28338c;

        private a(int i2, int i3, int i4) {
            this.f28336a = i2;
            this.f28337b = i3;
            this.f28338c = i4;
        }

        public static a a(String str) {
            String[] split = TextUtils.split(str.substring(7), ",");
            int i2 = -1;
            int i3 = -1;
            for (int i4 = 0; i4 < split.length; i4++) {
                String d2 = ad.d(split[i4].trim());
                d2.hashCode();
                if (d2.equals("name")) {
                    i2 = i4;
                } else if (d2.equals("alignment")) {
                    i3 = i4;
                }
            }
            if (i2 != -1) {
                return new a(i2, i3, split.length);
            }
            return null;
        }
    }

    static final class b {

        /* renamed from: c  reason: collision with root package name */
        private static final Pattern f28339c = Pattern.compile("\\{([^}]*)\\}");

        /* renamed from: d  reason: collision with root package name */
        private static final Pattern f28340d = Pattern.compile(ad.a("\\\\pos\\((%1$s),(%1$s)\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* renamed from: e  reason: collision with root package name */
        private static final Pattern f28341e = Pattern.compile(ad.a("\\\\move\\(%1$s,%1$s,(%1$s),(%1$s)(?:,%1$s,%1$s)?\\)", "\\s*\\d+(?:\\.\\d+)?\\s*"));

        /* renamed from: f  reason: collision with root package name */
        private static final Pattern f28342f = Pattern.compile("\\\\an(\\d+)");

        /* renamed from: a  reason: collision with root package name */
        public final int f28343a;

        /* renamed from: b  reason: collision with root package name */
        public final PointF f28344b;

        private b(int i2, PointF pointF) {
            this.f28343a = i2;
            this.f28344b = pointF;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(9:3|4|5|(1:7)|8|9|(2:11|18)(1:17)|15|1) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001b */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0009 A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static fz.c.b a(java.lang.String r5) {
            /*
                java.util.regex.Pattern r0 = f28339c
                java.util.regex.Matcher r5 = r0.matcher(r5)
                r0 = -1
                r1 = 0
                r2 = -1
            L_0x0009:
                boolean r3 = r5.find()
                if (r3 == 0) goto L_0x0025
                r3 = 1
                java.lang.String r3 = r5.group(r3)
                android.graphics.PointF r4 = c(r3)     // Catch:{ RuntimeException -> 0x001b }
                if (r4 == 0) goto L_0x001b
                r1 = r4
            L_0x001b:
                int r3 = d(r3)     // Catch:{ RuntimeException -> 0x0023 }
                if (r3 == r0) goto L_0x0009
                r2 = r3
                goto L_0x0009
            L_0x0023:
                goto L_0x0009
            L_0x0025:
                fz.c$b r5 = new fz.c$b
                r5.<init>(r2, r1)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: fz.c.b.a(java.lang.String):fz.c$b");
        }

        public static String b(String str) {
            return f28339c.matcher(str).replaceAll("");
        }

        private static PointF c(String str) {
            String str2;
            String str3;
            Matcher matcher = f28340d.matcher(str);
            Matcher matcher2 = f28341e.matcher(str);
            boolean find = matcher.find();
            boolean find2 = matcher2.find();
            if (find) {
                if (find2) {
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 82);
                    sb.append("Override has both \\pos(x,y) and \\move(x1,y1,x2,y2); using \\pos values. override='");
                    sb.append(str);
                    sb.append("'");
                    k.b("SsaStyle.Overrides", sb.toString());
                }
                str2 = matcher.group(1);
                str3 = matcher.group(2);
            } else if (!find2) {
                return null;
            } else {
                str2 = matcher2.group(1);
                str3 = matcher2.group(2);
            }
            return new PointF(Float.parseFloat(((String) com.google.android.exoplayer2.util.a.b(str2)).trim()), Float.parseFloat(((String) com.google.android.exoplayer2.util.a.b(str3)).trim()));
        }

        private static int d(String str) {
            Matcher matcher = f28342f.matcher(str);
            if (matcher.find()) {
                return c.b(matcher.group(1));
            }
            return -1;
        }
    }

    private c(String str, int i2) {
        this.f28334a = str;
        this.f28335b = i2;
    }

    public static c a(String str, a aVar) {
        com.google.android.exoplayer2.util.a.a(str.startsWith("Style:"));
        String[] split = TextUtils.split(str.substring(6), ",");
        if (split.length != aVar.f28338c) {
            k.c("SsaStyle", ad.a("Skipping malformed 'Style:' line (expected %s values, found %s): '%s'", Integer.valueOf(aVar.f28338c), Integer.valueOf(split.length), str));
            return null;
        }
        try {
            return new c(split[aVar.f28336a].trim(), b(split[aVar.f28337b]));
        } catch (RuntimeException e2) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 36);
            sb.append("Skipping malformed 'Style:' line: '");
            sb.append(str);
            sb.append("'");
            k.a("SsaStyle", sb.toString(), e2);
            return null;
        }
    }

    private static boolean a(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return true;
            default:
                return false;
        }
    }

    /* access modifiers changed from: private */
    public static int b(String str) {
        try {
            int parseInt = Integer.parseInt(str.trim());
            if (a(parseInt)) {
                return parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        String valueOf = String.valueOf(str);
        k.c("SsaStyle", valueOf.length() != 0 ? "Ignoring unknown alignment: ".concat(valueOf) : new String("Ignoring unknown alignment: "));
        return -1;
    }
}
