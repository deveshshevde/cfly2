package com.flypro.core.drone.variables;

import android.util.Log;
import com.flypro.core.drone.d;
import ef.a;
import fg.i;
import java.io.Serializable;

public class ListenerData extends d implements Serializable {
    private static final long serialVersionUID = -8740885025023609033L;
    private int A;
    private String B;
    private double C;
    private double D;
    private double E;
    private double F;
    private double G;
    private double H;
    private double I;
    private double J;
    private double K;
    private double L;
    private double M;
    private double N;
    private double O;
    private double P;
    private int Q;
    private String R;
    private String S;
    private double T;
    private String U;
    private String V;

    /* renamed from: a  reason: collision with root package name */
    private String f14237a;

    /* renamed from: c  reason: collision with root package name */
    private int f14238c;

    /* renamed from: d  reason: collision with root package name */
    private double f14239d;

    /* renamed from: e  reason: collision with root package name */
    private int f14240e;

    /* renamed from: f  reason: collision with root package name */
    private double f14241f;

    /* renamed from: g  reason: collision with root package name */
    private double f14242g;

    /* renamed from: h  reason: collision with root package name */
    private double f14243h;

    /* renamed from: i  reason: collision with root package name */
    private a f14244i;

    /* renamed from: j  reason: collision with root package name */
    private a f14245j;

    /* renamed from: k  reason: collision with root package name */
    private double f14246k;

    /* renamed from: l  reason: collision with root package name */
    private String f14247l;

    /* renamed from: m  reason: collision with root package name */
    private double f14248m;

    /* renamed from: n  reason: collision with root package name */
    private double f14249n;

    /* renamed from: o  reason: collision with root package name */
    private double f14250o;

    /* renamed from: p  reason: collision with root package name */
    private int f14251p;

    /* renamed from: q  reason: collision with root package name */
    private int f14252q;

    /* renamed from: r  reason: collision with root package name */
    private int f14253r;

    /* renamed from: s  reason: collision with root package name */
    private int f14254s;

    /* renamed from: t  reason: collision with root package name */
    private int f14255t;

    /* renamed from: u  reason: collision with root package name */
    private int f14256u;

    /* renamed from: v  reason: collision with root package name */
    private int f14257v;

    /* renamed from: w  reason: collision with root package name */
    private int f14258w;

    /* renamed from: x  reason: collision with root package name */
    private int f14259x;

    /* renamed from: y  reason: collision with root package name */
    private int f14260y;

    /* renamed from: z  reason: collision with root package name */
    private int f14261z;

    public ListenerData(en.a aVar) {
        super(aVar);
        this.U = "-";
        this.V = "-";
        this.f14237a = "-";
        this.f14238c = -1;
        this.f14239d = -1.0d;
        this.f14240e = -1;
        this.f14241f = -1.0d;
        this.f14242g = -1.0d;
        this.f14243h = -1.0d;
        this.f14244i = new a(i.f27244a, i.f27244a);
        this.f14245j = new a(i.f27244a, i.f27244a);
        this.f14246k = -1.0d;
        this.f14247l = "-";
        this.f14248m = -1.0d;
        this.f14249n = -1.0d;
        this.f14250o = -1.0d;
        this.f14251p = -1;
        this.f14252q = -1;
        this.f14253r = -1;
        this.f14254s = -1;
        this.f14255t = -1;
        this.f14256u = -1;
        this.f14257v = -1;
        this.f14258w = -1;
        this.f14259x = -1;
        this.f14260y = -1;
        this.f14261z = -1;
        this.A = -1;
        this.B = "-";
        this.C = -1.0d;
        this.D = -1.0d;
        this.E = -1.0d;
        this.F = -1.0d;
        this.G = -1.0d;
        this.H = -1.0d;
        this.I = -1.0d;
        this.J = -1.0d;
        this.K = -1.0d;
        this.L = -1.0d;
        this.M = -1.0d;
        this.N = -1.0d;
        this.O = -1.0d;
        this.P = -1.0d;
        this.Q = -1;
        this.R = "-";
        this.S = "-";
        this.T = -1.0d;
    }

