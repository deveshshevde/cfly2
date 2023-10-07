package ke;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.cfly.uav_pro.R;
import en.a;
import kh.b;

public class d extends b.a {

    /* renamed from: a  reason: collision with root package name */
    private a f29990a;

    public d(a aVar) {
        this.f29990a = aVar;
    }

    public boolean a() {
        return getPosition() != null;
    }

    public float getAnchorU() {
        return 0.5f;
    }

    public float getAnchorV() {
        return 0.5f;
    }

    public Bitmap getIcon(Resources resources) {
        return BitmapFactory.decodeResource(resources, R.drawable.home_location);
    }

    public ef.a getPosition() {
        if (this.f29990a.R() == null) {
            return null;
        }
        return this.f29990a.R().a();
    }

    public float getRotation() {
        return 0.0f;
    }

    public boolean isFlat() {
        return true;
    }

    public boolean isVisible() {
        return a();
    }
}
