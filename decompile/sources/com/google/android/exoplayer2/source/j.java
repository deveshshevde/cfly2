package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.upstream.h;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public interface j {

    /* renamed from: com.google.android.exoplayer2.source.j$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$a(j jVar, int i2, i.a aVar) {
        }

        public static void $default$a(j jVar, int i2, i.a aVar, b bVar, c cVar) {
        }

        public static void $default$a(j jVar, int i2, i.a aVar, b bVar, c cVar, IOException iOException, boolean z2) {
        }

        public static void $default$a(j jVar, int i2, i.a aVar, c cVar) {
        }

        public static void $default$b(j jVar, int i2, i.a aVar) {
        }

        public static void $default$b(j jVar, int i2, i.a aVar, b bVar, c cVar) {
        }

        public static void $default$b(j jVar, int i2, i.a aVar, c cVar) {
        }

        public static void $default$c(j jVar, int i2, i.a aVar) {
        }

        public static void $default$c(j jVar, int i2, i.a aVar, b bVar, c cVar) {
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f16372a;

        /* renamed from: b  reason: collision with root package name */
        public final i.a f16373b;

        /* renamed from: c  reason: collision with root package name */
        private final CopyOnWriteArrayList<C0114a> f16374c;

        /* renamed from: d  reason: collision with root package name */
        private final long f16375d;

        /* renamed from: com.google.android.exoplayer2.source.j$a$a  reason: collision with other inner class name */
        private static final class C0114a {

            /* renamed from: a  reason: collision with root package name */
            public final Handler f16376a;

            /* renamed from: b  reason: collision with root package name */
            public final j f16377b;

            public C0114a(Handler handler, j jVar) {
                this.f16376a = handler;
                this.f16377b = jVar;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, (i.a) null, 0);
        }

        private a(CopyOnWriteArrayList<C0114a> copyOnWriteArrayList, int i2, i.a aVar, long j2) {
            this.f16374c = copyOnWriteArrayList;
            this.f16372a = i2;
            this.f16373b = aVar;
            this.f16375d = j2;
        }

        private long a(long j2) {
            long a2 = e.a(j2);
            if (a2 == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.f16375d + a2;
        }

        private void a(Handler handler, Runnable runnable) {
            if (handler.getLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                handler.post(runnable);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(j jVar, i.a aVar) {
            jVar.c(this.f16372a, aVar);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(j jVar, i.a aVar, c cVar) {
            jVar.a(this.f16372a, aVar, cVar);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(j jVar, b bVar, c cVar) {
            jVar.c(this.f16372a, this.f16373b, bVar, cVar);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(j jVar, b bVar, c cVar, IOException iOException, boolean z2) {
            jVar.a(this.f16372a, this.f16373b, bVar, cVar, iOException, z2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(j jVar, c cVar) {
            jVar.b(this.f16372a, this.f16373b, cVar);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(j jVar, i.a aVar) {
            jVar.b(this.f16372a, aVar);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(j jVar, b bVar, c cVar) {
            jVar.b(this.f16372a, this.f16373b, bVar, cVar);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(j jVar, i.a aVar) {
            jVar.a(this.f16372a, aVar);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(j jVar, b bVar, c cVar) {
            jVar.a(this.f16372a, this.f16373b, bVar, cVar);
        }

        public a a(int i2, i.a aVar, long j2) {
            return new a(this.f16374c, i2, aVar, j2);
        }

        public void a() {
            i.a aVar = (i.a) com.google.android.exoplayer2.util.a.b(this.f16373b);
            Iterator<C0114a> it2 = this.f16374c.iterator();
            while (it2.hasNext()) {
                C0114a next = it2.next();
                a(next.f16376a, (Runnable) new Runnable(next.f16377b, aVar) {
                    public final /* synthetic */ j f$1;
                    public final /* synthetic */ i.a f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        j.a.this.c(this.f$1, this.f$2);
                    }
                });
            }
        }

        public void a(int i2, long j2, long j3) {
            long j4 = j2;
            a(new c(1, i2, (Format) null, 3, (Object) null, a(j2), a(j3)));
        }

        public void a(int i2, Format format, int i3, Object obj, long j2) {
            b(new c(1, i2, format, i3, obj, a(j2), -9223372036854775807L));
        }

        public void a(Handler handler, j jVar) {
            com.google.android.exoplayer2.util.a.a((handler == null || jVar == null) ? false : true);
            this.f16374c.add(new C0114a(handler, jVar));
        }

        public void a(b bVar, c cVar) {
            Iterator<C0114a> it2 = this.f16374c.iterator();
            while (it2.hasNext()) {
                C0114a next = it2.next();
                a(next.f16376a, (Runnable) new Runnable(next.f16377b, bVar, cVar) {
                    public final /* synthetic */ j f$1;
                    public final /* synthetic */ j.b f$2;
                    public final /* synthetic */ j.c f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void run() {
                        j.a.this.c(this.f$1, this.f$2, this.f$3);
                    }
                });
            }
        }

        public void a(b bVar, c cVar, IOException iOException, boolean z2) {
            Iterator<C0114a> it2 = this.f16374c.iterator();
            while (it2.hasNext()) {
                C0114a next = it2.next();
                a(next.f16376a, (Runnable) new Runnable(next.f16377b, bVar, cVar, iOException, z2) {
                    public final /* synthetic */ j f$1;
                    public final /* synthetic */ j.b f$2;
                    public final /* synthetic */ j.c f$3;
                    public final /* synthetic */ IOException f$4;
                    public final /* synthetic */ boolean f$5;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                        this.f$4 = r5;
                        this.f$5 = r6;
                    }

                    public final void run() {
                        j.a.this.a(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
                    }
                });
            }
        }

        public void a(c cVar) {
            i.a aVar = (i.a) com.google.android.exoplayer2.util.a.b(this.f16373b);
            Iterator<C0114a> it2 = this.f16374c.iterator();
            while (it2.hasNext()) {
                C0114a next = it2.next();
                a(next.f16376a, (Runnable) new Runnable(next.f16377b, aVar, cVar) {
                    public final /* synthetic */ j f$1;
                    public final /* synthetic */ i.a f$2;
                    public final /* synthetic */ j.c f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void run() {
                        j.a.this.a(this.f$1, this.f$2, this.f$3);
                    }
                });
            }
        }

        public void a(j jVar) {
            Iterator<C0114a> it2 = this.f16374c.iterator();
            while (it2.hasNext()) {
                C0114a next = it2.next();
                if (next.f16377b == jVar) {
                    this.f16374c.remove(next);
                }
            }
        }

        public void a(h hVar, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4) {
            h hVar2 = hVar;
            a(new b(hVar2, hVar2.f16995a, Collections.emptyMap(), j4, 0, 0), new c(i2, i3, format, i4, obj, a(j2), a(j3)));
        }

        public void a(h hVar, int i2, long j2) {
            a(hVar, i2, -1, (Format) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L, j2);
        }

        public void a(h hVar, Uri uri, Map<String, List<String>> map, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6) {
            b(new b(hVar, uri, map, j4, j5, j6), new c(i2, i3, format, i4, obj, a(j2), a(j3)));
        }

        public void a(h hVar, Uri uri, Map<String, List<String>> map, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6, IOException iOException, boolean z2) {
            a(new b(hVar, uri, map, j4, j5, j6), new c(i2, i3, format, i4, obj, a(j2), a(j3)), iOException, z2);
        }

        public void a(h hVar, Uri uri, Map<String, List<String>> map, int i2, long j2, long j3, long j4) {
            a(hVar, uri, map, i2, -1, (Format) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L, j2, j3, j4);
        }

        public void a(h hVar, Uri uri, Map<String, List<String>> map, int i2, long j2, long j3, long j4, IOException iOException, boolean z2) {
            a(hVar, uri, map, i2, -1, (Format) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L, j2, j3, j4, iOException, z2);
        }

        public void b() {
            i.a aVar = (i.a) com.google.android.exoplayer2.util.a.b(this.f16373b);
            Iterator<C0114a> it2 = this.f16374c.iterator();
            while (it2.hasNext()) {
                C0114a next = it2.next();
                a(next.f16376a, (Runnable) new Runnable(next.f16377b, aVar) {
                    public final /* synthetic */ j f$1;
                    public final /* synthetic */ i.a f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        j.a.this.b(this.f$1, this.f$2);
                    }
                });
            }
        }

        public void b(b bVar, c cVar) {
            Iterator<C0114a> it2 = this.f16374c.iterator();
            while (it2.hasNext()) {
                C0114a next = it2.next();
                a(next.f16376a, (Runnable) new Runnable(next.f16377b, bVar, cVar) {
                    public final /* synthetic */ j f$1;
                    public final /* synthetic */ j.b f$2;
                    public final /* synthetic */ j.c f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void run() {
                        j.a.this.b(this.f$1, this.f$2, this.f$3);
                    }
                });
            }
        }

        public void b(c cVar) {
            Iterator<C0114a> it2 = this.f16374c.iterator();
            while (it2.hasNext()) {
                C0114a next = it2.next();
                a(next.f16376a, (Runnable) new Runnable(next.f16377b, cVar) {
                    public final /* synthetic */ j f$1;
                    public final /* synthetic */ j.c f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        j.a.this.a(this.f$1, this.f$2);
                    }
                });
            }
        }

        public void b(h hVar, Uri uri, Map<String, List<String>> map, int i2, int i3, Format format, int i4, Object obj, long j2, long j3, long j4, long j5, long j6) {
            c(new b(hVar, uri, map, j4, j5, j6), new c(i2, i3, format, i4, obj, a(j2), a(j3)));
        }

        public void b(h hVar, Uri uri, Map<String, List<String>> map, int i2, long j2, long j3, long j4) {
            b(hVar, uri, map, i2, -1, (Format) null, 0, (Object) null, -9223372036854775807L, -9223372036854775807L, j2, j3, j4);
        }

        public void c() {
            i.a aVar = (i.a) com.google.android.exoplayer2.util.a.b(this.f16373b);
            Iterator<C0114a> it2 = this.f16374c.iterator();
            while (it2.hasNext()) {
                C0114a next = it2.next();
                a(next.f16376a, (Runnable) new Runnable(next.f16377b, aVar) {
                    public final /* synthetic */ j f$1;
                    public final /* synthetic */ i.a f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        j.a.this.a(this.f$1, this.f$2);
                    }
                });
            }
        }

        public void c(b bVar, c cVar) {
            Iterator<C0114a> it2 = this.f16374c.iterator();
            while (it2.hasNext()) {
                C0114a next = it2.next();
                a(next.f16376a, (Runnable) new Runnable(next.f16377b, bVar, cVar) {
                    public final /* synthetic */ j f$1;
                    public final /* synthetic */ j.b f$2;
                    public final /* synthetic */ j.c f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                    }

                    public final void run() {
                        j.a.this.a(this.f$1, this.f$2, this.f$3);
                    }
                });
            }
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final h f16378a;

        /* renamed from: b  reason: collision with root package name */
        public final Uri f16379b;

        /* renamed from: c  reason: collision with root package name */
        public final Map<String, List<String>> f16380c;

        /* renamed from: d  reason: collision with root package name */
        public final long f16381d;

        /* renamed from: e  reason: collision with root package name */
        public final long f16382e;

        /* renamed from: f  reason: collision with root package name */
        public final long f16383f;

        public b(h hVar, Uri uri, Map<String, List<String>> map, long j2, long j3, long j4) {
            this.f16378a = hVar;
            this.f16379b = uri;
            this.f16380c = map;
            this.f16381d = j2;
            this.f16382e = j3;
            this.f16383f = j4;
        }
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f16384a;

        /* renamed from: b  reason: collision with root package name */
        public final int f16385b;

        /* renamed from: c  reason: collision with root package name */
        public final Format f16386c;

        /* renamed from: d  reason: collision with root package name */
        public final int f16387d;

        /* renamed from: e  reason: collision with root package name */
        public final Object f16388e;

        /* renamed from: f  reason: collision with root package name */
        public final long f16389f;

        /* renamed from: g  reason: collision with root package name */
        public final long f16390g;

        public c(int i2, int i3, Format format, int i4, Object obj, long j2, long j3) {
            this.f16384a = i2;
            this.f16385b = i3;
            this.f16386c = format;
            this.f16387d = i4;
            this.f16388e = obj;
            this.f16389f = j2;
            this.f16390g = j3;
        }
    }

    void a(int i2, i.a aVar);

    void a(int i2, i.a aVar, b bVar, c cVar);

    void a(int i2, i.a aVar, b bVar, c cVar, IOException iOException, boolean z2);

    void a(int i2, i.a aVar, c cVar);

    void b(int i2, i.a aVar);

    void b(int i2, i.a aVar, b bVar, c cVar);

    void b(int i2, i.a aVar, c cVar);

    void c(int i2, i.a aVar);

    void c(int i2, i.a aVar, b bVar, c cVar);
}
