package com.scwang.smartrefresh.layout.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.b;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import ja.d;
import ja.g;
import ja.h;
import ja.i;
import ja.j;

public class TwoLevelHeader extends InternalAbstract implements g {

    /* renamed from: a  reason: collision with root package name */
    protected int f21565a;

    /* renamed from: b  reason: collision with root package name */
    protected float f21566b;

    /* renamed from: c  reason: collision with root package name */
    protected float f21567c;

    /* renamed from: d  reason: collision with root package name */
    protected float f21568d;

    /* renamed from: e  reason: collision with root package name */
    protected float f21569e;

    /* renamed from: f  reason: collision with root package name */
    protected boolean f21570f;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f21571g;

    /* renamed from: h  reason: collision with root package name */
    protected int f21572h;

    /* renamed from: i  reason: collision with root package name */
    protected int f21573i;

    /* renamed from: j  reason: collision with root package name */
    protected h f21574j;

    /* renamed from: k  reason: collision with root package name */
    protected i f21575k;

    /* renamed from: l  reason: collision with root package name */
    protected d f21576l;

    /* renamed from: com.scwang.smartrefresh.layout.header.TwoLevelHeader$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f21577a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.scwang.smartrefresh.layout.constant.RefreshState[] r0 = com.scwang.smartrefresh.layout.constant.RefreshState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f21577a = r0
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.TwoLevelReleased     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f21577a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.TwoLevel     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f21577a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.TwoLevelFinish     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f21577a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownToRefresh     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.header.TwoLevelHeader.AnonymousClass1.<clinit>():void");
        }
    }

    public TwoLevelHeader(Context context) {
        this(context, (AttributeSet) null);
    }

    public TwoLevelHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f21566b = 0.0f;
        this.f21567c = 2.5f;
        this.f21568d = 1.9f;
        this.f21569e = 1.0f;
        this.f21570f = true;
        this.f21571g = true;
        this.f21572h = 1000;
        this.f12189y = b.f12101c;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TwoLevelHeader);
        this.f21567c = obtainStyledAttributes.getFloat(R.styleable.TwoLevelHeader_srlMaxRage, this.f21567c);
        this.f21568d = obtainStyledAttributes.getFloat(R.styleable.TwoLevelHeader_srlFloorRage, this.f21568d);
        this.f21569e = obtainStyledAttributes.getFloat(R.styleable.TwoLevelHeader_srlRefreshRage, this.f21569e);
        this.f21572h = obtainStyledAttributes.getInt(R.styleable.TwoLevelHeader_srlFloorDuration, this.f21572h);
        this.f21570f = obtainStyledAttributes.getBoolean(R.styleable.TwoLevelHeader_srlEnableTwoLevel, this.f21570f);
        this.f21571g = obtainStyledAttributes.getBoolean(R.styleable.TwoLevelHeader_srlEnablePullToCloseTwoLevel, this.f21571g);
        obtainStyledAttributes.recycle();
    }

    public TwoLevelHeader a(g gVar) {
        return a(gVar, -1, -2);
    }

    public TwoLevelHeader a(g gVar, int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams;
        int i4;
        View view;
        if (gVar != null) {
            h hVar = this.f21574j;
            if (hVar != null) {
                removeView(hVar.getView());
            }
            if (gVar.getSpinnerStyle() == b.f12101c) {
                view = gVar.getView();
                i4 = 0;
                layoutParams = new RelativeLayout.LayoutParams(i2, i3);
            } else {
                view = gVar.getView();
                i4 = getChildCount();
                layoutParams = new RelativeLayout.LayoutParams(i2, i3);
            }
            addView(view, i4, layoutParams);
            this.f21574j = gVar;
            this.f12190z = gVar;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void a(int i2) {
        h hVar = this.f21574j;
        if (this.f21565a != i2 && hVar != null) {
            this.f21565a = i2;
            b spinnerStyle = hVar.getSpinnerStyle();
            if (spinnerStyle == b.f12099a) {
                hVar.getView().setTranslationY((float) i2);
            } else if (spinnerStyle.f12107i) {
                View view = hVar.getView();
                view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getTop() + Math.max(0, i2));
            }
        }
    }

    public void a(i iVar, int i2, int i3) {
        h hVar = this.f21574j;
        if (hVar != null) {
            if ((((float) (i3 + i2)) * 1.0f) / ((float) i2) != this.f21567c && this.f21573i == 0) {
                this.f21573i = i2;
                this.f21574j = null;
                iVar.a().d(this.f21567c);
                this.f21574j = hVar;
            }
            if (this.f21575k == null && hVar.getSpinnerStyle() == b.f12099a && !isInEditMode()) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) hVar.getView().getLayoutParams();
                marginLayoutParams.topMargin -= i2;
                hVar.getView().setLayoutParams(marginLayoutParams);
            }
            this.f21573i = i2;
            this.f21575k = iVar;
            iVar.b(this.f21572h);
            iVar.a((h) this, !this.f21571g);
            hVar.a(iVar, i2, i3);
        }
    }

    public void a(j jVar, RefreshState refreshState, RefreshState refreshState2) {
        h hVar = this.f21574j;
        if (hVar != null) {
            hVar.a(jVar, refreshState, refreshState2);
            int i2 = AnonymousClass1.f21577a[refreshState2.ordinal()];
            boolean z2 = true;
            if (i2 == 1) {
                if (hVar.getView() != this) {
                    hVar.getView().animate().alpha(0.0f).setDuration((long) (this.f21572h / 2));
                }
                i iVar = this.f21575k;
                if (iVar != null) {
                    d dVar = this.f21576l;
                    if (dVar != null && !dVar.a(jVar)) {
                        z2 = false;
                    }
                    iVar.a(z2);
                }
            } else if (i2 != 3) {
                if (i2 == 4 && hVar.getView().getAlpha() == 0.0f && hVar.getView() != this) {
                    hVar.getView().setAlpha(1.0f);
                }
            } else if (hVar.getView() != this) {
                hVar.getView().animate().alpha(1.0f).setDuration((long) (this.f21572h / 2));
            }
        }
    }

    public void a(boolean z2, float f2, int i2, int i3, int i4) {
        RefreshState refreshState;
        a(i2);
        h hVar = this.f21574j;
        i iVar = this.f21575k;
        if (hVar != null) {
            hVar.a(z2, f2, i2, i3, i4);
        }
        if (z2) {
            float f3 = this.f21566b;
            float f4 = this.f21568d;
            if (f3 < f4 && f2 >= f4 && this.f21570f) {
                refreshState = RefreshState.ReleaseToTwoLevel;
            } else if (f3 < f4 || f2 >= this.f21569e) {
                if (f3 >= f4 && f2 < f4) {
                    refreshState = RefreshState.ReleaseToRefresh;
                }
                this.f21566b = f2;
            } else {
                refreshState = RefreshState.PullDownToRefresh;
            }
            iVar.a(refreshState);
            this.f21566b = f2;
        }
    }

    public boolean equals(Object obj) {
        h hVar = this.f21574j;
        return (hVar != null && hVar.equals(obj)) || super.equals(obj);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f12189y = b.f12103e;
        if (this.f21574j == null) {
            a((g) new ClassicsHeader(getContext()));
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f12189y = b.f12101c;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            if (childAt instanceof g) {
                this.f21574j = (g) childAt;
                this.f12190z = (h) childAt;
                bringChildToFront(childAt);
                break;
            }
            i2++;
        }
        if (this.f21574j == null) {
            a((g) new ClassicsHeader(getContext()));
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        h hVar = this.f21574j;
        if (hVar == null || View.MeasureSpec.getMode(i3) != Integer.MIN_VALUE) {
            super.onMeasure(i2, i3);
            return;
        }
        hVar.getView().measure(i2, i3);
        super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), i2), hVar.getView().getMeasuredHeight());
    }
}
