package okio;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ByteString implements Serializable, Comparable<ByteString> {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f32415a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b  reason: collision with root package name */
    public static final ByteString f32416b = a(new byte[0]);
    private static final long serialVersionUID = 1;

    /* renamed from: c  reason: collision with root package name */
    final byte[] f32417c;

    /* renamed from: d  reason: collision with root package name */
    transient int f32418d;

    /* renamed from: e  reason: collision with root package name */
    transient String f32419e;

    ByteString(byte[] bArr) {
        this.f32417c = bArr;
    }

    private static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: " + c2);
            }
        }
        return (c2 - c3) + 10;
    }

    static int a(String str, int i2) {
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            if (i4 == i2) {
                return i3;
            }
            int codePointAt = str.codePointAt(i3);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i4++;
            i3 += Character.charCount(codePointAt);
        }
        return str.length();
    }

    public static ByteString a(String str) {
        if (str != null) {
            ByteString byteString = new ByteString(str.getBytes(t.f32478a));
            byteString.f32419e = str;
            return byteString;
        }
        throw new IllegalArgumentException("s == null");
    }

    public static ByteString a(byte... bArr) {
        if (bArr != null) {
            return new ByteString((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static ByteString b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        } else if (str.length() % 2 == 0) {
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) ((a(str.charAt(i3)) << 4) + a(str.charAt(i3 + 1)));
            }
            return a(bArr);
        } else {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
    }

    private ByteString c(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.f32417c));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public byte a(int i2) {
        return this.f32417c[i2];
    }

    public String a() {
        String str = this.f32419e;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f32417c, t.f32478a);
        this.f32419e = str2;
        return str2;
    }

    public ByteString a(int i2, int i3) {
        if (i2 >= 0) {
            byte[] bArr = this.f32417c;
            if (i3 <= bArr.length) {
                int i4 = i3 - i2;
                if (i4 < 0) {
                    throw new IllegalArgumentException("endIndex < beginIndex");
                } else if (i2 == 0 && i3 == bArr.length) {
                    return this;
                } else {
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(bArr, i2, bArr2, 0, i4);
                    return new ByteString(bArr2);
                }
            } else {
                throw new IllegalArgumentException("endIndex > length(" + this.f32417c.length + ")");
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0");
        }
    }

    /* access modifiers changed from: package-private */
    public void a(c cVar) {
        byte[] bArr = this.f32417c;
        cVar.c(bArr, 0, bArr.length);
    }

    public boolean a(int i2, ByteString byteString, int i3, int i4) {
        return byteString.a(i3, this.f32417c, i2, i4);
    }

    public boolean a(int i2, byte[] bArr, int i3, int i4) {
        if (i2 >= 0) {
            byte[] bArr2 = this.f32417c;
            return i2 <= bArr2.length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && t.a(bArr2, i2, bArr, i3, i4);
        }
    }

    public final boolean a(ByteString byteString) {
        return a(0, byteString, 0, byteString.g());
    }

    /* renamed from: b */
    public int compareTo(ByteString byteString) {
        int g2 = g();
        int g3 = byteString.g();
        int min = Math.min(g2, g3);
        for (int i2 = 0; i2 < min; i2++) {
            byte a2 = a(i2) & 255;
            byte a3 = byteString.a(i2) & 255;
            if (a2 != a3) {
                return a2 < a3 ? -1 : 1;
            }
        }
        if (g2 == g3) {
            return 0;
        }
        return g2 < g3 ? -1 : 1;
    }

    public String b() {
        return b.a(this.f32417c);
    }

    public ByteString c() {
        return c("SHA-1");
    }

    public ByteString d() {
        return c("SHA-256");
    }

    public String e() {
        byte[] bArr = this.f32417c;
        char[] cArr = new char[(bArr.length * 2)];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = i2 + 1;
            char[] cArr2 = f32415a;
            cArr[i2] = cArr2[(b2 >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            int g2 = byteString.g();
            byte[] bArr = this.f32417c;
            return g2 == bArr.length && byteString.a(0, bArr, 0, bArr.length);
        }
    }

    public ByteString f() {
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f32417c;
            if (i2 >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i2];
            if (b2 < 65 || b2 > 90) {
                i2++;
            } else {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i2] = (byte) (b2 + 32);
                for (int i3 = i2 + 1; i3 < bArr2.length; i3++) {
                    byte b3 = bArr2[i3];
                    if (b3 >= 65 && b3 <= 90) {
                        bArr2[i3] = (byte) (b3 + 32);
                    }
                }
                return new ByteString(bArr2);
            }
        }
    }

    public int g() {
        return this.f32417c.length;
    }

    public byte[] h() {
        return (byte[]) this.f32417c.clone();
    }

    public int hashCode() {
        int i2 = this.f32418d;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = Arrays.hashCode(this.f32417c);
        this.f32418d = hashCode;
        return hashCode;
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2;
        if (this.f32417c.length == 0) {
            return "[size=0]";
        }
        String a2 = a();
        int a3 = a(a2, 64);
        if (a3 == -1) {
            if (this.f32417c.length <= 64) {
                sb2 = new StringBuilder();
                sb2.append("[hex=");
                sb2.append(e());
                sb2.append("]");
            } else {
                sb2 = new StringBuilder();
                sb2.append("[size=");
                sb2.append(this.f32417c.length);
                sb2.append(" hex=");
                sb2.append(a(0, 64).e());
                sb2.append("…]");
            }
            return sb2.toString();
        }
        String replace = a2.substring(0, a3).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (a3 < a2.length()) {
            sb = new StringBuilder();
            sb.append("[size=");
            sb.append(this.f32417c.length);
            sb.append(" text=");
            sb.append(replace);
            sb.append("…]");
        } else {
            sb = new StringBuilder();
            sb.append("[text=");
            sb.append(replace);
            sb.append("]");
        }
        return sb.toString();
    }
}
