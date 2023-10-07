package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.widget.q;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.h;
import androidx.constraintlayout.solver.widgets.j;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import fg.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import t.s;

public class MotionLayout extends ConstraintLayout implements s {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1692a;
    int A;
    int B;
    int C;
    int D;
    int E;
    float F;
    TransitionState G = TransitionState.UNDEFINED;
    c H = new c();
    ArrayList<Integer> I = new ArrayList<>();
    /* access modifiers changed from: private */
    public int S = -1;
    /* access modifiers changed from: private */
    public int T = -1;
    /* access modifiers changed from: private */
    public int U = 0;
    /* access modifiers changed from: private */
    public int V = 0;
    private boolean W = true;

    /* renamed from: aa  reason: collision with root package name */
    private long f1693aa = 0;

    /* renamed from: ab  reason: collision with root package name */
    private float f1694ab = 1.0f;

    /* renamed from: ac  reason: collision with root package name */
    private long f1695ac;

    /* renamed from: ad  reason: collision with root package name */
    private boolean f1696ad;

    /* renamed from: ae  reason: collision with root package name */
    private g f1697ae;

    /* renamed from: af  reason: collision with root package name */
    private float f1698af;

    /* renamed from: ag  reason: collision with root package name */
    private float f1699ag;

    /* renamed from: ah  reason: collision with root package name */
    private boolean f1700ah = false;

    /* renamed from: ai  reason: collision with root package name */
    private k.g f1701ai = new k.g();

    /* renamed from: aj  reason: collision with root package name */
    private a f1702aj = new a();

    /* renamed from: ak  reason: collision with root package name */
    private b f1703ak;

    /* renamed from: al  reason: collision with root package name */
    private boolean f1704al = false;

    /* renamed from: am  reason: collision with root package name */
    private ArrayList<MotionHelper> f1705am = null;

    /* renamed from: an  reason: collision with root package name */
    private ArrayList<MotionHelper> f1706an = null;

    /* renamed from: ao  reason: collision with root package name */
    private ArrayList<g> f1707ao = null;

    /* renamed from: ap  reason: collision with root package name */
    private int f1708ap = 0;

    /* renamed from: aq  reason: collision with root package name */
    private long f1709aq = -1;

    /* renamed from: ar  reason: collision with root package name */
    private float f1710ar = 0.0f;

    /* renamed from: as  reason: collision with root package name */
    private int f1711as = 0;

    /* renamed from: at  reason: collision with root package name */
    private float f1712at = 0.0f;

    /* renamed from: au  reason: collision with root package name */
    private e f1713au = new e();

    /* renamed from: av  reason: collision with root package name */
    private boolean f1714av = false;

    /* renamed from: aw  reason: collision with root package name */
    private f f1715aw;

    /* renamed from: ax  reason: collision with root package name */
    private boolean f1716ax = false;

    /* renamed from: ay  reason: collision with root package name */
    private RectF f1717ay = new RectF();

    /* renamed from: az  reason: collision with root package name */
    private View f1718az = null;

    /* renamed from: b  reason: collision with root package name */
    q f1719b;

    /* renamed from: c  reason: collision with root package name */
    Interpolator f1720c;

    /* renamed from: d  reason: collision with root package name */
    float f1721d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    int f1722e = -1;

    /* renamed from: f  reason: collision with root package name */
    HashMap<View, n> f1723f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    float f1724g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    float f1725h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    float f1726i = 0.0f;

    /* renamed from: j  reason: collision with root package name */
    boolean f1727j = false;

    /* renamed from: k  reason: collision with root package name */
    boolean f1728k = false;

    /* renamed from: l  reason: collision with root package name */
    int f1729l = 0;

    /* renamed from: m  reason: collision with root package name */
    b f1730m;

    /* renamed from: n  reason: collision with root package name */
    boolean f1731n = true;

    /* renamed from: o  reason: collision with root package name */
    int f1732o;

    /* renamed from: p  reason: collision with root package name */
    int f1733p;

    /* renamed from: q  reason: collision with root package name */
    int f1734q;

    /* renamed from: r  reason: collision with root package name */
    int f1735r;

    /* renamed from: s  reason: collision with root package name */
    boolean f1736s = false;

    /* renamed from: t  reason: collision with root package name */
    float f1737t;

    /* renamed from: u  reason: collision with root package name */
    float f1738u;

    /* renamed from: v  reason: collision with root package name */
    long f1739v;

    /* renamed from: w  reason: collision with root package name */
    float f1740w;

    /* renamed from: x  reason: collision with root package name */
    boolean f1741x = false;

    /* renamed from: y  reason: collision with root package name */
    protected boolean f1742y = false;

