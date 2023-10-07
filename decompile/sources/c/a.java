package c;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.appcompat.widget.w;
import androidx.core.content.b;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f6158a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap<Context, SparseArray<C0064a>> f6159b = new WeakHashMap<>(0);

    /* renamed from: c  reason: collision with root package name */
    private static final Object f6160c = new Object();

    /* renamed from: c.a$a  reason: collision with other inner class name */
    private static class C0064a {

        /* renamed from: a  reason: collision with root package name */
        final ColorStateList f6161a;

        /* renamed from: b  reason: collision with root package name */
        final Configuration f6162b;

        C0064a(ColorStateList colorStateList, Configuration configuration) {
            this.f6161a = colorStateList;
            this.f6162b = configuration;
        }
    }

    public static ColorStateList a(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i2);
        }
        ColorStateList d2 = d(context, i2);
        if (d2 != null) {
            return d2;
        }
        ColorStateList c2 = c(context, i2);
        if (c2 == null) {
            return b.b(context, i2);
        }
        a(context, i2, c2);
        return c2;
    }

    private static TypedValue a() {
        ThreadLocal<TypedValue> threadLocal = f6158a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    private static void a(Context context, int i2, ColorStateList colorStateList) {
        synchronized (f6160c) {
            WeakHashMap<Context, SparseArray<C0064a>> weakHashMap = f6159b;
            SparseArray sparseArray = weakHashMap.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                weakHashMap.put(context, sparseArray);
            }
            sparseArray.append(i2, new C0064a(colorStateList, context.getResources().getConfiguration()));
        }
    }

    public static Drawable b(Context context, int i2) {
        return w.a().a(context, i2);
    }

    private static ColorStateList c(Context context, int i2) {
        if (e(context, i2)) {
            return null;
        }
        Resources resources = context.getResources();
        try {
            return l.a.a(resources, (XmlPullParser) resources.getXml(i2), context.getTheme());
        } catch (Exception e2) {
            Log.e("AppCompatResources", "Failed to inflate ColorStateList, leaving it to the framework", e2);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList d(android.content.Context r4, int r5) {
        /*
            java.lang.Object r0 = f6160c
            monitor-enter(r0)
            java.util.WeakHashMap<android.content.Context, android.util.SparseArray<c.a$a>> r1 = f6159b     // Catch:{ all -> 0x0035 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0035 }
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0032
            int r2 = r1.size()     // Catch:{ all -> 0x0035 }
            if (r2 <= 0) goto L_0x0032
            java.lang.Object r2 = r1.get(r5)     // Catch:{ all -> 0x0035 }
            c.a$a r2 = (c.a.C0064a) r2     // Catch:{ all -> 0x0035 }
            if (r2 == 0) goto L_0x0032
            android.content.res.Configuration r3 = r2.f6162b     // Catch:{ all -> 0x0035 }
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x0035 }
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch:{ all -> 0x0035 }
            boolean r4 = r3.equals(r4)     // Catch:{ all -> 0x0035 }
            if (r4 == 0) goto L_0x002f
            android.content.res.ColorStateList r4 = r2.f6161a     // Catch:{ all -> 0x0035 }
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return r4
        L_0x002f:
            r1.remove(r5)     // Catch:{ all -> 0x0035 }
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            r4 = 0
            return r4
        L_0x0035:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: c.a.d(android.content.Context, int):android.content.res.ColorStateList");
    }

    private static boolean e(Context context, int i2) {
        Resources resources = context.getResources();
        TypedValue a2 = a();
        resources.getValue(i2, a2, true);
        return a2.type >= 28 && a2.type <= 31;
    }
}
