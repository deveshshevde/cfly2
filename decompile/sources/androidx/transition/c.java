package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;

public class c extends aq {

    /* renamed from: a  reason: collision with root package name */
    private float f4815a = 3.0f;

    private static float a(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        return (float) Math.sqrt((double) ((f6 * f6) + (f7 * f7)));
    }

    public long a(ViewGroup viewGroup, Transition transition, y yVar, y yVar2) {
        int i2;
        int i3;
        int i4;
        if (yVar == null && yVar2 == null) {
            return 0;
        }
        if (yVar2 == null || b(yVar) == 0) {
            i2 = -1;
        } else {
            yVar = yVar2;
            i2 = 1;
        }
        int c2 = c(yVar);
        int d2 = d(yVar);
        Rect o2 = transition.o();
        if (o2 != null) {
            i4 = o2.centerX();
            i3 = o2.centerY();
        } else {
            int[] iArr = new int[2];
            viewGroup.getLocationOnScreen(iArr);
            int round = Math.round(((float) (iArr[0] + (viewGroup.getWidth() / 2))) + viewGroup.getTranslationX());
            i3 = Math.round(((float) (iArr[1] + (viewGroup.getHeight() / 2))) + viewGroup.getTranslationY());
            i4 = round;
        }
        float a2 = a((float) c2, (float) d2, (float) i4, (float) i3) / a(0.0f, 0.0f, (float) viewGroup.getWidth(), (float) viewGroup.getHeight());
        long b2 = transition.b();
        if (b2 < 0) {
            b2 = 300;
        }
        return (long) Math.round((((float) (b2 * ((long) i2))) / this.f4815a) * a2);
    }
}
