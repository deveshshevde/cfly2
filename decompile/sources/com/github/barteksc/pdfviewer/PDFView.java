package com.github.barteksc.pdfviewer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;
import com.github.barteksc.pdfviewer.exception.PageRenderingException;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.github.barteksc.pdfviewer.util.SnapEdge;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;
import com.shockwave.pdfium.util.SizeF;
import eu.b;
import eu.c;
import eu.d;
import eu.e;
import eu.f;
import eu.g;
import eu.h;
import eu.i;
import eu.j;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PDFView extends RelativeLayout {

    /* renamed from: e  reason: collision with root package name */
    private static final String f14513e = "PDFView";
    private boolean A = true;
    private boolean B = false;
    private boolean C = true;
    private PdfiumCore D;
    private com.github.barteksc.pdfviewer.scroll.a E;
    private boolean F = false;
    private boolean G = false;
    private boolean H = false;
    private boolean I = false;
    private boolean J = true;
    private PaintFlagsDrawFilter K = new PaintFlagsDrawFilter(0, 3);
    private int L = 0;
    private boolean M = false;
    private boolean N = true;
    private List<Integer> O = new ArrayList(10);
    /* access modifiers changed from: private */
    public boolean P = false;
    /* access modifiers changed from: private */
    public a Q;

    /* renamed from: a  reason: collision with root package name */
    b f14514a;

    /* renamed from: b  reason: collision with root package name */
    f f14515b;

    /* renamed from: c  reason: collision with root package name */
    g f14516c;

    /* renamed from: d  reason: collision with root package name */
    eu.a f14517d = new eu.a();

    /* renamed from: f  reason: collision with root package name */
    private float f14518f = 1.0f;

    /* renamed from: g  reason: collision with root package name */
    private float f14519g = 1.75f;

    /* renamed from: h  reason: collision with root package name */
    private float f14520h = 3.0f;

    /* renamed from: i  reason: collision with root package name */
    private ScrollDir f14521i = ScrollDir.NONE;

    /* renamed from: j  reason: collision with root package name */
    private a f14522j;

    /* renamed from: k  reason: collision with root package name */
    private d f14523k;

    /* renamed from: l  reason: collision with root package name */
    private int f14524l;

    /* renamed from: m  reason: collision with root package name */
    private float f14525m = 0.0f;

    /* renamed from: n  reason: collision with root package name */
    private float f14526n = 0.0f;

    /* renamed from: o  reason: collision with root package name */
    private float f14527o = 1.0f;

    /* renamed from: p  reason: collision with root package name */
    private boolean f14528p = true;

    /* renamed from: q  reason: collision with root package name */
    private State f14529q = State.DEFAULT;

    /* renamed from: r  reason: collision with root package name */
    private c f14530r;

    /* renamed from: s  reason: collision with root package name */
    private final HandlerThread f14531s = new HandlerThread("PDF renderer");

    /* renamed from: t  reason: collision with root package name */
    private e f14532t;

    /* renamed from: u  reason: collision with root package name */
    private Paint f14533u;

    /* renamed from: v  reason: collision with root package name */
    private Paint f14534v;

    /* renamed from: w  reason: collision with root package name */
    private FitPolicy f14535w = FitPolicy.WIDTH;

    /* renamed from: x  reason: collision with root package name */
    private int f14536x = 0;

    /* renamed from: y  reason: collision with root package name */
    private boolean f14537y = true;

    /* renamed from: z  reason: collision with root package name */
    private boolean f14538z = true;

    enum ScrollDir {
        NONE,
        START,
        END
    }

    private enum State {
        DEFAULT,
        LOADED,
        SHOWN,
        ERROR
    }

    public class a {
        private boolean A;
        private boolean B;

        /* renamed from: b  reason: collision with root package name */
        private final ew.a f14549b;

        /* renamed from: c  reason: collision with root package name */
        private int[] f14550c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f14551d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f14552e;

        /* renamed from: f  reason: collision with root package name */
        private b f14553f;

        /* renamed from: g  reason: collision with root package name */
        private b f14554g;

        /* renamed from: h  reason: collision with root package name */
        private d f14555h;

        /* renamed from: i  reason: collision with root package name */
        private c f14556i;

        /* renamed from: j  reason: collision with root package name */
        private f f14557j;

        /* renamed from: k  reason: collision with root package name */
        private h f14558k;

        /* renamed from: l  reason: collision with root package name */
        private i f14559l;

        /* renamed from: m  reason: collision with root package name */
        private j f14560m;

        /* renamed from: n  reason: collision with root package name */
        private e f14561n;

        /* renamed from: o  reason: collision with root package name */
        private g f14562o;

        /* renamed from: p  reason: collision with root package name */
        private et.b f14563p;

        /* renamed from: q  reason: collision with root package name */
        private int f14564q;

        /* renamed from: r  reason: collision with root package name */
        private boolean f14565r;

        /* renamed from: s  reason: collision with root package name */
        private boolean f14566s;

        /* renamed from: t  reason: collision with root package name */
        private String f14567t;

        /* renamed from: u  reason: collision with root package name */
        private com.github.barteksc.pdfviewer.scroll.a f14568u;

        /* renamed from: v  reason: collision with root package name */
        private boolean f14569v;

        /* renamed from: w  reason: collision with root package name */
        private int f14570w;

        /* renamed from: x  reason: collision with root package name */
        private boolean f14571x;

        /* renamed from: y  reason: collision with root package name */
        private FitPolicy f14572y;

        /* renamed from: z  reason: collision with root package name */
        private boolean f14573z;

        private a(ew.a aVar) {
            this.f14550c = null;
            this.f14551d = true;
            this.f14552e = true;
            this.f14563p = new et.a(PDFView.this);
            this.f14564q = 0;
            this.f14565r = false;
            this.f14566s = false;
            this.f14567t = null;
            this.f14568u = null;
            this.f14569v = true;
            this.f14570w = 0;
            this.f14571x = false;
            this.f14572y = FitPolicy.WIDTH;
            this.f14573z = false;
            this.A = false;
            this.B = false;
            this.f14549b = aVar;
        }

        public a a(int i2) {
            this.f14564q = i2;
            return this;
        }

        public a a(com.github.barteksc.pdfviewer.scroll.a aVar) {
            this.f14568u = aVar;
            return this;
        }

        public a a(String str) {
            this.f14567t = str;
            return this;
        }

        public a a(boolean z2) {
            this.f14551d = z2;
            return this;
        }

        public void a() {
            if (!PDFView.this.P) {
                a unused = PDFView.this.Q = this;
                return;
            }
            PDFView.this.c();
            PDFView.this.f14517d.a(this.f14555h);
            PDFView.this.f14517d.a(this.f14556i);
            PDFView.this.f14517d.a(this.f14553f);
            PDFView.this.f14517d.b(this.f14554g);
            PDFView.this.f14517d.a(this.f14557j);
            PDFView.this.f14517d.a(this.f14558k);
            PDFView.this.f14517d.a(this.f14559l);
            PDFView.this.f14517d.a(this.f14560m);
            PDFView.this.f14517d.a(this.f14561n);
            PDFView.this.f14517d.a(this.f14562o);
            PDFView.this.f14517d.a(this.f14563p);
            PDFView.this.setSwipeEnabled(this.f14551d);
            PDFView.this.setNightMode(this.B);
            PDFView.this.a(this.f14552e);
            PDFView.this.setDefaultPage(this.f14564q);
            PDFView.this.setSwipeVertical(!this.f14565r);
            PDFView.this.b(this.f14566s);
            PDFView.this.setScrollHandle(this.f14568u);
            PDFView.this.c(this.f14569v);
            PDFView.this.setSpacing(this.f14570w);
            PDFView.this.setAutoSpacing(this.f14571x);
            PDFView.this.setPageFitPolicy(this.f14572y);
            PDFView.this.setPageSnap(this.A);
            PDFView.this.setPageFling(this.f14573z);
            int[] iArr = this.f14550c;
            if (iArr != null) {
                PDFView.this.a(this.f14549b, this.f14567t, iArr);
            } else {
                PDFView.this.a(this.f14549b, this.f14567t);
            }
        }

        public a b(int i2) {
            this.f14570w = i2;
            return this;
        }

        public a b(boolean z2) {
            this.f14552e = z2;
            return this;
        }

        public a c(boolean z2) {
            this.f14566s = z2;
            return this;
        }

        public a d(boolean z2) {
            this.f14565r = z2;
            return this;
        }

        public a e(boolean z2) {
            this.f14569v = z2;
            return this;
        }

        public a f(boolean z2) {
            this.f14571x = z2;
            return this;
        }

        public a g(boolean z2) {
            this.A = z2;
            return this;
        }

        public a h(boolean z2) {
            this.f14573z = z2;
            return this;
        }

        public a i(boolean z2) {
            this.B = z2;
            return this;
        }
    }

    public PDFView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (!isInEditMode()) {
            this.f14514a = new b();
            a aVar = new a(this);
            this.f14522j = aVar;
            this.f14523k = new d(this, aVar);
            this.f14532t = new e(this);
            this.f14533u = new Paint();
            Paint paint = new Paint();
            this.f14534v = paint;
            paint.setStyle(Paint.Style.STROKE);
            this.D = new PdfiumCore(context);
            setWillNotDraw(false);
        }
    }

    private void a(Canvas canvas, int i2, b bVar) {
        float f2;
        if (bVar != null) {
            float f3 = 0.0f;
            if (this.f14537y) {
                f2 = this.f14515b.d(i2, this.f14527o);
            } else {
                f3 = this.f14515b.d(i2, this.f14527o);
                f2 = 0.0f;
            }
            canvas.translate(f3, f2);
            SizeF a2 = this.f14515b.a(i2);
            bVar.a(canvas, b(a2.a()), b(a2.b()), i2);
            canvas.translate(-f3, -f2);
        }
    }

    private void a(Canvas canvas, ev.b bVar) {
        float f2;
        float f3;
        RectF d2 = bVar.d();
        Bitmap c2 = bVar.c();
        if (!c2.isRecycled()) {
            SizeF a2 = this.f14515b.a(bVar.b());
            if (this.f14537y) {
                f3 = this.f14515b.d(bVar.b(), this.f14527o);
                f2 = b(this.f14515b.c() - a2.a()) / 2.0f;
            } else {
                f2 = this.f14515b.d(bVar.b(), this.f14527o);
                f3 = b(this.f14515b.d() - a2.b()) / 2.0f;
            }
            canvas.translate(f2, f3);
            Rect rect = new Rect(0, 0, c2.getWidth(), c2.getHeight());
            float b2 = b(d2.left * a2.a());
            float b3 = b(d2.top * a2.b());
            RectF rectF = new RectF((float) ((int) b2), (float) ((int) b3), (float) ((int) (b2 + b(d2.width() * a2.a()))), (float) ((int) (b3 + b(d2.height() * a2.b()))));
            float f4 = this.f14525m + f2;
            float f5 = this.f14526n + f3;
            if (rectF.left + f4 < ((float) getWidth()) && f4 + rectF.right > 0.0f && rectF.top + f5 < ((float) getHeight()) && f5 + rectF.bottom > 0.0f) {
                canvas.drawBitmap(c2, rect, rectF, this.f14533u);
                if (com.github.barteksc.pdfviewer.util.a.f14684a) {
                    this.f14534v.setColor(bVar.b() % 2 == 0 ? -65536 : -16776961);
                    canvas.drawRect(rectF, this.f14534v);
                }
            }
            canvas.translate(-f2, -f3);
        }
    }

    /* access modifiers changed from: private */
    public void a(ew.a aVar, String str) {
        a(aVar, str, (int[]) null);
    }

    /* access modifiers changed from: private */
    public void a(ew.a aVar, String str, int[] iArr) {
        if (this.f14528p) {
            this.f14528p = false;
            c cVar = new c(aVar, str, iArr, this, this.D);
            this.f14530r = cVar;
            cVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        throw new IllegalStateException("Don't call load on a PDF View without recycling it first.");
    }

    /* access modifiers changed from: private */
    public void setAutoSpacing(boolean z2) {
        this.M = z2;
    }

    /* access modifiers changed from: private */
    public void setDefaultPage(int i2) {
        this.f14536x = i2;
    }

    /* access modifiers changed from: private */
    public void setPageFitPolicy(FitPolicy fitPolicy) {
        this.f14535w = fitPolicy;
    }

    /* access modifiers changed from: private */
    public void setScrollHandle(com.github.barteksc.pdfviewer.scroll.a aVar) {
        this.E = aVar;
    }

    /* access modifiers changed from: private */
    public void setSpacing(int i2) {
        this.L = com.github.barteksc.pdfviewer.util.d.a(getContext(), i2);
    }

    /* access modifiers changed from: private */
    public void setSwipeVertical(boolean z2) {
        this.f14537y = z2;
    }

    /* access modifiers changed from: package-private */
    public float a(int i2, SnapEdge snapEdge) {
        float f2;
        float d2 = this.f14515b.d(i2, this.f14527o);
        float height = (float) (this.f14537y ? getHeight() : getWidth());
        float b2 = this.f14515b.b(i2, this.f14527o);
        if (snapEdge == SnapEdge.CENTER) {
            f2 = d2 - (height / 2.0f);
            b2 /= 2.0f;
        } else if (snapEdge != SnapEdge.END) {
            return d2;
        } else {
            f2 = d2 - height;
        }
        return f2 + b2;
    }

    public a a(File file) {
        return new a(new ew.b(file));
    }

    public void a() {
        this.f14522j.c();
    }

    public void a(float f2) {
        this.f14527o = f2;
    }

    public void a(float f2, float f3) {
        a(f2, f3, true);
    }

    public void a(float f2, float f3, float f4) {
        this.f14522j.a(f2, f3, this.f14527o, f4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007a, code lost:
        if (r7 > r0) goto L_0x007c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007c, code lost:
        r0 = com.github.barteksc.pdfviewer.PDFView.ScrollDir.f14540b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007f, code lost:
        r0 = com.github.barteksc.pdfviewer.PDFView.ScrollDir.f14539a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00f0, code lost:
        if (r6 > r0) goto L_0x007c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(float r6, float r7, boolean r8) {
        /*
            r5 = this;
            boolean r0 = r5.f14537y
            r1 = 1073741824(0x40000000, float:2.0)
            r2 = 0
            if (r0 == 0) goto L_0x0082
            com.github.barteksc.pdfviewer.f r0 = r5.f14515b
            float r0 = r0.c()
            float r0 = r5.b((float) r0)
            int r3 = r5.getWidth()
            float r3 = (float) r3
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0024
            int r6 = r5.getWidth()
            int r6 = r6 / 2
            float r6 = (float) r6
            float r0 = r0 / r1
        L_0x0022:
            float r6 = r6 - r0
            goto L_0x003b
        L_0x0024:
            int r3 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x002a
            r6 = 0
            goto L_0x003b
        L_0x002a:
            float r3 = r6 + r0
            int r4 = r5.getWidth()
            float r4 = (float) r4
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x003b
            int r6 = r5.getWidth()
            float r6 = (float) r6
            goto L_0x0022
        L_0x003b:
            com.github.barteksc.pdfviewer.f r0 = r5.f14515b
            float r3 = r5.f14527o
            float r0 = r0.a((float) r3)
            int r3 = r5.getHeight()
            float r3 = (float) r3
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0054
            int r7 = r5.getHeight()
            float r7 = (float) r7
            float r7 = r7 - r0
            float r7 = r7 / r1
            goto L_0x006c
        L_0x0054:
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x005a
            r7 = 0
            goto L_0x006c
        L_0x005a:
            float r1 = r7 + r0
            int r2 = r5.getHeight()
            float r2 = (float) r2
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x006c
            float r7 = -r0
            int r0 = r5.getHeight()
            float r0 = (float) r0
            float r7 = r7 + r0
        L_0x006c:
            float r0 = r5.f14526n
            int r1 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r1 >= 0) goto L_0x0078
        L_0x0072:
            com.github.barteksc.pdfviewer.PDFView$ScrollDir r0 = com.github.barteksc.pdfviewer.PDFView.ScrollDir.END
        L_0x0074:
            r5.f14521i = r0
            goto L_0x00f3
        L_0x0078:
            int r0 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x007f
        L_0x007c:
            com.github.barteksc.pdfviewer.PDFView$ScrollDir r0 = com.github.barteksc.pdfviewer.PDFView.ScrollDir.START
            goto L_0x0074
        L_0x007f:
            com.github.barteksc.pdfviewer.PDFView$ScrollDir r0 = com.github.barteksc.pdfviewer.PDFView.ScrollDir.NONE
            goto L_0x0074
        L_0x0082:
            com.github.barteksc.pdfviewer.f r0 = r5.f14515b
            float r0 = r0.d()
            float r0 = r5.b((float) r0)
            int r3 = r5.getHeight()
            float r3 = (float) r3
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x009f
            int r7 = r5.getHeight()
            int r7 = r7 / 2
            float r7 = (float) r7
            float r0 = r0 / r1
        L_0x009d:
            float r7 = r7 - r0
            goto L_0x00b6
        L_0x009f:
            int r3 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x00a5
            r7 = 0
            goto L_0x00b6
        L_0x00a5:
            float r3 = r7 + r0
            int r4 = r5.getHeight()
            float r4 = (float) r4
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 >= 0) goto L_0x00b6
            int r7 = r5.getHeight()
            float r7 = (float) r7
            goto L_0x009d
        L_0x00b6:
            com.github.barteksc.pdfviewer.f r0 = r5.f14515b
            float r3 = r5.f14527o
            float r0 = r0.a((float) r3)
            int r3 = r5.getWidth()
            float r3 = (float) r3
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x00cf
            int r6 = r5.getWidth()
            float r6 = (float) r6
            float r6 = r6 - r0
            float r6 = r6 / r1
            goto L_0x00e7
        L_0x00cf:
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x00d5
            r6 = 0
            goto L_0x00e7
        L_0x00d5:
            float r1 = r6 + r0
            int r2 = r5.getWidth()
            float r2 = (float) r2
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x00e7
            float r6 = -r0
            int r0 = r5.getWidth()
            float r0 = (float) r0
            float r6 = r6 + r0
        L_0x00e7:
            float r0 = r5.f14525m
            int r1 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r1 >= 0) goto L_0x00ee
            goto L_0x0072
        L_0x00ee:
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x007f
            goto L_0x007c
        L_0x00f3:
            r5.f14525m = r6
            r5.f14526n = r7
            float r6 = r5.getPositionOffset()
            if (r8 == 0) goto L_0x010c
            com.github.barteksc.pdfviewer.scroll.a r7 = r5.E
            if (r7 == 0) goto L_0x010c
            boolean r7 = r5.i()
            if (r7 != 0) goto L_0x010c
            com.github.barteksc.pdfviewer.scroll.a r7 = r5.E
            r7.setScroll(r6)
        L_0x010c:
            eu.a r7 = r5.f14517d
            int r8 = r5.getCurrentPage()
            r7.a((int) r8, (float) r6)
            r5.e()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.PDFView.a(float, float, boolean):void");
    }

    public void a(float f2, PointF pointF) {
        float f3 = f2 / this.f14527o;
        a(f2);
        a((this.f14525m * f3) + (pointF.x - (pointF.x * f3)), (this.f14526n * f3) + (pointF.y - (pointF.y * f3)));
    }

    public void a(float f2, boolean z2) {
        if (this.f14537y) {
            a(this.f14525m, ((-this.f14515b.a(this.f14527o)) + ((float) getHeight())) * f2, z2);
        } else {
            a(((-this.f14515b.a(this.f14527o)) + ((float) getWidth())) * f2, this.f14526n, z2);
        }
        f();
    }

    public void a(int i2) {
        a(i2, false);
    }

    public void a(int i2, boolean z2) {
        f fVar = this.f14515b;
        if (fVar != null) {
            int e2 = fVar.e(i2);
            float f2 = e2 == 0 ? 0.0f : -this.f14515b.d(e2, this.f14527o);
            if (this.f14537y) {
                if (z2) {
                    this.f14522j.b(this.f14526n, f2);
                } else {
                    a(this.f14525m, f2);
                }
            } else if (z2) {
                this.f14522j.a(this.f14525m, f2);
            } else {
                a(f2, this.f14526n);
            }
            b(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(PageRenderingException pageRenderingException) {
        if (!this.f14517d.a(pageRenderingException.a(), pageRenderingException.getCause())) {
            String str = f14513e;
            Log.e(str, "Cannot open page " + pageRenderingException.a(), pageRenderingException.getCause());
        }
    }

    /* access modifiers changed from: package-private */
    public void a(f fVar) {
        this.f14529q = State.LOADED;
        this.f14515b = fVar;
        if (!this.f14531s.isAlive()) {
            this.f14531s.start();
        }
        g gVar = new g(this.f14531s.getLooper(), this);
        this.f14516c = gVar;
        gVar.b();
        com.github.barteksc.pdfviewer.scroll.a aVar = this.E;
        if (aVar != null) {
            aVar.setupLayout(this);
            this.F = true;
        }
        this.f14523k.a();
        this.f14517d.a(fVar.a());
        a(this.f14536x, false);
    }

    public void a(ev.b bVar) {
        if (this.f14529q == State.LOADED) {
            this.f14529q = State.SHOWN;
            this.f14517d.b(this.f14515b.a());
        }
        if (bVar.e()) {
            this.f14514a.b(bVar);
        } else {
            this.f14514a.a(bVar);
        }
        e();
    }

    /* access modifiers changed from: package-private */
    public void a(Throwable th) {
        this.f14529q = State.ERROR;
        c a2 = this.f14517d.a();
        c();
        invalidate();
        if (a2 != null) {
            a2.a(th);
        } else {
            Log.e(f14513e, "load pdf error", th);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        this.A = z2;
    }

    public float b(float f2) {
        return f2 * this.f14527o;
    }

    /* access modifiers changed from: package-private */
    public int b(float f2, float f3) {
        boolean z2 = this.f14537y;
        if (z2) {
            f2 = f3;
        }
        float height = (float) (z2 ? getHeight() : getWidth());
        if (f2 > -1.0f) {
            return 0;
        }
        if (f2 < (-this.f14515b.a(this.f14527o)) + height + 1.0f) {
            return this.f14515b.a() - 1;
        }
        return this.f14515b.a(-(f2 - (height / 2.0f)), this.f14527o);
    }

    public void b(float f2, PointF pointF) {
        a(this.f14527o * f2, pointF);
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        if (!this.f14528p) {
            this.f14524l = this.f14515b.e(i2);
            d();
            if (this.E != null && !i()) {
                this.E.setPageNum(this.f14524l + 1);
            }
            this.f14517d.a(this.f14524l, this.f14515b.a());
        }
    }

    public void b(boolean z2) {
        this.H = z2;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.A;
    }

    /* access modifiers changed from: package-private */
    public SnapEdge c(int i2) {
        if (!this.C || i2 < 0) {
            return SnapEdge.NONE;
        }
        float f2 = this.f14537y ? this.f14526n : this.f14525m;
        float f3 = -this.f14515b.d(i2, this.f14527o);
        int height = this.f14537y ? getHeight() : getWidth();
        float b2 = this.f14515b.b(i2, this.f14527o);
        float f4 = (float) height;
        return f4 >= b2 ? SnapEdge.CENTER : f2 >= f3 ? SnapEdge.START : f3 - b2 > f2 - f4 ? SnapEdge.END : SnapEdge.NONE;
    }

    public void c() {
        this.Q = null;
        this.f14522j.b();
        this.f14523k.b();
        g gVar = this.f14516c;
        if (gVar != null) {
            gVar.a();
            this.f14516c.removeMessages(1);
        }
        c cVar = this.f14530r;
        if (cVar != null) {
            cVar.cancel(true);
        }
        this.f14514a.d();
        com.github.barteksc.pdfviewer.scroll.a aVar = this.E;
        if (aVar != null && this.F) {
            aVar.a();
        }
        f fVar = this.f14515b;
        if (fVar != null) {
            fVar.g();
            this.f14515b = null;
        }
        this.f14516c = null;
        this.E = null;
        this.F = false;
        this.f14526n = 0.0f;
        this.f14525m = 0.0f;
        this.f14527o = 1.0f;
        this.f14528p = true;
        this.f14517d = new eu.a();
        this.f14529q = State.DEFAULT;
    }

    public void c(float f2) {
        this.f14522j.a((float) (getWidth() / 2), (float) (getHeight() / 2), this.f14527o, f2);
    }

    public void c(float f2, float f3) {
        a(this.f14525m + f2, this.f14526n + f3);
    }

    public void c(boolean z2) {
        this.J = z2;
    }

    public boolean canScrollHorizontally(int i2) {
        f fVar = this.f14515b;
        if (fVar == null) {
            return true;
        }
        if (this.f14537y) {
            if (i2 >= 0 || this.f14525m >= 0.0f) {
                return i2 > 0 && this.f14525m + b(fVar.c()) > ((float) getWidth());
            }
            return true;
        } else if (i2 >= 0 || this.f14525m >= 0.0f) {
            return i2 > 0 && this.f14525m + fVar.a(this.f14527o) > ((float) getWidth());
        } else {
            return true;
        }
    }

    public boolean canScrollVertically(int i2) {
        f fVar = this.f14515b;
        if (fVar == null) {
            return true;
        }
        if (this.f14537y) {
            if (i2 >= 0 || this.f14526n >= 0.0f) {
                return i2 > 0 && this.f14526n + fVar.a(this.f14527o) > ((float) getHeight());
            }
            return true;
        } else if (i2 >= 0 || this.f14526n >= 0.0f) {
            return i2 > 0 && this.f14526n + b(fVar.d()) > ((float) getHeight());
        } else {
            return true;
        }
    }

    public void computeScroll() {
        super.computeScroll();
        if (!isInEditMode()) {
            this.f14522j.a();
        }
    }

    public void d() {
        g gVar;
        if (this.f14515b != null && (gVar = this.f14516c) != null) {
            gVar.removeMessages(1);
            this.f14514a.a();
            this.f14532t.a();
            e();
        }
    }

    /* access modifiers changed from: package-private */
    public void e() {
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void f() {
        int i2;
        float f2;
        if (this.f14515b.a() != 0) {
            if (this.f14537y) {
                f2 = this.f14526n;
                i2 = getHeight();
            } else {
                f2 = this.f14525m;
                i2 = getWidth();
            }
            int a2 = this.f14515b.a(-(f2 - (((float) i2) / 2.0f)), this.f14527o);
            if (a2 < 0 || a2 > this.f14515b.a() - 1 || a2 == getCurrentPage()) {
                d();
            } else {
                b(a2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        r0 = b(r3.f14525m, r3.f14526n);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g() {
        /*
            r3 = this;
            boolean r0 = r3.C
            if (r0 == 0) goto L_0x0039
            com.github.barteksc.pdfviewer.f r0 = r3.f14515b
            if (r0 == 0) goto L_0x0039
            int r0 = r0.a()
            if (r0 != 0) goto L_0x000f
            goto L_0x0039
        L_0x000f:
            float r0 = r3.f14525m
            float r1 = r3.f14526n
            int r0 = r3.b((float) r0, (float) r1)
            com.github.barteksc.pdfviewer.util.SnapEdge r1 = r3.c((int) r0)
            com.github.barteksc.pdfviewer.util.SnapEdge r2 = com.github.barteksc.pdfviewer.util.SnapEdge.NONE
            if (r1 != r2) goto L_0x0020
            return
        L_0x0020:
            float r0 = r3.a((int) r0, (com.github.barteksc.pdfviewer.util.SnapEdge) r1)
            boolean r1 = r3.f14537y
            if (r1 == 0) goto L_0x0031
            com.github.barteksc.pdfviewer.a r1 = r3.f14522j
            float r2 = r3.f14526n
            float r0 = -r0
            r1.b(r2, r0)
            goto L_0x0039
        L_0x0031:
            com.github.barteksc.pdfviewer.a r1 = r3.f14522j
            float r2 = r3.f14525m
            float r0 = -r0
            r1.a((float) r2, (float) r0)
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.PDFView.g():void");
    }

    public int getCurrentPage() {
        return this.f14524l;
    }

    public float getCurrentXOffset() {
        return this.f14525m;
    }

    public float getCurrentYOffset() {
        return this.f14526n;
    }

    public PdfDocument.Meta getDocumentMeta() {
        f fVar = this.f14515b;
        if (fVar == null) {
            return null;
        }
        return fVar.e();
    }

    public float getMaxZoom() {
        return this.f14520h;
    }

    public float getMidZoom() {
        return this.f14519g;
    }

    public float getMinZoom() {
        return this.f14518f;
    }

    public int getPageCount() {
        f fVar = this.f14515b;
        if (fVar == null) {
            return 0;
        }
        return fVar.a();
    }

    public FitPolicy getPageFitPolicy() {
        return this.f14535w;
    }

    public float getPositionOffset() {
        int i2;
        float f2;
        float f3;
        if (this.f14537y) {
            f3 = -this.f14526n;
            f2 = this.f14515b.a(this.f14527o);
            i2 = getHeight();
        } else {
            f3 = -this.f14525m;
            f2 = this.f14515b.a(this.f14527o);
            i2 = getWidth();
        }
        return com.github.barteksc.pdfviewer.util.b.a(f3 / (f2 - ((float) i2)), 0.0f, 1.0f);
    }

    /* access modifiers changed from: package-private */
    public com.github.barteksc.pdfviewer.scroll.a getScrollHandle() {
        return this.E;
    }

    public int getSpacingPx() {
        return this.L;
    }

    public List<PdfDocument.Bookmark> getTableOfContents() {
        f fVar = this.f14515b;
        return fVar == null ? Collections.emptyList() : fVar.f();
    }

    public float getZoom() {
        return this.f14527o;
    }

    public boolean h() {
        float f2 = -this.f14515b.d(this.f14524l, this.f14527o);
        float b2 = f2 - this.f14515b.b(this.f14524l, this.f14527o);
        if (m()) {
            float f3 = this.f14526n;
            return f2 > f3 && b2 < f3 - ((float) getHeight());
        }
        float f4 = this.f14525m;
        return f2 > f4 && b2 < f4 - ((float) getWidth());
    }

    public boolean i() {
        float a2 = this.f14515b.a(1.0f);
        return this.f14537y ? a2 < ((float) getHeight()) : a2 < ((float) getWidth());
    }

    public boolean j() {
        return this.f14527o != this.f14518f;
    }

    public void k() {
        c(this.f14518f);
    }

    public boolean l() {
        return this.G;
    }

    public boolean m() {
        return this.f14537y;
    }

    public boolean n() {
        return this.f14538z;
    }

    public boolean o() {
        return this.H;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        c();
        super.onDetachedFromWindow();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!isInEditMode()) {
            if (this.J) {
                canvas.setDrawFilter(this.K);
            }
            Drawable background = getBackground();
            if (background == null) {
                canvas.drawColor(this.B ? -16777216 : -1);
            } else {
                background.draw(canvas);
            }
            if (!this.f14528p && this.f14529q == State.SHOWN) {
                float f2 = this.f14525m;
                float f3 = this.f14526n;
                canvas.translate(f2, f3);
                for (ev.b a2 : this.f14514a.c()) {
                    a(canvas, a2);
                }
                for (ev.b next : this.f14514a.b()) {
                    a(canvas, next);
                    if (this.f14517d.c() != null && !this.O.contains(Integer.valueOf(next.b()))) {
                        this.O.add(Integer.valueOf(next.b()));
                    }
                }
                for (Integer intValue : this.O) {
                    a(canvas, intValue.intValue(), this.f14517d.c());
                }
                this.O.clear();
                a(canvas, this.f14524l, this.f14517d.b());
                canvas.translate(-f2, -f3);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        this.P = true;
        a aVar = this.Q;
        if (aVar != null) {
            aVar.a();
        }
        if (!isInEditMode() && this.f14529q == State.SHOWN) {
            this.f14522j.b();
            this.f14515b.a(new Size(i2, i3));
            if (this.f14537y) {
                f3 = this.f14525m;
                f2 = -this.f14515b.d(this.f14524l, this.f14527o);
            } else {
                f3 = -this.f14515b.d(this.f14524l, this.f14527o);
                f2 = this.f14526n;
            }
            a(f3, f2);
            f();
        }
    }

    public boolean p() {
        return this.M;
    }

    public boolean q() {
        return this.N;
    }

    public boolean r() {
        return this.I;
    }

    public void setMaxZoom(float f2) {
        this.f14520h = f2;
    }

    public void setMidZoom(float f2) {
        this.f14519g = f2;
    }

    public void setMinZoom(float f2) {
        this.f14518f = f2;
    }

    public void setNightMode(boolean z2) {
        Paint paint;
        ColorMatrixColorFilter colorMatrixColorFilter;
        this.B = z2;
        if (z2) {
            colorMatrixColorFilter = new ColorMatrixColorFilter(new ColorMatrix(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f}));
            paint = this.f14533u;
        } else {
            paint = this.f14533u;
            colorMatrixColorFilter = null;
        }
        paint.setColorFilter(colorMatrixColorFilter);
    }

    public void setPageFling(boolean z2) {
        this.N = z2;
    }

    public void setPageSnap(boolean z2) {
        this.C = z2;
    }

    public void setPositionOffset(float f2) {
        a(f2, true);
    }

    public void setSwipeEnabled(boolean z2) {
        this.f14538z = z2;
    }
}
