package gz;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

public interface a<V> extends Future<V> {
    void a(Runnable runnable, Executor executor);
}
