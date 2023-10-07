package kotlinx.coroutines.internal;

import kotlin.coroutines.f;
import kotlin.coroutines.jvm.internal.c;
import kotlinx.coroutines.a;
import kotlinx.coroutines.x;
import mm.b;

public class t<T> extends a<T> implements c {

    /* renamed from: c  reason: collision with root package name */
    public final kotlin.coroutines.c<T> f30435c;

    public t(f fVar, kotlin.coroutines.c<? super T> cVar) {
        super(fVar, true);
        this.f30435c = cVar;
    }

    /* access modifiers changed from: protected */
    public void c(Object obj) {
        kotlin.coroutines.c<T> cVar = this.f30435c;
        cVar.resumeWith(x.a(obj, cVar));
    }

    /* access modifiers changed from: protected */
    public void d(Object obj) {
        kotlin.coroutines.c<T> cVar = this.f30435c;
        f.a(kotlin.coroutines.intrinsics.a.a(cVar), x.a(obj, cVar), (b) null, 2, (Object) null);
    }

    public final c getCallerFrame() {
        kotlin.coroutines.c<T> cVar = this.f30435c;
        if (!(cVar instanceof c)) {
            cVar = null;
        }
        return (c) cVar;
    }

    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean o() {
        return true;
    }
}
