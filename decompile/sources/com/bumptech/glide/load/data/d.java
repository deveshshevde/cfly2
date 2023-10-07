package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

public interface d<T> {

    public interface a<T> {
        void a(Exception exc);

        void a(T t2);
    }

    Class<T> a();

    void a(Priority priority, a<? super T> aVar);

    void b();

    void c();

    DataSource d();
}
