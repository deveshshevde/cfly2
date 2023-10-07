package kb;

import android.graphics.Bitmap;

public class g extends d<g> {

    /* renamed from: b  reason: collision with root package name */
    private final Bitmap f29965b;

    public g(f<g> fVar, int i2, int i3) {
        super(fVar);
        this.f29965b = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
    }

    /* access modifiers changed from: protected */
    public void b() {
        if (this.f29962a != null) {
            this.f29962a.a(this);
        } else {
            this.f29965b.recycle();
        }
    }

    public Bitmap d() {
        return this.f29965b;
    }
}
