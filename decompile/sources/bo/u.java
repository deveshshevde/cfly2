package bo;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import bo.n;
import com.bumptech.glide.load.f;
import java.io.File;
import java.io.InputStream;

public class u<Data> implements n<String, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final n<Uri, Data> f5933a;

    public static final class a implements o<String, AssetFileDescriptor> {
        public n<String, AssetFileDescriptor> a(r rVar) {
            return new u(rVar.b(Uri.class, AssetFileDescriptor.class));
        }

        public void a() {
        }
    }

    public static class b implements o<String, ParcelFileDescriptor> {
        public n<String, ParcelFileDescriptor> a(r rVar) {
            return new u(rVar.b(Uri.class, ParcelFileDescriptor.class));
        }

        public void a() {
        }
    }

    public static class c implements o<String, InputStream> {
        public n<String, InputStream> a(r rVar) {
            return new u(rVar.b(Uri.class, InputStream.class));
        }

        public void a() {
        }
    }

    public u(n<Uri, Data> nVar) {
        this.f5933a = nVar;
    }

    private static Uri b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) != '/') {
            Uri parse = Uri.parse(str);
            if (parse.getScheme() != null) {
                return parse;
            }
        }
        return c(str);
    }

    private static Uri c(String str) {
        return Uri.fromFile(new File(str));
    }

    public n.a<Data> a(String str, int i2, int i3, f fVar) {
        Uri b2 = b(str);
        if (b2 == null || !this.f5933a.a(b2)) {
            return null;
        }
        return this.f5933a.a(b2, i2, i3, fVar);
    }

    public boolean a(String str) {
        return true;
    }
}
