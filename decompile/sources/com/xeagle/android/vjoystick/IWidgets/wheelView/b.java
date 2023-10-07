package com.xeagle.android.vjoystick.IWidgets.wheelView;

import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

abstract class b extends RecyclerView.g {

    /* renamed from: a  reason: collision with root package name */
    final int f24757a;

    /* renamed from: b  reason: collision with root package name */
    final int f24758b;

    /* renamed from: c  reason: collision with root package name */
    final float f24759c;

    /* renamed from: d  reason: collision with root package name */
    final float f24760d;

    /* renamed from: e  reason: collision with root package name */
    final int f24761e;

    /* renamed from: f  reason: collision with root package name */
    final Camera f24762f;

    /* renamed from: g  reason: collision with root package name */
    final Matrix f24763g;

    /* renamed from: h  reason: collision with root package name */
    boolean f24764h;

    /* renamed from: i  reason: collision with root package name */
    float f24765i;

    /* renamed from: j  reason: collision with root package name */
    int f24766j = -1;

    b(int i2, int i3, int i4) {
        this.f24757a = i2;
        this.f24758b = i3;
        this.f24765i = ((float) i3) / 2.0f;
        float f2 = 180.0f / ((float) ((i2 * 2) + 1));
        this.f24759c = f2;
        this.f24761e = i4;
        this.f24760d = (float) d.a(i3, f2);
        this.f24762f = new Camera();
        this.f24763g = new Matrix();
    }

    private float a(Rect rect) {
        float f2;
        float exactCenterX = rect.exactCenterX();
        int i2 = this.f24761e;
        if (i2 == 1) {
            f2 = 1.2f;
        } else if (i2 != 3) {
            return exactCenterX;
        } else {
            f2 = 0.8f;
        }
        return exactCenterX * f2;
    }

    /* access modifiers changed from: package-private */
    public int a(float f2) {
        float abs = Math.abs(f2);
        if (abs >= 90.0f) {
            return 0;
        }
        return (int) (((90.0f - abs) / 90.0f) * 255.0f);
    }

    /* access modifiers changed from: package-private */
    public void a(Canvas canvas, Rect rect, int i2, float f2, float f3) {
        Canvas canvas2 = canvas;
        float f4 = f2;
        int i3 = i2 - this.f24757a;
        float exactCenterY = rect.exactCenterY();
        float f5 = exactCenterY - f3;
        float f6 = (this.f24759c * f5) / ((float) this.f24758b);
        int a2 = a(f6);
        if (a2 > 0) {
            double d2 = (double) f6;
            float sin = f5 - (this.f24760d * ((float) Math.sin(Math.toRadians(d2))));
            boolean z2 = false;
            if (!this.f24764h) {
                if (Math.abs(f5) <= this.f24765i) {
                    z2 = true;
                }
                if (z2) {
                    this.f24766j = i3;
                    this.f24764h = true;
                }
            }
            canvas.save();
            canvas2.translate(0.0f, -sin);
            this.f24762f.save();
            double d3 = (double) this.f24760d;
            Double.isNaN(d3);
            this.f24762f.translate(0.0f, 0.0f, (float) (d3 * (1.0d - Math.abs(Math.cos(Math.toRadians(d2))))));
            this.f24762f.rotateX(-f6);
            this.f24762f.getMatrix(this.f24763g);
            this.f24762f.restore();
            this.f24763g.preTranslate(-f4, -exactCenterY);
            this.f24763g.postTranslate(f4, exactCenterY);
            canvas2.concat(this.f24763g);
            a(canvas, rect, i3, a2, z2, true);
            canvas.restore();
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void a(Canvas canvas, Rect rect, int i2, int i3, boolean z2, boolean z3);

    /* access modifiers changed from: package-private */
    public abstract void a(Canvas canvas, Rect rect, boolean z2);

    /* access modifiers changed from: package-private */
    public void b(Canvas canvas, Rect rect, int i2, float f2, float f3) {
        Canvas canvas2 = canvas;
        float f4 = f3;
        int i3 = i2 - this.f24757a;
        float exactCenterX = rect.exactCenterX();
        float f5 = exactCenterX - f2;
        float f6 = (this.f24759c * f5) / ((float) this.f24758b);
        int a2 = a(f6);
        if (a2 > 0) {
            double d2 = (double) f6;
            float sin = f5 - (this.f24760d * ((float) Math.sin(Math.toRadians(d2))));
            boolean z2 = false;
            if (!this.f24764h) {
                if (Math.abs(f5) <= this.f24765i) {
                    z2 = true;
                }
                if (z2) {
                    this.f24766j = i3;
                    this.f24764h = true;
                }
            }
            canvas.save();
            canvas2.translate(-sin, 0.0f);
            this.f24762f.save();
            double d3 = (double) this.f24760d;
            Double.isNaN(d3);
            this.f24762f.translate(0.0f, 0.0f, (float) (d3 * (1.0d - Math.abs(Math.cos(Math.toRadians(d2))))));
            this.f24762f.rotateY(f6);
            this.f24762f.getMatrix(this.f24763g);
            this.f24762f.restore();
            this.f24763g.preTranslate(-exactCenterX, -f4);
            this.f24763g.postTranslate(exactCenterX, f4);
            canvas2.concat(this.f24763g);
            a(canvas, rect, i3, a2, z2, false);
            canvas.restore();
        }
    }

    public final void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        this.f24766j = -1;
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            boolean z2 = true;
            if (linearLayoutManager.h() != 1) {
                z2 = false;
            }
            Rect rect = new Rect(recyclerView.getLeft(), recyclerView.getTop(), recyclerView.getRight(), recyclerView.getBottom());
            int o2 = linearLayoutManager.o();
            if (o2 >= 0) {
                int q2 = linearLayoutManager.q();
                this.f24764h = false;
                while (o2 <= q2) {
                    if (o2 >= this.f24757a) {
                        if (o2 >= linearLayoutManager.J() - this.f24757a) {
                            break;
                        }
                        View c2 = linearLayoutManager.c(o2);
                        Rect rect2 = new Rect(c2.getLeft(), c2.getTop(), c2.getRight(), c2.getBottom());
                        if (z2) {
                            a(canvas, rect2, o2, a(rect), rect.exactCenterY());
                        } else {
                            b(canvas, rect2, o2, rect.exactCenterX(), rect.exactCenterY());
                        }
                    }
                    o2++;
                }
                a(canvas, rect, z2);
            }
        }
    }
}
