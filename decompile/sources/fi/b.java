package fi;

import android.media.MediaCodec;
import com.google.android.exoplayer2.util.ad;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f27292a;

    /* renamed from: b  reason: collision with root package name */
    public byte[] f27293b;

    /* renamed from: c  reason: collision with root package name */
    public int f27294c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f27295d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f27296e;

    /* renamed from: f  reason: collision with root package name */
    public int f27297f;

    /* renamed from: g  reason: collision with root package name */
    public int f27298g;

    /* renamed from: h  reason: collision with root package name */
    public int f27299h;

    /* renamed from: i  reason: collision with root package name */
    private final MediaCodec.CryptoInfo f27300i;

    /* renamed from: j  reason: collision with root package name */
    private final a f27301j;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final MediaCodec.CryptoInfo f27302a;

        /* renamed from: b  reason: collision with root package name */
        private final MediaCodec.CryptoInfo.Pattern f27303b;

        private a(MediaCodec.CryptoInfo cryptoInfo) {
            this.f27302a = cryptoInfo;
            this.f27303b = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        /* access modifiers changed from: private */
        public void a(int i2, int i3) {
            this.f27303b.set(i2, i3);
            this.f27302a.setPattern(this.f27303b);
        }
    }

    public b() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f27300i = cryptoInfo;
        this.f27301j = ad.f11755a >= 24 ? new a(cryptoInfo) : null;
    }

    public MediaCodec.CryptoInfo a() {
        return this.f27300i;
    }

    public void a(int i2, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i3, int i4, int i5) {
        this.f27297f = i2;
        this.f27295d = iArr;
        this.f27296e = iArr2;
        this.f27293b = bArr;
        this.f27292a = bArr2;
        this.f27294c = i3;
        this.f27298g = i4;
        this.f27299h = i5;
        this.f27300i.numSubSamples = i2;
        this.f27300i.numBytesOfClearData = iArr;
        this.f27300i.numBytesOfEncryptedData = iArr2;
        this.f27300i.key = bArr;
        this.f27300i.iv = bArr2;
        this.f27300i.mode = i3;
        if (ad.f11755a >= 24) {
            this.f27301j.a(i4, i5);
        }
    }
}
