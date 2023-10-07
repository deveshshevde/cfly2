package com.shuyu.gsyvideoplayer.render.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import com.shuyu.gsyvideoplayer.utils.Debuger;
import com.shuyu.gsyvideoplayer.utils.FileUtils;
import com.shuyu.gsyvideoplayer.utils.MeasureHelper;
import java.io.File;
import jg.f;
import jg.g;
import jm.b;
import jm.c;

public class GSYVideoGLView extends GLSurfaceView implements a, MeasureHelper.MeasureFormVideoParamsListener, jm.a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f21673a = "com.shuyu.gsyvideoplayer.render.view.GSYVideoGLView";

    /* renamed from: b  reason: collision with root package name */
    private jl.a f21674b;

    /* renamed from: c  reason: collision with root package name */
    private Context f21675c;

    /* renamed from: d  reason: collision with root package name */
    private a f21676d = new jk.a();

    /* renamed from: e  reason: collision with root package name */
    private MeasureHelper.MeasureFormVideoParamsListener f21677e;

    /* renamed from: f  reason: collision with root package name */
    private MeasureHelper f21678f;

    /* renamed from: g  reason: collision with root package name */
    private jm.a f21679g;

    /* renamed from: h  reason: collision with root package name */
    private c f21680h;

    /* renamed from: i  reason: collision with root package name */
    private float[] f21681i;

    /* renamed from: j  reason: collision with root package name */
    private int f21682j = 0;

    public interface a {
        String a(GLSurfaceView gLSurfaceView);
    }

    public GSYVideoGLView(Context context) {
        super(context);
        a(context);
    }

    public GSYVideoGLView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public static GSYVideoGLView a(Context context, ViewGroup viewGroup, int i2, c cVar, MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener, a aVar, float[] fArr, jl.a aVar2, int i3) {
        float[] fArr2 = fArr;
        jl.a aVar3 = aVar2;
        if (viewGroup.getChildCount() > 0) {
            viewGroup.removeAllViews();
        }
        Context context2 = context;
        GSYVideoGLView gSYVideoGLView = new GSYVideoGLView(context);
        if (aVar3 != null) {
            gSYVideoGLView.setCustomRenderer(aVar3);
        }
        gSYVideoGLView.setEffect(aVar);
        MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener2 = measureFormVideoParamsListener;
        gSYVideoGLView.setVideoParamsListener(measureFormVideoParamsListener);
        final int i4 = i3;
        gSYVideoGLView.setRenderMode(i4);
        final c cVar2 = cVar;
        gSYVideoGLView.setIGSYSurfaceListener(cVar);
        final int i5 = i2;
        gSYVideoGLView.setRotation((float) i5);
        gSYVideoGLView.b();
        final Context context3 = context;
        final ViewGroup viewGroup2 = viewGroup;
        final MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener3 = measureFormVideoParamsListener;
        gSYVideoGLView.setGSYVideoGLRenderErrorListener(new b() {
            public void a(jl.a aVar, String str, int i2, boolean z2) {
                if (z2) {
                    GSYVideoGLView.a(context3, viewGroup2, i5, cVar2, measureFormVideoParamsListener3, aVar.d(), aVar.b(), aVar, i4);
                }
            }
        });
        if (fArr2 != null && fArr2.length == 16) {
            gSYVideoGLView.setMVPMatrix(fArr2);
        }
        ViewGroup viewGroup3 = viewGroup;
        jj.a.addToParent(viewGroup, gSYVideoGLView);
        return gSYVideoGLView;
    }

    private void a(Context context) {
        this.f21675c = context;
        setEGLContextClientVersion(2);
        this.f21674b = new jl.b();
        this.f21678f = new MeasureHelper(this, this);
        this.f21674b.a((GLSurfaceView) this);
    }

    /* access modifiers changed from: protected */
    public void a() {
        MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.f21677e;
        if (measureFormVideoParamsListener != null && this.f21682j == 1) {
            try {
                int currentVideoWidth = measureFormVideoParamsListener.getCurrentVideoWidth();
                int currentVideoHeight = this.f21677e.getCurrentVideoHeight();
                jl.a aVar = this.f21674b;
                if (aVar != null) {
                    aVar.a(this.f21678f.getMeasuredWidth());
                    this.f21674b.b(this.f21678f.getMeasuredHeight());
                    this.f21674b.c(currentVideoWidth);
                    this.f21674b.d(currentVideoHeight);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void a(Surface surface) {
        c cVar = this.f21680h;
        if (cVar != null) {
            cVar.onSurfaceAvailable(surface);
        }
    }

    public void a(f fVar, boolean z2) {
        this.f21674b.a(fVar, z2);
    }

    public void b() {
        setRenderer(this.f21674b);
    }

    public void c() {
        this.f21674b.c();
    }

    public void d() {
        jl.a aVar = this.f21674b;
        if (aVar != null) {
            aVar.a();
        }
    }

    public int getCurrentVideoHeight() {
        MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.f21677e;
        if (measureFormVideoParamsListener != null) {
            return measureFormVideoParamsListener.getCurrentVideoHeight();
        }
        return 0;
    }

    public int getCurrentVideoWidth() {
        MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.f21677e;
        if (measureFormVideoParamsListener != null) {
            return measureFormVideoParamsListener.getCurrentVideoWidth();
        }
        return 0;
    }

    public a getEffect() {
        return this.f21676d;
    }

    public c getIGSYSurfaceListener() {
        return this.f21680h;
    }

    public float[] getMVPMatrix() {
        return this.f21681i;
    }

    public int getMode() {
        return this.f21682j;
    }

    public Matrix getRenderTransform() {
        return null;
    }

    public View getRenderView() {
        return this;
    }

    public jl.a getRenderer() {
        return this.f21674b;
    }

    public int getSizeH() {
        return getHeight();
    }

    public int getSizeW() {
        return getWidth();
    }

    public int getVideoSarDen() {
        MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.f21677e;
        if (measureFormVideoParamsListener != null) {
            return measureFormVideoParamsListener.getVideoSarDen();
        }
        return 0;
    }

    public int getVideoSarNum() {
        MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener = this.f21677e;
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
        if (this.f21682j == 1) {
            super.onMeasure(i2, i3);
            this.f21678f.prepareMeasure(i2, i3, (int) getRotation());
            a();
            return;
        }
        this.f21678f.prepareMeasure(i2, i3, (int) getRotation());
        setMeasuredDimension(this.f21678f.getMeasuredWidth(), this.f21678f.getMeasuredHeight());
    }

    public void onRenderPause() {
        requestLayout();
        onPause();
    }

    public void onRenderResume() {
        requestLayout();
        onResume();
    }

    public void onResume() {
        super.onResume();
        jl.a aVar = this.f21674b;
        if (aVar != null) {
            aVar.e();
        }
    }

    public void releaseRenderAll() {
        requestLayout();
        d();
    }

    public void saveFrame(final File file, boolean z2, final g gVar) {
        a(new f() {
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
        }, z2);
        c();
    }

    public void setCustomRenderer(jl.a aVar) {
        this.f21674b = aVar;
        aVar.a((GLSurfaceView) this);
        a();
    }

    public void setEffect(a aVar) {
        if (aVar != null) {
            this.f21676d = aVar;
            this.f21674b.a(aVar);
        }
    }

    public void setGLEffectFilter(a aVar) {
        setEffect(aVar);
    }

    public void setGLMVPMatrix(float[] fArr) {
        setMVPMatrix(fArr);
    }

    public void setGLRenderer(jl.a aVar) {
        setCustomRenderer(aVar);
    }

    public void setGSYVideoGLRenderErrorListener(b bVar) {
        this.f21674b.a(bVar);
    }

    public void setIGSYSurfaceListener(c cVar) {
        setOnGSYSurfaceListener(this);
        this.f21680h = cVar;
    }

    public void setMVPMatrix(float[] fArr) {
        if (fArr != null) {
            this.f21681i = fArr;
            this.f21674b.a(fArr);
        }
    }

    public void setMode(int i2) {
        this.f21682j = i2;
    }

    public void setOnGSYSurfaceListener(jm.a aVar) {
        this.f21679g = aVar;
        this.f21674b.a(aVar);
    }

    public void setRenderMode(int i2) {
        setMode(i2);
    }

    public void setRenderTransform(Matrix matrix) {
        Debuger.printfLog(getClass().getSimpleName() + " not support setRenderTransform now");
    }

    public void setVideoParamsListener(MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener) {
        this.f21677e = measureFormVideoParamsListener;
    }

    public void taskShotPic(f fVar, boolean z2) {
        if (fVar != null) {
            a(fVar, z2);
            c();
        }
    }
}
