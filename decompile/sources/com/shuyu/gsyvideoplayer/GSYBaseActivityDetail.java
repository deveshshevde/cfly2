package com.shuyu.gsyvideoplayer;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;
import jg.i;

public abstract class GSYBaseActivityDetail<T extends GSYBaseVideoPlayer> extends AppCompatActivity implements i {

    /* renamed from: b  reason: collision with root package name */
    protected boolean f21610b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f21611c;

    /* renamed from: d  reason: collision with root package name */
    protected OrientationUtils f21612d;

    public boolean c() {
        return true;
    }

    public boolean d() {
        return true;
    }

    public abstract T e();

    public void onBackPressed() {
        OrientationUtils orientationUtils = this.f21612d;
        if (orientationUtils != null) {
            orientationUtils.backToProtVideo();
        }
        if (!c.a((Context) this)) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f21610b && !this.f21611c) {
            e().onConfigurationChanged(this, configuration, this.f21612d, c(), d());
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.f21610b) {
            e().getCurrentPlayer().release();
        }
        OrientationUtils orientationUtils = this.f21612d;
        if (orientationUtils != null) {
            orientationUtils.releaseListener();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        e().getCurrentPlayer().onVideoPause();
        OrientationUtils orientationUtils = this.f21612d;
        if (orientationUtils != null) {
            orientationUtils.setIsPause(true);
        }
        this.f21611c = true;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        e().getCurrentPlayer().onVideoResume();
        OrientationUtils orientationUtils = this.f21612d;
        if (orientationUtils != null) {
            orientationUtils.setIsPause(false);
        }
        this.f21611c = false;
    }
}
