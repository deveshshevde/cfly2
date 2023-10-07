package bm;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final int f5809a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5810b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f5811c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5812d;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final int f5813a = (Build.VERSION.SDK_INT < 26 ? 4 : 1);

        /* renamed from: b  reason: collision with root package name */
        final Context f5814b;

        /* renamed from: c  reason: collision with root package name */
        ActivityManager f5815c;

        /* renamed from: d  reason: collision with root package name */
        c f5816d;

        /* renamed from: e  reason: collision with root package name */
        float f5817e = 2.0f;

        /* renamed from: f  reason: collision with root package name */
        float f5818f = ((float) f5813a);

        /* renamed from: g  reason: collision with root package name */
        float f5819g = 0.4f;

        /* renamed from: h  reason: collision with root package name */
        float f5820h = 0.33f;

        /* renamed from: i  reason: collision with root package name */
        int f5821i = 4194304;

        public a(Context context) {
            this.f5814b = context;
            this.f5815c = (ActivityManager) context.getSystemService("activity");
            this.f5816d = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && i.a(this.f5815c)) {
                this.f5818f = 0.0f;
            }
        }

        public i a() {
            return new i(this);
        }
    }

    private static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        private final DisplayMetrics f5822a;

        b(DisplayMetrics displayMetrics) {
            this.f5822a = displayMetrics;
        }

        public int a() {
            return this.f5822a.widthPixels;
        }

        public int b() {
            return this.f5822a.heightPixels;
        }
    }

    interface c {
        int a();

        int b();
    }

    i(a aVar) {
        this.f5811c = aVar.f5814b;
        int i2 = a(aVar.f5815c) ? aVar.f5821i / 2 : aVar.f5821i;
        this.f5812d = i2;
        int a2 = a(aVar.f5815c, aVar.f5819g, aVar.f5820h);
        float a3 = (float) (aVar.f5816d.a() * aVar.f5816d.b() * 4);
        int round = Math.round(aVar.f5818f * a3);
        int round2 = Math.round(a3 * aVar.f5817e);
        int i3 = a2 - i2;
        int i4 = round2 + round;
        if (i4 <= i3) {
            this.f5810b = round2;
            this.f5809a = round;
        } else {
            float f2 = ((float) i3) / (aVar.f5818f + aVar.f5817e);
            this.f5810b = Math.round(aVar.f5817e * f2);
            this.f5809a = Math.round(f2 * aVar.f5818f);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(a(this.f5810b));
            sb.append(", pool size: ");
            sb.append(a(this.f5809a));
            sb.append(", byte array size: ");
            sb.append(a(i2));
            sb.append(", memory class limited? ");
            sb.append(i4 > a2);
            sb.append(", max size: ");
            sb.append(a(a2));
            sb.append(", memoryClass: ");
            sb.append(aVar.f5815c.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(a(aVar.f5815c));
            Log.d("MemorySizeCalculator", sb.toString());
        }
    }

    private static int a(ActivityManager activityManager, float f2, float f3) {
        boolean a2 = a(activityManager);
        float memoryClass = (float) (activityManager.getMemoryClass() * 1024 * 1024);
        if (a2) {
            f2 = f3;
        }
        return Math.round(memoryClass * f2);
    }

    private String a(int i2) {
        return Formatter.formatFileSize(this.f5811c, (long) i2);
    }

    static boolean a(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    public int a() {
        return this.f5810b;
    }

    public int b() {
        return this.f5809a;
    }

    public int c() {
        return this.f5812d;
    }
}
