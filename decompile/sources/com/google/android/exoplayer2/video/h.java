package com.google.android.exoplayer2.video;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.exoplayer2.util.ad;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final WindowManager f17267a;

    /* renamed from: b  reason: collision with root package name */
    private final b f17268b;

    /* renamed from: c  reason: collision with root package name */
    private final a f17269c;

    /* renamed from: d  reason: collision with root package name */
    private long f17270d;

    /* renamed from: e  reason: collision with root package name */
    private long f17271e;

    /* renamed from: f  reason: collision with root package name */
    private long f17272f;

    /* renamed from: g  reason: collision with root package name */
    private long f17273g;

    /* renamed from: h  reason: collision with root package name */
    private long f17274h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f17275i;

    /* renamed from: j  reason: collision with root package name */
    private long f17276j;

    /* renamed from: k  reason: collision with root package name */
    private long f17277k;

    /* renamed from: l  reason: collision with root package name */
    private long f17278l;

    private final class a implements DisplayManager.DisplayListener {

        /* renamed from: b  reason: collision with root package name */
        private final DisplayManager f17280b;

        public a(DisplayManager displayManager) {
            this.f17280b = displayManager;
        }

        public void a() {
            this.f17280b.registerDisplayListener(this, (Handler) null);
        }

        public void b() {
            this.f17280b.unregisterDisplayListener(this);
        }

        public void onDisplayAdded(int i2) {
        }

        public void onDisplayChanged(int i2) {
            if (i2 == 0) {
                h.this.c();
            }
        }

        public void onDisplayRemoved(int i2) {
        }
    }

    private static final class b implements Handler.Callback, Choreographer.FrameCallback {

        /* renamed from: b  reason: collision with root package name */
        private static final b f17281b = new b();

        /* renamed from: a  reason: collision with root package name */
        public volatile long f17282a = -9223372036854775807L;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f17283c;

        /* renamed from: d  reason: collision with root package name */
        private final HandlerThread f17284d;

        /* renamed from: e  reason: collision with root package name */
        private Choreographer f17285e;

        /* renamed from: f  reason: collision with root package name */
        private int f17286f;

        private b() {
            HandlerThread handlerThread = new HandlerThread("ChoreographerOwner:Handler");
            this.f17284d = handlerThread;
            handlerThread.start();
            Handler a2 = ad.a(handlerThread.getLooper(), (Handler.Callback) this);
            this.f17283c = a2;
            a2.sendEmptyMessage(0);
        }

        public static b a() {
            return f17281b;
        }

        private void d() {
            this.f17285e = Choreographer.getInstance();
        }

        private void e() {
            int i2 = this.f17286f + 1;
            this.f17286f = i2;
            if (i2 == 1) {
                this.f17285e.postFrameCallback(this);
            }
        }

        private void f() {
            int i2 = this.f17286f - 1;
            this.f17286f = i2;
            if (i2 == 0) {
                this.f17285e.removeFrameCallback(this);
                this.f17282a = -9223372036854775807L;
            }
        }

        public void b() {
            this.f17283c.sendEmptyMessage(1);
        }

        public void c() {
            this.f17283c.sendEmptyMessage(2);
        }

        public void doFrame(long j2) {
            this.f17282a = j2;
            this.f17285e.postFrameCallbackDelayed(this, 500);
        }

        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                d();
                return true;
            } else if (i2 == 1) {
                e();
                return true;
            } else if (i2 != 2) {
                return false;
            } else {
                f();
                return true;
            }
        }
    }

    public h() {
        this((Context) null);
    }

    public h(Context context) {
        a aVar = null;
        if (context != null) {
            context = context.getApplicationContext();
            this.f17267a = (WindowManager) context.getSystemService("window");
        } else {
            this.f17267a = null;
        }
        if (this.f17267a != null) {
            this.f17269c = ad.f11755a >= 17 ? a(context) : aVar;
            this.f17268b = b.a();
        } else {
            this.f17269c = null;
            this.f17268b = null;
        }
        this.f17270d = -9223372036854775807L;
        this.f17271e = -9223372036854775807L;
    }

    private static long a(long j2, long j3, long j4) {
        long j5;
        long j6 = j3 + (((j2 - j3) / j4) * j4);
        if (j2 <= j6) {
            j5 = j6 - j4;
        } else {
            long j7 = j6;
            j6 = j4 + j6;
            j5 = j7;
        }
        return j6 - j2 < j2 - j5 ? j6 : j5;
    }

    private a a(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
        if (displayManager == null) {
            return null;
        }
        return new a(displayManager);
    }

    private boolean b(long j2, long j3) {
        return Math.abs((j3 - this.f17276j) - (j2 - this.f17277k)) > 20000000;
    }

    /* access modifiers changed from: private */
    public void c() {
        Display defaultDisplay = this.f17267a.getDefaultDisplay();
        if (defaultDisplay != null) {
            double refreshRate = (double) defaultDisplay.getRefreshRate();
            Double.isNaN(refreshRate);
            long j2 = (long) (1.0E9d / refreshRate);
            this.f17270d = j2;
            this.f17271e = (j2 * 80) / 100;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003e, code lost:
        if (b(r0, r13) != false) goto L_0x0030;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0077 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long a(long r11, long r13) {
        /*
            r10 = this;
            r0 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r11
            boolean r2 = r10.f17275i
            if (r2 == 0) goto L_0x0041
            long r2 = r10.f17272f
            int r4 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x0019
            long r2 = r10.f17278l
            r4 = 1
            long r2 = r2 + r4
            r10.f17278l = r2
            long r2 = r10.f17274h
            r10.f17273g = r2
        L_0x0019:
            long r2 = r10.f17278l
            r4 = 6
            r6 = 0
            int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r7 < 0) goto L_0x003a
            long r4 = r10.f17277k
            long r4 = r0 - r4
            long r4 = r4 / r2
            long r2 = r10.f17273g
            long r2 = r2 + r4
            boolean r4 = r10.b(r2, r13)
            if (r4 == 0) goto L_0x0033
        L_0x0030:
            r10.f17275i = r6
            goto L_0x0041
        L_0x0033:
            long r4 = r10.f17276j
            long r4 = r4 + r2
            long r6 = r10.f17277k
            long r4 = r4 - r6
            goto L_0x0043
        L_0x003a:
            boolean r2 = r10.b(r0, r13)
            if (r2 == 0) goto L_0x0041
            goto L_0x0030
        L_0x0041:
            r4 = r13
            r2 = r0
        L_0x0043:
            boolean r6 = r10.f17275i
            if (r6 != 0) goto L_0x0052
            r10.f17277k = r0
            r10.f17276j = r13
            r13 = 0
            r10.f17278l = r13
            r13 = 1
            r10.f17275i = r13
        L_0x0052:
            r10.f17272f = r11
            r10.f17274h = r2
            com.google.android.exoplayer2.video.h$b r11 = r10.f17268b
            if (r11 == 0) goto L_0x0077
            long r12 = r10.f17270d
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r14 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r14 != 0) goto L_0x0066
            goto L_0x0077
        L_0x0066:
            long r6 = r11.f17282a
            int r11 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r11 != 0) goto L_0x006d
            return r4
        L_0x006d:
            long r8 = r10.f17270d
            long r11 = a(r4, r6, r8)
            long r13 = r10.f17271e
            long r11 = r11 - r13
            return r11
        L_0x0077:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.h.a(long, long):long");
    }

    public void a() {
        this.f17275i = false;
        if (this.f17267a != null) {
            this.f17268b.b();
            a aVar = this.f17269c;
            if (aVar != null) {
                aVar.a();
            }
            c();
        }
    }

    public void b() {
        if (this.f17267a != null) {
            a aVar = this.f17269c;
            if (aVar != null) {
                aVar.b();
            }
            this.f17268b.c();
        }
    }
}
