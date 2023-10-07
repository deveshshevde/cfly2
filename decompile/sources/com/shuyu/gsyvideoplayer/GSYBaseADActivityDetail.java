package com.shuyu.gsyvideoplayer;

import android.content.res.Configuration;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.GSYADVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;

public abstract class GSYBaseADActivityDetail<T extends GSYBaseVideoPlayer, R extends GSYADVideoPlayer> extends GSYBaseActivityDetail<T> {

    /* renamed from: a  reason: collision with root package name */
    protected OrientationUtils f21609a;

    /* access modifiers changed from: protected */
    public boolean a() {
        return (b().getCurrentPlayer().getCurrentState() < 0 || b().getCurrentPlayer().getCurrentState() == 0 || b().getCurrentPlayer().getCurrentState() == 6) ? false : true;
    }

    public abstract R b();

    public void onBackPressed() {
        OrientationUtils orientationUtils = this.f21609a;
        if (orientationUtils != null) {
            orientationUtils.backToProtVideo();
        }
        if (!a.a(this)) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        boolean z2 = this.f21610b;
        if (!this.f21611c && b().getVisibility() == 0 && a()) {
            this.f21610b = false;
            b().getCurrentPlayer().onConfigurationChanged(this, configuration, this.f21609a, c(), d());
        }
        super.onConfigurationChanged(configuration);
        this.f21610b = z2;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        a.b();
        OrientationUtils orientationUtils = this.f21609a;
        if (orientationUtils != null) {
            orientationUtils.releaseListener();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        a.c();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        a.d();
    }
}
