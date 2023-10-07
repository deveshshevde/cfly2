package com.flypro.core.drone;

import android.content.Context;
import com.MAVLink.common.msg_heartbeat;
import com.flypro.core.MAVLink.WaypointManager;
import com.flypro.core.MAVLink.a;
import com.flypro.core.drone.DroneInterfaces;
import com.flypro.core.drone.variables.GuidedPoint;
import com.flypro.core.drone.variables.HeartBeat;
import com.flypro.core.drone.variables.ListenerData;
import com.flypro.core.drone.variables.aa;
import com.flypro.core.drone.variables.ab;
import com.flypro.core.drone.variables.ac;
import com.flypro.core.drone.variables.ad;
import com.flypro.core.drone.variables.ae;
import com.flypro.core.drone.variables.af;
import com.flypro.core.drone.variables.d;
import com.flypro.core.drone.variables.e;
import com.flypro.core.drone.variables.f;
import com.flypro.core.drone.variables.g;
import com.flypro.core.drone.variables.h;
import com.flypro.core.drone.variables.i;
import com.flypro.core.drone.variables.j;
import com.flypro.core.drone.variables.k;
import com.flypro.core.drone.variables.l;
import com.flypro.core.drone.variables.m;
import com.flypro.core.drone.variables.n;
import com.flypro.core.drone.variables.o;
import com.flypro.core.drone.variables.p;
import com.flypro.core.drone.variables.q;
import com.flypro.core.drone.variables.r;
import com.flypro.core.drone.variables.s;
import com.flypro.core.drone.variables.t;
import com.flypro.core.drone.variables.u;
import com.flypro.core.drone.variables.v;
import com.flypro.core.drone.variables.w;
import com.flypro.core.drone.variables.x;
import com.flypro.core.drone.variables.y;
import com.flypro.core.drone.variables.z;
import com.flypro.core.firmware.FirmwareType;
import dz.b;
import en.a;

public class c implements a {
    private final aa A;
    private final HeartBeat B;
    private final dz.a C;
    private final k D;
    private final z E;
    private final af F;
    private final u G;
    private final h H;
    private final o I;
    private final n J;
    private final ae K;
    private final i L;
    private String M;
    private final a N;
    private final ListenerData O;
    private final f P;
    private final g Q;
    private final g R;
    private final a.C0089a S;
    private final e T;

    /* renamed from: a  reason: collision with root package name */
    private final b f11531a;

    /* renamed from: b  reason: collision with root package name */
    private final ad f11532b = new ad(this);

    /* renamed from: c  reason: collision with root package name */
    private b f11533c;

    /* renamed from: d  reason: collision with root package name */
    private final j f11534d = new j(this);

    /* renamed from: e  reason: collision with root package name */
    private final s f11535e = new s(this);

    /* renamed from: f  reason: collision with root package name */
    private final y f11536f = new y(this);

    /* renamed from: g  reason: collision with root package name */
    private final com.flypro.core.drone.variables.b f11537g = new com.flypro.core.drone.variables.b(this);

    /* renamed from: h  reason: collision with root package name */
    private final t f11538h = new t(this);

    /* renamed from: i  reason: collision with root package name */
    private final l f11539i;

    /* renamed from: j  reason: collision with root package name */
    private final com.flypro.core.mission.a f11540j;

    /* renamed from: k  reason: collision with root package name */
    private final p f11541k;

    /* renamed from: l  reason: collision with root package name */
    private final ac f11542l;

    /* renamed from: m  reason: collision with root package name */
    private final com.flypro.core.drone.variables.a f11543m;

    /* renamed from: n  reason: collision with root package name */
    private final r f11544n;

    /* renamed from: o  reason: collision with root package name */
    private final q f11545o;

    /* renamed from: p  reason: collision with root package name */
    private final GuidedPoint f11546p;

    /* renamed from: q  reason: collision with root package name */
    private final com.flypro.core.drone.variables.c f11547q;

    /* renamed from: r  reason: collision with root package name */
    private final WaypointManager f11548r;

    /* renamed from: s  reason: collision with root package name */
    private final m f11549s;

    /* renamed from: t  reason: collision with root package name */
    private final e f11550t;

    /* renamed from: u  reason: collision with root package name */
    private final ab f11551u;

    /* renamed from: v  reason: collision with root package name */
    private final eb.a f11552v;

    /* renamed from: w  reason: collision with root package name */
    private final v f11553w;

    /* renamed from: x  reason: collision with root package name */
    private final x f11554x;

    /* renamed from: y  reason: collision with root package name */
    private final w f11555y;

    /* renamed from: z  reason: collision with root package name */
    private final d f11556z;

