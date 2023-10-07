package com.google.android.exoplayer2.util;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;

public final class EGLSurfaceTexture implements SurfaceTexture.OnFrameAvailableListener, Runnable {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f17088a = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};

    /* renamed from: b  reason: collision with root package name */
    private final Handler f17089b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f17090c;

    /* renamed from: d  reason: collision with root package name */
    private final a f17091d;

    /* renamed from: e  reason: collision with root package name */
    private EGLDisplay f17092e;

    /* renamed from: f  reason: collision with root package name */
    private EGLContext f17093f;

    /* renamed from: g  reason: collision with root package name */
    private EGLSurface f17094g;

    /* renamed from: h  reason: collision with root package name */
    private SurfaceTexture f17095h;

    public static final class GlException extends RuntimeException {
        private GlException(String str) {
            super(str);
        }
    }

    public interface a {
        void a();
    }

    public EGLSurfaceTexture(Handler handler) {
        this(handler, (a) null);
    }

    public EGLSurfaceTexture(Handler handler, a aVar) {
        this.f17089b = handler;
        this.f17091d = aVar;
        this.f17090c = new int[1];
    }

    private static EGLConfig a(EGLDisplay eGLDisplay) {
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr = new int[1];
        boolean eglChooseConfig = EGL14.eglChooseConfig(eGLDisplay, f17088a, 0, eGLConfigArr, 0, 1, iArr, 0);
        if (eglChooseConfig && iArr[0] > 0 && eGLConfigArr[0] != null) {
            return eGLConfigArr[0];
        }
        throw new GlException(ad.a("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(eglChooseConfig), Integer.valueOf(iArr[0]), eGLConfigArr[0]));
    }

    private static EGLContext a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2) {
        EGLContext eglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, i2 == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, 12992, 1, 12344}, 0);
        if (eglCreateContext != null) {
            return eglCreateContext;
        }
        throw new GlException("eglCreateContext failed");
    }

    private static EGLSurface a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int i2) {
        EGLSurface eGLSurface;
        if (i2 == 1) {
            eGLSurface = EGL14.EGL_NO_SURFACE;
        } else {
            eGLSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i2 == 2 ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
            if (eGLSurface == null) {
                throw new GlException("eglCreatePbufferSurface failed");
            }
        }
        if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext)) {
            return eGLSurface;
        }
        throw new GlException("eglMakeCurrent failed");
    }

    private static void a(int[] iArr) {
        GLES20.glGenTextures(1, iArr, 0);
        i.b();
    }

    private void c() {
        a aVar = this.f17091d;
        if (aVar != null) {
            aVar.a();
        }
    }

    private static EGLDisplay d() {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        if (eglGetDisplay != null) {
            int[] iArr = new int[2];
            if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                return eglGetDisplay;
            }
            throw new GlException("eglInitialize failed");
        }
        throw new GlException("eglGetDisplay failed");
    }

    public void a() {
        this.f17089b.removeCallbacks(this);
        try {
            SurfaceTexture surfaceTexture = this.f17095h;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                GLES20.glDeleteTextures(1, this.f17090c, 0);
            }
        } finally {
            EGLDisplay eGLDisplay = this.f17092e;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglMakeCurrent(this.f17092e, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface = this.f17094g;
            if (eGLSurface != null && !eGLSurface.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.f17092e, this.f17094g);
            }
            EGLContext eGLContext = this.f17093f;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(this.f17092e, eGLContext);
            }
            if (ad.f11755a >= 19) {
                EGL14.eglReleaseThread();
            }
            EGLDisplay eGLDisplay2 = this.f17092e;
            if (eGLDisplay2 != null && !eGLDisplay2.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(this.f17092e);
            }
            this.f17092e = null;
            this.f17093f = null;
            this.f17094g = null;
            this.f17095h = null;
        }
    }

    public void a(int i2) {
        EGLDisplay d2 = d();
        this.f17092e = d2;
        EGLConfig a2 = a(d2);
        EGLContext a3 = a(this.f17092e, a2, i2);
        this.f17093f = a3;
        this.f17094g = a(this.f17092e, a2, a3, i2);
        a(this.f17090c);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f17090c[0]);
        this.f17095h = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
    }

    public SurfaceTexture b() {
        return (SurfaceTexture) a.b(this.f17095h);
    }

    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f17089b.post(this);
    }

    public void run() {
        c();
        SurfaceTexture surfaceTexture = this.f17095h;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }
}
