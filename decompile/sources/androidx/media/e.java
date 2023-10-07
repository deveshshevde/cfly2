package androidx.media;

import android.text.TextUtils;
import androidx.media.b;
import s.c;

class e {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f3805a = b.f3801a;

    static class a implements b.C0032b {

        /* renamed from: a  reason: collision with root package name */
        private String f3806a;

        /* renamed from: b  reason: collision with root package name */
        private int f3807b;

        /* renamed from: c  reason: collision with root package name */
        private int f3808c;

        a(String str, int i2, int i3) {
            this.f3806a = str;
            this.f3807b = i2;
            this.f3808c = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return TextUtils.equals(this.f3806a, aVar.f3806a) && this.f3807b == aVar.f3807b && this.f3808c == aVar.f3808c;
        }

        public int hashCode() {
            return c.a(this.f3806a, Integer.valueOf(this.f3807b), Integer.valueOf(this.f3808c));
        }
    }
}
