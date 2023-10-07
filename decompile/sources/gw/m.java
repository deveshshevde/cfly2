package gw;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.material.R;

public class m {

    /* renamed from: a  reason: collision with root package name */
    public static final c f13193a = new k(0.5f);

    /* renamed from: b  reason: collision with root package name */
    d f13194b;

    /* renamed from: c  reason: collision with root package name */
    d f13195c;

    /* renamed from: d  reason: collision with root package name */
    d f13196d;

    /* renamed from: e  reason: collision with root package name */
    d f13197e;

    /* renamed from: f  reason: collision with root package name */
    c f13198f;

    /* renamed from: g  reason: collision with root package name */
    c f13199g;

    /* renamed from: h  reason: collision with root package name */
    c f13200h;

    /* renamed from: i  reason: collision with root package name */
    c f13201i;

    /* renamed from: j  reason: collision with root package name */
    f f13202j;

    /* renamed from: k  reason: collision with root package name */
    f f13203k;

    /* renamed from: l  reason: collision with root package name */
    f f13204l;

    /* renamed from: m  reason: collision with root package name */
    f f13205m;

    public static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public d f13206a = i.a();
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public d f13207b = i.a();
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public d f13208c = i.a();
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public d f13209d = i.a();
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public c f13210e = new a(0.0f);
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public c f13211f = new a(0.0f);
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public c f13212g = new a(0.0f);
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public c f13213h = new a(0.0f);
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public f f13214i = i.b();
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public f f13215j = i.b();
        /* access modifiers changed from: private */

        /* renamed from: k  reason: collision with root package name */
        public f f13216k = i.b();
        /* access modifiers changed from: private */

        /* renamed from: l  reason: collision with root package name */
        public f f13217l = i.b();

        public a() {
        }

        public a(m mVar) {
            this.f13206a = mVar.f13194b;
            this.f13207b = mVar.f13195c;
            this.f13208c = mVar.f13196d;
            this.f13209d = mVar.f13197e;
            this.f13210e = mVar.f13198f;
            this.f13211f = mVar.f13199g;
            this.f13212g = mVar.f13200h;
            this.f13213h = mVar.f13201i;
            this.f13214i = mVar.f13202j;
            this.f13215j = mVar.f13203k;
            this.f13216k = mVar.f13204l;
            this.f13217l = mVar.f13205m;
        }

        private static float f(d dVar) {
            if (dVar instanceof l) {
                return ((l) dVar).f13192a;
            }
            if (dVar instanceof e) {
                return ((e) dVar).f13138a;
            }
            return -1.0f;
        }

        public a a(float f2) {
            return b(f2).c(f2).d(f2).e(f2);
        }

        public a a(int i2, float f2) {
            return a(i.a(i2)).a(f2);
        }

        public a a(int i2, c cVar) {
            return b(i.a(i2)).b(cVar);
        }

        public a a(c cVar) {
            return b(cVar).c(cVar).d(cVar).e(cVar);
        }

        public a a(d dVar) {
            return b(dVar).c(dVar).d(dVar).e(dVar);
        }

        public a a(f fVar) {
            this.f13214i = fVar;
            return this;
        }

        public m a() {
            return new m(this);
        }

        public a b(float f2) {
            this.f13210e = new a(f2);
            return this;
        }

        public a b(int i2, c cVar) {
            return c(i.a(i2)).c(cVar);
        }

        public a b(c cVar) {
            this.f13210e = cVar;
            return this;
        }

        public a b(d dVar) {
            this.f13206a = dVar;
            float f2 = f(dVar);
            if (f2 != -1.0f) {
                b(f2);
            }
            return this;
        }

        public a b(f fVar) {
            this.f13216k = fVar;
            return this;
        }

        public a c(float f2) {
            this.f13211f = new a(f2);
            return this;
        }

        public a c(int i2, c cVar) {
            return d(i.a(i2)).d(cVar);
        }

        public a c(c cVar) {
            this.f13211f = cVar;
            return this;
        }

        public a c(d dVar) {
            this.f13207b = dVar;
            float f2 = f(dVar);
            if (f2 != -1.0f) {
                c(f2);
            }
            return this;
        }

        public a d(float f2) {
            this.f13212g = new a(f2);
            return this;
        }

        public a d(int i2, c cVar) {
            return e(i.a(i2)).e(cVar);
        }

        public a d(c cVar) {
            this.f13212g = cVar;
            return this;
        }

        public a d(d dVar) {
            this.f13208c = dVar;
            float f2 = f(dVar);
            if (f2 != -1.0f) {
                d(f2);
            }
            return this;
        }

        public a e(float f2) {
            this.f13213h = new a(f2);
            return this;
        }

        public a e(c cVar) {
            this.f13213h = cVar;
            return this;
        }

