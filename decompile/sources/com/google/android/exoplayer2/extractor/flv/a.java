package com.google.android.exoplayer2.extractor.flv;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.flv.TagPayloadReader;
import com.google.android.exoplayer2.util.c;
import com.google.android.exoplayer2.util.q;
import fj.u;
import java.util.Collections;
import java.util.List;

final class a extends TagPayloadReader {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f15483b = {5512, 11025, 22050, 44100};

    /* renamed from: c  reason: collision with root package name */
    private boolean f15484c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f15485d;

    /* renamed from: e  reason: collision with root package name */
    private int f15486e;

    public a(u uVar) {
        super(uVar);
    }

    /* access modifiers changed from: protected */
    public boolean a(q qVar) throws TagPayloadReader.UnsupportedFormatException {
        Format a2;
        if (!this.f15484c) {
            int h2 = qVar.h();
            int i2 = (h2 >> 4) & 15;
            this.f15486e = i2;
            if (i2 == 2) {
                a2 = Format.a((String) null, "audio/mpeg", (String) null, -1, -1, 1, f15483b[(h2 >> 2) & 3], (List<byte[]>) null, (DrmInitData) null, 0, (String) null);
            } else if (i2 == 7 || i2 == 8) {
                a2 = Format.a((String) null, i2 == 7 ? "audio/g711-alaw" : "audio/g711-mlaw", (String) null, -1, -1, 1, 8000, -1, (List<byte[]>) null, (DrmInitData) null, 0, (String) null);
            } else {
                if (i2 != 10) {
                    int i3 = this.f15486e;
                    StringBuilder sb = new StringBuilder(39);
                    sb.append("Audio format not supported: ");
                    sb.append(i3);
                    throw new TagPayloadReader.UnsupportedFormatException(sb.toString());
                }
                this.f15484c = true;
            }
            this.f15482a.a(a2);
            this.f15485d = true;
            this.f15484c = true;
        } else {
            qVar.d(1);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean a(q qVar, long j2) throws ParserException {
        q qVar2 = qVar;
        if (this.f15486e == 2) {
            int b2 = qVar.b();
            this.f15482a.a(qVar2, b2);
            this.f15482a.a(j2, 1, b2, 0, (u.a) null);
            return true;
        }
        int h2 = qVar.h();
        if (h2 == 0 && !this.f15485d) {
            int b3 = qVar.b();
            byte[] bArr = new byte[b3];
            qVar2.a(bArr, 0, b3);
            Pair<Integer, Integer> a2 = c.a(bArr);
            this.f15482a.a(Format.a((String) null, "audio/mp4a-latm", (String) null, -1, -1, ((Integer) a2.second).intValue(), ((Integer) a2.first).intValue(), (List<byte[]>) Collections.singletonList(bArr), (DrmInitData) null, 0, (String) null));
            this.f15485d = true;
            return false;
        } else if (this.f15486e == 10 && h2 != 1) {
            return false;
        } else {
            int b4 = qVar.b();
            this.f15482a.a(qVar2, b4);
            this.f15482a.a(j2, 1, b4, 0, (u.a) null);
            return true;
        }
    }
}
