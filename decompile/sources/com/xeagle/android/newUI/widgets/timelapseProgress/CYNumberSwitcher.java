package com.xeagle.android.newUI.widgets.timelapseProgress;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.cfly.uav_pro.R;

public class CYNumberSwitcher extends TextSwitcher implements ViewSwitcher.ViewFactory {

    /* renamed from: a  reason: collision with root package name */
    private ValueAnimator f24177a;

    /* renamed from: b  reason: collision with root package name */
    private long f24178b;

    /* renamed from: c  reason: collision with root package name */
    private int f24179c;

    public CYNumberSwitcher(Context context) {
        this(context, (AttributeSet) null);
    }

    public CYNumberSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f24178b = 1500;
        this.f24179c = 0;
        setFactory(this);
    }

    public View makeView() {
        TextView textView = new TextView(getContext());
        textView.setTextSize(1, 34.0f);
        textView.setTextColor(getResources().getColor(R.color.black));
        textView.setGravity(17);
        return textView;
    }

    public final void reset() {
        ValueAnimator valueAnimator = this.f24177a;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        setText("0");
    }

    public final void setDataToShow(int i2) {
        this.f24179c = i2;
        setText(String.valueOf(i2));
    }

    public final void setShowTime(long j2) {
        this.f24178b = j2;
    }
}
