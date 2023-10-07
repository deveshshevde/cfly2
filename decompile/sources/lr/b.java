package lr;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static int f30988a;

    /* renamed from: b  reason: collision with root package name */
    public static int f30989b;

    /* renamed from: c  reason: collision with root package name */
    public static float f30990c;

    /* renamed from: d  reason: collision with root package name */
    public static int f30991d;

    /* renamed from: e  reason: collision with root package name */
    public static int f30992e;

    public static int a(float f2) {
        return (int) ((f2 * f30990c) + 0.5f);
    }

    public static void a(Context context) {
        if (context != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            f30988a = displayMetrics.widthPixels;
            f30989b = displayMetrics.heightPixels;
            f30990c = displayMetrics.density;
            f30991d = (int) (((float) f30988a) / displayMetrics.density);
            f30992e = (int) (((float) f30989b) / displayMetrics.density);
        }
    }
}
