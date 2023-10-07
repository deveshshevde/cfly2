package ke;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.cfly.uav_pro.R;
import ef.a;
import kh.b;

public class e extends b.a {

    /* renamed from: a  reason: collision with root package name */
    private a f29991a;

    public void a(a aVar) {
        this.f29991a = aVar;
    }

    public float getAnchorU() {
        return 0.5f;
    }

    public float getAnchorV() {
        return 0.5f;
    }

    public Bitmap getIcon(Resources resources) {
        return BitmapFactory.decodeResource(resources, R.drawable.quad);
    }

    public a getPosition() {
        return this.f29991a;
    }

    public float getRotation() {
        return 0.0f;
    }

    public boolean isFlat() {
        return true;
    }

    public boolean isVisible() {
        return true;
    }
}
