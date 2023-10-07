package com.ctoo.mediaedit.tools;

import android.util.Log;
import com.ctoo.mediaedit.tools.e;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class b implements cz.b {

    /* renamed from: a  reason: collision with root package name */
    private e.h f10890a;

    /* renamed from: b  reason: collision with root package name */
    private e.i f10891b;

    /* renamed from: c  reason: collision with root package name */
    private e.j f10892c;

    /* renamed from: d  reason: collision with root package name */
    private EGL10 f10893d;

    /* renamed from: e  reason: collision with root package name */
    private EGLDisplay f10894e;

    /* renamed from: f  reason: collision with root package name */
    private EGLSurface f10895f;

    /* renamed from: g  reason: collision with root package name */
    private EGLConfig f10896g;

    /* renamed from: h  reason: collision with root package name */
    private EGLContext f10897h;

    public b(e.h hVar, e.i iVar, e.j jVar) {
        this.f10890a = hVar;
        this.f10891b = iVar;
        this.f10892c = jVar;
    }

    private void a(String str) {
        a(str, this.f10893d.eglGetError());
    }

    public static void a(String str, int i2) {
        String b2 = b(str, i2);
        Log.e("EglHelper", "throwEglException tid=" + Thread.currentThread().getId() + " " + b2);
        throw new RuntimeException(b2);
    }

    public static void a(String str, String str2, int i2) {
        Log.w(str, b(str2, i2));
    }

    public static String b(String str, int i2) {
        return str + " failed: " + i2;
    }

    private void d() {
        EGLSurface eGLSurface = this.f10895f;
        if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
            this.f10893d.eglMakeCurrent(this.f10894e, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
            this.f10892c.a(this.f10893d, this.f10894e, this.f10895f);
            this.f10895f = null;
        }
    }

    public int a() {
        if (!this.f10893d.eglSwapBuffers(this.f10894e, this.f10895f)) {
            return this.f10893d.eglGetError();
        }
        return 12288;
    }

    public a a(a aVar) {
        Log.w("EglHelper", "start() tid=" + Thread.currentThread().getId());
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.f10893d = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f10894e = eglGetDisplay;
        if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
            if (this.f10893d.eglInitialize(this.f10894e, new int[2])) {
                EGLConfig a2 = this.f10890a.a(this.f10893d, this.f10894e);
                this.f10896g = a2;
                EGLContext a3 = this.f10891b.a(this.f10893d, this.f10894e, a2, aVar.a());
                this.f10897h = a3;
                if (a3 == null || a3 == EGL10.EGL_NO_CONTEXT) {
                    this.f10897h = null;
                    a("createContext");
                }
                Log.w("EglHelper", "createContext " + this.f10897h + " tid=" + Thread.currentThread().getId());
                this.f10895f = null;
                a aVar2 = new a();
                aVar2.a(this.f10897h);
                return aVar2;
            }
            throw new RuntimeException("eglInitialize failed");
        }
        throw new RuntimeException("eglGetDisplay failed");
    }

    public void a(long j2) {
    }

    public boolean a(Object obj) {
        Log.w("EglHelper", "createSurface()  tid=" + Thread.currentThread().getId());
        if (this.f10893d == null) {
            throw new RuntimeException("egl not initialized");
        } else if (this.f10894e == null) {
            throw new RuntimeException("eglDisplay not initialized");
        } else if (this.f10896g != null) {
            d();
            EGLSurface a2 = this.f10892c.a(this.f10893d, this.f10894e, this.f10896g, obj);
            this.f10895f = a2;
            if (a2 == null || a2 == EGL10.EGL_NO_SURFACE) {
                if (this.f10893d.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            }
            EGL10 egl10 = this.f10893d;
            EGLDisplay eGLDisplay = this.f10894e;
            EGLSurface eGLSurface = this.f10895f;
            if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.f10897h)) {
                return true;
            }
            a("EGLHelper", "eglMakeCurrent", this.f10893d.eglGetError());
            return false;
        } else {
            throw new RuntimeException("mEglConfig not initialized");
        }
    }

    public void b() {
        Log.w("EglHelper", "destroySurface()  tid=" + Thread.currentThread().getId());
        d();
    }

    public void c() {
        Log.w("EglHelper", "finish() tid=" + Thread.currentThread().getId());
        EGLContext eGLContext = this.f10897h;
        if (eGLContext != null) {
            this.f10891b.a(this.f10893d, this.f10894e, eGLContext);
            this.f10897h = null;
        }
        EGLDisplay eGLDisplay = this.f10894e;
        if (eGLDisplay != null) {
            this.f10893d.eglTerminate(eGLDisplay);
            this.f10894e = null;
        }
    }
}
