package com.xeagle.android.vjoystick.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import java.lang.reflect.Method;

public class a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static String f25432a;

    /* renamed from: b  reason: collision with root package name */
    private final C0159a f25433b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f25434c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f25435d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f25436e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f25437f;

    /* renamed from: g  reason: collision with root package name */
    private View f25438g;

    /* renamed from: h  reason: collision with root package name */
    private View f25439h;

    /* renamed from: com.xeagle.android.vjoystick.view.a$a  reason: collision with other inner class name */
    public static class C0159a {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f25440a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f25441b;

        /* renamed from: c  reason: collision with root package name */
        private final int f25442c;

        /* renamed from: d  reason: collision with root package name */
        private final int f25443d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f25444e;

        /* renamed from: f  reason: collision with root package name */
        private final int f25445f;

        /* renamed from: g  reason: collision with root package name */
        private final int f25446g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f25447h;

        /* renamed from: i  reason: collision with root package name */
        private final float f25448i;

        private C0159a(Activity activity, boolean z2, boolean z3) {
            Resources resources = activity.getResources();
            boolean z4 = false;
            this.f25447h = resources.getConfiguration().orientation == 1;
            this.f25448i = a(activity);
            this.f25442c = a(resources, "status_bar_height");
            this.f25443d = a((Context) activity);
            int b2 = b(activity);
            this.f25445f = b2;
            this.f25446g = c(activity);
            this.f25444e = b2 > 0 ? true : z4;
            this.f25440a = z2;
            this.f25441b = z3;
        }

        private float a(Activity activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            int i2 = Build.VERSION.SDK_INT;
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            if (i2 >= 16) {
                defaultDisplay.getRealMetrics(displayMetrics);
            } else {
                defaultDisplay.getMetrics(displayMetrics);
            }
            return Math.min(((float) displayMetrics.widthPixels) / displayMetrics.density, ((float) displayMetrics.heightPixels) / displayMetrics.density);
        }

        private int a(Context context) {
            if (Build.VERSION.SDK_INT < 14) {
                return 0;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16843499, typedValue, true);
            return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }

        private int a(Resources resources, String str) {
            int identifier = resources.getIdentifier(str, "dimen", "android");
            if (identifier > 0) {
                return resources.getDimensionPixelSize(identifier);
            }
            return 0;
        }

        private int b(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !d(context)) {
                return 0;
            }
            return a(resources, this.f25447h ? "navigation_bar_height" : "navigation_bar_height_landscape");
        }

        private int c(Context context) {
            Resources resources = context.getResources();
            if (Build.VERSION.SDK_INT < 14 || !d(context)) {
                return 0;
            }
            return a(resources, "navigation_bar_width");
        }

        private boolean d(Context context) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            if (identifier == 0) {
                return !ViewConfiguration.get(context).hasPermanentMenuKey();
            }
            boolean z2 = resources.getBoolean(identifier);
            if ("1".equals(a.f25432a)) {
                return false;
            }
            if ("0".equals(a.f25432a)) {
                return true;
            }
            return z2;
        }

        public boolean a() {
            return this.f25448i >= 600.0f || this.f25447h;
        }

        public int b() {
            return this.f25442c;
        }

        public boolean c() {
            return this.f25444e;
        }

        public int d() {
            return this.f25445f;
        }

        public int e() {
            return this.f25446g;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class});
                declaredMethod.setAccessible(true);
                f25432a = (String) declaredMethod.invoke((Object) null, new Object[]{"qemu.hw.mainkeys"});
            } catch (Throwable unused) {
                f25432a = null;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public a(Activity activity) {
        Window window = activity.getWindow();
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (Build.VERSION.SDK_INT >= 19) {
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes(new int[]{16843759, 16843760});
            try {
                this.f25434c = obtainStyledAttributes.getBoolean(0, false);
                this.f25435d = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
                WindowManager.LayoutParams attributes = window.getAttributes();
                if ((67108864 & attributes.flags) != 0) {
                    this.f25434c = true;
                }
                if ((attributes.flags & AMapEngineUtils.HALF_MAX_P20_WIDTH) != 0) {
                    this.f25435d = true;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        C0159a aVar = new C0159a(activity, this.f25434c, this.f25435d);
        this.f25433b = aVar;
        if (!aVar.c()) {
            this.f25435d = false;
        }
        if (this.f25434c) {
            a(activity, viewGroup);
        }
        if (this.f25435d) {
            b(activity, viewGroup);
        }
    }

    private void a(Context context, ViewGroup viewGroup) {
        this.f25438g = new View(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.f25433b.b());
        layoutParams.gravity = 48;
        if (this.f25435d && !this.f25433b.a()) {
            layoutParams.rightMargin = this.f25433b.e();
        }
        this.f25438g.setLayoutParams(layoutParams);
        this.f25438g.setBackgroundColor(-1728053248);
        this.f25438g.setVisibility(8);
        viewGroup.addView(this.f25438g);
    }

    private void b(Context context, ViewGroup viewGroup) {
        FrameLayout.LayoutParams layoutParams;
        int i2;
        this.f25439h = new View(context);
        if (this.f25433b.a()) {
            layoutParams = new FrameLayout.LayoutParams(-1, this.f25433b.d());
            i2 = 80;
        } else {
            layoutParams = new FrameLayout.LayoutParams(this.f25433b.e(), -1);
            i2 = 5;
        }
        layoutParams.gravity = i2;
        this.f25439h.setLayoutParams(layoutParams);
        this.f25439h.setBackgroundColor(-1728053248);
        this.f25439h.setVisibility(8);
        viewGroup.addView(this.f25439h);
    }

    public void a(int i2) {
        b(i2);
        c(i2);
    }

    public void a(boolean z2) {
        this.f25436e = z2;
        if (this.f25434c) {
            this.f25438g.setVisibility(z2 ? 0 : 8);
        }
    }

    public void b(int i2) {
        if (this.f25434c) {
            this.f25438g.setBackgroundColor(i2);
        }
    }

    public void b(boolean z2) {
        this.f25437f = z2;
        if (this.f25435d) {
            this.f25439h.setVisibility(z2 ? 0 : 8);
        }
    }

    public void c(int i2) {
        if (this.f25435d) {
            this.f25439h.setBackgroundColor(i2);
        }
    }
}
