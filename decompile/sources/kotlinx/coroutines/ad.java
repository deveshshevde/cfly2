package kotlinx.coroutines;

import java.util.Objects;
import kotlin.coroutines.f;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlinx.coroutines.bx;
import mm.m;

public final class ad extends kotlin.coroutines.a implements bx<String> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f30293a = new a((f) null);

    /* renamed from: b  reason: collision with root package name */
    private final long f30294b;

    public static final class a implements f.c<ad> {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public ad(long j2) {
        super(f30293a);
        this.f30294b = j2;
    }

    public final long a() {
        return this.f30294b;
    }

    /* renamed from: a */
    public String b(f fVar) {
        String str;
        ae aeVar = (ae) fVar.get(ae.f30295a);
        if (aeVar == null || (str = aeVar.a()) == null) {
            str = "coroutine";
        }
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        int b2 = kotlin.text.f.b((CharSequence) name, " @", 0, false, 6, (Object) null);
        if (b2 < 0) {
            b2 = name.length();
        }
        StringBuilder sb = new StringBuilder(str.length() + b2 + 10);
        Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
        String substring = name.substring(0, b2);
        h.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        sb.append(substring);
        sb.append(" @");
        sb.append(str);
        sb.append('#');
        sb.append(this.f30294b);
        l lVar = l.f30254a;
        String sb2 = sb.toString();
        h.b(sb2, "StringBuilder(capacity).…builderAction).toString()");
        currentThread.setName(sb2);
        return name;
    }

    public void a(f fVar, String str) {
        Thread.currentThread().setName(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ad) && this.f30294b == ((ad) obj).f30294b;
        }
        return true;
    }

    public <R> R fold(R r2, m<? super R, ? super f.b, ? extends R> mVar) {
        return bx.a.a(this, r2, mVar);
    }

    public <E extends f.b> E get(f.c<E> cVar) {
        return bx.a.a(this, cVar);
    }

    public int hashCode() {
        long j2 = this.f30294b;
        return (int) (j2 ^ (j2 >>> 32));
    }

    public f minusKey(f.c<?> cVar) {
        return bx.a.b(this, cVar);
    }

    public f plus(f fVar) {
        return bx.a.a(this, fVar);
    }

    public String toString() {
        return "CoroutineId(" + this.f30294b + ')';
    }
}
