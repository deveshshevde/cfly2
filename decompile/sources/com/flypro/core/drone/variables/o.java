package com.flypro.core.drone.variables;

import com.flypro.core.drone.d;
import dy.aq;
import en.a;
import org.greenrobot.eventbus.c;

public class o extends d {

    /* renamed from: a  reason: collision with root package name */
    private int f14365a = -1;

    public o(a aVar) {
        super(aVar);
    }

    public int a() {
        return this.f14365a;
    }

    public void a(int i2) {
        if (i2 != this.f14365a) {
            this.f14365a = i2;
            c.a().d(new aq(61));
        }
    }
}
