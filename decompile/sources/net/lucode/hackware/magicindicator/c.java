package net.lucode.hackware.magicindicator;

import androidx.viewpager.widget.ViewPager;

public class c {
    public static void a(final MagicIndicator magicIndicator, ViewPager viewPager) {
        viewPager.addOnPageChangeListener(new ViewPager.e() {
            public void onPageScrollStateChanged(int i2) {
                magicIndicator.b(i2);
            }

            public void onPageScrolled(int i2, float f2, int i3) {
                magicIndicator.a(i2, f2, i3);
            }

            public void onPageSelected(int i2) {
                magicIndicator.a(i2);
            }
        });
    }
}
