package com.cloudbufferfly.uicorelib.baseview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import kotlin.jvm.internal.h;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import me.yokeyword.fragmentation.b;
import me.yokeyword.fragmentation.c;
import me.yokeyword.fragmentation.f;

public class d extends Fragment implements c {

    /* renamed from: a  reason: collision with root package name */
    private final f f10716a = new f(this);

    /* renamed from: b  reason: collision with root package name */
    private FragmentActivity f10717b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f10718c;

    public void a(int i2, int i3, Bundle bundle) {
        this.f10716a.a(i2, i3, bundle);
    }

    public void a(Bundle bundle) {
        this.f10716a.d(bundle);
    }

    public void b(Bundle bundle) {
        this.f10716a.e(bundle);
    }

    public void h() {
        HashMap hashMap = this.f10718c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public void h_() {
        this.f10716a.e();
    }

    public f i() {
        return this.f10716a;
    }

    public void i_() {
        this.f10716a.f();
    }

    public boolean j() {
        return this.f10716a.g();
    }

    public FragmentAnimator k() {
        return this.f10716a.h();
    }

    public boolean l() {
        return this.f10716a.j();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f10716a.c(bundle);
    }

    public void onAttach(Activity activity) {
        h.c(activity, "activity");
        super.onAttach(activity);
        if (activity instanceof b) {
            this.f10716a.a(activity);
        } else {
            String simpleName = activity.getClass().getSimpleName();
            Log.e(simpleName, " must impl ISupportActivity!" + new Object[0]);
        }
        if (activity instanceof FragmentActivity) {
            this.f10717b = (FragmentActivity) activity;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f10716a.a(bundle);
    }

    public Animation onCreateAnimation(int i2, boolean z2, int i3) {
        return this.f10716a.a(i2, z2, i3);
    }

    public void onDestroy() {
        this.f10716a.d();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f10716a.c();
        super.onDestroyView();
        h();
    }

    public void onHiddenChanged(boolean z2) {
        super.onHiddenChanged(z2);
        this.f10716a.a(z2);
    }

    public void onPause() {
        super.onPause();
        this.f10716a.b();
    }

    public void onResume() {
        super.onResume();
        this.f10716a.a();
    }

    public void onSaveInstanceState(Bundle bundle) {
        h.c(bundle, "outState");
        super.onSaveInstanceState(bundle);
        this.f10716a.b(bundle);
    }

    public void setUserVisibleHint(boolean z2) {
        super.setUserVisibleHint(z2);
        this.f10716a.b(z2);
    }
}
