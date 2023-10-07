package moe.codeest.enviews;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import com.shuyu.gsyvideoplayer.R;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoView;
import fg.i;

public class ENDownloadView extends View {

    /* renamed from: b  reason: collision with root package name */
    private static final DownloadUnit f31213b = DownloadUnit.B;

    /* renamed from: a  reason: collision with root package name */
    ValueAnimator f31214a;

    /* renamed from: c  reason: collision with root package name */
    private a f31215c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f31216d;

    /* renamed from: e  reason: collision with root package name */
    private float f31217e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public double f31218f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public double f31219g;

    /* renamed from: h  reason: collision with root package name */
    private int f31220h;

    /* renamed from: i  reason: collision with root package name */
    private int f31221i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public DownloadUnit f31222j;

    /* renamed from: k  reason: collision with root package name */
    private Paint f31223k;

    /* renamed from: l  reason: collision with root package name */
    private Paint f31224l;

    /* renamed from: m  reason: collision with root package name */
    private Paint f31225m;

    /* renamed from: n  reason: collision with root package name */
    private Path f31226n;

    /* renamed from: o  reason: collision with root package name */
    private RectF f31227o;

    /* renamed from: p  reason: collision with root package name */
    private RectF f31228p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public float f31229q;

    /* renamed from: r  reason: collision with root package name */
    private float f31230r;

    /* renamed from: s  reason: collision with root package name */
    private float f31231s;

    /* renamed from: t  reason: collision with root package name */
    private float f31232t;

    /* renamed from: u  reason: collision with root package name */
    private float f31233u;

    /* renamed from: v  reason: collision with root package name */
    private float f31234v;

    /* renamed from: w  reason: collision with root package name */
    private float f31235w;

    /* renamed from: x  reason: collision with root package name */
    private float f31236x;

