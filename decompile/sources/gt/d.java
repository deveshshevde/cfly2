package gt;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.text.TextPaint;
import android.util.Log;
import com.google.android.material.R;
import l.f;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public final ColorStateList f28572a;

    /* renamed from: b  reason: collision with root package name */
    public final ColorStateList f28573b;

    /* renamed from: c  reason: collision with root package name */
    public final ColorStateList f28574c;

    /* renamed from: d  reason: collision with root package name */
    public final ColorStateList f28575d;

    /* renamed from: e  reason: collision with root package name */
    public final String f28576e;

    /* renamed from: f  reason: collision with root package name */
    public final int f28577f;

    /* renamed from: g  reason: collision with root package name */
    public final int f28578g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f28579h;

    /* renamed from: i  reason: collision with root package name */
    public final float f28580i;

    /* renamed from: j  reason: collision with root package name */
    public final float f28581j;

    /* renamed from: k  reason: collision with root package name */
    public final float f28582k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f28583l;

    /* renamed from: m  reason: collision with root package name */
    public final float f28584m;

    /* renamed from: n  reason: collision with root package name */
    public float f28585n;

    /* renamed from: o  reason: collision with root package name */
    private final int f28586o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public boolean f28587p = false;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public Typeface f28588q;

    public d(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i2, R.styleable.TextAppearance);
        this.f28585n = obtainStyledAttributes.getDimension(R.styleable.TextAppearance_android_textSize, 0.0f);
        this.f28572a = c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColor);
        this.f28573b = c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorHint);
        this.f28574c = c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_textColorLink);
        this.f28577f = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_textStyle, 0);
        this.f28578g = obtainStyledAttributes.getInt(R.styleable.TextAppearance_android_typeface, 1);
        int a2 = c.a(obtainStyledAttributes, R.styleable.TextAppearance_fontFamily, R.styleable.TextAppearance_android_fontFamily);
        this.f28586o = obtainStyledAttributes.getResourceId(a2, 0);
        this.f28576e = obtainStyledAttributes.getString(a2);
        this.f28579h = obtainStyledAttributes.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        this.f28575d = c.a(context, obtainStyledAttributes, R.styleable.TextAppearance_android_shadowColor);
        this.f28580i = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f28581j = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f28582k = obtainStyledAttributes.getFloat(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        obtainStyledAttributes.recycle();
        if (Build.VERSION.SDK_INT >= 21) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(i2, R.styleable.MaterialTextAppearance);
            this.f28583l = obtainStyledAttributes2.hasValue(R.styleable.MaterialTextAppearance_android_letterSpacing);
            this.f28584m = obtainStyledAttributes2.getFloat(R.styleable.MaterialTextAppearance_android_letterSpacing, 0.0f);
            obtainStyledAttributes2.recycle();
            return;
        }
        this.f28583l = false;
        this.f28584m = 0.0f;
    }

    private void b() {
        String str;
        if (this.f28588q == null && (str = this.f28576e) != null) {
            this.f28588q = Typeface.create(str, this.f28577f);
        }
        if (this.f28588q == null) {
            int i2 = this.f28578g;
            this.f28588q = i2 != 1 ? i2 != 2 ? i2 != 3 ? Typeface.DEFAULT : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF;
            this.f28588q = Typeface.create(this.f28588q, this.f28577f);
        }
    }

    private boolean b(Context context) {
        if (e.a()) {
            return true;
        }
        int i2 = this.f28586o;
        return (i2 != 0 ? f.b(context, i2) : null) != null;
    }

    public Typeface a() {
        b();
        return this.f28588q;
    }

    public Typeface a(Context context) {
        if (this.f28587p) {
            return this.f28588q;
        }
        if (!context.isRestricted()) {
            try {
                Typeface a2 = f.a(context, this.f28586o);
                this.f28588q = a2;
                if (a2 != null) {
                    this.f28588q = Typeface.create(a2, this.f28577f);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e2) {
                Log.d("TextAppearance", "Error loading font " + this.f28576e, e2);
            }
        }
        b();
        this.f28587p = true;
        return this.f28588q;
    }

    public void a(Context context, final TextPaint textPaint, final f fVar) {
        a(textPaint, a());
        a(context, (f) new f() {
            public void a(int i2) {
                fVar.a(i2);
            }

            public void a(Typeface typeface, boolean z2) {
                d.this.a(textPaint, typeface);
                fVar.a(typeface, z2);
            }
        });
    }

    public void a(Context context, final f fVar) {
        if (b(context)) {
            a(context);
        } else {
            b();
        }
        int i2 = this.f28586o;
        if (i2 == 0) {
            this.f28587p = true;
        }
        if (this.f28587p) {
            fVar.a(this.f28588q, true);
            return;
        }
        try {
            f.a(context, i2, new f.c() {
                public void a(int i2) {
                    boolean unused = d.this.f28587p = true;
                    fVar.a(i2);
                }

                public void a(Typeface typeface) {
                    d dVar = d.this;
                    Typeface unused = dVar.f28588q = Typeface.create(typeface, dVar.f28577f);
                    boolean unused2 = d.this.f28587p = true;
                    fVar.a(d.this.f28588q, false);
                }
            }, (Handler) null);
        } catch (Resources.NotFoundException unused) {
            this.f28587p = true;
            fVar.a(1);
        } catch (Exception e2) {
            Log.d("TextAppearance", "Error loading font " + this.f28576e, e2);
            this.f28587p = true;
            fVar.a(-3);
        }
    }

    public void a(TextPaint textPaint, Typeface typeface) {
        textPaint.setTypeface(typeface);
        int style = (typeface.getStyle() ^ -1) & this.f28577f;
        textPaint.setFakeBoldText((style & 1) != 0);
        textPaint.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f28585n);
        if (Build.VERSION.SDK_INT >= 21 && this.f28583l) {
            textPaint.setLetterSpacing(this.f28584m);
        }
    }

    public void b(Context context, TextPaint textPaint, f fVar) {
        c(context, textPaint, fVar);
        ColorStateList colorStateList = this.f28572a;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, this.f28572a.getDefaultColor()) : -16777216);
        float f2 = this.f28582k;
        float f3 = this.f28580i;
        float f4 = this.f28581j;
        ColorStateList colorStateList2 = this.f28575d;
        textPaint.setShadowLayer(f2, f3, f4, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, this.f28575d.getDefaultColor()) : 0);
    }

    public void c(Context context, TextPaint textPaint, f fVar) {
        if (b(context)) {
            a(textPaint, a(context));
        } else {
            a(context, textPaint, fVar);
        }
    }
}
