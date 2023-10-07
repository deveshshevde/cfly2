package l;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f30668a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap<b, SparseArray<a>> f30669b = new WeakHashMap<>(0);

    /* renamed from: c  reason: collision with root package name */
    private static final Object f30670c = new Object();

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        final ColorStateList f30671a;

        /* renamed from: b  reason: collision with root package name */
        final Configuration f30672b;

        a(ColorStateList colorStateList, Configuration configuration) {
            this.f30671a = colorStateList;
            this.f30672b = configuration;
        }
    }

    private static final class b {

        /* renamed from: a  reason: collision with root package name */
        final Resources f30673a;

        /* renamed from: b  reason: collision with root package name */
        final Resources.Theme f30674b;

        b(Resources resources, Resources.Theme theme) {
            this.f30673a = resources;
            this.f30674b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return this.f30673a.equals(bVar.f30673a) && s.c.a((Object) this.f30674b, (Object) bVar.f30674b);
        }

        public int hashCode() {
            return s.c.a(this.f30673a, this.f30674b);
        }
    }

    public static abstract class c {
        public static Handler a(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        public abstract void a(int i2);

        public final void a(final int i2, Handler handler) {
            a(handler).post(new Runnable() {
                public void run() {
                    c.this.a(i2);
                }
            });
        }

        public abstract void a(Typeface typeface);

        public final void a(final Typeface typeface, Handler handler) {
            a(handler).post(new Runnable() {
                public void run() {
                    c.this.a(typeface);
                }
            });
        }
    }

    public static final class d {

        static class a {

            /* renamed from: a  reason: collision with root package name */
            private static final Object f30679a = new Object();

            /* renamed from: b  reason: collision with root package name */
            private static Method f30680b;

            /* renamed from: c  reason: collision with root package name */
            private static boolean f30681c;

            static void a(Resources.Theme theme) {
                synchronized (f30679a) {
                    if (!f30681c) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                            f30680b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e2) {
                            Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e2);
                        }
                        f30681c = true;
                    }
                    Method method = f30680b;
                    if (method != null) {
                        try {
                            method.invoke(theme, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException e3) {
                            Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e3);
                            f30680b = null;
                        }
                    }
                }
            }
        }

        static class b {
            static void a(Resources.Theme theme) {
                theme.rebase();
            }
        }

        public static void a(Resources.Theme theme) {
            if (Build.VERSION.SDK_INT >= 29) {
                b.a(theme);
            } else if (Build.VERSION.SDK_INT >= 23) {
                a.a(theme);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList a(l.f.b r4, int r5) {
        /*
            java.lang.Object r0 = f30670c
            monitor-enter(r0)
            java.util.WeakHashMap<l.f$b, android.util.SparseArray<l.f$a>> r1 = f30669b     // Catch:{ all -> 0x0033 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0033 }
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch:{ all -> 0x0033 }
            if (r1 == 0) goto L_0x0030
            int r2 = r1.size()     // Catch:{ all -> 0x0033 }
            if (r2 <= 0) goto L_0x0030
            java.lang.Object r2 = r1.get(r5)     // Catch:{ all -> 0x0033 }
            l.f$a r2 = (l.f.a) r2     // Catch:{ all -> 0x0033 }
            if (r2 == 0) goto L_0x0030
            android.content.res.Configuration r3 = r2.f30672b     // Catch:{ all -> 0x0033 }
            android.content.res.Resources r4 = r4.f30673a     // Catch:{ all -> 0x0033 }
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch:{ all -> 0x0033 }
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x0033 }
            if (r4 == 0) goto L_0x002d
            android.content.res.ColorStateList r4 = r2.f30671a     // Catch:{ all -> 0x0033 }
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            return r4
        L_0x002d:
            r1.remove(r5)     // Catch:{ all -> 0x0033 }
        L_0x0030:
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            r4 = 0
            return r4
        L_0x0033:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: l.f.a(l.f$b, int):android.content.res.ColorStateList");
    }

    public static Typeface a(Context context, int i2) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return a(context, i2, new TypedValue(), 0, (c) null, (Handler) null, false, false);
    }

    public static Typeface a(Context context, int i2, TypedValue typedValue, int i3, c cVar) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return a(context, i2, typedValue, i3, cVar, (Handler) null, true, false);
    }

    private static Typeface a(Context context, int i2, TypedValue typedValue, int i3, c cVar, Handler handler, boolean z2, boolean z3) {
        Resources resources = context.getResources();
        int i4 = i2;
        resources.getValue(i2, typedValue, true);
        Typeface a2 = a(context, resources, typedValue, i2, i3, cVar, handler, z2, z3);
        if (a2 != null || cVar != null || z3) {
            return a2;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i2) + " could not be retrieved.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x009b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Typeface a(android.content.Context r15, android.content.res.Resources r16, android.util.TypedValue r17, int r18, int r19, l.f.c r20, android.os.Handler r21, boolean r22, boolean r23) {
        /*
            r0 = r16
            r1 = r17
            r4 = r18
            r5 = r19
            r9 = r20
            r10 = r21
            java.lang.String r11 = "ResourcesCompat"
            java.lang.CharSequence r2 = r1.string
            if (r2 == 0) goto L_0x009f
            java.lang.CharSequence r1 = r1.string
            java.lang.String r12 = r1.toString()
            java.lang.String r1 = "res/"
            boolean r1 = r12.startsWith(r1)
            r13 = -3
            r14 = 0
            if (r1 != 0) goto L_0x0028
            if (r9 == 0) goto L_0x0027
            r9.a((int) r13, (android.os.Handler) r10)
        L_0x0027:
            return r14
        L_0x0028:
            android.graphics.Typeface r1 = m.d.a((android.content.res.Resources) r0, (int) r4, (int) r5)
            if (r1 == 0) goto L_0x0034
            if (r9 == 0) goto L_0x0033
            r9.a((android.graphics.Typeface) r1, (android.os.Handler) r10)
        L_0x0033:
            return r1
        L_0x0034:
            if (r23 == 0) goto L_0x0037
            return r14
        L_0x0037:
            java.lang.String r1 = r12.toLowerCase()     // Catch:{ XmlPullParserException -> 0x0084, IOException -> 0x007b }
            java.lang.String r2 = ".xml"
            boolean r1 = r1.endsWith(r2)     // Catch:{ XmlPullParserException -> 0x0084, IOException -> 0x007b }
            if (r1 == 0) goto L_0x006a
            android.content.res.XmlResourceParser r1 = r0.getXml(r4)     // Catch:{ XmlPullParserException -> 0x0084, IOException -> 0x007b }
            l.c$a r2 = l.c.a((org.xmlpull.v1.XmlPullParser) r1, (android.content.res.Resources) r0)     // Catch:{ XmlPullParserException -> 0x0084, IOException -> 0x007b }
            if (r2 != 0) goto L_0x0058
            java.lang.String r0 = "Failed to find font-family tag"
            android.util.Log.e(r11, r0)     // Catch:{ XmlPullParserException -> 0x0084, IOException -> 0x007b }
            if (r9 == 0) goto L_0x0057
            r9.a((int) r13, (android.os.Handler) r10)     // Catch:{ XmlPullParserException -> 0x0084, IOException -> 0x007b }
        L_0x0057:
            return r14
        L_0x0058:
            r1 = r15
            r3 = r16
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            android.graphics.Typeface r0 = m.d.a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ XmlPullParserException -> 0x0084, IOException -> 0x007b }
            return r0
        L_0x006a:
            r1 = r15
            android.graphics.Typeface r0 = m.d.a(r15, r0, r4, r12, r5)     // Catch:{ XmlPullParserException -> 0x0084, IOException -> 0x007b }
            if (r9 == 0) goto L_0x007a
            if (r0 == 0) goto L_0x0077
            r9.a((android.graphics.Typeface) r0, (android.os.Handler) r10)     // Catch:{ XmlPullParserException -> 0x0084, IOException -> 0x007b }
            goto L_0x007a
        L_0x0077:
            r9.a((int) r13, (android.os.Handler) r10)     // Catch:{ XmlPullParserException -> 0x0084, IOException -> 0x007b }
        L_0x007a:
            return r0
        L_0x007b:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to read xml resource "
            goto L_0x008c
        L_0x0084:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to parse xml resource "
        L_0x008c:
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r11, r1, r0)
            if (r9 == 0) goto L_0x009e
            r9.a((int) r13, (android.os.Handler) r10)
        L_0x009e:
            return r14
        L_0x009f:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Resource \""
            r3.append(r5)
            java.lang.String r0 = r0.getResourceName(r4)
            r3.append(r0)
            java.lang.String r0 = "\" ("
            r3.append(r0)
            java.lang.String r0 = java.lang.Integer.toHexString(r18)
            r3.append(r0)
            java.lang.String r0 = ") is not a Font: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: l.f.a(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, l.f$c, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }

    public static Drawable a(Resources resources, int i2, Resources.Theme theme) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 21 ? resources.getDrawable(i2, theme) : resources.getDrawable(i2);
    }

    private static TypedValue a() {
        ThreadLocal<TypedValue> threadLocal = f30668a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static void a(Context context, int i2, c cVar, Handler handler) throws Resources.NotFoundException {
        s.f.a(cVar);
        if (context.isRestricted()) {
            cVar.a(-4, handler);
            return;
        }
        a(context, i2, new TypedValue(), 0, cVar, handler, false, false);
    }

    private static void a(b bVar, int i2, ColorStateList colorStateList) {
        synchronized (f30670c) {
            WeakHashMap<b, SparseArray<a>> weakHashMap = f30669b;
            SparseArray sparseArray = weakHashMap.get(bVar);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                weakHashMap.put(bVar, sparseArray);
            }
            sparseArray.append(i2, new a(colorStateList, bVar.f30673a.getConfiguration()));
        }
    }

    private static boolean a(Resources resources, int i2) {
        TypedValue a2 = a();
        resources.getValue(i2, a2, true);
        return a2.type >= 28 && a2.type <= 31;
    }

    public static int b(Resources resources, int i2, Resources.Theme theme) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 23 ? resources.getColor(i2, theme) : resources.getColor(i2);
    }

    public static Typeface b(Context context, int i2) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return a(context, i2, new TypedValue(), 0, (c) null, (Handler) null, false, true);
    }

    public static ColorStateList c(Resources resources, int i2, Resources.Theme theme) throws Resources.NotFoundException {
        if (Build.VERSION.SDK_INT >= 23) {
            return resources.getColorStateList(i2, theme);
        }
        b bVar = new b(resources, theme);
        ColorStateList a2 = a(bVar, i2);
        if (a2 != null) {
            return a2;
        }
        ColorStateList d2 = d(resources, i2, theme);
        if (d2 == null) {
            return resources.getColorStateList(i2);
        }
        a(bVar, i2, d2);
        return d2;
    }

    private static ColorStateList d(Resources resources, int i2, Resources.Theme theme) {
        if (a(resources, i2)) {
            return null;
        }
        try {
            return a.a(resources, (XmlPullParser) resources.getXml(i2), theme);
        } catch (Exception e2) {
            Log.e("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e2);
            return null;
        }
    }
}
