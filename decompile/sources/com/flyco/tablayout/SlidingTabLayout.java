package com.flyco.tablayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
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
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.n;
import androidx.viewpager.widget.ViewPager;
import dv.b;
import java.util.ArrayList;

public class SlidingTabLayout extends HorizontalScrollView implements ViewPager.e {
    private int A;
    private boolean B;
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
    private int N;
    private int O;
    /* access modifiers changed from: private */
    public boolean P;
    private float Q;
    private Paint R;
    private SparseArray<Boolean> S;
    /* access modifiers changed from: private */
    public b T;

    /* renamed from: a  reason: collision with root package name */
    private Context f11482a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ViewPager f11483b;

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<String> f11484c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public LinearLayout f11485d;

    /* renamed from: e  reason: collision with root package name */
    private int f11486e;

    /* renamed from: f  reason: collision with root package name */
    private float f11487f;

    /* renamed from: g  reason: collision with root package name */
    private int f11488g;

    /* renamed from: h  reason: collision with root package name */
    private Rect f11489h;

    /* renamed from: i  reason: collision with root package name */
    private Rect f11490i;

    /* renamed from: j  reason: collision with root package name */
    private GradientDrawable f11491j;

    /* renamed from: k  reason: collision with root package name */
    private Paint f11492k;

    /* renamed from: l  reason: collision with root package name */
    private Paint f11493l;

    /* renamed from: m  reason: collision with root package name */
    private Paint f11494m;

    /* renamed from: n  reason: collision with root package name */
    private Path f11495n;

    /* renamed from: o  reason: collision with root package name */
    private int f11496o;

    /* renamed from: p  reason: collision with root package name */
    private float f11497p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f11498q;

    /* renamed from: r  reason: collision with root package name */
    private float f11499r;

    /* renamed from: s  reason: collision with root package name */
    private int f11500s;

    /* renamed from: t  reason: collision with root package name */
    private float f11501t;

    /* renamed from: u  reason: collision with root package name */
    private float f11502u;

    /* renamed from: v  reason: collision with root package name */
    private float f11503v;

    /* renamed from: w  reason: collision with root package name */
    private float f11504w;

    /* renamed from: x  reason: collision with root package name */
    private float f11505x;

    /* renamed from: y  reason: collision with root package name */
    private float f11506y;

    /* renamed from: z  reason: collision with root package name */
    private float f11507z;

    class a extends n {

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<Fragment> f11510b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        private String[] f11511c;

        public a(FragmentManager fragmentManager, ArrayList<Fragment> arrayList, String[] strArr) {
            super(fragmentManager);
            this.f11510b = arrayList;
            this.f11511c = strArr;
        }

        public void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
        }

        public int getCount() {
            return this.f11510b.size();
        }

        public Fragment getItem(int i2) {
            return this.f11510b.get(i2);
        }

        public int getItemPosition(Object obj) {
            return -2;
        }

