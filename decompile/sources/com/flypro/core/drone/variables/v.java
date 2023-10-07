package com.flypro.core.drone.variables;

import com.flypro.core.drone.d;
import dy.w;
import en.a;
import org.greenrobot.eventbus.c;

public class v extends d {

    /* renamed from: a  reason: collision with root package name */
    private int f14395a = -1;

    public v(a aVar) {
        super(aVar);
    }

    public int a() {
        return this.f14395a;
    }

    public void a(int i2) {
        if (this.f14395a != i2) {
            this.f14395a = i2;
            c.a().d(new w(46));
        }
    }
}
