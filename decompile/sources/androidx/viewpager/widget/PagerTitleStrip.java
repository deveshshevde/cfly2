package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.method.SingleLineTransformationMethod;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.core.widget.j;
import androidx.viewpager.widget.ViewPager;
import java.lang.ref.WeakReference;
import java.util.Locale;

@ViewPager.a
public class PagerTitleStrip extends ViewGroup {

    /* renamed from: n  reason: collision with root package name */
    private static final int[] f4926n = {16842804, 16842901, 16842904, 16842927};

    /* renamed from: o  reason: collision with root package name */
    private static final int[] f4927o = {16843660};

    /* renamed from: a  reason: collision with root package name */
    ViewPager f4928a;

    /* renamed from: b  reason: collision with root package name */
    TextView f4929b;

    /* renamed from: c  reason: collision with root package name */
    TextView f4930c;

    /* renamed from: d  reason: collision with root package name */
    TextView f4931d;

    /* renamed from: e  reason: collision with root package name */
    float f4932e;

    /* renamed from: f  reason: collision with root package name */
    int f4933f;

    /* renamed from: g  reason: collision with root package name */
    private int f4934g;

    /* renamed from: h  reason: collision with root package name */
    private int f4935h;

    /* renamed from: i  reason: collision with root package name */
    private int f4936i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4937j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4938k;

    /* renamed from: l  reason: collision with root package name */
    private final a f4939l;

    /* renamed from: m  reason: collision with root package name */
    private WeakReference<a> f4940m;

    /* renamed from: p  reason: collision with root package name */
    private int f4941p;

    private class a extends DataSetObserver implements ViewPager.d, ViewPager.e {

        /* renamed from: b  reason: collision with root package name */
        private int f4943b;

        a() {
        }

        public void a(ViewPager viewPager, a aVar, a aVar2) {
            PagerTitleStrip.this.a(aVar, aVar2);
        }

        public void onChanged() {
            PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
            pagerTitleStrip.a(pagerTitleStrip.f4928a.getCurrentItem(), PagerTitleStrip.this.f4928a.getAdapter());
            float f2 = 0.0f;
            if (PagerTitleStrip.this.f4932e >= 0.0f) {
                f2 = PagerTitleStrip.this.f4932e;
            }
            PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
            pagerTitleStrip2.a(pagerTitleStrip2.f4928a.getCurrentItem(), f2, true);
        }

        public void onPageScrollStateChanged(int i2) {
            this.f4943b = i2;
        }

        public void onPageScrolled(int i2, float f2, int i3) {
            if (f2 > 0.5f) {
                i2++;
            }
            PagerTitleStrip.this.a(i2, f2, false);
        }

        public void onPageSelected(int i2) {
            if (this.f4943b == 0) {
                PagerTitleStrip pagerTitleStrip = PagerTitleStrip.this;
                pagerTitleStrip.a(pagerTitleStrip.f4928a.getCurrentItem(), PagerTitleStrip.this.f4928a.getAdapter());
                float f2 = 0.0f;
                if (PagerTitleStrip.this.f4932e >= 0.0f) {
                    f2 = PagerTitleStrip.this.f4932e;
                }
                PagerTitleStrip pagerTitleStrip2 = PagerTitleStrip.this;
                pagerTitleStrip2.a(pagerTitleStrip2.f4928a.getCurrentItem(), f2, true);
            }
        }
    }

    private static class b extends SingleLineTransformationMethod {

        /* renamed from: a  reason: collision with root package name */
        private Locale f4944a;

        b(Context context) {
            this.f4944a = context.getResources().getConfiguration().locale;
        }

        public CharSequence getTransformation(CharSequence charSequence, View view) {
            CharSequence transformation = super.getTransformation(charSequence, view);
            if (transformation != null) {
                return transformation.toString().toUpperCase(this.f4944a);
            }
            return null;
        }
    }

