package an;

import android.content.Context;
import ap.a;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static g f272a;

    /* renamed from: b  reason: collision with root package name */
    private a f273b;

    /* renamed from: c  reason: collision with root package name */
    private b f274c;

    /* renamed from: d  reason: collision with root package name */
    private e f275d;

    /* renamed from: e  reason: collision with root package name */
    private f f276e;

    private g(Context context, a aVar) {
        Context applicationContext = context.getApplicationContext();
        this.f273b = new a(applicationContext, aVar);
        this.f274c = new b(applicationContext, aVar);
        this.f275d = new e(applicationContext, aVar);
        this.f276e = new f(applicationContext, aVar);
    }

    public static synchronized g a(Context context, a aVar) {
        g gVar;
        synchronized (g.class) {
            if (f272a == null) {
                f272a = new g(context, aVar);
            }
            gVar = f272a;
        }
        return gVar;
    }

    public a a() {
        return this.f273b;
    }

    public b b() {
        return this.f274c;
    }

    public e c() {
        return this.f275d;
    }

    public f d() {
        return this.f276e;
    }
}
