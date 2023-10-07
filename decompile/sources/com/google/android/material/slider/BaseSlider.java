package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.SeekBar;
import com.blankj.utilcode.constant.MemoryConstants;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.material.R;
import com.google.android.material.internal.l;
import com.google.android.material.internal.r;
import com.google.android.material.internal.s;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.slider.a;
import com.google.android.material.slider.b;
import gw.h;
import gw.m;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import t.ac;
import u.c;

abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends a<S>, T extends b<S>> extends View {

    /* renamed from: a  reason: collision with root package name */
    static final int f19526a = R.style.Widget_MaterialComponents_Slider;

    /* renamed from: b  reason: collision with root package name */
    private static final String f19527b = "BaseSlider";
    private int A;
    private int B;
    private int C;
    private float D;
    private MotionEvent E;
    private c F;
    private boolean G;
    private float H;
    private float I;
    private ArrayList<Float> J;
    private int K;
    private int L;
    private float M;
    private float[] N;
    private boolean O;
    private int P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private ColorStateList T;
    private ColorStateList U;
    private ColorStateList V;
    private ColorStateList W;

    /* renamed from: aa  reason: collision with root package name */
    private ColorStateList f19528aa;

    /* renamed from: ab  reason: collision with root package name */
    private final h f19529ab;

    /* renamed from: ac  reason: collision with root package name */
    private float f19530ac;

    /* renamed from: ad  reason: collision with root package name */
    private int f19531ad;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f19532c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f19533d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f19534e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f19535f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f19536g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f19537h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final b f19538i;

    /* renamed from: j  reason: collision with root package name */
    private final AccessibilityManager f19539j;

    /* renamed from: k  reason: collision with root package name */
    private BaseSlider<S, L, T>.a f19540k;

    /* renamed from: l  reason: collision with root package name */
    private final c f19541l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final List<gy.a> f19542m;

    /* renamed from: n  reason: collision with root package name */
    private final List<L> f19543n;

    /* renamed from: o  reason: collision with root package name */
    private final List<T> f19544o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f19545p;

    /* renamed from: q  reason: collision with root package name */
    private ValueAnimator f19546q;

    /* renamed from: r  reason: collision with root package name */
    private ValueAnimator f19547r;

    /* renamed from: s  reason: collision with root package name */
    private final int f19548s;

    /* renamed from: t  reason: collision with root package name */
    private int f19549t;

    /* renamed from: u  reason: collision with root package name */
    private int f19550u;

    /* renamed from: v  reason: collision with root package name */
    private int f19551v;

    /* renamed from: w  reason: collision with root package name */
    private int f19552w;

    /* renamed from: x  reason: collision with root package name */
    private int f19553x;

    /* renamed from: y  reason: collision with root package name */
    private int f19554y;

    /* renamed from: z  reason: collision with root package name */
    private int f19555z;

    static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new Parcelable.Creator<SliderState>() {
            /* renamed from: a */
            public SliderState createFromParcel(Parcel parcel) {
                return new SliderState(parcel);
            }

            /* renamed from: a */
            public SliderState[] newArray(int i2) {
                return new SliderState[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        float f19561a;

        /* renamed from: b  reason: collision with root package name */
        float f19562b;

        /* renamed from: c  reason: collision with root package name */
        ArrayList<Float> f19563c;

        /* renamed from: d  reason: collision with root package name */
        float f19564d;

        /* renamed from: e  reason: collision with root package name */
        boolean f19565e;

        private SliderState(Parcel parcel) {
            super(parcel);
            this.f19561a = parcel.readFloat();
            this.f19562b = parcel.readFloat();
            ArrayList<Float> arrayList = new ArrayList<>();
            this.f19563c = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.f19564d = parcel.readFloat();
            this.f19565e = parcel.createBooleanArray()[0];
        }

        SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeFloat(this.f19561a);
            parcel.writeFloat(this.f19562b);
            parcel.writeList(this.f19563c);
            parcel.writeFloat(this.f19564d);
            parcel.writeBooleanArray(new boolean[]{this.f19565e});
        }
    }

    private class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        int f19566a;

        private a() {
            this.f19566a = -1;
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            this.f19566a = i2;
        }

        public void run() {
            BaseSlider.this.f19538i.a(this.f19566a, 4);
        }
    }

    private static class b extends x.a {

        /* renamed from: c  reason: collision with root package name */
        Rect f19568c = new Rect();

        /* renamed from: d  reason: collision with root package name */
        private final BaseSlider<?, ?, ?> f19569d;

        b(BaseSlider<?, ?, ?> baseSlider) {
            super(baseSlider);
            this.f19569d = baseSlider;
        }

        private String e(int i2) {
            Context context;
            int i3;
            if (i2 == this.f19569d.getValues().size() - 1) {
                context = this.f19569d.getContext();
                i3 = R.string.material_slider_range_end;
            } else if (i2 != 0) {
                return "";
            } else {
                context = this.f19569d.getContext();
                i3 = R.string.material_slider_range_start;
            }
            return context.getString(i3);
        }

        /* access modifiers changed from: protected */
        public int a(float f2, float f3) {
            for (int i2 = 0; i2 < this.f19569d.getValues().size(); i2++) {
                this.f19569d.a(i2, this.f19568c);
                if (this.f19568c.contains((int) f2, (int) f3)) {
                    return i2;
                }
            }
            return -1;
        }

        /* access modifiers changed from: protected */
        public void a(int i2, u.c cVar) {
            cVar.a(c.a.H);
            List<Float> values = this.f19569d.getValues();
            float floatValue = values.get(i2).floatValue();
            float valueFrom = this.f19569d.getValueFrom();
            float valueTo = this.f19569d.getValueTo();
            if (this.f19569d.isEnabled()) {
                if (floatValue > valueFrom) {
                    cVar.a(8192);
                }
                if (floatValue < valueTo) {
                    cVar.a(4096);
                }
            }
            cVar.a(c.d.a(1, valueFrom, valueTo, floatValue));
            cVar.b((CharSequence) SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (this.f19569d.getContentDescription() != null) {
                sb.append(this.f19569d.getContentDescription());
                sb.append(",");
            }
            if (values.size() > 1) {
                sb.append(e(i2));
                sb.append(this.f19569d.g(floatValue));
            }
            cVar.e((CharSequence) sb.toString());
            this.f19569d.a(i2, this.f19568c);
            cVar.b(this.f19568c);
        }

        /* access modifiers changed from: protected */
        public void a(List<Integer> list) {
            for (int i2 = 0; i2 < this.f19569d.getValues().size(); i2++) {
                list.add(Integer.valueOf(i2));
            }
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
            if (com.google.android.material.slider.BaseSlider.a((com.google.android.material.slider.BaseSlider) r4.f19569d, r5, r7.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE")) != false) goto L_0x0030;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean b(int r5, int r6, android.os.Bundle r7) {
            /*
                r4 = this;
                com.google.android.material.slider.BaseSlider<?, ?, ?> r0 = r4.f19569d
                boolean r0 = r0.isEnabled()
                r1 = 0
                if (r0 != 0) goto L_0x000a
                return r1
            L_0x000a:
                r0 = 4096(0x1000, float:5.74E-42)
                r2 = 1
                r3 = 8192(0x2000, float:1.14794E-41)
                if (r6 == r0) goto L_0x003f
                if (r6 == r3) goto L_0x003f
                r0 = 16908349(0x102003d, float:2.38774E-38)
                if (r6 == r0) goto L_0x0019
                return r1
            L_0x0019:
                if (r7 == 0) goto L_0x003e
                java.lang.String r6 = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"
                boolean r0 = r7.containsKey(r6)
                if (r0 != 0) goto L_0x0024
                goto L_0x003e
            L_0x0024:
                float r6 = r7.getFloat(r6)
                com.google.android.material.slider.BaseSlider<?, ?, ?> r7 = r4.f19569d
                boolean r6 = r7.a((int) r5, (float) r6)
                if (r6 == 0) goto L_0x003e
            L_0x0030:
                com.google.android.material.slider.BaseSlider<?, ?, ?> r6 = r4.f19569d
                r6.m()
                com.google.android.material.slider.BaseSlider<?, ?, ?> r6 = r4.f19569d
                r6.postInvalidate()
                r4.a((int) r5)
                return r2
            L_0x003e:
                return r1
            L_0x003f:
                com.google.android.material.slider.BaseSlider<?, ?, ?> r7 = r4.f19569d
                r0 = 20
                float r7 = r7.f((int) r0)
                if (r6 != r3) goto L_0x004a
                float r7 = -r7
            L_0x004a:
                com.google.android.material.slider.BaseSlider<?, ?, ?> r6 = r4.f19569d
                boolean r6 = r6.c()
                if (r6 == 0) goto L_0x0053
                float r7 = -r7
            L_0x0053:
                com.google.android.material.slider.BaseSlider<?, ?, ?> r6 = r4.f19569d
                java.util.List r6 = r6.getValues()
                java.lang.Object r6 = r6.get(r5)
                java.lang.Float r6 = (java.lang.Float) r6
                float r6 = r6.floatValue()
                float r6 = r6 + r7
                com.google.android.material.slider.BaseSlider<?, ?, ?> r7 = r4.f19569d
                float r7 = r7.getValueFrom()
                com.google.android.material.slider.BaseSlider<?, ?, ?> r0 = r4.f19569d
                float r0 = r0.getValueTo()
                float r6 = o.a.a((float) r6, (float) r7, (float) r0)
                com.google.android.material.slider.BaseSlider<?, ?, ?> r7 = r4.f19569d
                boolean r6 = r7.a((int) r5, (float) r6)
                if (r6 == 0) goto L_0x007d
                goto L_0x0030
            L_0x007d:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.b.b(int, int, android.os.Bundle):boolean");
        }
    }

    private interface c {
        gy.a a();
    }

    public BaseSlider(Context context) {
        this(context, (AttributeSet) null);
    }

    public BaseSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sliderStyle);
    }

    public BaseSlider(Context context, final AttributeSet attributeSet, final int i2) {
        super(gx.a.a(context, attributeSet, i2, f19526a), attributeSet, i2);
        this.f19542m = new ArrayList();
        this.f19543n = new ArrayList();
        this.f19544o = new ArrayList();
        this.f19545p = false;
        this.G = false;
        this.J = new ArrayList<>();
        this.K = -1;
        this.L = -1;
        this.M = 0.0f;
        this.O = true;
        this.R = false;
        h hVar = new h();
        this.f19529ab = hVar;
        this.f19531ad = 0;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.f19532c = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.f19533d = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeCap(Paint.Cap.ROUND);
        Paint paint3 = new Paint(1);
        this.f19534e = paint3;
        paint3.setStyle(Paint.Style.FILL);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint4 = new Paint(1);
        this.f19535f = paint4;
        paint4.setStyle(Paint.Style.FILL);
        Paint paint5 = new Paint();
        this.f19536g = paint5;
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setStrokeCap(Paint.Cap.ROUND);
        Paint paint6 = new Paint();
        this.f19537h = paint6;
        paint6.setStyle(Paint.Style.STROKE);
        paint6.setStrokeCap(Paint.Cap.ROUND);
        a(context2.getResources());
        this.f19541l = new c() {
            public gy.a a() {
                TypedArray a2 = l.a(BaseSlider.this.getContext(), attributeSet, R.styleable.Slider, i2, BaseSlider.f19526a, new int[0]);
                gy.a a3 = BaseSlider.b(BaseSlider.this.getContext(), a2);
                a2.recycle();
                return a3;
            }
        };
        a(context2, attributeSet, i2);
        setFocusable(true);
        setClickable(true);
        hVar.D(2);
        this.f19548s = ViewConfiguration.get(context2).getScaledTouchSlop();
        b bVar = new b(this);
        this.f19538i = bVar;
        ac.a((View) this, (t.a) bVar);
        this.f19539j = (AccessibilityManager) getContext().getSystemService("accessibility");
    }

    private static float a(ValueAnimator valueAnimator, float f2) {
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return f2;
        }
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        valueAnimator.cancel();
        return floatValue;
    }

    private int a(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    private static int a(float[] fArr, float f2) {
        return Math.round(f2 * ((float) ((fArr.length / 2) - 1)));
    }

    private ValueAnimator a(boolean z2) {
        float f2 = 0.0f;
        float a2 = a(z2 ? this.f19547r : this.f19546q, z2 ? 0.0f : 1.0f);
        if (z2) {
            f2 = 1.0f;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{a2, f2});
        ofFloat.setDuration(z2 ? 83 : 117);
        ofFloat.setInterpolator(z2 ? gl.a.f28539e : gl.a.f28537c);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                for (gy.a a2 : BaseSlider.this.f19542m) {
                    a2.a(floatValue);
                }
                ac.e(BaseSlider.this);
            }
        });
        return ofFloat;
    }

    private Boolean a(int i2, KeyEvent keyEvent) {
        if (i2 != 61) {
            if (i2 != 66) {
                if (i2 != 81) {
                    if (i2 == 69) {
                        c(-1);
                        return true;
                    } else if (i2 != 70) {
                        switch (i2) {
                            case 21:
                                d(-1);
                                return true;
                            case 22:
                                d(1);
                                return true;
                            case 23:
                                break;
                            default:
                                return null;
                        }
                    }
                }
                c(1);
                return true;
            }
            this.K = this.L;
            postInvalidate();
            return true;
        } else if (keyEvent.hasNoModifiers()) {
            return Boolean.valueOf(c(1));
        } else {
            if (keyEvent.isShiftPressed()) {
                return Boolean.valueOf(c(-1));
            }
            return false;
        }
    }

    private void a(int i2) {
        this.P = Math.max(i2 - (this.f19554y * 2), 0);
        l();
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        TypedArray a2 = l.a(context, attributeSet, R.styleable.Slider, i2, f19526a, new int[0]);
        this.H = a2.getFloat(R.styleable.Slider_android_valueFrom, 0.0f);
        this.I = a2.getFloat(R.styleable.Slider_android_valueTo, 1.0f);
        setValues(Float.valueOf(this.H));
        this.M = a2.getFloat(R.styleable.Slider_android_stepSize, 0.0f);
        boolean hasValue = a2.hasValue(R.styleable.Slider_trackColor);
        int i3 = hasValue ? R.styleable.Slider_trackColor : R.styleable.Slider_trackColorInactive;
        int i4 = hasValue ? R.styleable.Slider_trackColor : R.styleable.Slider_trackColorActive;
        ColorStateList a3 = gt.c.a(context, a2, i3);
        if (a3 == null) {
            a3 = c.a.a(context, R.color.material_slider_inactive_track_color);
        }
        setTrackInactiveTintList(a3);
        ColorStateList a4 = gt.c.a(context, a2, i4);
        if (a4 == null) {
            a4 = c.a.a(context, R.color.material_slider_active_track_color);
        }
        setTrackActiveTintList(a4);
        this.f19529ab.g(gt.c.a(context, a2, R.styleable.Slider_thumbColor));
        if (a2.hasValue(R.styleable.Slider_thumbStrokeColor)) {
            setThumbStrokeColor(gt.c.a(context, a2, R.styleable.Slider_thumbStrokeColor));
        }
        setThumbStrokeWidth(a2.getDimension(R.styleable.Slider_thumbStrokeWidth, 0.0f));
        ColorStateList a5 = gt.c.a(context, a2, R.styleable.Slider_haloColor);
        if (a5 == null) {
            a5 = c.a.a(context, R.color.material_slider_halo_color);
        }
        setHaloTintList(a5);
        this.O = a2.getBoolean(R.styleable.Slider_tickVisible, true);
        boolean hasValue2 = a2.hasValue(R.styleable.Slider_tickColor);
        int i5 = hasValue2 ? R.styleable.Slider_tickColor : R.styleable.Slider_tickColorInactive;
        int i6 = hasValue2 ? R.styleable.Slider_tickColor : R.styleable.Slider_tickColorActive;
        ColorStateList a6 = gt.c.a(context, a2, i5);
        if (a6 == null) {
            a6 = c.a.a(context, R.color.material_slider_inactive_tick_marks_color);
        }
        setTickInactiveTintList(a6);
        ColorStateList a7 = gt.c.a(context, a2, i6);
        if (a7 == null) {
            a7 = c.a.a(context, R.color.material_slider_active_tick_marks_color);
        }
        setTickActiveTintList(a7);
        setThumbRadius(a2.getDimensionPixelSize(R.styleable.Slider_thumbRadius, 0));
        setHaloRadius(a2.getDimensionPixelSize(R.styleable.Slider_haloRadius, 0));
        setThumbElevation(a2.getDimension(R.styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(a2.getDimensionPixelSize(R.styleable.Slider_trackHeight, 0));
        this.f19552w = a2.getInt(R.styleable.Slider_labelBehavior, 0);
        if (!a2.getBoolean(R.styleable.Slider_android_enabled, true)) {
            setEnabled(false);
        }
        a2.recycle();
    }

    private void a(Resources resources) {
        this.f19551v = resources.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
        this.f19549t = dimensionPixelOffset;
        this.f19554y = dimensionPixelOffset;
        this.f19550u = resources.getDimensionPixelSize(R.dimen.mtrl_slider_thumb_radius);
        this.f19555z = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_top);
        this.C = resources.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
    }

    private void a(Canvas canvas) {
        if (this.O && this.M > 0.0f) {
            float[] activeRange = getActiveRange();
            int a2 = a(this.N, activeRange[0]);
            int a3 = a(this.N, activeRange[1]);
            int i2 = a2 * 2;
            canvas.drawPoints(this.N, 0, i2, this.f19536g);
            int i3 = a3 * 2;
            canvas.drawPoints(this.N, i2, i3 - i2, this.f19537h);
            float[] fArr = this.N;
            canvas.drawPoints(fArr, i3, fArr.length - i3, this.f19536g);
        }
    }

    private void a(Canvas canvas, int i2, int i3) {
        float[] activeRange = getActiveRange();
        int i4 = this.f19554y;
        float f2 = (float) i2;
        float f3 = ((float) i4) + (activeRange[1] * f2);
        if (f3 < ((float) (i4 + i2))) {
            float f4 = (float) i3;
            canvas.drawLine(f3, f4, (float) (i4 + i2), f4, this.f19532c);
        }
        int i5 = this.f19554y;
        float f5 = ((float) i5) + (activeRange[0] * f2);
        if (f5 > ((float) i5)) {
            float f6 = (float) i3;
            canvas.drawLine((float) i5, f6, f5, f6, this.f19532c);
        }
    }

    private void a(gy.a aVar) {
        aVar.a((View) s.f(this));
    }

    private void a(gy.a aVar, float f2) {
        aVar.a((CharSequence) g(f2));
        int b2 = (this.f19554y + ((int) (b(f2) * ((float) this.P)))) - (aVar.getIntrinsicWidth() / 2);
        int n2 = n() - (this.C + this.A);
        aVar.setBounds(b2, n2 - aVar.getIntrinsicHeight(), aVar.getIntrinsicWidth() + b2, n2);
        Rect rect = new Rect(aVar.getBounds());
        com.google.android.material.internal.c.a(s.f(this), (View) this, rect);
        aVar.setBounds(rect);
        s.g(this).a(aVar);
    }

    private boolean a(float f2) {
        double doubleValue = new BigDecimal(Float.toString(f2)).subtract(new BigDecimal(Float.toString(this.H))).divide(new BigDecimal(Float.toString(this.M)), MathContext.DECIMAL64).doubleValue();
        double round = (double) Math.round(doubleValue);
        Double.isNaN(round);
        return Math.abs(round - doubleValue) < 1.0E-4d;
    }

    /* access modifiers changed from: private */
    public boolean a(int i2, float f2) {
        if (((double) Math.abs(f2 - this.J.get(i2).floatValue())) < 1.0E-4d) {
            return false;
        }
        this.J.set(i2, Float.valueOf(b(i2, f2)));
        this.L = i2;
        b(i2);
        return true;
    }

    private float b(float f2) {
        float f3 = this.H;
        float f4 = (f2 - f3) / (this.I - f3);
        return c() ? 1.0f - f4 : f4;
    }

    private float b(int i2, float f2) {
        float f3 = 0.0f;
        if (this.M == 0.0f) {
            f3 = getMinSeparation();
        }
        if (this.f19531ad == 0) {
            f3 = e(f3);
        }
        if (c()) {
            f3 = -f3;
        }
        int i3 = i2 + 1;
        int i4 = i2 - 1;
        return o.a.a(f2, i4 < 0 ? this.H : this.J.get(i4).floatValue() + f3, i3 >= this.J.size() ? this.I : this.J.get(i3).floatValue() - f3);
    }

    /* access modifiers changed from: private */
    public static gy.a b(Context context, TypedArray typedArray) {
        return gy.a.a(context, (AttributeSet) null, 0, typedArray.getResourceId(R.styleable.Slider_labelStyle, R.style.Widget_MaterialComponents_Tooltip));
    }

    private void b(int i2) {
        for (L a2 : this.f19543n) {
            a2.a(this, this.J.get(i2).floatValue(), true);
        }
        AccessibilityManager accessibilityManager = this.f19539j;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            h(i2);
        }
    }

    private void b(Canvas canvas, int i2, int i3) {
        float[] activeRange = getActiveRange();
        int i4 = this.f19554y;
        float f2 = (float) i2;
        float f3 = (float) i3;
        Canvas canvas2 = canvas;
        canvas2.drawLine(((float) i4) + (activeRange[0] * f2), f3, ((float) i4) + (activeRange[1] * f2), f3, this.f19533d);
    }

    private void b(gy.a aVar) {
        r g2 = s.g(this);
        if (g2 != null) {
            g2.b(aVar);
            aVar.b(s.f(this));
        }
    }

    private double c(float f2) {
        float f3 = this.M;
        if (f3 <= 0.0f) {
            return (double) f2;
        }
        int i2 = (int) ((this.I - this.H) / f3);
        double round = (double) Math.round(f2 * ((float) i2));
        double d2 = (double) i2;
        Double.isNaN(round);
        Double.isNaN(d2);
        return round / d2;
    }

    private void c(Canvas canvas, int i2, int i3) {
        if (!isEnabled()) {
            Iterator<Float> it2 = this.J.iterator();
            while (it2.hasNext()) {
                canvas.drawCircle(((float) this.f19554y) + (b(it2.next().floatValue()) * ((float) i2)), (float) i3, (float) this.A, this.f19534e);
            }
        }
        Iterator<Float> it3 = this.J.iterator();
        while (it3.hasNext()) {
            canvas.save();
            int b2 = this.f19554y + ((int) (b(it3.next().floatValue()) * ((float) i2)));
            int i4 = this.A;
            canvas.translate((float) (b2 - i4), (float) (i3 - i4));
            this.f19529ab.draw(canvas);
            canvas.restore();
        }
    }

    private boolean c(int i2) {
        int i3 = this.L;
        int a2 = (int) o.a.a(((long) i3) + ((long) i2), 0, (long) (this.J.size() - 1));
        this.L = a2;
        if (a2 == i3) {
            return false;
        }
        if (this.K != -1) {
            this.K = a2;
        }
        m();
        postInvalidate();
        return true;
    }

    private void d() {
        this.f19554y = this.f19549t + Math.max(this.A - this.f19550u, 0);
        if (ac.G(this)) {
            a(getWidth());
        }
    }

    private void d(Canvas canvas, int i2, int i3) {
        if (o()) {
            int b2 = (int) (((float) this.f19554y) + (b(this.J.get(this.L).floatValue()) * ((float) i2)));
            if (Build.VERSION.SDK_INT < 28) {
                int i4 = this.B;
                canvas.clipRect((float) (b2 - i4), (float) (i3 - i4), (float) (b2 + i4), (float) (i4 + i3), Region.Op.UNION);
            }
            canvas.drawCircle((float) b2, (float) i3, (float) this.B, this.f19535f);
        }
    }

    private boolean d(float f2) {
        return a(this.K, f2);
    }

    private boolean d(int i2) {
        if (c()) {
            i2 = i2 == Integer.MIN_VALUE ? SubsamplingScaleImageView.TILE_SIZE_AUTO : -i2;
        }
        return c(i2);
    }

    private float e(float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        float f3 = (f2 - ((float) this.f19554y)) / ((float) this.P);
        float f4 = this.H;
        return (f3 * (f4 - this.I)) + f4;
    }

    private Float e(int i2) {
        float f2 = this.R ? f(20) : x();
        if (i2 == 21) {
            if (!c()) {
                f2 = -f2;
            }
            return Float.valueOf(f2);
        } else if (i2 == 22) {
            if (c()) {
                f2 = -f2;
            }
            return Float.valueOf(f2);
        } else if (i2 == 69) {
            return Float.valueOf(-f2);
        } else {
            if (i2 == 70 || i2 == 81) {
                return Float.valueOf(f2);
            }
            return null;
        }
    }

    private void e() {
        if (this.H >= this.I) {
            throw new IllegalStateException(String.format("valueFrom(%s) must be smaller than valueTo(%s)", new Object[]{Float.toString(this.H), Float.toString(this.I)}));
        }
    }

    private float f(float f2) {
        return (b(f2) * ((float) this.P)) + ((float) this.f19554y);
    }

    /* access modifiers changed from: private */
    public float f(int i2) {
        float x2 = x();
        float f2 = (this.I - this.H) / x2;
        float f3 = (float) i2;
        return f2 <= f3 ? x2 : ((float) Math.round(f2 / f3)) * x2;
    }

    private void f() {
        if (this.I <= this.H) {
            throw new IllegalStateException(String.format("valueTo(%s) must be greater than valueFrom(%s)", new Object[]{Float.toString(this.I), Float.toString(this.H)}));
        }
    }

    /* access modifiers changed from: private */
    public String g(float f2) {
        if (a()) {
            return this.F.a(f2);
        }
        return String.format(((float) ((int) f2)) == f2 ? "%.0f" : "%.2f", new Object[]{Float.valueOf(f2)});
    }

    private void g() {
        if (this.M > 0.0f && !a(this.I)) {
            throw new IllegalStateException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", new Object[]{Float.toString(this.M), Float.toString(this.H), Float.toString(this.I)}));
        }
    }

    private void g(int i2) {
        if (i2 == 1) {
            c((int) SubsamplingScaleImageView.TILE_SIZE_AUTO);
        } else if (i2 == 2) {
            c(Integer.MIN_VALUE);
        } else if (i2 == 17) {
            d((int) SubsamplingScaleImageView.TILE_SIZE_AUTO);
        } else if (i2 == 66) {
            d(Integer.MIN_VALUE);
        }
    }

    private float[] getActiveRange() {
        float floatValue = ((Float) Collections.max(getValues())).floatValue();
        float floatValue2 = ((Float) Collections.min(getValues())).floatValue();
        if (this.J.size() == 1) {
            floatValue2 = this.H;
        }
        float b2 = b(floatValue2);
        float b3 = b(floatValue);
        if (c()) {
            return new float[]{b3, b2};
        }
        return new float[]{b2, b3};
    }

    private float getValueOfTouchPosition() {
        double c2 = c(this.f19530ac);
        if (c()) {
            c2 = 1.0d - c2;
        }
        float f2 = this.I;
        float f3 = this.H;
        double d2 = (double) (f2 - f3);
        Double.isNaN(d2);
        double d3 = (double) f3;
        Double.isNaN(d3);
        return (float) ((c2 * d2) + d3);
    }

    private float getValueOfTouchPositionAbsolute() {
        float f2 = this.f19530ac;
        if (c()) {
            f2 = 1.0f - f2;
        }
        float f3 = this.I;
        float f4 = this.H;
        return (f2 * (f3 - f4)) + f4;
    }

    private void h() {
        Iterator<Float> it2 = this.J.iterator();
        while (it2.hasNext()) {
            Float next = it2.next();
            if (next.floatValue() < this.H || next.floatValue() > this.I) {
                throw new IllegalStateException(String.format("Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)", new Object[]{Float.toString(next.floatValue()), Float.toString(this.H), Float.toString(this.I)}));
            } else if (this.M > 0.0f && !a(next.floatValue())) {
                throw new IllegalStateException(String.format("Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)", new Object[]{Float.toString(next.floatValue()), Float.toString(this.H), Float.toString(this.M), Float.toString(this.M)}));
            }
        }
    }

    private void h(int i2) {
        BaseSlider<S, L, T>.a aVar = this.f19540k;
        if (aVar == null) {
            this.f19540k = new a();
        } else {
            removeCallbacks(aVar);
        }
        this.f19540k.a(i2);
        postDelayed(this.f19540k, 200);
    }

    private void i() {
        float f2 = this.M;
        if (f2 != 0.0f) {
            if (((float) ((int) f2)) != f2) {
                Log.w(f19527b, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", new Object[]{"stepSize", Float.valueOf(f2)}));
            }
            float f3 = this.H;
            if (((float) ((int) f3)) != f3) {
                Log.w(f19527b, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", new Object[]{"valueFrom", Float.valueOf(f3)}));
            }
            float f4 = this.I;
            if (((float) ((int) f4)) != f4) {
                Log.w(f19527b, String.format("Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the  value correctly.", new Object[]{"valueTo", Float.valueOf(f4)}));
            }
        }
    }

    private void j() {
        if (this.S) {
            e();
            f();
            g();
            h();
            i();
            this.S = false;
        }
    }

    private void k() {
        if (this.f19542m.size() > this.J.size()) {
            List<gy.a> subList = this.f19542m.subList(this.J.size(), this.f19542m.size());
            for (gy.a next : subList) {
                if (ac.J(this)) {
                    b(next);
                }
            }
            subList.clear();
        }
        while (this.f19542m.size() < this.J.size()) {
            gy.a a2 = this.f19541l.a();
            this.f19542m.add(a2);
            if (ac.J(this)) {
                a(a2);
            }
        }
        int i2 = 1;
        if (this.f19542m.size() == 1) {
            i2 = 0;
        }
        for (gy.a n2 : this.f19542m) {
            n2.n((float) i2);
        }
    }

    private void l() {
        if (this.M > 0.0f) {
            j();
            int min = Math.min((int) (((this.I - this.H) / this.M) + 1.0f), (this.P / (this.f19553x * 2)) + 1);
            float[] fArr = this.N;
            if (fArr == null || fArr.length != min * 2) {
                this.N = new float[(min * 2)];
            }
            float f2 = ((float) this.P) / ((float) (min - 1));
            for (int i2 = 0; i2 < min * 2; i2 += 2) {
                float[] fArr2 = this.N;
                fArr2[i2] = ((float) this.f19554y) + (((float) (i2 / 2)) * f2);
                fArr2[i2 + 1] = (float) n();
            }
        }
    }

    /* access modifiers changed from: private */
    public void m() {
        if (!o() && getMeasuredWidth() > 0) {
            Drawable background = getBackground();
            if (background instanceof RippleDrawable) {
                int b2 = (int) ((b(this.J.get(this.L).floatValue()) * ((float) this.P)) + ((float) this.f19554y));
                int n2 = n();
                int i2 = this.B;
                androidx.core.graphics.drawable.a.a(background, b2 - i2, n2 - i2, b2 + i2, n2 + i2);
            }
        }
    }

    private int n() {
        int i2 = this.f19555z;
        int i3 = 0;
        if (this.f19552w == 1) {
            i3 = this.f19542m.get(0).getIntrinsicHeight();
        }
        return i2 + i3;
    }

    private boolean o() {
        return this.Q || Build.VERSION.SDK_INT < 21 || !(getBackground() instanceof RippleDrawable);
    }

    private boolean p() {
        return d(getValueOfTouchPosition());
    }

    private void q() {
        if (this.f19545p) {
            this.f19545p = false;
            ValueAnimator a2 = a(false);
            this.f19547r = a2;
            this.f19546q = null;
            a2.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    for (gy.a b2 : BaseSlider.this.f19542m) {
                        s.g(BaseSlider.this).b(b2);
                    }
                }
            });
            this.f19547r.start();
        }
    }

    private void r() {
        if (this.f19552w != 2) {
            if (!this.f19545p) {
                this.f19545p = true;
                ValueAnimator a2 = a(true);
                this.f19546q = a2;
                this.f19547r = null;
                a2.start();
            }
            Iterator<gy.a> it2 = this.f19542m.iterator();
            for (int i2 = 0; i2 < this.J.size() && it2.hasNext(); i2++) {
                if (i2 != this.L) {
                    a(it2.next(), this.J.get(i2).floatValue());
                }
            }
            if (it2.hasNext()) {
                a(it2.next(), this.J.get(this.L).floatValue());
            } else {
                throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", new Object[]{Integer.valueOf(this.f19542m.size()), Integer.valueOf(this.J.size())}));
            }
        }
    }

    private void s() {
        this.f19532c.setStrokeWidth((float) this.f19553x);
        this.f19533d.setStrokeWidth((float) this.f19553x);
        this.f19536g.setStrokeWidth(((float) this.f19553x) / 2.0f);
        this.f19537h.setStrokeWidth(((float) this.f19553x) / 2.0f);
    }

    private void setValuesInternal(ArrayList<Float> arrayList) {
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList);
            if (this.J.size() != arrayList.size() || !this.J.equals(arrayList)) {
                this.J = arrayList;
                this.S = true;
                this.L = 0;
                m();
                k();
                u();
                postInvalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("At least one value must be set");
    }

    private boolean t() {
        ViewParent parent = getParent();
        while (true) {
            boolean z2 = false;
            if (!(parent instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) {
                z2 = true;
            }
            if (z2 && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
            parent = parent.getParent();
        }
    }

    private void u() {
        for (L l2 : this.f19543n) {
            Iterator<Float> it2 = this.J.iterator();
            while (it2.hasNext()) {
                l2.a(this, it2.next().floatValue(), false);
            }
        }
    }

    private void v() {
        for (T a2 : this.f19544o) {
            a2.a(this);
        }
    }

    private void w() {
        for (T b2 : this.f19544o) {
            b2.b(this);
        }
    }

    private float x() {
        float f2 = this.M;
        if (f2 == 0.0f) {
            return 1.0f;
        }
        return f2;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, Rect rect) {
        int b2 = this.f19554y + ((int) (b(getValues().get(i2).floatValue()) * ((float) this.P)));
        int n2 = n();
        int i3 = this.A;
        rect.set(b2 - i3, n2 - i3, b2 + i3, n2 + i3);
    }

    public boolean a() {
        return this.F != null;
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        if (this.K != -1) {
            return true;
        }
        float valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
        float f2 = f(valueOfTouchPositionAbsolute);
        this.K = 0;
        float abs = Math.abs(this.J.get(0).floatValue() - valueOfTouchPositionAbsolute);
        for (int i2 = 1; i2 < this.J.size(); i2++) {
            float abs2 = Math.abs(this.J.get(i2).floatValue() - valueOfTouchPositionAbsolute);
            float f3 = f(this.J.get(i2).floatValue());
            if (Float.compare(abs2, abs) > 1) {
                break;
            }
            boolean z2 = !c() ? f3 - f2 < 0.0f : f3 - f2 > 0.0f;
            if (Float.compare(abs2, abs) >= 0) {
                if (Float.compare(abs2, abs) != 0) {
                    continue;
                } else if (Math.abs(f3 - f2) < ((float) this.f19548s)) {
                    this.K = -1;
                    return false;
                } else if (!z2) {
                }
            }
            this.K = i2;
            abs = abs2;
        }
        return this.K != -1;
    }

    /* access modifiers changed from: package-private */
    public final boolean c() {
        return ac.i(this) == 1;
    }

    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.f19538i.a(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f19532c.setColor(a(this.f19528aa));
        this.f19533d.setColor(a(this.W));
        this.f19536g.setColor(a(this.V));
        this.f19537h.setColor(a(this.U));
        for (gy.a next : this.f19542m) {
            if (next.isStateful()) {
                next.setState(getDrawableState());
            }
        }
        if (this.f19529ab.isStateful()) {
            this.f19529ab.setState(getDrawableState());
        }
        this.f19535f.setColor(a(this.T));
        this.f19535f.setAlpha(63);
    }

    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    /* access modifiers changed from: package-private */
    public final int getAccessibilityFocusedVirtualViewId() {
        return this.f19538i.b();
    }

    public int getActiveThumbIndex() {
        return this.K;
    }

    public int getFocusedThumbIndex() {
        return this.L;
    }

    public int getHaloRadius() {
        return this.B;
    }

    public ColorStateList getHaloTintList() {
        return this.T;
    }

    public int getLabelBehavior() {
        return this.f19552w;
    }

    /* access modifiers changed from: protected */
    public float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.M;
    }

    public float getThumbElevation() {
        return this.f19529ab.V();
    }

    public int getThumbRadius() {
        return this.A;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.f19529ab.O();
    }

    public float getThumbStrokeWidth() {
        return this.f19529ab.Q();
    }

    public ColorStateList getThumbTintList() {
        return this.f19529ab.N();
    }

    public ColorStateList getTickActiveTintList() {
        return this.U;
    }

    public ColorStateList getTickInactiveTintList() {
        return this.V;
    }

    public ColorStateList getTickTintList() {
        if (this.V.equals(this.U)) {
            return this.U;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    public ColorStateList getTrackActiveTintList() {
        return this.W;
    }

    public int getTrackHeight() {
        return this.f19553x;
    }

    public ColorStateList getTrackInactiveTintList() {
        return this.f19528aa;
    }

    public int getTrackSidePadding() {
        return this.f19554y;
    }

    public ColorStateList getTrackTintList() {
        if (this.f19528aa.equals(this.W)) {
            return this.W;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    public int getTrackWidth() {
        return this.P;
    }

    public float getValueFrom() {
        return this.H;
    }

    public float getValueTo() {
        return this.I;
    }

    /* access modifiers changed from: package-private */
    public List<Float> getValues() {
        return new ArrayList(this.J);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (gy.a a2 : this.f19542m) {
            a(a2);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        BaseSlider<S, L, T>.a aVar = this.f19540k;
        if (aVar != null) {
            removeCallbacks(aVar);
        }
        this.f19545p = false;
        for (gy.a b2 : this.f19542m) {
            b(b2);
        }
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.S) {
            j();
            l();
        }
        super.onDraw(canvas);
        int n2 = n();
        a(canvas, this.P, n2);
        if (((Float) Collections.max(getValues())).floatValue() > this.H) {
            b(canvas, this.P, n2);
        }
        a(canvas);
        if ((this.G || isFocused()) && isEnabled()) {
            d(canvas, this.P, n2);
            if (this.K != -1) {
                r();
            }
        }
        c(canvas, this.P, n2);
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z2, int i2, Rect rect) {
        super.onFocusChanged(z2, i2, rect);
        if (!z2) {
            this.K = -1;
            q();
            this.f19538i.d(this.L);
            return;
        }
        g(i2);
        this.f19538i.c(this.L);
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i2, keyEvent);
        }
        if (this.J.size() == 1) {
            this.K = 0;
        }
        if (this.K == -1) {
            Boolean a2 = a(i2, keyEvent);
            return a2 != null ? a2.booleanValue() : super.onKeyDown(i2, keyEvent);
        }
        this.R |= keyEvent.isLongPress();
        Float e2 = e(i2);
        if (e2 != null) {
            if (d(this.J.get(this.K).floatValue() + e2.floatValue())) {
                m();
                postInvalidate();
            }
            return true;
        }
        if (i2 != 23) {
            if (i2 != 61) {
                if (i2 != 66) {
                    return super.onKeyDown(i2, keyEvent);
                }
            } else if (keyEvent.hasNoModifiers()) {
                return c(1);
            } else {
                if (keyEvent.isShiftPressed()) {
                    return c(-1);
                }
                return false;
            }
        }
        this.K = -1;
        q();
        postInvalidate();
        return true;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        this.R = false;
        return super.onKeyUp(i2, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4 = this.f19551v;
        int i5 = 0;
        if (this.f19552w == 1) {
            i5 = this.f19542m.get(0).getIntrinsicHeight();
        }
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(i4 + i5, MemoryConstants.GB));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.H = sliderState.f19561a;
        this.I = sliderState.f19562b;
        setValuesInternal(sliderState.f19563c);
        this.M = sliderState.f19564d;
        if (sliderState.f19565e) {
            requestFocus();
        }
        u();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.f19561a = this.H;
        sliderState.f19562b = this.I;
        sliderState.f19563c = new ArrayList<>(this.J);
        sliderState.f19564d = this.M;
        sliderState.f19565e = hasFocus();
        return sliderState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        a(i2);
        m();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float x2 = motionEvent.getX();
        float f2 = (x2 - ((float) this.f19554y)) / ((float) this.P);
        this.f19530ac = f2;
        float max = Math.max(0.0f, f2);
        this.f19530ac = max;
        this.f19530ac = Math.min(1.0f, max);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                this.G = false;
                MotionEvent motionEvent2 = this.E;
                if (motionEvent2 != null && motionEvent2.getActionMasked() == 0 && Math.abs(this.E.getX() - motionEvent.getX()) <= ((float) this.f19548s) && Math.abs(this.E.getY() - motionEvent.getY()) <= ((float) this.f19548s) && b()) {
                    v();
                }
                if (this.K != -1) {
                    p();
                    this.K = -1;
                    w();
                }
                q();
            } else if (actionMasked == 2) {
                if (!this.G) {
                    if (t() && Math.abs(x2 - this.D) < ((float) this.f19548s)) {
                        return false;
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                    v();
                }
                if (b()) {
                    this.G = true;
                    p();
                    m();
                }
            }
            invalidate();
        } else {
            this.D = x2;
            if (!t()) {
                getParent().requestDisallowInterceptTouchEvent(true);
                if (b()) {
                    requestFocus();
                    this.G = true;
                    p();
                    m();
                    invalidate();
                    v();
                }
            }
        }
        setPressed(this.G);
        this.E = MotionEvent.obtain(motionEvent);
        return true;
    }

    /* access modifiers changed from: protected */
    public void setActiveThumbIndex(int i2) {
        this.K = i2;
    }

    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        setLayerType(z2 ? 0 : 2, (Paint) null);
    }

    public void setFocusedThumbIndex(int i2) {
        if (i2 < 0 || i2 >= this.J.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.L = i2;
        this.f19538i.c(i2);
        postInvalidate();
    }

    public void setHaloRadius(int i2) {
        if (i2 != this.B) {
            this.B = i2;
            Drawable background = getBackground();
            if (o() || !(background instanceof RippleDrawable)) {
                postInvalidate();
            } else {
                gp.a.a((RippleDrawable) background, this.B);
            }
        }
    }

    public void setHaloRadiusResource(int i2) {
        setHaloRadius(getResources().getDimensionPixelSize(i2));
    }

    public void setHaloTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.T)) {
            this.T = colorStateList;
            Drawable background = getBackground();
            if (o() || !(background instanceof RippleDrawable)) {
                this.f19535f.setColor(a(colorStateList));
                this.f19535f.setAlpha(63);
                invalidate();
                return;
            }
            ((RippleDrawable) background).setColor(colorStateList);
        }
    }

    public void setLabelBehavior(int i2) {
        if (this.f19552w != i2) {
            this.f19552w = i2;
            requestLayout();
        }
    }

    public void setLabelFormatter(c cVar) {
        this.F = cVar;
    }

    /* access modifiers changed from: protected */
    public void setSeparationUnit(int i2) {
        this.f19531ad = i2;
    }

    public void setStepSize(float f2) {
        if (f2 < 0.0f) {
            throw new IllegalArgumentException(String.format("The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range", new Object[]{Float.toString(f2), Float.toString(this.H), Float.toString(this.I)}));
        } else if (this.M != f2) {
            this.M = f2;
            this.S = true;
            postInvalidate();
        }
    }

    public void setThumbElevation(float f2) {
        this.f19529ab.r(f2);
    }

    public void setThumbElevationResource(int i2) {
        setThumbElevation(getResources().getDimension(i2));
    }

    public void setThumbRadius(int i2) {
        if (i2 != this.A) {
            this.A = i2;
            d();
            this.f19529ab.setShapeAppearanceModel(m.a().a(0, (float) this.A).a());
            h hVar = this.f19529ab;
            int i3 = this.A;
            hVar.setBounds(0, 0, i3 * 2, i3 * 2);
            postInvalidate();
        }
    }

    public void setThumbRadiusResource(int i2) {
        setThumbRadius(getResources().getDimensionPixelSize(i2));
    }

    public void setThumbStrokeColor(ColorStateList colorStateList) {
        this.f19529ab.h(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(int i2) {
        if (i2 != 0) {
            setThumbStrokeColor(c.a.a(getContext(), i2));
        }
    }

    public void setThumbStrokeWidth(float f2) {
        this.f19529ab.n(f2);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(int i2) {
        if (i2 != 0) {
            setThumbStrokeWidth(getResources().getDimension(i2));
        }
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.f19529ab.N())) {
            this.f19529ab.g(colorStateList);
            invalidate();
        }
    }

    public void setTickActiveTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.U)) {
            this.U = colorStateList;
            this.f19537h.setColor(a(colorStateList));
            invalidate();
        }
    }

    public void setTickInactiveTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.V)) {
            this.V = colorStateList;
            this.f19536g.setColor(a(colorStateList));
            invalidate();
        }
    }

    public void setTickTintList(ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisible(boolean z2) {
        if (this.O != z2) {
            this.O = z2;
            postInvalidate();
        }
    }

    public void setTrackActiveTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.W)) {
            this.W = colorStateList;
            this.f19533d.setColor(a(colorStateList));
            invalidate();
        }
    }

    public void setTrackHeight(int i2) {
        if (this.f19553x != i2) {
            this.f19553x = i2;
            s();
            postInvalidate();
        }
    }

    public void setTrackInactiveTintList(ColorStateList colorStateList) {
        if (!colorStateList.equals(this.f19528aa)) {
            this.f19528aa = colorStateList;
            this.f19532c.setColor(a(colorStateList));
            invalidate();
        }
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f2) {
        this.H = f2;
        this.S = true;
        postInvalidate();
    }

    public void setValueTo(float f2) {
        this.I = f2;
        this.S = true;
        postInvalidate();
    }

    /* access modifiers changed from: package-private */
    public void setValues(List<Float> list) {
        setValuesInternal(new ArrayList(list));
    }

    /* access modifiers changed from: package-private */
    public void setValues(Float... fArr) {
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, fArr);
        setValuesInternal(arrayList);
    }
}
