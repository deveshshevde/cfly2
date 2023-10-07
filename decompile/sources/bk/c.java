package bk;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.data.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class c implements d<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Uri f5735a;

    /* renamed from: b  reason: collision with root package name */
    private final e f5736b;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f5737c;

    static class a implements d {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f5738b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f5739a;

        a(ContentResolver contentResolver) {
            this.f5739a = contentResolver;
        }

        public Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f5739a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f5738b, "kind = 1 AND image_id = ?", new String[]{lastPathSegment}, (String) null);
        }
    }

    static class b implements d {

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f5740b = {"_data"};

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f5741a;

        b(ContentResolver contentResolver) {
            this.f5741a = contentResolver;
        }

        public Cursor a(Uri uri) {
            String lastPathSegment = uri.getLastPathSegment();
            return this.f5741a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f5740b, "kind = 1 AND video_id = ?", new String[]{lastPathSegment}, (String) null);
        }
    }

    c(Uri uri, e eVar) {
        this.f5735a = uri;
        this.f5736b = eVar;
    }

    public static c a(Context context, Uri uri) {
        return a(context, uri, new a(context.getContentResolver()));
    }

    private static c a(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.bumptech.glide.c.a(context).h().a(), dVar, com.bumptech.glide.c.a(context).b(), context.getContentResolver()));
    }

    public static c b(Context context, Uri uri) {
        return a(context, uri, new b(context.getContentResolver()));
    }

    private InputStream e() throws FileNotFoundException {
        InputStream b2 = this.f5736b.b(this.f5735a);
        int a2 = b2 != null ? this.f5736b.a(this.f5735a) : -1;
        return a2 != -1 ? new g(b2, a2) : b2;
    }

    public Class<InputStream> a() {
        return InputStream.class;
    }

    public void a(Priority priority, d.a<? super InputStream> aVar) {
        try {
            InputStream e2 = e();
            this.f5737c = e2;
            aVar.a(e2);
        } catch (FileNotFoundException e3) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e3);
            }
            aVar.a((Exception) e3);
        }
    }

    public void b() {
        InputStream inputStream = this.f5737c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public void c() {
    }

    public DataSource d() {
        return DataSource.LOCAL;
    }
}
