package com.xeagle.android.widgets.scViewPager;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

public class DotsView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private List<ImageView> f25966a;

    /* renamed from: b  reason: collision with root package name */
    private int f25967b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f25968c;

    /* renamed from: d  reason: collision with root package name */
    private int f25969d;

    public DotsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void a(int i2) {
        Resources resources = getResources();
        int i3 = 0;
        while (i3 < this.f25967b) {
            this.f25966a.get(i3).setImageDrawable(resources.getDrawable(i3 == i2 ? this.f25968c : this.f25969d));
            i3++;
        }
    }

    public void a(int i2, int i3) {
        this.f25968c = i2;
        this.f25969d = i3;
    }

    public void setNumberOfPage(int i2) {
        this.f25967b = i2;
        this.f25966a = new ArrayList();
        for (int i3 = 0; i3 < this.f25967b; i3++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageDrawable(getResources().getDrawable(this.f25969d));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (Build.VERSION.SDK_INT < 17) {
                layoutParams.leftMargin = 5;
                layoutParams.rightMargin = 5;
            } else {
                layoutParams.setMarginEnd(5);
                layoutParams.setMarginStart(5);
            }
            addView(imageView, layoutParams);
            this.f25966a.add(imageView);
        }
        a(0);
    }
}
