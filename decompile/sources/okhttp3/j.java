package okhttp3;

import java.util.concurrent.TimeUnit;
import okhttp3.internal.connection.f;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    final f f32250a;

    public j() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public j(int i2, long j2, TimeUnit timeUnit) {
        this.f32250a = new f(i2, j2, timeUnit);
    }
}
