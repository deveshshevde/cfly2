package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.data.d;

interface e {

    public interface a {
        void a(c cVar, Exception exc, d<?> dVar, DataSource dataSource);

        void a(c cVar, Object obj, d<?> dVar, DataSource dataSource, c cVar2);

        void c();
    }

    boolean a();

    void b();
}
