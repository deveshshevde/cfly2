package fs;

import android.net.Uri;
import java.util.Arrays;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f28031a = new a(new long[0]);

    /* renamed from: b  reason: collision with root package name */
    public final int f28032b;

    /* renamed from: c  reason: collision with root package name */
    public final long[] f28033c;

    /* renamed from: d  reason: collision with root package name */
    public final C0177a[] f28034d;

    /* renamed from: e  reason: collision with root package name */
    public final long f28035e;

    /* renamed from: f  reason: collision with root package name */
    public final long f28036f;

    /* renamed from: fs.a$a  reason: collision with other inner class name */
    public static final class C0177a {

        /* renamed from: a  reason: collision with root package name */
        public final int f28037a;

        /* renamed from: b  reason: collision with root package name */
        public final Uri[] f28038b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f28039c;

        /* renamed from: d  reason: collision with root package name */
        public final long[] f28040d;

        public C0177a() {
            this(-1, new int[0], new Uri[0], new long[0]);
        }

        private C0177a(int i2, int[] iArr, Uri[] uriArr, long[] jArr) {
            com.google.android.exoplayer2.util.a.a(iArr.length == uriArr.length);
            this.f28037a = i2;
            this.f28039c = iArr;
            this.f28038b = uriArr;
            this.f28040d = jArr;
        }

        public int a() {
            return a(-1);
        }

        public int a(int i2) {
            int i3 = i2 + 1;
            while (true) {
                int[] iArr = this.f28039c;
                if (i3 >= iArr.length || iArr[i3] == 0 || iArr[i3] == 1) {
                    return i3;
                }
                i3++;
            }
            return i3;
        }

        public boolean b() {
            return this.f28037a == -1 || a() < this.f28037a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0177a aVar = (C0177a) obj;
            return this.f28037a == aVar.f28037a && Arrays.equals(this.f28038b, aVar.f28038b) && Arrays.equals(this.f28039c, aVar.f28039c) && Arrays.equals(this.f28040d, aVar.f28040d);
        }

        public int hashCode() {
            return (((((this.f28037a * 31) + Arrays.hashCode(this.f28038b)) * 31) + Arrays.hashCode(this.f28039c)) * 31) + Arrays.hashCode(this.f28040d);
        }
    }

    public a(long... jArr) {
        int length = jArr.length;
        this.f28032b = length;
        this.f28033c = Arrays.copyOf(jArr, length);
        this.f28034d = new C0177a[length];
        for (int i2 = 0; i2 < length; i2++) {
            this.f28034d[i2] = new C0177a();
        }
        this.f28035e = 0;
        this.f28036f = -9223372036854775807L;
    }

    private boolean a(long j2, long j3, int i2) {
        if (j2 == Long.MIN_VALUE) {
            return false;
        }
        long j4 = this.f28033c[i2];
        return j4 == Long.MIN_VALUE ? j3 == -9223372036854775807L || j2 < j3 : j2 < j4;
    }

    public int a(long j2, long j3) {
        int length = this.f28033c.length - 1;
        while (length >= 0 && a(j2, j3, length)) {
            length--;
        }
        if (length < 0 || !this.f28034d[length].b()) {
            return -1;
        }
        return length;
    }

    public int b(long j2, long j3) {
        if (j2 == Long.MIN_VALUE) {
            return -1;
        }
        if (j3 != -9223372036854775807L && j2 >= j3) {
            return -1;
        }
        int i2 = 0;
        while (true) {
            long[] jArr = this.f28033c;
            if (i2 < jArr.length && jArr[i2] != Long.MIN_VALUE && (j2 >= jArr[i2] || !this.f28034d[i2].b())) {
                i2++;
            }
        }
        if (i2 < this.f28033c.length) {
            return i2;
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        return this.f28032b == aVar.f28032b && this.f28035e == aVar.f28035e && this.f28036f == aVar.f28036f && Arrays.equals(this.f28033c, aVar.f28033c) && Arrays.equals(this.f28034d, aVar.f28034d);
    }

    public int hashCode() {
        return (((((((this.f28032b * 31) + ((int) this.f28035e)) * 31) + ((int) this.f28036f)) * 31) + Arrays.hashCode(this.f28033c)) * 31) + Arrays.hashCode(this.f28034d);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdPlaybackState(adResumePositionUs=");
        sb.append(this.f28035e);
        sb.append(", adGroups=[");
        for (int i2 = 0; i2 < this.f28034d.length; i2++) {
            sb.append("adGroup(timeUs=");
            sb.append(this.f28033c[i2]);
            sb.append(", ads=[");
            for (int i3 = 0; i3 < this.f28034d[i2].f28039c.length; i3++) {
                sb.append("ad(state=");
                int i4 = this.f28034d[i2].f28039c[i3];
                sb.append(i4 != 0 ? i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? '?' : '!' : 'P' : 'S' : 'R' : '_');
                sb.append(", durationUs=");
                sb.append(this.f28034d[i2].f28040d[i3]);
                sb.append(')');
                if (i3 < this.f28034d[i2].f28039c.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("])");
            if (i2 < this.f28034d.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("])");
        return sb.toString();
    }
}
