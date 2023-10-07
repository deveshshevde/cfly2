package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.jvm.internal.h;

final class g {

    /* renamed from: a  reason: collision with root package name */
    public static a f30214a;

    /* renamed from: b  reason: collision with root package name */
    public static final g f30215b = new g();

    /* renamed from: c  reason: collision with root package name */
    private static final a f30216c = new a((Method) null, (Method) null, (Method) null);

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Method f30217a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f30218b;

        /* renamed from: c  reason: collision with root package name */
        public final Method f30219c;

        public a(Method method, Method method2, Method method3) {
            this.f30217a = method;
            this.f30218b = method2;
            this.f30219c = method3;
        }
    }

    private g() {
    }

    private final a b(BaseContinuationImpl baseContinuationImpl) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f30214a = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = f30216c;
            f30214a = aVar2;
            return aVar2;
        }
    }

    public final String a(BaseContinuationImpl baseContinuationImpl) {
        Method method;
        Object invoke;
        Method method2;
        Object invoke2;
        h.d(baseContinuationImpl, "continuation");
        a aVar = f30214a;
        if (aVar == null) {
            aVar = b(baseContinuationImpl);
        }
        Object obj = null;
        if (aVar == f30216c || (method = aVar.f30217a) == null || (invoke = method.invoke(baseContinuationImpl.getClass(), new Object[0])) == null || (method2 = aVar.f30218b) == null || (invoke2 = method2.invoke(invoke, new Object[0])) == null) {
            return null;
        }
        Method method3 = aVar.f30219c;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
        if (invoke3 instanceof String) {
            obj = invoke3;
        }
        return (String) obj;
    }
}
