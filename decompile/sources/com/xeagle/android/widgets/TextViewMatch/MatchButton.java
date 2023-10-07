package com.xeagle.android.widgets.TextViewMatch;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;

public class MatchButton extends MatchTextView {
    public MatchButton(Context context) {
        super(context);
        a();
    }

    public MatchButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MatchButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        b();
        super.a();
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (!TextUtils.isEmpty(this.f25627a)) {
            b.f25671a = true;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append('#');
            stringBuffer.append(this.f25627a);
            stringBuffer.append('%');
            this.f25627a = stringBuffer.toString();
        }
    }
}
