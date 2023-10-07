package com.github.barteksc.pdfviewer;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.github.barteksc.pdfviewer.util.a;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.util.SizeF;
import ev.a;

class d implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private PDFView f14598a;

    /* renamed from: b  reason: collision with root package name */
    private a f14599b;

    /* renamed from: c  reason: collision with root package name */
    private GestureDetector f14600c;

    /* renamed from: d  reason: collision with root package name */
    private ScaleGestureDetector f14601d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f14602e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f14603f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f14604g = false;

    d(PDFView pDFView, a aVar) {
        this.f14598a = pDFView;
        this.f14599b = aVar;
        this.f14600c = new GestureDetector(pDFView.getContext(), this);
        this.f14601d = new ScaleGestureDetector(pDFView.getContext(), this);
        pDFView.setOnTouchListener(this);
    }

    private void a(MotionEvent motionEvent) {
        this.f14598a.d();
        c();
        if (!this.f14599b.d()) {
            this.f14598a.g();
        }
    }

    private void a(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        float f4;
        float f5;
        if (c(f2, f3)) {
            int i2 = -1;
            if (!this.f14598a.m() ? f2 <= 0.0f : f3 <= 0.0f) {
                i2 = 1;
            }
            if (this.f14598a.m()) {
                f4 = motionEvent2.getY();
                f5 = motionEvent.getY();
            } else {
                f4 = motionEvent2.getX();
                f5 = motionEvent.getX();
            }
            float f6 = f4 - f5;
            int max = Math.max(0, Math.min(this.f14598a.getPageCount() - 1, this.f14598a.b(this.f14598a.getCurrentXOffset() - (this.f14598a.getZoom() * f6), this.f14598a.getCurrentYOffset() - (f6 * this.f14598a.getZoom())) + i2));
            this.f14599b.a(-this.f14598a.a(max, this.f14598a.c(max)));
        }
    }

    private boolean a(float f2, float f3) {
        int i2;
        int i3;
        f fVar = this.f14598a.f14515b;
        float f4 = (-this.f14598a.getCurrentXOffset()) + f2;
        float f5 = (-this.f14598a.getCurrentYOffset()) + f3;
        int a2 = fVar.a(this.f14598a.m() ? f5 : f4, this.f14598a.getZoom());
        SizeF a3 = fVar.a(a2, this.f14598a.getZoom());
        if (this.f14598a.m()) {
            i3 = (int) fVar.e(a2, this.f14598a.getZoom());
            i2 = (int) fVar.d(a2, this.f14598a.getZoom());
        } else {
            i2 = (int) fVar.e(a2, this.f14598a.getZoom());
            i3 = (int) fVar.d(a2, this.f14598a.getZoom());
        }
        int i4 = i3;
        int i5 = i2;
        for (PdfDocument.Link next : fVar.d(a2)) {
            RectF a4 = fVar.a(a2, i4, i5, (int) a3.a(), (int) a3.b(), next.c());
            a4.sort();
            if (a4.contains(f4, f5)) {
                this.f14598a.f14517d.a(new a(f2, f3, f4, f5, a4, next));
                return true;
            }
        }
        return false;
    }

    private void b(float f2, float f3) {
        float f4;
        float f5;
        int currentXOffset = (int) this.f14598a.getCurrentXOffset();
        int currentYOffset = (int) this.f14598a.getCurrentYOffset();
        f fVar = this.f14598a.f14515b;
        float f6 = -fVar.d(this.f14598a.getCurrentPage(), this.f14598a.getZoom());
        float b2 = f6 - fVar.b(this.f14598a.getCurrentPage(), this.f14598a.getZoom());
        float f7 = 0.0f;
        if (this.f14598a.m()) {
            f5 = -(this.f14598a.b(fVar.c()) - ((float) this.f14598a.getWidth()));
            f4 = b2 + ((float) this.f14598a.getHeight());
            f7 = f6;
            f6 = 0.0f;
        } else {
            float width = b2 + ((float) this.f14598a.getWidth());
            f4 = -(this.f14598a.b(fVar.d()) - ((float) this.f14598a.getHeight()));
            f5 = width;
        }
        this.f14599b.a(currentXOffset, currentYOffset, (int) f2, (int) f3, (int) f5, (int) f6, (int) f4, (int) f7);
    }

    private void c() {
        com.github.barteksc.pdfviewer.scroll.a scrollHandle = this.f14598a.getScrollHandle();
        if (scrollHandle != null && scrollHandle.c()) {
            scrollHandle.b();
        }
    }

    private boolean c(float f2, float f3) {
        float abs = Math.abs(f2);
        float abs2 = Math.abs(f3);
        if (this.f14598a.m()) {
            if (abs2 > abs) {
                return true;
            }
        } else if (abs > abs2) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f14604g = true;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f14604g = false;
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        PDFView pDFView;
        float x2;
        float y2;
        float maxZoom;
        if (!this.f14598a.b()) {
            return false;
        }
        if (this.f14598a.getZoom() < this.f14598a.getMidZoom()) {
            pDFView = this.f14598a;
            x2 = motionEvent.getX();
            y2 = motionEvent.getY();
            maxZoom = this.f14598a.getMidZoom();
        } else if (this.f14598a.getZoom() < this.f14598a.getMaxZoom()) {
            pDFView = this.f14598a;
            x2 = motionEvent.getX();
            y2 = motionEvent.getY();
            maxZoom = this.f14598a.getMaxZoom();
        } else {
            this.f14598a.k();
            return true;
        }
        pDFView.a(x2, y2, maxZoom);
        return true;
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onDown(MotionEvent motionEvent) {
        this.f14599b.c();
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        float f4;
        float f5;
        if (!this.f14598a.n()) {
            return false;
        }
        if (this.f14598a.q()) {
            if (this.f14598a.h()) {
                b(f2, f3);
            } else {
                a(motionEvent, motionEvent2, f2, f3);
            }
            return true;
        }
        int currentXOffset = (int) this.f14598a.getCurrentXOffset();
        int currentYOffset = (int) this.f14598a.getCurrentYOffset();
        f fVar = this.f14598a.f14515b;
        if (this.f14598a.m()) {
            f4 = -(this.f14598a.b(fVar.c()) - ((float) this.f14598a.getWidth()));
            f5 = fVar.a(this.f14598a.getZoom());
        } else {
            f4 = -(fVar.a(this.f14598a.getZoom()) - ((float) this.f14598a.getWidth()));
            f5 = this.f14598a.b(fVar.d());
        }
        this.f14599b.a(currentXOffset, currentYOffset, (int) f2, (int) f3, (int) f4, 0, (int) (-(f5 - ((float) this.f14598a.getHeight()))), 0);
        return true;
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.f14598a.f14517d.b(motionEvent);
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float f2;
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        float zoom = this.f14598a.getZoom() * scaleFactor;
        if (zoom < a.b.f14691b) {
            f2 = a.b.f14691b;
        } else {
            if (zoom > a.b.f14690a) {
                f2 = a.b.f14690a;
            }
            this.f14598a.b(scaleFactor, new PointF(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY()));
            return true;
        }
        scaleFactor = f2 / this.f14598a.getZoom();
        this.f14598a.b(scaleFactor, new PointF(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY()));
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.f14603f = true;
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        this.f14598a.d();
        c();
        this.f14603f = false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        this.f14602e = true;
        if (this.f14598a.j() || this.f14598a.n()) {
            this.f14598a.c(-f2, -f3);
        }
        if (!this.f14603f || this.f14598a.r()) {
            this.f14598a.f();
        }
        return true;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        com.github.barteksc.pdfviewer.scroll.a scrollHandle;
        boolean a2 = this.f14598a.f14517d.a(motionEvent);
        boolean a3 = a(motionEvent.getX(), motionEvent.getY());
        if (!a2 && !a3 && (scrollHandle = this.f14598a.getScrollHandle()) != null && !this.f14598a.i()) {
            if (!scrollHandle.c()) {
                scrollHandle.d();
            } else {
                scrollHandle.e();
            }
        }
        this.f14598a.performClick();
        return true;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f14604g) {
            return false;
        }
        boolean z2 = this.f14600c.onTouchEvent(motionEvent) || this.f14601d.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1 && this.f14602e) {
            this.f14602e = false;
            a(motionEvent);
        }
        return z2;
    }
}