    /* renamed from: z  reason: collision with root package name */
    int f1743z;

    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1746a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState[] r0 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1746a = r0
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r1 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.UNDEFINED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f1746a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r1 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.SETUP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f1746a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r1 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f1746a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r1 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.AnonymousClass2.<clinit>():void");
        }
    }

    enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    class a extends o {

        /* renamed from: a  reason: collision with root package name */
        float f1752a = 0.0f;

        /* renamed from: b  reason: collision with root package name */
        float f1753b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        float f1754c;

        a() {
        }

        public float a() {
            return MotionLayout.this.f1721d;
        }

        public void a(float f2, float f3, float f4) {
            this.f1752a = f2;
            this.f1753b = f3;
            this.f1754c = f4;
        }

        public float getInterpolation(float f2) {
            float f3;
            float f4 = this.f1752a;
            if (f4 > 0.0f) {
                float f5 = this.f1754c;
                if (f4 / f5 < f2) {
                    f2 = f4 / f5;
                }
                MotionLayout.this.f1721d = f4 - (f5 * f2);
                f3 = (this.f1752a * f2) - (((this.f1754c * f2) * f2) / 2.0f);
            } else {
                float f6 = this.f1754c;
                if ((-f4) / f6 < f2) {
                    f2 = (-f4) / f6;
                }
                MotionLayout.this.f1721d = f4 + (f6 * f2);
                f3 = (this.f1752a * f2) + (((this.f1754c * f2) * f2) / 2.0f);
            }
            return f3 + this.f1753b;
        }
    }

    private class b {

        /* renamed from: a  reason: collision with root package name */
        float[] f1756a;

        /* renamed from: b  reason: collision with root package name */
        int[] f1757b;

        /* renamed from: c  reason: collision with root package name */
        float[] f1758c;

        /* renamed from: d  reason: collision with root package name */
        Path f1759d;

        /* renamed from: e  reason: collision with root package name */
        Paint f1760e;

        /* renamed from: f  reason: collision with root package name */
        Paint f1761f;

        /* renamed from: g  reason: collision with root package name */
        Paint f1762g;

        /* renamed from: h  reason: collision with root package name */
        Paint f1763h;

        /* renamed from: i  reason: collision with root package name */
        Paint f1764i;

        /* renamed from: j  reason: collision with root package name */
        final int f1765j = -21965;

        /* renamed from: k  reason: collision with root package name */
        final int f1766k = -2067046;

        /* renamed from: l  reason: collision with root package name */
        final int f1767l = -13391360;

        /* renamed from: m  reason: collision with root package name */
        final int f1768m = 1996488704;

        /* renamed from: n  reason: collision with root package name */
        final int f1769n = 10;

        /* renamed from: o  reason: collision with root package name */
        DashPathEffect f1770o;

        /* renamed from: p  reason: collision with root package name */
        int f1771p;

        /* renamed from: q  reason: collision with root package name */
        Rect f1772q = new Rect();

        /* renamed from: r  reason: collision with root package name */
        boolean f1773r = false;

        /* renamed from: s  reason: collision with root package name */
        int f1774s = 1;

        /* renamed from: u  reason: collision with root package name */
        private float[] f1776u;

        public b() {
            Paint paint = new Paint();
            this.f1760e = paint;
            paint.setAntiAlias(true);
            this.f1760e.setColor(-21965);
            this.f1760e.setStrokeWidth(2.0f);
            this.f1760e.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.f1761f = paint2;
            paint2.setAntiAlias(true);
            this.f1761f.setColor(-2067046);
            this.f1761f.setStrokeWidth(2.0f);
            this.f1761f.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint();
            this.f1762g = paint3;
            paint3.setAntiAlias(true);
            this.f1762g.setColor(-13391360);
            this.f1762g.setStrokeWidth(2.0f);
            this.f1762g.setStyle(Paint.Style.STROKE);
            Paint paint4 = new Paint();
            this.f1763h = paint4;
            paint4.setAntiAlias(true);
            this.f1763h.setColor(-13391360);
            this.f1763h.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.f1776u = new float[8];
            Paint paint5 = new Paint();
            this.f1764i = paint5;
            paint5.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.f1770o = dashPathEffect;
            this.f1762g.setPathEffect(dashPathEffect);
            this.f1758c = new float[100];
            this.f1757b = new int[50];
            if (this.f1773r) {
                this.f1760e.setStrokeWidth(8.0f);
                this.f1764i.setStrokeWidth(8.0f);
                this.f1761f.setStrokeWidth(8.0f);
                this.f1774s = 4;
            }
        }

        private void a(Canvas canvas) {
            canvas.drawLines(this.f1756a, this.f1760e);
        }

        private void a(Canvas canvas, float f2, float f3) {
            float[] fArr = this.f1756a;
            float f4 = fArr[0];
            float f5 = fArr[1];
            float f6 = fArr[fArr.length - 2];
            float f7 = fArr[fArr.length - 1];
            float hypot = (float) Math.hypot((double) (f4 - f6), (double) (f5 - f7));
            float f8 = f6 - f4;
            float f9 = f7 - f5;
            float f10 = (((f2 - f4) * f8) + ((f3 - f5) * f9)) / (hypot * hypot);
            float f11 = f4 + (f8 * f10);
            float f12 = f5 + (f10 * f9);
            Path path = new Path();
            path.moveTo(f2, f3);
            path.lineTo(f11, f12);
            float hypot2 = (float) Math.hypot((double) (f11 - f2), (double) (f12 - f3));
            String str = "" + (((float) ((int) ((hypot2 * 100.0f) / hypot))) / 100.0f);
            a(str, this.f1763h);
            canvas.drawTextOnPath(str, path, (hypot2 / 2.0f) - ((float) (this.f1772q.width() / 2)), -20.0f, this.f1763h);
            canvas.drawLine(f2, f3, f11, f12, this.f1762g);
        }

        private void a(Canvas canvas, float f2, float f3, float f4, float f5) {
            canvas.drawRect(f2, f3, f4, f5, this.f1762g);
            canvas.drawLine(f2, f3, f4, f5, this.f1762g);
        }

        private void a(Canvas canvas, float f2, float f3, int i2, int i3) {
            Canvas canvas2 = canvas;
            StringBuilder sb = new StringBuilder();
            sb.append("");
            double width = (double) (((f2 - ((float) (i2 / 2))) * 100.0f) / ((float) (MotionLayout.this.getWidth() - i2)));
            Double.isNaN(width);
            sb.append(((float) ((int) (width + 0.5d))) / 100.0f);
            String sb2 = sb.toString();
            a(sb2, this.f1763h);
            canvas2.drawText(sb2, ((f2 / 2.0f) - ((float) (this.f1772q.width() / 2))) + 0.0f, f3 - 20.0f, this.f1763h);
            canvas.drawLine(f2, f3, Math.min(0.0f, 1.0f), f3, this.f1762g);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("");
            double height = (double) (((f3 - ((float) (i3 / 2))) * 100.0f) / ((float) (MotionLayout.this.getHeight() - i3)));
            Double.isNaN(height);
            sb3.append(((float) ((int) (height + 0.5d))) / 100.0f);
            String sb4 = sb3.toString();
            a(sb4, this.f1763h);
            canvas2.drawText(sb4, f2 + 5.0f, 0.0f - ((f3 / 2.0f) - ((float) (this.f1772q.height() / 2))), this.f1763h);
            canvas.drawLine(f2, f3, f2, Math.max(0.0f, 1.0f), this.f1762g);
        }

        private void a(Canvas canvas, n nVar) {
            this.f1759d.reset();
            for (int i2 = 0; i2 <= 50; i2++) {
                nVar.a(((float) i2) / ((float) 50), this.f1776u, 0);
                Path path = this.f1759d;
                float[] fArr = this.f1776u;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.f1759d;
                float[] fArr2 = this.f1776u;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.f1759d;
                float[] fArr3 = this.f1776u;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.f1759d;
                float[] fArr4 = this.f1776u;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.f1759d.close();
            }
            this.f1760e.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.f1759d, this.f1760e);
            canvas.translate(-2.0f, -2.0f);
            this.f1760e.setColor(-65536);
            canvas.drawPath(this.f1759d, this.f1760e);
        }

        private void b(Canvas canvas) {
            float[] fArr = this.f1756a;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.f1762g);
        }

        private void b(Canvas canvas, float f2, float f3) {
            Canvas canvas2 = canvas;
            float[] fArr = this.f1756a;
            float f4 = fArr[0];
            float f5 = fArr[1];
            float f6 = fArr[fArr.length - 2];
            float f7 = fArr[fArr.length - 1];
            float min = Math.min(f4, f6);
            float max = Math.max(f5, f7);
            float min2 = f2 - Math.min(f4, f6);
            float max2 = Math.max(f5, f7) - f3;
            StringBuilder sb = new StringBuilder();
            sb.append("");
            double abs = (double) ((min2 * 100.0f) / Math.abs(f6 - f4));
            Double.isNaN(abs);
            sb.append(((float) ((int) (abs + 0.5d))) / 100.0f);
            String sb2 = sb.toString();
            a(sb2, this.f1763h);
            canvas2.drawText(sb2, ((min2 / 2.0f) - ((float) (this.f1772q.width() / 2))) + min, f3 - 20.0f, this.f1763h);
            canvas.drawLine(f2, f3, Math.min(f4, f6), f3, this.f1762g);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("");
            double abs2 = (double) ((max2 * 100.0f) / Math.abs(f7 - f5));
            Double.isNaN(abs2);
            sb3.append(((float) ((int) (abs2 + 0.5d))) / 100.0f);
            String sb4 = sb3.toString();
            a(sb4, this.f1763h);
            canvas2.drawText(sb4, f2 + 5.0f, max - ((max2 / 2.0f) - ((float) (this.f1772q.height() / 2))), this.f1763h);
            canvas.drawLine(f2, f3, f2, Math.max(f5, f7), this.f1762g);
        }

        private void b(Canvas canvas, int i2, int i3, n nVar) {
            int i4;
            int i5;
            float f2;
            float f3;
            int i6;
            Canvas canvas2 = canvas;
            int i7 = i2;
            n nVar2 = nVar;
            if (nVar2.f1954a != null) {
                i5 = nVar2.f1954a.getWidth();
                i4 = nVar2.f1954a.getHeight();
            } else {
                i5 = 0;
                i4 = 0;
            }
            for (int i8 = 1; i8 < i3 - 1; i8++) {
                if (i7 != 4 || this.f1757b[i8 - 1] != 0) {
                    float[] fArr = this.f1758c;
                    int i9 = i8 * 2;
                    float f4 = fArr[i9];
                    float f5 = fArr[i9 + 1];
                    this.f1759d.reset();
                    this.f1759d.moveTo(f4, f5 + 10.0f);
                    this.f1759d.lineTo(f4 + 10.0f, f5);
                    this.f1759d.lineTo(f4, f5 - 10.0f);
                    this.f1759d.lineTo(f4 - 10.0f, f5);
                    this.f1759d.close();
                    int i10 = i8 - 1;
                    nVar2.a(i10);
                    if (i7 == 4) {
                        int[] iArr = this.f1757b;
                        if (iArr[i10] == 1) {
                            a(canvas2, f4 - 0.0f, f5 - 0.0f);
                        } else if (iArr[i10] == 2) {
                            b(canvas2, f4 - 0.0f, f5 - 0.0f);
                        } else if (iArr[i10] == 3) {
                            i6 = 3;
                            f3 = f5;
                            f2 = f4;
                            a(canvas, f4 - 0.0f, f5 - 0.0f, i5, i4);
                            canvas2.drawPath(this.f1759d, this.f1764i);
                        }
                        f3 = f5;
                        f2 = f4;
                        i6 = 3;
                        canvas2.drawPath(this.f1759d, this.f1764i);
                    } else {
                        f3 = f5;
                        f2 = f4;
                        i6 = 3;
                    }
                    if (i7 == 2) {
                        a(canvas2, f2 - 0.0f, f3 - 0.0f);
                    }
                    if (i7 == i6) {
                        b(canvas2, f2 - 0.0f, f3 - 0.0f);
                    }
                    if (i7 == 6) {
                        a(canvas, f2 - 0.0f, f3 - 0.0f, i5, i4);
                    }
                    canvas2.drawPath(this.f1759d, this.f1764i);
                }
            }
            float[] fArr2 = this.f1756a;
            if (fArr2.length > 1) {
                canvas2.drawCircle(fArr2[0], fArr2[1], 8.0f, this.f1761f);
                float[] fArr3 = this.f1756a;
                canvas2.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.f1761f);
            }
        }

        private void c(Canvas canvas) {
            boolean z2 = false;
            boolean z3 = false;
            for (int i2 = 0; i2 < this.f1771p; i2++) {
                int[] iArr = this.f1757b;
                if (iArr[i2] == 1) {
                    z2 = true;
                }
                if (iArr[i2] == 2) {
                    z3 = true;
                }
            }
            if (z2) {
                b(canvas);
            }
            if (z3) {
                d(canvas);
            }
        }

        private void d(Canvas canvas) {
            float[] fArr = this.f1756a;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[fArr.length - 2];
            float f5 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f2, f4), Math.max(f3, f5), Math.max(f2, f4), Math.max(f3, f5), this.f1762g);
            canvas.drawLine(Math.min(f2, f4), Math.min(f3, f5), Math.min(f2, f4), Math.max(f3, f5), this.f1762g);
        }

        public void a(Canvas canvas, int i2, int i3, n nVar) {
            if (i2 == 4) {
                c(canvas);
            }
            if (i2 == 2) {
                b(canvas);
            }
            if (i2 == 3) {
                d(canvas);
            }
            a(canvas);
            b(canvas, i2, i3, nVar);
        }

        public void a(Canvas canvas, HashMap<View, n> hashMap, int i2, int i3) {
            if (hashMap != null && hashMap.size() != 0) {
                canvas.save();
                if (!MotionLayout.this.isInEditMode() && (i3 & 1) == 2) {
                    String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.T) + ":" + MotionLayout.this.getProgress();
                    canvas.drawText(str, 10.0f, (float) (MotionLayout.this.getHeight() - 30), this.f1763h);
                    canvas.drawText(str, 11.0f, (float) (MotionLayout.this.getHeight() - 29), this.f1760e);
                }
                for (n next : hashMap.values()) {
                    int c2 = next.c();
                    if (i3 > 0 && c2 == 0) {
                        c2 = 1;
                    }
                    if (c2 != 0) {
                        this.f1771p = next.a(this.f1758c, this.f1757b);
                        if (c2 >= 1) {
                            int i4 = i2 / 16;
                            float[] fArr = this.f1756a;
                            if (fArr == null || fArr.length != i4 * 2) {
                                this.f1756a = new float[(i4 * 2)];
                                this.f1759d = new Path();
                            }
                            int i5 = this.f1774s;
                            canvas.translate((float) i5, (float) i5);
                            this.f1760e.setColor(1996488704);
                            this.f1764i.setColor(1996488704);
                            this.f1761f.setColor(1996488704);
                            this.f1762g.setColor(1996488704);
                            next.a(this.f1756a, i4);
                            a(canvas, c2, this.f1771p, next);
                            this.f1760e.setColor(-21965);
                            this.f1761f.setColor(-2067046);
                            this.f1764i.setColor(-2067046);
                            this.f1762g.setColor(-13391360);
                            int i6 = this.f1774s;
                            canvas.translate((float) (-i6), (float) (-i6));
                            a(canvas, c2, this.f1771p, next);
                            if (c2 == 5) {
                                a(canvas, next);
                            }
                        }
                    }
                }
                canvas.restore();
            }
        }

        /* access modifiers changed from: package-private */
        public void a(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.f1772q);
        }
    }

    class c {

        /* renamed from: a  reason: collision with root package name */
        androidx.constraintlayout.solver.widgets.d f1777a = new androidx.constraintlayout.solver.widgets.d();

        /* renamed from: b  reason: collision with root package name */
        androidx.constraintlayout.solver.widgets.d f1778b = new androidx.constraintlayout.solver.widgets.d();

        /* renamed from: c  reason: collision with root package name */
        androidx.constraintlayout.widget.b f1779c = null;

        /* renamed from: d  reason: collision with root package name */
        androidx.constraintlayout.widget.b f1780d = null;

        /* renamed from: e  reason: collision with root package name */
        int f1781e;

        /* renamed from: f  reason: collision with root package name */
        int f1782f;

        c() {
        }

        private void a(androidx.constraintlayout.solver.widgets.d dVar, androidx.constraintlayout.widget.b bVar) {
            SparseArray sparseArray = new SparseArray();
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, dVar);
            sparseArray.put(MotionLayout.this.getId(), dVar);
            Iterator<ConstraintWidget> it2 = dVar.ac().iterator();
            while (it2.hasNext()) {
                ConstraintWidget next = it2.next();
                sparseArray.put(((View) next.M()).getId(), next);
            }
            Iterator<ConstraintWidget> it3 = dVar.ac().iterator();
            while (it3.hasNext()) {
                ConstraintWidget next2 = it3.next();
                View view = (View) next2.M();
                bVar.a(view.getId(), (ConstraintLayout.LayoutParams) layoutParams);
                next2.o(bVar.e(view.getId()));
                next2.p(bVar.d(view.getId()));
                if (view instanceof ConstraintHelper) {
                    bVar.a((ConstraintHelper) view, next2, (ConstraintLayout.LayoutParams) layoutParams, (SparseArray<ConstraintWidget>) sparseArray);
                    if (view instanceof Barrier) {
                        ((Barrier) view).c();
                    }
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                } else {
                    layoutParams.resolveLayoutDirection(0);
                }
                MotionLayout.this.a(false, view, next2, (ConstraintLayout.LayoutParams) layoutParams, (SparseArray<ConstraintWidget>) sparseArray);
                next2.j(bVar.b(view.getId()) == 1 ? view.getVisibility() : bVar.c(view.getId()));
            }
            Iterator<ConstraintWidget> it4 = dVar.ac().iterator();
            while (it4.hasNext()) {
                ConstraintWidget next3 = it4.next();
                if (next3 instanceof j) {
                    androidx.constraintlayout.solver.widgets.g gVar = (androidx.constraintlayout.solver.widgets.g) next3;
                    ((ConstraintHelper) next3.M()).a(dVar, gVar, sparseArray);
                    ((j) gVar).i();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public ConstraintWidget a(androidx.constraintlayout.solver.widgets.d dVar, View view) {
            if (dVar.M() == view) {
                return dVar;
            }
            ArrayList<ConstraintWidget> ac2 = dVar.ac();
            int size = ac2.size();
            for (int i2 = 0; i2 < size; i2++) {
                ConstraintWidget constraintWidget = ac2.get(i2);
                if (constraintWidget.M() == view) {
                    return constraintWidget;
                }
            }
            return null;
        }

        public void a() {
            a(MotionLayout.this.U, MotionLayout.this.V);
            MotionLayout.this.j();
        }

        public void a(int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            MotionLayout.this.D = mode;
            MotionLayout.this.E = mode2;
            int optimizationLevel = MotionLayout.this.getOptimizationLevel();
            if (MotionLayout.this.f1722e == MotionLayout.this.getStartState()) {
                MotionLayout.this.a(this.f1778b, optimizationLevel, i2, i3);
                if (this.f1779c != null) {
                    MotionLayout.this.a(this.f1777a, optimizationLevel, i2, i3);
                }
            } else {
                if (this.f1779c != null) {
                    MotionLayout.this.a(this.f1777a, optimizationLevel, i2, i3);
                }
                MotionLayout.this.a(this.f1778b, optimizationLevel, i2, i3);
            }
            if (((MotionLayout.this.getParent() instanceof MotionLayout) && mode == 1073741824 && mode2 == 1073741824) ? false : true) {
                MotionLayout.this.D = mode;
                MotionLayout.this.E = mode2;
                if (MotionLayout.this.f1722e == MotionLayout.this.getStartState()) {
                    MotionLayout.this.a(this.f1778b, optimizationLevel, i2, i3);
                    if (this.f1779c != null) {
                        MotionLayout.this.a(this.f1777a, optimizationLevel, i2, i3);
                    }
                } else {
                    if (this.f1779c != null) {
                        MotionLayout.this.a(this.f1777a, optimizationLevel, i2, i3);
                    }
                    MotionLayout.this.a(this.f1778b, optimizationLevel, i2, i3);
                }
                MotionLayout.this.f1743z = this.f1777a.A();
                MotionLayout.this.A = this.f1777a.B();
                MotionLayout.this.B = this.f1778b.A();
                MotionLayout.this.C = this.f1778b.B();
                MotionLayout motionLayout = MotionLayout.this;
                motionLayout.f1742y = (motionLayout.f1743z == MotionLayout.this.B && MotionLayout.this.A == MotionLayout.this.C) ? false : true;
            }
            int i4 = MotionLayout.this.f1743z;
            int i5 = MotionLayout.this.A;
            if (MotionLayout.this.D == Integer.MIN_VALUE || MotionLayout.this.D == 0) {
                i4 = (int) (((float) MotionLayout.this.f1743z) + (MotionLayout.this.F * ((float) (MotionLayout.this.B - MotionLayout.this.f1743z))));
            }
            int i6 = i4;
            if (MotionLayout.this.E == Integer.MIN_VALUE || MotionLayout.this.E == 0) {
                i5 = (int) (((float) MotionLayout.this.A) + (MotionLayout.this.F * ((float) (MotionLayout.this.C - MotionLayout.this.A))));
            }
            MotionLayout.this.a(i2, i3, i6, i5, this.f1777a.i() || this.f1778b.i(), this.f1777a.X() || this.f1778b.X());
        }

        /* access modifiers changed from: package-private */
        public void a(androidx.constraintlayout.solver.widgets.d dVar, androidx.constraintlayout.solver.widgets.d dVar2) {
            ArrayList<ConstraintWidget> ac2 = dVar.ac();
            HashMap hashMap = new HashMap();
            hashMap.put(dVar, dVar2);
            dVar2.ac().clear();
            dVar2.a((ConstraintWidget) dVar, (HashMap<ConstraintWidget, ConstraintWidget>) hashMap);
            Iterator<ConstraintWidget> it2 = ac2.iterator();
            while (it2.hasNext()) {
                ConstraintWidget next = it2.next();
                ConstraintWidget aVar = next instanceof androidx.constraintlayout.solver.widgets.a ? new androidx.constraintlayout.solver.widgets.a() : next instanceof androidx.constraintlayout.solver.widgets.f ? new androidx.constraintlayout.solver.widgets.f() : next instanceof androidx.constraintlayout.solver.widgets.e ? new androidx.constraintlayout.solver.widgets.e() : next instanceof androidx.constraintlayout.solver.widgets.g ? new h() : new ConstraintWidget();
                dVar2.b(aVar);
                hashMap.put(next, aVar);
            }
            Iterator<ConstraintWidget> it3 = ac2.iterator();
            while (it3.hasNext()) {
                ConstraintWidget next2 = it3.next();
                ((ConstraintWidget) hashMap.get(next2)).a(next2, (HashMap<ConstraintWidget, ConstraintWidget>) hashMap);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(androidx.constraintlayout.solver.widgets.d dVar, androidx.constraintlayout.widget.b bVar, androidx.constraintlayout.widget.b bVar2) {
            this.f1779c = bVar;
            this.f1780d = bVar2;
            this.f1777a = new androidx.constraintlayout.solver.widgets.d();
            this.f1778b = new androidx.constraintlayout.solver.widgets.d();
            this.f1777a.a(MotionLayout.this.K.g());
            this.f1778b.a(MotionLayout.this.K.g());
            this.f1777a.ad();
            this.f1778b.ad();
            a(MotionLayout.this.K, this.f1777a);
            a(MotionLayout.this.K, this.f1778b);
            if (((double) MotionLayout.this.f1725h) > 0.5d) {
                if (bVar != null) {
                    a(this.f1777a, bVar);
                }
                a(this.f1778b, bVar2);
            } else {
                a(this.f1778b, bVar2);
                if (bVar != null) {
                    a(this.f1777a, bVar);
                }
            }
            this.f1777a.g(MotionLayout.this.h());
            this.f1777a.f();
            this.f1778b.g(MotionLayout.this.h());
            this.f1778b.f();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    this.f1777a.a(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                    this.f1778b.a(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                }
                if (layoutParams.height == -2) {
                    this.f1777a.b(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                    this.f1778b.b(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                }
            }
        }

        public void b() {
            int childCount = MotionLayout.this.getChildCount();
            MotionLayout.this.f1723f.clear();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = MotionLayout.this.getChildAt(i2);
                MotionLayout.this.f1723f.put(childAt, new n(childAt));
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt2 = MotionLayout.this.getChildAt(i3);
                n nVar = MotionLayout.this.f1723f.get(childAt2);
                if (nVar != null) {
                    if (this.f1779c != null) {
                        ConstraintWidget a2 = a(this.f1777a, childAt2);
                        if (a2 != null) {
                            nVar.a(a2, this.f1779c);
                        } else if (MotionLayout.this.f1729l != 0) {
                            Log.e("MotionLayout", a.a() + "no widget for  " + a.a(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    }
                    if (this.f1780d != null) {
                        ConstraintWidget a3 = a(this.f1778b, childAt2);
                        if (a3 != null) {
                            nVar.b(a3, this.f1780d);
                        } else if (MotionLayout.this.f1729l != 0) {
                            Log.e("MotionLayout", a.a() + "no widget for  " + a.a(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    }
                }
            }
        }

        public void b(int i2, int i3) {
            this.f1781e = i2;
            this.f1782f = i3;
        }

        public boolean c(int i2, int i3) {
            return (i2 == this.f1781e && i3 == this.f1782f) ? false : true;
        }
    }

    protected interface d {
        void a();

        void a(int i2);

        void a(MotionEvent motionEvent);

        float b();

        float c();
    }

    private static class e implements d {

        /* renamed from: b  reason: collision with root package name */
        private static e f1784b = new e();

        /* renamed from: a  reason: collision with root package name */
        VelocityTracker f1785a;

        private e() {
        }

        public static e d() {
            f1784b.f1785a = VelocityTracker.obtain();
            return f1784b;
        }

        public void a() {
            VelocityTracker velocityTracker = this.f1785a;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f1785a = null;
            }
        }

        public void a(int i2) {
            VelocityTracker velocityTracker = this.f1785a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i2);
            }
        }

        public void a(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.f1785a;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        public float b() {
            VelocityTracker velocityTracker = this.f1785a;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        public float c() {
            VelocityTracker velocityTracker = this.f1785a;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }
    }

    class f {

        /* renamed from: a  reason: collision with root package name */
        float f1786a = Float.NaN;

        /* renamed from: b  reason: collision with root package name */
        float f1787b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        int f1788c = -1;

        /* renamed from: d  reason: collision with root package name */
        int f1789d = -1;

        /* renamed from: e  reason: collision with root package name */
        final String f1790e = "motion.progress";

        /* renamed from: f  reason: collision with root package name */
        final String f1791f = "motion.velocity";

        /* renamed from: g  reason: collision with root package name */
        final String f1792g = "motion.StartState";

        /* renamed from: h  reason: collision with root package name */
        final String f1793h = "motion.EndState";

        f() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int i2 = this.f1788c;
            if (!(i2 == -1 && this.f1789d == -1)) {
                if (i2 == -1) {
                    MotionLayout.this.a(this.f1789d);
                } else {
                    int i3 = this.f1789d;
                    if (i3 == -1) {
                        MotionLayout.this.a(i2, -1, -1);
                    } else {
                        MotionLayout.this.a(i2, i3);
                    }
                }
                MotionLayout.this.setState(TransitionState.SETUP);
            }
            if (!Float.isNaN(this.f1787b)) {
                MotionLayout.this.a(this.f1786a, this.f1787b);
                this.f1786a = Float.NaN;
                this.f1787b = Float.NaN;
                this.f1788c = -1;
                this.f1789d = -1;
            } else if (!Float.isNaN(this.f1786a)) {
                MotionLayout.this.setProgress(this.f1786a);
            }
        }

        public void a(float f2) {
            this.f1786a = f2;
        }

        public void a(int i2) {
            this.f1789d = i2;
        }

        public void a(Bundle bundle) {
            this.f1786a = bundle.getFloat("motion.progress");
            this.f1787b = bundle.getFloat("motion.velocity");
            this.f1788c = bundle.getInt("motion.StartState");
            this.f1789d = bundle.getInt("motion.EndState");
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.f1786a);
            bundle.putFloat("motion.velocity", this.f1787b);
            bundle.putInt("motion.StartState", this.f1788c);
            bundle.putInt("motion.EndState", this.f1789d);
            return bundle;
        }

        public void b(float f2) {
            this.f1787b = f2;
        }

        public void b(int i2) {
            this.f1788c = i2;
        }

        public void c() {
            this.f1789d = MotionLayout.this.T;
            this.f1788c = MotionLayout.this.S;
            this.f1787b = MotionLayout.this.getVelocity();
            this.f1786a = MotionLayout.this.getProgress();
        }
    }

    public interface g {
        void a(MotionLayout motionLayout, int i2);

        void a(MotionLayout motionLayout, int i2, int i3);

        void a(MotionLayout motionLayout, int i2, int i3, float f2);

        void a(MotionLayout motionLayout, int i2, boolean z2, float f2);
    }

    public MotionLayout(Context context) {
        super(context);
        b((AttributeSet) null);
    }

    public MotionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(attributeSet);
    }

    public MotionLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b(attributeSet);
    }

    private void a(int i2, androidx.constraintlayout.widget.b bVar) {
        String a2 = a.a(getContext(), i2);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int id2 = childAt.getId();
            if (id2 == -1) {
                Log.w("MotionLayout", "CHECK: " + a2 + " ALL VIEWS SHOULD HAVE ID's " + childAt.getClass().getName() + " does not!");
            }
            if (bVar.f(id2) == null) {
                Log.w("MotionLayout", "CHECK: " + a2 + " NO CONSTRAINTS for " + a.a(childAt));
            }
        }
        int[] a3 = bVar.a();
        for (int i4 = 0; i4 < a3.length; i4++) {
            int i5 = a3[i4];
            String a4 = a.a(getContext(), i5);
            if (findViewById(a3[i4]) == null) {
                Log.w("MotionLayout", "CHECK: " + a2 + " NO View matches id " + a4);
            }
            if (bVar.d(i5) == -1) {
                Log.w("MotionLayout", "CHECK: " + a2 + "(" + a4 + ") no LAYOUT_HEIGHT");
            }
            if (bVar.e(i5) == -1) {
                Log.w("MotionLayout", "CHECK: " + a2 + "(" + a4 + ") no LAYOUT_HEIGHT");
            }
        }
    }

    private void a(q.a aVar) {
        Log.v("MotionLayout", "CHECK: transition = " + aVar.a(getContext()));
        Log.v("MotionLayout", "CHECK: transition.setDuration = " + aVar.e());
        if (aVar.d() == aVar.c()) {
            Log.e("MotionLayout", "CHECK: start and end constraint set should not be the same!");
        }
    }

    private static boolean a(float f2, float f3, float f4) {
        if (f2 > 0.0f) {
            float f5 = f2 / f4;
            return f3 + ((f2 * f5) - (((f4 * f5) * f5) / 2.0f)) > 1.0f;
        }
        float f6 = (-f2) / f4;
        return f3 + ((f2 * f6) + (((f4 * f6) * f6) / 2.0f)) < 0.0f;
    }

    private boolean a(float f2, float f3, View view, MotionEvent motionEvent) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                if (a(((float) view.getLeft()) + f2, ((float) view.getTop()) + f3, viewGroup.getChildAt(i2), motionEvent)) {
                    return true;
                }
            }
        }
        this.f1717ay.set(((float) view.getLeft()) + f2, ((float) view.getTop()) + f3, f2 + ((float) view.getRight()), f3 + ((float) view.getBottom()));
        if (motionEvent.getAction() == 0) {
            return this.f1717ay.contains(motionEvent.getX(), motionEvent.getY()) && view.onTouchEvent(motionEvent);
        }
        if (view.onTouchEvent(motionEvent)) {
            return true;
        }
    }

    private void b(AttributeSet attributeSet) {
        q qVar;
        int i2;
        f1692a = isInEditMode();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionLayout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z2 = true;
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.MotionLayout_layoutDescription) {
                    this.f1719b = new q(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == R.styleable.MotionLayout_currentState) {
                    this.f1722e = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == R.styleable.MotionLayout_motionProgress) {
                    this.f1726i = obtainStyledAttributes.getFloat(index, 0.0f);
                    this.f1727j = true;
                } else if (index == R.styleable.MotionLayout_applyMotionScene) {
                    z2 = obtainStyledAttributes.getBoolean(index, z2);
                } else {
                    if (index == R.styleable.MotionLayout_showPaths) {
                        if (this.f1729l == 0) {
                            i2 = obtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                        }
                    } else if (index == R.styleable.MotionLayout_motionDebug) {
                        i2 = obtainStyledAttributes.getInt(index, 0);
                    }
                    this.f1729l = i2;
                }
            }
            obtainStyledAttributes.recycle();
            if (this.f1719b == null) {
                Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
            }
            if (!z2) {
                this.f1719b = null;
            }
        }
        if (this.f1729l != 0) {
            m();
        }
        if (this.f1722e == -1 && (qVar = this.f1719b) != null) {
            this.f1722e = qVar.d();
            this.S = this.f1719b.d();
            this.T = this.f1719b.e();
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        int childCount = getChildCount();
        this.H.b();
        boolean z2 = true;
        this.f1727j = true;
        int width = getWidth();
        int height = getHeight();
        int h2 = this.f1719b.h();
        int i2 = 0;
        if (h2 != -1) {
            for (int i3 = 0; i3 < childCount; i3++) {
                n nVar = this.f1723f.get(getChildAt(i3));
                if (nVar != null) {
                    nVar.b(h2);
                }
            }
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            n nVar2 = this.f1723f.get(getChildAt(i4));
            if (nVar2 != null) {
                this.f1719b.a(nVar2);
                nVar2.a(width, height, this.f1694ab, getNanoTime());
            }
        }
        float i5 = this.f1719b.i();
        if (i5 != 0.0f) {
            boolean z3 = ((double) i5) < i.f27244a;
            float abs = Math.abs(i5);
            float f2 = -3.4028235E38f;
            float f3 = Float.MAX_VALUE;
            int i6 = 0;
            float f4 = Float.MAX_VALUE;
            float f5 = -3.4028235E38f;
            while (true) {
                if (i6 >= childCount) {
                    z2 = false;
                    break;
                }
                n nVar3 = this.f1723f.get(getChildAt(i6));
                if (!Float.isNaN(nVar3.f1957d)) {
                    break;
                }
                float a2 = nVar3.a();
                float b2 = nVar3.b();
                float f6 = z3 ? b2 - a2 : b2 + a2;
                f4 = Math.min(f4, f6);
                f5 = Math.max(f5, f6);
                i6++;
            }
            if (z2) {
                for (int i7 = 0; i7 < childCount; i7++) {
                    n nVar4 = this.f1723f.get(getChildAt(i7));
                    if (!Float.isNaN(nVar4.f1957d)) {
                        f3 = Math.min(f3, nVar4.f1957d);
                        f2 = Math.max(f2, nVar4.f1957d);
                    }
                }
                while (i2 < childCount) {
                    n nVar5 = this.f1723f.get(getChildAt(i2));
                    if (!Float.isNaN(nVar5.f1957d)) {
                        nVar5.f1959f = 1.0f / (1.0f - abs);
                        float f7 = nVar5.f1957d;
                        nVar5.f1958e = abs - (z3 ? ((f2 - f7) / (f2 - f3)) * abs : ((f7 - f3) * abs) / (f2 - f3));
                    }
                    i2++;
                }
                return;
            }
            while (i2 < childCount) {
                n nVar6 = this.f1723f.get(getChildAt(i2));
                float a3 = nVar6.a();
                float b3 = nVar6.b();
                float f8 = z3 ? b3 - a3 : b3 + a3;
                nVar6.f1959f = 1.0f / (1.0f - abs);
                nVar6.f1958e = abs - (((f8 - f4) * abs) / (f5 - f4));
                i2++;
            }
        }
    }

    private void k() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            n nVar = this.f1723f.get(childAt);
            if (nVar != null) {
                nVar.b(childAt);
            }
        }
    }

    private void l() {
        boolean z2;
        float signum = Math.signum(this.f1726i - this.f1725h);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.f1720c;
        float f2 = this.f1725h + (!(interpolator instanceof k.g) ? ((((float) (nanoTime - this.f1695ac)) * signum) * 1.0E-9f) / this.f1694ab : 0.0f);
        if (this.f1696ad) {
            f2 = this.f1726i;
        }
        if ((signum <= 0.0f || f2 < this.f1726i) && (signum > 0.0f || f2 > this.f1726i)) {
            z2 = false;
        } else {
            f2 = this.f1726i;
            z2 = true;
        }
        if (interpolator != null && !z2) {
            f2 = this.f1700ah ? interpolator.getInterpolation(((float) (nanoTime - this.f1693aa)) * 1.0E-9f) : interpolator.getInterpolation(f2);
        }
        if ((signum > 0.0f && f2 >= this.f1726i) || (signum <= 0.0f && f2 <= this.f1726i)) {
            f2 = this.f1726i;
        }
        this.F = f2;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            n nVar = this.f1723f.get(childAt);
            if (nVar != null) {
                nVar.a(childAt, f2, nanoTime2, this.f1713au);
            }
        }
        if (this.f1742y) {
            requestLayout();
        }
    }

    private void m() {
        q qVar = this.f1719b;
        if (qVar == null) {
            Log.e("MotionLayout", "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }
        int d2 = qVar.d();
        q qVar2 = this.f1719b;
        a(d2, qVar2.c(qVar2.d()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        Iterator<q.a> it2 = this.f1719b.a().iterator();
        while (it2.hasNext()) {
            q.a next = it2.next();
            if (next == this.f1719b.f1997b) {
                Log.v("MotionLayout", "CHECK: CURRENT");
            }
            a(next);
            int d3 = next.d();
            int c2 = next.c();
            String a2 = a.a(getContext(), d3);
            String a3 = a.a(getContext(), c2);
            if (sparseIntArray.get(d3) == c2) {
                Log.e("MotionLayout", "CHECK: two transitions with the same start and end " + a2 + "->" + a3);
            }
            if (sparseIntArray2.get(c2) == d3) {
                Log.e("MotionLayout", "CHECK: you can't have reverse transitions" + a2 + "->" + a3);
            }
            sparseIntArray.put(d3, c2);
            sparseIntArray2.put(c2, d3);
            if (this.f1719b.c(d3) == null) {
                Log.e("MotionLayout", " no such constraintSetStart " + a2);
            }
            if (this.f1719b.c(c2) == null) {
                Log.e("MotionLayout", " no such constraintSetEnd " + a2);
            }
        }
    }

    private void n() {
        ArrayList<g> arrayList;
        if ((this.f1697ae != null || ((arrayList = this.f1707ao) != null && !arrayList.isEmpty())) && this.f1712at != this.f1724g) {
            if (this.f1711as != -1) {
                g gVar = this.f1697ae;
                if (gVar != null) {
                    gVar.a(this, this.S, this.T);
                }
                ArrayList<g> arrayList2 = this.f1707ao;
                if (arrayList2 != null) {
                    Iterator<g> it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        it2.next().a(this, this.S, this.T);
                    }
                }
                this.f1741x = true;
            }
            this.f1711as = -1;
            float f2 = this.f1724g;
            this.f1712at = f2;
            g gVar2 = this.f1697ae;
            if (gVar2 != null) {
                gVar2.a(this, this.S, this.T, f2);
            }
            ArrayList<g> arrayList3 = this.f1707ao;
            if (arrayList3 != null) {
                Iterator<g> it3 = arrayList3.iterator();
                while (it3.hasNext()) {
                    it3.next().a(this, this.S, this.T, this.f1724g);
                }
            }
            this.f1741x = true;
        }
    }

    private void o() {
        ArrayList<g> arrayList;
        if (this.f1697ae != null || ((arrayList = this.f1707ao) != null && !arrayList.isEmpty())) {
            this.f1741x = false;
            Iterator<Integer> it2 = this.I.iterator();
            while (it2.hasNext()) {
                Integer next = it2.next();
                g gVar = this.f1697ae;
                if (gVar != null) {
                    gVar.a(this, next.intValue());
                }
                ArrayList<g> arrayList2 = this.f1707ao;
                if (arrayList2 != null) {
                    Iterator<g> it3 = arrayList2.iterator();
                    while (it3.hasNext()) {
                        it3.next().a(this, next.intValue());
                    }
                }
            }
            this.I.clear();
        }
    }

    /* access modifiers changed from: protected */
    public d a() {
        return e.d();
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        q qVar = this.f1719b;
        if (qVar != null) {
            float f3 = this.f1725h;
            float f4 = this.f1724g;
            if (f3 != f4 && this.f1696ad) {
                this.f1725h = f4;
            }
            float f5 = this.f1725h;
            if (f5 != f2) {
                this.f1700ah = false;
                this.f1726i = f2;
                this.f1694ab = ((float) qVar.g()) / 1000.0f;
                setProgress(this.f1726i);
                this.f1720c = this.f1719b.f();
                this.f1696ad = false;
                this.f1693aa = getNanoTime();
                this.f1727j = true;
                this.f1724g = f5;
                this.f1725h = f5;
                invalidate();
            }
        }
    }

    public void a(float f2, float f3) {
        if (!isAttachedToWindow()) {
            if (this.f1715aw == null) {
                this.f1715aw = new f();
            }
            this.f1715aw.a(f2);
            this.f1715aw.b(f3);
            return;
        }
        setProgress(f2);
        setState(TransitionState.MOVING);
        this.f1721d = f3;
        a(1.0f);
    }

    public void a(int i2) {
        if (!isAttachedToWindow()) {
            if (this.f1715aw == null) {
                this.f1715aw = new f();
            }
            this.f1715aw.a(i2);
            return;
        }
        b(i2, -1, -1);
    }

    public void a(int i2, float f2, float f3) {
        Interpolator interpolator;
        if (this.f1719b != null && this.f1725h != f2) {
            this.f1700ah = true;
            this.f1693aa = getNanoTime();
            float g2 = ((float) this.f1719b.g()) / 1000.0f;
            this.f1694ab = g2;
            this.f1726i = f2;
            this.f1727j = true;
            if (i2 == 0 || i2 == 1 || i2 == 2) {
                if (i2 == 1) {
                    f2 = 0.0f;
                } else if (i2 == 2) {
                    f2 = 1.0f;
                }
                this.f1701ai.a(this.f1725h, f2, f3, g2, this.f1719b.j(), this.f1719b.k());
            } else {
                if (i2 != 4) {
                    if (i2 == 5) {
                        if (!a(f3, this.f1725h, this.f1719b.j())) {
                            this.f1701ai.a(this.f1725h, f2, f3, this.f1694ab, this.f1719b.j(), this.f1719b.k());
                            this.f1721d = 0.0f;
                        }
                    }
                    this.f1696ad = false;
                    this.f1693aa = getNanoTime();
                    invalidate();
                }
                this.f1702aj.a(f3, this.f1725h, this.f1719b.j());
                interpolator = this.f1702aj;
                this.f1720c = interpolator;
                this.f1696ad = false;
                this.f1693aa = getNanoTime();
                invalidate();
            }
            int i3 = this.f1722e;
            this.f1726i = f2;
            this.f1722e = i3;
            interpolator = this.f1701ai;
            this.f1720c = interpolator;
            this.f1696ad = false;
            this.f1693aa = getNanoTime();
            invalidate();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, float f2, float f3, float f4, float[] fArr) {
        String str;
        HashMap<View, n> hashMap = this.f1723f;
        View d2 = d(i2);
        n nVar = hashMap.get(d2);
        if (nVar != null) {
            nVar.a(f2, f3, f4, fArr);
            float y2 = d2.getY();
            int i3 = ((f2 - this.f1698af) > 0.0f ? 1 : ((f2 - this.f1698af) == 0.0f ? 0 : -1));
            this.f1698af = f2;
            this.f1699ag = y2;
            return;
        }
        if (d2 == null) {
            str = "" + i2;
        } else {
            str = d2.getContext().getResources().getResourceName(i2);
        }
        Log.w("MotionLayout", "WARNING could not find view id " + str);
    }

    public void a(int i2, int i3) {
        if (!isAttachedToWindow()) {
            if (this.f1715aw == null) {
                this.f1715aw = new f();
            }
            this.f1715aw.b(i2);
            this.f1715aw.a(i3);
            return;
        }
        q qVar = this.f1719b;
        if (qVar != null) {
            this.S = i2;
            this.T = i3;
            qVar.a(i2, i3);
            this.H.a(this.K, this.f1719b.c(i2), this.f1719b.c(i3));
            f();
            this.f1725h = 0.0f;
            b();
        }
    }

    public void a(int i2, int i3, int i4) {
        setState(TransitionState.SETUP);
        this.f1722e = i2;
        this.S = -1;
        this.T = -1;
        if (this.M != null) {
            this.M.a(i2, (float) i3, (float) i4);
            return;
        }
        q qVar = this.f1719b;
        if (qVar != null) {
            qVar.c(i2).c((ConstraintLayout) this);
        }
    }

    public void a(int i2, boolean z2, float f2) {
        g gVar = this.f1697ae;
        if (gVar != null) {
            gVar.a(this, i2, z2, f2);
        }
        ArrayList<g> arrayList = this.f1707ao;
        if (arrayList != null) {
            Iterator<g> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next().a(this, i2, z2, f2);
            }
        }
    }

    public void a(View view, float f2, float f3, float[] fArr, int i2) {
        float f4;
        float f5 = this.f1721d;
        float f6 = this.f1725h;
        if (this.f1720c != null) {
            float signum = Math.signum(this.f1726i - f6);
            float interpolation = this.f1720c.getInterpolation(this.f1725h + 1.0E-5f);
            float interpolation2 = this.f1720c.getInterpolation(this.f1725h);
            f5 = (signum * ((interpolation - interpolation2) / 1.0E-5f)) / this.f1694ab;
            f4 = interpolation2;
        } else {
            f4 = f6;
        }
        Interpolator interpolator = this.f1720c;
        if (interpolator instanceof o) {
            f5 = ((o) interpolator).a();
        }
        n nVar = this.f1723f.get(view);
        if ((i2 & 1) == 0) {
            nVar.a(f4, view.getWidth(), view.getHeight(), f2, f3, fArr);
        } else {
            nVar.a(f4, f2, f3, fArr);
        }
        if (i2 < 2) {
            fArr[0] = fArr[0] * f5;
            fArr[1] = fArr[1] * f5;
        }
    }

    public void a(View view, int i2) {
        q qVar = this.f1719b;
        if (qVar != null) {
            float f2 = this.f1737t;
            float f3 = this.f1740w;
            qVar.b(f2 / f3, this.f1738u / f3);
        }
    }

    public void a(View view, int i2, int i3, int i4, int i5, int i6) {
    }

    public void a(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        if (!(!this.f1736s && i2 == 0 && i3 == 0)) {
            iArr[0] = iArr[0] + i4;
            iArr[1] = iArr[1] + i5;
        }
        this.f1736s = false;
    }

    public void a(final View view, int i2, int i3, int[] iArr, int i4) {
        t f2;
        int e2;
        q qVar = this.f1719b;
        if (qVar != null && qVar.f1997b != null && this.f1719b.f1997b.g()) {
            q.a aVar = this.f1719b.f1997b;
            if (aVar == null || !aVar.g() || (f2 = aVar.f()) == null || (e2 = f2.e()) == -1 || view.getId() == e2) {
                q qVar2 = this.f1719b;
                if (qVar2 != null && qVar2.m()) {
                    float f3 = this.f1724g;
                    if ((f3 == 1.0f || f3 == 0.0f) && view.canScrollVertically(-1)) {
                        return;
                    }
                }
                if (!(aVar.f() == null || (this.f1719b.f1997b.f().f() & 1) == 0)) {
                    float c2 = this.f1719b.c((float) i2, (float) i3);
                    float f4 = this.f1725h;
                    if ((f4 <= 0.0f && c2 < 0.0f) || (f4 >= 1.0f && c2 > 0.0f)) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            view.setNestedScrollingEnabled(false);
                            view.post(new Runnable() {
                                public void run() {
                                    view.setNestedScrollingEnabled(true);
                                }
                            });
                            return;
                        }
                        return;
                    }
                }
                float f5 = this.f1724g;
                long nanoTime = getNanoTime();
                float f6 = (float) i2;
                this.f1737t = f6;
                float f7 = (float) i3;
                this.f1738u = f7;
                double d2 = (double) (nanoTime - this.f1739v);
                Double.isNaN(d2);
                this.f1740w = (float) (d2 * 1.0E-9d);
                this.f1739v = nanoTime;
                this.f1719b.a(f6, f7);
                if (f5 != this.f1724g) {
                    iArr[0] = i2;
                    iArr[1] = i3;
                }
                a(false);
                if (iArr[0] != 0 || iArr[1] != 0) {
                    this.f1736s = true;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x020b, code lost:
        if (r1 != r2) goto L_0x020f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x021b, code lost:
        if (r1 != r2) goto L_0x020f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r20) {
        /*
            r19 = this;
            r0 = r19
            long r1 = r0.f1695ac
            r3 = -1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0010
            long r1 = r19.getNanoTime()
            r0.f1695ac = r1
        L_0x0010:
            float r1 = r0.f1725h
            r2 = -1
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            int r5 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r5 <= 0) goto L_0x0020
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0020
            r0.f1722e = r2
        L_0x0020:
            boolean r5 = r0.f1704al
            r6 = 1
            r7 = 0
            if (r5 != 0) goto L_0x0032
            boolean r5 = r0.f1727j
            if (r5 == 0) goto L_0x0201
            if (r20 != 0) goto L_0x0032
            float r5 = r0.f1726i
            int r5 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r5 == 0) goto L_0x0201
        L_0x0032:
            float r5 = r0.f1726i
            float r5 = r5 - r1
            float r1 = java.lang.Math.signum(r5)
            long r8 = r19.getNanoTime()
            android.view.animation.Interpolator r5 = r0.f1720c
            boolean r10 = r5 instanceof androidx.constraintlayout.motion.widget.o
            r11 = 814313567(0x3089705f, float:1.0E-9)
            if (r10 != 0) goto L_0x0055
            long r12 = r0.f1695ac
            long r12 = r8 - r12
            float r10 = (float) r12
            float r10 = r10 * r1
            float r10 = r10 * r11
            float r12 = r0.f1694ab
            float r10 = r10 / r12
            r0.f1721d = r10
            goto L_0x0056
        L_0x0055:
            r10 = 0
        L_0x0056:
            float r12 = r0.f1725h
            float r12 = r12 + r10
            boolean r13 = r0.f1696ad
            if (r13 == 0) goto L_0x005f
            float r12 = r0.f1726i
        L_0x005f:
            int r13 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r13 <= 0) goto L_0x0069
            float r13 = r0.f1726i
            int r13 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r13 >= 0) goto L_0x0073
        L_0x0069:
            int r13 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r13 > 0) goto L_0x0079
            float r13 = r0.f1726i
            int r13 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r13 > 0) goto L_0x0079
        L_0x0073:
            float r12 = r0.f1726i
            r0.f1727j = r7
            r13 = 1
            goto L_0x007a
        L_0x0079:
            r13 = 0
        L_0x007a:
            r0.f1725h = r12
            r0.f1724g = r12
            r0.f1695ac = r8
            r14 = 925353388(0x3727c5ac, float:1.0E-5)
            if (r5 == 0) goto L_0x00ef
            if (r13 != 0) goto L_0x00ef
            boolean r13 = r0.f1700ah
            if (r13 == 0) goto L_0x00d2
            long r12 = r0.f1693aa
            long r12 = r8 - r12
            float r10 = (float) r12
            float r10 = r10 * r11
            float r5 = r5.getInterpolation(r10)
            r0.f1725h = r5
            r0.f1695ac = r8
            android.view.animation.Interpolator r8 = r0.f1720c
            boolean r9 = r8 instanceof androidx.constraintlayout.motion.widget.o
            if (r9 == 0) goto L_0x00ee
            androidx.constraintlayout.motion.widget.o r8 = (androidx.constraintlayout.motion.widget.o) r8
            float r8 = r8.a()
            r0.f1721d = r8
            float r9 = java.lang.Math.abs(r8)
            float r10 = r0.f1694ab
            float r9 = r9 * r10
            int r9 = (r9 > r14 ? 1 : (r9 == r14 ? 0 : -1))
            if (r9 > 0) goto L_0x00b6
            r0.f1727j = r7
        L_0x00b6:
            int r9 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r9 <= 0) goto L_0x00c4
            int r9 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r9 < 0) goto L_0x00c4
            r0.f1725h = r3
            r0.f1727j = r7
            r5 = 1065353216(0x3f800000, float:1.0)
        L_0x00c4:
            int r8 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r8 >= 0) goto L_0x00ee
            int r8 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r8 > 0) goto L_0x00ee
            r0.f1725h = r4
            r0.f1727j = r7
            r12 = 0
            goto L_0x00ef
        L_0x00d2:
            float r5 = r5.getInterpolation(r12)
            android.view.animation.Interpolator r8 = r0.f1720c
            boolean r9 = r8 instanceof androidx.constraintlayout.motion.widget.o
            if (r9 == 0) goto L_0x00e3
            androidx.constraintlayout.motion.widget.o r8 = (androidx.constraintlayout.motion.widget.o) r8
            float r8 = r8.a()
            goto L_0x00ec
        L_0x00e3:
            float r12 = r12 + r10
            float r8 = r8.getInterpolation(r12)
            float r8 = r8 - r5
            float r8 = r8 * r1
            float r8 = r8 / r10
        L_0x00ec:
            r0.f1721d = r8
        L_0x00ee:
            r12 = r5
        L_0x00ef:
            float r5 = r0.f1721d
            float r5 = java.lang.Math.abs(r5)
            int r5 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r5 <= 0) goto L_0x00fe
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r5 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING
            r0.setState(r5)
        L_0x00fe:
            int r5 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r5 <= 0) goto L_0x0108
            float r5 = r0.f1726i
            int r5 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r5 >= 0) goto L_0x0112
        L_0x0108:
            int r5 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r5 > 0) goto L_0x0116
            float r5 = r0.f1726i
            int r5 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r5 > 0) goto L_0x0116
        L_0x0112:
            float r12 = r0.f1726i
            r0.f1727j = r7
        L_0x0116:
            int r5 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x011e
            int r5 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r5 > 0) goto L_0x0125
        L_0x011e:
            r0.f1727j = r7
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r5 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r5)
        L_0x0125:
            int r5 = r19.getChildCount()
            r0.f1704al = r7
            long r8 = r19.getNanoTime()
            r0.F = r12
            r10 = 0
        L_0x0132:
            if (r10 >= r5) goto L_0x0156
            android.view.View r14 = r0.getChildAt(r10)
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.n> r11 = r0.f1723f
            java.lang.Object r11 = r11.get(r14)
            r13 = r11
            androidx.constraintlayout.motion.widget.n r13 = (androidx.constraintlayout.motion.widget.n) r13
            if (r13 == 0) goto L_0x0153
            boolean r11 = r0.f1704al
            androidx.constraintlayout.motion.widget.e r15 = r0.f1713au
            r18 = r15
            r15 = r12
            r16 = r8
            boolean r13 = r13.a((android.view.View) r14, (float) r15, (long) r16, (androidx.constraintlayout.motion.widget.e) r18)
            r11 = r11 | r13
            r0.f1704al = r11
        L_0x0153:
            int r10 = r10 + 1
            goto L_0x0132
        L_0x0156:
            int r5 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r5 <= 0) goto L_0x0160
            float r5 = r0.f1726i
            int r5 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r5 >= 0) goto L_0x016a
        L_0x0160:
            int r5 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r5 > 0) goto L_0x016c
            float r5 = r0.f1726i
            int r5 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r5 > 0) goto L_0x016c
        L_0x016a:
            r5 = 1
            goto L_0x016d
        L_0x016c:
            r5 = 0
        L_0x016d:
            boolean r8 = r0.f1704al
            if (r8 != 0) goto L_0x017c
            boolean r8 = r0.f1727j
            if (r8 != 0) goto L_0x017c
            if (r5 == 0) goto L_0x017c
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r8 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r8)
        L_0x017c:
            boolean r8 = r0.f1742y
            if (r8 == 0) goto L_0x0183
            r19.requestLayout()
        L_0x0183:
            boolean r8 = r0.f1704al
            r5 = r5 ^ r6
            r5 = r5 | r8
            r0.f1704al = r5
            int r5 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r5 > 0) goto L_0x01a6
            int r5 = r0.S
            if (r5 == r2) goto L_0x01a6
            int r2 = r0.f1722e
            if (r2 == r5) goto L_0x01a6
            r0.f1722e = r5
            androidx.constraintlayout.motion.widget.q r2 = r0.f1719b
            androidx.constraintlayout.widget.b r2 = r2.c((int) r5)
            r2.d((androidx.constraintlayout.widget.ConstraintLayout) r0)
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r2 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r2)
            r7 = 1
        L_0x01a6:
            double r8 = (double) r12
            r10 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 < 0) goto L_0x01c4
            int r2 = r0.f1722e
            int r5 = r0.T
            if (r2 == r5) goto L_0x01c4
            r0.f1722e = r5
            androidx.constraintlayout.motion.widget.q r2 = r0.f1719b
            androidx.constraintlayout.widget.b r2 = r2.c((int) r5)
            r2.d((androidx.constraintlayout.widget.ConstraintLayout) r0)
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r2 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r2)
            r7 = 1
        L_0x01c4:
            boolean r2 = r0.f1704al
            if (r2 != 0) goto L_0x01e3
            boolean r2 = r0.f1727j
            if (r2 == 0) goto L_0x01cd
            goto L_0x01e3
        L_0x01cd:
            int r2 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x01d5
            int r2 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x01dd
        L_0x01d5:
            int r2 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x01e6
            int r2 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x01e6
        L_0x01dd:
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r2 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            r0.setState(r2)
            goto L_0x01e6
        L_0x01e3:
            r19.invalidate()
        L_0x01e6:
            boolean r2 = r0.f1704al
            if (r2 != 0) goto L_0x01f6
            boolean r2 = r0.f1727j
            if (r2 == 0) goto L_0x01f6
            int r2 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x01f6
            int r2 = (r12 > r3 ? 1 : (r12 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x01fe
        L_0x01f6:
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x0201
            int r1 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x0201
        L_0x01fe:
            r19.d()
        L_0x0201:
            float r1 = r0.f1725h
            int r2 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r2 < 0) goto L_0x0213
            int r1 = r0.f1722e
            int r2 = r0.T
            if (r1 == r2) goto L_0x020e
            goto L_0x020f
        L_0x020e:
            r6 = r7
        L_0x020f:
            r0.f1722e = r2
            r7 = r6
            goto L_0x021e
        L_0x0213:
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 > 0) goto L_0x021e
            int r1 = r0.f1722e
            int r2 = r0.S
            if (r1 == r2) goto L_0x020e
            goto L_0x020f
        L_0x021e:
            boolean r1 = r0.f1716ax
            r1 = r1 | r7
            r0.f1716ax = r1
            if (r7 == 0) goto L_0x022c
            boolean r1 = r0.f1714av
            if (r1 != 0) goto L_0x022c
            r19.requestLayout()
        L_0x022c:
            float r1 = r0.f1725h
            r0.f1724g = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.a(boolean):void");
    }

    public boolean a(View view, View view2, int i2, int i3) {
        q qVar = this.f1719b;
        return (qVar == null || qVar.f1997b == null || this.f1719b.f1997b.f() == null || (this.f1719b.f1997b.f().f() & 2) != 0) ? false : true;
    }

    public void b() {
        a(0.0f);
    }

    /* access modifiers changed from: protected */
    public void b(int i2) {
        this.M = null;
    }

    public void b(int i2, int i3, int i4) {
        int a2;
        q qVar = this.f1719b;
        if (!(qVar == null || qVar.f1996a == null || (a2 = this.f1719b.f1996a.a(this.f1722e, i2, (float) i3, (float) i4)) == -1)) {
            i2 = a2;
        }
        int i5 = this.f1722e;
        if (i5 != i2) {
            if (this.S == i2) {
                a(0.0f);
            } else if (this.T == i2) {
                a(1.0f);
            } else {
                this.T = i2;
                if (i5 != -1) {
                    a(i5, i2);
                    a(1.0f);
                    this.f1725h = 0.0f;
                    c();
                    return;
                }
                this.f1700ah = false;
                this.f1726i = 1.0f;
                this.f1724g = 0.0f;
                this.f1725h = 0.0f;
                this.f1695ac = getNanoTime();
                this.f1693aa = getNanoTime();
                this.f1696ad = false;
                this.f1720c = null;
                this.f1694ab = ((float) this.f1719b.g()) / 1000.0f;
                this.S = -1;
                this.f1719b.a(-1, this.T);
                this.f1719b.d();
                int childCount = getChildCount();
                this.f1723f.clear();
                for (int i6 = 0; i6 < childCount; i6++) {
                    View childAt = getChildAt(i6);
                    this.f1723f.put(childAt, new n(childAt));
                }
                this.f1727j = true;
                this.H.a(this.K, (androidx.constraintlayout.widget.b) null, this.f1719b.c(i2));
                f();
                this.H.b();
                k();
                int width = getWidth();
                int height = getHeight();
                for (int i7 = 0; i7 < childCount; i7++) {
                    n nVar = this.f1723f.get(getChildAt(i7));
                    this.f1719b.a(nVar);
                    nVar.a(width, height, this.f1694ab, getNanoTime());
                }
                float i8 = this.f1719b.i();
                if (i8 != 0.0f) {
                    float f2 = Float.MAX_VALUE;
                    float f3 = -3.4028235E38f;
                    for (int i9 = 0; i9 < childCount; i9++) {
                        n nVar2 = this.f1723f.get(getChildAt(i9));
                        float b2 = nVar2.b() + nVar2.a();
                        f2 = Math.min(f2, b2);
                        f3 = Math.max(f3, b2);
                    }
                    for (int i10 = 0; i10 < childCount; i10++) {
                        n nVar3 = this.f1723f.get(getChildAt(i10));
                        float a3 = nVar3.a();
                        float b3 = nVar3.b();
                        nVar3.f1959f = 1.0f / (1.0f - i8);
                        nVar3.f1958e = i8 - ((((a3 + b3) - f2) * i8) / (f3 - f2));
                    }
                }
                this.f1724g = 0.0f;
                this.f1725h = 0.0f;
                this.f1727j = true;
                invalidate();
            }
        }
    }

    public void b(View view, View view2, int i2, int i3) {
    }

    public q.a c(int i2) {
        return this.f1719b.b(i2);
    }

    public void c() {
        a(1.0f);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        q qVar = this.f1719b;
        if (qVar != null) {
            if (qVar.b(this, this.f1722e)) {
                requestLayout();
                return;
            }
            int i2 = this.f1722e;
            if (i2 != -1) {
                this.f1719b.a(this, i2);
            }
            if (this.f1719b.c()) {
                this.f1719b.l();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispatchDraw(android.graphics.Canvas r10) {
        /*
            r9 = this;
            r0 = 0
            r9.a((boolean) r0)
            super.dispatchDraw(r10)
            androidx.constraintlayout.motion.widget.q r1 = r9.f1719b
            if (r1 != 0) goto L_0x000c
            return
        L_0x000c:
            int r1 = r9.f1729l
            r2 = 1
            r1 = r1 & r2
            if (r1 != r2) goto L_0x00d3
            boolean r1 = r9.isInEditMode()
            if (r1 != 0) goto L_0x00d3
            int r1 = r9.f1708ap
            int r1 = r1 + r2
            r9.f1708ap = r1
            long r3 = r9.getNanoTime()
            long r5 = r9.f1709aq
            r7 = -1
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x0047
            long r5 = r3 - r5
            r7 = 200000000(0xbebc200, double:9.8813129E-316)
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 <= 0) goto L_0x0049
            int r1 = r9.f1708ap
            float r1 = (float) r1
            float r5 = (float) r5
            r6 = 814313567(0x3089705f, float:1.0E-9)
            float r5 = r5 * r6
            float r1 = r1 / r5
            r5 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 * r5
            int r1 = (int) r1
            float r1 = (float) r1
            float r1 = r1 / r5
            r9.f1710ar = r1
            r9.f1708ap = r0
        L_0x0047:
            r9.f1709aq = r3
        L_0x0049:
            android.graphics.Paint r0 = new android.graphics.Paint
            r0.<init>()
            r1 = 1109917696(0x42280000, float:42.0)
            r0.setTextSize(r1)
            float r1 = r9.getProgress()
            r3 = 1148846080(0x447a0000, float:1000.0)
            float r1 = r1 * r3
            int r1 = (int) r1
            float r1 = (float) r1
            r3 = 1092616192(0x41200000, float:10.0)
            float r1 = r1 / r3
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            float r5 = r9.f1710ar
            r4.append(r5)
            java.lang.String r5 = " fps "
            r4.append(r5)
            int r5 = r9.S
            java.lang.String r5 = androidx.constraintlayout.motion.widget.a.a((androidx.constraintlayout.motion.widget.MotionLayout) r9, (int) r5)
            r4.append(r5)
            java.lang.String r5 = " -> "
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r4)
            int r4 = r9.T
            java.lang.String r4 = androidx.constraintlayout.motion.widget.a.a((androidx.constraintlayout.motion.widget.MotionLayout) r9, (int) r4)
            r5.append(r4)
            java.lang.String r4 = " (progress: "
            r5.append(r4)
            r5.append(r1)
            java.lang.String r1 = " ) state="
            r5.append(r1)
            int r1 = r9.f1722e
            r4 = -1
            if (r1 != r4) goto L_0x00a7
            java.lang.String r1 = "undefined"
            goto L_0x00ab
        L_0x00a7:
            java.lang.String r1 = androidx.constraintlayout.motion.widget.a.a((androidx.constraintlayout.motion.widget.MotionLayout) r9, (int) r1)
        L_0x00ab:
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            r4 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r0.setColor(r4)
            r4 = 1093664768(0x41300000, float:11.0)
            int r5 = r9.getHeight()
            int r5 = r5 + -29
            float r5 = (float) r5
            r10.drawText(r1, r4, r5, r0)
            r4 = -7864184(0xffffffffff880088, float:NaN)
            r0.setColor(r4)
            int r4 = r9.getHeight()
            int r4 = r4 + -30
            float r4 = (float) r4
            r10.drawText(r1, r3, r4, r0)
        L_0x00d3:
            int r0 = r9.f1729l
            if (r0 <= r2) goto L_0x00f1
            androidx.constraintlayout.motion.widget.MotionLayout$b r0 = r9.f1730m
            if (r0 != 0) goto L_0x00e2
            androidx.constraintlayout.motion.widget.MotionLayout$b r0 = new androidx.constraintlayout.motion.widget.MotionLayout$b
            r0.<init>()
            r9.f1730m = r0
        L_0x00e2:
            androidx.constraintlayout.motion.widget.MotionLayout$b r0 = r9.f1730m
            java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.n> r1 = r9.f1723f
            androidx.constraintlayout.motion.widget.q r2 = r9.f1719b
            int r2 = r2.g()
            int r3 = r9.f1729l
            r0.a((android.graphics.Canvas) r10, (java.util.HashMap<android.view.View, androidx.constraintlayout.motion.widget.n>) r1, (int) r2, (int) r3)
        L_0x00f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.dispatchDraw(android.graphics.Canvas):void");
    }

    /* access modifiers changed from: protected */
    public void e() {
        int i2;
        ArrayList<g> arrayList;
        if ((this.f1697ae != null || ((arrayList = this.f1707ao) != null && !arrayList.isEmpty())) && this.f1711as == -1) {
            this.f1711as = this.f1722e;
            if (!this.I.isEmpty()) {
                ArrayList<Integer> arrayList2 = this.I;
                i2 = arrayList2.get(arrayList2.size() - 1).intValue();
            } else {
                i2 = -1;
            }
            int i3 = this.f1722e;
            if (!(i2 == i3 || i3 == -1)) {
                this.I.add(Integer.valueOf(i3));
            }
        }
        o();
    }

    public void f() {
        this.H.a();
        invalidate();
    }

    public boolean g() {
        return this.W;
    }

    public int[] getConstraintSetIds() {
        q qVar = this.f1719b;
        if (qVar == null) {
            return null;
        }
        return qVar.b();
    }

    public int getCurrentState() {
        return this.f1722e;
    }

    public ArrayList<q.a> getDefinedTransitions() {
        q qVar = this.f1719b;
        if (qVar == null) {
            return null;
        }
        return qVar.a();
    }

    public b getDesignTool() {
        if (this.f1703ak == null) {
            this.f1703ak = new b(this);
        }
        return this.f1703ak;
    }

    public int getEndState() {
        return this.T;
    }

    /* access modifiers changed from: protected */
    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.f1725h;
    }

    public int getStartState() {
        return this.S;
    }

    public float getTargetPosition() {
        return this.f1726i;
    }

    public Bundle getTransitionState() {
        if (this.f1715aw == null) {
            this.f1715aw = new f();
        }
        this.f1715aw.c();
        return this.f1715aw.b();
    }

    public long getTransitionTimeMs() {
        q qVar = this.f1719b;
        if (qVar != null) {
            this.f1694ab = ((float) qVar.g()) / 1000.0f;
        }
        return (long) (this.f1694ab * 1000.0f);
    }

    public float getVelocity() {
        return this.f1721d;
    }

    public boolean isAttachedToWindow() {
        return Build.VERSION.SDK_INT >= 19 ? super.isAttachedToWindow() : getWindowToken() != null;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        int i2;
        super.onAttachedToWindow();
        q qVar = this.f1719b;
        if (!(qVar == null || (i2 = this.f1722e) == -1)) {
            androidx.constraintlayout.widget.b c2 = qVar.c(i2);
            this.f1719b.a(this);
            if (c2 != null) {
                c2.c((ConstraintLayout) this);
            }
            this.S = this.f1722e;
        }
        d();
        f fVar = this.f1715aw;
        if (fVar != null) {
            fVar.a();
            return;
        }
        q qVar2 = this.f1719b;
        if (qVar2 != null && qVar2.f1997b != null && this.f1719b.f1997b.b() == 4) {
            c();
            setState(TransitionState.SETUP);
            setState(TransitionState.MOVING);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        q.a aVar;
        t f2;
        int e2;
        RectF a2;
        q qVar = this.f1719b;
        if (qVar != null && this.W && (aVar = qVar.f1997b) != null && aVar.g() && (f2 = aVar.f()) != null && ((motionEvent.getAction() != 0 || (a2 = f2.a((ViewGroup) this, new RectF())) == null || a2.contains(motionEvent.getX(), motionEvent.getY())) && (e2 = f2.e()) != -1)) {
            View view = this.f1718az;
            if (view == null || view.getId() != e2) {
                this.f1718az = findViewById(e2);
            }
            View view2 = this.f1718az;
            if (view2 != null) {
                this.f1717ay.set((float) view2.getLeft(), (float) this.f1718az.getTop(), (float) this.f1718az.getRight(), (float) this.f1718az.getBottom());
                if (this.f1717ay.contains(motionEvent.getX(), motionEvent.getY()) && !a(0.0f, 0.0f, this.f1718az, motionEvent)) {
                    return onTouchEvent(motionEvent);
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        this.f1714av = true;
        try {
            if (this.f1719b == null) {
                super.onLayout(z2, i2, i3, i4, i5);
                return;
            }
            int i6 = i4 - i2;
            int i7 = i5 - i3;
            if (!(this.f1734q == i6 && this.f1735r == i7)) {
                f();
                a(true);
            }
            this.f1734q = i6;
            this.f1735r = i7;
            this.f1732o = i6;
            this.f1733p = i7;
            this.f1714av = false;
        } finally {
            this.f1714av = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.f1719b == null) {
            super.onMeasure(i2, i3);
            return;
        }
        boolean z2 = false;
        boolean z3 = (this.U == i2 && this.V == i3) ? false : true;
        if (this.f1716ax) {
            this.f1716ax = false;
            d();
            o();
            z3 = true;
        }
        if (this.L) {
            z3 = true;
        }
        this.U = i2;
        this.V = i3;
        int d2 = this.f1719b.d();
        int e2 = this.f1719b.e();
        if ((z3 || this.H.c(d2, e2)) && this.S != -1) {
            super.onMeasure(i2, i3);
            this.H.a(this.K, this.f1719b.c(d2), this.f1719b.c(e2));
            this.H.a();
            this.H.b(d2, e2);
        } else {
            z2 = true;
        }
        if (this.f1742y || z2) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int A2 = this.K.A() + getPaddingLeft() + getPaddingRight();
            int B2 = this.K.B() + paddingTop;
            int i4 = this.D;
            if (i4 == Integer.MIN_VALUE || i4 == 0) {
                int i5 = this.f1743z;
                A2 = (int) (((float) i5) + (this.F * ((float) (this.B - i5))));
                requestLayout();
            }
            int i6 = this.E;
            if (i6 == Integer.MIN_VALUE || i6 == 0) {
                int i7 = this.A;
                B2 = (int) (((float) i7) + (this.F * ((float) (this.C - i7))));
                requestLayout();
            }
            setMeasuredDimension(A2, B2);
        }
        l();
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        return false;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    public void onRtlPropertiesChanged(int i2) {
        q qVar = this.f1719b;
        if (qVar != null) {
            qVar.a(h());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        q qVar = this.f1719b;
        if (qVar == null || !this.W || !qVar.c()) {
            return super.onTouchEvent(motionEvent);
        }
        q.a aVar = this.f1719b.f1997b;
        if (aVar != null && !aVar.g()) {
            return super.onTouchEvent(motionEvent);
        }
        this.f1719b.a(motionEvent, getCurrentState(), this);
        return true;
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.f1707ao == null) {
                this.f1707ao = new ArrayList<>();
            }
            this.f1707ao.add(motionHelper);
            if (motionHelper.a()) {
                if (this.f1705am == null) {
                    this.f1705am = new ArrayList<>();
                }
                this.f1705am.add(motionHelper);
            }
            if (motionHelper.b()) {
                if (this.f1706an == null) {
                    this.f1706an = new ArrayList<>();
                }
                this.f1706an.add(motionHelper);
            }
        }
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<MotionHelper> arrayList = this.f1705am;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<MotionHelper> arrayList2 = this.f1706an;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    public void requestLayout() {
        q qVar;
        if (this.f1742y || this.f1722e != -1 || (qVar = this.f1719b) == null || qVar.f1997b == null || this.f1719b.f1997b.a() != 0) {
            super.requestLayout();
        }
    }

    public void setDebugMode(int i2) {
        this.f1729l = i2;
        invalidate();
    }

    public void setInteractionEnabled(boolean z2) {
        this.W = z2;
    }

    public void setInterpolatedProgress(float f2) {
        if (this.f1719b != null) {
            setState(TransitionState.MOVING);
            Interpolator f3 = this.f1719b.f();
            if (f3 != null) {
                setProgress(f3.getInterpolation(f2));
                return;
            }
        }
        setProgress(f2);
    }

    public void setOnHide(float f2) {
        ArrayList<MotionHelper> arrayList = this.f1706an;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f1706an.get(i2).setProgress(f2);
            }
        }
    }

    public void setOnShow(float f2) {
        ArrayList<MotionHelper> arrayList = this.f1705am;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f1705am.get(i2).setProgress(f2);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        if (r4.f1725h == 0.0f) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0046, code lost:
        if (r4.f1725h == 1.0f) goto L_0x0037;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0056  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setProgress(float r5) {
        /*
            r4 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 0
            int r2 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r2 < 0) goto L_0x000b
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x0012
        L_0x000b:
            java.lang.String r2 = "MotionLayout"
            java.lang.String r3 = "Warning! Progress is defined for values between 0.0 and 1.0 inclusive"
            android.util.Log.w(r2, r3)
        L_0x0012:
            boolean r2 = r4.isAttachedToWindow()
            if (r2 != 0) goto L_0x0029
            androidx.constraintlayout.motion.widget.MotionLayout$f r0 = r4.f1715aw
            if (r0 != 0) goto L_0x0023
            androidx.constraintlayout.motion.widget.MotionLayout$f r0 = new androidx.constraintlayout.motion.widget.MotionLayout$f
            r0.<init>()
            r4.f1715aw = r0
        L_0x0023:
            androidx.constraintlayout.motion.widget.MotionLayout$f r0 = r4.f1715aw
            r0.a((float) r5)
            return
        L_0x0029:
            int r2 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r2 > 0) goto L_0x003a
            int r0 = r4.S
            r4.f1722e = r0
            float r0 = r4.f1725h
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0051
        L_0x0037:
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r0 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.FINISHED
            goto L_0x004e
        L_0x003a:
            int r1 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r1 < 0) goto L_0x0049
            int r1 = r4.T
            r4.f1722e = r1
            float r1 = r4.f1725h
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 != 0) goto L_0x0051
            goto L_0x0037
        L_0x0049:
            r0 = -1
            r4.f1722e = r0
            androidx.constraintlayout.motion.widget.MotionLayout$TransitionState r0 = androidx.constraintlayout.motion.widget.MotionLayout.TransitionState.MOVING
        L_0x004e:
            r4.setState(r0)
        L_0x0051:
            androidx.constraintlayout.motion.widget.q r0 = r4.f1719b
            if (r0 != 0) goto L_0x0056
            return
        L_0x0056:
            r0 = 1
            r4.f1696ad = r0
            r4.f1726i = r5
            r4.f1724g = r5
            r1 = -1
            r4.f1695ac = r1
            r4.f1693aa = r1
            r5 = 0
            r4.f1720c = r5
            r4.f1727j = r0
            r4.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.setProgress(float):void");
    }

    public void setScene(q qVar) {
        this.f1719b = qVar;
        qVar.a(h());
        f();
    }

    /* access modifiers changed from: package-private */
    public void setState(TransitionState transitionState) {
        if (transitionState != TransitionState.FINISHED || this.f1722e != -1) {
            TransitionState transitionState2 = this.G;
            this.G = transitionState;
            if (transitionState2 == TransitionState.MOVING && transitionState == TransitionState.MOVING) {
                n();
            }
            int i2 = AnonymousClass2.f1746a[transitionState2.ordinal()];
            if (i2 == 1 || i2 == 2) {
                if (transitionState == TransitionState.MOVING) {
                    n();
                }
                if (transitionState != TransitionState.FINISHED) {
                    return;
                }
            } else if (!(i2 == 3 && transitionState == TransitionState.FINISHED)) {
                return;
            }
            e();
        }
    }

    public void setTransition(int i2) {
        if (this.f1719b != null) {
            q.a c2 = c(i2);
            this.S = c2.d();
            this.T = c2.c();
            if (!isAttachedToWindow()) {
                if (this.f1715aw == null) {
                    this.f1715aw = new f();
                }
                this.f1715aw.b(this.S);
                this.f1715aw.a(this.T);
                return;
            }
            float f2 = Float.NaN;
            int i3 = this.f1722e;
            float f3 = 0.0f;
            if (i3 == this.S) {
                f2 = 0.0f;
            } else if (i3 == this.T) {
                f2 = 1.0f;
            }
            this.f1719b.a(c2);
            this.H.a(this.K, this.f1719b.c(this.S), this.f1719b.c(this.T));
            f();
            if (!Float.isNaN(f2)) {
                f3 = f2;
            }
            this.f1725h = f3;
            if (Float.isNaN(f2)) {
                Log.v("MotionLayout", a.a() + " transitionToStart ");
                b();
                return;
            }
            setProgress(f2);
        }
    }

    /* access modifiers changed from: protected */
    public void setTransition(q.a aVar) {
        this.f1719b.a(aVar);
        setState(TransitionState.SETUP);
        float f2 = this.f1722e == this.f1719b.e() ? 1.0f : 0.0f;
        this.f1725h = f2;
        this.f1724g = f2;
        this.f1726i = f2;
        this.f1695ac = aVar.b(1) ? -1 : getNanoTime();
        int d2 = this.f1719b.d();
        int e2 = this.f1719b.e();
        if (d2 != this.S || e2 != this.T) {
            this.S = d2;
            this.T = e2;
            this.f1719b.a(d2, e2);
            this.H.a(this.K, this.f1719b.c(this.S), this.f1719b.c(this.T));
            this.H.b(this.S, this.T);
            this.H.a();
            f();
        }
    }

    public void setTransitionDuration(int i2) {
        q qVar = this.f1719b;
        if (qVar == null) {
            Log.e("MotionLayout", "MotionScene not defined");
        } else {
            qVar.d(i2);
        }
    }

    public void setTransitionListener(g gVar) {
        this.f1697ae = gVar;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.f1715aw == null) {
            this.f1715aw = new f();
        }
        this.f1715aw.a(bundle);
        if (isAttachedToWindow()) {
            this.f1715aw.a();
        }
    }

    public String toString() {
        Context context = getContext();
        return a.a(context, this.S) + "->" + a.a(context, this.T) + " (pos:" + this.f1725h + " Dpos/Dt:" + this.f1721d;
    }
}
