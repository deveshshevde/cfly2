package m;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import l.c;
import q.f;

class e extends j {

    /* renamed from: a  reason: collision with root package name */
    private static Class<?> f31056a = null;

    /* renamed from: b  reason: collision with root package name */
    private static Constructor<?> f31057b = null;

    /* renamed from: c  reason: collision with root package name */
    private static Method f31058c = null;

    /* renamed from: d  reason: collision with root package name */
    private static Method f31059d = null;

    /* renamed from: e  reason: collision with root package name */
    private static boolean f31060e = false;

    e() {
    }

    private static Typeface a(Object obj) {
        a();
        try {
            Object newInstance = Array.newInstance(f31056a, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) f31059d.invoke((Object) null, new Object[]{newInstance});
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private File a(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            String readlink = Os.readlink("/proc/self/fd/" + parcelFileDescriptor.getFd());
            if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                return new File(readlink);
            }
        } catch (ErrnoException unused) {
        }
        return null;
    }

    private static void a() {
        Method method;
        Class<?> cls;
        Method method2;
        if (!f31060e) {
            f31060e = true;
            Constructor<?> constructor = null;
            try {
                cls = Class.forName("android.graphics.FontFamily");
                Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
                method = cls.getMethod("addFontWeightStyle", new Class[]{String.class, Integer.TYPE, Boolean.TYPE});
                method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
                constructor = constructor2;
            } catch (ClassNotFoundException | NoSuchMethodException e2) {
                Log.e("TypefaceCompatApi21Impl", e2.getClass().getName(), e2);
                method2 = null;
                cls = null;
                method = null;
            }
            f31057b = constructor;
            f31056a = cls;
            f31058c = method;
            f31059d = method2;
        }
    }

    private static boolean a(Object obj, String str, int i2, boolean z2) {
        a();
        try {
            return ((Boolean) f31058c.invoke(obj, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z2)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static Object b() {
        a();
        try {
            return f31057b.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public Typeface a(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i2) {
        FileInputStream fileInputStream;
        if (bVarArr.length < 1) {
            return null;
        }
        f.b a2 = a(bVarArr, i2);
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(a2.a(), "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                File a3 = a(openFileDescriptor);
                if (a3 != null) {
                    if (a3.canRead()) {
                        Typeface createFromFile = Typeface.createFromFile(a3);
                        if (openFileDescriptor != null) {
                            openFileDescriptor.close();
                        }
                        return createFromFile;
                    }
                }
                fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                Typeface a4 = super.a(context, (InputStream) fileInputStream);
                fileInputStream.close();
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return a4;
            } catch (Throwable th) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                throw th;
            }
        } catch (IOException unused) {
            return null;
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public Typeface a(Context context, c.b bVar, Resources resources, int i2) {
        Object b2 = b();
        c.C0214c[] a2 = bVar.a();
        int length = a2.length;
        int i3 = 0;
        while (i3 < length) {
            c.C0214c cVar = a2[i3];
            File a3 = k.a(context);
            if (a3 == null) {
                return null;
            }
            try {
                if (!k.a(a3, resources, cVar.f())) {
                    a3.delete();
                    return null;
                } else if (!a(b2, a3.getPath(), cVar.b(), cVar.c())) {
                    return null;
                } else {
                    i3++;
                }
            } catch (RuntimeException unused) {
                return null;
            } finally {
                a3.delete();
            }
        }
        return a(b2);
    }
}
