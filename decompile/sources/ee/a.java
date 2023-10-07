package ee;

import android.content.Context;
import aq.d;
import com.flypro.core.MAVLink.l;
import com.flypro.core.drone.DroneInterfaces;
import ed.a;
import fg.i;

public class a implements a.b {

    /* renamed from: a  reason: collision with root package name */
    public Runnable f26871a = new Runnable() {
        public void run() {
            a.this.d();
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private ed.a f26872b;

    /* renamed from: c  reason: collision with root package name */
    private long f26873c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f26874d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f26875e = true;

    /* renamed from: f  reason: collision with root package name */
    private double f26876f;

    /* renamed from: g  reason: collision with root package name */
    private double f26877g;

    /* renamed from: h  reason: collision with root package name */
    private en.a f26878h;

    /* renamed from: i  reason: collision with root package name */
    private DroneInterfaces.b f26879i;

    /* renamed from: j  reason: collision with root package name */
    private String f26880j;

    public a(DroneInterfaces.b bVar, en.a aVar, Context context) {
        this.f26879i = bVar;
        this.f26878h = aVar;
        d.a(context.getApplicationContext());
    }

    private double a(double d2) {
        return ((d2 < i.f27244a || d2 > 90.0d) && (d2 < 180.0d || d2 > 270.0d)) ? ((d2 <= 90.0d || d2 >= 180.0d) && (d2 <= 270.0d || d2 >= 360.0d)) ? i.f27244a : eg.a.c(270.0d - d2) : eg.a.c(90.0d - d2);
    }

    private void b() {
        if (!this.f26875e) {
            double d2 = this.f26872b.d();
            double c2 = eg.a.c(this.f26872b.c());
            this.f26877g += (this.f26872b.a().c() - this.f26877g) / 20.0d;
            this.f26876f += (this.f26872b.a().d() - this.f26876f) / 20.0d;
            ef.a a2 = eg.a.a(new ef.a(this.f26876f, this.f26877g), a(c2), d2 * 0.1d);
            l.a(this.f26878h, a2);
            this.f26876f = a2.d();
            this.f26877g = a2.c();
            return;
        }
        ef.a a3 = eg.a.a(this.f26872b.a(), a(this.f26872b.c()), this.f26872b.d() * 2.0d);
        l.a(this.f26878h, a3);
        this.f26876f = a3.d();
        this.f26877g = a3.c();
        this.f26875e = false;
    }

    private void c() {
        ed.a aVar = this.f26872b;
        if (aVar != null) {
            ef.a aVar2 = new ef.a(aVar.a().d(), this.f26872b.a().c());
            double c2 = this.f26872b.c();
            double d2 = this.f26872b.d();
            double currentTimeMillis = (double) (System.currentTimeMillis() - this.f26873c);
            Double.isNaN(currentTimeMillis);
            double d3 = (d2 * currentTimeMillis) / 1000.0d;
            ef.a a2 = eg.a.a(aVar2, c2, d3);
            if (d3 > i.f27244a) {
                l.a(this.f26878h, new ef.a(a2));
            }
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        if (this.f26880j.equals("Relate")) {
            b();
        } else {
            d.a("is_relate_key", false);
            c();
        }
        this.f26879i.postDelayed(this.f26871a, 500);
    }

    public void a() {
        this.f26879i.removeCallbacks(this.f26871a);
    }

    public void a(ed.a aVar) {
        this.f26880j = d.b("follow_type_key", "Relate");
        this.f26874d = d.b("is_relate_key", false);
        a();
        this.f26872b = aVar;
        this.f26873c = System.currentTimeMillis();
        d();
    }
}
