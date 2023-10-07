package com.shuyu.gsyvideoplayer.video.base;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.shuyu.gsyvideoplayer.d;
import com.shuyu.gsyvideoplayer.e;
import com.shuyu.gsyvideoplayer.render.view.GSYVideoGLView;
import com.shuyu.gsyvideoplayer.utils.GSYVideoType;
import com.shuyu.gsyvideoplayer.utils.MeasureHelper;
import jk.a;
import jm.c;

public abstract class GSYTextureRenderView extends FrameLayout implements MeasureHelper.MeasureFormVideoParamsListener, c {
    protected GSYVideoGLView.a mEffectFilter = new a();
    protected Bitmap mFullPauseBitmap;
    private boolean mIsNormalScreen = true;
    protected float[] mMatrixGL = null;
    protected int mMode = 0;
    private Matrix mOriginalMatrix;
    protected jl.a mRenderer;
    protected int mRotate;
    /* access modifiers changed from: private */
    public Matrix mSaveMatrix;
    private int mScreenOrHeight;
    private int mScreenOrWidth;
    protected Surface mSurface;
    protected jj.a mTextureView;
    protected ViewGroup mTextureViewContainer;
    private float mVideoScale = 1.0f;

    public GSYTextureRenderView(Context context) {
        super(context);
    }

    public GSYTextureRenderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GSYTextureRenderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void addTextureView() {
        jj.a aVar = new jj.a();
        this.mTextureView = aVar;
        aVar.addView(getContext(), this.mTextureViewContainer, this.mRotate, this, this, this.mEffectFilter, this.mMatrixGL, this.mRenderer, this.mMode);
    }

    public boolean adjustVideoView(float f2) {
        float f3 = this.mVideoScale * f2;
        this.mVideoScale = f3;
        if (f3 == 1.0f) {
            return false;
        }
        final Matrix videoTransform = getVideoTransform();
        if (this.mScreenOrWidth == 0 || this.mScreenOrHeight == 0) {
            this.mScreenOrWidth = this.mTextureView.getWidth();
            this.mScreenOrHeight = this.mTextureView.getHeight();
        }
        if (!this.mIsNormalScreen) {
            float f4 = this.mVideoScale;
            videoTransform.preScale(f4, f4);
            float f5 = this.mVideoScale;
            videoTransform.postTranslate((((float) this.mScreenOrWidth) * (1.0f - f5)) / 2.0f, (((float) this.mScreenOrHeight) * (1.0f - f5)) / 2.0f);
            this.mTextureView.setTransform(videoTransform);
            this.mIsNormalScreen = true;
        } else {
            float[] fArr = new float[2];
            videoTransform.mapPoints(fArr);
            float f6 = this.mVideoScale;
            final float f7 = ((((float) this.mScreenOrWidth) * (1.0f - f6)) / 2.0f) - fArr[0];
            final float f8 = ((((float) this.mScreenOrHeight) * (1.0f - f6)) / 2.0f) - fArr[1];
            if (this.mSaveMatrix == null) {
                this.mSaveMatrix = new Matrix();
            }
            ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(300);
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    GSYTextureRenderView.this.mSaveMatrix.set(videoTransform);
                    GSYTextureRenderView.this.mSaveMatrix.postTranslate(f7 * floatValue, f8 * floatValue);
                    GSYTextureRenderView.this.mTextureView.setTransform(GSYTextureRenderView.this.mSaveMatrix);
                }
            });
            duration.start();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void changeTextureViewShowType() {
        if (this.mTextureView != null) {
            int textureParams = getTextureParams();
            ViewGroup.LayoutParams layoutParams = this.mTextureView.getLayoutParams();
            layoutParams.width = textureParams;
            layoutParams.height = textureParams;
            this.mTextureView.setLayoutParams(layoutParams);
        }
    }

    public GSYVideoGLView.a getEffectFilter() {
        return this.mEffectFilter;
    }

    public jj.a getRenderProxy() {
        return this.mTextureView;
    }

    /* access modifiers changed from: protected */
    public int getTextureParams() {
        return GSYVideoType.getShowType() != 0 ? -2 : -1;
    }

    public Matrix getVideoTransform() {
        if (this.mOriginalMatrix == null) {
            this.mOriginalMatrix = this.mTextureView.getTransform();
        }
        return this.mTextureView.getTransform();
    }

    public Surface getmSurface() {
        return this.mSurface;
    }

    /* access modifiers changed from: protected */
    public void initCover() {
        jj.a aVar = this.mTextureView;
        if (aVar != null) {
            this.mFullPauseBitmap = aVar.initCover();
        }
    }

    public void onSurfaceAvailable(Surface surface) {
        Log.i("Sochip", "onSurfaceAvailable: --------");
        jj.a aVar = this.mTextureView;
        pauseLogic(surface, aVar != null && (aVar.getShowView() instanceof TextureView));
        org.greenrobot.eventbus.c.a().d(new d(System.currentTimeMillis()));
    }

    public boolean onSurfaceDestroyed(Surface surface) {
        Log.i("Sochip", "onSurfaceDestroyed:---- ");
        org.greenrobot.eventbus.c.a().d(new e(true));
        return true;
    }

    public void onSurfaceSizeChanged(Surface surface, int i2, int i3) {
    }

    public void onSurfaceUpdated(Surface surface) {
        releasePauseCover();
    }

    /* access modifiers changed from: protected */
    public void pauseLogic(Surface surface, boolean z2) {
        this.mSurface = surface;
        if (z2) {
            showPauseCover();
        }
        setDisplay(this.mSurface);
    }

    public abstract void releasePauseCover();

    /* access modifiers changed from: protected */
    public abstract void releaseSurface(Surface surface);

    public void resetVideoView(boolean z2) {
        this.mIsNormalScreen = z2;
        if (z2) {
            this.mVideoScale = 1.0f;
        }
        this.mTextureView.setTransform(this.mOriginalMatrix);
    }

    public void setCustomGLRenderer(jl.a aVar) {
        this.mRenderer = aVar;
        jj.a aVar2 = this.mTextureView;
        if (aVar2 != null) {
            aVar2.setGLRenderer(aVar);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void setDisplay(Surface surface);

    public void setEffectFilter(GSYVideoGLView.a aVar) {
        this.mEffectFilter = aVar;
        jj.a aVar2 = this.mTextureView;
        if (aVar2 != null) {
            aVar2.setEffectFilter(aVar);
        }
    }

    public void setGLRenderMode(int i2) {
        this.mMode = i2;
        jj.a aVar = this.mTextureView;
        if (aVar != null) {
            aVar.setGLRenderMode(i2);
        }
    }

    public void setMatrixGL(float[] fArr) {
        this.mMatrixGL = fArr;
        jj.a aVar = this.mTextureView;
        if (aVar != null) {
            aVar.setMatrixGL(fArr);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void setSmallVideoTextureView();

    /* access modifiers changed from: protected */
    public void setSmallVideoTextureView(View.OnTouchListener onTouchListener) {
        this.mTextureViewContainer.setOnTouchListener(onTouchListener);
        this.mTextureViewContainer.setOnClickListener((View.OnClickListener) null);
        setSmallVideoTextureView();
    }

    public void setVideoTransform(Matrix matrix) {
        this.mTextureView.setTransform(matrix);
    }

    public void setmSurface(Surface surface) {
        this.mSurface = surface;
    }

    public abstract void showPauseCover();
}
