package bs;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import c.a;
import f.d;
import l.f;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f5986a = true;

    public static Drawable a(Context context, int i2, Resources.Theme theme) {
        return a(context, context, i2, theme);
    }

    public static Drawable a(Context context, Context context2, int i2) {
        return a(context, context2, i2, (Resources.Theme) null);
    }

    private static Drawable a(Context context, Context context2, int i2, Resources.Theme theme) {
        try {
            if (f5986a) {
                return b(context2, i2, theme);
            }
        } catch (NoClassDefFoundError unused) {
            f5986a = false;
        } catch (IllegalStateException e2) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return androidx.core.content.b.a(context2, i2);
            }
            throw e2;
        } catch (Resources.NotFoundException unused2) {
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return c(context2, i2, theme);
    }

    private static Drawable b(Context context, int i2, Resources.Theme theme) {
        if (theme != null) {
            context = new d(context, theme);
        }
        return a.b(context, i2);
    }

    private static Drawable c(Context context, int i2, Resources.Theme theme) {
        return f.a(context.getResources(), i2, theme);
    }
}
