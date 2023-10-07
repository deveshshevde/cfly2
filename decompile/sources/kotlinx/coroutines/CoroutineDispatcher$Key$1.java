package kotlinx.coroutines;

import kotlin.coroutines.f;
import kotlin.jvm.internal.Lambda;
import mm.b;

final class CoroutineDispatcher$Key$1 extends Lambda implements b<f.b, aa> {

    /* renamed from: a  reason: collision with root package name */
    public static final CoroutineDispatcher$Key$1 f30278a = new CoroutineDispatcher$Key$1();

    CoroutineDispatcher$Key$1() {
        super(1);
    }

    /* renamed from: a */
    public final aa invoke(f.b bVar) {
        if (!(bVar instanceof aa)) {
            bVar = null;
        }
        return (aa) bVar;
    }
}
