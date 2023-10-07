package gj;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.dynamite.DynamiteModule;

public class af {

    /* renamed from: a  reason: collision with root package name */
    private static final String f28514a = "af";

    /* renamed from: b  reason: collision with root package name */
    private static Context f28515b;

    /* renamed from: c  reason: collision with root package name */
    private static ag f28516c;

    /* JADX WARNING: type inference failed for: r1v4, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static gj.ag a(android.content.Context r3) throws com.google.android.gms.common.GooglePlayServicesNotAvailableException {
        /*
            com.google.android.gms.common.internal.m.a(r3)
            gj.ag r0 = f28516c
            if (r0 == 0) goto L_0x0008
            return r0
        L_0x0008:
            r0 = 13400000(0xcc77c0, float:1.87774E-38)
            int r0 = com.google.android.gms.common.e.a(r3, r0)
            if (r0 != 0) goto L_0x005d
            java.lang.String r0 = f28514a
            java.lang.String r1 = "Making Creator dynamically"
            android.util.Log.i(r0, r1)
            android.content.Context r0 = b(r3)
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.lang.String r1 = "com.google.android.gms.maps.internal.CreatorImpl"
            java.lang.Object r0 = a(r0, r1)
            android.os.IBinder r0 = (android.os.IBinder) r0
            if (r0 != 0) goto L_0x002c
            r0 = 0
            goto L_0x0040
        L_0x002c:
            java.lang.String r1 = "com.google.android.gms.maps.internal.ICreator"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof gj.ag
            if (r2 == 0) goto L_0x003a
            r0 = r1
            gj.ag r0 = (gj.ag) r0
            goto L_0x0040
        L_0x003a:
            gj.ah r1 = new gj.ah
            r1.<init>(r0)
            r0 = r1
        L_0x0040:
            f28516c = r0
            android.content.Context r3 = b(r3)     // Catch:{ RemoteException -> 0x0056 }
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ RemoteException -> 0x0056 }
            com.google.android.gms.dynamic.b r3 = com.google.android.gms.dynamic.d.a(r3)     // Catch:{ RemoteException -> 0x0056 }
            int r1 = com.google.android.gms.common.e.f17694a     // Catch:{ RemoteException -> 0x0056 }
            r0.a((com.google.android.gms.dynamic.b) r3, (int) r1)     // Catch:{ RemoteException -> 0x0056 }
            gj.ag r3 = f28516c
            return r3
        L_0x0056:
            r3 = move-exception
            com.google.android.gms.maps.model.RuntimeRemoteException r0 = new com.google.android.gms.maps.model.RuntimeRemoteException
            r0.<init>(r3)
            throw r0
        L_0x005d:
            com.google.android.gms.common.GooglePlayServicesNotAvailableException r3 = new com.google.android.gms.common.GooglePlayServicesNotAvailableException
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: gj.af.a(android.content.Context):gj.ag");
    }

    private static <T> T a(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException unused) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalStateException(valueOf.length() != 0 ? "Unable to instantiate the dynamic class ".concat(valueOf) : new String("Unable to instantiate the dynamic class "));
        } catch (IllegalAccessException unused2) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new IllegalStateException(valueOf2.length() != 0 ? "Unable to call the default constructor of ".concat(valueOf2) : new String("Unable to call the default constructor of "));
        }
    }

    private static <T> T a(ClassLoader classLoader, String str) {
        try {
            return a(((ClassLoader) m.a(classLoader)).loadClass(str));
        } catch (ClassNotFoundException unused) {
            String valueOf = String.valueOf(str);
            throw new IllegalStateException(valueOf.length() != 0 ? "Unable to find dynamic class ".concat(valueOf) : new String("Unable to find dynamic class "));
        }
    }

    private static Context b(Context context) {
        Context context2 = f28515b;
        if (context2 != null) {
            return context2;
        }
        Context c2 = c(context);
        f28515b = c2;
        return c2;
    }

    private static Context c(Context context) {
        try {
            return DynamiteModule.a(context, DynamiteModule.f18009a, "com.google.android.gms.maps_dynamite").a();
        } catch (Exception e2) {
            Log.e(f28514a, "Failed to load maps module, use legacy", e2);
            return e.b(context);
        }
    }
}
