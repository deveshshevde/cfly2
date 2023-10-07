package com.facebook.drawee.view;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.drawee.generic.a;
import com.facebook.drawee.generic.c;
import ds.b;

public class GenericDraweeView extends DraweeView<a> {
    public GenericDraweeView(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public GenericDraweeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public GenericDraweeView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void a(Context context, AttributeSet attributeSet) {
        if (b.b()) {
            b.a("GenericDraweeView#inflateHierarchy");
        }
        com.facebook.drawee.generic.b a2 = c.a(context, attributeSet);
        setAspectRatio(a2.c());
        setHierarchy(a2.s());
        if (b.b()) {
            b.a();
        }
    }
}
