package lw;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.Comparator;
import java.util.concurrent.Callable;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final lv.e<Object, Object> f31009a = new g();

    /* renamed from: b  reason: collision with root package name */
    public static final Runnable f31010b = new d();

    /* renamed from: c  reason: collision with root package name */
    public static final lv.a f31011c = new C0222a();

    /* renamed from: d  reason: collision with root package name */
    static final lv.d<Object> f31012d = new b();

    /* renamed from: e  reason: collision with root package name */
    public static final lv.d<Throwable> f31013e = new e();

    /* renamed from: f  reason: collision with root package name */
    public static final lv.d<Throwable> f31014f = new k();

    /* renamed from: g  reason: collision with root package name */
    public static final lv.f f31015g = new c();

    /* renamed from: h  reason: collision with root package name */
    static final lv.g<Object> f31016h = new l();

    /* renamed from: i  reason: collision with root package name */
    static final lv.g<Object> f31017i = new f();

    /* renamed from: j  reason: collision with root package name */
    static final Callable<Object> f31018j = new j();

    /* renamed from: k  reason: collision with root package name */
    static final Comparator<Object> f31019k = new i();

    /* renamed from: l  reason: collision with root package name */
    public static final lv.d<oj.c> f31020l = new h();

    /* renamed from: lw.a$a  reason: collision with other inner class name */
    static final class C0222a implements lv.a {
        C0222a() {
        }

        public void a() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    static final class b implements lv.d<Object> {
        b() {
        }

        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    static final class c implements lv.f {
        c() {
        }
    }

    static final class d implements Runnable {
        d() {
        }

        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    static final class e implements lv.d<Throwable> {
        e() {
        }

        /* renamed from: a */
        public void accept(Throwable th) {
            ly.a.a(th);
        }
    }

    static final class f implements lv.g<Object> {
        f() {
        }
    }

    static final class g implements lv.e<Object, Object> {
        g() {
        }

        public Object a(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    static final class h implements lv.d<oj.c> {
        h() {
        }

        /* renamed from: a */
        public void accept(oj.c cVar) throws Exception {
            cVar.a(Long.MAX_VALUE);
        }
    }

    static final class i implements Comparator<Object> {
        i() {
        }

        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    static final class j implements Callable<Object> {
        j() {
        }

        public Object call() {
            return null;
        }
    }

    static final class k implements lv.d<Throwable> {
        k() {
        }

        /* renamed from: a */
        public void accept(Throwable th) {
            ly.a.a((Throwable) new OnErrorNotImplementedException(th));
        }
    }

    static final class l implements lv.g<Object> {
        l() {
        }
    }

    public static <T> lv.d<T> a() {
        return f31012d;
    }
}
