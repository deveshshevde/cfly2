package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.a;
import androidx.core.widget.j;
import t.ac;

public class SwitchCompat extends CompoundButton {
    private static final int[] O = {16842912};

    /* renamed from: c  reason: collision with root package name */
    private static final Property<SwitchCompat, Float> f1309c = new Property<SwitchCompat, Float>(Float.class, "thumbPos") {
        /* renamed from: a */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.f1310a);
        }

        /* renamed from: a */
        public void set(SwitchCompat switchCompat, Float f2) {
            switchCompat.setThumbPosition(f2.floatValue());
        }
    };
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private final TextPaint H;
    private ColorStateList I;
    private Layout J;
    private Layout K;
    private TransformationMethod L;
    private final m M;
    private final Rect N;

    /* renamed from: a  reason: collision with root package name */
    float f1310a;

    /* renamed from: b  reason: collision with root package name */
    ObjectAnimator f1311b;

    /* renamed from: d  reason: collision with root package name */
    private Drawable f1312d;

    /* renamed from: e  reason: collision with root package name */
    private ColorStateList f1313e;

    /* renamed from: f  reason: collision with root package name */
    private PorterDuff.Mode f1314f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1315g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1316h;

    /* renamed from: i  reason: collision with root package name */
    private Drawable f1317i;

    /* renamed from: j  reason: collision with root package name */
    private ColorStateList f1318j;

    /* renamed from: k  reason: collision with root package name */
    private PorterDuff.Mode f1319k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f1320l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1321m;

    /* renamed from: n  reason: collision with root package name */
    private int f1322n;

    /* renamed from: o  reason: collision with root package name */
    private int f1323o;

    /* renamed from: p  reason: collision with root package name */
    private int f1324p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f1325q;

    /* renamed from: r  reason: collision with root package name */
    private CharSequence f1326r;

    /* renamed from: s  reason: collision with root package name */
    private CharSequence f1327s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f1328t;

    /* renamed from: u  reason: collision with root package name */
    private int f1329u;

    /* renamed from: v  reason: collision with root package name */
    private int f1330v;

    /* renamed from: w  reason: collision with root package name */
    private float f1331w;

    /* renamed from: x  reason: collision with root package name */
    private float f1332x;

    /* renamed from: y  reason: collision with root package name */
    private VelocityTracker f1333y;

    /* renamed from: z  reason: collision with root package name */
    private int f1334z;

    public SwitchCompat(Context context) {
        this(context, (AttributeSet) null);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1313e = null;
        this.f1314f = null;
        this.f1315g = false;
        this.f1316h = false;
        this.f1318j = null;
        this.f1319k = null;
        this.f1320l = false;
        this.f1321m = false;
        this.f1333y = VelocityTracker.obtain();
        this.N = new Rect();
        aa.a((View) this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.H = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        af a2 = af.a(context, attributeSet, R.styleable.SwitchCompat, i2, 0);
        ac.a(this, context, R.styleable.SwitchCompat, attributeSet, a2.a(), i2, 0);
        Drawable a3 = a2.a(R.styleable.SwitchCompat_android_thumb);
        this.f1312d = a3;
        if (a3 != null) {
            a3.setCallback(this);
        }
        Drawable a4 = a2.a(R.styleable.SwitchCompat_track);
        this.f1317i = a4;
        if (a4 != null) {
            a4.setCallback(this);
        }
        this.f1326r = a2.c(R.styleable.SwitchCompat_android_textOn);
        this.f1327s = a2.c(R.styleable.SwitchCompat_android_textOff);
        this.f1328t = a2.a(R.styleable.SwitchCompat_showText, true);
        this.f1322n = a2.e(R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.f1323o = a2.e(R.styleable.SwitchCompat_switchMinWidth, 0);
        this.f1324p = a2.e(R.styleable.SwitchCompat_switchPadding, 0);
        this.f1325q = a2.a(R.styleable.SwitchCompat_splitTrack, false);
        ColorStateList e2 = a2.e(R.styleable.SwitchCompat_thumbTint);
        if (e2 != null) {
            this.f1313e = e2;
            this.f1315g = true;
        }
        PorterDuff.Mode a5 = q.a(a2.a(R.styleable.SwitchCompat_thumbTintMode, -1), (PorterDuff.Mode) null);
        if (this.f1314f != a5) {
            this.f1314f = a5;
            this.f1316h = true;
        }
        if (this.f1315g || this.f1316h) {
            b();
        }
        ColorStateList e3 = a2.e(R.styleable.SwitchCompat_trackTint);
        if (e3 != null) {
            this.f1318j = e3;
            this.f1320l = true;
        }
        PorterDuff.Mode a6 = q.a(a2.a(R.styleable.SwitchCompat_trackTintMode, -1), (PorterDuff.Mode) null);
        if (this.f1319k != a6) {
            this.f1319k = a6;
            this.f1321m = true;
        }
        if (this.f1320l || this.f1321m) {
            a();
        }
        int g2 = a2.g(R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (g2 != 0) {
            a(context, g2);
        }
        m mVar = new m(this);
        this.M = mVar;
        mVar.a(attributeSet, i2);
        a2.b();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1330v = viewConfiguration.getScaledTouchSlop();
        this.f1334z = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    private static float a(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
    }

    private Layout a(CharSequence charSequence) {
        TransformationMethod transformationMethod = this.L;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        TextPaint textPaint = this.H;
        return new StaticLayout(charSequence2, textPaint, charSequence2 != null ? (int) Math.ceil((double) Layout.getDesiredWidth(charSequence2, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void a() {
        Drawable drawable = this.f1317i;
        if (drawable == null) {
            return;
        }
        if (this.f1320l || this.f1321m) {
            Drawable mutate = a.g(drawable).mutate();
            this.f1317i = mutate;
            if (this.f1320l) {
                a.a(mutate, this.f1318j);
            }
            if (this.f1321m) {
                a.a(this.f1317i, this.f1319k);
            }
            if (this.f1317i.isStateful()) {
                this.f1317i.setState(getDrawableState());
            }
        }
    }

    private void a(int i2, int i3) {
        a(i2 != 1 ? i2 != 2 ? i2 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF, i3);
    }

    private void a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private void a(boolean z2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f1309c, new float[]{z2 ? 1.0f : 0.0f});
        this.f1311b = ofFloat;
        ofFloat.setDuration(250);
        if (Build.VERSION.SDK_INT >= 18) {
            this.f1311b.setAutoCancel(true);
        }
        this.f1311b.start();
    }

    private boolean a(float f2, float f3) {
        if (this.f1312d == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f1312d.getPadding(this.N);
        int i2 = this.E;
        int i3 = this.f1330v;
        int i4 = i2 - i3;
        int i5 = (this.D + thumbOffset) - i3;
        int i6 = this.C + i5 + this.N.left + this.N.right;
        int i7 = this.f1330v;
        return f2 > ((float) i5) && f2 < ((float) (i6 + i7)) && f3 > ((float) i4) && f3 < ((float) (this.G + i7));
    }

    private void b() {
        Drawable drawable = this.f1312d;
        if (drawable == null) {
            return;
        }
        if (this.f1315g || this.f1316h) {
            Drawable mutate = a.g(drawable).mutate();
            this.f1312d = mutate;
            if (this.f1315g) {
                a.a(mutate, this.f1313e);
            }
            if (this.f1316h) {
                a.a(this.f1312d, this.f1314f);
            }
            if (this.f1312d.isStateful()) {
                this.f1312d.setState(getDrawableState());
            }
        }
    }

    private void b(MotionEvent motionEvent) {
        this.f1329u = 0;
        boolean z2 = true;
        boolean z3 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z3) {
            this.f1333y.computeCurrentVelocity(1000);
            float xVelocity = this.f1333y.getXVelocity();
            if (Math.abs(xVelocity) <= ((float) this.f1334z)) {
                z2 = getTargetCheckedState();
            } else if (!al.a(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                z2 = false;
            }
        } else {
            z2 = isChecked;
        }
        if (z2 != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z2);
        a(motionEvent);
    }

    private void c() {
        ObjectAnimator objectAnimator = this.f1311b;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void d() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.f1326r;
            if (charSequence == null) {
                charSequence = getResources().getString(R.string.abc_capital_on);
            }
            ac.a((View) this, charSequence);
        }
    }

    private void e() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.f1327s;
            if (charSequence == null) {
                charSequence = getResources().getString(R.string.abc_capital_off);
            }
            ac.a((View) this, charSequence);
        }
    }

    private boolean getTargetCheckedState() {
        return this.f1310a > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((al.a(this) ? 1.0f - this.f1310a : this.f1310a) * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f1317i;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.N;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f1312d;
        Rect a2 = drawable2 != null ? q.a(drawable2) : q.f1548a;
        return ((((this.A - this.C) - rect.left) - rect.right) - a2.left) - a2.right;
    }

    public void a(Context context, int i2) {
        af a2 = af.a(context, i2, R.styleable.TextAppearance);
        ColorStateList e2 = a2.e(R.styleable.TextAppearance_android_textColor);
        if (e2 == null) {
            e2 = getTextColors();
        }
        this.I = e2;
        int e3 = a2.e(R.styleable.TextAppearance_android_textSize, 0);
        if (e3 != 0) {
            float f2 = (float) e3;
            if (f2 != this.H.getTextSize()) {
                this.H.setTextSize(f2);
                requestLayout();
            }
        }
        a(a2.a(R.styleable.TextAppearance_android_typeface, -1), a2.a(R.styleable.TextAppearance_android_textStyle, -1));
        this.L = a2.a(R.styleable.TextAppearance_textAllCaps, false) ? new e.a(getContext()) : null;
        a2.b();
    }

    public void a(Typeface typeface, int i2) {
        float f2 = 0.0f;
        boolean z2 = false;
        if (i2 > 0) {
            Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i2) : Typeface.create(typeface, i2);
            setSwitchTypeface(defaultFromStyle);
            int style = ((defaultFromStyle != null ? defaultFromStyle.getStyle() : 0) ^ -1) & i2;
            TextPaint textPaint = this.H;
            if ((style & 1) != 0) {
                z2 = true;
            }
            textPaint.setFakeBoldText(z2);
            TextPaint textPaint2 = this.H;
            if ((style & 2) != 0) {
                f2 = -0.25f;
            }
            textPaint2.setTextSkewX(f2);
            return;
        }
        this.H.setFakeBoldText(false);
        this.H.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    public void draw(Canvas canvas) {
        int i2;
        int i3;
        Rect rect = this.N;
        int i4 = this.D;
        int i5 = this.E;
        int i6 = this.F;
        int i7 = this.G;
        int thumbOffset = getThumbOffset() + i4;
        Drawable drawable = this.f1312d;
        Rect a2 = drawable != null ? q.a(drawable) : q.f1548a;
        Drawable drawable2 = this.f1317i;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            thumbOffset += rect.left;
            if (a2 != null) {
                if (a2.left > rect.left) {
                    i4 += a2.left - rect.left;
                }
                i2 = a2.top > rect.top ? (a2.top - rect.top) + i5 : i5;
                if (a2.right > rect.right) {
                    i6 -= a2.right - rect.right;
                }
                if (a2.bottom > rect.bottom) {
                    i3 = i7 - (a2.bottom - rect.bottom);
                    this.f1317i.setBounds(i4, i2, i6, i3);
                }
            } else {
                i2 = i5;
            }
            i3 = i7;
            this.f1317i.setBounds(i4, i2, i6, i3);
        }
        Drawable drawable3 = this.f1312d;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i8 = thumbOffset - rect.left;
            int i9 = thumbOffset + this.C + rect.right;
            this.f1312d.setBounds(i8, i5, i9, i7);
            Drawable background = getBackground();
            if (background != null) {
                a.a(background, i8, i5, i9, i7);
            }
        }
        super.draw(canvas);
    }

    public void drawableHotspotChanged(float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f2, f3);
        }
        Drawable drawable = this.f1312d;
        if (drawable != null) {
            a.a(drawable, f2, f3);
        }
        Drawable drawable2 = this.f1317i;
        if (drawable2 != null) {
            a.a(drawable2, f2, f3);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f1312d;
        boolean z2 = false;
        if (drawable != null && drawable.isStateful()) {
            z2 = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f1317i;
        if (drawable2 != null && drawable2.isStateful()) {
            z2 |= drawable2.setState(drawableState);
        }
        if (z2) {
            invalidate();
        }
    }

    public int getCompoundPaddingLeft() {
        if (!al.a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f1324p : compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (al.a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f1324p : compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.f1328t;
    }

    public boolean getSplitTrack() {
        return this.f1325q;
    }

    public int getSwitchMinWidth() {
        return this.f1323o;
    }

    public int getSwitchPadding() {
        return this.f1324p;
    }

    public CharSequence getTextOff() {
        return this.f1327s;
    }

    public CharSequence getTextOn() {
        return this.f1326r;
    }

    public Drawable getThumbDrawable() {
        return this.f1312d;
    }

    public int getThumbTextPadding() {
        return this.f1322n;
    }

    public ColorStateList getThumbTintList() {
        return this.f1313e;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f1314f;
    }

    public Drawable getTrackDrawable() {
        return this.f1317i;
    }

    public ColorStateList getTrackTintList() {
        return this.f1318j;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f1319k;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f1312d;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f1317i;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.f1311b;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.f1311b.end();
            this.f1311b = null;
        }
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, O);
        }
        return onCreateDrawableState;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i2;
        super.onDraw(canvas);
        Rect rect = this.N;
        Drawable drawable = this.f1317i;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i3 = this.E;
        int i4 = this.G;
        int i5 = i3 + rect.top;
        int i6 = i4 - rect.bottom;
        Drawable drawable2 = this.f1312d;
        if (drawable != null) {
            if (!this.f1325q || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect a2 = q.a(drawable2);
                drawable2.copyBounds(rect);
                rect.left += a2.left;
                rect.right -= a2.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.J : this.K;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.I;
            if (colorStateList != null) {
                this.H.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.H.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                i2 = bounds.left + bounds.right;
            } else {
                i2 = getWidth();
            }
            canvas.translate((float) ((i2 / 2) - (layout.getWidth() / 2)), (float) (((i5 + i6) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.f1326r : this.f1327s;
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(text);
                sb.append(' ');
                sb.append(charSequence);
                accessibilityNodeInfo.setText(sb);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        super.onLayout(z2, i2, i3, i4, i5);
        int i12 = 0;
        if (this.f1312d != null) {
            Rect rect = this.N;
            Drawable drawable = this.f1317i;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect a2 = q.a(this.f1312d);
            i6 = Math.max(0, a2.left - rect.left);
            i12 = Math.max(0, a2.right - rect.right);
        } else {
            i6 = 0;
        }
        if (al.a(this)) {
            i8 = getPaddingLeft() + i6;
            i7 = ((this.A + i8) - i6) - i12;
        } else {
            i7 = (getWidth() - getPaddingRight()) - i12;
            i8 = (i7 - this.A) + i6 + i12;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            i11 = this.B;
            i10 = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (i11 / 2);
        } else if (gravity != 80) {
            i10 = getPaddingTop();
            i11 = this.B;
        } else {
            i9 = getHeight() - getPaddingBottom();
            i10 = i9 - this.B;
            this.D = i8;
            this.E = i10;
            this.G = i9;
            this.F = i7;
        }
        i9 = i11 + i10;
        this.D = i8;
        this.E = i10;
        this.G = i9;
        this.F = i7;
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        if (this.f1328t) {
            if (this.J == null) {
                this.J = a(this.f1326r);
            }
            if (this.K == null) {
                this.K = a(this.f1327s);
            }
        }
        Rect rect = this.N;
        Drawable drawable = this.f1312d;
        int i6 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i5 = (this.f1312d.getIntrinsicWidth() - rect.left) - rect.right;
            i4 = this.f1312d.getIntrinsicHeight();
        } else {
            i5 = 0;
            i4 = 0;
        }
        this.C = Math.max(this.f1328t ? Math.max(this.J.getWidth(), this.K.getWidth()) + (this.f1322n * 2) : 0, i5);
        Drawable drawable2 = this.f1317i;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i6 = this.f1317i.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i7 = rect.left;
        int i8 = rect.right;
        Drawable drawable3 = this.f1312d;
        if (drawable3 != null) {
            Rect a2 = q.a(drawable3);
            i7 = Math.max(i7, a2.left);
            i8 = Math.max(i8, a2.right);
        }
        int max = Math.max(this.f1323o, (this.C * 2) + i7 + i8);
        int max2 = Math.max(i6, i4);
        this.A = max;
        this.B = max2;
        super.onMeasure(i2, i3);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f1326r : this.f1327s;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        if (r0 != 3) goto L_0x00b9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.f1333y
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L_0x009f
            r2 = 2
            if (r0 == r1) goto L_0x008b
            if (r0 == r2) goto L_0x0016
            r3 = 3
            if (r0 == r3) goto L_0x008b
            goto L_0x00b9
        L_0x0016:
            int r0 = r6.f1329u
            if (r0 == r1) goto L_0x0057
            if (r0 == r2) goto L_0x001e
            goto L_0x00b9
        L_0x001e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.f1331w
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L_0x0032
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L_0x003d
        L_0x0032:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0039
            r2 = 1065353216(0x3f800000, float:1.0)
            goto L_0x003d
        L_0x0039:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x003d:
            boolean r0 = androidx.appcompat.widget.al.a(r6)
            if (r0 == 0) goto L_0x0044
            float r2 = -r2
        L_0x0044:
            float r0 = r6.f1310a
            float r0 = r0 + r2
            float r0 = a(r0, r4, r3)
            float r2 = r6.f1310a
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0056
            r6.f1331w = r7
            r6.setThumbPosition(r0)
        L_0x0056:
            return r1
        L_0x0057:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.f1331w
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f1330v
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L_0x007d
            float r4 = r6.f1332x
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f1330v
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x00b9
        L_0x007d:
            r6.f1329u = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.f1331w = r0
            r6.f1332x = r3
            return r1
        L_0x008b:
            int r0 = r6.f1329u
            if (r0 != r2) goto L_0x0096
            r6.b(r7)
            super.onTouchEvent(r7)
            return r1
        L_0x0096:
            r0 = 0
            r6.f1329u = r0
            android.view.VelocityTracker r0 = r6.f1333y
            r0.clear()
            goto L_0x00b9
        L_0x009f:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto L_0x00b9
            boolean r3 = r6.a((float) r0, (float) r2)
            if (r3 == 0) goto L_0x00b9
            r6.f1329u = r1
            r6.f1331w = r0
            r6.f1332x = r2
        L_0x00b9:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setChecked(boolean z2) {
        super.setChecked(z2);
        boolean isChecked = isChecked();
        if (isChecked) {
            d();
        } else {
            e();
        }
        if (getWindowToken() == null || !ac.G(this)) {
            c();
            setThumbPosition(isChecked ? 1.0f : 0.0f);
            return;
        }
        a(isChecked);
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(j.a((TextView) this, callback));
    }

    public void setShowText(boolean z2) {
        if (this.f1328t != z2) {
            this.f1328t = z2;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z2) {
        this.f1325q = z2;
        invalidate();
    }

    public void setSwitchMinWidth(int i2) {
        this.f1323o = i2;
        requestLayout();
    }

    public void setSwitchPadding(int i2) {
        this.f1324p = i2;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.H.getTypeface() != null && !this.H.getTypeface().equals(typeface)) || (this.H.getTypeface() == null && typeface != null)) {
            this.H.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setTextOff(CharSequence charSequence) {
        this.f1327s = charSequence;
        requestLayout();
        if (!isChecked()) {
            e();
        }
    }

    public void setTextOn(CharSequence charSequence) {
        this.f1326r = charSequence;
        requestLayout();
        if (isChecked()) {
            d();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1312d;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f1312d = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void setThumbPosition(float f2) {
        this.f1310a = f2;
        invalidate();
    }

    public void setThumbResource(int i2) {
        setThumbDrawable(c.a.b(getContext(), i2));
    }

    public void setThumbTextPadding(int i2) {
        this.f1322n = i2;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f1313e = colorStateList;
        this.f1315g = true;
        b();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f1314f = mode;
        this.f1316h = true;
        b();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f1317i;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
        }
        this.f1317i = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i2) {
        setTrackDrawable(c.a.b(getContext(), i2));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f1318j = colorStateList;
        this.f1320l = true;
        a();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f1319k = mode;
        this.f1321m = true;
        a();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1312d || drawable == this.f1317i;
    }
}
