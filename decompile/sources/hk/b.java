package hk;

import android.graphics.PointF;
import android.graphics.RectF;
import android.util.Log;
import com.huantansheng.easyphotos.models.puzzle.Line;

class b implements Line {

    /* renamed from: a  reason: collision with root package name */
    public Line.Direction f13345a = Line.Direction.HORIZONTAL;

    /* renamed from: b  reason: collision with root package name */
    b f13346b;

    /* renamed from: c  reason: collision with root package name */
    b f13347c;

    /* renamed from: d  reason: collision with root package name */
    private PointF f13348d;

    /* renamed from: e  reason: collision with root package name */
    private PointF f13349e;

    /* renamed from: f  reason: collision with root package name */
    private PointF f13350f = new PointF();

    /* renamed from: g  reason: collision with root package name */
    private PointF f13351g = new PointF();

    /* renamed from: h  reason: collision with root package name */
    private Line f13352h;

    /* renamed from: i  reason: collision with root package name */
    private Line f13353i;

    /* renamed from: j  reason: collision with root package name */
    private RectF f13354j = new RectF();

    b(PointF pointF, PointF pointF2) {
        Line.Direction direction;
        this.f13348d = pointF;
        this.f13349e = pointF2;
        if (pointF.x == pointF2.x) {
            direction = Line.Direction.VERTICAL;
        } else if (pointF.y == pointF2.y) {
            direction = Line.Direction.HORIZONTAL;
        } else {
            Log.d("StraightLine", "StraightLine: current only support two direction");
            return;
        }
        this.f13345a = direction;
    }

    public PointF a() {
        return this.f13348d;
    }

    public void a(Line line) {
        this.f13353i = line;
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        this.f13346b = bVar;
    }

    public boolean a(float f2, float f3) {
        if (this.f13345a == Line.Direction.HORIZONTAL) {
            if (this.f13350f.y + f2 < this.f13353i.l() + f3 || this.f13350f.y + f2 > this.f13352h.k() - f3 || this.f13351g.y + f2 < this.f13353i.l() + f3 || this.f13351g.y + f2 > this.f13352h.k() - f3) {
                return false;
            }
            this.f13348d.y = this.f13350f.y + f2;
            this.f13349e.y = this.f13351g.y + f2;
            return true;
        } else if (this.f13350f.x + f2 < this.f13353i.j() + f3 || this.f13350f.x + f2 > this.f13352h.i() - f3 || this.f13351g.x + f2 < this.f13353i.j() + f3 || this.f13351g.x + f2 > this.f13352h.i() - f3) {
            return false;
        } else {
            this.f13348d.x = this.f13350f.x + f2;
            this.f13349e.x = this.f13351g.x + f2;
            return true;
        }
    }

    public boolean a(float f2, float f3, float f4) {
        if (this.f13345a == Line.Direction.HORIZONTAL) {
            this.f13354j.left = this.f13348d.x;
            this.f13354j.right = this.f13349e.x;
            float f5 = f4 / 2.0f;
            this.f13354j.top = this.f13348d.y - f5;
            this.f13354j.bottom = this.f13348d.y + f5;
        } else if (this.f13345a == Line.Direction.VERTICAL) {
            this.f13354j.top = this.f13348d.y;
            this.f13354j.bottom = this.f13349e.y;
            float f6 = f4 / 2.0f;
            this.f13354j.left = this.f13348d.x - f6;
            this.f13354j.right = this.f13348d.x + f6;
        }
        return this.f13354j.contains(f2, f3);
    }

    public PointF b() {
        return this.f13349e;
    }

    public void b(float f2, float f3) {
        if (this.f13345a == Line.Direction.HORIZONTAL) {
            b bVar = this.f13346b;
            if (bVar != null) {
                this.f13348d.x = bVar.m();
            }
            b bVar2 = this.f13347c;
            if (bVar2 != null) {
                this.f13349e.x = bVar2.m();
            }
        } else if (this.f13345a == Line.Direction.VERTICAL) {
            b bVar3 = this.f13346b;
            if (bVar3 != null) {
                this.f13348d.y = bVar3.m();
            }
            b bVar4 = this.f13347c;
            if (bVar4 != null) {
                this.f13349e.y = bVar4.m();
            }
        }
    }

    public void b(Line line) {
        this.f13352h = line;
    }

    /* access modifiers changed from: package-private */
    public void b(b bVar) {
        this.f13347c = bVar;
    }

    public Line c() {
        return this.f13353i;
    }

    public Line d() {
        return this.f13352h;
    }

    public Line e() {
        return this.f13346b;
    }

    public Line f() {
        return this.f13347c;
    }

    public Line.Direction g() {
        return this.f13345a;
    }

    public void h() {
        this.f13350f.set(this.f13348d);
        this.f13351g.set(this.f13349e);
    }

    public float i() {
        return Math.min(this.f13348d.x, this.f13349e.x);
    }

    public float j() {
        return Math.max(this.f13348d.x, this.f13349e.x);
    }

    public float k() {
        return Math.min(this.f13348d.y, this.f13349e.y);
    }

    public float l() {
        return Math.max(this.f13348d.y, this.f13349e.y);
    }

    public float m() {
        return this.f13345a == Line.Direction.HORIZONTAL ? this.f13348d.y : this.f13348d.x;
    }

    public String toString() {
        return "start --> " + this.f13348d.toString() + ",end --> " + this.f13349e.toString();
    }
}
