package com.shuyu.gsyvideoplayer.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;
import com.transitionseverywhere.e;
import java.io.File;
import java.util.Map;
import jg.i;

@Deprecated
public class ListVideoUtil {
    private String TAG = "NULL";
    private boolean autoRotation = true;
    private File cachePath;
    /* access modifiers changed from: private */
    public Context context;
    private boolean fullLandFrist = true;
    /* access modifiers changed from: private */
    public ViewGroup fullViewContainer;
    /* access modifiers changed from: private */
    public StandardGSYVideoPlayer gsyVideoPlayer;
    /* access modifiers changed from: private */
    public Handler handler = new Handler();
    /* access modifiers changed from: private */
    public boolean hideActionBar;
    /* access modifiers changed from: private */
    public boolean hideKey = true;
    /* access modifiers changed from: private */
    public boolean hideStatusBar;
    /* access modifiers changed from: private */
    public boolean isFull;
    private boolean isLoop;
    private boolean isSmall;
    /* access modifiers changed from: private */
    public int[] listItemRect;
    /* access modifiers changed from: private */
    public int[] listItemSize;
    /* access modifiers changed from: private */
    public ViewGroup.LayoutParams listParams;
    /* access modifiers changed from: private */
    public ViewGroup listParent;
    /* access modifiers changed from: private */
    public String mTitle;
    private Map<String, String> mapHeadData;
    private boolean needLockFull = true;
    protected boolean needShowWifiTip = true;
    /* access modifiers changed from: private */
    public OrientationUtils orientationUtils;
    private int playPosition = -1;
    private boolean showFullAnimation = true;
    private int speed = 1;
    /* access modifiers changed from: private */
    public int systemUiVisibility;
    /* access modifiers changed from: private */
    public String url;
    /* access modifiers changed from: private */
    public i videoAllCallBack;

    public ListVideoUtil(Context context2) {
        this.gsyVideoPlayer = new StandardGSYVideoPlayer(context2);
        this.context = context2;
    }

    private boolean isCurrentViewPlaying(int i2, String str) {
        return isPlayView(i2, str);
    }

    private boolean isPlayView(int i2, String str) {
        return this.playPosition == i2 && this.TAG.equals(str);
    }

    /* access modifiers changed from: private */
    public void resolveChangeFirstLogic(int i2) {
        if (isFullLandFrist()) {
            this.handler.postDelayed(new Runnable() {
                public void run() {
                    if (ListVideoUtil.this.orientationUtils.getIsLand() != 1) {
                        ListVideoUtil.this.orientationUtils.resolveByClick();
                    }
                }
            }, (long) i2);
        }
        this.gsyVideoPlayer.setIfCurrentIsFullscreen(true);
        if (this.videoAllCallBack != null) {
            Debuger.printfLog("onEnterFullscreen");
            this.videoAllCallBack.onEnterFullscreen(this.url, this.mTitle, this.gsyVideoPlayer);
        }
    }

    private void resolveFullAdd() {
        this.fullViewContainer.setBackgroundColor(-16777216);
        this.fullViewContainer.addView(this.gsyVideoPlayer);
        resolveChangeFirstLogic(50);
    }

    private void resolveMaterialAnimation() {
        this.listItemRect = new int[2];
        this.listItemSize = new int[2];
        saveLocationStatus(this.context, this.hideStatusBar, this.hideActionBar);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        FrameLayout frameLayout = new FrameLayout(this.context);
        frameLayout.setBackgroundColor(-16777216);
        int[] iArr = this.listItemSize;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(iArr[0], iArr[1]);
        int[] iArr2 = this.listItemRect;
        layoutParams2.setMargins(iArr2[0], iArr2[1], 0, 0);
        frameLayout.addView(this.gsyVideoPlayer, layoutParams2);
        this.fullViewContainer.addView(frameLayout, layoutParams);
        this.handler.postDelayed(new Runnable() {
            public void run() {
                e.a(ListVideoUtil.this.fullViewContainer);
                ListVideoUtil listVideoUtil = ListVideoUtil.this;
                listVideoUtil.resolveMaterialFullVideoShow(listVideoUtil.gsyVideoPlayer);
                ListVideoUtil.this.resolveChangeFirstLogic(600);
            }
        }, 300);
    }

