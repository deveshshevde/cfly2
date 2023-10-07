package com.cloudbufferfly.uicorelib.baseview;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;
import kotlin.jvm.internal.h;

public abstract class BaseLinearLayout extends LinearLayout implements i {

    /* renamed from: a  reason: collision with root package name */
    private final f f10684a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f10685b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BaseLinearLayout(Context context) {
        this(context, (AttributeSet) null, 0);
        h.c(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BaseLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        h.c(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        h.c(context, "context");
        f fVar = new f(this);
        this.f10684a = fVar;
        this.f10685b = new Handler();
        fVar.a();
    }

    public final SupportActivity getActivity() {
        return a.f10694a.a(this);
    }

    public i getLifecycleDelegate() {
        return this.f10684a;
    }

    /* access modifiers changed from: protected */
    public final Handler getMHandler() {
        return this.f10685b;
    }

    public void onAttachedToWindow() {
        Log.v(getClass().getSimpleName(), "onAttachedToWindow");
        super.onAttachedToWindow();
        this.f10684a.b();
    }

    public void onDetachedFromWindow() {
        Log.v(getClass().getSimpleName(), "onDetachedFromWindow");
        super.onDetachedFromWindow();
        this.f10684a.c();
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        this.f10684a.onWindowFocusChanged(z2);
    }
}
