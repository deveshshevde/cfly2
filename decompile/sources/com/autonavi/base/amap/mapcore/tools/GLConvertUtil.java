package com.autonavi.base.amap.mapcore.tools;

import java.io.ByteArrayOutputStream;

public class GLConvertUtil {
    public static double convertDouble(byte[] bArr, int i2) {
        long j2 = 0;
        for (int i3 = 0; i3 < 8; i3++) {
            j2 += ((long) (bArr[i3 + i2] & 255)) << (i3 * 8);
        }
        return Double.longBitsToDouble(j2);
    }

    public static byte[] convertInt(int i2) {
        return new byte[]{(byte) (i2 & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 16) & 255), (byte) ((i2 >> 24) & 255)};
    }

    public static byte[] convertShort(int i2) {
        return new byte[]{(byte) (i2 & 255), (byte) ((i2 >> 8) & 255)};
    }

    public static byte[] get1BString(String str) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bytes = str.getBytes("UTF-8");
            byteArrayOutputStream.write(new byte[]{(byte) bytes.length});
            byteArrayOutputStream.write(bytes);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e2) {
            e2.printStackTrace();
            return new byte[1];
        }
    }

    public static int getInt(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << 24) + ((bArr[i2 + 2] & 255) << 16) + ((bArr[i2 + 1] & 255) << 8) + ((bArr[i2 + 0] & 255) << 0);
    }

    public static int getInt2(byte[] bArr, int i2) {
        return ((bArr[i2 + 0] & 255) << 24) + ((bArr[i2 + 1] & 255) << 16) + ((bArr[i2 + 2] & 255) << 8) + ((bArr[i2 + 3] & 255) << 0);
    }

    public static long getLong(byte[] bArr, int i2) {
        return (((long) (bArr[i2 + 7] & 255)) << 56) + (((long) (bArr[i2 + 6] & 255)) << 48) + (((long) (bArr[i2 + 5] & 255)) << 40) + (((long) (bArr[i2 + 4] & 255)) << 32) + (((long) (bArr[i2 + 3] & 255)) << 24) + (((long) (bArr[i2 + 2] & 255)) << 16) + (((long) (bArr[i2 + 1] & 255)) << 8) + (((long) (bArr[i2 + 0] & 255)) << 0);
    }

    public static short getShort(byte[] bArr, int i2) {
        return (short) (((bArr[i2 + 1] & 255) << 8) + ((bArr[i2 + 0] & 255) << 0));
    }

    public static short getShort2(byte[] bArr, int i2) {
        return (short) (((bArr[i2 + 0] & 255) << 8) + ((bArr[i2 + 1] & 255) << 0));
    }

    public static String getString(byte[] bArr, int i2, int i3) {
        try {
            return new String(bArr, i2, i3, "UTF-8");
        } catch (Exception unused) {
            return "";
        }
    }

    public static byte[] getSubBytes(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return bArr2;
    }

    public static int getUShort(byte[] bArr, int i2) {
        return ((bArr[i2 + 1] & 255) << 8) + ((bArr[i2 + 0] & 255) << 0);
    }

    public static void moveArray(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        byte[] bArr3 = new byte[i4];
        System.arraycopy(bArr, i2, bArr3, 0, i4);
        System.arraycopy(bArr3, 0, bArr2, i3, i4);
    }

    public static void writeInt(byte[] bArr, int i2, int i3) {
        System.arraycopy(convertInt(i3), 0, bArr, i2, 4);
    }

    public static void writeShort(byte[] bArr, int i2, short s2) {
        System.arraycopy(convertShort(s2), 0, bArr, i2, 2);
    }
}
