package fu;

import android.net.Uri;
import com.google.android.exoplayer2.util.ac;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final long f28141a;

    /* renamed from: b  reason: collision with root package name */
    public final long f28142b;

    /* renamed from: c  reason: collision with root package name */
    private final String f28143c;

    /* renamed from: d  reason: collision with root package name */
    private int f28144d;

    public f(String str, long j2, long j3) {
        this.f28143c = str == null ? "" : str;
        this.f28141a = j2;
        this.f28142b = j3;
    }

    public Uri a(String str) {
        return ac.a(str, this.f28143c);
    }

    public f a(f fVar, String str) {
        String b2 = b(str);
        if (fVar != null && b2.equals(fVar.b(str))) {
            long j2 = this.f28142b;
            long j3 = -1;
            if (j2 != -1) {
                long j4 = this.f28141a;
                if (j4 + j2 == fVar.f28141a) {
                    long j5 = fVar.f28142b;
                    if (j5 != -1) {
                        j3 = j2 + j5;
                    }
                    return new f(b2, j4, j3);
                }
            }
            long j6 = fVar.f28142b;
            if (j6 != -1) {
                long j7 = fVar.f28141a;
                if (j7 + j6 == this.f28141a) {
                    if (j2 != -1) {
                        j3 = j6 + j2;
                    }
                    return new f(b2, j7, j3);
                }
            }
        }
        return null;
    }

    public String b(String str) {
        return ac.b(str, this.f28143c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return this.f28141a == fVar.f28141a && this.f28142b == fVar.f28142b && this.f28143c.equals(fVar.f28143c);
    }

    public int hashCode() {
        if (this.f28144d == 0) {
            this.f28144d = ((((527 + ((int) this.f28141a)) * 31) + ((int) this.f28142b)) * 31) + this.f28143c.hashCode();
        }
        return this.f28144d;
    }

    public String toString() {
        String str = this.f28143c;
        long j2 = this.f28141a;
        long j3 = this.f28142b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 81);
        sb.append("RangedUri(referenceUri=");
        sb.append(str);
        sb.append(", start=");
        sb.append(j2);
        sb.append(", length=");
        sb.append(j3);
        sb.append(")");
        return sb.toString();
    }
}
