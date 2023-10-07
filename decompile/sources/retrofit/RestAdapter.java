package retrofit;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import retrofit.Profiler;
import retrofit.RxSupport;
import retrofit.Utils;
import retrofit.client.Client;
import retrofit.client.Header;
import retrofit.client.Request;
import retrofit.client.Response;
import retrofit.converter.Converter;
import retrofit.mime.MimeUtil;
import retrofit.mime.TypedByteArray;
import retrofit.mime.TypedInput;
import retrofit.mime.TypedOutput;

public class RestAdapter {
    static final String IDLE_THREAD_NAME = "Retrofit-Idle";
    static final String THREAD_PREFIX = "Retrofit-";
    final Executor callbackExecutor;
    /* access modifiers changed from: private */
    public final Client.Provider clientProvider;
    final Converter converter;
    final ErrorHandler errorHandler;
    final Executor httpExecutor;
    final Log log;
    volatile LogLevel logLevel;
    /* access modifiers changed from: private */
    public final Profiler profiler;
    final RequestInterceptor requestInterceptor;
    /* access modifiers changed from: private */
    public RxSupport rxSupport;
    final Endpoint server;
    private final Map<Class<?>, Map<Method, RestMethodInfo>> serviceMethodInfoCache;

    public static class Builder {
        private Executor callbackExecutor;
        private Client.Provider clientProvider;
        private Converter converter;
        private Endpoint endpoint;
        private ErrorHandler errorHandler;
        private Executor httpExecutor;
        private Log log;
        private LogLevel logLevel = LogLevel.NONE;
        private Profiler profiler;
        private RequestInterceptor requestInterceptor;

        private void ensureSaneDefaults() {
            if (this.converter == null) {
                this.converter = Platform.get().defaultConverter();
            }
            if (this.clientProvider == null) {
                this.clientProvider = Platform.get().defaultClient();
            }
            if (this.httpExecutor == null) {
                this.httpExecutor = Platform.get().defaultHttpExecutor();
            }
            if (this.callbackExecutor == null) {
                this.callbackExecutor = Platform.get().defaultCallbackExecutor();
            }
            if (this.errorHandler == null) {
                this.errorHandler = ErrorHandler.DEFAULT;
            }
            if (this.log == null) {
                this.log = Platform.get().defaultLog();
            }
            if (this.requestInterceptor == null) {
                this.requestInterceptor = RequestInterceptor.NONE;
            }
        }

        public RestAdapter build() {
            if (this.endpoint != null) {
                ensureSaneDefaults();
                return new RestAdapter(this.endpoint, this.clientProvider, this.httpExecutor, this.callbackExecutor, this.requestInterceptor, this.converter, this.profiler, this.errorHandler, this.log, this.logLevel);
            }
            throw new IllegalArgumentException("Endpoint may not be null.");
        }

        public Builder setClient(Client.Provider provider) {
            Objects.requireNonNull(provider, "Client provider may not be null.");
            this.clientProvider = provider;
            return this;
        }

        public Builder setClient(final Client client) {
            Objects.requireNonNull(client, "Client may not be null.");
            return setClient((Client.Provider) new Client.Provider() {
                public Client get() {
                    return client;
                }
            });
        }

        public Builder setConverter(Converter converter2) {
            Objects.requireNonNull(converter2, "Converter may not be null.");
            this.converter = converter2;
            return this;
        }

        public Builder setEndpoint(String str) {
            if (str == null || str.trim().length() == 0) {
                throw new NullPointerException("Endpoint may not be blank.");
            }
            this.endpoint = Endpoints.newFixedEndpoint(str);
            return this;
        }

        public Builder setEndpoint(Endpoint endpoint2) {
            Objects.requireNonNull(endpoint2, "Endpoint may not be null.");
            this.endpoint = endpoint2;
            return this;
        }

        public Builder setErrorHandler(ErrorHandler errorHandler2) {
            Objects.requireNonNull(errorHandler2, "Error handler may not be null.");
            this.errorHandler = errorHandler2;
            return this;
        }

