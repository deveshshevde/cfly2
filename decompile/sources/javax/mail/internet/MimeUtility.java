package javax.mail.internet;

import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;
import com.sun.mail.util.BEncoderStream;
import com.sun.mail.util.QDecoderStream;
import com.sun.mail.util.QEncoderStream;
import com.sun.mail.util.QPDecoderStream;
import com.sun.mail.util.QPEncoderStream;
import com.sun.mail.util.UUDecoderStream;
import com.sun.mail.util.UUEncoderStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import javax.activation.DataHandler;
import javax.mail.MessagingException;
import retrofit.mime.MultipartTypedOutput;

public class MimeUtility {
    public static final int ALL = -1;
    static final int ALL_ASCII = 1;
    static final int MOSTLY_ASCII = 2;
    static final int MOSTLY_NONASCII = 3;
    private static boolean decodeStrict = true;
    private static String defaultJavaCharset = null;
    private static String defaultMIMECharset = null;
    private static boolean encodeEolStrict = false;
    private static boolean foldEncodedWords = false;
    private static boolean foldText = true;
    private static Hashtable java2mime = new Hashtable(40);
    private static Hashtable mime2java = new Hashtable(10);

    /* JADX WARNING: Can't wrap try/catch for region: R(5:44|47|48|49|50) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0091 */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0021 A[SYNTHETIC, Splitter:B:13:0x0021] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003a A[Catch:{ SecurityException -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003c A[Catch:{ SecurityException -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x004d A[Catch:{ SecurityException -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004e A[Catch:{ SecurityException -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d A[SYNTHETIC, Splitter:B:36:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    static {
        /*
            java.lang.String r0 = "mail.mime.decodetext.strict"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x0051 }
            java.lang.String r1 = "false"
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ SecurityException -> 0x0051 }
            if (r0 == 0) goto L_0x0014
            r0 = 0
            goto L_0x0015
        L_0x0014:
            r0 = 1
        L_0x0015:
            decodeStrict = r0     // Catch:{ SecurityException -> 0x0051 }
            java.lang.String r0 = "mail.mime.encodeeol.strict"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x0051 }
            java.lang.String r4 = "true"
            if (r0 == 0) goto L_0x0029
            boolean r0 = r0.equalsIgnoreCase(r4)     // Catch:{ SecurityException -> 0x0051 }
            if (r0 == 0) goto L_0x0029
            r0 = 1
            goto L_0x002a
        L_0x0029:
            r0 = 0
        L_0x002a:
            encodeEolStrict = r0     // Catch:{ SecurityException -> 0x0051 }
            java.lang.String r0 = "mail.mime.foldencodedwords"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x0051 }
            if (r0 == 0) goto L_0x003c
            boolean r0 = r0.equalsIgnoreCase(r4)     // Catch:{ SecurityException -> 0x0051 }
            if (r0 == 0) goto L_0x003c
            r0 = 1
            goto L_0x003d
        L_0x003c:
            r0 = 0
        L_0x003d:
            foldEncodedWords = r0     // Catch:{ SecurityException -> 0x0051 }
            java.lang.String r0 = "mail.mime.foldtext"
            java.lang.String r0 = java.lang.System.getProperty(r0)     // Catch:{ SecurityException -> 0x0051 }
            if (r0 == 0) goto L_0x004e
            boolean r0 = r0.equalsIgnoreCase(r1)     // Catch:{ SecurityException -> 0x0051 }
            if (r0 == 0) goto L_0x004e
            goto L_0x004f
        L_0x004e:
            r2 = 1
        L_0x004f:
            foldText = r2     // Catch:{ SecurityException -> 0x0051 }
        L_0x0051:
            java.util.Hashtable r0 = new java.util.Hashtable
            r1 = 40
            r0.<init>(r1)
            java2mime = r0
            java.util.Hashtable r0 = new java.util.Hashtable
            r1 = 10
            r0.<init>(r1)
            mime2java = r0
            java.lang.Class<javax.mail.internet.MimeUtility> r0 = javax.mail.internet.MimeUtility.class
            java.lang.String r1 = "/META-INF/javamail.charset.map"
            java.io.InputStream r0 = r0.getResourceAsStream(r1)     // Catch:{ Exception -> 0x0086 }
            if (r0 == 0) goto L_0x0092
            com.sun.mail.util.LineInputStream r1 = new com.sun.mail.util.LineInputStream     // Catch:{ all -> 0x008a }
            r1.<init>(r0)     // Catch:{ all -> 0x008a }
            r0 = r1
            com.sun.mail.util.LineInputStream r0 = (com.sun.mail.util.LineInputStream) r0     // Catch:{ all -> 0x0088 }
            java.util.Hashtable r2 = java2mime     // Catch:{ all -> 0x0088 }
            loadMappings(r0, r2)     // Catch:{ all -> 0x0088 }
            r0 = r1
            com.sun.mail.util.LineInputStream r0 = (com.sun.mail.util.LineInputStream) r0     // Catch:{ all -> 0x0088 }
            java.util.Hashtable r2 = mime2java     // Catch:{ all -> 0x0088 }
            loadMappings(r0, r2)     // Catch:{ all -> 0x0088 }
            r1.close()     // Catch:{ Exception -> 0x0086 }
            goto L_0x0092
        L_0x0086:
            goto L_0x0092
        L_0x0088:
            r0 = move-exception
            goto L_0x008e
        L_0x008a:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
        L_0x008e:
            r1.close()     // Catch:{ Exception -> 0x0091 }
        L_0x0091:
            throw r0     // Catch:{ Exception -> 0x0086 }
        L_0x0092:
            java.util.Hashtable r0 = java2mime
            boolean r0 = r0.isEmpty()
            java.lang.String r1 = "euc-kr"
            java.lang.String r2 = "ISO-8859-1"
            if (r0 == 0) goto L_0x01af
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "8859_1"
            r0.put(r3, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "iso8859_1"
            r0.put(r3, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "iso8859-1"
            r0.put(r3, r2)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "8859_2"
            java.lang.String r4 = "ISO-8859-2"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "iso8859_2"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "iso8859-2"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "8859_3"
            java.lang.String r4 = "ISO-8859-3"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "iso8859_3"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "iso8859-3"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "8859_4"
            java.lang.String r4 = "ISO-8859-4"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "iso8859_4"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "iso8859-4"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "8859_5"
            java.lang.String r4 = "ISO-8859-5"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "iso8859_5"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "iso8859-5"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "8859_6"
            java.lang.String r4 = "ISO-8859-6"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "iso8859_6"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "iso8859-6"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "8859_7"
            java.lang.String r4 = "ISO-8859-7"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "iso8859_7"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "iso8859-7"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "8859_8"
            java.lang.String r4 = "ISO-8859-8"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "iso8859_8"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "iso8859-8"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "8859_9"
            java.lang.String r4 = "ISO-8859-9"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "iso8859_9"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "iso8859-9"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "sjis"
            java.lang.String r4 = "Shift_JIS"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "jis"
            java.lang.String r4 = "ISO-2022-JP"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "iso2022jp"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "euc_jp"
            java.lang.String r4 = "euc-jp"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "koi8_r"
            java.lang.String r4 = "koi8-r"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "euc_cn"
            java.lang.String r4 = "euc-cn"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "euc_tw"
            java.lang.String r4 = "euc-tw"
            r0.put(r3, r4)
            java.util.Hashtable r0 = java2mime
            java.lang.String r3 = "euc_kr"
            r0.put(r3, r1)
        L_0x01af:
            java.util.Hashtable r0 = mime2java
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0207
            java.util.Hashtable r0 = mime2java
            java.lang.String r3 = "iso-2022-cn"
            java.lang.String r4 = "ISO2022CN"
            r0.put(r3, r4)
            java.util.Hashtable r0 = mime2java
            java.lang.String r3 = "iso-2022-kr"
            java.lang.String r4 = "ISO2022KR"
            r0.put(r3, r4)
            java.util.Hashtable r0 = mime2java
            java.lang.String r3 = "utf-8"
            java.lang.String r4 = "UTF8"
            r0.put(r3, r4)
            java.util.Hashtable r0 = mime2java
            java.lang.String r3 = "utf8"
            r0.put(r3, r4)
            java.util.Hashtable r0 = mime2java
            java.lang.String r3 = "ja_jp.iso2022-7"
            java.lang.String r4 = "ISO2022JP"
            r0.put(r3, r4)
            java.util.Hashtable r0 = mime2java
            java.lang.String r3 = "ja_jp.eucjp"
            java.lang.String r4 = "EUCJIS"
            r0.put(r3, r4)
            java.util.Hashtable r0 = mime2java
            java.lang.String r3 = "KSC5601"
            r0.put(r1, r3)
            java.util.Hashtable r0 = mime2java
            java.lang.String r1 = "euckr"
            r0.put(r1, r3)
            java.util.Hashtable r0 = mime2java
            java.lang.String r1 = "us-ascii"
            r0.put(r1, r2)
            java.util.Hashtable r0 = mime2java
            java.lang.String r1 = "x-us-ascii"
            r0.put(r1, r2)
        L_0x0207:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeUtility.<clinit>():void");
    }

    private MimeUtility() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0065  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int checkAscii(java.io.InputStream r16, int r17, boolean r18) {
        /*
            r0 = r17
            boolean r1 = encodeEolStrict
            r3 = 0
            if (r1 == 0) goto L_0x000b
            if (r18 == 0) goto L_0x000b
            r1 = 1
            goto L_0x000c
        L_0x000b:
            r1 = 0
        L_0x000c:
            r4 = 0
            byte[] r4 = (byte[]) r4
            r5 = -1
            r6 = 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x001e
            if (r0 != r5) goto L_0x0017
            goto L_0x001c
        L_0x0017:
            int r4 = java.lang.Math.min(r0, r6)
            r6 = r4
        L_0x001c:
            byte[] r4 = new byte[r6]
        L_0x001e:
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x0023:
            if (r0 != 0) goto L_0x0026
            goto L_0x006d
        L_0x0026:
            r13 = r16
            int r14 = r13.read(r4, r3, r6)     // Catch:{ IOException -> 0x006c }
            if (r14 != r5) goto L_0x002f
            goto L_0x006d
        L_0x002f:
            r15 = 0
        L_0x0030:
            if (r15 < r14) goto L_0x0037
            if (r0 == r5) goto L_0x0035
            int r0 = r0 - r14
        L_0x0035:
            r3 = 0
            goto L_0x0023
        L_0x0037:
            byte r5 = r4[r15]     // Catch:{ IOException -> 0x006c }
            r5 = r5 & 255(0xff, float:3.57E-43)
            r2 = 10
            r12 = 13
            if (r1 == 0) goto L_0x004a
            if (r3 != r12) goto L_0x0045
            if (r5 != r2) goto L_0x0049
        L_0x0045:
            if (r3 == r12) goto L_0x004a
            if (r5 != r2) goto L_0x004a
        L_0x0049:
            r9 = 1
        L_0x004a:
            if (r5 == r12) goto L_0x0057
            if (r5 != r2) goto L_0x004f
            goto L_0x0057
        L_0x004f:
            int r11 = r11 + 1
            r2 = 998(0x3e6, float:1.398E-42)
            if (r11 <= r2) goto L_0x0058
            r10 = 1
            goto L_0x0058
        L_0x0057:
            r11 = 0
        L_0x0058:
            boolean r2 = nonascii(r5)     // Catch:{ IOException -> 0x006c }
            if (r2 == 0) goto L_0x0065
            if (r18 == 0) goto L_0x0062
            r2 = 3
            return r2
        L_0x0062:
            int r8 = r8 + 1
            goto L_0x0067
        L_0x0065:
            int r7 = r7 + 1
        L_0x0067:
            int r15 = r15 + 1
            r3 = r5
            r5 = -1
            goto L_0x0030
        L_0x006c:
        L_0x006d:
            if (r0 != 0) goto L_0x0073
            if (r18 == 0) goto L_0x0073
            r0 = 3
            return r0
        L_0x0073:
            r0 = 3
            r1 = 2
            if (r8 != 0) goto L_0x007f
            if (r9 == 0) goto L_0x007a
            return r0
        L_0x007a:
            if (r10 == 0) goto L_0x007d
            return r1
        L_0x007d:
            r0 = 1
            return r0
        L_0x007f:
            if (r7 <= r8) goto L_0x0082
            return r1
        L_0x0082:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeUtility.checkAscii(java.io.InputStream, int, boolean):int");
    }

    static int checkAscii(String str) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            if (nonascii(str.charAt(i4))) {
                i2++;
            } else {
                i3++;
            }
        }
        if (i2 == 0) {
            return 1;
        }
        return i3 > i2 ? 2 : 3;
    }

    static int checkAscii(byte[] bArr) {
        int i2 = 0;
        int i3 = 0;
        for (byte b2 : bArr) {
            if (nonascii(b2 & 255)) {
                i2++;
            } else {
                i3++;
            }
        }
        if (i2 == 0) {
            return 1;
        }
        return i3 > i2 ? 2 : 3;
    }

    public static InputStream decode(InputStream inputStream, String str) throws MessagingException {
        if (str.equalsIgnoreCase("base64")) {
            return new BASE64DecoderStream(inputStream);
        }
        if (str.equalsIgnoreCase("quoted-printable")) {
            return new QPDecoderStream(inputStream);
        }
        if (str.equalsIgnoreCase("uuencode") || str.equalsIgnoreCase("x-uuencode") || str.equalsIgnoreCase("x-uue")) {
            return new UUDecoderStream(inputStream);
        }
        if (str.equalsIgnoreCase(MultipartTypedOutput.DEFAULT_TRANSFER_ENCODING) || str.equalsIgnoreCase("7bit") || str.equalsIgnoreCase("8bit")) {
            return inputStream;
        }
        throw new MessagingException("Unknown encoding: " + str);
    }

    private static String decodeInnerWords(String str) throws UnsupportedEncodingException {
        int indexOf;
        int indexOf2;
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        while (true) {
            int indexOf3 = str.indexOf("=?", i2);
            if (indexOf3 >= 0) {
                stringBuffer.append(str.substring(i2, indexOf3));
                int indexOf4 = str.indexOf(63, indexOf3 + 2);
                if (indexOf4 < 0 || (indexOf = str.indexOf(63, indexOf4 + 1)) < 0 || (indexOf2 = str.indexOf("?=", indexOf + 1)) < 0) {
                    break;
                }
                i2 = indexOf2 + 2;
                String substring = str.substring(indexOf3, i2);
                try {
                    substring = decodeWord(substring);
                } catch (ParseException unused) {
                }
                stringBuffer.append(substring);
            } else {
                break;
            }
        }
        if (i2 == 0) {
            return str;
        }
        if (i2 < str.length()) {
            stringBuffer.append(str.substring(i2));
        }
        return stringBuffer.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x007f, code lost:
        if (r2.length() > 0) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0086, code lost:
        if (r2.length() > 0) goto L_0x0088;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String decodeText(java.lang.String r9) throws java.io.UnsupportedEncodingException {
        /*
            java.lang.String r0 = "=?"
            int r1 = r9.indexOf(r0)
            r2 = -1
            if (r1 != r2) goto L_0x000a
            return r9
        L_0x000a:
            java.util.StringTokenizer r1 = new java.util.StringTokenizer
            java.lang.String r2 = " \t\n\r"
            r3 = 1
            r1.<init>(r9, r2, r3)
            java.lang.StringBuffer r9 = new java.lang.StringBuffer
            r9.<init>()
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
            r4 = 0
            r5 = 0
        L_0x001e:
            boolean r6 = r1.hasMoreTokens()
            if (r6 != 0) goto L_0x002c
            r9.append(r2)
            java.lang.String r9 = r9.toString()
            return r9
        L_0x002c:
            java.lang.String r6 = r1.nextToken()
            char r7 = r6.charAt(r4)
            r8 = 32
            if (r7 == r8) goto L_0x0093
            r8 = 9
            if (r7 == r8) goto L_0x0093
            r8 = 13
            if (r7 == r8) goto L_0x0093
            r8 = 10
            if (r7 != r8) goto L_0x0045
            goto L_0x0093
        L_0x0045:
            java.lang.String r7 = decodeWord(r6)     // Catch:{ ParseException -> 0x0057 }
            if (r5 != 0) goto L_0x0054
            int r8 = r2.length()     // Catch:{ ParseException -> 0x0057 }
            if (r8 <= 0) goto L_0x0054
            r9.append(r2)     // Catch:{ ParseException -> 0x0057 }
        L_0x0054:
            r6 = r7
            r5 = 1
            goto L_0x008c
        L_0x0057:
            boolean r7 = decodeStrict
            if (r7 != 0) goto L_0x0082
            java.lang.String r7 = decodeInnerWords(r6)
            if (r7 == r6) goto L_0x007b
            if (r5 == 0) goto L_0x006a
            boolean r5 = r6.startsWith(r0)
            if (r5 != 0) goto L_0x0073
        L_0x006a:
            int r5 = r2.length()
            if (r5 <= 0) goto L_0x0073
            r9.append(r2)
        L_0x0073:
            java.lang.String r5 = "?="
            boolean r5 = r6.endsWith(r5)
            r6 = r7
            goto L_0x008c
        L_0x007b:
            int r5 = r2.length()
            if (r5 <= 0) goto L_0x008b
            goto L_0x0088
        L_0x0082:
            int r5 = r2.length()
            if (r5 <= 0) goto L_0x008b
        L_0x0088:
            r9.append(r2)
        L_0x008b:
            r5 = 0
        L_0x008c:
            r9.append(r6)
            r2.setLength(r4)
            goto L_0x001e
        L_0x0093:
            r2.append(r7)
            goto L_0x001e
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeUtility.decodeText(java.lang.String):java.lang.String");
    }

    public static String decodeWord(String str) throws ParseException, UnsupportedEncodingException {
        InputStream inputStream;
        if (str.startsWith("=?")) {
            int indexOf = str.indexOf(63, 2);
            if (indexOf != -1) {
                String javaCharset = javaCharset(str.substring(2, indexOf));
                int i2 = indexOf + 1;
                int indexOf2 = str.indexOf(63, i2);
                if (indexOf2 != -1) {
                    String substring = str.substring(i2, indexOf2);
                    int i3 = indexOf2 + 1;
                    int indexOf3 = str.indexOf("?=", i3);
                    if (indexOf3 != -1) {
                        String substring2 = str.substring(i3, indexOf3);
                        try {
                            String str2 = "";
                            if (substring2.length() > 0) {
                                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(ASCIIUtility.getBytes(substring2));
                                if (substring.equalsIgnoreCase("B")) {
                                    inputStream = new BASE64DecoderStream(byteArrayInputStream);
                                } else if (substring.equalsIgnoreCase("Q")) {
                                    inputStream = new QDecoderStream(byteArrayInputStream);
                                } else {
                                    throw new UnsupportedEncodingException("unknown encoding: " + substring);
                                }
                                int available = byteArrayInputStream.available();
                                byte[] bArr = new byte[available];
                                int read = inputStream.read(bArr, 0, available);
                                if (read > 0) {
                                    str2 = new String(bArr, 0, read, javaCharset);
                                }
                            }
                            int i4 = indexOf3 + 2;
                            if (i4 >= str.length()) {
                                return str2;
                            }
                            String substring3 = str.substring(i4);
                            if (!decodeStrict) {
                                substring3 = decodeInnerWords(substring3);
                            }
                            return str2 + substring3;
                        } catch (UnsupportedEncodingException e2) {
                            throw e2;
                        } catch (IOException e3) {
                            throw new ParseException(e3.toString());
                        } catch (IllegalArgumentException unused) {
                            throw new UnsupportedEncodingException(javaCharset);
                        }
                    } else {
                        throw new ParseException("encoded word does not end with \"?=\": " + str);
                    }
                } else {
                    throw new ParseException("encoded word does not include encoding: " + str);
                }
            } else {
                throw new ParseException("encoded word does not include charset: " + str);
            }
        } else {
            throw new ParseException("encoded word does not start with \"=?\": " + str);
        }
    }

    private static void doEncode(String str, boolean z2, String str2, int i2, String str3, boolean z3, boolean z4, StringBuffer stringBuffer) throws UnsupportedEncodingException {
        int length;
        String str4 = str;
        boolean z5 = z4;
        StringBuffer stringBuffer2 = stringBuffer;
        byte[] bytes = str.getBytes(str2);
        if ((z2 ? BEncoderStream.encodedLength(bytes) : QEncoderStream.encodedLength(bytes, z5)) <= i2 || (length = str.length()) <= 1) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStream bEncoderStream = z2 ? new BEncoderStream(byteArrayOutputStream) : new QEncoderStream(byteArrayOutputStream, z5);
            try {
                bEncoderStream.write(bytes);
                bEncoderStream.close();
            } catch (IOException unused) {
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (!z3) {
                stringBuffer2.append(foldEncodedWords ? "\r\n " : " ");
            }
            stringBuffer2.append(str3);
            for (byte b2 : byteArray) {
                stringBuffer2.append((char) b2);
            }
            stringBuffer2.append("?=");
            return;
        }
        int i3 = length / 2;
        doEncode(str.substring(0, i3), z2, str2, i2, str3, z3, z4, stringBuffer);
        doEncode(str.substring(i3, length), z2, str2, i2, str3, false, z4, stringBuffer);
    }

    public static OutputStream encode(OutputStream outputStream, String str) throws MessagingException {
        if (str == null) {
            return outputStream;
        }
        if (str.equalsIgnoreCase("base64")) {
            return new BASE64EncoderStream(outputStream);
        }
        if (str.equalsIgnoreCase("quoted-printable")) {
            return new QPEncoderStream(outputStream);
        }
        if (str.equalsIgnoreCase("uuencode") || str.equalsIgnoreCase("x-uuencode") || str.equalsIgnoreCase("x-uue")) {
            return new UUEncoderStream(outputStream);
        }
        if (str.equalsIgnoreCase(MultipartTypedOutput.DEFAULT_TRANSFER_ENCODING) || str.equalsIgnoreCase("7bit") || str.equalsIgnoreCase("8bit")) {
            return outputStream;
        }
        throw new MessagingException("Unknown encoding: " + str);
    }

    public static OutputStream encode(OutputStream outputStream, String str, String str2) throws MessagingException {
        if (str == null) {
            return outputStream;
        }
        if (str.equalsIgnoreCase("base64")) {
            return new BASE64EncoderStream(outputStream);
        }
        if (str.equalsIgnoreCase("quoted-printable")) {
            return new QPEncoderStream(outputStream);
        }
        if (str.equalsIgnoreCase("uuencode") || str.equalsIgnoreCase("x-uuencode") || str.equalsIgnoreCase("x-uue")) {
            return new UUEncoderStream(outputStream, str2);
        }
        if (str.equalsIgnoreCase(MultipartTypedOutput.DEFAULT_TRANSFER_ENCODING) || str.equalsIgnoreCase("7bit") || str.equalsIgnoreCase("8bit")) {
            return outputStream;
        }
        throw new MessagingException("Unknown encoding: " + str);
    }

    public static String encodeText(String str) throws UnsupportedEncodingException {
        return encodeText(str, (String) null, (String) null);
    }

    public static String encodeText(String str, String str2, String str3) throws UnsupportedEncodingException {
        return encodeWord(str, str2, str3, false);
    }

    public static String encodeWord(String str) throws UnsupportedEncodingException {
        return encodeWord(str, (String) null, (String) null);
    }

    public static String encodeWord(String str, String str2, String str3) throws UnsupportedEncodingException {
        return encodeWord(str, str2, str3, true);
    }

    private static String encodeWord(String str, String str2, String str3, boolean z2) throws UnsupportedEncodingException {
        String str4;
        boolean z3;
        int checkAscii = checkAscii(str);
        if (checkAscii == 1) {
            return str;
        }
        if (str2 == null) {
            str4 = getDefaultJavaCharset();
            str2 = getDefaultMIMECharset();
        } else {
            str4 = javaCharset(str2);
        }
        if (str3 == null) {
            str3 = checkAscii != 3 ? "Q" : "B";
        }
        if (str3.equalsIgnoreCase("B")) {
            z3 = true;
        } else if (str3.equalsIgnoreCase("Q")) {
            z3 = false;
        } else {
            throw new UnsupportedEncodingException("Unknown transfer encoding: " + str3);
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = 68 - str2.length();
        doEncode(str, z3, str4, length, "=?" + str2 + "?" + str3 + "?", true, z2, stringBuffer);
        return stringBuffer.toString();
    }

    public static String fold(int i2, String str) {
        if (!foldText) {
            return str;
        }
        int length = str.length() - 1;
        while (length >= 0 && ((r4 = str.charAt(length)) == ' ' || r4 == 9 || r4 == 13 || r4 == 10)) {
            length--;
        }
        if (length != str.length() - 1) {
            str = str.substring(0, length + 1);
        }
        if (str.length() + i2 <= 76) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer(str.length() + 4);
        int i3 = i2;
        String str2 = str;
        char c2 = 0;
        while (true) {
            if (str2.length() + i3 <= 76) {
                break;
            }
            int i4 = 0;
            int i5 = -1;
            while (i4 < str2.length() && (i5 == -1 || i3 + i4 <= 76)) {
                char charAt = str2.charAt(i4);
                if (!((charAt != ' ' && charAt != 9) || c2 == ' ' || c2 == 9)) {
                    i5 = i4;
                }
                i4++;
                c2 = charAt;
            }
            if (i5 == -1) {
                stringBuffer.append(str2);
                str2 = "";
                break;
            }
            stringBuffer.append(str2.substring(0, i5));
            stringBuffer.append("\r\n");
            c2 = str2.charAt(i5);
            stringBuffer.append(c2);
            str2 = str2.substring(i5 + 1);
            i3 = 1;
        }
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public static String getDefaultJavaCharset() {
        if (defaultJavaCharset == null) {
            String str = null;
            try {
                str = System.getProperty("mail.mime.charset");
            } catch (SecurityException unused) {
            }
            if (str == null || str.length() <= 0) {
                try {
                    defaultJavaCharset = System.getProperty("file.encoding", "8859_1");
                } catch (SecurityException unused2) {
                    String encoding = new InputStreamReader(new InputStream() {
                        public int read() {
                            return 0;
                        }
                    }).getEncoding();
                    defaultJavaCharset = encoding;
                    if (encoding == null) {
                        defaultJavaCharset = "8859_1";
                    }
                }
            } else {
                String javaCharset = javaCharset(str);
                defaultJavaCharset = javaCharset;
                return javaCharset;
            }
        }
        return defaultJavaCharset;
    }

    static String getDefaultMIMECharset() {
        if (defaultMIMECharset == null) {
            try {
                defaultMIMECharset = System.getProperty("mail.mime.charset");
            } catch (SecurityException unused) {
            }
        }
        if (defaultMIMECharset == null) {
            defaultMIMECharset = mimeCharset(getDefaultJavaCharset());
        }
        return defaultMIMECharset;
    }

    public static String getEncoding(DataHandler dataHandler) {
        if (dataHandler.getName() != null) {
            return getEncoding(dataHandler.getDataSource());
        }
        try {
            if (new ContentType(dataHandler.getContentType()).match("text/*")) {
                AsciiOutputStream asciiOutputStream = new AsciiOutputStream(false, false);
                try {
                    dataHandler.writeTo(asciiOutputStream);
                } catch (IOException unused) {
                }
                int ascii = asciiOutputStream.getAscii();
                if (ascii != 1) {
                    return ascii != 2 ? "base64" : "quoted-printable";
                }
            } else {
                AsciiOutputStream asciiOutputStream2 = new AsciiOutputStream(true, encodeEolStrict);
                try {
                    dataHandler.writeTo(asciiOutputStream2);
                } catch (IOException unused2) {
                }
                if (asciiOutputStream2.getAscii() != 1) {
                    return "base64";
                }
            }
            return "7bit";
        } catch (Exception unused3) {
            return "base64";
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getEncoding(javax.activation.DataSource r4) {
        /*
            java.lang.String r0 = "base64"
            javax.mail.internet.ContentType r1 = new javax.mail.internet.ContentType     // Catch:{ Exception -> 0x002a }
            java.lang.String r2 = r4.getContentType()     // Catch:{ Exception -> 0x002a }
            r1.<init>(r2)     // Catch:{ Exception -> 0x002a }
            java.io.InputStream r4 = r4.getInputStream()     // Catch:{ Exception -> 0x002a }
            java.lang.String r2 = "text/*"
            boolean r1 = r1.match((java.lang.String) r2)
            r2 = -1
            r3 = 1
            r1 = r1 ^ r3
            int r1 = checkAscii(r4, r2, r1)
            if (r1 == r3) goto L_0x0025
            r2 = 2
            if (r1 == r2) goto L_0x0022
            goto L_0x0027
        L_0x0022:
            java.lang.String r0 = "quoted-printable"
            goto L_0x0027
        L_0x0025:
            java.lang.String r0 = "7bit"
        L_0x0027:
            r4.close()     // Catch:{  }
        L_0x002a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeUtility.getEncoding(javax.activation.DataSource):java.lang.String");
    }

    private static int indexOfAny(String str, String str2) {
        return indexOfAny(str, str2, 0);
    }

    private static int indexOfAny(String str, String str2, int i2) {
        try {
            int length = str.length();
            while (i2 < length) {
                if (str2.indexOf(str.charAt(i2)) >= 0) {
                    return i2;
                }
                i2++;
            }
            return -1;
        } catch (StringIndexOutOfBoundsException unused) {
            return -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r0 = (java.lang.String) r0.get(r2.toLowerCase(java.util.Locale.ENGLISH));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String javaCharset(java.lang.String r2) {
        /*
            java.util.Hashtable r0 = mime2java
            if (r0 == 0) goto L_0x0017
            if (r2 != 0) goto L_0x0007
            goto L_0x0017
        L_0x0007:
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.String r1 = r2.toLowerCase(r1)
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r2 = r0
        L_0x0017:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeUtility.javaCharset(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:15:0x0000, LOOP_START, MTH_ENTER_BLOCK, SYNTHETIC, Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void loadMappings(com.sun.mail.util.LineInputStream r3, java.util.Hashtable r4) {
        /*
        L_0x0000:
            java.lang.String r0 = r3.readLine()     // Catch:{ IOException -> 0x0042 }
            if (r0 != 0) goto L_0x0007
            goto L_0x0042
        L_0x0007:
            java.lang.String r1 = "--"
            boolean r2 = r0.startsWith(r1)
            if (r2 == 0) goto L_0x0016
            boolean r1 = r0.endsWith(r1)
            if (r1 == 0) goto L_0x0016
            goto L_0x0042
        L_0x0016:
            java.lang.String r1 = r0.trim()
            int r1 = r1.length()
            if (r1 == 0) goto L_0x0000
            java.lang.String r1 = "#"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L_0x0029
            goto L_0x0000
        L_0x0029:
            java.util.StringTokenizer r1 = new java.util.StringTokenizer
            java.lang.String r2 = " \t"
            r1.<init>(r0, r2)
            java.lang.String r0 = r1.nextToken()     // Catch:{ NoSuchElementException -> 0x0000 }
            java.lang.String r1 = r1.nextToken()     // Catch:{ NoSuchElementException -> 0x0000 }
            java.util.Locale r2 = java.util.Locale.ENGLISH     // Catch:{ NoSuchElementException -> 0x0000 }
            java.lang.String r0 = r0.toLowerCase(r2)     // Catch:{ NoSuchElementException -> 0x0000 }
            r4.put(r0, r1)     // Catch:{ NoSuchElementException -> 0x0000 }
            goto L_0x0000
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeUtility.loadMappings(com.sun.mail.util.LineInputStream, java.util.Hashtable):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r0 = (java.lang.String) r0.get(r2.toLowerCase(java.util.Locale.ENGLISH));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String mimeCharset(java.lang.String r2) {
        /*
            java.util.Hashtable r0 = java2mime
            if (r0 == 0) goto L_0x0017
            if (r2 != 0) goto L_0x0007
            goto L_0x0017
        L_0x0007:
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.String r1 = r2.toLowerCase(r1)
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r2 = r0
        L_0x0017:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeUtility.mimeCharset(java.lang.String):java.lang.String");
    }

    static final boolean nonascii(int i2) {
        if (i2 < 127) {
            return (i2 >= 32 || i2 == 13 || i2 == 10 || i2 == 9) ? false : true;
        }
        return true;
    }

    public static String quote(String str, String str2) {
        StringBuffer stringBuffer;
        int length = str.length();
        char c2 = 0;
        int i2 = 0;
        boolean z2 = false;
        while (true) {
            if (i2 < length) {
                char charAt = str.charAt(i2);
                if (charAt == '\"' || charAt == '\\' || charAt == 13 || charAt == 10) {
                    stringBuffer = new StringBuffer(length + 3);
                    stringBuffer.append('\"');
                    stringBuffer.append(str.substring(0, i2));
                } else {
                    if (charAt < ' ' || charAt >= 127 || str2.indexOf(charAt) >= 0) {
                        z2 = true;
                    }
                    i2++;
                }
            } else if (!z2) {
                return str;
            } else {
                stringBuffer = new StringBuffer(length + 2);
                stringBuffer.append('\"');
                stringBuffer.append(str);
            }
        }
        stringBuffer = new StringBuffer(length + 3);
        stringBuffer.append('\"');
        stringBuffer.append(str.substring(0, i2));
        while (i2 < length) {
            char charAt2 = str.charAt(i2);
            if ((charAt2 == '\"' || charAt2 == '\\' || charAt2 == 13 || charAt2 == 10) && !(charAt2 == 10 && c2 == 13)) {
                stringBuffer.append('\\');
            }
            stringBuffer.append(charAt2);
            i2++;
            c2 = charAt2;
        }
        stringBuffer.append('\"');
        return stringBuffer.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String unfold(java.lang.String r8) {
        /*
            boolean r0 = foldText
            if (r0 != 0) goto L_0x0005
            return r8
        L_0x0005:
            r0 = 0
        L_0x0006:
            java.lang.String r1 = "\r\n"
            int r1 = indexOfAny(r8, r1)
            if (r1 >= 0) goto L_0x0018
            if (r0 == 0) goto L_0x0017
            r0.append(r8)
            java.lang.String r8 = r0.toString()
        L_0x0017:
            return r8
        L_0x0018:
            int r2 = r8.length()
            int r3 = r1 + 1
            if (r3 >= r2) goto L_0x0034
            int r4 = r3 + -1
            char r4 = r8.charAt(r4)
            r5 = 13
            if (r4 != r5) goto L_0x0034
            char r4 = r8.charAt(r3)
            r5 = 10
            if (r4 != r5) goto L_0x0034
            int r3 = r3 + 1
        L_0x0034:
            r4 = 0
            if (r1 == 0) goto L_0x0059
            int r5 = r1 + -1
            char r6 = r8.charAt(r5)
            r7 = 92
            if (r6 == r7) goto L_0x0042
            goto L_0x0059
        L_0x0042:
            if (r0 != 0) goto L_0x004d
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            int r2 = r8.length()
            r0.<init>(r2)
        L_0x004d:
            java.lang.String r2 = r8.substring(r4, r5)
            r0.append(r2)
            java.lang.String r1 = r8.substring(r1, r3)
            goto L_0x009a
        L_0x0059:
            if (r3 >= r2) goto L_0x008b
            char r5 = r8.charAt(r3)
            r6 = 9
            r7 = 32
            if (r5 == r7) goto L_0x0067
            if (r5 != r6) goto L_0x008b
        L_0x0067:
            int r3 = r3 + 1
            if (r3 >= r2) goto L_0x0073
            char r5 = r8.charAt(r3)
            if (r5 == r7) goto L_0x0067
            if (r5 == r6) goto L_0x0067
        L_0x0073:
            if (r0 != 0) goto L_0x007e
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            int r2 = r8.length()
            r0.<init>(r2)
        L_0x007e:
            if (r1 == 0) goto L_0x009d
            java.lang.String r1 = r8.substring(r4, r1)
            r0.append(r1)
            r0.append(r7)
            goto L_0x009d
        L_0x008b:
            if (r0 != 0) goto L_0x0096
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            int r1 = r8.length()
            r0.<init>(r1)
        L_0x0096:
            java.lang.String r1 = r8.substring(r4, r3)
        L_0x009a:
            r0.append(r1)
        L_0x009d:
            java.lang.String r8 = r8.substring(r3)
            goto L_0x0006
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.MimeUtility.unfold(java.lang.String):java.lang.String");
    }
}
