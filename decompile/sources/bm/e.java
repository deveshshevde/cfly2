package bm;

import android.util.Log;
import bi.a;
import bm.a;
import com.bumptech.glide.load.c;
import java.io.File;
import java.io.IOException;

public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private final j f5801a;

    /* renamed from: b  reason: collision with root package name */
    private final File f5802b;

    /* renamed from: c  reason: collision with root package name */
    private final long f5803c;

    /* renamed from: d  reason: collision with root package name */
    private final c f5804d = new c();

    /* renamed from: e  reason: collision with root package name */
    private a f5805e;

    @Deprecated
    protected e(File file, long j2) {
        this.f5802b = file;
        this.f5803c = j2;
        this.f5801a = new j();
    }

    private synchronized a a() throws IOException {
        if (this.f5805e == null) {
            this.f5805e = a.a(this.f5802b, 1, 1, this.f5803c);
        }
        return this.f5805e;
    }

    public static a a(File file, long j2) {
        return new e(file, j2);
    }

    public File a(c cVar) {
        String a2 = this.f5801a.a(cVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + a2 + " for for Key: " + cVar);
        }
        try {
            a.d a3 = a().a(a2);
            if (a3 != null) {
                return a3.a(0);
            }
            return null;
        } catch (IOException e2) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e2);
            return null;
        }
    }

    public void a(c cVar, a.b bVar) {
        a.b b2;
        String a2 = this.f5801a.a(cVar);
        this.f5804d.a(a2);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + a2 + " for for Key: " + cVar);
            }
            try {
                bi.a a3 = a();
                if (a3.a(a2) == null) {
                    b2 = a3.b(a2);
                    if (b2 != null) {
                        if (bVar.a(b2.a(0))) {
                            b2.a();
                        }
                        b2.c();
                        this.f5804d.b(a2);
                        return;
                    }
                    throw new IllegalStateException("Had two simultaneous puts for: " + a2);
                }
            } catch (IOException e2) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e2);
                }
            } catch (Throwable th) {
                b2.c();
                throw th;
            }
        } finally {
            this.f5804d.b(a2);
        }
    }
}
