package com.shuyu.gsyvideoplayer.render.view;

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
import com.shuyu.gsyvideoplayer.utils.Debuger;
import com.shuyu.gsyvideoplayer.utils.FileUtils;
import com.shuyu.gsyvideoplayer.utils.GSYVideoType;
import com.shuyu.gsyvideoplayer.utils.MeasureHelper;
import java.io.File;
import jg.f;
import jg.g;
import jj.a;
import jm.c;

public class GSYTextureView extends TextureView implements TextureView.SurfaceTextureListener, a, MeasureHelper.MeasureFormVideoParamsListener {

    /* renamed from: a  reason: collision with root package name */
    private c f21665a;

    /* renamed from: b  reason: collision with root package name */
    private MeasureHelper.MeasureFormVideoParamsListener f21666b;

    /* renamed from: c  reason: collision with root package name */
    private MeasureHelper f21667c;

    /* renamed from: d  reason: collision with root package name */
    private SurfaceTexture f21668d;

    /* renamed from: e  reason: collision with root package name */
    private Surface f21669e;

    public GSYTextureView(Context context) {
        super(context);
        a();
    }

    public GSYTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public static GSYTextureView a(Context context, ViewGroup viewGroup, int i2, c cVar, MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener) {
        if (viewGroup.getChildCount() > 0) {
            viewGroup.removeAllViews();
        }
        GSYTextureView gSYTextureView = new GSYTextureView(context);
        gSYTextureView.setIGSYSurfaceListener(cVar);
        gSYTextureView.setVideoParamsListener(measureFormVideoParamsListener);
        gSYTextureView.setRotation((float) i2);
        a.addToParent(viewGroup, gSYTextureView);
        return gSYTextureView;
    }

    private void a() {
        this.f21667c = new MeasureHelper(this, this);
    }

    public int getCurrentVideoHeight() {
        MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.f21666b;
        if (measureFormVideoParamsListener != null) {
            return measureFormVideoParamsListener.getCurrentVideoHeight();
        }
        return 0;
    }

    public int getCurrentVideoWidth() {
        MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.f21666b;
        if (measureFormVideoParamsListener != null) {
            return measureFormVideoParamsListener.getCurrentVideoWidth();
        }
        return 0;
    }

    public c getIGSYSurfaceListener() {
        return this.f21665a;
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
        MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.f21666b;
        if (measureFormVideoParamsListener != null) {
            return measureFormVideoParamsListener.getVideoSarDen();
        }
        return 0;
    }

    public int getVideoSarNum() {
        MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.f21666b;
        if (measureFormVideoParamsListener != null) {
            return measureFormVideoParamsListener.getVideoSarNum();
        }
        return 0;
    }

    public Bitmap initCover() {
        if (getSizeH() <= 0 || getSizeW() <= 0) {
            return null;
        }
        return getBitmap(Bitmap.createBitmap(getSizeW(), getSizeH(), Bitmap.Config.RGB_565));
    }

    public Bitmap initCoverHigh() {
        return getBitmap(Bitmap.createBitmap(getSizeW(), getSizeH(), Bitmap.Config.ARGB_8888));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        this.f21667c.prepareMeasure(i2, i3, (int) getRotation());
        setMeasuredDimension(this.f21667c.getMeasuredWidth(), this.f21667c.getMeasuredHeight());
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
        if (GSYVideoType.isMediaCodecTexture()) {
            SurfaceTexture surfaceTexture2 = this.f21668d;
            if (surfaceTexture2 == null) {
                this.f21668d = surfaceTexture;
                this.f21669e = new Surface(surfaceTexture);
            } else {
                setSurfaceTexture(surfaceTexture2);
            }
            cVar = this.f21665a;
            if (cVar != null) {
                surface = this.f21669e;
            } else {
                return;
            }
        } else {
            surface = new Surface(surfaceTexture);
            this.f21669e = surface;
            cVar = this.f21665a;
            if (cVar == null) {
                return;
            }
        }
        cVar.onSurfaceAvailable(surface);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        c cVar = this.f21665a;
        if (cVar != null) {
            cVar.onSurfaceDestroyed(this.f21669e);
        }
        return !GSYVideoType.isMediaCodecTexture() || this.f21668d == null;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        c cVar = this.f21665a;
        if (cVar != null) {
            cVar.onSurfaceSizeChanged(this.f21669e, i2, i3);
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        c cVar = this.f21665a;
        if (cVar != null) {
            cVar.onSurfaceUpdated(this.f21669e);
        }
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
        this.f21665a = cVar;
    }

    public void setRenderMode(int i2) {
        Debuger.printfLog(getClass().getSimpleName() + " not support setRenderMode now");
    }

    public void setRenderTransform(Matrix matrix) {
        setTransform(matrix);
    }

    public void setVideoParamsListener(MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener) {
        this.f21666b = measureFormVideoParamsListener;
    }

    public void taskShotPic(f fVar, boolean z2) {
        fVar.getBitmap(z2 ? initCoverHigh() : initCover());
    }
}
