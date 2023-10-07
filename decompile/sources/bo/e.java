package bo;

import android.util.Base64;
import bo.n;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.f;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class e<Model, Data> implements n<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final a<Data> f5862a;

    public interface a<Data> {
        Class<Data> a();

        Data a(String str) throws IllegalArgumentException;

        void a(Data data) throws IOException;
    }

    private static final class b<Data> implements d<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final String f5863a;

        /* renamed from: b  reason: collision with root package name */
        private final a<Data> f5864b;

        /* renamed from: c  reason: collision with root package name */
        private Data f5865c;

        b(String str, a<Data> aVar) {
            this.f5863a = str;
            this.f5864b = aVar;
        }

        public Class<Data> a() {
            return this.f5864b.a();
        }

        public void a(Priority priority, d.a<? super Data> aVar) {
            try {
                Data a2 = this.f5864b.a(this.f5863a);
                this.f5865c = a2;
                aVar.a(a2);
            } catch (IllegalArgumentException e2) {
                aVar.a((Exception) e2);
            }
        }

        public void b() {
            try {
                this.f5864b.a(this.f5865c);
            } catch (IOException unused) {
            }
        }

        public void c() {
        }

        public DataSource d() {
            return DataSource.LOCAL;
        }
    }

    public static final class c<Model> implements o<Model, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final a<InputStream> f5866a = new a<InputStream>() {
            public Class<InputStream> a() {
                return InputStream.class;
            }

            public void a(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            /* renamed from: b */
            public InputStream a(String str) {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf == -1) {
                        throw new IllegalArgumentException("Missing comma in data URL.");
                    } else if (str.substring(0, indexOf).endsWith(";base64")) {
                        return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                    } else {
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                } else {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
            }
        };

        public n<Model, InputStream> a(r rVar) {
            return new e(this.f5866a);
        }

        public void a() {
        }
    }

    public e(a<Data> aVar) {
        this.f5862a = aVar;
    }

    public n.a<Data> a(Model model, int i2, int i3, f fVar) {
        return new n.a<>(new cb.b(model), new b(model.toString(), this.f5862a));
    }

    public boolean a(Model model) {
        return model.toString().startsWith("data:image");
    }
}
