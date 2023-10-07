package okio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

public interface e extends ReadableByteChannel, r {
    int a(l lVar) throws IOException;

    long a(byte b2) throws IOException;

    long a(q qVar) throws IOException;

    String a(Charset charset) throws IOException;

    void a(long j2) throws IOException;

    void a(byte[] bArr) throws IOException;

    @Deprecated
    c b();

    ByteString c(long j2) throws IOException;

    c c();

    String e(long j2) throws IOException;

    boolean f() throws IOException;

    InputStream g();

    byte[] g(long j2) throws IOException;

    void h(long j2) throws IOException;

    byte i() throws IOException;

    short j() throws IOException;

    int k() throws IOException;

    short l() throws IOException;

    int m() throws IOException;

    long n() throws IOException;

    String q() throws IOException;

    byte[] r() throws IOException;
}
