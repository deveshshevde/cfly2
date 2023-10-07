package ks;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.SystemClock;
import android.util.Log;
import jo.ba;
import org.greenrobot.eventbus.c;
import org.opencv.tracker.ImagesStitchUtil;

public class f {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f30570a = "ks.f";

    /* renamed from: b  reason: collision with root package name */
    private final b f30571b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public c f30572c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public d f30573d;

    /* renamed from: e  reason: collision with root package name */
    private Thread f30574e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f30575f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f30576g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f30577h;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final f f30578a = new f();
    }

    private class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private int[] f30580b;

        private b() {
            this.f30580b = new int[4];
        }

        private boolean a(Bitmap bitmap) {
            Rect a2 = f.this.f30573d.a();
            int i2 = a2.left;
            int i3 = a2.top;
            int i4 = a2.right - a2.left;
            int i5 = a2.bottom - a2.top;
            try {
                String c2 = f.this.f30573d.c();
                String d2 = f.this.f30573d.d();
                String e2 = f.this.f30573d.e();
                Log.i(f.f30570a, "UpdateTask initTracker");
                String initTrackerByBitmap = ImagesStitchUtil.initTrackerByBitmap(bitmap, i2, i3, i4, i5, c2, d2, e2);
                Log.i(f.f30570a, "UpdateTask initTracker end");
                c.a().d(new ba(initTrackerByBitmap));
                boolean unused = f.this.f30576g = false;
                return true;
            } catch (Throwable th) {
                f.this.f30572c.a(111);
                th.printStackTrace();
                f.this.c();
                return false;
            }
        }

        private boolean b(Bitmap bitmap) {
            long currentTimeMillis = System.currentTimeMillis();
            int updateTrackerByBitmap = ImagesStitchUtil.updateTrackerByBitmap(bitmap, this.f30580b);
            String e2 = f.f30570a;
            Log.i(e2, "trackerImp :" + (System.currentTimeMillis() - currentTimeMillis));
            if (updateTrackerByBitmap == -1) {
                f.this.f30572c.a(444);
                return false;
            }
            a b2 = f.this.f30573d.b();
            if (b2 != null && b2.c()) {
                int[] iArr = this.f30580b;
                b2.a(new int[]{iArr[0], iArr[1], iArr[2], iArr[3]});
            }
            if (updateTrackerByBitmap == 0) {
                c e3 = f.this.f30572c;
                int[] iArr2 = this.f30580b;
                e3.a(iArr2[0], iArr2[1], iArr2[2], iArr2[3]);
            }
            return true;
        }

        public void run() {
            boolean unused = f.this.f30576g = true;
            Log.i(f.f30570a, "UpdateTask run");
            while (f.this.f30575f) {
                if (!f.this.f30573d.f().isAvailable() || !f.this.f30577h) {
                    SystemClock.sleep(100);
                } else {
                    try {
                        Bitmap bitmap = f.this.f30573d.f().getBitmap();
                        if (bitmap == null) {
                            SystemClock.sleep(100);
                        } else if (f.this.f30576g) {
                            Log.i(f.f30570a, "UpdateTask init");
                            a(bitmap);
                            Log.i(f.f30570a, "UpdateTask init end");
                        } else if (!b(bitmap)) {
                            return;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    private f() {
        this.f30571b = new b();
        this.f30572c = null;
        this.f30573d = null;
        this.f30576g = true;
        this.f30577h = true;
    }

    public static f a() {
        return a.f30578a;
    }

    public void a(c cVar, d dVar) {
        if (cVar == null || dVar == null) {
            throw new IllegalStateException("listener or config can not be null !!");
        } else if (dVar.f() != null) {
            this.f30572c = cVar;
            this.f30573d = dVar;
        } else {
            throw new IllegalStateException("surface not config !!");
        }
    }

    public void a(boolean z2) {
        this.f30577h = z2;
    }

    public void b() {
        if (this.f30572c != null) {
            this.f30575f = true;
            Thread thread = new Thread(this.f30571b, "update_tracker_thread");
            this.f30574e = thread;
            thread.setPriority(10);
            this.f30574e.start();
            Log.i(f30570a, "startTracker");
            return;
        }
        throw new IllegalStateException("Not initialized, please call initTracker before calling this method!!");
    }

    public void c() {
        a b2;
        this.f30575f = false;
        Thread thread = this.f30574e;
        if (thread != null) {
            thread.interrupt();
        }
        d dVar = this.f30573d;
        if (!(dVar == null || (b2 = dVar.b()) == null)) {
            b2.d();
        }
        Log.i(f30570a, "==> stop tracker !!!");
    }

    public void d() {
        c();
    }
}
