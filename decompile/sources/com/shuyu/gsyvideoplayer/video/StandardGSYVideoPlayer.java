package com.shuyu.gsyvideoplayer.video;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.shuyu.gsyvideoplayer.R;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import com.shuyu.gsyvideoplayer.utils.NetworkUtils;
import com.shuyu.gsyvideoplayer.video.base.GSYBaseVideoPlayer;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoPlayer;
import java.io.File;
import jf.a;
import jg.f;
import jg.g;
import moe.codeest.enviews.ENDownloadView;
import moe.codeest.enviews.ENPlayView;
import org.greenrobot.eventbus.c;

public class StandardGSYVideoPlayer extends GSYVideoPlayer {
    protected Drawable mBottomProgressDrawable;
    protected Drawable mBottomShowProgressDrawable;
    protected Drawable mBottomShowProgressThumbDrawable;
    protected Dialog mBrightnessDialog;
    protected TextView mBrightnessDialogTv;
    protected ImageView mDialogIcon;
    protected ProgressBar mDialogProgressBar;
    protected Drawable mDialogProgressBarDrawable;
    protected int mDialogProgressHighLightColor = -11;
    protected int mDialogProgressNormalColor = -11;
    protected TextView mDialogSeekTime;
    protected TextView mDialogTotalTime;
    protected ProgressBar mDialogVolumeProgressBar;
    protected Dialog mProgressDialog;
    protected Dialog mVolumeDialog;
    protected Drawable mVolumeProgressDrawable;

    public StandardGSYVideoPlayer(Context context) {
        super(context);
    }

    public StandardGSYVideoPlayer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public StandardGSYVideoPlayer(Context context, Boolean bool) {
        super(context, bool);
    }

    private void initFullUI(StandardGSYVideoPlayer standardGSYVideoPlayer) {
        int i2;
        Drawable drawable;
        Drawable drawable2 = this.mBottomProgressDrawable;
        if (drawable2 != null) {
            standardGSYVideoPlayer.setBottomProgressBarDrawable(drawable2);
        }
        Drawable drawable3 = this.mBottomShowProgressDrawable;
        if (!(drawable3 == null || (drawable = this.mBottomShowProgressThumbDrawable) == null)) {
            standardGSYVideoPlayer.setBottomShowProgressBarDrawable(drawable3, drawable);
        }
        Drawable drawable4 = this.mVolumeProgressDrawable;
        if (drawable4 != null) {
            standardGSYVideoPlayer.setDialogVolumeProgressBar(drawable4);
        }
        Drawable drawable5 = this.mDialogProgressBarDrawable;
        if (drawable5 != null) {
            standardGSYVideoPlayer.setDialogProgressBar(drawable5);
        }
        int i3 = this.mDialogProgressHighLightColor;
        if (i3 >= 0 && (i2 = this.mDialogProgressNormalColor) >= 0) {
            standardGSYVideoPlayer.setDialogProgressColor(i3, i2);
        }
    }

    /* access modifiers changed from: protected */
    public void changeUiToClear() {
        Debuger.printfLog("changeUiToClear");
        setViewShowState(this.mTopContainer, 4);
        setViewShowState(this.mBottomContainer, 4);
        setViewShowState(this.mStartButton, 4);
        setViewShowState(this.mLoadingProgressBar, 4);
        setViewShowState(this.mThumbImageViewLayout, 4);
        setViewShowState(this.mBottomProgressBar, 4);
        setViewShowState(this.mLockScreen, 8);
        if (this.mLoadingProgressBar instanceof ENDownloadView) {
            ((ENDownloadView) this.mLoadingProgressBar).b();
        }
    }

    /* access modifiers changed from: protected */
    public void changeUiToCompleteClear() {
        Debuger.printfLog("changeUiToCompleteClear");
        setViewShowState(this.mTopContainer, 4);
        setViewShowState(this.mBottomContainer, 4);
        int i2 = 0;
        setViewShowState(this.mStartButton, 0);
        setViewShowState(this.mLoadingProgressBar, 4);
        setViewShowState(this.mThumbImageViewLayout, 0);
        setViewShowState(this.mBottomProgressBar, 0);
        ImageView imageView = this.mLockScreen;
        if (!this.mIfCurrentIsFullscreen || !this.mNeedLockFull) {
            i2 = 8;
        }
        setViewShowState(imageView, i2);
        if (this.mLoadingProgressBar instanceof ENDownloadView) {
            ((ENDownloadView) this.mLoadingProgressBar).b();
        }
        updateStartImage();
    }

