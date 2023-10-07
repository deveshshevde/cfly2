package androidx.core.content;

import android.content.LocusId;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final String f2956a;

    /* renamed from: b  reason: collision with root package name */
    private final LocusId f2957b;

    private String b() {
        int length = this.f2956a.length();
        return length + "_chars";
    }

    public LocusId a() {
        return this.f2957b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.f2956a;
        String str2 = ((c) obj).f2956a;
        return str == null ? str2 == null : str.equals(str2);
    }

    public int hashCode() {
        String str = this.f2956a;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "LocusIdCompat[" + b() + "]";
    }
}
