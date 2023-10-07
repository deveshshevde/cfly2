package gb;

import com.autonavi.base.amap.mapcore.AeUtil;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.e;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.ae;
import com.google.android.exoplayer2.util.k;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class a extends com.google.android.exoplayer2.text.c {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f28363a = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f28364b = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f28365c = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f28366d = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f28367e = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f28368f = Pattern.compile("^(\\d+) (\\d+)$");

    /* renamed from: g  reason: collision with root package name */
    private static final b f28369g = new b(30.0f, 1, 1);

    /* renamed from: h  reason: collision with root package name */
    private static final C0183a f28370h = new C0183a(32, 15);

    /* renamed from: i  reason: collision with root package name */
    private final XmlPullParserFactory f28371i;

    /* renamed from: gb.a$a  reason: collision with other inner class name */
    private static final class C0183a {

        /* renamed from: a  reason: collision with root package name */
        final int f28372a;

        /* renamed from: b  reason: collision with root package name */
        final int f28373b;

        C0183a(int i2, int i3) {
            this.f28372a = i2;
            this.f28373b = i3;
        }
    }

    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        final float f28374a;

        /* renamed from: b  reason: collision with root package name */
        final int f28375b;

        /* renamed from: c  reason: collision with root package name */
        final int f28376c;

        b(float f2, int i2, int i3) {
            this.f28374a = f2;
            this.f28375b = i2;
            this.f28376c = i3;
        }
    }

    private static final class c {

        /* renamed from: a  reason: collision with root package name */
        final int f28377a;

        /* renamed from: b  reason: collision with root package name */
        final int f28378b;

        c(int i2, int i3) {
            this.f28377a = i2;
            this.f28378b = i3;
        }
    }

    public a() {
        super("TtmlDecoder");
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            this.f28371i = newInstance;
            newInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b3, code lost:
        if (r13.equals("ms") == false) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ea, code lost:
        r8 = r8 / r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f8, code lost:
        r8 = r8 * r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00fe, code lost:
        java.lang.Double.isNaN(r13);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long a(java.lang.String r13, gb.a.b r14) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        /*
            java.util.regex.Pattern r0 = f28363a
            java.util.regex.Matcher r0 = r0.matcher(r13)
            boolean r1 = r0.matches()
            r2 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r1 == 0) goto L_0x0088
            java.lang.String r13 = r0.group(r7)
            long r7 = java.lang.Long.parseLong(r13)
            r9 = 3600(0xe10, double:1.7786E-320)
            long r7 = r7 * r9
            double r7 = (double) r7
            java.lang.String r13 = r0.group(r6)
            long r9 = java.lang.Long.parseLong(r13)
            r11 = 60
            long r9 = r9 * r11
            double r9 = (double) r9
            java.lang.Double.isNaN(r7)
            java.lang.Double.isNaN(r9)
            double r7 = r7 + r9
            java.lang.String r13 = r0.group(r5)
            long r5 = java.lang.Long.parseLong(r13)
            double r5 = (double) r5
            java.lang.Double.isNaN(r5)
            double r7 = r7 + r5
            java.lang.String r13 = r0.group(r4)
            r4 = 0
            if (r13 == 0) goto L_0x0050
            double r9 = java.lang.Double.parseDouble(r13)
            goto L_0x0051
        L_0x0050:
            r9 = r4
        L_0x0051:
            double r7 = r7 + r9
            r13 = 5
            java.lang.String r13 = r0.group(r13)
            if (r13 == 0) goto L_0x0063
            long r9 = java.lang.Long.parseLong(r13)
            float r13 = (float) r9
            float r1 = r14.f28374a
            float r13 = r13 / r1
            double r9 = (double) r13
            goto L_0x0064
        L_0x0063:
            r9 = r4
        L_0x0064:
            double r7 = r7 + r9
            r13 = 6
            java.lang.String r13 = r0.group(r13)
            if (r13 == 0) goto L_0x0083
            long r0 = java.lang.Long.parseLong(r13)
            double r0 = (double) r0
            int r13 = r14.f28375b
            double r4 = (double) r13
            java.lang.Double.isNaN(r0)
            java.lang.Double.isNaN(r4)
            double r0 = r0 / r4
            float r13 = r14.f28374a
            double r13 = (double) r13
            java.lang.Double.isNaN(r13)
            double r4 = r0 / r13
        L_0x0083:
            double r7 = r7 + r4
            double r7 = r7 * r2
            long r13 = (long) r7
            return r13
        L_0x0088:
            java.util.regex.Pattern r0 = f28364b
            java.util.regex.Matcher r0 = r0.matcher(r13)
            boolean r1 = r0.matches()
            if (r1 == 0) goto L_0x0106
            java.lang.String r13 = r0.group(r7)
            double r8 = java.lang.Double.parseDouble(r13)
            java.lang.String r13 = r0.group(r6)
            r13.hashCode()
            r0 = -1
            int r1 = r13.hashCode()
            switch(r1) {
                case 102: goto L_0x00d7;
                case 104: goto L_0x00cc;
                case 109: goto L_0x00c1;
                case 116: goto L_0x00b6;
                case 3494: goto L_0x00ad;
                default: goto L_0x00ab;
            }
        L_0x00ab:
            r4 = -1
            goto L_0x00e1
        L_0x00ad:
            java.lang.String r1 = "ms"
            boolean r13 = r13.equals(r1)
            if (r13 != 0) goto L_0x00e1
            goto L_0x00ab
        L_0x00b6:
            java.lang.String r1 = "t"
            boolean r13 = r13.equals(r1)
            if (r13 != 0) goto L_0x00bf
            goto L_0x00ab
        L_0x00bf:
            r4 = 3
            goto L_0x00e1
        L_0x00c1:
            java.lang.String r1 = "m"
            boolean r13 = r13.equals(r1)
            if (r13 != 0) goto L_0x00ca
            goto L_0x00ab
        L_0x00ca:
            r4 = 2
            goto L_0x00e1
        L_0x00cc:
            java.lang.String r1 = "h"
            boolean r13 = r13.equals(r1)
            if (r13 != 0) goto L_0x00d5
            goto L_0x00ab
        L_0x00d5:
            r4 = 1
            goto L_0x00e1
        L_0x00d7:
            java.lang.String r1 = "f"
            boolean r13 = r13.equals(r1)
            if (r13 != 0) goto L_0x00e0
            goto L_0x00ab
        L_0x00e0:
            r4 = 0
        L_0x00e1:
            switch(r4) {
                case 0: goto L_0x00fb;
                case 1: goto L_0x00f3;
                case 2: goto L_0x00f0;
                case 3: goto L_0x00ec;
                case 4: goto L_0x00e5;
                default: goto L_0x00e4;
            }
        L_0x00e4:
            goto L_0x0102
        L_0x00e5:
            r13 = 4652007308841189376(0x408f400000000000, double:1000.0)
        L_0x00ea:
            double r8 = r8 / r13
            goto L_0x0102
        L_0x00ec:
            int r13 = r14.f28376c
            double r13 = (double) r13
            goto L_0x00fe
        L_0x00f0:
            r13 = 4633641066610819072(0x404e000000000000, double:60.0)
            goto L_0x00f8
        L_0x00f3:
            r13 = 4660134898793709568(0x40ac200000000000, double:3600.0)
        L_0x00f8:
            double r8 = r8 * r13
            goto L_0x0102
        L_0x00fb:
            float r13 = r14.f28374a
            double r13 = (double) r13
        L_0x00fe:
            java.lang.Double.isNaN(r13)
            goto L_0x00ea
        L_0x0102:
            double r8 = r8 * r2
            long r13 = (long) r8
            return r13
        L_0x0106:
            com.google.android.exoplayer2.text.SubtitleDecoderException r14 = new com.google.android.exoplayer2.text.SubtitleDecoderException
            java.lang.String r0 = "Malformed time expression: "
            java.lang.String r13 = java.lang.String.valueOf(r13)
            int r1 = r13.length()
            if (r1 == 0) goto L_0x0119
            java.lang.String r13 = r0.concat(r13)
            goto L_0x011e
        L_0x0119:
            java.lang.String r13 = new java.lang.String
            r13.<init>(r0)
        L_0x011e:
            r14.<init>((java.lang.String) r13)
            goto L_0x0123
        L_0x0122:
            throw r14
        L_0x0123:
            goto L_0x0122
        */
        throw new UnsupportedOperationException("Method not decompiled: gb.a.a(java.lang.String, gb.a$b):long");
    }

    private C0183a a(XmlPullParser xmlPullParser, C0183a aVar) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return aVar;
        }
        Matcher matcher = f28368f.matcher(attributeValue);
        if (!matcher.matches()) {
            String valueOf = String.valueOf(attributeValue);
            k.c("TtmlDecoder", valueOf.length() != 0 ? "Ignoring malformed cell resolution: ".concat(valueOf) : new String("Ignoring malformed cell resolution: "));
            return aVar;
        }
        try {
            int parseInt = Integer.parseInt(matcher.group(1));
            int parseInt2 = Integer.parseInt(matcher.group(2));
            if (parseInt != 0 && parseInt2 != 0) {
                return new C0183a(parseInt, parseInt2);
            }
            StringBuilder sb = new StringBuilder(47);
            sb.append("Invalid cell resolution ");
            sb.append(parseInt);
            sb.append(" ");
            sb.append(parseInt2);
            throw new SubtitleDecoderException(sb.toString());
        } catch (NumberFormatException unused) {
            String valueOf2 = String.valueOf(attributeValue);
            k.c("TtmlDecoder", valueOf2.length() != 0 ? "Ignoring malformed cell resolution: ".concat(valueOf2) : new String("Ignoring malformed cell resolution: "));
            return aVar;
        }
    }

    private b a(XmlPullParser xmlPullParser) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        float f2 = 1.0f;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] a2 = ad.a(attributeValue2, " ");
            if (a2.length == 2) {
                f2 = ((float) Integer.parseInt(a2[0])) / ((float) Integer.parseInt(a2[1]));
            } else {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
        }
        b bVar = f28369g;
        int i2 = bVar.f28375b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i2 = Integer.parseInt(attributeValue3);
        }
        int i3 = bVar.f28376c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i3 = Integer.parseInt(attributeValue4);
        }
        return new b(((float) parseInt) * f2, i2, i3);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private gb.b a(org.xmlpull.v1.XmlPullParser r21, gb.b r22, java.util.Map<java.lang.String, gb.c> r23, gb.a.b r24) throws com.google.android.exoplayer2.text.SubtitleDecoderException {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r24
            int r4 = r21.getAttributeCount()
            r5 = 0
            gb.e r11 = r0.a((org.xmlpull.v1.XmlPullParser) r1, (gb.e) r5)
            java.lang.String r9 = ""
            r12 = r5
            r14 = r12
            r13 = r9
            r5 = 0
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r15 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r17 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0026:
            if (r5 >= r4) goto L_0x00b7
            java.lang.String r6 = r1.getAttributeName(r5)
            java.lang.String r7 = r1.getAttributeValue(r5)
            r6.hashCode()
            int r19 = r6.hashCode()
            switch(r19) {
                case -934795532: goto L_0x0073;
                case 99841: goto L_0x0068;
                case 100571: goto L_0x005d;
                case 93616297: goto L_0x0052;
                case 109780401: goto L_0x0047;
                case 1292595405: goto L_0x003c;
                default: goto L_0x003a;
            }
        L_0x003a:
            r8 = -1
            goto L_0x007d
        L_0x003c:
            java.lang.String r8 = "backgroundImage"
            boolean r6 = r6.equals(r8)
            if (r6 != 0) goto L_0x0045
            goto L_0x003a
        L_0x0045:
            r8 = 5
            goto L_0x007d
        L_0x0047:
            java.lang.String r8 = "style"
            boolean r6 = r6.equals(r8)
            if (r6 != 0) goto L_0x0050
            goto L_0x003a
        L_0x0050:
            r8 = 4
            goto L_0x007d
        L_0x0052:
            java.lang.String r8 = "begin"
            boolean r6 = r6.equals(r8)
            if (r6 != 0) goto L_0x005b
            goto L_0x003a
        L_0x005b:
            r8 = 3
            goto L_0x007d
        L_0x005d:
            java.lang.String r8 = "end"
            boolean r6 = r6.equals(r8)
            if (r6 != 0) goto L_0x0066
            goto L_0x003a
        L_0x0066:
            r8 = 2
            goto L_0x007d
        L_0x0068:
            java.lang.String r8 = "dur"
            boolean r6 = r6.equals(r8)
            if (r6 != 0) goto L_0x0071
            goto L_0x003a
        L_0x0071:
            r8 = 1
            goto L_0x007d
        L_0x0073:
            java.lang.String r8 = "region"
            boolean r6 = r6.equals(r8)
            if (r6 != 0) goto L_0x007c
            goto L_0x003a
        L_0x007c:
            r8 = 0
        L_0x007d:
            switch(r8) {
                case 0: goto L_0x00aa;
                case 1: goto L_0x00a5;
                case 2: goto L_0x00a0;
                case 3: goto L_0x0099;
                case 4: goto L_0x0090;
                case 5: goto L_0x0081;
                default: goto L_0x0080;
            }
        L_0x0080:
            goto L_0x009d
        L_0x0081:
            java.lang.String r6 = "#"
            boolean r6 = r7.startsWith(r6)
            if (r6 == 0) goto L_0x009d
            r6 = 1
            java.lang.String r6 = r7.substring(r6)
            r14 = r6
            goto L_0x009d
        L_0x0090:
            java.lang.String[] r6 = r0.a((java.lang.String) r7)
            int r7 = r6.length
            if (r7 <= 0) goto L_0x009d
            r12 = r6
            goto L_0x009d
        L_0x0099:
            long r9 = a((java.lang.String) r7, (gb.a.b) r3)
        L_0x009d:
            r6 = r23
            goto L_0x00b3
        L_0x00a0:
            long r15 = a((java.lang.String) r7, (gb.a.b) r3)
            goto L_0x009d
        L_0x00a5:
            long r17 = a((java.lang.String) r7, (gb.a.b) r3)
            goto L_0x009d
        L_0x00aa:
            r6 = r23
            boolean r8 = r6.containsKey(r7)
            if (r8 == 0) goto L_0x00b3
            r13 = r7
        L_0x00b3:
            int r5 = r5 + 1
            goto L_0x0026
        L_0x00b7:
            if (r2 == 0) goto L_0x00d3
            long r3 = r2.f28382d
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x00d8
            int r3 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x00cb
            long r3 = r2.f28382d
            long r9 = r9 + r3
        L_0x00cb:
            int r3 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x00d8
            long r3 = r2.f28382d
            long r15 = r15 + r3
            goto L_0x00d8
        L_0x00d3:
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x00d8:
            r7 = r9
            int r3 = (r15 > r5 ? 1 : (r15 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x00f2
            int r3 = (r17 > r5 ? 1 : (r17 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x00e6
            long r17 = r7 + r17
            r9 = r17
            goto L_0x00f3
        L_0x00e6:
            if (r2 == 0) goto L_0x00f2
            long r3 = r2.f28383e
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 == 0) goto L_0x00f2
            long r2 = r2.f28383e
            r9 = r2
            goto L_0x00f3
        L_0x00f2:
            r9 = r15
        L_0x00f3:
            java.lang.String r6 = r21.getName()
            gb.b r1 = gb.b.a(r6, r7, r9, r11, r12, r13, r14)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: gb.a.a(org.xmlpull.v1.XmlPullParser, gb.b, java.util.Map, gb.a$b):gb.b");
    }

    private c a(XmlPullParser xmlPullParser, C0183a aVar, c cVar) {
        String str;
        float f2;
        float f3;
        float f4;
        float f5;
        int i2;
        float f6;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        c cVar2 = cVar;
        String c2 = ae.c(xmlPullParser2, "id");
        if (c2 == null) {
            return null;
        }
        String c3 = ae.c(xmlPullParser2, "origin");
        if (c3 != null) {
            Pattern pattern = f28366d;
            Matcher matcher = pattern.matcher(c3);
            Pattern pattern2 = f28367e;
            Matcher matcher2 = pattern2.matcher(c3);
            if (matcher.matches()) {
                try {
                    float parseFloat = Float.parseFloat(matcher.group(1)) / 100.0f;
                    f2 = Float.parseFloat(matcher.group(2)) / 100.0f;
                    f3 = parseFloat;
                } catch (NumberFormatException unused) {
                    String valueOf = String.valueOf(c3);
                    k.c("TtmlDecoder", valueOf.length() != 0 ? "Ignoring region with malformed origin: ".concat(valueOf) : new String("Ignoring region with malformed origin: "));
                    return null;
                }
            } else if (!matcher2.matches()) {
                String valueOf2 = String.valueOf(c3);
                k.c("TtmlDecoder", valueOf2.length() != 0 ? "Ignoring region with unsupported origin: ".concat(valueOf2) : new String("Ignoring region with unsupported origin: "));
                return null;
            } else if (cVar2 == null) {
                String valueOf3 = String.valueOf(c3);
                k.c("TtmlDecoder", valueOf3.length() != 0 ? "Ignoring region with missing tts:extent: ".concat(valueOf3) : new String("Ignoring region with missing tts:extent: "));
                return null;
            } else {
                try {
                    int parseInt = Integer.parseInt(matcher2.group(1));
                    int parseInt2 = Integer.parseInt(matcher2.group(2));
                    f3 = ((float) parseInt) / ((float) cVar2.f28377a);
                    f2 = ((float) parseInt2) / ((float) cVar2.f28378b);
                } catch (NumberFormatException unused2) {
                    String valueOf4 = String.valueOf(c3);
                    k.c("TtmlDecoder", valueOf4.length() != 0 ? "Ignoring region with malformed origin: ".concat(valueOf4) : new String("Ignoring region with malformed origin: "));
                    return null;
                }
            }
            String c4 = ae.c(xmlPullParser2, "extent");
            if (c4 != null) {
                Matcher matcher3 = pattern.matcher(c4);
                Matcher matcher4 = pattern2.matcher(c4);
                if (matcher3.matches()) {
                    try {
                        f5 = Float.parseFloat(matcher3.group(1)) / 100.0f;
                        f4 = Float.parseFloat(matcher3.group(2)) / 100.0f;
                    } catch (NumberFormatException unused3) {
                        String valueOf5 = String.valueOf(c3);
                        k.c("TtmlDecoder", valueOf5.length() != 0 ? "Ignoring region with malformed extent: ".concat(valueOf5) : new String("Ignoring region with malformed extent: "));
                        return null;
                    }
                } else if (!matcher4.matches()) {
                    String valueOf6 = String.valueOf(c3);
                    k.c("TtmlDecoder", valueOf6.length() != 0 ? "Ignoring region with unsupported extent: ".concat(valueOf6) : new String("Ignoring region with unsupported extent: "));
                    return null;
                } else if (cVar2 == null) {
                    String valueOf7 = String.valueOf(c3);
                    k.c("TtmlDecoder", valueOf7.length() != 0 ? "Ignoring region with missing tts:extent: ".concat(valueOf7) : new String("Ignoring region with missing tts:extent: "));
                    return null;
                } else {
                    try {
                        int parseInt3 = Integer.parseInt(matcher4.group(1));
                        int parseInt4 = Integer.parseInt(matcher4.group(2));
                        float f7 = ((float) parseInt3) / ((float) cVar2.f28377a);
                        float f8 = ((float) parseInt4) / ((float) cVar2.f28378b);
                        f5 = f7;
                        f4 = f8;
                    } catch (NumberFormatException unused4) {
                        String valueOf8 = String.valueOf(c3);
                        k.c("TtmlDecoder", valueOf8.length() != 0 ? "Ignoring region with malformed extent: ".concat(valueOf8) : new String("Ignoring region with malformed extent: "));
                        return null;
                    }
                }
                String c5 = ae.c(xmlPullParser2, "displayAlign");
                if (c5 != null) {
                    String d2 = ad.d(c5);
                    d2.hashCode();
                    if (d2.equals("center")) {
                        f6 = f2 + (f4 / 2.0f);
                        i2 = 1;
                    } else if (d2.equals("after")) {
                        f6 = f2 + f4;
                        i2 = 2;
                    }
                    return new c(c2, f3, f6, 0, i2, f5, f4, 1, 1.0f / ((float) aVar.f28373b));
                }
                f6 = f2;
                i2 = 0;
                return new c(c2, f3, f6, 0, i2, f5, f4, 1, 1.0f / ((float) aVar.f28373b));
            }
            str = "Ignoring region without an extent";
        } else {
            str = "Ignoring region without an origin";
        }
        k.c("TtmlDecoder", str);
        return null;
    }

    private e a(e eVar) {
        return eVar == null ? new e() : eVar;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0130, code lost:
        if (r3.equals("linethrough") == false) goto L_0x0128;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0196, code lost:
        if (r3.equals("start") == false) goto L_0x018e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private gb.e a(org.xmlpull.v1.XmlPullParser r12, gb.e r13) {
        /*
            r11 = this;
            int r0 = r12.getAttributeCount()
            r1 = 0
            r2 = 0
        L_0x0006:
            if (r2 >= r0) goto L_0x01fc
            java.lang.String r3 = r12.getAttributeValue(r2)
            java.lang.String r4 = r12.getAttributeName(r2)
            r4.hashCode()
            int r5 = r4.hashCode()
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = -1
            r10 = 1
            switch(r5) {
                case -1550943582: goto L_0x007c;
                case -1224696685: goto L_0x0071;
                case -1065511464: goto L_0x0066;
                case -879295043: goto L_0x005b;
                case -734428249: goto L_0x0050;
                case 3355: goto L_0x0045;
                case 94842723: goto L_0x003a;
                case 365601008: goto L_0x002f;
                case 1287124693: goto L_0x0022;
                default: goto L_0x001f;
            }
        L_0x001f:
            r4 = -1
            goto L_0x0086
        L_0x0022:
            java.lang.String r5 = "backgroundColor"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x002b
            goto L_0x001f
        L_0x002b:
            r4 = 8
            goto L_0x0086
        L_0x002f:
            java.lang.String r5 = "fontSize"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0038
            goto L_0x001f
        L_0x0038:
            r4 = 7
            goto L_0x0086
        L_0x003a:
            java.lang.String r5 = "color"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0043
            goto L_0x001f
        L_0x0043:
            r4 = 6
            goto L_0x0086
        L_0x0045:
            java.lang.String r5 = "id"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x004e
            goto L_0x001f
        L_0x004e:
            r4 = 5
            goto L_0x0086
        L_0x0050:
            java.lang.String r5 = "fontWeight"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0059
            goto L_0x001f
        L_0x0059:
            r4 = 4
            goto L_0x0086
        L_0x005b:
            java.lang.String r5 = "textDecoration"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0064
            goto L_0x001f
        L_0x0064:
            r4 = 3
            goto L_0x0086
        L_0x0066:
            java.lang.String r5 = "textAlign"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x006f
            goto L_0x001f
        L_0x006f:
            r4 = 2
            goto L_0x0086
        L_0x0071:
            java.lang.String r5 = "fontFamily"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x007a
            goto L_0x001f
        L_0x007a:
            r4 = 1
            goto L_0x0086
        L_0x007c:
            java.lang.String r5 = "fontStyle"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x0085
            goto L_0x001f
        L_0x0085:
            r4 = 0
        L_0x0086:
            java.lang.String r5 = "TtmlDecoder"
            switch(r4) {
                case 0: goto L_0x01ea;
                case 1: goto L_0x01e1;
                case 2: goto L_0x0180;
                case 3: goto L_0x011a;
                case 4: goto L_0x010a;
                case 5: goto L_0x00f4;
                case 6: goto L_0x00d3;
                case 7: goto L_0x00ae;
                case 8: goto L_0x008d;
                default: goto L_0x008b;
            }
        L_0x008b:
            goto L_0x01f8
        L_0x008d:
            gb.e r13 = r11.a((gb.e) r13)
            int r4 = com.google.android.exoplayer2.util.d.a(r3)     // Catch:{ IllegalArgumentException -> 0x009a }
            r13.b((int) r4)     // Catch:{ IllegalArgumentException -> 0x009a }
            goto L_0x01f8
        L_0x009a:
            java.lang.String r4 = "Failed parsing background value: "
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r6 = r3.length()
            if (r6 == 0) goto L_0x00a8
            goto L_0x00c4
        L_0x00a8:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r4)
            goto L_0x00ce
        L_0x00ae:
            gb.e r13 = r11.a((gb.e) r13)     // Catch:{ SubtitleDecoderException -> 0x00b7 }
            a((java.lang.String) r3, (gb.e) r13)     // Catch:{ SubtitleDecoderException -> 0x00b7 }
            goto L_0x01f8
        L_0x00b7:
            java.lang.String r4 = "Failed parsing fontSize value: "
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r6 = r3.length()
            if (r6 == 0) goto L_0x00c9
        L_0x00c4:
            java.lang.String r3 = r4.concat(r3)
            goto L_0x00ce
        L_0x00c9:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r4)
        L_0x00ce:
            com.google.android.exoplayer2.util.k.c(r5, r3)
            goto L_0x01f8
        L_0x00d3:
            gb.e r13 = r11.a((gb.e) r13)
            int r4 = com.google.android.exoplayer2.util.d.a(r3)     // Catch:{ IllegalArgumentException -> 0x00e0 }
            r13.a((int) r4)     // Catch:{ IllegalArgumentException -> 0x00e0 }
            goto L_0x01f8
        L_0x00e0:
            java.lang.String r4 = "Failed parsing color value: "
            java.lang.String r3 = java.lang.String.valueOf(r3)
            int r6 = r3.length()
            if (r6 == 0) goto L_0x00ee
            goto L_0x00c4
        L_0x00ee:
            java.lang.String r3 = new java.lang.String
            r3.<init>(r4)
            goto L_0x00ce
        L_0x00f4:
            java.lang.String r4 = r12.getName()
            java.lang.String r5 = "style"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x01f8
            gb.e r13 = r11.a((gb.e) r13)
            gb.e r13 = r13.b((java.lang.String) r3)
            goto L_0x01f8
        L_0x010a:
            gb.e r13 = r11.a((gb.e) r13)
            java.lang.String r4 = "bold"
            boolean r3 = r4.equalsIgnoreCase(r3)
            gb.e r13 = r13.c((boolean) r3)
            goto L_0x01f8
        L_0x011a:
            java.lang.String r3 = com.google.android.exoplayer2.util.ad.d((java.lang.String) r3)
            r3.hashCode()
            int r4 = r3.hashCode()
            switch(r4) {
                case -1461280213: goto L_0x0149;
                case -1026963764: goto L_0x013e;
                case 913457136: goto L_0x0133;
                case 1679736913: goto L_0x012a;
                default: goto L_0x0128;
            }
        L_0x0128:
            r7 = -1
            goto L_0x0153
        L_0x012a:
            java.lang.String r4 = "linethrough"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0153
            goto L_0x0128
        L_0x0133:
            java.lang.String r4 = "nolinethrough"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x013c
            goto L_0x0128
        L_0x013c:
            r7 = 2
            goto L_0x0153
        L_0x013e:
            java.lang.String r4 = "underline"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0147
            goto L_0x0128
        L_0x0147:
            r7 = 1
            goto L_0x0153
        L_0x0149:
            java.lang.String r4 = "nounderline"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0152
            goto L_0x0128
        L_0x0152:
            r7 = 0
        L_0x0153:
            switch(r7) {
                case 0: goto L_0x0176;
                case 1: goto L_0x016c;
                case 2: goto L_0x0162;
                case 3: goto L_0x0158;
                default: goto L_0x0156;
            }
        L_0x0156:
            goto L_0x01f8
        L_0x0158:
            gb.e r13 = r11.a((gb.e) r13)
            gb.e r13 = r13.a((boolean) r10)
            goto L_0x01f8
        L_0x0162:
            gb.e r13 = r11.a((gb.e) r13)
            gb.e r13 = r13.a((boolean) r1)
            goto L_0x01f8
        L_0x016c:
            gb.e r13 = r11.a((gb.e) r13)
            gb.e r13 = r13.b((boolean) r10)
            goto L_0x01f8
        L_0x0176:
            gb.e r13 = r11.a((gb.e) r13)
            gb.e r13 = r13.b((boolean) r1)
            goto L_0x01f8
        L_0x0180:
            java.lang.String r3 = com.google.android.exoplayer2.util.ad.d((java.lang.String) r3)
            r3.hashCode()
            int r4 = r3.hashCode()
            switch(r4) {
                case -1364013995: goto L_0x01ba;
                case 100571: goto L_0x01af;
                case 3317767: goto L_0x01a4;
                case 108511772: goto L_0x0199;
                case 109757538: goto L_0x0190;
                default: goto L_0x018e;
            }
        L_0x018e:
            r6 = -1
            goto L_0x01c4
        L_0x0190:
            java.lang.String r4 = "start"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x01c4
            goto L_0x018e
        L_0x0199:
            java.lang.String r4 = "right"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x01a2
            goto L_0x018e
        L_0x01a2:
            r6 = 3
            goto L_0x01c4
        L_0x01a4:
            java.lang.String r4 = "left"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x01ad
            goto L_0x018e
        L_0x01ad:
            r6 = 2
            goto L_0x01c4
        L_0x01af:
            java.lang.String r4 = "end"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x01b8
            goto L_0x018e
        L_0x01b8:
            r6 = 1
            goto L_0x01c4
        L_0x01ba:
            java.lang.String r4 = "center"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x01c3
            goto L_0x018e
        L_0x01c3:
            r6 = 0
        L_0x01c4:
            switch(r6) {
                case 0: goto L_0x01da;
                case 1: goto L_0x01c8;
                case 2: goto L_0x01cf;
                case 3: goto L_0x01c8;
                case 4: goto L_0x01cf;
                default: goto L_0x01c7;
            }
        L_0x01c7:
            goto L_0x01f8
        L_0x01c8:
            gb.e r13 = r11.a((gb.e) r13)
            android.text.Layout$Alignment r3 = android.text.Layout.Alignment.ALIGN_OPPOSITE
            goto L_0x01d5
        L_0x01cf:
            gb.e r13 = r11.a((gb.e) r13)
            android.text.Layout$Alignment r3 = android.text.Layout.Alignment.ALIGN_NORMAL
        L_0x01d5:
            gb.e r13 = r13.a((android.text.Layout.Alignment) r3)
            goto L_0x01f8
        L_0x01da:
            gb.e r13 = r11.a((gb.e) r13)
            android.text.Layout$Alignment r3 = android.text.Layout.Alignment.ALIGN_CENTER
            goto L_0x01d5
        L_0x01e1:
            gb.e r13 = r11.a((gb.e) r13)
            gb.e r13 = r13.a((java.lang.String) r3)
            goto L_0x01f8
        L_0x01ea:
            gb.e r13 = r11.a((gb.e) r13)
            java.lang.String r4 = "italic"
            boolean r3 = r4.equalsIgnoreCase(r3)
            gb.e r13 = r13.d(r3)
        L_0x01f8:
            int r2 = r2 + 1
            goto L_0x0006
        L_0x01fc:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: gb.a.a(org.xmlpull.v1.XmlPullParser, gb.e):gb.e");
    }

    private Map<String, e> a(XmlPullParser xmlPullParser, Map<String, e> map, C0183a aVar, c cVar, Map<String, c> map2, Map<String, String> map3) throws IOException, XmlPullParserException {
        do {
            xmlPullParser.next();
            if (ae.b(xmlPullParser, "style")) {
                String c2 = ae.c(xmlPullParser, "style");
                e a2 = a(xmlPullParser, new e());
                if (c2 != null) {
                    for (String str : a(c2)) {
                        a2.a(map.get(str));
                    }
                }
                if (a2.i() != null) {
                    map.put(a2.i(), a2);
                }
            } else if (ae.b(xmlPullParser, "region")) {
                c a3 = a(xmlPullParser, aVar, cVar);
                if (a3 != null) {
                    map2.put(a3.f28391a, a3);
                }
            } else if (ae.b(xmlPullParser, "metadata")) {
                a(xmlPullParser, map3);
            }
        } while (!ae.a(xmlPullParser, "head"));
        return map;
    }

    private static void a(String str, e eVar) throws SubtitleDecoderException {
        Matcher matcher;
        String[] a2 = ad.a(str, "\\s+");
        if (a2.length == 1) {
            matcher = f28365c.matcher(str);
        } else if (a2.length == 2) {
            matcher = f28365c.matcher(a2[1]);
            k.c("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        } else {
            int length = a2.length;
            StringBuilder sb = new StringBuilder(52);
            sb.append("Invalid number of entries for fontSize: ");
            sb.append(length);
            sb.append(".");
            throw new SubtitleDecoderException(sb.toString());
        }
        if (matcher.matches()) {
            String group = matcher.group(3);
            group.hashCode();
            char c2 = 65535;
            switch (group.hashCode()) {
                case 37:
                    if (group.equals("%")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 3240:
                    if (group.equals("em")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 3592:
                    if (group.equals("px")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    eVar.c(3);
                    break;
                case 1:
                    eVar.c(2);
                    break;
                case 2:
                    eVar.c(1);
                    break;
                default:
                    StringBuilder sb2 = new StringBuilder(String.valueOf(group).length() + 30);
                    sb2.append("Invalid unit for fontSize: '");
                    sb2.append(group);
                    sb2.append("'.");
                    throw new SubtitleDecoderException(sb2.toString());
            }
            eVar.a(Float.valueOf(matcher.group(1)).floatValue());
            return;
        }
        StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 36);
        sb3.append("Invalid expression for fontSize: '");
        sb3.append(str);
        sb3.append("'.");
        throw new SubtitleDecoderException(sb3.toString());
    }

    private void a(XmlPullParser xmlPullParser, Map<String, String> map) throws IOException, XmlPullParserException {
        String c2;
        do {
            xmlPullParser.next();
            if (ae.b(xmlPullParser, "image") && (c2 = ae.c(xmlPullParser, "id")) != null) {
                map.put(c2, xmlPullParser.nextText());
            }
        } while (!ae.a(xmlPullParser, "metadata"));
    }

    private String[] a(String str) {
        String trim = str.trim();
        return trim.isEmpty() ? new String[0] : ad.a(trim, "\\s+");
    }

    private c b(XmlPullParser xmlPullParser) {
        String c2 = ae.c(xmlPullParser, "extent");
        if (c2 == null) {
            return null;
        }
        Matcher matcher = f28367e.matcher(c2);
        if (!matcher.matches()) {
            String valueOf = String.valueOf(c2);
            k.c("TtmlDecoder", valueOf.length() != 0 ? "Ignoring non-pixel tts extent: ".concat(valueOf) : new String("Ignoring non-pixel tts extent: "));
            return null;
        }
        try {
            return new c(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)));
        } catch (NumberFormatException unused) {
            String valueOf2 = String.valueOf(c2);
            k.c("TtmlDecoder", valueOf2.length() != 0 ? "Ignoring malformed tts extent: ".concat(valueOf2) : new String("Ignoring malformed tts extent: "));
            return null;
        }
    }

    private static boolean b(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("image") || str.equals(AeUtil.ROOT_DATA_PATH_OLD_NAME) || str.equals("information");
    }

    /* access modifiers changed from: protected */
    public e a(byte[] bArr, int i2, boolean z2) throws SubtitleDecoderException {
        f fVar;
        b bVar;
        try {
            XmlPullParser newPullParser = this.f28371i.newPullParser();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            HashMap hashMap3 = new HashMap();
            c cVar = null;
            hashMap2.put("", new c((String) null));
            newPullParser.setInput(new ByteArrayInputStream(bArr, 0, i2), (String) null);
            ArrayDeque arrayDeque = new ArrayDeque();
            b bVar2 = f28369g;
            C0183a aVar = f28370h;
            f fVar2 = null;
            int i3 = 0;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.getEventType()) {
                b bVar3 = (b) arrayDeque.peek();
                if (i3 == 0) {
                    String name = newPullParser.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            bVar2 = a(newPullParser);
                            aVar = a(newPullParser, f28370h);
                            cVar = b(newPullParser);
                        }
                        c cVar2 = cVar;
                        b bVar4 = bVar2;
                        C0183a aVar2 = aVar;
                        if (!b(name)) {
                            String valueOf = String.valueOf(newPullParser.getName());
                            k.b("TtmlDecoder", valueOf.length() != 0 ? "Ignoring unsupported tag: ".concat(valueOf) : new String("Ignoring unsupported tag: "));
                            i3++;
                            bVar2 = bVar4;
                            cVar = cVar2;
                            aVar = aVar2;
                            newPullParser.next();
                        } else {
                            if ("head".equals(name)) {
                                fVar = fVar2;
                                bVar = bVar4;
                                a(newPullParser, hashMap, aVar2, cVar2, hashMap2, hashMap3);
                            } else {
                                fVar = fVar2;
                                bVar = bVar4;
                                try {
                                    b a2 = a(newPullParser, bVar3, hashMap2, bVar);
                                    arrayDeque.push(a2);
                                    if (bVar3 != null) {
                                        bVar3.a(a2);
                                    }
                                } catch (SubtitleDecoderException e2) {
                                    k.a("TtmlDecoder", "Suppressing parser error", e2);
                                    i3++;
                                }
                            }
                            bVar2 = bVar;
                            cVar = cVar2;
                            aVar = aVar2;
                        }
                    } else {
                        fVar = fVar2;
                        if (eventType == 4) {
                            bVar3.a(b.a(newPullParser.getText()));
                        } else if (eventType == 3) {
                            fVar2 = newPullParser.getName().equals("tt") ? new f((b) arrayDeque.peek(), hashMap, hashMap2, hashMap3) : fVar;
                            arrayDeque.pop();
                            newPullParser.next();
                        }
                    }
                } else {
                    fVar = fVar2;
                    if (eventType == 2) {
                        i3++;
                    } else if (eventType == 3) {
                        i3--;
                    }
                }
                fVar2 = fVar;
                newPullParser.next();
            }
            return fVar2;
        } catch (XmlPullParserException e3) {
            throw new SubtitleDecoderException("Unable to decode source", e3);
        } catch (IOException e4) {
            throw new IllegalStateException("Unexpected error when reading input.", e4);
        }
    }
}
