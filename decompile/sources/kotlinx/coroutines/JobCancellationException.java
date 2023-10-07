package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.h;

public final class JobCancellationException extends CancellationException implements y<JobCancellationException> {

    /* renamed from: a  reason: collision with root package name */
    public final bg f30287a;

    public JobCancellationException(String str, Throwable th, bg bgVar) {
        super(str);
        this.f30287a = bgVar;
        if (th != null) {
            initCause(th);
        }
    }

    /* renamed from: b */
    public JobCancellationException a() {
        if (!ag.b()) {
            return null;
        }
        String message = getMessage();
        h.a((Object) message);
        bg bgVar = this.f30287a;
        h.a((Object) bgVar);
        return new JobCancellationException(message, this, bgVar);
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof JobCancellationException) {
                JobCancellationException jobCancellationException = (JobCancellationException) obj;
                if (!h.a((Object) jobCancellationException.getMessage(), (Object) getMessage()) || !h.a((Object) jobCancellationException.f30287a, (Object) this.f30287a) || !h.a((Object) jobCancellationException.getCause(), (Object) getCause())) {
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public Throwable fillInStackTrace() {
        if (ag.b()) {
            return super.fillInStackTrace();
        }
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        h.a((Object) message);
        int hashCode = message.hashCode() * 31;
        bg bgVar = this.f30287a;
        int i2 = 0;
        int hashCode2 = (hashCode + (bgVar != null ? bgVar.hashCode() : 0)) * 31;
        Throwable cause = getCause();
        if (cause != null) {
            i2 = cause.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return super.toString() + "; job=" + this.f30287a;
    }
}
