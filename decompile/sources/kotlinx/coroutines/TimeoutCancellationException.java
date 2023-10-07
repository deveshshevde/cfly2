package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

public final class TimeoutCancellationException extends CancellationException implements y<TimeoutCancellationException> {

    /* renamed from: a  reason: collision with root package name */
    public final Object f30288a;

    public TimeoutCancellationException(String str, Object obj) {
        super(str);
        this.f30288a = obj;
    }

    /* renamed from: b */
    public TimeoutCancellationException a() {
        String message = getMessage();
        if (message == null) {
            message = "";
        }
        TimeoutCancellationException timeoutCancellationException = new TimeoutCancellationException(message, this.f30288a);
        timeoutCancellationException.initCause(this);
        return timeoutCancellationException;
    }
}
