package androidx.media;

import android.media.session.MediaSessionManager;
import androidx.media.b;
import s.c;

class d extends c {

    static final class a implements b.C0032b {

        /* renamed from: a  reason: collision with root package name */
        final MediaSessionManager.RemoteUserInfo f3804a;

        a(String str, int i2, int i3) {
            this.f3804a = new MediaSessionManager.RemoteUserInfo(str, i2, i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            return this.f3804a.equals(((a) obj).f3804a);
        }

        public int hashCode() {
            return c.a(this.f3804a);
        }
    }
}
