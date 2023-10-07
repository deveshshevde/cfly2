package t;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class ak {

    /* renamed from: a  reason: collision with root package name */
    public static final ak f34443a = (Build.VERSION.SDK_INT >= 30 ? l.f34476e : g.f34459a);

    /* renamed from: b  reason: collision with root package name */
    private final g f34444b;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static Field f34445a;

        /* renamed from: b  reason: collision with root package name */
        private static Field f34446b;

        /* renamed from: c  reason: collision with root package name */
        private static Field f34447c;

        /* renamed from: d  reason: collision with root package name */
        private static boolean f34448d = true;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f34445a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f34446b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f34447c = declaredField3;
                declaredField3.setAccessible(true);
            } catch (ReflectiveOperationException e2) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e2.getMessage(), e2);
            }
        }

        public static ak a(View view) {
            if (f34448d && view.isAttachedToWindow()) {
                try {
                    Object obj = f34445a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f34446b.get(obj);
                        Rect rect2 = (Rect) f34447c.get(obj);
                        if (!(rect == null || rect2 == null)) {
                            ak a2 = new b().b(m.b.a(rect)).a(m.b.a(rect2)).a();
                            a2.a(a2);
                            a2.a(view.getRootView());
                            return a2;
                        }
                    }
                } catch (IllegalAccessException e2) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e2.getMessage(), e2);
                }
            }
            return null;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final c f34449a;

        public b() {
            this.f34449a = Build.VERSION.SDK_INT >= 30 ? new f() : Build.VERSION.SDK_INT >= 29 ? new e() : Build.VERSION.SDK_INT >= 20 ? new d() : new c();
        }

        public b(ak akVar) {
            this.f34449a = Build.VERSION.SDK_INT >= 30 ? new f(akVar) : Build.VERSION.SDK_INT >= 29 ? new e(akVar) : Build.VERSION.SDK_INT >= 20 ? new d(akVar) : new c(akVar);
        }

        @Deprecated
        public b a(m.b bVar) {
            this.f34449a.a(bVar);
            return this;
        }

        public ak a() {
            return this.f34449a.b();
        }

        @Deprecated
        public b b(m.b bVar) {
            this.f34449a.e(bVar);
            return this;
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        m.b[] f34450a;

        /* renamed from: b  reason: collision with root package name */
        private final ak f34451b;

        c() {
            this(new ak((ak) null));
        }

        c(ak akVar) {
            this.f34451b = akVar;
        }

        /* access modifiers changed from: protected */
        public final void a() {
            m.b[] bVarArr = this.f34450a;
            if (bVarArr != null) {
                m.b bVar = bVarArr[m.a(1)];
                m.b bVar2 = this.f34450a[m.a(2)];
                if (bVar2 == null) {
                    bVar2 = this.f34451b.a(2);
                }
                if (bVar == null) {
                    bVar = this.f34451b.a(1);
                }
                a(m.b.a(bVar, bVar2));
                m.b bVar3 = this.f34450a[m.a(16)];
                if (bVar3 != null) {
                    b(bVar3);
                }
                m.b bVar4 = this.f34450a[m.a(32)];
                if (bVar4 != null) {
                    c(bVar4);
                }
                m.b bVar5 = this.f34450a[m.a(64)];
                if (bVar5 != null) {
                    d(bVar5);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(m.b bVar) {
        }

        /* access modifiers changed from: package-private */
        public ak b() {
            a();
            return this.f34451b;
        }

        /* access modifiers changed from: package-private */
        public void b(m.b bVar) {
        }

        /* access modifiers changed from: package-private */
        public void c(m.b bVar) {
        }

        /* access modifiers changed from: package-private */
        public void d(m.b bVar) {
        }

        /* access modifiers changed from: package-private */
        public void e(m.b bVar) {
        }
    }

    private static class d extends c {

        /* renamed from: b  reason: collision with root package name */
        private static Field f34452b = null;

        /* renamed from: c  reason: collision with root package name */
        private static boolean f34453c = false;

        /* renamed from: d  reason: collision with root package name */
        private static Constructor<WindowInsets> f34454d = null;

        /* renamed from: e  reason: collision with root package name */
        private static boolean f34455e = false;

        /* renamed from: f  reason: collision with root package name */
        private WindowInsets f34456f;

        /* renamed from: g  reason: collision with root package name */
        private m.b f34457g;

        d() {
            this.f34456f = c();
        }

        d(ak akVar) {
            super(akVar);
            this.f34456f = akVar.m();
        }

        private static WindowInsets c() {
            if (!f34453c) {
                try {
                    f34452b = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
                }
                f34453c = true;
            }
            Field field = f34452b;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get((Object) null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
                }
            }
            if (!f34455e) {
                try {
                    f34454d = WindowInsets.class.getConstructor(new Class[]{Rect.class});
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
                }
                f34455e = true;
            }
            Constructor<WindowInsets> constructor = f34454d;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Object[]{new Rect()});
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void a(m.b bVar) {
            WindowInsets windowInsets = this.f34456f;
            if (windowInsets != null) {
                this.f34456f = windowInsets.replaceSystemWindowInsets(bVar.f31045b, bVar.f31046c, bVar.f31047d, bVar.f31048e);
            }
        }

        /* access modifiers changed from: package-private */
        public ak b() {
            a();
            ak a2 = ak.a(this.f34456f);
            a2.a(this.f34450a);
            a2.a(this.f34457g);
            return a2;
        }

        /* access modifiers changed from: package-private */
        public void e(m.b bVar) {
            this.f34457g = bVar;
        }
    }

    private static class e extends c {

        /* renamed from: b  reason: collision with root package name */
        final WindowInsets.Builder f34458b;

        e() {
            this.f34458b = new WindowInsets.Builder();
        }

        e(ak akVar) {
            super(akVar);
            WindowInsets.Builder builder;
            WindowInsets m2 = akVar.m();
            if (m2 == null) {
                builder = new WindowInsets.Builder();
            }
            this.f34458b = builder;
        }

        /* access modifiers changed from: package-private */
        public void a(m.b bVar) {
            this.f34458b.setSystemWindowInsets(bVar.a());
        }

        /* access modifiers changed from: package-private */
        public ak b() {
            a();
            ak a2 = ak.a(this.f34458b.build());
            a2.a(this.f34450a);
            return a2;
        }

        /* access modifiers changed from: package-private */
        public void b(m.b bVar) {
            this.f34458b.setSystemGestureInsets(bVar.a());
        }

        /* access modifiers changed from: package-private */
        public void c(m.b bVar) {
            this.f34458b.setMandatorySystemGestureInsets(bVar.a());
        }

        /* access modifiers changed from: package-private */
        public void d(m.b bVar) {
            this.f34458b.setTappableElementInsets(bVar.a());
        }

        /* access modifiers changed from: package-private */
        public void e(m.b bVar) {
            this.f34458b.setStableInsets(bVar.a());
        }
    }

    private static class f extends e {
        f() {
        }

        f(ak akVar) {
            super(akVar);
        }
    }

    private static class g {

        /* renamed from: a  reason: collision with root package name */
        static final ak f34459a = new b().a().j().h().g();

        /* renamed from: b  reason: collision with root package name */
        final ak f34460b;

        g(ak akVar) {
            this.f34460b = akVar;
        }

        /* access modifiers changed from: package-private */
        public m.b a(int i2) {
            return m.b.f31044a;
        }

        /* access modifiers changed from: package-private */
        public ak a(int i2, int i3, int i4, int i5) {
            return f34459a;
        }

        /* access modifiers changed from: package-private */
        public void a(View view) {
        }

        /* access modifiers changed from: package-private */
        public void a(m.b bVar) {
        }

        /* access modifiers changed from: package-private */
        public void a(ak akVar) {
        }

        public void a(m.b[] bVarArr) {
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return false;
        }

        public void b(m.b bVar) {
        }

        /* access modifiers changed from: package-private */
        public void b(ak akVar) {
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public ak c() {
            return this.f34460b;
        }

        /* access modifiers changed from: package-private */
        public ak d() {
            return this.f34460b;
        }

        /* access modifiers changed from: package-private */
        public d e() {
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return a() == gVar.a() && b() == gVar.b() && s.c.a((Object) g(), (Object) gVar.g()) && s.c.a((Object) h(), (Object) gVar.h()) && s.c.a((Object) e(), (Object) gVar.e());
        }

        /* access modifiers changed from: package-private */
        public ak f() {
            return this.f34460b;
        }

        /* access modifiers changed from: package-private */
        public m.b g() {
            return m.b.f31044a;
        }

        /* access modifiers changed from: package-private */
        public m.b h() {
            return m.b.f31044a;
        }

        public int hashCode() {
            return s.c.a(Boolean.valueOf(a()), Boolean.valueOf(b()), g(), h(), e());
        }

        /* access modifiers changed from: package-private */
        public m.b i() {
            return g();
        }

        /* access modifiers changed from: package-private */
        public m.b j() {
            return g();
        }

        /* access modifiers changed from: package-private */
        public m.b k() {
            return g();
        }
    }

    private static class h extends g {

        /* renamed from: e  reason: collision with root package name */
        private static boolean f34461e = false;

        /* renamed from: f  reason: collision with root package name */
        private static Method f34462f;

        /* renamed from: g  reason: collision with root package name */
        private static Class<?> f34463g;

        /* renamed from: h  reason: collision with root package name */
        private static Class<?> f34464h;

        /* renamed from: i  reason: collision with root package name */
        private static Field f34465i;

        /* renamed from: j  reason: collision with root package name */
        private static Field f34466j;

        /* renamed from: c  reason: collision with root package name */
        final WindowInsets f34467c;

        /* renamed from: d  reason: collision with root package name */
        m.b f34468d;

        /* renamed from: k  reason: collision with root package name */
        private m.b[] f34469k;

        /* renamed from: l  reason: collision with root package name */
        private m.b f34470l;

        /* renamed from: m  reason: collision with root package name */
        private ak f34471m;

        h(ak akVar, WindowInsets windowInsets) {
            super(akVar);
            this.f34470l = null;
            this.f34467c = windowInsets;
        }

        h(ak akVar, h hVar) {
            this(akVar, new WindowInsets(hVar.f34467c));
        }

        private m.b b(int i2, boolean z2) {
            m.b bVar = m.b.f31044a;
            for (int i3 = 1; i3 <= 256; i3 <<= 1) {
                if ((i2 & i3) != 0) {
                    bVar = m.b.a(bVar, a(i3, z2));
                }
            }
            return bVar;
        }

        private m.b b(View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!f34461e) {
                    m();
                }
                Method method = f34462f;
                if (!(method == null || f34464h == null || f34465i == null)) {
                    try {
                        Object invoke = method.invoke(view, new Object[0]);
                        if (invoke == null) {
                            Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                            return null;
                        }
                        Rect rect = (Rect) f34465i.get(f34466j.get(invoke));
                        if (rect != null) {
                            return m.b.a(rect);
                        }
                        return null;
                    } catch (ReflectiveOperationException e2) {
                        Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        private m.b l() {
            ak akVar = this.f34471m;
            return akVar != null ? akVar.k() : m.b.f31044a;
        }

        private static void m() {
            try {
                f34462f = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                f34463g = Class.forName("android.view.ViewRootImpl");
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f34464h = cls;
                f34465i = cls.getDeclaredField("mVisibleInsets");
                f34466j = f34463g.getDeclaredField("mAttachInfo");
                f34465i.setAccessible(true);
                f34466j.setAccessible(true);
            } catch (ReflectiveOperationException e2) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e2.getMessage(), e2);
            }
            f34461e = true;
        }

        public m.b a(int i2) {
            return b(i2, false);
        }

        /* access modifiers changed from: protected */
        public m.b a(int i2, boolean z2) {
            if (i2 == 1) {
                return z2 ? m.b.a(0, Math.max(l().f31046c, g().f31046c), 0, 0) : m.b.a(0, g().f31046c, 0, 0);
            }
            m.b bVar = null;
            if (i2 != 2) {
                if (i2 == 8) {
                    m.b[] bVarArr = this.f34469k;
                    if (bVarArr != null) {
                        bVar = bVarArr[m.a(8)];
                    }
                    if (bVar != null) {
                        return bVar;
                    }
                    m.b g2 = g();
                    m.b l2 = l();
                    if (g2.f31048e > l2.f31048e) {
                        return m.b.a(0, 0, 0, g2.f31048e);
                    }
                    m.b bVar2 = this.f34468d;
                    return (bVar2 == null || bVar2.equals(m.b.f31044a) || this.f34468d.f31048e <= l2.f31048e) ? m.b.f31044a : m.b.a(0, 0, 0, this.f34468d.f31048e);
                } else if (i2 == 16) {
                    return i();
                } else {
                    if (i2 == 32) {
                        return j();
                    }
                    if (i2 == 64) {
                        return k();
                    }
                    if (i2 != 128) {
                        return m.b.f31044a;
                    }
                    ak akVar = this.f34471m;
                    d i3 = akVar != null ? akVar.i() : e();
                    return i3 != null ? m.b.a(i3.c(), i3.a(), i3.d(), i3.b()) : m.b.f31044a;
                }
            } else if (z2) {
                m.b l3 = l();
                m.b h2 = h();
                return m.b.a(Math.max(l3.f31045b, h2.f31045b), 0, Math.max(l3.f31047d, h2.f31047d), Math.max(l3.f31048e, h2.f31048e));
            } else {
                m.b g3 = g();
                ak akVar2 = this.f34471m;
                if (akVar2 != null) {
                    bVar = akVar2.k();
                }
                int i4 = g3.f31048e;
                if (bVar != null) {
                    i4 = Math.min(i4, bVar.f31048e);
                }
                return m.b.a(g3.f31045b, 0, g3.f31047d, i4);
            }
        }

        /* access modifiers changed from: package-private */
        public ak a(int i2, int i3, int i4, int i5) {
            b bVar = new b(ak.a(this.f34467c));
            bVar.a(ak.a(g(), i2, i3, i4, i5));
            bVar.b(ak.a(h(), i2, i3, i4, i5));
            return bVar.a();
        }

        /* access modifiers changed from: package-private */
        public void a(View view) {
            m.b b2 = b(view);
            if (b2 == null) {
                b2 = m.b.f31044a;
            }
            a(b2);
        }

        /* access modifiers changed from: package-private */
        public void a(m.b bVar) {
            this.f34468d = bVar;
        }

        /* access modifiers changed from: package-private */
        public void a(ak akVar) {
            this.f34471m = akVar;
        }

        public void a(m.b[] bVarArr) {
            this.f34469k = bVarArr;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.f34467c.isRound();
        }

        /* access modifiers changed from: package-private */
        public void b(ak akVar) {
            akVar.a(this.f34471m);
            akVar.b(this.f34468d);
        }

        public boolean equals(Object obj) {
            if (!super.equals(obj)) {
                return false;
            }
            return Objects.equals(this.f34468d, ((h) obj).f34468d);
        }

        /* access modifiers changed from: package-private */
        public final m.b g() {
            if (this.f34470l == null) {
                this.f34470l = m.b.a(this.f34467c.getSystemWindowInsetLeft(), this.f34467c.getSystemWindowInsetTop(), this.f34467c.getSystemWindowInsetRight(), this.f34467c.getSystemWindowInsetBottom());
            }
            return this.f34470l;
        }
    }

    private static class i extends h {

        /* renamed from: e  reason: collision with root package name */
        private m.b f34472e = null;

        i(ak akVar, WindowInsets windowInsets) {
            super(akVar, windowInsets);
        }

        i(ak akVar, i iVar) {
            super(akVar, (h) iVar);
            this.f34472e = iVar.f34472e;
        }

        public void b(m.b bVar) {
            this.f34472e = bVar;
        }

        /* access modifiers changed from: package-private */
        public boolean b() {
            return this.f34467c.isConsumed();
        }

        /* access modifiers changed from: package-private */
        public ak c() {
            return ak.a(this.f34467c.consumeSystemWindowInsets());
        }

        /* access modifiers changed from: package-private */
        public ak d() {
            return ak.a(this.f34467c.consumeStableInsets());
        }

        /* access modifiers changed from: package-private */
        public final m.b h() {
            if (this.f34472e == null) {
                this.f34472e = m.b.a(this.f34467c.getStableInsetLeft(), this.f34467c.getStableInsetTop(), this.f34467c.getStableInsetRight(), this.f34467c.getStableInsetBottom());
            }
            return this.f34472e;
        }
    }

    private static class j extends i {
        j(ak akVar, WindowInsets windowInsets) {
            super(akVar, windowInsets);
        }

        j(ak akVar, j jVar) {
            super(akVar, (i) jVar);
        }

        /* access modifiers changed from: package-private */
        public d e() {
            return d.a(this.f34467c.getDisplayCutout());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return Objects.equals(this.f34467c, jVar.f34467c) && Objects.equals(this.f34468d, jVar.f34468d);
        }

        /* access modifiers changed from: package-private */
        public ak f() {
            return ak.a(this.f34467c.consumeDisplayCutout());
        }

        public int hashCode() {
            return this.f34467c.hashCode();
        }
    }

    private static class k extends j {

        /* renamed from: e  reason: collision with root package name */
        private m.b f34473e = null;

        /* renamed from: f  reason: collision with root package name */
        private m.b f34474f = null;

        /* renamed from: g  reason: collision with root package name */
        private m.b f34475g = null;

        k(ak akVar, WindowInsets windowInsets) {
            super(akVar, windowInsets);
        }

        k(ak akVar, k kVar) {
            super(akVar, (j) kVar);
        }

        /* access modifiers changed from: package-private */
        public ak a(int i2, int i3, int i4, int i5) {
            return ak.a(this.f34467c.inset(i2, i3, i4, i5));
        }

        public void b(m.b bVar) {
        }

        /* access modifiers changed from: package-private */
        public m.b i() {
            if (this.f34473e == null) {
                this.f34473e = m.b.a(this.f34467c.getSystemGestureInsets());
            }
            return this.f34473e;
        }

        /* access modifiers changed from: package-private */
        public m.b j() {
            if (this.f34474f == null) {
                this.f34474f = m.b.a(this.f34467c.getMandatorySystemGestureInsets());
            }
            return this.f34474f;
        }

        /* access modifiers changed from: package-private */
        public m.b k() {
            if (this.f34475g == null) {
                this.f34475g = m.b.a(this.f34467c.getTappableElementInsets());
            }
            return this.f34475g;
        }
    }

    private static class l extends k {

        /* renamed from: e  reason: collision with root package name */
        static final ak f34476e = ak.a(WindowInsets.CONSUMED);

        l(ak akVar, WindowInsets windowInsets) {
            super(akVar, windowInsets);
        }

        l(ak akVar, l lVar) {
            super(akVar, (k) lVar);
        }

        public m.b a(int i2) {
            return m.b.a(this.f34467c.getInsets(n.a(i2)));
        }

        /* access modifiers changed from: package-private */
        public final void a(View view) {
        }
    }

    public static final class m {
        static int a(int i2) {
            if (i2 == 1) {
                return 0;
            }
            if (i2 == 2) {
                return 1;
            }
            if (i2 == 4) {
                return 2;
            }
            if (i2 == 8) {
                return 3;
            }
            if (i2 == 16) {
                return 4;
            }
            if (i2 == 32) {
                return 5;
            }
            if (i2 == 64) {
                return 6;
            }
            if (i2 == 128) {
                return 7;
            }
            if (i2 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i2);
        }
    }

    private static final class n {
        static int a(int i2) {
            int i3;
            int i4 = 0;
            for (int i5 = 1; i5 <= 256; i5 <<= 1) {
                if ((i2 & i5) != 0) {
                    if (i5 == 1) {
                        i3 = WindowInsets.Type.statusBars();
                    } else if (i5 == 2) {
                        i3 = WindowInsets.Type.navigationBars();
                    } else if (i5 == 4) {
                        i3 = WindowInsets.Type.captionBar();
                    } else if (i5 == 8) {
                        i3 = WindowInsets.Type.ime();
                    } else if (i5 == 16) {
                        i3 = WindowInsets.Type.systemGestures();
                    } else if (i5 == 32) {
                        i3 = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i5 == 64) {
                        i3 = WindowInsets.Type.tappableElement();
                    } else if (i5 == 128) {
                        i3 = WindowInsets.Type.displayCutout();
                    }
                    i4 |= i3;
                }
            }
            return i4;
        }
    }

    private ak(WindowInsets windowInsets) {
        g hVar;
        if (Build.VERSION.SDK_INT >= 30) {
            hVar = new l(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 29) {
            hVar = new k(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 28) {
            hVar = new j(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 21) {
            hVar = new i(this, windowInsets);
        } else if (Build.VERSION.SDK_INT >= 20) {
            hVar = new h(this, windowInsets);
        } else {
            this.f34444b = new g(this);
            return;
        }
        this.f34444b = hVar;
    }

    public ak(ak akVar) {
        if (akVar != null) {
            g gVar = akVar.f34444b;
            this.f34444b = (Build.VERSION.SDK_INT < 30 || !(gVar instanceof l)) ? (Build.VERSION.SDK_INT < 29 || !(gVar instanceof k)) ? (Build.VERSION.SDK_INT < 28 || !(gVar instanceof j)) ? (Build.VERSION.SDK_INT < 21 || !(gVar instanceof i)) ? (Build.VERSION.SDK_INT < 20 || !(gVar instanceof h)) ? new g(this) : new h(this, (h) gVar) : new i(this, (i) gVar) : new j(this, (j) gVar) : new k(this, (k) gVar) : new l(this, (l) gVar);
            gVar.b(this);
            return;
        }
        this.f34444b = new g(this);
    }

    static m.b a(m.b bVar, int i2, int i3, int i4, int i5) {
        int max = Math.max(0, bVar.f31045b - i2);
        int max2 = Math.max(0, bVar.f31046c - i3);
        int max3 = Math.max(0, bVar.f31047d - i4);
        int max4 = Math.max(0, bVar.f31048e - i5);
        return (max == i2 && max2 == i3 && max3 == i4 && max4 == i5) ? bVar : m.b.a(max, max2, max3, max4);
    }

    public static ak a(WindowInsets windowInsets) {
        return a(windowInsets, (View) null);
    }

    public static ak a(WindowInsets windowInsets, View view) {
        ak akVar = new ak((WindowInsets) s.f.a(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            akVar.a(ac.y(view));
            akVar.a(view.getRootView());
        }
        return akVar;
    }

    @Deprecated
    public int a() {
        return this.f34444b.g().f31045b;
    }

    public m.b a(int i2) {
        return this.f34444b.a(i2);
    }

    @Deprecated
    public ak a(int i2, int i3, int i4, int i5) {
        return new b(this).a(m.b.a(i2, i3, i4, i5)).a();
    }

    /* access modifiers changed from: package-private */
    public void a(View view) {
        this.f34444b.a(view);
    }

    /* access modifiers changed from: package-private */
    public void a(m.b bVar) {
        this.f34444b.b(bVar);
    }

    /* access modifiers changed from: package-private */
    public void a(ak akVar) {
        this.f34444b.a(akVar);
    }

    /* access modifiers changed from: package-private */
    public void a(m.b[] bVarArr) {
        this.f34444b.a(bVarArr);
    }

    @Deprecated
    public int b() {
        return this.f34444b.g().f31046c;
    }

    public ak b(int i2, int i3, int i4, int i5) {
        return this.f34444b.a(i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    public void b(m.b bVar) {
        this.f34444b.a(bVar);
    }

    @Deprecated
    public int c() {
        return this.f34444b.g().f31047d;
    }

    @Deprecated
    public int d() {
        return this.f34444b.g().f31048e;
    }

    @Deprecated
    public boolean e() {
        return !this.f34444b.g().equals(m.b.f31044a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ak)) {
            return false;
        }
        return s.c.a((Object) this.f34444b, (Object) ((ak) obj).f34444b);
    }

    public boolean f() {
        return this.f34444b.b();
    }

    @Deprecated
    public ak g() {
        return this.f34444b.c();
    }

    @Deprecated
    public ak h() {
        return this.f34444b.d();
    }

    public int hashCode() {
        g gVar = this.f34444b;
        if (gVar == null) {
            return 0;
        }
        return gVar.hashCode();
    }

    public d i() {
        return this.f34444b.e();
    }

    @Deprecated
    public ak j() {
        return this.f34444b.f();
    }

    @Deprecated
    public m.b k() {
        return this.f34444b.h();
    }

    @Deprecated
    public m.b l() {
        return this.f34444b.j();
    }

    public WindowInsets m() {
        g gVar = this.f34444b;
        if (gVar instanceof h) {
            return ((h) gVar).f34467c;
        }
        return null;
    }
}
