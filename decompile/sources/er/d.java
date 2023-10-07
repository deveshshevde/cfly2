package er;

import android.content.Context;
import android.os.Build;

public abstract class d {
    public static d a(Context context) {
        return Build.VERSION.SDK_INT < 9 ? new c(context) : Build.VERSION.SDK_INT < 14 ? new a(context) : new b(context);
    }

    public abstract void a(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11);

    public abstract void a(boolean z2);

    public abstract boolean a();

    public abstract boolean b();

    public abstract int c();

    public abstract int d();
}
