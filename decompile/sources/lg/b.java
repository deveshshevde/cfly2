package lg;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import li.a;

public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    private int f30817a;

    /* renamed from: b  reason: collision with root package name */
    private String f30818b;

    /* renamed from: c  reason: collision with root package name */
    private String f30819c;

    /* renamed from: d  reason: collision with root package name */
    private String f30820d;

    /* renamed from: e  reason: collision with root package name */
    private String f30821e;

    /* renamed from: f  reason: collision with root package name */
    private String f30822f;

    /* renamed from: g  reason: collision with root package name */
    private String f30823g;

    /* renamed from: h  reason: collision with root package name */
    private String f30824h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f30825i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f30826j;

    /* renamed from: k  reason: collision with root package name */
    private int f30827k;

    /* renamed from: l  reason: collision with root package name */
    private float f30828l;

    /* renamed from: m  reason: collision with root package name */
    private float f30829m;

    /* renamed from: n  reason: collision with root package name */
    private float f30830n;

    /* renamed from: o  reason: collision with root package name */
    private double f30831o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f30832p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f30833q;

    /* renamed from: r  reason: collision with root package name */
    private List<String> f30834r;

    public b(String str) {
        super(str);
    }

    public String a() {
        if (this.f30818b == null) {
            return "No Title";
        }
        if (!e()) {
            return this.f30818b;
        }
        return "* " + this.f30818b;
    }

    public void a(double d2) {
        this.f30831o = d2;
        try {
            this.f30824h = String.valueOf(d2);
        } catch (Exception e2) {
            this.f30824h = "0.0";
            e2.printStackTrace();
        }
    }

    public void a(int i2) {
        this.f30827k = i2;
    }

    public void a(String str) {
        this.f30818b = str;
    }

    public void a(boolean z2) {
        this.f30833q = z2;
    }

    public String b() {
        String str = this.f30819c;
        return str == null ? "" : str;
    }

    public void b(int i2) {
        this.f30817a = i2;
    }

    public void b(String str) {
        this.f30819c = str;
    }

    public void b(boolean z2) {
        this.f30832p = z2;
    }

    public String c() {
        return this.f30823g;
    }

    public void c(String str) {
        this.f30823g = str;
    }

    public void d(String str) {
        if (str != null) {
            this.f30825i = str.equalsIgnoreCase("yes");
        }
    }

    public boolean d() {
        return this.f30825i;
    }

    public void e(String str) {
        if (str != null) {
            this.f30826j = str.equalsIgnoreCase("yes");
        }
    }

    public boolean e() {
        return this.f30826j;
    }

    public float f() {
        return this.f30828l;
    }

    public void f(String str) {
        if (str != null) {
            try {
                this.f30828l = Float.parseFloat(str);
            } catch (NumberFormatException e2) {
                this.f30828l = 0.0f;
                e2.printStackTrace();
            }
        }
    }

    public float g() {
        return this.f30829m;
    }

    public void g(String str) {
        if (str != null) {
            try {
                this.f30829m = Float.parseFloat(str);
            } catch (NumberFormatException e2) {
                this.f30829m = 0.0f;
                e2.printStackTrace();
            }
        }
    }

    public float h() {
        return this.f30830n;
    }

    public void h(String str) {
        if (str != null) {
            try {
                this.f30830n = Float.parseFloat(str);
            } catch (NumberFormatException e2) {
                this.f30830n = 0.0f;
                e2.printStackTrace();
            }
        }
    }

    public int i() {
        return this.f30827k;
    }

    public void i(String str) {
        if (str != null) {
            try {
                this.f30827k = Integer.parseInt(str);
            } catch (NumberFormatException e2) {
                this.f30827k = -1;
                e2.printStackTrace();
            }
        }
    }

    public List<String> j() {
        return this.f30834r;
    }

    public void j(String str) {
        this.f30834r = null;
        if (str != null) {
            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(str.split("\\s*,\\s*")));
            this.f30834r = arrayList;
            for (String str2 : arrayList) {
                PrintStream printStream = System.out;
                printStream.println("option : " + str2);
            }
        }
    }

    public int k() {
        return this.f30817a;
    }

    public void k(String str) {
        if (str == null) {
            str = "";
        }
        this.f30820d = str;
    }

    public String l() {
        return this.f30820d;
    }

    public void l(String str) {
        this.f30821e = str;
    }

    public double m() {
        return this.f30831o;
    }

    public void m(String str) {
        this.f30822f = str;
    }

    public void n(String str) {
        this.f30824h = str;
    }

    public boolean n() {
        return this.f30833q;
    }

    public boolean o() {
        return this.f30832p;
    }

    public String p() {
        String str = this.f30824h;
        return str == null ? "" : str;
    }

    public float q() {
        String str = this.f30824h;
        if (str != null) {
            try {
                return Float.parseFloat(str);
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
            }
        }
        return 0.0f;
    }
}
