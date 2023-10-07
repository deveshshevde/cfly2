package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import ms.a;
import ms.c;

public abstract class CallableReference implements Serializable, a {

    /* renamed from: b  reason: collision with root package name */
    public static final Object f30226b = NoReceiver.f30233a;

    /* renamed from: a  reason: collision with root package name */
    protected final Object f30227a;

    /* renamed from: c  reason: collision with root package name */
    private transient a f30228c;

    /* renamed from: d  reason: collision with root package name */
    private final Class f30229d;

    /* renamed from: e  reason: collision with root package name */
    private final String f30230e;

    /* renamed from: f  reason: collision with root package name */
    private final String f30231f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f30232g;

    private static class NoReceiver implements Serializable {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final NoReceiver f30233a = new NoReceiver();

        private NoReceiver() {
        }
    }

    public CallableReference() {
        this(f30226b);
    }

    protected CallableReference(Object obj) {
        this(obj, (Class) null, (String) null, (String) null, false);
    }

    protected CallableReference(Object obj, Class cls, String str, String str2, boolean z2) {
        this.f30227a = obj;
        this.f30229d = cls;
        this.f30230e = str;
        this.f30231f = str2;
        this.f30232g = z2;
    }

    public Object a(Object... objArr) {
        return h().a(objArr);
    }

    public c a() {
        Class cls = this.f30229d;
        if (cls == null) {
            return null;
        }
        return this.f30232g ? j.a(cls) : j.b(cls);
    }

    public String b() {
        return this.f30230e;
    }

    public String c() {
        return this.f30231f;
    }

    /* access modifiers changed from: protected */
    public abstract a e();

    public Object f() {
        return this.f30227a;
    }

    public a g() {
        a aVar = this.f30228c;
        if (aVar != null) {
            return aVar;
        }
        a e2 = e();
        this.f30228c = e2;
        return e2;
    }

    /* access modifiers changed from: protected */
    public a h() {
        a g2 = g();
        if (g2 != this) {
            return g2;
        }
        throw new KotlinReflectionNotSupportedError();
    }
}
