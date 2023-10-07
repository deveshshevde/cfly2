package ft;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.upstream.h;

public abstract class a extends l {

    /* renamed from: a  reason: collision with root package name */
    public final long f28041a;

    /* renamed from: b  reason: collision with root package name */
    public final long f28042b;

    /* renamed from: l  reason: collision with root package name */
    private c f28043l;

    /* renamed from: m  reason: collision with root package name */
    private int[] f28044m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(f fVar, h hVar, Format format, int i2, Object obj, long j2, long j3, long j4, long j5, long j6) {
        super(fVar, hVar, format, i2, obj, j2, j3, j6);
        this.f28041a = j4;
        this.f28042b = j5;
    }

    public final int a(int i2) {
        return this.f28044m[i2];
    }

    public void a(c cVar) {
        this.f28043l = cVar;
        this.f28044m = cVar.a();
    }

    /* access modifiers changed from: protected */
    public final c c() {
        return this.f28043l;
    }
}
