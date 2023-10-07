package com.xeagle.android.camera.widgets;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.blankj.utilcode.constant.MemoryConstants;
import com.cfly.uav_pro.R;

public class TabPageIndicator extends HorizontalScrollView implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final CharSequence f22404a = "";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Runnable f22405b;

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayout f22406c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ViewPager f22407d;

    /* renamed from: e  reason: collision with root package name */
    private ViewPager.e f22408e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f22409f;

    /* renamed from: g  reason: collision with root package name */
    private int f22410g;

    /* renamed from: h  reason: collision with root package name */
    private WindowManager f22411h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public a f22412i;

    /* renamed from: j  reason: collision with root package name */
    private final View.OnClickListener f22413j;

    public interface a {
        void a(int i2);
    }

    private class b extends TextView {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f22418b;

        public b(Context context) {
            super(context, (AttributeSet) null, R.attr.vpiTabPageIndicatorStyle);
        }

        public int a() {
            return this.f22418b;
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (TabPageIndicator.this.f22409f > 0 && getMeasuredWidth() > TabPageIndicator.this.f22409f) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(TabPageIndicator.this.f22409f, MemoryConstants.GB), i3);
            }
        }
    }

    public TabPageIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public TabPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f22413j = new View.OnClickListener() {
            public void onClick(View view) {
                int currentItem = TabPageIndicator.this.f22407d.getCurrentItem();
                int a2 = ((b) view).a();
                TabPageIndicator.this.f22407d.setCurrentItem(a2);
                if (currentItem == a2 && TabPageIndicator.this.f22412i != null) {
                    TabPageIndicator.this.f22412i.a(a2);
                }
            }
        };
        setHorizontalScrollBarEnabled(false);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f22406c = linearLayout;
        linearLayout.setGravity(17);
        this.f22411h = (WindowManager) context.getSystemService("window");
        addView(linearLayout, new ViewGroup.LayoutParams(-1, -1));
    }

    private void a(int i2) {
        final View childAt = this.f22406c.getChildAt(i2);
        Runnable runnable = this.f22405b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        AnonymousClass2 r0 = new Runnable() {
            public void run() {
                TabPageIndicator.this.smoothScrollTo((childAt.getLeft() - TabPageIndicator.this.getWidth()) - (childAt.getWidth() / 2), 0);
                Runnable unused = TabPageIndicator.this.f22405b = null;
            }
        };
        this.f22405b = r0;
        post(r0);
    }

    private void a(CharSequence charSequence, int i2) {
        b bVar = new b(getContext());
        int unused = bVar.f22418b = i2;
        bVar.setFocusable(true);
        bVar.setOnClickListener(this.f22413j);
        bVar.setTextSize(20.0f);
        int width = this.f22411h.getDefaultDisplay().getWidth();
        bVar.setHeight((int) ((getResources().getDisplayMetrics().density * 42.0f) + 0.5f));
        bVar.setWidth(width / 3);
        bVar.setText(charSequence);
        bVar.setGravity(17);
        this.f22406c.addView(bVar, new LinearLayout.LayoutParams(0, -1, 1.0f));
    }

    public void a() {
        this.f22406c.removeAllViews();
        androidx.viewpager.widget.a adapter = this.f22407d.getAdapter();
        int count = adapter.getCount();
        for (int i2 = 0; i2 < count; i2++) {
            CharSequence pageTitle = adapter.getPageTitle(i2);
            if (pageTitle == null) {
                pageTitle = f22404a;
            }
            a(pageTitle, i2);
        }
        if (this.f22410g > count) {
            this.f22410g = count - 1;
        }
        setCurrentItem(this.f22410g);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f22405b;
        if (runnable != null) {
            post(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f22405b;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int i4;
        int mode = View.MeasureSpec.getMode(i2);
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.f22406c.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            i4 = -1;
        } else if (childCount > 2) {
            i4 = (int) (((float) View.MeasureSpec.getSize(i2)) * 0.4f);
        } else {
            this.f22409f = View.MeasureSpec.getSize(i2) / 2;
            int measuredWidth = getMeasuredWidth();
            super.onMeasure(i2, i3);
            int measuredWidth2 = getMeasuredWidth();
            if (z2 && measuredWidth != measuredWidth2) {
                setCurrentItem(this.f22410g);
                return;
            }
        }
        this.f22409f = i4;
        int measuredWidth3 = getMeasuredWidth();
        super.onMeasure(i2, i3);
        int measuredWidth22 = getMeasuredWidth();
        if (z2) {
        }
    }

    public void onPageScrollStateChanged(int i2) {
        ViewPager.e eVar = this.f22408e;
        if (eVar != null) {
            eVar.onPageScrollStateChanged(i2);
        }
    }

    public void onPageScrolled(int i2, float f2, int i3) {
        ViewPager.e eVar = this.f22408e;
        if (eVar != null) {
            eVar.onPageScrolled(i2, f2, i3);
        }
    }

    public void onPageSelected(int i2) {
        setCurrentItem(i2);
        ViewPager.e eVar = this.f22408e;
        if (eVar != null) {
            eVar.onPageSelected(i2);
        }
    }

    public void setCurrentItem(int i2) {
        int i3;
        ViewPager viewPager = this.f22407d;
        if (viewPager != null) {
            this.f22410g = i2;
            viewPager.setCurrentItem(i2);
            int childCount = this.f22406c.getChildCount();
            int i4 = 0;
            while (i4 < childCount) {
                TextView textView = (TextView) this.f22406c.getChildAt(i4);
                boolean z2 = i4 == i2;
                textView.setSelected(z2);
                if (z2) {
                    a(i2);
                    textView.setTextColor(Color.parseColor("#FE137FF2"));
                    if (i4 == 0) {
                        i3 = R.drawable.tab_left_isselect;
                    } else {
                        if (i4 == childCount - 1) {
                            i3 = R.drawable.tab_right_isselect;
                        }
                        textView.setBackgroundResource(R.drawable.expandlist_middle_bg);
                        i4++;
                    }
                } else {
                    textView.setTextColor(-1);
                    if (i4 == 0) {
                        i3 = R.drawable.tab_left_select;
                    } else {
                        if (i4 == childCount - 1) {
                            i3 = R.drawable.tab_right_select;
                        }
                        textView.setBackgroundResource(R.drawable.expandlist_middle_bg);
                        i4++;
                    }
                }
                textView.setBackgroundResource(i3);
                i4++;
            }
            return;
        }
        throw new IllegalStateException("ViewPager has not been bond.");
    }

    public void setOnPageChangeListener(ViewPager.e eVar) {
        this.f22408e = eVar;
    }

    public void setOnTabReselectedListener(a aVar) {
        this.f22412i = aVar;
    }

    public void setViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.f22407d;
        if (viewPager2 != viewPager) {
            if (viewPager2 != null) {
                viewPager2.setOnPageChangeListener((ViewPager.e) null);
            }
            if (viewPager.getAdapter() != null) {
                this.f22407d = viewPager;
                viewPager.setOnPageChangeListener(this);
                a();
                return;
            }
            throw new IllegalStateException("ViewPager does not have adapter instance!");
        }
    }
}
