package gw;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.graphics.drawable.b;
import com.google.android.material.R;
import gw.m;
import gw.n;
import gw.o;
import java.util.BitSet;
import s.c;

public class h extends Drawable implements b, p {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13140a = "h";

    /* renamed from: b  reason: collision with root package name */
    private static final Paint f13141b = new Paint(1);

    /* renamed from: c  reason: collision with root package name */
    private a f13142c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final o.f[] f13143d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final o.f[] f13144e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final BitSet f13145f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f13146g;

    /* renamed from: h  reason: collision with root package name */
    private final Matrix f13147h;

    /* renamed from: i  reason: collision with root package name */
    private final Path f13148i;

    /* renamed from: j  reason: collision with root package name */
    private final Path f13149j;

    /* renamed from: k  reason: collision with root package name */
    private final RectF f13150k;

    /* renamed from: l  reason: collision with root package name */
    private final RectF f13151l;

    /* renamed from: m  reason: collision with root package name */
    private final Region f13152m;

    /* renamed from: n  reason: collision with root package name */
    private final Region f13153n;

    /* renamed from: o  reason: collision with root package name */
    private m f13154o;

    /* renamed from: p  reason: collision with root package name */
    private final Paint f13155p;

    /* renamed from: q  reason: collision with root package name */
    private final Paint f13156q;

    /* renamed from: r  reason: collision with root package name */
    private final gv.a f13157r;

    /* renamed from: s  reason: collision with root package name */
    private final n.b f13158s;

    /* renamed from: t  reason: collision with root package name */
    private final n f13159t;

    /* renamed from: u  reason: collision with root package name */
    private PorterDuffColorFilter f13160u;

    /* renamed from: v  reason: collision with root package name */
    private PorterDuffColorFilter f13161v;

    /* renamed from: w  reason: collision with root package name */
    private final RectF f13162w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f13163x;

    static final class a extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public m f13167a;

        /* renamed from: b  reason: collision with root package name */
        public gq.a f13168b;

        /* renamed from: c  reason: collision with root package name */
        public ColorFilter f13169c;

        /* renamed from: d  reason: collision with root package name */
        public ColorStateList f13170d = null;

        /* renamed from: e  reason: collision with root package name */
        public ColorStateList f13171e = null;

        /* renamed from: f  reason: collision with root package name */
        public ColorStateList f13172f = null;

        /* renamed from: g  reason: collision with root package name */
        public ColorStateList f13173g = null;

        /* renamed from: h  reason: collision with root package name */
        public PorterDuff.Mode f13174h = PorterDuff.Mode.SRC_IN;

        /* renamed from: i  reason: collision with root package name */
        public Rect f13175i = null;

        /* renamed from: j  reason: collision with root package name */
        public float f13176j = 1.0f;

        /* renamed from: k  reason: collision with root package name */
        public float f13177k = 1.0f;

        /* renamed from: l  reason: collision with root package name */
        public float f13178l;

        /* renamed from: m  reason: collision with root package name */
        public int f13179m = 255;

        /* renamed from: n  reason: collision with root package name */
        public float f13180n = 0.0f;

        /* renamed from: o  reason: collision with root package name */
        public float f13181o = 0.0f;

        /* renamed from: p  reason: collision with root package name */
        public float f13182p = 0.0f;

        /* renamed from: q  reason: collision with root package name */
        public int f13183q = 0;

        /* renamed from: r  reason: collision with root package name */
        public int f13184r = 0;

        /* renamed from: s  reason: collision with root package name */
        public int f13185s = 0;

        /* renamed from: t  reason: collision with root package name */
        public int f13186t = 0;

        /* renamed from: u  reason: collision with root package name */
        public boolean f13187u = false;

        /* renamed from: v  reason: collision with root package name */
        public Paint.Style f13188v = Paint.Style.FILL_AND_STROKE;

        public a(a aVar) {
            this.f13167a = aVar.f13167a;
            this.f13168b = aVar.f13168b;
            this.f13178l = aVar.f13178l;
            this.f13169c = aVar.f13169c;
            this.f13170d = aVar.f13170d;
            this.f13171e = aVar.f13171e;
            this.f13174h = aVar.f13174h;
            this.f13173g = aVar.f13173g;
            this.f13179m = aVar.f13179m;
            this.f13176j = aVar.f13176j;
            this.f13185s = aVar.f13185s;
            this.f13183q = aVar.f13183q;
            this.f13187u = aVar.f13187u;
            this.f13177k = aVar.f13177k;
            this.f13180n = aVar.f13180n;
            this.f13181o = aVar.f13181o;
            this.f13182p = aVar.f13182p;
            this.f13184r = aVar.f13184r;
            this.f13186t = aVar.f13186t;
            this.f13172f = aVar.f13172f;
            this.f13188v = aVar.f13188v;
            if (aVar.f13175i != null) {
                this.f13175i = new Rect(aVar.f13175i);
            }
        }

