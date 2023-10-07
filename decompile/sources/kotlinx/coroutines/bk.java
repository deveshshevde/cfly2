package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.coroutines.f;

final /* synthetic */ class bk {
    public static final void a(f fVar, CancellationException cancellationException) {
        bg bgVar = (bg) fVar.get(bg.f30343b);
        if (bgVar != null) {
            bgVar.a(cancellationException);
        }
    }

    public static /* synthetic */ void a(f fVar, CancellationException cancellationException, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cancellationException = null;
        }
        bj.a(fVar, cancellationException);
    }
}
