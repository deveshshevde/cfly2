package javax.mail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.BitSet;

public class URLName {
    static final int caseDiff = 32;
    private static boolean doEncode = true;
    static BitSet dontNeedEncoding = new BitSet(256);
    private String file;
    protected String fullURL;
    private int hashCode;
    private String host;
    private InetAddress hostAddress;
    private boolean hostAddressKnown;
    private String password;
    private int port;
    private String protocol;
    private String ref;
    private String username;

    static {
        try {
            doEncode = !Boolean.getBoolean("mail.URLName.dontencode");
        } catch (Exception unused) {
        }
        for (int i2 = 97; i2 <= 122; i2++) {
            dontNeedEncoding.set(i2);
        }
        for (int i3 = 65; i3 <= 90; i3++) {
            dontNeedEncoding.set(i3);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            dontNeedEncoding.set(i4);
        }
        dontNeedEncoding.set(32);
        dontNeedEncoding.set(45);
        dontNeedEncoding.set(95);
        dontNeedEncoding.set(46);
        dontNeedEncoding.set(42);
    }

    public URLName(String str) {
        this.hostAddressKnown = false;
        this.port = -1;
        this.hashCode = 0;
        parseString(str);
    }

    public URLName(String str, String str2, int i2, String str3, String str4, String str5) {
        String str6;
        int indexOf;
        this.hostAddressKnown = false;
        this.port = -1;
        this.hashCode = 0;
        this.protocol = str;
        this.host = str2;
        this.port = i2;
        if (str3 == null || (indexOf = str3.indexOf(35)) == -1) {
            this.file = str3;
            str6 = null;
        } else {
            this.file = str3.substring(0, indexOf);
            str6 = str3.substring(indexOf + 1);
        }
        this.ref = str6;
        this.username = doEncode ? encode(str4) : str4;
        this.password = doEncode ? encode(str5) : str5;
    }

    public URLName(URL url) {
        this(url.toString());
    }

