package ll;

import android.content.Context;

public class c extends b {

    /* renamed from: f  reason: collision with root package name */
    private int f30938f;

    /* renamed from: g  reason: collision with root package name */
    private int f30939g;

    /* renamed from: h  reason: collision with root package name */
    private String f30940h;

    public c(Context context, int i2, int i3) {
        this(context, i2, i3, (String) null);
    }

    public c(Context context, int i2, int i3, int i4, String str) {
        super(context, i2);
        this.f30938f = i3;
        this.f30939g = i4;
        this.f30940h = str;
    }

    public c(Context context, int i2, int i3, String str) {
        this(context, -1, i2, i3, str);
    }

    public int a() {
        return (this.f30939g - this.f30938f) + 1;
    }

    public CharSequence b(int i2) {
        if (i2 < 0 || i2 >= a()) {
            return null;
        }
        int i3 = this.f30938f + i2;
        String str = this.f30940h;
        if (str == null) {
            return Integer.toString(i3);
        }
        return String.format(str, new Object[]{Integer.valueOf(i3)});
    }

    public int c(int i2) {
        if (i2 >= 0 && i2 < a()) {
            return this.f30938f + i2;
        }
        throw new IllegalArgumentException("Index is out of range.");
    }

    public int d(int i2) {
        int i3 = this.f30938f;
        if (i2 < i3 || i2 > this.f30939g) {
            return -1;
        }
        return i2 - i3;
    }
}
