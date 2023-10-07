package com.flypro.core.drone.variables;

import android.util.Log;
import com.flypro.core.drone.d;
import com.flypro.core.drone.f;
import en.a;
import java.util.Locale;
import org.greenrobot.eventbus.c;

public class g extends d {

    /* renamed from: a  reason: collision with root package name */
    private int f14303a;

    /* renamed from: c  reason: collision with root package name */
    private String f14304c;

    /* renamed from: d  reason: collision with root package name */
    private String f14305d;

    /* renamed from: e  reason: collision with root package name */
    private String f14306e;

    /* renamed from: f  reason: collision with root package name */
    private int f14307f;

    /* renamed from: g  reason: collision with root package name */
    private int f14308g;

    /* renamed from: h  reason: collision with root package name */
    private String f14309h;

    public g(a aVar) {
        super(aVar);
    }

    public String a() {
        return this.f14304c;
    }

    public void a(int i2) {
        this.f14303a = i2;
    }

    public void a(int i2, int i3, int i4) {
        this.f14309h = String.format(Locale.US, "%08x%08x%08x", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        Log.i("LOOK_LOG", "setSnId: " + this.f14309h);
    }

    public String b() {
        return this.f14305d;
    }

    public void b(int i2) {
        this.f14308g = i2;
    }

    public String c() {
        return this.f14309h;
    }

    public void c(int i2) {
        this.f14307f = i2;
    }

    public String d() {
        return this.f14306e;
    }

    public void d(int i2) {
        c a2;
        f fVar;
        if (i2 == 0) {
            Log.e("Drone", "setTime: ====time is null");
            return;
        }
        this.f14304c = String.format(Locale.US, "%d%02d%02d", new Object[]{Integer.valueOf((i2 >> 16) & 65535), Integer.valueOf((i2 >> 8) & 255), Integer.valueOf(i2 & 255)});
        Log.i("ServeTest", "setTime:=====active=== " + (this.f14304c.substring(0, 4) + "-" + this.f14304c.substring(4, 6) + "-" + this.f14304c.substring(6, 8)));
        int i3 = this.f14308g;
        if (i3 == 3 && this.f14307f == 1) {
            a2 = c.a();
            fVar = new f("battery");
        } else if (i3 == 3 && this.f14307f == 2) {
            a2 = c.a();
            fVar = new f("drone");
        } else {
            return;
        }
        a2.d(fVar);
    }

    public void e(int i2) {
        this.f14305d = String.format(Locale.US, "%d%02d%02d", new Object[]{Integer.valueOf((i2 >> 16) & 65535), Integer.valueOf((i2 >> 8) & 255), Integer.valueOf(i2 & 255)});
    }

    public void f(int i2) {
        this.f14306e = String.format(Locale.US, "%s0%d%s", new Object[]{Character.valueOf((char) ((i2 >> 24) & 255)), Integer.valueOf((i2 >> 8) & 65535), Character.valueOf((char) (i2 & 255))});
    }
}
