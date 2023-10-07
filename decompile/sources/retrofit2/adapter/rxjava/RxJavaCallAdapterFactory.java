package retrofit2.adapter.rxjava;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import ok.b;
import ok.d;
import ok.e;
import ok.h;
import ok.i;
import on.c;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.exceptions.a;

public final class RxJavaCallAdapterFactory extends CallAdapter.Factory {
    private final e scheduler;

    static final class CallOnSubscribe<T> implements b.a<Response<T>> {
        private final Call<T> originalCall;

        CallOnSubscribe(Call<T> call) {
            this.originalCall = call;
        }

        public void call(h<? super Response<T>> hVar) {
            RequestArbiter requestArbiter = new RequestArbiter(this.originalCall.clone(), hVar);
            hVar.add(requestArbiter);
            hVar.setProducer(requestArbiter);
        }
    }

    static final class RequestArbiter<T> extends AtomicBoolean implements d, i {
        private final Call<T> call;
        private final h<? super Response<T>> subscriber;

        RequestArbiter(Call<T> call2, h<? super Response<T>> hVar) {
            this.call = call2;
            this.subscriber = hVar;
        }

        public boolean isUnsubscribed() {
            return this.call.isCanceled();
        }

        public void request(long j2) {
            if (j2 < 0) {
                throw new IllegalArgumentException("n < 0: " + j2);
            } else if (j2 != 0 && compareAndSet(false, true)) {
                try {
                    Response<T> execute = this.call.execute();
                    if (!this.subscriber.isUnsubscribed()) {
                        this.subscriber.onNext(execute);
                    }
                    if (!this.subscriber.isUnsubscribed()) {
                        this.subscriber.onCompleted();
                    }
                } catch (Throwable th) {
                    a.a(th);
                    if (!this.subscriber.isUnsubscribed()) {
                        this.subscriber.onError(th);
                    }
                }
            }
        }

        public void unsubscribe() {
            this.call.cancel();
        }
    }

    static final class ResponseCallAdapter implements CallAdapter<b<?>> {
        private final Type responseType;
        private final e scheduler;

        ResponseCallAdapter(Type type, e eVar) {
            this.responseType = type;
            this.scheduler = eVar;
        }

        public <R> b<Response<R>> adapt(Call<R> call) {
            b<Response<R>> a2 = b.a(new CallOnSubscribe(call));
            e eVar = this.scheduler;
            return eVar != null ? a2.b(eVar) : a2;
        }

        public Type responseType() {
            return this.responseType;
        }
    }

    static final class ResultCallAdapter implements CallAdapter<b<?>> {
        private final Type responseType;
        private final e scheduler;

        ResultCallAdapter(Type type, e eVar) {
            this.responseType = type;
            this.scheduler = eVar;
        }

        public <R> b<Result<R>> adapt(Call<R> call) {
            b<Result<R>> b2 = b.a(new CallOnSubscribe(call)).a(new c<Response<R>, Result<R>>() {
                public Result<R> call(Response<R> response) {
                    return Result.response(response);
                }
            }).b(new c<Throwable, Result<R>>() {
                public Result<R> call(Throwable th) {
                    return Result.error(th);
                }
            });
            e eVar = this.scheduler;
            return eVar != null ? b2.b(eVar) : b2;
        }

        public Type responseType() {
            return this.responseType;
        }
    }

    static final class SimpleCallAdapter implements CallAdapter<b<?>> {
        private final Type responseType;
        private final e scheduler;

        SimpleCallAdapter(Type type, e eVar) {
            this.responseType = type;
            this.scheduler = eVar;
        }

        public <R> b<R> adapt(Call<R> call) {
            b<R> a2 = b.a(new CallOnSubscribe(call)).a(OperatorMapResponseToBodyOrError.instance());
            e eVar = this.scheduler;
            return eVar != null ? a2.b(eVar) : a2;
        }

        public Type responseType() {
            return this.responseType;
        }
    }

    private RxJavaCallAdapterFactory(e eVar) {
        this.scheduler = eVar;
    }

    public static RxJavaCallAdapterFactory create() {
        return new RxJavaCallAdapterFactory((e) null);
    }

    public static RxJavaCallAdapterFactory createWithScheduler(e eVar) {
        Objects.requireNonNull(eVar, "scheduler == null");
        return new RxJavaCallAdapterFactory(eVar);
    }

    private CallAdapter<b<?>> getCallAdapter(Type type, e eVar) {
        Type parameterUpperBound = getParameterUpperBound(0, (ParameterizedType) type);
        Class<?> rawType = getRawType(parameterUpperBound);
        if (rawType == Response.class) {
            if (parameterUpperBound instanceof ParameterizedType) {
                return new ResponseCallAdapter(getParameterUpperBound(0, (ParameterizedType) parameterUpperBound), eVar);
            }
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        } else if (rawType != Result.class) {
            return new SimpleCallAdapter(parameterUpperBound, eVar);
        } else {
            if (parameterUpperBound instanceof ParameterizedType) {
                return new ResultCallAdapter(getParameterUpperBound(0, (ParameterizedType) parameterUpperBound), eVar);
            }
            throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
        }
    }

    public CallAdapter<?> get(Type type, Annotation[] annotationArr, Retrofit retrofit3) {
        Class<?> rawType = getRawType(type);
        String canonicalName = rawType.getCanonicalName();
        boolean equals = "rx.Single".equals(canonicalName);
        boolean equals2 = "rx.Completable".equals(canonicalName);
        if (rawType != b.class && !equals && !equals2) {
            return null;
        }
        if (!equals2 && !(type instanceof ParameterizedType)) {
            String str = equals ? "Single" : "Observable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        } else if (equals2) {
            return CompletableHelper.createCallAdapter(this.scheduler);
        } else {
            CallAdapter<b<?>> callAdapter = getCallAdapter(type, this.scheduler);
            return equals ? SingleHelper.makeSingle(callAdapter) : callAdapter;
        }
    }
}
