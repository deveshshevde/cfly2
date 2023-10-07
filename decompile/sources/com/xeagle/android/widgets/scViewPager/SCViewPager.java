package com.xeagle.android.widgets.scViewPager;

import android.content.Context;
import android.util.AttributeSet;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;

public class SCViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<b> f25970a = new ArrayList<>();

    public SCViewPager(Context context) {
        super(context);
    }

    public SCViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onPageScrolled(int i2, float f2, int i3) {
        super.onPageScrolled(i2, f2, i3);
        for (int i4 = 0; i4 < this.f25970a.size(); i4++) {
            this.f25970a.get(i4).a(i2, f2);
        }
    }
}
