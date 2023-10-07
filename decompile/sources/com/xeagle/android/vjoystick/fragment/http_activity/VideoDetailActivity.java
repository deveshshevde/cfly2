package com.xeagle.android.vjoystick.fragment.http_activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.cfly.uav_pro.R;
import com.shuyu.gsyvideoplayer.c;
import com.shuyu.gsyvideoplayer.utils.GSYVideoHelper;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.newUI.activity.BaseActivity;
import java.util.HashMap;
import kotlin.jvm.internal.h;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public final class VideoDetailActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private GSYVideoHelper.GSYVideoHelperBuilder f25182a = new GSYVideoHelper.GSYVideoHelperBuilder();

    /* renamed from: b  reason: collision with root package name */
    private HashMap f25183b;

    public final int a() {
        return R.layout.video_detail_layout;
    }

    public View a(int i2) {
        if (this.f25183b == null) {
            this.f25183b = new HashMap();
        }
        View view = (View) this.f25183b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f25183b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a());
        String stringExtra = getIntent().getStringExtra(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL);
        View inflate = View.inflate(this, R.layout.layout_explayout, (ViewGroup) null);
        GSYVideoHelper.GSYVideoHelperBuilder gSYVideoHelperBuilder = this.f25182a;
        gSYVideoHelperBuilder.setThumbImageView(inflate);
        XEagleApp xEagleApp = this.xEagleApp;
        h.b(xEagleApp, "xEagleApp");
        boolean c2 = xEagleApp.c();
        gSYVideoHelperBuilder.setUrl(stringExtra);
        gSYVideoHelperBuilder.setVideoTitle("");
        gSYVideoHelperBuilder.setCacheWithPlay(true);
        gSYVideoHelperBuilder.setRotateViewAuto(true);
        gSYVideoHelperBuilder.setLockLand(true);
        gSYVideoHelperBuilder.setShowFullAnimation(true);
        gSYVideoHelperBuilder.setAutoFullWithSize(true);
        gSYVideoHelperBuilder.setNeedLockFull(true);
        gSYVideoHelperBuilder.setDismissControlTime(3000);
        gSYVideoHelperBuilder.build((StandardGSYVideoPlayer) a(com.xeagle.R.id.videoPlayer));
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        c.d();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        c.j();
    }
}