    public ListenerData(en.a aVar, ListenerData listenerData) {
        super(aVar);
        String str = "-";
        this.U = str;
        this.V = str;
        this.f14237a = listenerData.f14237a;
        this.f14238c = listenerData.f14238c;
        this.f14239d = listenerData.f14239d;
        this.f14240e = listenerData.f14240e;
        this.f14241f = listenerData.f14241f;
        this.f14242g = listenerData.f14242g;
        this.f14243h = listenerData.f14243h;
        this.f14244i = listenerData.f14244i;
        this.f14245j = listenerData.f14245j;
        this.f14246k = listenerData.f14246k;
        this.f14247l = listenerData.f14247l;
        this.f14248m = listenerData.f14248m;
        this.f14249n = listenerData.f14249n;
        this.f14250o = listenerData.f14250o;
        this.f14251p = listenerData.f14251p;
        this.f14252q = listenerData.f14252q;
        this.f14253r = listenerData.f14253r;
        this.f14254s = listenerData.f14254s;
        this.f14255t = listenerData.f14255t;
        this.f14256u = listenerData.f14256u;
        this.f14257v = listenerData.f14257v;
        this.f14258w = listenerData.f14258w;
        this.f14259x = listenerData.f14259x;
        this.f14260y = listenerData.f14260y;
        this.f14261z = listenerData.f14261z;
        this.A = listenerData.A;
        this.C = listenerData.C;
        this.D = listenerData.D;
        this.E = listenerData.E;
        this.F = listenerData.F;
        this.G = listenerData.G;
        this.H = listenerData.H;
        this.I = listenerData.I;
        this.J = listenerData.J;
        this.K = listenerData.K;
        this.L = listenerData.L;
        this.M = listenerData.M;
        this.N = listenerData.N;
        this.O = listenerData.O;
        this.P = listenerData.P;
        this.Q = listenerData.Q;
        this.S = listenerData.S;
        this.T = listenerData.T;
        String str2 = listenerData.U;
        this.U = str2;
        this.V = listenerData.V;
        if (!str2.equals(listenerData.B)) {
            if (!listenerData.B.equals(str)) {
                listenerData.U = listenerData.A();
            }
            this.B = listenerData.A();
        } else {
            this.B = str;
        }
        if (!this.V.equals(listenerData.R)) {
            if (!listenerData.R.equals(str)) {
                listenerData.V = listenerData.Q();
            }
            str = listenerData.Q();
        }
        this.R = str;
    }

    public String A() {
        return this.B;
    }

    public double B() {
        return this.C;
    }

    public double C() {
        return this.D;
    }

    public double D() {
        return this.E;
    }

    public double E() {
        return this.F;
    }

    public double F() {
        return this.G;
    }

    public double G() {
        return this.H;
    }

    public double H() {
        return this.I;
    }

    public double I() {
        return this.J;
    }

    public double J() {
        return this.K;
    }

    public double K() {
        return this.L;
    }

    public double L() {
        return this.M;
    }

    public double M() {
        return this.N;
    }

    public double N() {
        return this.O;
    }

    public double O() {
        return this.P;
    }

    public int P() {
        return this.Q;
    }

    public String Q() {
        Log.i("ListenerData", "getError_msg: ===" + this.R + "==last===" + this.V);
        return this.R;
    }

    public String R() {
        if (this.S.contains("null")) {
            this.S = "-";
        }
        return this.S;
    }

    public double S() {
        return this.T;
    }

    public String a() {
        return this.f14237a;
    }

    public void a(double d2) {
        this.f14239d = d2;
    }

    public void a(int i2) {
        this.f14238c = i2;
    }

    public void a(a aVar) {
        this.f14244i = aVar;
    }

    public void a(String str) {
        this.f14237a = str;
    }

    public int b() {
        return this.f14238c;
    }

    public void b(double d2) {
        this.f14241f = d2;
    }

    public void b(int i2) {
        this.f14240e = i2;
    }

    public void b(a aVar) {
        this.f14245j = aVar;
    }

    public void b(String str) {
        this.f14247l = str;
    }

    public double c() {
        return this.f14239d;
    }

    public void c(double d2) {
        this.f14242g = d2;
    }

    public void c(int i2) {
        this.f14251p = i2;
    }

    public void c(String str) {
        this.B = str;
    }

    public int d() {
        return this.f14240e;
    }

    public void d(double d2) {
        this.f14243h = d2;
    }

    public void d(int i2) {
        this.f14252q = i2;
    }

    public void d(String str) {
        this.R = str;
    }

    public double e() {
        return this.f14241f;
    }

    public void e(double d2) {
        this.f14246k = d2;
    }

    public void e(int i2) {
        this.f14253r = i2;
    }

    public void e(String str) {
        this.S = str;
    }

    public double f() {
        return this.f14242g;
    }

