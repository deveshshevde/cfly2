package cx;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import com.ctoo.mediaedit.utils.EasyGlUtils;
import cs.b;
import cs.e;
import cv.d;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class a implements GLSurfaceView.Renderer {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public SurfaceTexture f26488a;

    /* renamed from: b  reason: collision with root package name */
    private e f26489b;

    /* renamed from: c  reason: collision with root package name */
    private cs.a f26490c;

    /* renamed from: d  reason: collision with root package name */
    private cs.a f26491d;

    /* renamed from: e  reason: collision with root package name */
    private final b f26492e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<cu.e> f26493f;

    /* renamed from: g  reason: collision with root package name */
    private cu.e f26494g;

    /* renamed from: h  reason: collision with root package name */
    private int f26495h;

    /* renamed from: i  reason: collision with root package name */
    private int f26496i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f26497j;

    /* renamed from: k  reason: collision with root package name */
    private int[] f26498k;

    /* renamed from: l  reason: collision with root package name */
    private Handler f26499l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public cw.a f26500m;

    public cu.e a() {
        return this.f26494g;
    }

    public void a(float f2) {
        cu.e eVar = this.f26494g;
        if (eVar != null && (eVar instanceof d)) {
            ((d) eVar).a(f2 * 5.0f);
        }
    }

    public void a(cu.e eVar) {
        cu.e eVar2 = this.f26494g;
        this.f26494g = eVar;
        if (eVar2 != null) {
            eVar2.h();
        }
        cu.e eVar3 = this.f26494g;
        if (eVar3 != null) {
            eVar3.g();
            this.f26494g.a(this.f26495h, this.f26496i);
        }
    }

    public void onDrawFrame(GL10 gl10) {
        this.f26488a.updateTexImage();
        EasyGlUtils.a(this.f26497j[0], this.f26498k[0]);
        GLES20.glViewport(0, 0, this.f26495h, this.f26496i);
        this.f26489b.b();
        EasyGlUtils.b();
        this.f26491d.a(this.f26498k[0]);
        this.f26491d.b();
        if (this.f26494g != null) {
            EasyGlUtils.a(this.f26497j[0], this.f26498k[0]);
            GLES20.glViewport(0, 0, this.f26495h, this.f26496i);
            this.f26494g.a(this.f26491d.f());
            EasyGlUtils.b();
            this.f26491d.a(this.f26498k[0]);
            this.f26491d.b();
        }
        for (int i2 = 0; i2 < this.f26493f.size(); i2++) {
            EasyGlUtils.a(this.f26497j[0], this.f26498k[0]);
            GLES20.glViewport(0, 0, this.f26495h, this.f26496i);
            this.f26493f.get(i2).a(this.f26491d.f());
            EasyGlUtils.b();
            this.f26491d.a(this.f26498k[0]);
            this.f26491d.b();
        }
        this.f26492e.a(this.f26491d.f());
        this.f26492e.b();
        GLES20.glViewport(0, 0, this.f26495h, this.f26496i);
        this.f26490c.a(this.f26492e.f());
        this.f26490c.b();
    }

    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        this.f26495h = i2;
        this.f26496i = i3;
        GLES20.glDeleteFramebuffers(1, this.f26497j, 0);
        GLES20.glDeleteTextures(1, this.f26498k, 0);
        GLES20.glGenFramebuffers(1, this.f26497j, 0);
        EasyGlUtils.a(1, this.f26498k, 0, 6408, this.f26495h, this.f26496i);
        this.f26492e.a(this.f26495h, this.f26496i);
        this.f26491d.a(this.f26495h, this.f26496i);
        for (int i4 = 0; i4 < this.f26493f.size(); i4++) {
            this.f26493f.get(i4).a(this.f26495h, this.f26496i);
        }
        cu.e eVar = this.f26494g;
        if (eVar != null) {
            eVar.a(this.f26495h, this.f26496i);
        }
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        this.f26488a = new SurfaceTexture(iArr[0]);
        this.f26489b.a();
        this.f26489b.a(iArr[0]);
        this.f26492e.a();
        this.f26491d.a();
        this.f26490c.a();
        for (int i2 = 0; i2 < this.f26493f.size(); i2++) {
            this.f26493f.get(i2).f();
        }
        cu.e eVar = this.f26494g;
        if (eVar != null) {
            eVar.f();
        }
        this.f26499l.post(new Runnable() {
            public void run() {
                if (a.this.f26500m != null) {
                    a.this.f26500m.a(a.this.f26488a);
                }
            }
        });
    }
}
