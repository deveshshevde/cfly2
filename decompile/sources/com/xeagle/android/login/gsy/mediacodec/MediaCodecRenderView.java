package com.xeagle.android.login.gsy.mediacodec;

import android.content.Context;
import android.view.ViewGroup;
import com.shuyu.gsyvideoplayer.render.view.GSYVideoGLView;
import com.shuyu.gsyvideoplayer.utils.MeasureHelper;
import jj.a;
import jm.c;

public class MediaCodecRenderView extends a {
    public void addView(Context context, ViewGroup viewGroup, int i2, c cVar, MeasureHelper.MeasureFormVideoParamsListener measureFormVideoParamsListener, GSYVideoGLView.a aVar, float[] fArr, jl.a aVar2, int i3) {
        this.mShowView = MediaCodecTextureView.addTextureView(context, viewGroup, i2, cVar, measureFormVideoParamsListener);
    }
}
