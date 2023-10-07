package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.d;
import java.io.IOException;
import java.util.Map;

public interface DrmSession<T extends d> {

    /* renamed from: com.google.android.exoplayer2.drm.DrmSession$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$d(DrmSession drmSession) {
            return false;
        }

        public static <T extends d> void a(DrmSession<T> drmSession, DrmSession<T> drmSession2) {
            if (drmSession != drmSession2) {
                if (drmSession2 != null) {
                    drmSession2.h();
                }
                if (drmSession != null) {
                    drmSession.i();
                }
            }
        }
    }

    public static class DrmSessionException extends IOException {
        public DrmSessionException(Throwable th) {
            super(th);
        }
    }

    int c();

    boolean d();

    DrmSessionException e();

    T f();

    Map<String, String> g();

    void h();

    void i();
}
