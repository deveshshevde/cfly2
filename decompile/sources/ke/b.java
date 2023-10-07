package ke;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.Log;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.variables.GuidedPoint;
import com.flypro.core.drone.variables.j;
import java.util.ArrayList;
import java.util.List;
import kh.a;
import kh.b;
import kh.c;

public class b extends b.a implements a.e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f29985a = "b";

    /* renamed from: b  reason: collision with root package name */
    private GuidedPoint f29986b;

    /* renamed from: c  reason: collision with root package name */
    private j f29987c;

    /* renamed from: d  reason: collision with root package name */
    private Context f29988d;

    public b(en.a aVar, Context context) {
        this.f29986b = aVar.w();
        this.f29987c = aVar.b();
        this.f29988d = context;
    }

    public float getAnchorU() {
        return 0.5f;
    }

    public float getAnchorV() {
        return 0.5f;
    }

    public Bitmap getIcon(Resources resources) {
        return c.a((int) R.drawable.ic_wp_map, "Guided", "", resources);
    }

    public List<ef.a> getPathPoints() {
        ArrayList arrayList = new ArrayList();
        if (this.f29986b.c()) {
            if (this.f29987c.a()) {
                arrayList.add(this.f29987c.b());
            }
            arrayList.add(this.f29986b.a());
        }
        return arrayList;
    }

    public ef.a getPosition() {
        return this.f29986b.a();
    }

    public boolean isDraggable() {
        return true;
    }

    public boolean isVisible() {
        return this.f29986b.c();
    }

    public void setPosition(ef.a aVar) {
        try {
            this.f29986b.b(this.f29988d, aVar);
        } catch (Exception e2) {
            Log.e(f29985a, "Unable to update guided point position.", e2);
        }
    }
}