    public void f(double d2) {
        this.f14248m = d2;
    }

    public void f(int i2) {
        this.f14254s = i2;
    }

    public double g() {
        return this.f14243h;
    }

    public void g(double d2) {
        this.f14249n = d2;
    }

    public void g(int i2) {
        this.f14255t = i2;
    }

    public a h() {
        return this.f14244i;
    }

    public void h(double d2) {
        this.f14250o = d2;
    }

    public void h(int i2) {
        this.f14256u = i2;
    }

    public a i() {
        return this.f14245j;
    }

    public void i(double d2) {
        this.C = d2;
    }

    public void i(int i2) {
        this.f14257v = i2;
    }

    public double j() {
        return this.f14246k;
    }

    public void j(double d2) {
        this.D = d2;
    }

    public void j(int i2) {
        this.f14258w = i2;
    }

    public String k() {
        return this.f14247l;
    }

    public void k(double d2) {
        this.E = d2;
    }

    public void k(int i2) {
        this.f14259x = i2;
    }

    public double l() {
        return this.f14248m;
    }

    public void l(double d2) {
        this.F = d2;
    }

    public void l(int i2) {
        this.f14260y = i2;
    }

    public double m() {
        return this.f14249n;
    }

    public void m(double d2) {
        this.G = d2;
    }

    public void m(int i2) {
        this.f14261z = i2;
    }

    public double n() {
        return this.f14250o;
    }

    public void n(double d2) {
        this.H = d2;
    }

    public void n(int i2) {
        this.A = i2;
    }

    public int o() {
        return this.f14251p;
    }

    public void o(double d2) {
        this.I = d2;
    }

    public void o(int i2) {
        this.Q = i2;
    }

    public int p() {
        return this.f14252q;
    }

    public void p(double d2) {
        this.J = d2;
    }

    public int q() {
        return this.f14253r;
    }

    public void q(double d2) {
        this.K = d2;
    }

    public int r() {
        return this.f14254s;
    }

    public void r(double d2) {
        this.L = d2;
    }

    public int s() {
        return this.f14255t;
    }

    public void s(double d2) {
        this.M = d2;
    }

    public int t() {
        return this.f14256u;
    }

    public void t(double d2) {
        this.N = d2;
    }

    public String toString() {
        return "ListenerData{mode='" + this.f14237a + '\'' + ", satCount=" + this.f14238c + ", hdop=" + this.f14239d + ", bat_vol=" + this.f14240e + ", pitch=" + this.f14241f + ", roll=" + this.f14242g + ", yaw=" + this.f14243h + ", coord2D=" + this.f14244i + ", locCoord2D=" + this.f14245j + ", locHdop=" + this.f14246k + ", time='" + this.f14247l + '\'' + ", alt=" + this.f14248m + ", hs=" + this.f14249n + ", vs=" + this.f14250o + ", servo_in1=" + this.f14251p + ", servo_in2=" + this.f14252q + ", servo_in3=" + this.f14253r + ", servo_in4=" + this.f14254s + ", servo_in5=" + this.f14255t + ", servo_in6=" + this.f14256u + ", servo_in7=" + this.f14257v + ", servo_in8=" + this.f14258w + ", servo_out1=" + this.f14259x + ", servo_out2=" + this.f14260y + ", servo_out3=" + this.f14261z + ", servo_out4=" + this.A + ", droneMsg='" + this.B + '\'' + ", vibration_x=" + this.C + ", vibration_y=" + this.D + ", vibration_z=" + this.E + ", xacc=" + this.F + ", yacc=" + this.G + ", zacc=" + this.H + ", xgyro=" + this.I + ", ygyro=" + this.J + ", zgyro=" + this.K + ", xmag=" + this.L + ", ymag=" + this.M + ", zmag=" + this.N + ", pressureRaw=" + this.O + ", sonarRaw=" + this.P + ", flowState=" + this.Q + ", error_msg='" + this.R + '\'' + ", app_action='" + this.S + '\'' + '}';
    }

    public int u() {
        return this.f14257v;
    }

    public void u(double d2) {
        this.O = d2;
    }

    public int v() {
        return this.f14258w;
    }

    public void v(double d2) {
        this.P = d2;
    }

    public int w() {
        return this.f14259x;
    }

    public void w(double d2) {
        this.T = d2;
    }

    public int x() {
        return this.f14260y;
    }

    public int y() {
        return this.f14261z;
    }

    public int z() {
        return this.A;
    }
}
