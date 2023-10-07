package com.cloudbufferfly.uicorelib.mvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cloudbufferfly.uicorelib.baseview.b;
import com.cloudbufferfly.uicorelib.baseview.e;
import java.util.HashMap;
import kotlin.jvm.internal.h;

public abstract class a<UIInterface, Presenter extends e<UIInterface>> extends b {

    /* renamed from: a  reason: collision with root package name */
    private Presenter f10739a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f10740b;

    public void f() {
        HashMap hashMap = this.f10740b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* access modifiers changed from: protected */
    public abstract Presenter g();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Presenter g2 = g();
        this.f10739a = g2;
        if (g2 != null) {
            g2.a(this);
            g2.b();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.c(layoutInflater, "inflater");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        Presenter presenter = this.f10739a;
        if (presenter != null) {
            presenter.c();
        }
        return onCreateView;
    }

    public void onDestroy() {
        super.onDestroy();
        Presenter presenter = this.f10739a;
        if (presenter != null) {
            presenter.h();
            presenter.g();
            presenter.a();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        Presenter presenter = this.f10739a;
        if (presenter != null) {
            presenter.f();
            presenter.a();
        }
        f();
    }

    public void onPause() {
        super.onPause();
        Presenter presenter = this.f10739a;
        if (presenter != null) {
            presenter.e();
        }
    }

    public void onResume() {
        super.onResume();
        Presenter presenter = this.f10739a;
        if (presenter != null) {
            presenter.d();
        }
    }
}
