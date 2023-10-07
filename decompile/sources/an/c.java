package an;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.j;
import ap.a;

public abstract class c<T> extends d<T> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f254d = j.a("BrdcstRcvrCnstrntTrckr");

    /* renamed from: e  reason: collision with root package name */
    private final BroadcastReceiver f255e = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                c.this.a(context, intent);
            }
        }
    };

    public c(Context context, a aVar) {
        super(context, aVar);
    }

    public abstract void a(Context context, Intent intent);

    public abstract IntentFilter b();

    public void d() {
        j.a().b(f254d, String.format("%s: registering receiver", new Object[]{getClass().getSimpleName()}), new Throwable[0]);
        this.f259b.registerReceiver(this.f255e, b());
    }

    public void e() {
        j.a().b(f254d, String.format("%s: unregistering receiver", new Object[]{getClass().getSimpleName()}), new Throwable[0]);
        this.f259b.unregisterReceiver(this.f255e);
    }
}
