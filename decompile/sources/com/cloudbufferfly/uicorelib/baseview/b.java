package com.cloudbufferfly.uicorelib.baseview;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.c;
import java.util.HashMap;
import kotlin.jvm.internal.h;
import me.yokeyword.fragmentation.f;

public abstract class b extends c implements me.yokeyword.fragmentation.c {

    /* renamed from: a  reason: collision with root package name */
    private final String f10697a = "BaseDialogFragment";

    /* renamed from: b  reason: collision with root package name */
    private final String f10698b = "DIALOG_FRAGMENT_KEY.BUNDLE";

    /* renamed from: c  reason: collision with root package name */
    private Bundle f10699c;

    /* renamed from: d  reason: collision with root package name */
    private l f10700d = new l();

    /* renamed from: e  reason: collision with root package name */
    private boolean f10701e;

    /* renamed from: f  reason: collision with root package name */
    private Activity f10702f;

    /* renamed from: g  reason: collision with root package name */
    private View f10703g;

    /* renamed from: h  reason: collision with root package name */
    private final Handler f10704h = new Handler();

    /* renamed from: i  reason: collision with root package name */
    private final f f10705i = new f(this);

    /* renamed from: j  reason: collision with root package name */
    private HashMap f10706j;

    public abstract int a();

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public void f() {
        HashMap hashMap = this.f10706j;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View getView() {
        return this.f10703g;
    }

    public void onAttach(Activity activity) {
        h.c(activity, "activity");
        super.onAttach(activity);
        this.f10702f = activity;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f10701e = true;
            if (this.f10699c == null) {
                this.f10699c = bundle.getBundle("DIALOG_FRAGMENT_KEY.BUNDLE");
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.c(layoutInflater, "inflater");
        b();
        a.f10694a.a(layoutInflater, this.f10700d);
        this.f10703g = layoutInflater.inflate(a(), viewGroup, false);
        c();
        d();
        e();
        this.f10700d.e();
        return this.f10703g;
    }

    public void onDestroy() {
        super.onDestroy();
        this.f10700d.k();
        this.f10703g = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f10700d.j();
        this.f10703g = null;
        f();
    }

    public void onDetach() {
        super.onDetach();
        this.f10702f = null;
    }

    public void onPause() {
        super.onPause();
        this.f10700d.h();
    }

    public void onResume() {
        super.onResume();
        this.f10700d.g();
    }

    public void onSaveInstanceState(Bundle bundle) {
        h.c(bundle, "outState");
        super.onSaveInstanceState(bundle);
        Bundle bundle2 = this.f10699c;
        if (bundle2 != null) {
            bundle.putBundle("DIALOG_FRAGMENT_KEY.BUNDLE", bundle2);
        }
    }

    public void onStart() {
        super.onStart();
        this.f10700d.f();
    }

    public void onStop() {
        super.onStop();
        this.f10700d.i();
    }
}
