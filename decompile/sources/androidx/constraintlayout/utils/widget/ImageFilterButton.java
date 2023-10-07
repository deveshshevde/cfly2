package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
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
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.R;

public class ImageFilterButton extends AppCompatImageButton {

    /* renamed from: a  reason: collision with root package name */
    ViewOutlineProvider f2453a;

    /* renamed from: b  reason: collision with root package name */
    RectF f2454b;

    /* renamed from: c  reason: collision with root package name */
    Drawable[] f2455c;

    /* renamed from: d  reason: collision with root package name */
    LayerDrawable f2456d;

    /* renamed from: e  reason: collision with root package name */
    private ImageFilterView.a f2457e = new ImageFilterView.a();

    /* renamed from: f  reason: collision with root package name */
    private float f2458f = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public float f2459g = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public float f2460h = Float.NaN;

    /* renamed from: i  reason: collision with root package name */
    private Path f2461i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f2462j = true;

    public ImageFilterButton(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ImageFilterView_altSrc);
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ImageFilterView_crossfade) {
                    this.f2458f = obtainStyledAttributes.getFloat(index, 0.0f);
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
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.f2462j));
                }
            }
            obtainStyledAttributes.recycle();
            if (drawable != null) {
                Drawable[] drawableArr = new Drawable[2];
                this.f2455c = drawableArr;
                drawableArr[0] = getDrawable();
                this.f2455c[1] = drawable;
                LayerDrawable layerDrawable = new LayerDrawable(this.f2455c);
                this.f2456d = layerDrawable;
                layerDrawable.getDrawable(1).setAlpha((int) (this.f2458f * 255.0f));
                super.setImageDrawable(this.f2456d);
            }
        }
    }

    private void setOverlay(boolean z2) {
        this.f2462j = z2;
    }

    public void draw(Canvas canvas) {
        boolean z2;
        if (Build.VERSION.SDK_INT >= 21 || this.f2460h == 0.0f || this.f2461i == null) {
            z2 = false;
        } else {
            z2 = true;
            canvas.save();
            canvas.clipPath(this.f2461i);
        }
        super.draw(canvas);
        if (z2) {
            canvas.restore();
        }
    }

    public float getContrast() {
        return this.f2457e.f2482f;
    }

    public float getCrossfade() {
        return this.f2458f;
    }

    public float getRound() {
        return this.f2460h;
    }

    public float getRoundPercent() {
        return this.f2459g;
    }

    public float getSaturation() {
        return this.f2457e.f2481e;
    }

    public float getWarmth() {
        return this.f2457e.f2483g;
    }

    public void setBrightness(float f2) {
        this.f2457e.f2480d = f2;
        this.f2457e.a((ImageView) this);
    }

    public void setContrast(float f2) {
        this.f2457e.f2482f = f2;
        this.f2457e.a((ImageView) this);
    }

    public void setCrossfade(float f2) {
        this.f2458f = f2;
        if (this.f2455c != null) {
            if (!this.f2462j) {
                this.f2456d.getDrawable(0).setAlpha((int) ((1.0f - this.f2458f) * 255.0f));
            }
            this.f2456d.getDrawable(1).setAlpha((int) (this.f2458f * 255.0f));
            super.setImageDrawable(this.f2456d);
        }
    }

    public void setRound(float f2) {
        if (Float.isNaN(f2)) {
            this.f2460h = f2;
            float f3 = this.f2459g;
            this.f2459g = -1.0f;
            setRoundPercent(f3);
            return;
        }
        boolean z2 = this.f2460h != f2;
        this.f2460h = f2;
        if (f2 != 0.0f) {
            if (this.f2461i == null) {
                this.f2461i = new Path();
            }
            if (this.f2454b == null) {
                this.f2454b = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f2453a == null) {
                    AnonymousClass2 r6 = new ViewOutlineProvider() {
                        public void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), ImageFilterButton.this.f2460h);
                        }
                    };
                    this.f2453a = r6;
                    setOutlineProvider(r6);
                }
                setClipToOutline(true);
            }
            this.f2454b.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.f2461i.reset();
            Path path = this.f2461i;
            RectF rectF = this.f2454b;
            float f4 = this.f2460h;
            path.addRoundRect(rectF, f4, f4, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (z2 && Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f2) {
        boolean z2 = this.f2459g != f2;
        this.f2459g = f2;
        if (f2 != 0.0f) {
            if (this.f2461i == null) {
                this.f2461i = new Path();
            }
            if (this.f2454b == null) {
                this.f2454b = new RectF();
            }
            if (Build.VERSION.SDK_INT >= 21) {
                if (this.f2453a == null) {
                    AnonymousClass1 r7 = new ViewOutlineProvider() {
                        public void getOutline(View view, Outline outline) {
                            int width = ImageFilterButton.this.getWidth();
                            int height = ImageFilterButton.this.getHeight();
                            outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * ImageFilterButton.this.f2459g) / 2.0f);
                        }
                    };
                    this.f2453a = r7;
                    setOutlineProvider(r7);
                }
                setClipToOutline(true);
            }
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.f2459g) / 2.0f;
            this.f2454b.set(0.0f, 0.0f, (float) width, (float) height);
            this.f2461i.reset();
            this.f2461i.addRoundRect(this.f2454b, min, min, Path.Direction.CW);
        } else if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(false);
        }
        if (z2 && Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f2) {
        this.f2457e.f2481e = f2;
        this.f2457e.a((ImageView) this);
    }

    public void setWarmth(float f2) {
        this.f2457e.f2483g = f2;
        this.f2457e.a((ImageView) this);
    }
}