    /* access modifiers changed from: protected */
    public void changeUiToCompleteShow() {
        Debuger.printfLog("changeUiToCompleteShow");
        int i2 = 0;
        setViewShowState(this.mTopContainer, 0);
        setViewShowState(this.mBottomContainer, 0);
        setViewShowState(this.mStartButton, 0);
        setViewShowState(this.mLoadingProgressBar, 4);
        setViewShowState(this.mThumbImageViewLayout, 0);
        setViewShowState(this.mBottomProgressBar, 4);
        ImageView imageView = this.mLockScreen;
        if (!this.mIfCurrentIsFullscreen || !this.mNeedLockFull) {
            i2 = 8;
        }
        setViewShowState(imageView, i2);
        if (this.mLoadingProgressBar instanceof ENDownloadView) {
            ((ENDownloadView) this.mLoadingProgressBar).b();
        }
        updateStartImage();
    }

    /* access modifiers changed from: protected */
    public void changeUiToError() {
        Debuger.printfLog("changeUiToError");
        setViewShowState(this.mTopContainer, 4);
        setViewShowState(this.mBottomContainer, 4);
        int i2 = 0;
        setViewShowState(this.mStartButton, 0);
        setViewShowState(this.mLoadingProgressBar, 4);
        setViewShowState(this.mThumbImageViewLayout, 4);
        setViewShowState(this.mBottomProgressBar, 4);
        ImageView imageView = this.mLockScreen;
        if (!this.mIfCurrentIsFullscreen || !this.mNeedLockFull) {
            i2 = 8;
        }
        setViewShowState(imageView, i2);
        if (this.mLoadingProgressBar instanceof ENDownloadView) {
            ((ENDownloadView) this.mLoadingProgressBar).b();
        }
        updateStartImage();
    }

    /* access modifiers changed from: protected */
    public void changeUiToNormal() {
        Debuger.printfLog("changeUiToNormal");
        int i2 = 0;
        setViewShowState(this.mTopContainer, 0);
        setViewShowState(this.mBottomContainer, 4);
        setViewShowState(this.mStartButton, 0);
        setViewShowState(this.mLoadingProgressBar, 4);
        setViewShowState(this.mThumbImageViewLayout, 0);
        setViewShowState(this.mBottomProgressBar, 4);
        ImageView imageView = this.mLockScreen;
        if (!this.mIfCurrentIsFullscreen || !this.mNeedLockFull) {
            i2 = 8;
        }
        setViewShowState(imageView, i2);
        updateStartImage();
        if (this.mLoadingProgressBar instanceof ENDownloadView) {
            ((ENDownloadView) this.mLoadingProgressBar).b();
        }
    }

    /* access modifiers changed from: protected */
    public void changeUiToPauseClear() {
        Debuger.printfLog("changeUiToPauseClear");
        changeUiToClear();
        setViewShowState(this.mBottomProgressBar, 0);
        updatePauseCover();
    }

    /* access modifiers changed from: protected */
    public void changeUiToPauseShow() {
        Debuger.printfLog("changeUiToPauseShow");
        int i2 = 0;
        setViewShowState(this.mTopContainer, 0);
        setViewShowState(this.mBottomContainer, 0);
        setViewShowState(this.mStartButton, 0);
        setViewShowState(this.mLoadingProgressBar, 4);
        setViewShowState(this.mThumbImageViewLayout, 4);
        setViewShowState(this.mBottomProgressBar, 4);
        ImageView imageView = this.mLockScreen;
        if (!this.mIfCurrentIsFullscreen || !this.mNeedLockFull) {
            i2 = 8;
        }
        setViewShowState(imageView, i2);
        if (this.mLoadingProgressBar instanceof ENDownloadView) {
            ((ENDownloadView) this.mLoadingProgressBar).b();
        }
        updateStartImage();
        updatePauseCover();
    }

