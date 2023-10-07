package com.afollestad.materialdialogs.internal.list;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ay.e;
import kotlin.jvm.internal.h;
import kotlin.l;
import mm.m;

public final class DialogRecyclerView extends RecyclerView {
    private m<? super Boolean, ? super Boolean, l> N;
    private final a O = new a(this);

    public static final class a extends RecyclerView.l {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DialogRecyclerView f7587a;

        a(DialogRecyclerView dialogRecyclerView) {
            this.f7587a = dialogRecyclerView;
        }

        public void a(RecyclerView recyclerView, int i2, int i3) {
            h.c(recyclerView, "recyclerView");
            super.a(recyclerView, i2, i3);
            this.f7587a.y();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.c(context, "context");
    }

    private final boolean A() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            h.a();
        }
        h.a((Object) adapter, "adapter!!");
        int itemCount = adapter.getItemCount() - 1;
        RecyclerView.h layoutManager = getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return (layoutManager instanceof GridLayoutManager) && ((GridLayoutManager) layoutManager).r() == itemCount;
        }
        if (((LinearLayoutManager) layoutManager).r() == itemCount) {
            return true;
        }
    }

    private final boolean B() {
        return A() && z();
    }

    /* access modifiers changed from: private */
    public final void C() {
        int i2 = 2;
        if (!(getChildCount() == 0 || getMeasuredHeight() == 0 || B())) {
            i2 = 1;
        }
        setOverScrollMode(i2);
    }

    private final boolean z() {
        RecyclerView.h layoutManager = getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            return (layoutManager instanceof GridLayoutManager) && ((GridLayoutManager) layoutManager).p() == 0;
        }
        if (((LinearLayoutManager) layoutManager).p() == 0) {
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e.f5573a.a(this, DialogRecyclerView$onAttachedToWindow$1.f7588a);
        a((RecyclerView.l) this.O);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        b((RecyclerView.l) this.O);
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        y();
    }

    public final void y() {
        m<? super Boolean, ? super Boolean, l> mVar;
        if (getChildCount() != 0 && getMeasuredHeight() != 0 && (mVar = this.N) != null) {
            l a2 = mVar.a(Boolean.valueOf(!z()), Boolean.valueOf(!A()));
        }
    }
}
