package gi;

import android.content.Context;
import com.google.android.gms.common.util.l;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Context f28509a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f28510b;

    public static synchronized boolean a(Context context) {
        boolean z2;
        Boolean bool;
        synchronized (a.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = f28509a;
            if (!(context2 == null || (bool = f28510b) == null)) {
                if (context2 == applicationContext) {
                    boolean booleanValue = bool.booleanValue();
                    return booleanValue;
                }
            }
            f28510b = null;
            if (l.f()) {
                z2 = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
            } else {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    f28510b = true;
                } catch (ClassNotFoundException unused) {
                    z2 = false;
                }
                f28509a = applicationContext;
                boolean booleanValue2 = f28510b.booleanValue();
                return booleanValue2;
            }
            f28510b = z2;
            f28509a = applicationContext;
            boolean booleanValue22 = f28510b.booleanValue();
            return booleanValue22;
        }
    }
}
