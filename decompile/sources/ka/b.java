package ka;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public class b implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f29957a = new Handler(Looper.getMainLooper());

    public void execute(Runnable runnable) {
        this.f29957a.post(runnable);
    }
}
