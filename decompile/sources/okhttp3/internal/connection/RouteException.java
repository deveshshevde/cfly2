package okhttp3.internal.connection;

import java.io.IOException;
import nb.c;

public final class RouteException extends RuntimeException {

    /* renamed from: a  reason: collision with root package name */
    private IOException f31973a;

    /* renamed from: b  reason: collision with root package name */
    private IOException f31974b;

    RouteException(IOException iOException) {
        super(iOException);
        this.f31973a = iOException;
        this.f31974b = iOException;
    }

    public IOException a() {
        return this.f31973a;
    }

    /* access modifiers changed from: package-private */
    public void a(IOException iOException) {
        c.a((Throwable) this.f31973a, (Throwable) iOException);
        this.f31974b = iOException;
    }

    public IOException b() {
        return this.f31974b;
    }
}
