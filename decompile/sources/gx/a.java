package gx;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.R;
import f.d;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f13263a = {16842752, R.attr.theme};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f13264b = {R.attr.materialThemeOverlay};

    private static int a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f13263a);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
        obtainStyledAttributes.recycle();
        return resourceId != 0 ? resourceId : resourceId2;
    }

    public static Context a(Context context, AttributeSet attributeSet, int i2, int i3) {
        int b2 = b(context, attributeSet, i2, i3);
        boolean z2 = (context instanceof d) && ((d) context).a() == b2;
        if (b2 == 0 || z2) {
            return context;
        }
        d dVar = new d(context, b2);
        int a2 = a(context, attributeSet);
        if (a2 != 0) {
            dVar.getTheme().applyStyle(a2, true);
        }
        return dVar;
    }

    private static int b(Context context, AttributeSet attributeSet, int i2, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f13264b, i2, i3);
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }
}
