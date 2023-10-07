package com.google.android.exoplayer2.drm;

import android.os.Looper;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.d;

public interface b<T extends d> {

    /* renamed from: b  reason: collision with root package name */
    public static final b<d> f15471b = new b<d>() {
        public /* synthetic */ DrmSession a(Looper looper, int i2) {
            return CC.$default$a(this, looper, i2);
        }

        public DrmSession<d> a(Looper looper, DrmInitData drmInitData) {
            return new c(new DrmSession.DrmSessionException(new UnsupportedDrmException(1)));
        }

        public /* synthetic */ void a() {
            CC.$default$a(this);
        }

        public boolean a(DrmInitData drmInitData) {
            return false;
        }

        public Class<d> b(DrmInitData drmInitData) {
            return null;
        }

        public /* synthetic */ void b() {
            CC.$default$b(this);
        }
    };

    /* renamed from: com.google.android.exoplayer2.drm.b$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static DrmSession $default$a(b bVar, Looper looper, int i2) {
            return null;
        }

        public static void $default$a(b bVar) {
        }

        public static void $default$b(b bVar) {
        }

        public static <T extends d> b<T> c() {
            return b.f15471b;
        }
    }

    DrmSession<T> a(Looper looper, int i2);

    DrmSession<T> a(Looper looper, DrmInitData drmInitData);

    void a();

    boolean a(DrmInitData drmInitData);

    Class<? extends d> b(DrmInitData drmInitData);

    void b();
}
