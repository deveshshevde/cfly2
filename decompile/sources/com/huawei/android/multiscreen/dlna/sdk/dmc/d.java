package com.huawei.android.multiscreen.dlna.sdk.dmc;

import com.huawei.android.multiscreen.dlna.sdk.common.a;
import java.util.ArrayList;
import java.util.List;

public class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private List<a> f20815a = new ArrayList();

    public void a() {
        this.f20815a.clear();
    }

    public void a(int i2) {
        for (int i3 = 0; i3 < this.f20815a.size(); i3++) {
            if (this.f20815a.get(i3).a() == i2) {
                this.f20815a.remove(i3);
            }
        }
    }

    public void a(g gVar) {
        this.f20815a.add(new a(gVar.b()));
    }

    public void b(g gVar) {
        a(gVar.b());
    }
}
