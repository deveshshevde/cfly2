package com.huantansheng.easyphotos.models.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.b;
import com.huantansheng.easyphotos.R;
import java.util.Objects;

public class TextSticker extends View {
    private int A;
    private int B = 300;
    private int C = 100;
    private float D;
    private StaticLayout E;
    private int F;
    private Canvas G;
    private Path H;

    /* renamed from: a  reason: collision with root package name */
    public boolean f20489a = false;

    /* renamed from: b  reason: collision with root package name */
    private String f20490b;

    /* renamed from: c  reason: collision with root package name */
    private float f20491c;

    /* renamed from: d  reason: collision with root package name */
    private float f20492d;

    /* renamed from: e  reason: collision with root package name */
    private Bitmap f20493e;

    /* renamed from: f  reason: collision with root package name */
    private Bitmap f20494f;

    /* renamed from: g  reason: collision with root package name */
    private Bitmap f20495g;

    /* renamed from: h  reason: collision with root package name */
    private int f20496h;

    /* renamed from: i  reason: collision with root package name */
    private Matrix f20497i;

    /* renamed from: j  reason: collision with root package name */
    private float[] f20498j;

    /* renamed from: k  reason: collision with root package name */
    private float[] f20499k;

    /* renamed from: l  reason: collision with root package name */
    private TextPaint f20500l;

    /* renamed from: m  reason: collision with root package name */
    private Paint f20501m;

    /* renamed from: n  reason: collision with root package name */
    private Paint f20502n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f20503o = true;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public float f20504p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public float f20505q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public float f20506r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public float f20507s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public ClickType f20508t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f20509u = false;

    /* renamed from: v  reason: collision with root package name */
    private GestureDetector f20510v;

    /* renamed from: w  reason: collision with root package name */
    private float f20511w;

    /* renamed from: x  reason: collision with root package name */
    private float f20512x;

    /* renamed from: y  reason: collision with root package name */
    private ho.a f20513y;

    /* renamed from: z  reason: collision with root package name */
    private int f20514z;

    /* renamed from: com.huantansheng.easyphotos.models.sticker.view.TextSticker$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f20515a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huantansheng.easyphotos.models.sticker.view.TextSticker$ClickType[] r0 = com.huantansheng.easyphotos.models.sticker.view.TextSticker.ClickType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f20515a = r0
                com.huantansheng.easyphotos.models.sticker.view.TextSticker$ClickType r1 = com.huantansheng.easyphotos.models.sticker.view.TextSticker.ClickType.DELETE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f20515a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huantansheng.easyphotos.models.sticker.view.TextSticker$ClickType r1 = com.huantansheng.easyphotos.models.sticker.view.TextSticker.ClickType.EDITOR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f20515a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huantansheng.easyphotos.models.sticker.view.TextSticker$ClickType r1 = com.huantansheng.easyphotos.models.sticker.view.TextSticker.ClickType.SCALE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f20515a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huantansheng.easyphotos.models.sticker.view.TextSticker$ClickType r1 = com.huantansheng.easyphotos.models.sticker.view.TextSticker.ClickType.ROTATE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f20515a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huantansheng.easyphotos.models.sticker.view.TextSticker$ClickType r1 = com.huantansheng.easyphotos.models.sticker.view.TextSticker.ClickType.IMAGE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f20515a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.huantansheng.easyphotos.models.sticker.view.TextSticker$ClickType r1 = com.huantansheng.easyphotos.models.sticker.view.TextSticker.ClickType.OUT     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huantansheng.easyphotos.models.sticker.view.TextSticker.AnonymousClass1.<clinit>():void");
        }
    }

    private enum ClickType {
        DELETE,
        EDITOR,
        SCALE,
        ROTATE,
        IMAGE,
        OUT
    }

    private class a extends GestureDetector.SimpleOnGestureListener {
        private a() {
        }

        /* synthetic */ a(TextSticker textSticker, AnonymousClass1 r2) {
            this();
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (AnonymousClass1.f20515a[TextSticker.this.f20508t.ordinal()] == 5) {
                TextSticker.this.j();
            }
            return super.onDoubleTap(motionEvent);
        }

