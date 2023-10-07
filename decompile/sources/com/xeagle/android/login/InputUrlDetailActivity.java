package com.xeagle.android.login;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.cfly.uav_pro.R;
import com.shuyu.gsyvideoplayer.c;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;
import com.xeagle.android.login.gsy.CustomInputDialog;
import com.xeagle.android.login.gsy.video.LandLayoutVideo;
import jd.a;
import jg.b;
import jg.h;

public class InputUrlDetailActivity extends AppCompatActivity {
    @BindView(2131296391)
    RelativeLayout activityDetailPlayer;
    /* access modifiers changed from: private */
    public boolean cache;
    @BindView(2131296951)
    LandLayoutVideo detailPlayer;
    private a gsyVideoOptionBuilder;
    @BindView(2131297485)
    Button inputUrl;
    private boolean isPause;
    /* access modifiers changed from: private */
    public boolean isPlay;
    /* access modifiers changed from: private */
    public OrientationUtils orientationUtils;
    @BindView(2131298447)
    NestedScrollView postDetailNestedScroll;
    /* access modifiers changed from: private */
    public String url;

    private GSYVideoPlayer getCurPlay() {
        return this.detailPlayer.getFullWindowPlayer() != null ? this.detailPlayer.getFullWindowPlayer() : this.detailPlayer;
    }

    /* access modifiers changed from: private */
    public void playVideo() {
        this.detailPlayer.release();
        this.gsyVideoOptionBuilder.setUrl(this.url).setCacheWithPlay(this.cache).setVideoTitle("测试视频").build((StandardGSYVideoPlayer) this.detailPlayer);
        this.gsyVideoOptionBuilder.build((StandardGSYVideoPlayer) this.detailPlayer);
        this.detailPlayer.postDelayed(new Runnable() {
            public void run() {
                InputUrlDetailActivity.this.detailPlayer.startPlayLogic();
            }
        }, 1000);
    }

    private void resolveNormalVideoUI() {
        this.detailPlayer.getTitleTextView().setVisibility(8);
        this.detailPlayer.getBackButton().setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void showInputDialog() {
        final CustomInputDialog customInputDialog = new CustomInputDialog(this);
        customInputDialog.setInput(this.url);
        customInputDialog.setCache(this.cache);
        customInputDialog.setTitle("请输入URL");
        customInputDialog.setButton(-1, "确定", new CustomInputDialog.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                String unused = InputUrlDetailActivity.this.url = customInputDialog.getEditMessage().getText().toString();
                InputUrlDetailActivity.this.playVideo();
            }

            public void onInputChanged(String str, boolean z2) {
                String unused = InputUrlDetailActivity.this.url = str;
                boolean unused2 = InputUrlDetailActivity.this.cache = z2;
            }
        });
        customInputDialog.setCancelable(true);
        customInputDialog.show();
    }

    public void onBackPressed() {
        OrientationUtils orientationUtils2 = this.orientationUtils;
        if (orientationUtils2 != null) {
            orientationUtils2.backToProtVideo();
        }
        if (!c.a((Context) this)) {
            super.onBackPressed();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.isPlay && !this.isPause) {
            this.detailPlayer.onConfigurationChanged(this, configuration, this.orientationUtils, true, true);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_input_url_detail);
        ButterKnife.bind((Activity) this);
        this.url = "https://res.exexm.com/cw_145225549855002";
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.drawable.ic_launcher);
        resolveNormalVideoUI();
        OrientationUtils orientationUtils2 = new OrientationUtils(this, this.detailPlayer);
        this.orientationUtils = orientationUtils2;
        orientationUtils2.setEnable(false);
        a videoAllCallBack = new a().setThumbImageView(imageView).setIsTouchWiget(true).setRotateViewAuto(false).setLockLand(false).setShowFullAnimation(false).setNeedLockFull(true).setSeekRatio(1.0f).setUrl(this.url).setCacheWithPlay(this.cache).setVideoTitle("测试视频").setVideoAllCallBack(new b() {
            public void onPrepared(String str, Object... objArr) {
                super.onPrepared(str, objArr);
                InputUrlDetailActivity.this.orientationUtils.setEnable(true);
                boolean unused = InputUrlDetailActivity.this.isPlay = true;
            }

            public void onQuitFullscreen(String str, Object... objArr) {
                super.onQuitFullscreen(str, objArr);
                if (InputUrlDetailActivity.this.orientationUtils != null) {
                    InputUrlDetailActivity.this.orientationUtils.backToProtVideo();
                }
            }
        });
        this.gsyVideoOptionBuilder = videoAllCallBack;
        videoAllCallBack.build((StandardGSYVideoPlayer) this.detailPlayer);
        this.detailPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                InputUrlDetailActivity.this.orientationUtils.resolveByClick();
                InputUrlDetailActivity.this.detailPlayer.startWindowFullscreen(InputUrlDetailActivity.this, true, true);
            }
        });
        this.detailPlayer.setLockClickListener(new h() {
            public void onClick(View view, boolean z2) {
                if (InputUrlDetailActivity.this.orientationUtils != null) {
                    InputUrlDetailActivity.this.orientationUtils.setEnable(!z2);
                }
            }
        });
        this.inputUrl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                InputUrlDetailActivity.this.showInputDialog();
            }
        });
        this.detailPlayer.postDelayed(new Runnable() {
            public void run() {
                com.bumptech.glide.c.b(InputUrlDetailActivity.this.getApplicationContext()).a("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1525708180755&di=078af5aedf4b44268425be46bf25e407&imgtype=0&src=http%3A%2F%2Fc.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F203fb80e7bec54e78494e3a3bb389b504fc26a17.jpg").a((ImageView) InputUrlDetailActivity.this.findViewById(R.id.test_image_view));
            }
        }, 5000);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.isPlay) {
            getCurPlay().release();
        }
        OrientationUtils orientationUtils2 = this.orientationUtils;
        if (orientationUtils2 != null) {
            orientationUtils2.releaseListener();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        getCurPlay().onVideoPause();
        super.onPause();
        this.isPause = true;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        getCurPlay().onVideoResume();
        super.onResume();
        this.isPause = false;
    }
}
