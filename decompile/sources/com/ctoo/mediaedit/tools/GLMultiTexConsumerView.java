package com.ctoo.mediaedit.tools;

import android.content.Context;
import android.util.AttributeSet;
import android.view.TextureView;
import com.ctoo.mediaedit.tools.e;
import cz.a;
import java.util.ArrayList;
import java.util.List;

public abstract class GLMultiTexConsumerView extends BaseGLCanvasTextureView {

    /* renamed from: c  reason: collision with root package name */
    protected List<Object> f10882c = new ArrayList();

    public GLMultiTexConsumerView(Context context) {
        super(context);
    }

    public GLMultiTexConsumerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GLMultiTexConsumerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public /* bridge */ /* synthetic */ a getCurrentEglContext() {
        return super.getCurrentEglContext();
    }

    public /* bridge */ /* synthetic */ void setOnCreateGLContextListener(e.l lVar) {
        super.setOnCreateGLContextListener(lVar);
    }

    public /* bridge */ /* synthetic */ void setRenderBackgroundColor(int i2) {
        super.setRenderBackgroundColor(i2);
    }

    public /* bridge */ /* synthetic */ void setRenderer(a aVar) {
        super.setRenderer(aVar);
    }

    public void setSharedEglContext(a aVar) {
        this.f10872b.a(aVar);
        d();
    }

    public /* bridge */ /* synthetic */ void setSurfaceTextureListener(TextureView.SurfaceTextureListener surfaceTextureListener) {
        super.setSurfaceTextureListener(surfaceTextureListener);
    }
}
