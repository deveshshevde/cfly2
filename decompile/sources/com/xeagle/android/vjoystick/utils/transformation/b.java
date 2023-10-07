package com.xeagle.android.vjoystick.utils.transformation;

import bo.g;
import bo.n;
import bo.o;
import bo.r;
import com.bumptech.glide.load.f;
import java.io.InputStream;
import okhttp3.e;
import okhttp3.x;

public class b implements n<g, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final e.a f25390a;

    public static class a implements o<g, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private static volatile e.a f25391a;

        /* renamed from: b  reason: collision with root package name */
        private final e.a f25392b;

        public a() {
            this(b());
        }

        public a(e.a aVar) {
            this.f25392b = aVar;
        }

        private static e.a b() {
            if (f25391a == null) {
                synchronized (a.class) {
                    if (f25391a == null) {
                        f25391a = new x();
                    }
                }
            }
            return f25391a;
        }

        public n<g, InputStream> a(r rVar) {
            return new b(this.f25392b);
        }

        public void a() {
        }
    }

    public b(e.a aVar) {
        this.f25390a = aVar;
    }

    public n.a<InputStream> a(g gVar, int i2, int i3, f fVar) {
        return new n.a<>(gVar, new a(this.f25390a, gVar));
    }

    public boolean a(g gVar) {
        return true;
    }
}
