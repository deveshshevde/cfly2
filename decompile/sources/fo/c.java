package fo;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.q;
import fj.g;
import fj.h;
import fj.i;
import fj.k;
import fj.r;
import fj.u;
import java.io.IOException;

public class c implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final k f27608a = $$Lambda$c$I7aBhELqk6wpiLlgCcnnKvZ7SQY.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    private i f27609b;

    /* renamed from: c  reason: collision with root package name */
    private h f27610c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f27611d;

    private static q a(q qVar) {
        qVar.c(0);
        return qVar;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ g[] a() {
        return new g[]{new c()};
    }

    private boolean b(h hVar) throws IOException, InterruptedException {
        h gVar;
        e eVar = new e();
        if (eVar.a(hVar, true) && (eVar.f27618b & 2) == 2) {
            int min = Math.min(eVar.f27625i, 8);
            q qVar = new q(min);
            hVar.d(qVar.f17159a, 0, min);
            if (b.a(a(qVar))) {
                gVar = new b();
            } else if (i.a(a(qVar))) {
                gVar = new i();
            } else if (g.a(a(qVar))) {
                gVar = new g();
            }
            this.f27610c = gVar;
            return true;
        }
        return false;
    }

    public int a(h hVar, r rVar) throws IOException, InterruptedException {
        if (this.f27610c == null) {
            if (b(hVar)) {
                hVar.a();
            } else {
                throw new ParserException("Failed to determine bitstream type");
            }
        }
        if (!this.f27611d) {
            u a2 = this.f27609b.a(0, 1);
            this.f27609b.a();
            this.f27610c.a(this.f27609b, a2);
            this.f27611d = true;
        }
        return this.f27610c.a(hVar, rVar);
    }

    public void a(long j2, long j3) {
        h hVar = this.f27610c;
        if (hVar != null) {
            hVar.a(j2, j3);
        }
    }

    public void a(i iVar) {
        this.f27609b = iVar;
    }

    public boolean a(h hVar) throws IOException, InterruptedException {
        try {
            return b(hVar);
        } catch (ParserException unused) {
            return false;
        }
    }

    public void c() {
    }
}
