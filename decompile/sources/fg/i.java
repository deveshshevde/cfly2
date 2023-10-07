package fg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import ez.b;
import ez.d;

public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    public static final double f27244a = Double.longBitsToDouble(1);

    /* renamed from: b  reason: collision with root package name */
    public static final float f27245b = Float.intBitsToFloat(1);

    /* renamed from: c  reason: collision with root package name */
    private static DisplayMetrics f27246c = null;

    /* renamed from: d  reason: collision with root package name */
    private static int f27247d = 50;

    /* renamed from: e  reason: collision with root package name */
    private static int f27248e = 8000;

    /* renamed from: f  reason: collision with root package name */
    private static Rect f27249f = new Rect();

    /* renamed from: g  reason: collision with root package name */
    private static Paint.FontMetrics f27250g = new Paint.FontMetrics();

    /* renamed from: h  reason: collision with root package name */
    private static Rect f27251h = new Rect();

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f27252i = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};

    /* renamed from: j  reason: collision with root package name */
    private static d f27253j = e();

    /* renamed from: k  reason: collision with root package name */
    private static Rect f27254k = new Rect();

    /* renamed from: l  reason: collision with root package name */
    private static Rect f27255l = new Rect();

    /* renamed from: m  reason: collision with root package name */
    private static Paint.FontMetrics f27256m = new Paint.FontMetrics();

    public static float a(double d2) {
        if (Double.isInfinite(d2) || Double.isNaN(d2) || d2 == f27244a) {
            return 0.0f;
        }
        float pow = (float) Math.pow(10.0d, (double) (1 - ((int) ((float) Math.ceil((double) ((float) Math.log10(d2 < f27244a ? -d2 : d2)))))));
        double d3 = (double) pow;
        Double.isNaN(d3);
        return ((float) Math.round(d2 * d3)) / pow;
    }

    public static float a(float f2) {
        DisplayMetrics displayMetrics = f27246c;
        if (displayMetrics != null) {
            return f2 * displayMetrics.density;
        }
        Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertDpToPixel(...). Otherwise conversion does not take place.");
        return f2;
    }

    public static float a(Paint paint) {
        return a(paint, f27250g);
    }

    public static float a(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static int a(Paint paint, String str) {
        return (int) paint.measureText(str);
    }

    public static d a() {
        return f27253j;
    }

    public static b a(float f2, float f3, float f4) {
        return b(f2, f3, f4 * 0.017453292f);
    }

    public static void a(Context context) {
        if (context == null) {
            f27247d = ViewConfiguration.getMinimumFlingVelocity();
            f27248e = ViewConfiguration.getMaximumFlingVelocity();
            Log.e("MPChartLib-Utils", "Utils.init(...) PROVIDED CONTEXT OBJECT IS NULL");
            return;
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        f27247d = viewConfiguration.getScaledMinimumFlingVelocity();
        f27248e = viewConfiguration.getScaledMaximumFlingVelocity();
        f27246c = context.getResources().getDisplayMetrics();
    }

    public static void a(Canvas canvas, Drawable drawable, int i2, int i3, int i4, int i5) {
        e b2 = e.b();
        b2.f27222a = (float) (i2 - (i4 / 2));
        b2.f27223b = (float) (i3 - (i5 / 2));
        drawable.copyBounds(f27254k);
        drawable.setBounds(f27254k.left, f27254k.top, f27254k.left + i4, f27254k.top + i4);
        int save = canvas.save();
        canvas.translate(b2.f27222a, b2.f27223b);
        drawable.draw(canvas);
        canvas.restoreToCount(save);
    }

    public static void a(Canvas canvas, String str, float f2, float f3, Paint paint, e eVar, float f4) {
        float fontMetrics = paint.getFontMetrics(f27256m);
        paint.getTextBounds(str, 0, str.length(), f27255l);
        float f5 = 0.0f - ((float) f27255l.left);
        float f6 = (-f27256m.ascent) + 0.0f;
        Paint.Align textAlign = paint.getTextAlign();
        paint.setTextAlign(Paint.Align.LEFT);
        if (f4 != 0.0f) {
            float width = f5 - (((float) f27255l.width()) * 0.5f);
            float f7 = f6 - (fontMetrics * 0.5f);
            if (!(eVar.f27222a == 0.5f && eVar.f27223b == 0.5f)) {
                b a2 = a((float) f27255l.width(), fontMetrics, f4);
                f2 -= a2.f27215a * (eVar.f27222a - 0.5f);
                f3 -= a2.f27216b * (eVar.f27223b - 0.5f);
                b.a(a2);
            }
            canvas.save();
            canvas.translate(f2, f3);
            canvas.rotate(f4);
            canvas.drawText(str, width, f7, paint);
            canvas.restore();
        } else {
            if (!(eVar.f27222a == 0.0f && eVar.f27223b == 0.0f)) {
                f5 -= ((float) f27255l.width()) * eVar.f27222a;
                f6 -= fontMetrics * eVar.f27223b;
            }
            canvas.drawText(str, f5 + f2, f6 + f3, paint);
        }
        paint.setTextAlign(textAlign);
    }

    public static void a(Paint paint, String str, b bVar) {
        Rect rect = f27251h;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        bVar.f27215a = (float) rect.width();
        bVar.f27216b = (float) rect.height();
    }

    public static void a(MotionEvent motionEvent, VelocityTracker velocityTracker) {
        velocityTracker.computeCurrentVelocity(1000, (float) f27248e);
        int actionIndex = motionEvent.getActionIndex();
        int pointerId = motionEvent.getPointerId(actionIndex);
        float xVelocity = velocityTracker.getXVelocity(pointerId);
        float yVelocity = velocityTracker.getYVelocity(pointerId);
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            if (i2 != actionIndex) {
                int pointerId2 = motionEvent.getPointerId(i2);
                if ((velocityTracker.getXVelocity(pointerId2) * xVelocity) + (velocityTracker.getYVelocity(pointerId2) * yVelocity) < 0.0f) {
                    velocityTracker.clear();
                    return;
                }
            }
        }
    }

    public static void a(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postInvalidateOnAnimation();
        } else {
            view.postInvalidateDelayed(10);
        }
    }

    public static void a(e eVar, float f2, float f3, e eVar2) {
        double d2 = (double) eVar.f27222a;
        double d3 = (double) f2;
        double d4 = (double) f3;
        double cos = Math.cos(Math.toRadians(d4));
        Double.isNaN(d3);
        Double.isNaN(d2);
        eVar2.f27222a = (float) (d2 + (cos * d3));
        double d5 = (double) eVar.f27223b;
        double sin = Math.sin(Math.toRadians(d4));
        Double.isNaN(d3);
        Double.isNaN(d5);
        eVar2.f27223b = (float) (d5 + (d3 * sin));
    }

    public static double b(double d2) {
        if (d2 == Double.POSITIVE_INFINITY) {
            return d2;
        }
        double d3 = d2 + f27244a;
        return Double.longBitsToDouble(Double.doubleToRawLongBits(d3) + (d3 >= f27244a ? 1 : -1));
    }

    public static float b(Paint paint) {
        return b(paint, f27250g);
    }

    public static float b(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return (fontMetrics.ascent - fontMetrics.top) + fontMetrics.bottom;
    }

    public static int b() {
        return f27247d;
    }

    public static int b(float f2) {
        float a2 = a((double) f2);
        if (Float.isInfinite(a2)) {
            return 0;
        }
        return ((int) Math.ceil(-Math.log10((double) a2))) + 2;
    }

    public static int b(Paint paint, String str) {
        Rect rect = f27249f;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static b b(float f2, float f3, float f4) {
        double d2 = (double) f4;
        return b.a(Math.abs(((float) Math.cos(d2)) * f2) + Math.abs(((float) Math.sin(d2)) * f3), Math.abs(f2 * ((float) Math.sin(d2))) + Math.abs(f3 * ((float) Math.cos(d2))));
    }

    public static float c(float f2) {
        while (f2 < 0.0f) {
            f2 += 360.0f;
        }
        return f2 % 360.0f;
    }

    public static int c() {
        return f27248e;
    }

    public static b c(Paint paint, String str) {
        b a2 = b.a(0.0f, 0.0f);
        a(paint, str, a2);
        return a2;
    }

    public static int d() {
        return Build.VERSION.SDK_INT;
    }

    private static d e() {
        return new b(1);
    }
}
