package gw;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.s;

public class i {
    static d a() {
        return new l();
    }

    static d a(int i2) {
        return i2 != 0 ? i2 != 1 ? a() : new e() : new l();
    }

    public static void a(View view) {
        Drawable background = view.getBackground();
        if (background instanceof h) {
            a(view, (h) background);
        }
    }

    public static void a(View view, float f2) {
        Drawable background = view.getBackground();
        if (background instanceof h) {
            ((h) background).r(f2);
        }
    }

    public static void a(View view, h hVar) {
        if (hVar.S()) {
            hVar.q(s.d(view));
        }
    }

    static f b() {
        return new f();
    }
}
