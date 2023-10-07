package com.google.android.exoplayer2.text;

import com.google.android.exoplayer2.util.a;
import fi.g;
import java.nio.ByteBuffer;

public abstract class c extends g<h, i, SubtitleDecoderException> implements f {

    /* renamed from: a  reason: collision with root package name */
    private final String f16599a;

    protected c(String str) {
        super(new h[2], new i[2]);
        this.f16599a = str;
        a(1024);
    }

    /* access modifiers changed from: protected */
    public final SubtitleDecoderException a(h hVar, i iVar, boolean z2) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) a.b(hVar.f13099b);
            i iVar2 = iVar;
            iVar2.a(hVar.f13101d, a(byteBuffer.array(), byteBuffer.limit(), z2), hVar.f16602f);
            iVar.clearFlag(Integer.MIN_VALUE);
            return null;
        } catch (SubtitleDecoderException e2) {
            return e2;
        }
    }

    /* access modifiers changed from: protected */
    public abstract e a(byte[] bArr, int i2, boolean z2) throws SubtitleDecoderException;

    public void a(long j2) {
    }

    /* access modifiers changed from: protected */
    public final void a(i iVar) {
        super.a(iVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final SubtitleDecoderException a(Throwable th) {
        return new SubtitleDecoderException("Unexpected decode error", th);
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public final h g() {
        return new h();
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public final i h() {
        return new d(this);
    }
}
