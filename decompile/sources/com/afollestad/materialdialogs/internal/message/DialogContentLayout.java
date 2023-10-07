package com.afollestad.materialdialogs.internal.message;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import ay.f;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.internal.list.DialogRecyclerView;
import com.afollestad.materialdialogs.internal.main.DialogLayout;
import com.afollestad.materialdialogs.internal.main.DialogScrollView;
import com.blankj.utilcode.constant.MemoryConstants;
import kotlin.TypeCastException;
import kotlin.d;
import kotlin.e;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import ms.g;

public final class DialogContentLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ g[] f7618a = {j.a((PropertyReference1) new PropertyReference1Impl(j.b(DialogContentLayout.class), "frameHorizontalMargin", "getFrameHorizontalMargin()I"))};

    /* renamed from: b  reason: collision with root package name */
    private ViewGroup f7619b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7620c;

    /* renamed from: d  reason: collision with root package name */
    private final d f7621d = e.a(new DialogContentLayout$frameHorizontalMargin$2(this));

    /* renamed from: e  reason: collision with root package name */
    private DialogScrollView f7622e;

    /* renamed from: f  reason: collision with root package name */
    private DialogRecyclerView f7623f;

    /* renamed from: g  reason: collision with root package name */
    private View f7624g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.c(context, "context");
    }

    public static /* synthetic */ void a(DialogContentLayout dialogContentLayout, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = -1;
        }
        if ((i4 & 2) != 0) {
            i3 = -1;
        }
        dialogContentLayout.a(i2, i3);
    }

    private final void a(boolean z2) {
        if (this.f7622e == null) {
            DialogScrollView dialogScrollView = (DialogScrollView) f.a(this, R.layout.md_dialog_stub_scrollview, (ViewGroup) null, 2, (Object) null);
            dialogScrollView.setRootView(getRootLayout());
            View childAt = dialogScrollView.getChildAt(0);
            if (childAt != null) {
                this.f7619b = (ViewGroup) childAt;
                if (!z2) {
                    View view = dialogScrollView;
                    ay.e.a(ay.e.f5573a, view, 0, 0, 0, ay.e.f5573a.a(view, R.dimen.md_dialog_frame_margin_vertical), 7, (Object) null);
                }
                this.f7622e = dialogScrollView;
                addView(dialogScrollView);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
        }
    }

    public static /* synthetic */ void b(DialogContentLayout dialogContentLayout, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = -1;
        }
        if ((i4 & 2) != 0) {
            i3 = -1;
        }
        dialogContentLayout.b(i2, i3);
    }

    private final int getFrameHorizontalMargin() {
        d dVar = this.f7621d;
        g gVar = f7618a[0];
        return ((Number) dVar.a()).intValue();
    }

    private final DialogLayout getRootLayout() {
        ViewParent parent = getParent();
        if (parent != null) {
            return (DialogLayout) parent;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.afollestad.materialdialogs.internal.main.DialogLayout");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: android.view.View} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View a(java.lang.Integer r10, android.view.View r11, boolean r12, boolean r13, boolean r14) {
        /*
            r9 = this;
            android.view.View r0 = r9.f7624g
            r1 = 0
            if (r0 != 0) goto L_0x0007
            r0 = 1
            goto L_0x0008
        L_0x0007:
            r0 = 0
        L_0x0008:
            if (r0 == 0) goto L_0x0089
            r0 = 0
            if (r11 == 0) goto L_0x0023
            android.view.ViewParent r2 = r11.getParent()
            if (r2 == 0) goto L_0x0023
            android.view.ViewParent r2 = r11.getParent()
            boolean r3 = r2 instanceof android.view.ViewGroup
            if (r3 != 0) goto L_0x001c
            r2 = r0
        L_0x001c:
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            if (r2 == 0) goto L_0x0023
            r2.removeView(r11)
        L_0x0023:
            if (r12 == 0) goto L_0x0066
            r9.f7620c = r1
            r9.a(r13)
            if (r11 == 0) goto L_0x002d
            goto L_0x003f
        L_0x002d:
            if (r10 != 0) goto L_0x0032
            kotlin.jvm.internal.h.a()
        L_0x0032:
            int r10 = r10.intValue()
            android.view.ViewGroup r11 = r9.f7619b
            java.lang.Object r10 = ay.f.a(r9, r10, r11)
            r11 = r10
            android.view.View r11 = (android.view.View) r11
        L_0x003f:
            r9.f7624g = r11
            android.view.ViewGroup r10 = r9.f7619b
            if (r10 != 0) goto L_0x0048
            kotlin.jvm.internal.h.a()
        L_0x0048:
            android.view.View r11 = r9.f7624g
            if (r11 == 0) goto L_0x0062
            if (r14 == 0) goto L_0x0061
            ay.e r1 = ay.e.f5573a
            int r3 = r9.getFrameHorizontalMargin()
            r4 = 0
            int r5 = r9.getFrameHorizontalMargin()
            r6 = 0
            r7 = 10
            r8 = 0
            r2 = r11
            ay.e.a(r1, r2, r3, r4, r5, r6, r7, r8)
        L_0x0061:
            r0 = r11
        L_0x0062:
            r10.addView(r0)
            goto L_0x0081
        L_0x0066:
            r9.f7620c = r14
            if (r11 == 0) goto L_0x006b
            goto L_0x007c
        L_0x006b:
            if (r10 != 0) goto L_0x0070
            kotlin.jvm.internal.h.a()
        L_0x0070:
            int r10 = r10.intValue()
            r11 = 2
            java.lang.Object r10 = ay.f.a(r9, r10, r0, r11, r0)
            r11 = r10
            android.view.View r11 = (android.view.View) r11
        L_0x007c:
            r9.f7624g = r11
            r9.addView(r11)
        L_0x0081:
            android.view.View r10 = r9.f7624g
            if (r10 != 0) goto L_0x0088
            kotlin.jvm.internal.h.a()
        L_0x0088:
            return r10
        L_0x0089:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "Custom view already set."
            java.lang.String r11 = r11.toString()
            r10.<init>(r11)
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.afollestad.materialdialogs.internal.message.DialogContentLayout.a(java.lang.Integer, android.view.View, boolean, boolean, boolean):android.view.View");
    }

    public final void a(int i2, int i3) {
        if (i2 != -1) {
            ay.e.a(ay.e.f5573a, getChildAt(0), 0, i2, 0, 0, 13, (Object) null);
        }
        if (i3 != -1) {
            ay.e.a(ay.e.f5573a, getChildAt(getChildCount() - 1), 0, 0, 0, i3, 7, (Object) null);
        }
    }

    public final boolean a() {
        return getChildCount() > 1;
    }

    public final void b(int i2, int i3) {
        ViewGroup viewGroup = this.f7622e;
        if (viewGroup == null) {
            viewGroup = this.f7623f;
        }
        ViewGroup viewGroup2 = viewGroup;
        if (i2 != -1) {
            ay.e.a(ay.e.f5573a, viewGroup2, 0, i2, 0, 0, 13, (Object) null);
        }
        if (i3 != -1) {
            ay.e.a(ay.e.f5573a, viewGroup2, 0, 0, 0, i3, 7, (Object) null);
        }
    }

    public final View getCustomView() {
        return this.f7624g;
    }

    public final DialogRecyclerView getRecyclerView() {
        return this.f7623f;
    }

    public final DialogScrollView getScrollView() {
        return this.f7622e;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int childCount = getChildCount();
        int i8 = 0;
        int i9 = 0;
        while (i8 < childCount) {
            View childAt = getChildAt(i8);
            h.a((Object) childAt, "currentChild");
            int measuredHeight = childAt.getMeasuredHeight() + i9;
            if (!h.a((Object) childAt, (Object) this.f7624g) || !this.f7620c) {
                i6 = getMeasuredWidth();
                i7 = 0;
            } else {
                i7 = getFrameHorizontalMargin();
                i6 = getMeasuredWidth() - getFrameHorizontalMargin();
            }
            childAt.layout(i7, i9, i6, measuredHeight);
            i8++;
            i9 = measuredHeight;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        DialogScrollView dialogScrollView = this.f7622e;
        if (dialogScrollView != null) {
            dialogScrollView.measure(View.MeasureSpec.makeMeasureSpec(size, MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE));
        }
        DialogScrollView dialogScrollView2 = this.f7622e;
        int measuredHeight = dialogScrollView2 != null ? dialogScrollView2.getMeasuredHeight() : 0;
        int i4 = size2 - measuredHeight;
        int childCount = this.f7622e != null ? getChildCount() - 1 : getChildCount();
        if (childCount == 0) {
            setMeasuredDimension(size, measuredHeight);
            return;
        }
        int i5 = i4 / childCount;
        int childCount2 = getChildCount();
        for (int i6 = 0; i6 < childCount2; i6++) {
            View childAt = getChildAt(i6);
            h.a((Object) childAt, "currentChild");
            int id2 = childAt.getId();
            DialogScrollView dialogScrollView3 = this.f7622e;
            if (dialogScrollView3 == null || id2 != dialogScrollView3.getId()) {
                childAt.measure((!h.a((Object) childAt, (Object) this.f7624g) || !this.f7620c) ? View.MeasureSpec.makeMeasureSpec(size, MemoryConstants.GB) : View.MeasureSpec.makeMeasureSpec(size - (getFrameHorizontalMargin() * 2), MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE));
                measuredHeight += childAt.getMeasuredHeight();
            }
        }
        setMeasuredDimension(size, measuredHeight);
    }

    public final void setCustomView(View view) {
        this.f7624g = view;
    }

    public final void setRecyclerView(DialogRecyclerView dialogRecyclerView) {
        this.f7623f = dialogRecyclerView;
    }

    public final void setScrollView(DialogScrollView dialogScrollView) {
        this.f7622e = dialogScrollView;
    }
}
