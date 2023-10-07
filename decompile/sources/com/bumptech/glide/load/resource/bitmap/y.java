package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import cc.l;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;

public final class y implements g<Bitmap, Bitmap> {

    private static final class a implements s<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        private final Bitmap f10526a;

        a(Bitmap bitmap) {
            this.f10526a = bitmap;
        }

        /* renamed from: a */
        public Bitmap d() {
            return this.f10526a;
        }

        public Class<Bitmap> c() {
            return Bitmap.class;
        }

        public int e() {
            return l.a(this.f10526a);
        }

        public void f() {
        }
    }

    public s<Bitmap> a(Bitmap bitmap, int i2, int i3, f fVar) {
        return new a(bitmap);
    }

    public boolean a(Bitmap bitmap, f fVar) {
        return true;
    }
}
