package com.huantansheng.easyphotos.models.puzzle.slant;

import android.graphics.RectF;
import android.util.Pair;
import com.huantansheng.easyphotos.models.puzzle.Line;
import com.huantansheng.easyphotos.models.puzzle.c;
import com.huantansheng.easyphotos.models.puzzle.slant.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class c implements com.huantansheng.easyphotos.models.puzzle.c {

    /* renamed from: a  reason: collision with root package name */
    private RectF f20444a;

    /* renamed from: b  reason: collision with root package name */
    private a f20445b;

    /* renamed from: c  reason: collision with root package name */
    private List<Line> f20446c = new ArrayList(4);

    /* renamed from: d  reason: collision with root package name */
    private List<a> f20447d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private List<Line> f20448e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private float f20449f;

    /* renamed from: g  reason: collision with root package name */
    private float f20450g;

    /* renamed from: h  reason: collision with root package name */
    private int f20451h;

    /* renamed from: i  reason: collision with root package name */
    private Comparator<a> f20452i = new a.C0136a();

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<c.a> f20453j = new ArrayList<>();

    protected c() {
    }

    private void a(Line line) {
        int size = this.f20448e.size();
        for (int i2 = 0; i2 < size; i2++) {
            Line line2 = this.f20448e.get(i2);
            if (line2.g() == line.g() && line2.e() == line.e() && line2.f() == line.f() && (line2.g() != Line.Direction.HORIZONTAL ? !(line2.i() <= line.c().j() || line2.j() >= line.i()) : !(line2.k() <= line.c().l() || line2.l() >= line.k()))) {
                line.a(line2);
            }
        }
    }

    private void b(Line line) {
        int size = this.f20448e.size();
        for (int i2 = 0; i2 < size; i2++) {
            Line line2 = this.f20448e.get(i2);
            if (line2.g() == line.g() && line2.e() == line.e() && line2.f() == line.f() && (line2.g() != Line.Direction.HORIZONTAL ? !(line2.j() >= line.d().i() || line2.i() <= line.j()) : !(line2.l() >= line.d().k() || line2.k() <= line.l()))) {
                line.b(line2);
            }
        }
    }

    private void i() {
        int size = this.f20448e.size();
        for (int i2 = 0; i2 < size; i2++) {
            Line line = this.f20448e.get(i2);
            b(line);
            a(line);
        }
    }

    private void j() {
        Collections.sort(this.f20447d, this.f20452i);
    }

    /* access modifiers changed from: protected */
    public List<a> a(int i2, Line.Direction direction, float f2) {
        return a(i2, direction, f2, f2);
    }

    /* access modifiers changed from: protected */
    public List<a> a(int i2, Line.Direction direction, float f2, float f3) {
        a aVar = this.f20447d.get(i2);
        this.f20447d.remove(aVar);
        b a2 = d.a(aVar, direction, f2, f3);
        this.f20448e.add(a2);
        List<a> a3 = d.a(aVar, a2);
        this.f20447d.addAll(a3);
        i();
        j();
        c.a aVar2 = new c.a();
        int i3 = 0;
        aVar2.f20383a = 0;
        if (direction != Line.Direction.HORIZONTAL) {
            i3 = 1;
        }
        aVar2.f20384b = i3;
        aVar2.f20385c = i2;
        this.f20453j.add(aVar2);
        return a3;
    }

    public void a(float f2) {
        this.f20449f = f2;
        for (a b2 : this.f20447d) {
            b2.b(f2);
        }
        this.f20445b.f20418a.a().set(this.f20444a.left + f2, this.f20444a.top + f2);
        this.f20445b.f20418a.b().set(this.f20444a.left + f2, this.f20444a.bottom - f2);
        this.f20445b.f20420c.a().set(this.f20444a.right - f2, this.f20444a.top + f2);
        this.f20445b.f20420c.b().set(this.f20444a.right - f2, this.f20444a.bottom - f2);
        this.f20445b.m();
        e();
    }

    /* access modifiers changed from: protected */
    public void a(int i2, float f2, float f3, float f4, float f5) {
        a aVar = this.f20447d.get(i2);
        this.f20447d.remove(aVar);
        b a2 = d.a(aVar, Line.Direction.HORIZONTAL, f2, f3);
        b a3 = d.a(aVar, Line.Direction.VERTICAL, f4, f5);
        this.f20448e.add(a2);
        this.f20448e.add(a3);
        this.f20447d.addAll(d.a(aVar, a2, a3));
        j();
        c.a aVar2 = new c.a();
        aVar2.f20383a = 1;
        aVar2.f20385c = i2;
        this.f20453j.add(aVar2);
    }

    /* access modifiers changed from: protected */
    public void a(int i2, int i3, int i4) {
        a aVar = this.f20447d.get(i2);
        this.f20447d.remove(aVar);
        Pair<List<b>, List<a>> a2 = d.a(aVar, i3, i4);
        this.f20448e.addAll((Collection) a2.first);
        this.f20447d.addAll((Collection) a2.second);
        i();
        j();
        c.a aVar2 = new c.a();
        aVar2.f20383a = 2;
        aVar2.f20385c = i2;
        aVar2.f20387e = i3;
        aVar2.f20388f = i4;
        this.f20453j.add(aVar2);
    }

    public void a(RectF rectF) {
        f();
        this.f20444a = rectF;
        CrossoverPointF crossoverPointF = new CrossoverPointF(rectF.left, rectF.top);
        CrossoverPointF crossoverPointF2 = new CrossoverPointF(rectF.right, rectF.top);
        CrossoverPointF crossoverPointF3 = new CrossoverPointF(rectF.left, rectF.bottom);
        CrossoverPointF crossoverPointF4 = new CrossoverPointF(rectF.right, rectF.bottom);
        b bVar = new b(crossoverPointF, crossoverPointF3, Line.Direction.VERTICAL);
        b bVar2 = new b(crossoverPointF, crossoverPointF2, Line.Direction.HORIZONTAL);
        b bVar3 = new b(crossoverPointF2, crossoverPointF4, Line.Direction.VERTICAL);
        b bVar4 = new b(crossoverPointF3, crossoverPointF4, Line.Direction.HORIZONTAL);
        this.f20446c.clear();
        this.f20446c.add(bVar);
        this.f20446c.add(bVar2);
        this.f20446c.add(bVar3);
        this.f20446c.add(bVar4);
        a aVar = new a();
        this.f20445b = aVar;
        aVar.f20418a = bVar;
        this.f20445b.f20419b = bVar2;
        this.f20445b.f20420c = bVar3;
        this.f20445b.f20421d = bVar4;
        this.f20445b.m();
        this.f20447d.clear();
        this.f20447d.add(this.f20445b);
    }

    public int b() {
        return this.f20447d.size();
    }

    public void b(float f2) {
        this.f20450g = f2;
        for (a a2 : this.f20447d) {
            a2.a(f2);
        }
    }

    public void b(int i2) {
        this.f20451h = i2;
    }

    /* renamed from: c */
    public a a(int i2) {
        return this.f20447d.get(i2);
    }

    public List<Line> c() {
        return this.f20446c;
    }

    public List<Line> d() {
        return this.f20448e;
    }

    public void e() {
        int size = this.f20448e.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f20448e.get(i2).b(g(), h());
        }
        int size2 = this.f20447d.size();
        for (int i3 = 0; i3 < size2; i3++) {
            this.f20447d.get(i3).m();
        }
    }

    public void f() {
        this.f20448e.clear();
        this.f20447d.clear();
        this.f20447d.add(this.f20445b);
        this.f20453j.clear();
    }

    public float g() {
        a aVar = this.f20445b;
        if (aVar == null) {
            return 0.0f;
        }
        return aVar.k();
    }

    public float h() {
        a aVar = this.f20445b;
        if (aVar == null) {
            return 0.0f;
        }
        return aVar.l();
    }
}
