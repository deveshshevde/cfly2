package gh;

import android.os.Process;

final class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f28508a;

    public c(Runnable runnable, int i2) {
        this.f28508a = runnable;
    }

    public final void run() {
        Process.setThreadPriority(0);
        this.f28508a.run();
    }
}
