package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps.model.LatLng;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

public final class du extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    Bitmap f8320a;

    /* renamed from: b  reason: collision with root package name */
    Bitmap f8321b;

    /* renamed from: c  reason: collision with root package name */
    Bitmap f8322c;

    /* renamed from: d  reason: collision with root package name */
    Bitmap f8323d;

    /* renamed from: e  reason: collision with root package name */
    Bitmap f8324e;

    /* renamed from: f  reason: collision with root package name */
    Bitmap f8325f;

    /* renamed from: g  reason: collision with root package name */
    ImageView f8326g;

    /* renamed from: h  reason: collision with root package name */
    IAMapDelegate f8327h;

    /* renamed from: i  reason: collision with root package name */
    boolean f8328i = false;

    public du(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f8327h = iAMapDelegate;
        try {
            Bitmap a2 = dl.a(context, "location_selected.png");
            this.f8323d = a2;
            this.f8320a = dl.a(a2, l.f9554a);
            Bitmap a3 = dl.a(context, "location_pressed.png");
            this.f8324e = a3;
            this.f8321b = dl.a(a3, l.f9554a);
            Bitmap a4 = dl.a(context, "location_unselected.png");
            this.f8325f = a4;
            this.f8322c = dl.a(a4, l.f9554a);
            ImageView imageView = new ImageView(context);
            this.f8326g = imageView;
            imageView.setImageBitmap(this.f8320a);
            this.f8326g.setClickable(true);
            this.f8326g.setPadding(0, 20, 20, 0);
            this.f8326g.setOnTouchListener(new View.OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (!du.this.f8328i) {
                        return false;
                    }
                    if (motionEvent.getAction() == 0) {
                        du.this.f8326g.setImageBitmap(du.this.f8321b);
                    } else if (motionEvent.getAction() == 1) {
                        try {
                            du.this.f8326g.setImageBitmap(du.this.f8320a);
                            du.this.f8327h.setMyLocationEnabled(true);
                            Location myLocation = du.this.f8327h.getMyLocation();
                            if (myLocation == null) {
                                return false;
                            }
                            LatLng latLng = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
                            du.this.f8327h.showMyLocationOverlay(myLocation);
                            du.this.f8327h.moveCamera(z.a(latLng, du.this.f8327h.getZoomLevel()));
                        } catch (Throwable th) {
                            fz.c(th, "LocationView", "onTouch");
                            th.printStackTrace();
                        }
                    }
                    return false;
                }
            });
            addView(this.f8326g);
        } catch (Throwable th) {
            fz.c(th, "LocationView", "create");
            th.printStackTrace();
        }
    }

    public final void a() {
        try {
            removeAllViews();
            Bitmap bitmap = this.f8320a;
            if (bitmap != null) {
                dl.a(bitmap);
            }
            Bitmap bitmap2 = this.f8321b;
            if (bitmap2 != null) {
                dl.a(bitmap2);
            }
            if (this.f8321b != null) {
                dl.a(this.f8322c);
            }
            this.f8320a = null;
            this.f8321b = null;
            this.f8322c = null;
            Bitmap bitmap3 = this.f8323d;
            if (bitmap3 != null) {
                dl.a(bitmap3);
                this.f8323d = null;
            }
            Bitmap bitmap4 = this.f8324e;
            if (bitmap4 != null) {
                dl.a(bitmap4);
                this.f8324e = null;
            }
            Bitmap bitmap5 = this.f8325f;
            if (bitmap5 != null) {
                dl.a(bitmap5);
                this.f8325f = null;
            }
        } catch (Throwable th) {
            fz.c(th, "LocationView", "destroy");
            th.printStackTrace();
        }
    }

    public final void a(boolean z2) {
        ImageView imageView;
        Bitmap bitmap;
        this.f8328i = z2;
        if (z2) {
            try {
                imageView = this.f8326g;
                bitmap = this.f8320a;
            } catch (Throwable th) {
                fz.c(th, "LocationView", "showSelect");
                th.printStackTrace();
                return;
            }
        } else {
            imageView = this.f8326g;
            bitmap = this.f8322c;
        }
        imageView.setImageBitmap(bitmap);
        this.f8326g.invalidate();
    }
}
