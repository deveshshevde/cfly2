package io.microshow.rxffmpeg.player;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import io.microshow.rxffmpeg.R;
import io.microshow.rxffmpeg.player.IMediaPlayer;
import io.microshow.rxffmpeg.player.RxFFmpegPlayerView;
import java.lang.ref.WeakReference;

public class RxFFmpegPlayerControllerImpl extends RxFFmpegPlayerController {
    /* access modifiers changed from: private */
    public boolean isSeeking = false;
    /* access modifiers changed from: private */
    public View mBottomPanel;
    public int mPosition;
    /* access modifiers changed from: private */
    public ProgressBar mProgressBar;
    /* access modifiers changed from: private */
    public SeekBar mProgressView;
    /* access modifiers changed from: private */
    public TextView mTimeView;
    private ImageView muteImage;
    private ImageView playBtn;
    /* access modifiers changed from: private */
    public View repeatPlay;

    public static class PlayerListener implements IMediaPlayer.OnCompletionListener, IMediaPlayer.OnErrorListener, IMediaPlayer.OnLoadingListener, IMediaPlayer.OnTimeUpdateListener {
        private WeakReference<RxFFmpegPlayerControllerImpl> mWeakReference;

        PlayerListener(RxFFmpegPlayerControllerImpl rxFFmpegPlayerControllerImpl) {
            this.mWeakReference = new WeakReference<>(rxFFmpegPlayerControllerImpl);
        }

        public void onCompletion(IMediaPlayer iMediaPlayer) {
            RxFFmpegPlayerControllerImpl rxFFmpegPlayerControllerImpl = (RxFFmpegPlayerControllerImpl) this.mWeakReference.get();
            if (rxFFmpegPlayerControllerImpl != null) {
                rxFFmpegPlayerControllerImpl.onCompletion(iMediaPlayer);
            }
        }

        public void onError(IMediaPlayer iMediaPlayer, int i2, String str) {
            RxFFmpegPlayerControllerImpl rxFFmpegPlayerControllerImpl = (RxFFmpegPlayerControllerImpl) this.mWeakReference.get();
            if (rxFFmpegPlayerControllerImpl != null) {
                rxFFmpegPlayerControllerImpl.onError(iMediaPlayer, i2, str);
            }
        }

        public void onLoading(IMediaPlayer iMediaPlayer, boolean z2) {
            RxFFmpegPlayerControllerImpl rxFFmpegPlayerControllerImpl = (RxFFmpegPlayerControllerImpl) this.mWeakReference.get();
            if (rxFFmpegPlayerControllerImpl != null) {
                rxFFmpegPlayerControllerImpl.onLoading(iMediaPlayer, z2);
            }
        }

        public void onTimeUpdate(IMediaPlayer iMediaPlayer, int i2, int i3) {
            RxFFmpegPlayerControllerImpl rxFFmpegPlayerControllerImpl = (RxFFmpegPlayerControllerImpl) this.mWeakReference.get();
            if (rxFFmpegPlayerControllerImpl != null) {
                rxFFmpegPlayerControllerImpl.onTimeUpdate(iMediaPlayer, i2, i3);
            }
        }
    }

    public RxFFmpegPlayerControllerImpl(Context context) {
        super(context);
    }

    public int getLayoutId() {
        return R.layout.rxffmpeg_player_controller;
    }

