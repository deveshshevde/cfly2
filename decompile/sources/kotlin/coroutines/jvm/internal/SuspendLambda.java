package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.c;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;

public abstract class SuspendLambda extends ContinuationImpl implements g<Object> {

    /* renamed from: a  reason: collision with root package name */
    private final int f30212a;

    public SuspendLambda(int i2, c<Object> cVar) {
        super(cVar);
        this.f30212a = i2;
    }

    public int getArity() {
        return this.f30212a;
    }

    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        String a2 = j.a((g) this);
        h.b(a2, "Reflection.renderLambdaToString(this)");
        return a2;
    }
}
