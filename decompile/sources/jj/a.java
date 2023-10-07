package jj;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.shuyu.gsyvideoplayer.render.view.GSYSurfaceView;
import com.shuyu.gsyvideoplayer.render.view.GSYTextureView;
import com.shuyu.gsyvideoplayer.render.view.GSYVideoGLView;
import com.shuyu.gsyvideoplayer.utils.GSYVideoType;
import com.shuyu.gsyvideoplayer.utils.MeasureHelper;
import java.io.File;
import jg.f;
import jg.g;
import jm.c;

public class a {
    protected com.shuyu.gsyvideoplayer.render.view.a mShowView;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: android.widget.FrameLayout$LayoutParams} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: android.widget.RelativeLayout$LayoutParams} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: android.widget.FrameLayout$LayoutParams} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: android.widget.FrameLayout$LayoutParams} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void addToParent(android.view.ViewGroup r2, android.view.View r3) {
        /*
            int r0 = getTextureParams()
            boolean r1 = r2 instanceof android.widget.RelativeLayout
            if (r1 == 0) goto L_0x0016
            android.widget.RelativeLayout$LayoutParams r1 = new android.widget.RelativeLayout$LayoutParams
            r1.<init>(r0, r0)
            r0 = 13
            r1.addRule(r0)
        L_0x0012:
            r2.addView(r3, r1)
            goto L_0x0024
        L_0x0016:
            boolean r1 = r2 instanceof android.widget.FrameLayout
            if (r1 == 0) goto L_0x0024
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams
            r1.<init>(r0, r0)
            r0 = 17
            r1.gravity = r0
            goto L_0x0012
        L_0x0024:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jj.a.addToParent(android.view.ViewGroup, android.view.View):void");
    }

    public static int getTextureParams() {
        return GSYVideoType.getShowType() != 0 ? -2 : -1;
    }

    public void addView(Context context, ViewGroup viewGroup, int i2, c cVar, MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener, GSYVideoGLView.a aVar, float[] fArr, jl.a aVar2, int i3) {
        Log.i("rtsp", "addView: ----render type----" + GSYVideoType.getRenderType());
        this.mShowView = GSYVideoType.getRenderType() == 1 ? GSYSurfaceView.a(context, viewGroup, i2, cVar, measureFormVideoParamsListener) : GSYVideoType.getRenderType() == 2 ? GSYVideoGLView.a(context, viewGroup, i2, cVar, measureFormVideoParamsListener, aVar, fArr, aVar2, i3) : GSYTextureView.a(context, viewGroup, i2, cVar, measureFormVideoParamsListener);
    }

    public int getHeight() {
        com.shuyu.gsyvideoplayer.render.view.a aVar = this.mShowView;
        if (aVar != null) {
            return aVar.getRenderView().getHeight();
        }
        return 0;
    }

    public ViewGroup.LayoutParams getLayoutParams() {
        return this.mShowView.getRenderView().getLayoutParams();
    }

    public float getRotation() {
        return this.mShowView.getRenderView().getRotation();
    }

    public View getShowView() {
        com.shuyu.gsyvideoplayer.render.view.a aVar = this.mShowView;
        if (aVar != null) {
            return aVar.getRenderView();
        }
        return null;
    }

    public Matrix getTransform() {
        com.shuyu.gsyvideoplayer.render.view.a aVar = this.mShowView;
        if (aVar != null) {
            return aVar.getRenderTransform();
        }
        return null;
    }

    public int getWidth() {
        com.shuyu.gsyvideoplayer.render.view.a aVar = this.mShowView;
        if (aVar != null) {
            return aVar.getRenderView().getWidth();
        }
        return 0;
    }

    public Bitmap initCover() {
        com.shuyu.gsyvideoplayer.render.view.a aVar = this.mShowView;
        if (aVar != null) {
            return aVar.initCover();
        }
        return null;
    }

    public Bitmap initCoverHigh() {
        com.shuyu.gsyvideoplayer.render.view.a aVar = this.mShowView;
        if (aVar != null) {
            return aVar.initCoverHigh();
        }
        return null;
    }

    public void invalidate() {
        com.shuyu.gsyvideoplayer.render.view.a aVar = this.mShowView;
        if (aVar != null) {
            aVar.getRenderView().invalidate();
        }
    }

    public void onPause() {
        com.shuyu.gsyvideoplayer.render.view.a aVar = this.mShowView;
        if (aVar != null) {
            aVar.onRenderPause();
        }
    }

    public void onResume() {
        com.shuyu.gsyvideoplayer.render.view.a aVar = this.mShowView;
        if (aVar != null) {
            aVar.onRenderResume();
        }
    }

    public void releaseAll() {
        com.shuyu.gsyvideoplayer.render.view.a aVar = this.mShowView;
        if (aVar != null) {
            aVar.releaseRenderAll();
        }
    }

    public void requestLayout() {
        com.shuyu.gsyvideoplayer.render.view.a aVar = this.mShowView;
        if (aVar != null) {
            aVar.getRenderView().requestLayout();
        }
    }

    public void saveFrame(File file, g gVar) {
        saveFrame(file, false, gVar);
    }

    public void saveFrame(File file, boolean z2, g gVar) {
        com.shuyu.gsyvideoplayer.render.view.a aVar = this.mShowView;
        if (aVar != null) {
            aVar.saveFrame(file, z2, gVar);
        }
    }

    public void setEffectFilter(GSYVideoGLView.a aVar) {
        com.shuyu.gsyvideoplayer.render.view.a aVar2 = this.mShowView;
        if (aVar2 != null) {
            aVar2.setGLEffectFilter(aVar);
        }
    }

    public void setGLRenderMode(int i2) {
        com.shuyu.gsyvideoplayer.render.view.a aVar = this.mShowView;
        if (aVar != null) {
            aVar.setRenderMode(i2);
        }
    }

    public void setGLRenderer(jl.a aVar) {
        com.shuyu.gsyvideoplayer.render.view.a aVar2 = this.mShowView;
        if (aVar2 != null) {
            aVar2.setGLRenderer(aVar);
        }
    }

    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        com.shuyu.gsyvideoplayer.render.view.a aVar = this.mShowView;
        if (aVar != null) {
            aVar.getRenderView().setLayoutParams(layoutParams);
        }
    }

    public void setMatrixGL(float[] fArr) {
        com.shuyu.gsyvideoplayer.render.view.a aVar = this.mShowView;
        if (aVar != null) {
            aVar.setGLMVPMatrix(fArr);
        }
    }

    public void setRotation(float f2) {
        com.shuyu.gsyvideoplayer.render.view.a aVar = this.mShowView;
        if (aVar != null) {
            aVar.getRenderView().setRotation(f2);
        }
    }

    public void setTransform(Matrix matrix) {
        com.shuyu.gsyvideoplayer.render.view.a aVar = this.mShowView;
        if (aVar != null) {
            aVar.setRenderTransform(matrix);
        }
    }

    public void taskShotPic(f fVar) {
        taskShotPic(fVar, false);
    }

    public void taskShotPic(f fVar, boolean z2) {
        com.shuyu.gsyvideoplayer.render.view.a aVar = this.mShowView;
        if (aVar != null) {
            aVar.taskShotPic(fVar, z2);
        }
    }
}
