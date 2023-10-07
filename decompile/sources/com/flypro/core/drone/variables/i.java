package com.flypro.core.drone.variables;

import com.flypro.core.drone.d;
import dy.ac;
import en.a;
import java.util.Locale;
import org.greenrobot.eventbus.c;

public class i extends d {

    /* renamed from: a  reason: collision with root package name */
    private float f14344a;

    /* renamed from: c  reason: collision with root package name */
    private float f14345c;

    /* renamed from: d  reason: collision with root package name */
    private float f14346d;

    public i(a aVar) {
        super(aVar);
    }

    public float a() {
        return this.f14344a;
    }

    public void a(float f2, float f3, float f4) {
        if (this.f14344a != f2 || this.f14345c != f3 || this.f14346d != f4) {
            this.f14344a = f2;
            this.f14345c = f3;
            this.f14346d = f4;
            this.f11557b.Q().i(Double.parseDouble(String.format(Locale.US, "%.1f", new Object[]{Float.valueOf(f2)})));
            this.f11557b.Q().j(Double.parseDouble(String.format(Locale.US, "%.1f", new Object[]{Float.valueOf(f3)})));
            this.f11557b.Q().k(Double.parseDouble(String.format(Locale.US, "%.1f", new Object[]{Float.valueOf(f4)})));
            c.a().d(new ac(69));
        }
    }

    public float b() {
        return this.f14345c;
    }

    public float c() {
        return this.f14346d;
    }
}
