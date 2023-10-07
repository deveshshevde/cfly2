package m;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
import l.c;
import q.f;

public class g extends e {

    /* renamed from: a  reason: collision with root package name */
    protected final Class<?> f31065a;

    /* renamed from: b  reason: collision with root package name */
    protected final Constructor<?> f31066b;

    /* renamed from: c  reason: collision with root package name */
    protected final Method f31067c;

    /* renamed from: d  reason: collision with root package name */
    protected final Method f31068d;

    /* renamed from: e  reason: collision with root package name */
    protected final Method f31069e;

    /* renamed from: f  reason: collision with root package name */
    protected final Method f31070f;

    /* renamed from: g  reason: collision with root package name */
    protected final Method f31071g;

    public g() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Constructor<?> constructor;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> a2 = a();
            constructor = a(a2);
            method4 = b(a2);
            method3 = c(a2);
            method2 = d(a2);
            method = e(a2);
            Class<?> cls2 = a2;
            method5 = f(a2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e2.getClass().getName(), e2);
            method5 = null;
            constructor = null;
            method4 = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        this.f31065a = cls;
        this.f31066b = constructor;
        this.f31067c = method4;
        this.f31068d = method3;
        this.f31069e = method2;
        this.f31070f = method;
        this.f31071g = method5;
    }

    private boolean a(Context context, Object obj, String str, int i2, int i3, int i4, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f31067c.invoke(obj, new Object[]{context.getAssets(), str, 0, false, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), fontVariationAxisArr})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean a(Object obj, ByteBuffer byteBuffer, int i2, int i3, int i4) {
        try {
            return ((Boolean) this.f31068d.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i2), null, Integer.valueOf(i3), Integer.valueOf(i4)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean b() {
        if (this.f31067c == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.f31067c != null;
    }

    private boolean b(Object obj) {
        try {
            return ((Boolean) this.f31069e.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private Object c() {
        try {
            return this.f31066b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private void c(Object obj) {
        try {
            this.f31070f.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public Typeface a(Context context, Resources resources, int i2, String str, int i3) {
        if (!b()) {
            return super.a(context, resources, i2, str, i3);
        }
        Object c2 = c();
        if (c2 == null) {
            return null;
        }
        if (!a(context, c2, str, 0, -1, -1, (FontVariationAxis[]) null)) {
            c(c2);
            return null;
        } else if (!b(c2)) {
            return null;
        } else {
            return a(c2);
        }
    }

    public Typeface a(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i2) {
        Typeface a2;
        ParcelFileDescriptor openFileDescriptor;
        if (bVarArr.length < 1) {
            return null;
        }
        if (!b()) {
            f.b a3 = a(bVarArr, i2);
            try {
                openFileDescriptor = context.getContentResolver().openFileDescriptor(a3.a(), "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(a3.c()).setItalic(a3.d()).build();
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return build;
            } catch (IOException unused) {
                return null;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            Map<Uri, ByteBuffer> a4 = k.a(context, bVarArr, cancellationSignal);
            Object c2 = c();
            if (c2 == null) {
                return null;
            }
            boolean z2 = false;
            for (f.b bVar : bVarArr) {
                ByteBuffer byteBuffer = a4.get(bVar.a());
                if (byteBuffer != null) {
                    if (!a(c2, byteBuffer, bVar.b(), bVar.c(), bVar.d() ? 1 : 0)) {
                        c(c2);
                        return null;
                    }
                    z2 = true;
                }
            }
            if (!z2) {
                c(c2);
                return null;
            } else if (b(c2) && (a2 = a(c2)) != null) {
                return Typeface.create(a2, i2);
            } else {
                return null;
            }
        }
        throw th;
    }

    public Typeface a(Context context, c.b bVar, Resources resources, int i2) {
        if (!b()) {
            return super.a(context, bVar, resources, i2);
        }
        Object c2 = c();
        if (c2 == null) {
            return null;
        }
        for (c.C0214c cVar : bVar.a()) {
            if (!a(context, c2, cVar.a(), cVar.e(), cVar.b(), cVar.c() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(cVar.d()))) {
                c(c2);
                return null;
            }
        }
        if (!b(c2)) {
            return null;
        }
        return a(c2);
    }

    /* access modifiers changed from: protected */
    public Typeface a(Object obj) {
        try {
            Object newInstance = Array.newInstance(this.f31065a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.f31071g.invoke((Object) null, new Object[]{newInstance, -1, -1});
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Class<?> a() throws ClassNotFoundException {
        return Class.forName("android.graphics.FontFamily");
    }

    /* access modifiers changed from: protected */
    public Constructor<?> a(Class<?> cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }

    /* access modifiers changed from: protected */
    public Method b(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("addFontFromAssetManager", new Class[]{AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class});
    }

    /* access modifiers changed from: protected */
    public Method c(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("addFontFromBuffer", new Class[]{ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE});
    }

    /* access modifiers changed from: protected */
    public Method d(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("freeze", new Class[0]);
    }

    /* access modifiers changed from: protected */
    public Method e(Class<?> cls) throws NoSuchMethodException {
        return cls.getMethod("abortCreation", new Class[0]);
    }

    /* access modifiers changed from: protected */
    public Method f(Class<?> cls) throws NoSuchMethodException {
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass(), Integer.TYPE, Integer.TYPE});
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
