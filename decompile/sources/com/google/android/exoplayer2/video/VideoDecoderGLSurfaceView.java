package com.google.android.exoplayer2.video;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

public class VideoDecoderGLSurfaceView extends GLSurfaceView {

    /* renamed from: a  reason: collision with root package name */
    private final f f17211a;

    public VideoDecoderGLSurfaceView(Context context) {
        this(context, (AttributeSet) null);
    }

    public VideoDecoderGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        f fVar = new f(this);
        this.f17211a = fVar;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(fVar);
        setRenderMode(0);
    }

    public e getVideoDecoderOutputBufferRenderer() {
        return this.f17211a;
    }
}
