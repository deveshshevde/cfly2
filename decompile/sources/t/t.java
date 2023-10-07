package t;

import android.view.View;
import android.view.ViewGroup;

public class t {

    /* renamed from: a  reason: collision with root package name */
    private int f14089a;

    /* renamed from: b  reason: collision with root package name */
    private int f14090b;

    public t(ViewGroup viewGroup) {
    }

    public int a() {
        return this.f14089a | this.f14090b;
    }

    public void a(View view) {
        a(view, 0);
    }

    public void a(View view, int i2) {
        if (i2 == 1) {
            this.f14090b = 0;
        } else {
            this.f14089a = 0;
        }
    }

    public void a(View view, View view2, int i2) {
        a(view, view2, i2, 0);
    }

    public void a(View view, View view2, int i2, int i3) {
        if (i3 == 1) {
            this.f14090b = i2;
        } else {
            this.f14089a = i2;
        }
    }
}
