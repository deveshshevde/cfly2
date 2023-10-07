package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.coroutines.c;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.e;
import retrofit2.Utils;

abstract class HttpServiceMethod<ResponseT, ReturnT> extends ServiceMethod<ReturnT> {
    private final e.a callFactory;
    private final RequestFactory requestFactory;
    private final Converter<ac, ResponseT> responseConverter;

    static final class CallAdapted<ResponseT, ReturnT> extends HttpServiceMethod<ResponseT, ReturnT> {
        private final CallAdapter<ResponseT, ReturnT> callAdapter;

        CallAdapted(RequestFactory requestFactory, e.a aVar, Converter<ac, ResponseT> converter, CallAdapter<ResponseT, ReturnT> callAdapter2) {
            super(requestFactory, aVar, converter);
            this.callAdapter = callAdapter2;
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [retrofit2.Call, retrofit2.Call<ResponseT>] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ReturnT adapt(retrofit2.Call<ResponseT> r1, java.lang.Object[] r2) {
            /*
                r0 = this;
                retrofit2.CallAdapter<ResponseT, ReturnT> r2 = r0.callAdapter
                java.lang.Object r1 = r2.adapt(r1)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: retrofit2.HttpServiceMethod.CallAdapted.adapt(retrofit2.Call, java.lang.Object[]):java.lang.Object");
        }
    }

    static final class SuspendForBody<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;
        private final boolean isNullable;

        SuspendForBody(RequestFactory requestFactory, e.a aVar, Converter<ac, ResponseT> converter, CallAdapter<ResponseT, Call<ResponseT>> callAdapter2, boolean z2) {
            super(requestFactory, aVar, converter);
            this.callAdapter = callAdapter2;
            this.isNullable = z2;
        }

        /* access modifiers changed from: protected */
        public Object adapt(Call<ResponseT> call, Object[] objArr) {
            Call call2 = (Call) this.callAdapter.adapt(call);
            c cVar = objArr[objArr.length - 1];
            try {
                return this.isNullable ? KotlinExtensions.awaitNullable(call2, cVar) : KotlinExtensions.await(call2, cVar);
            } catch (Exception e2) {
                return KotlinExtensions.suspendAndThrow(e2, cVar);
            }
        }
    }

    static final class SuspendForResponse<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;

        SuspendForResponse(RequestFactory requestFactory, e.a aVar, Converter<ac, ResponseT> converter, CallAdapter<ResponseT, Call<ResponseT>> callAdapter2) {
            super(requestFactory, aVar, converter);
            this.callAdapter = callAdapter2;
        }

        /* access modifiers changed from: protected */
        public Object adapt(Call<ResponseT> call, Object[] objArr) {
            Call call2 = (Call) this.callAdapter.adapt(call);
            c cVar = objArr[objArr.length - 1];
            try {
                return KotlinExtensions.awaitResponse(call2, cVar);
            } catch (Exception e2) {
                return KotlinExtensions.suspendAndThrow(e2, cVar);
            }
        }
    }

    HttpServiceMethod(RequestFactory requestFactory2, e.a aVar, Converter<ac, ResponseT> converter) {
        this.requestFactory = requestFactory2;
        this.callFactory = aVar;
        this.responseConverter = converter;
    }

    private static <ResponseT, ReturnT> CallAdapter<ResponseT, ReturnT> createCallAdapter(Retrofit retrofit3, Method method, Type type, Annotation[] annotationArr) {
        try {
            return retrofit3.callAdapter(type, annotationArr);
        } catch (RuntimeException e2) {
            throw Utils.methodError(method, e2, "Unable to create call adapter for %s", type);
        }
    }

    private static <ResponseT> Converter<ac, ResponseT> createResponseConverter(Retrofit retrofit3, Method method, Type type) {
        try {
            return retrofit3.responseBodyConverter(type, method.getAnnotations());
        } catch (RuntimeException e2) {
            throw Utils.methodError(method, e2, "Unable to create converter for %s", type);
        }
    }

    static <ResponseT, ReturnT> HttpServiceMethod<ResponseT, ReturnT> parseAnnotations(Retrofit retrofit3, Method method, RequestFactory requestFactory2) {
        Type type;
        boolean z2;
        boolean z3 = requestFactory2.isKotlinSuspendFunction;
        Annotation[] annotations = method.getAnnotations();
        if (z3) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type parameterLowerBound = Utils.getParameterLowerBound(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (Utils.getRawType(parameterLowerBound) != Response.class || !(parameterLowerBound instanceof ParameterizedType)) {
                z2 = false;
            } else {
                parameterLowerBound = Utils.getParameterUpperBound(0, (ParameterizedType) parameterLowerBound);
                z2 = true;
            }
            type = new Utils.ParameterizedTypeImpl((Type) null, Call.class, parameterLowerBound);
            annotations = SkipCallbackExecutorImpl.ensurePresent(annotations);
        } else {
            type = method.getGenericReturnType();
            z2 = false;
        }
        CallAdapter createCallAdapter = createCallAdapter(retrofit3, method, type, annotations);
        Type responseType = createCallAdapter.responseType();
        if (responseType == ab.class) {
            throw Utils.methodError(method, "'" + Utils.getRawType(responseType).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        } else if (responseType == Response.class) {
            throw Utils.methodError(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        } else if (!requestFactory2.httpMethod.equals("HEAD") || Void.class.equals(responseType)) {
            Converter createResponseConverter = createResponseConverter(retrofit3, method, responseType);
            e.a aVar = retrofit3.callFactory;
            return !z3 ? new CallAdapted(requestFactory2, aVar, createResponseConverter, createCallAdapter) : z2 ? new SuspendForResponse(requestFactory2, aVar, createResponseConverter, createCallAdapter) : new SuspendForBody(requestFactory2, aVar, createResponseConverter, createCallAdapter, false);
        } else {
            throw Utils.methodError(method, "HEAD method must use Void as response type.", new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    public abstract ReturnT adapt(Call<ResponseT> call, Object[] objArr);

    /* access modifiers changed from: package-private */
    public final ReturnT invoke(Object[] objArr) {
        return adapt(new OkHttpCall(this.requestFactory, objArr, this.callFactory, this.responseConverter), objArr);
    }
}
