package io.microshow.rxffmpeg.player;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

public abstract class RxFFmpegPlayerController extends FrameLayout {
    protected BaseMediaPlayer mPlayer;
    protected RxFFmpegPlayerView mPlayerView;

    public RxFFmpegPlayerController(Context context) {
        super(context);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(getLayoutId(), this, true);
        initView();
    }

    /* access modifiers changed from: protected */
    public abstract int getLayoutId();

    /* access modifiers changed from: protected */
    public abstract void initListener();

    /* access modifiers changed from: protected */
    public abstract void initView();

    /* access modifiers changed from: protected */
    public abstract void onPause();

    /* access modifiers changed from: protected */
    public abstract void onResume();

    public void setPlayerView(RxFFmpegPlayerView rxFFmpegPlayerView) {
        if (rxFFmpegPlayerView != null) {
            this.mPlayerView = rxFFmpegPlayerView;
            this.mPlayer = rxFFmpegPlayerView.mPlayer;
            initListener();
        }
    }
}
