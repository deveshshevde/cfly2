package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

final class i implements m {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrameLayout f18000a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LayoutInflater f18001b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ViewGroup f18002c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Bundle f18003d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ a f18004e;

    i(a aVar, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f18004e = aVar;
        this.f18000a = frameLayout;
        this.f18001b = layoutInflater;
        this.f18002c = viewGroup;
        this.f18003d = bundle;
    }

    public final int a() {
        return 2;
    }

    public final void a(c cVar) {
        this.f18000a.removeAllViews();
        this.f18000a.addView(this.f18004e.f17988a.a(this.f18001b, this.f18002c, this.f18003d));
    }
}
