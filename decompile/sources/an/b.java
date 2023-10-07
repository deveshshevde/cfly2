package an;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.j;
import ap.a;

public class b extends c<Boolean> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f253d = j.a("BatteryNotLowTracker");

    public b(Context context, a aVar) {
        super(context, aVar);
    }

    /* renamed from: a */
    public Boolean c() {
        Intent registerReceiver = this.f259b.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z2 = false;
        if (registerReceiver == null) {
            j.a().e(f253d, "getInitialState - null intent received", new Throwable[0]);
            return null;
        }
        int intExtra = registerReceiver.getIntExtra("status", -1);
        float intExtra2 = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
        if (intExtra == 1 || intExtra2 > 0.15f) {
            z2 = true;
        }
        return Boolean.valueOf(z2);
    }

    public void a(Context context, Intent intent) {
        boolean z2;
        if (intent.getAction() != null) {
            j.a().b(f253d, String.format("Received %s", new Object[]{intent.getAction()}), new Throwable[0]);
            String action = intent.getAction();
            action.hashCode();
            if (action.equals("android.intent.action.BATTERY_OKAY")) {
                z2 = true;
            } else if (action.equals("android.intent.action.BATTERY_LOW")) {
                z2 = false;
            } else {
                return;
            }
            a(z2);
        }
    }

    public IntentFilter b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        return intentFilter;
    }
}
