package okio;

import java.io.IOException;

public abstract class f implements q {
    private final q delegate;

    public f(q qVar) {
        if (qVar != null) {
            this.delegate = qVar;
            return;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public final q delegate() {
        return this.delegate;
    }

    public void flush() throws IOException {
        this.delegate.flush();
    }

    public s timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
    }

    public void write(c cVar, long j2) throws IOException {
        this.delegate.write(cVar, j2);
    }
}
