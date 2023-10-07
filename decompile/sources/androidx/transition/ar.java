package androidx.transition;

import android.os.IBinder;

class ar implements at {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f4810a;

    ar(IBinder iBinder) {
        this.f4810a = iBinder;
    }

    public boolean equals(Object obj) {
        return (obj instanceof ar) && ((ar) obj).f4810a.equals(this.f4810a);
    }

    public int hashCode() {
        return this.f4810a.hashCode();
    }
}
