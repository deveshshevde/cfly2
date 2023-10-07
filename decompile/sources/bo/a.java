package bo;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import bo.n;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.h;
import com.bumptech.glide.load.data.m;
import com.bumptech.glide.load.f;
import java.io.InputStream;

public class a<Data> implements n<Uri, Data> {

    /* renamed from: a  reason: collision with root package name */
    private static final int f5851a = 22;

    /* renamed from: b  reason: collision with root package name */
    private final AssetManager f5852b;

    /* renamed from: c  reason: collision with root package name */
    private final C0053a<Data> f5853c;

    /* renamed from: bo.a$a  reason: collision with other inner class name */
    public interface C0053a<Data> {
        d<Data> a(AssetManager assetManager, String str);
    }

    public static class b implements C0053a<AssetFileDescriptor>, o<Uri, AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f5854a;

        public b(AssetManager assetManager) {
            this.f5854a = assetManager;
        }

        public n<Uri, AssetFileDescriptor> a(r rVar) {
            return new a(this.f5854a, this);
        }

        public d<AssetFileDescriptor> a(AssetManager assetManager, String str) {
            return new h(assetManager, str);
        }

        public void a() {
        }
    }

    public static class c implements C0053a<InputStream>, o<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f5855a;

        public c(AssetManager assetManager) {
            this.f5855a = assetManager;
        }

        public n<Uri, InputStream> a(r rVar) {
            return new a(this.f5855a, this);
        }

        public d<InputStream> a(AssetManager assetManager, String str) {
            return new m(assetManager, str);
        }

        public void a() {
        }
    }

    public a(AssetManager assetManager, C0053a<Data> aVar) {
        this.f5852b = assetManager;
        this.f5853c = aVar;
    }

    public n.a<Data> a(Uri uri, int i2, int i3, f fVar) {
        return new n.a<>(new cb.b(uri), this.f5853c.a(this.f5852b, uri.toString().substring(f5851a)));
    }

    public boolean a(Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}
