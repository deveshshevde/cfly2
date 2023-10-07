package com.ctoo.mediaedit.tools;

import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Build;
import android.util.Log;
import android.view.Choreographer;
import java.util.ArrayList;
import java.util.Objects;
import javax.microedition.khronos.egl.EGL10;

public class e extends Thread {
    private a A = a.f10887c;
    private d B = new d(this);
    private long C;
    private cz.b D;

    /* renamed from: a  reason: collision with root package name */
    private final k f10905a = new k();

    /* renamed from: b  reason: collision with root package name */
    private int f10906b;

    /* renamed from: c  reason: collision with root package name */
    private j f10907c;

    /* renamed from: d  reason: collision with root package name */
    private h f10908d;

    /* renamed from: e  reason: collision with root package name */
    private i f10909e;

    /* renamed from: f  reason: collision with root package name */
    private cz.a f10910f;

    /* renamed from: g  reason: collision with root package name */
    private Object f10911g;

    /* renamed from: h  reason: collision with root package name */
    private l f10912h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10913i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f10914j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10915k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10916l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f10917m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f10918n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f10919o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f10920p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f10921q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f10922r;

    /* renamed from: s  reason: collision with root package name */
    private int f10923s = 0;

    /* renamed from: t  reason: collision with root package name */
    private int f10924t = 0;

    /* renamed from: u  reason: collision with root package name */
    private boolean f10925u = true;

    /* renamed from: v  reason: collision with root package name */
    private boolean f10926v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f10927w;

    /* renamed from: x  reason: collision with root package name */
    private ArrayList<Runnable> f10928x = new ArrayList<>();

    /* renamed from: y  reason: collision with root package name */
    private boolean f10929y = true;

    /* renamed from: z  reason: collision with root package name */
    private boolean f10930z = false;

    private static abstract class a implements h {

        /* renamed from: a  reason: collision with root package name */
        protected int[] f10931a;

        /* renamed from: b  reason: collision with root package name */
        private int f10932b;

        public a(int[] iArr, int i2) {
            this.f10931a = a(iArr);
            this.f10932b = i2;
        }

