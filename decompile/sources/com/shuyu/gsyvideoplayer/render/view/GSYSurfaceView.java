package com.shuyu.gsyvideoplayer.render.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.shuyu.gsyvideoplayer.render.view.GSYVideoGLView;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import com.shuyu.gsyvideoplayer.utils.MeasureHelper;
import java.io.File;
import jg.f;
import jg.g;
import jj.a;
import jm.c;

public class GSYSurfaceView extends SurfaceView implements SurfaceHolder.Callback2, a, MeasureHelper.MeasureFormVideoParamsListener {

    /* renamed from: a  reason: collision with root package name */
    private c f21662a;

    /* renamed from: b  reason: collision with root package name */
    private MeasureHelper.MeasureFormVideoParamsListener f21663b;

    /* renamed from: c  reason: collision with root package name */
    private MeasureHelper f21664c;

    public GSYSurfaceView(Context context) {
        super(context);
        a();
    }

    public GSYSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public static GSYSurfaceView a(Context context, ViewGroup viewGroup, int i2, c cVar, MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener) {
        if (viewGroup.getChildCount() > 0) {
            viewGroup.removeAllViews();
        }
        GSYSurfaceView gSYSurfaceView = new GSYSurfaceView(context);
        gSYSurfaceView.setIGSYSurfaceListener(cVar);
        gSYSurfaceView.setVideoParamsListener(measureFormVideoParamsListener);
        gSYSurfaceView.setRotation((float) i2);
        a.addToParent(viewGroup, gSYSurfaceView);
        return gSYSurfaceView;
    }

    private void a() {
        this.f21664c = new MeasureHelper(this, this);
    }

    public int getCurrentVideoHeight() {
        MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.f21663b;
        if (measureFormVideoParamsListener != null) {
            return measureFormVideoParamsListener.getCurrentVideoHeight();
        }
        return 0;
    }

    public int getCurrentVideoWidth() {
        MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.f21663b;
        if (measureFormVideoParamsListener != null) {
            return measureFormVideoParamsListener.getCurrentVideoWidth();
        }
        return 0;
    }

    public c getIGSYSurfaceListener() {
        return this.f21662a;
    }

    public Matrix getRenderTransform() {
        return null;
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
        MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.f21663b;
        if (measureFormVideoParamsListener != null) {
            return measureFormVideoParamsListener.getVideoSarDen();
        }
        return 0;
    }

    public int getVideoSarNum() {
        MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.f21663b;
        if (measureFormVideoParamsListener != null) {
            return measureFormVideoParamsListener.getVideoSarNum();
        }
        return 0;
    }

    public Bitmap initCover() {
        Debuger.printfLog(getClass().getSimpleName() + " not support initCover now");
        return null;
    }

    public Bitmap initCoverHigh() {
        Debuger.printfLog(getClass().getSimpleName() + " not support initCoverHigh now");
        return null;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        this.f21664c.prepareMeasure(i2, i3, (int) getRotation());
        setMeasuredDimension(this.f21664c.getMeasuredWidth(), this.f21664c.getMeasuredHeight());
    }

    public void onRenderPause() {
        Debuger.printfLog(getClass().getSimpleName() + " not support onRenderPause now");
    }

    public void onRenderResume() {
        Debuger.printfLog(getClass().getSimpleName() + " not support onRenderResume now");
    }

    public void releaseRenderAll() {
        Debuger.printfLog(getClass().getSimpleName() + " not support releaseRenderAll now");
    }

    public void saveFrame(File file, boolean z2, g gVar) {
        Debuger.printfLog(getClass().getSimpleName() + " not support saveFrame now");
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
        getHolder().addCallback(this);
        this.f21662a = cVar;
    }

    public void setRenderMode(int i2) {
        Debuger.printfLog(getClass().getSimpleName() + " not support setRenderMode now");
    }

    public void setRenderTransform(Matrix matrix) {
        Debuger.printfLog(getClass().getSimpleName() + " not support setRenderTransform now");
    }

    public void setVideoParamsListener(MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener) {
        this.f21663b = measureFormVideoParamsListener;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        c cVar = this.f21662a;
        if (cVar != null) {
            cVar.onSurfaceSizeChanged(surfaceHolder.getSurface(), i3, i4);
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        c cVar = this.f21662a;
        if (cVar != null) {
            cVar.onSurfaceAvailable(surfaceHolder.getSurface());
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        c cVar = this.f21662a;
        if (cVar != null) {
            cVar.onSurfaceDestroyed(surfaceHolder.getSurface());
        }
    }

    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
    }

    public void taskShotPic(f fVar, boolean z2) {
        Debuger.printfLog(getClass().getSimpleName() + " not support taskShotPic now");
    }
}