    private static String _encode(String str) {
        StringBuffer stringBuffer = new StringBuffer(str.length());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(10);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(byteArrayOutputStream);
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (dontNeedEncoding.get(charAt)) {
                if (charAt == ' ') {
                    charAt = '+';
                }
                stringBuffer.append((char) charAt);
            } else {
                try {
                    outputStreamWriter.write(charAt);
                    outputStreamWriter.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    for (int i3 = 0; i3 < byteArray.length; i3++) {
                        stringBuffer.append('%');
                        char forDigit = Character.forDigit((byteArray[i3] >> 4) & 15, 16);
                        if (Character.isLetter(forDigit)) {
                            forDigit = (char) (forDigit - ' ');
                        }
                        stringBuffer.append(forDigit);
                        char forDigit2 = Character.forDigit(byteArray[i3] & 15, 16);
                        if (Character.isLetter(forDigit2)) {
                            forDigit2 = (char) (forDigit2 - ' ');
                        }
                        stringBuffer.append(forDigit2);
                    }
                } catch (IOException unused) {
                }
                byteArrayOutputStream.reset();
            }
        }
        return stringBuffer.toString();
    }

    static String decode(String str) {
        if (str == null) {
            return null;
        }
        if (indexOfAny(str, "+%") == -1) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (charAt != '%') {
                if (charAt == '+') {
                    charAt = ' ';
                }
                stringBuffer.append(charAt);
            } else {
                try {
                    stringBuffer.append((char) Integer.parseInt(str.substring(i2 + 1, i2 + 3), 16));
                    i2 += 2;
                } catch (NumberFormatException unused) {
                    throw new IllegalArgumentException();
                }
            }
            i2++;
        }
        String stringBuffer2 = stringBuffer.toString();
        try {
            return new String(stringBuffer2.getBytes("8859_1"));
        } catch (UnsupportedEncodingException unused2) {
            return stringBuffer2;
        }
    }

    static String encode(String str) {
        if (str == null) {
            return null;
        }
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt == ' ' || !dontNeedEncoding.get(charAt)) {
                return _encode(str);
            }
        }
        return str;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:13|14|15|16|17|18|19) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0017 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.net.InetAddress getHostAddress() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.hostAddressKnown     // Catch:{ all -> 0x0020 }
            if (r0 == 0) goto L_0x0009
            java.net.InetAddress r0 = r2.hostAddress     // Catch:{ all -> 0x0020 }
            monitor-exit(r2)
            return r0
        L_0x0009:
            java.lang.String r0 = r2.host     // Catch:{ all -> 0x0020 }
            r1 = 0
            if (r0 != 0) goto L_0x0010
            monitor-exit(r2)
            return r1
        L_0x0010:
            java.net.InetAddress r0 = java.net.InetAddress.getByName(r0)     // Catch:{ UnknownHostException -> 0x0017 }
            r2.hostAddress = r0     // Catch:{ UnknownHostException -> 0x0017 }
            goto L_0x0019
        L_0x0017:
            r2.hostAddress = r1     // Catch:{ all -> 0x0020 }
        L_0x0019:
            r0 = 1
            r2.hostAddressKnown = r0     // Catch:{ all -> 0x0020 }
            java.net.InetAddress r0 = r2.hostAddress     // Catch:{ all -> 0x0020 }
            monitor-exit(r2)
            return r0
        L_0x0020:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.URLName.getHostAddress():java.net.InetAddress");
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

    public boolean equals(Object obj) {
        URLName uRLName;
        String str;
        String str2;
        if (!(obj instanceof URLName) || (str = uRLName.protocol) == null || !str.equals(this.protocol)) {
            return false;
        }
        InetAddress hostAddress2 = getHostAddress();
        InetAddress hostAddress3 = (uRLName = (URLName) obj).getHostAddress();
        if (hostAddress2 == null || hostAddress3 == null) {
            String str3 = this.host;
            if (str3 == null || (str2 = uRLName.host) == null) {
                if (str3 != uRLName.host) {
                    return false;
                }
            } else if (!str3.equalsIgnoreCase(str2)) {
                return false;
            }
        } else if (!hostAddress2.equals(hostAddress3)) {
            return false;
        }
        String str4 = this.username;
        String str5 = uRLName.username;
        if (str4 != str5 && (str4 == null || !str4.equals(str5))) {
            return false;
        }
        String str6 = this.file;
        String str7 = "";
        if (str6 == null) {
            str6 = str7;
        }
        String str8 = uRLName.file;
        if (str8 != null) {
            str7 = str8;
        }
        return str6.equals(str7) && this.port == uRLName.port;
    }

    public String getFile() {
        return this.file;
    }

    public String getHost() {
        return this.host;
    }

    public String getPassword() {
        return doEncode ? decode(this.password) : this.password;
    }

    public int getPort() {
        return this.port;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getRef() {
        return this.ref;
    }

    public URL getURL() throws MalformedURLException {
        return new URL(getProtocol(), getHost(), getPort(), getFile());
    }

    public String getUsername() {
        return doEncode ? decode(this.username) : this.username;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0042  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int hashCode() {
        /*
            r3 = this;
            int r0 = r3.hashCode
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            java.lang.String r1 = r3.protocol
            if (r1 == 0) goto L_0x0010
            int r1 = r1.hashCode()
            int r0 = r0 + r1
            r3.hashCode = r0
        L_0x0010:
            java.net.InetAddress r0 = r3.getHostAddress()
            if (r0 == 0) goto L_0x0020
            int r1 = r3.hashCode
            int r0 = r0.hashCode()
        L_0x001c:
            int r1 = r1 + r0
            r3.hashCode = r1
            goto L_0x0031
        L_0x0020:
            java.lang.String r0 = r3.host
            if (r0 == 0) goto L_0x0031
            int r1 = r3.hashCode
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r0 = r0.toLowerCase(r2)
            int r0 = r0.hashCode()
            goto L_0x001c
        L_0x0031:
            java.lang.String r0 = r3.username
            if (r0 == 0) goto L_0x003e
            int r1 = r3.hashCode
            int r0 = r0.hashCode()
            int r1 = r1 + r0
            r3.hashCode = r1
        L_0x003e:
            java.lang.String r0 = r3.file
            if (r0 == 0) goto L_0x004b
            int r1 = r3.hashCode
            int r0 = r0.hashCode()
            int r1 = r1 + r0
            r3.hashCode = r1
        L_0x004b:
            int r0 = r3.hashCode
            int r1 = r3.port
            int r0 = r0 + r1
            r3.hashCode = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.URLName.hashCode():int");
    }

    /* access modifiers changed from: protected */
    public void parseString(String str) {
        int indexOf;
        String str2;
        this.password = null;
        this.username = null;
        this.host = null;
        this.ref = null;
        this.file = null;
        this.protocol = null;
        this.port = -1;
        int length = str.length();
        int indexOf2 = str.indexOf(58);
        if (indexOf2 != -1) {
            this.protocol = str.substring(0, indexOf2);
        }
        int i2 = indexOf2 + 1;
        if (str.regionMatches(i2, "//", 0, 2)) {
            int i3 = indexOf2 + 3;
            int indexOf3 = str.indexOf(47, i3);
            if (indexOf3 != -1) {
                str2 = str.substring(i3, indexOf3);
                int i4 = indexOf3 + 1;
                this.file = i4 < length ? str.substring(i4) : "";
            } else {
                str2 = str.substring(i3);
            }
            int indexOf4 = str2.indexOf(64);
            if (indexOf4 != -1) {
                String substring = str2.substring(0, indexOf4);
                str2 = str2.substring(indexOf4 + 1);
                int indexOf5 = substring.indexOf(58);
                if (indexOf5 != -1) {
                    this.username = substring.substring(0, indexOf5);
                    this.password = substring.substring(indexOf5 + 1);
                } else {
                    this.username = substring;
                }
            }
            int indexOf6 = (str2.length() <= 0 || str2.charAt(0) != '[') ? str2.indexOf(58) : str2.indexOf(58, str2.indexOf(93));
            if (indexOf6 != -1) {
                String substring2 = str2.substring(indexOf6 + 1);
                if (substring2.length() > 0) {
                    try {
                        this.port = Integer.parseInt(substring2);
                    } catch (NumberFormatException unused) {
                        this.port = -1;
                    }
                }
                this.host = str2.substring(0, indexOf6);
            } else {
                this.host = str2;
            }
        } else if (i2 < length) {
            this.file = str.substring(i2);
        }
        String str3 = this.file;
        if (str3 != null && (indexOf = str3.indexOf(35)) != -1) {
            this.ref = this.file.substring(indexOf + 1);
            this.file = this.file.substring(0, indexOf);
        }
    }

    public String toString() {
        if (this.fullURL == null) {
            StringBuffer stringBuffer = new StringBuffer();
            String str = this.protocol;
            if (str != null) {
                stringBuffer.append(str);
                stringBuffer.append(":");
            }
            if (!(this.username == null && this.host == null)) {
                stringBuffer.append("//");
                String str2 = this.username;
                if (str2 != null) {
                    stringBuffer.append(str2);
                    if (this.password != null) {
                        stringBuffer.append(":");
                        stringBuffer.append(this.password);
                    }
                    stringBuffer.append("@");
                }
                String str3 = this.host;
                if (str3 != null) {
                    stringBuffer.append(str3);
                }
                if (this.port != -1) {
                    stringBuffer.append(":");
                    stringBuffer.append(Integer.toString(this.port));
                }
                if (this.file != null) {
                    stringBuffer.append("/");
                }
            }
            String str4 = this.file;
            if (str4 != null) {
                stringBuffer.append(str4);
            }
            if (this.ref != null) {
                stringBuffer.append("#");
                stringBuffer.append(this.ref);
            }
            this.fullURL = stringBuffer.toString();
        }
        return this.fullURL;
    }
}
