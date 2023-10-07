package androidx.work;

import android.content.Context;
import androidx.work.impl.utils.futures.b;
import java.util.UUID;
import java.util.concurrent.Executor;

public abstract class ListenableWorker {

    /* renamed from: a  reason: collision with root package name */
    private Context f5054a;

    /* renamed from: b  reason: collision with root package name */
    private WorkerParameters f5055b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f5056c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5057d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5058e;

    public static abstract class a {

        /* renamed from: androidx.work.ListenableWorker$a$a  reason: collision with other inner class name */
        public static final class C0043a extends a {

            /* renamed from: a  reason: collision with root package name */
            private final d f5059a;

            public C0043a() {
                this(d.f5146a);
            }

            public C0043a(d dVar) {
                this.f5059a = dVar;
            }

            public d d() {
                return this.f5059a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                return this.f5059a.equals(((C0043a) obj).f5059a);
            }

            public int hashCode() {
                return 28070863 + this.f5059a.hashCode();
            }

            public String toString() {
                return "Failure {mOutputData=" + this.f5059a + '}';
            }
        }

        public static final class b extends a {
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass();
            }

            public int hashCode() {
                return 1386378834;
            }

            public String toString() {
                return "Retry";
            }
        }

        public static final class c extends a {

            /* renamed from: a  reason: collision with root package name */
            private final d f5060a;

            public c() {
                this(d.f5146a);
            }

            public c(d dVar) {
                this.f5060a = dVar;
            }

            public d d() {
                return this.f5060a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }
                return this.f5060a.equals(((c) obj).f5060a);
            }

            public int hashCode() {
                return 28070925 + this.f5060a.hashCode();
            }

            public String toString() {
                return "Success {mOutputData=" + this.f5060a + '}';
            }
        }

        a() {
        }

        public static a a() {
            return new c();
        }

        public static a a(d dVar) {
            return new c(dVar);
        }

        public static a b() {
            return new b();
        }

        public static a c() {
            return new C0043a();
        }
    }

    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        } else if (workerParameters != null) {
            this.f5054a = context;
            this.f5055b = workerParameters;
        } else {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
    }

    public final Context a() {
        return this.f5054a;
    }

    public void a(boolean z2) {
        this.f5058e = z2;
    }

    public final UUID b() {
        return this.f5055b.a();
    }

    public final d c() {
        return this.f5055b.b();
    }

    public abstract gz.a<a> d();

    public gz.a<e> e() {
        b d2 = b.d();
        d2.a((Throwable) new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return d2;
    }

    public final boolean f() {
        return this.f5056c;
    }

    public final void g() {
        this.f5056c = true;
        h();
    }

    public void h() {
    }

    public final boolean i() {
        return this.f5057d;
    }

    public final void j() {
        this.f5057d = true;
    }

    public boolean k() {
        return this.f5058e;
    }

    public Executor l() {
        return this.f5055b.c();
    }

    public ap.a m() {
        return this.f5055b.d();
    }

    public s n() {
        return this.f5055b.e();
    }
}
