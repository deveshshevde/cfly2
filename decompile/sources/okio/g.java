package okio;

import java.io.IOException;

public abstract class g implements r {
    private final r delegate;

    public g(r rVar) {
        if (rVar != null) {
            this.delegate = rVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public final r delegate() {
        return this.delegate;
    }

    public long read(c cVar, long j2) throws IOException {
        return this.delegate.read(cVar, j2);
    }

    public s timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
    }
}
