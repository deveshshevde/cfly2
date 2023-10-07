package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Logger;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    static final Logger f32449a = Logger.getLogger(k.class.getName());

    private k() {
    }

    public static d a(q qVar) {
        return new m(qVar);
    }

    public static e a(r rVar) {
        return new n(rVar);
    }

    public static q a(OutputStream outputStream) {
        return a(outputStream, new s());
    }

    private static q a(final OutputStream outputStream, final s sVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        } else if (sVar != null) {
            return new q() {
                public void close() throws IOException {
                    outputStream.close();
                }

                public void flush() throws IOException {
                    outputStream.flush();
                }

                public s timeout() {
                    return s.this;
                }

                public String toString() {
                    return "sink(" + outputStream + ")";
                }

                public void write(c cVar, long j2) throws IOException {
                    t.a(cVar.f32436b, 0, j2);
                    while (j2 > 0) {
                        s.this.g();
                        o oVar = cVar.f32435a;
                        int min = (int) Math.min(j2, (long) (oVar.f32467c - oVar.f32466b));
                        outputStream.write(oVar.f32465a, oVar.f32466b, min);
                        oVar.f32466b += min;
                        long j3 = (long) min;
                        j2 -= j3;
                        cVar.f32436b -= j3;
                        if (oVar.f32466b == oVar.f32467c) {
                            cVar.f32435a = oVar.b();
                            p.a(oVar);
                        }
                    }
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    public static q a(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getOutputStream() != null) {
            a c2 = c(socket);
            return c2.a(a(socket.getOutputStream(), (s) c2));
        } else {
            throw new IOException("socket's output stream == null");
        }
    }

    public static r a(File file) throws FileNotFoundException {
        if (file != null) {
            return a((InputStream) new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static r a(InputStream inputStream) {
        return a(inputStream, new s());
    }

    private static r a(final InputStream inputStream, final s sVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        } else if (sVar != null) {
            return new r() {
                public void close() throws IOException {
                    inputStream.close();
                }

                public long read(c cVar, long j2) throws IOException {
                    if (j2 < 0) {
                        throw new IllegalArgumentException("byteCount < 0: " + j2);
                    } else if (j2 == 0) {
                        return 0;
                    } else {
                        try {
                            s.this.g();
                            o e2 = cVar.e(1);
                            int read = inputStream.read(e2.f32465a, e2.f32467c, (int) Math.min(j2, (long) (8192 - e2.f32467c)));
                            if (read == -1) {
                                return -1;
                            }
                            e2.f32467c += read;
                            long j3 = (long) read;
                            cVar.f32436b += j3;
                            return j3;
                        } catch (AssertionError e3) {
                            if (k.a(e3)) {
                                throw new IOException(e3);
                            }
                            throw e3;
                        }
                    }
                }

                public s timeout() {
                    return s.this;
                }

                public String toString() {
                    return "source(" + inputStream + ")";
                }
            };
        } else {
            throw new IllegalArgumentException("timeout == null");
        }
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static r b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        } else if (socket.getInputStream() != null) {
            a c2 = c(socket);
            return c2.a(a(socket.getInputStream(), (s) c2));
        } else {
            throw new IOException("socket's input stream == null");
        }
    }

    private static a c(final Socket socket) {
        return new a() {
            /* access modifiers changed from: protected */
            public IOException a(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Exception} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.AssertionError} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Exception} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Exception} */
            /* access modifiers changed from: protected */
            /* JADX WARNING: Multi-variable type inference failed */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void a() {
                /*
                    r5 = this;
                    java.lang.String r0 = "Failed to close timed out socket "
                    java.net.Socket r1 = r1     // Catch:{ Exception -> 0x001a, AssertionError -> 0x0008 }
                    r1.close()     // Catch:{ Exception -> 0x001a, AssertionError -> 0x0008 }
                    goto L_0x0033
                L_0x0008:
                    r1 = move-exception
                    boolean r2 = okio.k.a((java.lang.AssertionError) r1)
                    if (r2 == 0) goto L_0x0019
                    java.util.logging.Logger r2 = okio.k.f32449a
                    java.util.logging.Level r3 = java.util.logging.Level.WARNING
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                    goto L_0x0024
                L_0x0019:
                    throw r1
                L_0x001a:
                    r1 = move-exception
                    java.util.logging.Logger r2 = okio.k.f32449a
                    java.util.logging.Level r3 = java.util.logging.Level.WARNING
                    java.lang.StringBuilder r4 = new java.lang.StringBuilder
                    r4.<init>()
                L_0x0024:
                    r4.append(r0)
                    java.net.Socket r0 = r1
                    r4.append(r0)
                    java.lang.String r0 = r4.toString()
                    r2.log(r3, r0, r1)
                L_0x0033:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: okio.k.AnonymousClass3.a():void");
            }
        };
    }
}
