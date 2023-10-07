package da;

import com.danikula.videocache.f;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f26688a = Executors.newSingleThreadExecutor();

    private class a implements Callable<Void> {

        /* renamed from: b  reason: collision with root package name */
        private final File f26690b;

        public a(File file) {
            this.f26690b = file;
        }

        /* renamed from: a */
        public Void call() throws Exception {
            e.this.b(this.f26690b);
            return null;
        }
    }

    private void a(List<File> list) {
        long b2 = b(list);
        int size = list.size();
        for (File next : list) {
            if (!a(next, b2, size)) {
                long length = next.length();
                if (next.delete()) {
                    size--;
                    b2 -= length;
                    f.a("Cache file " + next + " is deleted because it exceeds cache limit");
                } else {
                    f.c("Error deleting file " + next + " for trimming cache");
                }
            }
        }
    }

    private long b(List<File> list) {
        long j2 = 0;
        for (File length : list) {
            j2 += length.length();
        }
        return j2;
    }

    /* access modifiers changed from: private */
    public void b(File file) throws IOException {
        d.c(file);
        a(d.b(file.getParentFile()));
    }

    public void a(File file) throws IOException {
        this.f26688a.submit(new a(file));
    }

    /* access modifiers changed from: protected */
    public abstract boolean a(File file, long j2, int i2);
}
