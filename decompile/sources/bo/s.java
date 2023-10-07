package bo;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import bo.n;
import com.bumptech.glide.load.f;
import java.io.InputStream;

public class s<Data> implements n<Integer, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final n<Uri, Data> f5926a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f5927b;

    public static final class a implements o<Integer, AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f5928a;

        public a(Resources resources) {
            this.f5928a = resources;
        }

        public n<Integer, AssetFileDescriptor> a(r rVar) {
            return new s(this.f5928a, rVar.b(Uri.class, AssetFileDescriptor.class));
        }

        public void a() {
        }
    }

    public static class b implements o<Integer, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f5929a;

        public b(Resources resources) {
            this.f5929a = resources;
        }

        public n<Integer, ParcelFileDescriptor> a(r rVar) {
            return new s(this.f5929a, rVar.b(Uri.class, ParcelFileDescriptor.class));
        }

        public void a() {
        }
    }

    public static class c implements o<Integer, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f5930a;

        public c(Resources resources) {
            this.f5930a = resources;
        }

        public n<Integer, InputStream> a(r rVar) {
            return new s(this.f5930a, rVar.b(Uri.class, InputStream.class));
        }

        public void a() {
        }
    }

    public static class d implements o<Integer, Uri> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f5931a;

        public d(Resources resources) {
            this.f5931a = resources;
        }

        public n<Integer, Uri> a(r rVar) {
            return new s(this.f5931a, v.a());
        }

        public void a() {
        }
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.f5927b = resources;
        this.f5926a = nVar;
    }

    private Uri b(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f5927b.getResourcePackageName(num.intValue()) + '/' + this.f5927b.getResourceTypeName(num.intValue()) + '/' + this.f5927b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e2) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            Log.w("ResourceLoader", "Received invalid resource id: " + num, e2);
            return null;
        }
    }

    public n.a<Data> a(Integer num, int i2, int i3, f fVar) {
        Uri b2 = b(num);
        if (b2 == null) {
            return null;
        }
        return this.f5926a.a(b2, i2, i3, fVar);
    }

    public boolean a(Integer num) {
        return true;
    }
}
