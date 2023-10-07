package okio;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public interface q extends Closeable, Flushable {
    void close() throws IOException;

    void flush() throws IOException;

    s timeout();

    void write(c cVar, long j2) throws IOException;
}
