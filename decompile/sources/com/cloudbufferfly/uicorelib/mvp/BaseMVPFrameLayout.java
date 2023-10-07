package com.cloudbufferfly.uicorelib.mvp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.cloudbufferfly.uicorelib.baseview.BaseFrameLayout;
import com.cloudbufferfly.uicorelib.baseview.e;
import kotlin.jvm.internal.h;

public abstract class BaseMVPFrameLayout<UIInterface, Presenter extends e<UIInterface>> extends BaseFrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private Presenter f10736a;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BaseMVPFrameLayout(Context context) {
        this(context, (AttributeSet) null, 0);
        h.c(context, "context");
        b();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BaseMVPFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        h.c(context, "context");
        b();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseMVPFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        h.c(context, "context");
    }

    private final void b() {
        Presenter a2 = a();
        this.f10736a = a2;
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
        return this.f10736a;
    }

    /* access modifiers changed from: protected */
    public final void setMPresenter(Presenter presenter) {
        this.f10736a = presenter;
    }
}
