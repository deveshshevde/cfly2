package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

class j {

    /* renamed from: a  reason: collision with root package name */
    private static AtomicBoolean f3621a = new AtomicBoolean(false);

    static class a extends d {
        a() {
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
            w.a(activity);
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    static void a(Context context) {
        if (!f3621a.getAndSet(true)) {
            ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new a());
        }
    }
}
