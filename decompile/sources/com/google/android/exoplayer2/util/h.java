package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.flac.VorbisComment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final int f17113a;

    /* renamed from: b  reason: collision with root package name */
    public final int f17114b;

    /* renamed from: c  reason: collision with root package name */
    public final int f17115c;

    /* renamed from: d  reason: collision with root package name */
    public final int f17116d;

    /* renamed from: e  reason: collision with root package name */
    public final int f17117e;

    /* renamed from: f  reason: collision with root package name */
    public final int f17118f;

    /* renamed from: g  reason: collision with root package name */
    public final int f17119g;

    /* renamed from: h  reason: collision with root package name */
    public final int f17120h;

    /* renamed from: i  reason: collision with root package name */
    public final int f17121i;

    /* renamed from: j  reason: collision with root package name */
    public final long f17122j;

    /* renamed from: k  reason: collision with root package name */
    public final a f17123k;

    /* renamed from: l  reason: collision with root package name */
    private final Metadata f17124l;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final long[] f17125a;

        /* renamed from: b  reason: collision with root package name */
        public final long[] f17126b;

        public a(long[] jArr, long[] jArr2) {
            this.f17125a = jArr;
            this.f17126b = jArr2;
        }
    }

    private h(int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, a aVar, Metadata metadata) {
        this.f17113a = i2;
        this.f17114b = i3;
        this.f17115c = i4;
        this.f17116d = i5;
        this.f17117e = i6;
        this.f17118f = a(i6);
        this.f17119g = i7;
        this.f17120h = i8;
        this.f17121i = b(i8);
        this.f17122j = j2;
        this.f17123k = aVar;
        this.f17124l = metadata;
    }

    public h(byte[] bArr, int i2) {
        p pVar = new p(bArr);
        pVar.a(i2 * 8);
        this.f17113a = pVar.c(16);
        this.f17114b = pVar.c(16);
        this.f17115c = pVar.c(24);
        this.f17116d = pVar.c(24);
        int c2 = pVar.c(20);
        this.f17117e = c2;
        this.f17118f = a(c2);
        this.f17119g = pVar.c(3) + 1;
        int c3 = pVar.c(5) + 1;
        this.f17120h = c3;
        this.f17121i = b(c3);
        this.f17122j = pVar.d(36);
        this.f17123k = null;
        this.f17124l = null;
    }

    private static int a(int i2) {
        switch (i2) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    private static Metadata a(List<String> list, List<PictureFrame> list2) {
        if (list.isEmpty() && list2.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            String str = list.get(i2);
            String[] b2 = ad.b(str, "=");
            if (b2.length != 2) {
                String valueOf = String.valueOf(str);
                k.c("FlacStreamMetadata", valueOf.length() != 0 ? "Failed to parse Vorbis comment: ".concat(valueOf) : new String("Failed to parse Vorbis comment: "));
            } else {
                arrayList.add(new VorbisComment(b2[0], b2[1]));
            }
        }
        arrayList.addAll(list2);
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    private static int b(int i2) {
        if (i2 == 8) {
            return 1;
        }
        if (i2 == 12) {
            return 2;
        }
        if (i2 == 16) {
            return 4;
        }
        if (i2 != 20) {
            return i2 != 24 ? -1 : 6;
        }
        return 5;
    }

    public int a() {
        return this.f17120h * this.f17117e * this.f17119g;
    }

    public long a(long j2) {
        return ad.a((j2 * ((long) this.f17117e)) / 1000000, 0, this.f17122j - 1);
    }

    public Format a(byte[] bArr, Metadata metadata) {
        int i2;
        Metadata metadata2;
        bArr[4] = Byte.MIN_VALUE;
        int i3 = this.f17116d;
        if (i3 > 0) {
            i2 = i3;
            metadata2 = metadata;
        } else {
            metadata2 = metadata;
            i2 = -1;
        }
        return Format.a((String) null, "audio/flac", (String) null, a(), i2, this.f17119g, this.f17117e, -1, 0, 0, (List<byte[]>) Collections.singletonList(bArr), (DrmInitData) null, 0, (String) null, a(metadata2));
    }

    public Metadata a(Metadata metadata) {
        Metadata metadata2 = this.f17124l;
        return metadata2 == null ? metadata : metadata2.a(metadata);
    }

    public h a(a aVar) {
        return new h(this.f17113a, this.f17114b, this.f17115c, this.f17116d, this.f17117e, this.f17119g, this.f17120h, this.f17122j, aVar, this.f17124l);
    }

    public h a(List<String> list) {
        return new h(this.f17113a, this.f17114b, this.f17115c, this.f17116d, this.f17117e, this.f17119g, this.f17120h, this.f17122j, this.f17123k, a(a(list, (List<PictureFrame>) Collections.emptyList())));
    }

    public long b() {
        long j2 = this.f17122j;
        if (j2 == 0) {
            return -9223372036854775807L;
        }
        return (j2 * 1000000) / ((long) this.f17117e);
    }

    public h b(List<PictureFrame> list) {
        return new h(this.f17113a, this.f17114b, this.f17115c, this.f17116d, this.f17117e, this.f17119g, this.f17120h, this.f17122j, this.f17123k, a(a((List<String>) Collections.emptyList(), list)));
    }

    public long c() {
        long j2;
        long j3;
        int i2 = this.f17116d;
        if (i2 > 0) {
            j2 = (((long) i2) + ((long) this.f17115c)) / 2;
            j3 = 1;
        } else {
            int i3 = this.f17113a;
            j2 = ((((i3 != this.f17114b || i3 <= 0) ? IjkMediaMeta.AV_CH_TOP_FRONT_LEFT : (long) i3) * ((long) this.f17119g)) * ((long) this.f17120h)) / 8;
            j3 = 64;
        }
        return j2 + j3;
    }
}
