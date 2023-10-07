package y;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Choreographer;
import j.g;
import java.util.ArrayList;

class a {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<a> f34629a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    final ArrayList<b> f34630b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    long f34631c = 0;

    /* renamed from: d  reason: collision with root package name */
    private final g<b, Long> f34632d = new g<>();

    /* renamed from: e  reason: collision with root package name */
    private final C0265a f34633e = new C0265a();

    /* renamed from: f  reason: collision with root package name */
    private c f34634f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f34635g = false;

    /* renamed from: y.a$a  reason: collision with other inner class name */
    class C0265a {
        C0265a() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            a.this.f34631c = SystemClock.uptimeMillis();
            a aVar = a.this;
            aVar.a(aVar.f34631c);
            if (a.this.f34630b.size() > 0) {
                a.this.b().a();
            }
        }
    }

    interface b {
        boolean a(long j2);
    }

    static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        final C0265a f34637a;

        c(C0265a aVar) {
            this.f34637a = aVar;
        }

        /* access modifiers changed from: package-private */
        public abstract void a();
    }

    private static class d extends c {

        /* renamed from: b  reason: collision with root package name */
        long f34638b = -1;

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f34639c = new Runnable() {
            public void run() {
                d.this.f34638b = SystemClock.uptimeMillis();
                d.this.f34637a.a();
            }
        };

        /* renamed from: d  reason: collision with root package name */
        private final Handler f34640d = new Handler(Looper.myLooper());

        d(C0265a aVar) {
            super(aVar);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f34640d.postDelayed(this.f34639c, Math.max(10 - (SystemClock.uptimeMillis() - this.f34638b), 0));
        }
    }

    private static class e extends c {

        /* renamed from: b  reason: collision with root package name */
        private final Choreographer f34642b = Choreographer.getInstance();

        /* renamed from: c  reason: collision with root package name */
        private final Choreographer.FrameCallback f34643c = new Choreographer.FrameCallback() {
            public void doFrame(long j2) {
                e.this.f34637a.a();
            }
        };

        e(C0265a aVar) {
            super(aVar);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f34642b.postFrameCallback(this.f34643c);
        }
    }

    a() {
    }

    public static a a() {
        ThreadLocal<a> threadLocal = f34629a;
        if (threadLocal.get() == null) {
            threadLocal.set(new a());
        }
        return threadLocal.get();
    }

    private boolean b(b bVar, long j2) {
        Long l2 = this.f34632d.get(bVar);
        if (l2 == null) {
            return true;
        }
        if (l2.longValue() >= j2) {
            return false;
        }
        this.f34632d.remove(bVar);
        return true;
    }

    private void c() {
        if (this.f34635g) {
            for (int size = this.f34630b.size() - 1; size >= 0; size--) {
                if (this.f34630b.get(size) == null) {
                    this.f34630b.remove(size);
                }
            }
            this.f34635g = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(long j2) {
        long uptimeMillis = SystemClock.uptimeMillis();
        for (int i2 = 0; i2 < this.f34630b.size(); i2++) {
            b bVar = this.f34630b.get(i2);
            if (bVar != null && b(bVar, uptimeMillis)) {
                bVar.a(j2);
            }
        }
        c();
    }

    public void a(b bVar) {
        this.f34632d.remove(bVar);
        int indexOf = this.f34630b.indexOf(bVar);
        if (indexOf >= 0) {
            this.f34630b.set(indexOf, (Object) null);
            this.f34635g = true;
        }
    }

    public void a(b bVar, long j2) {
        if (this.f34630b.size() == 0) {
            b().a();
        }
        if (!this.f34630b.contains(bVar)) {
            this.f34630b.add(bVar);
        }
        if (j2 > 0) {
            this.f34632d.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j2));
        }
    }

    /* access modifiers changed from: package-private */
    public c b() {
        if (this.f34634f == null) {
            this.f34634f = Build.VERSION.SDK_INT >= 16 ? new e(this.f34633e) : new d(this.f34633e);
        }
        return this.f34634f;
    }
}
