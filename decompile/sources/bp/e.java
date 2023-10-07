package bp;

import bo.g;
import bo.n;
import bo.o;
import bo.r;
import com.bumptech.glide.load.f;
import java.io.InputStream;
import java.net.URL;

public class e implements n<URL, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final n<g, InputStream> f5968a;

    public static class a implements o<URL, InputStream> {
        public n<URL, InputStream> a(r rVar) {
            return new e(rVar.b(g.class, InputStream.class));
        }

        public void a() {
        }
    }

    public e(n<g, InputStream> nVar) {
        this.f5968a = nVar;
    }

    public n.a<InputStream> a(URL url, int i2, int i3, f fVar) {
        return this.f5968a.a(new g(url), i2, i3, fVar);
    }

    public boolean a(URL url) {
        return true;
    }
}
