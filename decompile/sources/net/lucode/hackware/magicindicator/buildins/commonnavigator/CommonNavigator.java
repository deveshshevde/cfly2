package net.lucode.hackware.magicindicator.buildins.commonnavigator;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;
import mx.a;
import mz.c;
import mz.d;
import net.lucode.hackware.magicindicator.R;
import net.lucode.hackware.magicindicator.b;

public class CommonNavigator extends FrameLayout implements a, b.a {

    /* renamed from: a  reason: collision with root package name */
    private HorizontalScrollView f31446a;

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f31447b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f31448c;

    /* renamed from: d  reason: collision with root package name */
    private c f31449d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public mz.a f31450e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public b f31451f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f31452g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f31453h;

    /* renamed from: i  reason: collision with root package name */
    private float f31454i = 0.5f;

    /* renamed from: j  reason: collision with root package name */
    private boolean f31455j = true;

    /* renamed from: k  reason: collision with root package name */
    private boolean f31456k = true;

    /* renamed from: l  reason: collision with root package name */
    private int f31457l;

    /* renamed from: m  reason: collision with root package name */
    private int f31458m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f31459n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f31460o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f31461p = true;

    /* renamed from: q  reason: collision with root package name */
    private List<na.a> f31462q = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    private DataSetObserver f31463r = new DataSetObserver() {
        public void onChanged() {
            CommonNavigator.this.f31451f.c(CommonNavigator.this.f31450e.getCount());
            CommonNavigator.this.c();
        }

        public void onInvalidated() {
        }
    };

    public CommonNavigator(Context context) {
        super(context);
        b bVar = new b();
        this.f31451f = bVar;
        bVar.a((b.a) this);
    }

