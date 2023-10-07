package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.d;
import com.google.android.exoplayer2.util.a;
import java.util.Map;

public final class c<T extends d> implements DrmSession<T> {

    /* renamed from: a  reason: collision with root package name */
    private final DrmSession.DrmSessionException f15472a;

    public c(DrmSession.DrmSessionException drmSessionException) {
        this.f15472a = (DrmSession.DrmSessionException) a.b(drmSessionException);
    }

    public int c() {
        return 1;
    }

    public boolean d() {
        return false;
    }

    public DrmSession.DrmSessionException e() {
        return this.f15472a;
    }

    public T f() {
        return null;
    }

    public Map<String, String> g() {
        return null;
    }

    public void h() {
    }

    public void i() {
    }
}
