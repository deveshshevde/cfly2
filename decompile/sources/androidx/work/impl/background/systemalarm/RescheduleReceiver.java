package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.work.j;

public class RescheduleReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5171a = j.a("RescheduleReceiver");

    public void onReceive(Context context, Intent intent) {
        j.a().b(f5171a, String.format("Received intent %s", new Object[]{intent}), new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                androidx.work.impl.j.b(context).a(goAsync());
            } catch (IllegalStateException e2) {
                j.a().e(f5171a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e2);
            }
        } else {
            context.startService(b.b(context));
        }
    }
}
