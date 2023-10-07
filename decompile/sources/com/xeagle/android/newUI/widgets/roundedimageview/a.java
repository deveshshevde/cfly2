package com.xeagle.android.newUI.widgets.roundedimageview;

import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import android.widget.ImageView;
import java.util.HashSet;

public class a extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    private final RectF f24156a = new RectF();

    /* renamed from: b  reason: collision with root package name */
    private final RectF f24157b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    private final RectF f24158c;

    /* renamed from: d  reason: collision with root package name */
    private final Bitmap f24159d;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f24160e;

    /* renamed from: f  reason: collision with root package name */
    private final int f24161f;

    /* renamed from: g  reason: collision with root package name */
    private final int f24162g;

    /* renamed from: h  reason: collision with root package name */
    private final RectF f24163h;

    /* renamed from: i  reason: collision with root package name */
    private final Paint f24164i;

    /* renamed from: j  reason: collision with root package name */
    private final Matrix f24165j;

    /* renamed from: k  reason: collision with root package name */
    private final RectF f24166k;

    /* renamed from: l  reason: collision with root package name */
    private Shader.TileMode f24167l;

    /* renamed from: m  reason: collision with root package name */
    private Shader.TileMode f24168m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f24169n;

    /* renamed from: o  reason: collision with root package name */
    private float f24170o;

    /* renamed from: p  reason: collision with root package name */
    private final boolean[] f24171p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f24172q;

    /* renamed from: r  reason: collision with root package name */
    private float f24173r;

    /* renamed from: s  reason: collision with root package name */
    private ColorStateList f24174s;

    /* renamed from: t  reason: collision with root package name */
    private ImageView.ScaleType f24175t;

    /* renamed from: com.xeagle.android.newUI.widgets.roundedimageview.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24176a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                android.widget.ImageView$ScaleType[] r0 = android.widget.ImageView.ScaleType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f24176a = r0
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f24176a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f24176a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f24176a     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f24176a     // Catch:{ NoSuchFieldError -> 0x003e }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f24176a     // Catch:{ NoSuchFieldError -> 0x0049 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f24176a     // Catch:{ NoSuchFieldError -> 0x0054 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.newUI.widgets.roundedimageview.a.AnonymousClass1.<clinit>():void");
        }
    }

    public a(Bitmap bitmap) {
        RectF rectF = new RectF();
        this.f24158c = rectF;
        this.f24163h = new RectF();
        this.f24165j = new Matrix();
        this.f24166k = new RectF();
        this.f24167l = Shader.TileMode.CLAMP;
        this.f24168m = Shader.TileMode.CLAMP;
        this.f24169n = true;
        this.f24170o = 0.0f;
        this.f24171p = new boolean[]{true, true, true, true};
        this.f24172q = false;
        this.f24173r = 0.0f;
        this.f24174s = ColorStateList.valueOf(-16777216);
        this.f24175t = ImageView.ScaleType.FIT_CENTER;
        this.f24159d = bitmap;
        int width = bitmap.getWidth();
        this.f24161f = width;
        int height = bitmap.getHeight();
        this.f24162g = height;
        rectF.set(0.0f, 0.0f, (float) width, (float) height);
        Paint paint = new Paint();
        this.f24160e = paint;
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f24164i = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        paint2.setColor(this.f24174s.getColorForState(getState(), -16777216));
        paint2.setStrokeWidth(this.f24173r);
    }

    public static Drawable a(Drawable drawable) {
        if (drawable == null || (drawable instanceof a)) {
            return drawable;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i2 = 0; i2 < numberOfLayers; i2++) {
                layerDrawable.setDrawableByLayerId(layerDrawable.getId(i2), a(layerDrawable.getDrawable(i2)));
            }
            return layerDrawable;
        }
        Bitmap b2 = b(drawable);
        return b2 != null ? new a(b2) : drawable;
    }

    public static a a(Bitmap bitmap) {
        if (bitmap != null) {
            return new a(bitmap);
        }
        return null;
    }

    private void a() {
        float f2;
        float f3;
        Matrix matrix;
        RectF rectF;
        RectF rectF2;
        Matrix.ScaleToFit scaleToFit;
        int i2 = AnonymousClass1.f24176a[this.f24175t.ordinal()];
        if (i2 == 1) {
            this.f24163h.set(this.f24156a);
            RectF rectF3 = this.f24163h;
            float f4 = this.f24173r;
            rectF3.inset(f4 / 2.0f, f4 / 2.0f);
            this.f24165j.reset();
            this.f24165j.setTranslate((float) ((int) (((this.f24163h.width() - ((float) this.f24161f)) * 0.5f) + 0.5f)), (float) ((int) (((this.f24163h.height() - ((float) this.f24162g)) * 0.5f) + 0.5f)));
        } else if (i2 != 2) {
            if (i2 != 3) {
                if (i2 == 5) {
                    this.f24163h.set(this.f24158c);
                    matrix = this.f24165j;
                    rectF = this.f24158c;
                    rectF2 = this.f24156a;
                    scaleToFit = Matrix.ScaleToFit.END;
                } else if (i2 == 6) {
                    this.f24163h.set(this.f24158c);
                    matrix = this.f24165j;
                    rectF = this.f24158c;
                    rectF2 = this.f24156a;
                    scaleToFit = Matrix.ScaleToFit.START;
                } else if (i2 != 7) {
                    this.f24163h.set(this.f24158c);
                    matrix = this.f24165j;
                    rectF = this.f24158c;
                    rectF2 = this.f24156a;
                    scaleToFit = Matrix.ScaleToFit.CENTER;
                } else {
                    this.f24163h.set(this.f24156a);
                    RectF rectF4 = this.f24163h;
                    float f5 = this.f24173r;
                    rectF4.inset(f5 / 2.0f, f5 / 2.0f);
                    this.f24165j.reset();
                    this.f24165j.setRectToRect(this.f24158c, this.f24163h, Matrix.ScaleToFit.FILL);
                }
                matrix.setRectToRect(rectF, rectF2, scaleToFit);
            } else {
                this.f24165j.reset();
                float min = (((float) this.f24161f) > this.f24156a.width() || ((float) this.f24162g) > this.f24156a.height()) ? Math.min(this.f24156a.width() / ((float) this.f24161f), this.f24156a.height() / ((float) this.f24162g)) : 1.0f;
                this.f24165j.setScale(min, min);
                this.f24165j.postTranslate((float) ((int) (((this.f24156a.width() - (((float) this.f24161f) * min)) * 0.5f) + 0.5f)), (float) ((int) (((this.f24156a.height() - (((float) this.f24162g) * min)) * 0.5f) + 0.5f)));
                this.f24163h.set(this.f24158c);
            }
            this.f24165j.mapRect(this.f24163h);
            RectF rectF5 = this.f24163h;
            float f6 = this.f24173r;
            rectF5.inset(f6 / 2.0f, f6 / 2.0f);
            this.f24165j.setRectToRect(this.f24158c, this.f24163h, Matrix.ScaleToFit.FILL);
        } else {
            this.f24163h.set(this.f24156a);
            RectF rectF6 = this.f24163h;
            float f7 = this.f24173r;
            rectF6.inset(f7 / 2.0f, f7 / 2.0f);
            this.f24165j.reset();
            float f8 = 0.0f;
            if (((float) this.f24161f) * this.f24163h.height() > this.f24163h.width() * ((float) this.f24162g)) {
                f3 = this.f24163h.height() / ((float) this.f24162g);
                f8 = (this.f24163h.width() - (((float) this.f24161f) * f3)) * 0.5f;
                f2 = 0.0f;
            } else {
                f3 = this.f24163h.width() / ((float) this.f24161f);
                f2 = (this.f24163h.height() - (((float) this.f24162g) * f3)) * 0.5f;
            }
            this.f24165j.setScale(f3, f3);
            Matrix matrix2 = this.f24165j;
            float f9 = this.f24173r;
            matrix2.postTranslate(((float) ((int) (f8 + 0.5f))) + (f9 / 2.0f), ((float) ((int) (f2 + 0.5f))) + (f9 / 2.0f));
        }
        this.f24157b.set(this.f24163h);
    }

    private void a(Canvas canvas) {
        if (!b(this.f24171p) && this.f24170o != 0.0f) {
            float f2 = this.f24157b.left;
            float f3 = this.f24157b.top;
            float width = this.f24157b.width() + f2;
            float height = this.f24157b.height() + f3;
            float f4 = this.f24170o;
            if (!this.f24171p[0]) {
                this.f24166k.set(f2, f3, f2 + f4, f3 + f4);
                canvas.drawRect(this.f24166k, this.f24160e);
            }
            if (!this.f24171p[1]) {
                this.f24166k.set(width - f4, f3, width, f4);
                canvas.drawRect(this.f24166k, this.f24160e);
            }
            if (!this.f24171p[2]) {
                this.f24166k.set(width - f4, height - f4, width, height);
                canvas.drawRect(this.f24166k, this.f24160e);
            }
            if (!this.f24171p[3]) {
                this.f24166k.set(f2, height - f4, f4 + f2, height);
                canvas.drawRect(this.f24166k, this.f24160e);
            }
        }
    }

    private static boolean a(boolean[] zArr) {
        for (boolean z2 : zArr) {
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public static Bitmap b(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(Math.max(drawable.getIntrinsicWidth(), 2), Math.max(drawable.getIntrinsicHeight(), 2), Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (Exception e2) {
            e2.printStackTrace();
            Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
            return null;
        }
    }

    private void b(Canvas canvas) {
        if (!b(this.f24171p) && this.f24170o != 0.0f) {
            float f2 = this.f24157b.left;
            float f3 = this.f24157b.top;
            float width = f2 + this.f24157b.width();
            float height = f3 + this.f24157b.height();
            float f4 = this.f24170o;
            float f5 = this.f24173r / 2.0f;
            if (!this.f24171p[0]) {
                canvas.drawLine(f2 - f5, f3, f2 + f4, f3, this.f24164i);
                canvas.drawLine(f2, f3 - f5, f2, f3 + f4, this.f24164i);
            }
            if (!this.f24171p[1]) {
                Canvas canvas2 = canvas;
                float f6 = width;
                canvas2.drawLine((width - f4) - f5, f3, f6, f3, this.f24164i);
                canvas2.drawLine(width, f3 - f5, f6, f3 + f4, this.f24164i);
            }
            if (!this.f24171p[2]) {
                Canvas canvas3 = canvas;
                float f7 = height;
                canvas3.drawLine((width - f4) - f5, height, width + f5, f7, this.f24164i);
                canvas3.drawLine(width, height - f4, width, f7, this.f24164i);
            }
            if (!this.f24171p[3]) {
                canvas.drawLine(f2 - f5, height, f2 + f4, height, this.f24164i);
                canvas.drawLine(f2, height - f4, f2, height, this.f24164i);
            }
        }
    }

    private static boolean b(boolean[] zArr) {
        for (boolean z2 : zArr) {
            if (z2) {
                return false;
            }
        }
        return true;
    }

    public a a(float f2) {
        this.f24173r = f2;
        this.f24164i.setStrokeWidth(f2);
        return this;
    }

    public a a(float f2, float f3, float f4, float f5) {
        HashSet hashSet = new HashSet(4);
        hashSet.add(Float.valueOf(f2));
        hashSet.add(Float.valueOf(f3));
        hashSet.add(Float.valueOf(f4));
        hashSet.add(Float.valueOf(f5));
        hashSet.remove(Float.valueOf(0.0f));
        boolean z2 = true;
        if (hashSet.size() <= 1) {
            if (!hashSet.isEmpty()) {
                float floatValue = ((Float) hashSet.iterator().next()).floatValue();
                if (Float.isInfinite(floatValue) || Float.isNaN(floatValue) || floatValue < 0.0f) {
                    throw new IllegalArgumentException("Invalid radius value: " + floatValue);
                }
                this.f24170o = floatValue;
            } else {
                this.f24170o = 0.0f;
            }
            boolean[] zArr = this.f24171p;
            zArr[0] = f2 > 0.0f;
            zArr[1] = f3 > 0.0f;
            zArr[2] = f4 > 0.0f;
            if (f5 <= 0.0f) {
                z2 = false;
            }
            zArr[3] = z2;
            return this;
        }
        throw new IllegalArgumentException("Multiple nonzero corner radii not yet supported.");
    }

    public a a(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f24174s = colorStateList;
        this.f24164i.setColor(colorStateList.getColorForState(getState(), -16777216));
        return this;
    }

    public a a(Shader.TileMode tileMode) {
        if (this.f24167l != tileMode) {
            this.f24167l = tileMode;
            this.f24169n = true;
            invalidateSelf();
        }
        return this;
    }

    public a a(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            scaleType = ImageView.ScaleType.FIT_CENTER;
        }
        if (this.f24175t != scaleType) {
            this.f24175t = scaleType;
            a();
        }
        return this;
    }

    public a a(boolean z2) {
        this.f24172q = z2;
        return this;
    }

    public a b(Shader.TileMode tileMode) {
        if (this.f24168m != tileMode) {
            this.f24168m = tileMode;
            this.f24169n = true;
            invalidateSelf();
        }
        return this;
    }

    public void draw(Canvas canvas) {
        Paint paint;
        RectF rectF;
        if (this.f24169n) {
            BitmapShader bitmapShader = new BitmapShader(this.f24159d, this.f24167l, this.f24168m);
            if (this.f24167l == Shader.TileMode.CLAMP && this.f24168m == Shader.TileMode.CLAMP) {
                bitmapShader.setLocalMatrix(this.f24165j);
            }
            this.f24160e.setShader(bitmapShader);
            this.f24169n = false;
        }
        if (this.f24172q) {
            if (this.f24173r > 0.0f) {
                canvas.drawOval(this.f24157b, this.f24160e);
                rectF = this.f24163h;
                paint = this.f24164i;
            } else {
                rectF = this.f24157b;
                paint = this.f24160e;
            }
            canvas.drawOval(rectF, paint);
        } else if (a(this.f24171p)) {
            float f2 = this.f24170o;
            if (this.f24173r > 0.0f) {
                canvas.drawRoundRect(this.f24157b, f2, f2, this.f24160e);
                canvas.drawRoundRect(this.f24163h, f2, f2, this.f24164i);
                a(canvas);
                b(canvas);
                return;
            }
            canvas.drawRoundRect(this.f24157b, f2, f2, this.f24160e);
            a(canvas);
        } else {
            canvas.drawRect(this.f24157b, this.f24160e);
            if (this.f24173r > 0.0f) {
                canvas.drawRect(this.f24163h, this.f24164i);
            }
        }
    }

    public int getAlpha() {
        return this.f24160e.getAlpha();
    }

    public ColorFilter getColorFilter() {
        return this.f24160e.getColorFilter();
    }

    public int getIntrinsicHeight() {
        return this.f24162g;
    }

    public int getIntrinsicWidth() {
        return this.f24161f;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isStateful() {
        return this.f24174s.isStateful();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f24156a.set(rect);
        a();
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int colorForState = this.f24174s.getColorForState(iArr, 0);
        if (this.f24164i.getColor() == colorForState) {
            return super.onStateChange(iArr);
        }
        this.f24164i.setColor(colorForState);
        return true;
    }

    public void setAlpha(int i2) {
        this.f24160e.setAlpha(i2);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f24160e.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setDither(boolean z2) {
        this.f24160e.setDither(z2);
        invalidateSelf();
    }

    public void setFilterBitmap(boolean z2) {
        this.f24160e.setFilterBitmap(z2);
        invalidateSelf();
    }
}
