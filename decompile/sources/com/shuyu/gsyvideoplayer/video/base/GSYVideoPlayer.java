package com.shuyu.gsyvideoplayer.video.base;

import android.content.Context;
import android.util.AttributeSet;
import com.shuyu.gsyvideoplayer.c;

public abstract class GSYVideoPlayer extends GSYBaseVideoPlayer {
    public GSYVideoPlayer(Context context) {
        super(context);
    }

    public GSYVideoPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GSYVideoPlayer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public GSYVideoPlayer(Context context, Boolean bool) {
        super(context, bool);
    }

    /* access modifiers changed from: protected */
    public boolean backFromFull(Context context) {
        return c.a(context);
    }

    /* access modifiers changed from: protected */
    public int getFullId() {
        return c.f21655b;
    }

    public GSYVideoViewBridge getGSYVideoManager() {
        c.a().b(getContext().getApplicationContext());
        return c.a();
    }

    /* access modifiers changed from: protected */
    public int getSmallId() {
        return c.f21654a;
    }

    /* access modifiers changed from: protected */
    public void releaseVideos() {
        c.b();
    }

    /* access modifiers changed from: protected */
    public void releaseVideosCache() {
        c.c();
    }
}
