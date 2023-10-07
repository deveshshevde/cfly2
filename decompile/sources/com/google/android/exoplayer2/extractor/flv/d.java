package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.util.o;
import com.google.android.exoplayer2.util.q;
import com.google.android.exoplayer2.video.a;
import fj.u;

final class d extends TagPayloadReader {

    /* renamed from: b  reason: collision with root package name */
    private final q f15505b = new q(o.f17135a);

    /* renamed from: c  reason: collision with root package name */
    private final q f15506c = new q(4);

    /* renamed from: d  reason: collision with root package name */
    private int f15507d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f15508e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f15509f;

    /* renamed from: g  reason: collision with root package name */
    private int f15510g;

    public d(u uVar) {
        super(uVar);
    }

    /* access modifiers changed from: protected */
    public boolean a(q qVar) throws TagPayloadReader.UnsupportedFormatException {
        int h2 = qVar.h();
        int i2 = (h2 >> 4) & 15;
        int i3 = h2 & 15;
        if (i3 == 7) {
            this.f15510g = i2;
            return i2 != 5;
        }
        StringBuilder sb = new StringBuilder(39);
        sb.append("Video format not supported: ");
        sb.append(i3);
        throw new TagPayloadReader.UnsupportedFormatException(sb.toString());
    }

    /* access modifiers changed from: protected */
    public boolean a(q qVar, long j2) throws ParserException {
        q qVar2 = qVar;
        int h2 = qVar.h();
        long m2 = j2 + (((long) qVar.m()) * 1000);
        if (h2 == 0 && !this.f15508e) {
            q qVar3 = new q(new byte[qVar.b()]);
            qVar2.a(qVar3.f17159a, 0, qVar.b());
            a a2 = a.a(qVar3);
            this.f15507d = a2.f17213b;
            this.f15482a.a(Format.a((String) null, "video/avc", (String) null, -1, -1, a2.f17214c, a2.f17215d, -1.0f, a2.f17212a, -1, a2.f17216e, (DrmInitData) null));
            this.f15508e = true;
            return false;
        } else if (h2 != 1 || !this.f15508e) {
            return false;
        } else {
            int i2 = this.f15510g == 1 ? 1 : 0;
            if (!this.f15509f && i2 == 0) {
                return false;
            }
            byte[] bArr = this.f15506c.f17159a;
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i3 = 4 - this.f15507d;
            int i4 = 0;
            while (qVar.b() > 0) {
                qVar2.a(this.f15506c.f17159a, i3, this.f15507d);
                this.f15506c.c(0);
                int v2 = this.f15506c.v();
                this.f15505b.c(0);
                this.f15482a.a(this.f15505b, 4);
                this.f15482a.a(qVar2, v2);
                i4 = i4 + 4 + v2;
            }
            this.f15482a.a(m2, i2, i4, 0, (u.a) null);
            this.f15509f = true;
            return true;
        }
    }
}