    /* access modifiers changed from: protected */
    public void changeUiToPlayingBufferingClear() {
        Debuger.printfLog("changeUiToPlayingBufferingClear");
        setViewShowState(this.mTopContainer, 4);
        setViewShowState(this.mBottomContainer, 4);
        setViewShowState(this.mStartButton, 4);
        setViewShowState(this.mLoadingProgressBar, 0);
        setViewShowState(this.mThumbImageViewLayout, 4);
        setViewShowState(this.mBottomProgressBar, 0);
        setViewShowState(this.mLockScreen, 8);
        if ((this.mLoadingProgressBar instanceof ENDownloadView) && ((ENDownloadView) this.mLoadingProgressBar).getCurrentState() == 0) {
            ((ENDownloadView) this.mLoadingProgressBar).a();
        }
        updateStartImage();
    }

    /* access modifiers changed from: protected */
    public void changeUiToPlayingBufferingShow() {
        Debuger.printfLog("changeUiToPlayingBufferingShow");
        setViewShowState(this.mTopContainer, 0);
        setViewShowState(this.mBottomContainer, 0);
        setViewShowState(this.mStartButton, 4);
        setViewShowState(this.mLoadingProgressBar, 0);
        setViewShowState(this.mThumbImageViewLayout, 4);
        setViewShowState(this.mBottomProgressBar, 4);
        setViewShowState(this.mLockScreen, 8);
        if ((this.mLoadingProgressBar instanceof ENDownloadView) && ((ENDownloadView) this.mLoadingProgressBar).getCurrentState() == 0) {
            ((ENDownloadView) this.mLoadingProgressBar).a();
        }
    }

    /* access modifiers changed from: protected */
    public void changeUiToPlayingClear() {
        Debuger.printfLog("changeUiToPlayingClear");
        changeUiToClear();
        setViewShowState(this.mBottomProgressBar, 0);
    }

    /* access modifiers changed from: protected */
    public void changeUiToPlayingShow() {
        Debuger.printfLog("changeUiToPlayingShow");
        int i2 = 0;
        setViewShowState(this.mTopContainer, 0);
        setViewShowState(this.mBottomContainer, 0);
        setViewShowState(this.mStartButton, 0);
        setViewShowState(this.mLoadingProgressBar, 4);
        setViewShowState(this.mThumbImageViewLayout, 4);
        setViewShowState(this.mBottomProgressBar, 4);
        ImageView imageView = this.mLockScreen;
        if (!this.mIfCurrentIsFullscreen || !this.mNeedLockFull) {
            i2 = 8;
        }
        setViewShowState(imageView, i2);
        if (this.mLoadingProgressBar instanceof ENDownloadView) {
            ((ENDownloadView) this.mLoadingProgressBar).b();
        }
        updateStartImage();
    }

    /* access modifiers changed from: protected */
    public void changeUiToPrepareingClear() {
        Debuger.printfLog("changeUiToPrepareingClear");
        setViewShowState(this.mTopContainer, 4);
        setViewShowState(this.mBottomContainer, 4);
        setViewShowState(this.mStartButton, 4);
        setViewShowState(this.mLoadingProgressBar, 4);
        setViewShowState(this.mThumbImageViewLayout, 4);
        setViewShowState(this.mBottomProgressBar, 4);
        setViewShowState(this.mLockScreen, 8);
        if (this.mLoadingProgressBar instanceof ENDownloadView) {
            ((ENDownloadView) this.mLoadingProgressBar).b();
        }
    }

    /* access modifiers changed from: protected */
    public void changeUiToPreparingShow() {
        Debuger.printfLog("changeUiToPreparingShow");
        setViewShowState(this.mTopContainer, 0);
        setViewShowState(this.mBottomContainer, 0);
        setViewShowState(this.mStartButton, 4);
        setViewShowState(this.mLoadingProgressBar, 0);
        setViewShowState(this.mThumbImageViewLayout, 4);
        setViewShowState(this.mBottomProgressBar, 4);
        setViewShowState(this.mLockScreen, 8);
        if ((this.mLoadingProgressBar instanceof ENDownloadView) && ((ENDownloadView) this.mLoadingProgressBar).getCurrentState() == 0) {
            ((ENDownloadView) this.mLoadingProgressBar).a();
        }
    }