        public a(m mVar, gq.a aVar) {
            this.f13167a = mVar;
            this.f13168b = aVar;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            h hVar = new h(this);
            boolean unused = hVar.f13146g = true;
            return hVar;
        }
    }

    public h() {
        this(new m());
    }

    public h(Context context, AttributeSet attributeSet, int i2, int i3) {
        this(m.a(context, attributeSet, i2, i3).a());
    }

    private h(a aVar) {
        this.f13143d = new o.f[4];
        this.f13144e = new o.f[4];
        this.f13145f = new BitSet(8);
        this.f13147h = new Matrix();
        this.f13148i = new Path();
        this.f13149j = new Path();
        this.f13150k = new RectF();
        this.f13151l = new RectF();
        this.f13152m = new Region();
        this.f13153n = new Region();
        Paint paint = new Paint(1);
        this.f13155p = paint;
        Paint paint2 = new Paint(1);
        this.f13156q = paint2;
        this.f13157r = new gv.a();
        this.f13159t = Looper.getMainLooper().getThread() == Thread.currentThread() ? n.a() : new n();
        this.f13162w = new RectF();
        this.f13163x = true;
        this.f13142c = aVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        Paint paint3 = f13141b;
        paint3.setColor(-1);
        paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        g();
        a(getState());
        this.f13158s = new n.b() {
            public void a(o oVar, Matrix matrix, int i2) {
                h.this.f13145f.set(i2, oVar.a());
                h.this.f13143d[i2] = oVar.a(matrix);
            }

            public void b(o oVar, Matrix matrix, int i2) {
                h.this.f13145f.set(i2 + 4, oVar.a());
                h.this.f13144e[i2] = oVar.a(matrix);
            }
        };
    }

    public h(m mVar) {
        this(new a(mVar, (gq.a) null));
    }

    private static int a(int i2, int i3) {
        return (i2 * (i3 + (i3 >>> 7))) >>> 8;
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z2) {
        return (colorStateList == null || mode == null) ? a(paint, z2) : a(colorStateList, mode, z2);
    }

    private PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z2) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z2) {
            colorForState = E(colorForState);
        }
        return new PorterDuffColorFilter(colorForState, mode);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r2 = r2.getColor();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.PorterDuffColorFilter a(android.graphics.Paint r2, boolean r3) {
        /*
            r1 = this;
            if (r3 == 0) goto L_0x0014
            int r2 = r2.getColor()
            int r3 = r1.E(r2)
            if (r3 == r2) goto L_0x0014
            android.graphics.PorterDuffColorFilter r2 = new android.graphics.PorterDuffColorFilter
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.SRC_IN
            r2.<init>(r3, r0)
            return r2
        L_0x0014:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: gw.h.a(android.graphics.Paint, boolean):android.graphics.PorterDuffColorFilter");
    }

    public static h a(Context context, float f2) {
        int a2 = gn.a.a(context, R.attr.colorSurface, h.class.getSimpleName());
        h hVar = new h();
        hVar.a(context);
        hVar.g(ColorStateList.valueOf(a2));
        hVar.r(f2);
        return hVar;
    }

    private void a() {
        float X = X();
        this.f13142c.f13184r = (int) Math.ceil((double) (0.75f * X));
        this.f13142c.f13185s = (int) Math.ceil((double) (X * 0.25f));
        g();
        b();
    }

    private void a(Canvas canvas) {
        if (c()) {
            canvas.save();
            d(canvas);
            if (!this.f13163x) {
                e(canvas);
            } else {
                int width = (int) (this.f13162w.width() - ((float) getBounds().width()));
                int height = (int) (this.f13162w.height() - ((float) getBounds().height()));
                if (width < 0 || height < 0) {
                    throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
                }
                Bitmap createBitmap = Bitmap.createBitmap(((int) this.f13162w.width()) + (this.f13142c.f13184r * 2) + width, ((int) this.f13162w.height()) + (this.f13142c.f13184r * 2) + height, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                float f2 = (float) ((getBounds().left - this.f13142c.f13184r) - width);
                float f3 = (float) ((getBounds().top - this.f13142c.f13184r) - height);
                canvas2.translate(-f2, -f3);
                e(canvas2);
                canvas.drawBitmap(createBitmap, f2, f3, (Paint) null);
                createBitmap.recycle();
            }
            canvas.restore();
        }
    }

    private void a(Canvas canvas, Paint paint, Path path, m mVar, RectF rectF) {
        if (mVar.a(rectF)) {
            float a2 = mVar.g().a(rectF) * this.f13142c.f13177k;
            canvas.drawRoundRect(rectF, a2, a2, paint);
            return;
        }
        canvas.drawPath(path, paint);
    }

    private boolean a(int[] iArr) {
        boolean z2;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f13142c.f13170d == null || (color2 = this.f13155p.getColor()) == (colorForState2 = this.f13142c.f13170d.getColorForState(iArr, color2))) {
            z2 = false;
        } else {
            this.f13155p.setColor(colorForState2);
            z2 = true;
        }
        if (this.f13142c.f13171e == null || (color = this.f13156q.getColor()) == (colorForState = this.f13142c.f13171e.getColorForState(iArr, color))) {
            return z2;
        }
        this.f13156q.setColor(colorForState);
        return true;
    }

    private void b() {
        super.invalidateSelf();
    }

    private void b(Canvas canvas) {
        a(canvas, this.f13155p, this.f13148i, this.f13142c.f13167a, R());
    }

    private void b(RectF rectF, Path path) {
        a(rectF, path);
        if (this.f13142c.f13176j != 1.0f) {
            this.f13147h.reset();
            this.f13147h.setScale(this.f13142c.f13176j, this.f13142c.f13176j, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f13147h);
        }
        path.computeBounds(this.f13162w, true);
    }

    private void c(Canvas canvas) {
        a(canvas, this.f13156q, this.f13149j, this.f13154o, i());
    }

    private boolean c() {
        return this.f13142c.f13183q != 1 && this.f13142c.f13184r > 0 && (this.f13142c.f13183q == 2 || Z());
    }

    private void d(Canvas canvas) {
        int aa2 = aa();
        int ab2 = ab();
        if (Build.VERSION.SDK_INT < 21 && this.f13163x) {
            Rect clipBounds = canvas.getClipBounds();
            clipBounds.inset(-this.f13142c.f13184r, -this.f13142c.f13184r);
            clipBounds.offset(aa2, ab2);
            canvas.clipRect(clipBounds, Region.Op.REPLACE);
        }
        canvas.translate((float) aa2, (float) ab2);
    }

    private boolean d() {
        return this.f13142c.f13188v == Paint.Style.FILL_AND_STROKE || this.f13142c.f13188v == Paint.Style.FILL;
    }

    private void e(Canvas canvas) {
        if (this.f13145f.cardinality() > 0) {
            Log.w(f13140a, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f13142c.f13185s != 0) {
            canvas.drawPath(this.f13148i, this.f13157r.a());
        }
        for (int i2 = 0; i2 < 4; i2++) {
            this.f13143d[i2].a(this.f13157r, this.f13142c.f13184r, canvas);
            this.f13144e[i2].a(this.f13157r, this.f13142c.f13184r, canvas);
        }
        if (this.f13163x) {
            int aa2 = aa();
            int ab2 = ab();
            canvas.translate((float) (-aa2), (float) (-ab2));
            canvas.drawPath(this.f13148i, f13141b);
            canvas.translate((float) aa2, (float) ab2);
        }
    }

    private boolean e() {
        return (this.f13142c.f13188v == Paint.Style.FILL_AND_STROKE || this.f13142c.f13188v == Paint.Style.STROKE) && this.f13156q.getStrokeWidth() > 0.0f;
    }

    private void f() {
        final float f2 = -h();
        m a2 = M().a((m.b) new m.b() {
            public c a(c cVar) {
                return cVar instanceof k ? cVar : new b(f2, cVar);
            }
        });
        this.f13154o = a2;
        this.f13159t.a(a2, this.f13142c.f13177k, i(), this.f13149j);
    }

    private boolean g() {
        PorterDuffColorFilter porterDuffColorFilter = this.f13160u;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f13161v;
        this.f13160u = a(this.f13142c.f13173g, this.f13142c.f13174h, this.f13155p, true);
        this.f13161v = a(this.f13142c.f13172f, this.f13142c.f13174h, this.f13156q, false);
        if (this.f13142c.f13187u) {
            this.f13157r.a(this.f13142c.f13173g.getColorForState(getState(), 0));
        }
        return !c.a((Object) porterDuffColorFilter, (Object) this.f13160u) || !c.a((Object) porterDuffColorFilter2, (Object) this.f13161v);
    }

    private float h() {
        if (e()) {
            return this.f13156q.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private RectF i() {
        this.f13151l.set(R());
        float h2 = h();
        this.f13151l.inset(h2, h2);
        return this.f13151l;
    }

    public void D(int i2) {
        if (this.f13142c.f13183q != i2) {
            this.f13142c.f13183q = i2;
            b();
        }
    }

    /* access modifiers changed from: protected */
    public int E(int i2) {
        return this.f13142c.f13168b != null ? this.f13142c.f13168b.a(i2, X() + U()) : i2;
    }

    public void F(int i2) {
        if (this.f13142c.f13186t != i2) {
            this.f13142c.f13186t = i2;
            b();
        }
    }

    public void G(int i2) {
        this.f13157r.a(i2);
        this.f13142c.f13187u = false;
        b();
    }

    public m M() {
        return this.f13142c.f13167a;
    }

    public ColorStateList N() {
        return this.f13142c.f13170d;
    }

    public ColorStateList O() {
        return this.f13142c.f13171e;
    }

    public ColorStateList P() {
        return this.f13142c.f13173g;
    }

    public float Q() {
        return this.f13142c.f13178l;
    }

    /* access modifiers changed from: protected */
    public RectF R() {
        this.f13150k.set(getBounds());
        return this.f13150k;
    }

    public boolean S() {
        return this.f13142c.f13168b != null && this.f13142c.f13168b.a();
    }

    public float T() {
        return this.f13142c.f13177k;
    }

    public float U() {
        return this.f13142c.f13180n;
    }

    public float V() {
        return this.f13142c.f13181o;
    }

    public float W() {
        return this.f13142c.f13182p;
    }

    public float X() {
        return V() + W();
    }

    public int Y() {
        return this.f13142c.f13184r;
    }

    public boolean Z() {
        return Build.VERSION.SDK_INT < 21 || (!ag() && !this.f13148i.isConvex() && Build.VERSION.SDK_INT < 29);
    }

    public void a(float f2, int i2) {
        n(f2);
        h(ColorStateList.valueOf(i2));
    }

    public void a(float f2, ColorStateList colorStateList) {
        n(f2);
        h(colorStateList);
    }

    public void a(int i2, int i3, int i4, int i5) {
        if (this.f13142c.f13175i == null) {
            this.f13142c.f13175i = new Rect();
        }
        this.f13142c.f13175i.set(i2, i3, i4, i5);
        invalidateSelf();
    }

    public void a(Context context) {
        this.f13142c.f13168b = new gq.a(context);
        a();
    }

    /* access modifiers changed from: protected */
    public void a(Canvas canvas, Paint paint, Path path, RectF rectF) {
        a(canvas, paint, path, this.f13142c.f13167a, rectF);
    }

    public void a(Paint.Style style) {
        this.f13142c.f13188v = style;
        b();
    }

    /* access modifiers changed from: protected */
    public final void a(RectF rectF, Path path) {
        this.f13159t.a(this.f13142c.f13167a, this.f13142c.f13177k, rectF, this.f13158s, path);
    }

    public void a(c cVar) {
        setShapeAppearanceModel(this.f13142c.f13167a.a(cVar));
    }

    public int aa() {
        double d2 = (double) this.f13142c.f13185s;
        double sin = Math.sin(Math.toRadians((double) this.f13142c.f13186t));
        Double.isNaN(d2);
        return (int) (d2 * sin);
    }

    public int ab() {
        double d2 = (double) this.f13142c.f13185s;
        double cos = Math.cos(Math.toRadians((double) this.f13142c.f13186t));
        Double.isNaN(d2);
        return (int) (d2 * cos);
    }

    public float ac() {
        return this.f13142c.f13167a.f().a(R());
    }

    public float ad() {
        return this.f13142c.f13167a.g().a(R());
    }

    public float ae() {
        return this.f13142c.f13167a.i().a(R());
    }

    public float af() {
        return this.f13142c.f13167a.h().a(R());
    }

    public boolean ag() {
        return this.f13142c.f13167a.a(R());
    }

    public void draw(Canvas canvas) {
        this.f13155p.setColorFilter(this.f13160u);
        int alpha = this.f13155p.getAlpha();
        this.f13155p.setAlpha(a(alpha, this.f13142c.f13179m));
        this.f13156q.setColorFilter(this.f13161v);
        this.f13156q.setStrokeWidth(this.f13142c.f13178l);
        int alpha2 = this.f13156q.getAlpha();
        this.f13156q.setAlpha(a(alpha2, this.f13142c.f13179m));
        if (this.f13146g) {
            f();
            b(R(), this.f13148i);
            this.f13146g = false;
        }
        a(canvas);
        if (d()) {
            b(canvas);
        }
        if (e()) {
            c(canvas);
        }
        this.f13155p.setAlpha(alpha);
        this.f13156q.setAlpha(alpha2);
    }

    public void g(ColorStateList colorStateList) {
        if (this.f13142c.f13170d != colorStateList) {
            this.f13142c.f13170d = colorStateList;
            onStateChange(getState());
        }
    }

    public void g(boolean z2) {
        this.f13163x = z2;
    }

    public Drawable.ConstantState getConstantState() {
        return this.f13142c;
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        if (this.f13142c.f13183q != 2) {
            if (ag()) {
                outline.setRoundRect(getBounds(), ac() * this.f13142c.f13177k);
                return;
            }
            b(R(), this.f13148i);
            if (this.f13148i.isConvex() || Build.VERSION.SDK_INT >= 29) {
                try {
                    outline.setConvexPath(this.f13148i);
                } catch (IllegalArgumentException unused) {
                }
            }
        }
    }

    public boolean getPadding(Rect rect) {
        if (this.f13142c.f13175i == null) {
            return super.getPadding(rect);
        }
        rect.set(this.f13142c.f13175i);
        return true;
    }

    public Region getTransparentRegion() {
        this.f13152m.set(getBounds());
        b(R(), this.f13148i);
        this.f13153n.setPath(this.f13148i, this.f13152m);
        this.f13152m.op(this.f13153n, Region.Op.DIFFERENCE);
        return this.f13152m;
    }

    public void h(ColorStateList colorStateList) {
        if (this.f13142c.f13171e != colorStateList) {
            this.f13142c.f13171e = colorStateList;
            onStateChange(getState());
        }
    }

    public void invalidateSelf() {
        this.f13146g = true;
        super.invalidateSelf();
    }

    public boolean isStateful() {
        return super.isStateful() || (this.f13142c.f13173g != null && this.f13142c.f13173g.isStateful()) || ((this.f13142c.f13172f != null && this.f13142c.f13172f.isStateful()) || ((this.f13142c.f13171e != null && this.f13142c.f13171e.isStateful()) || (this.f13142c.f13170d != null && this.f13142c.f13170d.isStateful())));
    }

    public Drawable mutate() {
        this.f13142c = new a(this.f13142c);
        return this;
    }

    public void n(float f2) {
        this.f13142c.f13178l = f2;
        invalidateSelf();
    }

    public void o(float f2) {
        setShapeAppearanceModel(this.f13142c.f13167a.a(f2));
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        this.f13146g = true;
        super.onBoundsChange(rect);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean z2 = a(iArr) || g();
        if (z2) {
            invalidateSelf();
        }
        return z2;
    }

    public void p(float f2) {
        if (this.f13142c.f13177k != f2) {
            this.f13142c.f13177k = f2;
            this.f13146g = true;
            invalidateSelf();
        }
    }

    public void q(float f2) {
        if (this.f13142c.f13180n != f2) {
            this.f13142c.f13180n = f2;
            a();
        }
    }

    public void r(float f2) {
        if (this.f13142c.f13181o != f2) {
            this.f13142c.f13181o = f2;
            a();
        }
    }

    public void setAlpha(int i2) {
        if (this.f13142c.f13179m != i2) {
            this.f13142c.f13179m = i2;
            b();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f13142c.f13169c = colorFilter;
        b();
    }

    public void setShapeAppearanceModel(m mVar) {
        this.f13142c.f13167a = mVar;
        invalidateSelf();
    }

    public void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f13142c.f13173g = colorStateList;
        g();
        b();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f13142c.f13174h != mode) {
            this.f13142c.f13174h = mode;
            g();
            b();
        }
    }
}
