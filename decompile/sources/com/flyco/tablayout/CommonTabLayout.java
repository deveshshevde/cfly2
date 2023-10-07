package com.flyco.tablayout;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class CommonTabLayout extends FrameLayout implements ValueAnimator.AnimatorUpdateListener {
    private boolean A;
    private int B;
    private int C;
    private float D;
    private int E;
    private int F;
    private float G;
    private float H;
    private float I;
    private int J;
    private int K;
    private int L;
    private boolean M;
    private boolean N;
    private int O;
    private float P;
    private float Q;
    private float R;
    private int S;
    private ValueAnimator T;
    private OvershootInterpolator U;
    private dw.a V;
    private boolean W;

    /* renamed from: a  reason: collision with root package name */
    private Context f11415a;

    /* renamed from: aa  reason: collision with root package name */
    private Paint f11416aa;

    /* renamed from: ab  reason: collision with root package name */
    private SparseArray<Boolean> f11417ab;
    /* access modifiers changed from: private */

    /* renamed from: ac  reason: collision with root package name */
    public dv.b f11418ac;

    /* renamed from: ad  reason: collision with root package name */
    private a f11419ad;

    /* renamed from: ae  reason: collision with root package name */
    private a f11420ae;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<dv.a> f11421b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f11422c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f11423d;

    /* renamed from: e  reason: collision with root package name */
    private int f11424e;

    /* renamed from: f  reason: collision with root package name */
    private int f11425f;

    /* renamed from: g  reason: collision with root package name */
    private Rect f11426g;

    /* renamed from: h  reason: collision with root package name */
    private GradientDrawable f11427h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f11428i;

    /* renamed from: j  reason: collision with root package name */
    private Paint f11429j;

    /* renamed from: k  reason: collision with root package name */
    private Paint f11430k;

    /* renamed from: l  reason: collision with root package name */
    private Path f11431l;

    /* renamed from: m  reason: collision with root package name */
    private int f11432m;

    /* renamed from: n  reason: collision with root package name */
    private float f11433n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f11434o;

    /* renamed from: p  reason: collision with root package name */
    private float f11435p;

    /* renamed from: q  reason: collision with root package name */
    private int f11436q;

    /* renamed from: r  reason: collision with root package name */
    private float f11437r;

    /* renamed from: s  reason: collision with root package name */
    private float f11438s;

    /* renamed from: t  reason: collision with root package name */
    private float f11439t;

    /* renamed from: u  reason: collision with root package name */
    private float f11440u;

    /* renamed from: v  reason: collision with root package name */
    private float f11441v;

    /* renamed from: w  reason: collision with root package name */
    private float f11442w;

    /* renamed from: x  reason: collision with root package name */
    private float f11443x;

    /* renamed from: y  reason: collision with root package name */
    private long f11444y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f11445z;

    class a {

        /* renamed from: a  reason: collision with root package name */
        public float f11447a;

        /* renamed from: b  reason: collision with root package name */
        public float f11448b;

        a() {
        }
    }

    class b implements TypeEvaluator<a> {
        b() {
        }

        /* renamed from: a */
        public a evaluate(float f2, a aVar, a aVar2) {
            float f3 = aVar.f11447a + ((aVar2.f11447a - aVar.f11447a) * f2);
            float f4 = aVar.f11448b + (f2 * (aVar2.f11448b - aVar.f11448b));
            a aVar3 = new a();
            aVar3.f11447a = f3;
            aVar3.f11448b = f4;
            return aVar3;
        }
    }

    public CommonTabLayout(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public CommonTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11421b = new ArrayList<>();
        this.f11426g = new Rect();
        this.f11427h = new GradientDrawable();
        this.f11428i = new Paint(1);
        this.f11429j = new Paint(1);
        this.f11430k = new Paint(1);
        this.f11431l = new Path();
        this.f11432m = 0;
        this.U = new OvershootInterpolator(1.5f);
        this.W = true;
        this.f11416aa = new Paint(1);
        this.f11417ab = new SparseArray<>();
        this.f11419ad = new a();
        this.f11420ae = new a();
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.f11415a = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f11422c = linearLayout;
        addView(linearLayout);
        a(context, attributeSet);
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (!attributeValue.equals("-1") && !attributeValue.equals("-2")) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842997});
            this.S = obtainStyledAttributes.getDimensionPixelSize(0, -2);
            obtainStyledAttributes.recycle();
        }
        ValueAnimator ofObject = ValueAnimator.ofObject(new b(), new Object[]{this.f11420ae, this.f11419ad});
        this.T = ofObject;
        ofObject.addUpdateListener(this);
    }

    private void a(int i2) {
        int i3 = 0;
        while (i3 < this.f11425f) {
            View childAt = this.f11422c.getChildAt(i3);
            boolean z2 = i3 == i2;
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            textView.setTextColor(z2 ? this.J : this.K);
            ImageView imageView = (ImageView) childAt.findViewById(R.id.iv_tab_icon);
            dv.a aVar = this.f11421b.get(i3);
            imageView.setImageResource(z2 ? aVar.b() : aVar.c());
            if (this.L == 1) {
                textView.getPaint().setFakeBoldText(z2);
            }
            i3++;
        }
    }

    private void a(int i2, View view) {
        ((TextView) view.findViewById(R.id.tv_tab_title)).setText(this.f11421b.get(i2).a());
        ((ImageView) view.findViewById(R.id.iv_tab_icon)).setImageResource(this.f11421b.get(i2).c());
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (CommonTabLayout.this.f11423d != intValue) {
                    CommonTabLayout.this.setCurrentTab(intValue);
                    if (CommonTabLayout.this.f11418ac != null) {
                        CommonTabLayout.this.f11418ac.a(intValue);
                    }
                } else if (CommonTabLayout.this.f11418ac != null) {
                    CommonTabLayout.this.f11418ac.b(intValue);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = this.f11434o ? new LinearLayout.LayoutParams(0, -1, 1.0f) : new LinearLayout.LayoutParams(-2, -1);
        if (this.f11435p > 0.0f) {
            layoutParams = new LinearLayout.LayoutParams((int) this.f11435p, -1);
        }
        this.f11422c.addView(view, i2, layoutParams);
    }

    private void a(Context context, AttributeSet attributeSet) {
        float f2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CommonTabLayout);
        this.f11432m = obtainStyledAttributes.getInt(R.styleable.CommonTabLayout_tl_indicator_style, 0);
        this.f11436q = obtainStyledAttributes.getColor(R.styleable.CommonTabLayout_tl_indicator_color, Color.parseColor(this.f11432m == 2 ? "#4B6A87" : "#ffffff"));
        int i2 = R.styleable.CommonTabLayout_tl_indicator_height;
        int i3 = this.f11432m;
        if (i3 == 1) {
            f2 = 4.0f;
        } else {
            f2 = (float) (i3 == 2 ? -1 : 2);
        }
        this.f11437r = obtainStyledAttributes.getDimension(i2, (float) a(f2));
        this.f11438s = obtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_indicator_width, (float) a(this.f11432m == 1 ? 10.0f : -1.0f));
        this.f11439t = obtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_indicator_corner_radius, (float) a(this.f11432m == 2 ? -1.0f : 0.0f));
        this.f11440u = obtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_indicator_margin_left, (float) a(0.0f));
        float f3 = 7.0f;
        this.f11441v = obtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_indicator_margin_top, (float) a(this.f11432m == 2 ? 7.0f : 0.0f));
        this.f11442w = obtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_indicator_margin_right, (float) a(0.0f));
        int i4 = R.styleable.CommonTabLayout_tl_indicator_margin_bottom;
        if (this.f11432m != 2) {
            f3 = 0.0f;
        }
        this.f11443x = obtainStyledAttributes.getDimension(i4, (float) a(f3));
        this.f11445z = obtainStyledAttributes.getBoolean(R.styleable.CommonTabLayout_tl_indicator_anim_enable, true);
        this.A = obtainStyledAttributes.getBoolean(R.styleable.CommonTabLayout_tl_indicator_bounce_enable, true);
        this.f11444y = (long) obtainStyledAttributes.getInt(R.styleable.CommonTabLayout_tl_indicator_anim_duration, -1);
        this.B = obtainStyledAttributes.getInt(R.styleable.CommonTabLayout_tl_indicator_gravity, 80);
        this.C = obtainStyledAttributes.getColor(R.styleable.CommonTabLayout_tl_underline_color, Color.parseColor("#ffffff"));
        this.D = obtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_underline_height, (float) a(0.0f));
        this.E = obtainStyledAttributes.getInt(R.styleable.CommonTabLayout_tl_underline_gravity, 80);
        this.F = obtainStyledAttributes.getColor(R.styleable.CommonTabLayout_tl_divider_color, Color.parseColor("#ffffff"));
        this.G = obtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_divider_width, (float) a(0.0f));
        this.H = obtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_divider_padding, (float) a(12.0f));
        this.I = obtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_textsize, (float) b(13.0f));
        this.J = obtainStyledAttributes.getColor(R.styleable.CommonTabLayout_tl_textSelectColor, Color.parseColor("#ffffff"));
        this.K = obtainStyledAttributes.getColor(R.styleable.CommonTabLayout_tl_textUnselectColor, Color.parseColor("#AAffffff"));
        this.L = obtainStyledAttributes.getInt(R.styleable.CommonTabLayout_tl_textBold, 0);
        this.M = obtainStyledAttributes.getBoolean(R.styleable.CommonTabLayout_tl_textAllCaps, false);
        this.N = obtainStyledAttributes.getBoolean(R.styleable.CommonTabLayout_tl_iconVisible, true);
        this.O = obtainStyledAttributes.getInt(R.styleable.CommonTabLayout_tl_iconGravity, 48);
        this.P = obtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_iconWidth, (float) a(0.0f));
        this.Q = obtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_iconHeight, (float) a(0.0f));
        this.R = obtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_iconMargin, (float) a(2.5f));
        this.f11434o = obtainStyledAttributes.getBoolean(R.styleable.CommonTabLayout_tl_tab_space_equal, true);
        this.f11435p = obtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_tab_width, (float) a(-1.0f));
        this.f11433n = obtainStyledAttributes.getDimension(R.styleable.CommonTabLayout_tl_tab_padding, (float) ((this.f11434o || this.f11435p > 0.0f) ? a(0.0f) : a(10.0f)));
        obtainStyledAttributes.recycle();
    }

    private void b() {
        int i2 = 0;
        while (i2 < this.f11425f) {
            View childAt = this.f11422c.getChildAt(i2);
            float f2 = this.f11433n;
            childAt.setPadding((int) f2, 0, (int) f2, 0);
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            textView.setTextColor(i2 == this.f11423d ? this.J : this.K);
            textView.setTextSize(0, this.I);
            if (this.M) {
                textView.setText(textView.getText().toString().toUpperCase());
            }
            int i3 = this.L;
            if (i3 == 2) {
                textView.getPaint().setFakeBoldText(true);
            } else if (i3 == 0) {
                textView.getPaint().setFakeBoldText(false);
            }
            ImageView imageView = (ImageView) childAt.findViewById(R.id.iv_tab_icon);
            if (this.N) {
                imageView.setVisibility(0);
                dv.a aVar = this.f11421b.get(i2);
                imageView.setImageResource(i2 == this.f11423d ? aVar.b() : aVar.c());
                float f3 = this.P;
                int i4 = -2;
                int i5 = f3 <= 0.0f ? -2 : (int) f3;
                float f4 = this.Q;
                if (f4 > 0.0f) {
                    i4 = (int) f4;
                }
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(i5, i4);
                int i6 = this.O;
                if (i6 == 3) {
                    layoutParams.rightMargin = (int) this.R;
                } else if (i6 == 5) {
                    layoutParams.leftMargin = (int) this.R;
                } else if (i6 == 80) {
                    layoutParams.topMargin = (int) this.R;
                } else {
                    layoutParams.bottomMargin = (int) this.R;
                }
                imageView.setLayoutParams(layoutParams);
            } else {
                imageView.setVisibility(8);
            }
            i2++;
        }
    }

    private void c() {
        View childAt = this.f11422c.getChildAt(this.f11423d);
        this.f11419ad.f11447a = (float) childAt.getLeft();
        this.f11419ad.f11448b = (float) childAt.getRight();
        View childAt2 = this.f11422c.getChildAt(this.f11424e);
        this.f11420ae.f11447a = (float) childAt2.getLeft();
        this.f11420ae.f11448b = (float) childAt2.getRight();
        if (this.f11420ae.f11447a == this.f11419ad.f11447a && this.f11420ae.f11448b == this.f11419ad.f11448b) {
            invalidate();
            return;
        }
        this.T.setObjectValues(new Object[]{this.f11420ae, this.f11419ad});
        if (this.A) {
            this.T.setInterpolator(this.U);
        }
        if (this.f11444y < 0) {
            this.f11444y = this.A ? 500 : 250;
        }
        this.T.setDuration(this.f11444y);
        this.T.start();
    }

    private void d() {
        View childAt = this.f11422c.getChildAt(this.f11423d);
        this.f11426g.left = (int) ((float) childAt.getLeft());
        this.f11426g.right = (int) ((float) childAt.getRight());
        if (this.f11438s >= 0.0f) {
            this.f11426g.left = (int) (((float) childAt.getLeft()) + ((((float) childAt.getWidth()) - this.f11438s) / 2.0f));
            Rect rect = this.f11426g;
            rect.right = (int) (((float) rect.left) + this.f11438s);
        }
    }

    /* access modifiers changed from: protected */
    public int a(float f2) {
        return (int) ((f2 * this.f11415a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void a() {
        Context context;
        int i2;
        this.f11422c.removeAllViews();
        this.f11425f = this.f11421b.size();
        for (int i3 = 0; i3 < this.f11425f; i3++) {
            int i4 = this.O;
            if (i4 == 3) {
                context = this.f11415a;
                i2 = R.layout.layout_tab_left;
            } else if (i4 == 5) {
                context = this.f11415a;
                i2 = R.layout.layout_tab_right;
            } else if (i4 == 80) {
                context = this.f11415a;
                i2 = R.layout.layout_tab_bottom;
            } else {
                context = this.f11415a;
                i2 = R.layout.layout_tab_top;
            }
            View inflate = View.inflate(context, i2, (ViewGroup) null);
            inflate.setTag(Integer.valueOf(i3));
            a(i3, inflate);
        }
        b();
    }

    /* access modifiers changed from: protected */
    public int b(float f2) {
        return (int) ((f2 * this.f11415a.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public int getCurrentTab() {
        return this.f11423d;
    }

    public int getDividerColor() {
        return this.F;
    }

    public float getDividerPadding() {
        return this.H;
    }

    public float getDividerWidth() {
        return this.G;
    }

    public int getIconGravity() {
        return this.O;
    }

    public float getIconHeight() {
        return this.Q;
    }

    public float getIconMargin() {
        return this.R;
    }

    public float getIconWidth() {
        return this.P;
    }

    public long getIndicatorAnimDuration() {
        return this.f11444y;
    }

    public int getIndicatorColor() {
        return this.f11436q;
    }

    public float getIndicatorCornerRadius() {
        return this.f11439t;
    }

    public float getIndicatorHeight() {
        return this.f11437r;
    }

    public float getIndicatorMarginBottom() {
        return this.f11443x;
    }

    public float getIndicatorMarginLeft() {
        return this.f11440u;
    }

    public float getIndicatorMarginRight() {
        return this.f11442w;
    }

    public float getIndicatorMarginTop() {
        return this.f11441v;
    }

    public int getIndicatorStyle() {
        return this.f11432m;
    }

    public float getIndicatorWidth() {
        return this.f11438s;
    }

    public int getTabCount() {
        return this.f11425f;
    }

    public float getTabPadding() {
        return this.f11433n;
    }

    public float getTabWidth() {
        return this.f11435p;
    }

    public int getTextBold() {
        return this.L;
    }

    public int getTextSelectColor() {
        return this.J;
    }

    public int getTextUnselectColor() {
        return this.K;
    }

    public float getTextsize() {
        return this.I;
    }

    public int getUnderlineColor() {
        return this.C;
    }

    public float getUnderlineHeight() {
        return this.D;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        View childAt = this.f11422c.getChildAt(this.f11423d);
        a aVar = (a) valueAnimator.getAnimatedValue();
        this.f11426g.left = (int) aVar.f11447a;
        this.f11426g.right = (int) aVar.f11448b;
        if (this.f11438s >= 0.0f) {
            this.f11426g.left = (int) (aVar.f11447a + ((((float) childAt.getWidth()) - this.f11438s) / 2.0f));
            Rect rect = this.f11426g;
            rect.right = (int) (((float) rect.left) + this.f11438s);
        }
        invalidate();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r13) {
        /*
            r12 = this;
            super.onDraw(r13)
            boolean r0 = r12.isInEditMode()
            if (r0 != 0) goto L_0x019a
            int r0 = r12.f11425f
            if (r0 > 0) goto L_0x000f
            goto L_0x019a
        L_0x000f:
            int r6 = r12.getHeight()
            int r7 = r12.getPaddingLeft()
            float r0 = r12.G
            r8 = 0
            r9 = 1
            r10 = 0
            int r1 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r1 <= 0) goto L_0x0054
            android.graphics.Paint r1 = r12.f11429j
            r1.setStrokeWidth(r0)
            android.graphics.Paint r0 = r12.f11429j
            int r1 = r12.F
            r0.setColor(r1)
            r11 = 0
        L_0x002d:
            int r0 = r12.f11425f
            int r0 = r0 - r9
            if (r11 >= r0) goto L_0x0054
            android.widget.LinearLayout r0 = r12.f11422c
            android.view.View r0 = r0.getChildAt(r11)
            int r1 = r0.getRight()
            int r1 = r1 + r7
            float r1 = (float) r1
            float r2 = r12.H
            int r0 = r0.getRight()
            int r0 = r0 + r7
            float r3 = (float) r0
            float r0 = (float) r6
            float r4 = r12.H
            float r4 = r0 - r4
            android.graphics.Paint r5 = r12.f11429j
            r0 = r13
            r0.drawLine(r1, r2, r3, r4, r5)
            int r11 = r11 + 1
            goto L_0x002d
        L_0x0054:
            float r0 = r12.D
            r11 = 80
            int r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r0 <= 0) goto L_0x0087
            android.graphics.Paint r0 = r12.f11428i
            int r1 = r12.C
            r0.setColor(r1)
            int r0 = r12.E
            float r1 = (float) r7
            if (r0 != r11) goto L_0x0076
            float r4 = (float) r6
            float r0 = r12.D
            float r2 = r4 - r0
            android.widget.LinearLayout r0 = r12.f11422c
            int r0 = r0.getWidth()
            int r0 = r0 + r7
            float r3 = (float) r0
            goto L_0x0081
        L_0x0076:
            r2 = 0
            android.widget.LinearLayout r0 = r12.f11422c
            int r0 = r0.getWidth()
            int r0 = r0 + r7
            float r3 = (float) r0
            float r4 = r12.D
        L_0x0081:
            android.graphics.Paint r5 = r12.f11428i
            r0 = r13
            r0.drawRect(r1, r2, r3, r4, r5)
        L_0x0087:
            boolean r0 = r12.f11445z
            if (r0 == 0) goto L_0x0091
            boolean r0 = r12.W
            if (r0 == 0) goto L_0x0094
            r12.W = r8
        L_0x0091:
            r12.d()
        L_0x0094:
            int r0 = r12.f11432m
            r1 = 2
            if (r0 != r9) goto L_0x00e6
            float r0 = r12.f11437r
            int r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r0 <= 0) goto L_0x019a
            android.graphics.Paint r0 = r12.f11430k
            int r2 = r12.f11436q
            r0.setColor(r2)
            android.graphics.Path r0 = r12.f11431l
            r0.reset()
            android.graphics.Path r0 = r12.f11431l
            android.graphics.Rect r2 = r12.f11426g
            int r2 = r2.left
            int r2 = r2 + r7
            float r2 = (float) r2
            float r3 = (float) r6
            r0.moveTo(r2, r3)
            android.graphics.Path r0 = r12.f11431l
            android.graphics.Rect r2 = r12.f11426g
            int r2 = r2.left
            int r2 = r2 / r1
            int r2 = r2 + r7
            android.graphics.Rect r4 = r12.f11426g
            int r4 = r4.right
            int r4 = r4 / r1
            int r2 = r2 + r4
            float r1 = (float) r2
            float r2 = r12.f11437r
            float r2 = r3 - r2
            r0.lineTo(r1, r2)
            android.graphics.Path r0 = r12.f11431l
            android.graphics.Rect r1 = r12.f11426g
            int r1 = r1.right
            int r7 = r7 + r1
            float r1 = (float) r7
            r0.lineTo(r1, r3)
            android.graphics.Path r0 = r12.f11431l
            r0.close()
            android.graphics.Path r0 = r12.f11431l
            android.graphics.Paint r1 = r12.f11430k
            r13.drawPath(r0, r1)
            goto L_0x019a
        L_0x00e6:
            if (r0 != r1) goto L_0x0137
            float r0 = r12.f11437r
            int r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r0 >= 0) goto L_0x00f7
            float r0 = (float) r6
            float r1 = r12.f11441v
            float r0 = r0 - r1
            float r1 = r12.f11443x
            float r0 = r0 - r1
            r12.f11437r = r0
        L_0x00f7:
            float r0 = r12.f11437r
            int r1 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r1 <= 0) goto L_0x019a
            float r1 = r12.f11439t
            r2 = 1073741824(0x40000000, float:2.0)
            int r3 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r3 < 0) goto L_0x010b
            float r3 = r0 / r2
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x010e
        L_0x010b:
            float r0 = r0 / r2
            r12.f11439t = r0
        L_0x010e:
            android.graphics.drawable.GradientDrawable r0 = r12.f11427h
            int r1 = r12.f11436q
            r0.setColor(r1)
            android.graphics.drawable.GradientDrawable r0 = r12.f11427h
            float r1 = r12.f11440u
            int r1 = (int) r1
            int r1 = r1 + r7
            android.graphics.Rect r2 = r12.f11426g
            int r2 = r2.left
            int r1 = r1 + r2
            float r2 = r12.f11441v
            int r2 = (int) r2
            android.graphics.Rect r3 = r12.f11426g
            int r3 = r3.right
            int r7 = r7 + r3
            float r3 = (float) r7
            float r4 = r12.f11442w
            float r3 = r3 - r4
            int r3 = (int) r3
            float r4 = r12.f11441v
            float r5 = r12.f11437r
            float r4 = r4 + r5
            int r4 = (int) r4
            r0.setBounds(r1, r2, r3, r4)
            goto L_0x018e
        L_0x0137:
            float r0 = r12.f11437r
            int r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r0 <= 0) goto L_0x019a
            android.graphics.drawable.GradientDrawable r0 = r12.f11427h
            int r1 = r12.f11436q
            r0.setColor(r1)
            int r0 = r12.B
            if (r0 != r11) goto L_0x016d
            android.graphics.drawable.GradientDrawable r0 = r12.f11427h
            float r1 = r12.f11440u
            int r1 = (int) r1
            int r1 = r1 + r7
            android.graphics.Rect r2 = r12.f11426g
            int r2 = r2.left
            int r1 = r1 + r2
            float r2 = r12.f11437r
            int r2 = (int) r2
            int r2 = r6 - r2
            float r3 = r12.f11443x
            int r3 = (int) r3
            int r2 = r2 - r3
            android.graphics.Rect r3 = r12.f11426g
            int r3 = r3.right
            int r7 = r7 + r3
            float r3 = r12.f11442w
            int r3 = (int) r3
            int r7 = r7 - r3
            float r3 = r12.f11443x
            int r3 = (int) r3
            int r6 = r6 - r3
            r0.setBounds(r1, r2, r7, r6)
            goto L_0x018e
        L_0x016d:
            android.graphics.drawable.GradientDrawable r0 = r12.f11427h
            float r1 = r12.f11440u
            int r1 = (int) r1
            int r1 = r1 + r7
            android.graphics.Rect r2 = r12.f11426g
            int r2 = r2.left
            int r1 = r1 + r2
            float r2 = r12.f11441v
            int r2 = (int) r2
            android.graphics.Rect r3 = r12.f11426g
            int r3 = r3.right
            int r7 = r7 + r3
            float r3 = r12.f11442w
            int r3 = (int) r3
            int r7 = r7 - r3
            float r3 = r12.f11437r
            int r3 = (int) r3
            float r4 = r12.f11441v
            int r4 = (int) r4
            int r3 = r3 + r4
            r0.setBounds(r1, r2, r7, r3)
        L_0x018e:
            android.graphics.drawable.GradientDrawable r0 = r12.f11427h
            float r1 = r12.f11439t
            r0.setCornerRadius(r1)
            android.graphics.drawable.GradientDrawable r0 = r12.f11427h
            r0.draw(r13)
        L_0x019a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flyco.tablayout.CommonTabLayout.onDraw(android.graphics.Canvas):void");
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f11423d = bundle.getInt("mCurrentTab");
            parcelable = bundle.getParcelable("instanceState");
            if (this.f11423d != 0 && this.f11422c.getChildCount() > 0) {
                a(this.f11423d);
            }
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("mCurrentTab", this.f11423d);
        return bundle;
    }

    public void setCurrentTab(int i2) {
        this.f11424e = this.f11423d;
        this.f11423d = i2;
        a(i2);
        dw.a aVar = this.V;
        if (aVar != null) {
            aVar.a(i2);
        }
        if (this.f11445z) {
            c();
        } else {
            invalidate();
        }
    }

    public void setDividerColor(int i2) {
        this.F = i2;
        invalidate();
    }

    public void setDividerPadding(float f2) {
        this.H = (float) a(f2);
        invalidate();
    }

    public void setDividerWidth(float f2) {
        this.G = (float) a(f2);
        invalidate();
    }

    public void setIconGravity(int i2) {
        this.O = i2;
        a();
    }

    public void setIconHeight(float f2) {
        this.Q = (float) a(f2);
        b();
    }

    public void setIconMargin(float f2) {
        this.R = (float) a(f2);
        b();
    }

    public void setIconVisible(boolean z2) {
        this.N = z2;
        b();
    }

    public void setIconWidth(float f2) {
        this.P = (float) a(f2);
        b();
    }

    public void setIndicatorAnimDuration(long j2) {
        this.f11444y = j2;
    }

    public void setIndicatorAnimEnable(boolean z2) {
        this.f11445z = z2;
    }

    public void setIndicatorBounceEnable(boolean z2) {
        this.A = z2;
    }

    public void setIndicatorColor(int i2) {
        this.f11436q = i2;
        invalidate();
    }

    public void setIndicatorCornerRadius(float f2) {
        this.f11439t = (float) a(f2);
        invalidate();
    }

    public void setIndicatorGravity(int i2) {
        this.B = i2;
        invalidate();
    }

    public void setIndicatorHeight(float f2) {
        this.f11437r = (float) a(f2);
        invalidate();
    }

    public void setIndicatorStyle(int i2) {
        this.f11432m = i2;
        invalidate();
    }

    public void setIndicatorWidth(float f2) {
        this.f11438s = (float) a(f2);
        invalidate();
    }

    public void setOnTabSelectListener(dv.b bVar) {
        this.f11418ac = bVar;
    }

    public void setTabData(ArrayList<dv.a> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            throw new IllegalStateException("TabEntitys can not be NULL or EMPTY !");
        }
        this.f11421b.clear();
        this.f11421b.addAll(arrayList);
        a();
    }

    public void setTabPadding(float f2) {
        this.f11433n = (float) a(f2);
        b();
    }

    public void setTabSpaceEqual(boolean z2) {
        this.f11434o = z2;
        b();
    }

    public void setTabWidth(float f2) {
        this.f11435p = (float) a(f2);
        b();
    }

    public void setTextAllCaps(boolean z2) {
        this.M = z2;
        b();
    }

    public void setTextBold(int i2) {
        this.L = i2;
        b();
    }

    public void setTextSelectColor(int i2) {
        this.J = i2;
        b();
    }

    public void setTextUnselectColor(int i2) {
        this.K = i2;
        b();
    }

    public void setTextsize(float f2) {
        this.I = (float) b(f2);
        b();
    }

    public void setUnderlineColor(int i2) {
        this.C = i2;
        invalidate();
    }

    public void setUnderlineGravity(int i2) {
        this.E = i2;
        invalidate();
    }

    public void setUnderlineHeight(float f2) {
        this.D = (float) a(f2);
        invalidate();
    }
}
