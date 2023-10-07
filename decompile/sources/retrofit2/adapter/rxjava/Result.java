package retrofit2.adapter.rxjava;

import java.util.Objects;
import retrofit2.Response;

public final class Result<T> {
    private final Throwable error;
    private final Response<T> response;

    private Result(Response<T> response2, Throwable th) {
        this.response = response2;
        this.error = th;
    }

    public static <T> Result<T> error(Throwable th) {
        Objects.requireNonNull(th, "error == null");
        return new Result<>((Response) null, th);
    }

    public static <T> Result<T> response(Response<T> response2) {
        Objects.requireNonNull(response2, "response == null");
        return new Result<>(response2, (Throwable) null);
    }

    public Throwable error() {
        return this.error;
    }

    public boolean isError() {
        return this.error != null;
    }

    public Response<T> response() {
        return this.response;
    }
}
