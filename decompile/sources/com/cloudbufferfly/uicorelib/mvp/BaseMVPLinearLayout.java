package com.cloudbufferfly.uicorelib.mvp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.cloudbufferfly.uicorelib.baseview.BaseLinearLayout;
import com.cloudbufferfly.uicorelib.baseview.e;
import kotlin.jvm.internal.h;

public abstract class BaseMVPLinearLayout<UIInterface, Presenter extends e<UIInterface>> extends BaseLinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Presenter f10737a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BaseMVPLinearLayout(Context context) {
        this(context, (AttributeSet) null, 0);
        h.c(context, "context");
        b();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BaseMVPLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        h.c(context, "context");
        b();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseMVPLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        h.c(context, "context");
    }

    private final void b() {
        Presenter a2 = a();
        this.f10737a = a2;
        if (a2 != null) {
            a2.a(this);
        }
        if (getContentViewId() != 0) {
            LayoutInflater.from(getContext()).inflate(getContentViewId(), this);
        }
    }

    /* access modifiers changed from: protected */
    public abstract Presenter a();

    public abstract int getContentViewId();

    /* access modifiers changed from: protected */
    public final Presenter getMPresenter() {
        return this.f10737a;
    }

    /* access modifiers changed from: protected */
    public final void setMPresenter(Presenter presenter) {
        this.f10737a = presenter;
    }
}
