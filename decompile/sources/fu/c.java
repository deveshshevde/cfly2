package fu;

import com.google.android.exoplayer2.util.ad;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final String f28130a;

    /* renamed from: b  reason: collision with root package name */
    public final String f28131b;

    /* renamed from: c  reason: collision with root package name */
    public final String f28132c;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return ad.a((Object) this.f28130a, (Object) cVar.f28130a) && ad.a((Object) this.f28131b, (Object) cVar.f28131b) && ad.a((Object) this.f28132c, (Object) cVar.f28132c);
    }

    public int hashCode() {
        int hashCode = this.f28130a.hashCode() * 31;
        String str = this.f28131b;
        int i2 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f28132c;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }
}
