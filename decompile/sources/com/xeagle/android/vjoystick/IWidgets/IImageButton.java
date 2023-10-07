package com.xeagle.android.vjoystick.IWidgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.xeagle.android.utils.aa;

public class IImageButton extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private long f24669a;

    public IImageButton(Context context) {
        super(context);
        a(context, (AttributeSet) null, 0);
    }

    public IImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public IImageButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        aa.a().a(context);
    }

    public boolean performClick() {
        long currentTimeMillis = System.currentTimeMillis();
        aa.a().a(true);
        aa.a().c();
        if (currentTimeMillis - this.f24669a > 500) {
            this.f24669a = System.currentTimeMillis();
            return super.performClick();
        }
        ToastUtils.showShort((CharSequence) getContext().getString(R.string.btn_click_fast));
        return true;
    }
}
