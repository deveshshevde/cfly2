package ka;

import android.os.Process;
import java.util.concurrent.ThreadFactory;

public class c implements ThreadFactory {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final int f29958a;

    public c(int i2) {
        this.f29958a = i2;
    }

    public Thread newThread(final Runnable runnable) {
        return new Thread(new Runnable() {
            public void run() {
                try {
                    Process.setThreadPriority(c.this.f29958a);
                } catch (Throwable unused) {
                }
                runnable.run();
            }
        });
    }
}
