package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.View;
import java.io.File;

public final class dz extends View {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f8376a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f8377b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Bitmap f8378c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Bitmap f8379d;

    /* renamed from: e  reason: collision with root package name */
    private Bitmap f8380e;

    /* renamed from: f  reason: collision with root package name */
    private Bitmap f8381f;

    /* renamed from: g  reason: collision with root package name */
    private Bitmap f8382g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f8383h = new Paint();

    /* renamed from: i  reason: collision with root package name */
    private boolean f8384i = false;

    /* renamed from: j  reason: collision with root package name */
    private int f8385j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f8386k = 0;

    /* renamed from: l  reason: collision with root package name */
    private int f8387l = 0;

    /* renamed from: m  reason: collision with root package name */
    private int f8388m = 10;

    /* renamed from: n  reason: collision with root package name */
    private int f8389n = 0;

    /* renamed from: o  reason: collision with root package name */
    private int f8390o = 0;

    /* renamed from: p  reason: collision with root package name */
    private int f8391p = 10;

    /* renamed from: q  reason: collision with root package name */
    private int f8392q = 8;

    /* renamed from: r  reason: collision with root package name */
    private boolean f8393r = false;

    /* renamed from: s  reason: collision with root package name */
    private boolean f8394s = false;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public Context f8395t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f8396u = true;

    /* renamed from: v  reason: collision with root package name */
    private float f8397v = 0.0f;

    /* renamed from: w  reason: collision with root package name */
    private float f8398w = 0.0f;

    /* renamed from: x  reason: collision with root package name */
    private boolean f8399x = true;

