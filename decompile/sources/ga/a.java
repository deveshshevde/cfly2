package ga;

import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import com.google.android.exoplayer2.text.b;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.e;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.q;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f28357a = Pattern.compile("\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*-->\\s*((?:(\\d+):)?(\\d+):(\\d+)(?:,(\\d+))?)\\s*");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f28358b = Pattern.compile("\\{\\\\.*?\\}");

    /* renamed from: c  reason: collision with root package name */
    private final StringBuilder f28359c = new StringBuilder();

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<String> f28360d = new ArrayList<>();

    public a() {
        super("SubripDecoder");
    }

    private static long a(Matcher matcher, int i2) {
        String group = matcher.group(i2 + 1);
        long parseLong = (group != null ? Long.parseLong(group) * 60 * 60 * 1000 : 0) + (Long.parseLong(matcher.group(i2 + 2)) * 60 * 1000) + (Long.parseLong(matcher.group(i2 + 3)) * 1000);
        String group2 = matcher.group(i2 + 4);
        if (group2 != null) {
            parseLong += Long.parseLong(group2);
        }
        return parseLong * 1000;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.exoplayer2.text.b a(android.text.Spanned r19, java.lang.String r20) {
        /*
            r18 = this;
            r0 = r20
            if (r0 != 0) goto L_0x000c
            com.google.android.exoplayer2.text.b r0 = new com.google.android.exoplayer2.text.b
            r2 = r19
            r0.<init>(r2)
            return r0
        L_0x000c:
            r2 = r19
            int r1 = r20.hashCode()
            java.lang.String r6 = "{\\an9}"
            java.lang.String r7 = "{\\an8}"
            java.lang.String r8 = "{\\an7}"
            java.lang.String r9 = "{\\an6}"
            java.lang.String r10 = "{\\an5}"
            java.lang.String r11 = "{\\an4}"
            java.lang.String r12 = "{\\an3}"
            java.lang.String r13 = "{\\an2}"
            java.lang.String r14 = "{\\an1}"
            r16 = 0
            r4 = 4
            r5 = 3
            r15 = 2
            r3 = 1
            switch(r1) {
                case -685620710: goto L_0x006f;
                case -685620679: goto L_0x0067;
                case -685620648: goto L_0x005f;
                case -685620617: goto L_0x0057;
                case -685620586: goto L_0x004f;
                case -685620555: goto L_0x0047;
                case -685620524: goto L_0x003f;
                case -685620493: goto L_0x0036;
                case -685620462: goto L_0x002e;
                default: goto L_0x002d;
            }
        L_0x002d:
            goto L_0x0077
        L_0x002e:
            boolean r1 = r0.equals(r6)
            if (r1 == 0) goto L_0x0077
            r1 = 5
            goto L_0x0078
        L_0x0036:
            boolean r1 = r0.equals(r7)
            if (r1 == 0) goto L_0x0077
            r1 = 8
            goto L_0x0078
        L_0x003f:
            boolean r1 = r0.equals(r8)
            if (r1 == 0) goto L_0x0077
            r1 = 2
            goto L_0x0078
        L_0x0047:
            boolean r1 = r0.equals(r9)
            if (r1 == 0) goto L_0x0077
            r1 = 4
            goto L_0x0078
        L_0x004f:
            boolean r1 = r0.equals(r10)
            if (r1 == 0) goto L_0x0077
            r1 = 7
            goto L_0x0078
        L_0x0057:
            boolean r1 = r0.equals(r11)
            if (r1 == 0) goto L_0x0077
            r1 = 1
            goto L_0x0078
        L_0x005f:
            boolean r1 = r0.equals(r12)
            if (r1 == 0) goto L_0x0077
            r1 = 3
            goto L_0x0078
        L_0x0067:
            boolean r1 = r0.equals(r13)
            if (r1 == 0) goto L_0x0077
            r1 = 6
            goto L_0x0078
        L_0x006f:
            boolean r1 = r0.equals(r14)
            if (r1 == 0) goto L_0x0077
            r1 = 0
            goto L_0x0078
        L_0x0077:
            r1 = -1
        L_0x0078:
            if (r1 == 0) goto L_0x008b
            if (r1 == r3) goto L_0x008b
            if (r1 == r15) goto L_0x008b
            if (r1 == r5) goto L_0x0088
            if (r1 == r4) goto L_0x0088
            r4 = 5
            if (r1 == r4) goto L_0x0088
            r17 = 1
            goto L_0x008d
        L_0x0088:
            r17 = 2
            goto L_0x008d
        L_0x008b:
            r17 = 0
        L_0x008d:
            int r1 = r20.hashCode()
            switch(r1) {
                case -685620710: goto L_0x00d6;
                case -685620679: goto L_0x00ce;
                case -685620648: goto L_0x00c6;
                case -685620617: goto L_0x00be;
                case -685620586: goto L_0x00b6;
                case -685620555: goto L_0x00ad;
                case -685620524: goto L_0x00a5;
                case -685620493: goto L_0x009d;
                case -685620462: goto L_0x0095;
                default: goto L_0x0094;
            }
        L_0x0094:
            goto L_0x00de
        L_0x0095:
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L_0x00de
            r0 = 5
            goto L_0x00df
        L_0x009d:
            boolean r0 = r0.equals(r7)
            if (r0 == 0) goto L_0x00de
            r0 = 4
            goto L_0x00df
        L_0x00a5:
            boolean r0 = r0.equals(r8)
            if (r0 == 0) goto L_0x00de
            r0 = 3
            goto L_0x00df
        L_0x00ad:
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x00de
            r0 = 8
            goto L_0x00df
        L_0x00b6:
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x00de
            r0 = 7
            goto L_0x00df
        L_0x00be:
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L_0x00de
            r0 = 6
            goto L_0x00df
        L_0x00c6:
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x00de
            r0 = 2
            goto L_0x00df
        L_0x00ce:
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x00de
            r0 = 1
            goto L_0x00df
        L_0x00d6:
            boolean r0 = r0.equals(r14)
            if (r0 == 0) goto L_0x00de
            r0 = 0
            goto L_0x00df
        L_0x00de:
            r0 = -1
        L_0x00df:
            if (r0 == 0) goto L_0x00f1
            if (r0 == r3) goto L_0x00f1
            if (r0 == r15) goto L_0x00f1
            if (r0 == r5) goto L_0x00ef
            r1 = 4
            if (r0 == r1) goto L_0x00ef
            r1 = 5
            if (r0 == r1) goto L_0x00ef
            r6 = 1
            goto L_0x00f2
        L_0x00ef:
            r6 = 0
            goto L_0x00f2
        L_0x00f1:
            r6 = 2
        L_0x00f2:
            com.google.android.exoplayer2.text.b r0 = new com.google.android.exoplayer2.text.b
            r3 = 0
            float r4 = b(r6)
            r5 = 0
            float r7 = b(r17)
            r9 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            r1 = r0
            r2 = r19
            r8 = r17
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ga.a.a(android.text.Spanned, java.lang.String):com.google.android.exoplayer2.text.b");
    }

    private String a(String str, ArrayList<String> arrayList) {
        String trim = str.trim();
        StringBuilder sb = new StringBuilder(trim);
        Matcher matcher = f28358b.matcher(trim);
        int i2 = 0;
        while (matcher.find()) {
            String group = matcher.group();
            arrayList.add(group);
            int start = matcher.start() - i2;
            int length = group.length();
            sb.replace(start, start + length, "");
            i2 += length;
        }
        return sb.toString();
    }

    static float b(int i2) {
        if (i2 == 0) {
            return 0.08f;
        }
        if (i2 == 1) {
            return 0.5f;
        }
        if (i2 == 2) {
            return 0.92f;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: protected */
    public e a(byte[] bArr, int i2, boolean z2) {
        String str;
        String str2;
        String str3;
        ArrayList arrayList = new ArrayList();
        l lVar = new l();
        q qVar = new q(bArr, i2);
        while (true) {
            String B = qVar.B();
            if (B == null) {
                break;
            } else if (B.length() != 0) {
                try {
                    Integer.parseInt(B);
                    String B2 = qVar.B();
                    if (B2 == null) {
                        k.c("SubripDecoder", "Unexpected end");
                        break;
                    }
                    Matcher matcher = f28357a.matcher(B2);
                    if (matcher.matches()) {
                        lVar.a(a(matcher, 1));
                        lVar.a(a(matcher, 6));
                        int i3 = 0;
                        this.f28359c.setLength(0);
                        this.f28360d.clear();
                        while (true) {
                            String B3 = qVar.B();
                            if (TextUtils.isEmpty(B3)) {
                                break;
                            }
                            if (this.f28359c.length() > 0) {
                                this.f28359c.append("<br>");
                            }
                            this.f28359c.append(a(B3, this.f28360d));
                        }
                        Spanned fromHtml = Html.fromHtml(this.f28359c.toString());
                        String str4 = null;
                        while (true) {
                            if (i3 >= this.f28360d.size()) {
                                break;
                            }
                            String str5 = this.f28360d.get(i3);
                            if (str5.matches("\\{\\\\an[1-9]\\}")) {
                                str4 = str5;
                                break;
                            }
                            i3++;
                        }
                        arrayList.add(a(fromHtml, str4));
                        arrayList.add(b.f16584a);
                    } else {
                        str2 = "Skipping invalid timing: ";
                        str3 = String.valueOf(B2);
                        if (str3.length() == 0) {
                            str = new String(str2);
                            k.c("SubripDecoder", str);
                        }
                        str = str2.concat(str3);
                        k.c("SubripDecoder", str);
                    }
                } catch (NumberFormatException unused) {
                    str2 = "Skipping invalid index: ";
                    str3 = String.valueOf(B);
                    if (str3.length() == 0) {
                        str = new String(str2);
                    }
                }
            }
        }
        b[] bVarArr = new b[arrayList.size()];
        arrayList.toArray(bVarArr);
        return new b(bVarArr, lVar.b());
    }
}
