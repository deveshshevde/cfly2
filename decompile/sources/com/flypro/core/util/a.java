package com.flypro.core.util;

import android.content.Context;
import android.content.Intent;
import com.flypro.core.database.UploadData;
import com.flypro.core.database.UserLiteHelper;
import com.flypro.core.drone.variables.ListenerData;
import com.xeagle.android.login.common.TimeUtil;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import ea.d;
import ea.e;
import ea.f;
import fg.i;
import io.reactivex.disposables.b;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private Intent f11610a;

    /* renamed from: b  reason: collision with root package name */
    private en.a f11611b;

    /* renamed from: c  reason: collision with root package name */
    private e f11612c;

    /* renamed from: d  reason: collision with root package name */
    private double f11613d;

    /* renamed from: e  reason: collision with root package name */
    private double f11614e;

    /* renamed from: f  reason: collision with root package name */
    private ef.a f11615f;

    /* renamed from: g  reason: collision with root package name */
    private ef.a f11616g;

    /* renamed from: h  reason: collision with root package name */
    private e f11617h;

    /* renamed from: i  reason: collision with root package name */
    private double f11618i;

    /* renamed from: j  reason: collision with root package name */
    private double f11619j;

    /* renamed from: k  reason: collision with root package name */
    private double f11620k;

    /* renamed from: l  reason: collision with root package name */
    private double f11621l;

    /* renamed from: m  reason: collision with root package name */
    private AtomicBoolean f11622m;

    /* renamed from: n  reason: collision with root package name */
    private String f11623n;

    /* renamed from: o  reason: collision with root package name */
    private UploadData f11624o;

    /* renamed from: p  reason: collision with root package name */
    private b f11625p;

    /* renamed from: com.flypro.core.util.a$a  reason: collision with other inner class name */
    public static final class C0103a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f14467a = new a();
    }

    private a() {
        this.f11613d = i.f27244a;
        this.f11614e = i.f27244a;
        this.f11615f = new ef.a(i.f27244a, i.f27244a);
        this.f11618i = i.f27244a;
        this.f11622m = new AtomicBoolean(false);
        this.f11623n = "-";
    }

    public static a a() {
        return C0103a.f14467a;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(int i2) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Context context, Long l2) throws Exception {
        d(context);
    }

    public static boolean d(en.a aVar) {
        return (aVar.y() != null && aVar.y().contains(UserGlobal.DRONE_TYPE_DF808_D)) || (aVar.y() != null && !aVar.y().contains(UserGlobal.DRONE_NAME_DF808)) || (aVar.y() != null && aVar.z() > 2.9d);
    }

    private void e(Context context) {
        String str = d.a("yyyy-MM-dd-HH-mm-ss", System.currentTimeMillis()) + ".txt";
        this.f11623n = str;
        this.f11624o.setDroneSn(this.f11611b.S().c());
        this.f11624o.setBatterySn(this.f11611b.T().c());
        this.f11624o.setFileName(str);
        f.a(d.c(context, str), a().b());
        f.a(d.c(context, str));
        UserLiteHelper.saveUploadInfo(this.f11624o);
    }

    private void m() {
        this.f11623n = "-";
        if (this.f11622m.get()) {
            UploadData uploadData = this.f11624o;
            uploadData.setFly_total_time(this.f11611b.d().n() + "");
            UploadData uploadData2 = this.f11624o;
            uploadData2.setMileage(a().d() + "");
            b bVar = this.f11625p;
            if (bVar != null) {
                bVar.dispose();
                this.f11625p = null;
            }
            this.f11623n = "-";
            this.f11622m.set(false);
        }
    }

    public void a(double d2) {
        this.f11613d = d2;
    }

    public void a(Context context) {
        if (this.f11610a == null) {
            Intent intent = new Intent(context, ListenerWriteService.class);
            this.f11610a = intent;
            intent.putExtra("TAG", ListenerWriteService.class.getSimpleName());
        }
        ListenerWriteService.a(context, this.f11610a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.MAVLink.common.msg_sonar_dug r9) {
        /*
            r8 = this;
            en.a r0 = r8.f11611b
            if (r0 != 0) goto L_0x0006
            goto L_0x00b2
        L_0x0006:
            boolean r0 = r8.c((en.a) r0)
            if (r0 == 0) goto L_0x00b2
            en.a r0 = r8.f11611b
            com.flypro.core.drone.variables.j r0 = r0.b()
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x00b2
            short r9 = r9.f7264i
            double r0 = (double) r9
            r8.f11614e = r0
            com.flypro.core.util.e r9 = r8.f11617h
            java.lang.String r9 = r9.i()
            java.lang.String r0 = "Ground"
            boolean r9 = r9.contains(r0)
            if (r9 == 0) goto L_0x0063
            double r0 = r8.f11614e
            r2 = 4654311885213007872(0x4097700000000000, double:1500.0)
            int r9 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r9 > 0) goto L_0x0043
            double r2 = r0 / r2
            r4 = 4598175219545276416(0x3fd0000000000000, double:0.25)
            double r2 = r2 * r4
            r4 = 4607632778762754458(0x3ff199999999999a, double:1.1)
            double r2 = r2 + r4
            goto L_0x0048
        L_0x0043:
            r2 = 4608758678669597082(0x3ff599999999999a, double:1.35)
        L_0x0048:
            double r0 = r0 * r2
            r8.f11614e = r0
            double r4 = r8.f11613d
            double r6 = r8.f11618i
            double r0 = r0 - r6
            double r0 = java.lang.Math.abs(r0)
            double r4 = r4 + r0
            r8.f11613d = r4
            double r0 = r8.f11614e
            int r9 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r9 >= 0) goto L_0x0071
            r4 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r2 = r2 * r4
            goto L_0x006e
        L_0x0063:
            double r0 = r8.f11613d
            double r2 = r8.f11614e
            double r4 = r8.f11618i
            double r2 = r2 - r4
            double r2 = java.lang.Math.abs(r2)
        L_0x006e:
            double r0 = r0 + r2
            r8.f11613d = r0
        L_0x0071:
            double r0 = r8.f11614e
            r8.f11618i = r0
            en.a r9 = r8.f11611b
            com.flypro.core.drone.variables.j r9 = r9.b()
            double r0 = r8.f11614e
            r9.a((double) r0)
            en.a r9 = r8.f11611b
            com.flypro.core.drone.variables.ListenerData r9 = r9.Q()
            double r0 = r8.f11614e
            r9.w(r0)
            en.a r9 = r8.f11611b
            com.flypro.core.drone.variables.j r9 = r9.b()
            if (r9 == 0) goto L_0x00b2
            en.a r9 = r8.f11611b
            com.flypro.core.drone.variables.j r9 = r9.b()
            ef.a r9 = r9.b()
            if (r9 == 0) goto L_0x00b2
            en.a r9 = r8.f11611b
            com.flypro.core.drone.variables.ListenerData r9 = r9.Q()
            en.a r0 = r8.f11611b
            com.flypro.core.drone.variables.j r0 = r0.b()
            ef.a r0 = r0.b()
            r9.a((ef.a) r0)
        L_0x00b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flypro.core.util.a.a(com.MAVLink.common.msg_sonar_dug):void");
    }

    public void a(e eVar) {
        this.f11617h = eVar;
    }

    public void a(e eVar) {
        if (this.f11612c != eVar) {
            this.f11612c = eVar;
        }
    }

    public void a(en.a aVar) {
        this.f11611b = aVar;
    }

    public e b() {
        e eVar = this.f11612c;
        return eVar == null ? new e() : eVar;
    }

    public void b(Context context) {
        m();
        Intent intent = this.f11610a;
        if (intent != null) {
            context.stopService(intent);
            this.f11610a = null;
        }
    }

    public boolean b(en.a aVar) {
        return aVar.y() != null && aVar.y().contains(UserGlobal.DRONE_TYPE_DF808) && !aVar.y().contains(UserGlobal.DRONE_TYPE_DF808_D) && aVar.z() < 3.7d;
    }

    public double c() {
        return this.f11614e;
    }

    public void c(Context context) {
        if (this.f11611b != null && this.f11623n.equalsIgnoreCase("-") && !this.f11622m.get()) {
            this.f11622m.set(true);
            this.f11624o = new UploadData();
            this.f11613d = i.f27244a;
            a().a((double) i.f27244a);
            this.f11624o.setFlying_off(d.a(TimeUtil.DEF_FORMAT, System.currentTimeMillis()));
            this.f11611b.d().k();
            e(context);
            if (this.f11625p == null) {
                this.f11625p = io.reactivex.f.a(240, 120, TimeUnit.MILLISECONDS).b(lz.a.b()).a(lu.a.a()).a(new lv.d(context) {
                    public final /* synthetic */ Context f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void accept(Object obj) {
                        a.this.a(this.f$1, (Long) obj);
                    }
                });
            }
        }
    }

    public boolean c(en.a aVar) {
        return aVar.y() != null && (aVar.y().contains(UserGlobal.DRONE_TYPE_DF808_D) || !aVar.y().contains(UserGlobal.DRONE_TYPE_DF808) || aVar.z() >= 3.7d);
    }

    public double d() {
        return this.f11613d;
    }

    public void d(Context context) {
        this.f11611b.Q().b(d.a("yyyy-MM-dd-HH:mm:ss", System.currentTimeMillis()));
        if (this.f11622m.get() && !this.f11623n.equalsIgnoreCase("-")) {
            UploadData uploadData = this.f11624o;
            uploadData.setFly_total_time(this.f11611b.d().n() + "");
            UploadData uploadData2 = this.f11624o;
            uploadData2.setMileage(a().d() + "");
            File c2 = d.c(context, this.f11623n);
            en.a aVar = this.f11611b;
            f.a(c2, new ListenerData(aVar, aVar.Q()));
            this.f11611b.Q().e("-");
            UserLiteHelper.updateUploadInfo(this.f11624o, $$Lambda$a$2a3LDgi5mXFx3Ybll6Aa_Vw_4.INSTANCE);
        }
    }

    public double e() {
        return this.f11619j;
    }

    public double f() {
        return this.f11620k;
    }

    public double g() {
        return this.f11621l;
    }

    public boolean h() {
        return this.f11622m.get();
    }

    public String i() {
        return this.f11623n;
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x01b8  */
    /* JADX WARNING: Removed duplicated region for block: B:57:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j() {
        /*
            r9 = this;
            en.a r0 = r9.f11611b
            r1 = 0
            if (r0 != 0) goto L_0x0011
            ef.a r0 = new ef.a
            r0.<init>(r1, r1)
        L_0x000b:
            r9.f11616g = r0
            r9.f11613d = r1
            goto L_0x01b4
        L_0x0011:
            com.flypro.core.drone.variables.j r0 = r0.b()
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x01ad
            en.a r0 = r9.f11611b
            com.flypro.core.drone.variables.ListenerData r0 = r0.Q()
            ef.a r0 = r0.i()
            double r3 = r0.d()
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x014d
            en.a r0 = r9.f11611b
            com.flypro.core.drone.variables.ListenerData r0 = r0.Q()
            ef.a r0 = r0.i()
            double r3 = r0.c()
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0041
            goto L_0x014d
        L_0x0041:
            org.greenrobot.eventbus.c r0 = org.greenrobot.eventbus.c.a()
            dy.ao r3 = new dy.ao
            en.a r4 = r9.f11611b
            com.flypro.core.drone.variables.ListenerData r4 = r4.Q()
            double r4 = r4.j()
            r3.<init>(r4)
            r0.d(r3)
            en.a r0 = r9.f11611b
            boolean r0 = r9.b((en.a) r0)
            if (r0 == 0) goto L_0x01b4
            en.a r0 = r9.f11611b
            com.flypro.core.drone.variables.ListenerData r0 = r0.Q()
            double r3 = r0.j()
            r5 = 4613937818241073152(0x4008000000000000, double:3.0)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 > 0) goto L_0x014c
            en.a r0 = r9.f11611b
            com.flypro.core.drone.variables.k r0 = r0.F()
            double r3 = r0.a()
            r5 = 4612811918334230528(0x4004000000000000, double:2.5)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x0081
            goto L_0x014c
        L_0x0081:
            ef.a r0 = new ef.a
            en.a r3 = r9.f11611b
            com.flypro.core.drone.variables.ListenerData r3 = r3.Q()
            ef.a r3 = r3.i()
            double r3 = r3.d()
            en.a r5 = r9.f11611b
            com.flypro.core.drone.variables.ListenerData r5 = r5.Q()
            ef.a r5 = r5.i()
            double r5 = r5.c()
            r0.<init>(r3, r5)
            en.a r3 = r9.f11611b
            com.flypro.core.drone.variables.j r3 = r3.b()
            ef.a r3 = r3.b()
            ej.c r0 = eg.a.c(r0, r3)
            double r3 = r0.a()
            r9.f11614e = r3
            com.flypro.core.util.e r0 = r9.f11617h
            java.lang.String r0 = r0.i()
            if (r0 == 0) goto L_0x0122
            com.flypro.core.util.e r0 = r9.f11617h
            java.lang.String r0 = r0.i()
            java.lang.String r3 = "Ground"
            boolean r0 = r0.contains(r3)
            if (r0 == 0) goto L_0x0122
            double r3 = r9.f11614e
            r5 = 4654311885213007872(0x4097700000000000, double:1500.0)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 > 0) goto L_0x00e4
            double r5 = r3 / r5
            r7 = 4598175219545276416(0x3fd0000000000000, double:0.25)
            double r5 = r5 * r7
            r7 = 4607632778762754458(0x3ff199999999999a, double:1.1)
            double r5 = r5 + r7
            goto L_0x00e9
        L_0x00e4:
            r5 = 4608758678669597082(0x3ff599999999999a, double:1.35)
        L_0x00e9:
            double r3 = r3 * r5
            r9.f11614e = r3
            ef.a r0 = r9.f11615f
            double r3 = r0.d()
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0101
            ef.a r0 = r9.f11615f
            double r3 = r0.c()
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0112
        L_0x0101:
            double r0 = r9.f11613d
            ef.a r2 = r9.f11615f
            ef.a r3 = r9.f11616g
            ej.c r2 = eg.a.c(r2, r3)
            double r2 = r2.a()
            double r0 = r0 + r2
            r9.f11613d = r0
        L_0x0112:
            double r0 = r9.f11613d
            double r2 = r9.f11614e
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L_0x0147
            r0 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r5 = r5 * r0
            double r2 = r2 + r5
            r9.f11613d = r2
            goto L_0x0147
        L_0x0122:
            ef.a r0 = r9.f11615f
            double r3 = r0.d()
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0136
            ef.a r0 = r9.f11615f
            double r3 = r0.c()
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0147
        L_0x0136:
            double r0 = r9.f11613d
            ef.a r2 = r9.f11615f
            ef.a r3 = r9.f11616g
            ej.c r2 = eg.a.c(r2, r3)
            double r2 = r2.a()
            double r0 = r0 + r2
            r9.f11613d = r0
        L_0x0147:
            ef.a r0 = r9.f11616g
            r9.f11615f = r0
            goto L_0x01b4
        L_0x014c:
            return
        L_0x014d:
            en.a r0 = r9.f11611b
            com.flypro.core.drone.variables.j r0 = r0.b()
            ef.a r0 = r0.b()
            r9.f11616g = r0
            en.a r0 = r9.f11611b
            java.lang.String r0 = r0.y()
            if (r0 == 0) goto L_0x01a3
            en.a r0 = r9.f11611b
            java.lang.String r0 = r0.y()
            java.lang.String r3 = "DF808"
            boolean r0 = r0.contains(r3)
            if (r0 == 0) goto L_0x01a3
            en.a r0 = r9.f11611b
            double r3 = r0.z()
            r5 = 4615514078110652826(0x400d99999999999a, double:3.7)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x01a3
            ef.a r0 = r9.f11615f
            double r3 = r0.d()
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0192
            ef.a r0 = r9.f11615f
            double r3 = r0.c()
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x01a3
        L_0x0192:
            double r3 = r9.f11613d
            ef.a r0 = r9.f11615f
            ef.a r5 = r9.f11616g
            ej.c r0 = eg.a.c(r0, r5)
            double r5 = r0.a()
            double r3 = r3 + r5
            r9.f11613d = r3
        L_0x01a3:
            en.a r0 = r9.f11611b
            com.flypro.core.drone.variables.j r0 = r0.b()
            r0.a((double) r1)
            goto L_0x01b4
        L_0x01ad:
            ef.a r0 = new ef.a
            r0.<init>(r1, r1)
            goto L_0x000b
        L_0x01b4:
            ef.a r0 = r9.f11616g
            if (r0 == 0) goto L_0x01c3
            en.a r0 = r9.f11611b
            com.flypro.core.drone.variables.ListenerData r0 = r0.Q()
            ef.a r1 = r9.f11616g
            r0.a((ef.a) r1)
        L_0x01c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flypro.core.util.a.j():void");
    }

    public void k() {
        double d2;
        en.a aVar = this.f11611b;
        if (aVar == null) {
            this.f11619j = -1.0d;
            this.f11620k = -1.0d;
            return;
        }
        if (aVar.G() == null) {
            d2 = i.f27244a;
            this.f11619j = i.f27244a;
        } else if (!this.f11611b.a()) {
            this.f11619j = -1.0d;
            this.f11620k = -1.0d;
            this.f11611b.Q().h(this.f11620k);
            this.f11611b.Q().g(this.f11619j);
        } else {
            this.f11619j = d(this.f11611b) ? this.f11611b.G().a() * 1.2d : this.f11611b.G().a();
            d2 = this.f11611b.G().b();
        }
        this.f11620k = d2;
        this.f11611b.Q().h(this.f11620k);
        this.f11611b.Q().g(this.f11619j);
    }

    public void l() {
        en.a aVar = this.f11611b;
        if (aVar == null) {
            this.f11621l = -1.0d;
            return;
        }
        if (aVar.t() == null || !this.f11611b.a()) {
            this.f11621l = -1.0d;
        } else {
            this.f11621l = this.f11611b.t().a() / 10.0d;
        }
        this.f11611b.Q().f(this.f11621l);
        this.f11611b.t().a(this.f11621l);
    }
}
