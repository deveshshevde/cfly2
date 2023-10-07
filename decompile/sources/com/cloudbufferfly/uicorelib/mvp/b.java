package com.cloudbufferfly.uicorelib.mvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cloudbufferfly.uicorelib.baseview.c;
import com.cloudbufferfly.uicorelib.baseview.e;
import java.util.HashMap;
import kotlin.jvm.internal.h;

public abstract class b<UIInterface, Presenter extends e<UIInterface>> extends c {

    /* renamed from: a  reason: collision with root package name */
    private Presenter f10741a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f10742b;

    public void h() {
        HashMap hashMap = this.f10742b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    /* access modifiers changed from: protected */
    public abstract Presenter m();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Presenter m2 = m();
        this.f10741a = m2;
        if (m2 != null) {
            m2.a(this);
        }
        Presenter presenter = this.f10741a;
        if (presenter != null) {
            presenter.b();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.c(layoutInflater, "inflater");
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        Presenter presenter = this.f10741a;
        if (presenter != null) {
            presenter.c();
        }
        return onCreateView;
    }

    public void onDestroy() {
        super.onDestroy();
        Presenter presenter = this.f10741a;
        if (presenter != null) {
            presenter.h();
            presenter.g();
            presenter.a();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        Presenter presenter = this.f10741a;
        if (presenter != null) {
            presenter.f();
            presenter.a();
        }
        h();
    }

    public void onPause() {
        super.onPause();
        Presenter presenter = this.f10741a;
        if (presenter != null) {
            presenter.e();
        }
    }

    public void onResume() {
        super.onResume();
        Presenter presenter = this.f10741a;
        if (presenter != null) {
            presenter.d();
        }
    }
}
