package io.reactivex;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.e;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.TimeUnit;

public abstract class i {

    /* renamed from: a  reason: collision with root package name */
    static final long f28683a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    static final class a implements io.reactivex.disposables.b, Runnable {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f28684a;

        /* renamed from: b  reason: collision with root package name */
        final c f28685b;

        /* renamed from: c  reason: collision with root package name */
        Thread f28686c;

        a(Runnable runnable, c cVar) {
            this.f28684a = runnable;
            this.f28685b = cVar;
        }

        public void dispose() {
            if (this.f28686c == Thread.currentThread()) {
                c cVar = this.f28685b;
                if (cVar instanceof e) {
                    ((e) cVar).b();
                    return;
                }
            }
            this.f28685b.dispose();
        }

        public boolean isDisposed() {
            return this.f28685b.isDisposed();
        }

        public void run() {
            this.f28686c = Thread.currentThread();
            try {
                this.f28684a.run();
            } finally {
                dispose();
                this.f28686c = null;
            }
        }
    }

    static final class b implements io.reactivex.disposables.b, Runnable {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f28687a;

        /* renamed from: b  reason: collision with root package name */
        final c f28688b;

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f28689c;

        b(Runnable runnable, c cVar) {
            this.f28687a = runnable;
            this.f28688b = cVar;
        }

        public void dispose() {
            this.f28689c = true;
            this.f28688b.dispose();
        }

        public boolean isDisposed() {
            return this.f28689c;
        }

        public void run() {
            if (!this.f28689c) {
                try {
                    this.f28687a.run();
                } catch (Throwable th) {
                    io.reactivex.exceptions.a.b(th);
                    this.f28688b.dispose();
                    throw ExceptionHelper.a(th);
                }
            }
        }
    }

    public static abstract class c implements io.reactivex.disposables.b {

        final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final Runnable f28690a;

            /* renamed from: b  reason: collision with root package name */
            final SequentialDisposable f28691b;

            /* renamed from: c  reason: collision with root package name */
            final long f28692c;

            /* renamed from: d  reason: collision with root package name */
            long f28693d;

            /* renamed from: e  reason: collision with root package name */
            long f28694e;

            /* renamed from: f  reason: collision with root package name */
            long f28695f;

            a(long j2, Runnable runnable, long j3, SequentialDisposable sequentialDisposable, long j4) {
                this.f28690a = runnable;
                this.f28691b = sequentialDisposable;
                this.f28692c = j4;
                this.f28694e = j3;
                this.f28695f = j2;
            }

            public void run() {
                long j2;
                this.f28690a.run();
                if (!this.f28691b.isDisposed()) {
                    long a2 = c.this.a(TimeUnit.NANOSECONDS);
                    long j3 = this.f28694e;
                    if (i.f28683a + a2 < j3 || a2 >= j3 + this.f28692c + i.f28683a) {
                        long j4 = this.f28692c;
                        long j5 = a2 + j4;
                        long j6 = this.f28693d + 1;
                        this.f28693d = j6;
                        this.f28695f = j5 - (j4 * j6);
                        j2 = j5;
                    } else {
                        long j7 = this.f28695f;
                        long j8 = this.f28693d + 1;
                        this.f28693d = j8;
                        j2 = j7 + (j8 * this.f28692c);
                    }
                    this.f28694e = a2;
                    this.f28691b.a(c.this.a(this, j2 - a2, TimeUnit.NANOSECONDS));
                }
            }
        }

        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public io.reactivex.disposables.b a(Runnable runnable) {
            return a(runnable, 0, TimeUnit.NANOSECONDS);
        }

        public io.reactivex.disposables.b a(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
            long j4 = j2;
            TimeUnit timeUnit2 = timeUnit;
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable a2 = ly.a.a(runnable);
            long nanos = timeUnit2.toNanos(j3);
            long a3 = a(TimeUnit.NANOSECONDS);
            SequentialDisposable sequentialDisposable3 = sequentialDisposable;
            a aVar = r0;
            a aVar2 = new a(a3 + timeUnit2.toNanos(j4), a2, a3, sequentialDisposable2, nanos);
            io.reactivex.disposables.b a4 = a(aVar, j4, timeUnit2);
            if (a4 == EmptyDisposable.INSTANCE) {
                return a4;
            }
            sequentialDisposable3.a(a4);
            return sequentialDisposable2;
        }

        public abstract io.reactivex.disposables.b a(Runnable runnable, long j2, TimeUnit timeUnit);
    }

    public io.reactivex.disposables.b a(Runnable runnable) {
        return a(runnable, 0, TimeUnit.NANOSECONDS);
    }

    public io.reactivex.disposables.b a(Runnable runnable, long j2, long j3, TimeUnit timeUnit) {
        c a2 = a();
        b bVar = new b(ly.a.a(runnable), a2);
        io.reactivex.disposables.b a3 = a2.a(bVar, j2, j3, timeUnit);
        return a3 == EmptyDisposable.INSTANCE ? a3 : bVar;
    }

    public io.reactivex.disposables.b a(Runnable runnable, long j2, TimeUnit timeUnit) {
        c a2 = a();
        a aVar = new a(ly.a.a(runnable), a2);
        a2.a(aVar, j2, timeUnit);
        return aVar;
    }

    public abstract c a();

    public void b() {
    }
}
