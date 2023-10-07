package moe.codeest.enviews;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AnticipateInterpolator;
import com.shuyu.gsyvideoplayer.R;

public class ENPlayView extends View {

    /* renamed from: a  reason: collision with root package name */
    public static int f31248a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f31249b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static int f31250c = -1;

    /* renamed from: d  reason: collision with root package name */
    public static int f31251d = -328966;

    /* renamed from: e  reason: collision with root package name */
    public static int f31252e = 4;

    /* renamed from: f  reason: collision with root package name */
    public static int f31253f = 4;

    /* renamed from: g  reason: collision with root package name */
    public static int f31254g = 1200;

    /* renamed from: h  reason: collision with root package name */
    private int f31255h = f31249b;

    /* renamed from: i  reason: collision with root package name */
    private Paint f31256i;

    /* renamed from: j  reason: collision with root package name */
    private Paint f31257j;

    /* renamed from: k  reason: collision with root package name */
    private int f31258k;

    /* renamed from: l  reason: collision with root package name */
    private int f31259l;

    /* renamed from: m  reason: collision with root package name */
    private int f31260m;

    /* renamed from: n  reason: collision with root package name */
    private int f31261n;

    /* renamed from: o  reason: collision with root package name */
    private int f31262o;

    /* renamed from: p  reason: collision with root package name */
    private RectF f31263p;

    /* renamed from: q  reason: collision with root package name */
    private RectF f31264q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public float f31265r = 1.0f;

    /* renamed from: s  reason: collision with root package name */
    private Path f31266s;

    /* renamed from: t  reason: collision with root package name */
    private Path f31267t;

    /* renamed from: u  reason: collision with root package name */
    private PathMeasure f31268u;

    /* renamed from: v  reason: collision with root package name */
    private float f31269v;

    /* renamed from: w  reason: collision with root package name */
    private int f31270w;

    public ENPlayView(Context context) {
        super(context);
    }

