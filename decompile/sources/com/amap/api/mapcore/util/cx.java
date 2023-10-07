package com.amap.api.mapcore.util;

import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public final class cx {

    public static class a extends cv {

        /* renamed from: g  reason: collision with root package name */
        private static int f8214g = 4;

        /* renamed from: a  reason: collision with root package name */
        protected int f8215a = 5;

        /* renamed from: b  reason: collision with root package name */
        protected int f8216b = 6;

        /* renamed from: c  reason: collision with root package name */
        protected int f8217c = 5;

        /* renamed from: d  reason: collision with root package name */
        protected int f8218d = 0;

        /* renamed from: e  reason: collision with root package name */
        protected int f8219e = 16;

        /* renamed from: f  reason: collision with root package name */
        protected int f8220f = 8;

        /* renamed from: h  reason: collision with root package name */
        private int[] f8221h = new int[1];

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, this.f8221h)) {
                return this.f8221h[0];
            }
            return 0;
        }

        private c a(EGL10 egl10, EGLDisplay eGLDisplay) {
            c cVar = new c((byte) 0);
            cVar.f8222a = a(true);
            egl10.eglChooseConfig(eGLDisplay, cVar.f8222a, (EGLConfig[]) null, 0, cVar.f8223b);
            if (cVar.f8223b[0] <= 0) {
                cVar.f8222a = a(false);
                egl10.eglChooseConfig(eGLDisplay, cVar.f8222a, (EGLConfig[]) null, 0, cVar.f8223b);
                if (cVar.f8223b[0] <= 0) {
                    return null;
                }
            }
            return cVar;
        }

        private EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12325);
                int a3 = a(egl10, eGLDisplay, eGLConfig, 12326);
                if (a2 >= this.f8219e && a3 >= this.f8220f) {
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12324);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, 12323);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, 12322);
                    int a7 = a(egl10, eGLDisplay, eGLConfig, 12321);
                    if (a4 == this.f8215a && a5 == this.f8216b && a6 == this.f8217c && a7 == this.f8218d) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }

        private int[] a(boolean z2) {
            return new int[]{12324, this.f8215a, 12323, this.f8216b, 12322, this.f8217c, 12321, this.f8218d, 12325, this.f8219e, 12326, this.f8220f, 12338, z2, 12352, f8214g, 12344};
        }

        public final EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            c a2 = a(egl10, eGLDisplay);
            if (a2 == null || a2.f8222a == null) {
                return null;
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[a2.f8223b[0]];
            egl10.eglChooseConfig(eGLDisplay, a2.f8222a, eGLConfigArr, a2.f8223b[0], a2.f8223b);
            EGLConfig a3 = a(egl10, eGLDisplay, eGLConfigArr);
            if (a3 != null) {
                return a3;
            }
            this.f8215a = 8;
            this.f8216b = 8;
            this.f8217c = 8;
            c a4 = a(egl10, eGLDisplay);
            if (a4 == null || a4.f8222a == null) {
                return a3;
            }
            EGLConfig[] eGLConfigArr2 = new EGLConfig[a4.f8223b[0]];
            egl10.eglChooseConfig(eGLDisplay, a4.f8222a, eGLConfigArr2, a4.f8223b[0], a4.f8223b);
            return a(egl10, eGLDisplay, eGLConfigArr2);
        }
    }

    public static class b extends cw {
        public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            try {
                return egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            egl10.eglDestroyContext(eGLDisplay, eGLContext);
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        public int[] f8222a;

        /* renamed from: b  reason: collision with root package name */
        public int[] f8223b;

        private c() {
            this.f8222a = null;
            this.f8223b = new int[1];
        }

        /* synthetic */ c(byte b2) {
            this();
        }
    }

    public static void a(IGLSurfaceView iGLSurfaceView) {
        iGLSurfaceView.setEGLContextFactory(new b());
        iGLSurfaceView.setEGLConfigChooser(new a());
    }
}