    /* access modifiers changed from: protected */
    public void cloneParams(GSYBaseVideoPlayer gSYBaseVideoPlayer, GSYBaseVideoPlayer gSYBaseVideoPlayer2) {
        super.cloneParams(gSYBaseVideoPlayer, gSYBaseVideoPlayer2);
        StandardGSYVideoPlayer standardGSYVideoPlayer = (StandardGSYVideoPlayer) gSYBaseVideoPlayer;
        StandardGSYVideoPlayer standardGSYVideoPlayer2 = (StandardGSYVideoPlayer) gSYBaseVideoPlayer2;
        if (!(standardGSYVideoPlayer2.mProgressBar == null || standardGSYVideoPlayer.mProgressBar == null)) {
            standardGSYVideoPlayer2.mProgressBar.setProgress(standardGSYVideoPlayer.mProgressBar.getProgress());
            standardGSYVideoPlayer2.mProgressBar.setSecondaryProgress(standardGSYVideoPlayer.mProgressBar.getSecondaryProgress());
        }
        if (!(standardGSYVideoPlayer2.mTotalTimeTextView == null || standardGSYVideoPlayer.mTotalTimeTextView == null)) {
            standardGSYVideoPlayer2.mTotalTimeTextView.setText(standardGSYVideoPlayer.mTotalTimeTextView.getText());
        }
        if (standardGSYVideoPlayer2.mCurrentTimeTextView != null && standardGSYVideoPlayer.mCurrentTimeTextView != null) {
            standardGSYVideoPlayer2.mCurrentTimeTextView.setText(standardGSYVideoPlayer.mCurrentTimeTextView.getText());
        }
    }

    /* access modifiers changed from: protected */
    public void dismissBrightnessDialog() {
        Dialog dialog = this.mBrightnessDialog;
        if (dialog != null) {
            dialog.dismiss();
            this.mBrightnessDialog = null;
        }
    }

    /* access modifiers changed from: protected */
    public void dismissProgressDialog() {
        Dialog dialog = this.mProgressDialog;
        if (dialog != null) {
            dialog.dismiss();
            this.mProgressDialog = null;
        }
    }

    /* access modifiers changed from: protected */
    public void dismissVolumeDialog() {
        Dialog dialog = this.mVolumeDialog;
        if (dialog != null) {
            dialog.dismiss();
            this.mVolumeDialog = null;
        }
    }

    /* access modifiers changed from: protected */
    public void firstFrameDetectView(int i2, int i3) {
        c.a().d(new a(i2, i3));
    }

    /* access modifiers changed from: protected */
    public int getBrightnessLayoutId() {
        return R.layout.video_brightness;
    }

    /* access modifiers changed from: protected */
    public int getBrightnessTextId() {
        return R.id.app_video_brightness;
    }

    public int getLayoutId() {
        return R.layout.video_layout_standard;
    }

    /* access modifiers changed from: protected */
    public int getProgressDialogAllDurationTextId() {
        return R.id.tv_duration;
    }

    /* access modifiers changed from: protected */
    public int getProgressDialogCurrentDurationTextId() {
        return R.id.tv_current;
    }

    /* access modifiers changed from: protected */
    public int getProgressDialogImageId() {
        return R.id.duration_image_tip;
    }

    /* access modifiers changed from: protected */
    public int getProgressDialogLayoutId() {
        return R.layout.video_progress_dialog;
    }

    /* access modifiers changed from: protected */
    public int getProgressDialogProgressId() {
        return R.id.duration_progressbar;
    }

    /* access modifiers changed from: protected */
    public int getVolumeLayoutId() {
        return R.layout.video_volume_dialog;
    }

    /* access modifiers changed from: protected */
    public int getVolumeProgressId() {
        return R.id.volume_progressbar;
    }

    /* access modifiers changed from: protected */
    public void hideAllWidget() {
        setViewShowState(this.mBottomContainer, 4);
        setViewShowState(this.mTopContainer, 4);
        setViewShowState(this.mBottomProgressBar, 0);
        setViewShowState(this.mStartButton, 4);
    }

    /* access modifiers changed from: protected */
    public void init(Context context) {
        super.init(context);
        if (this.mBottomProgressDrawable != null) {
            this.mBottomProgressBar.setProgressDrawable(this.mBottomProgressDrawable);
        }
        if (this.mBottomShowProgressDrawable != null) {
            this.mProgressBar.setProgressDrawable(this.mBottomProgressDrawable);
        }
        if (this.mBottomShowProgressThumbDrawable != null) {
            this.mProgressBar.setThumb(this.mBottomShowProgressThumbDrawable);
        }
    }

