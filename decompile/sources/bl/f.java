package bl;

import android.graphics.Bitmap;

public class f implements e {
    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        return Bitmap.createBitmap(i2, i3, config);
    }

    public void a() {
    }

    public void a(int i2) {
    }

    public void a(Bitmap bitmap) {
        bitmap.recycle();
    }

    public Bitmap b(int i2, int i3, Bitmap.Config config) {
        return a(i2, i3, config);
    }
}
