package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.a;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;

public abstract class BaseContinuationImpl implements Serializable, c<Object>, c {
    private final c<Object> completion;

    public BaseContinuationImpl(c<Object> cVar) {
        this.completion = cVar;
    }

    public c<l> create(Object obj, c<?> cVar) {
        h.d(cVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public c<l> create(c<?> cVar) {
        h.d(cVar, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public c getCallerFrame() {
        c<Object> cVar = this.completion;
        if (!(cVar instanceof c)) {
            cVar = null;
        }
        return (c) cVar;
    }

    public final c<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return e.a(this);
    }

    /* access modifiers changed from: protected */
    public abstract Object invokeSuspend(Object obj);

    /* access modifiers changed from: protected */
    public void releaseIntercepted() {
    }

    public final void resumeWith(Object obj) {
        c cVar = this;
        while (true) {
            BaseContinuationImpl baseContinuationImpl = (BaseContinuationImpl) cVar;
            f.b(baseContinuationImpl);
            c cVar2 = baseContinuationImpl.completion;
            h.a((Object) cVar2);
            try {
                Object invokeSuspend = baseContinuationImpl.invokeSuspend(obj);
                if (invokeSuspend != a.a()) {
                    Result.a aVar = Result.f30171a;
                    obj = Result.e(invokeSuspend);
                    baseContinuationImpl.releaseIntercepted();
                    if (cVar2 instanceof BaseContinuationImpl) {
                        cVar = cVar2;
                    } else {
                        cVar2.resumeWith(obj);
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th) {
                Result.a aVar2 = Result.f30171a;
                obj = Result.e(i.a(th));
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Serializable stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }
}
