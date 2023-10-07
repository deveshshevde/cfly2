package m;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import l.c;
import q.f;

class j {

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<Long, c.b> f31072a = new ConcurrentHashMap<>();

    private interface a<T> {
        boolean a(T t2);

        int b(T t2);
    }

    j() {
    }

    private static <T> T a(T[] tArr, int i2, a<T> aVar) {
        int i3 = (i2 & 1) == 0 ? 400 : 700;
        boolean z2 = (i2 & 2) != 0;
        T t2 = null;
        int i4 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        for (T t3 : tArr) {
            int abs = (Math.abs(aVar.b(t3) - i3) * 2) + (aVar.a(t3) == z2 ? 0 : 1);
            if (t2 == null || i4 > abs) {
                t2 = t3;
                i4 = abs;
            }
        }
        return t2;
    }

    private c.C0214c a(c.b bVar, int i2) {
        return (c.C0214c) a(bVar.a(), i2, new a<c.C0214c>() {
            /* renamed from: a */
            public int b(c.C0214c cVar) {
                return cVar.b();
            }

            /* renamed from: b */
            public boolean a(c.C0214c cVar) {
                return cVar.c();
            }
        });
    }

    private void a(Typeface typeface, c.b bVar) {
        long b2 = b(typeface);
        if (b2 != 0) {
            this.f31072a.put(Long.valueOf(b2), bVar);
        }
    }

    private static long b(Typeface typeface) {
        if (typeface == null) {
            return 0;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (NoSuchFieldException e2) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e2);
            return 0;
        } catch (IllegalAccessException e3) {
            Log.e("TypefaceCompatBaseImpl", "Could not retrieve font from family.", e3);
            return 0;
        }
    }

    public Typeface a(Context context, Resources resources, int i2, String str, int i3) {
        File a2 = k.a(context);
        if (a2 == null) {
            return null;
        }
        try {
            if (!k.a(a2, resources, i2)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(a2.getPath());
            a2.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a2.delete();
        }
    }

    public Typeface a(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i2) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (bVarArr.length < 1) {
            return null;
        }
        try {
            inputStream = context.getContentResolver().openInputStream(a(bVarArr, i2).a());
            try {
                Typeface a2 = a(context, inputStream);
                k.a((Closeable) inputStream);
                return a2;
            } catch (IOException unused) {
                k.a((Closeable) inputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                k.a((Closeable) inputStream2);
                throw th;
            }
        } catch (IOException unused2) {
            inputStream = null;
            k.a((Closeable) inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            k.a((Closeable) inputStream2);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public Typeface a(Context context, InputStream inputStream) {
        File a2 = k.a(context);
        if (a2 == null) {
            return null;
        }
        try {
            if (!k.a(a2, inputStream)) {
                return null;
            }
            Typeface createFromFile = Typeface.createFromFile(a2.getPath());
            a2.delete();
            return createFromFile;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a2.delete();
        }
    }

    public Typeface a(Context context, c.b bVar, Resources resources, int i2) {
        c.C0214c a2 = a(bVar, i2);
        if (a2 == null) {
            return null;
        }
        Typeface a3 = d.a(context, resources, a2.f(), a2.a(), i2);
        a(a3, bVar);
        return a3;
    }

    /* access modifiers changed from: package-private */
    public c.b a(Typeface typeface) {
        long b2 = b(typeface);
        if (b2 == 0) {
            return null;
        }
        return this.f31072a.get(Long.valueOf(b2));
    }

    /* access modifiers changed from: protected */
    public f.b a(f.b[] bVarArr, int i2) {
        return (f.b) a(bVarArr, i2, new a<f.b>() {
            /* renamed from: a */
            public int b(f.b bVar) {
                return bVar.c();
            }

            /* renamed from: b */
            public boolean a(f.b bVar) {
                return bVar.d();
            }
        });
    }
}
