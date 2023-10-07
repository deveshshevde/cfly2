package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R;

public class ImageFilterView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    ViewOutlineProvider f2465a;

    /* renamed from: b  reason: collision with root package name */
    RectF f2466b;

    /* renamed from: c  reason: collision with root package name */
    Drawable[] f2467c;

    /* renamed from: d  reason: collision with root package name */
    LayerDrawable f2468d;

    /* renamed from: e  reason: collision with root package name */
    private a f2469e = new a();

    /* renamed from: f  reason: collision with root package name */
    private boolean f2470f = true;

    /* renamed from: g  reason: collision with root package name */
    private float f2471g = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public float f2472h = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public float f2473i = Float.NaN;

    /* renamed from: j  reason: collision with root package name */
    private Path f2474j;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        float[] f2477a = new float[20];

        /* renamed from: b  reason: collision with root package name */
        ColorMatrix f2478b = new ColorMatrix();

        /* renamed from: c  reason: collision with root package name */
        ColorMatrix f2479c = new ColorMatrix();

        /* renamed from: d  reason: collision with root package name */
        float f2480d = 1.0f;

        /* renamed from: e  reason: collision with root package name */
        float f2481e = 1.0f;

        /* renamed from: f  reason: collision with root package name */
        float f2482f = 1.0f;

        /* renamed from: g  reason: collision with root package name */
        float f2483g = 1.0f;

        a() {
        }

        private void a(float f2) {
            float f3 = 1.0f - f2;
            float f4 = 0.2999f * f3;
            float f5 = 0.587f * f3;
            float f6 = f3 * 0.114f;
            float[] fArr = this.f2477a;
            fArr[0] = f4 + f2;
            fArr[1] = f5;
            fArr[2] = f6;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f4;
            fArr[6] = f5 + f2;
            fArr[7] = f6;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = f4;
            fArr[11] = f5;
            fArr[12] = f6 + f2;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void b(float f2) {
            float f3;
            float f4;
            if (f2 <= 0.0f) {
                f2 = 0.01f;
            }
            float f5 = (5000.0f / f2) / 100.0f;
            if (f5 > 66.0f) {
                double d2 = (double) (f5 - 60.0f);
                f4 = ((float) Math.pow(d2, -0.13320475816726685d)) * 329.69873f;
                f3 = ((float) Math.pow(d2, 0.07551484555006027d)) * 288.12216f;
            } else {
                f3 = (((float) Math.log((double) f5)) * 99.4708f) - 161.11957f;
                f4 = 255.0f;
            }
            float log = f5 < 66.0f ? f5 > 19.0f ? (((float) Math.log((double) (f5 - 10.0f))) * 138.51773f) - 305.0448f : 0.0f : 255.0f;
            float min = Math.min(255.0f, Math.max(f4, 0.0f));
            float min2 = Math.min(255.0f, Math.max(f3, 0.0f));
            float min3 = Math.min(255.0f, Math.max(log, 0.0f));
            float min4 = Math.min(255.0f, Math.max(255.0f, 0.0f));
            float min5 = Math.min(255.0f, Math.max((((float) Math.log((double) 50.0f)) * 99.4708f) - 161.11957f, 0.0f));
            float min6 = min3 / Math.min(255.0f, Math.max((((float) Math.log((double) 40.0f)) * 138.51773f) - 305.0448f, 0.0f));
            float[] fArr = this.f2477a;
            fArr[0] = min / min4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = min2 / min5;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = min6;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        private void c(float f2) {
            float[] fArr = this.f2477a;
            fArr[0] = f2;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 0.0f;
            fArr[6] = f2;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 0.0f;
            fArr[11] = 0.0f;
            fArr[12] = f2;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            fArr[15] = 0.0f;
            fArr[16] = 0.0f;
            fArr[17] = 0.0f;
            fArr[18] = 1.0f;
            fArr[19] = 0.0f;
        }

        /* access modifiers changed from: package-private */
        public void a(ImageView imageView) {
            boolean z2;
            this.f2478b.reset();
            float f2 = this.f2481e;
            boolean z3 = true;
            if (f2 != 1.0f) {
                a(f2);
                this.f2478b.set(this.f2477a);
                z2 = true;
            } else {
                z2 = false;
            }
            float f3 = this.f2482f;
            if (f3 != 1.0f) {
                this.f2479c.setScale(f3, f3, f3, 1.0f);
                this.f2478b.postConcat(this.f2479c);
                z2 = true;
            }
            float f4 = this.f2483g;
            if (f4 != 1.0f) {
                b(f4);
                this.f2479c.set(this.f2477a);
                this.f2478b.postConcat(this.f2479c);
                z2 = true;
            }
            float f5 = this.f2480d;
            if (f5 != 1.0f) {
                c(f5);
                this.f2479c.set(this.f2477a);
                this.f2478b.postConcat(this.f2479c);
            } else {
                z3 = z2;
            }
            if (z3) {
                imageView.setColorFilter(new ColorMatrixColorFilter(this.f2478b));
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    public ImageFilterView(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ImageFilterView_altSrc);
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ImageFilterView_crossfade) {
                    this.f2471g = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_round) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                    }
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                    }
                } else if (index == R.styleable.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.f2470f));
                }
            }
            obtainStyledAttributes.recycle();
            if (drawable != null) {
                Drawable[] drawableArr = new Drawable[2];
                this.f2467c = drawableArr;
                drawableArr[0] = getDrawable();
                this.f2467c[1] = drawable;
                LayerDrawable layerDrawable = new LayerDrawable(this.f2467c);
                this.f2468d = layerDrawable;
                layerDrawable.getDrawable(1).setAlpha((int) (this.f2471g * 255.0f));
                super.setImageDrawable(this.f2468d);
            }
        }
    }

    private void setOverlay(boolean z2) {
        this.f2470f = z2;
    }

    public void draw(Canvas canvas) {
        boolean z2;
        if (Build.VERSION.SDK_INT >= 21 || this.f2472h == 0.0f || this.f2474j == null) {
            z2 = false;
        } else {
            z2 = true;
            canvas.save();
            canvas.clipPath(this.f2474j);
        }
        super.draw(canvas);
        if (z2) {
            canvas.restore();
        }
    }

    public float getBrightness() {
        return this.f2469e.f2480d;
    }

    public float getContrast() {
        return this.f2469e.f2482f;
    }

    public float getCrossfade() {
        return this.f2471g;
    }

    public float getRound() {
        return this.f2473i;
    }

    public float getRoundPercent() {
        return this.f2472h;
    }

    public float getSaturation() {
        return this.f2469e.f2481e;
    }

    public float getWarmth() {
        return this.f2469e.f2483g;
    }

    public void setBrightness(float f2) {
        this.f2469e.f2480d = f2;
        this.f2469e.a((ImageView) this);
    }

    public void setContrast(float f2) {
        this.f2469e.f2482f = f2;
        this.f2469e.a((ImageView) this);
    }

    public void setCrossfade(float f2) {
        this.f2471g = f2;
        if (this.f2467c != null) {
            if (!this.f2470f) {
                this.f2468d.getDrawable(0).setAlpha((int) ((1.0f - this.f2471g) * 255.0f));
            }
            this.f2468d.getDrawable(1).setAlpha((int) (this.f2471g * 255.0f));
            super.setImageDrawable(this.f2468d);
        }
    }

    public void setRound(float f2) {
        if (Float.isNaN(f2)) {
            this.f2473i = f2;
            float f3 = this.f2472h;
            this.f2472h = -1.0f;
            setRoundPercent(f3);
            return;
        }
        boolean z2 = this.f2473i != f2;
        this.f2473i = f2;
        if (f2 != 0.0f) {
            if (this.f2474j == null) {
                this.f2474j = new Path();
            }
            if (this.f2466b == null) {
                this.f2466b = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f2465a == null) {
                    AnonymousClass2 r6 = new ViewOutlineProvider() {
                        public void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.this.f2473i);
                        }
                    };
                    this.f2465a = r6;
                    setOutlineProvider(r6);
                }
                setClipToOutline(true);
            }
            this.f2466b.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.f2474j.reset();
            Path path = this.f2474j;
            RectF rectF = this.f2466b;
            float f4 = this.f2473i;
            path.addRoundRect(rectF, f4, f4, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (z2 && Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f2) {
        boolean z2 = this.f2472h != f2;
        this.f2472h = f2;
        if (f2 != 0.0f) {
            if (this.f2474j == null) {
                this.f2474j = new Path();
            }
            if (this.f2466b == null) {
                this.f2466b = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f2465a == null) {
                    AnonymousClass1 r7 = new ViewOutlineProvider() {
                        public void getOutline(View view, Outline outline) {
                            int width = ImageFilterView.this.getWidth();
                            int height = ImageFilterView.this.getHeight();
                            outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * ImageFilterView.this.f2472h) / 2.0f);
                        }
                    };
                    this.f2465a = r7;
                    setOutlineProvider(r7);
                }
                setClipToOutline(true);
            }
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.f2472h) / 2.0f;
            this.f2466b.set(0.0f, 0.0f, (float) width, (float) height);
            this.f2474j.reset();
            this.f2474j.addRoundRect(this.f2466b, min, min, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (z2 && Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f2) {
        this.f2469e.f2481e = f2;
        this.f2469e.a((ImageView) this);
    }

    public void setWarmth(float f2) {
        this.f2469e.f2483g = f2;
        this.f2469e.a((ImageView) this);
    }
}
