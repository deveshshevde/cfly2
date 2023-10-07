package org.opencv.core;

public final class a {
    public static final int A = g(3);
    public static final int B = g(4);
    public static final int C = h(1);
    public static final int D = h(2);
    public static final int E = h(3);
    public static final int F = h(4);

    /* renamed from: a  reason: collision with root package name */
    public static final int f34062a = a(1);

    /* renamed from: b  reason: collision with root package name */
    public static final int f34063b = a(2);

    /* renamed from: c  reason: collision with root package name */
    public static final int f34064c = a(3);

    /* renamed from: d  reason: collision with root package name */
    public static final int f34065d = a(4);

    /* renamed from: e  reason: collision with root package name */
    public static final int f34066e = b(1);

    /* renamed from: f  reason: collision with root package name */
    public static final int f34067f = b(2);

    /* renamed from: g  reason: collision with root package name */
    public static final int f34068g = b(3);

    /* renamed from: h  reason: collision with root package name */
    public static final int f34069h = b(4);

    /* renamed from: i  reason: collision with root package name */
    public static final int f34070i = c(1);

    /* renamed from: j  reason: collision with root package name */
    public static final int f34071j = c(2);

    /* renamed from: k  reason: collision with root package name */
    public static final int f34072k = c(3);

    /* renamed from: l  reason: collision with root package name */
    public static final int f34073l = c(4);

    /* renamed from: m  reason: collision with root package name */
    public static final int f34074m = d(1);

    /* renamed from: n  reason: collision with root package name */
    public static final int f34075n = d(2);

    /* renamed from: o  reason: collision with root package name */
    public static final int f34076o = d(3);

    /* renamed from: p  reason: collision with root package name */
    public static final int f34077p = d(4);

    /* renamed from: q  reason: collision with root package name */
    public static final int f34078q = e(1);

    /* renamed from: r  reason: collision with root package name */
    public static final int f34079r = e(2);

    /* renamed from: s  reason: collision with root package name */
    public static final int f34080s = e(3);

    /* renamed from: t  reason: collision with root package name */
    public static final int f34081t = e(4);

    /* renamed from: u  reason: collision with root package name */
    public static final int f34082u = f(1);

    /* renamed from: v  reason: collision with root package name */
    public static final int f34083v = f(2);

    /* renamed from: w  reason: collision with root package name */
    public static final int f34084w = f(3);

    /* renamed from: x  reason: collision with root package name */
    public static final int f34085x = f(4);

    /* renamed from: y  reason: collision with root package name */
    public static final int f34086y = g(1);

    /* renamed from: z  reason: collision with root package name */
    public static final int f34087z = g(2);

    public static final int a(int i2) {
        return a(0, i2);
    }

    public static final int a(int i2, int i3) {
        if (i3 <= 0 || i3 >= 512) {
            throw new UnsupportedOperationException("Channels count should be 1..511");
        } else if (i2 >= 0 && i2 < 8) {
            return (i2 & 7) + ((i3 - 1) << 3);
        } else {
            throw new UnsupportedOperationException("Data type depth should be 0..7");
        }
    }

    public static final int b(int i2) {
        return a(1, i2);
    }

    public static final int c(int i2) {
        return a(2, i2);
    }

    public static final int d(int i2) {
        return a(3, i2);
    }

    public static final int e(int i2) {
        return a(4, i2);
    }

    public static final int f(int i2) {
        return a(5, i2);
    }

    public static final int g(int i2) {
        return a(6, i2);
    }

    public static final int h(int i2) {
        return a(7, i2);
    }

    public static final int i(int i2) {
        return (i2 >> 3) + 1;
    }

    public static final int j(int i2) {
        return i2 & 7;
    }

    public static final String k(int i2) {
        String str;
        StringBuilder sb;
        switch (j(i2)) {
            case 0:
                str = "CV_8U";
                break;
            case 1:
                str = "CV_8S";
                break;
            case 2:
                str = "CV_16U";
                break;
            case 3:
                str = "CV_16S";
                break;
            case 4:
                str = "CV_32S";
                break;
            case 5:
                str = "CV_32F";
                break;
            case 6:
                str = "CV_64F";
                break;
            case 7:
                str = "CV_16F";
                break;
            default:
                throw new UnsupportedOperationException("Unsupported CvType value: " + i2);
        }
        int i3 = i(i2);
        if (i3 <= 4) {
            sb = new StringBuilder();
            sb.append(str);
            sb.append("C");
            sb.append(i3);
        } else {
            sb = new StringBuilder();
            sb.append(str);
            sb.append("C(");
            sb.append(i3);
            sb.append(")");
        }
        return sb.toString();
    }
}