        public a e(d dVar) {
            this.f13209d = dVar;
            float f2 = f(dVar);
            if (f2 != -1.0f) {
                e(f2);
            }
            return this;
        }
    }

    public interface b {
        c a(c cVar);
    }

    public m() {
        this.f13194b = i.a();
        this.f13195c = i.a();
        this.f13196d = i.a();
        this.f13197e = i.a();
        this.f13198f = new a(0.0f);
        this.f13199g = new a(0.0f);
        this.f13200h = new a(0.0f);
        this.f13201i = new a(0.0f);
        this.f13202j = i.b();
        this.f13203k = i.b();
        this.f13204l = i.b();
        this.f13205m = i.b();
    }

    private m(a aVar) {
        this.f13194b = aVar.f13206a;
        this.f13195c = aVar.f13207b;
        this.f13196d = aVar.f13208c;
        this.f13197e = aVar.f13209d;
        this.f13198f = aVar.f13210e;
        this.f13199g = aVar.f13211f;
        this.f13200h = aVar.f13212g;
        this.f13201i = aVar.f13213h;
        this.f13202j = aVar.f13214i;
        this.f13203k = aVar.f13215j;
        this.f13204l = aVar.f13216k;
        this.f13205m = aVar.f13217l;
    }

    private static c a(TypedArray typedArray, int i2, c cVar) {
        TypedValue peekValue = typedArray.peekValue(i2);
        return peekValue == null ? cVar : peekValue.type == 5 ? new a((float) TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics())) : peekValue.type == 6 ? new k(peekValue.getFraction(1.0f, 1.0f)) : cVar;
    }

    public static a a() {
        return new a();
    }

    public static a a(Context context, int i2, int i3) {
        return a(context, i2, i3, 0);
    }

    private static a a(Context context, int i2, int i3, int i4) {
        return a(context, i2, i3, (c) new a((float) i4));
    }

    private static a a(Context context, int i2, int i3, c cVar) {
        if (i3 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i2);
            i2 = i3;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R.styleable.ShapeAppearance);
        try {
            int i4 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamily, 0);
            int i5 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopLeft, i4);
            int i6 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyTopRight, i4);
            int i7 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomRight, i4);
            int i8 = obtainStyledAttributes.getInt(R.styleable.ShapeAppearance_cornerFamilyBottomLeft, i4);
            c a2 = a(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSize, cVar);
            c a3 = a(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopLeft, a2);
            c a4 = a(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeTopRight, a2);
            c a5 = a(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomRight, a2);
            return new a().a(i5, a3).b(i6, a4).c(i7, a5).d(i8, a(obtainStyledAttributes, R.styleable.ShapeAppearance_cornerSizeBottomLeft, a2));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static a a(Context context, AttributeSet attributeSet, int i2, int i3) {
        return a(context, attributeSet, i2, i3, 0);
    }

    public static a a(Context context, AttributeSet attributeSet, int i2, int i3, int i4) {
        return a(context, attributeSet, i2, i3, (c) new a((float) i4));
    }

    public static a a(Context context, AttributeSet attributeSet, int i2, int i3, c cVar) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialShape, i2, i3);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearance, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(R.styleable.MaterialShape_shapeAppearanceOverlay, 0);
        obtainStyledAttributes.recycle();
        return a(context, resourceId, resourceId2, cVar);
    }

    public m a(float f2) {
        return n().a(f2).a();
    }

    public m a(c cVar) {
        return n().a(cVar).a();
    }

    public m a(b bVar) {
        return n().b(bVar.a(f())).c(bVar.a(g())).e(bVar.a(i())).d(bVar.a(h())).a();
    }

    public boolean a(RectF rectF) {
        boolean z2 = this.f13205m.getClass().equals(f.class) && this.f13203k.getClass().equals(f.class) && this.f13202j.getClass().equals(f.class) && this.f13204l.getClass().equals(f.class);
        float a2 = this.f13198f.a(rectF);
        return z2 && ((this.f13199g.a(rectF) > a2 ? 1 : (this.f13199g.a(rectF) == a2 ? 0 : -1)) == 0 && (this.f13201i.a(rectF) > a2 ? 1 : (this.f13201i.a(rectF) == a2 ? 0 : -1)) == 0 && (this.f13200h.a(rectF) > a2 ? 1 : (this.f13200h.a(rectF) == a2 ? 0 : -1)) == 0) && ((this.f13195c instanceof l) && (this.f13194b instanceof l) && (this.f13196d instanceof l) && (this.f13197e instanceof l));
    }

    public d b() {
        return this.f13194b;
    }

    public d c() {
        return this.f13195c;
    }

    public d d() {
        return this.f13196d;
    }

    public d e() {
        return this.f13197e;
    }

    public c f() {
        return this.f13198f;
    }

    public c g() {
        return this.f13199g;
    }

    public c h() {
        return this.f13200h;
    }

    public c i() {
        return this.f13201i;
    }

    public f j() {
        return this.f13205m;
    }

    public f k() {
        return this.f13202j;
    }

    public f l() {
        return this.f13203k;
    }

    public f m() {
        return this.f13204l;
    }

    public a n() {
        return new a(this);
    }
}
