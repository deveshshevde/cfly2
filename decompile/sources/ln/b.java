package ln;

import android.graphics.drawable.Drawable;
import com.xeagle.android.widgets.wheelView.widget.WheelView;

public class b {
    public static Drawable a(WheelView.Skin skin, int i2, int i3, WheelView.c cVar, int i4, int i5) {
        return skin.equals(WheelView.Skin.Common) ? new a(i2, i3, cVar, i4, i5) : skin.equals(WheelView.Skin.Holo) ? new c(i2, i3, cVar, i4, i5) : new d(i2, i3, cVar);
    }
}
