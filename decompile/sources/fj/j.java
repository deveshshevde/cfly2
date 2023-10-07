package fj;

import java.io.IOException;

final class j {
    public static int a(h hVar, byte[] bArr, int i2, int i3) throws IOException, InterruptedException {
        int i4 = 0;
        while (i4 < i3) {
            int c2 = hVar.c(bArr, i2 + i4, i3 - i4);
            if (c2 == -1) {
                break;
            }
            i4 += c2;
        }
        return i4;
    }
}
