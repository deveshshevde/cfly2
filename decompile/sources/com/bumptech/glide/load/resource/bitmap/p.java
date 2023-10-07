package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f10488a = (Build.VERSION.SDK_INT < 29);

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f10489b;

    /* renamed from: c  reason: collision with root package name */
    private static final File f10490c = new File("/proc/self/fd");

    /* renamed from: d  reason: collision with root package name */
    private static volatile p f10491d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile int f10492e = -1;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f10493f = c();

    /* renamed from: g  reason: collision with root package name */
    private final int f10494g;

    /* renamed from: h  reason: collision with root package name */
    private final int f10495h;

    /* renamed from: i  reason: collision with root package name */
    private int f10496i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10497j = true;

    /* renamed from: k  reason: collision with root package name */
    private final AtomicBoolean f10498k = new AtomicBoolean(false);

    static {
        boolean z2 = true;
        if (Build.VERSION.SDK_INT < 26) {
            z2 = false;
        }
        f10489b = z2;
    }

    p() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f10494g = 20000;
            this.f10495h = 0;
            return;
        }
        this.f10494g = 700;
        this.f10495h = 128;
    }

    public static p a() {
        if (f10491d == null) {
            synchronized (p.class) {
                if (f10491d == null) {
                    f10491d = new p();
                }
            }
        }
        return f10491d;
    }

    private boolean b() {
        return f10488a && !this.f10498k.get();
    }

    private static boolean c() {
        return !e() && !d();
    }

    private static boolean d() {
        if (Build.VERSION.SDK_INT != 27) {
            return false;
        }
        return Arrays.asList(new String[]{"LG-M250", "LG-M320", "LG-Q710AL", "LG-Q710PL", "LGM-K121K", "LGM-K121L", "LGM-K121S", "LGM-X320K", "LGM-X320L", "LGM-X320S", "LGM-X401L", "LGM-X401S", "LM-Q610.FG", "LM-Q610.FGN", "LM-Q617.FG", "LM-Q617.FGN", "LM-Q710.FG", "LM-Q710.FGN", "LM-X220PM", "LM-X220QMA", "LM-X410PM"}).contains(Build.MODEL);
    }

    private static boolean e() {
        if (Build.VERSION.SDK_INT != 26) {
            return false;
        }
        for (String startsWith : Arrays.asList(new String[]{"SC-04J", "SM-N935", "SM-J720", "SM-G570F", "SM-G570M", "SM-G960", "SM-G965", "SM-G935", "SM-G930", "SM-A520", "SM-A720F", "moto e5", "moto e5 play", "moto e5 plus", "moto e5 cruise", "moto g(6) forge", "moto g(6) play"})) {
            if (Build.MODEL.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    private int f() {
        return f10492e != -1 ? f10492e : this.f10494g;
    }

    private synchronized boolean g() {
        boolean z2 = true;
        int i2 = this.f10496i + 1;
        this.f10496i = i2;
        if (i2 >= 50) {
            this.f10496i = 0;
            int length = f10490c.list().length;
            long f2 = (long) f();
            if (((long) length) >= f2) {
                z2 = false;
            }
            this.f10497j = z2;
            if (!z2 && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + f2);
            }
        }
        return this.f10497j;
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2, int i3, BitmapFactory.Options options, boolean z2, boolean z3) {
        boolean a2 = a(i2, i3, z2, z3);
        if (a2) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return a2;
    }

    public boolean a(int i2, int i3, boolean z2, boolean z3) {
        if (!z2) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by caller");
            }
            return false;
        } else if (!this.f10493f) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by device model");
            }
            return false;
        } else if (!f10489b) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by sdk");
            }
            return false;
        } else if (b()) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by app state");
            }
            return false;
        } else if (z3) {
            if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
            }
            return false;
        } else {
            int i4 = this.f10495h;
            if (i2 < i4) {
                if (Log.isLoggable("HardwareConfig", 2)) {
                    Log.v("HardwareConfig", "Hardware config disallowed because width is too small");
                }
                return false;
            } else if (i3 < i4) {
                if (Log.isLoggable("HardwareConfig", 2)) {
                    Log.v("HardwareConfig", "Hardware config disallowed because height is too small");
                }
                return false;
            } else if (g()) {
                return true;
            } else {
                if (Log.isLoggable("HardwareConfig", 2)) {
                    Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
                }
                return false;
            }
        }
    }
}
