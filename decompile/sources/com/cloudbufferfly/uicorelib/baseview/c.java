package com.cloudbufferfly.uicorelib.baseview;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;
import kotlin.jvm.internal.h;

public abstract class c extends d implements j {

    /* renamed from: a  reason: collision with root package name */
    private Bundle f10707a;

    /* renamed from: b  reason: collision with root package name */
    private final l f10708b = new l();

    /* renamed from: c  reason: collision with root package name */
    private boolean f10709c;

    /* renamed from: d  reason: collision with root package name */
    private Activity f10710d;

    /* renamed from: e  reason: collision with root package name */
    private View f10711e;

    /* renamed from: f  reason: collision with root package name */
    private final Handler f10712f = new Handler();

    /* renamed from: g  reason: collision with root package name */
    private final String f10713g = "BaseFragment";

    /* renamed from: h  reason: collision with root package name */
    private final String f10714h = "FRAGMENT_KEY.BUNDLE";

    /* renamed from: i  reason: collision with root package name */
    private HashMap f10715i;

    public abstract int c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public View getView() {
        return this.f10711e;
    }

    public void h() {
        HashMap hashMap = this.f10715i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public void h_() {
        super.h_();
        this.f10708b.a();
    }

    public void i_() {
        super.i_();
        this.f10708b.b();
    }

    public void onAttach(Activity activity) {
        h.c(activity, "activity");
        super.onAttach(activity);
        this.f10710d = activity;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f10709c = true;
            if (this.f10707a == null) {
                this.f10707a = bundle.getBundle("FRAGMENT_KEY.BUNDLE");
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.c(layoutInflater, "inflater");
        Log.v(getClass().getSimpleName(), "onCreateView");
        d();
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(getContext());
        a aVar = a.f10694a;
        h.a((Object) cloneInContext, "inflaterClone");
        aVar.a(cloneInContext, this.f10708b);
        this.f10711e = cloneInContext.inflate(c(), viewGroup, false);
        e();
        f();
        g();
        this.f10708b.e();
        return this.f10711e;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f10708b.k();
        this.f10711e = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f10708b.j();
        this.f10711e = null;
        h();
    }

    public void onDetach() {
        super.onDetach();
        this.f10710d = null;
    }

    public void onPause() {
        super.onPause();
        this.f10708b.h();
    }

    public void onResume() {
        super.onResume();
        this.f10708b.g();
    }

    public void onSaveInstanceState(Bundle bundle) {
        h.c(bundle, "outState");
        super.onSaveInstanceState(bundle);
        Bundle bundle2 = this.f10707a;
        if (bundle2 != null) {
            bundle.putBundle("FRAGMENT_KEY.BUNDLE", bundle2);
        }
    }

    public void onStart() {
        super.onStart();
        this.f10708b.f();
    }

    public void onStop() {
        super.onStop();
        this.f10708b.i();
    }
}
