package as;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import androidx.core.content.b;
import fg.i;
import mm.a;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f5572a = new h();

    private h() {
    }

    public static /* synthetic */ ColorStateList a(h hVar, Context context, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z2 = true;
        }
        return hVar.a(context, i2, z2);
    }

    private final Drawable b(int i2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColors(new int[]{i2, i2});
        return gradientDrawable;
    }

    public final ColorStateList a(Context context, int i2, boolean z2) {
        kotlin.jvm.internal.h.c(context, "context");
        int[][] iArr = {new int[]{-16842910}, new int[]{16842910, -16842913}, new int[]{16842910, 16842913}};
        int a2 = c.a(context, 16842807, (a) null, 2, (Object) null);
        int a3 = c.a(context, 16842806, (a) null, 2, (Object) null);
        int[] iArr2 = new int[3];
        iArr2[0] = a2;
        iArr2[1] = a3;
        if (z2) {
            i2 = b.a(i2, i.f27244a, 1, (Object) null) ? -1 : -16777216;
        }
        iArr2[2] = i2;
        return new ColorStateList(iArr, iArr2);
    }

    public final Drawable a(int i2) {
        Drawable b2 = b(i2);
        if (Build.VERSION.SDK_INT >= 21) {
            ColorStateList valueOf = ColorStateList.valueOf(i2);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842913}, b2);
            return new RippleDrawable(valueOf, stateListDrawable, b2);
        }
        StateListDrawable stateListDrawable2 = new StateListDrawable();
        Drawable mutate = b2.mutate();
        mutate.setAlpha((int) 76.5d);
        stateListDrawable2.addState(new int[]{16842910, 16842919}, mutate);
        stateListDrawable2.addState(new int[]{16842910, 16842913}, b2);
        return stateListDrawable2;
    }

    public final Drawable a(Context context, int i2, int i3) {
        kotlin.jvm.internal.h.c(context, "context");
        Drawable a2 = b.a(context, i2);
        if (a2 == null) {
            kotlin.jvm.internal.h.a();
        }
        a2.setColorFilter(i3, PorterDuff.Mode.SRC_IN);
        a2.setAlpha(Color.alpha(i3));
        kotlin.jvm.internal.h.a((Object) a2, "ContextCompat.getDrawabl… Color.alpha(color)\n    }");
        return a2;
    }
}
