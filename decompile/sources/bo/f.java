package bo;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import bo.n;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class f<Data> implements n<File, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final d<Data> f5868a;

    public static class a<Data> implements o<File, Data> {

        /* renamed from: a  reason: collision with root package name */
        private final d<Data> f5869a;

        public a(d<Data> dVar) {
            this.f5869a = dVar;
        }

        public final n<File, Data> a(r rVar) {
            return new f(this.f5869a);
        }

        public final void a() {
        }
    }

    public static class b extends a<ParcelFileDescriptor> {
        public b() {
            super(new d<ParcelFileDescriptor>() {
                /* renamed from: a */
                public ParcelFileDescriptor b(File file) throws FileNotFoundException {
                    return ParcelFileDescriptor.open(file, AMapEngineUtils.MAX_P20_WIDTH);
                }

                public Class<ParcelFileDescriptor> a() {
                    return ParcelFileDescriptor.class;
                }

                public void a(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                    parcelFileDescriptor.close();
                }
            });
        }
    }

    private static final class c<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final File f5870a;

        /* renamed from: b  reason: collision with root package name */
        private final d<Data> f5871b;

        /* renamed from: c  reason: collision with root package name */
        private Data f5872c;

        c(File file, d<Data> dVar) {
            this.f5870a = file;
            this.f5871b = dVar;
        }

        public Class<Data> a() {
            return this.f5871b.a();
        }

        public void a(Priority priority, d.a<? super Data> aVar) {
            try {
                Data b2 = this.f5871b.b(this.f5870a);
                this.f5872c = b2;
                aVar.a(b2);
            } catch (FileNotFoundException e2) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e2);
                }
                aVar.a((Exception) e2);
            }
        }

        public void b() {
            Data data = this.f5872c;
            if (data != null) {
                try {
                    this.f5871b.a(data);
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

    public interface d<Data> {
        Class<Data> a();

        void a(Data data) throws IOException;

        Data b(File file) throws FileNotFoundException;
    }

    public static class e extends a<InputStream> {
        public e() {
            super(new d<InputStream>() {
                /* renamed from: a */
                public InputStream b(File file) throws FileNotFoundException {
                    return new FileInputStream(file);
                }

                public Class<InputStream> a() {
                    return InputStream.class;
                }

                public void a(InputStream inputStream) throws IOException {
                    inputStream.close();
                }
            });
        }
    }

    public f(d<Data> dVar) {
        this.f5868a = dVar;
    }

    public n.a<Data> a(File file, int i2, int i3, com.bumptech.glide.load.f fVar) {
        return new n.a<>(new cb.b(file), new c(file, this.f5868a));
    }

    public boolean a(File file) {
        return true;
    }
}
