package com.scwang.smartrefresh.layout.impl;

import android.graphics.PointF;
import android.view.View;
import ja.k;

public class b implements k {

    /* renamed from: a  reason: collision with root package name */
    public PointF f21578a;

    /* renamed from: b  reason: collision with root package name */
    public k f21579b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f21580c = true;

    public boolean a(View view) {
        k kVar = this.f21579b;
        return kVar != null ? kVar.a(view) : jc.b.a(view, this.f21578a);
    }

    public boolean b(View view) {
        k kVar = this.f21579b;
        return kVar != null ? kVar.b(view) : jc.b.a(view, this.f21578a, this.f21580c);
    }
}
