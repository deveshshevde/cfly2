package fq;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.aa;
import com.google.android.exoplayer2.util.q;
import fj.i;
import fj.u;
import fq.ac;

public final class y implements v {

    /* renamed from: a  reason: collision with root package name */
    private aa f27989a;

    /* renamed from: b  reason: collision with root package name */
    private u f27990b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f27991c;

    public void a(aa aaVar, i iVar, ac.d dVar) {
        this.f27989a = aaVar;
        dVar.a();
        u a2 = iVar.a(dVar.b(), 4);
        this.f27990b = a2;
        a2.a(Format.a(dVar.c(), "application/x-scte35", (String) null, -1, (DrmInitData) null));
    }

    public void a(q qVar) {
        if (!this.f27991c) {
            if (this.f27989a.c() != -9223372036854775807L) {
                this.f27990b.a(Format.a((String) null, "application/x-scte35", this.f27989a.c()));
                this.f27991c = true;
            } else {
                return;
            }
        }
        int b2 = qVar.b();
        this.f27990b.a(qVar, b2);
        this.f27990b.a(this.f27989a.b(), 1, b2, 0, (u.a) null);
    }
}
