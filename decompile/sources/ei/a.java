package ei;

import java.lang.reflect.Array;

public class a {
    public static double a(double d2, double d3, double d4) {
        return (c(d2, d3, d4) - d3) / (d4 - d3);
    }

    public static int a(int i2, int i3, int i4) {
        return ((i2 & 65535) << 16) | 0 | ((i3 & 255) << 8) | (i4 & 255);
    }

    public static byte[] a(byte b2) {
        byte[] bArr = new byte[8];
        int i2 = 0;
        bArr[0] = (byte) ((b2 & 1) == 1 ? 1 : 0);
        bArr[1] = (byte) ((b2 & 2) == 2 ? 1 : 0);
        bArr[2] = (byte) ((b2 & 4) == 4 ? 1 : 0);
        bArr[3] = (byte) ((b2 & 8) == 8 ? 1 : 0);
        bArr[4] = (byte) ((b2 & 16) == 16 ? 1 : 0);
        bArr[5] = (byte) ((b2 & 32) == 32 ? 1 : 0);
        bArr[6] = (byte) ((b2 & 64) == 64 ? 1 : 0);
        if ((b2 & 128) == 128) {
            i2 = 1;
        }
        bArr[7] = (byte) i2;
        return bArr;
    }

    public static double[][] b(double d2, double d3, double d4) {
        double[][] dArr = (double[][]) Array.newInstance(double.class, new int[]{3, 3});
        double cos = Math.cos(d3);
        double sin = Math.sin(d3);
        double sin2 = Math.sin(d2);
        double cos2 = Math.cos(d2);
        double sin3 = Math.sin(d4);
        double cos3 = Math.cos(d4);
        dArr[0][0] = cos * cos3;
        double d5 = sin2 * sin;
        dArr[1][0] = (d5 * cos3) - (cos2 * sin3);
        double d6 = cos2 * sin;
        dArr[2][0] = (d6 * cos3) + (sin2 * sin3);
        dArr[0][1] = cos * sin3;
        dArr[1][1] = (d5 * sin3) + (cos2 * cos3);
        dArr[2][1] = (d6 * sin3) - (cos3 * sin2);
        dArr[0][2] = -sin;
        dArr[1][2] = sin2 * cos;
        dArr[2][2] = cos2 * cos;
        return dArr;
    }

    private static double c(double d2, double d3, double d4) {
        return Math.min(Math.max(d2, d3), d4);
    }
}
