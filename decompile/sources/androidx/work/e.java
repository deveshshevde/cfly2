package androidx.work;

import android.app.Notification;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final int f5150a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5151b;

    /* renamed from: c  reason: collision with root package name */
    private final Notification f5152c;

    public e(int i2, Notification notification, int i3) {
        this.f5150a = i2;
        this.f5152c = notification;
        this.f5151b = i3;
    }

    public int a() {
        return this.f5150a;
    }

    public int b() {
        return this.f5151b;
    }

    public Notification c() {
        return this.f5152c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.f5150a == eVar.f5150a && this.f5151b == eVar.f5151b) {
            return this.f5152c.equals(eVar.f5152c);
        }
        return false;
    }

    public int hashCode() {
        return (((this.f5150a * 31) + this.f5151b) * 31) + this.f5152c.hashCode();
    }

    public String toString() {
        return "ForegroundInfo{" + "mNotificationId=" + this.f5150a + ", mForegroundServiceType=" + this.f5151b + ", mNotification=" + this.f5152c + '}';
    }
}
