package javax.mail.internet;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Locale;
import javax.mail.Address;
import javax.mail.Session;

public class InternetAddress extends Address implements Cloneable {
    private static final String rfc822phrase = HeaderTokenizer.RFC822.replace(' ', 0).replace(9, 0);
    private static final long serialVersionUID = -7507595530758302903L;
    private static final String specialsNoDot = "()<>,;:\\\"[]@";
    private static final String specialsNoDotNoAt = "()<>,;:\\\"[]";
    protected String address;
    protected String encodedPersonal;
    protected String personal;

    public InternetAddress() {
    }

    public InternetAddress(String str) throws AddressException {
        InternetAddress[] parse = parse(str, true);
        if (parse.length == 1) {
            this.address = parse[0].address;
            this.personal = parse[0].personal;
            this.encodedPersonal = parse[0].encodedPersonal;
            return;
        }
        throw new AddressException("Illegal address", str);
    }

    public InternetAddress(String str, String str2) throws UnsupportedEncodingException {
        this(str, str2, (String) null);
    }

    public InternetAddress(String str, String str2, String str3) throws UnsupportedEncodingException {
        this.address = str;
        setPersonal(str2, str3);
    }

    public InternetAddress(String str, boolean z2) throws AddressException {
        this(str);
        if (z2) {
            checkAddress(this.address, true, true);
        }
    }

    private static void checkAddress(String str, boolean z2, boolean z3) throws AddressException {
        String str2;
        String str3;
        if (str.indexOf(34) < 0) {
            int i2 = 0;
            if (z2) {
                while (true) {
                    int indexOfAny = indexOfAny(str, ",:", i2);
                    if (indexOfAny < 0) {
                        break;
                    } else if (str.charAt(i2) != '@') {
                        throw new AddressException("Illegal route-addr", str);
                    } else if (str.charAt(indexOfAny) == ':') {
                        i2 = indexOfAny + 1;
                        break;
                    } else {
                        i2 = indexOfAny + 1;
                    }
                }
            }
            int indexOf = str.indexOf(64, i2);
            if (indexOf >= 0) {
                if (indexOf == i2) {
                    throw new AddressException("Missing local name", str);
                } else if (indexOf != str.length() - 1) {
                    str2 = str.substring(i2, indexOf);
                    str3 = str.substring(indexOf + 1);
                } else {
                    throw new AddressException("Missing domain", str);
                }
            } else if (!z3) {
                str3 = null;
                str2 = str;
            } else {
                throw new AddressException("Missing final '@domain'", str);
            }
            if (indexOfAny(str, " \t\n\r") >= 0) {
                throw new AddressException("Illegal whitespace in address", str);
            } else if (indexOfAny(str2, specialsNoDot) >= 0) {
                throw new AddressException("Illegal character in local name", str);
            } else if (str3 != null && str3.indexOf(91) < 0 && indexOfAny(str3, specialsNoDot) >= 0) {
                throw new AddressException("Illegal character in domain", str);
            }
        }
    }

