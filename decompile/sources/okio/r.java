package okio;

import java.io.Closeable;
import java.io.IOException;

public interface r extends Closeable {
    void close() throws IOException;

    long read(c cVar, long j2) throws IOException;

    s timeout();
}
