package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import kotlin.Result;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import mm.b;

public final class ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4 extends Lambda implements b<Throwable, Throwable> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Constructor f30376a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4(Constructor constructor) {
        super(1);
        this.f30376a = constructor;
    }

    /* renamed from: a */
    public final Throwable invoke(Throwable th) {
        Object obj;
        try {
            Result.a aVar = Result.f30171a;
            Object newInstance = this.f30376a.newInstance(new Object[0]);
            if (newInstance != null) {
                Throwable th2 = (Throwable) newInstance;
                th2.initCause(th);
                obj = Result.e(th2);
                if (Result.b(obj)) {
                    obj = null;
                }
                return (Throwable) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
        } catch (Throwable th3) {
            Result.a aVar2 = Result.f30171a;
            obj = Result.e(i.a(th3));
        }
    }
}
