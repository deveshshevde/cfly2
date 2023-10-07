package androidx.transition;

import android.view.View;
import android.view.WindowId;

class as implements at {

    /* renamed from: a  reason: collision with root package name */
    private final WindowId f4811a;

    as(View view) {
        this.f4811a = view.getWindowId();
    }

    public boolean equals(Object obj) {
        return (obj instanceof as) && ((as) obj).f4811a.equals(this.f4811a);
    }

    public int hashCode() {
        return this.f4811a.hashCode();
    }
}
