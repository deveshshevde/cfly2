package retrofit2.adapter.rxjava;

import ok.b;
import ok.h;
import retrofit2.Response;

final class OperatorMapResponseToBodyOrError<T> implements b.C0235b<T, Response<T>> {
    private static final OperatorMapResponseToBodyOrError<Object> INSTANCE = new OperatorMapResponseToBodyOrError<>();

    OperatorMapResponseToBodyOrError() {
    }

    static <R> OperatorMapResponseToBodyOrError<R> instance() {
        return INSTANCE;
    }

    public h<? super Response<T>> call(final h<? super T> hVar) {
        return new h<Response<T>>(hVar) {
            public void onCompleted() {
                hVar.onCompleted();
            }

            public void onError(Throwable th) {
                hVar.onError(th);
            }

            public void onNext(Response<T> response) {
                if (response.isSuccessful()) {
                    hVar.onNext(response.body());
                } else {
                    hVar.onError(new HttpException(response));
                }
            }
        };
    }
}
