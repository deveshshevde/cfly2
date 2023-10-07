package com.huantansheng.easyphotos.models.puzzle.slant;

import android.graphics.PointF;
import com.huantansheng.easyphotos.models.puzzle.Line;

class b implements Line {

    /* renamed from: a  reason: collision with root package name */
    CrossoverPointF f20435a;

    /* renamed from: b  reason: collision with root package name */
    CrossoverPointF f20436b;

    /* renamed from: c  reason: collision with root package name */
    public final Line.Direction f20437c;

    /* renamed from: d  reason: collision with root package name */
    b f20438d;

    /* renamed from: e  reason: collision with root package name */
    b f20439e;

    /* renamed from: f  reason: collision with root package name */
    Line f20440f;

    /* renamed from: g  reason: collision with root package name */
    Line f20441g;

    /* renamed from: h  reason: collision with root package name */
    private PointF f20442h = new PointF();

    /* renamed from: i  reason: collision with root package name */
    private PointF f20443i = new PointF();

    b(Line.Direction direction) {
        this.f20437c = direction;
    }

    b(CrossoverPointF crossoverPointF, CrossoverPointF crossoverPointF2, Line.Direction direction) {
        this.f20435a = crossoverPointF;
        this.f20436b = crossoverPointF2;
        this.f20437c = direction;
    }

    public PointF a() {
        return this.f20435a;
    }

    public void a(Line line) {
        this.f20441g = line;
    }

    public boolean a(float f2, float f3) {
        if (this.f20437c == Line.Direction.HORIZONTAL) {
            if (this.f20442h.y + f2 < this.f20441g.l() + f3 || this.f20442h.y + f2 > this.f20440f.k() - f3 || this.f20443i.y + f2 < this.f20441g.l() + f3 || this.f20443i.y + f2 > this.f20440f.k() - f3) {
                return false;
            }
            this.f20435a.y = this.f20442h.y + f2;
            this.f20436b.y = this.f20443i.y + f2;
            return true;
        } else if (this.f20442h.x + f2 < this.f20441g.j() + f3 || this.f20442h.x + f2 > this.f20440f.i() - f3 || this.f20443i.x + f2 < this.f20441g.j() + f3 || this.f20443i.x + f2 > this.f20440f.i() - f3) {
            return false;
        } else {
            this.f20435a.x = this.f20442h.x + f2;
            this.f20436b.x = this.f20443i.x + f2;
            return true;
        }
    }

    public boolean a(float f2, float f3, float f4) {
        return d.a(this, f2, f3, f4);
    }

    public PointF b() {
        return this.f20436b;
    }

    public void b(float f2, float f3) {
        d.a(this.f20435a, this, this.f20438d);
        d.a(this.f20436b, this, this.f20439e);
    }

    public void b(Line line) {
        this.f20440f = line;
    }

    public Line c() {
        return this.f20441g;
    }

    public Line d() {
        return this.f20440f;
    }

    public Line e() {
        return this.f20438d;
    }

    public Line f() {
        return this.f20439e;
    }

    public Line.Direction g() {
        return this.f20437c;
    }

    public void h() {
        this.f20442h.set(this.f20435a);
        this.f20443i.set(this.f20436b);
    }

    public float i() {
        return Math.min(this.f20435a.x, this.f20436b.x);
    }

    public float j() {
        return Math.max(this.f20435a.x, this.f20436b.x);
    }

    public float k() {
        return Math.min(this.f20435a.y, this.f20436b.y);
    }

    public float l() {
        return Math.max(this.f20435a.y, this.f20436b.y);
    }

    public String toString() {
        return "start --> " + this.f20435a.toString() + ",end --> " + this.f20436b.toString();
    }
}
