package s;

import com.blankj.utilcode.constant.CacheConstants;
import java.io.PrintWriter;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f34399a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static char[] f34400b = new char[24];

    private static int a(int i2, int i3, boolean z2, int i4) {
        if (i2 > 99 || (z2 && i4 >= 3)) {
            return i3 + 3;
        }
        if (i2 > 9 || (z2 && i4 >= 2)) {
            return i3 + 2;
        }
        if (z2 || i2 > 0) {
            return i3 + 1;
        }
        return 0;
    }

    private static int a(long j2, int i2) {
        char c2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        long j3 = j2;
        int i8 = i2;
        if (f34400b.length < i8) {
            f34400b = new char[i8];
        }
        char[] cArr = f34400b;
        if (j3 == 0) {
            int i9 = i8 - 1;
            while (i9 > 0) {
                cArr[0] = ' ';
            }
            cArr[0] = '0';
            return 1;
        }
        if (j3 > 0) {
            c2 = '+';
        } else {
            c2 = '-';
            j3 = -j3;
        }
        int i10 = (int) (j3 % 1000);
        int floor = (int) Math.floor((double) (j3 / 1000));
        if (floor > 86400) {
            i3 = floor / CacheConstants.DAY;
            floor -= CacheConstants.DAY * i3;
        } else {
            i3 = 0;
        }
        if (floor > 3600) {
            i4 = floor / CacheConstants.HOUR;
            floor -= i4 * CacheConstants.HOUR;
        } else {
            i4 = 0;
        }
        if (floor > 60) {
            int i11 = floor / 60;
            i5 = floor - (i11 * 60);
            i6 = i11;
        } else {
            i5 = floor;
            i6 = 0;
        }
        if (i8 != 0) {
            int a2 = a(i3, 1, false, 0);
            int a3 = a2 + a(i4, 1, a2 > 0, 2);
            int a4 = a3 + a(i6, 1, a3 > 0, 2);
            int a5 = a4 + a(i5, 1, a4 > 0, 2);
            i7 = 0;
            for (int a6 = a5 + a(i10, 2, true, a5 > 0 ? 3 : 0) + 1; a6 < i8; a6++) {
                cArr[i7] = ' ';
                i7++;
            }
        } else {
            i7 = 0;
        }
        cArr[i7] = c2;
        int i12 = i7 + 1;
        boolean z2 = i8 != 0;
        int i13 = i12;
        int a7 = a(cArr, i3, 'd', i12, false, 0);
        int a8 = a(cArr, i4, 'h', a7, a7 != i13, z2 ? 2 : 0);
        int a9 = a(cArr, i6, 'm', a8, a8 != i13, z2 ? 2 : 0);
        int a10 = a(cArr, i5, 's', a9, a9 != i13, z2 ? 2 : 0);
        int a11 = a(cArr, i10, 'm', a10, true, (!z2 || a10 == i13) ? 0 : 3);
        cArr[a11] = 's';
        return a11 + 1;
    }

    private static int a(char[] cArr, int i2, char c2, int i3, boolean z2, int i4) {
        int i5;
        if (!z2 && i2 <= 0) {
            return i3;
        }
        if ((!z2 || i4 < 3) && i2 <= 99) {
            i5 = i3;
        } else {
            int i6 = i2 / 100;
            cArr[i3] = (char) (i6 + 48);
            i5 = i3 + 1;
            i2 -= i6 * 100;
        }
        if ((z2 && i4 >= 2) || i2 > 9 || i3 != i5) {
            int i7 = i2 / 10;
            cArr[i5] = (char) (i7 + 48);
            i5++;
            i2 -= i7 * 10;
        }
        cArr[i5] = (char) (i2 + 48);
        int i8 = i5 + 1;
        cArr[i8] = c2;
        return i8 + 1;
    }

    public static void a(long j2, long j3, PrintWriter printWriter) {
        if (j2 == 0) {
            printWriter.print("--");
        } else {
            a(j2 - j3, printWriter, 0);
        }
    }

    public static void a(long j2, PrintWriter printWriter) {
        a(j2, printWriter, 0);
    }

    public static void a(long j2, PrintWriter printWriter, int i2) {
        synchronized (f34399a) {
            printWriter.print(new String(f34400b, 0, a(j2, i2)));
        }
    }
}
