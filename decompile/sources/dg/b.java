package dg;

import android.util.Log;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public class b implements c {

    /* renamed from: a  reason: collision with root package name */
    public static final b f26702a = new b();

    /* renamed from: b  reason: collision with root package name */
    private String f26703b = IjkMediaMeta.IJKM_VAL_TYPE__UNKNOWN;

    /* renamed from: c  reason: collision with root package name */
    private int f26704c = 5;

    private b() {
    }

    public static b a() {
        return f26702a;
    }

    private String a(String str) {
        if (this.f26703b == null) {
            return str;
        }
        return this.f26703b + ":" + str;
    }

    private void a(int i2, String str, String str2) {
        Log.println(i2, a(str), str2);
    }

    public void a(String str, String str2) {
        a(2, str, str2);
    }

    public boolean a(int i2) {
        return this.f26704c <= i2;
    }

    public void b(String str, String str2) {
        a(5, str, str2);
    }
}
