package com.xeagle.android.login.fragment;

import android.app.Activity;
import android.net.Uri;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.CustomVideoView;
import com.xeagle.android.login.SplashActivity;

public class GuideFragment extends LazyLoadFragment {
    private CustomVideoView customVideoView;
    private int index;
    private SplashActivity parent;
    int playProgress;
    private Uri uri;

    /* access modifiers changed from: protected */
    public void lazyLoad() {
        this.customVideoView = (CustomVideoView) findViewById(R.id.video_view);
        this.index = getArguments().getInt("index");
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.parent = (SplashActivity) activity;
    }

    public void onPause() {
        super.onPause();
        CustomVideoView customVideoView2 = this.customVideoView;
        if (customVideoView2 != null) {
            customVideoView2.pause();
            this.playProgress = this.customVideoView.getCurrentPosition();
        }
    }

    public void onResume() {
        super.onResume();
        CustomVideoView customVideoView2 = this.customVideoView;
        if (customVideoView2 != null) {
            customVideoView2.start();
        }
    }

    public void onStop() {
        super.onStop();
        CustomVideoView customVideoView2 = this.customVideoView;
        if (customVideoView2 != null) {
            customVideoView2.pause();
            this.playProgress = this.customVideoView.getCurrentPosition();
        }
    }

    /* access modifiers changed from: protected */
    public int setContentView() {
        return R.layout.guide_fragment_layout;
    }

    /* access modifiers changed from: protected */
    public void stopLoad() {
        super.stopLoad();
        CustomVideoView customVideoView2 = this.customVideoView;
        if (customVideoView2 != null) {
            customVideoView2.stopPlayback();
        }
    }
}
