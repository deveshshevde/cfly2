package com.flypro.core.drone.variables;

import com.flypro.core.drone.d;
import dy.j;
import en.a;
import org.greenrobot.eventbus.c;

public class e extends d {

    /* renamed from: a  reason: collision with root package name */
    private int f14300a = -1;

    public e(a aVar) {
        super(aVar);
    }

    public int a() {
        return this.f14300a;
    }

    public void a(int i2) {
        this.f14300a = i2;
        c.a().d(new j(52));
    }
}
