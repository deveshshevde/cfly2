package com.ctoo.mediaedit.tools;

import android.opengl.EGL14;
import android.os.Build;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

public class a {

    /* renamed from: c  reason: collision with root package name */
    public static a f10887c = new C0085a();

    /* renamed from: a  reason: collision with root package name */
    protected EGLContext f10888a;

    /* renamed from: b  reason: collision with root package name */
    protected android.opengl.EGLContext f10889b;

    /* renamed from: com.ctoo.mediaedit.tools.a$a  reason: collision with other inner class name */
    public static class C0085a extends a {
        public C0085a() {
            this.f10888a = EGL10.EGL_NO_CONTEXT;
            if (Build.VERSION.SDK_INT >= 17) {
                this.f10889b = EGL14.EGL_NO_CONTEXT;
            }
        }

        public void a(android.opengl.EGLContext eGLContext) {
        }

        public void a(EGLContext eGLContext) {
        }
    }

    public EGLContext a() {
        return this.f10888a;
    }

    public void a(android.opengl.EGLContext eGLContext) {
        this.f10889b = eGLContext;
    }

    public void a(EGLContext eGLContext) {
        this.f10888a = eGLContext;
    }

    public android.opengl.EGLContext b() {
        return this.f10889b;
    }
}
