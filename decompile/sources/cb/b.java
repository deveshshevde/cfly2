package cb;

import cc.k;
import com.bumptech.glide.load.c;
import java.security.MessageDigest;

public final class b implements c {

    /* renamed from: b  reason: collision with root package name */
    private final Object f6166b;

    public b(Object obj) {
        this.f6166b = k.a(obj);
    }

    public void a(MessageDigest messageDigest) {
        messageDigest.update(this.f6166b.toString().getBytes(f10157a));
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            return this.f6166b.equals(((b) obj).f6166b);
        }
        return false;
    }

    public int hashCode() {
        return this.f6166b.hashCode();
    }

    public String toString() {
        return "ObjectKey{object=" + this.f6166b + '}';
    }
}
