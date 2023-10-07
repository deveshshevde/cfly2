package bw;

import android.app.Activity;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

final class i implements ComponentCallbacks2, k {
    i() {
    }

    public void a(Activity activity) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
        onTrimMemory(20);
    }

    public void onTrimMemory(int i2) {
    }
}
