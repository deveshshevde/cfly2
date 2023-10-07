package okhttp3;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import nc.d;
import nc.e;

public final class c implements Closeable, Flushable {

    /* renamed from: a  reason: collision with root package name */
    final e f31870a;

    /* renamed from: b  reason: collision with root package name */
    final d f31871b;

    public void close() throws IOException {
        this.f31871b.close();
    }

    public void flush() throws IOException {
        this.f31871b.flush();
    }
}
