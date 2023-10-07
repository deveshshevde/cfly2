package bp;

import bo.g;
import bo.m;
import bo.n;
import bo.o;
import bo.r;
import com.bumptech.glide.load.data.j;
import com.bumptech.glide.load.e;
import com.bumptech.glide.load.f;
import java.io.InputStream;

public class a implements n<g, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public static final e<Integer> f5944a = e.a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* renamed from: b  reason: collision with root package name */
    private final m<g, g> f5945b;

    /* renamed from: bp.a$a  reason: collision with other inner class name */
    public static class C0056a implements o<g, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final m<g, g> f5946a = new m<>(500);

        public n<g, InputStream> a(r rVar) {
            return new a(this.f5946a);
        }

        public void a() {
        }
    }

    public a() {
        this((m<g, g>) null);
    }

    public a(m<g, g> mVar) {
        this.f5945b = mVar;
    }

    public n.a<InputStream> a(g gVar, int i2, int i3, f fVar) {
        m<g, g> mVar = this.f5945b;
        if (mVar != null) {
            g a2 = mVar.a(gVar, 0, 0);
            if (a2 == null) {
                this.f5945b.a(gVar, 0, 0, gVar);
            } else {
                gVar = a2;
            }
        }
        return new n.a<>(gVar, new j(gVar, ((Integer) fVar.a(f5944a)).intValue()));
    }

    public boolean a(g gVar) {
        return true;
    }
}
