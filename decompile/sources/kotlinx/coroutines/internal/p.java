package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlinx.coroutines.bp;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f30431a = true;

    public static final Void a() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    public static final bp a(MainDispatcherFactory mainDispatcherFactory, List<? extends MainDispatcherFactory> list) {
        try {
            return mainDispatcherFactory.createDispatcher(list);
        } catch (Throwable th) {
            return a(th, mainDispatcherFactory.hintOnError());
        }
    }

    private static final q a(Throwable th, String str) {
        if (f30431a) {
            return new q(th, str);
        }
        if (th != null) {
            throw th;
        }
        a();
        throw new KotlinNothingValueException();
    }

    static /* synthetic */ q a(Throwable th, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            th = null;
        }
        if ((i2 & 2) != 0) {
            str = null;
        }
        return a(th, str);
    }
}
