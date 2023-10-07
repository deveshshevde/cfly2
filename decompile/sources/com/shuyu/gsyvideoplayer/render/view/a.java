package com.shuyu.gsyvideoplayer.render.view;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.View;
import com.shuyu.gsyvideoplayer.render.view.GSYVideoGLView;
import java.io.File;
import jg.f;
import jg.g;

public interface a {
    Matrix getRenderTransform();

    View getRenderView();

    Bitmap initCover();

    Bitmap initCoverHigh();

    void onRenderPause();

    void onRenderResume();

    void releaseRenderAll();

    void saveFrame(File file, boolean z2, g gVar);

    void setGLEffectFilter(GSYVideoGLView.a aVar);

    void setGLMVPMatrix(float[] fArr);

    void setGLRenderer(jl.a aVar);

    void setRenderMode(int i2);

    void setRenderTransform(Matrix matrix);

    void taskShotPic(f fVar, boolean z2);
}
