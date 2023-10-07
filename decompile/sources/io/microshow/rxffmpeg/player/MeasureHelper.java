package io.microshow.rxffmpeg.player;

import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;

public class MeasureHelper {
    private FitModel mFitModel = FitModel.FM_DEFAULT;
    private int mMeasuredHeight;
    private int mMeasuredWidth;
    private VideoSizeInfo mVideoSizeInfo;
    private WeakReference<View> mWeakView;

    public enum FitModel {
        FM_DEFAULT,
        FM_FULL_SCREEN_WIDTH,
        FM_FULL_SCREEN_HEIGHT,
        FM_WH_16X9
    }

    public static class VideoSizeInfo {
        private float mDar;
        private int mHeight;
        private int mWidth;

        public VideoSizeInfo(int i2, int i3, float f2) {
            this.mWidth = i2;
            this.mHeight = i3;
            this.mDar = f2;
        }

        public float getDar() {
            return this.mDar;
        }

        public int getHeight() {
            return this.mHeight;
        }

        public int getWidth() {
            return this.mWidth;
        }
    }

    public MeasureHelper(View view) {
        this.mWeakView = new WeakReference<>(view);
    }

    public int[] doMeasure(int i2, int i3) {
        if (this.mFitModel == FitModel.FM_DEFAULT || this.mFitModel == FitModel.FM_FULL_SCREEN_HEIGHT) {
            i3 = this.mMeasuredHeight;
        }
        return new int[]{i2, i3};
    }

    public FitModel getFitModel() {
        return this.mFitModel;
    }

    public VideoSizeInfo getVideoSizeInfo() {
        return this.mVideoSizeInfo;
    }

    public View getView() {
        View view;
        WeakReference<View> weakReference = this.mWeakView;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return null;
        }
        return view;
    }

    public boolean isFullScreen() {
        return false;
    }

    public void setDefaultVideoLayoutParams() {
        View view = getView();
        if (view instanceof RxFFmpegPlayerView) {
            RxFFmpegPlayerView rxFFmpegPlayerView = (RxFFmpegPlayerView) view;
            int screenWidth = Helper.getScreenWidth(view.getContext());
            int i2 = (screenWidth * 9) / 16;
            setVideoSizeInfo(new VideoSizeInfo(screenWidth, i2, ((float) screenWidth) / ((float) i2)));
            setVideoLayoutParams(rxFFmpegPlayerView.getTextureView(), rxFFmpegPlayerView.getContainerView());
        }
    }

    public void setFitModel(FitModel fitModel) {
        this.mFitModel = fitModel;
    }

    public void setVideoLayoutParams(TextureView textureView, FrameLayout frameLayout) {
        int i2;
        if (textureView != null && frameLayout != null && getVideoSizeInfo() != null) {
            int width = getVideoSizeInfo().getWidth();
            int height = getVideoSizeInfo().getHeight();
            getVideoSizeInfo().getDar();
            float f2 = ((float) width) / ((float) height);
            int screenWidth = Helper.getScreenWidth(getView().getContext());
            if (isFullScreen()) {
                screenWidth = Helper.getScreenHeight(getView().getContext());
            } else {
                if (this.mFitModel != FitModel.FM_FULL_SCREEN_WIDTH) {
                    if (this.mFitModel == FitModel.FM_FULL_SCREEN_HEIGHT) {
                        screenWidth = Helper.getFullScreenHeight(getView().getContext());
                    } else if (this.mFitModel == FitModel.FM_WH_16X9) {
                        screenWidth = (screenWidth * 9) / 16;
                    } else if (width <= height) {
                        if (width >= height) {
                            i2 = screenWidth;
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(screenWidth, i2);
                            layoutParams.gravity = 17;
                            textureView.setLayoutParams(layoutParams);
                            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(Helper.getScreenWidth(getView().getContext()), i2));
                            this.mMeasuredHeight = i2;
                            getView().requestLayout();
                        }
                    }
                }
                i2 = (int) (((float) screenWidth) / f2);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(screenWidth, i2);
                layoutParams2.gravity = 17;
                textureView.setLayoutParams(layoutParams2);
                frameLayout.setLayoutParams(new FrameLayout.LayoutParams(Helper.getScreenWidth(getView().getContext()), i2));
                this.mMeasuredHeight = i2;
                getView().requestLayout();
            }
            int i3 = screenWidth;
            screenWidth = (int) (((float) screenWidth) * f2);
            i2 = i3;
            FrameLayout.LayoutParams layoutParams22 = new FrameLayout.LayoutParams(screenWidth, i2);
            layoutParams22.gravity = 17;
            textureView.setLayoutParams(layoutParams22);
            frameLayout.setLayoutParams(new FrameLayout.LayoutParams(Helper.getScreenWidth(getView().getContext()), i2));
            this.mMeasuredHeight = i2;
            getView().requestLayout();
        }
    }

    public void setVideoSizeInfo(VideoSizeInfo videoSizeInfo) {
        this.mVideoSizeInfo = videoSizeInfo;
    }
}
