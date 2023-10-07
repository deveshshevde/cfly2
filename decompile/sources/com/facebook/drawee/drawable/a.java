package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import df.c;

public class a extends Drawable implements Drawable.Callback, o, p {

    /* renamed from: a  reason: collision with root package name */
    private p f11155a;

    /* renamed from: b  reason: collision with root package name */
    private final d f11156b = new d();

    /* renamed from: c  reason: collision with root package name */
    private final Drawable[] f11157c;

    /* renamed from: d  reason: collision with root package name */
    private final c[] f11158d;

    /* renamed from: e  reason: collision with root package name */
    private final Rect f11159e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private boolean f11160f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11161g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11162h;

    public a(Drawable[] drawableArr) {
        int i2 = 0;
        this.f11160f = false;
        this.f11161g = false;
        this.f11162h = false;
        c.a(drawableArr);
        this.f11157c = drawableArr;
        while (true) {
            Drawable[] drawableArr2 = this.f11157c;
            if (i2 < drawableArr2.length) {
                e.a(drawableArr2[i2], this, this);
                i2++;
            } else {
                this.f11158d = new c[drawableArr2.length];
                return;
            }
        }
    }

    public Drawable a(int i2) {
        boolean z2 = true;
        c.a(i2 >= 0);
        if (i2 >= this.f11157c.length) {
            z2 = false;
        }
        c.a(z2);
        return this.f11157c[i2];
    }

    public void a(Matrix matrix) {
        p pVar = this.f11155a;
        if (pVar != null) {
            pVar.a(matrix);
        } else {
            matrix.reset();
        }
    }

    public void a(RectF rectF) {
        p pVar = this.f11155a;
        if (pVar != null) {
            pVar.a(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    public void a(p pVar) {
        this.f11155a = pVar;
    }

    public void draw(Canvas canvas) {
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.f11157c;
            if (i2 < drawableArr.length) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public int getIntrinsicHeight() {
        int i2 = 0;
        int i3 = -1;
        while (true) {
            Drawable[] drawableArr = this.f11157c;
            if (i2 >= drawableArr.length) {
                break;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                i3 = Math.max(i3, drawable.getIntrinsicHeight());
            }
            i2++;
        }
        if (i3 > 0) {
            return i3;
        }
        return -1;
    }

    public int getIntrinsicWidth() {
        int i2 = 0;
        int i3 = -1;
        while (true) {
            Drawable[] drawableArr = this.f11157c;
            if (i2 >= drawableArr.length) {
                break;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                i3 = Math.max(i3, drawable.getIntrinsicWidth());
            }
            i2++;
        }
        if (i3 > 0) {
            return i3;
        }
        return -1;
    }

    public int getOpacity() {
        if (this.f11157c.length == 0) {
            return -2;
        }
        int i2 = -1;
        int i3 = 1;
        while (true) {
            Drawable[] drawableArr = this.f11157c;
            if (i3 >= drawableArr.length) {
                return i2;
            }
            Drawable drawable = drawableArr[i3];
            if (drawable != null) {
                i2 = Drawable.resolveOpacity(i2, drawable.getOpacity());
            }
            i3++;
        }
    }

    public boolean getPadding(Rect rect) {
        int i2 = 0;
        rect.left = 0;
        rect.top = 0;
        rect.right = 0;
        rect.bottom = 0;
        Rect rect2 = this.f11159e;
        while (true) {
            Drawable[] drawableArr = this.f11157c;
            if (i2 >= drawableArr.length) {
                return true;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.getPadding(rect2);
                rect.left = Math.max(rect.left, rect2.left);
                rect.top = Math.max(rect.top, rect2.top);
                rect.right = Math.max(rect.right, rect2.right);
                rect.bottom = Math.max(rect.bottom, rect2.bottom);
            }
            i2++;
        }
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isStateful() {
        if (!this.f11161g) {
            this.f11160f = false;
            int i2 = 0;
            while (true) {
                Drawable[] drawableArr = this.f11157c;
                boolean z2 = true;
                if (i2 >= drawableArr.length) {
                    break;
                }
                Drawable drawable = drawableArr[i2];
                boolean z3 = this.f11160f;
                if (drawable == null || !drawable.isStateful()) {
                    z2 = false;
                }
                this.f11160f = z3 | z2;
                i2++;
            }
            this.f11161g = true;
        }
        return this.f11160f;
    }

    public Drawable mutate() {
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.f11157c;
            if (i2 < drawableArr.length) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    drawable.mutate();
                }
                i2++;
            } else {
                this.f11162h = true;
                return this;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.f11157c;
            if (i2 < drawableArr.length) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    drawable.setBounds(rect);
                }
                i2++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i2) {
        int i3 = 0;
        boolean z2 = false;
        while (true) {
            Drawable[] drawableArr = this.f11157c;
            if (i3 >= drawableArr.length) {
                return z2;
            }
            Drawable drawable = drawableArr[i3];
            if (drawable != null && drawable.setLevel(i2)) {
                z2 = true;
            }
            i3++;
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int i2 = 0;
        boolean z2 = false;
        while (true) {
            Drawable[] drawableArr = this.f11157c;
            if (i2 >= drawableArr.length) {
                return z2;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null && drawable.setState(iArr)) {
                z2 = true;
            }
            i2++;
        }
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        scheduleSelf(runnable, j2);
    }

    public void setAlpha(int i2) {
        this.f11156b.a(i2);
        int i3 = 0;
        while (true) {
            Drawable[] drawableArr = this.f11157c;
            if (i3 < drawableArr.length) {
                Drawable drawable = drawableArr[i3];
                if (drawable != null) {
                    drawable.setAlpha(i2);
                }
                i3++;
            } else {
                return;
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f11156b.a(colorFilter);
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.f11157c;
            if (i2 < drawableArr.length) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    drawable.setColorFilter(colorFilter);
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public void setDither(boolean z2) {
        this.f11156b.a(z2);
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.f11157c;
            if (i2 < drawableArr.length) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    drawable.setDither(z2);
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public void setFilterBitmap(boolean z2) {
        this.f11156b.b(z2);
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.f11157c;
            if (i2 < drawableArr.length) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    drawable.setFilterBitmap(z2);
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public void setHotspot(float f2, float f3) {
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.f11157c;
            if (i2 < drawableArr.length) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    drawable.setHotspot(f2, f3);
                }
                i2++;
            } else {
                return;
            }
        }
    }

    public boolean setVisible(boolean z2, boolean z3) {
        boolean visible = super.setVisible(z2, z3);
        int i2 = 0;
        while (true) {
            Drawable[] drawableArr = this.f11157c;
            if (i2 >= drawableArr.length) {
                return visible;
            }
            Drawable drawable = drawableArr[i2];
            if (drawable != null) {
                drawable.setVisible(z2, z3);
            }
            i2++;
        }
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
