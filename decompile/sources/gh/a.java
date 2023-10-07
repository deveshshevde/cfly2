package gh;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.common.zzi;
import java.util.concurrent.Executor;

public class a implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f28504a;

    public a(Looper looper) {
        this.f28504a = new zzi(looper);
    }

    public final void execute(Runnable runnable) {
        this.f28504a.post(runnable);
    }
}
