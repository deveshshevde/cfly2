package kw;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class b {
    public static boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