    /* renamed from: y  reason: collision with root package name */
    private boolean f8400y = false;

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ef A[SYNTHETIC, Splitter:B:23:0x00ef] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f9 A[SYNTHETIC, Splitter:B:28:0x00f9] */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public dz(android.content.Context r6) {
        /*
            r5 = this;
            r5.<init>(r6)
            android.graphics.Paint r0 = new android.graphics.Paint
            r0.<init>()
            r5.f8383h = r0
            r0 = 0
            r5.f8384i = r0
            r5.f8385j = r0
            r5.f8386k = r0
            r5.f8387l = r0
            r1 = 10
            r5.f8388m = r1
            r5.f8389n = r0
            r5.f8390o = r0
            r5.f8391p = r1
            r1 = 8
            r5.f8392q = r1
            r5.f8393r = r0
            r5.f8394s = r0
            r1 = 1
            r5.f8396u = r1
            r2 = 0
            r5.f8397v = r2
            r5.f8398w = r2
            r5.f8399x = r1
            r5.f8400y = r0
            r0 = 0
            android.content.Context r2 = r6.getApplicationContext()     // Catch:{ all -> 0x00e4 }
            r5.f8395t = r2     // Catch:{ all -> 0x00e4 }
            android.content.res.AssetManager r2 = com.amap.api.mapcore.util.df.a(r6)     // Catch:{ all -> 0x00e4 }
            java.lang.String r3 = "ap.data"
            java.io.InputStream r2 = r2.open(r3)     // Catch:{ all -> 0x00e4 }
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r2)     // Catch:{ all -> 0x00e0 }
            r5.f8381f = r3     // Catch:{ all -> 0x00e0 }
            float r4 = com.amap.api.mapcore.util.l.f9554a     // Catch:{ all -> 0x00e0 }
            android.graphics.Bitmap r3 = com.amap.api.mapcore.util.dl.a((android.graphics.Bitmap) r3, (float) r4)     // Catch:{ all -> 0x00e0 }
            r5.f8376a = r3     // Catch:{ all -> 0x00e0 }
            r2.close()     // Catch:{ all -> 0x00e0 }
            android.content.res.AssetManager r3 = com.amap.api.mapcore.util.df.a(r6)     // Catch:{ all -> 0x00e0 }
            java.lang.String r4 = "ap1.data"
            java.io.InputStream r0 = r3.open(r4)     // Catch:{ all -> 0x00e0 }
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeStream(r0)     // Catch:{ all -> 0x00e0 }
            r5.f8382g = r3     // Catch:{ all -> 0x00e0 }
            float r4 = com.amap.api.mapcore.util.l.f9554a     // Catch:{ all -> 0x00e0 }
            android.graphics.Bitmap r3 = com.amap.api.mapcore.util.dl.a((android.graphics.Bitmap) r3, (float) r4)     // Catch:{ all -> 0x00e0 }
            r5.f8377b = r3     // Catch:{ all -> 0x00e0 }
            r0.close()     // Catch:{ all -> 0x00e0 }
            android.graphics.Bitmap r3 = r5.f8377b     // Catch:{ all -> 0x00e0 }
            int r3 = r3.getWidth()     // Catch:{ all -> 0x00e0 }
            r5.f8386k = r3     // Catch:{ all -> 0x00e0 }
            android.graphics.Bitmap r3 = r5.f8377b     // Catch:{ all -> 0x00e0 }
            int r3 = r3.getHeight()     // Catch:{ all -> 0x00e0 }
            r5.f8385j = r3     // Catch:{ all -> 0x00e0 }
            android.graphics.Paint r3 = r5.f8383h     // Catch:{ all -> 0x00e0 }
            r3.setAntiAlias(r1)     // Catch:{ all -> 0x00e0 }
            android.graphics.Paint r1 = r5.f8383h     // Catch:{ all -> 0x00e0 }
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r1.setColor(r3)     // Catch:{ all -> 0x00e0 }
            android.graphics.Paint r1 = r5.f8383h     // Catch:{ all -> 0x00e0 }
            android.graphics.Paint$Style r3 = android.graphics.Paint.Style.STROKE     // Catch:{ all -> 0x00e0 }
            r1.setStyle(r3)     // Catch:{ all -> 0x00e0 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e0 }
            r1.<init>()     // Catch:{ all -> 0x00e0 }
            java.io.File r3 = r6.getFilesDir()     // Catch:{ all -> 0x00e0 }
            r1.append(r3)     // Catch:{ all -> 0x00e0 }
            java.lang.String r3 = "/icon_web_day.data"
            r1.append(r3)     // Catch:{ all -> 0x00e0 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00e0 }
            com.autonavi.amap.mapcore.AMapEngineUtils.LOGO_CUSTOM_ICON_DAY_NAME = r1     // Catch:{ all -> 0x00e0 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e0 }
            r1.<init>()     // Catch:{ all -> 0x00e0 }
            java.io.File r6 = r6.getFilesDir()     // Catch:{ all -> 0x00e0 }
            r1.append(r6)     // Catch:{ all -> 0x00e0 }
            java.lang.String r6 = "/icon_web_night.data"
            r1.append(r6)     // Catch:{ all -> 0x00e0 }
            java.lang.String r6 = r1.toString()     // Catch:{ all -> 0x00e0 }
            com.autonavi.amap.mapcore.AMapEngineUtils.LOGO_CUSTOM_ICON_NIGHT_NAME = r6     // Catch:{ all -> 0x00e0 }
            com.amap.api.mapcore.util.dj r6 = com.amap.api.mapcore.util.dj.a()     // Catch:{ all -> 0x00e0 }
            com.amap.api.mapcore.util.dz$1 r1 = new com.amap.api.mapcore.util.dz$1     // Catch:{ all -> 0x00e0 }
            r1.<init>()     // Catch:{ all -> 0x00e0 }
            r6.a(r1)     // Catch:{ all -> 0x00e0 }
            if (r2 == 0) goto L_0x00d5
            r2.close()     // Catch:{ all -> 0x00d1 }
            goto L_0x00d5
        L_0x00d1:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00d5:
            if (r0 == 0) goto L_0x00df
            r0.close()     // Catch:{ all -> 0x00db }
            goto L_0x00df
        L_0x00db:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00df:
            return
        L_0x00e0:
            r6 = move-exception
            r1 = r0
            r0 = r2
            goto L_0x00e6
        L_0x00e4:
            r6 = move-exception
            r1 = r0
        L_0x00e6:
            java.lang.String r2 = "WaterMarkerView"
            java.lang.String r3 = "create"
            com.amap.api.mapcore.util.fz.c(r6, r2, r3)     // Catch:{ all -> 0x0102 }
            if (r0 == 0) goto L_0x00f7
            r0.close()     // Catch:{ all -> 0x00f3 }
            goto L_0x00f7
        L_0x00f3:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00f7:
            if (r1 == 0) goto L_0x0101
            r1.close()     // Catch:{ all -> 0x00fd }
            goto L_0x0101
        L_0x00fd:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0101:
            return
        L_0x0102:
            r6 = move-exception
            if (r0 == 0) goto L_0x010d
            r0.close()     // Catch:{ all -> 0x0109 }
            goto L_0x010d
        L_0x0109:
            r0 = move-exception
            r0.printStackTrace()
        L_0x010d:
            if (r1 == 0) goto L_0x0117
            r1.close()     // Catch:{ all -> 0x0113 }
            goto L_0x0117
        L_0x0113:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0117:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.dz.<init>(android.content.Context):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
        r0 = r1.f8379d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap e() {
        /*
            r1 = this;
            boolean r0 = r1.f8400y
            if (r0 == 0) goto L_0x0009
            android.graphics.Bitmap r0 = r1.f8380e
            if (r0 == 0) goto L_0x0009
            return r0
        L_0x0009:
            boolean r0 = r1.f8384i
            if (r0 == 0) goto L_0x0019
            boolean r0 = r1.f8394s
            if (r0 == 0) goto L_0x0016
            android.graphics.Bitmap r0 = r1.f8379d
            if (r0 == 0) goto L_0x0016
            return r0
        L_0x0016:
            android.graphics.Bitmap r0 = r1.f8377b
            return r0
        L_0x0019:
            boolean r0 = r1.f8394s
            if (r0 == 0) goto L_0x0022
            android.graphics.Bitmap r0 = r1.f8378c
            if (r0 == 0) goto L_0x0022
            return r0
        L_0x0022:
            android.graphics.Bitmap r0 = r1.f8376a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.dz.e():android.graphics.Bitmap");
    }

    private void f() {
        int i2 = this.f8390o;
        if (i2 == 0) {
            h();
        } else if (i2 == 2) {
            g();
        }
        this.f8388m = this.f8391p;
        int height = (getHeight() - this.f8392q) - this.f8385j;
        this.f8389n = height;
        if (this.f8388m < 0) {
            this.f8388m = 0;
        }
        if (height < 0) {
            this.f8389n = 0;
        }
    }

    private void g() {
        this.f8391p = (int) (this.f8399x ? ((float) getWidth()) * this.f8397v : (((float) getWidth()) * this.f8397v) - ((float) this.f8386k));
        this.f8392q = (int) (((float) getHeight()) * this.f8398w);
    }

    private void h() {
        int width;
        int i2 = this.f8387l;
        if (i2 == 1) {
            width = (getWidth() - this.f8386k) / 2;
        } else if (i2 == 2) {
            width = (getWidth() - this.f8386k) - 10;
        } else {
            this.f8391p = 10;
            this.f8392q = 8;
        }
        this.f8391p = width;
        this.f8392q = 8;
    }

    public final void a() {
        try {
            Bitmap bitmap = this.f8376a;
            if (bitmap != null) {
                dl.a(bitmap);
                this.f8376a = null;
            }
            Bitmap bitmap2 = this.f8377b;
            if (bitmap2 != null) {
                dl.a(bitmap2);
                this.f8377b = null;
            }
            this.f8376a = null;
            this.f8377b = null;
            Bitmap bitmap3 = this.f8381f;
            if (bitmap3 != null) {
                dl.a(bitmap3);
                this.f8381f = null;
            }
            Bitmap bitmap4 = this.f8382g;
            if (bitmap4 != null) {
                dl.a(bitmap4);
                this.f8382g = null;
            }
            Bitmap bitmap5 = this.f8378c;
            if (bitmap5 != null) {
                dl.a(bitmap5);
            }
            this.f8378c = null;
            Bitmap bitmap6 = this.f8379d;
            if (bitmap6 != null) {
                dl.a(bitmap6);
            }
            this.f8379d = null;
            Bitmap bitmap7 = this.f8380e;
            if (bitmap7 != null) {
                bitmap7.recycle();
            }
            this.f8383h = null;
        } catch (Throwable th) {
            fz.c(th, "WaterMarkerView", "destory");
            th.printStackTrace();
        }
    }

    public final void a(int i2) {
        this.f8390o = 0;
        this.f8387l = i2;
        c();
    }

    public final void a(int i2, float f2) {
        if (this.f8396u) {
            this.f8390o = 2;
            float max = Math.max(0.0f, Math.min(f2, 1.0f));
            if (i2 == 0) {
                this.f8397v = max;
                this.f8399x = true;
            } else if (i2 == 1) {
                this.f8397v = 1.0f - max;
                this.f8399x = false;
            } else if (i2 == 2) {
                this.f8398w = 1.0f - max;
            }
            c();
        }
    }

    public final void a(String str, int i2) {
        try {
            if (!this.f8396u || !new File(str).exists()) {
                return;
            }
            if (i2 == 0) {
                Bitmap bitmap = this.f8378c;
                Bitmap decodeFile = BitmapFactory.decodeFile(str);
                this.f8381f = decodeFile;
                this.f8378c = dl.a(decodeFile, l.f9554a);
                if (bitmap != null && !bitmap.isRecycled()) {
                    dl.a(bitmap);
                }
            } else if (i2 == 1) {
                Bitmap bitmap2 = this.f8379d;
                Bitmap decodeFile2 = BitmapFactory.decodeFile(str);
                this.f8381f = decodeFile2;
                this.f8379d = dl.a(decodeFile2, l.f9554a);
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    dl.a(bitmap2);
                }
            }
        } catch (Throwable th) {
            fz.c(th, "WaterMarkerView", "create");
            th.printStackTrace();
        }
    }

    public final void a(boolean z2) {
        if (this.f8396u) {
            try {
                this.f8384i = z2;
                if (z2) {
                    this.f8383h.setColor(-1);
                } else {
                    this.f8383h.setColor(-16777216);
                }
            } catch (Throwable th) {
                fz.c(th, "WaterMarkerView", "changeBitmap");
                th.printStackTrace();
            }
        }
    }

    public final Point b() {
        return new Point(this.f8388m, this.f8389n - 2);
    }

    public final void b(int i2) {
        this.f8390o = 1;
        this.f8392q = i2;
        c();
    }

    public final void b(boolean z2) {
        if (this.f8396u) {
            this.f8400y = z2;
            if (z2) {
                Bitmap bitmap = this.f8380e;
                if (bitmap != null) {
                    this.f8386k = bitmap.getWidth();
                    this.f8385j = this.f8380e.getHeight();
                    return;
                }
                return;
            }
            this.f8386k = this.f8376a.getWidth();
            this.f8385j = this.f8376a.getHeight();
        }
    }

    public final void c() {
        if (getWidth() != 0 && getHeight() != 0) {
            f();
            postInvalidate();
        }
    }

    public final void c(int i2) {
        this.f8390o = 1;
        this.f8391p = i2;
        c();
    }

    public final void c(boolean z2) {
        this.f8396u = z2;
    }

    public final float d(int i2) {
        float f2;
        if (!this.f8396u) {
            return 0.0f;
        }
        if (i2 == 0) {
            return this.f8397v;
        }
        if (i2 == 1) {
            f2 = this.f8397v;
        } else if (i2 != 2) {
            return 0.0f;
        } else {
            f2 = this.f8398w;
        }
        return 1.0f - f2;
    }

    public final void d(boolean z2) {
        Bitmap bitmap;
        if (this.f8396u && this.f8394s != z2) {
            this.f8394s = z2;
            if (z2) {
                if (this.f8384i) {
                    Bitmap bitmap2 = this.f8379d;
                    if (bitmap2 != null) {
                        this.f8386k = bitmap2.getWidth();
                        bitmap = this.f8379d;
                    } else {
                        return;
                    }
                } else {
                    Bitmap bitmap3 = this.f8378c;
                    if (bitmap3 != null) {
                        this.f8386k = bitmap3.getWidth();
                        bitmap = this.f8378c;
                    } else {
                        return;
                    }
                }
                this.f8385j = bitmap.getHeight();
                return;
            }
            this.f8386k = this.f8376a.getWidth();
            this.f8385j = this.f8376a.getHeight();
        }
    }

    public final boolean d() {
        return this.f8384i;
    }

    public final void onDraw(Canvas canvas) {
        try {
            if (!this.f8396u || getWidth() == 0) {
                return;
            }
            if (getHeight() != 0) {
                if (this.f8377b != null) {
                    if (!this.f8393r) {
                        f();
                        this.f8393r = true;
                    }
                    canvas.drawBitmap(e(), (float) this.f8388m, (float) this.f8389n, this.f8383h);
                }
            }
        } catch (Throwable th) {
            fz.c(th, "WaterMarkerView", "onDraw");
            th.printStackTrace();
        }
    }
}
