package com.xeagle.android.utils;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f24423a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f24424b = {60, 56, 52, 48, 44, 40, 36, 32, 28, 24, 20, 16, 12, 8, 4, 0};

    public static String a(byte b2) {
        return a((long) b2, 2);
    }

    private static String a(long j2, int i2) {
        StringBuilder sb = new StringBuilder(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(f24423a[(int) ((j2 >> f24424b[(16 - i2) + i3]) & 15)]);
        }
        return sb.toString();
    }

    public static String a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static String a(byte[] bArr, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        int i4 = i3 + i2;
        while (i2 < i4) {
            sb.append(a(bArr[i2]));
            i2++;
        }
        return sb.toString();
    }
}
