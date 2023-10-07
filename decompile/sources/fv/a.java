package fv;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.mp4.k;
import com.google.android.exoplayer2.util.ac;
import com.google.android.exoplayer2.util.ad;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f28152a;

    /* renamed from: b  reason: collision with root package name */
    public final C0178a f28153b;

    /* renamed from: c  reason: collision with root package name */
    public final b[] f28154c;

    /* renamed from: d  reason: collision with root package name */
    public final long f28155d;

    /* renamed from: e  reason: collision with root package name */
    public final long f28156e;

    /* renamed from: fv.a$a  reason: collision with other inner class name */
    public static class C0178a {

        /* renamed from: a  reason: collision with root package name */
        public final k[] f28157a;
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f28158a;

        /* renamed from: b  reason: collision with root package name */
        public final long f28159b;

        /* renamed from: c  reason: collision with root package name */
        public final Format[] f28160c;

        /* renamed from: d  reason: collision with root package name */
        public final int f28161d;

        /* renamed from: e  reason: collision with root package name */
        private final String f28162e;

        /* renamed from: f  reason: collision with root package name */
        private final String f28163f;

        /* renamed from: g  reason: collision with root package name */
        private final List<Long> f28164g;

        /* renamed from: h  reason: collision with root package name */
        private final long[] f28165h;

        /* renamed from: i  reason: collision with root package name */
        private final long f28166i;

        public int a(long j2) {
            return ad.a(this.f28165h, j2, true, true);
        }

        public long a(int i2) {
            return this.f28165h[i2];
        }

        public Uri a(int i2, int i3) {
            boolean z2 = true;
            com.google.android.exoplayer2.util.a.b(this.f28160c != null);
            com.google.android.exoplayer2.util.a.b(this.f28164g != null);
            if (i3 >= this.f28164g.size()) {
                z2 = false;
            }
            com.google.android.exoplayer2.util.a.b(z2);
            String num = Integer.toString(this.f28160c[i2].f15088e);
            String l2 = this.f28164g.get(i3).toString();
            return ac.a(this.f28162e, this.f28163f.replace("{bitrate}", num).replace("{Bitrate}", num).replace("{start time}", l2).replace("{start_time}", l2));
        }

        public long b(int i2) {
            if (i2 == this.f28161d - 1) {
                return this.f28166i;
            }
            long[] jArr = this.f28165h;
            return jArr[i2 + 1] - jArr[i2];
        }
    }
}
