package hk;

import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Pair;
import com.huantansheng.easyphotos.models.puzzle.Line;
import com.huantansheng.easyphotos.models.puzzle.c;
import hk.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class c implements com.huantansheng.easyphotos.models.puzzle.c {

    /* renamed from: a  reason: collision with root package name */
    private RectF f13355a;

    /* renamed from: b  reason: collision with root package name */
    private a f13356b;

    /* renamed from: c  reason: collision with root package name */
    private List<a> f13357c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private List<Line> f13358d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private List<Line> f13359e = new ArrayList(4);

    /* renamed from: f  reason: collision with root package name */
    private float f13360f;

    /* renamed from: g  reason: collision with root package name */
    private float f13361g;

    /* renamed from: h  reason: collision with root package name */
    private int f13362h;

    /* renamed from: i  reason: collision with root package name */
    private Comparator<a> f13363i = new a.C0096a();

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<c.a> f13364j = new ArrayList<>();

    protected c() {
    }

    private List<a> a(a aVar, Line.Direction direction, float f2) {
        this.f13357c.remove(aVar);
        b a2 = d.a(aVar, direction, f2);
        this.f13358d.add(a2);
        List<a> a3 = d.a(aVar, a2);
        this.f13357c.addAll(a3);
        j();
        i();
        return a3;
    }

    private void a(Line line) {
        int size = this.f13358d.size();
        for (int i2 = 0; i2 < size; i2++) {
            Line line2 = this.f13358d.get(i2);
            if (line2 != line && line2.g() == line.g() && (line2.g() != Line.Direction.HORIZONTAL ? !(line2.l() <= line.k() || line.l() <= line2.k() || line2.i() <= line.c().j() || line2.j() >= line.i()) : !(line2.j() <= line.i() || line.j() <= line2.i() || line2.k() <= line.c().l() || line2.l() >= line.k()))) {
                line.a(line2);
            }
        }
    }

    private void b(Line line) {
        int size = this.f13358d.size();
        for (int i2 = 0; i2 < size; i2++) {
            Line line2 = this.f13358d.get(i2);
            if (line2 != line && line2.g() == line.g() && (line2.g() != Line.Direction.HORIZONTAL ? !(line2.l() <= line.k() || line.l() <= line2.k() || line2.j() >= line.d().i() || line2.i() <= line.j()) : !(line2.j() <= line.i() || line.j() <= line2.i() || line2.l() >= line.d().k() || line2.k() <= line.l()))) {
                line.b(line2);
            }
        }
    }

    private void i() {
        Collections.sort(this.f13357c, this.f13363i);
    }

    private void j() {
        int size = this.f13358d.size();
        for (int i2 = 0; i2 < size; i2++) {
            Line line = this.f13358d.get(i2);
            b(line);
            a(line);
        }
    }

    public com.huantansheng.easyphotos.models.puzzle.a a(int i2) {
        return this.f13357c.get(i2);
    }

    public void a(float f2) {
        this.f13360f = f2;
        for (a b2 : this.f13357c) {
            b2.b(f2);
        }
        this.f13356b.f13333a.a().set(this.f13355a.left + f2, this.f13355a.top + f2);
        this.f13356b.f13333a.b().set(this.f13355a.left + f2, this.f13355a.bottom - f2);
        this.f13356b.f13335c.a().set(this.f13355a.right - f2, this.f13355a.top + f2);
        this.f13356b.f13335c.b().set(this.f13355a.right - f2, this.f13355a.bottom - f2);
        e();
    }

    /* access modifiers changed from: protected */
    public void a(int i2, float f2) {
        a(i2, f2, f2);
    }

    /* access modifiers changed from: protected */
    public void a(int i2, float f2, float f3) {
        a aVar = this.f13357c.get(i2);
        this.f13357c.remove(aVar);
        b a2 = d.a(aVar, Line.Direction.HORIZONTAL, f2);
        b a3 = d.a(aVar, Line.Direction.VERTICAL, f3);
        this.f13358d.add(a2);
        this.f13358d.add(a3);
        this.f13357c.addAll(d.a(aVar, a2, a3));
        j();
        i();
        c.a aVar2 = new c.a();
        aVar2.f20383a = 1;
        aVar2.f20385c = i2;
        this.f13364j.add(aVar2);
    }

    /* access modifiers changed from: protected */
    public void a(int i2, int i3, int i4) {
        a aVar = this.f13357c.get(i2);
        this.f13357c.remove(aVar);
        Pair<List<b>, List<a>> a2 = d.a(aVar, i3, i4);
        this.f13358d.addAll((List) a2.first);
        this.f13357c.addAll((List) a2.second);
        j();
        i();
        c.a aVar2 = new c.a();
        aVar2.f20383a = 2;
        aVar2.f20385c = i2;
        aVar2.f20387e = i3;
        aVar2.f20388f = i4;
        this.f13364j.add(aVar2);
    }

    /* access modifiers changed from: protected */
    public void a(int i2, int i3, Line.Direction direction) {
        int i4;
        a aVar = this.f13357c.get(i2);
        int i5 = i3;
        while (true) {
            i4 = 0;
            if (i5 <= 1) {
                break;
            }
            aVar = a(aVar, direction, ((float) (i5 - 1)) / ((float) i5)).get(0);
            i5--;
        }
        c.a aVar2 = new c.a();
        aVar2.f20383a = 3;
        aVar2.f20386d = i3;
        aVar2.f20385c = i2;
        if (direction != Line.Direction.HORIZONTAL) {
            i4 = 1;
        }
        aVar2.f20384b = i4;
        this.f13364j.add(aVar2);
    }

    /* access modifiers changed from: protected */
    public void a(int i2, Line.Direction direction, float f2) {
        a(this.f13357c.get(i2), direction, f2);
        c.a aVar = new c.a();
        int i3 = 0;
        aVar.f20383a = 0;
        if (direction != Line.Direction.HORIZONTAL) {
            i3 = 1;
        }
        aVar.f20384b = i3;
        aVar.f20385c = i2;
        this.f13364j.add(aVar);
    }

    public void a(RectF rectF) {
        f();
        this.f13355a = rectF;
        PointF pointF = new PointF(rectF.left, rectF.top);
        PointF pointF2 = new PointF(rectF.right, rectF.top);
        PointF pointF3 = new PointF(rectF.left, rectF.bottom);
        PointF pointF4 = new PointF(rectF.right, rectF.bottom);
        b bVar = new b(pointF, pointF3);
        b bVar2 = new b(pointF, pointF2);
        b bVar3 = new b(pointF2, pointF4);
        b bVar4 = new b(pointF3, pointF4);
        this.f13359e.clear();
        this.f13359e.add(bVar);
        this.f13359e.add(bVar2);
        this.f13359e.add(bVar3);
        this.f13359e.add(bVar4);
        a aVar = new a();
        this.f13356b = aVar;
        aVar.f13333a = bVar;
        this.f13356b.f13334b = bVar2;
        this.f13356b.f13335c = bVar3;
        this.f13356b.f13336d = bVar4;
        this.f13357c.clear();
        this.f13357c.add(this.f13356b);
    }

    public int b() {
        return this.f13357c.size();
    }

    public void b(float f2) {
        this.f13361g = f2;
        for (a a2 : this.f13357c) {
            a2.a(f2);
        }
    }

    public void b(int i2) {
        this.f13362h = i2;
    }

    public List<Line> c() {
        return this.f13359e;
    }

    /* access modifiers changed from: protected */
    public void c(int i2) {
        a aVar = this.f13357c.get(i2);
        this.f13357c.remove(aVar);
        Pair<List<b>, List<a>> a2 = d.a(aVar);
        this.f13358d.addAll((Collection) a2.first);
        this.f13357c.addAll((Collection) a2.second);
        j();
        i();
        c.a aVar2 = new c.a();
        aVar2.f20383a = 4;
        aVar2.f20385c = i2;
        this.f13364j.add(aVar2);
    }

    public List<Line> d() {
        return this.f13358d;
    }

    public void e() {
        for (Line b2 : this.f13358d) {
            b2.b(g(), h());
        }
    }

    public void f() {
        this.f13358d.clear();
        this.f13357c.clear();
        this.f13357c.add(this.f13356b);
        this.f13364j.clear();
    }

    public float g() {
        a aVar = this.f13356b;
        if (aVar == null) {
            return 0.0f;
        }
        return aVar.k();
    }

    public float h() {
        a aVar = this.f13356b;
        if (aVar == null) {
            return 0.0f;
        }
        return aVar.l();
    }
}
