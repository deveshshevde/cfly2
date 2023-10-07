package com.xeagle.android.login.gsy.video;

import android.content.Context;
import android.util.AttributeSet;
import com.cfly.uav_pro.R;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.xeagle.android.activities.helpers.SuperUI;
import jo.be;
import jp.a;
import jp.b;
import org.greenrobot.eventbus.c;

public class EmptyControlVideo extends StandardGSYVideoPlayer {
    private Context context;

    public interface LogcatListener {
        void logcatError(String str);

        void rtspConnect(long j2);

        void rtspDisconnect();
    }

    public EmptyControlVideo(Context context2) {
        super(context2);
        this.context = context2;
    }

    public EmptyControlVideo(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        this.context = context2;
    }

    public EmptyControlVideo(Context context2, Boolean bool) {
        super(context2, bool);
        this.context = context2;
    }

    /* access modifiers changed from: protected */
    public void getCurrentScaleFactor(float f2) {
        super.getCurrentScaleFactor(f2);
    }

    public int getLayoutId() {
        return R.layout.empty_control_video;
    }

    public void onCompletion() {
        super.onCompletion();
        c.a().d(new a("ijk"));
    }

    public void onError(int i2, int i3) {
        super.onError(i2, i3);
    }

    public void onPrepared() {
        super.onPrepared();
        c.a().d(new b("ijk"));
    }

    public void onVideoSizeChanged() {
        super.onVideoSizeChanged();
    }

    /* access modifiers changed from: protected */
    public void touchDoubleUp() {
    }

    /* access modifiers changed from: protected */
    public void touchSurfaceMoveFullLogic(float f2, float f3) {
        super.touchSurfaceMoveFullLogic(f2, f3);
        this.mChangePosition = false;
        this.mChangeVolume = false;
        this.mBrightness = false;
    }

    /* access modifiers changed from: protected */
    public void touchSurfaceUp() {
        if (!((SuperUI) this.context).f()) {
            c.a().d(new be(true));
        }
    }
}
