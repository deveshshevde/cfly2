package com.google.android.exoplayer2.source;

import android.os.Handler;
import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.upstream.t;
import java.io.IOException;

public interface i {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Object f16367a;

        /* renamed from: b  reason: collision with root package name */
        public final int f16368b;

        /* renamed from: c  reason: collision with root package name */
        public final int f16369c;

        /* renamed from: d  reason: collision with root package name */
        public final long f16370d;

        /* renamed from: e  reason: collision with root package name */
        public final int f16371e;

        public a(Object obj) {
            this(obj, -1);
        }

        public a(Object obj, int i2, int i3, long j2) {
            this(obj, i2, i3, j2, -1);
        }

        private a(Object obj, int i2, int i3, long j2, int i4) {
            this.f16367a = obj;
            this.f16368b = i2;
            this.f16369c = i3;
            this.f16370d = j2;
            this.f16371e = i4;
        }

        public a(Object obj, long j2) {
            this(obj, -1, -1, j2, -1);
        }

        public a(Object obj, long j2, int i2) {
            this(obj, -1, -1, j2, i2);
        }

        public boolean a() {
            return this.f16368b != -1;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f16367a.equals(aVar.f16367a) && this.f16368b == aVar.f16368b && this.f16369c == aVar.f16369c && this.f16370d == aVar.f16370d && this.f16371e == aVar.f16371e;
        }

        public int hashCode() {
            return ((((((((527 + this.f16367a.hashCode()) * 31) + this.f16368b) * 31) + this.f16369c) * 31) + ((int) this.f16370d)) * 31) + this.f16371e;
        }
    }

    public interface b {
        void a(i iVar, af afVar);
    }

    h a(a aVar, com.google.android.exoplayer2.upstream.b bVar, long j2);

    void a(Handler handler, j jVar);

    void a(h hVar);

    void a(b bVar, t tVar);

    void a(j jVar);

    void c(b bVar);

    void d() throws IOException;
}
