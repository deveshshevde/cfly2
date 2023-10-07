package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.internal.m;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private final Object f17609a;

    public h(Activity activity) {
        m.a(activity, (Object) "Activity must not be null");
        this.f17609a = activity;
    }

    public final Activity a() {
        return (Activity) this.f17609a;
    }

    public final FragmentActivity b() {
        return (FragmentActivity) this.f17609a;
    }

    public final boolean c() {
        return this.f17609a instanceof Activity;
    }

    public final boolean d() {
        return this.f17609a instanceof FragmentActivity;
    }
}