    /* access modifiers changed from: private */
    public void c() {
        int i2;
        LayoutInflater layoutInflater;
        removeAllViews();
        if (this.f31452g) {
            layoutInflater = LayoutInflater.from(getContext());
            i2 = R.layout.pager_navigator_layout_no_scroll;
        } else {
            layoutInflater = LayoutInflater.from(getContext());
            i2 = R.layout.pager_navigator_layout;
        }
        View inflate = layoutInflater.inflate(i2, this);
        this.f31446a = (HorizontalScrollView) inflate.findViewById(R.id.scroll_view);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.title_container);
        this.f31447b = linearLayout;
        linearLayout.setPadding(this.f31458m, 0, this.f31457l, 0);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.indicator_container);
        this.f31448c = linearLayout2;
        if (this.f31459n) {
            linearLayout2.getParent().bringChildToFront(this.f31448c);
        }
        d();
    }

    private void d() {
        LinearLayout.LayoutParams layoutParams;
        int a2 = this.f31451f.a();
        for (int i2 = 0; i2 < a2; i2++) {
            d titleView = this.f31450e.getTitleView(getContext(), i2);
            if (titleView instanceof View) {
                View view = (View) titleView;
                if (this.f31452g) {
                    layoutParams = new LinearLayout.LayoutParams(0, -1);
                    layoutParams.weight = this.f31450e.getTitleWeight(getContext(), i2);
                } else {
                    layoutParams = new LinearLayout.LayoutParams(-2, -1);
                }
                this.f31447b.addView(view, layoutParams);
            }
        }
        mz.a aVar = this.f31450e;
        if (aVar != null) {
            c indicator = aVar.getIndicator(getContext());
            this.f31449d = indicator;
            if (indicator instanceof View) {
                this.f31448c.addView((View) this.f31449d, new FrameLayout.LayoutParams(-1, -1));
            }
        }
    }

    private void e() {
        int i2;
        this.f31462q.clear();
        int a2 = this.f31451f.a();
        for (int i3 = 0; i3 < a2; i3++) {
            na.a aVar = new na.a();
            View childAt = this.f31447b.getChildAt(i3);
            if (childAt != null) {
                aVar.f31303a = childAt.getLeft();
                aVar.f31304b = childAt.getTop();
                aVar.f31305c = childAt.getRight();
                aVar.f31306d = childAt.getBottom();
                if (childAt instanceof mz.b) {
                    mz.b bVar = (mz.b) childAt;
                    aVar.f31307e = bVar.getContentLeft();
                    aVar.f31308f = bVar.getContentTop();
                    aVar.f31309g = bVar.getContentRight();
                    i2 = bVar.getContentBottom();
                } else {
                    aVar.f31307e = aVar.f31303a;
                    aVar.f31308f = aVar.f31304b;
                    aVar.f31309g = aVar.f31305c;
                    i2 = aVar.f31306d;
                }
                aVar.f31310h = i2;
            }
            this.f31462q.add(aVar);
        }
    }

    public void a() {
        c();
    }

    public void a(int i2) {
        if (this.f31450e != null) {
            this.f31451f.a(i2);
            c cVar = this.f31449d;
            if (cVar != null) {
                cVar.a(i2);
            }
        }
    }

    public void a(int i2, float f2, int i3) {
        if (this.f31450e != null) {
            this.f31451f.a(i2, f2, i3);
            c cVar = this.f31449d;
            if (cVar != null) {
                cVar.a(i2, f2, i3);
            }
            if (this.f31446a != null && this.f31462q.size() > 0 && i2 >= 0 && i2 < this.f31462q.size() && this.f31456k) {
                int min = Math.min(this.f31462q.size() - 1, i2);
                int min2 = Math.min(this.f31462q.size() - 1, i2 + 1);
                float b2 = ((float) this.f31462q.get(min).b()) - (((float) this.f31446a.getWidth()) * this.f31454i);
                this.f31446a.scrollTo((int) (b2 + (((((float) this.f31462q.get(min2).b()) - (((float) this.f31446a.getWidth()) * this.f31454i)) - b2) * f2)), 0);
            }
        }
    }

    public void a(int i2, int i3) {
        HorizontalScrollView horizontalScrollView;
        int i4;
        HorizontalScrollView horizontalScrollView2;
        int i5;
        LinearLayout linearLayout = this.f31447b;
        if (linearLayout != null) {
            View childAt = linearLayout.getChildAt(i2);
            if (childAt instanceof d) {
                ((d) childAt).a(i2, i3);
            }
            if (!this.f31452g && !this.f31456k && this.f31446a != null && this.f31462q.size() > 0) {
                na.a aVar = this.f31462q.get(Math.min(this.f31462q.size() - 1, i2));
                if (this.f31453h) {
                    float b2 = ((float) aVar.b()) - (((float) this.f31446a.getWidth()) * this.f31454i);
                    if (this.f31455j) {
                        horizontalScrollView2 = this.f31446a;
                        i5 = (int) b2;
                    } else {
                        horizontalScrollView = this.f31446a;
                        i4 = (int) b2;
                        horizontalScrollView.scrollTo(i4, 0);
                        return;
                    }
                } else if (this.f31446a.getScrollX() > aVar.f31303a) {
                    if (this.f31455j) {
                        horizontalScrollView2 = this.f31446a;
                        i5 = aVar.f31303a;
                    } else {
                        horizontalScrollView = this.f31446a;
                        i4 = aVar.f31303a;
                        horizontalScrollView.scrollTo(i4, 0);
                        return;
                    }
                } else if (this.f31446a.getScrollX() + getWidth() >= aVar.f31305c) {
                    return;
                } else {
                    if (this.f31455j) {
                        horizontalScrollView2 = this.f31446a;
                        i5 = aVar.f31305c - getWidth();
                    } else {
                        horizontalScrollView = this.f31446a;
                        i4 = aVar.f31305c - getWidth();
                        horizontalScrollView.scrollTo(i4, 0);
                        return;
                    }
                }
                horizontalScrollView2.smoothScrollTo(i5, 0);
            }
        }
    }

    public void a(int i2, int i3, float f2, boolean z2) {
        LinearLayout linearLayout = this.f31447b;
        if (linearLayout != null) {
            View childAt = linearLayout.getChildAt(i2);
            if (childAt instanceof d) {
                ((d) childAt).a(i2, i3, f2, z2);
            }
        }
    }

    public void b() {
    }

    public void b(int i2) {
        if (this.f31450e != null) {
            this.f31451f.b(i2);
            c cVar = this.f31449d;
            if (cVar != null) {
                cVar.b(i2);
            }
        }
    }

    public void b(int i2, int i3) {
        LinearLayout linearLayout = this.f31447b;
        if (linearLayout != null) {
            View childAt = linearLayout.getChildAt(i2);
            if (childAt instanceof d) {
                ((d) childAt).b(i2, i3);
            }
        }
    }

    public void b(int i2, int i3, float f2, boolean z2) {
        LinearLayout linearLayout = this.f31447b;
        if (linearLayout != null) {
            View childAt = linearLayout.getChildAt(i2);
            if (childAt instanceof d) {
                ((d) childAt).b(i2, i3, f2, z2);
            }
        }
    }

    public mz.a getAdapter() {
        return this.f31450e;
    }

    public int getLeftPadding() {
        return this.f31458m;
    }

    public c getPagerIndicator() {
        return this.f31449d;
    }

    public int getRightPadding() {
        return this.f31457l;
    }

    public float getScrollPivotX() {
        return this.f31454i;
    }

    public LinearLayout getTitleContainer() {
        return this.f31447b;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (this.f31450e != null) {
            e();
            c cVar = this.f31449d;
            if (cVar != null) {
                cVar.a(this.f31462q);
            }
            if (this.f31461p && this.f31451f.c() == 0) {
                a(this.f31451f.b());
                a(this.f31451f.b(), 0.0f, 0);
            }
        }
    }

    public void setAdapter(mz.a aVar) {
        mz.a aVar2 = this.f31450e;
        if (aVar2 != aVar) {
            if (aVar2 != null) {
                aVar2.unregisterDataSetObserver(this.f31463r);
            }
            this.f31450e = aVar;
            if (aVar != null) {
                aVar.registerDataSetObserver(this.f31463r);
                this.f31451f.c(this.f31450e.getCount());
                if (this.f31447b != null) {
                    this.f31450e.notifyDataSetChanged();
                    return;
                }
                return;
            }
            this.f31451f.c(0);
            c();
        }
    }

    public void setAdjustMode(boolean z2) {
        this.f31452g = z2;
    }

    public void setEnablePivotScroll(boolean z2) {
        this.f31453h = z2;
    }

    public void setFollowTouch(boolean z2) {
        this.f31456k = z2;
    }

    public void setIndicatorOnTop(boolean z2) {
        this.f31459n = z2;
    }

    public void setLeftPadding(int i2) {
        this.f31458m = i2;
    }

    public void setReselectWhenLayout(boolean z2) {
        this.f31461p = z2;
    }

    public void setRightPadding(int i2) {
        this.f31457l = i2;
    }

    public void setScrollPivotX(float f2) {
        this.f31454i = f2;
    }

    public void setSkimOver(boolean z2) {
        this.f31460o = z2;
        this.f31451f.a(z2);
    }

    public void setSmoothScroll(boolean z2) {
        this.f31455j = z2;
    }
}