    public c(Context context, a.C0089a aVar, DroneInterfaces.a aVar2, DroneInterfaces.b bVar, e eVar) {
        this.S = aVar;
        this.T = eVar;
        this.f11531a = new b(this, bVar);
        this.A = new aa(this, aVar2, bVar);
        this.B = new HeartBeat(this, bVar);
        this.C = new dz.a(this, bVar);
        this.f11539i = new l(this, context);
        this.f11540j = new com.flypro.core.mission.a(this);
        this.f11541k = new p(this);
        this.f11542l = new ac(this);
        this.f11543m = new com.flypro.core.drone.variables.a(this);
        this.f11544n = new r(this);
        this.f11545o = new q(this);
        this.f11546p = new GuidedPoint(this);
        this.f11547q = new com.flypro.core.drone.variables.c(this);
        this.f11548r = new WaypointManager(this);
        this.f11549s = new m(this);
        this.f11550t = new e(this);
        this.f11551u = new ab(this);
        this.f11552v = new eb.a(context, this);
        this.f11553w = new v(this);
        this.f11554x = new x(this);
        this.f11555y = new w(this);
        this.f11556z = new d(this);
        this.D = new k(this);
        this.E = new z(this);
        this.F = new af(this);
        this.G = new u(this);
        this.H = new h(this);
        this.I = new o(this);
        this.J = new n(this);
        this.K = new ae(this);
        this.L = new i(this);
        this.N = new a(this);
        this.O = new ListenerData(this);
        this.P = new f(this);
        this.Q = new g(this);
        this.R = new g(this);
        h();
    }

    public String A() {
        return this.M;
    }

    public m B() {
        return this.f11549s;
    }

    public e C() {
        return this.f11550t;
    }

    public ab D() {
        return this.f11551u;
    }

    public v E() {
        return this.f11553w;
    }

    public k F() {
        return this.D;
    }

    public z G() {
        return this.E;
    }

    public af H() {
        return this.F;
    }

    public u I() {
        return this.G;
    }

    public w J() {
        return this.f11555y;
    }

    public d K() {
        return this.f11556z;
    }

    public h L() {
        return this.H;
    }

    public o M() {
        return this.I;
    }

    public ae N() {
        return this.K;
    }

    public i O() {
        return this.L;
    }

    public a P() {
        return this.N;
    }

    public ListenerData Q() {
        return this.O;
    }

    public f R() {
        return this.P;
    }

    public g S() {
        return this.Q;
    }

    public g T() {
        return this.R;
    }

    public void a(double d2) {
        this.f11543m.b(d2);
        com.flypro.core.util.a.a().l();
        org.greenrobot.eventbus.c.a().d(new dy.x(12));
    }

    public void a(double d2, double d3, double d4) {
        this.f11541k.a(d2);
        this.f11543m.c(d3);
        this.f11536f.a(d4);
        a(DroneInterfaces.DroneEventsType.ORIENTATION);
    }

    public void a(int i2) {
        this.f11532b.a(i2);
    }

    public void a(msg_heartbeat msg_heartbeat) {
        this.B.a(msg_heartbeat);
    }

    public void a(DroneInterfaces.DroneEventsType droneEventsType) {
        this.f11531a.a(droneEventsType);
    }

    public void a(DroneInterfaces.c cVar) {
        this.f11531a.a(cVar);
    }

    public void a(String str) {
        this.f11532b.a(str);
    }

    public boolean a() {
        return this.B.b();
    }

    public j b() {
        return this.f11534d;
    }

    public void b(DroneInterfaces.c cVar) {
        this.f11531a.b(cVar);
    }

    public void b(String str) {
        this.M = str;
    }

    public int c() {
        return this.B.a();
    }

    public aa d() {
        return this.A;
    }

    public dz.a e() {
        return this.C;
    }

    public int f() {
        return this.f11532b.a();
    }

    public FirmwareType g() {
        return this.f11532b.b();
    }

    public void h() {
        this.f11533c = this.T.a(g());
    }

    public b i() {
        return this.f11533c;
    }

    public a.C0089a j() {
        return this.S;
    }

    public e k() {
        return this.T;
    }

    public WaypointManager l() {
        return this.f11548r;
    }

    public s m() {
        return this.f11535e;
    }

    public y n() {
        return this.f11536f;
    }

    public com.flypro.core.drone.variables.b o() {
        return this.f11537g;
    }

    public t p() {
        return this.f11538h;
    }

    public l q() {
        return this.f11539i;
    }

    public com.flypro.core.mission.a r() {
        return this.f11540j;
    }

    public p s() {
        return this.f11541k;
    }

    public com.flypro.core.drone.variables.a t() {
        return this.f11543m;
    }

    public r u() {
        return this.f11544n;
    }

    public q v() {
        return this.f11545o;
    }

    public GuidedPoint w() {
        return this.f11546p;
    }

    public com.flypro.core.drone.variables.c x() {
        return this.f11547q;
    }

    public String y() {
        return this.f11532b.c();
    }

    public double z() {
        return (this.f11532b.c() != null && this.f11532b.c().length() >= 5) ? Double.parseDouble(this.f11532b.c().substring(this.f11532b.c().indexOf("v") + 1, this.f11532b.c().indexOf("v") + 4)) : fg.i.f27244a;
    }
}
