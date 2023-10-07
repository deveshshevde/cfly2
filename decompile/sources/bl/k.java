package bl;

import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class k implements e {

    /* renamed from: a  reason: collision with root package name */
    private static final Bitmap.Config f5770a = Bitmap.Config.ARGB_8888;

    /* renamed from: b  reason: collision with root package name */
    private final l f5771b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Bitmap.Config> f5772c;

    /* renamed from: d  reason: collision with root package name */
    private final long f5773d;

    /* renamed from: e  reason: collision with root package name */
    private final a f5774e;

    /* renamed from: f  reason: collision with root package name */
    private long f5775f;

    /* renamed from: g  reason: collision with root package name */
    private long f5776g;

    /* renamed from: h  reason: collision with root package name */
    private int f5777h;

    /* renamed from: i  reason: collision with root package name */
    private int f5778i;

    /* renamed from: j  reason: collision with root package name */
    private int f5779j;

    /* renamed from: k  reason: collision with root package name */
    private int f5780k;

    private interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    private static final class b implements a {
        b() {
        }

        public void a(Bitmap bitmap) {
        }

        public void b(Bitmap bitmap) {
        }
    }

    public k(long j2) {
        this(j2, f(), g());
    }

    k(long j2, l lVar, Set<Bitmap.Config> set) {
        this.f5773d = j2;
        this.f5775f = j2;
        this.f5771b = lVar;
        this.f5772c = set;
        this.f5774e = new b();
    }

    private synchronized void a(long j2) {
        while (this.f5776g > j2) {
            Bitmap a2 = this.f5771b.a();
            if (a2 == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    e();
                }
                this.f5776g = 0;
                return;
            }
            this.f5774e.b(a2);
            this.f5776g -= (long) this.f5771b.c(a2);
            this.f5780k++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + this.f5771b.b(a2));
            }
            d();
            a2.recycle();
        }
    }

    private static void a(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    private static void b(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        c(bitmap);
    }

    private static Bitmap c(int i2, int i3, Bitmap.Config config) {
        if (config == null) {
            config = f5770a;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    private void c() {
        a(this.f5775f);
    }

    private static void c(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    private synchronized Bitmap d(int i2, int i3, Bitmap.Config config) {
        Bitmap a2;
        a(config);
        a2 = this.f5771b.a(i2, i3, config != null ? config : f5770a);
        if (a2 == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.f5771b.b(i2, i3, config));
            }
            this.f5778i++;
        } else {
            this.f5777h++;
            this.f5776g -= (long) this.f5771b.c(a2);
            this.f5774e.b(a2);
            b(a2);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.f5771b.b(i2, i3, config));
        }
        d();
        return a2;
    }

    private void d() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            e();
        }
    }

    private void e() {
        Log.v("LruBitmapPool", "Hits=" + this.f5777h + ", misses=" + this.f5778i + ", puts=" + this.f5779j + ", evictions=" + this.f5780k + ", currentSize=" + this.f5776g + ", maxSize=" + this.f5775f + "\nStrategy=" + this.f5771b);
    }

    private static l f() {
        return Build.VERSION.SDK_INT >= 19 ? new n() : new c();
    }

    private static Set<Bitmap.Config> g() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        if (Build.VERSION.SDK_INT >= 19) {
            hashSet.add((Object) null);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        Bitmap d2 = d(i2, i3, config);
        if (d2 == null) {
            return c(i2, i3, config);
        }
        d2.eraseColor(0);
        return d2;
    }

    public void a() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        a(0);
    }

    public void a(int i2) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i2);
        }
        if (i2 >= 40 || (Build.VERSION.SDK_INT >= 23 && i2 >= 20)) {
            a();
        } else if (i2 >= 20 || i2 == 15) {
            a(b() / 2);
        }
    }

    public synchronized void a(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && ((long) this.f5771b.c(bitmap)) <= this.f5775f) {
                        if (this.f5772c.contains(bitmap.getConfig())) {
                            int c2 = this.f5771b.c(bitmap);
                            this.f5771b.a(bitmap);
                            this.f5774e.a(bitmap);
                            this.f5779j++;
                            this.f5776g += (long) c2;
                            if (Log.isLoggable("LruBitmapPool", 2)) {
                                Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f5771b.b(bitmap));
                            }
                            d();
                            c();
                            return;
                        }
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f5771b.b(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f5772c.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new NullPointerException("Bitmap must not be null");
        }
    }

    public long b() {
        return this.f5775f;
    }

    public Bitmap b(int i2, int i3, Bitmap.Config config) {
        Bitmap d2 = d(i2, i3, config);
        return d2 == null ? c(i2, i3, config) : d2;
    }
}
