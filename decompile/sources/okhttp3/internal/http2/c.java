package okhttp3.internal.http2;

import java.io.IOException;
import okio.ByteString;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    static final ByteString f32104a = ByteString.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* renamed from: b  reason: collision with root package name */
    static final String[] f32105b = new String[64];

    /* renamed from: c  reason: collision with root package name */
    static final String[] f32106c = new String[256];

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f32107d = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    static {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr = f32106c;
            if (i3 >= strArr.length) {
                break;
            }
            strArr[i3] = nb.c.a("%8s", Integer.toBinaryString(i3)).replace(' ', '0');
            i3++;
        }
        String[] strArr2 = f32105b;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i4 = 0; i4 < 1; i4++) {
            int i5 = iArr[i4];
            String[] strArr3 = f32105b;
            strArr3[i5 | 8] = strArr3[i5] + "|PADDED";
        }
        String[] strArr4 = f32105b;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i6 = 0; i6 < 3; i6++) {
            int i7 = iArr2[i6];
            for (int i8 = 0; i8 < 1; i8++) {
                int i9 = iArr[i8];
                String[] strArr5 = f32105b;
                int i10 = i9 | i7;
                strArr5[i10] = strArr5[i9] + '|' + strArr5[i7];
                strArr5[i10 | 8] = strArr5[i9] + '|' + strArr5[i7] + "|PADDED";
            }
        }
        while (true) {
            String[] strArr6 = f32105b;
            if (i2 < strArr6.length) {
                if (strArr6[i2] == null) {
                    strArr6[i2] = f32106c[i2];
                }
                i2++;
            } else {
                return;
            }
        }
    }

    private c() {
    }

    static IllegalArgumentException a(String str, Object... objArr) {
        throw new IllegalArgumentException(nb.c.a(str, objArr));
    }

    static String a(byte b2, byte b3) {
        if (b3 == 0) {
            return "";
        }
        if (!(b2 == 2 || b2 == 3)) {
            if (b2 == 4 || b2 == 6) {
                return b3 == 1 ? "ACK" : f32106c[b3];
            }
            if (!(b2 == 7 || b2 == 8)) {
                String[] strArr = f32105b;
                String str = b3 < strArr.length ? strArr[b3] : f32106c[b3];
                return (b2 != 5 || (b3 & 4) == 0) ? (b2 != 0 || (b3 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED") : str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return f32106c[b3];
    }

    static String a(boolean z2, int i2, int i3, byte b2, byte b3) {
        String[] strArr = f32107d;
        String a2 = b2 < strArr.length ? strArr[b2] : nb.c.a("0x%02x", Byte.valueOf(b2));
        String a3 = a(b2, b3);
        Object[] objArr = new Object[5];
        objArr[0] = z2 ? "<<" : ">>";
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(i3);
        objArr[3] = a2;
        objArr[4] = a3;
        return nb.c.a("%s 0x%08x %5d %-13s %s", objArr);
    }

    static IOException b(String str, Object... objArr) throws IOException {
        throw new IOException(nb.c.a(str, objArr));
    }
}