    public void initListener() {
        PlayerListener playerListener = new PlayerListener(this);
        this.mPlayer.setOnLoadingListener(playerListener);
        this.mPlayer.setOnTimeUpdateListener(playerListener);
        this.mPlayer.setOnErrorListener(playerListener);
        this.mPlayer.setOnCompleteListener(playerListener);
        this.mProgressView.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
                RxFFmpegPlayerControllerImpl rxFFmpegPlayerControllerImpl;
                int i3;
                int duration;
                RxFFmpegPlayerControllerImpl rxFFmpegPlayerControllerImpl2 = RxFFmpegPlayerControllerImpl.this;
                rxFFmpegPlayerControllerImpl2.mPosition = (i2 * rxFFmpegPlayerControllerImpl2.mPlayer.getDuration()) / 100;
                if (RxFFmpegPlayerControllerImpl.this.isSeeking) {
                    if (RxFFmpegPlayerControllerImpl.this.mPlayerView.mPlayerCoreType == RxFFmpegPlayerView.PlayerCoreType.PCT_RXFFMPEG_PLAYER) {
                        rxFFmpegPlayerControllerImpl = RxFFmpegPlayerControllerImpl.this;
                        i3 = rxFFmpegPlayerControllerImpl.mPosition;
                        duration = RxFFmpegPlayerControllerImpl.this.mPlayer.getDuration();
                    } else {
                        if (RxFFmpegPlayerControllerImpl.this.mPlayerView.mPlayerCoreType == RxFFmpegPlayerView.PlayerCoreType.PCT_SYSTEM_MEDIA_PLAYER) {
                            rxFFmpegPlayerControllerImpl = RxFFmpegPlayerControllerImpl.this;
                            i3 = rxFFmpegPlayerControllerImpl.mPosition / 1000;
                            duration = RxFFmpegPlayerControllerImpl.this.mPlayer.getDuration() / 1000;
                        }
                        RxFFmpegPlayerControllerImpl.this.mPlayer.seekTo(RxFFmpegPlayerControllerImpl.this.mPosition);
                    }
                    rxFFmpegPlayerControllerImpl.onTimeUpdate((IMediaPlayer) null, i3, duration);
                    RxFFmpegPlayerControllerImpl.this.mPlayer.seekTo(RxFFmpegPlayerControllerImpl.this.mPosition);
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                boolean unused = RxFFmpegPlayerControllerImpl.this.isSeeking = true;
                RxFFmpegPlayerControllerImpl.this.mPlayer.pause();
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                RxFFmpegPlayerControllerImpl.this.mPlayer.resume();
                RxFFmpegPlayerControllerImpl.this.mPlayer.seekTo(RxFFmpegPlayerControllerImpl.this.mPosition);
                boolean unused = RxFFmpegPlayerControllerImpl.this.isSeeking = false;
            }
        });
    }

    public void initView() {
        this.mBottomPanel = findViewById(R.id.bottomPanel);
        this.mProgressView = (SeekBar) findViewById(R.id.progress_view);
        this.mTimeView = (TextView) findViewById(R.id.time_view);
        this.mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
        this.playBtn = (ImageView) findViewById(R.id.iv_play);
        View findViewById = findViewById(R.id.repeatPlay);
        this.repeatPlay = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RxFFmpegPlayerControllerImpl.this.mPlayerView.repeatPlay();
                RxFFmpegPlayerControllerImpl.this.repeatPlay.setVisibility(8);
            }
        });
        findViewById(R.id.iv_fullscreen).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (RxFFmpegPlayerControllerImpl.this.mPlayerView != null) {
                    RxFFmpegPlayerControllerImpl.this.mPlayerView.switchScreen();
                }
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.iv_mute);
        this.muteImage = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                RxFFmpegPlayerControllerImpl.this.switchMute();
            }
        });
        this.playBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (RxFFmpegPlayerControllerImpl.this.mPlayerView == null) {
                    return;
                }
                if (RxFFmpegPlayerControllerImpl.this.mPlayerView.isPlaying()) {
                    RxFFmpegPlayerControllerImpl.this.mPlayerView.pause();
                } else {
                    RxFFmpegPlayerControllerImpl.this.mPlayerView.resume();
                }
            }
        });
    }

    public void onCompletion(IMediaPlayer iMediaPlayer) {
        post(new Runnable() {
            public void run() {
                int i2;
                View view;
                if (RxFFmpegPlayerControllerImpl.this.mPlayerView == null || RxFFmpegPlayerControllerImpl.this.mPlayerView.isLooping()) {
                    view = RxFFmpegPlayerControllerImpl.this.repeatPlay;
                    i2 = 8;
                } else {
                    view = RxFFmpegPlayerControllerImpl.this.repeatPlay;
                    i2 = 0;
                }
                view.setVisibility(i2);
            }
        });
    }

    public void onError(IMediaPlayer iMediaPlayer, final int i2, final String str) {
        post(new Runnable() {
            public void run() {
                Context context = RxFFmpegPlayerControllerImpl.this.getContext();
                Toast.makeText(context, "出错了：code=" + i2 + ", msg=" + str, 0).show();
            }
        });
    }

    public void onLoading(IMediaPlayer iMediaPlayer, final boolean z2) {
        post(new Runnable() {
            public void run() {
                RxFFmpegPlayerControllerImpl.this.mProgressBar.setVisibility(z2 ? 0 : 8);
            }
        });
    }

    public void onPause() {
        this.playBtn.setImageResource(R.mipmap.rxffmpeg_player_start);
        this.playBtn.animate().alpha(1.0f).start();
    }

    public void onResume() {
        this.playBtn.setImageResource(R.mipmap.rxffmpeg_player_pause);
        this.playBtn.animate().alpha(1.0f).start();
        if (this.mPlayerView != null) {
            this.muteImage.setImageResource(this.mPlayerView.getVolume() == 0 ? R.mipmap.rxffmpeg_player_mute : R.mipmap.rxffmpeg_player_unmute);
        }
    }

    public void onTimeUpdate(IMediaPlayer iMediaPlayer, final int i2, final int i3) {
        post(new Runnable() {
            public void run() {
                if (i3 <= 0) {
                    RxFFmpegPlayerControllerImpl.this.mBottomPanel.setVisibility(8);
                    return;
                }
                RxFFmpegPlayerControllerImpl.this.mBottomPanel.setVisibility(0);
                TextView access$300 = RxFFmpegPlayerControllerImpl.this.mTimeView;
                StringBuilder sb = new StringBuilder();
                sb.append(Helper.secdsToDateFormat(i2, i3));
                sb.append(" / ");
                int i2 = i3;
                sb.append(Helper.secdsToDateFormat(i2, i2));
                access$300.setText(sb.toString());
                if (!RxFFmpegPlayerControllerImpl.this.isSeeking && i3 > 0) {
                    RxFFmpegPlayerControllerImpl.this.mProgressView.setProgress((i2 * 100) / i3);
                }
            }
        });
    }

    public void switchMute() {
        int i2;
        ImageView imageView;
        if (this.mPlayerView != null) {
            if (this.mPlayerView.getVolume() == 0) {
                this.mPlayerView.setVolume(100);
                imageView = this.muteImage;
                i2 = R.mipmap.rxffmpeg_player_unmute;
            } else {
                this.mPlayerView.setVolume(0);
                imageView = this.muteImage;
                i2 = R.mipmap.rxffmpeg_player_mute;
            }
            imageView.setImageResource(i2);
        }
    }
}
