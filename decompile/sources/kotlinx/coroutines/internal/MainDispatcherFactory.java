package kotlinx.coroutines.internal;

import java.util.List;
import kotlinx.coroutines.bp;

public interface MainDispatcherFactory {
    bp createDispatcher(List<? extends MainDispatcherFactory> list);

    int getLoadPriority();

    String hintOnError();
}
