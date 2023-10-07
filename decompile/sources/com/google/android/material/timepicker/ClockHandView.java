package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.google.android.material.R;
import java.util.ArrayList;
import java.util.List;
import t.ac;

class ClockHandView extends View {

    /* renamed from: a  reason: collision with root package name */
    private ValueAnimator f19904a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f19905b;

    /* renamed from: c  reason: collision with root package name */
    private float f19906c;

    /* renamed from: d  reason: collision with root package name */
    private float f19907d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f19908e;

    /* renamed from: f  reason: collision with root package name */
    private int f19909f;

    /* renamed from: g  reason: collision with root package name */
    private final List<b> f19910g;

    /* renamed from: h  reason: collision with root package name */
    private final int f19911h;

    /* renamed from: i  reason: collision with root package name */
    private final float f19912i;

    /* renamed from: j  reason: collision with root package name */
    private final Paint f19913j;

    /* renamed from: k  reason: collision with root package name */
    private final RectF f19914k;

    /* renamed from: l  reason: collision with root package name */
    private final int f19915l;

    /* renamed from: m  reason: collision with root package name */
    private float f19916m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f19917n;

    /* renamed from: o  reason: collision with root package name */
    private a f19918o;

    /* renamed from: p  reason: collision with root package name */
    private double f19919p;

    /* renamed from: q  reason: collision with root package name */
    private int f19920q;

    public interface a {
        void b(float f2, boolean z2);
    }

    public interface b {
        void a(float f2, boolean z2);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialClockStyle);
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f19910g = new ArrayList();
        Paint paint = new Paint();
        this.f19913j = paint;
        this.f19914k = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClockHandView, i2, R.style.Widget_MaterialComponents_TimePicker_Clock);
        this.f19920q = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_materialCircleRadius, 0);
        this.f19911h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_selectorSize, 0);
        Resources resources = getResources();
        this.f19915l = resources.getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.f19912i = (float) resources.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = obtainStyledAttributes.getColor(R.styleable.ClockHandView_clockHandColor, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        a(0.0f);
        this.f19909f = ViewConfiguration.get(context).getScaledTouchSlop();
        ac.b((View) this, 2);
        obtainStyledAttributes.recycle();
    }

    private int a(float f2, float f3) {
        int degrees = ((int) Math.toDegrees(Math.atan2((double) (f3 - ((float) (getHeight() / 2))), (double) (f2 - ((float) (getWidth() / 2)))))) + 90;
        return degrees < 0 ? degrees + SpatialRelationUtil.A_CIRCLE_DEGREE : degrees;
    }

    private void a(Canvas canvas) {
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f2 = (float) width;
        float f3 = (float) height;
        this.f19913j.setStrokeWidth(0.0f);
        canvas.drawCircle((((float) this.f19920q) * ((float) Math.cos(this.f19919p))) + f2, (((float) this.f19920q) * ((float) Math.sin(this.f19919p))) + f3, (float) this.f19911h, this.f19913j);
        double sin = Math.sin(this.f19919p);
        double cos = Math.cos(this.f19919p);
        double d2 = (double) ((float) (this.f19920q - this.f19911h));
        Double.isNaN(d2);
        float f4 = (float) (width + ((int) (cos * d2)));
        Double.isNaN(d2);
        float f5 = (float) (height + ((int) (d2 * sin)));
        this.f19913j.setStrokeWidth((float) this.f19915l);
        canvas.drawLine(f2, f3, f4, f5, this.f19913j);
        canvas.drawCircle(f2, f3, this.f19912i, this.f19913j);
    }

    private boolean a(float f2, float f3, boolean z2, boolean z3, boolean z4) {
        float a2 = (float) a(f2, f3);
        boolean z5 = false;
        boolean z6 = a() != a2;
        if (z3 && z6) {
            return true;
        }
        if (!z6 && !z2) {
            return false;
        }
        if (z4 && this.f19905b) {
            z5 = true;
        }
        a(a2, z5);
        return true;
    }

    private Pair<Float, Float> b(float f2) {
        float a2 = a();
        if (Math.abs(a2 - f2) > 180.0f) {
            if (a2 > 180.0f && f2 < 180.0f) {
                f2 += 360.0f;
            }
            if (a2 < 180.0f && f2 > 180.0f) {
                a2 += 360.0f;
            }
        }
        return new Pair<>(Float.valueOf(a2), Float.valueOf(f2));
    }

    /* access modifiers changed from: private */
    public void b(float f2, boolean z2) {
        float f3 = f2 % 360.0f;
        this.f19916m = f3;
        this.f19919p = Math.toRadians((double) (f3 - 90.0f));
        float width = ((float) (getWidth() / 2)) + (((float) this.f19920q) * ((float) Math.cos(this.f19919p)));
        float height = ((float) (getHeight() / 2)) + (((float) this.f19920q) * ((float) Math.sin(this.f19919p)));
        RectF rectF = this.f19914k;
        int i2 = this.f19911h;
        rectF.set(width - ((float) i2), height - ((float) i2), width + ((float) i2), height + ((float) i2));
        for (b a2 : this.f19910g) {
            a2.a(f3, z2);
        }
        invalidate();
    }

    public float a() {
        return this.f19916m;
    }

    public void a(float f2) {
        a(f2, false);
    }

    public void a(float f2, boolean z2) {
        ValueAnimator valueAnimator = this.f19904a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z2) {
            b(f2, false);
            return;
        }
        Pair<Float, Float> b2 = b(f2);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{((Float) b2.first).floatValue(), ((Float) b2.second).floatValue()});
        this.f19904a = ofFloat;
        ofFloat.setDuration(200);
        this.f19904a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ClockHandView.this.b(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
            }
        });
        this.f19904a.addListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                animator.end();
            }
        });
        this.f19904a.start();
    }

    public void a(int i2) {
        this.f19920q = i2;
        invalidate();
    }

    public void a(a aVar) {
        this.f19918o = aVar;
    }

    public void a(b bVar) {
        this.f19910g.add(bVar);
    }

    public void a(boolean z2) {
        this.f19905b = z2;
    }

    public RectF b() {
        return this.f19914k;
    }

    public int c() {
        return this.f19911h;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        a(canvas);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        a(a());
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        boolean z3;
        boolean z4;
        a aVar;
        int actionMasked = motionEvent.getActionMasked();
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 2) {
                int i2 = (int) (x2 - this.f19906c);
                int i3 = (int) (y2 - this.f19907d);
                this.f19908e = (i2 * i2) + (i3 * i3) > this.f19909f;
                boolean z5 = this.f19917n;
                z4 = actionMasked == 1;
                z3 = z5;
            } else {
                z4 = false;
                z3 = false;
            }
            z2 = false;
        } else {
            this.f19906c = x2;
            this.f19907d = y2;
            this.f19908e = true;
            this.f19917n = false;
            z4 = false;
            z3 = false;
            z2 = true;
        }
        boolean a2 = a(x2, y2, z3, z2, z4) | this.f19917n;
        this.f19917n = a2;
        if (a2 && z4 && (aVar = this.f19918o) != null) {
            aVar.b((float) a(x2, y2), this.f19908e);
        }
        return true;
    }
}
