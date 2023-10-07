package jo;

import kotlin.jvm.internal.h;

public final class ba {

    /* renamed from: a  reason: collision with root package name */
    private String f29578a;

    public ba(String str) {
        h.d(str, "obType");
        this.f29578a = str;
    }

    public final String a() {
        return this.f29578a;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ba) && h.a((Object) this.f29578a, (Object) ((ba) obj).f29578a);
        }
        return true;
    }

    public int hashCode() {
        String str = this.f29578a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "TrackerEvent(obType=" + this.f29578a + ")";
    }
}
