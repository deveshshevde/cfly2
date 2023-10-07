package com.flypro.core.drone.variables;

import android.content.Context;
import android.util.Log;
import com.MAVLink.Messages.ApmModes;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.drone.d;
import dy.ad;
import dy.an;
import dy.ay;
import dy.h;
import dy.s;
import dy.y;
import dy.z;
import en.a;
import org.greenrobot.eventbus.c;

public class aa extends d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f11567a;

    /* renamed from: c  reason: collision with root package name */
    public DroneInterfaces.b f11568c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f11569d = new Runnable() {
        public void run() {
            aa.this.j();
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private String f11570e = "";

    /* renamed from: f  reason: collision with root package name */
    private int f11571f = -1;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11572g = false;

    /* renamed from: h  reason: collision with root package name */
    private String f11573h = "";

    /* renamed from: i  reason: collision with root package name */
    private ApmModes f11574i = ApmModes.UNKNOWN;

    /* renamed from: j  reason: collision with root package name */
    private boolean f11575j;

    /* renamed from: k  reason: collision with root package name */
    private String f11576k = "";

    /* renamed from: l  reason: collision with root package name */
    private long f11577l = 0;

    /* renamed from: m  reason: collision with root package name */
    private long f11578m = 0;

    /* renamed from: n  reason: collision with root package name */
    private long f11579n = 0;

    /* renamed from: o  reason: collision with root package name */
    private DroneInterfaces.a f11580o;

    /* renamed from: p  reason: collision with root package name */
    private int f11581p = 0;

    /* renamed from: q  reason: collision with root package name */
    private int f11582q = 0;

    public aa(a aVar, DroneInterfaces.a aVar2, DroneInterfaces.b bVar) {
        super(aVar);
        this.f11580o = aVar2;
        this.f11568c = bVar;
        k();
    }

    public long a() {
        return this.f11577l;
    }

    public void a(int i2) {
        c cVar;
        Object obj;
        if (this.f11571f != i2) {
            this.f11571f = i2;
            c.a().d(new h(9));
            if (i2 != 1) {
                if (this.f11574i == ApmModes.ROTOR_LAND) {
                    if (this.f11567a && this.f11557b.E().a() != 1) {
                        cVar = c.a();
                        obj = new an(54);
                    } else if (!this.f11567a && this.f11557b.E().a() != 1) {
                        cVar = c.a();
                        obj = new an(54);
                    } else {
                        return;
                    }
                } else if (this.f11574i == ApmModes.ROTOR_RTL && this.f11557b.E().a() != 1) {
                    cVar = c.a();
                    obj = new ay(54);
                } else {
                    return;
                }
                cVar.d(obj);
            }
        }
    }

    public void a(long j2) {
        this.f11577l = j2;
    }

    public void a(Context context, ej.a aVar) {
        this.f11557b.w().a(context, aVar);
    }

    public void a(ApmModes apmModes) {
        if (this.f11574i != apmModes) {
            this.f11574i = apmModes;
            this.f11557b.Q().a(apmModes.b());
            c.a().d(new s(4));
        }
    }

    public void a(String str) {
        if (this.f11573h.equals(str)) {
            int i2 = this.f11581p + 1;
            this.f11581p = i2;
            if (i2 == 15) {
                this.f11573h = str;
                c.a().d(new z(53));
                this.f11581p = 0;
                return;
            }
            return;
        }
        this.f11581p = 0;
        this.f11573h = str;
        c.a().d(new z(53));
    }

    public void a(boolean z2) {
        this.f11575j = z2;
    }

    public void b(ApmModes apmModes) {
        if (ApmModes.a(apmModes)) {
            Log.i("TAG", "changeFlightMode: ====" + apmModes.b());
            com.flypro.core.MAVLink.h.a(this.f11557b, apmModes);
        }
    }

    public void b(String str) {
        this.f11576k = str;
    }

    public void b(boolean z2) {
        if (z2 != this.f11572g) {
            this.f11572g = z2;
            c.a().d(new y(2));
            if (this.f11572g) {
                l();
            } else {
                m();
            }
        }
    }

    public boolean b() {
        return !this.f11570e.equals("");
    }

    public void c(String str) {
        this.f11570e = str;
        c.a().d(new ad(19, true));
        if (!this.f11557b.Q().Q().equalsIgnoreCase(str)) {
            this.f11557b.Q().d(str);
        }
    }

    public boolean c() {
        return this.f11571f == 1;
    }

    public void d(String str) {
        if (!this.f11570e.equals(str)) {
            this.f11582q = 0;
            this.f11570e = str;
            c.a().d(new ad(19, false));
            this.f11557b.Q().d(str);
            return;
        }
        int i2 = this.f11582q + 1;
        this.f11582q = i2;
        if (i2 == 12) {
            this.f11570e = str;
            c.a().d(new ad(19, false));
            this.f11557b.Q().d(str);
            this.f11582q = 0;
        }
    }

    public boolean d() {
        return this.f11572g;
    }

    public ApmModes e() {
        return this.f11574i;
    }

    public String f() {
        return this.f11570e;
    }

    public String g() {
        return this.f11573h;
    }

    public String h() {
        return this.f11576k;
    }

    public boolean i() {
        return this.f11575j;
    }

    /* access modifiers changed from: protected */
    public void j() {
        d("");
        this.f11557b.Q().d("");
    }

    public void k() {
        this.f11579n = 0;
        this.f11578m = this.f11580o.a();
    }

    public void l() {
        this.f11578m = this.f11580o.a();
    }

    public void m() {
        this.f11579n += this.f11580o.a() - this.f11578m;
        this.f11578m = this.f11580o.a();
    }

    public long n() {
        if (c()) {
            this.f11579n += this.f11580o.a() - this.f11578m;
            this.f11578m = this.f11580o.a();
        }
        return this.f11579n / 1000;
    }
}
