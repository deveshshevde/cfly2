package com.google.android.gms.common.internal.safeparcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SafeParcelReader {

    public static class ParseException extends RuntimeException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ParseException(java.lang.String r4, android.os.Parcel r5) {
            /*
                r3 = this;
                int r0 = r5.dataPosition()
                int r5 = r5.dataSize()
                java.lang.String r1 = java.lang.String.valueOf(r4)
                int r1 = r1.length()
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                int r1 = r1 + 41
                r2.<init>(r1)
                r2.append(r4)
                java.lang.String r4 = " Parcel: pos="
                r2.append(r4)
                r2.append(r0)
                java.lang.String r4 = " size="
                r2.append(r4)
                r2.append(r5)
                java.lang.String r4 = r2.toString()
                r3.<init>(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException.<init>(java.lang.String, android.os.Parcel):void");
        }
    }

    public static BigDecimal[] A(Parcel parcel, int i2) {
        int e2 = e(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (e2 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigDecimal[] bigDecimalArr = new BigDecimal[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            byte[] createByteArray = parcel.createByteArray();
            bigDecimalArr[i3] = new BigDecimal(new BigInteger(createByteArray), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + e2);
        return bigDecimalArr;
    }

    public static BigInteger[] B(Parcel parcel, int i2) {
        int e2 = e(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (e2 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        BigInteger[] bigIntegerArr = new BigInteger[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            bigIntegerArr[i3] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + e2);
        return bigIntegerArr;
    }

    public static boolean[] C(Parcel parcel, int i2) {
        int e2 = e(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (e2 == 0) {
            return null;
        }
        boolean[] createBooleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(dataPosition + e2);
        return createBooleanArray;
    }

    public static byte a(Parcel parcel, int i2) {
        a(parcel, i2, 4);
        return (byte) parcel.readInt();
    }

    public static int a(int i2) {
        return (char) i2;
    }

    public static int a(Parcel parcel) {
        return parcel.readInt();
    }

    public static <T extends Parcelable> T a(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int e2 = e(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (e2 == 0) {
            return null;
        }
        T t2 = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + e2);
        return t2;
    }

    private static void a(Parcel parcel, int i2, int i3) {
        int e2 = e(parcel, i2);
        if (e2 != i3) {
            String hexString = Integer.toHexString(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
            sb.append("Expected size ");
            sb.append(i3);
            sb.append(" got ");
            sb.append(e2);
            sb.append(" (0x");
            sb.append(hexString);
            sb.append(")");
            throw new ParseException(sb.toString(), parcel);
        }
    }

    private static void a(Parcel parcel, int i2, int i3, int i4) {
        if (i3 != i4) {
            String hexString = Integer.toHexString(i3);
            StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
            sb.append("Expected size ");
            sb.append(i4);
            sb.append(" got ");
            sb.append(i3);
            sb.append(" (0x");
            sb.append(hexString);
            sb.append(")");
            throw new ParseException(sb.toString(), parcel);
        }
    }

    public static void a(Parcel parcel, int i2, List list, ClassLoader classLoader) {
        int e2 = e(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (e2 != 0) {
            parcel.readList(list, classLoader);
            parcel.setDataPosition(dataPosition + e2);
        }
    }

    public static double b(Parcel parcel, int i2) {
        a(parcel, i2, 8);
        return parcel.readDouble();
    }

    public static int b(Parcel parcel) {
        int a2 = a(parcel);
        int e2 = e(parcel, a2);
        int dataPosition = parcel.dataPosition();
        if (a(a2) != 20293) {
            String valueOf = String.valueOf(Integer.toHexString(a2));
            throw new ParseException(valueOf.length() != 0 ? "Expected object header. Got 0x".concat(valueOf) : new String("Expected object header. Got 0x"), parcel);
        }
        int i2 = e2 + dataPosition;
        if (i2 >= dataPosition && i2 <= parcel.dataSize()) {
            return i2;
        }
        StringBuilder sb = new StringBuilder(54);
        sb.append("Size read is invalid start=");
        sb.append(dataPosition);
        sb.append(" end=");
        sb.append(i2);
        throw new ParseException(sb.toString(), parcel);
    }

    public static <T> ArrayList<T> b(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int e2 = e(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (e2 == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + e2);
        return createTypedArrayList;
    }

    public static float c(Parcel parcel, int i2) {
        a(parcel, i2, 4);
        return parcel.readFloat();
    }

    public static <T> T[] c(Parcel parcel, int i2, Parcelable.Creator<T> creator) {
        int e2 = e(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (e2 == 0) {
            return null;
        }
        T[] createTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + e2);
        return createTypedArray;
    }

    public static int d(Parcel parcel, int i2) {
        a(parcel, i2, 4);
        return parcel.readInt();
    }

    public static int e(Parcel parcel, int i2) {
        return (i2 & -65536) != -65536 ? (char) (i2 >> 16) : parcel.readInt();
    }

    public static long f(Parcel parcel, int i2) {
        a(parcel, i2, 8);
        return parcel.readLong();
    }

    public static Bundle g(Parcel parcel, int i2) {
        int e2 = e(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (e2 == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + e2);
        return readBundle;
    }

    public static IBinder h(Parcel parcel, int i2) {
        int e2 = e(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (e2 == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + e2);
        return readStrongBinder;
    }

    public static Parcel i(Parcel parcel, int i2) {
        int e2 = e(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (e2 == 0) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, e2);
        parcel.setDataPosition(dataPosition + e2);
        return obtain;
    }

    public static Float j(Parcel parcel, int i2) {
        int e2 = e(parcel, i2);
        if (e2 == 0) {
            return null;
        }
        a(parcel, i2, e2, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static Integer k(Parcel parcel, int i2) {
        int e2 = e(parcel, i2);
        if (e2 == 0) {
            return null;
        }
        a(parcel, i2, e2, 4);
        return Integer.valueOf(parcel.readInt());
    }

    public static String l(Parcel parcel, int i2) {
        int e2 = e(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (e2 == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + e2);
        return readString;
    }

    public static BigDecimal m(Parcel parcel, int i2) {
        int e2 = e(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (e2 == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        int readInt = parcel.readInt();
        parcel.setDataPosition(dataPosition + e2);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public static BigInteger n(Parcel parcel, int i2) {
        int e2 = e(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (e2 == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + e2);
        return new BigInteger(createByteArray);
    }

    public static ArrayList<String> o(Parcel parcel, int i2) {
        int e2 = e(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (e2 == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + e2);
        return createStringArrayList;
    }

    public static short p(Parcel parcel, int i2) {
        a(parcel, i2, 4);
        return (short) parcel.readInt();
    }

    public static void q(Parcel parcel, int i2) {
        if (parcel.dataPosition() != i2) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Overread allowed size end=");
            sb.append(i2);
            throw new ParseException(sb.toString(), parcel);
        }
    }

    public static void r(Parcel parcel, int i2) {
        parcel.setDataPosition(parcel.dataPosition() + e(parcel, i2));
    }

    public static boolean s(Parcel parcel, int i2) {
        a(parcel, i2, 4);
        return parcel.readInt() != 0;
    }

    public static byte[] t(Parcel parcel, int i2) {
        int e2 = e(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (e2 == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + e2);
        return createByteArray;
    }

    public static double[] u(Parcel parcel, int i2) {
        int e2 = e(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (e2 == 0) {
            return null;
        }
        double[] createDoubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(dataPosition + e2);
        return createDoubleArray;
    }

    public static float[] v(Parcel parcel, int i2) {
        int e2 = e(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (e2 == 0) {
            return null;
        }
        float[] createFloatArray = parcel.createFloatArray();
        parcel.setDataPosition(dataPosition + e2);
        return createFloatArray;
    }

    public static int[] w(Parcel parcel, int i2) {
        int e2 = e(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (e2 == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + e2);
        return createIntArray;
    }

    public static long[] x(Parcel parcel, int i2) {
        int e2 = e(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (e2 == 0) {
            return null;
        }
        long[] createLongArray = parcel.createLongArray();
        parcel.setDataPosition(dataPosition + e2);
        return createLongArray;
    }

    public static Parcel[] y(Parcel parcel, int i2) {
        int e2 = e(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (e2 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        Parcel[] parcelArr = new Parcel[readInt];
        for (int i3 = 0; i3 < readInt; i3++) {
            int readInt2 = parcel.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = parcel.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, readInt2);
                parcelArr[i3] = obtain;
                parcel.setDataPosition(dataPosition2 + readInt2);
            } else {
                parcelArr[i3] = null;
            }
        }
        parcel.setDataPosition(dataPosition + e2);
        return parcelArr;
    }

    public static String[] z(Parcel parcel, int i2) {
        int e2 = e(parcel, i2);
        int dataPosition = parcel.dataPosition();
        if (e2 == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(dataPosition + e2);
        return createStringArray;
    }
}
