package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.mapcore.util.dv;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

final class ea extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Bitmap f8406a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f8407b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Bitmap f8408c;

    /* renamed from: d  reason: collision with root package name */
    private Bitmap f8409d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Bitmap f8410e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Bitmap f8411f;

    /* renamed from: g  reason: collision with root package name */
    private Bitmap f8412g;

    /* renamed from: h  reason: collision with root package name */
    private Bitmap f8413h;

    /* renamed from: i  reason: collision with root package name */
    private Bitmap f8414i;

    /* renamed from: j  reason: collision with root package name */
    private Bitmap f8415j;

    /* renamed from: k  reason: collision with root package name */
    private Bitmap f8416k;

    /* renamed from: l  reason: collision with root package name */
    private Bitmap f8417l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public ImageView f8418m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public ImageView f8419n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public IAMapDelegate f8420o;

    public ea(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f8420o = iAMapDelegate;
        try {
            Bitmap a2 = dl.a(context, "zoomin_selected.png");
            this.f8412g = a2;
            this.f8406a = dl.a(a2, l.f9554a);
            Bitmap a3 = dl.a(context, "zoomin_unselected.png");
            this.f8413h = a3;
            this.f8407b = dl.a(a3, l.f9554a);
            Bitmap a4 = dl.a(context, "zoomout_selected.png");
            this.f8414i = a4;
            this.f8408c = dl.a(a4, l.f9554a);
            Bitmap a5 = dl.a(context, "zoomout_unselected.png");
            this.f8415j = a5;
            this.f8409d = dl.a(a5, l.f9554a);
            Bitmap a6 = dl.a(context, "zoomin_pressed.png");
            this.f8416k = a6;
            this.f8410e = dl.a(a6, l.f9554a);
            Bitmap a7 = dl.a(context, "zoomout_pressed.png");
            this.f8417l = a7;
            this.f8411f = dl.a(a7, l.f9554a);
            ImageView imageView = new ImageView(context);
            this.f8418m = imageView;
            imageView.setImageBitmap(this.f8406a);
            this.f8418m.setClickable(true);
            ImageView imageView2 = new ImageView(context);
            this.f8419n = imageView2;
            imageView2.setImageBitmap(this.f8408c);
            this.f8419n.setClickable(true);
            this.f8418m.setOnTouchListener(new View.OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    try {
                        if (ea.this.f8420o.getZoomLevel() < ea.this.f8420o.getMaxZoomLevel()) {
                            if (ea.this.f8420o.isMaploaded()) {
                                if (motionEvent.getAction() == 0) {
                                    ea.this.f8418m.setImageBitmap(ea.this.f8410e);
                                } else if (motionEvent.getAction() == 1) {
                                    ea.this.f8418m.setImageBitmap(ea.this.f8406a);
                                    ea.this.f8420o.animateCamera(z.a());
                                }
                                return false;
                            }
                        }
                        return false;
                    } catch (RemoteException e2) {
                        fz.c(e2, "ZoomControllerView", "zoomin ontouch");
                        e2.printStackTrace();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
            this.f8419n.setOnTouchListener(new View.OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    try {
                        if (ea.this.f8420o.getZoomLevel() > ea.this.f8420o.getMinZoomLevel()) {
                            if (ea.this.f8420o.isMaploaded()) {
                                if (motionEvent.getAction() == 0) {
                                    ea.this.f8419n.setImageBitmap(ea.this.f8411f);
                                } else if (motionEvent.getAction() == 1) {
                                    ea.this.f8419n.setImageBitmap(ea.this.f8408c);
                                    ea.this.f8420o.animateCamera(z.b());
                                }
                                return false;
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        fz.c(th, "ZoomControllerView", "zoomout ontouch");
                        th.printStackTrace();
                    }
                }
            });
            this.f8418m.setPadding(0, 0, 20, -2);
            this.f8419n.setPadding(0, 0, 20, 20);
            setOrientation(1);
            addView(this.f8418m);
            addView(this.f8419n);
        } catch (Throwable th) {
            fz.c(th, "ZoomControllerView", "create");
            th.printStackTrace();
        }
    }

    public final void a() {
        try {
            removeAllViews();
            dl.a(this.f8406a);
            dl.a(this.f8407b);
            dl.a(this.f8408c);
            dl.a(this.f8409d);
            dl.a(this.f8410e);
            dl.a(this.f8411f);
            this.f8406a = null;
            this.f8407b = null;
            this.f8408c = null;
            this.f8409d = null;
            this.f8410e = null;
            this.f8411f = null;
            Bitmap bitmap = this.f8412g;
            if (bitmap != null) {
                dl.a(bitmap);
                this.f8412g = null;
            }
            Bitmap bitmap2 = this.f8413h;
            if (bitmap2 != null) {
                dl.a(bitmap2);
                this.f8413h = null;
            }
            Bitmap bitmap3 = this.f8414i;
            if (bitmap3 != null) {
                dl.a(bitmap3);
                this.f8414i = null;
            }
            Bitmap bitmap4 = this.f8415j;
            if (bitmap4 != null) {
                dl.a(bitmap4);
                this.f8412g = null;
            }
            Bitmap bitmap5 = this.f8416k;
            if (bitmap5 != null) {
                dl.a(bitmap5);
                this.f8416k = null;
            }
            Bitmap bitmap6 = this.f8417l;
            if (bitmap6 != null) {
                dl.a(bitmap6);
                this.f8417l = null;
            }
            this.f8418m = null;
            this.f8419n = null;
        } catch (Throwable th) {
            fz.c(th, "ZoomControllerView", "destory");
            th.printStackTrace();
        }
    }

    public final void a(float f2) {
        try {
            if (f2 < this.f8420o.getMaxZoomLevel() && f2 > this.f8420o.getMinZoomLevel()) {
                this.f8418m.setImageBitmap(this.f8406a);
                this.f8419n.setImageBitmap(this.f8408c);
            } else if (f2 == this.f8420o.getMinZoomLevel()) {
                this.f8419n.setImageBitmap(this.f8409d);
                this.f8418m.setImageBitmap(this.f8406a);
            } else if (f2 == this.f8420o.getMaxZoomLevel()) {
                this.f8418m.setImageBitmap(this.f8407b);
                this.f8419n.setImageBitmap(this.f8408c);
            }
        } catch (Throwable th) {
            fz.c(th, "ZoomControllerView", "setZoomBitmap");
            th.printStackTrace();
        }
    }

    public final void a(int i2) {
        try {
            dv.a aVar = (dv.a) getLayoutParams();
            if (i2 == 1) {
                aVar.f8360e = 16;
            } else if (i2 == 2) {
                aVar.f8360e = 80;
            }
            setLayoutParams(aVar);
        } catch (Throwable th) {
            fz.c(th, "ZoomControllerView", "setZoomPosition");
            th.printStackTrace();
        }
    }

    public final void a(boolean z2) {
        setVisibility(z2 ? 0 : 8);
    }
}