    public ENPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.play);
        int color = obtainStyledAttributes.getColor(R.styleable.play_play_line_color, f31250c);
        int color2 = obtainStyledAttributes.getColor(R.styleable.play_play_bg_line_color, f31251d);
        int integer = obtainStyledAttributes.getInteger(R.styleable.play_play_line_width, a(f31252e));
        int integer2 = obtainStyledAttributes.getInteger(R.styleable.play_play_bg_line_width, a(f31253f));
        obtainStyledAttributes.recycle();
        setLayerType(1, (Paint) null);
        Paint paint = new Paint(1);
        this.f31256i = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f31256i.setStrokeCap(Paint.Cap.ROUND);
        this.f31256i.setColor(color);
        this.f31256i.setStrokeWidth((float) integer);
        this.f31256i.setPathEffect(new CornerPathEffect(1.0f));
        Paint paint2 = new Paint(1);
        this.f31257j = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f31257j.setStrokeCap(Paint.Cap.ROUND);
        this.f31257j.setColor(color2);
        this.f31257j.setStrokeWidth((float) integer2);
        this.f31266s = new Path();
        this.f31267t = new Path();
        this.f31268u = new PathMeasure();
        this.f31270w = f31254g;
    }

    private int a(int i2) {
        return (int) TypedValue.applyDimension(1, (float) i2, getContext().getResources().getDisplayMetrics());
    }

    public void a() {
        int i2 = this.f31255h;
        int i3 = f31248a;
        if (i2 != i3) {
            this.f31255h = i3;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 100.0f});
            ofFloat.setDuration((long) this.f31270w);
            ofFloat.setInterpolator(new AnticipateInterpolator());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = ENPlayView.this.f31265r = 1.0f - valueAnimator.getAnimatedFraction();
                    ENPlayView.this.invalidate();
                }
            });
            if (!ofFloat.isRunning()) {
                ofFloat.start();
            }
        }
    }

    public void b() {
        int i2 = this.f31255h;
        int i3 = f31249b;
        if (i2 != i3) {
            this.f31255h = i3;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 100.0f});
            ofFloat.setDuration((long) this.f31270w);
            ofFloat.setInterpolator(new AnticipateInterpolator());
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = ENPlayView.this.f31265r = valueAnimator.getAnimatedFraction();
                    ENPlayView.this.invalidate();
                }
            });
            if (!ofFloat.isRunning()) {
                ofFloat.start();
            }
        }
    }

    public int getCurrentState() {
        return this.f31255h;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        boolean z2;
        float f2;
        float f3;
        RectF rectF;
        Paint paint;
        Canvas canvas2;
        Canvas canvas3 = canvas;
        super.onDraw(canvas);
        canvas3.drawCircle((float) this.f31260m, (float) this.f31261n, (float) (this.f31258k / 2), this.f31257j);
        float f4 = this.f31265r;
        if (f4 < 0.0f) {
            int i2 = this.f31260m;
            int i3 = this.f31262o;
            int i4 = this.f31261n;
            canvas.drawLine((float) (i2 + i3), (((float) i4) - (((float) i3) * 1.6f)) + (((float) (i3 * 10)) * f4), (float) (i2 + i3), ((float) i4) + (((float) i3) * 1.6f) + (((float) (i3 * 10)) * f4), this.f31256i);
            int i5 = this.f31260m;
            int i6 = this.f31262o;
            int i7 = this.f31261n;
            canvas2 = canvas;
            canvas2.drawLine((float) (i5 - i6), ((float) i7) - (((float) i6) * 1.6f), (float) (i5 - i6), ((float) i7) + (((float) i6) * 1.6f), this.f31256i);
            rectF = this.f31264q;
            f3 = -105.0f;
            f2 = 360.0f;
            z2 = false;
            paint = this.f31256i;
        } else {
            if (((double) f4) <= 0.3d) {
                int i8 = this.f31260m;
                int i9 = this.f31262o;
                int i10 = this.f31261n;
                canvas.drawLine((float) (i8 + i9), (((float) i10) - (((float) i9) * 1.6f)) + (((((float) i9) * 3.2f) / 0.3f) * f4), (float) (i8 + i9), ((float) i10) + (((float) i9) * 1.6f), this.f31256i);
                int i11 = this.f31260m;
                int i12 = this.f31262o;
                int i13 = this.f31261n;
                canvas.drawLine((float) (i11 - i12), ((float) i13) - (((float) i12) * 1.6f), (float) (i11 - i12), ((float) i13) + (((float) i12) * 1.6f), this.f31256i);
                float f5 = this.f31265r;
                if (f5 != 0.0f) {
                    canvas.drawArc(this.f31263p, 0.0f, f5 * 600.0f, false, this.f31256i);
                }
            } else if (((double) f4) <= 0.6d) {
                z2 = false;
                canvas.drawArc(this.f31263p, (f4 - 0.3f) * 600.0f, 180.0f - ((f4 - 0.3f) * 600.0f), false, this.f31256i);
                this.f31267t.reset();
                PathMeasure pathMeasure = this.f31268u;
                float f6 = this.f31269v;
                pathMeasure.getSegment(0.02f * f6, (0.38f * f6) + (((f6 * 0.42f) / 0.3f) * (this.f31265r - 0.3f)), this.f31267t, true);
                canvas3.drawPath(this.f31267t, this.f31256i);
                rectF = this.f31264q;
                float f7 = this.f31265r;
                f3 = (f7 * 360.0f) - 0.04248047f;
                f2 = (1.0f - f7) * 360.0f;
                paint = this.f31256i;
                canvas2 = canvas;
            } else {
                int i14 = (((double) f4) > 0.8d ? 1 : (((double) f4) == 0.8d ? 0 : -1));
                this.f31267t.reset();
                PathMeasure pathMeasure2 = this.f31268u;
                if (i14 <= 0) {
                    float f8 = this.f31269v;
                    float f9 = this.f31265r;
                    pathMeasure2.getSegment((0.02f * f8) + (((f8 * 0.2f) / 0.2f) * (f9 - 0.6f)), (0.8f * f8) + (((f8 * 0.2f) / 0.2f) * (f9 - 0.6f)), this.f31267t, true);
                    canvas3.drawPath(this.f31267t, this.f31256i);
                } else {
                    pathMeasure2.getSegment(((float) (this.f31262o * 10)) * (this.f31265r - 1.0f), this.f31269v, this.f31267t, true);
                    canvas3.drawPath(this.f31267t, this.f31256i);
                    return;
                }
            }
            rectF = this.f31264q;
            float f10 = this.f31265r;
            f3 = (f10 * 360.0f) - 0.04248047f;
            f2 = (1.0f - f10) * 360.0f;
            z2 = false;
            paint = this.f31256i;
            canvas2 = canvas;
        }
        canvas2.drawArc(rectF, f3, f2, z2, paint);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        int i6 = (i2 * 9) / 10;
        this.f31258k = i6;
        this.f31259l = (i3 * 9) / 10;
        this.f31262o = i6 / a(4);
        this.f31260m = i2 / 2;
        this.f31261n = i3 / 2;
        int i7 = this.f31260m;
        int i8 = this.f31262o;
        int i9 = this.f31261n;
        this.f31263p = new RectF((float) (i7 - i8), ((float) i9) + (((float) i8) * 0.6f), (float) (i7 + i8), ((float) i9) + (((float) i8) * 2.6f));
        int i10 = this.f31260m;
        int i11 = this.f31258k;
        int i12 = this.f31261n;
        int i13 = this.f31259l;
        this.f31264q = new RectF((float) (i10 - (i11 / 2)), (float) (i12 - (i13 / 2)), (float) (i10 + (i11 / 2)), (float) (i12 + (i13 / 2)));
        Path path = this.f31266s;
        int i14 = this.f31260m;
        int i15 = this.f31262o;
        path.moveTo((float) (i14 - i15), ((float) this.f31261n) + (((float) i15) * 1.8f));
        Path path2 = this.f31266s;
        int i16 = this.f31260m;
        int i17 = this.f31262o;
        path2.lineTo((float) (i16 - i17), ((float) this.f31261n) - (((float) i17) * 1.8f));
        this.f31266s.lineTo((float) (this.f31260m + this.f31262o), (float) this.f31261n);
        this.f31266s.close();
        this.f31268u.setPath(this.f31266s, false);
        this.f31269v = this.f31268u.getLength();
    }

    public void setDuration(int i2) {
        this.f31270w = i2;
    }
}
