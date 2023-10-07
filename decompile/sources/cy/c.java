package cy;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;
import java.util.Objects;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private EGLDisplay f26529a;

    /* renamed from: b  reason: collision with root package name */
    private EGLContext f26530b;

    /* renamed from: c  reason: collision with root package name */
    private EGLSurface f26531c;

    /* renamed from: d  reason: collision with root package name */
    private Surface f26532d;

    public c(Surface surface) {
        Objects.requireNonNull(surface);
        this.f26532d = surface;
        d();
    }

    private void a(String str) {
        boolean z2 = false;
        while (true) {
            int eglGetError = EGL14.eglGetError();
            if (eglGetError == 12288) {
                break;
            }
            Log.e("EncoderSurface", str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            z2 = true;
        }
        if (z2) {
            throw new RuntimeException("EGL error encountered (see log)");
        }
    }

    private void d() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.f26529a = eglGetDisplay;
        if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
            int[] iArr = new int[2];
            if (EGL14.eglInitialize(this.f26529a, iArr, 0, iArr, 1)) {
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                if (EGL14.eglChooseConfig(this.f26529a, new int[]{12324, 8, 12323, 8, 12322, 8, 12352, 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                    this.f26530b = EGL14.eglCreateContext(this.f26529a, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                    a("eglCreateContext");
                    if (this.f26530b != null) {
                        this.f26531c = EGL14.eglCreateWindowSurface(this.f26529a, eGLConfigArr[0], this.f26532d, new int[]{12344}, 0);
                        a("eglCreateWindowSurface");
                        if (this.f26531c == null) {
                            throw new RuntimeException("surface was null");
                        }
                        return;
                    }
                    throw new RuntimeException("null context");
                }
                throw new RuntimeException("unable to find RGB888+recordable ES2 EGL config");
            }
            this.f26529a = null;
            throw new RuntimeException("unable to initialize EGL14");
        }
        throw new RuntimeException("unable to get EGL14 display");
    }

    public void a() {
        if (EGL14.eglGetCurrentContext().equals(this.f26530b)) {
            EGL14.eglMakeCurrent(this.f26529a, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
        }
        EGL14.eglDestroySurface(this.f26529a, this.f26531c);
        EGL14.eglDestroyContext(this.f26529a, this.f26530b);
        this.f26532d.release();
        this.f26529a = null;
        this.f26530b = null;
        this.f26531c = null;
        this.f26532d = null;
    }

    public void a(long j2) {
        EGLExt.eglPresentationTimeANDROID(this.f26529a, this.f26531c, j2);
    }

    public void b() {
        EGLDisplay eGLDisplay = this.f26529a;
        EGLSurface eGLSurface = this.f26531c;
        if (!EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f26530b)) {
            throw new RuntimeException("eglMakeCurrent failed");
        }
    }

    public boolean c() {
        return EGL14.eglSwapBuffers(this.f26529a, this.f26531c);
    }
}
