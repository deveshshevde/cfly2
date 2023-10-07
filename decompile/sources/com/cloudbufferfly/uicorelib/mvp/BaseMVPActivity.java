package com.cloudbufferfly.uicorelib.mvp;

import android.os.Bundle;
import com.cloudbufferfly.uicorelib.baseview.SupportActivity;
import com.cloudbufferfly.uicorelib.baseview.e;

public abstract class BaseMVPActivity<UIIterface, Presenter extends e<UIIterface>> extends SupportActivity {

    /* renamed from: a  reason: collision with root package name */
    private Presenter f10735a;

    /* access modifiers changed from: protected */
    public abstract Presenter b();

    /* access modifiers changed from: protected */
    public abstract int c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (c() != 0) {
            setContentView(c());
        }
        d();
        e();
        f();
        Presenter b2 = b();
        this.f10735a = b2;
        if (b2 != null) {
            b2.a(this);
            b2.b();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        Presenter presenter = this.f10735a;
        if (presenter != null) {
            presenter.e();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Presenter presenter = this.f10735a;
        if (presenter != null) {
            presenter.d();
        }
    }
}
