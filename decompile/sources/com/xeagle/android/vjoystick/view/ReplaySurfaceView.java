package com.xeagle.android.vjoystick.view;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.io.InputStream;

public class ReplaySurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: d  reason: collision with root package name */
    private static int f25413d;

    /* renamed from: e  reason: collision with root package name */
    private static int f25414e;

    /* renamed from: a  reason: collision with root package name */
    InputStream f25415a = null;

    /* renamed from: b  reason: collision with root package name */
    private SurfaceHolder f25416b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f25417c;

    /* renamed from: f  reason: collision with root package name */
    private boolean f25418f = false;

    /* renamed from: g  reason: collision with root package name */
    private Rect f25419g;

    public ReplaySurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
        Paint paint = new Paint();
        this.f25417c = paint;
        paint.setAntiAlias(true);
        SurfaceHolder holder = getHolder();
        this.f25416b = holder;
        holder.addCallback(this);
        setKeepScreenOn(true);
        setFocusable(true);
    }

    private void b() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        f25413d = displayMetrics.widthPixels;
        f25414e = displayMetrics.heightPixels;
        this.f25419g = new Rect(0, 0, f25413d, f25414e);
        setKeepScreenOn(true);
    }

    public void a() {
        this.f25418f = true;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f25418f = true;
    }
}
