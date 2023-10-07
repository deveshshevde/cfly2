package gd;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.q;
import com.xeagle.android.login.pickImage.data.GLImage;
import gd.e;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f28446a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f28447b = Pattern.compile("(\\S+?):(\\S+)");

    /* renamed from: c  reason: collision with root package name */
    private final StringBuilder f28448c = new StringBuilder();

    private static final class a {

        /* renamed from: e  reason: collision with root package name */
        private static final String[] f28449e = new String[0];

        /* renamed from: a  reason: collision with root package name */
        public final String f28450a;

        /* renamed from: b  reason: collision with root package name */
        public final int f28451b;

        /* renamed from: c  reason: collision with root package name */
        public final String f28452c;

        /* renamed from: d  reason: collision with root package name */
        public final String[] f28453d;

        private a(String str, int i2, String str2, String[] strArr) {
            this.f28451b = i2;
            this.f28450a = str;
            this.f28452c = str2;
            this.f28453d = strArr;
        }

        public static a a() {
            return new a("", 0, "", new String[0]);
        }

        public static a a(String str, int i2) {
            String str2;
            String trim = str.trim();
            com.google.android.exoplayer2.util.a.a(!trim.isEmpty());
            int indexOf = trim.indexOf(" ");
            if (indexOf == -1) {
                str2 = "";
            } else {
                String trim2 = trim.substring(indexOf).trim();
                trim = trim.substring(0, indexOf);
                str2 = trim2;
            }
            String[] a2 = ad.a(trim, "\\.");
            return new a(a2[0], i2, str2, a2.length > 1 ? (String[]) ad.a((T[]) a2, 1, a2.length) : f28449e);
        }
    }

    private static final class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        public final int f28454a;

        /* renamed from: b  reason: collision with root package name */
        public final d f28455b;

        public b(int i2, d dVar) {
            this.f28454a = i2;
            this.f28455b = dVar;
        }

        /* renamed from: a */
        public int compareTo(b bVar) {
            return this.f28454a - bVar.f28454a;
        }
    }

    private static int a(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c2 = 1;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c2 = 2;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 0;
            default:
                String valueOf = String.valueOf(str);
                k.c("WebvttCueParser", valueOf.length() != 0 ? "Invalid anchor value: ".concat(valueOf) : new String("Invalid anchor value: "));
                return Integer.MIN_VALUE;
        }
    }

    private static int a(String str, int i2) {
        int indexOf = str.indexOf(62, i2);
        return indexOf == -1 ? str.length() : indexOf + 1;
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, d dVar, int i2, int i3) {
        Object obj;
        if (dVar != null) {
            if (dVar.b() != -1) {
                spannableStringBuilder.setSpan(new StyleSpan(dVar.b()), i2, i3, 33);
            }
            if (dVar.c()) {
                spannableStringBuilder.setSpan(new StrikethroughSpan(), i2, i3, 33);
            }
            if (dVar.d()) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i2, i3, 33);
            }
            if (dVar.g()) {
                spannableStringBuilder.setSpan(new ForegroundColorSpan(dVar.f()), i2, i3, 33);
            }
            if (dVar.i()) {
                spannableStringBuilder.setSpan(new BackgroundColorSpan(dVar.h()), i2, i3, 33);
            }
            if (dVar.e() != null) {
                spannableStringBuilder.setSpan(new TypefaceSpan(dVar.e()), i2, i3, 33);
            }
            Layout.Alignment j2 = dVar.j();
            if (j2 != null) {
                spannableStringBuilder.setSpan(new AlignmentSpan.Standard(j2), i2, i3, 33);
            }
            int k2 = dVar.k();
            if (k2 == 1) {
                obj = new AbsoluteSizeSpan((int) dVar.l(), true);
            } else if (k2 == 2) {
                obj = new RelativeSizeSpan(dVar.l());
            } else if (k2 == 3) {
                obj = new RelativeSizeSpan(dVar.l() / 100.0f);
            } else {
                return;
            }
            spannableStringBuilder.setSpan(obj, i2, i3, 33);
        }
    }

    private static void a(String str, SpannableStringBuilder spannableStringBuilder) {
        char c2;
        str.hashCode();
        char c3 = 65535;
        switch (str.hashCode()) {
            case 3309:
                if (str.equals("gt")) {
                    c3 = 0;
                    break;
                }
                break;
            case 3464:
                if (str.equals("lt")) {
                    c3 = 1;
                    break;
                }
                break;
            case 96708:
                if (str.equals("amp")) {
                    c3 = 2;
                    break;
                }
                break;
            case 3374865:
                if (str.equals("nbsp")) {
                    c3 = 3;
                    break;
                }
                break;
        }
        switch (c3) {
            case 0:
                c2 = '>';
                break;
            case 1:
                c2 = '<';
                break;
            case 2:
                c2 = '&';
                break;
            case 3:
                c2 = ' ';
                break;
            default:
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33);
                sb.append("ignoring unsupported entity: '&");
                sb.append(str);
                sb.append(";'");
                k.c("WebvttCueParser", sb.toString());
                return;
        }
        spannableStringBuilder.append(c2);
    }

    static void a(String str, e.a aVar) {
        Matcher matcher = f28447b.matcher(str);
        while (matcher.find()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            try {
                if ("line".equals(group)) {
                    b(group2, aVar);
                } else if ("align".equals(group)) {
                    aVar.a(b(group2));
                } else if ("position".equals(group)) {
                    c(group2, aVar);
                } else if (GLImage.KEY_SIZE.equals(group)) {
                    aVar.c(h.b(group2));
                } else {
                    StringBuilder sb = new StringBuilder(String.valueOf(group).length() + 21 + String.valueOf(group2).length());
                    sb.append("Unknown cue setting ");
                    sb.append(group);
                    sb.append(":");
                    sb.append(group2);
                    k.c("WebvttCueParser", sb.toString());
                }
            } catch (NumberFormatException unused) {
                String valueOf = String.valueOf(matcher.group());
                k.c("WebvttCueParser", valueOf.length() != 0 ? "Skipping bad cue setting: ".concat(valueOf) : new String("Skipping bad cue setting: "));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0089 A[LOOP:0: B:31:0x0087->B:32:0x0089, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.lang.String r8, gd.f.a r9, android.text.SpannableStringBuilder r10, java.util.List<gd.d> r11, java.util.List<gd.f.b> r12) {
        /*
            int r0 = r9.f28451b
            int r1 = r10.length()
            java.lang.String r2 = r9.f28450a
            r2.hashCode()
            int r3 = r2.hashCode()
            r4 = 2
            r5 = 0
            r6 = 1
            r7 = -1
            switch(r3) {
                case 0: goto L_0x0059;
                case 98: goto L_0x004e;
                case 99: goto L_0x0043;
                case 105: goto L_0x0038;
                case 117: goto L_0x002d;
                case 118: goto L_0x0022;
                case 3314158: goto L_0x0017;
                default: goto L_0x0016;
            }
        L_0x0016:
            goto L_0x0063
        L_0x0017:
            java.lang.String r3 = "lang"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0020
            goto L_0x0063
        L_0x0020:
            r7 = 6
            goto L_0x0063
        L_0x0022:
            java.lang.String r3 = "v"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x002b
            goto L_0x0063
        L_0x002b:
            r7 = 5
            goto L_0x0063
        L_0x002d:
            java.lang.String r3 = "u"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0036
            goto L_0x0063
        L_0x0036:
            r7 = 4
            goto L_0x0063
        L_0x0038:
            java.lang.String r3 = "i"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0041
            goto L_0x0063
        L_0x0041:
            r7 = 3
            goto L_0x0063
        L_0x0043:
            java.lang.String r3 = "c"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x004c
            goto L_0x0063
        L_0x004c:
            r7 = 2
            goto L_0x0063
        L_0x004e:
            java.lang.String r3 = "b"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0057
            goto L_0x0063
        L_0x0057:
            r7 = 1
            goto L_0x0063
        L_0x0059:
            java.lang.String r3 = ""
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0062
            goto L_0x0063
        L_0x0062:
            r7 = 0
        L_0x0063:
            r2 = 33
            switch(r7) {
                case 0: goto L_0x007d;
                case 1: goto L_0x0075;
                case 2: goto L_0x007d;
                case 3: goto L_0x006f;
                case 4: goto L_0x0069;
                case 5: goto L_0x007d;
                case 6: goto L_0x007d;
                default: goto L_0x0068;
            }
        L_0x0068:
            return
        L_0x0069:
            android.text.style.UnderlineSpan r3 = new android.text.style.UnderlineSpan
            r3.<init>()
            goto L_0x007a
        L_0x006f:
            android.text.style.StyleSpan r3 = new android.text.style.StyleSpan
            r3.<init>(r4)
            goto L_0x007a
        L_0x0075:
            android.text.style.StyleSpan r3 = new android.text.style.StyleSpan
            r3.<init>(r6)
        L_0x007a:
            r10.setSpan(r3, r0, r1, r2)
        L_0x007d:
            r12.clear()
            a((java.util.List<gd.d>) r11, (java.lang.String) r8, (gd.f.a) r9, (java.util.List<gd.f.b>) r12)
            int r8 = r12.size()
        L_0x0087:
            if (r5 >= r8) goto L_0x0097
            java.lang.Object r9 = r12.get(r5)
            gd.f$b r9 = (gd.f.b) r9
            gd.d r9 = r9.f28455b
            a((android.text.SpannableStringBuilder) r10, (gd.d) r9, (int) r0, (int) r1)
            int r5 = r5 + 1
            goto L_0x0087
        L_0x0097:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: gd.f.a(java.lang.String, gd.f$a, android.text.SpannableStringBuilder, java.util.List, java.util.List):void");
    }

    static void a(String str, String str2, e.a aVar, List<d> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < str2.length()) {
            char charAt = str2.charAt(i2);
            if (charAt == '&') {
                i2++;
                int indexOf = str2.indexOf(59, i2);
                int indexOf2 = str2.indexOf(32, i2);
                if (indexOf == -1) {
                    indexOf = indexOf2;
                } else if (indexOf2 != -1) {
                    indexOf = Math.min(indexOf, indexOf2);
                }
                if (indexOf != -1) {
                    a(str2.substring(i2, indexOf), spannableStringBuilder);
                    if (indexOf == indexOf2) {
                        spannableStringBuilder.append(" ");
                    }
                    i2 = indexOf + 1;
                } else {
                    spannableStringBuilder.append(charAt);
                }
            } else if (charAt != '<') {
                spannableStringBuilder.append(charAt);
                i2++;
            } else {
                int i3 = i2 + 1;
                if (i3 < str2.length()) {
                    int i4 = 1;
                    boolean z2 = str2.charAt(i3) == '/';
                    i3 = a(str2, i3);
                    int i5 = i3 - 2;
                    boolean z3 = str2.charAt(i5) == '/';
                    if (z2) {
                        i4 = 2;
                    }
                    int i6 = i2 + i4;
                    if (!z3) {
                        i5 = i3 - 1;
                    }
                    String substring = str2.substring(i6, i5);
                    if (!substring.trim().isEmpty()) {
                        String d2 = d(substring);
                        if (c(d2)) {
                            if (z2) {
                                while (!arrayDeque.isEmpty()) {
                                    a aVar2 = (a) arrayDeque.pop();
                                    a(str, aVar2, spannableStringBuilder, list, arrayList);
                                    if (aVar2.f28450a.equals(d2)) {
                                        break;
                                    }
                                }
                            } else if (!z3) {
                                arrayDeque.push(a.a(substring, spannableStringBuilder.length()));
                            }
                        }
                    }
                }
                i2 = i3;
            }
        }
        while (!arrayDeque.isEmpty()) {
            a(str, (a) arrayDeque.pop(), spannableStringBuilder, list, arrayList);
        }
        a(str, a.a(), spannableStringBuilder, list, arrayList);
        aVar.a((CharSequence) spannableStringBuilder);
    }

    private static void a(List<d> list, String str, a aVar, List<b> list2) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = list.get(i2);
            int a2 = dVar.a(str, aVar.f28450a, aVar.f28453d, aVar.f28452c);
            if (a2 > 0) {
                list2.add(new b(a2, dVar));
            }
        }
        Collections.sort(list2);
    }

    private static boolean a(String str, Matcher matcher, q qVar, e.a aVar, StringBuilder sb, List<d> list) {
        try {
            aVar.a(h.a(matcher.group(1))).b(h.a(matcher.group(2)));
            a(matcher.group(3), aVar);
            sb.setLength(0);
            while (true) {
                String B = qVar.B();
                if (!TextUtils.isEmpty(B)) {
                    if (sb.length() > 0) {
                        sb.append("\n");
                    }
                    sb.append(B.trim());
                } else {
                    a(str, sb.toString(), aVar, list);
                    return true;
                }
            }
        } catch (NumberFormatException unused) {
            String valueOf = String.valueOf(matcher.group());
            k.c("WebvttCueParser", valueOf.length() != 0 ? "Skipping cue with bad header: ".concat(valueOf) : new String("Skipping cue with bad header: "));
            return false;
        }
    }

    private static int b(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1074341483:
                if (str.equals("middle")) {
                    c2 = 1;
                    break;
                }
                break;
            case 100571:
                if (str.equals("end")) {
                    c2 = 2;
                    break;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    c2 = 3;
                    break;
                }
                break;
            case 108511772:
                if (str.equals("right")) {
                    c2 = 4;
                    break;
                }
                break;
            case 109757538:
                if (str.equals("start")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 1;
            default:
                String valueOf = String.valueOf(str);
                k.c("WebvttCueParser", valueOf.length() != 0 ? "Invalid alignment value: ".concat(valueOf) : new String("Invalid alignment value: "));
                return 2;
        }
    }

    private static void b(String str, e.a aVar) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            aVar.c(a(str.substring(indexOf + 1)));
            str = str.substring(0, indexOf);
        }
        if (str.endsWith("%")) {
            aVar.a(h.b(str)).b(0);
            return;
        }
        int parseInt = Integer.parseInt(str);
        if (parseInt < 0) {
            parseInt--;
        }
        aVar.a((float) parseInt).b(1);
    }

    private static void c(String str, e.a aVar) {
        int indexOf = str.indexOf(44);
        if (indexOf != -1) {
            aVar.d(a(str.substring(indexOf + 1)));
            str = str.substring(0, indexOf);
        }
        aVar.b(h.b(str));
    }

    private static boolean c(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 98:
                if (str.equals("b")) {
                    c2 = 0;
                    break;
                }
                break;
            case 99:
                if (str.equals("c")) {
                    c2 = 1;
                    break;
                }
                break;
            case 105:
                if (str.equals("i")) {
                    c2 = 2;
                    break;
                }
                break;
            case 117:
                if (str.equals("u")) {
                    c2 = 3;
                    break;
                }
                break;
            case 118:
                if (str.equals("v")) {
                    c2 = 4;
                    break;
                }
                break;
            case 3314158:
                if (str.equals("lang")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            default:
                return false;
        }
    }

    private static String d(String str) {
        String trim = str.trim();
        com.google.android.exoplayer2.util.a.a(!trim.isEmpty());
        return ad.b(trim, "[ \\.]")[0];
    }

    public boolean a(q qVar, e.a aVar, List<d> list) {
        String B = qVar.B();
        if (B == null) {
            return false;
        }
        Pattern pattern = f28446a;
        Matcher matcher = pattern.matcher(B);
        if (matcher.matches()) {
            return a((String) null, matcher, qVar, aVar, this.f28448c, list);
        }
        String B2 = qVar.B();
        if (B2 == null) {
            return false;
        }
        Matcher matcher2 = pattern.matcher(B2);
        if (!matcher2.matches()) {
            return false;
        }
        return a(B.trim(), matcher2, qVar, aVar, this.f28448c, list);
    }
}
