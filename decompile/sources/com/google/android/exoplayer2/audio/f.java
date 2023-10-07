package com.google.android.exoplayer2.audio;

import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.f;
import com.google.android.exoplayer2.util.ad;
import fi.d;

public interface f {

    /* renamed from: com.google.android.exoplayer2.audio.f$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$a(f fVar, int i2, long j2, long j3) {
        }

        public static void $default$b(f fVar, Format format) {
        }

        public static void $default$b(f fVar, String str, long j2, long j3) {
        }

        public static void $default$c(f fVar, d dVar) {
        }

        public static void $default$d(f fVar, d dVar) {
        }

        public static void $default$e(f fVar, int i2) {
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f15281a;

        /* renamed from: b  reason: collision with root package name */
        private final f f15282b;

        public a(Handler handler, f fVar) {
            this.f15281a = fVar != null ? (Handler) com.google.android.exoplayer2.util.a.b(handler) : null;
            this.f15282b = fVar;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(int i2) {
            ((f) ad.a(this.f15282b)).e(i2);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(int i2, long j2, long j3) {
            ((f) ad.a(this.f15282b)).a(i2, j2, j3);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(Format format) {
            ((f) ad.a(this.f15282b)).b(format);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(String str, long j2, long j3) {
            ((f) ad.a(this.f15282b)).b(str, j2, j3);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(d dVar) {
            dVar.a();
            ((f) ad.a(this.f15282b)).d(dVar);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(d dVar) {
            ((f) ad.a(this.f15282b)).c(dVar);
        }

        public void a(int i2) {
            Handler handler = this.f15281a;
            if (handler != null) {
                handler.post(new Runnable(i2) {
                    public final /* synthetic */ int f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        f.a.this.b(this.f$1);
                    }
                });
            }
        }

        public void a(int i2, long j2, long j3) {
            Handler handler = this.f15281a;
            if (handler != null) {
                handler.post(new Runnable(i2, j2, j3) {
                    public final /* synthetic */ int f$1;
                    public final /* synthetic */ long f$2;
                    public final /* synthetic */ long f$3;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                        this.f$3 = r5;
                    }

                    public final void run() {
                        f.a.this.b(this.f$1, this.f$2, this.f$3);
                    }
                });
            }
        }

        public void a(Format format) {
            Handler handler = this.f15281a;
            if (handler != null) {
                handler.post(new Runnable(format) {
                    public final /* synthetic */ Format f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        f.a.this.b(this.f$1);
                    }
                });
            }
        }

        public void a(d dVar) {
            Handler handler = this.f15281a;
            if (handler != null) {
                handler.post(new Runnable(dVar) {
                    public final /* synthetic */ d f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        f.a.this.d(this.f$1);
                    }
                });
            }
        }

        public void a(String str, long j2, long j3) {
            Handler handler = this.f15281a;
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
                        f.a.this.b(this.f$1, this.f$2, this.f$3);
                    }
                });
            }
        }

        public void b(d dVar) {
            dVar.a();
            Handler handler = this.f15281a;
            if (handler != null) {
                handler.post(new Runnable(dVar) {
                    public final /* synthetic */ d f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        f.a.this.c(this.f$1);
                    }
                });
            }
        }
    }

    void a(int i2, long j2, long j3);

    void b(Format format);

    void b(String str, long j2, long j3);

    void c(d dVar);

    void d(d dVar);

    void e(int i2);
}
