package com.xeagle.android.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.login.retrofitLogin.sochip.SochipPresenter;
import com.xeagle.android.newUI.activity.BaseActivity;
import com.xeagle.android.newUI.cameraManager.AmbaClient;

public abstract class a extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    protected XEagleApp f12540a;

    /* renamed from: b  reason: collision with root package name */
    protected int f12541b;

    /* renamed from: c  reason: collision with root package name */
    protected AmbaClient f12542c;

    /* renamed from: d  reason: collision with root package name */
    protected SochipPresenter f12543d;

    /* renamed from: e  reason: collision with root package name */
    public BaseActivity f12544e;

    /* renamed from: f  reason: collision with root package name */
    public int f12545f = -1;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12546g = true;

    private void d() {
        if (getLifecycle().a() == Lifecycle.State.STARTED && this.f12546g) {
            a();
            this.f12546g = false;
        }
    }

    public void a() {
    }

    public abstract void a(View view);

    public abstract int b();

    public void c() {
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f12544e = (BaseActivity) activity;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(b(), viewGroup, false);
    }

    public void onResume() {
        super.onResume();
        d();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        XEagleApp xEagleApp = (XEagleApp) this.f12544e.getApplication();
        this.f12540a = xEagleApp;
        int a2 = xEagleApp.m().a();
        this.f12541b = a2;
        if (a2 == 1) {
            this.f12542c = this.f12540a.g();
        } else if (a2 == 2) {
            this.f12543d = this.f12540a.h();
        }
        this.f12546g = true;
        a(view);
    }
}
