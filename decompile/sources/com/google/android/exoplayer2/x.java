package com.google.android.exoplayer2;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.af;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.j;
import com.google.android.exoplayer2.trackselection.f;
import com.google.android.exoplayer2.video.e;
import com.google.android.exoplayer2.video.g;
import com.google.android.exoplayer2.video.i;

public interface x {

    public interface a {

        /* renamed from: com.google.android.exoplayer2.x$a$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$a(a aVar, ExoPlaybackException exoPlaybackException) {
            }

            public static void $default$a(a aVar, af afVar, int i2) {
                aVar.a(afVar, afVar.b() == 1 ? afVar.a(0, new af.b()).f15175d : null, i2);
            }

            @Deprecated
            public static void $default$a(a aVar, af afVar, Object obj, int i2) {
            }

            public static void $default$a(a aVar, TrackGroupArray trackGroupArray, f fVar) {
            }

            public static void $default$a(a aVar, v vVar) {
            }

            public static void $default$a(a aVar, boolean z2) {
            }

            public static void $default$a(a aVar, boolean z2, int i2) {
            }

            public static void $default$b(a aVar) {
            }

            public static void $default$b(a aVar, int i2) {
            }

            public static void $default$b(a aVar, boolean z2) {
            }

            public static void $default$c(a aVar, int i2) {
            }

            public static void $default$c(a aVar, boolean z2) {
            }

            public static void $default$d(a aVar, int i2) {
            }
        }

        void a(ExoPlaybackException exoPlaybackException);

        void a(af afVar, int i2);

        @Deprecated
        void a(af afVar, Object obj, int i2);

        void a(TrackGroupArray trackGroupArray, f fVar);

        void a(v vVar);

        void a(boolean z2);

        void a(boolean z2, int i2);

        void b();

        void b(int i2);

        void b(boolean z2);

        void c(int i2);

        void c(boolean z2);

        void d(int i2);
    }

    public interface b {
        void a(j jVar);

        void b(j jVar);
    }

    public interface c {
        void a(Surface surface);

        void a(SurfaceView surfaceView);

        void a(TextureView textureView);

        void a(e eVar);

        void a(g gVar);

        void a(i iVar);

        void a(ge.a aVar);

        void b(Surface surface);

        void b(SurfaceView surfaceView);

        void b(TextureView textureView);

        void b(g gVar);

        void b(i iVar);

        void b(ge.a aVar);
    }

    long A();

    long B();

    TrackGroupArray C();

    f D();

    af E();

    void a(int i2);

    void a(int i2, long j2);

    void a(a aVar);

    void a(boolean z2);

    boolean a();

    int b(int i2);

    void b(a aVar);

    void b(boolean z2);

    boolean b();

    boolean c();

    int d();

    int e();

    boolean f();

    c h();

    b i();

    Looper j();

    int k();

    int l();

    ExoPlaybackException m();

    boolean n();

    int o();

    boolean p();

    v q();

    int s();

    int t();

    long u();

    long v();

    long w();

    boolean x();

    int y();

    int z();
}
