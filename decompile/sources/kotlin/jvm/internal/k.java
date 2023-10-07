package kotlin.jvm.internal;

import ms.b;
import ms.c;
import ms.d;
import ms.f;
import ms.h;

public class k {
    public String a(Lambda lambda) {
        return a((g) lambda);
    }

    public String a(g gVar) {
        String obj = gVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }

    public b a(Class cls) {
        return new d(cls);
    }

    public c a(Class cls, String str) {
        return new i(cls, str);
    }

    public d a(FunctionReference functionReference) {
        return functionReference;
    }

    public f a(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    public h a(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }
}
