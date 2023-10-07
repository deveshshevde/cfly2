package com.xeagle.android.newUI.widgets.roundedimageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.xeagle.R;

public class RoundedImageView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    public static final Shader.TileMode f24138a = Shader.TileMode.CLAMP;

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f24139b = true;

    /* renamed from: c  reason: collision with root package name */
    private static final ImageView.ScaleType[] f24140c = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: d  reason: collision with root package name */
    private final float[] f24141d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f24142e;

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f24143f;

    /* renamed from: g  reason: collision with root package name */
    private float f24144g;

    /* renamed from: h  reason: collision with root package name */
    private ColorFilter f24145h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f24146i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f24147j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f24148k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f24149l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f24150m;

    /* renamed from: n  reason: collision with root package name */
    private int f24151n;

    /* renamed from: o  reason: collision with root package name */
    private ImageView.ScaleType f24152o;

    /* renamed from: p  reason: collision with root package name */
    private Shader.TileMode f24153p;

    /* renamed from: q  reason: collision with root package name */
    private Shader.TileMode f24154q;

    /* renamed from: com.xeagle.android.newUI.widgets.roundedimageview.RoundedImageView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f24155a;

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
                f24155a = r0
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f24155a     // Catch:{ NoSuchFieldError -> 0x001d }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_CROP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f24155a     // Catch:{ NoSuchFieldError -> 0x0028 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.CENTER_INSIDE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f24155a     // Catch:{ NoSuchFieldError -> 0x0033 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_CENTER     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f24155a     // Catch:{ NoSuchFieldError -> 0x003e }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_START     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f24155a     // Catch:{ NoSuchFieldError -> 0x0049 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_END     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f24155a     // Catch:{ NoSuchFieldError -> 0x0054 }
                android.widget.ImageView$ScaleType r1 = android.widget.ImageView.ScaleType.FIT_XY     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.newUI.widgets.roundedimageview.RoundedImageView.AnonymousClass1.<clinit>():void");
        }
    }

    public RoundedImageView(Context context) {
        super(context);
        this.f24141d = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.f24143f = ColorStateList.valueOf(-16777216);
        this.f24144g = 0.0f;
        this.f24145h = null;
        this.f24146i = false;
        this.f24148k = false;
        this.f24149l = false;
        this.f24150m = false;
        this.f24152o = ImageView.ScaleType.FIT_CENTER;
        Shader.TileMode tileMode = f24138a;
        this.f24153p = tileMode;
        this.f24154q = tileMode;
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        this.f24141d = fArr;
        this.f24143f = ColorStateList.valueOf(-16777216);
        this.f24144g = 0.0f;
        this.f24145h = null;
        this.f24146i = false;
        this.f24148k = false;
        this.f24149l = false;
        this.f24150m = false;
        this.f24152o = ImageView.ScaleType.FIT_CENTER;
        Shader.TileMode tileMode = f24138a;
        this.f24153p = tileMode;
        this.f24154q = tileMode;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundedImageView, i2, 0);
        int i3 = obtainStyledAttributes.getInt(0, -1);
        setScaleType(i3 >= 0 ? f24140c[i3] : ImageView.ScaleType.FIT_CENTER);
        float dimensionPixelSize = (float) obtainStyledAttributes.getDimensionPixelSize(3, -1);
        fArr[0] = (float) obtainStyledAttributes.getDimensionPixelSize(6, -1);
        fArr[1] = (float) obtainStyledAttributes.getDimensionPixelSize(7, -1);
        fArr[2] = (float) obtainStyledAttributes.getDimensionPixelSize(5, -1);
        fArr[3] = (float) obtainStyledAttributes.getDimensionPixelSize(4, -1);
        int length = fArr.length;
        boolean z2 = false;
        for (int i4 = 0; i4 < length; i4++) {
            float[] fArr2 = this.f24141d;
            if (fArr2[i4] < 0.0f) {
                fArr2[i4] = 0.0f;
            } else {
                z2 = true;
            }
        }
        if (!z2) {
            dimensionPixelSize = dimensionPixelSize < 0.0f ? 0.0f : dimensionPixelSize;
            int length2 = this.f24141d.length;
            for (int i5 = 0; i5 < length2; i5++) {
                this.f24141d[i5] = dimensionPixelSize;
            }
        }
        float dimensionPixelSize2 = (float) obtainStyledAttributes.getDimensionPixelSize(2, -1);
        this.f24144g = dimensionPixelSize2;
        if (dimensionPixelSize2 < 0.0f) {
            this.f24144g = 0.0f;
        }
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(1);
        this.f24143f = colorStateList;
        if (colorStateList == null) {
            this.f24143f = ColorStateList.valueOf(-16777216);
        }
        this.f24150m = obtainStyledAttributes.getBoolean(8, false);
        this.f24149l = obtainStyledAttributes.getBoolean(9, false);
        int i6 = obtainStyledAttributes.getInt(10, -2);
        if (i6 != -2) {
            setTileModeX(a(i6));
            setTileModeY(a(i6));
        }
        int i7 = obtainStyledAttributes.getInt(11, -2);
        if (i7 != -2) {
            setTileModeX(a(i7));
        }
        int i8 = obtainStyledAttributes.getInt(12, -2);
        if (i8 != -2) {
            setTileModeY(a(i8));
        }
        b();
        a(true);
        obtainStyledAttributes.recycle();
    }

    private static Shader.TileMode a(int i2) {
        if (i2 == 0) {
            return Shader.TileMode.CLAMP;
        }
        if (i2 == 1) {
            return Shader.TileMode.REPEAT;
        }
        if (i2 != 2) {
            return null;
        }
        return Shader.TileMode.MIRROR;
    }

    private Drawable a() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i2 = this.f24151n;
        if (i2 != 0) {
            try {
                drawable = resources.getDrawable(i2);
            } catch (Exception e2) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.f24151n, e2);
                this.f24151n = 0;
            }
        }
        return a.a(drawable);
    }

    private void a(Drawable drawable) {
        if (drawable != null) {
            if (drawable instanceof a) {
                a aVar = (a) drawable;
                aVar.a(this.f24152o).a(this.f24144g).a(this.f24143f).a(this.f24149l).a(this.f24153p).b(this.f24154q);
                float[] fArr = this.f24141d;
                if (fArr != null) {
                    aVar.a(fArr[0], fArr[1], fArr[2], fArr[3]);
                }
                c();
            } else if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                for (int i2 = 0; i2 < numberOfLayers; i2++) {
                    a(layerDrawable.getDrawable(i2));
                }
            }
        }
    }

    private void a(boolean z2) {
        if (this.f24150m) {
            if (z2) {
                this.f24142e = a.a(this.f24142e);
            }
            a(this.f24142e);
        }
    }

    private void b() {
        a(this.f24147j);
    }

    private void c() {
        Drawable drawable = this.f24147j;
        if (drawable != null && this.f24146i) {
            Drawable mutate = drawable.mutate();
            this.f24147j = mutate;
            if (this.f24148k) {
                mutate.setColorFilter(this.f24145h);
            }
        }
    }

    public void a(float f2, float f3, float f4, float f5) {
        float[] fArr = this.f24141d;
        if (fArr[0] != f2 || fArr[1] != f3 || fArr[2] != f5 || fArr[3] != f4) {
            fArr[0] = f2;
            fArr[1] = f3;
            fArr[3] = f4;
            fArr[2] = f5;
            b();
            a(false);
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    public int getBorderColor() {
        return this.f24143f.getDefaultColor();
    }

    public ColorStateList getBorderColors() {
        return this.f24143f;
    }

    public float getBorderWidth() {
        return this.f24144g;
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float f2 = 0.0f;
        for (float max : this.f24141d) {
            f2 = Math.max(max, f2);
        }
        return f2;
    }

    public ImageView.ScaleType getScaleType() {
        return this.f24152o;
    }

    public Shader.TileMode getTileModeX() {
        return this.f24153p;
    }

    public Shader.TileMode getTileModeY() {
        return this.f24154q;
    }

    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.f24142e = drawable;
        a(true);
        super.setBackgroundDrawable(this.f24142e);
    }

    public void setBorderColor(int i2) {
        setBorderColor(ColorStateList.valueOf(i2));
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (!this.f24143f.equals(colorStateList)) {
            if (colorStateList == null) {
                colorStateList = ColorStateList.valueOf(-16777216);
            }
            this.f24143f = colorStateList;
            b();
            a(false);
            if (this.f24144g > 0.0f) {
                invalidate();
            }
        }
    }

    public void setBorderWidth(float f2) {
        if (this.f24144g != f2) {
            this.f24144g = f2;
            b();
            a(false);
            invalidate();
        }
    }

    public void setBorderWidth(int i2) {
        setBorderWidth(getResources().getDimension(i2));
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f24145h != colorFilter) {
            this.f24145h = colorFilter;
            this.f24148k = true;
            this.f24146i = true;
            c();
            invalidate();
        }
    }

    public void setCornerRadius(float f2) {
        a(f2, f2, f2, f2);
    }

    public void setCornerRadiusDimen(int i2) {
        float dimension = getResources().getDimension(i2);
        a(dimension, dimension, dimension, dimension);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.f24151n = 0;
        this.f24147j = a.a(bitmap);
        b();
        super.setImageDrawable(this.f24147j);
    }

    public void setImageDrawable(Drawable drawable) {
        this.f24151n = 0;
        this.f24147j = a.a(drawable);
        b();
        super.setImageDrawable(this.f24147j);
    }

    public void setImageResource(int i2) {
        if (this.f24151n != i2) {
            this.f24151n = i2;
            this.f24147j = a();
            b();
            super.setImageDrawable(this.f24147j);
        }
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    public void setOval(boolean z2) {
        this.f24149l = z2;
        b();
        a(false);
        invalidate();
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!f24139b && scaleType == null) {
            throw new AssertionError();
        } else if (this.f24152o != scaleType) {
            this.f24152o = scaleType;
            switch (AnonymousClass1.f24155a[scaleType.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    scaleType = ImageView.ScaleType.FIT_XY;
                    break;
            }
            super.setScaleType(scaleType);
            b();
            a(false);
            invalidate();
        }
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.f24153p != tileMode) {
            this.f24153p = tileMode;
            b();
            a(false);
            invalidate();
        }
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.f24154q != tileMode) {
            this.f24154q = tileMode;
            b();
            a(false);
            invalidate();
        }
    }
}
