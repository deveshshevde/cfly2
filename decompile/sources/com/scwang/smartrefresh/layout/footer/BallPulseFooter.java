package com.scwang.smartrefresh.layout.footer;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import ja.f;
import ja.j;
import jc.b;
import m.a;

public class BallPulseFooter extends InternalAbstract implements f {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f12108a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f12109b;

    /* renamed from: c  reason: collision with root package name */
    protected Paint f12110c;

    /* renamed from: d  reason: collision with root package name */
    protected int f12111d;

    /* renamed from: e  reason: collision with root package name */
    protected int f12112e;

    /* renamed from: f  reason: collision with root package name */
    protected float f12113f;

    /* renamed from: g  reason: collision with root package name */
    protected long f12114g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f12115h;

    /* renamed from: i  reason: collision with root package name */
    protected TimeInterpolator f12116i;

    public BallPulseFooter(Context context) {
        this(context, (AttributeSet) null);
    }

    public BallPulseFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f12111d = -1118482;
        this.f12112e = -1615546;
        this.f12114g = 0;
        this.f12115h = false;
        this.f12116i = new AccelerateDecelerateInterpolator();
        setMinimumHeight(b.a(60.0f));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BallPulseFooter);
        Paint paint = new Paint();
        this.f12110c = paint;
        paint.setColor(-1);
        this.f12110c.setStyle(Paint.Style.FILL);
        this.f12110c.setAntiAlias(true);
        this.f12189y = com.scwang.smartrefresh.layout.constant.b.f12099a;
        this.f12189y = com.scwang.smartrefresh.layout.constant.b.f12104f[obtainStyledAttributes.getInt(R.styleable.BallPulseFooter_srlClassicsSpinnerStyle, this.f12189y.f12105g)];
        if (obtainStyledAttributes.hasValue(R.styleable.BallPulseFooter_srlNormalColor)) {
            a(obtainStyledAttributes.getColor(R.styleable.BallPulseFooter_srlNormalColor, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.BallPulseFooter_srlAnimatingColor)) {
            b(obtainStyledAttributes.getColor(R.styleable.BallPulseFooter_srlAnimatingColor, 0));
        }
        obtainStyledAttributes.recycle();
        this.f12113f = (float) b.a(4.0f);
    }

    public int a(j jVar, boolean z2) {
        this.f12115h = false;
        this.f12114g = 0;
        this.f12110c.setColor(this.f12111d);
        return 0;
    }

    public BallPulseFooter a(int i2) {
        this.f12111d = i2;
        this.f12108a = true;
        if (!this.f12115h) {
            this.f12110c.setColor(i2);
        }
        return this;
    }

    public BallPulseFooter b(int i2) {
        this.f12112e = i2;
        this.f12109b = true;
        if (this.f12115h) {
            this.f12110c.setColor(i2);
        }
        return this;
    }

    public void b(j jVar, int i2, int i3) {
        if (!this.f12115h) {
            invalidate();
            this.f12115h = true;
            this.f12114g = System.currentTimeMillis();
            this.f12110c.setColor(this.f12112e);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Canvas canvas2 = canvas;
        int width = getWidth();
        int height = getHeight();
        float f2 = this.f12113f;
        float min = (((float) Math.min(width, height)) - (f2 * 2.0f)) / 6.0f;
        float f3 = min * 2.0f;
        float f4 = (((float) width) / 2.0f) - (f2 + f3);
        float f5 = ((float) height) / 2.0f;
        long currentTimeMillis = System.currentTimeMillis();
        int i2 = 0;
        while (i2 < 3) {
            int i3 = i2 + 1;
            long j2 = (currentTimeMillis - this.f12114g) - ((long) (i3 * 120));
            float interpolation = this.f12116i.getInterpolation(j2 > 0 ? ((float) (j2 % 750)) / 750.0f : 0.0f);
            canvas.save();
            float f6 = (float) i2;
            canvas2.translate((f3 * f6) + f4 + (this.f12113f * f6), f5);
            if (((double) interpolation) < 0.5d) {
                float f7 = 1.0f - ((interpolation * 2.0f) * 0.7f);
                canvas2.scale(f7, f7);
            } else {
                float f8 = ((interpolation * 2.0f) * 0.7f) - 0.4f;
                canvas2.scale(f8, f8);
            }
            canvas2.drawCircle(0.0f, 0.0f, min, this.f12110c);
            canvas.restore();
            i2 = i3;
        }
        super.dispatchDraw(canvas);
        if (this.f12115h) {
            invalidate();
        }
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        int a2;
        if (!this.f12109b && iArr.length > 1) {
            b(iArr[0]);
            this.f12109b = false;
        }
        if (!this.f12108a) {
            if (iArr.length > 1) {
                a2 = iArr[1];
            } else {
                if (iArr.length > 0) {
                    a2 = a.a(-1711276033, iArr[0]);
                }
                this.f12108a = false;
            }
            a(a2);
            this.f12108a = false;
        }
    }
}
