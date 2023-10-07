package bo;

import bo.n;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.f;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class b<Data> implements n<byte[], Data> {

    /* renamed from: a  reason: collision with root package name */
    private final C0054b<Data> f5856a;

    public static class a implements o<byte[], ByteBuffer> {
        public n<byte[], ByteBuffer> a(r rVar) {
            return new b(new C0054b<ByteBuffer>() {
                public Class<ByteBuffer> a() {
                    return ByteBuffer.class;
                }

                /* renamed from: a */
                public ByteBuffer b(byte[] bArr) {
                    return ByteBuffer.wrap(bArr);
                }
            });
        }

        public void a() {
        }
    }

    /* renamed from: bo.b$b  reason: collision with other inner class name */
    public interface C0054b<Data> {
        Class<Data> a();

        Data b(byte[] bArr);
    }

    private static class c<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* renamed from: a  reason: collision with root package name */
        private final byte[] f5858a;

        /* renamed from: b  reason: collision with root package name */
        private final C0054b<Data> f5859b;

        c(byte[] bArr, C0054b<Data> bVar) {
            this.f5858a = bArr;
            this.f5859b = bVar;
        }

        public Class<Data> a() {
            return this.f5859b.a();
        }

        public void a(Priority priority, d.a<? super Data> aVar) {
            aVar.a(this.f5859b.b(this.f5858a));
        }

        public void b() {
        }

        public void c() {
        }

        public DataSource d() {
            return DataSource.LOCAL;
        }
    }

    public static class d implements o<byte[], InputStream> {
        public n<byte[], InputStream> a(r rVar) {
            return new b(new C0054b<InputStream>() {
                /* renamed from: a */
                public InputStream b(byte[] bArr) {
                    return new ByteArrayInputStream(bArr);
                }

                public Class<InputStream> a() {
                    return InputStream.class;
                }
            });
        }

        public void a() {
        }
    }

    public b(C0054b<Data> bVar) {
        this.f5856a = bVar;
    }

    public n.a<Data> a(byte[] bArr, int i2, int i3, f fVar) {
        return new n.a<>(new cb.b(bArr), new c(bArr, this.f5856a));
    }

    public boolean a(byte[] bArr) {
        return true;
    }
}
