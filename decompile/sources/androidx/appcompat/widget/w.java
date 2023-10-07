package androidx.appcompat.widget;

import aj.i;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import androidx.appcompat.resources.R;
import j.h;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    private static final PorterDuff.Mode f1587a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private static w f1588b;

    /* renamed from: c  reason: collision with root package name */
    private static final c f1589c = new c(6);

    /* renamed from: d  reason: collision with root package name */
    private WeakHashMap<Context, h<ColorStateList>> f1590d;

    /* renamed from: e  reason: collision with root package name */
    private j.g<String, e> f1591e;

    /* renamed from: f  reason: collision with root package name */
    private h<String> f1592f;

    /* renamed from: g  reason: collision with root package name */
    private final WeakHashMap<Context, j.d<WeakReference<Drawable.ConstantState>>> f1593g = new WeakHashMap<>(0);

    /* renamed from: h  reason: collision with root package name */
    private TypedValue f1594h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1595i;

    /* renamed from: j  reason: collision with root package name */
    private f f1596j;

    static class a implements e {
        a() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return d.a.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e2);
                return null;
            }
        }
    }

    private static class b implements e {
        b() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return aj.c.a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e2);
                return null;
            }
        }
    }

    private static class c extends j.e<Integer, PorterDuffColorFilter> {
        public c(int i2) {
            super(i2);
        }

        private static int b(int i2, PorterDuff.Mode mode) {
            return ((i2 + 31) * 31) + mode.hashCode();
        }

        /* access modifiers changed from: package-private */
        public PorterDuffColorFilter a(int i2, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(b(i2, mode)));
        }

        /* access modifiers changed from: package-private */
        public PorterDuffColorFilter a(int i2, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(b(i2, mode)), porterDuffColorFilter);
        }
    }

    static class d implements e {
        d() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) d.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    if (Build.VERSION.SDK_INT >= 21) {
                        drawable.inflate(context.getResources(), xmlPullParser, attributeSet, theme);
                    } else {
                        drawable.inflate(context.getResources(), xmlPullParser, attributeSet);
                    }
                    return drawable;
                } catch (Exception e2) {
                    Log.e("DrawableDelegate", "Exception while inflating <drawable>", e2);
                }
            }
            return null;
        }
    }

    private interface e {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public interface f {
        ColorStateList a(Context context, int i2);

        PorterDuff.Mode a(int i2);

        Drawable a(w wVar, Context context, int i2);

        boolean a(Context context, int i2, Drawable drawable);

        boolean b(Context context, int i2, Drawable drawable);
    }

    private static class g implements e {
        g() {
        }

        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return i.a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e2);
                return null;
            }
        }
    }

    private static long a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    public static synchronized PorterDuffColorFilter a(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter a2;
        synchronized (w.class) {
            c cVar = f1589c;
            a2 = cVar.a(i2, mode);
            if (a2 == null) {
                a2 = new PorterDuffColorFilter(i2, mode);
                cVar.a(i2, mode, a2);
            }
        }
        return a2;
    }

    private static PorterDuffColorFilter a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return a(colorStateList.getColorForState(iArr, 0), mode);
    }

    private Drawable a(Context context, int i2, boolean z2, Drawable drawable) {
        ColorStateList b2 = b(context, i2);
        if (b2 != null) {
            if (q.c(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable g2 = androidx.core.graphics.drawable.a.g(drawable);
            androidx.core.graphics.drawable.a.a(g2, b2);
            PorterDuff.Mode a2 = a(i2);
            if (a2 == null) {
                return g2;
            }
            androidx.core.graphics.drawable.a.a(g2, a2);
            return g2;
        }
        f fVar = this.f1596j;
        if ((fVar == null || !fVar.a(context, i2, drawable)) && !a(context, i2, drawable) && z2) {
            return null;
        }
        return drawable;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized android.graphics.drawable.Drawable a(android.content.Context r4, long r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.WeakHashMap<android.content.Context, j.d<java.lang.ref.WeakReference<android.graphics.drawable.Drawable$ConstantState>>> r0 = r3.f1593g     // Catch:{ all -> 0x002d }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x002d }
            j.d r0 = (j.d) r0     // Catch:{ all -> 0x002d }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r3)
            return r1
        L_0x000e:
            java.lang.Object r2 = r0.a((long) r5)     // Catch:{ all -> 0x002d }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x002b
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable$ConstantState r2 = (android.graphics.drawable.Drawable.ConstantState) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x0028
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable r4 = r2.newDrawable(r4)     // Catch:{ all -> 0x002d }
            monitor-exit(r3)
            return r4
        L_0x0028:
            r0.c((long) r5)     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r3)
            return r1
        L_0x002d:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.w.a(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    public static synchronized w a() {
        w wVar;
        synchronized (w.class) {
            if (f1588b == null) {
                w wVar2 = new w();
                f1588b = wVar2;
                a(wVar2);
            }
            wVar = f1588b;
        }
        return wVar;
    }

    private void a(Context context, int i2, ColorStateList colorStateList) {
        if (this.f1590d == null) {
            this.f1590d = new WeakHashMap<>();
        }
        h hVar = this.f1590d.get(context);
        if (hVar == null) {
            hVar = new h();
            this.f1590d.put(context, hVar);
        }
        hVar.c(i2, colorStateList);
    }

    static void a(Drawable drawable, ad adVar, int[] iArr) {
        if (!q.c(drawable) || drawable.mutate() == drawable) {
            if (adVar.f1403d || adVar.f1402c) {
                drawable.setColorFilter(a(adVar.f1403d ? adVar.f1400a : null, adVar.f1402c ? adVar.f1401b : f1587a, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
    }

    private static void a(w wVar) {
        if (Build.VERSION.SDK_INT < 24) {
            wVar.a("vector", (e) new g());
            wVar.a("animated-vector", (e) new b());
            wVar.a("animated-selector", (e) new a());
            wVar.a("drawable", (e) new d());
        }
    }

    private void a(String str, e eVar) {
        if (this.f1591e == null) {
            this.f1591e = new j.g<>();
        }
        this.f1591e.put(str, eVar);
    }

    private synchronized boolean a(Context context, long j2, Drawable drawable) {
        boolean z2;
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            j.d dVar = this.f1593g.get(context);
            if (dVar == null) {
                dVar = new j.d();
                this.f1593g.put(context, dVar);
            }
            dVar.b(j2, new WeakReference(constantState));
            z2 = true;
        } else {
            z2 = false;
        }
        return z2;
    }

    private static boolean a(Drawable drawable) {
        return (drawable instanceof i) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private void b(Context context) {
        if (!this.f1595i) {
            this.f1595i = true;
            Drawable a2 = a(context, R.drawable.abc_vector_test);
            if (a2 == null || !a(a2)) {
                this.f1595i = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    private Drawable c(Context context, int i2) {
        if (this.f1594h == null) {
            this.f1594h = new TypedValue();
        }
        TypedValue typedValue = this.f1594h;
        context.getResources().getValue(i2, typedValue, true);
        long a2 = a(typedValue);
        Drawable a3 = a(context, a2);
        if (a3 != null) {
            return a3;
        }
        f fVar = this.f1596j;
        Drawable a4 = fVar == null ? null : fVar.a(this, context, i2);
        if (a4 != null) {
            a4.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, a2, a4);
        }
        return a4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0075 A[Catch:{ Exception -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009c A[Catch:{ Exception -> 0x00a4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable d(android.content.Context r11, int r12) {
        /*
            r10 = this;
            j.g<java.lang.String, androidx.appcompat.widget.w$e> r0 = r10.f1591e
            r1 = 0
            if (r0 == 0) goto L_0x00b4
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00b4
            j.h<java.lang.String> r0 = r10.f1592f
            java.lang.String r2 = "appcompat_skip_skip"
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r0.a((int) r12)
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = r2.equals(r0)
            if (r3 != 0) goto L_0x0027
            if (r0 == 0) goto L_0x002f
            j.g<java.lang.String, androidx.appcompat.widget.w$e> r3 = r10.f1591e
            java.lang.Object r0 = r3.get(r0)
            if (r0 != 0) goto L_0x002f
        L_0x0027:
            return r1
        L_0x0028:
            j.h r0 = new j.h
            r0.<init>()
            r10.f1592f = r0
        L_0x002f:
            android.util.TypedValue r0 = r10.f1594h
            if (r0 != 0) goto L_0x003a
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r10.f1594h = r0
        L_0x003a:
            android.util.TypedValue r0 = r10.f1594h
            android.content.res.Resources r1 = r11.getResources()
            r3 = 1
            r1.getValue(r12, r0, r3)
            long r4 = a((android.util.TypedValue) r0)
            android.graphics.drawable.Drawable r6 = r10.a((android.content.Context) r11, (long) r4)
            if (r6 == 0) goto L_0x004f
            return r6
        L_0x004f:
            java.lang.CharSequence r7 = r0.string
            if (r7 == 0) goto L_0x00ac
            java.lang.CharSequence r7 = r0.string
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = ".xml"
            boolean r7 = r7.endsWith(r8)
            if (r7 == 0) goto L_0x00ac
            android.content.res.XmlResourceParser r1 = r1.getXml(r12)     // Catch:{ Exception -> 0x00a4 }
            android.util.AttributeSet r7 = android.util.Xml.asAttributeSet(r1)     // Catch:{ Exception -> 0x00a4 }
        L_0x0069:
            int r8 = r1.next()     // Catch:{ Exception -> 0x00a4 }
            r9 = 2
            if (r8 == r9) goto L_0x0073
            if (r8 == r3) goto L_0x0073
            goto L_0x0069
        L_0x0073:
            if (r8 != r9) goto L_0x009c
            java.lang.String r3 = r1.getName()     // Catch:{ Exception -> 0x00a4 }
            j.h<java.lang.String> r8 = r10.f1592f     // Catch:{ Exception -> 0x00a4 }
            r8.c(r12, r3)     // Catch:{ Exception -> 0x00a4 }
            j.g<java.lang.String, androidx.appcompat.widget.w$e> r8 = r10.f1591e     // Catch:{ Exception -> 0x00a4 }
            java.lang.Object r3 = r8.get(r3)     // Catch:{ Exception -> 0x00a4 }
            androidx.appcompat.widget.w$e r3 = (androidx.appcompat.widget.w.e) r3     // Catch:{ Exception -> 0x00a4 }
            if (r3 == 0) goto L_0x0091
            android.content.res.Resources$Theme r8 = r11.getTheme()     // Catch:{ Exception -> 0x00a4 }
            android.graphics.drawable.Drawable r1 = r3.a(r11, r1, r7, r8)     // Catch:{ Exception -> 0x00a4 }
            r6 = r1
        L_0x0091:
            if (r6 == 0) goto L_0x00ac
            int r0 = r0.changingConfigurations     // Catch:{ Exception -> 0x00a4 }
            r6.setChangingConfigurations(r0)     // Catch:{ Exception -> 0x00a4 }
            r10.a((android.content.Context) r11, (long) r4, (android.graphics.drawable.Drawable) r6)     // Catch:{ Exception -> 0x00a4 }
            goto L_0x00ac
        L_0x009c:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r0 = "No start tag found"
            r11.<init>(r0)     // Catch:{ Exception -> 0x00a4 }
            throw r11     // Catch:{ Exception -> 0x00a4 }
        L_0x00a4:
            r11 = move-exception
            java.lang.String r0 = "ResourceManagerInternal"
            java.lang.String r1 = "Exception while inflating drawable"
            android.util.Log.e(r0, r1, r11)
        L_0x00ac:
            if (r6 != 0) goto L_0x00b3
            j.h<java.lang.String> r11 = r10.f1592f
            r11.c(r12, r2)
        L_0x00b3:
            return r6
        L_0x00b4:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.w.d(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    private ColorStateList e(Context context, int i2) {
        h hVar;
        WeakHashMap<Context, h<ColorStateList>> weakHashMap = this.f1590d;
        if (weakHashMap == null || (hVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) hVar.a(i2);
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode a(int i2) {
        f fVar = this.f1596j;
        if (fVar == null) {
            return null;
        }
        return fVar.a(i2);
    }

    public synchronized Drawable a(Context context, int i2) {
        return a(context, i2, false);
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable a(Context context, int i2, boolean z2) {
        Drawable d2;
        b(context);
        d2 = d(context, i2);
        if (d2 == null) {
            d2 = c(context, i2);
        }
        if (d2 == null) {
            d2 = androidx.core.content.b.a(context, i2);
        }
        if (d2 != null) {
            d2 = a(context, i2, z2, d2);
        }
        if (d2 != null) {
            q.b(d2);
        }
        return d2;
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable a(Context context, ak akVar, int i2) {
        Drawable d2 = d(context, i2);
        if (d2 == null) {
            d2 = akVar.a(i2);
        }
        if (d2 == null) {
            return null;
        }
        return a(context, i2, false, d2);
    }

    public synchronized void a(Context context) {
        j.d dVar = this.f1593g.get(context);
        if (dVar != null) {
            dVar.d();
        }
    }

    public synchronized void a(f fVar) {
        this.f1596j = fVar;
    }

    /* access modifiers changed from: package-private */
    public boolean a(Context context, int i2, Drawable drawable) {
        f fVar = this.f1596j;
        return fVar != null && fVar.b(context, i2, drawable);
    }

    /* access modifiers changed from: package-private */
    public synchronized ColorStateList b(Context context, int i2) {
        ColorStateList e2;
        e2 = e(context, i2);
        if (e2 == null) {
            f fVar = this.f1596j;
            e2 = fVar == null ? null : fVar.a(context, i2);
            if (e2 != null) {
                a(context, i2, e2);
            }
        }
        return e2;
    }
}
