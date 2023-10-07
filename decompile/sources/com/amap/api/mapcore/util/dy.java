package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoView;

public final class dy extends View {

    /* renamed from: a  reason: collision with root package name */
    private String f8367a = "";

    /* renamed from: b  reason: collision with root package name */
    private int f8368b = 0;

    /* renamed from: c  reason: collision with root package name */
    private IAMapDelegate f8369c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f8370d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f8371e;

    /* renamed from: f  reason: collision with root package name */
    private Rect f8372f;

    /* renamed from: g  reason: collision with root package name */
    private IPoint f8373g;

    /* renamed from: h  reason: collision with root package name */
    private float f8374h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    private final int[] f8375i = {10000000, 5000000, 2000000, 1000000, 500000, 200000, 100000, 50000, 30000, 20000, 10000, 5000, GSYVideoView.CHANGE_DELAY_TIME, 1000, 500, 200, 100, 50, 25, 10, 5};

    public dy(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f8369c = iAMapDelegate;
        this.f8370d = new Paint();
        this.f8372f = new Rect();
        this.f8370d.setAntiAlias(true);
        this.f8370d.setColor(-16777216);
        this.f8370d.setStrokeWidth(l.f9554a * 2.0f);
        this.f8370d.setStyle(Paint.Style.STROKE);
        Paint paint = new Paint();
        this.f8371e = paint;
        paint.setAntiAlias(true);
        this.f8371e.setColor(-16777216);
        this.f8371e.setTextSize(l.f9554a * 20.0f);
        this.f8374h = (float) df.b(context);
        this.f8373g = new IPoint();
    }

    private void a(int i2) {
        this.f8368b = i2;
    }

    private void a(String str) {
        this.f8367a = str;
    }

    public final void a() {
        this.f8370d = null;
        this.f8371e = null;
        this.f8372f = null;
        this.f8367a = null;
        this.f8373g = null;
    }

    public final void a(boolean z2) {
        if (z2) {
            setVisibility(0);
            b();
            return;
        }
        a("");
        a(0);
        setVisibility(8);
    }

    public final void b() {
        IAMapDelegate iAMapDelegate = this.f8369c;
        if (iAMapDelegate != null) {
            try {
                float preciseLevel = iAMapDelegate.getPreciseLevel(1);
                this.f8369c.getGeoCenter(1, this.f8373g);
                IPoint iPoint = this.f8373g;
                if (iPoint != null) {
                    DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong((long) iPoint.x, (long) this.f8373g.y, 20);
                    float mapZoomScale = this.f8369c.getMapZoomScale();
                    double cos = (double) ((float) ((((Math.cos((pixelsToLatLong.f10010y * 3.141592653589793d) / 180.0d) * 2.0d) * 3.141592653589793d) * 6378137.0d) / (Math.pow(2.0d, (double) preciseLevel) * 256.0d)));
                    int[] iArr = this.f8375i;
                    int i2 = (int) preciseLevel;
                    double d2 = (double) iArr[i2];
                    double d3 = (double) mapZoomScale;
                    Double.isNaN(cos);
                    Double.isNaN(d3);
                    Double.isNaN(d2);
                    int i3 = (int) (d2 / (cos * d3));
                    String a2 = dl.a(iArr[i2]);
                    a(i3);
                    a(a2);
                    pixelsToLatLong.recycle();
                    invalidate();
                }
            } catch (Throwable th) {
                fz.c(th, "AMapDelegateImpGLSurfaceView", "changeScaleState");
                th.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        Point waterMarkerPositon;
        String str = this.f8367a;
        if (str != null && !"".equals(str) && this.f8368b != 0 && (waterMarkerPositon = this.f8369c.getWaterMarkerPositon()) != null) {
            Paint paint = this.f8371e;
            String str2 = this.f8367a;
            paint.getTextBounds(str2, 0, str2.length(), this.f8372f);
            int i2 = waterMarkerPositon.x;
            int height = (waterMarkerPositon.y - this.f8372f.height()) + 5;
            canvas.drawText(this.f8367a, (float) (((this.f8368b - this.f8372f.width()) / 2) + i2), (float) height, this.f8371e);
            float f2 = (float) i2;
            float height2 = (float) (height + (this.f8372f.height() - 5));
            Canvas canvas2 = canvas;
            float f3 = f2;
            canvas2.drawLine(f3, height2 - (this.f8374h * 2.0f), f2, height2 + l.f9554a, this.f8370d);
            canvas2.drawLine(f3, height2, (float) (this.f8368b + i2), height2, this.f8370d);
            int i3 = this.f8368b;
            canvas2.drawLine((float) (i2 + i3), height2 - (this.f8374h * 2.0f), (float) (i2 + i3), height2 + l.f9554a, this.f8370d);
        }
    }
}
