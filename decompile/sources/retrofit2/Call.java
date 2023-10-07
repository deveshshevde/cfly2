package retrofit2;

import java.io.IOException;
import okhttp3.z;
import okio.s;

public interface Call<T> extends Cloneable {
    void cancel();

    Call<T> clone();

    void enqueue(Callback<T> callback);

    Response<T> execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    z request();

    s timeout();
}
