package androidx.work;

import android.os.Build;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    final Executor f5100a;

    /* renamed from: b  reason: collision with root package name */
    final Executor f5101b;

    /* renamed from: c  reason: collision with root package name */
    final s f5102c;

    /* renamed from: d  reason: collision with root package name */
    final i f5103d;

    /* renamed from: e  reason: collision with root package name */
    final n f5104e;

    /* renamed from: f  reason: collision with root package name */
    final g f5105f;

    /* renamed from: g  reason: collision with root package name */
    final String f5106g;

    /* renamed from: h  reason: collision with root package name */
    final int f5107h;

    /* renamed from: i  reason: collision with root package name */
    final int f5108i;

    /* renamed from: j  reason: collision with root package name */
    final int f5109j;

    /* renamed from: k  reason: collision with root package name */
    final int f5110k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f5111l;

    /* renamed from: androidx.work.a$a  reason: collision with other inner class name */
    public static final class C0044a {

        /* renamed from: a  reason: collision with root package name */
        Executor f5115a;

        /* renamed from: b  reason: collision with root package name */
        s f5116b;

        /* renamed from: c  reason: collision with root package name */
        i f5117c;

        /* renamed from: d  reason: collision with root package name */
        Executor f5118d;

        /* renamed from: e  reason: collision with root package name */
        n f5119e;

        /* renamed from: f  reason: collision with root package name */
        g f5120f;

        /* renamed from: g  reason: collision with root package name */
        String f5121g;

        /* renamed from: h  reason: collision with root package name */
        int f5122h = 4;

        /* renamed from: i  reason: collision with root package name */
        int f5123i = 0;

        /* renamed from: j  reason: collision with root package name */
        int f5124j = SubsamplingScaleImageView.TILE_SIZE_AUTO;

        /* renamed from: k  reason: collision with root package name */
        int f5125k = 20;

        public a a() {
            return new a(this);
        }
    }

    public interface b {
        a a();
    }

    a(C0044a aVar) {
        Executor executor;
        this.f5100a = aVar.f5115a == null ? a(false) : aVar.f5115a;
        if (aVar.f5118d == null) {
            this.f5111l = true;
            executor = a(true);
        } else {
            this.f5111l = false;
            executor = aVar.f5118d;
        }
        this.f5101b = executor;
        this.f5102c = aVar.f5116b == null ? s.a() : aVar.f5116b;
        this.f5103d = aVar.f5117c == null ? i.a() : aVar.f5117c;
        this.f5104e = aVar.f5119e == null ? new androidx.work.impl.a() : aVar.f5119e;
        this.f5107h = aVar.f5122h;
        this.f5108i = aVar.f5123i;
        this.f5109j = aVar.f5124j;
        this.f5110k = aVar.f5125k;
        this.f5105f = aVar.f5120f;
        this.f5106g = aVar.f5121g;
    }

    private Executor a(boolean z2) {
        return Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), b(z2));
    }

    private ThreadFactory b(final boolean z2) {
        return new ThreadFactory() {

            /* renamed from: c  reason: collision with root package name */
            private final AtomicInteger f5114c = new AtomicInteger(0);

            public Thread newThread(Runnable runnable) {
                String str = z2 ? "WM.task-" : "androidx.work-";
                return new Thread(runnable, str + this.f5114c.incrementAndGet());
            }
        };
    }

    public Executor a() {
        return this.f5100a;
    }

    public Executor b() {
        return this.f5101b;
    }

    public s c() {
        return this.f5102c;
    }

    public i d() {
        return this.f5103d;
    }

    public n e() {
        return this.f5104e;
    }

    public int f() {
        return this.f5107h;
    }

    public int g() {
        return this.f5108i;
    }

    public int h() {
        return this.f5109j;
    }

    public String i() {
        return this.f5106g;
    }

    public int j() {
        return Build.VERSION.SDK_INT == 23 ? this.f5110k / 2 : this.f5110k;
    }

    public g k() {
        return this.f5105f;
    }
}