        public boolean onDown(MotionEvent motionEvent) {
            TextSticker.this.f20489a = true;
            TextSticker.this.b((int) motionEvent.getX(), (int) motionEvent.getY());
            if (TextSticker.this.f20508t == ClickType.IMAGE) {
                TextSticker.this.k();
            }
            return true;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0066, code lost:
            if (r5.getPointerCount() > 1) goto L_0x006e;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onScroll(android.view.MotionEvent r4, android.view.MotionEvent r5, float r6, float r7) {
            /*
                r3 = this;
                int[] r4 = com.huantansheng.easyphotos.models.sticker.view.TextSticker.AnonymousClass1.f20515a
                com.huantansheng.easyphotos.models.sticker.view.TextSticker r0 = com.huantansheng.easyphotos.models.sticker.view.TextSticker.this
                com.huantansheng.easyphotos.models.sticker.view.TextSticker$ClickType r0 = r0.f20508t
                int r0 = r0.ordinal()
                r4 = r4[r0]
                r0 = 3
                r1 = 1
                if (r4 == r0) goto L_0x0062
                r0 = 5
                if (r4 == r0) goto L_0x0016
                goto L_0x006e
            L_0x0016:
                int r4 = r5.getPointerCount()
                r0 = 2
                if (r4 != r0) goto L_0x0054
                com.huantansheng.easyphotos.models.sticker.view.TextSticker r4 = com.huantansheng.easyphotos.models.sticker.view.TextSticker.this
                float r4 = r4.f20504p
                com.huantansheng.easyphotos.models.sticker.view.TextSticker r6 = com.huantansheng.easyphotos.models.sticker.view.TextSticker.this
                float r6 = r6.f20505q
                float r4 = r4 + r6
                com.huantansheng.easyphotos.models.sticker.view.TextSticker r6 = com.huantansheng.easyphotos.models.sticker.view.TextSticker.this
                float r6 = r6.f20506r
                float r4 = r4 + r6
                com.huantansheng.easyphotos.models.sticker.view.TextSticker r6 = com.huantansheng.easyphotos.models.sticker.view.TextSticker.this
                float r6 = r6.f20507s
                float r4 = r4 + r6
                r6 = 0
                int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r4 != 0) goto L_0x0069
                com.huantansheng.easyphotos.models.sticker.view.TextSticker r4 = com.huantansheng.easyphotos.models.sticker.view.TextSticker.this
                r6 = 0
                float r7 = r5.getX(r6)
                float r6 = r5.getY(r6)
                float r0 = r5.getX(r1)
                float r2 = r5.getY(r1)
                r4.a(r7, r6, r0, r2)
                goto L_0x0069
            L_0x0054:
                int r4 = r5.getPointerCount()
                if (r4 != r1) goto L_0x006e
                com.huantansheng.easyphotos.models.sticker.view.TextSticker r4 = com.huantansheng.easyphotos.models.sticker.view.TextSticker.this
                float r5 = -r6
                float r6 = -r7
                r4.b((float) r5, (float) r6)
                goto L_0x006e
            L_0x0062:
                int r4 = r5.getPointerCount()
                if (r4 <= r1) goto L_0x0069
                goto L_0x006e
            L_0x0069:
                com.huantansheng.easyphotos.models.sticker.view.TextSticker r4 = com.huantansheng.easyphotos.models.sticker.view.TextSticker.this
                r4.a((android.view.MotionEvent) r5)
            L_0x006e:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huantansheng.easyphotos.models.sticker.view.TextSticker.a.onScroll(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean");
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (AnonymousClass1.f20515a[TextSticker.this.f20508t.ordinal()] == 1) {
                TextSticker.this.a();
            }
            return true;
        }
    }

    public TextSticker(Context context, String str, int i2, int i3) {
        super(context);
        this.f20490b = str;
        if (TextUtils.isEmpty(str)) {
            this.f20490b = context.getString(R.string.text_sticker_hint_easy_photos);
        }
        this.H = new Path();
        this.F = getResources().getDisplayMetrics().widthPixels / 2;
        i();
        f();
        g();
        a(i2, i3);
        h();
        c();
        e();
        d();
        this.f20511w = a(new Point((int) this.f20491c, (int) this.f20492d), new Point(((int) this.f20491c) / 2, ((int) this.f20492d) / 2));
        this.f20512x = 1000.0f;
        this.f20510v = new GestureDetector(context, new a(this, (AnonymousClass1) null));
    }

    /* access modifiers changed from: private */
    public void a(float f2, float f3, float f4, float f5) {
        this.f20504p = f2;
        this.f20505q = f3;
        this.f20506r = f4;
        this.f20507s = f5;
    }

    private void a(int i2, int i3) {
        int i4 = i2 - (((int) this.f20491c) / 2);
        this.f20514z = i4;
        if (i4 < 100) {
            this.f20514z = i2 / 2;
        }
        int i5 = i3 - (((int) this.f20492d) / 2);
        this.A = i5;
        if (i5 < 100) {
            this.A = i3 / 2;
        }
    }

    private void a(Canvas canvas) {
        Canvas canvas2 = canvas;
        this.H.reset();
        Path path = this.H;
        float[] fArr = this.f20499k;
        path.moveTo(fArr[0], fArr[1]);
        Path path2 = this.H;
        float[] fArr2 = this.f20499k;
        path2.lineTo(fArr2[2], fArr2[3]);
        Path path3 = this.H;
        float[] fArr3 = this.f20499k;
        path3.lineTo(fArr3[4], fArr3[5]);
        Path path4 = this.H;
        float[] fArr4 = this.f20499k;
        path4.lineTo(fArr4[6], fArr4[7]);
        Path path5 = this.H;
        float[] fArr5 = this.f20499k;
        path5.lineTo(fArr5[0], fArr5[1]);
        int i2 = 0;
        while (true) {
            if (i2 >= 7) {
                break;
            }
            float[] fArr6 = this.f20499k;
            if (i2 == 6) {
                canvas.drawLine(fArr6[i2], fArr6[i2 + 1], fArr6[0], fArr6[1], this.f20502n);
                break;
            }
            int i3 = i2 + 2;
            canvas.drawLine(fArr6[i2], fArr6[i2 + 1], fArr6[i3], fArr6[i2 + 3], this.f20502n);
            i2 = i3;
        }
        Bitmap bitmap = this.f20494f;
        float[] fArr7 = this.f20499k;
        float f2 = fArr7[2];
        int i4 = this.f20496h;
        canvas2.drawBitmap(bitmap, f2 - ((float) (i4 / 2)), fArr7[3] - ((float) (i4 / 2)), this.f20501m);
        Bitmap bitmap2 = this.f20495g;
        float[] fArr8 = this.f20499k;
        float f3 = fArr8[4];
        int i5 = this.f20496h;
        canvas2.drawBitmap(bitmap2, f3 - ((float) (i5 / 2)), fArr8[5] - ((float) (i5 / 2)), this.f20501m);
    }

    /* access modifiers changed from: private */
    public void a(MotionEvent motionEvent) {
        b(motionEvent);
        c(motionEvent);
    }

    private float b(float f2, float f3, float f4, float f5) {
        float f6 = f2 - f4;
        float f7 = f3 - f5;
        return (float) Math.sqrt((double) ((f6 * f6) + (f7 * f7)));
    }

    /* access modifiers changed from: private */
    public void b(float f2, float f3) {
        this.f20497i.postTranslate(f2, f3);
        l();
    }

    /* access modifiers changed from: private */
    public void b(int i2, int i3) {
        ClickType clickType;
        int i4 = this.f20496h;
        RectF rectF = new RectF((float) ((i2 - (i4 / 2)) - 40), (float) ((i3 - (i4 / 2)) - 40), (float) ((i4 / 2) + i2 + 40), (float) ((i4 / 2) + i3 + 40));
        new Rect();
        float[] fArr = this.f20499k;
        if (rectF.contains(fArr[2] - 20.0f, fArr[3])) {
            clickType = ClickType.DELETE;
        } else {
            float[] fArr2 = this.f20499k;
            if (rectF.contains(fArr2[4] + 20.0f, fArr2[5])) {
                clickType = ClickType.SCALE;
            } else {
                RectF rectF2 = new RectF();
                this.H.computeBounds(rectF2, true);
                Region region = new Region();
                region.setPath(this.H, new Region((int) rectF2.left, (int) rectF2.top, (int) rectF2.right, (int) rectF2.bottom));
                if (region.contains(i2, i3)) {
                    if (this.f20509u) {
                        this.f20509u = false;
                    }
                    if (!this.f20503o) {
                        this.f20503o = true;
                        this.f20513y.d();
                        postInvalidate();
                    }
                    clickType = ClickType.IMAGE;
                } else {
                    if (this.f20503o) {
                        this.f20503o = false;
                        postInvalidate();
                    }
                    if (!this.f20509u) {
                        this.f20509u = true;
                    }
                    clickType = ClickType.OUT;
                }
            }
        }
        this.f20508t = clickType;
    }

    private void b(MotionEvent motionEvent) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        if (motionEvent.getPointerCount() == 2) {
            f9 = this.f20506r;
            f6 = this.f20507s;
            f5 = this.f20504p;
            f4 = this.f20505q;
            f3 = motionEvent.getX(1);
            f8 = motionEvent.getY(1);
            f2 = motionEvent.getX(0);
            f7 = motionEvent.getY(0);
        } else {
            float[] fArr = this.f20499k;
            float f10 = fArr[4];
            float f11 = fArr[5];
            float f12 = fArr[0];
            f4 = fArr[1];
            f3 = motionEvent.getX();
            f8 = motionEvent.getY();
            f2 = f12;
            f9 = f10;
            f6 = f11;
            f5 = f2;
            f7 = f4;
        }
        float b2 = b(f3, f8, f2, f7) / b(f9, f6, f5, f4);
        if (getScaleValue() >= this.D || b2 >= 1.0f) {
            Matrix matrix = this.f20497i;
            float[] fArr2 = this.f20499k;
            matrix.postScale(b2, b2, fArr2[8], fArr2[9]);
            l();
            if (motionEvent.getPointerCount() == 2) {
                a(f2, f7, f3, f8);
            }
        }
    }

    private void c() {
        com.huantansheng.easyphotos.a.a(this.f20493e);
        this.f20493e = Bitmap.createBitmap((int) this.f20491c, (int) this.f20492d, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(this.f20493e);
        this.G = canvas;
        this.E.draw(canvas);
    }

    private void c(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() == 2) {
            float a2 = a(new Point((int) motionEvent.getX(0), (int) motionEvent.getY(0)), new Point((int) motionEvent.getX(1), (int) motionEvent.getY(1)));
            if (this.f20512x == 1000.0f) {
                this.f20512x = a2;
            }
            float[] fArr = this.f20499k;
            this.f20497i.postRotate(a2 - this.f20512x, fArr[8], fArr[9]);
            l();
            this.f20512x = a2;
            return;
        }
        Point point = new Point((int) motionEvent.getX(), (int) motionEvent.getY());
        float[] fArr2 = this.f20499k;
        float a3 = a(point, new Point((int) fArr2[8], (int) fArr2[9]));
        float[] fArr3 = this.f20499k;
        this.f20497i.postRotate(a3 - this.f20511w, fArr3[8], fArr3[9]);
        l();
        this.f20511w = a3;
    }

    private void d() {
        this.f20497i.postTranslate((float) this.f20514z, (float) this.A);
        this.f20497i.mapPoints(this.f20499k, this.f20498j);
    }

    private void e() {
        this.f20497i = new Matrix();
    }

    private void f() {
        TextPaint textPaint = new TextPaint();
        this.f20500l = textPaint;
        textPaint.setAntiAlias(true);
        this.f20500l.setDither(true);
        this.f20500l.setFilterBitmap(true);
        this.f20500l.setTypeface(Typeface.DEFAULT_BOLD);
        this.f20500l.setTextSize((float) getResources().getDimensionPixelSize(R.dimen.sticker_text_size_easy_photos));
        this.f20500l.setColor(-1);
        Paint paint = new Paint();
        this.f20501m = paint;
        paint.setAntiAlias(true);
        this.f20501m.setDither(true);
        this.f20501m.setFilterBitmap(true);
        Paint paint2 = new Paint();
        this.f20502n = paint2;
        paint2.setAntiAlias(true);
        this.f20501m.setDither(true);
        this.f20501m.setFilterBitmap(true);
        this.f20502n.setStrokeWidth(1.0f);
        this.f20502n.setColor(b.c(getContext(), 17170443));
    }

    private void g() {
        StaticLayout staticLayout = new StaticLayout(this.f20490b, this.f20500l, this.F, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true);
        this.E = staticLayout;
        float f2 = (float) this.B;
        this.f20491c = f2;
        this.f20492d = (float) this.C;
        if (f2 < ((float) staticLayout.getWidth())) {
            this.f20491c = (float) this.E.getWidth();
        }
        if (this.f20492d < ((float) this.E.getHeight())) {
            this.f20492d = (float) this.E.getHeight();
        }
        this.D = ((float) this.B) / this.f20491c;
    }

    private void h() {
        float f2 = this.f20491c;
        float f3 = this.f20492d;
        float[] fArr = {0.0f, 0.0f, f2, 0.0f, f2, f3, 0.0f, f3, f2 / 2.0f, f3 / 2.0f};
        this.f20498j = fArr;
        this.f20499k = (float[]) fArr.clone();
    }

    private void i() {
        this.f20494f = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_delete_easy_photos);
        this.f20495g = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_controller_easy_photos);
        this.f20496h = this.f20494f.getWidth();
    }

    /* access modifiers changed from: private */
    public void j() {
        this.f20513y.b();
    }

    /* access modifiers changed from: private */
    public void k() {
        bringToFront();
        invalidate();
        this.f20513y.c();
    }

    private void l() {
        this.f20497i.mapPoints(this.f20499k, this.f20498j);
        postInvalidate();
    }

    private void m() {
        float f2 = this.f20491c;
        float f3 = this.f20492d;
        this.f20498j = new float[]{0.0f, 0.0f, f2, 0.0f, f2, f3, 0.0f, f3, f2 / 2.0f, f3 / 2.0f};
    }

    public float a(Point point, Point point2) {
        float f2;
        float f3 = (float) (point.x - point2.x);
        float f4 = (float) (point.y - point2.y);
        double d2 = (double) f3;
        double sqrt = Math.sqrt((double) ((f3 * f3) + (f4 * f4)));
        Double.isNaN(d2);
        float asin = (float) ((Math.asin(d2 / sqrt) * 180.0d) / 3.141592653589793d);
        if (!Float.isNaN(asin)) {
            if (f3 >= 0.0f && f4 <= 0.0f) {
                return asin;
            }
            if (f3 <= 0.0f && f4 <= 0.0f) {
                return asin;
            }
            if (f3 <= 0.0f && f4 >= 0.0f) {
                f2 = -180.0f;
            } else if (f3 >= 0.0f && f4 >= 0.0f) {
                f2 = 180.0f;
            }
            return f2 - asin;
        }
        return 0.0f;
    }

    public void a() {
        Objects.requireNonNull(this.f20513y, "OnStickerClickListener listener is null");
        setVisibility(8);
        com.huantansheng.easyphotos.a.a(this.f20493e);
        this.f20513y.a();
    }

    public void a(float f2, float f3) {
        float[] fArr = this.f20499k;
        b(f2 - fArr[8], f3 - fArr[1]);
    }

    public void a(String str) {
        this.f20490b = str;
        g();
        m();
        c();
        l();
    }

    public boolean b() {
        return this.f20503o;
    }

    public float getScaleValue() {
        float[] fArr = this.f20498j;
        float f2 = ((fArr[8] - fArr[0]) * (fArr[8] - fArr[0])) + ((fArr[9] - fArr[1]) * (fArr[9] - fArr[1]));
        float[] fArr2 = this.f20499k;
        return (float) Math.sqrt((double) ((((fArr2[8] - fArr2[0]) * (fArr2[8] - fArr2[0])) + ((fArr2[9] - fArr2[1]) * (fArr2[9] - fArr2[1]))) / f2));
    }

    public String getText() {
        return this.f20490b;
    }

    public int getTextAlpha() {
        return this.f20500l.getAlpha();
    }

    public int getTextColor() {
        return this.f20500l.getColor();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.f20493e, this.f20497i, this.f20501m);
        if (this.f20503o) {
            a(canvas);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f20510v.onTouchEvent(motionEvent);
        if (1 == motionEvent.getAction() || 6 == motionEvent.getAction() || 6 == motionEvent.getAction() || 262 == motionEvent.getAction()) {
            a(0.0f, 0.0f, 0.0f, 0.0f);
            this.f20512x = 1000.0f;
            float[] fArr = this.f20499k;
            Point point = new Point((int) fArr[4], (int) fArr[5]);
            float[] fArr2 = this.f20499k;
            this.f20511w = a(point, new Point((int) fArr2[8], (int) fArr2[9]));
        }
        return !this.f20509u;
    }

    public void setOnStickerClickListener(ho.a aVar) {
        this.f20513y = aVar;
    }

    public void setTextAlpha(int i2) {
        this.f20500l.setAlpha(i2);
        g();
        m();
        c();
        l();
    }

    public void setTextColor(int i2) {
        this.f20500l.setColor(i2);
        g();
        m();
        c();
        l();
    }

    public void setUsing(boolean z2) {
        this.f20503o = z2;
        postInvalidate();
    }
}
