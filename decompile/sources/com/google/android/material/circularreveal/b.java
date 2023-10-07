package com.google.android.material.circularreveal;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import com.google.android.material.circularreveal.c;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final int f18847a = (Build.VERSION.SDK_INT >= 21 ? 2 : Build.VERSION.SDK_INT >= 18 ? 1 : 0);

    /* renamed from: b  reason: collision with root package name */
    private final a f18848b;

    /* renamed from: c  reason: collision with root package name */
    private final View f18849c;

    /* renamed from: d  reason: collision with root package name */
    private final Path f18850d = new Path();

    /* renamed from: e  reason: collision with root package name */
    private final Paint f18851e = new Paint(7);

    /* renamed from: f  reason: collision with root package name */
    private final Paint f18852f;

    /* renamed from: g  reason: collision with root package name */
    private c.d f18853g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f18854h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f18855i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f18856j;

    public interface a {
        void a(Canvas canvas);

        boolean c();
    }

    public b(a aVar) {
        this.f18848b = aVar;
        View view = (View) aVar;
        this.f18849c = view;
        view.setWillNotDraw(false);
        Paint paint = new Paint(1);
        this.f18852f = paint;
        paint.setColor(0);
    }

    private float b(c.d dVar) {
        return gs.a.a(dVar.f18861a, dVar.f18862b, 0.0f, 0.0f, (float) this.f18849c.getWidth(), (float) this.f18849c.getHeight());
    }

    private void b(Canvas canvas) {
        if (j()) {
            Rect bounds = this.f18854h.getBounds();
            float width = this.f18853g.f18861a - (((float) bounds.width()) / 2.0f);
            float height = this.f18853g.f18862b - (((float) bounds.height()) / 2.0f);
            canvas.translate(width, height);
            this.f18854h.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    private void g() {
        if (f18847a == 1) {
            this.f18850d.rewind();
            c.d dVar = this.f18853g;
            if (dVar != null) {
                this.f18850d.addCircle(dVar.f18861a, this.f18853g.f18862b, this.f18853g.f18863c, Path.Direction.CW);
            }
        }
        this.f18849c.invalidate();
    }

    private boolean h() {
        c.d dVar = this.f18853g;
        boolean z2 = dVar == null || dVar.a();
        return f18847a == 0 ? !z2 && this.f18856j : !z2;
    }

    private boolean i() {
        return !this.f18855i && Color.alpha(this.f18852f.getColor()) != 0;
    }

    private boolean j() {
        return (this.f18855i || this.f18854h == null || this.f18853g == null) ? false : true;
    }

    public void a() {
        if (f18847a == 0) {
            this.f18855i = true;
            this.f18856j = false;
            this.f18849c.buildDrawingCache();
            Bitmap drawingCache = this.f18849c.getDrawingCache();
            if (!(drawingCache != null || this.f18849c.getWidth() == 0 || this.f18849c.getHeight() == 0)) {
                drawingCache = Bitmap.createBitmap(this.f18849c.getWidth(), this.f18849c.getHeight(), Bitmap.Config.ARGB_8888);
                this.f18849c.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                this.f18851e.setShader(new BitmapShader(drawingCache, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            }
            this.f18855i = false;
            this.f18856j = true;
        }
    }

    public void a(int i2) {
        this.f18852f.setColor(i2);
        this.f18849c.invalidate();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0094, code lost:
        if (i() != false) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        if (i() != false) goto L_0x0096;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.graphics.Canvas r9) {
        /*
            r8 = this;
            boolean r0 = r8.h()
            if (r0 == 0) goto L_0x008b
            int r0 = f18847a
            if (r0 == 0) goto L_0x0062
            r1 = 1
            if (r0 == r1) goto L_0x0034
            r1 = 2
            if (r0 != r1) goto L_0x001d
            com.google.android.material.circularreveal.b$a r0 = r8.f18848b
            r0.a(r9)
            boolean r0 = r8.i()
            if (r0 == 0) goto L_0x00ac
            goto L_0x0096
        L_0x001d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unsupported strategy "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r9.<init>(r0)
            throw r9
        L_0x0034:
            int r0 = r9.save()
            android.graphics.Path r1 = r8.f18850d
            r9.clipPath(r1)
            com.google.android.material.circularreveal.b$a r1 = r8.f18848b
            r1.a(r9)
            boolean r1 = r8.i()
            if (r1 == 0) goto L_0x005e
            r3 = 0
            r4 = 0
            android.view.View r1 = r8.f18849c
            int r1 = r1.getWidth()
            float r5 = (float) r1
            android.view.View r1 = r8.f18849c
            int r1 = r1.getHeight()
            float r6 = (float) r1
            android.graphics.Paint r7 = r8.f18852f
            r2 = r9
            r2.drawRect(r3, r4, r5, r6, r7)
        L_0x005e:
            r9.restoreToCount(r0)
            goto L_0x00ac
        L_0x0062:
            com.google.android.material.circularreveal.c$d r0 = r8.f18853g
            float r0 = r0.f18861a
            com.google.android.material.circularreveal.c$d r1 = r8.f18853g
            float r1 = r1.f18862b
            com.google.android.material.circularreveal.c$d r2 = r8.f18853g
            float r2 = r2.f18863c
            android.graphics.Paint r3 = r8.f18851e
            r9.drawCircle(r0, r1, r2, r3)
            boolean r0 = r8.i()
            if (r0 == 0) goto L_0x00ac
            com.google.android.material.circularreveal.c$d r0 = r8.f18853g
            float r0 = r0.f18861a
            com.google.android.material.circularreveal.c$d r1 = r8.f18853g
            float r1 = r1.f18862b
            com.google.android.material.circularreveal.c$d r2 = r8.f18853g
            float r2 = r2.f18863c
            android.graphics.Paint r3 = r8.f18852f
            r9.drawCircle(r0, r1, r2, r3)
            goto L_0x00ac
        L_0x008b:
            com.google.android.material.circularreveal.b$a r0 = r8.f18848b
            r0.a(r9)
            boolean r0 = r8.i()
            if (r0 == 0) goto L_0x00ac
        L_0x0096:
            r2 = 0
            r3 = 0
            android.view.View r0 = r8.f18849c
            int r0 = r0.getWidth()
            float r4 = (float) r0
            android.view.View r0 = r8.f18849c
            int r0 = r0.getHeight()
            float r5 = (float) r0
            android.graphics.Paint r6 = r8.f18852f
            r1 = r9
            r1.drawRect(r2, r3, r4, r5, r6)
        L_0x00ac:
            r8.b((android.graphics.Canvas) r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.circularreveal.b.a(android.graphics.Canvas):void");
    }

    public void a(Drawable drawable) {
        this.f18854h = drawable;
        this.f18849c.invalidate();
    }

    public void a(c.d dVar) {
        if (dVar == null) {
            this.f18853g = null;
        } else {
            c.d dVar2 = this.f18853g;
            if (dVar2 == null) {
                this.f18853g = new c.d(dVar);
            } else {
                dVar2.a(dVar);
            }
            if (gs.a.b(dVar.f18863c, b(dVar), 1.0E-4f)) {
                this.f18853g.f18863c = Float.MAX_VALUE;
            }
        }
        g();
    }

    public void b() {
        if (f18847a == 0) {
            this.f18856j = false;
            this.f18849c.destroyDrawingCache();
            this.f18851e.setShader((Shader) null);
            this.f18849c.invalidate();
        }
    }

    public c.d c() {
        c.d dVar = this.f18853g;
        if (dVar == null) {
            return null;
        }
        c.d dVar2 = new c.d(dVar);
        if (dVar2.a()) {
            dVar2.f18863c = b(dVar2);
        }
        return dVar2;
    }

    public int d() {
        return this.f18852f.getColor();
    }

    public Drawable e() {
        return this.f18854h;
    }

    public boolean f() {
        return this.f18848b.c() && !h();
    }
}
