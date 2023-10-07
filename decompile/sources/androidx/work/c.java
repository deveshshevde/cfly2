package androidx.work;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Set<a> f5143a = new HashSet();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f5144a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f5145b;

        a(Uri uri, boolean z2) {
            this.f5144a = uri;
            this.f5145b = z2;
        }

        public Uri a() {
            return this.f5144a;
        }

        public boolean b() {
            return this.f5145b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f5145b == aVar.f5145b && this.f5144a.equals(aVar.f5144a);
        }

        public int hashCode() {
            return (this.f5144a.hashCode() * 31) + (this.f5145b ? 1 : 0);
        }
    }

    public Set<a> a() {
        return this.f5143a;
    }

    public void a(Uri uri, boolean z2) {
        this.f5143a.add(new a(uri, z2));
    }

    public int b() {
        return this.f5143a.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f5143a.equals(((c) obj).f5143a);
    }

    public int hashCode() {
        return this.f5143a.hashCode();
    }
}
