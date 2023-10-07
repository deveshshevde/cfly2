package com.xeagle.android.editor.videoView;

import android.app.ActivityManager;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

public class GlVideoView extends GLSurfaceView {

    /* renamed from: a  reason: collision with root package name */
    private c f22849a;

    /* renamed from: b  reason: collision with root package name */
    private Context f22850b;

    public GlVideoView(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public GlVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (a(context)) {
            this.f22850b = context;
            return;
        }
        throw new IllegalStateException("OpenGL ES 2.0 is not supported on this phone.");
    }

    private boolean a(Context context) {
        return ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= 131072;
    }

    public void a(b bVar) {
        this.f22849a = new c(new a(), bVar);
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        getHolder().setFormat(1);
        setRenderer(this.f22849a);
        setRenderMode(1);
    }

    public a getFilter() {
        return this.f22849a.e();
    }

    public String getVersion() {
        return "1.1.0";
    }

    public void setFilter(a aVar) {
        this.f22849a.a(aVar);
    }
}
