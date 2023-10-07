package af;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, Lock> f61a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final File f62b;

    /* renamed from: c  reason: collision with root package name */
    private final Lock f63c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f64d;

    /* renamed from: e  reason: collision with root package name */
    private FileChannel f65e;

    public a(String str, File file, boolean z2) {
        File file2 = new File(file, str + ".lck");
        this.f62b = file2;
        this.f63c = a(file2.getAbsolutePath());
        this.f64d = z2;
    }

    private static Lock a(String str) {
        Lock lock;
        Map<String, Lock> map = f61a;
        synchronized (map) {
            lock = map.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                map.put(str, lock);
            }
        }
        return lock;
    }

    public void a() {
        this.f63c.lock();
        if (this.f64d) {
            try {
                FileChannel channel = new FileOutputStream(this.f62b).getChannel();
                this.f65e = channel;
                channel.lock();
            } catch (IOException e2) {
                throw new IllegalStateException("Unable to grab copy lock.", e2);
            }
        }
    }

    public void b() {
        FileChannel fileChannel = this.f65e;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.f63c.unlock();
    }
}
