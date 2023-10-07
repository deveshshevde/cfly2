package bp;

import android.content.Context;
import android.net.Uri;
import bk.b;
import bo.n;
import bo.o;
import bo.r;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import java.io.InputStream;

public class c implements n<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5949a;

    public static class a implements o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f5950a;

        public a(Context context) {
            this.f5950a = context;
        }

        public n<Uri, InputStream> a(r rVar) {
            return new c(this.f5950a);
        }

        public void a() {
        }
    }

    public c(Context context) {
        this.f5949a = context.getApplicationContext();
    }

    private boolean a(f fVar) {
        Long l2 = (Long) fVar.a(VideoDecoder.f10446a);
        return l2 != null && l2.longValue() == -1;
    }

    public n.a<InputStream> a(Uri uri, int i2, int i3, f fVar) {
        if (!b.a(i2, i3) || !a(fVar)) {
            return null;
        }
        return new n.a<>(new cb.b(uri), bk.c.b(this.f5949a, uri));
    }

    public boolean a(Uri uri) {
        return b.b(uri);
    }
}
