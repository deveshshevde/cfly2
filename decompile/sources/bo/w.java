package bo;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import bo.n;
import com.bumptech.glide.load.data.i;
import com.bumptech.glide.load.data.n;
import com.bumptech.glide.load.f;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class w<Data> implements n<Uri, Data> {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<String> f5937a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"file", "android.resource", "content"})));

    /* renamed from: b  reason: collision with root package name */
    private final c<Data> f5938b;

    public static final class a implements o<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f5939a;

        public a(ContentResolver contentResolver) {
            this.f5939a = contentResolver;
        }

        public n<Uri, AssetFileDescriptor> a(r rVar) {
            return new w(this);
        }

        public com.bumptech.glide.load.data.d<AssetFileDescriptor> a(Uri uri) {
            return new com.bumptech.glide.load.data.a(this.f5939a, uri);
        }

        public void a() {
        }
    }

    public static class b implements o<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f5940a;

        public b(ContentResolver contentResolver) {
            this.f5940a = contentResolver;
        }

        public n<Uri, ParcelFileDescriptor> a(r rVar) {
            return new w(this);
        }

        public com.bumptech.glide.load.data.d<ParcelFileDescriptor> a(Uri uri) {
            return new i(this.f5940a, uri);
        }

        public void a() {
        }
    }

    public interface c<Data> {
        com.bumptech.glide.load.data.d<Data> a(Uri uri);
    }

    public static class d implements o<Uri, InputStream>, c<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f5941a;

        public d(ContentResolver contentResolver) {
            this.f5941a = contentResolver;
        }

        public n<Uri, InputStream> a(r rVar) {
            return new w(this);
        }

        public com.bumptech.glide.load.data.d<InputStream> a(Uri uri) {
            return new n(this.f5941a, uri);
        }

        public void a() {
        }
    }

    public w(c<Data> cVar) {
        this.f5938b = cVar;
    }

    public n.a<Data> a(Uri uri, int i2, int i3, f fVar) {
        return new n.a<>(new cb.b(uri), this.f5938b.a(uri));
    }

    public boolean a(Uri uri) {
        return f5937a.contains(uri.getScheme());
    }
}
