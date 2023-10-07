package androidx.core.os;

import s.c;

public class OperationCanceledException extends RuntimeException {
    public OperationCanceledException() {
        this((String) null);
    }

    public OperationCanceledException(String str) {
        super(c.a((Object) str, "The operation has been canceled."));
    }
}
