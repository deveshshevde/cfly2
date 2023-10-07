package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.video.j;
import fi.d;

public interface j {

    /* renamed from: com.google.android.exoplayer2.video.j$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$a(j jVar, int i2, int i3, int i4, float f2) {
        }

        public static void $default$a(j jVar, int i2, long j2) {
        }

        public static void $default$a(j jVar, Surface surface) {
        }

        public static void $default$a(j jVar, Format format) {
        }

        public static void $default$a(j jVar, d dVar) {
        }

        public static void $default$a(j jVar, String str, long j2, long j3) {
        }

        public static void $default$b(j jVar, d dVar) {
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f17287a;

        /* renamed from: b  reason: collision with root package name */
        private final j f17288b;

        public a(Handler handler, j jVar) {
            this.f17287a = jVar != null ? (Handler) com.google.android.exoplayer2.util.a.b(handler) : null;
            this.f17288b = jVar;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(int i2, int i3, int i4, float f2) {
            ((j) ad.a(this.f17288b)).a(i2, i3, i4, f2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(int i2, long j2) {
            ((j) ad.a(this.f17288b)).a(i2, j2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(Surface surface) {
            ((j) ad.a(this.f17288b)).a(surface);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(Format format) {
            ((j) ad.a(this.f17288b)).a(format);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(String str, long j2, long j3) {
            ((j) ad.a(this.f17288b)).a(str, j2, j3);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(d dVar) {
            dVar.a();
            ((j) ad.a(this.f17288b)).b(dVar);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(d dVar) {
            ((j) ad.a(this.f17288b)).a(dVar);
        }

        public void a(int i2, int i3, int i4, float f2) {
            Handler handler = this.f17287a;
            if (handler != null) {
                handler.post(new Runnable(i2, i3, i4, f2) {
                    public final /* synthetic */ int f$1;
                    public final /* synthetic */ int f$2;
                    public final /* synthetic */ int f$3;
                    public final /* synthetic */ float f$4;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r4;
                        this.f$4 = r5;
                    }

                    public final void run() {
                        j.a.this.b(this.f$1, this.f$2, this.f$3, this.f$4);
                    }
                });
            }
        }

        public void a(int i2, long j2) {
            Handler handler = this.f17287a;
            if (handler != null) {
                handler.post(new Runnable(i2, j2) {
                    public final /* synthetic */ int f$1;
                    public final /* synthetic */ long f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void run() {
                        j.a.this.b(this.f$1, this.f$2);
                    }
                });
            }
        }

        public void a(Surface surface) {
            Handler handler = this.f17287a;
            if (handler != null) {
                handler.post(new Runnable(surface) {
                    public final /* synthetic */ Surface f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        j.a.this.b(this.f$1);
                    }
                });
            }
        }

        public void a(Format format) {
            Handler handler = this.f17287a;
            if (handler != null) {
                handler.post(new Runnable(format) {
                    public final /* synthetic */ Format f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        j.a.this.b(this.f$1);
                    }
                });
            }
        }

        public void a(d dVar) {
            Handler handler = this.f17287a;
            if (handler != null) {
                handler.post(new Runnable(dVar) {
                    public final /* synthetic */ d f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        j.a.this.d(this.f$1);
                    }
                });
            }
        }

        public void a(String str, long j2, long j3) {
            Handler handler = this.f17287a;
            if (handler != null) {
                handler.post(new Runnable(str, j2, j3) {
                    public final /* synthetic */ String f$1;
                    public final /* synthetic */ long f$2;
                    public final /* synthetic */ long f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r5;
                    }

                    public final void run() {
                        j.a.this.b(this.f$1, this.f$2, this.f$3);
                    }
                });
            }
        }

        public void b(d dVar) {
            dVar.a();
            Handler handler = this.f17287a;
            if (handler != null) {
                handler.post(new Runnable(dVar) {
                    public final /* synthetic */ d f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        j.a.this.c(this.f$1);
                    }
                });
            }
        }
    }

    void a(int i2, int i3, int i4, float f2);

    void a(int i2, long j2);

    void a(Surface surface);

    void a(Format format);

    void a(d dVar);

    void a(String str, long j2, long j3);

    void b(d dVar);
}
