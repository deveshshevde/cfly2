package bw;

import android.content.Context;
import android.util.Log;
import androidx.core.content.b;
import bw.c;

public class f implements d {
    public c a(Context context, c.a aVar) {
        boolean z2 = b.b(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", z2 ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        return z2 ? new e(context, aVar) : new n();
    }
}
