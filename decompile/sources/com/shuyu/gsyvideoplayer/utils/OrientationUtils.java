package com.shuyu.gsyvideoplayer.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.view.OrientationEventListener;
import android.widget.ImageView;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;
import java.lang.ref.WeakReference;

public class OrientationUtils {
    private static final int LAND_TYPE_NORMAL = 1;
    private static final int LAND_TYPE_NULL = 0;
    private static final int LAND_TYPE_REVERSE = 2;
    private WeakReference<Activity> mActivity;
    /* access modifiers changed from: private */
    public boolean mClick;
    /* access modifiers changed from: private */
    public boolean mClickLand;
    /* access modifiers changed from: private */
    public boolean mClickPort;
    private boolean mEnable;
    /* access modifiers changed from: private */
    public int mIsLand;
    /* access modifiers changed from: private */
    public boolean mIsOnlyRotateLand;
    /* access modifiers changed from: private */
    public boolean mIsPause;
    private OrientationEventListener mOrientationEventListener;
    /* access modifiers changed from: private */
    public OrientationOption mOrientationOption;
    /* access modifiers changed from: private */
    public boolean mRotateWithSystem;
    /* access modifiers changed from: private */
    public int mScreenType;
    /* access modifiers changed from: private */
    public GSYBaseVideoPlayer mVideoPlayer;

    public OrientationUtils(Activity activity, GSYBaseVideoPlayer gSYBaseVideoPlayer) {
        this(activity, gSYBaseVideoPlayer, (OrientationOption) null);
    }

    public OrientationUtils(Activity activity, GSYBaseVideoPlayer gSYBaseVideoPlayer, OrientationOption orientationOption) {
        this.mScreenType = 1;
        this.mIsLand = 0;
        this.mClick = false;
        this.mClickLand = false;
        this.mEnable = true;
        this.mRotateWithSystem = true;
        this.mIsPause = false;
        this.mIsOnlyRotateLand = false;
        this.mActivity = new WeakReference<>(activity);
        this.mVideoPlayer = gSYBaseVideoPlayer;
        if (orientationOption == null) {
            this.mOrientationOption = new OrientationOption();
        } else {
            this.mOrientationOption = orientationOption;
        }
        initGravity(activity);
        init();
    }

    private void initGravity(Activity activity) {
        if (this.mIsLand == 0) {
            int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            if (rotation == 0) {
                this.mIsLand = 0;
                this.mScreenType = 1;
            } else if (rotation == 3) {
                this.mIsLand = 2;
                this.mScreenType = 8;
            } else {
                this.mIsLand = 1;
                this.mScreenType = 0;
            }
        }
    }

    /* access modifiers changed from: private */
    public void setRequestedOrientation(int i2) {
        Activity activity = (Activity) this.mActivity.get();
        if (activity != null) {
            try {
                activity.setRequestedOrientation(i2);
            } catch (IllegalStateException e2) {
                if (Build.VERSION.SDK_INT == 26 || Build.VERSION.SDK_INT == 27) {
                    Debuger.printfError("OrientationUtils", (Exception) e2);
                } else {
                    e2.printStackTrace();
                }
            }
        }
    }

    public int backToProtVideo() {
        if (this.mIsLand <= 0) {
            return 0;
        }
        this.mClick = true;
        GSYBaseVideoPlayer gSYBaseVideoPlayer = this.mVideoPlayer;
        if (!(gSYBaseVideoPlayer == null || gSYBaseVideoPlayer.getFullscreenButton() == null)) {
            this.mVideoPlayer.getFullscreenButton().setImageResource(this.mVideoPlayer.getEnlargeImageRes());
        }
        this.mIsLand = 0;
        this.mClickPort = false;
        return 500;
    }

    public int getIsLand() {
        return this.mIsLand;
    }

    public OrientationOption getOrientationOption() {
        return this.mOrientationOption;
    }

    public int getScreenType() {
        return this.mScreenType;
    }

