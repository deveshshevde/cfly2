package retrofit;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import ok.b;
import ok.h;
import ot.e;

final class RxSupport {
    /* access modifiers changed from: private */
    public final ErrorHandler errorHandler;
    /* access modifiers changed from: private */
    public final Executor executor;
    /* access modifiers changed from: private */
    public final RequestInterceptor requestInterceptor;

    interface Invoker {
        ResponseWrapper invoke(RequestInterceptor requestInterceptor);
    }

    RxSupport(Executor executor2, ErrorHandler errorHandler2, RequestInterceptor requestInterceptor2) {
        this.executor = executor2;
        this.errorHandler = errorHandler2;
        this.requestInterceptor = requestInterceptor2;
    }

    /* access modifiers changed from: private */
    public Runnable getRunnable(final h<? super Object> hVar, final Invoker invoker, final RequestInterceptorTape requestInterceptorTape) {
        return new Runnable() {
            public void run() {
                try {
                    if (!hVar.isUnsubscribed()) {
                        hVar.onNext(invoker.invoke(requestInterceptorTape).responseBody);
                        hVar.onCompleted();
                    }
                } catch (RetrofitError e2) {
                    hVar.onError(RxSupport.this.errorHandler.handleError(e2));
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    public b createRequestObservable(final Invoker invoker) {
        return b.a(new b.a<Object>() {
            public void call(h<? super Object> hVar) {
                RequestInterceptorTape requestInterceptorTape = new RequestInterceptorTape();
                RxSupport.this.requestInterceptor.intercept(requestInterceptorTape);
                FutureTask futureTask = new FutureTask(RxSupport.this.getRunnable(hVar, invoker, requestInterceptorTape), (Object) null);
                hVar.add(e.a((Future<?>) futureTask));
                RxSupport.this.executor.execute(futureTask);
            }
        });
    }
}
