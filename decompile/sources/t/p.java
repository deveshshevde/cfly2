package t;

import android.view.View;
import android.view.ViewParent;

public class p {

    /* renamed from: a  reason: collision with root package name */
    private ViewParent f14084a;

    /* renamed from: b  reason: collision with root package name */
    private ViewParent f14085b;

    /* renamed from: c  reason: collision with root package name */
    private final View f14086c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f14087d;

    /* renamed from: e  reason: collision with root package name */
    private int[] f14088e;

    public p(View view) {
        this.f14086c = view;
    }

    private void a(int i2, ViewParent viewParent) {
        if (i2 == 0) {
            this.f14084a = viewParent;
        } else if (i2 == 1) {
            this.f14085b = viewParent;
        }
    }

    private boolean b(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        ViewParent d2;
        int i7;
        int i8;
        int[] iArr3;
        int[] iArr4 = iArr;
        if (!a() || (d2 = d(i6)) == null) {
            return false;
        }
        if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            if (iArr4 != null) {
                iArr4[0] = 0;
                iArr4[1] = 0;
            }
            return false;
        }
        if (iArr4 != null) {
            this.f14086c.getLocationInWindow(iArr4);
            i8 = iArr4[0];
            i7 = iArr4[1];
        } else {
            i8 = 0;
            i7 = 0;
        }
        if (iArr2 == null) {
            int[] d3 = d();
            d3[0] = 0;
            d3[1] = 0;
            iArr3 = d3;
        } else {
            iArr3 = iArr2;
        }
        af.a(d2, this.f14086c, i2, i3, i4, i5, i6, iArr3);
        if (iArr4 != null) {
            this.f14086c.getLocationInWindow(iArr4);
            iArr4[0] = iArr4[0] - i8;
            iArr4[1] = iArr4[1] - i7;
        }
        return true;
    }

    private ViewParent d(int i2) {
        if (i2 == 0) {
            return this.f14084a;
        }
        if (i2 != 1) {
            return null;
        }
        return this.f14085b;
    }

    private int[] d() {
        if (this.f14088e == null) {
            this.f14088e = new int[2];
        }
        return this.f14088e;
    }

    public void a(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        b(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public void a(boolean z2) {
        if (this.f14087d) {
            ac.F(this.f14086c);
        }
        this.f14087d = z2;
    }

    public boolean a() {
        return this.f14087d;
    }

    public boolean a(float f2, float f3) {
        ViewParent d2;
        if (!a() || (d2 = d(0)) == null) {
            return false;
        }
        return af.a(d2, this.f14086c, f2, f3);
    }

    public boolean a(float f2, float f3, boolean z2) {
        ViewParent d2;
        if (!a() || (d2 = d(0)) == null) {
            return false;
        }
        return af.a(d2, this.f14086c, f2, f3, z2);
    }

    public boolean a(int i2) {
        return d(i2) != null;
    }

    public boolean a(int i2, int i3) {
        if (a(i3)) {
            return true;
        }
        if (!a()) {
            return false;
        }
        View view = this.f14086c;
        for (ViewParent parent = this.f14086c.getParent(); parent != null; parent = parent.getParent()) {
            if (af.a(parent, view, this.f14086c, i2, i3)) {
                a(i3, parent);
                af.b(parent, view, this.f14086c, i2, i3);
                return true;
            }
            if (parent instanceof View) {
                view = (View) parent;
            }
        }
        return false;
    }

    public boolean a(int i2, int i3, int i4, int i5, int[] iArr) {
        return b(i2, i3, i4, i5, iArr, 0, (int[]) null);
    }

    public boolean a(int i2, int i3, int[] iArr, int[] iArr2) {
        return a(i2, i3, iArr, iArr2, 0);
    }

    public boolean a(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        ViewParent d2;
        int i5;
        int i6;
        if (!a() || (d2 = d(i4)) == null) {
            return false;
        }
        if (i2 != 0 || i3 != 0) {
            if (iArr2 != null) {
                this.f14086c.getLocationInWindow(iArr2);
                i6 = iArr2[0];
                i5 = iArr2[1];
            } else {
                i6 = 0;
                i5 = 0;
            }
            if (iArr == null) {
                iArr = d();
            }
            iArr[0] = 0;
            iArr[1] = 0;
            af.a(d2, this.f14086c, i2, i3, iArr, i4);
            if (iArr2 != null) {
                this.f14086c.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i6;
                iArr2[1] = iArr2[1] - i5;
            }
            return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public boolean b() {
        return a(0);
    }

    public boolean b(int i2) {
        return a(i2, 0);
    }

    public void c() {
        c(0);
    }

    public void c(int i2) {
        ViewParent d2 = d(i2);
        if (d2 != null) {
            af.a(d2, this.f14086c, i2);
            a(i2, (ViewParent) null);
        }
    }
}
