package bp;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import bo.n;
import bo.o;
import bo.r;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.f;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class d<DataT> implements n<Uri, DataT> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5951a;

    /* renamed from: b  reason: collision with root package name */
    private final n<File, DataT> f5952b;

    /* renamed from: c  reason: collision with root package name */
    private final n<Uri, DataT> f5953c;

    /* renamed from: d  reason: collision with root package name */
    private final Class<DataT> f5954d;

    private static abstract class a<DataT> implements o<Uri, DataT> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f5955a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<DataT> f5956b;

        a(Context context, Class<DataT> cls) {
            this.f5955a = context;
            this.f5956b = cls;
        }

        public final n<Uri, DataT> a(r rVar) {
            return new d(this.f5955a, rVar.b(File.class, this.f5956b), rVar.b(Uri.class, this.f5956b), this.f5956b);
        }

        public final void a() {
        }
    }

    public static final class b extends a<ParcelFileDescriptor> {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    public static final class c extends a<InputStream> {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    /* renamed from: bp.d$d  reason: collision with other inner class name */
    private static final class C0057d<DataT> implements com.bumptech.glide.load.data.d<DataT> {

        /* renamed from: a  reason: collision with root package name */
        private static final String[] f5957a = {"_data"};

        /* renamed from: b  reason: collision with root package name */
        private final Context f5958b;

        /* renamed from: c  reason: collision with root package name */
        private final n<File, DataT> f5959c;

        /* renamed from: d  reason: collision with root package name */
        private final n<Uri, DataT> f5960d;

        /* renamed from: e  reason: collision with root package name */
        private final Uri f5961e;

        /* renamed from: f  reason: collision with root package name */
        private final int f5962f;

        /* renamed from: g  reason: collision with root package name */
        private final int f5963g;

        /* renamed from: h  reason: collision with root package name */
        private final f f5964h;

        /* renamed from: i  reason: collision with root package name */
        private final Class<DataT> f5965i;

        /* renamed from: j  reason: collision with root package name */
        private volatile boolean f5966j;

        /* renamed from: k  reason: collision with root package name */
        private volatile com.bumptech.glide.load.data.d<DataT> f5967k;

        C0057d(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Uri uri, int i2, int i3, f fVar, Class<DataT> cls) {
            this.f5958b = context.getApplicationContext();
            this.f5959c = nVar;
            this.f5960d = nVar2;
            this.f5961e = uri;
            this.f5962f = i2;
            this.f5963g = i3;
            this.f5964h = fVar;
            this.f5965i = cls;
        }

        private File a(Uri uri) throws FileNotFoundException {
            Cursor cursor = null;
            try {
                cursor = this.f5958b.getContentResolver().query(uri, f5957a, (String) null, (String[]) null, (String) null);
                if (cursor == null || !cursor.moveToFirst()) {
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                }
                String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                if (!TextUtils.isEmpty(string)) {
                    return new File(string);
                }
                throw new FileNotFoundException("File path was empty in media store for: " + uri);
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }

        private com.bumptech.glide.load.data.d<DataT> e() throws FileNotFoundException {
            n.a f2 = f();
            if (f2 != null) {
                return f2.f5903c;
            }
            return null;
        }

        private n.a<DataT> f() throws FileNotFoundException {
            if (Environment.isExternalStorageLegacy()) {
                return this.f5959c.a(a(this.f5961e), this.f5962f, this.f5963g, this.f5964h);
            }
            return this.f5960d.a(g() ? MediaStore.setRequireOriginal(this.f5961e) : this.f5961e, this.f5962f, this.f5963g, this.f5964h);
        }

        private boolean g() {
            return this.f5958b.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        public Class<DataT> a() {
            return this.f5965i;
        }

        public void a(Priority priority, d.a<? super DataT> aVar) {
            try {
                com.bumptech.glide.load.data.d<DataT> e2 = e();
                if (e2 == null) {
                    aVar.a((Exception) new IllegalArgumentException("Failed to build fetcher for: " + this.f5961e));
                    return;
                }
                this.f5967k = e2;
                if (this.f5966j) {
                    c();
                } else {
                    e2.a(priority, aVar);
                }
            } catch (FileNotFoundException e3) {
                aVar.a((Exception) e3);
            }
        }

        public void b() {
            com.bumptech.glide.load.data.d<DataT> dVar = this.f5967k;
            if (dVar != null) {
                dVar.b();
            }
        }

        public void c() {
            this.f5966j = true;
            com.bumptech.glide.load.data.d<DataT> dVar = this.f5967k;
            if (dVar != null) {
                dVar.c();
            }
        }

        public DataSource d() {
            return DataSource.LOCAL;
        }
    }

    d(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Class<DataT> cls) {
        this.f5951a = context.getApplicationContext();
        this.f5952b = nVar;
        this.f5953c = nVar2;
        this.f5954d = cls;
    }

    public n.a<DataT> a(Uri uri, int i2, int i3, f fVar) {
        return new n.a<>(new cb.b(uri), new C0057d(this.f5951a, this.f5952b, this.f5953c, uri, i2, i3, fVar, this.f5954d));
    }

    public boolean a(Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && bk.b.a(uri);
    }
}
