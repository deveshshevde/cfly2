package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLDebugHelper;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.TextureView;
import com.amap.api.maps.MapsInitializer;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

public class m extends TextureView implements TextureView.SurfaceTextureListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final j f9559a = new j((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<m> f9560b = new WeakReference<>(this);

    /* renamed from: c  reason: collision with root package name */
    private i f9561c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public GLSurfaceView.Renderer f9562d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9563e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public e f9564f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public f f9565g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public g f9566h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public k f9567i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public int f9568j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public int f9569k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public boolean f9570l;

    private abstract class a implements e {

        /* renamed from: a  reason: collision with root package name */
        protected int[] f9571a;

        public a(int[] iArr) {
            this.f9571a = a(iArr);
        }

        private int[] a(int[] iArr) {
            if (m.this.f9569k != 2 && m.this.f9569k != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[(length + 2)];
            int i2 = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            iArr2[i2] = 12352;
            if (m.this.f9569k == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        /* access modifiers changed from: package-private */
        public abstract EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.f9571a, (EGLConfig[]) null, 0, iArr)) {
                int i2 = iArr[0];
                if (i2 > 0) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[i2];
                    if (egl10.eglChooseConfig(eGLDisplay, this.f9571a, eGLConfigArr, i2, iArr)) {
                        EGLConfig a2 = a(egl10, eGLDisplay, eGLConfigArr);
                        if (a2 != null) {
                            return a2;
                        }
                        throw new IllegalArgumentException("No config chosen");
                    }
                    throw new IllegalArgumentException("eglChooseConfig#2 failed");
                }
                throw new IllegalArgumentException("No configs match configSpec");
            }
            throw new IllegalArgumentException("eglChooseConfig failed");
        }
    }

    private class b extends a {

        /* renamed from: c  reason: collision with root package name */
        protected int f9573c = 8;

        /* renamed from: d  reason: collision with root package name */
        protected int f9574d = 8;

        /* renamed from: e  reason: collision with root package name */
        protected int f9575e = 8;

        /* renamed from: f  reason: collision with root package name */
        protected int f9576f = 0;

        /* renamed from: g  reason: collision with root package name */
        protected int f9577g = 16;

        /* renamed from: h  reason: collision with root package name */
        protected int f9578h = 0;

        /* renamed from: j  reason: collision with root package name */
        private int[] f9580j = new int[1];

        public b() {
            super(new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 0, 12325, 16, 12326, 0, 12344});
        }

        private int a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i2) {
            if (egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, this.f9580j)) {
                return this.f9580j[0];
            }
            return 0;
        }

        public final EGLConfig a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int a2 = a(egl10, eGLDisplay, eGLConfig, 12325);
                int a3 = a(egl10, eGLDisplay, eGLConfig, 12326);
                if (a2 >= this.f9577g && a3 >= this.f9578h) {
                    int a4 = a(egl10, eGLDisplay, eGLConfig, 12324);
                    int a5 = a(egl10, eGLDisplay, eGLConfig, 12323);
                    int a6 = a(egl10, eGLDisplay, eGLConfig, 12322);
                    int a7 = a(egl10, eGLDisplay, eGLConfig, 12321);
                    if (a4 == this.f9573c && a5 == this.f9574d && a6 == this.f9575e && a7 == this.f9576f) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }
    }

    private class c implements f {
        private c() {
        }

        /* synthetic */ c(m mVar, byte b2) {
            this();
        }

        public final EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {12440, m.this.f9569k, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (m.this.f9569k == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        public final void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
                h.a("eglDestroyContex", egl10.eglGetError());
            }
        }
    }

    private static class d implements g {
        private d() {
        }

        /* synthetic */ d(byte b2) {
            this();
        }

        public final EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, (int[]) null);
            } catch (IllegalArgumentException e2) {
                Log.e("GLSurfaceView", "eglCreateWindowSurface", e2);
                return null;
            }
        }

        public final void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    public interface e {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    public interface f {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    public interface g {
        EGLSurface a(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void a(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    private static class h {

        /* renamed from: a  reason: collision with root package name */
        EGL10 f9582a;

        /* renamed from: b  reason: collision with root package name */
        EGLDisplay f9583b;

        /* renamed from: c  reason: collision with root package name */
        EGLSurface f9584c;

        /* renamed from: d  reason: collision with root package name */
        EGLConfig f9585d;

        /* renamed from: e  reason: collision with root package name */
        EGLContext f9586e;

        /* renamed from: f  reason: collision with root package name */
        private WeakReference<m> f9587f;

        public h(WeakReference<m> weakReference) {
            this.f9587f = weakReference;
        }

        private void a(String str) {
            a(str, this.f9582a.eglGetError());
        }

        public static void a(String str, int i2) {
            throw new RuntimeException(b(str, i2));
        }

        public static void a(String str, String str2, int i2) {
            Log.w(str, b(str2, i2));
        }

        private static String b(String str, int i2) {
            return str + " failed: " + i2;
        }

        private void g() {
            EGLSurface eGLSurface = this.f9584c;
            if (eGLSurface != null && eGLSurface != EGL10.EGL_NO_SURFACE) {
                EGL10 egl10 = this.f9582a;
                EGLDisplay eGLDisplay = this.f9583b;
                EGLSurface eGLSurface2 = EGL10.EGL_NO_SURFACE;
                egl10.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, EGL10.EGL_NO_CONTEXT);
                m mVar = (m) this.f9587f.get();
                if (mVar != null) {
                    mVar.f9566h.a(this.f9582a, this.f9583b, this.f9584c);
                }
                this.f9584c = null;
            }
        }

        public final void a() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.f9582a = egl10;
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            this.f9583b = eglGetDisplay;
            if (eglGetDisplay != EGL10.EGL_NO_DISPLAY) {
                if (this.f9582a.eglInitialize(this.f9583b, new int[2])) {
                    m mVar = (m) this.f9587f.get();
                    if (mVar == null) {
                        this.f9585d = null;
                        this.f9586e = null;
                    } else {
                        this.f9585d = mVar.f9564f.chooseConfig(this.f9582a, this.f9583b);
                        this.f9586e = mVar.f9565g.createContext(this.f9582a, this.f9583b, this.f9585d);
                    }
                    EGLContext eGLContext = this.f9586e;
                    if (eGLContext == null || eGLContext == EGL10.EGL_NO_CONTEXT) {
                        this.f9586e = null;
                        a("createContext");
                    }
                    this.f9584c = null;
                    return;
                }
                throw new RuntimeException("eglInitialize failed");
            }
            throw new RuntimeException("eglGetDisplay failed");
        }

        public final boolean b() {
            if (this.f9582a == null) {
                throw new RuntimeException("egl not initialized");
            } else if (this.f9583b == null) {
                throw new RuntimeException("eglDisplay not initialized");
            } else if (this.f9585d != null) {
                g();
                m mVar = (m) this.f9587f.get();
                this.f9584c = mVar != null ? mVar.f9566h.a(this.f9582a, this.f9583b, this.f9585d, mVar.getSurfaceTexture()) : null;
                EGLSurface eGLSurface = this.f9584c;
                if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                    if (this.f9582a.eglGetError() == 12299) {
                        Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                    }
                    return false;
                }
                EGL10 egl10 = this.f9582a;
                EGLDisplay eGLDisplay = this.f9583b;
                EGLSurface eGLSurface2 = this.f9584c;
                if (egl10.eglMakeCurrent(eGLDisplay, eGLSurface2, eGLSurface2, this.f9586e)) {
                    return true;
                }
                a("EGLHelper", "eglMakeCurrent", this.f9582a.eglGetError());
                return false;
            } else {
                throw new RuntimeException("mEglConfig not initialized");
            }
        }

        /* access modifiers changed from: package-private */
        public final GL c() {
            GL gl2 = this.f9586e.getGL();
            m mVar = (m) this.f9587f.get();
            if (mVar == null) {
                return gl2;
            }
            if (mVar.f9567i != null) {
                gl2 = mVar.f9567i.a();
            }
            if ((mVar.f9568j & 3) == 0) {
                return gl2;
            }
            int i2 = 0;
            l lVar = null;
            if ((mVar.f9568j & 1) != 0) {
                i2 = 1;
            }
            if ((mVar.f9568j & 2) != 0) {
                lVar = new l();
            }
            return GLDebugHelper.wrap(gl2, i2, lVar);
        }

        public final int d() {
            if (!this.f9582a.eglSwapBuffers(this.f9583b, this.f9584c)) {
                return this.f9582a.eglGetError();
            }
            return 12288;
        }

        public final void e() {
            g();
        }

        public final void f() {
            if (this.f9586e != null) {
                m mVar = (m) this.f9587f.get();
                if (mVar != null) {
                    mVar.f9565g.destroyContext(this.f9582a, this.f9583b, this.f9586e);
                }
                this.f9586e = null;
            }
            EGLDisplay eGLDisplay = this.f9583b;
            if (eGLDisplay != null) {
                this.f9582a.eglTerminate(eGLDisplay);
                this.f9583b = null;
            }
        }
    }

    static class i extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private boolean f9588a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public boolean f9589b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f9590c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f9591d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f9592e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f9593f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f9594g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f9595h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f9596i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f9597j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f9598k;

        /* renamed from: l  reason: collision with root package name */
        private int f9599l = 0;

        /* renamed from: m  reason: collision with root package name */
        private int f9600m = 0;

        /* renamed from: n  reason: collision with root package name */
        private int f9601n = 1;

        /* renamed from: o  reason: collision with root package name */
        private boolean f9602o = true;

        /* renamed from: p  reason: collision with root package name */
        private boolean f9603p;

        /* renamed from: q  reason: collision with root package name */
        private ArrayList<Runnable> f9604q = new ArrayList<>();

        /* renamed from: r  reason: collision with root package name */
        private boolean f9605r = true;

        /* renamed from: s  reason: collision with root package name */
        private h f9606s;

        /* renamed from: t  reason: collision with root package name */
        private WeakReference<m> f9607t;

        i(WeakReference<m> weakReference) {
            this.f9607t = weakReference;
        }

        private void k() {
            if (this.f9596i) {
                this.f9596i = false;
                this.f9606s.e();
            }
        }

        private void l() {
            if (this.f9595h) {
                this.f9606s.f();
                this.f9595h = false;
                m.f9559a.c(this);
            }
        }

        /* JADX WARNING: type inference failed for: r2v24, types: [javax.microedition.khronos.opengles.GL] */
        /* JADX WARNING: Code restructure failed: missing block: B:100:0x0160, code lost:
            r2 = com.amap.api.mapcore.util.m.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:101:0x0164, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:104:?, code lost:
            r1.f9597j = true;
            com.amap.api.mapcore.util.m.d().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:105:0x016f, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x0170, code lost:
            r8 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:111:0x0175, code lost:
            r2 = com.amap.api.mapcore.util.m.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:112:0x0179, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:115:?, code lost:
            r1.f9597j = true;
            r1.f9593f = true;
            com.amap.api.mapcore.util.m.d().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:116:0x0186, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:122:0x018c, code lost:
            if (r9 == false) goto L_0x019f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:123:0x018e, code lost:
            r6 = r1.f9606s.c();
            com.amap.api.mapcore.util.m.d().a(r6);
            r9 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:124:0x019f, code lost:
            if (r7 == false) goto L_0x01b7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:125:0x01a1, code lost:
            r2 = (com.amap.api.mapcore.util.m) r1.f9607t.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:126:0x01a9, code lost:
            if (r2 == null) goto L_0x01b6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:127:0x01ab, code lost:
            com.amap.api.mapcore.util.m.h(r2).onSurfaceCreated(r6, r1.f9606s.f9585d);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:128:0x01b6, code lost:
            r7 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:129:0x01b7, code lost:
            if (r10 == false) goto L_0x01cb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:130:0x01b9, code lost:
            r2 = (com.amap.api.mapcore.util.m) r1.f9607t.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:131:0x01c1, code lost:
            if (r2 == null) goto L_0x01ca;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:132:0x01c3, code lost:
            com.amap.api.mapcore.util.m.h(r2).onSurfaceChanged(r6, r11, r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:133:0x01ca, code lost:
            r10 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:134:0x01cb, code lost:
            r2 = (com.amap.api.mapcore.util.m) r1.f9607t.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:135:0x01d3, code lost:
            if (r2 == null) goto L_0x01dc;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:136:0x01d5, code lost:
            com.amap.api.mapcore.util.m.h(r2).onDrawFrame(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:137:0x01dc, code lost:
            r2 = r1.f9606s.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:138:0x01e4, code lost:
            if (r2 == 12288) goto L_0x0208;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:140:0x01e8, code lost:
            if (r2 == 12302) goto L_0x0205;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:141:0x01ea, code lost:
            com.amap.api.mapcore.util.m.h.a("GLThread", "eglSwapBuffers", r2);
            r2 = com.amap.api.mapcore.util.m.d();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:142:0x01f5, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:145:?, code lost:
            r1.f9593f = true;
            com.amap.api.mapcore.util.m.d().notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:146:0x0200, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:152:0x0205, code lost:
            r3 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:154:0x0209, code lost:
            if (r13 == false) goto L_0x020c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:155:0x020b, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x014f, code lost:
            if (r14 == null) goto L_0x0156;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:0x0156, code lost:
            if (r8 == false) goto L_0x018c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x015e, code lost:
            if (r1.f9606s.b() == false) goto L_0x0175;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m() throws java.lang.InterruptedException {
            /*
                r16 = this;
                r1 = r16
                com.amap.api.mapcore.util.m$h r0 = new com.amap.api.mapcore.util.m$h
                java.lang.ref.WeakReference<com.amap.api.mapcore.util.m> r2 = r1.f9607t
                r0.<init>(r2)
                r1.f9606s = r0
                r0 = 0
                r1.f9595h = r0
                r1.f9596i = r0
                r3 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
            L_0x001b:
                r14 = 0
            L_0x001c:
                com.amap.api.mapcore.util.m$j r15 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ all -> 0x021c }
                monitor-enter(r15)     // Catch:{ all -> 0x021c }
            L_0x0021:
                boolean r2 = r1.f9588a     // Catch:{ all -> 0x0219 }
                if (r2 == 0) goto L_0x0036
                monitor-exit(r15)     // Catch:{ all -> 0x0219 }
                com.amap.api.mapcore.util.m$j r2 = com.amap.api.mapcore.util.m.f9559a
                monitor-enter(r2)
                r16.k()     // Catch:{ all -> 0x0033 }
                r16.l()     // Catch:{ all -> 0x0033 }
                monitor-exit(r2)     // Catch:{ all -> 0x0033 }
                return
            L_0x0033:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0033 }
                throw r0
            L_0x0036:
                java.util.ArrayList<java.lang.Runnable> r2 = r1.f9604q     // Catch:{ all -> 0x0219 }
                boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x0219 }
                if (r2 != 0) goto L_0x004b
                java.util.ArrayList<java.lang.Runnable> r2 = r1.f9604q     // Catch:{ all -> 0x0219 }
                r14 = 0
                java.lang.Object r2 = r2.remove(r14)     // Catch:{ all -> 0x0219 }
                r14 = r2
                java.lang.Runnable r14 = (java.lang.Runnable) r14     // Catch:{ all -> 0x0219 }
                r0 = 0
                goto L_0x014e
            L_0x004b:
                boolean r2 = r1.f9591d     // Catch:{ all -> 0x0219 }
                boolean r0 = r1.f9590c     // Catch:{ all -> 0x0219 }
                if (r2 == r0) goto L_0x005b
                r1.f9591d = r0     // Catch:{ all -> 0x0219 }
                com.amap.api.mapcore.util.m$j r2 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ all -> 0x0219 }
                r2.notifyAll()     // Catch:{ all -> 0x0219 }
                goto L_0x005c
            L_0x005b:
                r0 = 0
            L_0x005c:
                boolean r2 = r1.f9598k     // Catch:{ all -> 0x0219 }
                if (r2 == 0) goto L_0x006a
                r16.k()     // Catch:{ all -> 0x0219 }
                r16.l()     // Catch:{ all -> 0x0219 }
                r2 = 0
                r1.f9598k = r2     // Catch:{ all -> 0x0219 }
                r5 = 1
            L_0x006a:
                if (r3 == 0) goto L_0x0073
                r16.k()     // Catch:{ all -> 0x0219 }
                r16.l()     // Catch:{ all -> 0x0219 }
                r3 = 0
            L_0x0073:
                if (r0 == 0) goto L_0x007c
                boolean r2 = r1.f9596i     // Catch:{ all -> 0x0219 }
                if (r2 == 0) goto L_0x007c
                r16.k()     // Catch:{ all -> 0x0219 }
            L_0x007c:
                if (r0 == 0) goto L_0x00a1
                boolean r2 = r1.f9595h     // Catch:{ all -> 0x0219 }
                if (r2 == 0) goto L_0x00a1
                java.lang.ref.WeakReference<com.amap.api.mapcore.util.m> r2 = r1.f9607t     // Catch:{ all -> 0x0219 }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0219 }
                com.amap.api.mapcore.util.m r2 = (com.amap.api.mapcore.util.m) r2     // Catch:{ all -> 0x0219 }
                if (r2 != 0) goto L_0x008e
                r2 = 0
                goto L_0x0092
            L_0x008e:
                boolean r2 = r2.f9570l     // Catch:{ all -> 0x0219 }
            L_0x0092:
                if (r2 == 0) goto L_0x009e
                com.amap.api.mapcore.util.m$j r2 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ all -> 0x0219 }
                boolean r2 = r2.a()     // Catch:{ all -> 0x0219 }
                if (r2 == 0) goto L_0x00a1
            L_0x009e:
                r16.l()     // Catch:{ all -> 0x0219 }
            L_0x00a1:
                if (r0 == 0) goto L_0x00b2
                com.amap.api.mapcore.util.m$j r0 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ all -> 0x0219 }
                boolean r0 = r0.b()     // Catch:{ all -> 0x0219 }
                if (r0 == 0) goto L_0x00b2
                com.amap.api.mapcore.util.m$h r0 = r1.f9606s     // Catch:{ all -> 0x0219 }
                r0.f()     // Catch:{ all -> 0x0219 }
            L_0x00b2:
                boolean r0 = r1.f9592e     // Catch:{ all -> 0x0219 }
                if (r0 != 0) goto L_0x00ce
                boolean r0 = r1.f9594g     // Catch:{ all -> 0x0219 }
                if (r0 != 0) goto L_0x00ce
                boolean r0 = r1.f9596i     // Catch:{ all -> 0x0219 }
                if (r0 == 0) goto L_0x00c1
                r16.k()     // Catch:{ all -> 0x0219 }
            L_0x00c1:
                r0 = 1
                r1.f9594g = r0     // Catch:{ all -> 0x0219 }
                r0 = 0
                r1.f9593f = r0     // Catch:{ all -> 0x0219 }
                com.amap.api.mapcore.util.m$j r0 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ all -> 0x0219 }
                r0.notifyAll()     // Catch:{ all -> 0x0219 }
            L_0x00ce:
                boolean r0 = r1.f9592e     // Catch:{ all -> 0x0219 }
                if (r0 == 0) goto L_0x00e0
                boolean r0 = r1.f9594g     // Catch:{ all -> 0x0219 }
                if (r0 == 0) goto L_0x00e0
                r0 = 0
                r1.f9594g = r0     // Catch:{ all -> 0x0219 }
                com.amap.api.mapcore.util.m$j r0 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ all -> 0x0219 }
                r0.notifyAll()     // Catch:{ all -> 0x0219 }
            L_0x00e0:
                if (r4 == 0) goto L_0x00ee
                r0 = 1
                r1.f9603p = r0     // Catch:{ all -> 0x0219 }
                com.amap.api.mapcore.util.m$j r0 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ all -> 0x0219 }
                r0.notifyAll()     // Catch:{ all -> 0x0219 }
                r4 = 0
                r13 = 0
            L_0x00ee:
                boolean r0 = r16.o()     // Catch:{ all -> 0x0219 }
                if (r0 == 0) goto L_0x020f
                boolean r0 = r1.f9595h     // Catch:{ all -> 0x0219 }
                if (r0 != 0) goto L_0x0120
                if (r5 == 0) goto L_0x00fc
                r5 = 0
                goto L_0x0120
            L_0x00fc:
                com.amap.api.mapcore.util.m$j r0 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ all -> 0x0219 }
                boolean r0 = r0.b(r1)     // Catch:{ all -> 0x0219 }
                if (r0 == 0) goto L_0x0120
                com.amap.api.mapcore.util.m$h r0 = r1.f9606s     // Catch:{ RuntimeException -> 0x0117 }
                r0.a()     // Catch:{ RuntimeException -> 0x0117 }
                r0 = 1
                r1.f9595h = r0     // Catch:{ all -> 0x0219 }
                com.amap.api.mapcore.util.m$j r0 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ all -> 0x0219 }
                r0.notifyAll()     // Catch:{ all -> 0x0219 }
                r7 = 1
                goto L_0x0120
            L_0x0117:
                r0 = move-exception
                com.amap.api.mapcore.util.m$j r2 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ all -> 0x0219 }
                r2.c(r1)     // Catch:{ all -> 0x0219 }
                throw r0     // Catch:{ all -> 0x0219 }
            L_0x0120:
                boolean r0 = r1.f9595h     // Catch:{ all -> 0x0219 }
                if (r0 == 0) goto L_0x012e
                boolean r0 = r1.f9596i     // Catch:{ all -> 0x0219 }
                if (r0 != 0) goto L_0x012e
                r0 = 1
                r1.f9596i = r0     // Catch:{ all -> 0x0219 }
                r8 = 1
                r9 = 1
                r10 = 1
            L_0x012e:
                boolean r0 = r1.f9596i     // Catch:{ all -> 0x0219 }
                if (r0 == 0) goto L_0x020f
                boolean r0 = r1.f9605r     // Catch:{ all -> 0x0219 }
                if (r0 == 0) goto L_0x0144
                int r0 = r1.f9599l     // Catch:{ all -> 0x0219 }
                int r2 = r1.f9600m     // Catch:{ all -> 0x0219 }
                r8 = 0
                r1.f9605r = r8     // Catch:{ all -> 0x0219 }
                r11 = r0
                r12 = r2
                r0 = 0
                r8 = 1
                r10 = 1
                r13 = 1
                goto L_0x0145
            L_0x0144:
                r0 = 0
            L_0x0145:
                r1.f9602o = r0     // Catch:{ all -> 0x0219 }
                com.amap.api.mapcore.util.m$j r2 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ all -> 0x0219 }
                r2.notifyAll()     // Catch:{ all -> 0x0219 }
            L_0x014e:
                monitor-exit(r15)     // Catch:{ all -> 0x0219 }
                if (r14 == 0) goto L_0x0156
                r14.run()     // Catch:{ all -> 0x021c }
                goto L_0x001b
            L_0x0156:
                if (r8 == 0) goto L_0x018c
                com.amap.api.mapcore.util.m$h r2 = r1.f9606s     // Catch:{ all -> 0x021c }
                boolean r2 = r2.b()     // Catch:{ all -> 0x021c }
                if (r2 == 0) goto L_0x0175
                com.amap.api.mapcore.util.m$j r2 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ all -> 0x021c }
                monitor-enter(r2)     // Catch:{ all -> 0x021c }
                r8 = 1
                r1.f9597j = r8     // Catch:{ all -> 0x0172 }
                com.amap.api.mapcore.util.m$j r8 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ all -> 0x0172 }
                r8.notifyAll()     // Catch:{ all -> 0x0172 }
                monitor-exit(r2)     // Catch:{ all -> 0x0172 }
                r8 = 0
                goto L_0x018c
            L_0x0172:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0172 }
                throw r0     // Catch:{ all -> 0x021c }
            L_0x0175:
                com.amap.api.mapcore.util.m$j r2 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ all -> 0x021c }
                monitor-enter(r2)     // Catch:{ all -> 0x021c }
                r15 = 1
                r1.f9597j = r15     // Catch:{ all -> 0x0189 }
                r1.f9593f = r15     // Catch:{ all -> 0x0189 }
                com.amap.api.mapcore.util.m$j r15 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ all -> 0x0189 }
                r15.notifyAll()     // Catch:{ all -> 0x0189 }
                monitor-exit(r2)     // Catch:{ all -> 0x0189 }
                goto L_0x001c
            L_0x0189:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0189 }
                throw r0     // Catch:{ all -> 0x021c }
            L_0x018c:
                if (r9 == 0) goto L_0x019f
                com.amap.api.mapcore.util.m$h r2 = r1.f9606s     // Catch:{ all -> 0x021c }
                javax.microedition.khronos.opengles.GL r2 = r2.c()     // Catch:{ all -> 0x021c }
                r6 = r2
                javax.microedition.khronos.opengles.GL10 r6 = (javax.microedition.khronos.opengles.GL10) r6     // Catch:{ all -> 0x021c }
                com.amap.api.mapcore.util.m$j r2 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ all -> 0x021c }
                r2.a((javax.microedition.khronos.opengles.GL10) r6)     // Catch:{ all -> 0x021c }
                r9 = 0
            L_0x019f:
                if (r7 == 0) goto L_0x01b7
                java.lang.ref.WeakReference<com.amap.api.mapcore.util.m> r2 = r1.f9607t     // Catch:{ all -> 0x021c }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x021c }
                com.amap.api.mapcore.util.m r2 = (com.amap.api.mapcore.util.m) r2     // Catch:{ all -> 0x021c }
                if (r2 == 0) goto L_0x01b6
                android.opengl.GLSurfaceView$Renderer r2 = r2.f9562d     // Catch:{ all -> 0x021c }
                com.amap.api.mapcore.util.m$h r7 = r1.f9606s     // Catch:{ all -> 0x021c }
                javax.microedition.khronos.egl.EGLConfig r7 = r7.f9585d     // Catch:{ all -> 0x021c }
                r2.onSurfaceCreated(r6, r7)     // Catch:{ all -> 0x021c }
            L_0x01b6:
                r7 = 0
            L_0x01b7:
                if (r10 == 0) goto L_0x01cb
                java.lang.ref.WeakReference<com.amap.api.mapcore.util.m> r2 = r1.f9607t     // Catch:{ all -> 0x021c }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x021c }
                com.amap.api.mapcore.util.m r2 = (com.amap.api.mapcore.util.m) r2     // Catch:{ all -> 0x021c }
                if (r2 == 0) goto L_0x01ca
                android.opengl.GLSurfaceView$Renderer r2 = r2.f9562d     // Catch:{ all -> 0x021c }
                r2.onSurfaceChanged(r6, r11, r12)     // Catch:{ all -> 0x021c }
            L_0x01ca:
                r10 = 0
            L_0x01cb:
                java.lang.ref.WeakReference<com.amap.api.mapcore.util.m> r2 = r1.f9607t     // Catch:{ all -> 0x021c }
                java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x021c }
                com.amap.api.mapcore.util.m r2 = (com.amap.api.mapcore.util.m) r2     // Catch:{ all -> 0x021c }
                if (r2 == 0) goto L_0x01dc
                android.opengl.GLSurfaceView$Renderer r2 = r2.f9562d     // Catch:{ all -> 0x021c }
                r2.onDrawFrame(r6)     // Catch:{ all -> 0x021c }
            L_0x01dc:
                com.amap.api.mapcore.util.m$h r2 = r1.f9606s     // Catch:{ all -> 0x021c }
                int r2 = r2.d()     // Catch:{ all -> 0x021c }
                r15 = 12288(0x3000, float:1.7219E-41)
                if (r2 == r15) goto L_0x0208
                r15 = 12302(0x300e, float:1.7239E-41)
                if (r2 == r15) goto L_0x0205
                java.lang.String r15 = "GLThread"
                java.lang.String r0 = "eglSwapBuffers"
                com.amap.api.mapcore.util.m.h.a(r15, r0, r2)     // Catch:{ all -> 0x021c }
                com.amap.api.mapcore.util.m$j r2 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ all -> 0x021c }
                monitor-enter(r2)     // Catch:{ all -> 0x021c }
                r0 = 1
                r1.f9593f = r0     // Catch:{ all -> 0x0202 }
                com.amap.api.mapcore.util.m$j r15 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ all -> 0x0202 }
                r15.notifyAll()     // Catch:{ all -> 0x0202 }
                monitor-exit(r2)     // Catch:{ all -> 0x0202 }
                goto L_0x0209
            L_0x0202:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0202 }
                throw r0     // Catch:{ all -> 0x021c }
            L_0x0205:
                r0 = 1
                r3 = 1
                goto L_0x0209
            L_0x0208:
                r0 = 1
            L_0x0209:
                if (r13 == 0) goto L_0x020c
                r4 = 1
            L_0x020c:
                r0 = 0
                goto L_0x001c
            L_0x020f:
                com.amap.api.mapcore.util.m$j r0 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ all -> 0x0219 }
                r0.wait()     // Catch:{ all -> 0x0219 }
                r0 = 0
                goto L_0x0021
            L_0x0219:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x0219 }
                throw r0     // Catch:{ all -> 0x021c }
            L_0x021c:
                r0 = move-exception
                com.amap.api.mapcore.util.m$j r2 = com.amap.api.mapcore.util.m.f9559a
                monitor-enter(r2)
                r16.k()     // Catch:{ all -> 0x022a }
                r16.l()     // Catch:{ all -> 0x022a }
                monitor-exit(r2)     // Catch:{ all -> 0x022a }
                throw r0
            L_0x022a:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x022a }
                goto L_0x022e
            L_0x022d:
                throw r0
            L_0x022e:
                goto L_0x022d
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.m.i.m():void");
        }

        private boolean n() {
            return this.f9595h && this.f9596i && o();
        }

        private boolean o() {
            if (this.f9591d || !this.f9592e || this.f9593f || this.f9599l <= 0 || this.f9600m <= 0) {
                return false;
            }
            return this.f9602o || this.f9601n == 1;
        }

        public final int a() {
            int i2;
            synchronized (m.f9559a) {
                i2 = this.f9601n;
            }
            return i2;
        }

        public final void a(int i2) {
            if (i2 < 0 || i2 > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (m.f9559a) {
                this.f9601n = i2;
                m.f9559a.notifyAll();
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:12|13|14|15|27|21|4) */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0018, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0032 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(int r2, int r3) {
            /*
                r1 = this;
                com.amap.api.mapcore.util.m$j r0 = com.amap.api.mapcore.util.m.f9559a
                monitor-enter(r0)
                r1.f9599l = r2     // Catch:{ all -> 0x003c }
                r1.f9600m = r3     // Catch:{ all -> 0x003c }
                r2 = 1
                r1.f9605r = r2     // Catch:{ all -> 0x003c }
                r1.f9602o = r2     // Catch:{ all -> 0x003c }
                r2 = 0
                r1.f9603p = r2     // Catch:{ all -> 0x003c }
                com.amap.api.mapcore.util.m$j r2 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ all -> 0x003c }
                r2.notifyAll()     // Catch:{ all -> 0x003c }
            L_0x0018:
                boolean r2 = r1.f9589b     // Catch:{ all -> 0x003c }
                if (r2 != 0) goto L_0x003a
                boolean r2 = r1.f9591d     // Catch:{ all -> 0x003c }
                if (r2 != 0) goto L_0x003a
                boolean r2 = r1.f9603p     // Catch:{ all -> 0x003c }
                if (r2 != 0) goto L_0x003a
                boolean r2 = r1.n()     // Catch:{ all -> 0x003c }
                if (r2 == 0) goto L_0x003a
                com.amap.api.mapcore.util.m$j r2 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ InterruptedException -> 0x0032 }
                r2.wait()     // Catch:{ InterruptedException -> 0x0032 }
                goto L_0x0018
            L_0x0032:
                java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x003c }
                r2.interrupt()     // Catch:{ all -> 0x003c }
                goto L_0x0018
            L_0x003a:
                monitor-exit(r0)     // Catch:{ all -> 0x003c }
                return
            L_0x003c:
                r2 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x003c }
                goto L_0x0040
            L_0x003f:
                throw r2
            L_0x0040:
                goto L_0x003f
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.m.i.a(int, int):void");
        }

        public final void a(Runnable runnable) {
            if (runnable != null) {
                synchronized (m.f9559a) {
                    this.f9604q.add(runnable);
                    m.f9559a.notifyAll();
                }
                return;
            }
            throw new IllegalArgumentException("r must not be null");
        }

        public final void b() {
            synchronized (m.f9559a) {
                this.f9602o = true;
                m.f9559a.notifyAll();
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|25|20|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0012, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0026 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void c() {
            /*
                r2 = this;
                com.amap.api.mapcore.util.m$j r0 = com.amap.api.mapcore.util.m.f9559a
                monitor-enter(r0)
                r1 = 1
                r2.f9592e = r1     // Catch:{ all -> 0x0030 }
                r1 = 0
                r2.f9597j = r1     // Catch:{ all -> 0x0030 }
                com.amap.api.mapcore.util.m$j r1 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ all -> 0x0030 }
                r1.notifyAll()     // Catch:{ all -> 0x0030 }
            L_0x0012:
                boolean r1 = r2.f9594g     // Catch:{ all -> 0x0030 }
                if (r1 == 0) goto L_0x002e
                boolean r1 = r2.f9597j     // Catch:{ all -> 0x0030 }
                if (r1 != 0) goto L_0x002e
                boolean r1 = r2.f9589b     // Catch:{ all -> 0x0030 }
                if (r1 != 0) goto L_0x002e
                com.amap.api.mapcore.util.m$j r1 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ InterruptedException -> 0x0026 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0026 }
                goto L_0x0012
            L_0x0026:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0030 }
                r1.interrupt()     // Catch:{ all -> 0x0030 }
                goto L_0x0012
            L_0x002e:
                monitor-exit(r0)     // Catch:{ all -> 0x0030 }
                return
            L_0x0030:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0030 }
                goto L_0x0034
            L_0x0033:
                throw r1
            L_0x0034:
                goto L_0x0033
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.m.i.c():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:14|15|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void d() {
            /*
                r4 = this;
                com.amap.api.mapcore.util.m$j r0 = com.amap.api.mapcore.util.m.f9559a
                monitor-enter(r0)
                r1 = 0
                r4.f9592e = r1     // Catch:{ all -> 0x0039 }
                com.amap.api.mapcore.util.m$j r1 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ all -> 0x0039 }
                r1.notifyAll()     // Catch:{ all -> 0x0039 }
            L_0x000f:
                boolean r1 = r4.f9594g     // Catch:{ all -> 0x0039 }
                if (r1 != 0) goto L_0x0037
                boolean r1 = r4.f9589b     // Catch:{ all -> 0x0039 }
                if (r1 != 0) goto L_0x0037
                boolean r1 = com.amap.api.maps.MapsInitializer.getTextureViewDestorySync()     // Catch:{ InterruptedException -> 0x002f }
                if (r1 == 0) goto L_0x0025
                com.amap.api.mapcore.util.m$j r1 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ InterruptedException -> 0x002f }
                r1.wait()     // Catch:{ InterruptedException -> 0x002f }
                goto L_0x000f
            L_0x0025:
                com.amap.api.mapcore.util.m$j r1 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ InterruptedException -> 0x002f }
                r2 = 2000(0x7d0, double:9.88E-321)
                r1.wait(r2)     // Catch:{ InterruptedException -> 0x002f }
                goto L_0x000f
            L_0x002f:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0039 }
                r1.interrupt()     // Catch:{ all -> 0x0039 }
                goto L_0x000f
            L_0x0037:
                monitor-exit(r0)     // Catch:{ all -> 0x0039 }
                return
            L_0x0039:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0039 }
                goto L_0x003d
            L_0x003c:
                throw r1
            L_0x003d:
                goto L_0x003c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.m.i.d():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(3:14|15|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            java.lang.Thread.currentThread().interrupt();
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void e() {
            /*
                r4 = this;
                com.amap.api.mapcore.util.m$j r0 = com.amap.api.mapcore.util.m.f9559a
                monitor-enter(r0)
                r1 = 1
                r4.f9590c = r1     // Catch:{ all -> 0x0039 }
                com.amap.api.mapcore.util.m$j r1 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ all -> 0x0039 }
                r1.notifyAll()     // Catch:{ all -> 0x0039 }
            L_0x000f:
                boolean r1 = r4.f9589b     // Catch:{ all -> 0x0039 }
                if (r1 != 0) goto L_0x0037
                boolean r1 = r4.f9591d     // Catch:{ all -> 0x0039 }
                if (r1 != 0) goto L_0x0037
                boolean r1 = com.amap.api.maps.MapsInitializer.getTextureViewDestorySync()     // Catch:{ InterruptedException -> 0x002f }
                if (r1 == 0) goto L_0x0025
                com.amap.api.mapcore.util.m$j r1 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ InterruptedException -> 0x002f }
                r1.wait()     // Catch:{ InterruptedException -> 0x002f }
                goto L_0x000f
            L_0x0025:
                com.amap.api.mapcore.util.m$j r1 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ InterruptedException -> 0x002f }
                r2 = 2000(0x7d0, double:9.88E-321)
                r1.wait(r2)     // Catch:{ InterruptedException -> 0x002f }
                goto L_0x000f
            L_0x002f:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0039 }
                r1.interrupt()     // Catch:{ all -> 0x0039 }
                goto L_0x000f
            L_0x0037:
                monitor-exit(r0)     // Catch:{ all -> 0x0039 }
                return
            L_0x0039:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0039 }
                goto L_0x003d
            L_0x003c:
                throw r1
            L_0x003d:
                goto L_0x003c
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.m.i.e():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|25|20|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0014, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0028 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void f() {
            /*
                r3 = this;
                com.amap.api.mapcore.util.m$j r0 = com.amap.api.mapcore.util.m.f9559a
                monitor-enter(r0)
                r1 = 0
                r3.f9590c = r1     // Catch:{ all -> 0x0032 }
                r2 = 1
                r3.f9602o = r2     // Catch:{ all -> 0x0032 }
                r3.f9603p = r1     // Catch:{ all -> 0x0032 }
                com.amap.api.mapcore.util.m$j r1 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ all -> 0x0032 }
                r1.notifyAll()     // Catch:{ all -> 0x0032 }
            L_0x0014:
                boolean r1 = r3.f9589b     // Catch:{ all -> 0x0032 }
                if (r1 != 0) goto L_0x0030
                boolean r1 = r3.f9591d     // Catch:{ all -> 0x0032 }
                if (r1 == 0) goto L_0x0030
                boolean r1 = r3.f9603p     // Catch:{ all -> 0x0032 }
                if (r1 != 0) goto L_0x0030
                com.amap.api.mapcore.util.m$j r1 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ InterruptedException -> 0x0028 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0028 }
                goto L_0x0014
            L_0x0028:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0032 }
                r1.interrupt()     // Catch:{ all -> 0x0032 }
                goto L_0x0014
            L_0x0030:
                monitor-exit(r0)     // Catch:{ all -> 0x0032 }
                return
            L_0x0032:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0032 }
                goto L_0x0036
            L_0x0035:
                throw r1
            L_0x0036:
                goto L_0x0035
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.m.i.f():void");
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:7|8|9|10|19|16|5) */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x000f, code lost:
            continue;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void g() {
            /*
                r2 = this;
                com.amap.api.mapcore.util.m$j r0 = com.amap.api.mapcore.util.m.f9559a
                monitor-enter(r0)
                r1 = 1
                r2.f9588a = r1     // Catch:{ all -> 0x0025 }
                com.amap.api.mapcore.util.m$j r1 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ all -> 0x0025 }
                r1.notifyAll()     // Catch:{ all -> 0x0025 }
            L_0x000f:
                boolean r1 = r2.f9589b     // Catch:{ all -> 0x0025 }
                if (r1 != 0) goto L_0x0023
                com.amap.api.mapcore.util.m$j r1 = com.amap.api.mapcore.util.m.f9559a     // Catch:{ InterruptedException -> 0x001b }
                r1.wait()     // Catch:{ InterruptedException -> 0x001b }
                goto L_0x000f
            L_0x001b:
                java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0025 }
                r1.interrupt()     // Catch:{ all -> 0x0025 }
                goto L_0x000f
            L_0x0023:
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                return
            L_0x0025:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0025 }
                goto L_0x0029
            L_0x0028:
                throw r1
            L_0x0029:
                goto L_0x0028
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.m.i.g():void");
        }

        public final void h() {
            this.f9598k = true;
            m.f9559a.notifyAll();
        }

        public final int i() {
            int i2;
            synchronized (m.f9559a) {
                i2 = this.f9599l;
            }
            return i2;
        }

        public final int j() {
            int i2;
            synchronized (m.f9559a) {
                i2 = this.f9600m;
            }
            return i2;
        }

        public final void run() {
            setName("GLThread " + getId());
            try {
                m();
            } catch (InterruptedException unused) {
            } finally {
                m.f9559a.a(this);
            }
        }
    }

    private static class j {

        /* renamed from: a  reason: collision with root package name */
        private static String f9608a = "GLThreadManager";

        /* renamed from: b  reason: collision with root package name */
        private boolean f9609b;

        /* renamed from: c  reason: collision with root package name */
        private int f9610c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f9611d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f9612e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f9613f;

        /* renamed from: g  reason: collision with root package name */
        private i f9614g;

        private j() {
        }

        /* synthetic */ j(byte b2) {
            this();
        }

        private void c() {
            if (!this.f9609b) {
                this.f9610c = 131072;
                this.f9612e = true;
                this.f9609b = true;
            }
        }

        public final synchronized void a(i iVar) {
            boolean unused = iVar.f9589b = true;
            if (this.f9614g == iVar) {
                this.f9614g = null;
            }
            notifyAll();
        }

        public final synchronized void a(GL10 gl10) {
            if (!this.f9611d && gl10 != null) {
                c();
                String glGetString = gl10.glGetString(7937);
                boolean z2 = false;
                if (this.f9610c < 131072) {
                    this.f9612e = !glGetString.startsWith("Q3Dimension MSM7500 ");
                    notifyAll();
                }
                if (!this.f9612e) {
                    z2 = true;
                }
                this.f9613f = z2;
                this.f9611d = true;
            }
        }

        public final synchronized boolean a() {
            return this.f9613f;
        }

        public final synchronized boolean b() {
            c();
            return !this.f9612e;
        }

        public final boolean b(i iVar) {
            i iVar2 = this.f9614g;
            if (iVar2 == iVar || iVar2 == null) {
                this.f9614g = iVar;
                notifyAll();
                return true;
            }
            c();
            if (this.f9612e) {
                return true;
            }
            i iVar3 = this.f9614g;
            if (iVar3 == null) {
                return false;
            }
            iVar3.h();
            return false;
        }

        public final void c(i iVar) {
            if (this.f9614g == iVar) {
                this.f9614g = null;
            }
            notifyAll();
        }
    }

    public interface k {
        GL a();
    }

    static class l extends Writer {

        /* renamed from: a  reason: collision with root package name */
        private StringBuilder f9615a = new StringBuilder();

        l() {
        }

        private void a() {
            if (this.f9615a.length() > 0) {
                Log.v("GLSurfaceView", this.f9615a.toString());
                StringBuilder sb = this.f9615a;
                sb.delete(0, sb.length());
            }
        }

        public final void close() {
            a();
        }

        public final void flush() {
            a();
        }

        public final void write(char[] cArr, int i2, int i3) {
            for (int i4 = 0; i4 < i3; i4++) {
                char c2 = cArr[i2 + i4];
                if (c2 == 10) {
                    a();
                } else {
                    this.f9615a.append(c2);
                }
            }
        }
    }

    /* renamed from: com.amap.api.mapcore.util.m$m  reason: collision with other inner class name */
    private class C0076m extends b {
        public C0076m() {
            super();
        }
    }

    public m(Context context) {
        super(context, (AttributeSet) null);
        a();
    }

    private void a() {
        setSurfaceTextureListener(this);
    }

    private void e() {
        if (this.f9561c != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private static boolean f() {
        return Build.VERSION.SDK_INT < 23;
    }

    public final void a(e eVar) {
        e();
        this.f9564f = eVar;
    }

    public final void a(f fVar) {
        e();
        this.f9565g = fVar;
    }

    public void b() {
        this.f9561c.e();
    }

    public void c() {
        this.f9561c.f();
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            i iVar = this.f9561c;
            if (iVar != null) {
                iVar.g();
            }
        } finally {
            super.finalize();
        }
    }

    public int getRenderMode() {
        return this.f9561c.a();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f9563e && this.f9562d != null) {
            i iVar = this.f9561c;
            int a2 = iVar != null ? iVar.a() : 1;
            i iVar2 = new i(this.f9560b);
            this.f9561c = iVar2;
            if (a2 != 1) {
                iVar2.a(a2);
            }
            this.f9561c.start();
        }
        this.f9563e = false;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        i iVar = this.f9561c;
        if (iVar != null) {
            iVar.g();
        }
        this.f9563e = true;
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        onSurfaceTextureSizeChanged(getSurfaceTexture(), i4 - i2, i5 - i3);
        super.onLayout(z2, i2, i3, i4, i5);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.f9561c.c();
        if (f() || MapsInitializer.getTextureSizeChangedInvoked()) {
            onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
        } else if (this.f9561c.i() != i2 || this.f9561c.j() != i3) {
            onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f9561c.d();
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.f9561c.a(i2, i3);
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void queueEvent(Runnable runnable) {
        this.f9561c.a(runnable);
    }

    public void requestRender() {
        this.f9561c.b();
    }

    public void setRenderMode(int i2) {
        this.f9561c.a(i2);
    }

    public void setRenderer(GLSurfaceView.Renderer renderer) {
        e();
        if (this.f9564f == null) {
            this.f9564f = new C0076m();
        }
        if (this.f9565g == null) {
            this.f9565g = new c(this, (byte) 0);
        }
        if (this.f9566h == null) {
            this.f9566h = new d((byte) 0);
        }
        this.f9562d = renderer;
        i iVar = new i(this.f9560b);
        this.f9561c = iVar;
        iVar.start();
    }
}
