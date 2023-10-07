package retrofit2;

import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlinx.coroutines.j;

public final class KotlinExtensions$await$4$2 implements Callback<T> {
    final /* synthetic */ j $continuation;

    KotlinExtensions$await$4$2(j jVar) {
        this.$continuation = jVar;
    }

    public void onFailure(Call<T> call, Throwable th) {
        h.c(call, "call");
        h.c(th, "t");
        Result.a aVar = Result.f30171a;
        this.$continuation.resumeWith(Result.e(i.a(th)));
    }

    public void onResponse(Call<T> call, Response<T> response) {
        T t2;
        c cVar;
        h.c(call, "call");
        h.c(response, "response");
        if (response.isSuccessful()) {
            cVar = this.$continuation;
            t2 = response.body();
            Result.a aVar = Result.f30171a;
        } else {
            cVar = this.$continuation;
            Result.a aVar2 = Result.f30171a;
            t2 = i.a((Throwable) new HttpException(response));
        }
        cVar.resumeWith(Result.e(t2));
    }
}