    /* access modifiers changed from: protected */
    public void onClickUiToggle() {
        if (this.mIfCurrentIsFullscreen && this.mLockCurScreen && this.mNeedLockFull) {
            setViewShowState(this.mLockScreen, 0);
        } else if (this.mCurrentState == 1) {
            if (this.mBottomContainer == null) {
                return;
            }
            if (this.mBottomContainer.getVisibility() == 0) {
                changeUiToPrepareingClear();
            } else {
                changeUiToPreparingShow();
            }
        } else if (this.mCurrentState == 2) {
            if (this.mBottomContainer == null) {
                return;
            }
            if (this.mBottomContainer.getVisibility() == 0) {
                changeUiToPlayingClear();
            } else {
                changeUiToPlayingShow();
            }
        } else if (this.mCurrentState == 5) {
            if (this.mBottomContainer == null) {
                return;
            }
            if (this.mBottomContainer.getVisibility() == 0) {
                changeUiToPauseClear();
            } else {
                changeUiToPauseShow();
            }
        } else if (this.mCurrentState == 6) {
            if (this.mBottomContainer == null) {
                return;
            }
            if (this.mBottomContainer.getVisibility() == 0) {
                changeUiToCompleteClear();
            } else {
                changeUiToCompleteShow();
            }
        } else if (this.mCurrentState == 3 && this.mBottomContainer != null) {
            if (this.mBottomContainer.getVisibility() == 0) {
                changeUiToPlayingBufferingClear();
            } else {
                changeUiToPlayingBufferingShow();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dismissVolumeDialog();
        dismissBrightnessDialog();
    }

    public void restartTimerTask() {
        startProgressTimer();
        startDismissControlViewTimer();
    }

    public void saveFrame(File file, g gVar) {
        saveFrame(file, false, gVar);
    }

    public void saveFrame(File file, boolean z2, g gVar) {
        if (getCurrentPlayer().getRenderProxy() != null) {
            getCurrentPlayer().getRenderProxy().saveFrame(file, z2, gVar);
        }
    }

    public void setBottomProgressBarDrawable(Drawable drawable) {
        this.mBottomProgressDrawable = drawable;
        if (this.mBottomProgressBar != null) {
            this.mBottomProgressBar.setProgressDrawable(drawable);
        }
    }

    public void setBottomShowProgressBarDrawable(Drawable drawable, Drawable drawable2) {
        this.mBottomShowProgressDrawable = drawable;
        this.mBottomShowProgressThumbDrawable = drawable2;
        if (this.mProgressBar != null) {
            this.mProgressBar.setProgressDrawable(drawable);
            this.mProgressBar.setThumb(drawable2);
        }
    }

    public void setDialogProgressBar(Drawable drawable) {
        this.mDialogProgressBarDrawable = drawable;
    }

    public void setDialogProgressColor(int i2, int i3) {
        this.mDialogProgressHighLightColor = i2;
        this.mDialogProgressNormalColor = i3;
    }

    public void setDialogVolumeProgressBar(Drawable drawable) {
        this.mVolumeProgressDrawable = drawable;
    }

    /* access modifiers changed from: protected */
    public void showBrightnessDialog(float f2) {
        if (this.mBrightnessDialog == null) {
            View inflate = LayoutInflater.from(getActivityContext()).inflate(getBrightnessLayoutId(), (ViewGroup) null);
            if (inflate.findViewById(getBrightnessTextId()) instanceof TextView) {
                this.mBrightnessDialogTv = (TextView) inflate.findViewById(getBrightnessTextId());
            }
            Dialog dialog = new Dialog(getActivityContext(), R.style.video_style_dialog_progress);
            this.mBrightnessDialog = dialog;
            dialog.setContentView(inflate);
            this.mBrightnessDialog.getWindow().addFlags(8);
            this.mBrightnessDialog.getWindow().addFlags(32);
            this.mBrightnessDialog.getWindow().addFlags(16);
            this.mBrightnessDialog.getWindow().getDecorView().setSystemUiVisibility(2);
            this.mBrightnessDialog.getWindow().setLayout(-2, -2);
            WindowManager.LayoutParams attributes = this.mBrightnessDialog.getWindow().getAttributes();
            attributes.gravity = 8388661;
            attributes.width = getWidth();
            attributes.height = getHeight();
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            attributes.x = iArr[0];
            attributes.y = iArr[1];
            this.mBrightnessDialog.getWindow().setAttributes(attributes);
        }
        if (!this.mBrightnessDialog.isShowing()) {
            this.mBrightnessDialog.show();
        }
        TextView textView = this.mBrightnessDialogTv;
        if (textView != null) {
            textView.setText(((int) (f2 * 100.0f)) + "%");
        }
    }

    /* access modifiers changed from: protected */
    public void showProgressDialog(float f2, String str, int i2, String str2, int i3) {
        int i4;
        ImageView imageView;
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        if (this.mProgressDialog == null) {
            View inflate = LayoutInflater.from(getActivityContext()).inflate(getProgressDialogLayoutId(), (ViewGroup) null);
            if (inflate.findViewById(getProgressDialogProgressId()) instanceof ProgressBar) {
                ProgressBar progressBar2 = (ProgressBar) inflate.findViewById(getProgressDialogProgressId());
                this.mDialogProgressBar = progressBar2;
                Drawable drawable = this.mDialogProgressBarDrawable;
                if (drawable != null) {
                    progressBar2.setProgressDrawable(drawable);
                }
            }
            if (inflate.findViewById(getProgressDialogCurrentDurationTextId()) instanceof TextView) {
                this.mDialogSeekTime = (TextView) inflate.findViewById(getProgressDialogCurrentDurationTextId());
            }
            if (inflate.findViewById(getProgressDialogAllDurationTextId()) instanceof TextView) {
                this.mDialogTotalTime = (TextView) inflate.findViewById(getProgressDialogAllDurationTextId());
            }
            if (inflate.findViewById(getProgressDialogImageId()) instanceof ImageView) {
                this.mDialogIcon = (ImageView) inflate.findViewById(getProgressDialogImageId());
            }
            Dialog dialog = new Dialog(getActivityContext(), R.style.video_style_dialog_progress);
            this.mProgressDialog = dialog;
            dialog.setContentView(inflate);
            this.mProgressDialog.getWindow().addFlags(8);
            this.mProgressDialog.getWindow().addFlags(32);
            this.mProgressDialog.getWindow().addFlags(16);
            this.mProgressDialog.getWindow().setLayout(getWidth(), getHeight());
            int i5 = this.mDialogProgressNormalColor;
            if (!(i5 == -11 || (textView2 = this.mDialogTotalTime) == null)) {
                textView2.setTextColor(i5);
            }
            int i6 = this.mDialogProgressHighLightColor;
            if (!(i6 == -11 || (textView = this.mDialogSeekTime) == null)) {
                textView.setTextColor(i6);
            }
            WindowManager.LayoutParams attributes = this.mProgressDialog.getWindow().getAttributes();
            attributes.gravity = 48;
            attributes.width = getWidth();
            attributes.height = getHeight();
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            attributes.x = iArr[0];
            attributes.y = iArr[1];
            this.mProgressDialog.getWindow().setAttributes(attributes);
        }
        if (!this.mProgressDialog.isShowing()) {
            this.mProgressDialog.show();
        }
        TextView textView3 = this.mDialogSeekTime;
        if (textView3 != null) {
            textView3.setText(str);
        }
        TextView textView4 = this.mDialogTotalTime;
        if (textView4 != null) {
            textView4.setText(" / " + str2);
        }
        if (i3 > 0 && (progressBar = this.mDialogProgressBar) != null) {
            progressBar.setProgress((i2 * 100) / i3);
        }
        if (f2 > 0.0f) {
            imageView = this.mDialogIcon;
            if (imageView != null) {
                i4 = R.drawable.video_forward_icon;
            } else {
                return;
            }
        } else {
            imageView = this.mDialogIcon;
            if (imageView != null) {
                i4 = R.drawable.video_backward_icon;
            } else {
                return;
            }
        }
        imageView.setBackgroundResource(i4);
    }

    /* access modifiers changed from: protected */
    public void showVolumeDialog(float f2, int i2) {
        if (this.mVolumeDialog == null) {
            View inflate = LayoutInflater.from(getActivityContext()).inflate(getVolumeLayoutId(), (ViewGroup) null);
            if (inflate.findViewById(getVolumeProgressId()) instanceof ProgressBar) {
                ProgressBar progressBar = (ProgressBar) inflate.findViewById(getVolumeProgressId());
                this.mDialogVolumeProgressBar = progressBar;
                Drawable drawable = this.mVolumeProgressDrawable;
                if (!(drawable == null || progressBar == null)) {
                    progressBar.setProgressDrawable(drawable);
                }
            }
            Dialog dialog = new Dialog(getActivityContext(), R.style.video_style_dialog_progress);
            this.mVolumeDialog = dialog;
            dialog.setContentView(inflate);
            this.mVolumeDialog.getWindow().addFlags(8);
            this.mVolumeDialog.getWindow().addFlags(32);
            this.mVolumeDialog.getWindow().addFlags(16);
            this.mVolumeDialog.getWindow().setLayout(-2, -2);
            WindowManager.LayoutParams attributes = this.mVolumeDialog.getWindow().getAttributes();
            attributes.gravity = 8388659;
            attributes.width = getWidth();
            attributes.height = getHeight();
            int[] iArr = new int[2];
            getLocationOnScreen(iArr);
            attributes.x = iArr[0];
            attributes.y = iArr[1];
            this.mVolumeDialog.getWindow().setAttributes(attributes);
        }
        if (!this.mVolumeDialog.isShowing()) {
            this.mVolumeDialog.show();
        }
        ProgressBar progressBar2 = this.mDialogVolumeProgressBar;
        if (progressBar2 != null) {
            progressBar2.setProgress(i2);
        }
    }

    /* access modifiers changed from: protected */
    public void showWifiDialog() {
        if (!NetworkUtils.isAvailable(this.mContext)) {
            startPlayLogic();
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivityContext());
        builder.setMessage(getResources().getString(R.string.tips_not_wifi));
        builder.setPositiveButton(getResources().getString(R.string.tips_not_wifi_confirm), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
                StandardGSYVideoPlayer.this.startPlayLogic();
            }
        });
        builder.setNegativeButton(getResources().getString(R.string.tips_not_wifi_cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    public void startPlayLogic() {
        synchronized (this) {
            if (this.mVideoAllCallBack != null) {
                Debuger.printfLog("onClickStartThumb");
                this.mVideoAllCallBack.onClickStartThumb(this.mOriginUrl, this.mTitle, this);
            }
            prepareVideo();
            startDismissControlViewTimer();
        }
    }

    public GSYBaseVideoPlayer startWindowFullscreen(Context context, boolean z2, boolean z3) {
        GSYBaseVideoPlayer startWindowFullscreen = super.startWindowFullscreen(context, z2, z3);
        if (startWindowFullscreen != null) {
            StandardGSYVideoPlayer standardGSYVideoPlayer = (StandardGSYVideoPlayer) startWindowFullscreen;
            standardGSYVideoPlayer.setLockClickListener(this.mLockClickListener);
            standardGSYVideoPlayer.setNeedLockFull(isNeedLockFull());
            initFullUI(standardGSYVideoPlayer);
        }
        return startWindowFullscreen;
    }

    public void taskShotPic(f fVar) {
        taskShotPic(fVar, false);
    }

    public void taskShotPic(f fVar, boolean z2) {
        if (getCurrentPlayer().getRenderProxy() != null) {
            getCurrentPlayer().getRenderProxy().taskShotPic(fVar, z2);
        }
    }

    /* access modifiers changed from: protected */
    public void updateStartImage() {
        if (this.mStartButton instanceof ENPlayView) {
            ENPlayView eNPlayView = (ENPlayView) this.mStartButton;
            eNPlayView.setDuration(500);
            if (this.mCurrentState == 2) {
                eNPlayView.a();
                return;
            }
            int i2 = this.mCurrentState;
            eNPlayView.b();
        } else if (this.mStartButton instanceof ImageView) {
            ((ImageView) this.mStartButton).setImageResource(this.mCurrentState == 2 ? R.drawable.video_click_pause_selector : this.mCurrentState == 7 ? R.drawable.video_click_error_selector : R.drawable.video_click_play_selector);
        }
    }
}
