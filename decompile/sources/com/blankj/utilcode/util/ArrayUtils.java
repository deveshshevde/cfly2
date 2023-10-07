package com.blankj.utilcode.util;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ArrayUtils {
    public static final int INDEX_NOT_FOUND = -1;

    public interface Closure<E> {
        void execute(int i2, E e2);
    }

    private ArrayUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static byte[] add(byte[] bArr, byte b2) {
        byte[] bArr2 = (byte[]) realAddOne(bArr, Byte.valueOf(b2), Byte.TYPE);
        Objects.requireNonNull(bArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return bArr2;
    }

    public static byte[] add(byte[] bArr, int i2, byte b2) {
        byte[] bArr2 = (byte[]) realAdd(bArr, i2, Byte.valueOf(b2), Byte.TYPE);
        Objects.requireNonNull(bArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return bArr2;
    }

    public static byte[] add(byte[] bArr, int i2, byte[] bArr2) {
        Object realAddArr = realAddArr(bArr, i2, bArr2, Byte.TYPE);
        if (realAddArr == null) {
            return null;
        }
        return (byte[]) realAddArr;
    }

    public static byte[] add(byte[] bArr, byte[] bArr2) {
        return (byte[]) realAddArr(bArr, bArr2);
    }

    public static char[] add(char[] cArr, char c2) {
        char[] cArr2 = (char[]) realAddOne(cArr, Character.valueOf(c2), Character.TYPE);
        Objects.requireNonNull(cArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return cArr2;
    }

    public static char[] add(char[] cArr, int i2, char c2) {
        char[] cArr2 = (char[]) realAdd(cArr, i2, Character.valueOf(c2), Character.TYPE);
        Objects.requireNonNull(cArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return cArr2;
    }

    public static char[] add(char[] cArr, int i2, char[] cArr2) {
        Object realAddArr = realAddArr(cArr, i2, cArr2, Character.TYPE);
        if (realAddArr == null) {
            return null;
        }
        return (char[]) realAddArr;
    }

    public static char[] add(char[] cArr, char[] cArr2) {
        return (char[]) realAddArr(cArr, cArr2);
    }

    public static double[] add(double[] dArr, double d2) {
        double[] dArr2 = (double[]) realAddOne(dArr, Double.valueOf(d2), Double.TYPE);
        Objects.requireNonNull(dArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return dArr2;
    }

    public static double[] add(double[] dArr, int i2, double d2) {
        double[] dArr2 = (double[]) realAdd(dArr, i2, Double.valueOf(d2), Double.TYPE);
        Objects.requireNonNull(dArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return dArr2;
    }

    public static double[] add(double[] dArr, int i2, double[] dArr2) {
        Object realAddArr = realAddArr(dArr, i2, dArr2, Double.TYPE);
        if (realAddArr == null) {
            return null;
        }
        return (double[]) realAddArr;
    }

    public static double[] add(double[] dArr, double[] dArr2) {
        return (double[]) realAddArr(dArr, dArr2);
    }

    public static float[] add(float[] fArr, float f2) {
        float[] fArr2 = (float[]) realAddOne(fArr, Float.valueOf(f2), Float.TYPE);
        Objects.requireNonNull(fArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return fArr2;
    }

    public static float[] add(float[] fArr, int i2, float f2) {
        float[] fArr2 = (float[]) realAdd(fArr, i2, Float.valueOf(f2), Float.TYPE);
        Objects.requireNonNull(fArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return fArr2;
    }

    public static float[] add(float[] fArr, int i2, float[] fArr2) {
        Object realAddArr = realAddArr(fArr, i2, fArr2, Float.TYPE);
        if (realAddArr == null) {
            return null;
        }
        return (float[]) realAddArr;
    }

    public static float[] add(float[] fArr, float[] fArr2) {
        return (float[]) realAddArr(fArr, fArr2);
    }

    public static int[] add(int[] iArr, int i2) {
        int[] iArr2 = (int[]) realAddOne(iArr, Integer.valueOf(i2), Integer.TYPE);
        Objects.requireNonNull(iArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return iArr2;
    }

    public static int[] add(int[] iArr, int i2, int i3) {
        int[] iArr2 = (int[]) realAdd(iArr, i2, Integer.valueOf(i3), Integer.TYPE);
        Objects.requireNonNull(iArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return iArr2;
    }

    public static int[] add(int[] iArr, int i2, int[] iArr2) {
        Object realAddArr = realAddArr(iArr, i2, iArr2, Integer.TYPE);
        if (realAddArr == null) {
            return null;
        }
        return (int[]) realAddArr;
    }

    public static int[] add(int[] iArr, int[] iArr2) {
        return (int[]) realAddArr(iArr, iArr2);
    }

    public static long[] add(long[] jArr, int i2, long j2) {
        long[] jArr2 = (long[]) realAdd(jArr, i2, Long.valueOf(j2), Long.TYPE);
        Objects.requireNonNull(jArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return jArr2;
    }

    public static long[] add(long[] jArr, int i2, long[] jArr2) {
        Object realAddArr = realAddArr(jArr, i2, jArr2, Long.TYPE);
        if (realAddArr == null) {
            return null;
        }
        return (long[]) realAddArr;
    }

    public static long[] add(long[] jArr, long j2) {
        long[] jArr2 = (long[]) realAddOne(jArr, Long.valueOf(j2), Long.TYPE);
        Objects.requireNonNull(jArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return jArr2;
    }

    public static long[] add(long[] jArr, long[] jArr2) {
        return (long[]) realAddArr(jArr, jArr2);
    }

    public static <T> T[] add(T[] tArr, int i2, T t2) {
        Class<?> cls;
        if (tArr != null) {
            cls = tArr.getClass().getComponentType();
        } else if (t2 != null) {
            cls = t2.getClass();
        } else {
            return (Object[]) new Object[]{null};
        }
        T[] tArr2 = (Object[]) realAdd(tArr, i2, t2, cls);
        Objects.requireNonNull(tArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return tArr2;
    }

    public static <T> T[] add(T[] tArr, int i2, T[] tArr2) {
        Class<?> cls;
        if (tArr != null) {
            cls = tArr.getClass();
        } else if (tArr2 == null) {
            return null;
        } else {
            cls = tArr2.getClass();
        }
        return (Object[]) realAddArr(tArr, i2, tArr2, cls.getComponentType());
    }

    public static <T> T[] add(T[] tArr, T t2) {
        T[] tArr2 = (Object[]) realAddOne(tArr, t2, tArr != null ? tArr.getClass() : t2 != null ? t2.getClass() : Object.class);
        Objects.requireNonNull(tArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return tArr2;
    }

    public static <T> T[] add(T[] tArr, T[] tArr2) {
        return (Object[]) realAddArr(tArr, tArr2);
    }

    public static short[] add(short[] sArr, int i2, short s2) {
        short[] sArr2 = (short[]) realAdd(sArr, i2, Short.valueOf(s2), Short.TYPE);
        Objects.requireNonNull(sArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return sArr2;
    }

    public static short[] add(short[] sArr, int i2, short[] sArr2) {
        Object realAddArr = realAddArr(sArr, i2, sArr2, Short.TYPE);
        if (realAddArr == null) {
            return null;
        }
        return (short[]) realAddArr;
    }

    public static short[] add(short[] sArr, short s2) {
        short[] sArr2 = (short[]) realAddOne(sArr, Short.valueOf(s2), Short.TYPE);
        Objects.requireNonNull(sArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return sArr2;
    }

    public static short[] add(short[] sArr, short[] sArr2) {
        return (short[]) realAddArr(sArr, sArr2);
    }

    public static boolean[] add(boolean[] zArr, int i2, boolean z2) {
        boolean[] zArr2 = (boolean[]) realAdd(zArr, i2, Boolean.valueOf(z2), Boolean.TYPE);
        Objects.requireNonNull(zArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return zArr2;
    }

    public static boolean[] add(boolean[] zArr, int i2, boolean[] zArr2) {
        Object realAddArr = realAddArr(zArr, i2, zArr2, Boolean.TYPE);
        if (realAddArr == null) {
            return null;
        }
        return (boolean[]) realAddArr;
    }

    public static boolean[] add(boolean[] zArr, boolean z2) {
        boolean[] zArr2 = (boolean[]) realAddOne(zArr, Boolean.valueOf(z2), Boolean.TYPE);
        Objects.requireNonNull(zArr2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.add() marked by @androidx.annotation.NonNull");
        return zArr2;
    }

    public static boolean[] add(boolean[] zArr, boolean[] zArr2) {
        return (boolean[]) realAddArr(zArr, zArr2);
    }

    public static <T> List<T> asArrayList(T... tArr) {
        ArrayList arrayList = new ArrayList();
        if (!(tArr == null || tArr.length == 0)) {
            arrayList.addAll(Arrays.asList(tArr));
        }
        return arrayList;
    }

    public static <T> List<T> asLinkedList(T... tArr) {
        LinkedList linkedList = new LinkedList();
        if (!(tArr == null || tArr.length == 0)) {
            linkedList.addAll(Arrays.asList(tArr));
        }
        return linkedList;
    }

    public static <T> List<T> asList(T... tArr) {
        if (tArr == null || tArr.length == 0) {
            List<T> emptyList = Collections.emptyList();
            Objects.requireNonNull(emptyList, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.asList() marked by @androidx.annotation.NonNull");
            return emptyList;
        }
        List<T> asList = Arrays.asList(tArr);
        Objects.requireNonNull(asList, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.asList() marked by @androidx.annotation.NonNull");
        return asList;
    }

    public static <T> List<T> asUnmodifiableList(T... tArr) {
        List<T> unmodifiableList = Collections.unmodifiableList(asList(tArr));
        Objects.requireNonNull(unmodifiableList, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.asUnmodifiableList() marked by @androidx.annotation.NonNull");
        return unmodifiableList;
    }

    public static boolean contains(byte[] bArr, byte b2) {
        return indexOf(bArr, b2) != -1;
    }

    public static boolean contains(char[] cArr, char c2) {
        return indexOf(cArr, c2) != -1;
    }

    public static boolean contains(double[] dArr, double d2) {
        return indexOf(dArr, d2) != -1;
    }

    public static boolean contains(double[] dArr, double d2, double d3) {
        return indexOf(dArr, d2, 0, d3) != -1;
    }

    public static boolean contains(float[] fArr, float f2) {
        return indexOf(fArr, f2) != -1;
    }

    public static boolean contains(int[] iArr, int i2) {
        return indexOf(iArr, i2) != -1;
    }

    public static boolean contains(long[] jArr, long j2) {
        return indexOf(jArr, j2) != -1;
    }

    public static boolean contains(Object[] objArr, Object obj) {
        return indexOf(objArr, obj) != -1;
    }

    public static boolean contains(short[] sArr, short s2) {
        return indexOf(sArr, s2) != -1;
    }

    public static boolean contains(boolean[] zArr, boolean z2) {
        return indexOf(zArr, z2) != -1;
    }

    public static byte[] copy(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return subArray(bArr, 0, bArr.length);
    }

    public static char[] copy(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return subArray(cArr, 0, cArr.length);
    }

    public static double[] copy(double[] dArr) {
        if (dArr == null) {
            return null;
        }
        return subArray(dArr, 0, dArr.length);
    }

    public static float[] copy(float[] fArr) {
        if (fArr == null) {
            return null;
        }
        return subArray(fArr, 0, fArr.length);
    }

    public static int[] copy(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        return subArray(iArr, 0, iArr.length);
    }

    public static long[] copy(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        return subArray(jArr, 0, jArr.length);
    }

    public static <T> T[] copy(T[] tArr) {
        if (tArr == null) {
            return null;
        }
        return subArray(tArr, 0, tArr.length);
    }

    public static short[] copy(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        return subArray(sArr, 0, sArr.length);
    }

    public static boolean[] copy(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        return subArray(zArr, 0, zArr.length);
    }

    public static boolean equals(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    public static boolean equals(char[] cArr, char[] cArr2) {
        return Arrays.equals(cArr, cArr2);
    }

    public static boolean equals(double[] dArr, double[] dArr2) {
        return Arrays.equals(dArr, dArr2);
    }

    public static boolean equals(float[] fArr, float[] fArr2) {
        return Arrays.equals(fArr, fArr2);
    }

    public static boolean equals(int[] iArr, int[] iArr2) {
        return Arrays.equals(iArr, iArr2);
    }

    public static boolean equals(Object[] objArr, Object[] objArr2) {
        return Arrays.deepEquals(objArr, objArr2);
    }

    public static boolean equals(short[] sArr, short[] sArr2) {
        return Arrays.equals(sArr, sArr2);
    }

    public static boolean equals(boolean[] zArr, boolean[] zArr2) {
        return Arrays.equals(zArr, zArr2);
    }

    public static <E> void forAllDo(Object obj, Closure<E> closure) {
        if (obj != null && closure != null) {
            int i2 = 0;
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                int length = objArr.length;
                while (i2 < length) {
                    closure.execute(i2, objArr[i2]);
                    i2++;
                }
            } else if (obj instanceof boolean[]) {
                boolean[] zArr = (boolean[]) obj;
                int length2 = zArr.length;
                while (i2 < length2) {
                    closure.execute(i2, zArr[i2] ? Boolean.TRUE : Boolean.FALSE);
                    i2++;
                }
            } else if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                int length3 = bArr.length;
                while (i2 < length3) {
                    closure.execute(i2, Byte.valueOf(bArr[i2]));
                    i2++;
                }
            } else if (obj instanceof char[]) {
                char[] cArr = (char[]) obj;
                int length4 = cArr.length;
                while (i2 < length4) {
                    closure.execute(i2, Character.valueOf(cArr[i2]));
                    i2++;
                }
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                int length5 = sArr.length;
                while (i2 < length5) {
                    closure.execute(i2, Short.valueOf(sArr[i2]));
                    i2++;
                }
            } else if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                int length6 = iArr.length;
                while (i2 < length6) {
                    closure.execute(i2, Integer.valueOf(iArr[i2]));
                    i2++;
                }
            } else if (obj instanceof long[]) {
                long[] jArr = (long[]) obj;
                int length7 = jArr.length;
                while (i2 < length7) {
                    closure.execute(i2, Long.valueOf(jArr[i2]));
                    i2++;
                }
            } else if (obj instanceof float[]) {
                float[] fArr = (float[]) obj;
                int length8 = fArr.length;
                while (i2 < length8) {
                    closure.execute(i2, Float.valueOf(fArr[i2]));
                    i2++;
                }
            } else if (obj instanceof double[]) {
                double[] dArr = (double[]) obj;
                int length9 = dArr.length;
                while (i2 < length9) {
                    closure.execute(i2, Double.valueOf(dArr[i2]));
                    i2++;
                }
            } else {
                throw new IllegalArgumentException("Not an array: " + obj.getClass());
            }
        }
    }

    public static Object get(Object obj, int i2) {
        return get(obj, i2, (Object) null);
    }

    public static Object get(Object obj, int i2, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        try {
            return Array.get(obj, i2);
        } catch (Exception unused) {
            return obj2;
        }
    }

    public static int getLength(Object obj) {
        if (obj == null) {
            return 0;
        }
        return Array.getLength(obj);
    }

    public static int indexOf(byte[] bArr, byte b2) {
        return indexOf(bArr, b2, 0);
    }

    public static int indexOf(byte[] bArr, byte b2, int i2) {
        if (bArr == null) {
            return -1;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < bArr.length) {
            if (b2 == bArr[i2]) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int indexOf(char[] cArr, char c2) {
        return indexOf(cArr, c2, 0);
    }

    public static int indexOf(char[] cArr, char c2, int i2) {
        if (cArr == null) {
            return -1;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < cArr.length) {
            if (c2 == cArr[i2]) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int indexOf(double[] dArr, double d2) {
        return indexOf(dArr, d2, 0);
    }

    public static int indexOf(double[] dArr, double d2, double d3) {
        return indexOf(dArr, d2, 0, d3);
    }

    public static int indexOf(double[] dArr, double d2, int i2) {
        if (isEmpty(dArr)) {
            return -1;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < dArr.length) {
            if (d2 == dArr[i2]) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int indexOf(double[] dArr, double d2, int i2, double d3) {
        if (isEmpty(dArr)) {
            return -1;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        double d4 = d2 - d3;
        double d5 = d2 + d3;
        while (i2 < dArr.length) {
            if (dArr[i2] >= d4 && dArr[i2] <= d5) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int indexOf(float[] fArr, float f2) {
        return indexOf(fArr, f2, 0);
    }

    public static int indexOf(float[] fArr, float f2, int i2) {
        if (isEmpty(fArr)) {
            return -1;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < fArr.length) {
            if (f2 == fArr[i2]) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int indexOf(int[] iArr, int i2) {
        return indexOf(iArr, i2, 0);
    }

    public static int indexOf(int[] iArr, int i2, int i3) {
        if (iArr == null) {
            return -1;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        while (i3 < iArr.length) {
            if (i2 == iArr[i3]) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    public static int indexOf(long[] jArr, long j2) {
        return indexOf(jArr, j2, 0);
    }

    public static int indexOf(long[] jArr, long j2, int i2) {
        if (jArr == null) {
            return -1;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < jArr.length) {
            if (j2 == jArr[i2]) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int indexOf(Object[] objArr, Object obj) {
        return indexOf(objArr, obj, 0);
    }

    public static int indexOf(Object[] objArr, Object obj, int i2) {
        if (objArr == null) {
            return -1;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (obj == null) {
            while (i2 < objArr.length) {
                if (objArr[i2] == null) {
                    return i2;
                }
                i2++;
            }
        } else {
            while (i2 < objArr.length) {
                if (obj.equals(objArr[i2])) {
                    return i2;
                }
                i2++;
            }
        }
        return -1;
    }

    public static int indexOf(short[] sArr, short s2) {
        return indexOf(sArr, s2, 0);
    }

    public static int indexOf(short[] sArr, short s2, int i2) {
        if (sArr == null) {
            return -1;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < sArr.length) {
            if (s2 == sArr[i2]) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int indexOf(boolean[] zArr, boolean z2) {
        return indexOf(zArr, z2, 0);
    }

    public static int indexOf(boolean[] zArr, boolean z2, int i2) {
        if (isEmpty(zArr)) {
            return -1;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        while (i2 < zArr.length) {
            if (z2 == zArr[i2]) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static boolean isEmpty(Object obj) {
        return getLength(obj) == 0;
    }

    public static boolean isSameLength(Object obj, Object obj2) {
        return getLength(obj) == getLength(obj2);
    }

    public static int lastIndexOf(byte[] bArr, byte b2) {
        return lastIndexOf(bArr, b2, (int) SubsamplingScaleImageView.TILE_SIZE_AUTO);
    }

    public static int lastIndexOf(byte[] bArr, byte b2, int i2) {
        if (bArr == null || i2 < 0) {
            return -1;
        }
        if (i2 >= bArr.length) {
            i2 = bArr.length - 1;
        }
        while (i2 >= 0) {
            if (b2 == bArr[i2]) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public static int lastIndexOf(char[] cArr, char c2) {
        return lastIndexOf(cArr, c2, (int) SubsamplingScaleImageView.TILE_SIZE_AUTO);
    }

    public static int lastIndexOf(char[] cArr, char c2, int i2) {
        if (cArr == null || i2 < 0) {
            return -1;
        }
        if (i2 >= cArr.length) {
            i2 = cArr.length - 1;
        }
        while (i2 >= 0) {
            if (c2 == cArr[i2]) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public static int lastIndexOf(double[] dArr, double d2) {
        return lastIndexOf(dArr, d2, (int) SubsamplingScaleImageView.TILE_SIZE_AUTO);
    }

    public static int lastIndexOf(double[] dArr, double d2, double d3) {
        return lastIndexOf(dArr, d2, SubsamplingScaleImageView.TILE_SIZE_AUTO, d3);
    }

    public static int lastIndexOf(double[] dArr, double d2, int i2) {
        if (isEmpty(dArr) || i2 < 0) {
            return -1;
        }
        if (i2 >= dArr.length) {
            i2 = dArr.length - 1;
        }
        while (i2 >= 0) {
            if (d2 == dArr[i2]) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public static int lastIndexOf(double[] dArr, double d2, int i2, double d3) {
        if (isEmpty(dArr) || i2 < 0) {
            return -1;
        }
        if (i2 >= dArr.length) {
            i2 = dArr.length - 1;
        }
        double d4 = d2 - d3;
        double d5 = d2 + d3;
        while (i2 >= 0) {
            if (dArr[i2] >= d4 && dArr[i2] <= d5) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public static int lastIndexOf(float[] fArr, float f2) {
        return lastIndexOf(fArr, f2, (int) SubsamplingScaleImageView.TILE_SIZE_AUTO);
    }

    public static int lastIndexOf(float[] fArr, float f2, int i2) {
        if (isEmpty(fArr) || i2 < 0) {
            return -1;
        }
        if (i2 >= fArr.length) {
            i2 = fArr.length - 1;
        }
        while (i2 >= 0) {
            if (f2 == fArr[i2]) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public static int lastIndexOf(int[] iArr, int i2) {
        return lastIndexOf(iArr, i2, (int) SubsamplingScaleImageView.TILE_SIZE_AUTO);
    }

    public static int lastIndexOf(int[] iArr, int i2, int i3) {
        if (iArr == null || i3 < 0) {
            return -1;
        }
        if (i3 >= iArr.length) {
            i3 = iArr.length - 1;
        }
        while (i3 >= 0) {
            if (i2 == iArr[i3]) {
                return i3;
            }
            i3--;
        }
        return -1;
    }

    public static int lastIndexOf(long[] jArr, long j2) {
        return lastIndexOf(jArr, j2, (int) SubsamplingScaleImageView.TILE_SIZE_AUTO);
    }

    public static int lastIndexOf(long[] jArr, long j2, int i2) {
        if (jArr == null || i2 < 0) {
            return -1;
        }
        if (i2 >= jArr.length) {
            i2 = jArr.length - 1;
        }
        while (i2 >= 0) {
            if (j2 == jArr[i2]) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public static int lastIndexOf(Object[] objArr, Object obj) {
        return lastIndexOf(objArr, obj, (int) SubsamplingScaleImageView.TILE_SIZE_AUTO);
    }

    public static int lastIndexOf(Object[] objArr, Object obj, int i2) {
        if (objArr == null || i2 < 0) {
            return -1;
        }
        if (i2 >= objArr.length) {
            i2 = objArr.length - 1;
        }
        if (obj == null) {
            while (i2 >= 0) {
                if (objArr[i2] == null) {
                    return i2;
                }
                i2--;
            }
        } else {
            while (i2 >= 0) {
                if (obj.equals(objArr[i2])) {
                    return i2;
                }
                i2--;
            }
        }
        return -1;
    }

    public static int lastIndexOf(short[] sArr, short s2) {
        return lastIndexOf(sArr, s2, (int) SubsamplingScaleImageView.TILE_SIZE_AUTO);
    }

    public static int lastIndexOf(short[] sArr, short s2, int i2) {
        if (sArr == null || i2 < 0) {
            return -1;
        }
        if (i2 >= sArr.length) {
            i2 = sArr.length - 1;
        }
        while (i2 >= 0) {
            if (s2 == sArr[i2]) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public static int lastIndexOf(boolean[] zArr, boolean z2) {
        return lastIndexOf(zArr, z2, (int) SubsamplingScaleImageView.TILE_SIZE_AUTO);
    }

    public static int lastIndexOf(boolean[] zArr, boolean z2, int i2) {
        if (isEmpty(zArr) || i2 < 0) {
            return -1;
        }
        if (i2 >= zArr.length) {
            i2 = zArr.length - 1;
        }
        while (i2 >= 0) {
            if (z2 == zArr[i2]) {
                return i2;
            }
            i2--;
        }
        return -1;
    }

    public static <T> T[] newArray(T... tArr) {
        Objects.requireNonNull(tArr, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.newArray() marked by @androidx.annotation.NonNull");
        return tArr;
    }

    public static boolean[] newBooleanArray(boolean... zArr) {
        Objects.requireNonNull(zArr, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.newBooleanArray() marked by @androidx.annotation.NonNull");
        return zArr;
    }

    public static byte[] newByteArray(byte... bArr) {
        Objects.requireNonNull(bArr, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.newByteArray() marked by @androidx.annotation.NonNull");
        return bArr;
    }

    public static char[] newCharArray(char... cArr) {
        Objects.requireNonNull(cArr, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.newCharArray() marked by @androidx.annotation.NonNull");
        return cArr;
    }

    public static double[] newDoubleArray(double... dArr) {
        Objects.requireNonNull(dArr, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.newDoubleArray() marked by @androidx.annotation.NonNull");
        return dArr;
    }

    public static float[] newFloatArray(float... fArr) {
        Objects.requireNonNull(fArr, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.newFloatArray() marked by @androidx.annotation.NonNull");
        return fArr;
    }

    public static int[] newIntArray(int... iArr) {
        Objects.requireNonNull(iArr, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.newIntArray() marked by @androidx.annotation.NonNull");
        return iArr;
    }

    public static long[] newLongArray(long... jArr) {
        Objects.requireNonNull(jArr, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.newLongArray() marked by @androidx.annotation.NonNull");
        return jArr;
    }

    public static short[] newShortArray(short... sArr) {
        Objects.requireNonNull(sArr, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.newShortArray() marked by @androidx.annotation.NonNull");
        return sArr;
    }

    private static Object realAdd(Object obj, int i2, Object obj2, Class cls) {
        if (obj != null) {
            int length = Array.getLength(obj);
            if (i2 > length || i2 < 0) {
                throw new IndexOutOfBoundsException("Index: " + i2 + ", Length: " + length);
            }
            Object newInstance = Array.newInstance(cls, length + 1);
            System.arraycopy(obj, 0, newInstance, 0, i2);
            Array.set(newInstance, i2, obj2);
            if (i2 < length) {
                System.arraycopy(obj, i2, newInstance, i2 + 1, length - i2);
            }
            Objects.requireNonNull(newInstance, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.realAdd() marked by @androidx.annotation.NonNull");
            return newInstance;
        } else if (i2 == 0) {
            Object newInstance2 = Array.newInstance(cls, 1);
            Array.set(newInstance2, 0, obj2);
            Objects.requireNonNull(newInstance2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.realAdd() marked by @androidx.annotation.NonNull");
            return newInstance2;
        } else {
            throw new IndexOutOfBoundsException("Index: " + i2 + ", Length: 0");
        }
    }

    private static Object realAddArr(Object obj, int i2, Object obj2, Class cls) {
        if (obj == null && obj2 == null) {
            return null;
        }
        int length = getLength(obj);
        int length2 = getLength(obj2);
        if (length == 0) {
            if (i2 == 0) {
                return realCopy(obj2);
            }
            throw new IndexOutOfBoundsException("Index: " + i2 + ", array1 Length: 0");
        } else if (length2 == 0) {
            return realCopy(obj);
        } else {
            if (i2 > length || i2 < 0) {
                throw new IndexOutOfBoundsException("Index: " + i2 + ", array1 Length: " + length);
            }
            Object newInstance = Array.newInstance(obj.getClass().getComponentType(), length + length2);
            if (i2 == length) {
                System.arraycopy(obj, 0, newInstance, 0, length);
                System.arraycopy(obj2, 0, newInstance, length, length2);
            } else if (i2 == 0) {
                System.arraycopy(obj2, 0, newInstance, 0, length2);
                System.arraycopy(obj, 0, newInstance, length2, length);
            } else {
                System.arraycopy(obj, 0, newInstance, 0, i2);
                System.arraycopy(obj2, 0, newInstance, i2, length2);
                System.arraycopy(obj, i2, newInstance, length2 + i2, length - i2);
            }
            return newInstance;
        }
    }

    private static Object realAddArr(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return null;
        }
        if (obj == null) {
            return realCopy(obj2);
        }
        if (obj2 == null) {
            return realCopy(obj);
        }
        int length = getLength(obj);
        int length2 = getLength(obj2);
        Object newInstance = Array.newInstance(obj.getClass().getComponentType(), length + length2);
        System.arraycopy(obj, 0, newInstance, 0, length);
        System.arraycopy(obj2, 0, newInstance, length, length2);
        return newInstance;
    }

    private static Object realAddOne(Object obj, Object obj2, Class cls) {
        Object obj3;
        int i2 = 0;
        if (obj != null) {
            int length = getLength(obj);
            obj3 = Array.newInstance(obj.getClass().getComponentType(), length + 1);
            System.arraycopy(obj, 0, obj3, 0, length);
            i2 = length;
        } else {
            obj3 = Array.newInstance(cls, 1);
        }
        Array.set(obj3, i2, obj2);
        Objects.requireNonNull(obj3, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.realAddOne() marked by @androidx.annotation.NonNull");
        return obj3;
    }

    private static Object realCopy(Object obj) {
        if (obj == null) {
            return null;
        }
        return realSubArray(obj, 0, getLength(obj));
    }

    private static Object realSubArray(Object obj, int i2, int i3) {
        if (obj == null) {
            return null;
        }
        if (i2 < 0) {
            i2 = 0;
        }
        int length = getLength(obj);
        if (i3 > length) {
            i3 = length;
        }
        int i4 = i3 - i2;
        Class<?> componentType = obj.getClass().getComponentType();
        if (i4 <= 0) {
            return Array.newInstance(componentType, 0);
        }
        Object newInstance = Array.newInstance(componentType, i4);
        System.arraycopy(obj, i2, newInstance, 0, i4);
        return newInstance;
    }

    private static Object remove(Object obj, int i2) {
        Objects.requireNonNull(obj, "Argument 'array' of type Object (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        int length = getLength(obj);
        if (i2 < 0 || i2 >= length) {
            throw new IndexOutOfBoundsException("Index: " + i2 + ", Length: " + length);
        }
        int i3 = length - 1;
        Object newInstance = Array.newInstance(obj.getClass().getComponentType(), i3);
        System.arraycopy(obj, 0, newInstance, 0, i2);
        if (i2 < i3) {
            System.arraycopy(obj, i2 + 1, newInstance, i2, (length - i2) - 1);
        }
        Objects.requireNonNull(newInstance, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.remove() marked by @androidx.annotation.NonNull");
        return newInstance;
    }

    public static byte[] remove(byte[] bArr, int i2) {
        if (bArr == null) {
            return null;
        }
        return (byte[]) remove((Object) bArr, i2);
    }

    public static char[] remove(char[] cArr, int i2) {
        if (cArr == null) {
            return null;
        }
        return (char[]) remove((Object) cArr, i2);
    }

    public static double[] remove(double[] dArr, int i2) {
        if (dArr == null) {
            return null;
        }
        return (double[]) remove((Object) dArr, i2);
    }

    public static float[] remove(float[] fArr, int i2) {
        if (fArr == null) {
            return null;
        }
        return (float[]) remove((Object) fArr, i2);
    }

    public static int[] remove(int[] iArr, int i2) {
        if (iArr == null) {
            return null;
        }
        return (int[]) remove((Object) iArr, i2);
    }

    public static long[] remove(long[] jArr, int i2) {
        if (jArr == null) {
            return null;
        }
        return (long[]) remove((Object) jArr, i2);
    }

    public static Object[] remove(Object[] objArr, int i2) {
        if (objArr == null) {
            return null;
        }
        return (Object[]) remove((Object) objArr, i2);
    }

    public static short[] remove(short[] sArr, int i2) {
        if (sArr == null) {
            return null;
        }
        return (short[]) remove((Object) sArr, i2);
    }

    public static boolean[] remove(boolean[] zArr, int i2) {
        if (zArr == null) {
            return null;
        }
        return (boolean[]) remove((Object) zArr, i2);
    }

    public static byte[] removeElement(byte[] bArr, byte b2) {
        int indexOf = indexOf(bArr, b2);
        return indexOf == -1 ? copy(bArr) : remove(bArr, indexOf);
    }

    public static char[] removeElement(char[] cArr, char c2) {
        int indexOf = indexOf(cArr, c2);
        return indexOf == -1 ? copy(cArr) : remove(cArr, indexOf);
    }

    public static double[] removeElement(double[] dArr, double d2) {
        int indexOf = indexOf(dArr, d2);
        return indexOf == -1 ? copy(dArr) : remove(dArr, indexOf);
    }

    public static float[] removeElement(float[] fArr, float f2) {
        int indexOf = indexOf(fArr, f2);
        return indexOf == -1 ? copy(fArr) : remove(fArr, indexOf);
    }

    public static int[] removeElement(int[] iArr, int i2) {
        int indexOf = indexOf(iArr, i2);
        return indexOf == -1 ? copy(iArr) : remove(iArr, indexOf);
    }

    public static long[] removeElement(long[] jArr, long j2) {
        int indexOf = indexOf(jArr, j2);
        return indexOf == -1 ? copy(jArr) : remove(jArr, indexOf);
    }

    public static Object[] removeElement(Object[] objArr, Object obj) {
        int indexOf = indexOf(objArr, obj);
        return indexOf == -1 ? copy((T[]) objArr) : remove(objArr, indexOf);
    }

    public static short[] removeElement(short[] sArr, short s2) {
        int indexOf = indexOf(sArr, s2);
        return indexOf == -1 ? copy(sArr) : remove(sArr, indexOf);
    }

    public static boolean[] removeElement(boolean[] zArr, boolean z2) {
        int indexOf = indexOf(zArr, z2);
        return indexOf == -1 ? copy(zArr) : remove(zArr, indexOf);
    }

    public static void reverse(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length - 1;
            for (int i2 = 0; length > i2; i2++) {
                byte b2 = bArr[length];
                bArr[length] = bArr[i2];
                bArr[i2] = b2;
                length--;
            }
        }
    }

    public static void reverse(char[] cArr) {
        if (cArr != null) {
            int length = cArr.length - 1;
            for (int i2 = 0; length > i2; i2++) {
                char c2 = cArr[length];
                cArr[length] = cArr[i2];
                cArr[i2] = c2;
                length--;
            }
        }
    }

    public static void reverse(double[] dArr) {
        if (dArr != null) {
            int length = dArr.length - 1;
            for (int i2 = 0; length > i2; i2++) {
                double d2 = dArr[length];
                dArr[length] = dArr[i2];
                dArr[i2] = d2;
                length--;
            }
        }
    }

    public static void reverse(float[] fArr) {
        if (fArr != null) {
            int length = fArr.length - 1;
            for (int i2 = 0; length > i2; i2++) {
                float f2 = fArr[length];
                fArr[length] = fArr[i2];
                fArr[i2] = f2;
                length--;
            }
        }
    }

    public static void reverse(int[] iArr) {
        if (iArr != null) {
            int length = iArr.length - 1;
            for (int i2 = 0; length > i2; i2++) {
                int i3 = iArr[length];
                iArr[length] = iArr[i2];
                iArr[i2] = i3;
                length--;
            }
        }
    }

    public static void reverse(long[] jArr) {
        if (jArr != null) {
            int length = jArr.length - 1;
            for (int i2 = 0; length > i2; i2++) {
                long j2 = jArr[length];
                jArr[length] = jArr[i2];
                jArr[i2] = j2;
                length--;
            }
        }
    }

    public static <T> void reverse(T[] tArr) {
        if (tArr != null) {
            int length = tArr.length - 1;
            for (int i2 = 0; length > i2; i2++) {
                T t2 = tArr[length];
                tArr[length] = tArr[i2];
                tArr[i2] = t2;
                length--;
            }
        }
    }

    public static void reverse(short[] sArr) {
        if (sArr != null) {
            int length = sArr.length - 1;
            for (int i2 = 0; length > i2; i2++) {
                short s2 = sArr[length];
                sArr[length] = sArr[i2];
                sArr[i2] = s2;
                length--;
            }
        }
    }

    public static void reverse(boolean[] zArr) {
        if (zArr != null) {
            int length = zArr.length - 1;
            for (int i2 = 0; length > i2; i2++) {
                boolean z2 = zArr[length];
                zArr[length] = zArr[i2];
                zArr[i2] = z2;
                length--;
            }
        }
    }

    public static void set(Object obj, int i2, Object obj2) {
        if (obj != null) {
            Array.set(obj, i2, obj2);
        }
    }

    public static void sort(byte[] bArr) {
        if (bArr != null && bArr.length >= 2) {
            Arrays.sort(bArr);
        }
    }

    public static void sort(char[] cArr) {
        if (cArr != null && cArr.length >= 2) {
            Arrays.sort(cArr);
        }
    }

    public static void sort(double[] dArr) {
        if (dArr != null && dArr.length >= 2) {
            Arrays.sort(dArr);
        }
    }

    public static void sort(float[] fArr) {
        if (fArr != null && fArr.length >= 2) {
            Arrays.sort(fArr);
        }
    }

    public static void sort(int[] iArr) {
        if (iArr != null && iArr.length >= 2) {
            Arrays.sort(iArr);
        }
    }

    public static void sort(long[] jArr) {
        if (jArr != null && jArr.length >= 2) {
            Arrays.sort(jArr);
        }
    }

    public static <T> void sort(T[] tArr, Comparator<? super T> comparator) {
        if (tArr != null && tArr.length >= 2) {
            Arrays.sort(tArr, comparator);
        }
    }

    public static void sort(short[] sArr) {
        if (sArr != null && sArr.length >= 2) {
            Arrays.sort(sArr);
        }
    }

    public static byte[] subArray(byte[] bArr, int i2, int i3) {
        return (byte[]) realSubArray(bArr, i2, i3);
    }

    public static char[] subArray(char[] cArr, int i2, int i3) {
        return (char[]) realSubArray(cArr, i2, i3);
    }

    public static double[] subArray(double[] dArr, int i2, int i3) {
        return (double[]) realSubArray(dArr, i2, i3);
    }

    public static float[] subArray(float[] fArr, int i2, int i3) {
        return (float[]) realSubArray(fArr, i2, i3);
    }

    public static int[] subArray(int[] iArr, int i2, int i3) {
        return (int[]) realSubArray(iArr, i2, i3);
    }

    public static long[] subArray(long[] jArr, int i2, int i3) {
        return (long[]) realSubArray(jArr, i2, i3);
    }

    public static <T> T[] subArray(T[] tArr, int i2, int i3) {
        return (Object[]) realSubArray(tArr, i2, i3);
    }

    public static short[] subArray(short[] sArr, int i2, int i3) {
        return (short[]) realSubArray(sArr, i2, i3);
    }

    public static boolean[] subArray(boolean[] zArr, int i2, int i3) {
        return (boolean[]) realSubArray(zArr, i2, i3);
    }

    public static Boolean[] toObject(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        if (zArr.length == 0) {
            return new Boolean[0];
        }
        Boolean[] boolArr = new Boolean[zArr.length];
        for (int i2 = 0; i2 < zArr.length; i2++) {
            boolArr[i2] = zArr[i2] ? Boolean.TRUE : Boolean.FALSE;
        }
        return boolArr;
    }

    public static Byte[] toObject(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return new Byte[0];
        }
        Byte[] bArr2 = new Byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = new Byte(bArr[i2]);
        }
        return bArr2;
    }

    public static Character[] toObject(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        if (cArr.length == 0) {
            return new Character[0];
        }
        Character[] chArr = new Character[cArr.length];
        for (int i2 = 0; i2 < cArr.length; i2++) {
            chArr[i2] = new Character(cArr[i2]);
        }
        return chArr;
    }

    public static Double[] toObject(double[] dArr) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return new Double[0];
        }
        Double[] dArr2 = new Double[dArr.length];
        for (int i2 = 0; i2 < dArr.length; i2++) {
            dArr2[i2] = new Double(dArr[i2]);
        }
        return dArr2;
    }

    public static Float[] toObject(float[] fArr) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return new Float[0];
        }
        Float[] fArr2 = new Float[fArr.length];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr2[i2] = new Float(fArr[i2]);
        }
        return fArr2;
    }

    public static Integer[] toObject(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        if (iArr.length == 0) {
            return new Integer[0];
        }
        Integer[] numArr = new Integer[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            numArr[i2] = new Integer(iArr[i2]);
        }
        return numArr;
    }

    public static Long[] toObject(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        if (jArr.length == 0) {
            return new Long[0];
        }
        Long[] lArr = new Long[jArr.length];
        for (int i2 = 0; i2 < jArr.length; i2++) {
            lArr[i2] = new Long(jArr[i2]);
        }
        return lArr;
    }

    public static Short[] toObject(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        if (sArr.length == 0) {
            return new Short[0];
        }
        Short[] shArr = new Short[sArr.length];
        for (int i2 = 0; i2 < sArr.length; i2++) {
            shArr[i2] = new Short(sArr[i2]);
        }
        return shArr;
    }

    public static byte[] toPrimitive(Byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = bArr[i2].byteValue();
        }
        return bArr2;
    }

    public static byte[] toPrimitive(Byte[] bArr, byte b2) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            Byte b3 = bArr[i2];
            bArr2[i2] = b3 == null ? b2 : b3.byteValue();
        }
        return bArr2;
    }

    public static char[] toPrimitive(Character[] chArr) {
        if (chArr == null) {
            return null;
        }
        if (chArr.length == 0) {
            return new char[0];
        }
        char[] cArr = new char[chArr.length];
        for (int i2 = 0; i2 < chArr.length; i2++) {
            cArr[i2] = chArr[i2].charValue();
        }
        return cArr;
    }

    public static char[] toPrimitive(Character[] chArr, char c2) {
        if (chArr == null) {
            return null;
        }
        if (chArr.length == 0) {
            return new char[0];
        }
        char[] cArr = new char[chArr.length];
        for (int i2 = 0; i2 < chArr.length; i2++) {
            Character ch2 = chArr[i2];
            cArr[i2] = ch2 == null ? c2 : ch2.charValue();
        }
        return cArr;
    }

    public static double[] toPrimitive(Double[] dArr) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return new double[0];
        }
        double[] dArr2 = new double[dArr.length];
        for (int i2 = 0; i2 < dArr.length; i2++) {
            dArr2[i2] = dArr[i2].doubleValue();
        }
        return dArr2;
    }

    public static double[] toPrimitive(Double[] dArr, double d2) {
        if (dArr == null) {
            return null;
        }
        if (dArr.length == 0) {
            return new double[0];
        }
        double[] dArr2 = new double[dArr.length];
        for (int i2 = 0; i2 < dArr.length; i2++) {
            Double d3 = dArr[i2];
            dArr2[i2] = d3 == null ? d2 : d3.doubleValue();
        }
        return dArr2;
    }

    public static float[] toPrimitive(Float[] fArr) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return new float[0];
        }
        float[] fArr2 = new float[fArr.length];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr2[i2] = fArr[i2].floatValue();
        }
        return fArr2;
    }

    public static float[] toPrimitive(Float[] fArr, float f2) {
        if (fArr == null) {
            return null;
        }
        if (fArr.length == 0) {
            return new float[0];
        }
        float[] fArr2 = new float[fArr.length];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            Float f3 = fArr[i2];
            fArr2[i2] = f3 == null ? f2 : f3.floatValue();
        }
        return fArr2;
    }

    public static int[] toPrimitive(Integer[] numArr) {
        if (numArr == null) {
            return null;
        }
        if (numArr.length == 0) {
            return new int[0];
        }
        int[] iArr = new int[numArr.length];
        for (int i2 = 0; i2 < numArr.length; i2++) {
            iArr[i2] = numArr[i2].intValue();
        }
        return iArr;
    }

    public static int[] toPrimitive(Integer[] numArr, int i2) {
        if (numArr == null) {
            return null;
        }
        if (numArr.length == 0) {
            return new int[0];
        }
        int[] iArr = new int[numArr.length];
        for (int i3 = 0; i3 < numArr.length; i3++) {
            Integer num = numArr[i3];
            iArr[i3] = num == null ? i2 : num.intValue();
        }
        return iArr;
    }

    public static long[] toPrimitive(Long[] lArr) {
        if (lArr == null) {
            return null;
        }
        if (lArr.length == 0) {
            return new long[0];
        }
        long[] jArr = new long[lArr.length];
        for (int i2 = 0; i2 < lArr.length; i2++) {
            jArr[i2] = lArr[i2].longValue();
        }
        return jArr;
    }

    public static long[] toPrimitive(Long[] lArr, long j2) {
        if (lArr == null) {
            return null;
        }
        if (lArr.length == 0) {
            return new long[0];
        }
        long[] jArr = new long[lArr.length];
        for (int i2 = 0; i2 < lArr.length; i2++) {
            Long l2 = lArr[i2];
            jArr[i2] = l2 == null ? j2 : l2.longValue();
        }
        return jArr;
    }

    public static short[] toPrimitive(Short[] shArr) {
        if (shArr == null) {
            return null;
        }
        if (shArr.length == 0) {
            return new short[0];
        }
        short[] sArr = new short[shArr.length];
        for (int i2 = 0; i2 < shArr.length; i2++) {
            sArr[i2] = shArr[i2].shortValue();
        }
        return sArr;
    }

    public static short[] toPrimitive(Short[] shArr, short s2) {
        if (shArr == null) {
            return null;
        }
        if (shArr.length == 0) {
            return new short[0];
        }
        short[] sArr = new short[shArr.length];
        for (int i2 = 0; i2 < shArr.length; i2++) {
            Short sh = shArr[i2];
            sArr[i2] = sh == null ? s2 : sh.shortValue();
        }
        return sArr;
    }

    public static boolean[] toPrimitive(Boolean[] boolArr) {
        if (boolArr == null) {
            return null;
        }
        if (boolArr.length == 0) {
            return new boolean[0];
        }
        boolean[] zArr = new boolean[boolArr.length];
        for (int i2 = 0; i2 < boolArr.length; i2++) {
            zArr[i2] = boolArr[i2].booleanValue();
        }
        return zArr;
    }

    public static boolean[] toPrimitive(Boolean[] boolArr, boolean z2) {
        if (boolArr == null) {
            return null;
        }
        if (boolArr.length == 0) {
            return new boolean[0];
        }
        boolean[] zArr = new boolean[boolArr.length];
        for (int i2 = 0; i2 < boolArr.length; i2++) {
            Boolean bool = boolArr[i2];
            zArr[i2] = bool == null ? z2 : bool.booleanValue();
        }
        return zArr;
    }

    public static String toString(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (obj instanceof Object[]) {
            String deepToString = Arrays.deepToString((Object[]) obj);
            Objects.requireNonNull(deepToString, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.toString() marked by @androidx.annotation.NonNull");
            return deepToString;
        } else if (obj instanceof boolean[]) {
            String arrays = Arrays.toString((boolean[]) obj);
            Objects.requireNonNull(arrays, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.toString() marked by @androidx.annotation.NonNull");
            return arrays;
        } else if (obj instanceof byte[]) {
            String arrays2 = Arrays.toString((byte[]) obj);
            Objects.requireNonNull(arrays2, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.toString() marked by @androidx.annotation.NonNull");
            return arrays2;
        } else if (obj instanceof char[]) {
            String arrays3 = Arrays.toString((char[]) obj);
            Objects.requireNonNull(arrays3, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.toString() marked by @androidx.annotation.NonNull");
            return arrays3;
        } else if (obj instanceof double[]) {
            String arrays4 = Arrays.toString((double[]) obj);
            Objects.requireNonNull(arrays4, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.toString() marked by @androidx.annotation.NonNull");
            return arrays4;
        } else if (obj instanceof float[]) {
            String arrays5 = Arrays.toString((float[]) obj);
            Objects.requireNonNull(arrays5, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.toString() marked by @androidx.annotation.NonNull");
            return arrays5;
        } else if (obj instanceof int[]) {
            String arrays6 = Arrays.toString((int[]) obj);
            Objects.requireNonNull(arrays6, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.toString() marked by @androidx.annotation.NonNull");
            return arrays6;
        } else if (obj instanceof long[]) {
            String arrays7 = Arrays.toString((long[]) obj);
            Objects.requireNonNull(arrays7, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.toString() marked by @androidx.annotation.NonNull");
            return arrays7;
        } else if (obj instanceof short[]) {
            String arrays8 = Arrays.toString((short[]) obj);
            Objects.requireNonNull(arrays8, "Detected an attempt to return null from a method com.blankj.utilcode.util.ArrayUtils.toString() marked by @androidx.annotation.NonNull");
            return arrays8;
        } else {
            throw new IllegalArgumentException("Array has incompatible type: " + obj.getClass());
        }
    }
}