    public static InternetAddress getLocalAddress(Session session) {
        String str;
        String str2;
        String str3;
        String str4;
        String property;
        InetAddress localHost;
        if (session == null) {
            try {
                str = System.getProperty("user.name");
                str3 = InetAddress.getLocalHost().getHostName();
                str2 = null;
            } catch (SecurityException | UnknownHostException | AddressException unused) {
            }
        } else {
            str2 = session.getProperty("mail.from");
            if (str2 == null) {
                String property2 = session.getProperty("mail.user");
                if (property2 == null || property2.length() == 0) {
                    property2 = session.getProperty("user.name");
                }
                if (property2 != null) {
                    if (property2.length() != 0) {
                        str4 = property2;
                        property = session.getProperty("mail.host");
                        if ((property == null || property.length() == 0) && (localHost = InetAddress.getLocalHost()) != null) {
                            property = localHost.getHostName();
                        }
                        String str5 = str4;
                        str3 = property;
                        str = str5;
                    }
                }
                str4 = System.getProperty("user.name");
                property = session.getProperty("mail.host");
                property = localHost.getHostName();
                String str52 = str4;
                str3 = property;
                str = str52;
            } else {
                str = null;
                str3 = null;
            }
        }
        if (!(str2 != null || str == null || str.length() == 0 || str3 == null || str3.length() == 0)) {
            str2 = String.valueOf(str) + "@" + str3;
        }
        if (str2 != null) {
            return new InternetAddress(str2);
        }
        return null;
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

    private boolean isSimple() {
        String str = this.address;
        return str == null || indexOfAny(str, specialsNoDotNoAt) < 0;
    }

    private static int lengthOfFirstSegment(String str) {
        int indexOf = str.indexOf("\r\n");
        return indexOf != -1 ? indexOf : str.length();
    }

    private static int lengthOfLastSegment(String str, int i2) {
        int lastIndexOf = str.lastIndexOf("\r\n");
        int length = str.length();
        return lastIndexOf != -1 ? (length - lastIndexOf) - 2 : length + i2;
    }

    public static InternetAddress[] parse(String str) throws AddressException {
        return parse(str, true);
    }

    public static InternetAddress[] parse(String str, boolean z2) throws AddressException {
        return parse(str, z2, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:167:0x0237  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x023a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0194 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x00dc A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ea  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static javax.mail.internet.InternetAddress[] parse(java.lang.String r16, boolean r17, boolean r18) throws javax.mail.internet.AddressException {
        /*
            r0 = r16
            int r1 = r16.length()
            java.util.Vector r2 = new java.util.Vector
            r2.<init>()
            r3 = 0
            r4 = -1
            r5 = 0
            r6 = -1
            r7 = 0
            r8 = 0
            r9 = -1
            r10 = 0
            r11 = -1
            r12 = -1
        L_0x0015:
            if (r5 < r1) goto L_0x0077
            if (r6 < 0) goto L_0x006d
            if (r9 != r4) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r5 = r9
        L_0x001d:
            java.lang.String r1 = r0.substring(r6, r5)
            java.lang.String r1 = r1.trim()
            if (r10 != 0) goto L_0x004b
            if (r17 != 0) goto L_0x004b
            if (r18 == 0) goto L_0x002c
            goto L_0x004b
        L_0x002c:
            java.util.StringTokenizer r4 = new java.util.StringTokenizer
            r4.<init>(r1)
        L_0x0031:
            boolean r0 = r4.hasMoreTokens()
            if (r0 != 0) goto L_0x0038
            goto L_0x006d
        L_0x0038:
            java.lang.String r0 = r4.nextToken()
            checkAddress(r0, r3, r3)
            javax.mail.internet.InternetAddress r1 = new javax.mail.internet.InternetAddress
            r1.<init>()
            r1.setAddress(r0)
            r2.addElement(r1)
            goto L_0x0031
        L_0x004b:
            if (r17 != 0) goto L_0x004f
            if (r18 != 0) goto L_0x0052
        L_0x004f:
            checkAddress(r1, r8, r3)
        L_0x0052:
            javax.mail.internet.InternetAddress r3 = new javax.mail.internet.InternetAddress
            r3.<init>()
            r3.setAddress(r1)
            if (r11 < 0) goto L_0x006a
            java.lang.String r0 = r0.substring(r11, r12)
            java.lang.String r0 = r0.trim()
            java.lang.String r0 = unquote(r0)
            r3.encodedPersonal = r0
        L_0x006a:
            r2.addElement(r3)
        L_0x006d:
            int r0 = r2.size()
            javax.mail.internet.InternetAddress[] r0 = new javax.mail.internet.InternetAddress[r0]
            r2.copyInto(r0)
            return r0
        L_0x0077:
            char r13 = r0.charAt(r5)
            r14 = 9
            if (r13 == r14) goto L_0x00ae
            r14 = 10
            if (r13 == r14) goto L_0x00ae
            r14 = 13
            if (r13 == r14) goto L_0x00ae
            r14 = 32
            if (r13 == r14) goto L_0x00ae
            java.lang.String r14 = "Missing '\"'"
            r3 = 34
            if (r13 == r3) goto L_0x0219
            r15 = 44
            if (r13 == r15) goto L_0x01a9
            r15 = 62
            if (r13 == r15) goto L_0x01a1
            r15 = 91
            if (r13 == r15) goto L_0x017d
            r15 = 41
            r3 = 40
            if (r13 == r3) goto L_0x0143
            if (r13 == r15) goto L_0x013b
            switch(r13) {
                case 58: goto L_0x0129;
                case 59: goto L_0x00fd;
                case 60: goto L_0x00b1;
                default: goto L_0x00a8;
            }
        L_0x00a8:
            if (r6 != r4) goto L_0x00ae
            r6 = r5
            r3 = 1
            goto L_0x01b0
        L_0x00ae:
            r13 = 0
            goto L_0x0240
        L_0x00b1:
            if (r8 != 0) goto L_0x00f5
            if (r7 != 0) goto L_0x00bc
            if (r6 < 0) goto L_0x00b8
            r12 = r5
        L_0x00b8:
            int r3 = r5 + 1
            r11 = r6
            r6 = r3
        L_0x00bc:
            int r5 = r5 + 1
            r3 = 0
        L_0x00bf:
            if (r5 < r1) goto L_0x00c2
            goto L_0x00da
        L_0x00c2:
            char r8 = r0.charAt(r5)
            r9 = 34
            if (r8 == r9) goto L_0x00ee
            r9 = 62
            if (r8 == r9) goto L_0x00d6
            r10 = 92
            if (r8 == r10) goto L_0x00d3
            goto L_0x00d8
        L_0x00d3:
            int r5 = r5 + 1
            goto L_0x00d8
        L_0x00d6:
            if (r3 == 0) goto L_0x00da
        L_0x00d8:
            r8 = 1
            goto L_0x00f3
        L_0x00da:
            if (r5 < r1) goto L_0x00ea
            javax.mail.internet.AddressException r1 = new javax.mail.internet.AddressException
            if (r3 == 0) goto L_0x00e4
            r1.<init>(r14, r0, r5)
            throw r1
        L_0x00e4:
            java.lang.String r2 = "Missing '>'"
            r1.<init>(r2, r0, r5)
            throw r1
        L_0x00ea:
            r9 = r5
            r3 = 1
            r8 = 1
            goto L_0x0130
        L_0x00ee:
            r9 = 62
            r3 = r3 ^ 1
            goto L_0x00d8
        L_0x00f3:
            int r5 = r5 + r8
            goto L_0x00bf
        L_0x00f5:
            javax.mail.internet.AddressException r1 = new javax.mail.internet.AddressException
            java.lang.String r2 = "Extra route-addr"
            r1.<init>(r2, r0, r5)
            throw r1
        L_0x00fd:
            if (r6 != r4) goto L_0x0100
            r6 = r5
        L_0x0100:
            if (r7 == 0) goto L_0x0121
            if (r6 != r4) goto L_0x0105
            r6 = r5
        L_0x0105:
            javax.mail.internet.InternetAddress r3 = new javax.mail.internet.InternetAddress
            r3.<init>()
            int r7 = r5 + 1
            java.lang.String r6 = r0.substring(r6, r7)
            java.lang.String r6 = r6.trim()
            r3.setAddress(r6)
            r2.addElement(r3)
            r3 = 1
            r6 = -1
            r7 = 0
            r8 = 0
            r9 = -1
            goto L_0x01b0
        L_0x0121:
            javax.mail.internet.AddressException r1 = new javax.mail.internet.AddressException
            java.lang.String r2 = "Illegal semicolon, not in group"
            r1.<init>(r2, r0, r5)
            throw r1
        L_0x0129:
            if (r7 != 0) goto L_0x0133
            if (r6 != r4) goto L_0x012e
            r6 = r5
        L_0x012e:
            r3 = 1
            r7 = 1
        L_0x0130:
            r10 = 1
            goto L_0x01b0
        L_0x0133:
            javax.mail.internet.AddressException r1 = new javax.mail.internet.AddressException
            java.lang.String r2 = "Nested group"
            r1.<init>(r2, r0, r5)
            throw r1
        L_0x013b:
            javax.mail.internet.AddressException r1 = new javax.mail.internet.AddressException
            java.lang.String r2 = "Missing '('"
            r1.<init>(r2, r0, r5)
            throw r1
        L_0x0143:
            if (r6 < 0) goto L_0x0148
            if (r9 != r4) goto L_0x0148
            r9 = r5
        L_0x0148:
            if (r11 != r4) goto L_0x014c
            int r11 = r5 + 1
        L_0x014c:
            int r5 = r5 + 1
            r10 = 1
        L_0x014f:
            if (r5 >= r1) goto L_0x016d
            if (r10 > 0) goto L_0x0154
            goto L_0x016d
        L_0x0154:
            char r13 = r0.charAt(r5)
            if (r13 == r3) goto L_0x0168
            if (r13 == r15) goto L_0x0165
            r14 = 92
            if (r13 == r14) goto L_0x0162
        L_0x0160:
            r13 = 1
            goto L_0x016b
        L_0x0162:
            int r5 = r5 + 1
            goto L_0x0160
        L_0x0165:
            int r10 = r10 + -1
            goto L_0x0160
        L_0x0168:
            int r10 = r10 + 1
            goto L_0x0160
        L_0x016b:
            int r5 = r5 + r13
            goto L_0x014f
        L_0x016d:
            if (r10 > 0) goto L_0x0175
            int r5 = r5 + -1
            if (r12 != r4) goto L_0x0192
            r12 = r5
            goto L_0x0192
        L_0x0175:
            javax.mail.internet.AddressException r1 = new javax.mail.internet.AddressException
            java.lang.String r2 = "Missing ')'"
            r1.<init>(r2, r0, r5)
            throw r1
        L_0x017d:
            int r5 = r5 + 1
        L_0x017f:
            if (r5 < r1) goto L_0x0182
            goto L_0x0190
        L_0x0182:
            char r3 = r0.charAt(r5)
            r10 = 92
            if (r3 == r10) goto L_0x019c
            r10 = 93
            if (r3 == r10) goto L_0x0190
        L_0x018e:
            r3 = 1
            goto L_0x019f
        L_0x0190:
            if (r5 >= r1) goto L_0x0194
        L_0x0192:
            r3 = 1
            goto L_0x0130
        L_0x0194:
            javax.mail.internet.AddressException r1 = new javax.mail.internet.AddressException
            java.lang.String r2 = "Missing ']'"
            r1.<init>(r2, r0, r5)
            throw r1
        L_0x019c:
            int r5 = r5 + 1
            goto L_0x018e
        L_0x019f:
            int r5 = r5 + r3
            goto L_0x017f
        L_0x01a1:
            javax.mail.internet.AddressException r1 = new javax.mail.internet.AddressException
            java.lang.String r2 = "Missing '<'"
            r1.<init>(r2, r0, r5)
            throw r1
        L_0x01a9:
            if (r6 != r4) goto L_0x01b3
            r3 = 1
            r6 = -1
            r8 = 0
            r9 = -1
            r10 = 0
        L_0x01b0:
            r13 = 0
            goto L_0x0241
        L_0x01b3:
            if (r7 == 0) goto L_0x01b8
            r3 = 1
            r8 = 0
            goto L_0x01b0
        L_0x01b8:
            if (r9 != r4) goto L_0x01bb
            r9 = r5
        L_0x01bb:
            java.lang.String r3 = r0.substring(r6, r9)
            java.lang.String r3 = r3.trim()
            if (r10 != 0) goto L_0x01eb
            if (r17 != 0) goto L_0x01eb
            if (r18 == 0) goto L_0x01ca
            goto L_0x01eb
        L_0x01ca:
            java.util.StringTokenizer r6 = new java.util.StringTokenizer
            r6.<init>(r3)
        L_0x01cf:
            boolean r3 = r6.hasMoreTokens()
            if (r3 != 0) goto L_0x01d7
            r13 = 0
            goto L_0x0213
        L_0x01d7:
            java.lang.String r3 = r6.nextToken()
            r8 = 0
            checkAddress(r3, r8, r8)
            javax.mail.internet.InternetAddress r8 = new javax.mail.internet.InternetAddress
            r8.<init>()
            r8.setAddress(r3)
            r2.addElement(r8)
            goto L_0x01cf
        L_0x01eb:
            if (r17 != 0) goto L_0x01f2
            if (r18 != 0) goto L_0x01f0
            goto L_0x01f2
        L_0x01f0:
            r13 = 0
            goto L_0x01f6
        L_0x01f2:
            r13 = 0
            checkAddress(r3, r8, r13)
        L_0x01f6:
            javax.mail.internet.InternetAddress r6 = new javax.mail.internet.InternetAddress
            r6.<init>()
            r6.setAddress(r3)
            if (r11 < 0) goto L_0x0210
            java.lang.String r3 = r0.substring(r11, r12)
            java.lang.String r3 = r3.trim()
            java.lang.String r3 = unquote(r3)
            r6.encodedPersonal = r3
            r11 = -1
            r12 = -1
        L_0x0210:
            r2.addElement(r6)
        L_0x0213:
            r3 = 1
            r6 = -1
            r8 = 0
            r9 = -1
            r10 = 0
            goto L_0x0241
        L_0x0219:
            r13 = 0
            if (r6 != r4) goto L_0x021d
            r6 = r5
        L_0x021d:
            int r5 = r5 + 1
        L_0x021f:
            if (r5 < r1) goto L_0x0222
            goto L_0x0235
        L_0x0222:
            char r3 = r0.charAt(r5)
            r10 = 34
            if (r3 == r10) goto L_0x0235
            r15 = 92
            if (r3 == r15) goto L_0x0230
        L_0x022e:
            r3 = 1
            goto L_0x0233
        L_0x0230:
            int r5 = r5 + 1
            goto L_0x022e
        L_0x0233:
            int r5 = r5 + r3
            goto L_0x021f
        L_0x0235:
            if (r5 >= r1) goto L_0x023a
            r3 = 1
            r10 = 1
            goto L_0x0241
        L_0x023a:
            javax.mail.internet.AddressException r1 = new javax.mail.internet.AddressException
            r1.<init>(r14, r0, r5)
            throw r1
        L_0x0240:
            r3 = 1
        L_0x0241:
            int r5 = r5 + r3
            r3 = 0
            goto L_0x0015
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.mail.internet.InternetAddress.parse(java.lang.String, boolean, boolean):javax.mail.internet.InternetAddress[]");
    }

    public static InternetAddress[] parseHeader(String str, boolean z2) throws AddressException {
        return parse(str, z2, true);
    }

    private static String quotePhrase(String str) {
        int length = str.length();
        boolean z2 = false;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt == '\"' || charAt == '\\') {
                StringBuffer stringBuffer = new StringBuffer(length + 3);
                stringBuffer.append('\"');
                for (int i3 = 0; i3 < length; i3++) {
                    char charAt2 = str.charAt(i3);
                    if (charAt2 == '\"' || charAt2 == '\\') {
                        stringBuffer.append('\\');
                    }
                    stringBuffer.append(charAt2);
                }
                stringBuffer.append('\"');
                return stringBuffer.toString();
            }
            if ((charAt < ' ' && charAt != 13 && charAt != 10 && charAt != 9) || charAt >= 127 || rfc822phrase.indexOf(charAt) >= 0) {
                z2 = true;
            }
        }
        if (!z2) {
            return str;
        }
        StringBuffer stringBuffer2 = new StringBuffer(length + 2);
        stringBuffer2.append('\"');
        stringBuffer2.append(str);
        stringBuffer2.append('\"');
        return stringBuffer2.toString();
    }

    public static String toString(Address[] addressArr) {
        return toString(addressArr, 0);
    }

    public static String toString(Address[] addressArr, int i2) {
        if (addressArr == null || addressArr.length == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < addressArr.length; i3++) {
            if (i3 != 0) {
                stringBuffer.append(", ");
                i2 += 2;
            }
            String address2 = addressArr[i3].toString();
            if (lengthOfFirstSegment(address2) + i2 > 76) {
                stringBuffer.append("\r\n\t");
                i2 = 8;
            }
            stringBuffer.append(address2);
            i2 = lengthOfLastSegment(address2, i2);
        }
        return stringBuffer.toString();
    }

    private static String unquote(String str) {
        if (!str.startsWith("\"") || !str.endsWith("\"")) {
            return str;
        }
        String substring = str.substring(1, str.length() - 1);
        if (substring.indexOf(92) < 0) {
            return substring;
        }
        StringBuffer stringBuffer = new StringBuffer(substring.length());
        int i2 = 0;
        while (i2 < substring.length()) {
            char charAt = substring.charAt(i2);
            if (charAt == '\\' && i2 < substring.length() - 1) {
                i2++;
                charAt = substring.charAt(i2);
            }
            stringBuffer.append(charAt);
            i2++;
        }
        return stringBuffer.toString();
    }

    public Object clone() {
        try {
            return (InternetAddress) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof InternetAddress)) {
            return false;
        }
        String address2 = ((InternetAddress) obj).getAddress();
        String str = this.address;
        if (address2 == str) {
            return true;
        }
        return str != null && str.equalsIgnoreCase(address2);
    }

    public String getAddress() {
        return this.address;
    }

    public InternetAddress[] getGroup(boolean z2) throws AddressException {
        int indexOf;
        String address2 = getAddress();
        if (address2.endsWith(";") && (indexOf = address2.indexOf(58)) >= 0) {
            return parseHeader(address2.substring(indexOf + 1, address2.length() - 1), z2);
        }
        return null;
    }

    public String getPersonal() {
        String str = this.personal;
        if (str != null) {
            return str;
        }
        String str2 = this.encodedPersonal;
        if (str2 == null) {
            return null;
        }
        try {
            String decodeText = MimeUtility.decodeText(str2);
            this.personal = decodeText;
            return decodeText;
        } catch (Exception unused) {
            return this.encodedPersonal;
        }
    }

    public String getType() {
        return "rfc822";
    }

    public int hashCode() {
        String str = this.address;
        if (str == null) {
            return 0;
        }
        return str.toLowerCase(Locale.ENGLISH).hashCode();
    }

    public boolean isGroup() {
        String str = this.address;
        return str != null && str.endsWith(";") && this.address.indexOf(58) > 0;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setPersonal(String str) throws UnsupportedEncodingException {
        this.personal = str;
        this.encodedPersonal = str != null ? MimeUtility.encodeWord(str) : null;
    }

    public void setPersonal(String str, String str2) throws UnsupportedEncodingException {
        this.personal = str;
        if (str != null) {
            this.encodedPersonal = MimeUtility.encodeWord(str, str2, (String) null);
        } else {
            this.encodedPersonal = null;
        }
    }

    public String toString() {
        String str;
        if (this.encodedPersonal == null && (str = this.personal) != null) {
            try {
                this.encodedPersonal = MimeUtility.encodeWord(str);
            } catch (UnsupportedEncodingException unused) {
            }
        }
        String str2 = this.encodedPersonal;
        if (str2 != null) {
            return String.valueOf(quotePhrase(str2)) + " <" + this.address + ">";
        } else if (isGroup() || isSimple()) {
            return this.address;
        } else {
            return "<" + this.address + ">";
        }
    }

    public String toUnicodeString() {
        String personal2 = getPersonal();
        if (personal2 != null) {
            return String.valueOf(quotePhrase(personal2)) + " <" + this.address + ">";
        } else if (isGroup() || isSimple()) {
            return this.address;
        } else {
            return "<" + this.address + ">";
        }
    }

    public void validate() throws AddressException {
        checkAddress(getAddress(), true, true);
    }
}
