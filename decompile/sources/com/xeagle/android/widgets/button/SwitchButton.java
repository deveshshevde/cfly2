package com.xeagle.android.widgets.button;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.CompoundButton;
import androidx.core.content.b;
import com.xeagle.R;

public class SwitchButton extends CompoundButton {

    /* renamed from: a  reason: collision with root package name */
    private static int[] f25799a = {16842912, 16842910, 16842919};

    /* renamed from: b  reason: collision with root package name */
    private static int[] f25800b = {-16842912, 16842910, 16842919};
    private ObjectAnimator A;
    private float B;
    private RectF C;
    private float D;
    private float E;
    private float F;
    private int G;
    private int H;
    private Paint I;

    /* renamed from: c  reason: collision with root package name */
    private Drawable f25801c;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f25802d;

    /* renamed from: e  reason: collision with root package name */
    private ColorStateList f25803e;

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f25804f;

    /* renamed from: g  reason: collision with root package name */
    private float f25805g;

    /* renamed from: h  reason: collision with root package name */
    private float f25806h;

    /* renamed from: i  reason: collision with root package name */
    private RectF f25807i;

    /* renamed from: j  reason: collision with root package name */
    private float f25808j;

    /* renamed from: k  reason: collision with root package name */
    private long f25809k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f25810l;

    /* renamed from: m  reason: collision with root package name */
    private int f25811m;

    /* renamed from: n  reason: collision with root package name */
    private PointF f25812n;

    /* renamed from: o  reason: collision with root package name */
    private int f25813o;

    /* renamed from: p  reason: collision with root package name */
    private int f25814p;

    /* renamed from: q  reason: collision with root package name */
    private int f25815q;

    /* renamed from: r  reason: collision with root package name */
    private Drawable f25816r;

    /* renamed from: s  reason: collision with root package name */
    private Drawable f25817s;

    /* renamed from: t  reason: collision with root package name */
    private RectF f25818t;

    /* renamed from: u  reason: collision with root package name */
    private RectF f25819u;

    /* renamed from: v  reason: collision with root package name */
    private RectF f25820v;

    /* renamed from: w  reason: collision with root package name */
    private Paint f25821w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f25822x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f25823y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f25824z = false;

    public SwitchButton(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }

    private int a(int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int i3 = (int) (this.f25812n.x * this.f25808j);
        if (this.f25823y) {
            i3 = Math.max(i3, this.f25802d.getMinimumWidth());
        }
        int max = Math.max(i3, (int) (((float) i3) + this.f25807i.left + this.f25807i.right));
        int max2 = Math.max(Math.max(max, getPaddingLeft() + max + getPaddingRight()), getSuggestedMinimumWidth());
        return mode == 1073741824 ? Math.max(max2, size) : mode == Integer.MIN_VALUE ? Math.min(max2, size) : max2;
    }

    private void a() {
        float paddingTop = ((float) getPaddingTop()) + Math.max(0.0f, this.f25807i.top);
        float paddingLeft = ((float) getPaddingLeft()) + Math.max(0.0f, this.f25807i.left);
        if (this.f25822x) {
            PointF pointF = this.f25812n;
            pointF.x = Math.max(pointF.x, (float) this.f25801c.getMinimumWidth());
            PointF pointF2 = this.f25812n;
            pointF2.y = Math.max(pointF2.y, (float) this.f25801c.getMinimumHeight());
        }
        this.f25818t.set(paddingLeft, paddingTop, this.f25812n.x + paddingLeft, this.f25812n.y + paddingTop);
        float f2 = this.f25818t.left - this.f25807i.left;
        this.f25819u.set(f2, this.f25818t.top - this.f25807i.top, this.f25807i.left + f2 + (this.f25812n.x * this.f25808j) + this.f25807i.right, this.f25818t.bottom + this.f25807i.bottom);
        this.f25820v.set(this.f25818t.left, 0.0f, (this.f25819u.right - this.f25807i.right) - this.f25818t.width(), 0.0f);
        this.f25806h = Math.min(Math.min(this.f25819u.width(), this.f25819u.height()) / 2.0f, this.f25806h);
        Drawable drawable = this.f25802d;
        if (drawable != null) {
            drawable.setBounds((int) this.f25819u.left, (int) this.f25819u.top, (int) this.f25819u.right, (int) this.f25819u.bottom);
        }
    }

