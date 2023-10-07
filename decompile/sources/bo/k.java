package bo;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import bo.n;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.f;
import java.io.File;
import java.io.FileNotFoundException;

public final class k implements n<Uri, File> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5890a;

    public static final class a implements o<Uri, File> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f5891a;

        public a(Context context) {
            this.f5891a = context;
        }

        public n<Uri, File> a(r rVar) {
            return new k(this.f5891a);
        }

        public void a() {
        }
    }

    private static class b implements d<File> {

        /* renamed from: a  reason: collision with root package name */
        private static final String[] f5892a = {"_data"};

        /* renamed from: b  reason: collision with root package name */
        private final Context f5893b;

        /* renamed from: c  reason: collision with root package name */
        private final Uri f5894c;

        b(Context context, Uri uri) {
            this.f5893b = context;
            this.f5894c = uri;
        }

        public Class<File> a() {
            return File.class;
        }

        public void a(Priority priority, d.a<? super File> aVar) {
            Cursor query = this.f5893b.getContentResolver().query(this.f5894c, f5892a, (String) null, (String[]) null, (String) null);
            String str = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(str)) {
                aVar.a((Exception) new FileNotFoundException("Failed to find file path for: " + this.f5894c));
                return;
            }
            aVar.a(new File(str));
        }

        public void b() {
        }

        public void c() {
        }

        public DataSource d() {
            return DataSource.LOCAL;
        }
    }

    public k(Context context) {
        this.f5890a = context;
    }

    public n.a<File> a(Uri uri, int i2, int i3, f fVar) {
        return new n.a<>(new cb.b(uri), new b(this.f5890a, uri));
    }

    public boolean a(Uri uri) {
        return bk.b.a(uri);
    }
}
