package an;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import androidx.work.j;

public class e extends d<al.b> {

    /* renamed from: d  reason: collision with root package name */
    static final String f265d = j.a("NetworkStateTracker");

    /* renamed from: e  reason: collision with root package name */
    private final ConnectivityManager f266e = ((ConnectivityManager) this.f259b.getSystemService("connectivity"));

    /* renamed from: f  reason: collision with root package name */
    private b f267f;

    /* renamed from: g  reason: collision with root package name */
    private a f268g;

    private class a extends BroadcastReceiver {
        a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent != null && intent.getAction() != null && intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                j.a().b(e.f265d, "Network broadcast received", new Throwable[0]);
                e eVar = e.this;
                eVar.a(eVar.b());
            }
        }
    }

    private class b extends ConnectivityManager.NetworkCallback {
        b() {
        }

        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            j.a().b(e.f265d, String.format("Network capabilities changed: %s", new Object[]{networkCapabilities}), new Throwable[0]);
            e eVar = e.this;
            eVar.a(eVar.b());
        }

        public void onLost(Network network) {
            j.a().b(e.f265d, "Network connection lost", new Throwable[0]);
            e eVar = e.this;
            eVar.a(eVar.b());
        }
    }

    public e(Context context, ap.a aVar) {
        super(context, aVar);
        if (g()) {
            this.f267f = new b();
        } else {
            this.f268g = new a();
        }
    }

    private static boolean g() {
        return Build.VERSION.SDK_INT >= 24;
    }

    /* renamed from: a */
    public al.b c() {
        return b();
    }

    /* access modifiers changed from: package-private */
    public al.b b() {
        NetworkInfo activeNetworkInfo = this.f266e.getActiveNetworkInfo();
        boolean z2 = true;
        boolean z3 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        boolean f2 = f();
        boolean a2 = p.a.a(this.f266e);
        if (activeNetworkInfo == null || activeNetworkInfo.isRoaming()) {
            z2 = false;
        }
        return new al.b(z3, f2, a2, z2);
    }

    public void d() {
        if (g()) {
            try {
                j.a().b(f265d, "Registering network callback", new Throwable[0]);
                this.f266e.registerDefaultNetworkCallback(this.f267f);
            } catch (IllegalArgumentException | SecurityException e2) {
                j.a().e(f265d, "Received exception while registering network callback", e2);
            }
        } else {
            j.a().b(f265d, "Registering broadcast receiver", new Throwable[0]);
            this.f259b.registerReceiver(this.f268g, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    public void e() {
        if (g()) {
            try {
                j.a().b(f265d, "Unregistering network callback", new Throwable[0]);
                this.f266e.unregisterNetworkCallback(this.f267f);
            } catch (IllegalArgumentException | SecurityException e2) {
                j.a().e(f265d, "Received exception while unregistering network callback", e2);
            }
        } else {
            j.a().b(f265d, "Unregistering broadcast receiver", new Throwable[0]);
            this.f259b.unregisterReceiver(this.f268g);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        try {
            NetworkCapabilities networkCapabilities = this.f266e.getNetworkCapabilities(this.f266e.getActiveNetwork());
            return networkCapabilities != null && networkCapabilities.hasCapability(16);
        } catch (SecurityException e2) {
            j.a().e(f265d, "Unable to validate active network", e2);
            return false;
        }
    }
}
