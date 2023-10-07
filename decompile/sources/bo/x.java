package bo;

import android.net.Uri;
import bo.n;
import com.bumptech.glide.load.f;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class x<Data> implements n<Uri, Data> {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f5942a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));

    /* renamed from: b  reason: collision with root package name */
    private final n<g, Data> f5943b;

    public static class a implements o<Uri, InputStream> {
        public n<Uri, InputStream> a(r rVar) {
            return new x(rVar.b(g.class, InputStream.class));
        }

        public void a() {
        }
    }

    public x(n<g, Data> nVar) {
        this.f5943b = nVar;
    }

    public n.a<Data> a(Uri uri, int i2, int i3, f fVar) {
        return this.f5943b.a(new g(uri.toString()), i2, i3, fVar);
    }

    public boolean a(Uri uri) {
        return f5942a.contains(uri.getScheme());
    }
}
