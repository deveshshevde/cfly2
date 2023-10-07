package da;

import com.danikula.videocache.ProxyCacheException;
import com.danikula.videocache.a;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public File f26685a;

    /* renamed from: b  reason: collision with root package name */
    private final a f26686b;

    /* renamed from: c  reason: collision with root package name */
    private RandomAccessFile f26687c;

    public b(File file, a aVar) throws ProxyCacheException {
        File file2;
        if (aVar != null) {
            try {
                this.f26686b = aVar;
                d.a(file.getParentFile());
                boolean exists = file.exists();
                if (exists) {
                    file2 = file;
                } else {
                    File parentFile = file.getParentFile();
                    file2 = new File(parentFile, file.getName() + ".download");
                }
                this.f26685a = file2;
                this.f26687c = new RandomAccessFile(this.f26685a, exists ? "r" : "rw");
            } catch (IOException e2) {
                throw new ProxyCacheException("Error using file " + file + " as disc cache", e2);
            }
        } else {
            throw new NullPointerException();
        }
    }

    private boolean a(File file) {
        return file.getName().endsWith(".download");
    }

    public synchronized int a(byte[] bArr, long j2, int i2) throws ProxyCacheException {
        try {
            this.f26687c.seek(j2);
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error reading %d bytes with offset %d from file[%d bytes] to buffer[%d bytes]", new Object[]{Integer.valueOf(i2), Long.valueOf(j2), Long.valueOf(a()), Integer.valueOf(bArr.length)}), e2);
        }
        return this.f26687c.read(bArr, 0, i2);
    }

    public synchronized long a() throws ProxyCacheException {
        try {
        } catch (IOException e2) {
            throw new ProxyCacheException("Error reading length of file " + this.f26685a, e2);
        }
        return (long) ((int) this.f26687c.length());
    }

    public synchronized void a(byte[] bArr, int i2) throws ProxyCacheException {
        try {
            if (!d()) {
                this.f26687c.seek(a());
                this.f26687c.write(bArr, 0, i2);
            } else {
                throw new ProxyCacheException("Error append cache: cache file " + this.f26685a + " is completed!");
            }
        } catch (IOException e2) {
            throw new ProxyCacheException(String.format("Error writing %d bytes to %s from buffer with size %d", new Object[]{Integer.valueOf(i2), this.f26687c, Integer.valueOf(bArr.length)}), e2);
        }
    }

    public synchronized void b() throws ProxyCacheException {
        try {
            this.f26687c.close();
            this.f26686b.a(this.f26685a);
        } catch (IOException e2) {
            throw new ProxyCacheException("Error closing file " + this.f26685a, e2);
        }
    }

    public synchronized void c() throws ProxyCacheException {
        if (!d()) {
            b();
            File file = new File(this.f26685a.getParentFile(), this.f26685a.getName().substring(0, this.f26685a.getName().length() - 9));
            if (this.f26685a.renameTo(file)) {
                this.f26685a = file;
                try {
                    this.f26687c = new RandomAccessFile(this.f26685a, "r");
                    this.f26686b.a(this.f26685a);
                } catch (IOException e2) {
                    throw new ProxyCacheException("Error opening " + this.f26685a + " as disc cache", e2);
                }
            } else {
                throw new ProxyCacheException("Error renaming file " + this.f26685a + " to " + file + " for completion!");
            }
        }
    }

    public synchronized boolean d() {
        return !a(this.f26685a);
    }
}
