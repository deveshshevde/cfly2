package com.google.android.exoplayer2.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;
import com.google.android.exoplayer2.util.EGLSurfaceTexture;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.i;
import com.google.android.exoplayer2.util.k;

public final class DummySurface extends Surface {

    /* renamed from: b  reason: collision with root package name */
    private static int f17201b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f17202c;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f17203a;

    /* renamed from: d  reason: collision with root package name */
    private final a f17204d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f17205e;

    private static class a extends HandlerThread implements Handler.Callback {

        /* renamed from: a  reason: collision with root package name */
        private EGLSurfaceTexture f17206a;

        /* renamed from: b  reason: collision with root package name */
        private Handler f17207b;

        /* renamed from: c  reason: collision with root package name */
        private Error f17208c;

        /* renamed from: d  reason: collision with root package name */
        private RuntimeException f17209d;

        /* renamed from: e  reason: collision with root package name */
        private DummySurface f17210e;

        public a() {
            super("dummySurface");
        }

        private void b() {
            com.google.android.exoplayer2.util.a.b(this.f17206a);
            this.f17206a.a();
        }

        private void b(int i2) {
            com.google.android.exoplayer2.util.a.b(this.f17206a);
            this.f17206a.a(i2);
            this.f17210e = new DummySurface(this, this.f17206a.b(), i2 != 0);
        }

        public DummySurface a(int i2) {
            boolean z2;
            start();
            Handler handler = new Handler(getLooper(), this);
            this.f17207b = handler;
            this.f17206a = new EGLSurfaceTexture(handler);
            synchronized (this) {
                z2 = false;
                this.f17207b.obtainMessage(1, i2, 0).sendToTarget();
                while (this.f17210e == null && this.f17209d == null && this.f17208c == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z2 = true;
                    }
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.f17209d;
            if (runtimeException == null) {
                Error error = this.f17208c;
                if (error == null) {
                    return (DummySurface) com.google.android.exoplayer2.util.a.b(this.f17210e);
                }
                throw error;
            }
            throw runtimeException;
        }

        public void a() {
            com.google.android.exoplayer2.util.a.b(this.f17207b);
            this.f17207b.sendEmptyMessage(2);
        }

        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1) {
                try {
                    b(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e2) {
                    k.b("DummySurface", "Failed to initialize dummy surface", e2);
                    this.f17209d = e2;
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e3) {
                    try {
                        k.b("DummySurface", "Failed to initialize dummy surface", e3);
                        this.f17208c = e3;
                        synchronized (this) {
                            notify();
                        }
                    } catch (Throwable th) {
                        synchronized (this) {
                            notify();
                            throw th;
                        }
                    }
                }
                return true;
            } else if (i2 != 2) {
                return true;
            } else {
                try {
                    b();
                } catch (Throwable th2) {
                    quit();
                    throw th2;
                }
                quit();
                return true;
            }
        }
    }

    private DummySurface(a aVar, SurfaceTexture surfaceTexture, boolean z2) {
        super(surfaceTexture);
        this.f17204d = aVar;
        this.f17203a = z2;
    }

    public static DummySurface a(Context context, boolean z2) {
        a();
        int i2 = 0;
        com.google.android.exoplayer2.util.a.b(!z2 || a(context));
        a aVar = new a();
        if (z2) {
            i2 = f17201b;
        }
        return aVar.a(i2);
    }

    private static void a() {
        if (ad.f11755a < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
    }

    public static synchronized boolean a(Context context) {
        boolean z2;
        synchronized (DummySurface.class) {
            z2 = true;
            if (!f17202c) {
                f17201b = b(context);
                f17202c = true;
            }
            if (f17201b == 0) {
                z2 = false;
            }
        }
        return z2;
    }

    private static int b(Context context) {
        if (i.a(context)) {
            return i.a() ? 1 : 2;
        }
        return 0;
    }

    public void release() {
        super.release();
        synchronized (this.f17204d) {
            if (!this.f17205e) {
                this.f17204d.a();
                this.f17205e = true;
            }
        }
    }
}
