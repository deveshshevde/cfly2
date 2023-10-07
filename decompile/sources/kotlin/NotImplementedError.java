package kotlin;

import kotlin.jvm.internal.h;

public final class NotImplementedError extends Error {
    public NotImplementedError() {
        this((String) null, 1, (f) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotImplementedError(String str) {
        super(str);
        h.d(str, "message");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NotImplementedError(String str, int i2, f fVar) {
        this((i2 & 1) != 0 ? "An operation is not implemented." : str);
    }
}
