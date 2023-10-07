package lz;

import io.reactivex.i;
import java.util.concurrent.Callable;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final i f31034a = ly.a.d(new h());

    /* renamed from: b  reason: collision with root package name */
    static final i f31035b = ly.a.a((Callable<i>) new b());

    /* renamed from: c  reason: collision with root package name */
    static final i f31036c = ly.a.b((Callable<i>) new c());

    /* renamed from: d  reason: collision with root package name */
    static final i f31037d = io.reactivex.internal.schedulers.h.c();

    /* renamed from: e  reason: collision with root package name */
    static final i f31038e = ly.a.c((Callable<i>) new f());

    /* renamed from: lz.a$a  reason: collision with other inner class name */
    static final class C0223a {

        /* renamed from: a  reason: collision with root package name */
        static final i f31039a = new io.reactivex.internal.schedulers.a();
    }

    static final class b implements Callable<i> {
        b() {
        }

        /* renamed from: a */
        public i call() throws Exception {
            return C0223a.f31039a;
        }
    }

    static final class c implements Callable<i> {
        c() {
        }

        /* renamed from: a */
        public i call() throws Exception {
            return d.f31040a;
        }
    }

    static final class d {

        /* renamed from: a  reason: collision with root package name */
        static final i f31040a = new io.reactivex.internal.schedulers.c();
    }

    static final class e {

        /* renamed from: a  reason: collision with root package name */
        static final i f31041a = new io.reactivex.internal.schedulers.d();
    }

    static final class f implements Callable<i> {
        f() {
        }

        /* renamed from: a */
        public i call() throws Exception {
            return e.f31041a;
        }
    }

    static final class g {

        /* renamed from: a  reason: collision with root package name */
        static final i f31042a = new io.reactivex.internal.schedulers.g();
    }

    static final class h implements Callable<i> {
        h() {
        }

        /* renamed from: a */
        public i call() throws Exception {
            return g.f31042a;
        }
    }

    public static i a() {
        return ly.a.a(f31035b);
    }

    public static i b() {
        return ly.a.b(f31036c);
    }
}