    public PagerTitleStrip(Context context) {
        this(context, (AttributeSet) null);
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4934g = -1;
        this.f4932e = -1.0f;
        this.f4939l = new a();
        TextView textView = new TextView(context);
        this.f4929b = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f4930c = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f4931d = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f4926n);
        boolean z2 = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            j.a(this.f4929b, resourceId);
            j.a(this.f4930c, resourceId);
            j.a(this.f4931d, resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            a(0, (float) dimensionPixelSize);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            this.f4929b.setTextColor(color);
            this.f4930c.setTextColor(color);
            this.f4931d.setTextColor(color);
        }
        this.f4936i = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.f4933f = this.f4930c.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        this.f4929b.setEllipsize(TextUtils.TruncateAt.END);
        this.f4930c.setEllipsize(TextUtils.TruncateAt.END);
        this.f4931d.setEllipsize(TextUtils.TruncateAt.END);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f4927o);
            z2 = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        TextView textView4 = this.f4929b;
        if (z2) {
            setSingleLineAllCaps(textView4);
            setSingleLineAllCaps(this.f4930c);
            setSingleLineAllCaps(this.f4931d);
        } else {
            textView4.setSingleLine();
            this.f4930c.setSingleLine();
            this.f4931d.setSingleLine();
        }
        this.f4935h = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        textView.setTransformationMethod(new b(textView.getContext()));
    }

    public void a(int i2, float f2) {
        this.f4929b.setTextSize(i2, f2);
        this.f4930c.setTextSize(i2, f2);
        this.f4931d.setTextSize(i2, f2);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, float f2, boolean z2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = i2;
        float f3 = f2;
        if (i7 != this.f4934g) {
            a(i7, this.f4928a.getAdapter());
        } else if (!z2 && f3 == this.f4932e) {
            return;
        }
        this.f4938k = true;
        int measuredWidth = this.f4929b.getMeasuredWidth();
        int measuredWidth2 = this.f4930c.getMeasuredWidth();
        int measuredWidth3 = this.f4931d.getMeasuredWidth();
        int i8 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i9 = paddingRight + i8;
        int i10 = (width - (paddingLeft + i8)) - i9;
        float f4 = 0.5f + f3;
        if (f4 > 1.0f) {
            f4 -= 1.0f;
        }
        int i11 = ((width - i9) - ((int) (((float) i10) * f4))) - i8;
        int i12 = measuredWidth2 + i11;
        int baseline = this.f4929b.getBaseline();
        int baseline2 = this.f4930c.getBaseline();
        int baseline3 = this.f4931d.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i13 = max - baseline;
        int i14 = max - baseline2;
        int i15 = max - baseline3;
        int i16 = measuredWidth3;
        int max2 = Math.max(Math.max(this.f4929b.getMeasuredHeight() + i13, this.f4930c.getMeasuredHeight() + i14), this.f4931d.getMeasuredHeight() + i15);
        int i17 = this.f4936i & 112;
        if (i17 == 16) {
            i6 = (((height - paddingTop) - paddingBottom) - max2) / 2;
        } else if (i17 != 80) {
            i5 = i13 + paddingTop;
            i3 = i14 + paddingTop;
            i4 = paddingTop + i15;
            TextView textView = this.f4930c;
            textView.layout(i11, i3, i12, textView.getMeasuredHeight() + i3);
            int min = Math.min(paddingLeft, (i11 - this.f4935h) - measuredWidth);
            TextView textView2 = this.f4929b;
            textView2.layout(min, i5, measuredWidth + min, textView2.getMeasuredHeight() + i5);
            int max3 = Math.max((width - paddingRight) - i16, i12 + this.f4935h);
            TextView textView3 = this.f4931d;
            textView3.layout(max3, i4, max3 + i16, textView3.getMeasuredHeight() + i4);
            this.f4932e = f2;
            this.f4938k = false;
        } else {
            i6 = (height - paddingBottom) - max2;
        }
        i5 = i13 + i6;
        i3 = i14 + i6;
        i4 = i6 + i15;
        TextView textView4 = this.f4930c;
        textView4.layout(i11, i3, i12, textView4.getMeasuredHeight() + i3);
        int min2 = Math.min(paddingLeft, (i11 - this.f4935h) - measuredWidth);
        TextView textView22 = this.f4929b;
        textView22.layout(min2, i5, measuredWidth + min2, textView22.getMeasuredHeight() + i5);
        int max32 = Math.max((width - paddingRight) - i16, i12 + this.f4935h);
        TextView textView32 = this.f4931d;
        textView32.layout(max32, i4, max32 + i16, textView32.getMeasuredHeight() + i4);
        this.f4932e = f2;
        this.f4938k = false;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, a aVar) {
        int count = aVar != null ? aVar.getCount() : 0;
        this.f4937j = true;
        CharSequence charSequence = null;
        this.f4929b.setText((i2 < 1 || aVar == null) ? null : aVar.getPageTitle(i2 - 1));
        this.f4930c.setText((aVar == null || i2 >= count) ? null : aVar.getPageTitle(i2));
        int i3 = i2 + 1;
        if (i3 < count && aVar != null) {
            charSequence = aVar.getPageTitle(i3);
        }
        this.f4931d.setText(charSequence);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((float) ((getWidth() - getPaddingLeft()) - getPaddingRight())) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        this.f4929b.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f4930c.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f4931d.measure(makeMeasureSpec, makeMeasureSpec2);
        this.f4934g = i2;
        if (!this.f4938k) {
            a(i2, this.f4932e, false);
        }
        this.f4937j = false;
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar, a aVar2) {
        if (aVar != null) {
            aVar.unregisterDataSetObserver(this.f4939l);
            this.f4940m = null;
        }
        if (aVar2 != null) {
            aVar2.registerDataSetObserver(this.f4939l);
            this.f4940m = new WeakReference<>(aVar2);
        }
        ViewPager viewPager = this.f4928a;
        if (viewPager != null) {
            this.f4934g = -1;
            this.f4932e = -1.0f;
            a(viewPager.getCurrentItem(), aVar2);
            requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.f4935h;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof ViewPager) {
            ViewPager viewPager = (ViewPager) parent;
            a adapter = viewPager.getAdapter();
            viewPager.setInternalPageChangeListener(this.f4939l);
            viewPager.addOnAdapterChangeListener(this.f4939l);
            this.f4928a = viewPager;
            WeakReference<a> weakReference = this.f4940m;
            a(weakReference != null ? (a) weakReference.get() : null, adapter);
            return;
        }
        throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f4928a;
        if (viewPager != null) {
            a(viewPager.getAdapter(), (a) null);
            this.f4928a.setInternalPageChangeListener((ViewPager.e) null);
            this.f4928a.removeOnAdapterChangeListener(this.f4939l);
            this.f4928a = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        if (this.f4928a != null) {
            float f2 = this.f4932e;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            a(this.f4934g, f2, true);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        if (View.MeasureSpec.getMode(i2) == 1073741824) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int childMeasureSpec = getChildMeasureSpec(i3, paddingTop, -2);
            int size = View.MeasureSpec.getSize(i2);
            int childMeasureSpec2 = getChildMeasureSpec(i2, (int) (((float) size) * 0.2f), -2);
            this.f4929b.measure(childMeasureSpec2, childMeasureSpec);
            this.f4930c.measure(childMeasureSpec2, childMeasureSpec);
            this.f4931d.measure(childMeasureSpec2, childMeasureSpec);
            if (View.MeasureSpec.getMode(i3) == 1073741824) {
                i4 = View.MeasureSpec.getSize(i3);
            } else {
                i4 = Math.max(getMinHeight(), this.f4930c.getMeasuredHeight() + paddingTop);
            }
            setMeasuredDimension(size, View.resolveSizeAndState(i4, i3, this.f4930c.getMeasuredState() << 16));
            return;
        }
        throw new IllegalStateException("Must measure with an exact width");
    }

    public void requestLayout() {
        if (!this.f4937j) {
            super.requestLayout();
        }
    }

    public void setGravity(int i2) {
        this.f4936i = i2;
        requestLayout();
    }

    public void setNonPrimaryAlpha(float f2) {
        int i2 = ((int) (f2 * 255.0f)) & 255;
        this.f4941p = i2;
        int i3 = (i2 << 24) | (this.f4933f & 16777215);
        this.f4929b.setTextColor(i3);
        this.f4931d.setTextColor(i3);
    }

    public void setTextColor(int i2) {
        this.f4933f = i2;
        this.f4930c.setTextColor(i2);
        int i3 = (this.f4941p << 24) | (this.f4933f & 16777215);
        this.f4929b.setTextColor(i3);
        this.f4931d.setTextColor(i3);
    }

    public void setTextSpacing(int i2) {
        this.f4935h = i2;
        requestLayout();
    }
}
