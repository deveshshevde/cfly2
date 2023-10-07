package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.workers.DiagnosticsWorker;
import androidx.work.j;
import androidx.work.k;
import androidx.work.p;
import androidx.work.q;

public class DiagnosticsReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5241a = j.a("DiagnosticsRcvr");

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            j.a().b(f5241a, "Requesting diagnostics", new Throwable[0]);
            try {
                p.a(context).a((q) k.a(DiagnosticsWorker.class));
            } catch (IllegalStateException e2) {
                j.a().e(f5241a, "WorkManager is not initialized", e2);
            }
        }
    }
}
