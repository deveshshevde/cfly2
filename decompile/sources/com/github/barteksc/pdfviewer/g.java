package com.github.barteksc.pdfviewer;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.github.barteksc.pdfviewer.exception.PageRenderingException;
import ev.b;

class g extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private static final String f14647a = "com.github.barteksc.pdfviewer.g";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public PDFView f14648b;

    /* renamed from: c  reason: collision with root package name */
    private RectF f14649c = new RectF();

    /* renamed from: d  reason: collision with root package name */
    private Rect f14650d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    private Matrix f14651e = new Matrix();

    /* renamed from: f  reason: collision with root package name */
    private boolean f14652f = false;

    private class a {

        /* renamed from: a  reason: collision with root package name */
        float f14657a;

        /* renamed from: b  reason: collision with root package name */
        float f14658b;

        /* renamed from: c  reason: collision with root package name */
        RectF f14659c;

        /* renamed from: d  reason: collision with root package name */
        int f14660d;

        /* renamed from: e  reason: collision with root package name */
        boolean f14661e;

        /* renamed from: f  reason: collision with root package name */
        int f14662f;

        /* renamed from: g  reason: collision with root package name */
        boolean f14663g;

        /* renamed from: h  reason: collision with root package name */
        boolean f14664h;

        a(float f2, float f3, RectF rectF, int i2, boolean z2, int i3, boolean z3, boolean z4) {
            this.f14660d = i2;
            this.f14657a = f2;
            this.f14658b = f3;
            this.f14659c = rectF;
            this.f14661e = z2;
            this.f14662f = i3;
            this.f14663g = z3;
            this.f14664h = z4;
        }
    }

    g(Looper looper, PDFView pDFView) {
        super(looper);
        this.f14648b = pDFView;
    }

    private b a(a aVar) throws PageRenderingException {
        f fVar = this.f14648b.f14515b;
        fVar.b(aVar.f14660d);
        int round = Math.round(aVar.f14657a);
        int round2 = Math.round(aVar.f14658b);
        if (!(round == 0 || round2 == 0 || fVar.c(aVar.f14660d))) {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(round, round2, aVar.f14663g ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
                a(round, round2, aVar.f14659c);
                fVar.a(createBitmap, aVar.f14660d, this.f14650d, aVar.f14664h);
                return new b(aVar.f14660d, createBitmap, aVar.f14659c, aVar.f14661e, aVar.f14662f);
            } catch (IllegalArgumentException e2) {
                Log.e(f14647a, "Cannot create bitmap", e2);
            }
        }
        return null;
    }

    private void a(int i2, int i3, RectF rectF) {
        this.f14651e.reset();
        float f2 = (float) i2;
        float f3 = (float) i3;
        this.f14651e.postTranslate((-rectF.left) * f2, (-rectF.top) * f3);
        this.f14651e.postScale(1.0f / rectF.width(), 1.0f / rectF.height());
        this.f14649c.set(0.0f, 0.0f, f2, f3);
        this.f14651e.mapRect(this.f14649c);
        this.f14649c.round(this.f14650d);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f14652f = false;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, float f2, float f3, RectF rectF, boolean z2, int i3, boolean z3, boolean z4) {
        sendMessage(obtainMessage(1, new a(f2, f3, rectF, i2, z2, i3, z3, z4)));
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f14652f = true;
    }

    public void handleMessage(Message message) {
        try {
            final b a2 = a((a) message.obj);
            if (a2 == null) {
                return;
            }
            if (this.f14652f) {
                this.f14648b.post(new Runnable() {
                    public void run() {
                        g.this.f14648b.a(a2);
                    }
                });
            } else {
                a2.c().recycle();
            }
        } catch (PageRenderingException e2) {
            this.f14648b.post(new Runnable() {
                public void run() {
                    g.this.f14648b.a(e2);
                }
            });
        }
    }
}
