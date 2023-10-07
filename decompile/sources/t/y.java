package t;

import android.content.Context;
import android.os.Build;
import android.view.PointerIcon;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    private Object f34523a;

    private y(Object obj) {
        this.f34523a = obj;
    }

    public static y a(Context context, int i2) {
        return Build.VERSION.SDK_INT >= 24 ? new y(PointerIcon.getSystemIcon(context, i2)) : new y((Object) null);
    }

    public Object a() {
        return this.f34523a;
    }
}
