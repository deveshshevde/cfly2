package ke;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.cfly.uav_pro.R;
import kh.b;

public class a extends b.a {

    /* renamed from: a  reason: collision with root package name */
    private en.a f29981a;

    /* renamed from: b  reason: collision with root package name */
    private int f29982b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f29983c = R.drawable.drone_icon1;

    /* renamed from: d  reason: collision with root package name */
    private float f29984d;

    public a(en.a aVar) {
        this.f29981a = aVar;
    }

    public void a(float f2) {
        if (f2 == 0.0f) {
            f2 = (float) this.f29981a.u().c();
        }
        this.f29984d = f2;
    }

    public float getAnchorU() {
        return 0.5f;
    }

    public float getAnchorV() {
        return 0.5f;
    }

    public Bitmap getIcon(Resources resources) {
        return BitmapFactory.decodeResource(resources, this.f29981a.a() ? R.drawable.drone_loc : R.drawable.drone_loc_nor);
    }

    public ef.a getPosition() {
        return this.f29981a.b().b();
    }

    public float getRotation() {
        float f2 = this.f29984d;
        return f2 == 0.0f ? (float) this.f29981a.u().c() : f2;
    }

    public boolean isFlat() {
        return true;
    }

    public boolean isVisible() {
        return true;
    }
}