        private int[] a(int[] iArr) {
            int i2 = this.f10932b;
            if (i2 != 2 && i2 != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[(length + 2)];
            int i3 = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            iArr2[i3] = 12352;
            if (this.f10932b == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        public EGLConfig a(EGLDisplay eGLDisplay, boolean z2) {
            int[] iArr = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, this.f10932b >= 3 ? 68 : 4, 12344, 0, 12344};
            if (z2) {
                iArr[10] = 12610;
                iArr[11] = 1;
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(eGLDisplay, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                return eGLConfigArr[0];
            }
            Log.w("GLThread", "unable to find RGB8888 / " + this.f10932b + " EGLConfig");
            return null;
        }

        public javax.microedition.khronos.egl.EGLConfig a(EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (egl10.eglChooseConfig(eGLDisplay, this.f10931a, (javax.microedition.khronos.egl.EGLConfig[]) null, 0, iArr)) {
                int i2 = iArr[0];
                if (i2 > 0) {
                    javax.microedition.khronos.egl.EGLConfig[] eGLConfigArr = new javax.microedition.khronos.egl.EGLConfig[i2];
                    if (egl10.eglChooseConfig(eGLDisplay, this.f10931a, eGLConfigArr, i2, iArr)) {
                        javax.microedition.khronos.egl.EGLConfig a2 = a(egl10, eGLDisplay, eGLConfigArr);
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

        /* access modifiers changed from: package-private */
        public abstract javax.microedition.khronos.egl.EGLConfig a(EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig[] eGLConfigArr);
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private h f10933a;

        /* renamed from: b  reason: collision with root package name */
        private i f10934b;

        /* renamed from: c  reason: collision with root package name */
        private j f10935c;

        /* renamed from: d  reason: collision with root package name */
        private cz.a f10936d;

        /* renamed from: e  reason: collision with root package name */
        private int f10937e;

        /* renamed from: f  reason: collision with root package name */
        private int f10938f;

        /* renamed from: g  reason: collision with root package name */
        private Object f10939g;

        /* renamed from: h  reason: collision with root package name */
        private a f10940h;

        public b a(a aVar) {
            this.f10940h = aVar;
            return this;
        }

        public e a() {
            Objects.requireNonNull(this.f10936d, "renderer has not been set");
            if (this.f10939g == null) {
                Objects.requireNonNull(this.f10935c, "surface has not been set");
            }
            if (this.f10933a == null) {
                this.f10933a = m.a(true, this.f10937e);
            }
            if (this.f10934b == null) {
                this.f10934b = new f(this.f10937e);
            }
            if (this.f10935c == null) {
                this.f10935c = new g();
            }
            return new e(this.f10933a, this.f10934b, this.f10935c, this.f10936d, this.f10938f, this.f10939g, this.f10940h);
        }
    }

    public static class c implements Choreographer.FrameCallback {

        /* renamed from: a  reason: collision with root package name */
        private e f10941a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f10942b = true;

        public c(e eVar) {
            this.f10941a = eVar;
        }

        public void a() {
            Choreographer.getInstance().postFrameCallback(this);
        }

        public void a(boolean z2) {
            this.f10942b = z2;
        }

        public boolean b() {
            return this.f10942b || this.f10941a.c() == 0;
        }

        public void doFrame(long j2) {
            if (this.f10941a.c() == 1) {
                this.f10942b = true;
                this.f10941a.a(j2);
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private c f10943a = null;

        public d(e eVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.f10943a = new c(eVar);
            }
        }

        public void a() {
            c cVar = this.f10943a;
            if (cVar != null) {
                cVar.a();
            }
        }

        public boolean b() {
            c cVar = this.f10943a;
            if (cVar != null) {
                return cVar.b();
            }
            return true;
        }

        public void c() {
            c cVar = this.f10943a;
            if (cVar != null) {
                cVar.a(false);
            }
        }
    }

    /* renamed from: com.ctoo.mediaedit.tools.e$e  reason: collision with other inner class name */
    private static class C0086e extends a {

        /* renamed from: b  reason: collision with root package name */
        protected int f10944b;

        /* renamed from: c  reason: collision with root package name */
        protected int f10945c;

        /* renamed from: d  reason: collision with root package name */
        protected int f10946d;

        /* renamed from: e  reason: collision with root package name */
        protected int f10947e;

        /* renamed from: f  reason: collision with root package name */
        protected int f10948f;

        /* renamed from: g  reason: collision with root package name */
        protected int f10949g;

        /* renamed from: h  reason: collision with root package name */
        private int[] f10950h = new int[1];

        public C0086e(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            super(new int[]{12324, i2, 12323, i3, 12322, i4, 12321, i5, 12325, i6, 12326, i7, 12344}, i8);
            this.f10944b = i2;
            this.f10945c = i3;
            this.f10946d = i4;
            this.f10947e = i5;
            this.f10948f = i6;
            this.f10949g = i7;
        }

        private int a(EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig, int i2, int i3) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i2, this.f10950h) ? this.f10950h[0] : i3;
        }

        public javax.microedition.khronos.egl.EGLConfig a(EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig[] eGLConfigArr) {
            for (javax.microedition.khronos.egl.EGLConfig eGLConfig : eGLConfigArr) {
                EGL10 egl102 = egl10;
                javax.microedition.khronos.egl.EGLDisplay eGLDisplay2 = eGLDisplay;
                javax.microedition.khronos.egl.EGLConfig eGLConfig2 = eGLConfig;
                int a2 = a(egl102, eGLDisplay2, eGLConfig2, 12325, 0);
                int a3 = a(egl102, eGLDisplay2, eGLConfig2, 12326, 0);
                if (a2 >= this.f10948f && a3 >= this.f10949g) {
                    EGL10 egl103 = egl10;
                    javax.microedition.khronos.egl.EGLDisplay eGLDisplay3 = eGLDisplay;
                    javax.microedition.khronos.egl.EGLConfig eGLConfig3 = eGLConfig;
                    int a4 = a(egl103, eGLDisplay3, eGLConfig3, 12324, 0);
                    int a5 = a(egl103, eGLDisplay3, eGLConfig3, 12323, 0);
                    int a6 = a(egl103, eGLDisplay3, eGLConfig3, 12322, 0);
                    int a7 = a(egl103, eGLDisplay3, eGLConfig3, 12321, 0);
                    if (a4 == this.f10944b && a5 == this.f10945c && a6 == this.f10946d && a7 == this.f10947e) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }
    }

    public static class f implements i {

        /* renamed from: a  reason: collision with root package name */
        private int f10951a = 12440;

        /* renamed from: b  reason: collision with root package name */
        private int f10952b;

        public f(int i2) {
            this.f10952b = i2;
        }

        public EGLContext a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext) {
            return EGL14.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, new int[]{12440, this.f10952b, 12344}, 0);
        }

        public javax.microedition.khronos.egl.EGLContext a(EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig, javax.microedition.khronos.egl.EGLContext eGLContext) {
            int i2 = this.f10952b;
            int[] iArr = {this.f10951a, i2, 12344};
            if (i2 == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        public void a(EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (!EGL14.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("GLThread", "DefaultContextFactory display:" + eGLDisplay + " context: " + eGLContext);
            }
        }

        public void a(EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLContext eGLContext) {
            if (!egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                Log.e("GLThread", "DefaultContextFactory display:" + eGLDisplay + " context: " + eGLContext);
            }
        }
    }

    public static class g implements j {
        public EGLSurface a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return EGL14.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, new int[]{12344}, 0);
            } catch (IllegalArgumentException e2) {
                Log.e("DefaultWindow", "eglCreateWindowSurface", e2);
                return null;
            }
        }

        public javax.microedition.khronos.egl.EGLSurface a(EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, new int[]{12344});
            } catch (IllegalArgumentException e2) {
                Log.e("DefaultWindow", "eglCreateWindowSurface", e2);
                return null;
            }
        }

        public void a(EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            EGL14.eglDestroySurface(eGLDisplay, eGLSurface);
        }

        public void a(EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    public interface h {
        EGLConfig a(EGLDisplay eGLDisplay, boolean z2);

        javax.microedition.khronos.egl.EGLConfig a(EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay);
    }

    public interface i {
        EGLContext a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext);

        javax.microedition.khronos.egl.EGLContext a(EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig, javax.microedition.khronos.egl.EGLContext eGLContext);

        void a(EGLDisplay eGLDisplay, EGLContext eGLContext);

        void a(EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLContext eGLContext);
    }

    public interface j {
        EGLSurface a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        javax.microedition.khronos.egl.EGLSurface a(EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig eGLConfig, Object obj);

        void a(EGLDisplay eGLDisplay, EGLSurface eGLSurface);

        void a(EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLSurface eGLSurface);
    }

    private static class k {

        /* renamed from: a  reason: collision with root package name */
        private e f10953a;

        private k() {
        }

        public synchronized void a(e eVar) {
            Log.i("GLThread", "exiting tid=" + eVar.getId());
            boolean unused = eVar.f10914j = true;
            if (this.f10953a == eVar) {
                this.f10953a = null;
            }
            notifyAll();
        }

        public boolean b(e eVar) {
            e eVar2 = this.f10953a;
            if (eVar2 != eVar && eVar2 != null) {
                return true;
            }
            this.f10953a = eVar;
            notifyAll();
            return true;
        }

        public void c(e eVar) {
            if (this.f10953a == eVar) {
                this.f10953a = null;
            }
            notifyAll();
        }
    }

    public interface l {
        void a(a aVar);
    }

    public static class m extends C0086e {
        public m(int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            super(i2, i3, i4, i5, i6, i7, i8);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(boolean z2, int i2) {
            super(8, 8, 8, 0, z2 ? 16 : 0, 0, i2);
        }

        public static m a(boolean z2, int i2) {
            return Build.VERSION.SDK_INT >= 16 ? new m(z2, i2) : new m(5, 6, 5, 8, 0, 0, i2);
        }

        public /* bridge */ /* synthetic */ EGLConfig a(EGLDisplay eGLDisplay, boolean z2) {
            return super.a(eGLDisplay, z2);
        }

        public /* bridge */ /* synthetic */ javax.microedition.khronos.egl.EGLConfig a(EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay) {
            return super.a(egl10, eGLDisplay);
        }

        public /* bridge */ /* synthetic */ javax.microedition.khronos.egl.EGLConfig a(EGL10 egl10, javax.microedition.khronos.egl.EGLDisplay eGLDisplay, javax.microedition.khronos.egl.EGLConfig[] eGLConfigArr) {
            return super.a(egl10, eGLDisplay, eGLConfigArr);
        }
    }

    e(h hVar, i iVar, j jVar, cz.a aVar, int i2, Object obj, a aVar2) {
        this.f10906b = i2;
        this.f10926v = false;
        this.f10908d = hVar;
        this.f10909e = iVar;
        this.f10907c = jVar;
        this.f10911g = obj;
        this.f10910f = aVar;
        this.A = aVar2;
    }

    private void g() {
        if (this.f10921q) {
            this.f10921q = false;
            this.D.b();
        }
    }

    private void h() {
        if (this.f10920p) {
            this.D.c();
            this.f10920p = false;
            this.f10905a.c(this);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01e3, code lost:
        r3 = r1.f10905a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01e5, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:?, code lost:
        r1.f10922r = true;
        r1.f10918n = true;
        r1.f10905a.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01f0, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x01f6, code lost:
        if (r8 == false) goto L_0x01f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x01f8, code lost:
        r8 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x01f9, code lost:
        if (r6 == false) goto L_0x0208;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x01fb, code lost:
        android.util.Log.w("GLThread", "onSurfaceCreated");
        r1.f10910f.a();
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0208, code lost:
        if (r9 == false) goto L_0x0233;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x020a, code lost:
        android.util.Log.w("GLThread", "onSurfaceChanged(" + r10 + ", " + r11 + ")");
        r1.f10910f.a(r10, r11);
        r9 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0239, code lost:
        if (r1.B.b() == false) goto L_0x028c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x023b, code lost:
        if (r12 != false) goto L_0x0241;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x023d, code lost:
        r0 = 0;
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0241, code lost:
        r1.f10910f.b();
        r1.D.a(r1.C);
        r0 = r1.D.a();
        r1.B.c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x025a, code lost:
        if (r0 == 12288) goto L_0x028c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x025e, code lost:
        if (r0 == 12302) goto L_0x0270;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0260, code lost:
        r2 = r1.f10905a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0262, code lost:
        monitor-enter(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:?, code lost:
        r1.f10918n = true;
        r1.f10905a.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x026b, code lost:
        monitor-exit(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0270, code lost:
        android.util.Log.i("GLThread", "egl context lost tid=" + getId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x028b, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x028c, code lost:
        if (r14 == false) goto L_0x0292;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0292, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01b6, code lost:
        if (r13 == null) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:?, code lost:
        r13.run();
        r0 = 0;
        r13 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01bf, code lost:
        if (r7 == false) goto L_0x01f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01c1, code lost:
        android.util.Log.w("GLThread", "egl createSurface");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01d0, code lost:
        if (r1.D.a(r1.f10911g) == false) goto L_0x01e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01d2, code lost:
        r3 = r1.f10905a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01d4, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:?, code lost:
        r1.f10922r = true;
        r1.f10905a.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01dd, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01de, code lost:
        r7 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i() throws java.lang.InterruptedException {
        /*
            r18 = this;
            r1 = r18
            com.ctoo.mediaedit.tools.e$h r0 = r1.f10908d
            com.ctoo.mediaedit.tools.e$i r2 = r1.f10909e
            com.ctoo.mediaedit.tools.e$j r3 = r1.f10907c
            cz.b r0 = com.ctoo.mediaedit.tools.d.a(r0, r2, r3)
            r1.D = r0
            r0 = 0
            r1.f10920p = r0
            r1.f10921q = r0
            r1.f10926v = r0
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
        L_0x001f:
            r14 = 0
        L_0x0020:
            com.ctoo.mediaedit.tools.e$k r15 = r1.f10905a     // Catch:{ all -> 0x02a3 }
            monitor-enter(r15)     // Catch:{ all -> 0x02a3 }
        L_0x0023:
            boolean r2 = r1.f10913i     // Catch:{ all -> 0x02a0 }
            if (r2 == 0) goto L_0x0036
            monitor-exit(r15)     // Catch:{ all -> 0x02a0 }
            com.ctoo.mediaedit.tools.e$k r2 = r1.f10905a
            monitor-enter(r2)
            r18.g()     // Catch:{ all -> 0x0033 }
            r18.h()     // Catch:{ all -> 0x0033 }
            monitor-exit(r2)     // Catch:{ all -> 0x0033 }
            return
        L_0x0033:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0033 }
            throw r0
        L_0x0036:
            java.util.ArrayList<java.lang.Runnable> r2 = r1.f10928x     // Catch:{ all -> 0x02a0 }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x02a0 }
            if (r2 != 0) goto L_0x004e
            boolean r2 = r1.f10920p     // Catch:{ all -> 0x02a0 }
            if (r2 == 0) goto L_0x004e
            java.util.ArrayList<java.lang.Runnable> r2 = r1.f10928x     // Catch:{ all -> 0x02a0 }
            java.lang.Object r2 = r2.remove(r0)     // Catch:{ all -> 0x02a0 }
            r13 = r2
            java.lang.Runnable r13 = (java.lang.Runnable) r13     // Catch:{ all -> 0x02a0 }
            r2 = 0
            goto L_0x01b5
        L_0x004e:
            boolean r2 = r1.f10916l     // Catch:{ all -> 0x02a0 }
            boolean r0 = r1.f10915k     // Catch:{ all -> 0x02a0 }
            if (r2 == r0) goto L_0x0085
            r1.f10916l = r0     // Catch:{ all -> 0x02a0 }
            com.ctoo.mediaedit.tools.e$k r2 = r1.f10905a     // Catch:{ all -> 0x02a0 }
            r2.notifyAll()     // Catch:{ all -> 0x02a0 }
            java.lang.String r2 = "GLThread"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a0 }
            r3.<init>()     // Catch:{ all -> 0x02a0 }
            r16 = r0
            java.lang.String r0 = "mPaused is now "
            r3.append(r0)     // Catch:{ all -> 0x02a0 }
            boolean r0 = r1.f10916l     // Catch:{ all -> 0x02a0 }
            r3.append(r0)     // Catch:{ all -> 0x02a0 }
            java.lang.String r0 = " tid="
            r3.append(r0)     // Catch:{ all -> 0x02a0 }
            r0 = r6
            r17 = r7
            long r6 = r18.getId()     // Catch:{ all -> 0x02a0 }
            r3.append(r6)     // Catch:{ all -> 0x02a0 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x02a0 }
            android.util.Log.i(r2, r3)     // Catch:{ all -> 0x02a0 }
            goto L_0x008a
        L_0x0085:
            r0 = r6
            r17 = r7
            r16 = 0
        L_0x008a:
            if (r4 == 0) goto L_0x009a
            java.lang.String r2 = "GLThread"
            java.lang.String r3 = "lostEglContext"
            android.util.Log.i(r2, r3)     // Catch:{ all -> 0x02a0 }
            r18.g()     // Catch:{ all -> 0x02a0 }
            r18.h()     // Catch:{ all -> 0x02a0 }
            r4 = 0
        L_0x009a:
            if (r16 == 0) goto L_0x00bd
            boolean r2 = r1.f10921q     // Catch:{ all -> 0x02a0 }
            if (r2 == 0) goto L_0x00bd
            java.lang.String r2 = "GLThread"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a0 }
            r3.<init>()     // Catch:{ all -> 0x02a0 }
            java.lang.String r6 = "releasing EGL surface because paused tid="
            r3.append(r6)     // Catch:{ all -> 0x02a0 }
            long r6 = r18.getId()     // Catch:{ all -> 0x02a0 }
            r3.append(r6)     // Catch:{ all -> 0x02a0 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x02a0 }
            android.util.Log.i(r2, r3)     // Catch:{ all -> 0x02a0 }
            r18.g()     // Catch:{ all -> 0x02a0 }
        L_0x00bd:
            boolean r2 = r1.f10917m     // Catch:{ all -> 0x02a0 }
            if (r2 != 0) goto L_0x00f1
            boolean r2 = r1.f10919o     // Catch:{ all -> 0x02a0 }
            if (r2 != 0) goto L_0x00f1
            java.lang.String r2 = "GLThread"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a0 }
            r3.<init>()     // Catch:{ all -> 0x02a0 }
            java.lang.String r6 = "noticed surfaceView surface lost tid="
            r3.append(r6)     // Catch:{ all -> 0x02a0 }
            long r6 = r18.getId()     // Catch:{ all -> 0x02a0 }
            r3.append(r6)     // Catch:{ all -> 0x02a0 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x02a0 }
            android.util.Log.i(r2, r3)     // Catch:{ all -> 0x02a0 }
            boolean r2 = r1.f10921q     // Catch:{ all -> 0x02a0 }
            if (r2 == 0) goto L_0x00e6
            r18.g()     // Catch:{ all -> 0x02a0 }
        L_0x00e6:
            r2 = 1
            r1.f10919o = r2     // Catch:{ all -> 0x02a0 }
            r2 = 0
            r1.f10918n = r2     // Catch:{ all -> 0x02a0 }
            com.ctoo.mediaedit.tools.e$k r2 = r1.f10905a     // Catch:{ all -> 0x02a0 }
            r2.notifyAll()     // Catch:{ all -> 0x02a0 }
        L_0x00f1:
            boolean r2 = r1.f10917m     // Catch:{ all -> 0x02a0 }
            if (r2 == 0) goto L_0x011b
            boolean r2 = r1.f10919o     // Catch:{ all -> 0x02a0 }
            if (r2 == 0) goto L_0x011b
            java.lang.String r2 = "GLThread"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a0 }
            r3.<init>()     // Catch:{ all -> 0x02a0 }
            java.lang.String r6 = "noticed surfaceView surface acquired tid="
            r3.append(r6)     // Catch:{ all -> 0x02a0 }
            long r6 = r18.getId()     // Catch:{ all -> 0x02a0 }
            r3.append(r6)     // Catch:{ all -> 0x02a0 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x02a0 }
            android.util.Log.i(r2, r3)     // Catch:{ all -> 0x02a0 }
            r2 = 0
            r1.f10919o = r2     // Catch:{ all -> 0x02a0 }
            com.ctoo.mediaedit.tools.e$k r2 = r1.f10905a     // Catch:{ all -> 0x02a0 }
            r2.notifyAll()     // Catch:{ all -> 0x02a0 }
        L_0x011b:
            if (r5 == 0) goto L_0x0129
            r2 = 0
            r1.f10926v = r2     // Catch:{ all -> 0x02a0 }
            r2 = 1
            r1.f10927w = r2     // Catch:{ all -> 0x02a0 }
            com.ctoo.mediaedit.tools.e$k r2 = r1.f10905a     // Catch:{ all -> 0x02a0 }
            r2.notifyAll()     // Catch:{ all -> 0x02a0 }
            r5 = 0
        L_0x0129:
            boolean r2 = r18.j()     // Catch:{ all -> 0x02a0 }
            if (r2 == 0) goto L_0x0295
            boolean r2 = r1.f10920p     // Catch:{ all -> 0x02a0 }
            if (r2 != 0) goto L_0x015d
            com.ctoo.mediaedit.tools.e$k r2 = r1.f10905a     // Catch:{ all -> 0x02a0 }
            boolean r2 = r2.b(r1)     // Catch:{ all -> 0x02a0 }
            if (r2 == 0) goto L_0x015d
            cz.b r0 = r1.D     // Catch:{ RuntimeException -> 0x0156 }
            com.ctoo.mediaedit.tools.a r2 = r1.A     // Catch:{ RuntimeException -> 0x0156 }
            com.ctoo.mediaedit.tools.a r0 = r0.a((com.ctoo.mediaedit.tools.a) r2)     // Catch:{ RuntimeException -> 0x0156 }
            r1.A = r0     // Catch:{ RuntimeException -> 0x0156 }
            com.ctoo.mediaedit.tools.e$l r2 = r1.f10912h     // Catch:{ RuntimeException -> 0x0156 }
            if (r2 == 0) goto L_0x014c
            r2.a(r0)     // Catch:{ RuntimeException -> 0x0156 }
        L_0x014c:
            r0 = 1
            r1.f10920p = r0     // Catch:{ all -> 0x02a0 }
            com.ctoo.mediaedit.tools.e$k r0 = r1.f10905a     // Catch:{ all -> 0x02a0 }
            r0.notifyAll()     // Catch:{ all -> 0x02a0 }
            r6 = 1
            goto L_0x015e
        L_0x0156:
            r0 = move-exception
            com.ctoo.mediaedit.tools.e$k r2 = r1.f10905a     // Catch:{ all -> 0x02a0 }
            r2.c(r1)     // Catch:{ all -> 0x02a0 }
            throw r0     // Catch:{ all -> 0x02a0 }
        L_0x015d:
            r6 = r0
        L_0x015e:
            boolean r0 = r1.f10920p     // Catch:{ all -> 0x02a0 }
            if (r0 == 0) goto L_0x016d
            boolean r0 = r1.f10921q     // Catch:{ all -> 0x02a0 }
            if (r0 != 0) goto L_0x016d
            r0 = 1
            r1.f10921q = r0     // Catch:{ all -> 0x02a0 }
            r7 = 1
            r8 = 1
            r9 = 1
            goto L_0x016f
        L_0x016d:
            r7 = r17
        L_0x016f:
            boolean r0 = r1.f10921q     // Catch:{ all -> 0x02a0 }
            if (r0 == 0) goto L_0x0298
            boolean r0 = r1.f10929y     // Catch:{ all -> 0x02a0 }
            if (r0 == 0) goto L_0x019f
            int r0 = r1.f10923s     // Catch:{ all -> 0x02a0 }
            int r2 = r1.f10924t     // Catch:{ all -> 0x02a0 }
            r3 = 1
            r1.f10926v = r3     // Catch:{ all -> 0x02a0 }
            java.lang.String r3 = "GLThread"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a0 }
            r7.<init>()     // Catch:{ all -> 0x02a0 }
            java.lang.String r9 = "noticing that we want render notification tid="
            r7.append(r9)     // Catch:{ all -> 0x02a0 }
            long r9 = r18.getId()     // Catch:{ all -> 0x02a0 }
            r7.append(r9)     // Catch:{ all -> 0x02a0 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x02a0 }
            android.util.Log.i(r3, r7)     // Catch:{ all -> 0x02a0 }
            r3 = 0
            r1.f10929y = r3     // Catch:{ all -> 0x02a0 }
            r10 = r0
            r11 = r2
            r7 = 1
            r9 = 1
        L_0x019f:
            boolean r0 = r1.f10930z     // Catch:{ all -> 0x02a0 }
            if (r0 == 0) goto L_0x01a8
            r2 = 0
            r1.f10930z = r2     // Catch:{ all -> 0x02a0 }
            r7 = 1
            goto L_0x01a9
        L_0x01a8:
            r2 = 0
        L_0x01a9:
            r1.f10925u = r2     // Catch:{ all -> 0x02a0 }
            com.ctoo.mediaedit.tools.e$k r0 = r1.f10905a     // Catch:{ all -> 0x02a0 }
            r0.notifyAll()     // Catch:{ all -> 0x02a0 }
            boolean r0 = r1.f10926v     // Catch:{ all -> 0x02a0 }
            if (r0 == 0) goto L_0x01b5
            r14 = 1
        L_0x01b5:
            monitor-exit(r15)     // Catch:{ all -> 0x02a0 }
            if (r13 == 0) goto L_0x01bf
            r13.run()     // Catch:{ all -> 0x02a3 }
            r0 = 0
            r13 = 0
            goto L_0x0020
        L_0x01bf:
            if (r7 == 0) goto L_0x01f6
            java.lang.String r0 = "GLThread"
            java.lang.String r3 = "egl createSurface"
            android.util.Log.w(r0, r3)     // Catch:{ all -> 0x02a3 }
            cz.b r0 = r1.D     // Catch:{ all -> 0x02a3 }
            java.lang.Object r3 = r1.f10911g     // Catch:{ all -> 0x02a3 }
            boolean r0 = r0.a((java.lang.Object) r3)     // Catch:{ all -> 0x02a3 }
            if (r0 == 0) goto L_0x01e3
            com.ctoo.mediaedit.tools.e$k r3 = r1.f10905a     // Catch:{ all -> 0x02a3 }
            monitor-enter(r3)     // Catch:{ all -> 0x02a3 }
            r0 = 1
            r1.f10922r = r0     // Catch:{ all -> 0x01e0 }
            com.ctoo.mediaedit.tools.e$k r0 = r1.f10905a     // Catch:{ all -> 0x01e0 }
            r0.notifyAll()     // Catch:{ all -> 0x01e0 }
            monitor-exit(r3)     // Catch:{ all -> 0x01e0 }
            r7 = 0
            goto L_0x01f6
        L_0x01e0:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x01e0 }
            throw r0     // Catch:{ all -> 0x02a3 }
        L_0x01e3:
            com.ctoo.mediaedit.tools.e$k r3 = r1.f10905a     // Catch:{ all -> 0x02a3 }
            monitor-enter(r3)     // Catch:{ all -> 0x02a3 }
            r0 = 1
            r1.f10922r = r0     // Catch:{ all -> 0x01f3 }
            r1.f10918n = r0     // Catch:{ all -> 0x01f3 }
            com.ctoo.mediaedit.tools.e$k r0 = r1.f10905a     // Catch:{ all -> 0x01f3 }
            r0.notifyAll()     // Catch:{ all -> 0x01f3 }
            monitor-exit(r3)     // Catch:{ all -> 0x01f3 }
            goto L_0x0292
        L_0x01f3:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x01f3 }
            throw r0     // Catch:{ all -> 0x02a3 }
        L_0x01f6:
            if (r8 == 0) goto L_0x01f9
            r8 = 0
        L_0x01f9:
            if (r6 == 0) goto L_0x0208
            java.lang.String r0 = "GLThread"
            java.lang.String r3 = "onSurfaceCreated"
            android.util.Log.w(r0, r3)     // Catch:{ all -> 0x02a3 }
            cz.a r0 = r1.f10910f     // Catch:{ all -> 0x02a3 }
            r0.a()     // Catch:{ all -> 0x02a3 }
            r6 = 0
        L_0x0208:
            if (r9 == 0) goto L_0x0233
            java.lang.String r0 = "GLThread"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a3 }
            r3.<init>()     // Catch:{ all -> 0x02a3 }
            java.lang.String r9 = "onSurfaceChanged("
            r3.append(r9)     // Catch:{ all -> 0x02a3 }
            r3.append(r10)     // Catch:{ all -> 0x02a3 }
            java.lang.String r9 = ", "
            r3.append(r9)     // Catch:{ all -> 0x02a3 }
            r3.append(r11)     // Catch:{ all -> 0x02a3 }
            java.lang.String r9 = ")"
            r3.append(r9)     // Catch:{ all -> 0x02a3 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x02a3 }
            android.util.Log.w(r0, r3)     // Catch:{ all -> 0x02a3 }
            cz.a r0 = r1.f10910f     // Catch:{ all -> 0x02a3 }
            r0.a(r10, r11)     // Catch:{ all -> 0x02a3 }
            r9 = 0
        L_0x0233:
            com.ctoo.mediaedit.tools.e$d r0 = r1.B     // Catch:{ all -> 0x02a3 }
            boolean r0 = r0.b()     // Catch:{ all -> 0x02a3 }
            if (r0 == 0) goto L_0x028c
            if (r12 != 0) goto L_0x0241
            r0 = 0
            r12 = 1
            goto L_0x0020
        L_0x0241:
            cz.a r0 = r1.f10910f     // Catch:{ all -> 0x02a3 }
            r0.b()     // Catch:{ all -> 0x02a3 }
            cz.b r0 = r1.D     // Catch:{ all -> 0x02a3 }
            long r2 = r1.C     // Catch:{ all -> 0x02a3 }
            r0.a((long) r2)     // Catch:{ all -> 0x02a3 }
            cz.b r0 = r1.D     // Catch:{ all -> 0x02a3 }
            int r0 = r0.a()     // Catch:{ all -> 0x02a3 }
            com.ctoo.mediaedit.tools.e$d r2 = r1.B     // Catch:{ all -> 0x02a3 }
            r2.c()     // Catch:{ all -> 0x02a3 }
            r2 = 12288(0x3000, float:1.7219E-41)
            if (r0 == r2) goto L_0x028c
            r2 = 12302(0x300e, float:1.7239E-41)
            if (r0 == r2) goto L_0x0270
            com.ctoo.mediaedit.tools.e$k r2 = r1.f10905a     // Catch:{ all -> 0x02a3 }
            monitor-enter(r2)     // Catch:{ all -> 0x02a3 }
            r3 = 1
            r1.f10918n = r3     // Catch:{ all -> 0x026d }
            com.ctoo.mediaedit.tools.e$k r0 = r1.f10905a     // Catch:{ all -> 0x026d }
            r0.notifyAll()     // Catch:{ all -> 0x026d }
            monitor-exit(r2)     // Catch:{ all -> 0x026d }
            goto L_0x028c
        L_0x026d:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x026d }
            throw r0     // Catch:{ all -> 0x02a3 }
        L_0x0270:
            r3 = 1
            java.lang.String r0 = "GLThread"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x02a3 }
            r2.<init>()     // Catch:{ all -> 0x02a3 }
            java.lang.String r4 = "egl context lost tid="
            r2.append(r4)     // Catch:{ all -> 0x02a3 }
            long r3 = r18.getId()     // Catch:{ all -> 0x02a3 }
            r2.append(r3)     // Catch:{ all -> 0x02a3 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x02a3 }
            android.util.Log.i(r0, r2)     // Catch:{ all -> 0x02a3 }
            r4 = 1
        L_0x028c:
            if (r14 == 0) goto L_0x0292
            r0 = 0
            r5 = 1
            goto L_0x001f
        L_0x0292:
            r0 = 0
            goto L_0x0020
        L_0x0295:
            r6 = r0
            r7 = r17
        L_0x0298:
            com.ctoo.mediaedit.tools.e$k r0 = r1.f10905a     // Catch:{ all -> 0x02a0 }
            r0.wait()     // Catch:{ all -> 0x02a0 }
            r0 = 0
            goto L_0x0023
        L_0x02a0:
            r0 = move-exception
            monitor-exit(r15)     // Catch:{ all -> 0x02a0 }
            throw r0     // Catch:{ all -> 0x02a3 }
        L_0x02a3:
            r0 = move-exception
            com.ctoo.mediaedit.tools.e$k r2 = r1.f10905a
            monitor-enter(r2)
            r18.g()     // Catch:{ all -> 0x02af }
            r18.h()     // Catch:{ all -> 0x02af }
            monitor-exit(r2)     // Catch:{ all -> 0x02af }
            throw r0
        L_0x02af:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x02af }
            goto L_0x02b3
        L_0x02b2:
            throw r0
        L_0x02b3:
            goto L_0x02b2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ctoo.mediaedit.tools.e.i():void");
    }

    private boolean j() {
        return !this.f10916l && this.f10917m && !this.f10918n && this.f10923s > 0 && this.f10924t > 0 && this.f10925u;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:17|18|19|20|21|33|27|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0075, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x003a, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x006c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r5, int r6) {
        /*
            r4 = this;
            com.ctoo.mediaedit.tools.e$k r0 = r4.f10905a
            monitor-enter(r0)
            java.lang.String r1 = "GLThread"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r2.<init>()     // Catch:{ all -> 0x0076 }
            java.lang.String r3 = "width:"
            r2.append(r3)     // Catch:{ all -> 0x0076 }
            r2.append(r5)     // Catch:{ all -> 0x0076 }
            java.lang.String r3 = " height:"
            r2.append(r3)     // Catch:{ all -> 0x0076 }
            r2.append(r6)     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0076 }
            android.util.Log.d(r1, r2)     // Catch:{ all -> 0x0076 }
            r4.f10923s = r5     // Catch:{ all -> 0x0076 }
            r4.f10924t = r6     // Catch:{ all -> 0x0076 }
            r5 = 1
            r4.f10929y = r5     // Catch:{ all -> 0x0076 }
            r4.f10925u = r5     // Catch:{ all -> 0x0076 }
            r5 = 0
            r4.f10927w = r5     // Catch:{ all -> 0x0076 }
            java.lang.Thread r5 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0076 }
            if (r5 != r4) goto L_0x0035
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            return
        L_0x0035:
            com.ctoo.mediaedit.tools.e$k r5 = r4.f10905a     // Catch:{ all -> 0x0076 }
            r5.notifyAll()     // Catch:{ all -> 0x0076 }
        L_0x003a:
            boolean r5 = r4.f10914j     // Catch:{ all -> 0x0076 }
            if (r5 != 0) goto L_0x0074
            boolean r5 = r4.f10916l     // Catch:{ all -> 0x0076 }
            if (r5 != 0) goto L_0x0074
            boolean r5 = r4.f10927w     // Catch:{ all -> 0x0076 }
            if (r5 != 0) goto L_0x0074
            boolean r5 = r4.a()     // Catch:{ all -> 0x0076 }
            if (r5 == 0) goto L_0x0074
            java.lang.String r5 = "GLThread"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r6.<init>()     // Catch:{ all -> 0x0076 }
            java.lang.String r1 = "onWindowResize waiting for render complete from tid="
            r6.append(r1)     // Catch:{ all -> 0x0076 }
            long r1 = r4.getId()     // Catch:{ all -> 0x0076 }
            r6.append(r1)     // Catch:{ all -> 0x0076 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0076 }
            android.util.Log.i(r5, r6)     // Catch:{ all -> 0x0076 }
            com.ctoo.mediaedit.tools.e$k r5 = r4.f10905a     // Catch:{ InterruptedException -> 0x006c }
            r5.wait()     // Catch:{ InterruptedException -> 0x006c }
            goto L_0x003a
        L_0x006c:
            java.lang.Thread r5 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0076 }
            r5.interrupt()     // Catch:{ all -> 0x0076 }
            goto L_0x003a
        L_0x0074:
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            return
        L_0x0076:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            goto L_0x007a
        L_0x0079:
            throw r5
        L_0x007a:
            goto L_0x0079
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ctoo.mediaedit.tools.e.a(int, int):void");
    }

    public void a(long j2) {
        this.C = j2;
        synchronized (this.f10905a) {
            this.f10925u = true;
            this.f10905a.notifyAll();
        }
    }

    public void a(l lVar) {
        this.f10912h = lVar;
    }

    public void a(Runnable runnable) {
        if (runnable != null) {
            synchronized (this.f10905a) {
                this.f10928x.add(runnable);
                this.f10905a.notifyAll();
            }
            return;
        }
        throw new IllegalArgumentException("r must not be null");
    }

    public boolean a() {
        return this.f10920p && this.f10921q && j();
    }

    public a b() {
        return this.A;
    }

    public int c() {
        return this.f10906b;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:16|17|18|19|31|25|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0018, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0030 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void d() {
        /*
            r2 = this;
            com.ctoo.mediaedit.tools.e$k r0 = r2.f10905a
            monitor-enter(r0)
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x003a }
            if (r1 != r2) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            return
        L_0x000b:
            r1 = 1
            r2.f10926v = r1     // Catch:{ all -> 0x003a }
            r2.f10925u = r1     // Catch:{ all -> 0x003a }
            r1 = 0
            r2.f10927w = r1     // Catch:{ all -> 0x003a }
            com.ctoo.mediaedit.tools.e$k r1 = r2.f10905a     // Catch:{ all -> 0x003a }
            r1.notifyAll()     // Catch:{ all -> 0x003a }
        L_0x0018:
            boolean r1 = r2.f10914j     // Catch:{ all -> 0x003a }
            if (r1 != 0) goto L_0x0038
            boolean r1 = r2.f10916l     // Catch:{ all -> 0x003a }
            if (r1 != 0) goto L_0x0038
            boolean r1 = r2.f10927w     // Catch:{ all -> 0x003a }
            if (r1 != 0) goto L_0x0038
            boolean r1 = r2.a()     // Catch:{ all -> 0x003a }
            if (r1 == 0) goto L_0x0038
            com.ctoo.mediaedit.tools.e$k r1 = r2.f10905a     // Catch:{ InterruptedException -> 0x0030 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0030 }
            goto L_0x0018
        L_0x0030:
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x003a }
            r1.interrupt()     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x0038:
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            return
        L_0x003a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003a }
            goto L_0x003e
        L_0x003d:
            throw r1
        L_0x003e:
            goto L_0x003d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ctoo.mediaedit.tools.e.d():void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|25|20|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0028, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e() {
        /*
            r5 = this;
            com.ctoo.mediaedit.tools.e$k r0 = r5.f10905a
            monitor-enter(r0)
            java.lang.String r1 = "GLThread"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0044 }
            r2.<init>()     // Catch:{ all -> 0x0044 }
            java.lang.String r3 = "surfaceCreated tid="
            r2.append(r3)     // Catch:{ all -> 0x0044 }
            long r3 = r5.getId()     // Catch:{ all -> 0x0044 }
            r2.append(r3)     // Catch:{ all -> 0x0044 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0044 }
            android.util.Log.i(r1, r2)     // Catch:{ all -> 0x0044 }
            r1 = 1
            r5.f10917m = r1     // Catch:{ all -> 0x0044 }
            r1 = 0
            r5.f10922r = r1     // Catch:{ all -> 0x0044 }
            com.ctoo.mediaedit.tools.e$k r1 = r5.f10905a     // Catch:{ all -> 0x0044 }
            r1.notifyAll()     // Catch:{ all -> 0x0044 }
        L_0x0028:
            boolean r1 = r5.f10919o     // Catch:{ all -> 0x0044 }
            if (r1 == 0) goto L_0x0042
            boolean r1 = r5.f10922r     // Catch:{ all -> 0x0044 }
            if (r1 != 0) goto L_0x0042
            boolean r1 = r5.f10914j     // Catch:{ all -> 0x0044 }
            if (r1 != 0) goto L_0x0042
            com.ctoo.mediaedit.tools.e$k r1 = r5.f10905a     // Catch:{ InterruptedException -> 0x003a }
            r1.wait()     // Catch:{ InterruptedException -> 0x003a }
            goto L_0x0028
        L_0x003a:
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0044 }
            r1.interrupt()     // Catch:{ all -> 0x0044 }
            goto L_0x0028
        L_0x0042:
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            return
        L_0x0044:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0044 }
            goto L_0x0048
        L_0x0047:
            throw r1
        L_0x0048:
            goto L_0x0047
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ctoo.mediaedit.tools.e.e():void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:7|8|9|10|19|16|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x000b, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f() {
        /*
            r2 = this;
            com.ctoo.mediaedit.tools.e$k r0 = r2.f10905a
            monitor-enter(r0)
            r1 = 1
            r2.f10913i = r1     // Catch:{ all -> 0x001f }
            com.ctoo.mediaedit.tools.e$k r1 = r2.f10905a     // Catch:{ all -> 0x001f }
            r1.notifyAll()     // Catch:{ all -> 0x001f }
        L_0x000b:
            boolean r1 = r2.f10914j     // Catch:{ all -> 0x001f }
            if (r1 != 0) goto L_0x001d
            com.ctoo.mediaedit.tools.e$k r1 = r2.f10905a     // Catch:{ InterruptedException -> 0x0015 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0015 }
            goto L_0x000b
        L_0x0015:
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x001f }
            r1.interrupt()     // Catch:{ all -> 0x001f }
            goto L_0x000b
        L_0x001d:
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            return
        L_0x001f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x001f }
            goto L_0x0023
        L_0x0022:
            throw r1
        L_0x0023:
            goto L_0x0022
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ctoo.mediaedit.tools.e.f():void");
    }

    public void run() {
        setName("GLThread " + getId());
        Log.i("GLThread", "starting tid=" + getId());
        try {
            i();
        } catch (InterruptedException e2) {
            Log.e("GLThread", "", e2);
        } catch (Throwable th) {
            this.f10905a.a(this);
            throw th;
        }
        this.f10905a.a(this);
    }

    public synchronized void start() {
        super.start();
        this.B.a();
    }
}
