package ik;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f13584a = {'&'};

    /* renamed from: b  reason: collision with root package name */
    private static final BitSet f13585b = new BitSet(256);

    /* renamed from: c  reason: collision with root package name */
    private static final BitSet f13586c = new BitSet(256);

    /* renamed from: d  reason: collision with root package name */
    private static final BitSet f13587d = new BitSet(256);

    /* renamed from: e  reason: collision with root package name */
    private static final BitSet f13588e = new BitSet(256);

    /* renamed from: f  reason: collision with root package name */
    private static final BitSet f13589f = new BitSet(256);

    /* renamed from: g  reason: collision with root package name */
    private static final BitSet f13590g = new BitSet(256);

    /* renamed from: h  reason: collision with root package name */
    private static final BitSet f13591h = new BitSet(256);

    static {
        for (int i2 = 97; i2 <= 122; i2++) {
            f13585b.set(i2);
        }
        for (int i3 = 65; i3 <= 90; i3++) {
            f13585b.set(i3);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            f13585b.set(i4);
        }
        BitSet bitSet = f13585b;
        bitSet.set(95);
        bitSet.set(45);
        bitSet.set(46);
        bitSet.set(42);
        f13591h.or(bitSet);
        bitSet.set(33);
        bitSet.set(126);
        bitSet.set(39);
        bitSet.set(40);
        bitSet.set(41);
        BitSet bitSet2 = f13586c;
        bitSet2.set(44);
        bitSet2.set(59);
        bitSet2.set(58);
        bitSet2.set(36);
        bitSet2.set(38);
        bitSet2.set(43);
        bitSet2.set(61);
        BitSet bitSet3 = f13587d;
        bitSet3.or(bitSet);
        bitSet3.or(bitSet2);
        BitSet bitSet4 = f13588e;
        bitSet4.or(bitSet);
        bitSet4.set(47);
        bitSet4.set(59);
        bitSet4.set(58);
        bitSet4.set(64);
        bitSet4.set(38);
        bitSet4.set(61);
        bitSet4.set(43);
        bitSet4.set(36);
        bitSet4.set(44);
        BitSet bitSet5 = f13590g;
        bitSet5.set(59);
        bitSet5.set(47);
        bitSet5.set(63);
        bitSet5.set(58);
        bitSet5.set(64);
        bitSet5.set(38);
        bitSet5.set(61);
        bitSet5.set(43);
        bitSet5.set(36);
        bitSet5.set(44);
        bitSet5.set(91);
        bitSet5.set(93);
        BitSet bitSet6 = f13589f;
        bitSet6.or(bitSet5);
        bitSet6.or(bitSet);
    }

    public static String a(Iterable<? extends NameValuePair> iterable, Charset charset) {
        StringBuilder sb = new StringBuilder();
        for (NameValuePair next : iterable) {
            String d2 = d(next.getName(), charset);
            String d3 = d(next.getValue(), charset);
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(d2);
            if (d3 != null) {
                sb.append("=");
                sb.append(d3);
            }
        }
        return sb.toString();
    }

    private static String a(String str, String str2) {
        if (str == null) {
            return null;
        }
        if (str2 == null) {
            str2 = "UTF-8";
        }
        return a(str, Charset.forName(str2), f13591h, true);
    }

    static String a(String str, Charset charset) {
        return a(str, charset, f13587d, false);
    }

    private static String a(String str, Charset charset, BitSet bitSet, boolean z2) {
        char upperCase;
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        ByteBuffer encode = charset.encode(str);
        while (encode.hasRemaining()) {
            byte b2 = encode.get() & 255;
            if (bitSet.get(b2)) {
                upperCase = (char) b2;
            } else if (!z2 || b2 != 32) {
                sb.append("%");
                char upperCase2 = Character.toUpperCase(Character.forDigit((b2 >> 4) & 15, 16));
                upperCase = Character.toUpperCase(Character.forDigit(b2 & 15, 16));
                sb.append(upperCase2);
            } else {
                upperCase = '+';
            }
            sb.append(upperCase);
        }
        return sb.toString();
    }

    public static String a(List<? extends NameValuePair> list, String str) {
        StringBuilder sb = new StringBuilder();
        for (NameValuePair next : list) {
            String a2 = a(next.getName(), str);
            String a3 = a(next.getValue(), str);
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(a2);
            if (a3 != null) {
                sb.append("=");
                sb.append(a3);
            }
        }
        return sb.toString();
    }

    public static List<NameValuePair> a(String str) {
        if (str == null) {
            return Collections.emptyList();
        }
        BasicHeaderValueParser basicHeaderValueParser = BasicHeaderValueParser.DEFAULT;
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
        charArrayBuffer.append(str);
        ParserCursor parserCursor = new ParserCursor(0, charArrayBuffer.length());
        ArrayList arrayList = new ArrayList();
        while (!parserCursor.atEnd()) {
            NameValuePair parseNameValuePair = basicHeaderValueParser.parseNameValuePair(charArrayBuffer, parserCursor, f13584a);
            if (parseNameValuePair.getName().length() > 0) {
                arrayList.add(new BasicNameValuePair(parseNameValuePair.getName(), parseNameValuePair.getValue()));
            }
        }
        return arrayList;
    }

    static String b(String str, Charset charset) {
        return a(str, charset, f13589f, false);
    }

    static String c(String str, Charset charset) {
        return a(str, charset, f13588e, false);
    }

    private static String d(String str, Charset charset) {
        if (str == null) {
            return null;
        }
        if (charset == null) {
            charset = Charset.forName("UTF-8");
        }
        return a(str, charset, f13591h, true);
    }
}
