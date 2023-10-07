package bl;

import android.graphics.Bitmap;
import cc.l;

class c implements l {

    /* renamed from: a  reason: collision with root package name */
    private final b f5748a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final h<a, Bitmap> f5749b = new h<>();

    static class a implements m {

        /* renamed from: a  reason: collision with root package name */
        private final b f5750a;

        /* renamed from: b  reason: collision with root package name */
        private int f5751b;

        /* renamed from: c  reason: collision with root package name */
        private int f5752c;

        /* renamed from: d  reason: collision with root package name */
        private Bitmap.Config f5753d;

        public a(b bVar) {
            this.f5750a = bVar;
        }

        public void a() {
            this.f5750a.a(this);
        }

        public void a(int i2, int i3, Bitmap.Config config) {
            this.f5751b = i2;
            this.f5752c = i3;
            this.f5753d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f5751b == aVar.f5751b && this.f5752c == aVar.f5752c && this.f5753d == aVar.f5753d;
        }

        public int hashCode() {
            int i2 = ((this.f5751b * 31) + this.f5752c) * 31;
            Bitmap.Config config = this.f5753d;
            return i2 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return c.c(this.f5751b, this.f5752c, this.f5753d);
        }
    }

    static class b extends d<a> {
        b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public a b() {
            return new a(this);
        }

        /* access modifiers changed from: package-private */
        public a a(int i2, int i3, Bitmap.Config config) {
            a aVar = (a) c();
            aVar.a(i2, i3, config);
            return aVar;
        }
    }

    c() {
    }

    static String c(int i2, int i3, Bitmap.Config config) {
        return "[" + i2 + "x" + i3 + "], " + config;
    }

    private static String d(Bitmap bitmap) {
        return c(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    public Bitmap a() {
        return this.f5749b.a();
    }

    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        return this.f5749b.a(this.f5748a.a(i2, i3, config));
    }

    public void a(Bitmap bitmap) {
        this.f5749b.a(this.f5748a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    public String b(int i2, int i3, Bitmap.Config config) {
        return c(i2, i3, config);
    }

    public String b(Bitmap bitmap) {
        return d(bitmap);
    }

    public int c(Bitmap bitmap) {
        return l.a(bitmap);
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f5749b;
    }
}
