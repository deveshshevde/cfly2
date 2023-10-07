package gi;

import android.content.Context;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f28512a = new c();

    /* renamed from: b  reason: collision with root package name */
    private b f28513b = null;

    public static b a(Context context) {
        return f28512a.b(context);
    }

    public final synchronized b b(Context context) {
        if (this.f28513b == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f28513b = new b(context);
        }
        return this.f28513b;
    }
}
