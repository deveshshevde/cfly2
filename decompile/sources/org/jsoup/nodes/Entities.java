package org.jsoup.nodes;

import java.io.IOException;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import java.util.HashMap;
import org.jsoup.helper.c;
import org.jsoup.nodes.Document;
import org.jsoup.parser.a;

public class Entities {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f33635a = {',', ';'};

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<String, String> f33636b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static final Document.OutputSettings f33637c = new Document.OutputSettings();

    /* renamed from: org.jsoup.nodes.Entities$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33638a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.jsoup.nodes.Entities$CoreCharset[] r0 = org.jsoup.nodes.Entities.CoreCharset.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f33638a = r0
                org.jsoup.nodes.Entities$CoreCharset r1 = org.jsoup.nodes.Entities.CoreCharset.ascii     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f33638a     // Catch:{ NoSuchFieldError -> 0x001d }
                org.jsoup.nodes.Entities$CoreCharset r1 = org.jsoup.nodes.Entities.CoreCharset.utf     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.jsoup.nodes.Entities.AnonymousClass1.<clinit>():void");
        }
    }

    enum CoreCharset {
        ascii,
        utf,
        fallback;

        static CoreCharset a(String str) {
            return str.equals("US-ASCII") ? ascii : str.startsWith("UTF-") ? utf : fallback;
        }
    }

    public enum EscapeMode {
        xhtml(g.f33661a, 4),
        base(g.f33662b, 106),
        extended(g.f33663c, 2125);
        
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String[] f33647d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int[] f33648e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int[] f33649f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public String[] f33650g;

        private EscapeMode(String str, int i2) {
            Entities.b(this, str, i2);
        }

        /* access modifiers changed from: package-private */
        public int a(String str) {
            int binarySearch = Arrays.binarySearch(this.f33647d, str);
            if (binarySearch >= 0) {
                return this.f33648e[binarySearch];
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public String a(int i2) {
            int binarySearch = Arrays.binarySearch(this.f33649f, i2);
            if (binarySearch < 0) {
                return "";
            }
            String[] strArr = this.f33650g;
            if (binarySearch < strArr.length - 1) {
                int i3 = binarySearch + 1;
                if (this.f33649f[i3] == i2) {
                    return strArr[i3];
                }
            }
            return strArr[binarySearch];
        }
    }

    public static int a(String str, int[] iArr) {
        String str2 = f33636b.get(str);
        if (str2 != null) {
            iArr[0] = str2.codePointAt(0);
            iArr[1] = str2.codePointAt(1);
            return 2;
        }
        int a2 = EscapeMode.extended.a(str);
        if (a2 == -1) {
            return 0;
        }
        iArr[0] = a2;
        return 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0050, code lost:
        if (a(r12, r8, r1) != false) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x008b, code lost:
        if (r1.canEncode(r8) != false) goto L_0x0071;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void a(java.lang.Appendable r10, java.lang.String r11, org.jsoup.nodes.Document.OutputSettings r12, boolean r13, boolean r14, boolean r15) throws java.io.IOException {
        /*
            org.jsoup.nodes.Entities$EscapeMode r0 = r12.a()
            java.nio.charset.CharsetEncoder r1 = r12.d()
            org.jsoup.nodes.Entities$CoreCharset r12 = r12.f33610a
            int r2 = r11.length()
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
        L_0x0012:
            if (r4 >= r2) goto L_0x0095
            int r7 = r11.codePointAt(r4)
            r8 = 1
            if (r14 == 0) goto L_0x0033
            boolean r9 = oh.c.b((int) r7)
            if (r9 == 0) goto L_0x0031
            if (r15 == 0) goto L_0x0025
            if (r5 == 0) goto L_0x008e
        L_0x0025:
            if (r6 == 0) goto L_0x0029
            goto L_0x008e
        L_0x0029:
            r6 = 32
            r10.append(r6)
            r6 = 1
            goto L_0x008e
        L_0x0031:
            r5 = 1
            r6 = 0
        L_0x0033:
            r8 = 65536(0x10000, float:9.18355E-41)
            if (r7 >= r8) goto L_0x007e
            char r8 = (char) r7
            r9 = 34
            if (r8 == r9) goto L_0x0075
            r9 = 38
            if (r8 == r9) goto L_0x006f
            r9 = 60
            if (r8 == r9) goto L_0x0066
            r9 = 62
            if (r8 == r9) goto L_0x0061
            r9 = 160(0xa0, float:2.24E-43)
            if (r8 == r9) goto L_0x0057
            boolean r9 = a((org.jsoup.nodes.Entities.CoreCharset) r12, (char) r8, (java.nio.charset.CharsetEncoder) r1)
            if (r9 == 0) goto L_0x0053
            goto L_0x007a
        L_0x0053:
            a((java.lang.Appendable) r10, (org.jsoup.nodes.Entities.EscapeMode) r0, (int) r7)
            goto L_0x008e
        L_0x0057:
            org.jsoup.nodes.Entities$EscapeMode r8 = org.jsoup.nodes.Entities.EscapeMode.xhtml
            if (r0 == r8) goto L_0x005e
            java.lang.String r8 = "&nbsp;"
            goto L_0x0071
        L_0x005e:
            java.lang.String r8 = "&#xa0;"
            goto L_0x0071
        L_0x0061:
            if (r13 != 0) goto L_0x007a
            java.lang.String r8 = "&gt;"
            goto L_0x0071
        L_0x0066:
            if (r13 == 0) goto L_0x006c
            org.jsoup.nodes.Entities$EscapeMode r9 = org.jsoup.nodes.Entities.EscapeMode.xhtml
            if (r0 != r9) goto L_0x007a
        L_0x006c:
            java.lang.String r8 = "&lt;"
            goto L_0x0071
        L_0x006f:
            java.lang.String r8 = "&amp;"
        L_0x0071:
            r10.append(r8)
            goto L_0x008e
        L_0x0075:
            if (r13 == 0) goto L_0x007a
            java.lang.String r8 = "&quot;"
            goto L_0x0071
        L_0x007a:
            r10.append(r8)
            goto L_0x008e
        L_0x007e:
            java.lang.String r8 = new java.lang.String
            char[] r9 = java.lang.Character.toChars(r7)
            r8.<init>(r9)
            boolean r9 = r1.canEncode(r8)
            if (r9 == 0) goto L_0x0053
            goto L_0x0071
        L_0x008e:
            int r7 = java.lang.Character.charCount(r7)
            int r4 = r4 + r7
            goto L_0x0012
        L_0x0095:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.nodes.Entities.a(java.lang.Appendable, java.lang.String, org.jsoup.nodes.Document$OutputSettings, boolean, boolean, boolean):void");
    }

    private static void a(Appendable appendable, EscapeMode escapeMode, int i2) throws IOException {
        Appendable appendable2;
        String a2 = escapeMode.a(i2);
        if (!"".equals(a2)) {
            appendable2 = appendable.append('&');
        } else {
            appendable2 = appendable.append("&#x");
            a2 = Integer.toHexString(i2);
        }
        appendable2.append(a2).append(';');
    }

    public static boolean a(String str) {
        return EscapeMode.extended.a(str) != -1;
    }

    private static boolean a(CoreCharset coreCharset, char c2, CharsetEncoder charsetEncoder) {
        int i2 = AnonymousClass1.f33638a[coreCharset.ordinal()];
        if (i2 == 1) {
            return c2 < 128;
        }
        if (i2 != 2) {
            return charsetEncoder.canEncode(c2);
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static void b(EscapeMode escapeMode, String str, int i2) {
        int i3;
        String[] unused = escapeMode.f33647d = new String[i2];
        int[] unused2 = escapeMode.f33648e = new int[i2];
        int[] unused3 = escapeMode.f33649f = new int[i2];
        String[] unused4 = escapeMode.f33650g = new String[i2];
        a aVar = new a(str);
        boolean z2 = false;
        int i4 = 0;
        while (!aVar.c()) {
            String b2 = aVar.b('=');
            aVar.g();
            int parseInt = Integer.parseInt(aVar.a(f33635a), 36);
            char d2 = aVar.d();
            aVar.g();
            if (d2 == ',') {
                i3 = Integer.parseInt(aVar.b(';'), 36);
                aVar.g();
            } else {
                i3 = -1;
            }
            int parseInt2 = Integer.parseInt(aVar.b('&'), 36);
            aVar.g();
            escapeMode.f33647d[i4] = b2;
            escapeMode.f33648e[i4] = parseInt;
            escapeMode.f33649f[parseInt2] = parseInt;
            escapeMode.f33650g[parseInt2] = b2;
            if (i3 != -1) {
                f33636b.put(b2, new String(new int[]{parseInt, i3}, 0, 2));
            }
            i4++;
        }
        if (i4 == i2) {
            z2 = true;
        }
        c.a(z2, "Unexpected count of entities loaded");
    }

    public static boolean b(String str) {
        return EscapeMode.base.a(str) != -1;
    }
}
