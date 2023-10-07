package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.Rect;

public class n {

    public static abstract class a implements b {
        public Matrix a(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3) {
            int i4 = i2;
            int i5 = i3;
            a(matrix, rect, i4, i5, f2, f3, ((float) rect.width()) / ((float) i4), ((float) rect.height()) / ((float) i5));
            return matrix;
        }

        public abstract void a(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5);
    }

    public interface b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f11239a = j.f11255j;

        /* renamed from: b  reason: collision with root package name */
        public static final b f11240b = i.f11254j;

        /* renamed from: c  reason: collision with root package name */
        public static final b f11241c = g.f11252j;

        /* renamed from: d  reason: collision with root package name */
        public static final b f11242d = h.f11253j;

        /* renamed from: e  reason: collision with root package name */
        public static final b f11243e = c.f11248j;

        /* renamed from: f  reason: collision with root package name */
        public static final b f11244f = e.f11250j;

        /* renamed from: g  reason: collision with root package name */
        public static final b f11245g = d.f11249j;

        /* renamed from: h  reason: collision with root package name */
        public static final b f11246h = k.f11256j;

        /* renamed from: i  reason: collision with root package name */
        public static final b f11247i = f.f11251j;

        Matrix a(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3);
    }

    private static class c extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final b f11248j = new c();

        private c() {
        }

        public void a(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            matrix.setTranslate((float) ((int) (((float) rect.left) + (((float) (rect.width() - i2)) * 0.5f) + 0.5f)), (float) ((int) (((float) rect.top) + (((float) (rect.height() - i3)) * 0.5f) + 0.5f)));
        }

        public String toString() {
            return "center";
        }
    }

    private static class d extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final b f11249j = new d();

        private d() {
        }

        public void a(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float f6;
            float f7;
            if (f5 > f4) {
                f6 = ((float) rect.left) + ((((float) rect.width()) - (((float) i2) * f5)) * 0.5f);
                f7 = (float) rect.top;
                f4 = f5;
            } else {
                f7 = ((((float) rect.height()) - (((float) i3) * f4)) * 0.5f) + ((float) rect.top);
                f6 = (float) rect.left;
            }
            matrix.setScale(f4, f4);
            matrix.postTranslate((float) ((int) (f6 + 0.5f)), (float) ((int) (f7 + 0.5f)));
        }

        public String toString() {
            return "center_crop";
        }
    }

    private static class e extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final b f11250j = new e();

        private e() {
        }

        public void a(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float min = Math.min(Math.min(f4, f5), 1.0f);
            float width = ((float) rect.left) + ((((float) rect.width()) - (((float) i2) * min)) * 0.5f);
            float height = ((float) rect.top) + ((((float) rect.height()) - (((float) i3) * min)) * 0.5f);
            matrix.setScale(min, min);
            matrix.postTranslate((float) ((int) (width + 0.5f)), (float) ((int) (height + 0.5f)));
        }

        public String toString() {
            return "center_inside";
        }
    }

    private static class f extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final b f11251j = new f();

        private f() {
        }

        public void a(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float min = Math.min(f4, f5);
            matrix.setScale(min, min);
            matrix.postTranslate((float) ((int) (((float) rect.left) + 0.5f)), (float) ((int) (((float) rect.top) + (((float) rect.height()) - (((float) i3) * min)) + 0.5f)));
        }

        public String toString() {
            return "fit_bottom_start";
        }
    }

    private static class g extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final b f11252j = new g();

        private g() {
        }

        public void a(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float min = Math.min(f4, f5);
            float width = ((float) rect.left) + ((((float) rect.width()) - (((float) i2) * min)) * 0.5f);
            float height = ((float) rect.top) + ((((float) rect.height()) - (((float) i3) * min)) * 0.5f);
            matrix.setScale(min, min);
            matrix.postTranslate((float) ((int) (width + 0.5f)), (float) ((int) (height + 0.5f)));
        }

        public String toString() {
            return "fit_center";
        }
    }

    private static class h extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final b f11253j = new h();

        private h() {
        }

        public void a(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float min = Math.min(f4, f5);
            matrix.setScale(min, min);
            matrix.postTranslate((float) ((int) (((float) rect.left) + (((float) rect.width()) - (((float) i2) * min)) + 0.5f)), (float) ((int) (((float) rect.top) + (((float) rect.height()) - (((float) i3) * min)) + 0.5f)));
        }

        public String toString() {
            return "fit_end";
        }
    }

    private static class i extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final b f11254j = new i();

        private i() {
        }

        public void a(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float min = Math.min(f4, f5);
            matrix.setScale(min, min);
            matrix.postTranslate((float) ((int) (((float) rect.left) + 0.5f)), (float) ((int) (((float) rect.top) + 0.5f)));
        }

        public String toString() {
            return "fit_start";
        }
    }

    private static class j extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final b f11255j = new j();

        private j() {
        }

        public void a(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            matrix.setScale(f4, f5);
            matrix.postTranslate((float) ((int) (((float) rect.left) + 0.5f)), (float) ((int) (((float) rect.top) + 0.5f)));
        }

        public String toString() {
            return "fit_xy";
        }
    }

    private static class k extends a {

        /* renamed from: j  reason: collision with root package name */
        public static final b f11256j = new k();

        private k() {
        }

        public void a(Matrix matrix, Rect rect, int i2, int i3, float f2, float f3, float f4, float f5) {
            float f6;
            float f7;
            if (f5 > f4) {
                float f8 = ((float) i2) * f5;
                f6 = ((float) rect.left) + Math.max(Math.min((((float) rect.width()) * 0.5f) - (f2 * f8), 0.0f), ((float) rect.width()) - f8);
                f7 = (float) rect.top;
                f4 = f5;
            } else {
                f6 = (float) rect.left;
                float f9 = ((float) i3) * f4;
                f7 = Math.max(Math.min((((float) rect.height()) * 0.5f) - (f3 * f9), 0.0f), ((float) rect.height()) - f9) + ((float) rect.top);
            }
            matrix.setScale(f4, f4);
            matrix.postTranslate((float) ((int) (f6 + 0.5f)), (float) ((int) (f7 + 0.5f)));
        }

        public String toString() {
            return "focus_crop";
        }
    }

    public interface l {
        Object a();
    }
}