    /* renamed from: moe.codeest.enviews.ENDownloadView$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31241a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                moe.codeest.enviews.ENDownloadView$DownloadUnit[] r0 = moe.codeest.enviews.ENDownloadView.DownloadUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31241a = r0
                moe.codeest.enviews.ENDownloadView$DownloadUnit r1 = moe.codeest.enviews.ENDownloadView.DownloadUnit.GB     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31241a     // Catch:{ NoSuchFieldError -> 0x001d }
                moe.codeest.enviews.ENDownloadView$DownloadUnit r1 = moe.codeest.enviews.ENDownloadView.DownloadUnit.MB     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31241a     // Catch:{ NoSuchFieldError -> 0x0028 }
                moe.codeest.enviews.ENDownloadView$DownloadUnit r1 = moe.codeest.enviews.ENDownloadView.DownloadUnit.KB     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f31241a     // Catch:{ NoSuchFieldError -> 0x0033 }
                moe.codeest.enviews.ENDownloadView$DownloadUnit r1 = moe.codeest.enviews.ENDownloadView.DownloadUnit.B     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: moe.codeest.enviews.ENDownloadView.AnonymousClass5.<clinit>():void");
        }
    }

    public enum DownloadUnit {
        GB,
        MB,
        KB,
        B,
        NONE
    }

    interface a {
    }

    public ENDownloadView(Context context) {
        super(context);
    }

    public ENDownloadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.download);
        int color = obtainStyledAttributes.getColor(R.styleable.download_download_line_color, -1);
        int color2 = obtainStyledAttributes.getColor(R.styleable.download_download_bg_line_color, -12959931);
        int color3 = obtainStyledAttributes.getColor(R.styleable.download_download_text_color, -1);
        int integer = obtainStyledAttributes.getInteger(R.styleable.download_download_line_width, 9);
        int integer2 = obtainStyledAttributes.getInteger(R.styleable.download_download_bg_line_width, 9);
        int integer3 = obtainStyledAttributes.getInteger(R.styleable.download_download_text_size, 14);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint(1);
        this.f31223k = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f31223k.setStrokeCap(Paint.Cap.ROUND);
        this.f31223k.setStrokeWidth((float) integer);
        this.f31223k.setColor(color);
        Paint paint2 = new Paint(1);
        this.f31224l = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.f31224l.setStrokeCap(Paint.Cap.ROUND);
        this.f31224l.setStrokeWidth((float) integer2);
        this.f31224l.setColor(color2);
        Paint paint3 = new Paint(1);
        this.f31225m = paint3;
        paint3.setColor(color3);
        this.f31225m.setTextSize((float) integer3);
        this.f31225m.setTextAlign(Paint.Align.CENTER);
        this.f31226n = new Path();
        this.f31220h = integer3;
        this.f31216d = 0;
        this.f31222j = f31213b;
        this.f31221i = GSYVideoView.CHANGE_DELAY_TIME;
    }

    private String a(DownloadUnit downloadUnit) {
        int i2 = AnonymousClass5.f31241a[downloadUnit.ordinal()];
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? " b" : " kb" : " mb" : " gb";
    }

    /* access modifiers changed from: private */
    public void c() {
        ValueAnimator valueAnimator = this.f31214a;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f31214a.removeAllUpdateListeners();
            if (this.f31214a.isRunning()) {
                this.f31214a.cancel();
            }
            this.f31214a = null;
        }
        if (this.f31216d == 1) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 100.0f});
            this.f31214a = ofFloat;
            ofFloat.setDuration((long) this.f31221i);
            this.f31214a.setInterpolator(new LinearInterpolator());
            this.f31214a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float unused = ENDownloadView.this.f31229q = valueAnimator.getAnimatedFraction();
                    if (ENDownloadView.this.f31222j != DownloadUnit.NONE && ENDownloadView.this.f31219g > i.f27244a) {
                        ENDownloadView eNDownloadView = ENDownloadView.this;
                        double d2 = (double) eNDownloadView.f31229q;
                        double c2 = ENDownloadView.this.f31219g;
                        Double.isNaN(d2);
                        double unused2 = eNDownloadView.f31218f = d2 * c2;
                    }
                    ENDownloadView.this.invalidate();
                }
            });
            this.f31214a.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    int unused = ENDownloadView.this.f31216d = 1;
                    ENDownloadView.this.c();
                }
            });
            this.f31214a.start();
        }
    }

    public void a() {
        ValueAnimator valueAnimator = this.f31214a;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f31214a.removeAllUpdateListeners();
            if (this.f31214a.isRunning()) {
                this.f31214a.cancel();
            }
            this.f31214a = null;
        }
        this.f31216d = 1;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 100.0f});
        this.f31214a = ofFloat;
        ofFloat.setDuration(1500);
        this.f31214a.setInterpolator(new OvershootInterpolator());
        this.f31214a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = ENDownloadView.this.f31229q = valueAnimator.getAnimatedFraction();
                ENDownloadView.this.invalidate();
            }
        });
        this.f31214a.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                int unused = ENDownloadView.this.f31216d = 1;
                ENDownloadView.this.c();
            }
        });
        this.f31214a.start();
    }

    public void b() {
        this.f31229q = 0.0f;
        this.f31216d = 0;
        ValueAnimator valueAnimator = this.f31214a;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.f31214a.removeAllUpdateListeners();
            if (this.f31214a.isRunning()) {
                this.f31214a.cancel();
            }
            this.f31214a = null;
        }
    }

    public int getCurrentState() {
        return this.f31216d;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        Paint paint;
        Canvas canvas2;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        Canvas canvas3 = canvas;
        super.onDraw(canvas);
        int i2 = this.f31216d;
        if (i2 == 0) {
            float f11 = this.f31229q;
            if (((double) f11) <= 0.4d) {
                canvas3.drawCircle(this.f31232t, this.f31233u, this.f31235w, this.f31224l);
                float f12 = this.f31232t;
                float f13 = this.f31234v;
                float f14 = this.f31233u;
                canvas.drawLine(f12 - f13, f14, f12, f14 + f13, this.f31223k);
                float f15 = this.f31232t;
                float f16 = this.f31233u;
                float f17 = this.f31234v;
                canvas.drawLine(f15, f16 + f17, f15 + f17, f16, this.f31223k);
                f3 = this.f31232t;
                float f18 = this.f31233u;
                float f19 = this.f31234v;
                float f20 = this.f31229q;
                f5 = (f18 + f19) - (((f19 * 1.3f) / 0.4f) * f20);
                f2 = (f18 - (1.6f * f19)) + (((f19 * 1.3f) / 0.4f) * f20);
                paint = this.f31223k;
                canvas2 = canvas;
                f4 = f3;
            } else if (((double) f11) <= 0.6d) {
                canvas3.drawCircle(this.f31232t, this.f31233u, this.f31235w, this.f31224l);
                canvas3.drawCircle(this.f31232t, this.f31233u - (this.f31234v * 0.3f), 2.0f, this.f31223k);
                float f21 = this.f31232t;
                float f22 = this.f31234v;
                float f23 = this.f31229q;
                float f24 = (f21 - f22) - (((f22 * 1.2f) / 0.2f) * (f23 - 0.4f));
                float f25 = this.f31233u;
                canvas.drawLine(f24, f25, f21, (f25 + f22) - ((f22 / 0.2f) * (f23 - 0.4f)), this.f31223k);
                f4 = this.f31232t;
                f2 = this.f31233u;
                float f26 = this.f31234v;
                float f27 = this.f31229q;
                f5 = (f2 + f26) - ((f26 / 0.2f) * (f27 - 0.4f));
                f3 = f4 + f26 + (((f26 * 1.2f) / 0.2f) * (f27 - 0.4f));
                paint = this.f31223k;
                canvas2 = canvas;
            } else {
                if (f11 <= 1.0f) {
                    canvas3.drawCircle(this.f31232t, this.f31233u, this.f31235w, this.f31224l);
                    float f28 = this.f31232t;
                    float f29 = this.f31233u;
                    float f30 = this.f31234v;
                    canvas3.drawCircle(f28, (f29 - (f30 * 0.3f)) - (((this.f31235w - (f30 * 0.3f)) / 0.4f) * (this.f31229q - 0.6f)), 2.0f, this.f31223k);
                } else {
                    canvas3.drawCircle(this.f31232t, this.f31233u, this.f31235w, this.f31224l);
                    canvas3.drawCircle(this.f31232t, (this.f31233u - this.f31235w) - ((this.f31234v * 3.0f) * (this.f31229q - 1.0f)), 3.0f, this.f31223k);
                }
                float f31 = this.f31232t;
                float f32 = this.f31234v;
                float f33 = f31 - (f32 * 2.2f);
                f2 = this.f31233u;
                f3 = f31 + (f32 * 2.2f);
                paint = this.f31223k;
                canvas2 = canvas;
                f4 = f33;
                f5 = f2;
            }
        } else if (i2 != 1) {
            if (i2 == 2) {
                canvas3.drawCircle(this.f31232t, this.f31233u, this.f31235w, this.f31223k);
                float f34 = this.f31229q;
                if (((double) f34) <= 0.5d) {
                    Paint paint2 = this.f31225m;
                    int i3 = this.f31220h;
                    paint2.setTextSize(((float) i3) - ((((float) i3) / 0.2f) * f34));
                } else {
                    this.f31225m.setTextSize(0.0f);
                }
                if (this.f31222j != DownloadUnit.NONE && this.f31218f > i.f27244a) {
                    canvas3.drawText(String.format("%.2f", new Object[]{Double.valueOf(this.f31218f)}) + a(this.f31222j), this.f31232t, this.f31233u + (this.f31234v * 1.4f), this.f31225m);
                }
                float f35 = this.f31232t;
                float f36 = this.f31234v;
                float f37 = this.f31229q;
                float f38 = this.f31233u;
                canvas.drawLine((f35 - (f36 * 2.2f)) + (1.2f * f36 * f37), f38, f35 - (f36 * 0.5f), f38 + (f36 * 0.5f * f37 * 1.3f), this.f31223k);
                float f39 = this.f31232t;
                float f40 = this.f31234v;
                f6 = f39 - (f40 * 0.5f);
                f7 = this.f31233u;
                float f41 = this.f31229q;
                f8 = f7 + (0.5f * f40 * f41 * 1.3f);
                f9 = (f39 + (2.2f * f40)) - (f40 * f41);
                f10 = f40 * f41 * 1.3f;
            } else if (i2 == 3) {
                canvas3.drawCircle(this.f31232t, this.f31233u, this.f31235w, this.f31224l);
                float f42 = this.f31232t;
                float f43 = this.f31234v;
                float f44 = this.f31233u;
                float f45 = this.f31229q;
                canvas.drawLine(f42 - f43, f44, (f43 * 0.5f * f45) + (f42 - (f43 * 0.5f)), (f43 * 0.65f) + f44 + (f43 * 0.35f * f45), this.f31223k);
                float f46 = this.f31232t;
                float f47 = this.f31234v;
                float f48 = this.f31229q;
                float f49 = this.f31233u;
                canvas.drawLine((f46 - (f47 * 0.5f)) + (f47 * 0.5f * f48), (f47 * 0.65f) + f49 + (f47 * 0.35f * f48), (f46 + (1.2f * f47)) - ((0.2f * f47) * f48), (f49 - (f47 * 1.3f)) + (f47 * 1.3f * f48), this.f31223k);
                float f50 = this.f31232t;
                float f51 = this.f31234v;
                float f52 = this.f31229q;
                f6 = (f50 - (f51 * 0.5f)) + (f51 * 0.5f * f52);
                float f53 = this.f31233u;
                f8 = (f51 * 0.65f) + f53 + (0.35f * f51 * f52);
                f9 = (0.5f * f51 * f52) + (f50 - (f51 * 0.5f));
                f7 = f53 + (0.65f * f51);
                f10 = f51 * 2.25f * f52;
            } else {
                return;
            }
            f2 = f7 - f10;
            canvas2 = canvas;
            f4 = f6;
            f5 = f8;
            f3 = f9;
            paint = this.f31223k;
        } else {
            float f54 = this.f31229q;
            if (((double) f54) <= 0.2d) {
                this.f31225m.setTextSize((((float) this.f31220h) / 0.2f) * f54);
            }
            canvas3.drawCircle(this.f31232t, this.f31233u, this.f31235w, this.f31224l);
            canvas.drawArc(this.f31227o, -90.0f, this.f31229q * 359.99f, false, this.f31223k);
            this.f31226n.reset();
            float f55 = this.f31217e + 2.0f;
            this.f31217e = f55;
            float f56 = this.f31232t;
            float f57 = this.f31236x;
            if (f55 > f56 - (6.0f * f57)) {
                this.f31217e = f56 - (f57 * 10.0f);
            }
            this.f31226n.moveTo(this.f31217e, this.f31233u);
            for (int i4 = 0; i4 < 4; i4++) {
                Path path = this.f31226n;
                float f58 = this.f31236x;
                path.rQuadTo(f58, (-(1.0f - this.f31229q)) * f58, f58 * 2.0f, 0.0f);
                Path path2 = this.f31226n;
                float f59 = this.f31236x;
                path2.rQuadTo(f59, (1.0f - this.f31229q) * f59, f59 * 2.0f, 0.0f);
            }
            canvas.save();
            canvas3.clipRect(this.f31228p);
            canvas3.drawPath(this.f31226n, this.f31223k);
            canvas.restore();
            if (this.f31222j != DownloadUnit.NONE) {
                int i5 = (this.f31218f > i.f27244a ? 1 : (this.f31218f == i.f27244a ? 0 : -1));
                return;
            }
            return;
        }
        canvas2.drawLine(f4, f5, f3, f2, paint);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        float f2 = (float) i2;
        this.f31230r = f2;
        float f3 = (float) i3;
        this.f31231s = f3;
        float f4 = f2 / 2.0f;
        this.f31232t = f4;
        this.f31233u = f3 / 2.0f;
        float f5 = (f2 * 5.0f) / 12.0f;
        this.f31235w = f5;
        float f6 = f5 / 3.0f;
        this.f31234v = f6;
        float f7 = (f6 * 4.4f) / 12.0f;
        this.f31236x = f7;
        this.f31217e = f4 - (f7 * 10.0f);
        float f8 = this.f31232t;
        float f9 = this.f31235w;
        float f10 = this.f31233u;
        this.f31227o = new RectF(f8 - f9, f10 - f9, f8 + f9, f10 + f9);
        float f11 = this.f31232t;
        float f12 = this.f31236x;
        this.f31228p = new RectF(f11 - (f12 * 6.0f), 0.0f, f11 + (f12 * 6.0f), this.f31231s);
    }

    public void setOnDownloadStateListener(a aVar) {
        this.f31215c = aVar;
    }
}
