package kotlin.jvm.internal;

import ms.b;
import ms.c;
import ms.d;
import ms.f;
import ms.h;

public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final k f30250a;

    /* renamed from: b  reason: collision with root package name */
    private static final b[] f30251b = new b[0];

    static {
        k kVar = null;
        try {
            kVar = (k) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (kVar == null) {
            kVar = new k();
        }
        f30250a = kVar;
    }

    public static String a(Lambda lambda) {
        return f30250a.a(lambda);
    }

    public static String a(g gVar) {
        return f30250a.a(gVar);
    }

    public static c a(Class cls) {
        return f30250a.a(cls, "");
    }

    public static d a(FunctionReference functionReference) {
        return f30250a.a(functionReference);
    }

    public static f a(MutablePropertyReference1 mutablePropertyReference1) {
        return f30250a.a(mutablePropertyReference1);
    }

    public static h a(PropertyReference1 propertyReference1) {
        return f30250a.a(propertyReference1);
    }

    public static b b(Class cls) {
        return f30250a.a(cls);
    }
}
