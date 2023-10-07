package ke;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.variables.l;
import en.a;
import kh.b;

public class c extends b.a {

    /* renamed from: a  reason: collision with root package name */
    private l f29989a;

    public c(a aVar) {
        this.f29989a = aVar.q();
    }

    public boolean a() {
        return this.f29989a.a();
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
        return this.f29989a.c();
    }

    public String getSnippet() {
        return "Home " + this.f29989a.d();
    }

    public String getTitle() {
        return "Home";
    }

    public boolean isVisible() {
        return this.f29989a.a();
    }
}
