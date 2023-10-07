package kotlin.jvm.internal;

import ms.a;
import ms.d;

public class FunctionReference extends CallableReference implements g, d {

    /* renamed from: c  reason: collision with root package name */
    private final int f30234c;

    /* renamed from: d  reason: collision with root package name */
    private final int f30235d;

    public FunctionReference(int i2, Object obj) {
        this(i2, obj, (Class) null, (String) null, (String) null, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FunctionReference(int i2, Object obj, Class cls, String str, String str2, int i3) {
        super(obj, cls, str, str2, (i3 & 1) == 1);
        this.f30234c = i2;
        this.f30235d = i3 >> 1;
    }

    /* access modifiers changed from: protected */
    public a e() {
        return j.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference functionReference = (FunctionReference) obj;
            return h.a((Object) a(), (Object) functionReference.a()) && b().equals(functionReference.b()) && c().equals(functionReference.c()) && this.f30235d == functionReference.f30235d && this.f30234c == functionReference.f30234c && h.a(f(), functionReference.f());
        } else if (obj instanceof d) {
            return obj.equals(g());
        } else {
            return false;
        }
    }

    public int getArity() {
        return this.f30234c;
    }

    public int hashCode() {
        return (((a() == null ? 0 : a().hashCode() * 31) + b().hashCode()) * 31) + c().hashCode();
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public d h() {
        return (d) super.h();
    }

    public String toString() {
        a g2 = g();
        if (g2 != this) {
            return g2.toString();
        }
        if ("<init>".equals(b())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + b() + " (Kotlin reflection is not available)";
    }
}
