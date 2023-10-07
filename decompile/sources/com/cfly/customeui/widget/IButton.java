package com.cfly.customeui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;
import cg.a;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.customeui.R;

public class IButton extends Button {

    /* renamed from: a  reason: collision with root package name */
    private long f10636a;

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
        a.a().a(context);
        setAllCaps(false);
    }

    public boolean performClick() {
        long currentTimeMillis = System.currentTimeMillis();
        a.a().a(true);
        a.a().b();
        if (currentTimeMillis - this.f10636a > 500) {
            this.f10636a = System.currentTimeMillis();
            return super.performClick();
        }
        ToastUtils.showShort((CharSequence) getContext().getString(R.string.btn_click_fast));
        return true;
    }
}
