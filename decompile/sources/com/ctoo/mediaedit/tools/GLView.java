package com.ctoo.mediaedit.tools;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.AttributeSet;

public abstract class GLView extends GLSurfaceView implements GLSurfaceView.Renderer {

    /* renamed from: a  reason: collision with root package name */
    private a f10886a;

    public interface a {
        void a(int i2, int i3, int i4, int i5);
    }

    public GLView(Context context) {
        super(context);
        a();
    }

    public GLView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    /* access modifiers changed from: protected */
    public void a() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        setZOrderOnTop(true);
        setEGLContextClientVersion(2);
        if (Build.VERSION.SDK_INT >= 16) {
            i6 = 8;
            i5 = 8;
            i4 = 8;
            i3 = 8;
            i2 = 16;
        } else {
            i6 = 5;
            i5 = 6;
            i4 = 5;
            i3 = 8;
            i2 = 0;
        }
        setEGLConfigChooser(i6, i5, i4, i3, i2, 0);
        if (Build.VERSION.SDK_INT >= 11) {
            setPreserveEGLContextOnPause(true);
        }
        getHolder().setFormat(-3);
        setRenderer(this);
        setRenderMode(0);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        a aVar = this.f10886a;
        if (aVar != null) {
            aVar.a(i2, i3, i4, i5);
        }
    }

    public void setOnSizeChangeCallback(a aVar) {
        this.f10886a = aVar;
    }
}
