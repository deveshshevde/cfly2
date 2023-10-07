package ok;

public interface c<T> {
    void onCompleted();

    void onError(Throwable th);

    void onNext(T t2);
}
