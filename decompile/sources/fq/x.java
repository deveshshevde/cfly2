package fq;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.q;
import fj.i;
import fj.u;
import fq.ac;
import fw.g;
import java.util.List;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    private final List<Format> f27987a;

    /* renamed from: b  reason: collision with root package name */
    private final u[] f27988b;

    public x(List<Format> list) {
        this.f27987a = list;
        this.f27988b = new u[list.size()];
    }

    public void a(long j2, q qVar) {
        g.a(j2, qVar, this.f27988b);
    }

    public void a(i iVar, ac.d dVar) {
        for (int i2 = 0; i2 < this.f27988b.length; i2++) {
            dVar.a();
            u a2 = iVar.a(dVar.b(), 3);
            Format format = this.f27987a.get(i2);
            String str = format.f15092i;
            boolean z2 = "application/cea-608".equals(str) || "application/cea-708".equals(str);
            String valueOf = String.valueOf(str);
            a.a(z2, (Object) valueOf.length() != 0 ? "Invalid closed caption mime type provided: ".concat(valueOf) : new String("Invalid closed caption mime type provided: "));
            a2.a(Format.a(format.f15084a != null ? format.f15084a : dVar.c(), str, (String) null, -1, format.f15086c, format.A, format.B, (DrmInitData) null, Long.MAX_VALUE, format.f15094k));
            this.f27988b[i2] = a2;
        }
    }
}
