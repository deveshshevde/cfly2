package com.huantansheng.easyphotos.models.puzzle.slant;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.huantansheng.easyphotos.models.puzzle.Line;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class a implements com.huantansheng.easyphotos.models.puzzle.a {

    /* renamed from: a  reason: collision with root package name */
    b f20418a;

    /* renamed from: b  reason: collision with root package name */
    b f20419b;

    /* renamed from: c  reason: collision with root package name */
    b f20420c;

    /* renamed from: d  reason: collision with root package name */
    b f20421d;

    /* renamed from: e  reason: collision with root package name */
    CrossoverPointF f20422e;

    /* renamed from: f  reason: collision with root package name */
    CrossoverPointF f20423f;

    /* renamed from: g  reason: collision with root package name */
    CrossoverPointF f20424g;

    /* renamed from: h  reason: collision with root package name */
    CrossoverPointF f20425h;

    /* renamed from: i  reason: collision with root package name */
    private PointF f20426i;

    /* renamed from: j  reason: collision with root package name */
    private float f20427j;

    /* renamed from: k  reason: collision with root package name */
    private float f20428k;

    /* renamed from: l  reason: collision with root package name */
    private float f20429l;

    /* renamed from: m  reason: collision with root package name */
    private float f20430m;

    /* renamed from: n  reason: collision with root package name */
    private float f20431n;

    /* renamed from: o  reason: collision with root package name */
    private Path f20432o;

    /* renamed from: p  reason: collision with root package name */
    private RectF f20433p;

    /* renamed from: q  reason: collision with root package name */
    private PointF[] f20434q;

    /* renamed from: com.huantansheng.easyphotos.models.puzzle.slant.a$a  reason: collision with other inner class name */
    static class C0136a implements Comparator<a> {
        C0136a() {
        }

        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            if (aVar.f20422e.y < aVar2.f20422e.y) {
                return -1;
            }
            return (aVar.f20422e.y != aVar2.f20422e.y || aVar.f20422e.x >= aVar2.f20422e.x) ? 1 : -1;
        }
    }

    a() {
        this.f20432o = new Path();
        this.f20433p = new RectF();
        PointF[] pointFArr = new PointF[2];
        this.f20434q = pointFArr;
        pointFArr[0] = new PointF();
        this.f20434q[1] = new PointF();
        this.f20422e = new CrossoverPointF();
        this.f20423f = new CrossoverPointF();
        this.f20424g = new CrossoverPointF();
        this.f20425h = new CrossoverPointF();
        this.f20426i = new PointF();
    }

    a(a aVar) {
        this();
        this.f20418a = aVar.f20418a;
        this.f20419b = aVar.f20419b;
        this.f20420c = aVar.f20420c;
        this.f20421d = aVar.f20421d;
        this.f20422e = aVar.f20422e;
        this.f20423f = aVar.f20423f;
        this.f20424g = aVar.f20424g;
        this.f20425h = aVar.f20425h;
        m();
    }

    public float a() {
        return Math.min(this.f20422e.x, this.f20423f.x) + this.f20427j;
    }

    public void a(float f2) {
        this.f20431n = f2;
    }

    public void a(float f2, float f3, float f4, float f5) {
        this.f20427j = f2;
        this.f20428k = f3;
        this.f20429l = f4;
        this.f20430m = f5;
    }

    public boolean a(float f2, float f3) {
        return d.a(this, f2, f3);
    }

    public boolean a(Line line) {
        return this.f20418a == line || this.f20419b == line || this.f20420c == line || this.f20421d == line;
    }

    public float b() {
        return Math.min(this.f20422e.y, this.f20424g.y) + this.f20428k;
    }

    public void b(float f2) {
        a(f2, f2, f2, f2);
    }

    public PointF[] b(Line line) {
        PointF pointF;
        float f2;
        PointF pointF2;
        float f3;
        if (line == this.f20418a) {
            d.a(this.f20434q[0], this.f20422e, this.f20423f, line.g(), 0.25f);
            d.a(this.f20434q[1], this.f20422e, this.f20423f, line.g(), 0.75f);
            this.f20434q[0].offset(this.f20427j, 0.0f);
            pointF2 = this.f20434q[1];
            f3 = this.f20427j;
        } else {
            if (line == this.f20419b) {
                d.a(this.f20434q[0], this.f20422e, this.f20424g, line.g(), 0.25f);
                d.a(this.f20434q[1], this.f20422e, this.f20424g, line.g(), 0.75f);
                this.f20434q[0].offset(0.0f, this.f20428k);
                pointF = this.f20434q[1];
                f2 = this.f20428k;
            } else if (line == this.f20420c) {
                d.a(this.f20434q[0], this.f20424g, this.f20425h, line.g(), 0.25f);
                d.a(this.f20434q[1], this.f20424g, this.f20425h, line.g(), 0.75f);
                this.f20434q[0].offset(-this.f20429l, 0.0f);
                pointF2 = this.f20434q[1];
                f3 = -this.f20429l;
            } else {
                if (line == this.f20421d) {
                    d.a(this.f20434q[0], this.f20423f, this.f20425h, line.g(), 0.25f);
                    d.a(this.f20434q[1], this.f20423f, this.f20425h, line.g(), 0.75f);
                    this.f20434q[0].offset(0.0f, -this.f20430m);
                    pointF = this.f20434q[1];
                    f2 = -this.f20430m;
                }
                return this.f20434q;
            }
            pointF.offset(0.0f, f2);
            return this.f20434q;
        }
        pointF2.offset(f3, 0.0f);
        return this.f20434q;
    }

    public float c() {
        return Math.max(this.f20424g.x, this.f20425h.x) - this.f20429l;
    }

    public float d() {
        return Math.max(this.f20423f.y, this.f20425h.y) - this.f20430m;
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
        float f2;
        float f3;
        Path path;
        this.f20432o.reset();
        float f4 = this.f20431n;
        if (f4 > 0.0f) {
            d.a(this.f20426i, this.f20422e, this.f20423f, Line.Direction.VERTICAL, f4 / d.a((PointF) this.f20422e, (PointF) this.f20423f));
            this.f20426i.offset(this.f20427j, this.f20428k);
            this.f20432o.moveTo(this.f20426i.x, this.f20426i.y);
            float a2 = this.f20431n / d.a((PointF) this.f20422e, (PointF) this.f20424g);
            d.a(this.f20426i, this.f20422e, this.f20424g, Line.Direction.HORIZONTAL, a2);
            this.f20426i.offset(this.f20427j, this.f20428k);
            this.f20432o.quadTo(this.f20422e.x + this.f20427j, this.f20422e.y + this.f20428k, this.f20426i.x, this.f20426i.y);
            d.a(this.f20426i, this.f20422e, this.f20424g, Line.Direction.HORIZONTAL, 1.0f - a2);
            this.f20426i.offset(-this.f20429l, this.f20428k);
            this.f20432o.lineTo(this.f20426i.x, this.f20426i.y);
            float a3 = this.f20431n / d.a((PointF) this.f20424g, (PointF) this.f20425h);
            d.a(this.f20426i, this.f20424g, this.f20425h, Line.Direction.VERTICAL, a3);
            this.f20426i.offset(-this.f20429l, this.f20428k);
            this.f20432o.quadTo(this.f20424g.x - this.f20427j, this.f20424g.y + this.f20428k, this.f20426i.x, this.f20426i.y);
            d.a(this.f20426i, this.f20424g, this.f20425h, Line.Direction.VERTICAL, 1.0f - a3);
            this.f20426i.offset(-this.f20429l, -this.f20430m);
            this.f20432o.lineTo(this.f20426i.x, this.f20426i.y);
            float a4 = 1.0f - (this.f20431n / d.a((PointF) this.f20423f, (PointF) this.f20425h));
            d.a(this.f20426i, this.f20423f, this.f20425h, Line.Direction.HORIZONTAL, a4);
            this.f20426i.offset(-this.f20429l, -this.f20430m);
            this.f20432o.quadTo(this.f20425h.x - this.f20429l, this.f20425h.y - this.f20428k, this.f20426i.x, this.f20426i.y);
            d.a(this.f20426i, this.f20423f, this.f20425h, Line.Direction.HORIZONTAL, 1.0f - a4);
            this.f20426i.offset(this.f20427j, -this.f20430m);
            this.f20432o.lineTo(this.f20426i.x, this.f20426i.y);
            float a5 = 1.0f - (this.f20431n / d.a((PointF) this.f20422e, (PointF) this.f20423f));
            d.a(this.f20426i, this.f20422e, this.f20423f, Line.Direction.VERTICAL, a5);
            this.f20426i.offset(this.f20427j, -this.f20430m);
            this.f20432o.quadTo(this.f20423f.x + this.f20427j, this.f20423f.y - this.f20430m, this.f20426i.x, this.f20426i.y);
            d.a(this.f20426i, this.f20422e, this.f20423f, Line.Direction.VERTICAL, 1.0f - a5);
            this.f20426i.offset(this.f20427j, this.f20428k);
            path = this.f20432o;
            f3 = this.f20426i.x;
            f2 = this.f20426i.y;
        } else {
            this.f20432o.moveTo(this.f20422e.x + this.f20427j, this.f20422e.y + this.f20428k);
            this.f20432o.lineTo(this.f20424g.x - this.f20429l, this.f20424g.y + this.f20428k);
            this.f20432o.lineTo(this.f20425h.x - this.f20429l, this.f20425h.y - this.f20430m);
            this.f20432o.lineTo(this.f20423f.x + this.f20427j, this.f20423f.y - this.f20430m);
            path = this.f20432o;
            f3 = this.f20422e.x + this.f20427j;
            f2 = this.f20422e.y + this.f20428k;
        }
        path.lineTo(f3, f2);
        return this.f20432o;
    }

    public RectF i() {
        this.f20433p.set(a(), b(), c(), d());
        return this.f20433p;
    }

    public List<Line> j() {
        return Arrays.asList(new Line[]{this.f20418a, this.f20419b, this.f20420c, this.f20421d});
    }

    public float k() {
        return c() - a();
    }

    public float l() {
        return d() - b();
    }

    /* access modifiers changed from: package-private */
    public void m() {
        d.a(this.f20422e, this.f20418a, this.f20419b);
        d.a(this.f20423f, this.f20418a, this.f20421d);
        d.a(this.f20424g, this.f20420c, this.f20419b);
        d.a(this.f20425h, this.f20420c, this.f20421d);
    }
}
