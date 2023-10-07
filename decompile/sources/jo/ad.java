package jo;

import kotlin.jvm.internal.h;

public final class ad {

    /* renamed from: a  reason: collision with root package name */
    private String f29554a;

    public ad(String str) {
        h.d(str, "currentModel");
        this.f29554a = str;
    }

    public final String a() {
        return this.f29554a;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ad) && h.a((Object) this.f29554a, (Object) ((ad) obj).f29554a);
        }
        return true;
    }

    public int hashCode() {
        String str = this.f29554a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ModelTrackerEvent(currentModel=" + this.f29554a + ")";
    }
}
