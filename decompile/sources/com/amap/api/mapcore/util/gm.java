package com.amap.api.mapcore.util;

public final class gm {

    /* renamed from: a  reason: collision with root package name */
    private static int f8931a = 4;

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return bArr;
        }
        int length = bArr.length;
        int i2 = f8931a;
        int i3 = i2 - (length % i2);
        int i4 = ((length / i2) + 1) * i2;
        byte[] bArr3 = new byte[i4];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        while (length < i4) {
            bArr3[length] = (byte) i3;
            length++;
        }
        int[] a2 = a(bArr3);
        int[] a3 = a(bArr2);
        int length2 = a2.length - 1;
        if (length2 > 0) {
            if (a3.length < 4) {
                int[] iArr = new int[4];
                System.arraycopy(a3, 0, iArr, 0, a3.length);
                a3 = iArr;
            }
            int i5 = a2[length2];
            int i6 = (52 / (length2 + 1)) + 6;
            int i7 = 0;
            while (true) {
                int i8 = i6 - 1;
                if (i6 <= 0) {
                    break;
                }
                i7 -= 1640531527;
                int i9 = (i7 >>> 2) & 3;
                int i10 = 0;
                while (i10 < length2) {
                    int i11 = i10 + 1;
                    int i12 = a2[i11];
                    i5 = ((((i5 >>> 5) ^ (i12 << 2)) + ((i12 >>> 3) ^ (i5 << 4))) ^ ((i12 ^ i7) + (i5 ^ a3[(i10 & 3) ^ i9]))) + a2[i10];
                    a2[i10] = i5;
                    i10 = i11;
                }
                int i13 = a2[0];
                i5 = ((((i5 >>> 5) ^ (i13 << 2)) + ((i13 >>> 3) ^ (i5 << 4))) ^ ((i13 ^ i7) + (i5 ^ a3[i9 ^ (i10 & 3)]))) + a2[length2];
                a2[length2] = i5;
                i6 = i8;
            }
        }
        int length3 = a2.length << 2;
        byte[] bArr4 = new byte[length3];
        for (int i14 = 0; i14 < length3; i14++) {
            bArr4[i14] = (byte) ((a2[i14 >>> 2] >>> ((i14 & 3) << 3)) & 255);
        }
        return bArr4;
    }

    private static int[] a(byte[] bArr) {
        int[] iArr = new int[(bArr.length >>> 2)];
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 >>> 2;
            iArr[i3] = iArr[i3] | ((bArr[i2] & 255) << ((i2 & 3) << 3));
        }
        return iArr;
    }
}
