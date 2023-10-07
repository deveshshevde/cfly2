package oj;

public interface b<T> {
    void onComplete();

    void onError(Throwable th);

    void onNext(T t2);

    void onSubscribe(c cVar);
}