    private void a(AttributeSet attributeSet) {
        float f2;
        int i2;
        float f3;
        float f4;
        ColorStateList colorStateList;
        float f5;
        float f6;
        Drawable drawable;
        ColorStateList colorStateList2;
        float f7;
        float f8;
        int i3;
        int i4;
        boolean z2;
        AttributeSet attributeSet2 = attributeSet;
        this.G = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.H = ViewConfiguration.getPressedStateDuration() + ViewConfiguration.getTapTimeout();
        this.f25821w = new Paint(1);
        Paint paint = new Paint(1);
        this.I = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.I.setStrokeWidth(getResources().getDisplayMetrics().density);
        this.f25818t = new RectF();
        this.f25819u = new RectF();
        this.f25820v = new RectF();
        this.f25812n = new PointF();
        this.f25807i = new RectF();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this, "process", new float[]{0.0f, 0.0f}).setDuration(250);
        this.A = duration;
        duration.setInterpolator(new AccelerateDecelerateInterpolator());
        this.C = new RectF();
        float f9 = getResources().getDisplayMetrics().density;
        float f10 = f9 * 2.0f;
        float f11 = f9 * 20.0f;
        float f12 = f11 / 2.0f;
        Drawable drawable2 = null;
        TypedArray obtainStyledAttributes = attributeSet2 == null ? null : getContext().obtainStyledAttributes(attributeSet2, R.styleable.SwitchButton);
        if (obtainStyledAttributes != null) {
            drawable2 = obtainStyledAttributes.getDrawable(7);
            ColorStateList colorStateList3 = obtainStyledAttributes.getColorStateList(6);
            float dimension = obtainStyledAttributes.getDimension(9, f10);
            float dimension2 = obtainStyledAttributes.getDimension(11, dimension);
            float dimension3 = obtainStyledAttributes.getDimension(12, dimension);
            float dimension4 = obtainStyledAttributes.getDimension(13, dimension);
            float dimension5 = obtainStyledAttributes.getDimension(10, dimension);
            float dimension6 = obtainStyledAttributes.getDimension(15, f11);
            float dimension7 = obtainStyledAttributes.getDimension(8, f11);
            float dimension8 = obtainStyledAttributes.getDimension(14, Math.min(dimension6, dimension7) / 2.0f);
            f7 = obtainStyledAttributes.getDimension(4, f10 + dimension8);
            Drawable drawable3 = obtainStyledAttributes.getDrawable(2);
            colorStateList = obtainStyledAttributes.getColorStateList(1);
            float f13 = obtainStyledAttributes.getFloat(3, 1.8f);
            Drawable drawable4 = drawable3;
            int integer = obtainStyledAttributes.getInteger(0, 250);
            boolean z3 = obtainStyledAttributes.getBoolean(5, true);
            i3 = Integer.MIN_VALUE;
            i4 = obtainStyledAttributes.getColor(16, Integer.MIN_VALUE);
            obtainStyledAttributes.recycle();
            f2 = dimension2;
            i2 = integer;
            z2 = z3;
            f3 = f13;
            f5 = dimension5;
            drawable = drawable4;
            float f14 = dimension8;
            f8 = dimension7;
            f11 = dimension6;
            f4 = dimension3;
            f6 = dimension4;
            colorStateList2 = colorStateList3;
            f12 = f14;
        } else {
            i3 = Integer.MIN_VALUE;
            f8 = f11;
            f7 = f12;
            colorStateList2 = null;
            drawable = null;
            colorStateList = null;
            z2 = true;
            i4 = Integer.MIN_VALUE;
            f6 = 0.0f;
            f5 = 0.0f;
            f4 = 0.0f;
            f3 = 1.8f;
            i2 = 250;
            f2 = 0.0f;
        }
        this.f25801c = drawable2;
        this.f25804f = colorStateList2;
        boolean z4 = drawable2 != null;
        this.f25822x = z4;
        this.f25811m = i4;
        if (i4 == i3) {
            this.f25811m = 3309506;
        }
        if (!z4 && colorStateList2 == null) {
            ColorStateList a2 = a.a(this.f25811m);
            this.f25804f = a2;
            this.f25813o = a2.getDefaultColor();
        }
        if (this.f25822x) {
            f11 = Math.max(f11, (float) this.f25801c.getMinimumWidth());
            f8 = Math.max(f8, (float) this.f25801c.getMinimumHeight());
        }
        this.f25812n.set(f11, f8);
        this.f25802d = drawable;
        this.f25803e = colorStateList;
        boolean z5 = drawable != null;
        this.f25823y = z5;
        if (!z5 && colorStateList == null) {
            ColorStateList b2 = a.b(this.f25811m);
            this.f25803e = b2;
            int defaultColor = b2.getDefaultColor();
            this.f25814p = defaultColor;
            this.f25815q = this.f25803e.getColorForState(f25799a, defaultColor);
        }
        this.f25807i.set(f2, f6, f4, f5);
        if (this.f25807i.width() >= 0.0f) {
            f3 = Math.max(f3, 1.0f);
        }
        this.f25808j = f3;
        this.f25805g = f12;
        this.f25806h = f7;
        long j2 = (long) i2;
        this.f25809k = j2;
        this.f25810l = z2;
        this.A.setDuration(j2);
        setFocusable(true);
        setClickable(true);
        if (isChecked()) {
            setProcess(1.0f);
        }
    }

    private int b(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int max = Math.max((int) Math.max(this.f25812n.y, this.f25812n.y + this.f25807i.top + this.f25807i.right), getSuggestedMinimumHeight());
        int max2 = Math.max(max, getPaddingTop() + max + getPaddingBottom());
        return mode == 1073741824 ? Math.max(max2, size) : mode == Integer.MIN_VALUE ? Math.min(max2, size) : max2;
    }

    private void b() {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    private boolean getStatusBasedOnPos() {
        return getProcess() > 0.5f;
    }

    private void setDrawableState(Drawable drawable) {
        if (drawable != null) {
            drawable.setState(getDrawableState());
            invalidate();
        }
    }

    public void a(float f2, float f3) {
        this.f25812n.set(f2, f3);
        a();
        requestLayout();
    }

    public void a(float f2, float f3, float f4, float f5) {
        this.f25807i.set(f2, f3, f4, f5);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2) {
        ObjectAnimator objectAnimator = this.A;
        if (objectAnimator != null) {
            if (objectAnimator.isRunning()) {
                this.A.cancel();
            }
            this.A.setDuration(this.f25809k);
            if (z2) {
                this.A.setFloatValues(new float[]{this.B, 1.0f});
            } else {
                this.A.setFloatValues(new float[]{this.B, 0.0f});
            }
            this.A.start();
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        Drawable drawable;
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        super.drawableStateChanged();
        if (this.f25822x || (colorStateList2 = this.f25804f) == null) {
            setDrawableState(this.f25801c);
        } else {
            this.f25813o = colorStateList2.getColorForState(getDrawableState(), this.f25813o);
        }
        int[] iArr = isChecked() ? f25800b : f25799a;
        if (this.f25823y || (colorStateList = this.f25803e) == null) {
            Drawable drawable2 = this.f25802d;
            if (!(drawable2 instanceof StateListDrawable) || !this.f25810l) {
                drawable = null;
            } else {
                drawable2.setState(iArr);
                drawable = this.f25802d.getCurrent().mutate();
            }
            this.f25817s = drawable;
            setDrawableState(this.f25802d);
            Drawable drawable3 = this.f25802d;
            if (drawable3 != null) {
                this.f25816r = drawable3.getCurrent().mutate();
                return;
            }
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), this.f25814p);
        this.f25814p = colorForState;
        this.f25815q = this.f25803e.getColorForState(iArr, colorForState);
    }

    public long getAnimationDuration() {
        return this.f25809k;
    }

    public ColorStateList getBackColor() {
        return this.f25803e;
    }

    public Drawable getBackDrawable() {
        return this.f25802d;
    }

    public float getBackMeasureRatio() {
        return this.f25808j;
    }

    public float getBackRadius() {
        return this.f25806h;
    }

    public PointF getBackSizeF() {
        return new PointF(this.f25819u.width(), this.f25819u.height());
    }

    public final float getProcess() {
        return this.B;
    }

    public ColorStateList getThumbColor() {
        return this.f25804f;
    }

    public Drawable getThumbDrawable() {
        return this.f25801c;
    }

    public float getThumbHeight() {
        return this.f25812n.y;
    }

    public RectF getThumbMargin() {
        return this.f25807i;
    }

    public float getThumbRadius() {
        return this.f25805g;
    }

    public PointF getThumbSizeF() {
        return this.f25812n;
    }

    public float getThumbWidth() {
        return this.f25812n.x;
    }

    public int getTintColor() {
        return this.f25811m;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Drawable drawable;
        super.onDraw(canvas);
        if (this.f25823y) {
            if (!this.f25810l || this.f25816r == null || this.f25817s == null) {
                this.f25802d.setAlpha(255);
                drawable = this.f25802d;
            } else {
                int process = (int) ((isChecked() ? getProcess() : 1.0f - getProcess()) * 255.0f);
                this.f25816r.setAlpha(process);
                this.f25816r.draw(canvas);
                this.f25817s.setAlpha(255 - process);
                drawable = this.f25817s;
            }
            drawable.draw(canvas);
        } else if (this.f25810l) {
            int process2 = (int) ((isChecked() ? getProcess() : 1.0f - getProcess()) * 255.0f);
            this.f25821w.setARGB((Color.alpha(this.f25814p) * process2) / 255, Color.red(this.f25814p), Color.green(this.f25814p), Color.blue(this.f25814p));
            RectF rectF = this.f25819u;
            float f2 = this.f25806h;
            canvas.drawRoundRect(rectF, f2, f2, this.f25821w);
            this.f25821w.setARGB((Color.alpha(this.f25815q) * (255 - process2)) / 255, Color.red(this.f25815q), Color.green(this.f25815q), Color.blue(this.f25815q));
            RectF rectF2 = this.f25819u;
            float f3 = this.f25806h;
            canvas.drawRoundRect(rectF2, f3, f3, this.f25821w);
            this.f25821w.setAlpha(255);
        } else {
            this.f25821w.setColor(this.f25814p);
            RectF rectF3 = this.f25819u;
            float f4 = this.f25806h;
            canvas.drawRoundRect(rectF3, f4, f4, this.f25821w);
        }
        this.C.set(this.f25818t);
        this.C.offset(this.B * this.f25820v.width(), 0.0f);
        if (this.f25822x) {
            this.f25801c.setBounds((int) this.C.left, (int) this.C.top, (int) this.C.right, (int) this.C.bottom);
            this.f25801c.draw(canvas);
        } else {
            this.f25821w.setColor(this.f25813o);
            RectF rectF4 = this.C;
            float f5 = this.f25805g;
            canvas.drawRoundRect(rectF4, f5, f5, this.f25821w);
        }
        if (this.f25824z) {
            this.I.setColor(Color.parseColor("#AA0000"));
            canvas.drawRect(this.f25819u, this.I);
            this.I.setColor(Color.parseColor("#0000FF"));
            canvas.drawRect(this.C, this.I);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(a(i2), b(i3));
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4 || i3 != i5) {
            a();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        if (r0 != 3) goto L_0x0096;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            boolean r0 = r9.isEnabled()
            r1 = 0
            if (r0 == 0) goto L_0x0097
            boolean r0 = r9.isClickable()
            if (r0 != 0) goto L_0x000f
            goto L_0x0097
        L_0x000f:
            int r0 = r10.getAction()
            float r2 = r10.getX()
            float r3 = r9.D
            float r2 = r2 - r3
            float r3 = r10.getY()
            float r4 = r9.E
            float r3 = r3 - r4
            r4 = 1
            if (r0 == 0) goto L_0x0080
            if (r0 == r4) goto L_0x0047
            r5 = 2
            if (r0 == r5) goto L_0x002d
            r5 = 3
            if (r0 == r5) goto L_0x0047
            goto L_0x0096
        L_0x002d:
            float r10 = r10.getX()
            float r0 = r9.getProcess()
            float r1 = r9.F
            float r1 = r10 - r1
            android.graphics.RectF r2 = r9.f25820v
            float r2 = r2.width()
            float r1 = r1 / r2
            float r0 = r0 + r1
            r9.setProcess(r0)
            r9.F = r10
            goto L_0x0096
        L_0x0047:
            r9.setPressed(r1)
            boolean r0 = r9.getStatusBasedOnPos()
            long r5 = r10.getEventTime()
            long r7 = r10.getDownTime()
            long r5 = r5 - r7
            float r10 = (float) r5
            int r5 = r9.G
            float r6 = (float) r5
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 >= 0) goto L_0x006f
            float r2 = (float) r5
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x006f
            int r2 = r9.H
            float r2 = (float) r2
            int r10 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r10 >= 0) goto L_0x006f
            r9.performClick()
            goto L_0x0096
        L_0x006f:
            boolean r10 = r9.isChecked()
            if (r0 == r10) goto L_0x007c
            r9.playSoundEffect(r1)
            r9.setChecked(r0)
            goto L_0x0096
        L_0x007c:
            r9.a((boolean) r0)
            goto L_0x0096
        L_0x0080:
            r9.b()
            float r0 = r10.getX()
            r9.D = r0
            float r10 = r10.getY()
            r9.E = r10
            float r10 = r9.D
            r9.F = r10
            r9.setPressed(r4)
        L_0x0096:
            return r4
        L_0x0097:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.widgets.button.SwitchButton.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean performClick() {
        return super.performClick();
    }

    public void setAnimationDuration(long j2) {
        this.f25809k = j2;
    }

    public void setBackColor(ColorStateList colorStateList) {
        this.f25803e = colorStateList;
        if (colorStateList != null) {
            setBackDrawable((Drawable) null);
        }
        invalidate();
    }

    public void setBackDrawable(Drawable drawable) {
        this.f25802d = drawable;
        this.f25823y = drawable != null;
        a();
        refreshDrawableState();
        requestLayout();
        invalidate();
    }

    public void setBackDrawableRes(int i2) {
        setBackDrawable(b.a(getContext(), i2));
    }

    public void setBackMeasureRatio(float f2) {
        this.f25808j = f2;
        requestLayout();
    }

    public void setBackRadius(float f2) {
        this.f25806h = f2;
        if (!this.f25823y) {
            invalidate();
        }
    }

    public void setChecked(boolean z2) {
        if (isChecked() != z2) {
            a(z2);
        }
        super.setChecked(z2);
    }

    public void setCheckedImmediately(boolean z2) {
        super.setChecked(z2);
        ObjectAnimator objectAnimator = this.A;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.A.cancel();
        }
        setProcess(z2 ? 1.0f : 0.0f);
        invalidate();
    }

    public void setDrawDebugRect(boolean z2) {
        this.f25824z = z2;
        invalidate();
    }

    public void setFadeBack(boolean z2) {
        this.f25810l = z2;
    }

    public final void setProcess(float f2) {
        if (f2 > 1.0f) {
            f2 = 1.0f;
        } else if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        this.B = f2;
        invalidate();
    }

    public void setThumbColor(ColorStateList colorStateList) {
        this.f25804f = colorStateList;
        if (colorStateList != null) {
            setThumbDrawable((Drawable) null);
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        this.f25801c = drawable;
        this.f25822x = drawable != null;
        a();
        refreshDrawableState();
        requestLayout();
        invalidate();
    }

    public void setThumbDrawableRes(int i2) {
        setThumbDrawable(b.a(getContext(), i2));
    }

    public void setThumbMargin(RectF rectF) {
        if (rectF == null) {
            a(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            a(rectF.left, rectF.top, rectF.right, rectF.bottom);
        }
    }

    public void setThumbRadius(float f2) {
        this.f25805g = f2;
        if (!this.f25822x) {
            invalidate();
        }
    }

    public void setThumbSize(PointF pointF) {
        if (pointF == null) {
            float f2 = getResources().getDisplayMetrics().density * 20.0f;
            a(f2, f2);
            return;
        }
        a(pointF.x, pointF.y);
    }

    public void setTintColor(int i2) {
        this.f25811m = i2;
        this.f25804f = a.a(i2);
        this.f25803e = a.b(this.f25811m);
        this.f25823y = false;
        this.f25822x = false;
        refreshDrawableState();
        invalidate();
    }
}
