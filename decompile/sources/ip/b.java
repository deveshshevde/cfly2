package ip;

import iq.c;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final BufferedOutputStream f29049a;

    /* renamed from: b  reason: collision with root package name */
    private final FileDescriptor f29050b;

    /* renamed from: c  reason: collision with root package name */
    private final RandomAccessFile f29051c;

    public static class a implements c.e {
        public a a(File file) throws IOException {
            return new b(file);
        }

        public boolean a() {
            return true;
        }
    }

    b(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.f29051c = randomAccessFile;
        this.f29050b = randomAccessFile.getFD();
        this.f29049a = new BufferedOutputStream(new FileOutputStream(randomAccessFile.getFD()));
    }

    public void a() throws IOException {
        this.f29049a.flush();
        this.f29050b.sync();
    }

    public void a(long j2) throws IOException {
        this.f29051c.seek(j2);
    }

    public void a(byte[] bArr, int i2, int i3) throws IOException {
        this.f29049a.write(bArr, i2, i3);
    }

    public void b() throws IOException {
        this.f29049a.close();
        this.f29051c.close();
    }

    public void b(long j2) throws IOException {
        this.f29051c.setLength(j2);
    }
}
