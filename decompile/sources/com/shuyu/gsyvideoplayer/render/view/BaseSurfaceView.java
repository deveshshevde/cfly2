package com.shuyu.gsyvideoplayer.render.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public abstract class BaseSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: a  reason: collision with root package name */
    SurfaceHolder f21661a;

    public BaseSurfaceView(Context context) {
        super(context);
        SurfaceHolder holder = getHolder();
        this.f21661a = holder;
        holder.addCallback(this);
    }

    public BaseSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseSurfaceView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public abstract void a(Canvas canvas);

    public Bitmap getBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        a(new Canvas(createBitmap));
        return createBitmap;
    }
}
