package m;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import j.e;
import l.c;
import l.f;
import q.f;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final j f31053a = (Build.VERSION.SDK_INT >= 29 ? new i() : Build.VERSION.SDK_INT >= 28 ? new h() : Build.VERSION.SDK_INT >= 26 ? new g() : (Build.VERSION.SDK_INT < 24 || !f.a()) ? Build.VERSION.SDK_INT >= 21 ? new e() : new j() : new f());

    /* renamed from: b  reason: collision with root package name */
    private static final e<String, Typeface> f31054b = new e<>(16);

    public static class a extends f.c {

        /* renamed from: a  reason: collision with root package name */
        private f.c f31055a;

        public a(f.c cVar) {
            this.f31055a = cVar;
        }

        public void a(int i2) {
            f.c cVar = this.f31055a;
            if (cVar != null) {
                cVar.a(i2);
            }
        }

        public void a(Typeface typeface) {
            f.c cVar = this.f31055a;
            if (cVar != null) {
                cVar.a(typeface);
            }
        }
    }

    public static Typeface a(Context context, Resources resources, int i2, String str, int i3) {
        Typeface a2 = f31053a.a(context, resources, i2, str, i3);
        if (a2 != null) {
            f31054b.put(b(resources, i2, i3), a2);
        }
        return a2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r2 = b(r2, r3, r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface a(android.content.Context r2, android.graphics.Typeface r3, int r4) {
        /*
            if (r2 == 0) goto L_0x0014
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r0 >= r1) goto L_0x000f
            android.graphics.Typeface r2 = b((android.content.Context) r2, (android.graphics.Typeface) r3, (int) r4)
            if (r2 == 0) goto L_0x000f
            return r2
        L_0x000f:
            android.graphics.Typeface r2 = android.graphics.Typeface.create(r3, r4)
            return r2
        L_0x0014:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Context cannot be null"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: m.d.a(android.content.Context, android.graphics.Typeface, int):android.graphics.Typeface");
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, f.b[] bVarArr, int i2) {
        return f31053a.a(context, cancellationSignal, bVarArr, i2);
    }

    public static Typeface a(Context context, c.a aVar, Resources resources, int i2, int i3, f.c cVar, Handler handler, boolean z2) {
        Typeface typeface;
        c.a aVar2 = aVar;
        f.c cVar2 = cVar;
        Handler handler2 = handler;
        if (aVar2 instanceof c.d) {
            c.d dVar = (c.d) aVar2;
            Typeface a2 = a(dVar.d());
            if (a2 != null) {
                if (cVar2 != null) {
                    cVar2.a(a2, handler2);
                }
                return a2;
            }
            typeface = q.f.a(context, dVar.a(), i3, !z2 ? cVar2 == null : dVar.b() == 0, z2 ? dVar.c() : -1, f.c.a(handler), new a(cVar2));
            Resources resources2 = resources;
            int i4 = i3;
        } else {
            Context context2 = context;
            Resources resources3 = resources;
            typeface = f31053a.a(context, (c.b) aVar2, resources, i3);
            if (cVar2 != null) {
                if (typeface != null) {
                    cVar2.a(typeface, handler2);
                } else {
                    cVar2.a(-3, handler2);
                }
            }
        }
        if (typeface != null) {
            f31054b.put(b(resources, i2, i3), typeface);
        }
        return typeface;
    }

    public static Typeface a(Resources resources, int i2, int i3) {
        return f31054b.get(b(resources, i2, i3));
    }

    private static Typeface a(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface create = Typeface.create(str, 0);
        Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
        if (create == null || create.equals(create2)) {
            return null;
        }
        return create;
    }

    private static Typeface b(Context context, Typeface typeface, int i2) {
        j jVar = f31053a;
        c.b a2 = jVar.a(typeface);
        if (a2 == null) {
            return null;
        }
        return jVar.a(context, a2, context.getResources(), i2);
    }

    private static String b(Resources resources, int i2, int i3) {
        return resources.getResourcePackageName(i2) + "-" + i2 + "-" + i3;
    }
}
