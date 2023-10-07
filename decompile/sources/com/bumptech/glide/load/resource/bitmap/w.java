package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import bl.b;
import bl.e;
import cc.d;
import cc.i;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.resource.bitmap.k;
import java.io.IOException;
import java.io.InputStream;

public class w implements g<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final k f10516a;

    /* renamed from: b  reason: collision with root package name */
    private final b f10517b;

    static class a implements k.a {

        /* renamed from: a  reason: collision with root package name */
        private final RecyclableBufferedInputStream f10518a;

        /* renamed from: b  reason: collision with root package name */
        private final d f10519b;

        a(RecyclableBufferedInputStream recyclableBufferedInputStream, d dVar) {
            this.f10518a = recyclableBufferedInputStream;
            this.f10519b = dVar;
        }

        public void a() {
            this.f10518a.a();
        }

        public void a(e eVar, Bitmap bitmap) throws IOException {
            IOException a2 = this.f10519b.a();
            if (a2 != null) {
                if (bitmap != null) {
                    eVar.a(bitmap);
                }
                throw a2;
            }
        }
    }

    public w(k kVar, b bVar) {
        this.f10516a = kVar;
        this.f10517b = bVar;
    }

    public s<Bitmap> a(InputStream inputStream, int i2, int i3, f fVar) throws IOException {
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z2;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z2 = false;
        } else {
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.f10517b);
            z2 = true;
        }
        d a2 = d.a(recyclableBufferedInputStream);
        try {
            return this.f10516a.a((InputStream) new i(a2), i2, i3, fVar, (k.a) new a(recyclableBufferedInputStream, a2));
        } finally {
            a2.b();
            if (z2) {
                recyclableBufferedInputStream.b();
            }
        }
    }

    public boolean a(InputStream inputStream, f fVar) {
        return this.f10516a.a(inputStream);
    }
}
