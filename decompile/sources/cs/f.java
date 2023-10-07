package cs;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;

public class f extends c {

    /* renamed from: n  reason: collision with root package name */
    private int f26278n;

    /* renamed from: o  reason: collision with root package name */
    private int f26279o;

    /* renamed from: p  reason: collision with root package name */
    private int f26280p;

    /* renamed from: q  reason: collision with root package name */
    private int f26281q;

    /* renamed from: r  reason: collision with root package name */
    private int f26282r;

    /* renamed from: s  reason: collision with root package name */
    private int f26283s;

    /* renamed from: t  reason: collision with root package name */
    private Bitmap f26284t;

    /* renamed from: u  reason: collision with root package name */
    private c f26285u;

    /* renamed from: v  reason: collision with root package name */
    private int[] f26286v = new int[1];

    public f(Resources resources) {
        super(resources);
        this.f26285u = new c(resources) {
            /* access modifiers changed from: protected */
            public void k() {
            }
        };
    }

    private void o() {
        if (this.f26284t != null) {
            GLES20.glGenTextures(1, this.f26286v, 0);
            GLES20.glBindTexture(3553, this.f26286v[0]);
            GLES20.glTexParameterf(3553, 10241, 9728.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, this.f26284t, 0);
            a(this.f26285u.c(), false, true);
            this.f26285u.a(this.f26286v[0]);
        }
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.f26278n = i2;
        this.f26279o = i3;
        this.f26280p = i4;
        this.f26281q = i5;
    }

    public void a(Bitmap bitmap) {
        Bitmap bitmap2 = this.f26284t;
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
        this.f26284t = bitmap;
    }

    public float[] a(float[] fArr, boolean z2, boolean z3) {
        if (z2 || z3) {
            float f2 = -1.0f;
            float f3 = z2 ? -1.0f : 1.0f;
            if (!z3) {
                f2 = 1.0f;
            }
            Matrix.scaleM(fArr, 0, f3, f2, 1.0f);
        }
        return fArr;
    }

    public void b() {
        super.b();
        int i2 = this.f26278n;
        int i3 = this.f26279o;
        int i4 = this.f26280p;
        if (i4 == 0) {
            i4 = this.f26284t.getWidth();
        }
        int i5 = this.f26281q;
        if (i5 == 0) {
            i5 = this.f26284t.getHeight();
        }
        GLES20.glViewport(i2, i3, i4, i5);
        GLES20.glDisable(2929);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(768, 771);
        this.f26285u.b();
        GLES20.glDisable(3042);
        GLES20.glViewport(0, 0, this.f26282r, this.f26283s);
    }

    /* access modifiers changed from: protected */
    public void b(int i2, int i3) {
        this.f26282r = i2;
        this.f26283s = i3;
        this.f26285u.a(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void g() {
        super.g();
        this.f26285u.a();
        o();
    }
}
