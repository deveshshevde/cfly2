package com.bumptech.glide.load.data;

import bl.b;
import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class k implements e<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final RecyclableBufferedInputStream f10183a;

    public static final class a implements e.a<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final b f10184a;

        public a(b bVar) {
            this.f10184a = bVar;
        }

        public e<InputStream> a(InputStream inputStream) {
            return new k(inputStream, this.f10184a);
        }

        public Class<InputStream> a() {
            return InputStream.class;
        }
    }

    public k(InputStream inputStream, b bVar) {
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        this.f10183a = recyclableBufferedInputStream;
        recyclableBufferedInputStream.mark(5242880);
    }

    public void b() {
        this.f10183a.b();
    }

    /* renamed from: c */
    public InputStream a() throws IOException {
        this.f10183a.reset();
        return this.f10183a;
    }

    public void d() {
        this.f10183a.a();
    }
}