    /* access modifiers changed from: private */
    public void resolveMaterialFullVideoShow(GSYBaseVideoPlayer gSYBaseVideoPlayer) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) gSYBaseVideoPlayer.getLayoutParams();
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams.height = -1;
        layoutParams.width = -1;
        layoutParams.gravity = 17;
        gSYBaseVideoPlayer.setLayoutParams(layoutParams);
        gSYBaseVideoPlayer.setIfCurrentIsFullscreen(true);
    }

    /* access modifiers changed from: private */
    public void resolveMaterialToNormal(final GSYVideoPlayer gSYVideoPlayer) {
        if (!this.showFullAnimation || !(this.fullViewContainer instanceof FrameLayout)) {
            resolveToNormal();
            return;
        }
        this.handler.postDelayed(new Runnable() {
            public void run() {
                e.a(ListVideoUtil.this.fullViewContainer);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) gSYVideoPlayer.getLayoutParams();
                layoutParams.setMargins(ListVideoUtil.this.listItemRect[0], ListVideoUtil.this.listItemRect[1], 0, 0);
                layoutParams.width = ListVideoUtil.this.listItemSize[0];
                layoutParams.height = ListVideoUtil.this.listItemSize[1];
                layoutParams.gravity = 0;
                gSYVideoPlayer.setLayoutParams(layoutParams);
                ListVideoUtil.this.handler.postDelayed(new Runnable() {
                    public void run() {
                        ListVideoUtil.this.resolveToNormal();
                    }
                }, 400);
            }
        }, (long) this.orientationUtils.backToProtVideo());
    }

    private void resolveToFull() {
        this.systemUiVisibility = ((Activity) this.context).getWindow().getDecorView().getSystemUiVisibility();
        CommonUtil.hideSupportActionBar(this.context, this.hideActionBar, this.hideStatusBar);
        if (this.hideKey) {
            CommonUtil.hideNavKey(this.context);
        }
        this.isFull = true;
        ViewGroup viewGroup = (ViewGroup) this.gsyVideoPlayer.getParent();
        this.listParams = this.gsyVideoPlayer.getLayoutParams();
        if (viewGroup != null) {
            this.listParent = viewGroup;
            viewGroup.removeView(this.gsyVideoPlayer);
        }
        this.gsyVideoPlayer.setIfCurrentIsFullscreen(true);
        this.gsyVideoPlayer.getFullscreenButton().setImageResource(this.gsyVideoPlayer.getShrinkImageRes());
        this.gsyVideoPlayer.getBackButton().setVisibility(0);
        OrientationUtils orientationUtils2 = new OrientationUtils((Activity) this.context, this.gsyVideoPlayer);
        this.orientationUtils = orientationUtils2;
        orientationUtils2.setEnable(isAutoRotation());
        this.gsyVideoPlayer.getBackButton().setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ListVideoUtil listVideoUtil = ListVideoUtil.this;
                listVideoUtil.resolveMaterialToNormal(listVideoUtil.gsyVideoPlayer);
            }
        });
        if (!this.showFullAnimation || !(this.fullViewContainer instanceof FrameLayout)) {
            resolveFullAdd();
        } else {
            resolveMaterialAnimation();
        }
    }

    /* access modifiers changed from: private */
    public void resolveToNormal() {
        this.handler.postDelayed(new Runnable() {
            public void run() {
                boolean unused = ListVideoUtil.this.isFull = false;
                ListVideoUtil.this.fullViewContainer.removeAllViews();
                if (ListVideoUtil.this.gsyVideoPlayer.getParent() != null) {
                    ((ViewGroup) ListVideoUtil.this.gsyVideoPlayer.getParent()).removeView(ListVideoUtil.this.gsyVideoPlayer);
                }
                ListVideoUtil.this.orientationUtils.setEnable(false);
                ListVideoUtil.this.gsyVideoPlayer.setIfCurrentIsFullscreen(false);
                ListVideoUtil.this.fullViewContainer.setBackgroundColor(0);
                ListVideoUtil.this.listParent.addView(ListVideoUtil.this.gsyVideoPlayer, ListVideoUtil.this.listParams);
                ListVideoUtil.this.gsyVideoPlayer.getFullscreenButton().setImageResource(ListVideoUtil.this.gsyVideoPlayer.getEnlargeImageRes());
                ListVideoUtil.this.gsyVideoPlayer.getBackButton().setVisibility(8);
                ListVideoUtil.this.gsyVideoPlayer.setIfCurrentIsFullscreen(false);
                if (ListVideoUtil.this.videoAllCallBack != null) {
                    Debuger.printfLog("onQuitFullscreen");
                    ListVideoUtil.this.videoAllCallBack.onQuitFullscreen(ListVideoUtil.this.url, ListVideoUtil.this.mTitle, ListVideoUtil.this.gsyVideoPlayer);
                }
                if (ListVideoUtil.this.hideKey) {
                    CommonUtil.showNavKey(ListVideoUtil.this.context, ListVideoUtil.this.systemUiVisibility);
                }
                CommonUtil.showSupportActionBar(ListVideoUtil.this.context, ListVideoUtil.this.hideActionBar, ListVideoUtil.this.hideStatusBar);
            }
        }, (long) this.orientationUtils.backToProtVideo());
    }

    private void saveLocationStatus(Context context2, boolean z2, boolean z3) {
        this.listParent.getLocationOnScreen(this.listItemRect);
        int statusBarHeight = CommonUtil.getStatusBarHeight(context2);
        int actionBarHeight = CommonUtil.getActionBarHeight((Activity) context2);
        if (z2) {
            int[] iArr = this.listItemRect;
            iArr[1] = iArr[1] - statusBarHeight;
        }
        if (z3) {
            int[] iArr2 = this.listItemRect;
            iArr2[1] = iArr2[1] - actionBarHeight;
        }
        this.listItemSize[0] = this.listParent.getWidth();
        this.listItemSize[1] = this.listParent.getHeight();
    }

    public void addVideoPlayer(int i2, View view, String str, ViewGroup viewGroup, View view2) {
        viewGroup.removeAllViews();
        if (!isCurrentViewPlaying(i2, str)) {
            view2.setVisibility(0);
            viewGroup.removeAllViews();
            viewGroup.addView(view);
        } else if (!this.isFull) {
            ViewGroup viewGroup2 = (ViewGroup) this.gsyVideoPlayer.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeAllViews();
            }
            viewGroup.addView(this.gsyVideoPlayer);
            view2.setVisibility(4);
        }
    }

    public boolean backFromFull() {
        if (this.fullViewContainer.getChildCount() <= 0) {
            return false;
        }
        resolveMaterialToNormal(this.gsyVideoPlayer);
        return true;
    }

    public File getCachePath() {
        return this.cachePath;
    }

    public int getCurrentPositionWhenPlaying() {
        return this.gsyVideoPlayer.getCurrentPositionWhenPlaying();
    }

    public int getDuration() {
        return this.gsyVideoPlayer.getDuration();
    }

    public StandardGSYVideoPlayer getGsyVideoPlayer() {
        return this.gsyVideoPlayer;
    }

    public Map<String, String> getMapHeadData() {
        return this.mapHeadData;
    }

    public int getPlayPosition() {
        return this.playPosition;
    }

    public String getPlayTAG() {
        return this.TAG;
    }

    public int getSpeed() {
        return this.speed;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public boolean isAutoRotation() {
        return this.autoRotation;
    }

    public boolean isFull() {
        return this.isFull;
    }

    public boolean isFullLandFrist() {
        return this.fullLandFrist;
    }

    public boolean isHideActionBar() {
        return this.hideActionBar;
    }

    public boolean isHideKey() {
        return this.hideKey;
    }

    public boolean isHideStatusBar() {
        return this.hideStatusBar;
    }

    public boolean isLoop() {
        return this.isLoop;
    }

    public boolean isNeedLockFull() {
        return this.needLockFull;
    }

    public boolean isNeedShowWifiTip() {
        return this.needShowWifiTip;
    }

    public boolean isShowFullAnimation() {
        return this.showFullAnimation;
    }

    public boolean isSmall() {
        return this.isSmall;
    }

    public void releaseVideoPlayer() {
        ViewGroup viewGroup = (ViewGroup) this.gsyVideoPlayer.getParent();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        this.playPosition = -1;
        this.TAG = "NULL";
        OrientationUtils orientationUtils2 = this.orientationUtils;
        if (orientationUtils2 != null) {
            orientationUtils2.releaseListener();
        }
    }

    public void resolveFullBtn() {
        if (this.fullViewContainer != null) {
            if (!this.isFull) {
                resolveToFull();
            } else {
                resolveMaterialToNormal(this.gsyVideoPlayer);
            }
        }
    }

    public void setAutoRotation(boolean z2) {
        this.autoRotation = z2;
    }

    public void setCachePath(File file) {
        this.cachePath = file;
    }

    public void setFullLandFrist(boolean z2) {
        this.fullLandFrist = z2;
    }

    public void setFullViewContainer(ViewGroup viewGroup) {
        this.fullViewContainer = viewGroup;
    }

    public void setHideActionBar(boolean z2) {
        this.hideActionBar = z2;
    }

    public void setHideKey(boolean z2) {
        this.hideKey = z2;
    }

    public void setHideStatusBar(boolean z2) {
        this.hideStatusBar = z2;
    }

    public void setLoop(boolean z2) {
        this.isLoop = z2;
    }

    public void setMapHeadData(Map<String, String> map) {
        this.mapHeadData = map;
    }

    public void setNeedLockFull(boolean z2) {
        this.needLockFull = z2;
    }

    public void setNeedShowWifiTip(boolean z2) {
        this.needShowWifiTip = z2;
    }

    public void setPlayPositionAndTag(int i2, String str) {
        this.playPosition = i2;
        this.TAG = str;
    }

    public void setShowFullAnimation(boolean z2) {
        this.showFullAnimation = z2;
    }

    public void setSpeed(int i2) {
        this.speed = i2;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setVideoAllCallBack(i iVar) {
        this.videoAllCallBack = iVar;
        this.gsyVideoPlayer.setVideoAllCallBack(iVar);
    }

    public void showSmallVideo(Point point, boolean z2, boolean z3) {
        if (this.gsyVideoPlayer.getCurrentState() == 2) {
            this.gsyVideoPlayer.showSmallVideo(point, z2, z3);
            this.isSmall = true;
        }
    }

    public void smallVideoToNormal() {
        this.isSmall = false;
        this.gsyVideoPlayer.hideSmallVideo();
    }

    public void startPlay(String str) {
        if (isSmall()) {
            smallVideoToNormal();
        }
        this.url = str;
        this.gsyVideoPlayer.release();
        this.gsyVideoPlayer.setLooping(this.isLoop);
        this.gsyVideoPlayer.setSpeed((float) this.speed);
        this.gsyVideoPlayer.setNeedShowWifiTip(this.needShowWifiTip);
        this.gsyVideoPlayer.setNeedLockFull(this.needLockFull);
        this.gsyVideoPlayer.setUp(str, true, this.cachePath, this.mapHeadData, this.mTitle);
        if (!TextUtils.isEmpty(this.mTitle)) {
            this.gsyVideoPlayer.getTitleTextView().setText(this.mTitle);
        }
        this.gsyVideoPlayer.getTitleTextView().setVisibility(8);
        this.gsyVideoPlayer.getBackButton().setVisibility(8);
        this.gsyVideoPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ListVideoUtil.this.resolveFullBtn();
            }
        });
        this.gsyVideoPlayer.startPlayLogic();
    }
}
