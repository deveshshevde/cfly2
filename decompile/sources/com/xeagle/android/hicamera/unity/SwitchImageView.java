package com.xeagle.android.hicamera.unity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class SwitchImageView extends View {
    private float A = 0.0f;
    private float B = 0.0f;
    private float C = -1.0f;
    private float D = -1.0f;
    /* access modifiers changed from: private */
    public float E = -1.0f;
    /* access modifiers changed from: private */
    public float F = -1.0f;
    /* access modifiers changed from: private */
    public float G = -1.0f;
    /* access modifiers changed from: private */
    public float H = -1.0f;
    private float I;
    private float J;
    private float K;
    private float L;
    private float M;
    private float N;
    private float O;
    private float P;
    private float Q;
    private float R;
    private float S;
    private float T;
    private float U;
    private float V;
    private float W;

    /* renamed from: a  reason: collision with root package name */
    Runnable f23699a = new Runnable() {
        public void run() {
            int a2 = SwitchImageView.this.f23721m;
            if (a2 == 1) {
                int unused = SwitchImageView.this.f23725q = 8;
                SwitchImageView switchImageView = SwitchImageView.this;
                SwitchImageView.a(switchImageView, switchImageView.f23714f);
                if (SwitchImageView.this.f23714f == 0.0f) {
                    return;
                }
            } else if (a2 == 2) {
                SwitchImageView switchImageView2 = SwitchImageView.this;
                SwitchImageView.a(switchImageView2, switchImageView2.f23713e);
                int unused2 = SwitchImageView.this.f23725q = 5;
                if (SwitchImageView.this.f23713e == 0.0f) {
                    return;
                }
            } else if (a2 == 3) {
                int unused3 = SwitchImageView.this.f23725q = 9;
                SwitchImageView switchImageView3 = SwitchImageView.this;
                SwitchImageView.b(switchImageView3, (float) switchImageView3.f23716h);
                SwitchImageView switchImageView4 = SwitchImageView.this;
                SwitchImageView.c(switchImageView4, (float) switchImageView4.f23715g);
                SwitchImageView switchImageView5 = SwitchImageView.this;
                SwitchImageView.d(switchImageView5, switchImageView5.f23717i);
            }
            SwitchImageView.this.invalidate();
            SwitchImageView.this.f23706ag.postDelayed(this, 30);
        }
    };

    /* renamed from: aa  reason: collision with root package name */
    private double f23700aa;

    /* renamed from: ab  reason: collision with root package name */
    private Handler f23701ab = null;
    /* access modifiers changed from: private */

    /* renamed from: ac  reason: collision with root package name */
    public Handler f23702ac = null;

    /* renamed from: ad  reason: collision with root package name */
    private boolean f23703ad = true;

    /* renamed from: ae  reason: collision with root package name */
    private ImageView f23704ae = null;

    /* renamed from: af  reason: collision with root package name */
    private boolean f23705af = true;
    /* access modifiers changed from: private */

    /* renamed from: ag  reason: collision with root package name */
    public Handler f23706ag = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: ah  reason: collision with root package name */
    public boolean f23707ah = true;
    /* access modifiers changed from: private */

    /* renamed from: ai  reason: collision with root package name */
    public boolean f23708ai = true;
    /* access modifiers changed from: private */

    /* renamed from: aj  reason: collision with root package name */
    public int f23709aj = 0;

    /* renamed from: b  reason: collision with root package name */
    Runnable f23710b = new Runnable() {
        public void run() {
            if (SwitchImageView.this.f23709aj >= 40) {
                Message obtainMessage = SwitchImageView.this.f23702ac.obtainMessage();
                obtainMessage.what = 3;
                SwitchImageView.this.f23702ac.sendMessage(obtainMessage);
                int unused = SwitchImageView.this.f23709aj = 0;
            }
            SwitchImageView.j(SwitchImageView.this);
            SwitchImageView.this.f23706ag.postDelayed(this, 100);
        }
    };

    /* renamed from: c  reason: collision with root package name */
    Runnable f23711c = new Runnable() {
        public void run() {
            Message message;
            if (!SwitchImageView.this.f23707ah) {
                int i2 = 1;
                if (SwitchImageView.this.f23708ai) {
                    boolean unused = SwitchImageView.this.f23707ah = true;
                    if (SwitchImageView.this.E - SwitchImageView.this.G < 12.0f && SwitchImageView.this.E - SwitchImageView.this.G > -12.0f && SwitchImageView.this.F - SwitchImageView.this.H < 12.0f && SwitchImageView.this.F - SwitchImageView.this.H > -12.0f) {
                        message = SwitchImageView.this.f23702ac.obtainMessage();
                    } else {
                        return;
                    }
                } else {
                    boolean unused2 = SwitchImageView.this.f23707ah = true;
                    message = SwitchImageView.this.f23702ac.obtainMessage();
                    i2 = 2;
                }
                message.what = i2;
                SwitchImageView.this.f23702ac.sendMessage(message);
            }
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private Matrix f23712d = new Matrix();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public float f23713e = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public float f23714f = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f23715g = 0;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f23716h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public float f23717i = 0.0f;

    /* renamed from: j  reason: collision with root package name */
    private float f23718j = 0.0f;

    /* renamed from: k  reason: collision with root package name */
    private float f23719k = 0.0f;

    /* renamed from: l  reason: collision with root package name */
    private float f23720l = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public int f23721m;

    /* renamed from: n  reason: collision with root package name */
    private Bitmap f23722n;

    /* renamed from: o  reason: collision with root package name */
    private Bitmap f23723o;

    /* renamed from: p  reason: collision with root package name */
    private Bitmap f23724p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public int f23725q = 0;

    /* renamed from: r  reason: collision with root package name */
    private int f23726r;

    /* renamed from: s  reason: collision with root package name */
    private int f23727s;

    /* renamed from: t  reason: collision with root package name */
    private float f23728t;

    /* renamed from: u  reason: collision with root package name */
    private float f23729u;

    /* renamed from: v  reason: collision with root package name */
    private float f23730v;

    /* renamed from: w  reason: collision with root package name */
    private float f23731w;

    /* renamed from: x  reason: collision with root package name */
    private float f23732x;

    /* renamed from: y  reason: collision with root package name */
    private float f23733y = 0.0f;

    /* renamed from: z  reason: collision with root package name */
    private float f23734z = 0.0f;

    public SwitchImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private double a(MotionEvent motionEvent) {
        float abs = Math.abs(motionEvent.getX(0) - motionEvent.getX(1));
        float abs2 = Math.abs(motionEvent.getY(0) - motionEvent.getY(1));
        return Math.sqrt((double) ((abs * abs) + (abs2 * abs2)));
    }

    static /* synthetic */ float a(SwitchImageView switchImageView, float f2) {
        float f3 = switchImageView.L + f2;
        switchImageView.L = f3;
        return f3;
    }

    private void a() {
        if (this.f23707ah) {
            this.f23707ah = false;
            this.f23708ai = false;
            this.f23706ag.postDelayed(this.f23711c, 350);
            return;
        }
        this.f23707ah = true;
        float f2 = this.E;
        float f3 = this.G;
        if (f2 - f3 < 12.0f && f2 - f3 > -12.0f) {
            float f4 = this.F;
            float f5 = this.H;
            if (f4 - f5 < 12.0f && f4 - f5 > -12.0f) {
                b();
            }
        }
    }

    private void a(Canvas canvas) {
        float f2 = this.f23717i;
        if ((f2 > 0.0f && this.S >= this.f23720l) || (f2 < 0.0f && this.S <= this.f23720l)) {
            this.f23706ag.removeCallbacks(this.f23699a);
            this.S = this.f23720l;
            this.K = this.f23718j;
            this.P = this.f23719k;
            this.f23705af = true;
            Log.d("SwitchImageView", "removeCallbacks");
        }
        this.f23712d.reset();
        Matrix matrix = this.f23712d;
        float f3 = this.S;
        matrix.postScale(f3, f3);
        this.f23712d.postTranslate(this.K, this.P);
        Bitmap bitmap = this.f23722n;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, this.f23712d, (Paint) null);
        }
    }

    static /* synthetic */ float b(SwitchImageView switchImageView, float f2) {
        float f3 = switchImageView.P + f2;
        switchImageView.P = f3;
        return f3;
    }

    private void b() {
        Bitmap bitmap;
        float f2;
        if (!this.f23703ad && (bitmap = this.f23722n) != null) {
            float f3 = this.U;
            if (f3 * 2.0f < this.S) {
                this.f23720l = f3;
                this.f23730v = f3 * ((float) bitmap.getWidth());
                float height = this.f23720l * ((float) this.f23722n.getHeight());
                this.f23732x = height;
                this.f23718j = (((float) this.f23726r) - this.f23730v) / 2.0f;
                this.f23719k = (((float) this.f23727s) - height) / 2.0f;
            } else {
                float f4 = f3 * 4.0f;
                this.f23720l = f4;
                float width = (this.E - this.K) * ((f4 * ((float) bitmap.getWidth())) / this.f23730v);
                float width2 = this.f23720l * ((float) this.f23722n.getWidth());
                this.f23730v = width2;
                int i2 = this.f23726r;
                if ((((float) i2) / 2.0f) + width > width2) {
                    this.f23718j = ((float) i2) - width2;
                } else if (width - (((float) i2) / 2.0f) < 0.0f) {
                    this.f23718j = 0.0f;
                } else {
                    this.f23718j = (-width) + (((float) i2) / 2.0f);
                }
                float height2 = (((this.F - this.P) * this.f23720l) * ((float) this.f23722n.getHeight())) / this.f23732x;
                float height3 = this.f23720l * ((float) this.f23722n.getHeight());
                this.f23732x = height3;
                int i3 = this.f23727s;
                if ((((float) i3) / 2.0f) + height2 > height3) {
                    f2 = ((float) i3) - height3;
                } else if (height2 - (((float) i3) / 2.0f) < 0.0f) {
                    this.f23719k = 0.0f;
                } else {
                    f2 = (-height2) + (((float) i3) / 2.0f);
                }
                this.f23719k = f2;
            }
            this.f23715g = (int) ((this.f23718j - this.K) / 10.0f);
            this.f23716h = (int) ((this.f23719k - this.P) / 10.0f);
            this.f23717i = (this.f23720l - this.S) / 10.0f;
            this.f23725q = 2;
            Log.d("SwitchImageView", "" + this.S + " " + this.f23720l);
            this.f23705af = false;
            invalidate();
        }
    }

    private void b(Canvas canvas) {
        float f2;
        if (this.f23722n != null) {
            this.f23712d.reset();
            Matrix matrix = this.f23712d;
            float f3 = this.S;
            matrix.postScale(f3, f3);
            float width = ((float) this.f23722n.getWidth()) * this.S;
            float height = ((float) this.f23722n.getHeight()) * this.S;
            float f4 = this.f23730v;
            int i2 = this.f23726r;
            float f5 = 0.0f;
            if (f4 < ((float) i2)) {
                f2 = (((float) i2) - width) / 2.0f;
            } else {
                float f6 = this.K;
                float f7 = this.T;
                f2 = (f6 * f7) + (this.f23728t * (1.0f - f7));
                if (f2 > 0.0f) {
                    f2 = 0.0f;
                } else if (((float) i2) - f2 > width) {
                    f2 = ((float) i2) - width;
                }
            }
            float f8 = this.f23732x;
            int i3 = this.f23727s;
            if (f8 < ((float) i3)) {
                f5 = (((float) i3) - height) / 2.0f;
            } else {
                float f9 = this.P;
                float f10 = this.T;
                float f11 = (f9 * f10) + (this.f23729u * (1.0f - f10));
                if (f11 <= 0.0f) {
                    f5 = ((float) i3) - f11 > height ? ((float) i3) - height : f11;
                }
            }
            this.f23712d.postTranslate(f2, f5);
            this.K = f2;
            this.P = f5;
            this.f23730v = width;
            this.f23732x = height;
            canvas.drawBitmap(this.f23722n, this.f23712d, (Paint) null);
            this.f23705af = true;
        }
    }

    private void b(MotionEvent motionEvent) {
        float x2 = motionEvent.getX(0);
        float y2 = motionEvent.getY(0);
        float x3 = motionEvent.getX(1);
        float y3 = motionEvent.getY(1);
        this.f23728t = (x2 + x3) / 2.0f;
        this.f23729u = (y2 + y3) / 2.0f;
    }

    static /* synthetic */ float c(SwitchImageView switchImageView, float f2) {
        float f3 = switchImageView.K + f2;
        switchImageView.K = f3;
        return f3;
    }

    private void c() {
        float f2;
        Bitmap bitmap = this.f23724p;
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = this.f23724p.getHeight();
            this.Q = 0.0f;
            this.O = 0.0f;
            int i2 = this.f23726r;
            if (width > i2 || height > this.f23727s) {
                float f3 = (float) width;
                float f4 = f3 * 1.0f;
                float f5 = (float) height;
                float f6 = 1.0f * f5;
                int i3 = this.f23727s;
                if (f4 / ((float) i2) > f6 / ((float) i3)) {
                    float f7 = ((float) i2) / f4;
                    this.Q = (((float) i3) - (f5 * f7)) / 2.0f;
                    this.V = f7;
                } else {
                    float f8 = ((float) i3) / f6;
                    this.O = (((float) i2) - (f3 * f8)) / 2.0f;
                    this.V = f8;
                }
                f2 = f3 * this.V;
            } else {
                this.O = ((float) (i2 - this.f23724p.getWidth())) / 2.0f;
                this.Q = ((float) (this.f23727s - this.f23724p.getHeight())) / 2.0f;
                this.V = 1.0f;
                f2 = (float) width;
            }
            this.f23731w = f2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002b, code lost:
        if (r0 >= r2) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0032, code lost:
        if (r0 <= r2) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(android.graphics.Canvas r7) {
        /*
            r6 = this;
            android.graphics.Bitmap r0 = r6.f23722n
            r1 = 1
            if (r0 != 0) goto L_0x000f
            android.os.Handler r7 = r6.f23706ag
            java.lang.Runnable r0 = r6.f23699a
            r7.removeCallbacks(r0)
            r6.f23705af = r1
            return
        L_0x000f:
            android.graphics.Matrix r0 = r6.f23712d
            r0.reset()
            android.graphics.Matrix r0 = r6.f23712d
            float r2 = r6.S
            r0.postScale(r2, r2)
            float r0 = r6.L
            float r2 = r6.f23714f
            float r0 = r0 + r2
            r6.L = r0
            r3 = 0
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L_0x002e
            float r2 = r6.K
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x003f
            goto L_0x0034
        L_0x002e:
            float r2 = r6.K
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x003f
        L_0x0034:
            r6.L = r2
            android.os.Handler r0 = r6.f23706ag
            java.lang.Runnable r2 = r6.f23699a
            r0.removeCallbacks(r2)
            r6.f23705af = r1
        L_0x003f:
            android.graphics.Matrix r0 = r6.f23712d
            float r1 = r6.L
            float r2 = r6.P
            r0.postTranslate(r1, r2)
            android.graphics.Bitmap r0 = r6.f23722n
            android.graphics.Matrix r1 = r6.f23712d
            r2 = 0
            r7.drawBitmap(r0, r1, r2)
            float r0 = r6.f23714f
            r1 = 1090519040(0x41000000, float:8.0)
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x009c
            r0 = 0
            int r3 = r6.f23726r
            float r4 = (float) r3
            float r5 = r6.f23730v
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x0067
            float r0 = (float) r3
            float r0 = r0 - r5
            int r0 = (int) r0
            int r0 = r0 / 2
        L_0x0067:
            float r4 = (float) r3
            float r4 = r4 - r5
            float r5 = r6.L
            float r4 = r4 - r5
            float r0 = (float) r0
            float r4 = r4 - r0
            float r3 = (float) r3
            float r3 = r3 / r1
            int r3 = (r4 > r3 ? 1 : (r4 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x00d4
            android.graphics.Bitmap r3 = r6.f23723o
            if (r3 == 0) goto L_0x00d4
            android.graphics.Matrix r3 = r6.f23712d
            r3.reset()
            android.graphics.Matrix r3 = r6.f23712d
            float r4 = r6.W
            r3.postScale(r4, r4)
            android.graphics.Matrix r3 = r6.f23712d
            float r4 = r6.f23730v
            float r5 = r6.L
            float r4 = r4 + r5
            float r4 = r4 + r0
            int r0 = r6.f23726r
            float r0 = (float) r0
            float r0 = r0 / r1
            float r4 = r4 + r0
            float r0 = r6.N
            float r4 = r4 + r0
            float r0 = r6.R
            r3.postTranslate(r4, r0)
            android.graphics.Bitmap r0 = r6.f23723o
            goto L_0x00cf
        L_0x009c:
            float r0 = r6.L
            int r3 = r6.f23726r
            float r3 = (float) r3
            float r3 = r3 / r1
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L_0x00d4
            android.graphics.Bitmap r0 = r6.f23724p
            if (r0 == 0) goto L_0x00d4
            android.graphics.Matrix r0 = r6.f23712d
            r0.reset()
            android.graphics.Matrix r0 = r6.f23712d
            float r3 = r6.V
            r0.postScale(r3, r3)
            android.graphics.Matrix r0 = r6.f23712d
            float r3 = r6.L
            int r4 = r6.f23726r
            float r4 = (float) r4
            float r4 = r4 / r1
            float r3 = r3 - r4
            float r1 = r6.f23731w
            float r3 = r3 - r1
            float r1 = r6.O
            float r3 = r3 - r1
            float r1 = r6.K
            float r3 = r3 - r1
            float r1 = r6.Q
            r0.postTranslate(r3, r1)
            android.graphics.Bitmap r0 = r6.f23724p
        L_0x00cf:
            android.graphics.Matrix r1 = r6.f23712d
            r7.drawBitmap(r0, r1, r2)
        L_0x00d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.hicamera.unity.SwitchImageView.c(android.graphics.Canvas):void");
    }

    static /* synthetic */ float d(SwitchImageView switchImageView, float f2) {
        float f3 = switchImageView.S + f2;
        switchImageView.S = f3;
        return f3;
    }

    private void d() {
        Bitmap bitmap = this.f23723o;
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = this.f23723o.getHeight();
            this.R = 0.0f;
            this.N = 0.0f;
            int i2 = this.f23726r;
            if (width > i2 || height > this.f23727s) {
                float f2 = (float) width;
                float f3 = f2 * 1.0f;
                float f4 = (float) height;
                float f5 = 1.0f * f4;
                int i3 = this.f23727s;
                if (f3 / ((float) i2) > f5 / ((float) i3)) {
                    float f6 = ((float) i2) / f3;
                    this.R = (((float) i3) - (f4 * f6)) / 2.0f;
                    this.W = f6;
                    return;
                }
                float f7 = ((float) i3) / f5;
                this.N = (((float) i2) - (f2 * f7)) / 2.0f;
                this.W = f7;
                return;
            }
            this.N = ((float) (i2 - this.f23723o.getWidth())) / 2.0f;
            this.R = ((float) (this.f23727s - this.f23723o.getHeight())) / 2.0f;
            this.W = 1.0f;
        }
    }

    private void d(Canvas canvas) {
        Bitmap bitmap;
        this.f23712d.reset();
        float f2 = this.K + this.I;
        float f3 = this.P + this.J;
        Matrix matrix = this.f23712d;
        float f4 = this.S;
        matrix.postScale(f4, f4);
        this.f23712d.postTranslate(f2, f3);
        this.K = f2;
        this.P = f3;
        Bitmap bitmap2 = this.f23722n;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, this.f23712d, (Paint) null);
        }
        float f5 = this.K;
        int i2 = this.f23726r;
        if (f5 > ((float) i2) / 8.0f) {
            this.f23712d.reset();
            Matrix matrix2 = this.f23712d;
            float f6 = this.V;
            matrix2.postScale(f6, f6);
            float f7 = ((-this.f23731w) - this.O) + this.K;
            int i3 = this.f23726r;
            float f8 = f7 - (((float) i3) / 8.0f);
            this.f23733y = f8;
            float f9 = this.f23730v;
            if (((float) i3) > f9) {
                this.f23733y = f8 - ((((float) i3) - f9) / 2.0f);
            }
            this.f23734z = this.P;
            this.A = this.S;
            this.B = f9;
            this.f23712d.postTranslate(this.f23733y, this.Q);
            bitmap = this.f23724p;
            if (bitmap == null) {
                return;
            }
        } else if (((-this.f23730v) - f5) + ((float) i2) > ((float) i2) / 8.0f) {
            this.f23712d.reset();
            Matrix matrix3 = this.f23712d;
            float f10 = this.W;
            matrix3.postScale(f10, f10);
            this.f23734z = this.P;
            this.A = this.S;
            float f11 = this.f23730v;
            this.B = f11;
            int i4 = this.f23726r;
            float f12 = this.K + f11 + (((float) i4) / 8.0f) + this.N;
            this.f23733y = f12;
            if (((float) i4) > f11) {
                this.f23733y = f12 + ((((float) i4) - f11) / 2.0f);
            }
            this.f23712d.postTranslate(this.f23733y, this.R);
            bitmap = this.f23723o;
            if (bitmap == null) {
                return;
            }
        } else {
            return;
        }
        canvas.drawBitmap(bitmap, this.f23712d, (Paint) null);
    }

    private void e(Canvas canvas) {
        Bitmap bitmap;
        if (this.f23722n == null) {
            this.f23706ag.removeCallbacks(this.f23699a);
            this.f23705af = true;
            return;
        }
        this.f23712d.reset();
        float f2 = this.L + this.I;
        float f3 = this.M + this.J;
        Matrix matrix = this.f23712d;
        float f4 = this.S;
        matrix.postScale(f4, f4);
        if (this.f23733y < 0.0f) {
            float f5 = this.K;
            if (f5 <= this.L) {
                this.f23712d.postTranslate(f5, f3);
                canvas.drawBitmap(this.f23722n, this.f23712d, (Paint) null);
                this.f23706ag.removeCallbacks(this.f23699a);
                if (this.f23703ad) {
                    this.f23704ae.setVisibility(0);
                }
                Message obtainMessage = this.f23701ab.obtainMessage();
                obtainMessage.what = 3;
                this.f23701ab.sendMessage(obtainMessage);
                this.f23705af = false;
                return;
            }
        } else {
            float f6 = this.K;
            if (f6 >= this.L) {
                this.f23712d.postTranslate(f6, f3);
                canvas.drawBitmap(this.f23722n, this.f23712d, (Paint) null);
                this.f23706ag.removeCallbacks(this.f23699a);
                if (this.f23703ad) {
                    this.f23704ae.setVisibility(0);
                }
                Message obtainMessage2 = this.f23701ab.obtainMessage();
                obtainMessage2.what = 3;
                this.f23701ab.sendMessage(obtainMessage2);
                this.f23705af = false;
                return;
            }
        }
        this.f23712d.postTranslate(f2, f3);
        canvas.drawBitmap(this.f23722n, this.f23712d, (Paint) null);
        if (this.f23733y < 0.0f) {
            int i2 = this.f23726r;
            if ((((float) i2) - this.f23730v) - f2 > ((float) i2) / 8.0f && this.f23723o != null) {
                this.f23712d.reset();
                Matrix matrix2 = this.f23712d;
                float f7 = this.A;
                matrix2.postScale(f7, f7);
                this.f23712d.postTranslate(this.f23730v + f2 + (((float) this.f23726r) / 8.0f) + this.N + this.K, this.f23734z);
                bitmap = this.f23723o;
            } else {
                return;
            }
        } else if (f2 > ((float) this.f23726r) / 8.0f && this.f23724p != null) {
            this.f23712d.reset();
            Matrix matrix3 = this.f23712d;
            float f8 = this.A;
            matrix3.postScale(f8, f8);
            this.f23712d.postTranslate((((f2 - (((float) this.f23726r) / 8.0f)) - this.B) - this.O) - this.K, this.f23734z);
            bitmap = this.f23724p;
        } else {
            return;
        }
        canvas.drawBitmap(bitmap, this.f23712d, (Paint) null);
    }

    private void f(Canvas canvas) {
        Bitmap bitmap = this.f23722n;
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = this.f23722n.getHeight();
            this.P = 0.0f;
            this.K = 0.0f;
            int i2 = this.f23726r;
            if (width > i2 || height > this.f23727s) {
                float f2 = (float) width;
                float f3 = f2 * 1.0f;
                float f4 = (float) height;
                float f5 = 1.0f * f4;
                int i3 = this.f23727s;
                if (f3 / ((float) i2) > f5 / ((float) i3)) {
                    float f6 = ((float) i2) / f3;
                    this.U = f6;
                    this.S = f6;
                    this.P = (((float) i3) - (f6 * f4)) / 2.0f;
                } else {
                    float f7 = ((float) i3) / f5;
                    this.U = f7;
                    this.S = f7;
                    this.K = (((float) i2) - (f7 * f2)) / 2.0f;
                }
                float f8 = this.U;
                this.f23730v = f2 * f8;
                this.f23732x = f4 * f8;
            } else {
                this.K = ((float) (i2 - this.f23722n.getWidth())) / 2.0f;
                this.P = ((float) (this.f23727s - this.f23722n.getHeight())) / 2.0f;
                this.U = 1.0f;
                this.S = 1.0f;
                this.f23730v = (float) width;
                this.f23732x = (float) height;
            }
            if (canvas != null) {
                this.f23712d.reset();
                Matrix matrix = this.f23712d;
                float f9 = this.U;
                matrix.postScale(f9, f9);
                this.f23712d.postTranslate(this.K, this.P);
                canvas.drawBitmap(this.f23722n, this.f23712d, (Paint) null);
                this.f23705af = true;
            }
        }
    }

    static /* synthetic */ int j(SwitchImageView switchImageView) {
        int i2 = switchImageView.f23709aj;
        switchImageView.f23709aj = i2 + 1;
        return i2;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
            Log.d("SwitchImageView", "" + this.f23725q);
            switch (this.f23725q) {
                case 0:
                    Bitmap bitmap = this.f23722n;
                    if (bitmap != null) {
                        canvas.drawBitmap(bitmap, this.f23712d, (Paint) null);
                        return;
                    }
                    return;
                case 1:
                    this.f23725q = 0;
                    f((Canvas) null);
                    d();
                    c();
                    this.I = 0.0f;
                    this.J = 0.0f;
                    float f2 = this.f23733y;
                    this.L = f2;
                    if (f2 > 0.0f) {
                        this.f23713e = (((float) (-this.f23726r)) * 1.0f) / 8.0f;
                    } else if (f2 < 0.0f) {
                        this.f23713e = (((float) this.f23726r) * 1.0f) / 8.0f;
                    }
                    this.M = this.P;
                    this.f23721m = 2;
                    this.L = f2 + this.f23713e;
                    e(canvas);
                    if (this.f23733y != 0.0f) {
                        this.f23706ag.postDelayed(this.f23699a, 0);
                        return;
                    }
                    return;
                case 2:
                    this.f23721m = 3;
                    a(canvas);
                    this.f23706ag.postDelayed(this.f23699a, 30);
                    return;
                case 3:
                    if (!this.f23703ad) {
                        b(canvas);
                        return;
                    }
                    return;
                case 4:
                    d(canvas);
                    return;
                case 5:
                    e(canvas);
                    return;
                case 6:
                    this.f23721m = 1;
                    this.f23706ag.postDelayed(this.f23699a, 30);
                    break;
                case 7:
                    f(canvas);
                    return;
                case 8:
                    break;
                case 9:
                    a(canvas);
                    return;
                default:
                    return;
            }
            c(canvas);
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.d("SwitchImageView", "trying to use a recycled bitmap");
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (z2) {
            this.f23726r = getWidth();
            this.f23727s = getHeight();
            this.f23733y = 0.0f;
            Log.d("SwitchImageView", "lastXImgMove = " + this.f23733y);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01c9, code lost:
        if (((float) r8) > r11) goto L_0x01cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0209, code lost:
        if (((float) r8) > r11) goto L_0x01cb;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0215  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x021b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r19) {
        /*
            r18 = this;
            r0 = r18
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "event.getActionMasked() = "
            r1.append(r2)
            int r2 = r19.getActionMasked()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "SwitchImageView"
            android.util.Log.d(r2, r1)
            r1 = 0
            r0.f23709aj = r1
            boolean r3 = r0.f23705af
            r4 = 1
            if (r3 != 0) goto L_0x003b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "bEnableTouch = "
            r1.append(r3)
            boolean r3 = r0.f23705af
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r2, r1)
            return r4
        L_0x003b:
            int r3 = r19.getActionMasked()
            if (r3 == 0) goto L_0x0225
            r5 = 6
            r6 = 1065353216(0x3f800000, float:1.0)
            r7 = 2
            r8 = -1082130432(0xffffffffbf800000, float:-1.0)
            r9 = 0
            if (r3 == r4) goto L_0x016b
            if (r3 == r7) goto L_0x006d
            r1 = 5
            if (r3 == r1) goto L_0x005f
            if (r3 == r5) goto L_0x0053
            goto L_0x023b
        L_0x0053:
            int r1 = r19.getPointerCount()
            if (r1 != r7) goto L_0x023b
            r0.C = r8
            r0.D = r8
            goto L_0x023b
        L_0x005f:
            int r1 = r19.getPointerCount()
            if (r1 != r7) goto L_0x023b
            double r1 = r18.a((android.view.MotionEvent) r19)
            r0.f23700aa = r1
            goto L_0x023b
        L_0x006d:
            int r1 = r19.getPointerCount()
            if (r1 != r4) goto L_0x00ed
            float r1 = r19.getX()
            float r2 = r19.getY()
            float r3 = r0.C
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 != 0) goto L_0x008b
            float r3 = r0.D
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 != 0) goto L_0x008b
            r0.C = r1
            r0.D = r2
        L_0x008b:
            r3 = 4
            r0.f23725q = r3
            float r3 = r0.C
            float r3 = r1 - r3
            r0.I = r3
            float r5 = r0.D
            float r5 = r2 - r5
            r0.J = r5
            float r6 = r0.K
            float r7 = r6 + r3
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 <= 0) goto L_0x00ad
            android.graphics.Bitmap r3 = r0.f23724p
            if (r3 == 0) goto L_0x00aa
            android.graphics.Bitmap r3 = r0.f23723o
            if (r3 != 0) goto L_0x00c1
        L_0x00aa:
            r0.I = r9
            goto L_0x00c1
        L_0x00ad:
            int r7 = r0.f23726r
            float r7 = (float) r7
            float r6 = r6 + r3
            float r7 = r7 - r6
            float r3 = r0.f23730v
            int r3 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x00c1
            android.graphics.Bitmap r3 = r0.f23724p
            if (r3 == 0) goto L_0x00aa
            android.graphics.Bitmap r3 = r0.f23723o
            if (r3 != 0) goto L_0x00c1
            goto L_0x00aa
        L_0x00c1:
            float r3 = r0.P
            float r6 = r3 + r5
            int r6 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r6 <= 0) goto L_0x00cc
        L_0x00c9:
            r0.J = r9
            goto L_0x00d8
        L_0x00cc:
            int r6 = r0.f23727s
            float r6 = (float) r6
            float r3 = r3 + r5
            float r6 = r6 - r3
            float r3 = r0.f23732x
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x00d8
            goto L_0x00c9
        L_0x00d8:
            float r3 = r0.I
            int r3 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r3 != 0) goto L_0x00e4
            float r3 = r0.J
            int r3 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r3 == 0) goto L_0x00e7
        L_0x00e4:
            r18.invalidate()
        L_0x00e7:
            r0.C = r1
            r0.D = r2
            goto L_0x023b
        L_0x00ed:
            int r1 = r19.getPointerCount()
            if (r1 != r7) goto L_0x023b
            boolean r1 = r0.f23703ad
            if (r1 != r4) goto L_0x00f8
            return r4
        L_0x00f8:
            r18.b((android.view.MotionEvent) r19)
            double r7 = r18.a((android.view.MotionEvent) r19)
            r1 = 3
            r0.f23725q = r1
            float r1 = r0.S
            float r3 = r0.U
            r5 = 1082130432(0x40800000, float:4.0)
            float r9 = r3 * r5
            int r9 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r9 > 0) goto L_0x023b
            int r9 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r9 < 0) goto L_0x023b
            double r9 = r0.f23700aa
            double r9 = r7 / r9
            float r9 = (float) r9
            r0.T = r9
            float r3 = r3 * r5
            float r1 = r1 - r3
            float r1 = java.lang.Math.abs(r1)
            double r9 = (double) r1
            r11 = 4502148214488346440(0x3e7ad7f29abcaf48, double:1.0E-7)
            int r1 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r1 >= 0) goto L_0x0133
            float r1 = r0.T
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 < 0) goto L_0x0133
            r0.f23700aa = r7
            return r4
        L_0x0133:
            float r1 = r0.S
            float r3 = r0.T
            float r1 = r1 * r3
            r0.S = r1
            float r3 = r0.U
            float r6 = r3 * r5
            int r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x015e
            float r3 = r3 * r5
            r0.S = r3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "totalRatio = "
            r1.append(r3)
            float r3 = r0.S
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r2, r1)
            goto L_0x0164
        L_0x015e:
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x0164
            r0.S = r3
        L_0x0164:
            r18.invalidate()
            r0.f23700aa = r7
            goto L_0x023b
        L_0x016b:
            r0.C = r8
            r0.D = r8
            r0.f23708ai = r4
            float r3 = r19.getX()
            r0.G = r3
            float r3 = r19.getY()
            r0.H = r3
            int r3 = r19.getPointerCount()
            if (r3 != r4) goto L_0x023b
            android.os.Handler r3 = r0.f23701ab
            android.os.Message r3 = r3.obtainMessage()
            r3.what = r1
            int r8 = r0.f23726r
            float r10 = (float) r8
            float r11 = r0.f23730v
            r12 = 1073741824(0x40000000, float:2.0)
            int r10 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r10 <= 0) goto L_0x019a
            float r10 = (float) r8
            float r10 = r10 - r11
            float r10 = r10 / r12
            goto L_0x019b
        L_0x019a:
            r10 = 0
        L_0x019b:
            float r13 = r0.K
            r0.L = r13
            float r14 = r13 - r10
            float r15 = (float) r8
            float r15 = r15 * r6
            r16 = 1090519040(0x41000000, float:8.0)
            float r15 = r15 / r16
            int r14 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
            if (r14 <= 0) goto L_0x01b1
            r3.what = r4
        L_0x01ae:
            r0.f23705af = r1
            goto L_0x0211
        L_0x01b1:
            float r14 = r13 - r10
            float r15 = (float) r8
            float r15 = r15 * r6
            float r15 = r15 / r16
            r17 = 1092616192(0x41200000, float:10.0)
            int r14 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
            if (r14 > 0) goto L_0x01dd
            float r14 = r13 - r10
            int r14 = (r14 > r9 ? 1 : (r14 == r9 ? 0 : -1))
            if (r14 <= 0) goto L_0x01dd
            r0.K = r9
            float r2 = (float) r8
            int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r2 <= 0) goto L_0x01d0
        L_0x01cb:
            float r2 = (float) r8
            float r2 = r2 - r11
            float r2 = r2 / r12
            r0.K = r2
        L_0x01d0:
            r0.f23725q = r5
            float r2 = r0.K
            float r2 = r2 - r13
            float r2 = r2 / r17
            r0.f23714f = r2
            r18.invalidate()
            goto L_0x0211
        L_0x01dd:
            float r14 = (float) r8
            float r14 = r14 - r11
            float r14 = r14 - r13
            float r14 = r14 - r10
            float r15 = (float) r8
            float r15 = r15 * r6
            float r15 = r15 / r16
            int r14 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
            if (r14 <= 0) goto L_0x01ed
            r3.what = r7
            goto L_0x01ae
        L_0x01ed:
            float r7 = (float) r8
            float r7 = r7 - r11
            float r7 = r7 - r13
            float r7 = r7 - r10
            float r14 = (float) r8
            float r14 = r14 * r6
            float r14 = r14 / r16
            int r6 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
            if (r6 > 0) goto L_0x020c
            float r6 = (float) r8
            float r6 = r6 - r11
            float r6 = r6 - r13
            float r6 = r6 - r10
            int r6 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r6 <= 0) goto L_0x020c
            float r2 = (float) r8
            float r2 = r2 - r11
            r0.K = r2
            float r2 = (float) r8
            int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r2 <= 0) goto L_0x01d0
            goto L_0x01cb
        L_0x020c:
            java.lang.String r5 = "no-operation"
            android.util.Log.d(r2, r5)
        L_0x0211:
            int r2 = r3.what
            if (r2 == 0) goto L_0x021b
            android.os.Handler r1 = r0.f23701ab
            r1.sendMessage(r3)
            goto L_0x023b
        L_0x021b:
            boolean r2 = r0.f23703ad
            if (r2 != r4) goto L_0x023b
            android.widget.ImageView r2 = r0.f23704ae
            r2.setVisibility(r1)
            goto L_0x023b
        L_0x0225:
            android.widget.ImageView r1 = r0.f23704ae
            r2 = 8
            r1.setVisibility(r2)
            r18.a()
            float r1 = r19.getX()
            r0.E = r1
            float r1 = r19.getY()
            r0.F = r1
        L_0x023b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.hicamera.unity.SwitchImageView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setPlayBtn(ImageView imageView) {
        this.f23704ae = imageView;
    }
}
