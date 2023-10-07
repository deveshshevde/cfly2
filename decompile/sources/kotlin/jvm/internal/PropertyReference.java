package kotlin.jvm.internal;

import ms.a;
import ms.g;

public abstract class PropertyReference extends CallableReference implements g {
    public PropertyReference() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PropertyReference(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            return a().equals(propertyReference.a()) && b().equals(propertyReference.b()) && c().equals(propertyReference.c()) && h.a(f(), propertyReference.f());
        } else if (obj instanceof g) {
            return obj.equals(g());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((a().hashCode() * 31) + b().hashCode()) * 31) + c().hashCode();
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public g h() {
        return (g) super.h();
    }

    public String toString() {
        a g2 = g();
        if (g2 != this) {
            return g2.toString();
        }
        return "property " + b() + " (Kotlin reflection is not available)";
    }
}
