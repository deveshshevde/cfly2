package com.xeagle.android.widgets.viewPager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.blankj.utilcode.constant.MemoryConstants;
import com.cfly.uav_pro.R;

public class TabPageIndicator extends HorizontalScrollView implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final CharSequence f26091a = "";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Runnable f26092b;

    /* renamed from: c  reason: collision with root package name */
    private final View.OnClickListener f26093c;

    /* renamed from: d  reason: collision with root package name */
    private final LinearLayout f26094d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ViewPager f26095e;

    /* renamed from: f  reason: collision with root package name */
    private ViewPager.e f26096f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f26097g;

    /* renamed from: h  reason: collision with root package name */
    private int f26098h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public a f26099i;

    public interface a {
        void a(int i2);
    }

    private class b extends TextView {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f26104b;

        public b(Context context) {
            super(context, (AttributeSet) null, R.attr.vpiTabPageIndicatorStyle);
        }

        public int a() {
            return this.f26104b;
        }

        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (TabPageIndicator.this.f26097g > 0 && getMeasuredWidth() > TabPageIndicator.this.f26097g) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(TabPageIndicator.this.f26097g, MemoryConstants.GB), i3);
            }
        }
    }

    public TabPageIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public TabPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f26093c = new View.OnClickListener() {
            public void onClick(View view) {
                int currentItem = TabPageIndicator.this.f26095e.getCurrentItem();
                int a2 = ((b) view).a();
                TabPageIndicator.this.f26095e.setCurrentItem(a2);
                if (currentItem == a2 && TabPageIndicator.this.f26099i != null) {
                    TabPageIndicator.this.f26099i.a(a2);
                }
            }
        };
        setHorizontalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f26094d = linearLayout;
        addView(linearLayout, new ViewGroup.LayoutParams(-2, -1));
    }

    private void a(int i2) {
        final View childAt = this.f26094d.getChildAt(i2);
        Runnable runnable = this.f26092b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        AnonymousClass2 r0 = new Runnable() {
            public void run() {
                TabPageIndicator.this.smoothScrollTo(childAt.getLeft() - ((TabPageIndicator.this.getWidth() - childAt.getWidth()) / 2), 0);
                Runnable unused = TabPageIndicator.this.f26092b = null;
            }
        };
        this.f26092b = r0;
        post(r0);
    }

    private void a(CharSequence charSequence, int i2) {
        b bVar = new b(getContext());
        int unused = bVar.f26104b = i2;
        bVar.setFocusable(true);
        bVar.setOnClickListener(this.f26093c);
        bVar.setText(charSequence);
        this.f26094d.addView(bVar, new LinearLayout.LayoutParams(0, -1, 1.0f));
    }

    public void a() {
        this.f26094d.removeAllViews();
        androidx.viewpager.widget.a adapter = this.f26095e.getAdapter();
        int count = adapter.getCount();
        for (int i2 = 0; i2 < count; i2++) {
            CharSequence pageTitle = adapter.getPageTitle(i2);
            if (pageTitle == null) {
                pageTitle = f26091a;
            }
            a(pageTitle, i2);
        }
        if (this.f26098h > count) {
            this.f26098h = count - 1;
        }
        setCurrentItem(this.f26098h);
        requestLayout();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f26092b;
        if (runnable != null) {
            post(runnable);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f26092b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        int mode = View.MeasureSpec.getMode(i2);
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.f26094d.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            i4 = -1;
        } else if (childCount > 2) {
            i4 = (int) (((float) View.MeasureSpec.getSize(i2)) * 0.4f);
        } else {
            this.f26097g = View.MeasureSpec.getSize(i2) / 2;
            int measuredWidth = getMeasuredWidth();
            super.onMeasure(i2, i3);
            int measuredWidth2 = getMeasuredWidth();
            if (z2 && measuredWidth != measuredWidth2) {
                setCurrentItem(this.f26098h);
                return;
            }
        }
        this.f26097g = i4;
        int measuredWidth3 = getMeasuredWidth();
        super.onMeasure(i2, i3);
        int measuredWidth22 = getMeasuredWidth();
        if (z2) {
        }
    }

    public void onPageScrollStateChanged(int i2) {
        ViewPager.e eVar = this.f26096f;
        if (eVar != null) {
            eVar.onPageScrollStateChanged(i2);
        }
    }

    public void onPageScrolled(int i2, float f2, int i3) {
        ViewPager.e eVar = this.f26096f;
        if (eVar != null) {
            eVar.onPageScrolled(i2, f2, i3);
        }
    }

    public void onPageSelected(int i2) {
        setCurrentItem(i2);
        ViewPager.e eVar = this.f26096f;
        if (eVar != null) {
            eVar.onPageSelected(i2);
        }
    }

    public void setCurrentItem(int i2) {
        ViewPager viewPager = this.f26095e;
        if (viewPager != null) {
            this.f26098h = i2;
            viewPager.setCurrentItem(i2);
            int childCount = this.f26094d.getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.f26094d.getChildAt(i3);
                boolean z2 = i3 == i2;
                childAt.setSelected(z2);
                if (z2) {
                    a(i2);
                }
                i3++;
            }
            return;
        }
        throw new IllegalStateException("ViewPager has not been bound.");
    }

    public void setOnPageChangeListener(ViewPager.e eVar) {
        this.f26096f = eVar;
    }

    public void setOnTabReselectedListener(a aVar) {
        this.f26099i = aVar;
    }

    public void setViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.f26095e;
        if (viewPager2 != viewPager) {
            if (viewPager2 != null) {
                viewPager2.setOnPageChangeListener((ViewPager.e) null);
            }
            if (viewPager.getAdapter() != null) {
                this.f26095e = viewPager;
                viewPager.setOnPageChangeListener(this);
                a();
                return;
            }
            throw new IllegalStateException("ViewPager does not have adapter instance.");
        }
    }
}
