package retrofit2.adapter.rxjava;

import java.lang.reflect.Type;
import ok.a;
import ok.e;
import ok.i;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;

final class CompletableHelper {

    static class CompletableCallAdapter implements CallAdapter<a> {
        private final e scheduler;

        CompletableCallAdapter(e eVar) {
            this.scheduler = eVar;
        }

        public a adapt(Call call) {
            a a2 = a.a((a.C0234a) new CompletableCallOnSubscribe(call));
            e eVar = this.scheduler;
            return eVar != null ? a2.a(eVar) : a2;
        }

        public Type responseType() {
            return Void.class;
        }
    }

    private static final class CompletableCallOnSubscribe implements a.C0234a {
        private final Call originalCall;

        CompletableCallOnSubscribe(Call call) {
            this.originalCall = call;
        }

        public void call(a.b bVar) {
            final Call clone = this.originalCall.clone();
            i a2 = ot.e.a((on.a) new on.a() {
                public void call() {
                    clone.cancel();
                }
            });
            bVar.a(a2);
            try {
                Response execute = clone.execute();
                if (a2.isUnsubscribed()) {
                    return;
                }
                if (execute.isSuccessful()) {
                    bVar.a();
                } else {
                    bVar.a((Throwable) new HttpException(execute));
                }
            } catch (Throwable th) {
                rx.exceptions.a.a(th);
                if (!a2.isUnsubscribed()) {
                    bVar.a(th);
                }
            }
        }
    }

    CompletableHelper() {
    }

    static CallAdapter<a> createCallAdapter(e eVar) {
        return new CompletableCallAdapter(eVar);
    }
}
