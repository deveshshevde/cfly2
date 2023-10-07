package io.reactivex.disposables;

import io.reactivex.internal.disposables.EmptyDisposable;
import lw.b;

public final class c {
    public static b a() {
        return EmptyDisposable.INSTANCE;
    }

    public static b a(Runnable runnable) {
        b.a(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }
}
