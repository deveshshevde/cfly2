package fz;

import android.text.Layout;
import com.google.android.exoplayer2.text.b;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.e;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.q;
import fz.c;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f28323a = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");

    /* renamed from: b  reason: collision with root package name */
    private final boolean f28324b;

    /* renamed from: c  reason: collision with root package name */
    private final b f28325c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, c> f28326d;

    /* renamed from: e  reason: collision with root package name */
    private float f28327e;

    /* renamed from: f  reason: collision with root package name */
    private float f28328f;

    public a() {
        this((List<byte[]>) null);
    }

    public a(List<byte[]> list) {
        super("SsaDecoder");
        this.f28327e = -3.4028235E38f;
        this.f28328f = -3.4028235E38f;
        if (list == null || list.isEmpty()) {
            this.f28324b = false;
            this.f28325c = null;
            return;
        }
        this.f28324b = true;
        String a2 = ad.a(list.get(0));
        com.google.android.exoplayer2.util.a.a(a2.startsWith("Format:"));
        this.f28325c = (b) com.google.android.exoplayer2.util.a.b(b.a(a2));
        a(new q(list.get(1)));
    }

    private static int a(long j2, List<Long> list, List<List<b>> list2) {
        int i2;
        ArrayList arrayList;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                i2 = 0;
                break;
            } else if (list.get(size).longValue() == j2) {
                return size;
            } else {
                if (list.get(size).longValue() < j2) {
                    i2 = size + 1;
                    break;
                }
                size--;
            }
        }
        list.add(i2, Long.valueOf(j2));
        if (i2 != 0) {
            arrayList = new ArrayList(list2.get(i2 - 1));
        }
        list2.add(i2, arrayList);
        return i2;
    }

    private static long a(String str) {
        Matcher matcher = f28323a.matcher(str.trim());
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        return (Long.parseLong((String) ad.a(matcher.group(1))) * 60 * 60 * 1000000) + (Long.parseLong((String) ad.a(matcher.group(2))) * 60 * 1000000) + (Long.parseLong((String) ad.a(matcher.group(3))) * 1000000) + (Long.parseLong((String) ad.a(matcher.group(4))) * 10000);
    }

    private static b a(String str, c cVar, c.b bVar, float f2, float f3) {
        float f4;
        float f5;
        int i2 = -1;
        if (bVar.f28343a != -1) {
            i2 = bVar.f28343a;
        } else if (cVar != null) {
            i2 = cVar.f28335b;
        }
        int d2 = d(i2);
        int c2 = c(i2);
        if (bVar.f28344b == null || f3 == -3.4028235E38f || f2 == -3.4028235E38f) {
            f5 = e(d2);
            f4 = e(c2);
        } else {
            f5 = bVar.f28344b.x / f2;
            f4 = bVar.f28344b.y / f3;
        }
        float f6 = f4;
        return new b(str, b(i2), f6, 0, c2, f5, d2, -3.4028235E38f);
    }

    private void a(q qVar) {
        while (true) {
            String B = qVar.B();
            if (B == null) {
                return;
            }
            if ("[Script Info]".equalsIgnoreCase(B)) {
                b(qVar);
            } else if ("[V4+ Styles]".equalsIgnoreCase(B)) {
                this.f28326d = c(qVar);
            } else if ("[V4 Styles]".equalsIgnoreCase(B)) {
                k.b("SsaDecoder", "[V4 Styles] are not supported");
            } else if ("[Events]".equalsIgnoreCase(B)) {
                return;
            }
        }
    }

    private void a(q qVar, List<List<b>> list, List<Long> list2) {
        b bVar = this.f28324b ? this.f28325c : null;
        while (true) {
            String B = qVar.B();
            if (B == null) {
                return;
            }
            if (B.startsWith("Format:")) {
                bVar = b.a(B);
            } else if (B.startsWith("Dialogue:")) {
                if (bVar == null) {
                    String valueOf = String.valueOf(B);
                    k.c("SsaDecoder", valueOf.length() != 0 ? "Skipping dialogue line before complete format: ".concat(valueOf) : new String("Skipping dialogue line before complete format: "));
                } else {
                    a(B, bVar, list, list2);
                }
            }
        }
    }

    private void a(String str, b bVar, List<List<b>> list, List<Long> list2) {
        com.google.android.exoplayer2.util.a.a(str.startsWith("Dialogue:"));
        String[] split = str.substring(9).split(",", bVar.f28333e);
        if (split.length != bVar.f28333e) {
            String valueOf = String.valueOf(str);
            k.c("SsaDecoder", valueOf.length() != 0 ? "Skipping dialogue line with fewer columns than format: ".concat(valueOf) : new String("Skipping dialogue line with fewer columns than format: "));
            return;
        }
        long a2 = a(split[bVar.f28329a]);
        if (a2 == -9223372036854775807L) {
            String valueOf2 = String.valueOf(str);
            k.c("SsaDecoder", valueOf2.length() != 0 ? "Skipping invalid timing: ".concat(valueOf2) : new String("Skipping invalid timing: "));
            return;
        }
        long a3 = a(split[bVar.f28330b]);
        if (a3 == -9223372036854775807L) {
            String valueOf3 = String.valueOf(str);
            k.c("SsaDecoder", valueOf3.length() != 0 ? "Skipping invalid timing: ".concat(valueOf3) : new String("Skipping invalid timing: "));
            return;
        }
        c cVar = (this.f28326d == null || bVar.f28331c == -1) ? null : this.f28326d.get(split[bVar.f28331c].trim());
        String str2 = split[bVar.f28332d];
        b a4 = a(c.b.b(str2).replaceAll("\\\\N", "\n").replaceAll("\\\\n", "\n"), cVar, c.b.a(str2), this.f28327e, this.f28328f);
        int a5 = a(a3, list2, list);
        for (int a6 = a(a2, list2, list); a6 < a5; a6++) {
            list.get(a6).add(a4);
        }
    }

    private static Layout.Alignment b(int i2) {
        switch (i2) {
            case -1:
                return null;
            case 1:
            case 4:
            case 7:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
            case 5:
            case 8:
                return Layout.Alignment.ALIGN_CENTER;
            case 3:
            case 6:
            case 9:
                return Layout.Alignment.ALIGN_OPPOSITE;
            default:
                StringBuilder sb = new StringBuilder(30);
                sb.append("Unknown alignment: ");
                sb.append(i2);
                k.c("SsaDecoder", sb.toString());
                return null;
        }
    }

    private void b(q qVar) {
        while (true) {
            String B = qVar.B();
            if (B == null) {
                return;
            }
            if (qVar.b() == 0 || qVar.f() != 91) {
                String[] split = B.split(":");
                if (split.length == 2) {
                    String d2 = ad.d(split[0].trim());
                    d2.hashCode();
                    if (d2.equals("playresx")) {
                        this.f28327e = Float.parseFloat(split[1].trim());
                    } else if (d2.equals("playresy")) {
                        try {
                            this.f28328f = Float.parseFloat(split[1].trim());
                        } catch (NumberFormatException unused) {
                        }
                    }
                }
            } else {
                return;
            }
        }
    }

    private static int c(int i2) {
        switch (i2) {
            case -1:
                return Integer.MIN_VALUE;
            case 1:
            case 2:
            case 3:
                return 2;
            case 4:
            case 5:
            case 6:
                return 1;
            case 7:
            case 8:
            case 9:
                return 0;
            default:
                StringBuilder sb = new StringBuilder(30);
                sb.append("Unknown alignment: ");
                sb.append(i2);
                k.c("SsaDecoder", sb.toString());
                return Integer.MIN_VALUE;
        }
    }

    private static Map<String, c> c(q qVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        c.a aVar = null;
        while (true) {
            String B = qVar.B();
            if (B == null || (qVar.b() != 0 && qVar.f() == 91)) {
                return linkedHashMap;
            }
            if (B.startsWith("Format:")) {
                aVar = c.a.a(B);
            } else if (B.startsWith("Style:")) {
                if (aVar == null) {
                    String valueOf = String.valueOf(B);
                    k.c("SsaDecoder", valueOf.length() != 0 ? "Skipping 'Style:' line before 'Format:' line: ".concat(valueOf) : new String("Skipping 'Style:' line before 'Format:' line: "));
                } else {
                    c a2 = c.a(B, aVar);
                    if (a2 != null) {
                        linkedHashMap.put(a2.f28334a, a2);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private static int d(int i2) {
        switch (i2) {
            case -1:
                return Integer.MIN_VALUE;
            case 1:
            case 4:
            case 7:
                return 0;
            case 2:
            case 5:
            case 8:
                return 1;
            case 3:
            case 6:
            case 9:
                return 2;
            default:
                StringBuilder sb = new StringBuilder(30);
                sb.append("Unknown alignment: ");
                sb.append(i2);
                k.c("SsaDecoder", sb.toString());
                return Integer.MIN_VALUE;
        }
    }

    private static float e(int i2) {
        if (i2 == 0) {
            return 0.05f;
        }
        if (i2 != 1) {
            return i2 != 2 ? -3.4028235E38f : 0.95f;
        }
        return 0.5f;
    }

    /* access modifiers changed from: protected */
    public e a(byte[] bArr, int i2, boolean z2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        q qVar = new q(bArr, i2);
        if (!this.f28324b) {
            a(qVar);
        }
        a(qVar, (List<List<b>>) arrayList, (List<Long>) arrayList2);
        return new d(arrayList, arrayList2);
    }
}
