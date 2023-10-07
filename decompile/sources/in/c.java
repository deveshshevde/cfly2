package in;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import com.liulishuo.filedownloader.model.a;
import in.a;
import iq.d;
import iq.e;
import iq.f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private final b f13610a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final d f13611b = new d();

    /* renamed from: c  reason: collision with root package name */
    private Handler f13612c;

    /* renamed from: d  reason: collision with root package name */
    private final long f13613d = e.a().f29059b;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final List<Integer> f13614e = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public AtomicInteger f13615f = new AtomicInteger();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public volatile Thread f13616g;

    public c() {
        HandlerThread handlerThread = new HandlerThread(f.j("RemitHandoverToDB"));
        handlerThread.start();
        this.f13612c = new Handler(handlerThread.getLooper(), new Handler.Callback() {
            public boolean handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 0) {
                    if (c.this.f13616g != null) {
                        LockSupport.unpark(c.this.f13616g);
                        Thread unused = c.this.f13616g = null;
                    }
                    return false;
                }
                try {
                    c.this.f13615f.set(i2);
                    c.this.g(i2);
                    c.this.f13614e.add(Integer.valueOf(i2));
                    return false;
                } finally {
                    c.this.f13615f.set(0);
                    if (c.this.f13616g != null) {
                        LockSupport.unpark(c.this.f13616g);
                        Thread unused2 = c.this.f13616g = null;
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void g(int i2) {
        if (d.f29057a) {
            d.c(this, "sync cache to db %d", Integer.valueOf(i2));
        }
        this.f13611b.a(this.f13610a.b(i2));
        List<a> c2 = this.f13610a.c(i2);
        this.f13611b.d(i2);
        for (a a2 : c2) {
            this.f13611b.a(a2);
        }
    }

    private boolean h(int i2) {
        return !this.f13614e.contains(Integer.valueOf(i2));
    }

    private void i(int i2) {
        this.f13612c.removeMessages(i2);
        if (this.f13615f.get() == i2) {
            this.f13616g = Thread.currentThread();
            this.f13612c.sendEmptyMessage(0);
            LockSupport.park();
            return;
        }
        g(i2);
    }

    public void a() {
        this.f13610a.a();
        this.f13611b.a();
    }

    public void a(int i2) {
        this.f13612c.sendEmptyMessageDelayed(i2, this.f13613d);
    }

    public void a(int i2, int i3) {
        this.f13610a.a(i2, i3);
        if (!h(i2)) {
            this.f13611b.a(i2, i3);
        }
    }

    public void a(int i2, int i3, long j2) {
        this.f13610a.a(i2, i3, j2);
        if (!h(i2)) {
            this.f13611b.a(i2, i3, j2);
        }
    }

    public void a(int i2, long j2) {
        this.f13610a.a(i2, j2);
        if (!h(i2)) {
            this.f13611b.a(i2, j2);
        }
    }

    public void a(int i2, long j2, String str, String str2) {
        this.f13610a.a(i2, j2, str, str2);
        if (!h(i2)) {
            this.f13611b.a(i2, j2, str, str2);
        }
    }

    public void a(int i2, String str, long j2, long j3, int i3) {
        this.f13610a.a(i2, str, j2, j3, i3);
        if (!h(i2)) {
            this.f13611b.a(i2, str, j2, j3, i3);
        }
    }

    public void a(int i2, Throwable th) {
        this.f13610a.a(i2, th);
        if (!h(i2)) {
            this.f13611b.a(i2, th);
        }
    }

    public void a(int i2, Throwable th, long j2) {
        this.f13610a.a(i2, th, j2);
        if (h(i2)) {
            i(i2);
        }
        this.f13611b.a(i2, th, j2);
        this.f13614e.remove(Integer.valueOf(i2));
    }

    public void a(FileDownloadModel fileDownloadModel) {
        this.f13610a.a(fileDownloadModel);
        if (!h(fileDownloadModel.a())) {
            this.f13611b.a(fileDownloadModel);
        }
    }

    public void a(a aVar) {
        this.f13610a.a(aVar);
        if (!h(aVar.a())) {
            this.f13611b.a(aVar);
        }
    }

    public FileDownloadModel b(int i2) {
        return this.f13610a.b(i2);
    }

    public a.C0100a b() {
        return this.f13611b.a(this.f13610a.f13606a, this.f13610a.f13607b);
    }

    public void b(int i2, long j2) {
        this.f13610a.b(i2, j2);
        if (h(i2)) {
            this.f13612c.removeMessages(i2);
            if (this.f13615f.get() == i2) {
                this.f13616g = Thread.currentThread();
                this.f13612c.sendEmptyMessage(0);
                LockSupport.park();
            }
            this.f13614e.remove(Integer.valueOf(i2));
        }
        this.f13611b.b(i2, j2);
        this.f13614e.remove(Integer.valueOf(i2));
    }

    public List<com.liulishuo.filedownloader.model.a> c(int i2) {
        return this.f13610a.c(i2);
    }

    public void c(int i2, long j2) {
        this.f13610a.c(i2, j2);
        if (h(i2)) {
            i(i2);
        }
        this.f13611b.c(i2, j2);
        this.f13614e.remove(Integer.valueOf(i2));
    }

    public void d(int i2) {
        this.f13610a.d(i2);
        if (!h(i2)) {
            this.f13611b.d(i2);
        }
    }

    public boolean e(int i2) {
        this.f13611b.e(i2);
        return this.f13610a.e(i2);
    }

    public void f(int i2) {
        this.f13610a.f(i2);
        if (!h(i2)) {
            this.f13611b.f(i2);
        }
    }
}
