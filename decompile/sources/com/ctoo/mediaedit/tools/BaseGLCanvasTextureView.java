package com.ctoo.mediaedit.tools;

import android.content.Context;
import android.util.AttributeSet;
import cz.a;

abstract class BaseGLCanvasTextureView extends BaseGLTextureView implements a {

    /* renamed from: c  reason: collision with root package name */
    private int f10870c = 0;

    public BaseGLCanvasTextureView(Context context) {
        super(context);
    }

    public BaseGLCanvasTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseGLCanvasTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setRenderBackgroundColor(int i2) {
        this.f10870c = i2;
    }
}
