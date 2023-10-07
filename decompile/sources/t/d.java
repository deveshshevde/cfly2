package t;

import android.os.Build;
import android.view.DisplayCutout;
import s.c;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Object f34490a;

    private d(Object obj) {
        this.f34490a = obj;
    }

    static d a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new d(obj);
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f34490a).getSafeInsetTop();
        }
        return 0;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f34490a).getSafeInsetBottom();
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f34490a).getSafeInsetLeft();
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 28) {
            return ((DisplayCutout) this.f34490a).getSafeInsetRight();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return c.a(this.f34490a, ((d) obj).f34490a);
    }

    public int hashCode() {
        Object obj = this.f34490a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f34490a + "}";
    }
}
