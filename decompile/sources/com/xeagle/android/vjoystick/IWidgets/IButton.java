package com.xeagle.android.vjoystick.IWidgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.xeagle.android.utils.aa;

public class IButton extends Button {

    /* renamed from: a  reason: collision with root package name */
    private long f24668a;

    public IButton(Context context) {
        super(context);
        a(context, (AttributeSet) null, 0);
    }

    public IButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public IButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet, i2);
    }

    private void a(Context context, AttributeSet attributeSet, int i2) {
        aa.a().a(context);
        setAllCaps(false);
    }

    public boolean performClick() {
        long currentTimeMillis = System.currentTimeMillis();
        aa.a().a(true);
        aa.a().c();
        if (currentTimeMillis - this.f24668a > 500) {
            this.f24668a = System.currentTimeMillis();
            return super.performClick();
        }
        ToastUtils.showShort((CharSequence) getContext().getString(R.string.btn_click_fast));
        return true;
    }
}
