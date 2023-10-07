package bp;

import android.content.Context;
import android.net.Uri;
import bk.c;
import bo.n;
import bo.o;
import bo.r;
import com.bumptech.glide.load.f;
import java.io.InputStream;

public class b implements n<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5947a;

    public static class a implements o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f5948a;

        public a(Context context) {
            this.f5948a = context;
        }

        public n<Uri, InputStream> a(r rVar) {
            return new b(this.f5948a);
        }

        public void a() {
        }
    }

    public b(Context context) {
        this.f5947a = context.getApplicationContext();
    }

    public n.a<InputStream> a(Uri uri, int i2, int i3, f fVar) {
        if (bk.b.a(i2, i3)) {
            return new n.a<>(new cb.b(uri), c.a(this.f5947a, uri));
        }
        return null;
    }

    public boolean a(Uri uri) {
        return bk.b.c(uri);
    }
}
