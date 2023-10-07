package ok;

import java.util.Objects;
import ok.e;
import or.d;
import ot.e;

public class a {

    /* renamed from: a  reason: collision with root package name */
    static final a f31769a = a((C0234a) new C0234a() {
        /* renamed from: a */
        public void call(b bVar) {
            bVar.a(e.b());
            bVar.a();
        }
    });

    /* renamed from: b  reason: collision with root package name */
    static final a f31770b = a((C0234a) new C0234a() {
        /* renamed from: a */
        public void call(b bVar) {
            bVar.a(e.b());
        }
    });

    /* renamed from: c  reason: collision with root package name */
    static final or.a f31771c = d.a().b();

    /* renamed from: d  reason: collision with root package name */
    private final C0234a f31772d;

    /* renamed from: ok.a$a  reason: collision with other inner class name */
    public interface C0234a extends on.b<b> {
    }

    public interface b {
        void a();

        void a(Throwable th);

        void a(i iVar);
    }

    protected a(C0234a aVar) {
        this.f31772d = aVar;
    }

    static NullPointerException a(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    static <T> T a(T t2) {
        Objects.requireNonNull(t2);
        return t2;
    }

    public static a a(C0234a aVar) {
        a(aVar);
        try {
            return new a(aVar);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            f31771c.a(th);
            throw a(th);
        }
    }

    public final a a(final e eVar) {
        a(eVar);
        return a((C0234a) new C0234a() {
            /* renamed from: a */
            public void call(final b bVar) {
                final e.a a2 = eVar.a();
                a2.a(new on.a() {
                    public void call() {
                        try {
                            a.this.a(bVar);
                        } finally {
                            a2.unsubscribe();
                        }
                    }
                });
            }
        });
    }

    public final void a(b bVar) {
        a(bVar);
        try {
            this.f31772d.call(bVar);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            f31771c.a(th);
            rx.exceptions.a.a(th);
            throw a(th);
        }
    }
}
