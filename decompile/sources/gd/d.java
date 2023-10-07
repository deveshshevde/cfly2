package gd;

import android.text.Layout;
import android.text.TextUtils;
import com.blankj.utilcode.constant.MemoryConstants;
import com.google.android.exoplayer2.util.ad;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private String f13119a;

    /* renamed from: b  reason: collision with root package name */
    private String f13120b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f13121c;

    /* renamed from: d  reason: collision with root package name */
    private String f13122d;

    /* renamed from: e  reason: collision with root package name */
    private String f13123e;

    /* renamed from: f  reason: collision with root package name */
    private int f13124f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f13125g;

    /* renamed from: h  reason: collision with root package name */
    private int f13126h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f13127i;

    /* renamed from: j  reason: collision with root package name */
    private int f13128j;

    /* renamed from: k  reason: collision with root package name */
    private int f13129k;

    /* renamed from: l  reason: collision with root package name */
    private int f13130l;

    /* renamed from: m  reason: collision with root package name */
    private int f13131m;

    /* renamed from: n  reason: collision with root package name */
    private int f13132n;

    /* renamed from: o  reason: collision with root package name */
    private float f13133o;

    /* renamed from: p  reason: collision with root package name */
    private Layout.Alignment f13134p;

    public d() {
        a();
    }

    private static int a(int i2, String str, String str2, int i3) {
        if (str.isEmpty() || i2 == -1) {
            return i2;
        }
        if (str.equals(str2)) {
            return i2 + i3;
        }
        return -1;
    }

    public int a(String str, String str2, String[] strArr, String str3) {
        if (this.f13119a.isEmpty() && this.f13120b.isEmpty() && this.f13121c.isEmpty() && this.f13122d.isEmpty()) {
            return TextUtils.isEmpty(str2) ? 1 : 0;
        }
        int a2 = a(a(a(0, this.f13119a, str, (int) MemoryConstants.GB), this.f13120b, str2, 2), this.f13122d, str3, 4);
        if (a2 == -1 || !Arrays.asList(strArr).containsAll(this.f13121c)) {
            return 0;
        }
        return a2 + (this.f13121c.size() * 4);
    }

    public d a(int i2) {
        this.f13124f = i2;
        this.f13125g = true;
        return this;
    }

    public d a(boolean z2) {
        this.f13129k = z2 ? 1 : 0;
        return this;
    }

    @EnsuresNonNull({"targetId", "targetTag", "targetClasses", "targetVoice"})
    public void a() {
        this.f13119a = "";
        this.f13120b = "";
        this.f13121c = Collections.emptyList();
        this.f13122d = "";
        this.f13123e = null;
        this.f13125g = false;
        this.f13127i = false;
        this.f13128j = -1;
        this.f13129k = -1;
        this.f13130l = -1;
        this.f13131m = -1;
        this.f13132n = -1;
        this.f13134p = null;
    }

    public void a(String str) {
        this.f13119a = str;
    }

    public void a(String[] strArr) {
        this.f13121c = Arrays.asList(strArr);
    }

    public int b() {
        int i2 = this.f13130l;
        if (i2 == -1 && this.f13131m == -1) {
            return -1;
        }
        int i3 = 0;
        int i4 = i2 == 1 ? 1 : 0;
        if (this.f13131m == 1) {
            i3 = 2;
        }
        return i4 | i3;
    }

    public d b(int i2) {
        this.f13126h = i2;
        this.f13127i = true;
        return this;
    }

    public d b(boolean z2) {
        this.f13130l = z2 ? 1 : 0;
        return this;
    }

    public void b(String str) {
        this.f13120b = str;
    }

    public d c(boolean z2) {
        this.f13131m = z2 ? 1 : 0;
        return this;
    }

    public void c(String str) {
        this.f13122d = str;
    }

    public boolean c() {
        return this.f13128j == 1;
    }

    public d d(String str) {
        this.f13123e = ad.d(str);
        return this;
    }

    public boolean d() {
        return this.f13129k == 1;
    }

    public String e() {
        return this.f13123e;
    }

    public int f() {
        if (this.f13125g) {
            return this.f13124f;
        }
        throw new IllegalStateException("Font color not defined");
    }

    public boolean g() {
        return this.f13125g;
    }

    public int h() {
        if (this.f13127i) {
            return this.f13126h;
        }
        throw new IllegalStateException("Background color not defined.");
    }

    public boolean i() {
        return this.f13127i;
    }

    public Layout.Alignment j() {
        return this.f13134p;
    }

    public int k() {
        return this.f13132n;
    }

    public float l() {
        return this.f13133o;
    }
}
