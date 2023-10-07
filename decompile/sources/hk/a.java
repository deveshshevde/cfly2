package hk;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.huantansheng.easyphotos.models.puzzle.Line;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class a implements com.huantansheng.easyphotos.models.puzzle.a {

    /* renamed from: a  reason: collision with root package name */
    b f13333a;

    /* renamed from: b  reason: collision with root package name */
    b f13334b;

    /* renamed from: c  reason: collision with root package name */
    b f13335c;

    /* renamed from: d  reason: collision with root package name */
    b f13336d;

    /* renamed from: e  reason: collision with root package name */
    private Path f13337e = new Path();

    /* renamed from: f  reason: collision with root package name */
    private RectF f13338f = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private PointF[] f13339g;

    /* renamed from: h  reason: collision with root package name */
    private float f13340h;

    /* renamed from: i  reason: collision with root package name */
    private float f13341i;

    /* renamed from: j  reason: collision with root package name */
    private float f13342j;

    /* renamed from: k  reason: collision with root package name */
    private float f13343k;

    /* renamed from: l  reason: collision with root package name */
    private float f13344l;

    /* renamed from: hk.a$a  reason: collision with other inner class name */
    static class C0096a implements Comparator<a> {
        C0096a() {
        }

        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            if (aVar.b() < aVar2.b()) {
                return -1;
            }
            return (aVar.b() != aVar2.b() || aVar.a() >= aVar2.a()) ? 1 : -1;
        }
    }

    a() {
        PointF[] pointFArr = new PointF[2];
        this.f13339g = pointFArr;
        pointFArr[0] = new PointF();
        this.f13339g[1] = new PointF();
    }

    a(a aVar) {
        PointF[] pointFArr = new PointF[2];
        this.f13339g = pointFArr;
        this.f13333a = aVar.f13333a;
        this.f13334b = aVar.f13334b;
        this.f13335c = aVar.f13335c;
        this.f13336d = aVar.f13336d;
        pointFArr[0] = new PointF();
        this.f13339g[1] = new PointF();
    }

    public float a() {
        return this.f13333a.i() + this.f13340h;
    }

    public void a(float f2) {
        this.f13344l = f2;
    }

    public void a(float f2, float f3, float f4, float f5) {
        this.f13340h = f2;
        this.f13341i = f3;
        this.f13342j = f4;
        this.f13343k = f5;
    }

    public boolean a(float f2, float f3) {
        return i().contains(f2, f3);
    }

    public boolean a(Line line) {
        return this.f13333a == line || this.f13334b == line || this.f13335c == line || this.f13336d == line;
    }

    public float b() {
        return this.f13334b.k() + this.f13341i;
    }

    public void b(float f2) {
        a(f2, f2, f2, f2);
    }

    public PointF[] b(Line line) {
        PointF pointF;
        float d2;
        if (line == this.f13333a) {
            this.f13339g[0].x = a();
            this.f13339g[0].y = b() + (l() / 4.0f);
            this.f13339g[1].x = a();
            pointF = this.f13339g[1];
        } else {
            if (line == this.f13334b) {
                this.f13339g[0].x = a() + (k() / 4.0f);
                this.f13339g[0].y = b();
                this.f13339g[1].x = a() + ((k() / 4.0f) * 3.0f);
                pointF = this.f13339g[1];
                d2 = b();
            } else if (line == this.f13335c) {
                this.f13339g[0].x = c();
                this.f13339g[0].y = b() + (l() / 4.0f);
                this.f13339g[1].x = c();
                pointF = this.f13339g[1];
            } else {
                if (line == this.f13336d) {
                    this.f13339g[0].x = a() + (k() / 4.0f);
                    this.f13339g[0].y = d();
                    this.f13339g[1].x = a() + ((k() / 4.0f) * 3.0f);
                    pointF = this.f13339g[1];
                    d2 = d();
                }
                return this.f13339g;
            }
            pointF.y = d2;
            return this.f13339g;
        }
        d2 = b() + ((l() / 4.0f) * 3.0f);
        pointF.y = d2;
        return this.f13339g;
    }

    public float c() {
        return this.f13335c.j() - this.f13342j;
    }

    public float d() {
        return this.f13336d.l() - this.f13343k;
    }

    public float e() {
        return (a() + c()) / 2.0f;
    }

    public float f() {
        return (b() + d()) / 2.0f;
    }

    public PointF g() {
        return new PointF(e(), f());
    }

    public Path h() {
        this.f13337e.reset();
        Path path = this.f13337e;
        RectF i2 = i();
        float f2 = this.f13344l;
        path.addRoundRect(i2, f2, f2, Path.Direction.CCW);
        return this.f13337e;
    }

    public RectF i() {
        this.f13338f.set(a(), b(), c(), d());
        return this.f13338f;
    }

    public List<Line> j() {
        return Arrays.asList(new Line[]{this.f13333a, this.f13334b, this.f13335c, this.f13336d});
    }

    public float k() {
        return c() - a();
    }

    public float l() {
        return d() - b();
    }
}