    /* access modifiers changed from: protected */
    public void init() {
        Activity activity = (Activity) this.mActivity.get();
        if (activity != null) {
            final Context applicationContext = activity.getApplicationContext();
            AnonymousClass1 r1 = new OrientationEventListener(applicationContext) {
                public void onOrientationChanged(int i2) {
                    ImageView imageView;
                    int i3;
                    if (!(Settings.System.getInt(applicationContext.getContentResolver(), "accelerometer_rotation", 0) == 1) && OrientationUtils.this.mRotateWithSystem && (!OrientationUtils.this.mIsOnlyRotateLand || OrientationUtils.this.getIsLand() == 0)) {
                        return;
                    }
                    if ((OrientationUtils.this.mVideoPlayer == null || !OrientationUtils.this.mVideoPlayer.isVerticalFullByVideoSize()) && !OrientationUtils.this.mIsPause) {
                        if ((i2 < 0 || i2 > OrientationUtils.this.mOrientationOption.getNormalPortraitAngleStart()) && i2 < OrientationUtils.this.mOrientationOption.getNormalPortraitAngleEnd()) {
                            if (i2 < OrientationUtils.this.mOrientationOption.getNormalLandAngleStart() || i2 > OrientationUtils.this.mOrientationOption.getNormalLandAngleEnd()) {
                                if (i2 > OrientationUtils.this.mOrientationOption.getReverseLandAngleStart() && i2 < OrientationUtils.this.mOrientationOption.getReverseLandAngleEnd()) {
                                    if (OrientationUtils.this.mClick) {
                                        if (OrientationUtils.this.mIsLand == 2 || OrientationUtils.this.mClickPort) {
                                            boolean unused = OrientationUtils.this.mClickLand = true;
                                            boolean unused2 = OrientationUtils.this.mClick = false;
                                            int unused3 = OrientationUtils.this.mIsLand = 2;
                                            return;
                                        }
                                        return;
                                    } else if (OrientationUtils.this.mIsLand != 2) {
                                        int unused4 = OrientationUtils.this.mScreenType = 0;
                                        OrientationUtils.this.setRequestedOrientation(8);
                                        if (OrientationUtils.this.mVideoPlayer.getFullscreenButton() != null) {
                                            OrientationUtils.this.mVideoPlayer.getFullscreenButton().setImageResource(OrientationUtils.this.mVideoPlayer.getShrinkImageRes());
                                        }
                                        int unused5 = OrientationUtils.this.mIsLand = 2;
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else if (OrientationUtils.this.mClick) {
                                if (OrientationUtils.this.mIsLand == 1 || OrientationUtils.this.mClickPort) {
                                    boolean unused6 = OrientationUtils.this.mClickLand = true;
                                    boolean unused7 = OrientationUtils.this.mClick = false;
                                    int unused8 = OrientationUtils.this.mIsLand = 1;
                                    return;
                                }
                                return;
                            } else if (OrientationUtils.this.mIsLand != 1) {
                                int unused9 = OrientationUtils.this.mScreenType = 0;
                                OrientationUtils.this.setRequestedOrientation(0);
                                if (OrientationUtils.this.mVideoPlayer.getFullscreenButton() != null) {
                                    OrientationUtils.this.mVideoPlayer.getFullscreenButton().setImageResource(OrientationUtils.this.mVideoPlayer.getShrinkImageRes());
                                }
                                int unused10 = OrientationUtils.this.mIsLand = 1;
                            } else {
                                return;
                            }
                        } else if (OrientationUtils.this.mClick) {
                            if (OrientationUtils.this.mIsLand <= 0 || OrientationUtils.this.mClickLand) {
                                boolean unused11 = OrientationUtils.this.mClickPort = true;
                                boolean unused12 = OrientationUtils.this.mClick = false;
                                int unused13 = OrientationUtils.this.mIsLand = 0;
                                return;
                            }
                            return;
                        } else if (OrientationUtils.this.mIsLand <= 0) {
                            return;
                        } else {
                            if (!OrientationUtils.this.mIsOnlyRotateLand) {
                                int unused14 = OrientationUtils.this.mScreenType = 1;
                                OrientationUtils.this.setRequestedOrientation(1);
                                if (OrientationUtils.this.mVideoPlayer.getFullscreenButton() != null) {
                                    if (OrientationUtils.this.mVideoPlayer.isIfCurrentIsFullscreen()) {
                                        imageView = OrientationUtils.this.mVideoPlayer.getFullscreenButton();
                                        i3 = OrientationUtils.this.mVideoPlayer.getShrinkImageRes();
                                    } else {
                                        imageView = OrientationUtils.this.mVideoPlayer.getFullscreenButton();
                                        i3 = OrientationUtils.this.mVideoPlayer.getEnlargeImageRes();
                                    }
                                    imageView.setImageResource(i3);
                                }
                                int unused15 = OrientationUtils.this.mIsLand = 0;
                            }
                        }
                        boolean unused16 = OrientationUtils.this.mClick = false;
                    }
                }
            };
            this.mOrientationEventListener = r1;
            r1.enable();
        }
    }

    public boolean isClick() {
        return this.mClick;
    }

    public boolean isClickLand() {
        return this.mClickLand;
    }

    public boolean isClickPort() {
        return this.mClickPort;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public boolean isOnlyRotateLand() {
        return this.mIsOnlyRotateLand;
    }

    public boolean isPause() {
        return this.mIsPause;
    }

    public boolean isRotateWithSystem() {
        return this.mRotateWithSystem;
    }

    public void releaseListener() {
        OrientationEventListener orientationEventListener = this.mOrientationEventListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    public void resolveByClick() {
        int i2;
        ImageView imageView;
        GSYBaseVideoPlayer gSYBaseVideoPlayer;
        if (this.mIsLand != 0 || (gSYBaseVideoPlayer = this.mVideoPlayer) == null || !gSYBaseVideoPlayer.isVerticalFullByVideoSize()) {
            this.mClick = true;
            Activity activity = (Activity) this.mActivity.get();
            if (activity != null) {
                if (this.mIsLand == 0) {
                    if (activity.getRequestedOrientation() == 8) {
                        this.mScreenType = 8;
                    } else {
                        this.mScreenType = 0;
                    }
                    setRequestedOrientation(this.mScreenType);
                    if (this.mVideoPlayer.getFullscreenButton() != null) {
                        this.mVideoPlayer.getFullscreenButton().setImageResource(this.mVideoPlayer.getShrinkImageRes());
                    }
                    this.mIsLand = 1;
                    this.mClickLand = false;
                    return;
                }
                this.mScreenType = 1;
                setRequestedOrientation(1);
                if (this.mVideoPlayer.getFullscreenButton() != null) {
                    if (this.mVideoPlayer.isIfCurrentIsFullscreen()) {
                        imageView = this.mVideoPlayer.getFullscreenButton();
                        i2 = this.mVideoPlayer.getShrinkImageRes();
                    } else {
                        imageView = this.mVideoPlayer.getFullscreenButton();
                        i2 = this.mVideoPlayer.getEnlargeImageRes();
                    }
                    imageView.setImageResource(i2);
                }
                this.mIsLand = 0;
                this.mClickPort = false;
            }
        }
    }

    public void setClick(boolean z2) {
        this.mClick = z2;
    }

    public void setClickLand(boolean z2) {
        this.mClickLand = z2;
    }

    public void setClickPort(boolean z2) {
        this.mClickPort = z2;
    }

    public void setEnable(boolean z2) {
        this.mEnable = z2;
        if (z2) {
            this.mOrientationEventListener.enable();
        } else {
            this.mOrientationEventListener.disable();
        }
    }

    public void setIsLand(int i2) {
        this.mIsLand = i2;
    }

    public void setIsPause(boolean z2) {
        this.mIsPause = z2;
    }

    public void setOnlyRotateLand(boolean z2) {
        this.mIsOnlyRotateLand = z2;
    }

    public void setOrientationOption(OrientationOption orientationOption) {
        this.mOrientationOption = orientationOption;
    }

    public void setRotateWithSystem(boolean z2) {
        this.mRotateWithSystem = z2;
    }

    public void setScreenType(int i2) {
        this.mScreenType = i2;
    }
}
