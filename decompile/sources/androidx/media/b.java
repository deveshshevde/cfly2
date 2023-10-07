package androidx.media;

import android.os.Build;
import android.util.Log;
import androidx.media.d;
import androidx.media.e;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    static final boolean f3801a = Log.isLoggable("MediaSessionManager", 3);

    /* renamed from: b  reason: collision with root package name */
    private static final Object f3802b = new Object();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        C0032b f3803a;

        public a(String str, int i2, int i3) {
            this.f3803a = Build.VERSION.SDK_INT >= 28 ? new d.a(str, i2, i3) : new e.a(str, i2, i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            return this.f3803a.equals(((a) obj).f3803a);
        }

        public int hashCode() {
            return this.f3803a.hashCode();
        }
    }

    /* renamed from: androidx.media.b$b  reason: collision with other inner class name */
    interface C0032b {
    }
}
