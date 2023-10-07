package kf;

import com.xeagle.android.hicamera.unity.a;
import com.xeagle.android.hicamera.unity.c;
import com.xeagle.android.hicamera.unity.d;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.TreeMap;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f29992a;

    /* renamed from: b  reason: collision with root package name */
    public String f29993b = null;

    /* renamed from: c  reason: collision with root package name */
    public int f29994c;

    /* renamed from: d  reason: collision with root package name */
    public int f29995d;

    /* renamed from: e  reason: collision with root package name */
    public a.C0147a f29996e;

    /* renamed from: f  reason: collision with root package name */
    public a.b f29997f;

    /* renamed from: g  reason: collision with root package name */
    public a.c f29998g;

    /* renamed from: h  reason: collision with root package name */
    public c f29999h;

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f30000i;

    /* renamed from: j  reason: collision with root package name */
    private String f30001j;

    public a(String str) {
        a(str);
        this.f30001j = str;
        this.f29995d = 1;
        this.f29994c = 3;
        this.f29998g = null;
        this.f29996e = null;
        this.f29997f = new a.b();
        this.f29999h = new c();
        this.f30000i = false;
    }

    public int a(int i2) {
        return c.a(this.f29992a, i2);
    }

    public int a(int i2, int i3) {
        return c.a(this.f29992a, i2, i3);
    }

    public int a(String str, int i2) {
        return c.a(this.f29992a, str, i2);
    }

    public int a(Map<String, String> map) {
        return c.a(this.f29992a, map);
    }

    public int a(boolean z2) {
        return c.a(this.f29992a, z2);
    }

    public String a() {
        return this.f29992a;
    }

    public void a(String str) {
        this.f29992a = str;
    }

    public int b(int i2) {
        return c.b(this.f29992a, i2);
    }

    public int b(String str) {
        return c.a(this.f29992a, str);
    }

    public int b(Map<String, Integer> map) {
        return c.b(this.f29992a, map);
    }

    public int b(boolean z2) {
        return c.b(this.f29992a, z2);
    }

    public Boolean b() {
        return c.b(this.f29992a);
    }

    public int c() {
        return c.c(this.f29992a);
    }

    public int c(int i2) {
        return c.c(this.f29992a, i2);
    }

    public int c(String str) {
        return c.b(this.f29992a, str);
    }

    public int c(Map<String, String> map) {
        if (map == null) {
            map = new TreeMap<>();
        }
        d.a(this.f29992a, map);
        String str = map.get("sdstatus");
        return (str == null || !str.equals("1")) ? -1 : 0;
    }

    public int c(boolean z2) {
        return c.c(this.f29992a, z2);
    }

    public int d() {
        return c.d(this.f29992a);
    }

    public int d(boolean z2) {
        return c.d(this.f29992a, z2);
    }

    public int e() {
        return c.e(this.f29992a);
    }

    public String f() {
        return c.f(this.f29992a);
    }

    public Boolean g() {
        return c.g(this.f29992a);
    }

    public String h() {
        return c.h(this.f29992a);
    }

    public int i() {
        return c.a(this.f29992a, new GregorianCalendar());
    }

    public Boolean j() {
        return c.i(this.f29992a);
    }

    public Boolean k() {
        return c.j(this.f29992a);
    }

    public void l() {
        c.k(this.f29992a);
    }
}
