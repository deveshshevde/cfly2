package com.xeagle.android.login.gsy.mediacodec;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Surface;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;

public class MediaCodecVideo extends StandardGSYVideoPlayer {
    public MediaCodecVideo(Context context) {
        super(context);
    }

    public MediaCodecVideo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MediaCodecVideo(Context context, Boolean bool) {
        super(context, bool);
    }

    /* access modifiers changed from: protected */
    public void addTextureView() {
        this.mTextureView = new MediaCodecRenderView();
        this.mTextureView.addView(getContext(), this.mTextureViewContainer, this.mRotate, this, this, this.mEffectFilter, this.mMatrixGL, this.mRenderer, this.mMode);
    }

    public void onSurfaceAvailable(Surface surface) {
        super.onSurfaceAvailable(surface);
    }

    public boolean onSurfaceDestroyed(Surface surface) {
        return true;
    }

    public GSYBaseVideoPlayer startWindowFullscreen(Context context, boolean z2, boolean z3) {
        return super.startWindowFullscreen(context, false, false);
    }
}
