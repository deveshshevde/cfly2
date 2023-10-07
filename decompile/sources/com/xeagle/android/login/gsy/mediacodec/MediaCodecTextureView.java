package com.xeagle.android.login.gsy.mediacodec;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.shuyu.gsyvideoplayer.render.view.GSYVideoGLView;
import com.shuyu.gsyvideoplayer.render.view.a;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import com.shuyu.gsyvideoplayer.utils.FileUtils;
import com.shuyu.gsyvideoplayer.utils.MeasureHelper;
import java.io.File;
import jg.f;
import jg.g;
import jm.c;

public class MediaCodecTextureView extends TextureView implements TextureView.SurfaceTextureListener, a, MeasureHelper.MeasureFormVideoParamsListener {
    private c mIGSYSurfaceListener;
    private SurfaceTexture mSaveTexture;
    private Surface mSurface;
    private MeasureHelper.MeasureFormVideoParamsListener mVideoParamsListener;
    private MeasureHelper measureHelper;

    public MediaCodecTextureView(Context context) {
        super(context);
        init();
    }

    public MediaCodecTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public static MediaCodecTextureView addTextureView(Context context, ViewGroup viewGroup, int i2, c cVar, MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener) {
        if (viewGroup.getChildCount() > 0) {
            viewGroup.removeAllViews();
        }
        MediaCodecTextureView mediaCodecTextureView = new MediaCodecTextureView(context);
        mediaCodecTextureView.setIGSYSurfaceListener(cVar);
        mediaCodecTextureView.setVideoParamsListener(measureFormVideoParamsListener);
        mediaCodecTextureView.setRotation((float) i2);
        jj.a.addToParent(viewGroup, mediaCodecTextureView);
        return mediaCodecTextureView;
    }

    private void init() {
        this.measureHelper = new MeasureHelper(this, this);
    }

    public int getCurrentVideoHeight() {
        MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.mVideoParamsListener;
        if (measureFormVideoParamsListener != null) {
            return measureFormVideoParamsListener.getCurrentVideoHeight();
        }
        return 0;
    }

    public int getCurrentVideoWidth() {
        MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.mVideoParamsListener;
        if (measureFormVideoParamsListener != null) {
            return measureFormVideoParamsListener.getCurrentVideoWidth();
        }
        return 0;
    }

    public c getIGSYSurfaceListener() {
        return this.mIGSYSurfaceListener;
    }

    public Matrix getRenderTransform() {
        return getTransform((Matrix) null);
    }

    public View getRenderView() {
        return this;
    }

    public int getSizeH() {
        return getHeight();
    }

    public int getSizeW() {
        return getWidth();
    }

    public int getVideoSarDen() {
        MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.mVideoParamsListener;
        if (measureFormVideoParamsListener != null) {
            return measureFormVideoParamsListener.getVideoSarDen();
        }
        return 0;
    }

    public int getVideoSarNum() {
        MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.mVideoParamsListener;
        if (measureFormVideoParamsListener != null) {
            return measureFormVideoParamsListener.getVideoSarNum();
        }
        return 0;
    }

    public Bitmap initCover() {
        return getBitmap(Bitmap.createBitmap(getSizeW(), getSizeH(), Bitmap.Config.RGB_565));
    }

    public Bitmap initCoverHigh() {
        return getBitmap(Bitmap.createBitmap(getSizeW(), getSizeH(), Bitmap.Config.ARGB_8888));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        this.measureHelper.prepareMeasure(i2, i3, (int) getRotation());
        setMeasuredDimension(this.measureHelper.getMeasuredWidth(), this.measureHelper.getMeasuredHeight());
    }

    public void onRenderPause() {
        Debuger.printfLog(getClass().getSimpleName() + " not support onRenderPause now");
    }

    public void onRenderResume() {
        Debuger.printfLog(getClass().getSimpleName() + " not support onRenderResume now");
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        Surface surface;
        c cVar;
        SurfaceTexture surfaceTexture2 = this.mSaveTexture;
        if (surfaceTexture2 == null) {
            this.mSaveTexture = surfaceTexture;
            surface = new Surface(surfaceTexture);
            this.mSurface = surface;
            cVar = this.mIGSYSurfaceListener;
            if (cVar == null) {
                return;
            }
        } else {
            setSurfaceTexture(surfaceTexture2);
            cVar = this.mIGSYSurfaceListener;
            if (cVar != null) {
                surface = this.mSurface;
            } else {
                return;
            }
        }
        cVar.onSurfaceAvailable(surface);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        c cVar = this.mIGSYSurfaceListener;
        if (cVar != null) {
            cVar.onSurfaceDestroyed(this.mSurface);
        }
        return this.mSaveTexture == null;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        c cVar = this.mIGSYSurfaceListener;
        if (cVar != null) {
            cVar.onSurfaceSizeChanged(this.mSurface, i2, i3);
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        c cVar = this.mIGSYSurfaceListener;
        if (cVar != null) {
            cVar.onSurfaceUpdated(this.mSurface);
        }
    }

    public void release() {
        this.mSaveTexture = null;
    }

    public void releaseRenderAll() {
        Debuger.printfLog(getClass().getSimpleName() + " not support releaseRenderAll now");
    }

    public void saveFrame(final File file, boolean z2, final g gVar) {
        new f() {
            public void getBitmap(Bitmap bitmap) {
                g gVar;
                boolean z2;
                if (bitmap == null) {
                    gVar = gVar;
                    z2 = false;
                } else {
                    FileUtils.saveBitmap(bitmap, file);
                    gVar = gVar;
                    z2 = true;
                }
                gVar.result(z2, file);
            }
        }.getBitmap(z2 ? initCoverHigh() : initCover());
    }

    public void setGLEffectFilter(GSYVideoGLView.a aVar) {
        Debuger.printfLog(getClass().getSimpleName() + " not support setGLEffectFilter now");
    }

    public void setGLMVPMatrix(float[] fArr) {
        Debuger.printfLog(getClass().getSimpleName() + " not support setGLMVPMatrix now");
    }

    public void setGLRenderer(jl.a aVar) {
        Debuger.printfLog(getClass().getSimpleName() + " not support setGLRenderer now");
    }

    public void setIGSYSurfaceListener(c cVar) {
        setSurfaceTextureListener(this);
        this.mIGSYSurfaceListener = cVar;
    }

    public void setRenderMode(int i2) {
        Debuger.printfLog(getClass().getSimpleName() + " not support setRenderMode now");
    }

    public void setRenderTransform(Matrix matrix) {
        setTransform(matrix);
    }

    public void setVideoParamsListener(MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener) {
        this.mVideoParamsListener = measureFormVideoParamsListener;
    }

    public void taskShotPic(f fVar, boolean z2) {
        fVar.getBitmap(z2 ? initCoverHigh() : initCover());
    }
}
