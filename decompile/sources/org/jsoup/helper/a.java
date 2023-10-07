package org.jsoup.helper;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import oh.c;
import org.jsoup.UncheckedIOException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.d;
import org.jsoup.nodes.j;
import org.jsoup.nodes.n;
import org.jsoup.parser.e;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Pattern f33571a = Pattern.compile("(?i)\\bcharset=\\s*(?:[\"'])?([^\\s,;\"']*)");

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f33572b = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /* renamed from: org.jsoup.helper.a$a  reason: collision with other inner class name */
    private static class C0243a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final String f33573a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final boolean f33574b;

        public C0243a(String str, boolean z2) {
            this.f33573a = str;
            this.f33574b = z2;
        }
    }

    static String a(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = f33571a.matcher(str);
        if (matcher.find()) {
            return b(matcher.group(1).trim().replace("charset=", ""));
        }
        return null;
    }

    static ByteBuffer a() {
        return ByteBuffer.allocate(0);
    }

    public static ByteBuffer a(InputStream inputStream, int i2) throws IOException {
        c.a(i2 >= 0, "maxSize must be 0 (unlimited) or larger");
        return oh.a.a(inputStream, 32768, i2).a(i2);
    }

    private static C0243a a(ByteBuffer byteBuffer) {
        byteBuffer.mark();
        byte[] bArr = new byte[4];
        if (byteBuffer.remaining() >= 4) {
            byteBuffer.get(bArr);
            byteBuffer.rewind();
        }
        if ((bArr[0] == 0 && bArr[1] == 0 && bArr[2] == -2 && bArr[3] == -1) || (bArr[0] == -1 && bArr[1] == -2 && bArr[2] == 0 && bArr[3] == 0)) {
            return new C0243a("UTF-32", false);
        }
        if ((bArr[0] == -2 && bArr[1] == -1) || (bArr[0] == -1 && bArr[1] == -2)) {
            return new C0243a("UTF-16", false);
        }
        if (bArr[0] == -17 && bArr[1] == -69 && bArr[2] == -65) {
            return new C0243a("UTF-8", true);
        }
        return null;
    }

    static Document a(InputStream inputStream, String str, String str2, e eVar) throws IOException {
        n nVar;
        InputStream inputStream2 = inputStream;
        String str3 = str2;
        e eVar2 = eVar;
        if (inputStream2 == null) {
            return new Document(str3);
        }
        boolean z2 = false;
        oh.a a2 = oh.a.a(inputStream2, 32768, 0);
        a2.mark(32768);
        ByteBuffer a3 = a((InputStream) a2, 5119);
        boolean z3 = a2.read() == -1;
        a2.reset();
        C0243a a4 = a(a3);
        String a5 = a4 != null ? a4.f33573a : str;
        Document document = null;
        if (a5 == null) {
            try {
                CharBuffer decode = Charset.forName("UTF-8").decode(a3);
                Document a6 = decode.hasArray() ? eVar2.a((Reader) new CharArrayReader(decode.array()), str3) : eVar2.a(decode.toString(), str3);
                Iterator it2 = a6.e("meta[http-equiv=content-type], meta[charset]").iterator();
                String str4 = null;
                while (it2.hasNext()) {
                    Element element = (Element) it2.next();
                    if (element.b("http-equiv")) {
                        str4 = a(element.c("content"));
                    }
                    if (str4 == null && element.b("charset")) {
                        str4 = element.c("charset");
                        continue;
                    }
                    if (str4 != null) {
                        break;
                    }
                }
                if (str4 == null && a6.h() > 0) {
                    j b2 = a6.b(0);
                    if (b2 instanceof n) {
                        nVar = (n) b2;
                    } else {
                        if (b2 instanceof d) {
                            d dVar = (d) b2;
                            if (dVar.e()) {
                                nVar = dVar.f();
                            }
                        }
                        nVar = null;
                    }
                    if (nVar != null && nVar.b().equalsIgnoreCase("xml")) {
                        str4 = nVar.c("encoding");
                    }
                }
                String b3 = b(str4);
                if (b3 != null && !b3.equalsIgnoreCase("UTF-8")) {
                    a5 = b3.trim().replaceAll("[\"']", "");
                } else if (z3) {
                    document = a6;
                }
            } catch (UncheckedIOException e2) {
                throw e2.a();
            }
        } else {
            c.a(a5, "Must set charset arg to character set of file to parse. Set to null to attempt to detect from HTML");
        }
        if (document == null) {
            if (a5 == null) {
                a5 = "UTF-8";
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(a2, a5), 32768);
            if (a4 != null && a4.f33574b) {
                if (bufferedReader.skip(1) == 1) {
                    z2 = true;
                }
                c.a(z2);
            }
            try {
                document = eVar2.a((Reader) bufferedReader, str3);
                Charset forName = Charset.forName(a5);
                document.j().a(forName);
                if (!forName.canEncode()) {
                    document.a(Charset.forName("UTF-8"));
                }
            } catch (UncheckedIOException e3) {
                throw e3.a();
            }
        }
        a2.close();
        return document;
    }

    static void a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[32768];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    static String b() {
        StringBuilder a2 = c.a();
        Random random = new Random();
        for (int i2 = 0; i2 < 32; i2++) {
            char[] cArr = f33572b;
            a2.append(cArr[random.nextInt(cArr.length)]);
        }
        return c.a(a2);
    }

    private static String b(String str) {
        if (!(str == null || str.length() == 0)) {
            String replaceAll = str.trim().replaceAll("[\"']", "");
            try {
                if (Charset.isSupported(replaceAll)) {
                    return replaceAll;
                }
                String upperCase = replaceAll.toUpperCase(Locale.ENGLISH);
                if (Charset.isSupported(upperCase)) {
                    return upperCase;
                }
            } catch (IllegalCharsetNameException unused) {
            }
        }
        return null;
    }
}
