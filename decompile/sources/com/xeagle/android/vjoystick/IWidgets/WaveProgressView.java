package com.xeagle.android.vjoystick.IWidgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.TextView;
import com.xeagle.R;

public class WaveProgressView extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f24672a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f24673b;

    /* renamed from: c  reason: collision with root package name */
    private Path f24674c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f24675d;

    /* renamed from: e  reason: collision with root package name */
    private Bitmap f24676e;

    /* renamed from: f  reason: collision with root package name */
    private Canvas f24677f;

    /* renamed from: g  reason: collision with root package name */
    private b f24678g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public TextView f24679h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public a f24680i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public float f24681j;

    /* renamed from: k  reason: collision with root package name */
    private float f24682k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public int f24683l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public float f24684m;

    /* renamed from: n  reason: collision with root package name */
    private int f24685n;

    /* renamed from: o  reason: collision with root package name */
    private int f24686o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public float f24687p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public float f24688q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public float f24689r;

    /* renamed from: s  reason: collision with root package name */
    private int f24690s;

    /* renamed from: t  reason: collision with root package name */
    private int f24691t;

    /* renamed from: u  reason: collision with root package name */
    private int f24692u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f24693v;

    public interface a {
        float a(float f2, float f3);

        String a(float f2, float f3, float f4);
    }

    public class b extends Animation {
        public b() {
        }

        /* access modifiers changed from: protected */
        public void applyTransformation(float f2, Transformation transformation) {
            super.applyTransformation(f2, transformation);
            if (WaveProgressView.this.f24687p < WaveProgressView.this.f24688q / WaveProgressView.this.f24689r) {
                WaveProgressView waveProgressView = WaveProgressView.this;
                float unused = waveProgressView.f24687p = (waveProgressView.f24688q * f2) / WaveProgressView.this.f24689r;
                if (!(WaveProgressView.this.f24679h == null || WaveProgressView.this.f24680i == null)) {
                    WaveProgressView.this.f24679h.setText(WaveProgressView.this.f24680i.a(f2, WaveProgressView.this.f24688q, WaveProgressView.this.f24689r));
                }
            }
            WaveProgressView waveProgressView2 = WaveProgressView.this;
            float unused2 = waveProgressView2.f24684m = f2 * ((float) waveProgressView2.f24683l) * WaveProgressView.this.f24681j * 2.0f;
            WaveProgressView.this.postInvalidate();
        }
    }

    public WaveProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    private int a(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min(i2, size) : i2;
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WaveProgressView);
        this.f24681j = obtainStyledAttributes.getDimension(4, (float) com.xeagle.android.vjoystick.utils.a.a(context, 25.0f));
        this.f24682k = obtainStyledAttributes.getDimension(3, (float) com.xeagle.android.vjoystick.utils.a.a(context, 5.0f));
        this.f24690s = obtainStyledAttributes.getColor(2, -16711936);
        this.f24691t = obtainStyledAttributes.getColor(0, getResources().getColor(com.cfly.uav_pro.R.color.light));
        this.f24692u = obtainStyledAttributes.getColor(1, -7829368);
        obtainStyledAttributes.recycle();
        int a2 = com.xeagle.android.vjoystick.utils.a.a(context, 100.0f);
        this.f24686o = a2;
        this.f24683l = (int) Math.ceil(Double.parseDouble(String.valueOf((((float) a2) / this.f24681j) / 2.0f)));
        this.f24684m = 0.0f;
        this.f24674c = new Path();
        Paint paint = new Paint();
        this.f24673b = paint;
        paint.setColor(this.f24690s);
        this.f24673b.setAntiAlias(true);
        this.f24673b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        Paint paint2 = new Paint();
        this.f24675d = paint2;
        paint2.setColor(this.f24691t);
        this.f24675d.setAntiAlias(true);
        this.f24675d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        Paint paint3 = new Paint();
        this.f24672a = paint3;
        paint3.setColor(this.f24692u);
        this.f24672a.setAntiAlias(true);
        b bVar = new b();
        this.f24678g = bVar;
        bVar.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
            }
        });
        this.f24687p = 0.0f;
        this.f24688q = 0.0f;
        this.f24689r = 100.0f;
        this.f24693v = false;
    }

    private Path getSecondWavePath() {
        float f2 = this.f24682k;
        a aVar = this.f24680i;
        if (aVar != null) {
            f2 = (aVar.a(this.f24687p, f2) != 0.0f || this.f24687p >= 1.0f) ? this.f24680i.a(this.f24687p, this.f24682k) : this.f24682k;
        }
        this.f24674c.reset();
        this.f24674c.moveTo(0.0f, (1.0f - this.f24687p) * ((float) this.f24685n));
        this.f24674c.lineTo(0.0f, (float) this.f24685n);
        Path path = this.f24674c;
        int i2 = this.f24685n;
        path.lineTo((float) i2, (float) i2);
        Path path2 = this.f24674c;
        int i3 = this.f24685n;
        path2.lineTo(((float) i3) + this.f24684m, (1.0f - this.f24687p) * ((float) i3));
        for (int i4 = 0; i4 < this.f24683l * 2; i4++) {
            Path path3 = this.f24674c;
            float f3 = this.f24681j;
            path3.rQuadTo((-f3) / 2.0f, f2, -f3, 0.0f);
            Path path4 = this.f24674c;
            float f4 = this.f24681j;
            path4.rQuadTo((-f4) / 2.0f, -f2, -f4, 0.0f);
        }
        this.f24674c.close();
        return this.f24674c;
    }

    private Path getWavePath() {
        float f2 = this.f24682k;
        a aVar = this.f24680i;
        if (aVar != null) {
            f2 = (aVar.a(this.f24687p, f2) != 0.0f || this.f24687p >= 1.0f) ? this.f24680i.a(this.f24687p, this.f24682k) : this.f24682k;
        }
        this.f24674c.reset();
        Path path = this.f24674c;
        int i2 = this.f24685n;
        path.moveTo((float) i2, (1.0f - this.f24687p) * ((float) i2));
        Path path2 = this.f24674c;
        int i3 = this.f24685n;
        path2.lineTo((float) i3, (float) i3);
        this.f24674c.lineTo(0.0f, (float) this.f24685n);
        this.f24674c.lineTo(-this.f24684m, (1.0f - this.f24687p) * ((float) this.f24685n));
        for (int i4 = 0; i4 < this.f24683l * 2; i4++) {
            Path path3 = this.f24674c;
            float f3 = this.f24681j;
            path3.rQuadTo(f3 / 2.0f, f2, f3, 0.0f);
            Path path4 = this.f24674c;
            float f4 = this.f24681j;
            path4.rQuadTo(f4 / 2.0f, -f2, f4, 0.0f);
        }
        this.f24674c.close();
        return this.f24674c;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i2 = this.f24685n;
        this.f24676e = Bitmap.createBitmap(i2, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(this.f24676e);
        this.f24677f = canvas2;
        int i3 = this.f24685n;
        canvas2.drawCircle((float) (i3 / 2), (float) (i3 / 2), (float) (i3 / 2), this.f24672a);
        this.f24677f.drawPath(getWavePath(), this.f24673b);
        if (this.f24693v) {
            this.f24677f.drawPath(getSecondWavePath(), this.f24675d);
        }
        canvas.drawBitmap(this.f24676e, 0.0f, 0.0f, (Paint) null);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int min = Math.min(a(this.f24686o, i2), a(this.f24686o, i3));
        setMeasuredDimension(min, min);
        this.f24685n = min;
        this.f24683l = (int) Math.ceil(Double.parseDouble(String.valueOf((((float) min) / this.f24681j) / 2.0f)));
    }

    public void setDrawSecondWave(boolean z2) {
        this.f24693v = z2;
    }

    public void setOnAnimationListener(a aVar) {
        this.f24680i = aVar;
    }

    public void setTextView(TextView textView) {
        this.f24679h = textView;
    }
}
