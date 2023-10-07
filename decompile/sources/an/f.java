package an;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.j;
import ap.a;

public class f extends c<Boolean> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f271d = j.a("StorageNotLowTracker");

    public f(Context context, a aVar) {
        super(context, aVar);
    }

    /* renamed from: a */
    public Boolean c() {
        Intent registerReceiver = this.f259b.registerReceiver((BroadcastReceiver) null, b());
        if (registerReceiver == null || registerReceiver.getAction() == null) {
            return true;
        }
        String action = registerReceiver.getAction();
        action.hashCode();
        if (!action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            return !action.equals("android.intent.action.DEVICE_STORAGE_OK") ? null : true;
        }
        return false;
    }

    public void a(Context context, Intent intent) {
        boolean z2;
        if (intent.getAction() != null) {
            j.a().b(f271d, String.format("Received %s", new Object[]{intent.getAction()}), new Throwable[0]);
            String action = intent.getAction();
            action.hashCode();
            if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
                z2 = false;
            } else if (action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                z2 = true;
            } else {
                return;
            }
            a(z2);
        }
    }

    public IntentFilter b() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        return intentFilter;
    }
}
