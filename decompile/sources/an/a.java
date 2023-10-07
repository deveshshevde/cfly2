package an;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.work.j;

public class a extends c<Boolean> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f252d = j.a("BatteryChrgTracker");

    public a(Context context, ap.a aVar) {
        super(context, aVar);
    }

    private boolean a(Intent intent) {
        if (Build.VERSION.SDK_INT >= 23) {
            int intExtra = intent.getIntExtra("status", -1);
            if (intExtra == 2 || intExtra == 5) {
                return true;
            }
        } else if (intent.getIntExtra("plugged", 0) != 0) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public Boolean c() {
        Intent registerReceiver = this.f259b.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return Boolean.valueOf(a(registerReceiver));
        }
        j.a().e(f252d, "getInitialState - null intent received", new Throwable[0]);
        return null;
    }

    public void a(Context context, Intent intent) {
        boolean z2;
        String action = intent.getAction();
        if (action != null) {
            j.a().b(f252d, String.format("Received %s", new Object[]{action}), new Throwable[0]);
            action.hashCode();
            char c2 = 65535;
            switch (action.hashCode()) {
                case -1886648615:
                    if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -54942926:
                    if (action.equals("android.os.action.DISCHARGING")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 948344062:
                    if (action.equals("android.os.action.CHARGING")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 1019184907:
                    if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                case 1:
                    z2 = false;
                    break;
                case 2:
                case 3:
                    z2 = true;
                    break;
                default:
                    return;
            }
            a(z2);
        }
    }

    public IntentFilter b() {
        String str;
        IntentFilter intentFilter = new IntentFilter();
        if (Build.VERSION.SDK_INT >= 23) {
            intentFilter.addAction("android.os.action.CHARGING");
            str = "android.os.action.DISCHARGING";
        } else {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            str = "android.intent.action.ACTION_POWER_DISCONNECTED";
        }
        intentFilter.addAction(str);
        return intentFilter;
    }
}