        public Builder setExecutors(Executor executor, Executor executor2) {
            Objects.requireNonNull(executor, "HTTP executor may not be null.");
            if (executor2 == null) {
                executor2 = new Utils.SynchronousExecutor();
            }
            this.httpExecutor = executor;
            this.callbackExecutor = executor2;
            return this;
        }

        public Builder setLog(Log log2) {
            Objects.requireNonNull(log2, "Log may not be null.");
            this.log = log2;
            return this;
        }

        public Builder setLogLevel(LogLevel logLevel2) {
            Objects.requireNonNull(logLevel2, "Log level may not be null.");
            this.logLevel = logLevel2;
            return this;
        }

        public Builder setProfiler(Profiler profiler2) {
            Objects.requireNonNull(profiler2, "Profiler may not be null.");
            this.profiler = profiler2;
            return this;
        }

        public Builder setRequestInterceptor(RequestInterceptor requestInterceptor2) {
            Objects.requireNonNull(requestInterceptor2, "Request interceptor may not be null.");
            this.requestInterceptor = requestInterceptor2;
            return this;
        }
    }

    public interface Log {
        public static final Log NONE = new Log() {
            public void log(String str) {
            }
        };

        void log(String str);
    }

    public enum LogLevel {
        NONE,
        BASIC,
        HEADERS,
        HEADERS_AND_ARGS,
        FULL;

        public boolean log() {
            return this != NONE;
        }
    }

    private class RestHandler implements InvocationHandler {
        private final Map<Method, RestMethodInfo> methodDetailsCache;

