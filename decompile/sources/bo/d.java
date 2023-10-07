package bo;

import android.util.Log;
import bo.n;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.f;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class d implements n<File, ByteBuffer> {

    private static final class a implements com.bumptech.glide.load.data.d<ByteBuffer> {

        /* renamed from: a  reason: collision with root package name */
        private final File f5861a;

        a(File file) {
            this.f5861a = file;
        }

        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        public void a(Priority priority, d.a<? super ByteBuffer> aVar) {
            try {
                aVar.a(cc.a.a(this.f5861a));
            } catch (IOException e2) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e2);
                }
                aVar.a((Exception) e2);
            }
        }

        public void b() {
        }

        public void c() {
        }

        public DataSource d() {
            return DataSource.LOCAL;
        }
    }

    public static class b implements o<File, ByteBuffer> {
        public n<File, ByteBuffer> a(r rVar) {
            return new d();
        }

        public void a() {
        }
    }

    public n.a<ByteBuffer> a(File file, int i2, int i3, f fVar) {
        return new n.a<>(new cb.b(file), new a(file));
    }

    public boolean a(File file) {
        return true;
    }
}
