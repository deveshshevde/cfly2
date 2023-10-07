package retrofit2;

import kotlin.Result;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlinx.coroutines.j;

public final class KotlinExtensions$awaitResponse$2$2 implements Callback<T> {
    final /* synthetic */ j $continuation;

    KotlinExtensions$awaitResponse$2$2(j jVar) {
        this.$continuation = jVar;
    }

    public void onFailure(Call<T> call, Throwable th) {
        h.c(call, "call");
        h.c(th, "t");
        Result.a aVar = Result.f30171a;
        this.$continuation.resumeWith(Result.e(i.a(th)));
    }

    public void onResponse(Call<T> call, Response<T> response) {
        h.c(call, "call");
        h.c(response, "response");
        Result.a aVar = Result.f30171a;
        this.$continuation.resumeWith(Result.e(response));
    }
}
