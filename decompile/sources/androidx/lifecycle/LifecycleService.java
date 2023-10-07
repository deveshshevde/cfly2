package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class LifecycleService extends Service implements n {

    /* renamed from: a  reason: collision with root package name */
    private final z f3568a = new z(this);

    public Lifecycle getLifecycle() {
        return this.f3568a.e();
    }

    public IBinder onBind(Intent intent) {
        this.f3568a.b();
        return null;
    }

    public void onCreate() {
        this.f3568a.a();
        super.onCreate();
    }

    public void onDestroy() {
        this.f3568a.d();
        super.onDestroy();
    }

    public void onStart(Intent intent, int i2) {
        this.f3568a.c();
        super.onStart(intent, i2);
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        return super.onStartCommand(intent, i2, i3);
    }
}
