package retrofit2.adapter.rxjava;

import java.lang.reflect.Type;
import ok.b;
import ok.f;
import retrofit2.Call;
import retrofit2.CallAdapter;

final class SingleHelper {
    SingleHelper() {
    }

    static CallAdapter<f<?>> makeSingle(final CallAdapter<b<?>> callAdapter) {
        return new CallAdapter<f<?>>() {
            public <R> f<?> adapt(Call<R> call) {
                return ((b) callAdapter.adapt(call)).a();
            }

            public Type responseType() {
                return callAdapter.responseType();
            }
        };
    }
}