        public CharSequence getPageTitle(int i2) {
            return this.f11511c[i2];
        }
    }

    public SlidingTabLayout(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f11489h = new Rect();
        this.f11490i = new Rect();
        this.f11491j = new GradientDrawable();
        this.f11492k = new Paint(1);
        this.f11493l = new Paint(1);
        this.f11494m = new Paint(1);
        this.f11495n = new Path();
        this.f11496o = 0;
        this.R = new Paint(1);
        this.S = new SparseArray<>();
        setFillViewport(true);
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.f11482a = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f11485d = linearLayout;
        addView(linearLayout);
        a(context, attributeSet);
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (!attributeValue.equals("-1") && !attributeValue.equals("-2")) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842997});
            this.O = obtainStyledAttributes.getDimensionPixelSize(0, -2);
            obtainStyledAttributes.recycle();
        }
    }

    private void a(int i2) {
        int i3 = 0;
        while (i3 < this.f11488g) {
            View childAt = this.f11485d.getChildAt(i3);
            boolean z2 = i3 == i2;
            TextView textView = (TextView) childAt.findViewById(R.id.tv_tab_title);
            if (textView != null) {
                textView.setTextColor(z2 ? this.J : this.K);
                if (this.L == 1) {
                    textView.getPaint().setFakeBoldText(z2);
                }
            }
            i3++;
        }
    }

    private void a(int i2, String str, View view) {
        TextView textView = (TextView) view.findViewById(R.id.tv_tab_title);
        if (!(textView == null || str == null)) {
            textView.setText(str);
        }
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int indexOfChild = SlidingTabLayout.this.f11485d.indexOfChild(view);
                if (indexOfChild == -1) {
                    return;
                }
                if (SlidingTabLayout.this.f11483b.getCurrentItem() != indexOfChild) {
                    if (SlidingTabLayout.this.P) {
                        SlidingTabLayout.this.f11483b.setCurrentItem(indexOfChild, false);
                    } else {
                        SlidingTabLayout.this.f11483b.setCurrentItem(indexOfChild);
                    }
                    if (SlidingTabLayout.this.T != null) {
                        SlidingTabLayout.this.T.a(indexOfChild);
                    }
                } else if (SlidingTabLayout.this.T != null) {
                    SlidingTabLayout.this.T.b(indexOfChild);
                }
            }
        });
        LinearLayout.LayoutParams layoutParams = this.f11498q ? new LinearLayout.LayoutParams(0, -1, 1.0f) : new LinearLayout.LayoutParams(-2, -1);
        if (this.f11499r > 0.0f) {
            layoutParams = new LinearLayout.LayoutParams((int) this.f11499r, -1);
        }
        this.f11485d.addView(view, i2, layoutParams);
    }

    private void a(Context context, AttributeSet attributeSet) {
        float f2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SlidingTabLayout);
        this.f11496o = obtainStyledAttributes.getInt(R.styleable.SlidingTabLayout_tl_indicator_style, 0);
        this.f11500s = obtainStyledAttributes.getColor(R.styleable.SlidingTabLayout_tl_indicator_color, Color.parseColor(this.f11496o == 2 ? "#4B6A87" : "#ffffff"));
        int i2 = R.styleable.SlidingTabLayout_tl_indicator_height;
        int i3 = this.f11496o;
        if (i3 == 1) {
            f2 = 4.0f;
        } else {
            f2 = (float) (i3 == 2 ? -1 : 2);
        }
        this.f11501t = obtainStyledAttributes.getDimension(i2, (float) a(f2));
        this.f11502u = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_indicator_width, (float) a(this.f11496o == 1 ? 10.0f : -1.0f));
        this.f11503v = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_indicator_corner_radius, (float) a(this.f11496o == 2 ? -1.0f : 0.0f));
        this.f11504w = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_indicator_margin_left, (float) a(0.0f));
        float f3 = 7.0f;
        this.f11505x = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_indicator_margin_top, (float) a(this.f11496o == 2 ? 7.0f : 0.0f));
        this.f11506y = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_indicator_margin_right, (float) a(0.0f));
        int i4 = R.styleable.SlidingTabLayout_tl_indicator_margin_bottom;
        if (this.f11496o != 2) {
            f3 = 0.0f;
        }
        this.f11507z = obtainStyledAttributes.getDimension(i4, (float) a(f3));
        this.A = obtainStyledAttributes.getInt(R.styleable.SlidingTabLayout_tl_indicator_gravity, 80);
        this.B = obtainStyledAttributes.getBoolean(R.styleable.SlidingTabLayout_tl_indicator_width_equal_title, false);
        this.C = obtainStyledAttributes.getColor(R.styleable.SlidingTabLayout_tl_underline_color, Color.parseColor("#ffffff"));
        this.D = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_underline_height, (float) a(0.0f));
        this.E = obtainStyledAttributes.getInt(R.styleable.SlidingTabLayout_tl_underline_gravity, 80);
        this.F = obtainStyledAttributes.getColor(R.styleable.SlidingTabLayout_tl_divider_color, Color.parseColor("#ffffff"));
        this.G = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_divider_width, (float) a(0.0f));
        this.H = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_divider_padding, (float) a(12.0f));
        this.I = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_textsize, (float) b(14.0f));
        this.J = obtainStyledAttributes.getColor(R.styleable.SlidingTabLayout_tl_textSelectColor, Color.parseColor("#ffffff"));
        this.K = obtainStyledAttributes.getColor(R.styleable.SlidingTabLayout_tl_textUnselectColor, Color.parseColor("#AAffffff"));
        this.L = obtainStyledAttributes.getInt(R.styleable.SlidingTabLayout_tl_textBold, 0);
        this.M = obtainStyledAttributes.getBoolean(R.styleable.SlidingTabLayout_tl_textAllCaps, false);
        this.f11498q = obtainStyledAttributes.getBoolean(R.styleable.SlidingTabLayout_tl_tab_space_equal, false);
        this.f11499r = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_tab_width, (float) a(-1.0f));
        this.f11497p = obtainStyledAttributes.getDimension(R.styleable.SlidingTabLayout_tl_tab_padding, (float) ((this.f11498q || this.f11499r > 0.0f) ? a(0.0f) : a(20.0f)));
        obtainStyledAttributes.recycle();
    }

    private void b() {
        int i2 = 0;
        while (i2 < this.f11488g) {
            TextView textView = (TextView) this.f11485d.getChildAt(i2).findViewById(R.id.tv_tab_title);
            if (textView != null) {
                textView.setTextColor(i2 == this.f11486e ? this.J : this.K);
                textView.setTextSize(0, this.I);
                float f2 = this.f11497p;
                textView.setPadding((int) f2, 0, (int) f2, 0);
                if (this.M) {
                    textView.setText(textView.getText().toString().toUpperCase());
                }
                int i3 = this.L;
                if (i3 == 2) {
                    textView.getPaint().setFakeBoldText(true);
                } else if (i3 == 0) {
                    textView.getPaint().setFakeBoldText(false);
                }
            }
            i2++;
        }
    }

    private void c() {
        if (this.f11488g > 0) {
            int width = (int) (this.f11487f * ((float) this.f11485d.getChildAt(this.f11486e).getWidth()));
            int left = this.f11485d.getChildAt(this.f11486e).getLeft() + width;
            if (this.f11486e > 0 || width > 0) {
                d();
                left = (left - ((getWidth() / 2) - getPaddingLeft())) + ((this.f11490i.right - this.f11490i.left) / 2);
            }
            if (left != this.N) {
                this.N = left;
                scrollTo(left, 0);
            }
        }
    }

    private void d() {
        View childAt = this.f11485d.getChildAt(this.f11486e);
        float left = (float) childAt.getLeft();
        float right = (float) childAt.getRight();
        if (this.f11496o == 0 && this.B) {
            this.R.setTextSize(this.I);
            this.Q = ((right - left) - this.R.measureText(((TextView) childAt.findViewById(R.id.tv_tab_title)).getText().toString())) / 2.0f;
        }
        int i2 = this.f11486e;
        if (i2 < this.f11488g - 1) {
            View childAt2 = this.f11485d.getChildAt(i2 + 1);
            float left2 = (float) childAt2.getLeft();
            float right2 = (float) childAt2.getRight();
            float f2 = this.f11487f;
            left += (left2 - left) * f2;
            right += f2 * (right2 - right);
            if (this.f11496o == 0 && this.B) {
                this.R.setTextSize(this.I);
                float f3 = this.Q;
                this.Q = f3 + (this.f11487f * ((((right2 - left2) - this.R.measureText(((TextView) childAt2.findViewById(R.id.tv_tab_title)).getText().toString())) / 2.0f) - f3));
            }
        }
        int i3 = (int) left;
        this.f11489h.left = i3;
        int i4 = (int) right;
        this.f11489h.right = i4;
        if (this.f11496o == 0 && this.B) {
            this.f11489h.left = (int) ((left + this.Q) - 1.0f);
            this.f11489h.right = (int) ((right - this.Q) - 1.0f);
        }
        this.f11490i.left = i3;
        this.f11490i.right = i4;
        if (this.f11502u >= 0.0f) {
            float left3 = ((float) childAt.getLeft()) + ((((float) childAt.getWidth()) - this.f11502u) / 2.0f);
            int i5 = this.f11486e;
            if (i5 < this.f11488g - 1) {
                left3 += this.f11487f * ((float) ((childAt.getWidth() / 2) + (this.f11485d.getChildAt(i5 + 1).getWidth() / 2)));
            }
            this.f11489h.left = (int) left3;
            Rect rect = this.f11489h;
            rect.right = (int) (((float) rect.left) + this.f11502u);
        }
    }

    /* access modifiers changed from: protected */
    public int a(float f2) {
        return (int) ((f2 * this.f11482a.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void a() {
        this.f11485d.removeAllViews();
        ArrayList<String> arrayList = this.f11484c;
        this.f11488g = arrayList == null ? this.f11483b.getAdapter().getCount() : arrayList.size();
        for (int i2 = 0; i2 < this.f11488g; i2++) {
            View inflate = View.inflate(this.f11482a, R.layout.layout_tab, (ViewGroup) null);
            ArrayList<String> arrayList2 = this.f11484c;
            a(i2, (arrayList2 == null ? this.f11483b.getAdapter().getPageTitle(i2) : arrayList2.get(i2)).toString(), inflate);
        }
        b();
    }

    public void a(ViewPager viewPager, String[] strArr, FragmentActivity fragmentActivity, ArrayList<Fragment> arrayList) {
        if (viewPager == null) {
            throw new IllegalStateException("ViewPager can not be NULL !");
        } else if (strArr == null || strArr.length == 0) {
            throw new IllegalStateException("Titles can not be EMPTY !");
        } else {
            this.f11483b = viewPager;
            viewPager.setAdapter(new a(fragmentActivity.getSupportFragmentManager(), arrayList, strArr));
            this.f11483b.removeOnPageChangeListener(this);
            this.f11483b.addOnPageChangeListener(this);
            a();
        }
    }

    /* access modifiers changed from: protected */
    public int b(float f2) {
        return (int) ((f2 * this.f11482a.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public int getCurrentTab() {
        return this.f11486e;
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

    public int getIndicatorColor() {
        return this.f11500s;
    }

    public float getIndicatorCornerRadius() {
        return this.f11503v;
    }

    public float getIndicatorHeight() {
        return this.f11501t;
    }

    public float getIndicatorMarginBottom() {
        return this.f11507z;
    }

    public float getIndicatorMarginLeft() {
        return this.f11504w;
    }

    public float getIndicatorMarginRight() {
        return this.f11506y;
    }

    public float getIndicatorMarginTop() {
        return this.f11505x;
    }

    public int getIndicatorStyle() {
        return this.f11496o;
    }

    public float getIndicatorWidth() {
        return this.f11502u;
    }

    public int getTabCount() {
        return this.f11488g;
    }

    public float getTabPadding() {
        return this.f11497p;
    }

    public float getTabWidth() {
        return this.f11499r;
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

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        super.onDraw(canvas);
        if (!isInEditMode() && this.f11488g > 0) {
            int height = getHeight();
            int paddingLeft = getPaddingLeft();
            float f5 = this.G;
            if (f5 > 0.0f) {
                this.f11493l.setStrokeWidth(f5);
                this.f11493l.setColor(this.F);
                for (int i2 = 0; i2 < this.f11488g - 1; i2++) {
                    View childAt = this.f11485d.getChildAt(i2);
                    canvas.drawLine((float) (childAt.getRight() + paddingLeft), this.H, (float) (childAt.getRight() + paddingLeft), ((float) height) - this.H, this.f11493l);
                }
            }
            if (this.D > 0.0f) {
                this.f11492k.setColor(this.C);
                float f6 = (float) paddingLeft;
                if (this.E == 80) {
                    f2 = (float) height;
                    f4 = f2 - this.D;
                    f3 = (float) (this.f11485d.getWidth() + paddingLeft);
                } else {
                    f4 = 0.0f;
                    f3 = (float) (this.f11485d.getWidth() + paddingLeft);
                    f2 = this.D;
                }
                canvas.drawRect(f6, f4, f3, f2, this.f11492k);
            }
            d();
            int i3 = this.f11496o;
            if (i3 != 1) {
                if (i3 == 2) {
                    if (this.f11501t < 0.0f) {
                        this.f11501t = (((float) height) - this.f11505x) - this.f11507z;
                    }
                    float f7 = this.f11501t;
                    if (f7 > 0.0f) {
                        float f8 = this.f11503v;
                        if (f8 < 0.0f || f8 > f7 / 2.0f) {
                            this.f11503v = f7 / 2.0f;
                        }
                        this.f11491j.setColor(this.f11500s);
                        this.f11491j.setBounds(((int) this.f11504w) + paddingLeft + this.f11489h.left, (int) this.f11505x, (int) (((float) (paddingLeft + this.f11489h.right)) - this.f11506y), (int) (this.f11505x + this.f11501t));
                    } else {
                        return;
                    }
                } else if (this.f11501t > 0.0f) {
                    this.f11491j.setColor(this.f11500s);
                    if (this.A == 80) {
                        this.f11491j.setBounds(((int) this.f11504w) + paddingLeft + this.f11489h.left, (height - ((int) this.f11501t)) - ((int) this.f11507z), (paddingLeft + this.f11489h.right) - ((int) this.f11506y), height - ((int) this.f11507z));
                    } else {
                        this.f11491j.setBounds(((int) this.f11504w) + paddingLeft + this.f11489h.left, (int) this.f11505x, (paddingLeft + this.f11489h.right) - ((int) this.f11506y), ((int) this.f11501t) + ((int) this.f11505x));
                    }
                } else {
                    return;
                }
                this.f11491j.setCornerRadius(this.f11503v);
                this.f11491j.draw(canvas);
            } else if (this.f11501t > 0.0f) {
                this.f11494m.setColor(this.f11500s);
                this.f11495n.reset();
                float f9 = (float) height;
                this.f11495n.moveTo((float) (this.f11489h.left + paddingLeft), f9);
                this.f11495n.lineTo((float) ((this.f11489h.left / 2) + paddingLeft + (this.f11489h.right / 2)), f9 - this.f11501t);
                this.f11495n.lineTo((float) (paddingLeft + this.f11489h.right), f9);
                this.f11495n.close();
                canvas.drawPath(this.f11495n, this.f11494m);
            }
        }
    }

    public void onPageScrollStateChanged(int i2) {
    }

    public void onPageScrolled(int i2, float f2, int i3) {
        this.f11486e = i2;
        this.f11487f = f2;
        c();
        invalidate();
    }

    public void onPageSelected(int i2) {
        a(i2);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f11486e = bundle.getInt("mCurrentTab");
            parcelable = bundle.getParcelable("instanceState");
            if (this.f11486e != 0 && this.f11485d.getChildCount() > 0) {
                a(this.f11486e);
                c();
            }
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("mCurrentTab", this.f11486e);
        return bundle;
    }

    public void setCurrentTab(int i2) {
        this.f11486e = i2;
        this.f11483b.setCurrentItem(i2);
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

    public void setIndicatorColor(int i2) {
        this.f11500s = i2;
        invalidate();
    }

    public void setIndicatorCornerRadius(float f2) {
        this.f11503v = (float) a(f2);
        invalidate();
    }

    public void setIndicatorGravity(int i2) {
        this.A = i2;
        invalidate();
    }

    public void setIndicatorHeight(float f2) {
        this.f11501t = (float) a(f2);
        invalidate();
    }

    public void setIndicatorStyle(int i2) {
        this.f11496o = i2;
        invalidate();
    }

    public void setIndicatorWidth(float f2) {
        this.f11502u = (float) a(f2);
        invalidate();
    }

    public void setIndicatorWidthEqualTitle(boolean z2) {
        this.B = z2;
        invalidate();
    }

    public void setOnTabSelectListener(b bVar) {
        this.T = bVar;
    }

    public void setSnapOnTabClick(boolean z2) {
        this.P = z2;
    }

    public void setTabPadding(float f2) {
        this.f11497p = (float) a(f2);
        b();
    }

    public void setTabSpaceEqual(boolean z2) {
        this.f11498q = z2;
        b();
    }

    public void setTabWidth(float f2) {
        this.f11499r = (float) a(f2);
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

    public void setViewPager(ViewPager viewPager) {
        if (viewPager == null || viewPager.getAdapter() == null) {
            throw new IllegalStateException("ViewPager or ViewPager adapter can not be NULL !");
        }
        this.f11483b = viewPager;
        viewPager.removeOnPageChangeListener(this);
        this.f11483b.addOnPageChangeListener(this);
        a();
    }
}
