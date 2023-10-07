package retrofit2;

import java.io.IOException;
import java.util.Objects;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.e;
import okhttp3.f;
import okhttp3.v;
import okhttp3.z;
import okio.c;
import okio.g;
import okio.k;
import okio.r;
import okio.s;

final class OkHttpCall<T> implements Call<T> {
    private final Object[] args;
    private final e.a callFactory;
    private volatile boolean canceled;
    private Throwable creationFailure;
    private boolean executed;
    private e rawCall;
    private final RequestFactory requestFactory;
    private final Converter<ac, T> responseConverter;

    static final class ExceptionCatchingResponseBody extends ac {
        private final ac delegate;
        private final okio.e delegateSource;
        IOException thrownException;

        ExceptionCatchingResponseBody(ac acVar) {
            this.delegate = acVar;
            this.delegateSource = k.a((r) new g(acVar.source()) {
                public long read(c cVar, long j2) throws IOException {
                    try {
                        return super.read(cVar, j2);
                    } catch (IOException e2) {
                        ExceptionCatchingResponseBody.this.thrownException = e2;
                        throw e2;
                    }
                }
            });
        }

        public void close() {
            this.delegate.close();
        }

        public long contentLength() {
            return this.delegate.contentLength();
        }

        public v contentType() {
            return this.delegate.contentType();
        }

        public okio.e source() {
            return this.delegateSource;
        }

        /* access modifiers changed from: package-private */
        public void throwIfCaught() throws IOException {
            IOException iOException = this.thrownException;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    static final class NoContentResponseBody extends ac {
        private final long contentLength;
        private final v contentType;

        NoContentResponseBody(v vVar, long j2) {
            this.contentType = vVar;
            this.contentLength = j2;
        }

        public long contentLength() {
            return this.contentLength;
        }

        public v contentType() {
            return this.contentType;
        }

        public okio.e source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    OkHttpCall(RequestFactory requestFactory2, Object[] objArr, e.a aVar, Converter<ac, T> converter) {
        this.requestFactory = requestFactory2;
        this.args = objArr;
        this.callFactory = aVar;
        this.responseConverter = converter;
    }

    private e createRawCall() throws IOException {
        e a2 = this.callFactory.a(this.requestFactory.create(this.args));
        Objects.requireNonNull(a2, "Call.Factory returned null.");
        return a2;
    }

    private e getRawCall() throws IOException {
        e eVar = this.rawCall;
        if (eVar != null) {
            return eVar;
        }
        Throwable th = this.creationFailure;
        if (th == null) {
            try {
                e createRawCall = createRawCall();
                this.rawCall = createRawCall;
                return createRawCall;
            } catch (IOException | Error | RuntimeException e2) {
                Utils.throwIfFatal(e2);
                this.creationFailure = e2;
                throw e2;
            }
        } else if (th instanceof IOException) {
            throw ((IOException) th);
        } else if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else {
            throw ((Error) th);
        }
    }

    public void cancel() {
        e eVar;
        this.canceled = true;
        synchronized (this) {
            eVar = this.rawCall;
        }
        if (eVar != null) {
            eVar.c();
        }
    }

    public OkHttpCall<T> clone() {
        return new OkHttpCall<>(this.requestFactory, this.args, this.callFactory, this.responseConverter);
    }

    public void enqueue(final Callback<T> callback) {
        e eVar;
        Throwable th;
        Objects.requireNonNull(callback, "callback == null");
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                eVar = this.rawCall;
                th = this.creationFailure;
                if (eVar == null && th == null) {
                    try {
                        e createRawCall = createRawCall();
                        this.rawCall = createRawCall;
                        eVar = createRawCall;
                    } catch (Throwable th2) {
                        th = th2;
                        Utils.throwIfFatal(th);
                        this.creationFailure = th;
                    }
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (th != null) {
            callback.onFailure(this, th);
            return;
        }
        if (this.canceled) {
            eVar.c();
        }
        eVar.a(new f() {
            private void callFailure(Throwable th) {
                try {
                    callback.onFailure(OkHttpCall.this, th);
                } catch (Throwable th2) {
                    Utils.throwIfFatal(th2);
                    th2.printStackTrace();
                }
            }

            public void onFailure(e eVar, IOException iOException) {
                callFailure(iOException);
            }

            public void onResponse(e eVar, ab abVar) {
                try {
                    try {
                        callback.onResponse(OkHttpCall.this, OkHttpCall.this.parseResponse(abVar));
                    } catch (Throwable th) {
                        Utils.throwIfFatal(th);
                        th.printStackTrace();
                    }
                } catch (Throwable th2) {
                    Utils.throwIfFatal(th2);
                    callFailure(th2);
                }
            }
        });
    }

    public Response<T> execute() throws IOException {
        e rawCall2;
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                rawCall2 = getRawCall();
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (this.canceled) {
            rawCall2.c();
        }
        return parseResponse(rawCall2.b());
    }

    public boolean isCanceled() {
        boolean z2 = true;
        if (this.canceled) {
            return true;
        }
        synchronized (this) {
            e eVar = this.rawCall;
            if (eVar == null || !eVar.d()) {
                z2 = false;
            }
        }
        return z2;
    }

    public synchronized boolean isExecuted() {
        return this.executed;
    }

    /* access modifiers changed from: package-private */
    public Response<T> parseResponse(ab abVar) throws IOException {
        ac g2 = abVar.g();
        ab a2 = abVar.h().a((ac) new NoContentResponseBody(g2.contentType(), g2.contentLength())).a();
        int b2 = a2.b();
        if (b2 < 200 || b2 >= 300) {
            try {
                return Response.error(Utils.buffer(g2), a2);
            } finally {
                g2.close();
            }
        } else if (b2 == 204 || b2 == 205) {
            g2.close();
            return Response.success(null, a2);
        } else {
            ExceptionCatchingResponseBody exceptionCatchingResponseBody = new ExceptionCatchingResponseBody(g2);
            try {
                return Response.success(this.responseConverter.convert(exceptionCatchingResponseBody), a2);
            } catch (RuntimeException e2) {
                exceptionCatchingResponseBody.throwIfCaught();
                throw e2;
            }
        }
    }

    public synchronized z request() {
        try {
        } catch (IOException e2) {
            throw new RuntimeException("Unable to create request.", e2);
        }
        return getRawCall().a();
    }

    public synchronized s timeout() {
        try {
        } catch (IOException e2) {
            throw new RuntimeException("Unable to create call.", e2);
        }
        return getRawCall().e();
    }
}
