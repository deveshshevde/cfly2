package com.google.android.exoplayer2.metadata.icy;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.c;
import com.google.android.exoplayer2.util.ad;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a implements com.google.android.exoplayer2.metadata.a {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f15884a = Pattern.compile("(.+?)='(.*?)';", 32);

    /* renamed from: b  reason: collision with root package name */
    private final CharsetDecoder f15885b = Charset.forName("UTF-8").newDecoder();

    /* renamed from: c  reason: collision with root package name */
    private final CharsetDecoder f15886c = Charset.forName("ISO-8859-1").newDecoder();

    private String a(ByteBuffer byteBuffer) {
        String str;
        CharsetDecoder charsetDecoder;
        try {
            str = this.f15885b.decode(byteBuffer).toString();
            charsetDecoder = this.f15885b;
        } catch (CharacterCodingException unused) {
            this.f15885b.reset();
            byteBuffer.rewind();
            try {
                str = this.f15886c.decode(byteBuffer).toString();
            } catch (CharacterCodingException unused2) {
                str = null;
            } catch (Throwable th) {
                this.f15886c.reset();
                byteBuffer.rewind();
                throw th;
            }
            charsetDecoder = this.f15886c;
        } catch (Throwable th2) {
            this.f15885b.reset();
            byteBuffer.rewind();
            throw th2;
        }
        charsetDecoder.reset();
        byteBuffer.rewind();
        return str;
    }

    public Metadata a(c cVar) {
        ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.b(cVar.f13099b);
        String a2 = a(byteBuffer);
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        String str = null;
        if (a2 == null) {
            return new Metadata(new IcyInfo(bArr, (String) null, (String) null));
        }
        Matcher matcher = f15884a.matcher(a2);
        String str2 = null;
        for (int i2 = 0; matcher.find(i2); i2 = matcher.end()) {
            String d2 = ad.d(matcher.group(1));
            String group = matcher.group(2);
            d2.hashCode();
            if (d2.equals("streamurl")) {
                str2 = group;
            } else if (d2.equals("streamtitle")) {
                str = group;
            }
        }
        return new Metadata(new IcyInfo(bArr, str, str2));
    }
}
