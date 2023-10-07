package com.ctoo.mediaedit.tools;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.os.Build;
import android.util.Log;
import com.ctoo.mediaedit.tools.e;
import cz.b;

public class c implements b {

    /* renamed from: a  reason: collision with root package name */
    private e.h f10898a;

    /* renamed from: b  reason: collision with root package name */
    private e.i f10899b;

    /* renamed from: c  reason: collision with root package name */
    private e.j f10900c;

    /* renamed from: d  reason: collision with root package name */
    private EGLDisplay f10901d;

    /* renamed from: e  reason: collision with root package name */
    private EGLConfig f10902e;

    /* renamed from: f  reason: collision with root package name */
    private EGLContext f10903f;

    /* renamed from: g  reason: collision with root package name */
    private EGLSurface f10904g;

    public c(e.h hVar, e.i iVar, e.j jVar) {
        this.f10898a = hVar;
        this.f10899b = iVar;
        this.f10900c = jVar;
    }

    private void a(String str) {
        a(str, EGL14.eglGetError());
    }

    public static void a(String str, int i2) {
        String b2 = b.b(str, i2);
        Log.e("EglHelperAPI17", "throwEglException tid=" + Thread.currentThread().getId() + " " + b2);
        throw new RuntimeException(b2);
    }

    public static void a(String str, String str2, int i2) {
        Log.w(str, b.b(str2, i2));
    }

    private void d() {
        EGLSurface eGLSurface = this.f10904g;
        if (eGLSurface != null && eGLSurface != EGL14.EGL_NO_SURFACE) {
            EGL14.eglMakeCurrent(this.f10901d, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_SURFACE, EGL14.EGL_NO_CONTEXT);
            this.f10900c.a(this.f10901d, this.f10904g);
            this.f10904g = null;
        }
    }

    public int a() {
        if (EGL14.eglSwapBuffers(this.f10901d, this.f10904g)) {
            return 12288;
        }
        Log.w("EglHelperAPI17", String.format("swap: start get error", new Object[0]));
        return EGL14.eglGetError();
    }

    public a a(a aVar) {
        Log.w("EglHelperAPI17", "start() tid=" + Thread.currentThread().getId());
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.f10901d = eglGetDisplay;
        if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
            int[] iArr = new int[2];
            if (EGL14.eglInitialize(this.f10901d, iArr, 0, iArr, 1)) {
                EGLConfig a2 = this.f10898a.a(this.f10901d, false);
                this.f10902e = a2;
                EGLContext a3 = this.f10899b.a(this.f10901d, a2, aVar.b());
                this.f10903f = a3;
                if (a3 == null || a3 == EGL14.EGL_NO_CONTEXT) {
                    Log.d("EglHelperAPI17", "mEglContext:" + this.f10903f);
                    this.f10903f = null;
                    a("; createContext");
                }
                Log.w("EglHelperAPI17", "createContext " + this.f10903f + " tid=" + Thread.currentThread().getId());
                this.f10904g = null;
                a aVar2 = new a();
                aVar2.a(this.f10903f);
                return aVar2;
            }
            this.f10901d = null;
            throw new RuntimeException("eglInitialize failed");
        }
        throw new RuntimeException("eglGetDisplay failed");
    }

    public void a(long j2) {
        if (Build.VERSION.SDK_INT >= 18 && j2 != 0) {
            EGLExt.eglPresentationTimeANDROID(this.f10901d, this.f10904g, j2);
        }
    }

    public boolean a(Object obj) {
        Log.w("EglHelperAPI17", "createSurface()  tid=" + Thread.currentThread().getId());
        if (this.f10901d == null) {
            throw new RuntimeException("eglDisplay not initialized");
        } else if (this.f10902e != null) {
            d();
            EGLSurface a2 = this.f10900c.a(this.f10901d, this.f10902e, obj);
            this.f10904g = a2;
            if (a2 == null || a2 == EGL14.EGL_NO_SURFACE) {
                if (EGL14.eglGetError() == 12299) {
                    Log.e("EglHelperAPI17", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                Log.e("EglHelperAPI17", "EGL_NO_SURFACE");
                return false;
            }
            EGLDisplay eGLDisplay = this.f10901d;
            EGLSurface eGLSurface = this.f10904g;
            if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f10903f)) {
                return true;
            }
            a("EglHelperAPI17", "eglMakeCurrent", EGL14.eglGetError());
            return false;
        } else {
            throw new RuntimeException("mEglConfig not initialized");
        }
    }

    public void b() {
        Log.w("EglHelperAPI17", "destroySurface()  tid=" + Thread.currentThread().getId());
        d();
    }

    public void c() {
        Log.w("EglHelperAPI17", "finish() tid=" + Thread.currentThread().getId());
        EGLContext eGLContext = this.f10903f;
        if (eGLContext != null) {
            this.f10899b.a(this.f10901d, eGLContext);
            this.f10903f = null;
        }
        EGLDisplay eGLDisplay = this.f10901d;
        if (eGLDisplay != null) {
            EGL14.eglTerminate(eGLDisplay);
            this.f10901d = null;
        }
    }
}
