package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.c;
import com.android.volley.g;
import com.android.volley.i;
import com.android.volley.k;
import com.android.volley.l;

public class i extends Request<Bitmap> {

    /* renamed from: e  reason: collision with root package name */
    private static final Object f10002e = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final i.b<Bitmap> f10003a;

    /* renamed from: b  reason: collision with root package name */
    private final Bitmap.Config f10004b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10005c;

    /* renamed from: d  reason: collision with root package name */
    private final int f10006d;

    public i(String str, i.b<Bitmap> bVar, int i2, int i3, Bitmap.Config config, i.a aVar) {
        super(0, str, aVar);
        a((k) new c(1000, 2, 2.0f));
        this.f10003a = bVar;
        this.f10004b = config;
        this.f10005c = i2;
        this.f10006d = i3;
    }

    static int a(int i2, int i3, int i4, int i5) {
        double d2 = (double) i2;
        double d3 = (double) i4;
        Double.isNaN(d2);
        Double.isNaN(d3);
        double d4 = (double) i3;
        double d5 = (double) i5;
        Double.isNaN(d4);
        Double.isNaN(d5);
        double min = Math.min(d2 / d3, d4 / d5);
        float f2 = 1.0f;
        while (true) {
            float f3 = 2.0f * f2;
            if (((double) f3) > min) {
                return (int) f2;
            }
            f2 = f3;
        }
    }

    private static int b(int i2, int i3, int i4, int i5) {
        if (i2 == 0 && i3 == 0) {
            return i4;
        }
        if (i2 == 0) {
            double d2 = (double) i3;
            double d3 = (double) i5;
            Double.isNaN(d2);
            Double.isNaN(d3);
            double d4 = (double) i4;
            Double.isNaN(d4);
            return (int) (d4 * (d2 / d3));
        } else if (i3 == 0) {
            return i2;
        } else {
            double d5 = (double) i5;
            double d6 = (double) i4;
            Double.isNaN(d5);
            Double.isNaN(d6);
            double d7 = d5 / d6;
            double d8 = (double) i2;
            Double.isNaN(d8);
            double d9 = (double) i3;
            if (d8 * d7 <= d9) {
                return i2;
            }
            Double.isNaN(d9);
            return (int) (d9 / d7);
        }
    }

    private com.android.volley.i<Bitmap> b(g gVar) {
        Bitmap bitmap;
        byte[] bArr = gVar.f9918b;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.f10005c == 0 && this.f10006d == 0) {
            options.inPreferredConfig = this.f10004b;
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            int b2 = b(this.f10005c, this.f10006d, i2, i3);
            int b3 = b(this.f10006d, this.f10005c, i3, i2);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i2, i3, b2, b3);
            bitmap = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmap != null && (bitmap.getWidth() > b2 || bitmap.getHeight() > b3)) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, b2, b3, true);
                bitmap.recycle();
                bitmap = createScaledBitmap;
            }
        }
        return bitmap == null ? com.android.volley.i.a(new ParseError()) : com.android.volley.i.a(bitmap, e.a(gVar));
    }

    /* access modifiers changed from: protected */
    public com.android.volley.i<Bitmap> a(g gVar) {
        com.android.volley.i<Bitmap> b2;
        synchronized (f10002e) {
            try {
                b2 = b(gVar);
            } catch (OutOfMemoryError e2) {
                l.c("Caught OOM for %d byte image, url=%s", Integer.valueOf(gVar.f9918b.length), c());
                return com.android.volley.i.a(new ParseError(e2));
            } catch (Throwable th) {
                throw th;
            }
        }
        return b2;
    }

    /* access modifiers changed from: protected */
    public void a(Bitmap bitmap) {
        this.f10003a.a(bitmap);
    }

    public Request.Priority r() {
        return Request.Priority.LOW;
    }
}
