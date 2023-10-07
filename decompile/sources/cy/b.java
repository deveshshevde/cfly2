package cy;

import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import cu.e;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class b implements SurfaceTexture.OnFrameAvailableListener {

    /* renamed from: a  reason: collision with root package name */
    private EGL10 f26520a;

    /* renamed from: b  reason: collision with root package name */
    private EGLDisplay f26521b;

    /* renamed from: c  reason: collision with root package name */
    private EGLContext f26522c;

    /* renamed from: d  reason: collision with root package name */
    private EGLSurface f26523d;

    /* renamed from: e  reason: collision with root package name */
    private SurfaceTexture f26524e;

    /* renamed from: f  reason: collision with root package name */
    private Surface f26525f;

    /* renamed from: g  reason: collision with root package name */
    private Object f26526g = new Object();

    /* renamed from: h  reason: collision with root package name */
    private boolean f26527h;

    /* renamed from: i  reason: collision with root package name */
    private g f26528i;

    public b(int i2, int i3, Resources resources) {
        a(i2, i3, resources);
    }

    private void a(int i2, int i3, Resources resources) {
        g gVar = new g(i2, i3, resources);
        this.f26528i = gVar;
        gVar.b();
        this.f26528i.a(i2, i3);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f26528i.a());
        this.f26524e = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.f26525f = new Surface(this.f26524e);
    }

    public void a() {
        EGL10 egl10 = this.f26520a;
        if (egl10 != null) {
            if (egl10.eglGetCurrentContext().equals(this.f26522c)) {
                this.f26520a.eglMakeCurrent(this.f26521b, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            }
            this.f26520a.eglDestroySurface(this.f26521b, this.f26523d);
            this.f26520a.eglDestroyContext(this.f26521b, this.f26522c);
        }
        this.f26525f.release();
        this.f26521b = null;
        this.f26522c = null;
        this.f26523d = null;
        this.f26520a = null;
        this.f26528i = null;
        this.f26525f = null;
        this.f26524e = null;
    }

    public void a(int i2, int i3) {
        this.f26528i.a(i2, i3);
    }

    public void a(e eVar) {
        this.f26528i.a(eVar);
    }

    public Surface b() {
        return this.f26525f;
    }

    public void c() {
        synchronized (this.f26526g) {
            while (!this.f26527h) {
                try {
                    this.f26526g.wait(1000);
                    if (!this.f26527h) {
                        throw new RuntimeException("Surface frame wait timed out");
                    }
                } catch (InterruptedException e2) {
                    throw new RuntimeException(e2);
                }
            }
            this.f26527h = false;
        }
        this.f26524e.updateTexImage();
    }

    public void d() {
        this.f26528i.a(this.f26524e);
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.f26526g) {
            if (!this.f26527h) {
                this.f26527h = true;
                this.f26526g.notifyAll();
            } else {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
        }
    }
}
