package fj;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.q;
import java.io.IOException;
import java.util.Arrays;

public interface u {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f27409a;

        /* renamed from: b  reason: collision with root package name */
        public final byte[] f27410b;

        /* renamed from: c  reason: collision with root package name */
        public final int f27411c;

        /* renamed from: d  reason: collision with root package name */
        public final int f27412d;

        public a(int i2, byte[] bArr, int i3, int i4) {
            this.f27409a = i2;
            this.f27410b = bArr;
            this.f27411c = i3;
            this.f27412d = i4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f27409a == aVar.f27409a && this.f27411c == aVar.f27411c && this.f27412d == aVar.f27412d && Arrays.equals(this.f27410b, aVar.f27410b);
        }

        public int hashCode() {
            return (((((this.f27409a * 31) + Arrays.hashCode(this.f27410b)) * 31) + this.f27411c) * 31) + this.f27412d;
        }
    }

    int a(h hVar, int i2, boolean z2) throws IOException, InterruptedException;

    void a(long j2, int i2, int i3, int i4, a aVar);

    void a(Format format);

    void a(q qVar, int i2);
}