        RestHandler(Map<Method, RestMethodInfo> map) {
            this.methodDetailsCache = map;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:102:0x01bf, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:103:0x01c0, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:104:0x01c1, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:106:0x01c4, code lost:
            if (r2.isSynchronous == false) goto L_0x01c6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:107:0x01c6, code lost:
            java.lang.Thread.currentThread().setName(retrofit.RestAdapter.IDLE_THREAD_NAME);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:108:0x01cd, code lost:
            throw r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x0195, code lost:
            r0 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x01a0, code lost:
            r1.this$0.logException(r0, r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:96:0x01aa, code lost:
            r0 = e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:99:0x01b5, code lost:
            r1.this$0.logException(r0, r4);
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:102:0x01bf A[Catch:{ RetrofitError -> 0x01bf, IOException -> 0x01aa, all -> 0x0195, all -> 0x01c1 }, ExcHandler: RetrofitError (r0v2 'e' retrofit.RetrofitError A[CUSTOM_DECLARE, Catch:{  }]), Splitter:B:1:0x0009] */
        /* JADX WARNING: Removed duplicated region for block: B:93:0x01a0 A[Catch:{ RetrofitError -> 0x01bf, IOException -> 0x01aa, all -> 0x0195, all -> 0x01c1 }] */
        /* JADX WARNING: Removed duplicated region for block: B:99:0x01b5 A[Catch:{ RetrofitError -> 0x01bf, IOException -> 0x01aa, all -> 0x0195, all -> 0x01c1 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object invokeRequest(retrofit.RequestInterceptor r17, retrofit.RestMethodInfo r18, java.lang.Object[] r19) {
            /*
                r16 = this;
                r1 = r16
                r2 = r18
                r0 = r19
                java.lang.String r3 = "Retrofit-Idle"
                r4 = 0
                r18.init()     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x01aa, all -> 0x0195 }
                retrofit.RestAdapter r5 = retrofit.RestAdapter.this     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x01aa, all -> 0x0195 }
                retrofit.Endpoint r5 = r5.server     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x01aa, all -> 0x0195 }
                java.lang.String r5 = r5.getUrl()     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x01aa, all -> 0x0195 }
                retrofit.RequestBuilder r6 = new retrofit.RequestBuilder     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x01aa, all -> 0x0195 }
                retrofit.RestAdapter r7 = retrofit.RestAdapter.this     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x01aa, all -> 0x0195 }
                retrofit.converter.Converter r7 = r7.converter     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x01aa, all -> 0x0195 }
                r6.<init>(r5, r2, r7)     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x01aa, all -> 0x0195 }
                r6.setArguments(r0)     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x01aa, all -> 0x0195 }
                r7 = r17
                r7.intercept(r6)     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x01aa, all -> 0x0195 }
                retrofit.client.Request r6 = r6.build()     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x01aa, all -> 0x0195 }
                java.lang.String r7 = r6.getUrl()     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x01aa, all -> 0x0195 }
                boolean r8 = r2.isSynchronous     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                if (r8 != 0) goto L_0x0062
                java.lang.String r8 = "?"
                int r9 = r5.length()     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                int r8 = r7.indexOf(r8, r9)     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                r9 = -1
                if (r8 != r9) goto L_0x0042
                int r8 = r7.length()     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
            L_0x0042:
                java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                r10.<init>()     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                java.lang.String r11 = "Retrofit-"
                r10.append(r11)     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                int r11 = r5.length()     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                java.lang.String r8 = r7.substring(r11, r8)     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                r10.append(r8)     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                java.lang.String r8 = r10.toString()     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                r9.setName(r8)     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
            L_0x0062:
                retrofit.RestAdapter r8 = retrofit.RestAdapter.this     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                retrofit.RestAdapter$LogLevel r8 = r8.logLevel     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                boolean r8 = r8.log()     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                if (r8 == 0) goto L_0x0074
                retrofit.RestAdapter r8 = retrofit.RestAdapter.this     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                java.lang.String r9 = "HTTP"
                retrofit.client.Request r6 = r8.logAndReplaceRequest(r9, r6, r0)     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
            L_0x0074:
                retrofit.RestAdapter r0 = retrofit.RestAdapter.this     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                retrofit.Profiler r0 = r0.profiler     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                if (r0 == 0) goto L_0x0088
                retrofit.RestAdapter r0 = retrofit.RestAdapter.this     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                retrofit.Profiler r0 = r0.profiler     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                java.lang.Object r0 = r0.beforeCall()     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                r13 = r0
                goto L_0x0089
            L_0x0088:
                r13 = r4
            L_0x0089:
                long r8 = java.lang.System.nanoTime()     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                retrofit.RestAdapter r0 = retrofit.RestAdapter.this     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                retrofit.client.Client$Provider r0 = r0.clientProvider     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                retrofit.client.Client r0 = r0.get()     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                retrofit.client.Response r0 = r0.execute(r6)     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                long r11 = java.lang.System.nanoTime()     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                long r11 = r11 - r8
                long r14 = r10.toMillis(r11)     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                int r12 = r0.getStatus()     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                retrofit.RestAdapter r8 = retrofit.RestAdapter.this     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                retrofit.Profiler r8 = r8.profiler     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                if (r8 == 0) goto L_0x00c2
                retrofit.Profiler$RequestInformation r9 = retrofit.RestAdapter.getRequestInfo(r5, r2, r6)     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                retrofit.RestAdapter r5 = retrofit.RestAdapter.this     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                retrofit.Profiler r8 = r5.profiler     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                r10 = r14
                r5 = r12
                r8.afterCall(r9, r10, r12, r13)     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                goto L_0x00c3
            L_0x00c2:
                r5 = r12
            L_0x00c3:
                retrofit.RestAdapter r6 = retrofit.RestAdapter.this     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                retrofit.RestAdapter$LogLevel r6 = r6.logLevel     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                boolean r6 = r6.log()     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                if (r6 == 0) goto L_0x00d3
                retrofit.RestAdapter r6 = retrofit.RestAdapter.this     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                retrofit.client.Response r0 = r6.logAndReplaceResponse(r7, r0, r14)     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
            L_0x00d3:
                r6 = r0
                java.lang.reflect.Type r8 = r2.responseObjectType     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                r0 = 200(0xc8, float:2.8E-43)
                if (r5 < r0) goto L_0x0182
                r0 = 300(0x12c, float:4.2E-43)
                if (r5 >= r0) goto L_0x0182
                java.lang.Class<retrofit.client.Response> r0 = retrofit.client.Response.class
                boolean r0 = r8.equals(r0)     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                if (r0 == 0) goto L_0x010f
                boolean r0 = r2.isStreaming     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                if (r0 != 0) goto L_0x00ee
                retrofit.client.Response r6 = retrofit.Utils.readBodyToBytesIfNecessary((retrofit.client.Response) r6)     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
            L_0x00ee:
                boolean r0 = r2.isSynchronous     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                if (r0 == 0) goto L_0x00fe
                boolean r0 = r2.isSynchronous
                if (r0 != 0) goto L_0x00fd
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.setName(r3)
            L_0x00fd:
                return r6
            L_0x00fe:
                retrofit.ResponseWrapper r0 = new retrofit.ResponseWrapper     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                r0.<init>(r6, r6)     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                boolean r2 = r2.isSynchronous
                if (r2 != 0) goto L_0x010e
                java.lang.Thread r2 = java.lang.Thread.currentThread()
                r2.setName(r3)
            L_0x010e:
                return r0
            L_0x010f:
                retrofit.mime.TypedInput r0 = r6.getBody()     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                if (r0 != 0) goto L_0x0136
                boolean r0 = r2.isSynchronous     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                if (r0 == 0) goto L_0x0125
                boolean r0 = r2.isSynchronous
                if (r0 != 0) goto L_0x0124
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.setName(r3)
            L_0x0124:
                return r4
            L_0x0125:
                retrofit.ResponseWrapper r0 = new retrofit.ResponseWrapper     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                r0.<init>(r6, r4)     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                boolean r2 = r2.isSynchronous
                if (r2 != 0) goto L_0x0135
                java.lang.Thread r2 = java.lang.Thread.currentThread()
                r2.setName(r3)
            L_0x0135:
                return r0
            L_0x0136:
                retrofit.ExceptionCatchingTypedInput r5 = new retrofit.ExceptionCatchingTypedInput     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                r5.<init>(r0)     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                retrofit.RestAdapter r9 = retrofit.RestAdapter.this     // Catch:{ ConversionException -> 0x0169 }
                retrofit.converter.Converter r9 = r9.converter     // Catch:{ ConversionException -> 0x0169 }
                java.lang.Object r9 = r9.fromBody(r5, r8)     // Catch:{ ConversionException -> 0x0169 }
                retrofit.RestAdapter r10 = retrofit.RestAdapter.this     // Catch:{ ConversionException -> 0x0169 }
                r10.logResponseBody(r0, r9)     // Catch:{ ConversionException -> 0x0169 }
                boolean r0 = r2.isSynchronous     // Catch:{ ConversionException -> 0x0169 }
                if (r0 == 0) goto L_0x0158
                boolean r0 = r2.isSynchronous
                if (r0 != 0) goto L_0x0157
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.setName(r3)
            L_0x0157:
                return r9
            L_0x0158:
                retrofit.ResponseWrapper r0 = new retrofit.ResponseWrapper     // Catch:{ ConversionException -> 0x0169 }
                r0.<init>(r6, r9)     // Catch:{ ConversionException -> 0x0169 }
                boolean r2 = r2.isSynchronous
                if (r2 != 0) goto L_0x0168
                java.lang.Thread r2 = java.lang.Thread.currentThread()
                r2.setName(r3)
            L_0x0168:
                return r0
            L_0x0169:
                r0 = move-exception
                boolean r9 = r5.threwException()     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                if (r9 == 0) goto L_0x0175
                java.io.IOException r0 = r5.getThrownException()     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                throw r0     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
            L_0x0175:
                retrofit.client.Response r4 = retrofit.Utils.replaceResponseBody(r6, r4)     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                retrofit.RestAdapter r5 = retrofit.RestAdapter.this     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                retrofit.converter.Converter r5 = r5.converter     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                retrofit.RetrofitError r0 = retrofit.RetrofitError.conversionError(r7, r4, r5, r8, r0)     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                throw r0     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
            L_0x0182:
                retrofit.client.Response r0 = retrofit.Utils.readBodyToBytesIfNecessary((retrofit.client.Response) r6)     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                retrofit.RestAdapter r4 = retrofit.RestAdapter.this     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                retrofit.converter.Converter r4 = r4.converter     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                retrofit.RetrofitError r0 = retrofit.RetrofitError.httpError(r7, r0, r4, r8)     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
                throw r0     // Catch:{ RetrofitError -> 0x01bf, IOException -> 0x0192, all -> 0x018f }
            L_0x018f:
                r0 = move-exception
                r4 = r7
                goto L_0x0196
            L_0x0192:
                r0 = move-exception
                r4 = r7
                goto L_0x01ab
            L_0x0195:
                r0 = move-exception
            L_0x0196:
                retrofit.RestAdapter r5 = retrofit.RestAdapter.this     // Catch:{ all -> 0x01c1 }
                retrofit.RestAdapter$LogLevel r5 = r5.logLevel     // Catch:{ all -> 0x01c1 }
                boolean r5 = r5.log()     // Catch:{ all -> 0x01c1 }
                if (r5 == 0) goto L_0x01a5
                retrofit.RestAdapter r5 = retrofit.RestAdapter.this     // Catch:{ all -> 0x01c1 }
                r5.logException(r0, r4)     // Catch:{ all -> 0x01c1 }
            L_0x01a5:
                retrofit.RetrofitError r0 = retrofit.RetrofitError.unexpectedError(r4, r0)     // Catch:{ all -> 0x01c1 }
                throw r0     // Catch:{ all -> 0x01c1 }
            L_0x01aa:
                r0 = move-exception
            L_0x01ab:
                retrofit.RestAdapter r5 = retrofit.RestAdapter.this     // Catch:{ all -> 0x01c1 }
                retrofit.RestAdapter$LogLevel r5 = r5.logLevel     // Catch:{ all -> 0x01c1 }
                boolean r5 = r5.log()     // Catch:{ all -> 0x01c1 }
                if (r5 == 0) goto L_0x01ba
                retrofit.RestAdapter r5 = retrofit.RestAdapter.this     // Catch:{ all -> 0x01c1 }
                r5.logException(r0, r4)     // Catch:{ all -> 0x01c1 }
            L_0x01ba:
                retrofit.RetrofitError r0 = retrofit.RetrofitError.networkError(r4, r0)     // Catch:{ all -> 0x01c1 }
                throw r0     // Catch:{ all -> 0x01c1 }
            L_0x01bf:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x01c1 }
            L_0x01c1:
                r0 = move-exception
                boolean r2 = r2.isSynchronous
                if (r2 != 0) goto L_0x01cd
                java.lang.Thread r2 = java.lang.Thread.currentThread()
                r2.setName(r3)
            L_0x01cd:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: retrofit.RestAdapter.RestHandler.invokeRequest(retrofit.RequestInterceptor, retrofit.RestMethodInfo, java.lang.Object[]):java.lang.Object");
        }

        public Object invoke(Object obj, Method method, final Object[] objArr) throws Throwable {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            final RestMethodInfo methodInfo = RestAdapter.getMethodInfo(this.methodDetailsCache, method);
            if (methodInfo.isSynchronous) {
                try {
                    return invokeRequest(RestAdapter.this.requestInterceptor, methodInfo, objArr);
                } catch (RetrofitError e2) {
                    Throwable handleError = RestAdapter.this.errorHandler.handleError(e2);
                    if (handleError == null) {
                        throw new IllegalStateException("Error handler returned null for wrapped exception.", e2);
                    }
                    throw handleError;
                }
            } else if (RestAdapter.this.httpExecutor == null || RestAdapter.this.callbackExecutor == null) {
                throw new IllegalStateException("Asynchronous invocation requires calling setExecutors.");
            } else if (methodInfo.isObservable) {
                if (RestAdapter.this.rxSupport == null) {
                    if (Platform.HAS_RX_JAVA) {
                        RestAdapter restAdapter = RestAdapter.this;
                        RxSupport unused = restAdapter.rxSupport = new RxSupport(restAdapter.httpExecutor, RestAdapter.this.errorHandler, RestAdapter.this.requestInterceptor);
                    } else {
                        throw new IllegalStateException("Observable method found but no RxJava on classpath.");
                    }
                }
                return RestAdapter.this.rxSupport.createRequestObservable(new RxSupport.Invoker() {
                    public ResponseWrapper invoke(RequestInterceptor requestInterceptor) {
                        return (ResponseWrapper) RestHandler.this.invokeRequest(requestInterceptor, methodInfo, objArr);
                    }
                });
            } else {
                final RequestInterceptorTape requestInterceptorTape = new RequestInterceptorTape();
                RestAdapter.this.requestInterceptor.intercept(requestInterceptorTape);
                final Object[] objArr2 = objArr;
                RestAdapter.this.httpExecutor.execute(new CallbackRunnable(objArr[objArr.length - 1], RestAdapter.this.callbackExecutor, RestAdapter.this.errorHandler) {
                    public ResponseWrapper obtainResponse() {
                        return (ResponseWrapper) RestHandler.this.invokeRequest(requestInterceptorTape, methodInfo, objArr2);
                    }
                });
                return null;
            }
        }
    }

    private RestAdapter(Endpoint endpoint, Client.Provider provider, Executor executor, Executor executor2, RequestInterceptor requestInterceptor2, Converter converter2, Profiler profiler2, ErrorHandler errorHandler2, Log log2, LogLevel logLevel2) {
        this.serviceMethodInfoCache = new LinkedHashMap();
        this.server = endpoint;
        this.clientProvider = provider;
        this.httpExecutor = executor;
        this.callbackExecutor = executor2;
        this.requestInterceptor = requestInterceptor2;
        this.converter = converter2;
        this.profiler = profiler2;
        this.errorHandler = errorHandler2;
        this.log = log2;
        this.logLevel = logLevel2;
    }

    static RestMethodInfo getMethodInfo(Map<Method, RestMethodInfo> map, Method method) {
        RestMethodInfo restMethodInfo;
        synchronized (map) {
            restMethodInfo = map.get(method);
            if (restMethodInfo == null) {
                restMethodInfo = new RestMethodInfo(method);
                map.put(method, restMethodInfo);
            }
        }
        return restMethodInfo;
    }

    /* access modifiers changed from: private */
    public static Profiler.RequestInformation getRequestInfo(String str, RestMethodInfo restMethodInfo, Request request) {
        String str2;
        long j2;
        TypedOutput body = request.getBody();
        if (body != null) {
            j2 = body.length();
            str2 = body.mimeType();
        } else {
            j2 = 0;
            str2 = null;
        }
        long j3 = j2;
        return new Profiler.RequestInformation(restMethodInfo.requestMethod, str, restMethodInfo.requestUrl, j3, str2);
    }

    /* access modifiers changed from: private */
    public Response logAndReplaceResponse(String str, Response response, long j2) throws IOException {
        this.log.log(String.format("<--- HTTP %s %s (%sms)", new Object[]{Integer.valueOf(response.getStatus()), str, Long.valueOf(j2)}));
        if (this.logLevel.ordinal() >= LogLevel.HEADERS.ordinal()) {
            for (Header header : response.getHeaders()) {
                this.log.log(header.toString());
            }
            long j3 = 0;
            TypedInput body = response.getBody();
            if (body != null) {
                j3 = body.length();
                if (this.logLevel.ordinal() >= LogLevel.FULL.ordinal()) {
                    if (!response.getHeaders().isEmpty()) {
                        this.log.log("");
                    }
                    if (!(body instanceof TypedByteArray)) {
                        response = Utils.readBodyToBytesIfNecessary(response);
                        body = response.getBody();
                    }
                    byte[] bytes = ((TypedByteArray) body).getBytes();
                    long length = (long) bytes.length;
                    this.log.log(new String(bytes, MimeUtil.parseCharset(body.mimeType(), "UTF-8")));
                    j3 = length;
                }
            }
            this.log.log(String.format("<--- END HTTP (%s-byte body)", new Object[]{Long.valueOf(j3)}));
        }
        return response;
    }

    /* access modifiers changed from: private */
    public void logResponseBody(TypedInput typedInput, Object obj) {
        if (this.logLevel.ordinal() == LogLevel.HEADERS_AND_ARGS.ordinal()) {
            this.log.log("<--- BODY:");
            this.log.log(obj.toString());
        }
    }

    public <T> T create(Class<T> cls) {
        Utils.validateServiceClass(cls);
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new RestHandler(getMethodInfoCache(cls)));
    }

    public LogLevel getLogLevel() {
        return this.logLevel;
    }

    /* access modifiers changed from: package-private */
    public Map<Method, RestMethodInfo> getMethodInfoCache(Class<?> cls) {
        Map<Method, RestMethodInfo> map;
        synchronized (this.serviceMethodInfoCache) {
            map = this.serviceMethodInfoCache.get(cls);
            if (map == null) {
                map = new LinkedHashMap<>();
                this.serviceMethodInfoCache.put(cls, map);
            }
        }
        return map;
    }

    /* access modifiers changed from: package-private */
    public Request logAndReplaceRequest(String str, Request request, Object[] objArr) throws IOException {
        String str2;
        this.log.log(String.format("---> %s %s %s", new Object[]{str, request.getMethod(), request.getUrl()}));
        if (this.logLevel.ordinal() >= LogLevel.HEADERS.ordinal()) {
            for (Header header : request.getHeaders()) {
                this.log.log(header.toString());
            }
            TypedOutput body = request.getBody();
            if (body != null) {
                String mimeType = body.mimeType();
                if (mimeType != null) {
                    this.log.log("Content-Type: " + mimeType);
                }
                long length = body.length();
                str2 = length + "-byte";
                if (length != -1) {
                    this.log.log("Content-Length: " + length);
                }
                if (this.logLevel.ordinal() >= LogLevel.FULL.ordinal()) {
                    if (!request.getHeaders().isEmpty()) {
                        this.log.log("");
                    }
                    if (!(body instanceof TypedByteArray)) {
                        request = Utils.readBodyToBytesIfNecessary(request);
                        body = request.getBody();
                    }
                    this.log.log(new String(((TypedByteArray) body).getBytes(), MimeUtil.parseCharset(body.mimeType(), "UTF-8")));
                } else if (this.logLevel.ordinal() >= LogLevel.HEADERS_AND_ARGS.ordinal()) {
                    if (!request.getHeaders().isEmpty()) {
                        this.log.log("---> REQUEST:");
                    }
                    for (int i2 = 0; i2 < objArr.length; i2++) {
                        this.log.log("#" + i2 + ": " + objArr[i2]);
                    }
                }
            } else {
                str2 = "no";
            }
            this.log.log(String.format("---> END %s (%s body)", new Object[]{str, str2}));
        }
        return request;
    }

    /* access modifiers changed from: package-private */
    public void logException(Throwable th, String str) {
        Log log2 = this.log;
        Object[] objArr = new Object[1];
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        log2.log(String.format("---- ERROR %s", objArr));
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        this.log.log(stringWriter.toString());
        this.log.log("---- END ERROR");
    }

    public void setLogLevel(LogLevel logLevel2) {
        Objects.requireNonNull(this.logLevel, "Log level may not be null.");
        this.logLevel = logLevel2;
    }
}
