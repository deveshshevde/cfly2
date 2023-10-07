package retrofit2;

import java.util.Objects;
import okhttp3.Protocol;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.s;
import okhttp3.z;
import retrofit2.OkHttpCall;

public final class Response<T> {
    private final T body;
    private final ac errorBody;
    private final ab rawResponse;

    private Response(ab abVar, T t2, ac acVar) {
        this.rawResponse = abVar;
        this.body = t2;
        this.errorBody = acVar;
    }

    public static <T> Response<T> error(int i2, ac acVar) {
        Objects.requireNonNull(acVar, "body == null");
        if (i2 >= 400) {
            return error(acVar, new ab.a().a((ac) new OkHttpCall.NoContentResponseBody(acVar.contentType(), acVar.contentLength())).a(i2).a("Response.error()").a(Protocol.HTTP_1_1).a(new z.a().a("http://localhost/").b()).a());
        }
        throw new IllegalArgumentException("code < 400: " + i2);
    }

    public static <T> Response<T> error(ac acVar, ab abVar) {
        Objects.requireNonNull(acVar, "body == null");
        Objects.requireNonNull(abVar, "rawResponse == null");
        if (!abVar.c()) {
            return new Response<>(abVar, (Object) null, acVar);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static <T> Response<T> success(int i2, T t2) {
        if (i2 >= 200 && i2 < 300) {
            return success(t2, new ab.a().a(i2).a("Response.success()").a(Protocol.HTTP_1_1).a(new z.a().a("http://localhost/").b()).a());
        }
        throw new IllegalArgumentException("code < 200 or >= 300: " + i2);
    }

    public static <T> Response<T> success(T t2) {
        return success(t2, new ab.a().a(200).a("OK").a(Protocol.HTTP_1_1).a(new z.a().a("http://localhost/").b()).a());
    }

    public static <T> Response<T> success(T t2, ab abVar) {
        Objects.requireNonNull(abVar, "rawResponse == null");
        if (abVar.c()) {
            return new Response<>(abVar, t2, (ac) null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public static <T> Response<T> success(T t2, s sVar) {
        Objects.requireNonNull(sVar, "headers == null");
        return success(t2, new ab.a().a(200).a("OK").a(Protocol.HTTP_1_1).a(sVar).a(new z.a().a("http://localhost/").b()).a());
    }

    public T body() {
        return this.body;
    }

    public int code() {
        return this.rawResponse.b();
    }

    public ac errorBody() {
        return this.errorBody;
    }

    public s headers() {
        return this.rawResponse.f();
    }

    public boolean isSuccessful() {
        return this.rawResponse.c();
    }

    public String message() {
        return this.rawResponse.d();
    }

    public ab raw() {
        return this.rawResponse;
    }

    public String toString() {
        return this.rawResponse.toString();
    }
}
