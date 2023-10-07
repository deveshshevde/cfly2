package net.lucode.hackware.magicindicator.buildins.commonnavigator.titles;

import android.content.Context;
import my.a;

public class ColorTransitionPagerTitleView extends SimplePagerTitleView {
    public ColorTransitionPagerTitleView(Context context) {
        super(context);
    }

    public void a(int i2, int i3) {
    }

    public void a(int i2, int i3, float f2, boolean z2) {
        setTextColor(a.a(f2, this.f31527b, this.f31526a));
    }

    public void b(int i2, int i3) {
    }

    public void b(int i2, int i3, float f2, boolean z2) {
        setTextColor(a.a(f2, this.f31526a, this.f31527b));
    }
}
