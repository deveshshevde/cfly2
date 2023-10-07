package retrofit2;

import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlinx.coroutines.j;

public final class KotlinExtensions$await$2$2 implements Callback<T> {
    final /* synthetic */ j $continuation;

    KotlinExtensions$await$2$2(j jVar) {
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
            t2 = response.body();
            if (t2 == null) {
                Object a2 = call.request().a(Invocation.class);
                if (a2 == null) {
                    h.a();
                }
                h.a(a2, "call.request().tag(Invocation::class.java)!!");
                Method method = ((Invocation) a2).method();
                StringBuilder sb = new StringBuilder();
                sb.append("Response from ");
                h.a((Object) method, "method");
                Class<?> declaringClass = method.getDeclaringClass();
                h.a((Object) declaringClass, "method.declaringClass");
                sb.append(declaringClass.getName());
                sb.append('.');
                sb.append(method.getName());
                sb.append(" was null but response body type was declared as non-null");
                KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(sb.toString());
                cVar = this.$continuation;
                Result.a aVar = Result.f30171a;
                t2 = i.a((Throwable) kotlinNullPointerException);
            } else {
                cVar = this.$continuation;
                Result.a aVar2 = Result.f30171a;
            }
        } else {
            cVar = this.$continuation;
            Result.a aVar3 = Result.f30171a;
            t2 = i.a((Throwable) new HttpException(response));
        }
        cVar.resumeWith(Result.e(t2));
    }
}
