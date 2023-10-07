package com.flyco.tablayout;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SegmentTabLayout extends FrameLayout implements ValueAnimator.AnimatorUpdateListener {
    private float A;
    private int B;
    private int C;
    private int D;
    private boolean E;
    private int F;
    private int G;
    private float H;
    private int I;
    private ValueAnimator J;
    private OvershootInterpolator K;
    private dw.a L;
    private float[] M;
    private boolean N;
    private Paint O;
    private SparseArray<Boolean> P;
    /* access modifiers changed from: private */
    public dv.b Q;
    private a R;
    private a S;

    /* renamed from: a  reason: collision with root package name */
    private Context f11451a;

    /* renamed from: b  reason: collision with root package name */
    private String[] f11452b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f11453c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f11454d;

    /* renamed from: e  reason: collision with root package name */
    private int f11455e;

    /* renamed from: f  reason: collision with root package name */
    private int f11456f;

    /* renamed from: g  reason: collision with root package name */
    private Rect f11457g;

    /* renamed from: h  reason: collision with root package name */
    private GradientDrawable f11458h;

    /* renamed from: i  reason: collision with root package name */
    private GradientDrawable f11459i;

    /* renamed from: j  reason: collision with root package name */
    private Paint f11460j;

    /* renamed from: k  reason: collision with root package name */
    private float f11461k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f11462l;

    /* renamed from: m  reason: collision with root package name */
    private float f11463m;

    /* renamed from: n  reason: collision with root package name */
    private int f11464n;

    /* renamed from: o  reason: collision with root package name */
    private float f11465o;

    /* renamed from: p  reason: collision with root package name */
    private float f11466p;

    /* renamed from: q  reason: collision with root package name */
    private float f11467q;

    /* renamed from: r  reason: collision with root package name */
    private float f11468r;

    /* renamed from: s  reason: collision with root package name */
    private float f11469s;

    /* renamed from: t  reason: collision with root package name */
    private float f11470t;

    /* renamed from: u  reason: collision with root package name */
    private long f11471u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f11472v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f11473w;

    /* renamed from: x  reason: collision with root package name */
    private int f11474x;

    /* renamed from: y  reason: collision with root package name */
    private float f11475y;

    /* renamed from: z  reason: collision with root package name */
    private float f11476z;

    class a {

        /* renamed from: a  reason: collision with root package name */
        public float f11478a;

        /* renamed from: b  reason: collision with root package name */
        public float f11479b;

        a() {
        }
    }

    class b implements TypeEvaluator<a> {
        b() {
        }

        /* renamed from: a */
        public a evaluate(float f2, a aVar, a aVar2) {
            float f3 = aVar.f11478a + ((aVar2.f11478a - aVar.f11478a) * f2);
            float f4 = aVar.f11479b + (f2 * (aVar2.f11479b - aVar.f11479b));
            a aVar3 = new a();
            aVar3.f11478a = f3;
            aVar3.f11479b = f4;
            return aVar3;
        }
    }

    public SegmentTabLayout(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public SegmentTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SegmentTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11457g = new Rect();
        this.f11458h = new GradientDrawable();
        this.f11459i = new GradientDrawable();
        this.f11460j = new Paint(1);
        this.K = new OvershootInterpolator(0.8f);
        this.M = new float[8];
        this.N = true;
        this.O = new Paint(1);
        this.P = new SparseArray<>();
        this.R = new a();
        this.S = new a();
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.f11451a = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f11453c = linearLayout;
        addView(linearLayout);
        a(context, attributeSet);
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (!attributeValue.equals("-1") && !attributeValue.equals("-2")) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842997});
            this.I = obtainStyledAttributes.getDimensionPixelSize(0, -2);
            obtainStyledAttributes.recycle();
        }
        ValueAnimator ofObject = ValueAnimator.ofObject(new b(), new Object[]{this.S, this.R});
        this.J = ofObject;
        ofObject.addUpdateListener(this);
    }

    private void a(int i2) {
        int i3 = 0;
        while (i3 < this.f11456f) {
            View childAt = this.f11453c.getChildAt(i3);
            boolean z2 = i3 == i2;
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            textView.setTextColor(z2 ? this.B : this.C);
            if (this.D == 1) {
                textView.getPaint().setFakeBoldText(z2);
            }
            i3++;
        }
    }

    private void a(int i2, View view) {
        ((TextView) view.findViewById(R.id.tv_tab_title)).setText(this.f11452b[i2]);
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (SegmentTabLayout.this.f11454d != intValue) {
                    SegmentTabLayout.this.setCurrentTab(intValue);
                    if (SegmentTabLayout.this.Q != null) {
                        SegmentTabLayout.this.Q.a(intValue);
                    }
                } else if (SegmentTabLayout.this.Q != null) {
                    SegmentTabLayout.this.Q.b(intValue);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = this.f11462l ? new LinearLayout.LayoutParams(0, -1, 1.0f) : new LinearLayout.LayoutParams(-2, -1);
        if (this.f11463m > 0.0f) {
            layoutParams = new LinearLayout.LayoutParams((int) this.f11463m, -1);
        }
        this.f11453c.addView(view, i2, layoutParams);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SegmentTabLayout);
        this.f11464n = obtainStyledAttributes.getColor(R.styleable.SegmentTabLayout_tl_indicator_color, Color.parseColor("#222831"));
        this.f11465o = obtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_indicator_height, -1.0f);
        this.f11466p = obtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_indicator_corner_radius, -1.0f);
        this.f11467q = obtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_indicator_margin_left, (float) a(0.0f));
        this.f11468r = obtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_indicator_margin_top, 0.0f);
        this.f11469s = obtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_indicator_margin_right, (float) a(0.0f));
        this.f11470t = obtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_indicator_margin_bottom, 0.0f);
        this.f11472v = obtainStyledAttributes.getBoolean(R.styleable.SegmentTabLayout_tl_indicator_anim_enable, false);
        this.f11473w = obtainStyledAttributes.getBoolean(R.styleable.SegmentTabLayout_tl_indicator_bounce_enable, true);
        this.f11471u = (long) obtainStyledAttributes.getInt(R.styleable.SegmentTabLayout_tl_indicator_anim_duration, -1);
        this.f11474x = obtainStyledAttributes.getColor(R.styleable.SegmentTabLayout_tl_divider_color, this.f11464n);
        this.f11475y = obtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_divider_width, (float) a(1.0f));
        this.f11476z = obtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_divider_padding, 0.0f);
        this.A = obtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_textsize, (float) b(13.0f));
        this.B = obtainStyledAttributes.getColor(R.styleable.SegmentTabLayout_tl_textSelectColor, Color.parseColor("#ffffff"));
        this.C = obtainStyledAttributes.getColor(R.styleable.SegmentTabLayout_tl_textUnselectColor, this.f11464n);
        this.D = obtainStyledAttributes.getInt(R.styleable.SegmentTabLayout_tl_textBold, 0);
        this.E = obtainStyledAttributes.getBoolean(R.styleable.SegmentTabLayout_tl_textAllCaps, false);
        this.f11462l = obtainStyledAttributes.getBoolean(R.styleable.SegmentTabLayout_tl_tab_space_equal, true);
        this.f11463m = obtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_tab_width, (float) a(-1.0f));
        this.f11461k = obtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_tab_padding, (float) ((this.f11462l || this.f11463m > 0.0f) ? a(0.0f) : a(10.0f)));
        this.F = obtainStyledAttributes.getColor(R.styleable.SegmentTabLayout_tl_bar_color, 0);
        this.G = obtainStyledAttributes.getColor(R.styleable.SegmentTabLayout_tl_bar_stroke_color, this.f11464n);
        this.H = obtainStyledAttributes.getDimension(R.styleable.SegmentTabLayout_tl_bar_stroke_width, (float) a(1.0f));
        obtainStyledAttributes.recycle();
    }

    private void b() {
        int i2 = 0;
        while (i2 < this.f11456f) {
            View childAt = this.f11453c.getChildAt(i2);
            float f2 = this.f11461k;
            childAt.setPadding((int) f2, 0, (int) f2, 0);
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            textView.setTextColor(i2 == this.f11454d ? this.B : this.C);
            textView.setTextSize(0, this.A);
            if (this.E) {
                textView.setText(textView.getText().toString().toUpperCase());
            }
            int i3 = this.D;
            if (i3 == 2) {
                textView.getPaint().setFakeBoldText(true);
            } else if (i3 == 0) {
                textView.getPaint().setFakeBoldText(false);
            }
            i2++;
        }
    }

    private void c() {
        View childAt = this.f11453c.getChildAt(this.f11454d);
        this.R.f11478a = (float) childAt.getLeft();
        this.R.f11479b = (float) childAt.getRight();
        View childAt2 = this.f11453c.getChildAt(this.f11455e);
        this.S.f11478a = (float) childAt2.getLeft();
        this.S.f11479b = (float) childAt2.getRight();
        if (this.S.f11478a == this.R.f11478a && this.S.f11479b == this.R.f11479b) {
            invalidate();
            return;
        }
        this.J.setObjectValues(new Object[]{this.S, this.R});
        if (this.f11473w) {
            this.J.setInterpolator(this.K);
        }
        if (this.f11471u < 0) {
            this.f11471u = this.f11473w ? 500 : 250;
        }
        this.J.setDuration(this.f11471u);
        this.J.start();
    }

    private void d() {
        View childAt = this.f11453c.getChildAt(this.f11454d);
        this.f11457g.left = (int) ((float) childAt.getLeft());
        this.f11457g.right = (int) ((float) childAt.getRight());
        if (!this.f11472v) {
            int i2 = this.f11454d;
            if (i2 == 0) {
                float[] fArr = this.M;
                float f2 = this.f11466p;
                fArr[0] = f2;
                fArr[1] = f2;
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
                fArr[4] = 0.0f;
                fArr[5] = 0.0f;
                fArr[6] = f2;
                fArr[7] = f2;
            } else if (i2 == this.f11456f - 1) {
                float[] fArr2 = this.M;
                fArr2[0] = 0.0f;
                fArr2[1] = 0.0f;
                float f3 = this.f11466p;
                fArr2[2] = f3;
                fArr2[3] = f3;
                fArr2[4] = f3;
                fArr2[5] = f3;
                fArr2[6] = 0.0f;
                fArr2[7] = 0.0f;
            } else {
                float[] fArr3 = this.M;
                fArr3[0] = 0.0f;
                fArr3[1] = 0.0f;
                fArr3[2] = 0.0f;
                fArr3[3] = 0.0f;
                fArr3[4] = 0.0f;
                fArr3[5] = 0.0f;
                fArr3[6] = 0.0f;
                fArr3[7] = 0.0f;
            }
        } else {
            float[] fArr4 = this.M;
            float f4 = this.f11466p;
            fArr4[0] = f4;
            fArr4[1] = f4;
            fArr4[2] = f4;
            fArr4[3] = f4;
            fArr4[4] = f4;
            fArr4[5] = f4;
            fArr4[6] = f4;
            fArr4[7] = f4;
        }
    }

    /* access modifiers changed from: protected */
    public int a(float f2) {
        return (int) ((f2 * this.f11451a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void a() {
        this.f11453c.removeAllViews();
        this.f11456f = this.f11452b.length;
        for (int i2 = 0; i2 < this.f11456f; i2++) {
            View inflate = View.inflate(this.f11451a, R.layout.layout_tab_segment, (ViewGroup) null);
            inflate.setTag(Integer.valueOf(i2));
            a(i2, inflate);
        }
        b();
    }

    /* access modifiers changed from: protected */
    public int b(float f2) {
        return (int) ((f2 * this.f11451a.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public int getCurrentTab() {
        return this.f11454d;
    }

    public int getDividerColor() {
        return this.f11474x;
    }

    public float getDividerPadding() {
        return this.f11476z;
    }

    public float getDividerWidth() {
        return this.f11475y;
    }

    public long getIndicatorAnimDuration() {
        return this.f11471u;
    }

    public int getIndicatorColor() {
        return this.f11464n;
    }

    public float getIndicatorCornerRadius() {
        return this.f11466p;
    }

    public float getIndicatorHeight() {
        return this.f11465o;
    }

    public float getIndicatorMarginBottom() {
        return this.f11470t;
    }

    public float getIndicatorMarginLeft() {
        return this.f11467q;
    }

    public float getIndicatorMarginRight() {
        return this.f11469s;
    }

    public float getIndicatorMarginTop() {
        return this.f11468r;
    }

    public int getTabCount() {
        return this.f11456f;
    }

    public float getTabPadding() {
        return this.f11461k;
    }

    public float getTabWidth() {
        return this.f11463m;
    }

    public int getTextBold() {
        return this.D;
    }

    public int getTextSelectColor() {
        return this.B;
    }

    public int getTextUnselectColor() {
        return this.C;
    }

    public float getTextsize() {
        return this.A;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        a aVar = (a) valueAnimator.getAnimatedValue();
        this.f11457g.left = (int) aVar.f11478a;
        this.f11457g.right = (int) aVar.f11479b;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.f11456f > 0) {
            int height = getHeight();
            int paddingLeft = getPaddingLeft();
            if (this.f11465o < 0.0f) {
                this.f11465o = (((float) height) - this.f11468r) - this.f11470t;
            }
            float f2 = this.f11466p;
            if (f2 < 0.0f || f2 > this.f11465o / 2.0f) {
                this.f11466p = this.f11465o / 2.0f;
            }
            this.f11459i.setColor(this.F);
            this.f11459i.setStroke((int) this.H, this.G);
            this.f11459i.setCornerRadius(this.f11466p);
            this.f11459i.setBounds(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
            this.f11459i.draw(canvas);
            if (!this.f11472v) {
                float f3 = this.f11475y;
                if (f3 > 0.0f) {
                    this.f11460j.setStrokeWidth(f3);
                    this.f11460j.setColor(this.f11474x);
                    for (int i2 = 0; i2 < this.f11456f - 1; i2++) {
                        View childAt = this.f11453c.getChildAt(i2);
                        canvas.drawLine((float) (childAt.getRight() + paddingLeft), this.f11476z, (float) (childAt.getRight() + paddingLeft), ((float) height) - this.f11476z, this.f11460j);
                    }
                }
            }
            if (this.f11472v) {
                if (this.N) {
                    this.N = false;
                }
                this.f11458h.setColor(this.f11464n);
                this.f11458h.setBounds(((int) this.f11467q) + paddingLeft + this.f11457g.left, (int) this.f11468r, (int) (((float) (paddingLeft + this.f11457g.right)) - this.f11469s), (int) (this.f11468r + this.f11465o));
                this.f11458h.setCornerRadii(this.M);
                this.f11458h.draw(canvas);
            }
            d();
            this.f11458h.setColor(this.f11464n);
            this.f11458h.setBounds(((int) this.f11467q) + paddingLeft + this.f11457g.left, (int) this.f11468r, (int) (((float) (paddingLeft + this.f11457g.right)) - this.f11469s), (int) (this.f11468r + this.f11465o));
            this.f11458h.setCornerRadii(this.M);
            this.f11458h.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f11454d = bundle.getInt("mCurrentTab");
            parcelable = bundle.getParcelable("instanceState");
            if (this.f11454d != 0 && this.f11453c.getChildCount() > 0) {
                a(this.f11454d);
            }
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("mCurrentTab", this.f11454d);
        return bundle;
    }

    public void setCurrentTab(int i2) {
        this.f11455e = this.f11454d;
        this.f11454d = i2;
        a(i2);
        dw.a aVar = this.L;
        if (aVar != null) {
            aVar.a(i2);
        }
        if (this.f11472v) {
            c();
        } else {
            invalidate();
        }
    }

    public void setDividerColor(int i2) {
        this.f11474x = i2;
        invalidate();
    }

    public void setDividerPadding(float f2) {
        this.f11476z = (float) a(f2);
        invalidate();
    }

    public void setDividerWidth(float f2) {
        this.f11475y = (float) a(f2);
        invalidate();
    }

    public void setIndicatorAnimDuration(long j2) {
        this.f11471u = j2;
    }

    public void setIndicatorAnimEnable(boolean z2) {
        this.f11472v = z2;
    }

    public void setIndicatorBounceEnable(boolean z2) {
        this.f11473w = z2;
    }

    public void setIndicatorColor(int i2) {
        this.f11464n = i2;
        invalidate();
    }

    public void setIndicatorCornerRadius(float f2) {
        this.f11466p = (float) a(f2);
        invalidate();
    }

    public void setIndicatorHeight(float f2) {
        this.f11465o = (float) a(f2);
        invalidate();
    }

    public void setOnTabSelectListener(dv.b bVar) {
        this.Q = bVar;
    }

    public void setTabData(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalStateException("Titles can not be NULL or EMPTY !");
        }
        this.f11452b = strArr;
        a();
    }

    public void setTabPadding(float f2) {
        this.f11461k = (float) a(f2);
        b();
    }

    public void setTabSpaceEqual(boolean z2) {
        this.f11462l = z2;
        b();
    }

    public void setTabWidth(float f2) {
        this.f11463m = (float) a(f2);
        b();
    }

    public void setTextAllCaps(boolean z2) {
        this.E = z2;
        b();
    }

    public void setTextBold(int i2) {
        this.D = i2;
        b();
    }

    public void setTextSelectColor(int i2) {
        this.B = i2;
        b();
    }

    public void setTextUnselectColor(int i2) {
        this.C = i2;
        b();
    }

    public void setTextsize(float f2) {
        this.A = (float) b(f2);
        b();
    }
}
