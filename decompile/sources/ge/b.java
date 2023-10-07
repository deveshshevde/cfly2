package ge;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.aa;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.q;
import fi.e;
import java.nio.ByteBuffer;

public class b extends d {

    /* renamed from: a  reason: collision with root package name */
    private final e f28466a = new e(1);

    /* renamed from: b  reason: collision with root package name */
    private final q f28467b = new q();

    /* renamed from: c  reason: collision with root package name */
    private long f28468c;

    /* renamed from: d  reason: collision with root package name */
    private a f28469d;

    /* renamed from: e  reason: collision with root package name */
    private long f28470e;

    public b() {
        super(5);
    }

    private void A() {
        this.f28470e = 0;
        a aVar = this.f28469d;
        if (aVar != null) {
            aVar.b();
        }
    }

    private float[] a(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.f28467b.a(byteBuffer.array(), byteBuffer.limit());
        this.f28467b.c(byteBuffer.arrayOffset() + 4);
        float[] fArr = new float[3];
        for (int i2 = 0; i2 < 3; i2++) {
            fArr[i2] = Float.intBitsToFloat(this.f28467b.q());
        }
        return fArr;
    }

    public int a(Format format) {
        return aa.CC.b("application/x-camera-motion".equals(format.f15092i) ? 4 : 0);
    }

    public void a(int i2, Object obj) throws ExoPlaybackException {
        if (i2 == 7) {
            this.f28469d = (a) obj;
        } else {
            super.a(i2, obj);
        }
    }

    public void a(long j2, long j3) throws ExoPlaybackException {
        float[] a2;
        while (!g() && this.f28470e < 100000 + j2) {
            this.f28466a.clear();
            if (a(t(), this.f28466a, false) == -4 && !this.f28466a.isEndOfStream()) {
                this.f28466a.d();
                this.f28470e = this.f28466a.f13101d;
                if (!(this.f28469d == null || (a2 = a((ByteBuffer) ad.a(this.f28466a.f13099b))) == null)) {
                    ((a) ad.a(this.f28469d)).a(this.f28470e - this.f28468c, a2);
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(long j2, boolean z2) throws ExoPlaybackException {
        A();
    }

    /* access modifiers changed from: protected */
    public void a(Format[] formatArr, long j2) throws ExoPlaybackException {
        this.f28468c = j2;
    }

    /* access modifiers changed from: protected */
    public void r() {
        A();
    }

    public boolean y() {
        return true;
    }

    public boolean z() {
        return g();
    }
}
