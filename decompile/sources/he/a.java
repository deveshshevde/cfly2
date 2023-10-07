package he;

import java.nio.ByteBuffer;

public class a {
    public static int a(byte[] bArr, int i2) {
        return ByteBuffer.wrap(bArr, i2, 4).getInt();
    }

    public static boolean a(byte[] bArr, byte[] bArr2, int i2) {
        if (bArr.length < i2 || bArr2.length < i2) {
            return false;
        }
        int i3 = 0;
        while (i3 < i2 && bArr[i3] == bArr2[i3]) {
            i3++;
        }
        return i3 == i2;
    }

    public static byte[] a(int i2) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[4]);
        wrap.putInt(i2);
        return wrap.array();
    }
}
