package com.xeagle.android.activities;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.cfly.uav_pro.R;
import com.shuyu.gsyvideoplayer.c;
import com.shuyu.gsyvideoplayer.utils.GSYVideoHelper;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.xeagle.android.login.gsy.video.SampleCoverVideo;
import com.xeagle.android.login.pickImage.loader.GlideImageLoader;
import com.xeagle.android.newUI.activity.BaseActivity;
import java.util.HashMap;
import java.util.Objects;
import kotlin.jvm.internal.h;

public final class OpenVideoActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private String f22270a;

    /* renamed from: b  reason: collision with root package name */
    private String f22271b;

    /* renamed from: c  reason: collision with root package name */
    private GSYVideoHelper.GSYVideoHelperBuilder f22272c = new GSYVideoHelper.GSYVideoHelperBuilder();

    /* renamed from: d  reason: collision with root package name */
    private HashMap f22273d;

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ OpenVideoActivity f22274a;

        a(OpenVideoActivity openVideoActivity) {
            this.f22274a = openVideoActivity;
        }

        public final void onClick(View view) {
            this.f22274a.finish();
        }
    }

    public View a(int i2) {
        if (this.f22273d == null) {
            this.f22273d = new HashMap();
        }
        View view = (View) this.f22273d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f22273d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.open_vedio);
        this.f22271b = getIntent().getStringExtra("video_info");
        this.f22270a = getIntent().getStringExtra("open_video");
        View inflate = View.inflate(this, R.layout.layout_explayout, (ViewGroup) null);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.ImageView");
        GlideImageLoader.displayVideo((ImageView) inflate, this.f22270a);
        GSYVideoHelper.GSYVideoHelperBuilder gSYVideoHelperBuilder = this.f22272c;
        gSYVideoHelperBuilder.setThumbImageView(inflate);
        gSYVideoHelperBuilder.setUrl(this.f22270a);
        gSYVideoHelperBuilder.setVideoTitle(this.f22271b);
        gSYVideoHelperBuilder.setCacheWithPlay(true);
        gSYVideoHelperBuilder.setRotateViewAuto(true);
        gSYVideoHelperBuilder.setLockLand(true);
        gSYVideoHelperBuilder.setShowFullAnimation(true);
        gSYVideoHelperBuilder.setAutoFullWithSize(true);
        gSYVideoHelperBuilder.setNeedLockFull(true);
        gSYVideoHelperBuilder.setDismissControlTime(3000);
        gSYVideoHelperBuilder.build((StandardGSYVideoPlayer) (SampleCoverVideo) a(com.xeagle.R.id.vv_player));
        ((SampleCoverVideo) a(com.xeagle.R.id.vv_player)).startPlayLogic();
        SampleCoverVideo sampleCoverVideo = (SampleCoverVideo) a(com.xeagle.R.id.vv_player);
        h.b(sampleCoverVideo, "vv_player");
        ImageView backButton = sampleCoverVideo.getBackButton();
        h.b(backButton, "vv_player.backButton");
        backButton.setVisibility(0);
        SampleCoverVideo sampleCoverVideo2 = (SampleCoverVideo) a(com.xeagle.R.id.vv_player);
        h.b(sampleCoverVideo2, "vv_player");
        sampleCoverVideo2.getBackButton().setOnClickListener(new a(this));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        c.b();
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
