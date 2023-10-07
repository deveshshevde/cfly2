package com.transitionseverywhere;

import android.graphics.Path;
import android.util.Log;
import fg.i;
import java.util.ArrayList;
import java.util.Arrays;

public class b {

    /* renamed from: a  reason: collision with root package name */
    static final String f21903a = "b";

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        int f21904a;

        /* renamed from: b  reason: collision with root package name */
        boolean f21905b;

        private a() {
        }
    }

    /* renamed from: com.transitionseverywhere.b$b  reason: collision with other inner class name */
    public static class C0143b {

        /* renamed from: a  reason: collision with root package name */
        private char f21906a;

        /* renamed from: b  reason: collision with root package name */
        private float[] f21907b;

        private C0143b(char c2, float[] fArr) {
            this.f21906a = c2;
            this.f21907b = fArr;
        }

        private static void a(Path path, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
            double d11 = d4;
            int ceil = (int) Math.ceil(Math.abs((d10 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d8);
            double sin = Math.sin(d8);
            double cos2 = Math.cos(d9);
            double sin2 = Math.sin(d9);
            double d12 = -d11;
            double d13 = d12 * cos;
            double d14 = d5 * sin;
            double d15 = (d13 * sin2) - (d14 * cos2);
            double d16 = d12 * sin;
            double d17 = d5 * cos;
            double d18 = (sin2 * d16) + (cos2 * d17);
            double d19 = (double) ceil;
            Double.isNaN(d19);
            double d20 = d10 / d19;
            double d21 = d9;
            double d22 = d18;
            double d23 = d15;
            int i2 = 0;
            double d24 = d6;
            double d25 = d7;
            while (i2 < ceil) {
                double d26 = d21 + d20;
                double sin3 = Math.sin(d26);
                double cos3 = Math.cos(d26);
                double d27 = (d2 + ((d11 * cos) * cos3)) - (d14 * sin3);
                double d28 = d3 + (d11 * sin * cos3) + (d17 * sin3);
                double d29 = (d13 * sin3) - (d14 * cos3);
                double d30 = (sin3 * d16) + (cos3 * d17);
                double d31 = d26 - d21;
                double tan = Math.tan(d31 / 2.0d);
                double sin4 = (Math.sin(d31) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                double d32 = d24 + (d23 * sin4);
                double d33 = cos;
                double d34 = sin;
                float f2 = (float) (d27 - (sin4 * d29));
                float f3 = (float) (d28 - (sin4 * d30));
                path.cubicTo((float) d32, (float) (d25 + (d22 * sin4)), f2, f3, (float) d27, (float) d28);
                i2++;
                d20 = d20;
                sin = d34;
                d25 = d28;
                d24 = d27;
                cos = d33;
                d21 = d26;
                d22 = d30;
                d23 = d29;
                ceil = ceil;
                d11 = d4;
            }
        }

        private static void a(Path path, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z2, boolean z3) {
            double d2;
            double d3;
            float f9 = f2;
            float f10 = f4;
            float f11 = f6;
            boolean z4 = z3;
            double radians = Math.toRadians((double) f8);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d4 = (double) f9;
            Double.isNaN(d4);
            double d5 = d4 * cos;
            double d6 = d4;
            double d7 = (double) f3;
            Double.isNaN(d7);
            double d8 = (double) f11;
            Double.isNaN(d8);
            double d9 = (d5 + (d7 * sin)) / d8;
            double d10 = (double) (-f9);
            Double.isNaN(d10);
            Double.isNaN(d7);
            double d11 = (d10 * sin) + (d7 * cos);
            double d12 = d7;
            double d13 = (double) f7;
            Double.isNaN(d13);
            double d14 = (double) f10;
            Double.isNaN(d14);
            double d15 = d11 / d13;
            double d16 = (double) f5;
            Double.isNaN(d16);
            Double.isNaN(d8);
            double d17 = ((d14 * cos) + (d16 * sin)) / d8;
            double d18 = d8;
            double d19 = (double) (-f10);
            Double.isNaN(d19);
            Double.isNaN(d16);
            Double.isNaN(d13);
            double d20 = ((d19 * sin) + (d16 * cos)) / d13;
            double d21 = d9 - d17;
            double d22 = d15 - d20;
            double d23 = (d9 + d17) / 2.0d;
            double d24 = (d15 + d20) / 2.0d;
            double d25 = sin;
            double d26 = (d21 * d21) + (d22 * d22);
            if (d26 == i.f27244a) {
                Log.w(b.f21903a, " Points are coincident");
                return;
            }
            double d27 = (1.0d / d26) - 0.25d;
            if (d27 < i.f27244a) {
                String str = b.f21903a;
                Log.w(str, "Points are too far apart " + d26);
                float sqrt = (float) (Math.sqrt(d26) / 1.99999d);
                a(path, f2, f3, f4, f5, f11 * sqrt, f7 * sqrt, f8, z2, z3);
                return;
            }
            double sqrt2 = Math.sqrt(d27);
            double d28 = d21 * sqrt2;
            double d29 = sqrt2 * d22;
            boolean z5 = z3;
            if (z2 == z5) {
                d3 = d23 - d29;
                d2 = d24 + d28;
            } else {
                d3 = d23 + d29;
                d2 = d24 - d28;
            }
            double atan2 = Math.atan2(d15 - d2, d9 - d3);
            double atan22 = Math.atan2(d20 - d2, d17 - d3) - atan2;
            if (z5 != (atan22 >= i.f27244a)) {
                atan22 = atan22 > i.f27244a ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            Double.isNaN(d18);
            double d30 = d3 * d18;
            Double.isNaN(d13);
            double d31 = d2 * d13;
            a(path, (d30 * cos) - (d31 * d25), (d30 * d25) + (d31 * cos), d18, d13, d6, d12, radians, atan2, atan22);
        }

        private static void a(Path path, float[] fArr, char c2, char c3, float[] fArr2) {
            int i2;
            int i3;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11;
            Path path2 = path;
            char c4 = c3;
            float[] fArr3 = fArr2;
            float f12 = fArr[0];
            float f13 = fArr[1];
            float f14 = fArr[2];
            float f15 = fArr[3];
            float f16 = fArr[4];
            float f17 = fArr[5];
            switch (c4) {
                case 'A':
                case 'a':
                    i2 = 7;
                    break;
                case 'C':
                case 'c':
                    i2 = 6;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case 'v':
                    i2 = 1;
                    break;
                case 'Q':
                case 'S':
                case 'q':
                case 's':
                    i2 = 4;
                    break;
                case 'Z':
                case 'z':
                    path.close();
                    path2.moveTo(f16, f17);
                    f12 = f16;
                    f14 = f12;
                    f13 = f17;
                    f15 = f13;
                    break;
            }
            i2 = 2;
            float f18 = f12;
            float f19 = f13;
            float f20 = f16;
            float f21 = f17;
            int i4 = 0;
            char c5 = c2;
            while (i4 < fArr3.length) {
                if (c4 != 'A') {
                    if (c4 == 'C') {
                        i3 = i4;
                        int i5 = i3 + 2;
                        int i6 = i3 + 3;
                        int i7 = i3 + 4;
                        int i8 = i3 + 5;
                        path.cubicTo(fArr3[i3 + 0], fArr3[i3 + 1], fArr3[i5], fArr3[i6], fArr3[i7], fArr3[i8]);
                        f18 = fArr3[i7];
                        float f22 = fArr3[i8];
                        float f23 = fArr3[i5];
                        float f24 = fArr3[i6];
                        f19 = f22;
                        f15 = f24;
                        f14 = f23;
                    } else if (c4 == 'H') {
                        i3 = i4;
                        int i9 = i3 + 0;
                        path2.lineTo(fArr3[i9], f19);
                        f18 = fArr3[i9];
                    } else if (c4 == 'Q') {
                        i3 = i4;
                        int i10 = i3 + 0;
                        int i11 = i3 + 1;
                        int i12 = i3 + 2;
                        int i13 = i3 + 3;
                        path2.quadTo(fArr3[i10], fArr3[i11], fArr3[i12], fArr3[i13]);
                        float f25 = fArr3[i10];
                        float f26 = fArr3[i11];
                        f18 = fArr3[i12];
                        f19 = fArr3[i13];
                        f14 = f25;
                        f15 = f26;
                    } else if (c4 == 'V') {
                        i3 = i4;
                        int i14 = i3 + 0;
                        path2.lineTo(f18, fArr3[i14]);
                        f19 = fArr3[i14];
                    } else if (c4 != 'a') {
                        if (c4 == 'c') {
                            int i15 = i4 + 2;
                            int i16 = i4 + 3;
                            int i17 = i4 + 4;
                            int i18 = i4 + 5;
                            path.rCubicTo(fArr3[i4 + 0], fArr3[i4 + 1], fArr3[i15], fArr3[i16], fArr3[i17], fArr3[i18]);
                            f5 = fArr3[i15] + f18;
                            f4 = fArr3[i16] + f19;
                            f18 += fArr3[i17];
                            f6 = fArr3[i18];
                            f19 += f6;
                            f14 = f5;
                            f15 = f4;
                        } else if (c4 != 'h') {
                            if (c4 != 'q') {
                                if (c4 == 'v') {
                                    int i19 = i4 + 0;
                                    path2.rLineTo(0.0f, fArr3[i19]);
                                    f7 = fArr3[i19];
                                } else if (c4 != 'L') {
                                    if (c4 == 'M') {
                                        int i20 = i4 + 0;
                                        f18 = fArr3[i20];
                                        int i21 = i4 + 1;
                                        f19 = fArr3[i21];
                                        if (i4 > 0) {
                                            path2.lineTo(fArr3[i20], fArr3[i21]);
                                        } else {
                                            path2.moveTo(fArr3[i20], fArr3[i21]);
                                        }
                                    } else if (c4 == 'S') {
                                        if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                            f18 = (f18 * 2.0f) - f14;
                                            f19 = (f19 * 2.0f) - f15;
                                        }
                                        float f27 = f19;
                                        int i22 = i4 + 0;
                                        int i23 = i4 + 1;
                                        int i24 = i4 + 2;
                                        int i25 = i4 + 3;
                                        path.cubicTo(f18, f27, fArr3[i22], fArr3[i23], fArr3[i24], fArr3[i25]);
                                        f5 = fArr3[i22];
                                        f4 = fArr3[i23];
                                        f18 = fArr3[i24];
                                        f19 = fArr3[i25];
                                        f14 = f5;
                                        f15 = f4;
                                    } else if (c4 == 'T') {
                                        if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                            f18 = (f18 * 2.0f) - f14;
                                            f19 = (f19 * 2.0f) - f15;
                                        }
                                        int i26 = i4 + 0;
                                        int i27 = i4 + 1;
                                        path2.quadTo(f18, f19, fArr3[i26], fArr3[i27]);
                                        float f28 = fArr3[i26];
                                        float f29 = fArr3[i27];
                                        i3 = i4;
                                        f15 = f19;
                                        f14 = f18;
                                        f18 = f28;
                                        f19 = f29;
                                    } else if (c4 == 'l') {
                                        int i28 = i4 + 0;
                                        int i29 = i4 + 1;
                                        path2.rLineTo(fArr3[i28], fArr3[i29]);
                                        f18 += fArr3[i28];
                                        f7 = fArr3[i29];
                                    } else if (c4 == 'm') {
                                        int i30 = i4 + 0;
                                        f18 += fArr3[i30];
                                        int i31 = i4 + 1;
                                        f19 += fArr3[i31];
                                        if (i4 > 0) {
                                            path2.rLineTo(fArr3[i30], fArr3[i31]);
                                        } else {
                                            path2.rMoveTo(fArr3[i30], fArr3[i31]);
                                        }
                                    } else if (c4 == 's') {
                                        if (c5 == 'c' || c5 == 's' || c5 == 'C' || c5 == 'S') {
                                            float f30 = f18 - f14;
                                            f8 = f19 - f15;
                                            f9 = f30;
                                        } else {
                                            f9 = 0.0f;
                                            f8 = 0.0f;
                                        }
                                        int i32 = i4 + 0;
                                        int i33 = i4 + 1;
                                        int i34 = i4 + 2;
                                        int i35 = i4 + 3;
                                        path.rCubicTo(f9, f8, fArr3[i32], fArr3[i33], fArr3[i34], fArr3[i35]);
                                        f5 = fArr3[i32] + f18;
                                        f4 = fArr3[i33] + f19;
                                        f18 += fArr3[i34];
                                        f6 = fArr3[i35];
                                    } else if (c4 == 't') {
                                        if (c5 == 'q' || c5 == 't' || c5 == 'Q' || c5 == 'T') {
                                            f10 = f18 - f14;
                                            f11 = f19 - f15;
                                        } else {
                                            f11 = 0.0f;
                                            f10 = 0;
                                        }
                                        int i36 = i4 + 0;
                                        int i37 = i4 + 1;
                                        path2.rQuadTo(f10, f11, fArr3[i36], fArr3[i37]);
                                        float f31 = f10 + f18;
                                        float f32 = f11 + f19;
                                        f18 += fArr3[i36];
                                        f19 += fArr3[i37];
                                        f15 = f32;
                                        f14 = f31;
                                    }
                                    i3 = i4;
                                    f21 = f19;
                                    f20 = f18;
                                } else {
                                    int i38 = i4 + 0;
                                    int i39 = i4 + 1;
                                    path2.lineTo(fArr3[i38], fArr3[i39]);
                                    f18 = fArr3[i38];
                                    f19 = fArr3[i39];
                                }
                                f19 += f7;
                            } else {
                                int i40 = i4 + 0;
                                int i41 = i4 + 1;
                                int i42 = i4 + 2;
                                int i43 = i4 + 3;
                                path2.rQuadTo(fArr3[i40], fArr3[i41], fArr3[i42], fArr3[i43]);
                                f5 = fArr3[i40] + f18;
                                f4 = fArr3[i41] + f19;
                                f18 += fArr3[i42];
                                f6 = fArr3[i43];
                            }
                            f19 += f6;
                            f14 = f5;
                            f15 = f4;
                        } else {
                            int i44 = i4 + 0;
                            path2.rLineTo(fArr3[i44], 0.0f);
                            f18 += fArr3[i44];
                        }
                        i3 = i4;
                    } else {
                        int i45 = i4 + 5;
                        int i46 = i4 + 6;
                        i3 = i4;
                        a(path, f18, f19, fArr3[i45] + f18, fArr3[i46] + f19, fArr3[i4 + 0], fArr3[i4 + 1], fArr3[i4 + 2], fArr3[i4 + 3] != 0.0f, fArr3[i4 + 4] != 0.0f);
                        f2 = f18 + fArr3[i45];
                        f3 = f19 + fArr3[i46];
                    }
                    i4 = i3 + i2;
                    c5 = c3;
                    c4 = c5;
                } else {
                    i3 = i4;
                    int i47 = i3 + 5;
                    int i48 = i3 + 6;
                    a(path, f18, f19, fArr3[i47], fArr3[i48], fArr3[i3 + 0], fArr3[i3 + 1], fArr3[i3 + 2], fArr3[i3 + 3] != 0.0f, fArr3[i3 + 4] != 0.0f);
                    f2 = fArr3[i47];
                    f3 = fArr3[i48];
                }
                f15 = f19;
                f14 = f18;
                i4 = i3 + i2;
                c5 = c3;
                c4 = c5;
            }
            fArr[0] = f18;
            fArr[1] = f19;
            fArr[2] = f14;
            fArr[3] = f15;
            fArr[4] = f20;
            fArr[5] = f21;
        }

        public static void a(C0143b[] bVarArr, Path path) {
            float[] fArr = new float[6];
            char c2 = 'm';
            for (int i2 = 0; i2 < bVarArr.length; i2++) {
                a(path, fArr, c2, bVarArr[i2].f21906a, bVarArr[i2].f21907b);
                c2 = bVarArr[i2].f21906a;
            }
        }
    }

    private static int a(String str, int i2) {
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i2;
            }
            i2++;
        }
        return i2;
    }

    public static Path a(String str) {
        Path path = new Path();
        C0143b[] b2 = b(str);
        if (b2 == null) {
            return null;
        }
        try {
            C0143b.a(b2, path);
            return path;
        } catch (RuntimeException e2) {
            throw new RuntimeException("Error in parsing " + str, e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0027, code lost:
        r10.f21905b = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002c, code lost:
        if (r2 == false) goto L_0x0027;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
        r2 = false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0038 A[LOOP:0: B:1:0x0007->B:19:0x0038, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x003b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.lang.String r8, int r9, com.transitionseverywhere.b.a r10) {
        /*
            r0 = 0
            r10.f21905b = r0
            r1 = r9
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x0007:
            int r5 = r8.length()
            if (r1 >= r5) goto L_0x003b
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L_0x0033
            r6 = 69
            if (r5 == r6) goto L_0x0031
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L_0x0031
            switch(r5) {
                case 44: goto L_0x0033;
                case 45: goto L_0x002a;
                case 46: goto L_0x0022;
                default: goto L_0x0021;
            }
        L_0x0021:
            goto L_0x002f
        L_0x0022:
            if (r3 != 0) goto L_0x0027
            r2 = 0
            r3 = 1
            goto L_0x0035
        L_0x0027:
            r10.f21905b = r7
            goto L_0x0033
        L_0x002a:
            if (r1 == r9) goto L_0x002f
            if (r2 != 0) goto L_0x002f
            goto L_0x0027
        L_0x002f:
            r2 = 0
            goto L_0x0035
        L_0x0031:
            r2 = 1
            goto L_0x0035
        L_0x0033:
            r2 = 0
            r4 = 1
        L_0x0035:
            if (r4 == 0) goto L_0x0038
            goto L_0x003b
        L_0x0038:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x003b:
            r10.f21904a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transitionseverywhere.b.a(java.lang.String, int, com.transitionseverywhere.b$a):void");
    }

    private static void a(ArrayList<C0143b> arrayList, char c2, float[] fArr) {
        arrayList.add(new C0143b(c2, fArr));
    }

    public static C0143b[] b(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        int i3 = 0;
        while (i2 < str.length()) {
            int a2 = a(str, i2);
            String trim = str.substring(i3, a2).trim();
            if (trim.length() > 0) {
                a((ArrayList<C0143b>) arrayList, trim.charAt(0), c(trim));
            }
            i3 = a2;
            i2 = a2 + 1;
        }
        if (i2 - i3 == 1 && i3 < str.length()) {
            a((ArrayList<C0143b>) arrayList, str.charAt(i3), new float[0]);
        }
        return (C0143b[]) arrayList.toArray(new C0143b[arrayList.size()]);
    }

    private static float[] c(String str) {
        int i2 = 0;
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i3 = 1;
            while (i3 < length) {
                a(str, i3, aVar);
                int i4 = aVar.f21904a;
                if (i3 < i4) {
                    fArr[i2] = Float.parseFloat(str.substring(i3, i4));
                    i2++;
                }
                i3 = aVar.f21905b ? i4 : i4 + 1;
            }
            return Arrays.copyOf(fArr, i2);
        } catch (NumberFormatException e2) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e2);
        }
    }
}
