package androidx.media;

import ci.a;
import java.util.Arrays;

public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a  reason: collision with root package name */
    public int f3720a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f3721b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f3722c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f3723d = -1;

    AudioAttributesImplBase() {
    }

    public int a() {
        int i2 = this.f3723d;
        return i2 != -1 ? i2 : AudioAttributesCompat.a(false, this.f3722c, this.f3720a);
    }

    public int b() {
        return this.f3721b;
    }

    public int c() {
        return this.f3720a;
    }

    public int d() {
        int i2 = this.f3722c;
        int a2 = a();
        if (a2 == 6) {
            i2 |= 4;
        } else if (a2 == 7) {
            i2 |= 1;
        }
        return i2 & a.HEADER_VIEW;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        return this.f3721b == audioAttributesImplBase.b() && this.f3722c == audioAttributesImplBase.d() && this.f3720a == audioAttributesImplBase.c() && this.f3723d == audioAttributesImplBase.f3723d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3721b), Integer.valueOf(this.f3722c), Integer.valueOf(this.f3720a), Integer.valueOf(this.f3723d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f3723d != -1) {
            sb.append(" stream=");
            sb.append(this.f3723d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.a(this.f3720a));
        sb.append(" content=");
        sb.append(this.f3721b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f3722c).toUpperCase());
        return sb.toString();
    }
}
