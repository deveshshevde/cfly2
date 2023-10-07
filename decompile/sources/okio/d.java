package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;

public interface d extends WritableByteChannel, q {
    long a(r rVar) throws IOException;

    c b();

    d b(String str) throws IOException;

    d b(ByteString byteString) throws IOException;

    d c(byte[] bArr) throws IOException;

    d c(byte[] bArr, int i2, int i3) throws IOException;

    OutputStream d();

    void flush() throws IOException;

    d g(int i2) throws IOException;

    d h(int i2) throws IOException;

    d i(int i2) throws IOException;

    d k(long j2) throws IOException;

    d l(long j2) throws IOException;

    d v() throws IOException;
}
