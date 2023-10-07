package androidx.loader.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.os.OperationCanceledException;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import s.g;

public abstract class a<D> extends c<D> {

    /* renamed from: a  reason: collision with root package name */
    volatile a<D>.a f3688a;

    /* renamed from: b  reason: collision with root package name */
    volatile a<D>.a f3689b;

    /* renamed from: c  reason: collision with root package name */
    long f3690c;

    /* renamed from: d  reason: collision with root package name */
    long f3691d;

    /* renamed from: e  reason: collision with root package name */
    Handler f3692e;

    /* renamed from: f  reason: collision with root package name */
    private final Executor f3693f;

    /* renamed from: androidx.loader.content.a$a  reason: collision with other inner class name */
    final class C0030a extends ModernAsyncTask<Void, Void, D> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        boolean f3694a;

        /* renamed from: f  reason: collision with root package name */
        private final CountDownLatch f3696f = new CountDownLatch(1);

        C0030a() {
        }

        /* access modifiers changed from: protected */
        public D a(Void... voidArr) {
            try {
                return a.this.e();
            } catch (OperationCanceledException e2) {
                if (c()) {
                    return null;
                }
                throw e2;
            }
        }

        /* access modifiers changed from: protected */
        public void a(D d2) {
            try {
                a.this.b(this, d2);
            } finally {
                this.f3696f.countDown();
            }
        }

        /* access modifiers changed from: protected */
        public void b(D d2) {
            try {
                a.this.a(this, d2);
            } finally {
                this.f3696f.countDown();
            }
        }

        public void run() {
            this.f3694a = false;
            a.this.c();
        }
    }

    public a(Context context) {
        this(context, ModernAsyncTask.f3669c);
    }

    private a(Context context, Executor executor) {
        super(context);
        this.f3691d = -10000;
        this.f3693f = executor;
    }

    /* access modifiers changed from: protected */
    public void a() {
        super.a();
        r();
        this.f3688a = new C0030a();
        c();
    }

    /* access modifiers changed from: package-private */
    public void a(a<D>.a aVar, D d2) {
        a(d2);
        if (this.f3689b == aVar) {
            z();
            this.f3691d = SystemClock.uptimeMillis();
            this.f3689b = null;
            l();
            c();
        }
    }

    public void a(D d2) {
    }

    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        if (this.f3688a != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.f3688a);
            printWriter.print(" waiting=");
            printWriter.println(this.f3688a.f3694a);
        }
        if (this.f3689b != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.f3689b);
            printWriter.print(" waiting=");
            printWriter.println(this.f3689b.f3694a);
        }
        if (this.f3690c != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            g.a(this.f3690c, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            g.a(this.f3691d, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(a<D>.a aVar, D d2) {
        if (this.f3688a != aVar) {
            a(aVar, d2);
        } else if (o()) {
            a(d2);
        } else {
            y();
            this.f3691d = SystemClock.uptimeMillis();
            this.f3688a = null;
            b(d2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        if (this.f3688a == null) {
            return false;
        }
        if (!this.f3709r) {
            this.f3712u = true;
        }
        if (this.f3689b != null) {
            if (this.f3688a.f3694a) {
                this.f3688a.f3694a = false;
                this.f3692e.removeCallbacks(this.f3688a);
            }
            this.f3688a = null;
            return false;
        } else if (this.f3688a.f3694a) {
            this.f3688a.f3694a = false;
            this.f3692e.removeCallbacks(this.f3688a);
            this.f3688a = null;
            return false;
        } else {
            boolean a2 = this.f3688a.a(false);
            if (a2) {
                this.f3689b = this.f3688a;
                f();
            }
            this.f3688a = null;
            return a2;
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.f3689b == null && this.f3688a != null) {
            if (this.f3688a.f3694a) {
                this.f3688a.f3694a = false;
                this.f3692e.removeCallbacks(this.f3688a);
            }
            if (this.f3690c <= 0 || SystemClock.uptimeMillis() >= this.f3691d + this.f3690c) {
                this.f3688a.a(this.f3693f, (Params[]) null);
                return;
            }
            this.f3688a.f3694a = true;
            this.f3692e.postAtTime(this.f3688a, this.f3691d + this.f3690c);
        }
    }

    public abstract D d();

    /* access modifiers changed from: protected */
    public D e() {
        return d();
    }

    public void f() {
    }

    public boolean g() {
        return this.f3689b != null;
    }
}
