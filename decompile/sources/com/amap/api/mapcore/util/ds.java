package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps.model.CameraPosition;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

public final class ds extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    Bitmap f8285a;

    /* renamed from: b  reason: collision with root package name */
    Bitmap f8286b;

    /* renamed from: c  reason: collision with root package name */
    Bitmap f8287c;

    /* renamed from: d  reason: collision with root package name */
    ImageView f8288d;

    /* renamed from: e  reason: collision with root package name */
    IAMapDelegate f8289e;

    /* renamed from: f  reason: collision with root package name */
    Matrix f8290f = new Matrix();

    public ds(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f8289e = iAMapDelegate;
        try {
            Bitmap a2 = dl.a(context, "maps_dav_compass_needle_large.png");
            this.f8287c = a2;
            this.f8286b = dl.a(a2, l.f9554a * 0.8f);
            Bitmap a3 = dl.a(this.f8287c, l.f9554a * 0.7f);
            this.f8287c = a3;
            Bitmap bitmap = this.f8286b;
            if (bitmap == null) {
                return;
            }
            if (a3 != null) {
                this.f8285a = Bitmap.createBitmap(bitmap.getWidth(), this.f8286b.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.f8285a);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setFilterBitmap(true);
                canvas.drawBitmap(this.f8287c, ((float) (this.f8286b.getWidth() - this.f8287c.getWidth())) / 2.0f, ((float) (this.f8286b.getHeight() - this.f8287c.getHeight())) / 2.0f, paint);
                ImageView imageView = new ImageView(context);
                this.f8288d = imageView;
                imageView.setScaleType(ImageView.ScaleType.MATRIX);
                this.f8288d.setImageBitmap(this.f8285a);
                this.f8288d.setClickable(true);
                b();
                this.f8288d.setOnTouchListener(new View.OnTouchListener() {
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        try {
                            if (!ds.this.f8289e.isMaploaded()) {
                                return false;
                            }
                            if (motionEvent.getAction() == 0) {
                                ds.this.f8288d.setImageBitmap(ds.this.f8286b);
                            } else if (motionEvent.getAction() == 1) {
                                ds.this.f8288d.setImageBitmap(ds.this.f8285a);
                                CameraPosition cameraPosition = ds.this.f8289e.getCameraPosition();
                                ds.this.f8289e.animateCamera(z.a(new CameraPosition(cameraPosition.target, cameraPosition.zoom, 0.0f, 0.0f)));
                            }
                            return false;
                        } catch (Throwable th) {
                            fz.c(th, "CompassView", "onTouch");
                            th.printStackTrace();
                        }
                    }
                });
                addView(this.f8288d);
            }
        } catch (Throwable th) {
            fz.c(th, "CompassView", "create");
            th.printStackTrace();
        }
    }

    public final void a() {
        try {
            removeAllViews();
            Bitmap bitmap = this.f8285a;
            if (bitmap != null) {
                dl.a(bitmap);
            }
            Bitmap bitmap2 = this.f8286b;
            if (bitmap2 != null) {
                dl.a(bitmap2);
            }
            Bitmap bitmap3 = this.f8287c;
            if (bitmap3 != null) {
                dl.a(bitmap3);
            }
            Matrix matrix = this.f8290f;
            if (matrix != null) {
                matrix.reset();
                this.f8290f = null;
            }
            this.f8287c = null;
            this.f8285a = null;
            this.f8286b = null;
        } catch (Throwable th) {
            fz.c(th, "CompassView", "destroy");
            th.printStackTrace();
        }
    }

    public final void a(boolean z2) {
        if (z2) {
            setVisibility(0);
            b();
            return;
        }
        setVisibility(8);
    }

    public final void b() {
        try {
            IAMapDelegate iAMapDelegate = this.f8289e;
            if (iAMapDelegate != null && this.f8288d != null) {
                float cameraDegree = iAMapDelegate.getCameraDegree(1);
                float mapAngle = this.f8289e.getMapAngle(1);
                if (this.f8290f == null) {
                    this.f8290f = new Matrix();
                }
                this.f8290f.reset();
                this.f8290f.postRotate(-mapAngle, ((float) this.f8288d.getDrawable().getBounds().width()) / 2.0f, ((float) this.f8288d.getDrawable().getBounds().height()) / 2.0f);
                Matrix matrix = this.f8290f;
                double d2 = (double) cameraDegree;
                Double.isNaN(d2);
                matrix.postScale(1.0f, (float) Math.cos((d2 * 3.141592653589793d) / 180.0d), ((float) this.f8288d.getDrawable().getBounds().width()) / 2.0f, ((float) this.f8288d.getDrawable().getBounds().height()) / 2.0f);
                this.f8288d.setImageMatrix(this.f8290f);
            }
        } catch (Throwable th) {
            fz.c(th, "CompassView", "invalidateAngle");
            th.printStackTrace();
        }
    }
}
