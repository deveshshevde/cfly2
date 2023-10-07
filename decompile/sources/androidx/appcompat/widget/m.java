package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.widget.b;
import androidx.core.widget.j;
import java.lang.ref.WeakReference;
import java.util.Locale;
import l.f;
import t.ac;
import v.a;

class m {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f1513a;

    /* renamed from: b  reason: collision with root package name */
    private ad f1514b;

    /* renamed from: c  reason: collision with root package name */
    private ad f1515c;

    /* renamed from: d  reason: collision with root package name */
    private ad f1516d;

    /* renamed from: e  reason: collision with root package name */
    private ad f1517e;

    /* renamed from: f  reason: collision with root package name */
    private ad f1518f;

    /* renamed from: g  reason: collision with root package name */
    private ad f1519g;

    /* renamed from: h  reason: collision with root package name */
    private ad f1520h;

    /* renamed from: i  reason: collision with root package name */
    private final n f1521i;

    /* renamed from: j  reason: collision with root package name */
    private int f1522j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f1523k = -1;

    /* renamed from: l  reason: collision with root package name */
    private Typeface f1524l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1525m;

    m(TextView textView) {
        this.f1513a = textView;
        this.f1521i = new n(textView);
    }

    private static ad a(Context context, f fVar, int i2) {
        ColorStateList b2 = fVar.b(context, i2);
        if (b2 == null) {
            return null;
        }
        ad adVar = new ad();
        adVar.f1403d = true;
        adVar.f1400a = b2;
        return adVar;
    }

    private void a(Context context, af afVar) {
        String d2;
        Typeface typeface;
        Typeface typeface2;
        this.f1522j = afVar.a(R.styleable.TextAppearance_android_textStyle, this.f1522j);
        boolean z2 = false;
        if (Build.VERSION.SDK_INT >= 28) {
            int a2 = afVar.a(R.styleable.TextAppearance_android_textFontWeight, -1);
            this.f1523k = a2;
            if (a2 != -1) {
                this.f1522j = (this.f1522j & 2) | 0;
            }
        }
        if (afVar.g(R.styleable.TextAppearance_android_fontFamily) || afVar.g(R.styleable.TextAppearance_fontFamily)) {
            this.f1524l = null;
            int i2 = afVar.g(R.styleable.TextAppearance_fontFamily) ? R.styleable.TextAppearance_fontFamily : R.styleable.TextAppearance_android_fontFamily;
            final int i3 = this.f1523k;
            final int i4 = this.f1522j;
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.f1513a);
                try {
                    Typeface a3 = afVar.a(i2, this.f1522j, (f.c) new f.c() {
                        public void a(int i2) {
                        }

                        public void a(Typeface typeface) {
                            int i2;
                            if (Build.VERSION.SDK_INT >= 28 && (i2 = i3) != -1) {
                                typeface = Typeface.create(typeface, i2, (i4 & 2) != 0);
                            }
                            m.this.a((WeakReference<TextView>) weakReference, typeface);
                        }
                    });
                    if (a3 != null) {
                        if (Build.VERSION.SDK_INT >= 28 && this.f1523k != -1) {
                            a3 = Typeface.create(Typeface.create(a3, 0), this.f1523k, (this.f1522j & 2) != 0);
                        }
                        this.f1524l = a3;
                    }
                    this.f1525m = this.f1524l == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.f1524l == null && (d2 = afVar.d(i2)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.f1523k == -1) {
                    typeface = Typeface.create(d2, this.f1522j);
                } else {
                    Typeface create = Typeface.create(d2, 0);
                    int i5 = this.f1523k;
                    if ((this.f1522j & 2) != 0) {
                        z2 = true;
                    }
                    typeface = Typeface.create(create, i5, z2);
                }
                this.f1524l = typeface;
            }
        } else if (afVar.g(R.styleable.TextAppearance_android_typeface)) {
            this.f1525m = false;
            int a4 = afVar.a(R.styleable.TextAppearance_android_typeface, 1);
            if (a4 == 1) {
                typeface2 = Typeface.SANS_SERIF;
            } else if (a4 == 2) {
                typeface2 = Typeface.SERIF;
            } else if (a4 == 3) {
                typeface2 = Typeface.MONOSPACE;
            } else {
                return;
            }
            this.f1524l = typeface2;
        }
    }

    private void a(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (Build.VERSION.SDK_INT >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.f1513a.getCompoundDrawablesRelative();
            TextView textView = this.f1513a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        } else if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                Drawable[] compoundDrawablesRelative2 = this.f1513a.getCompoundDrawablesRelative();
                if (!(compoundDrawablesRelative2[0] == null && compoundDrawablesRelative2[2] == null)) {
                    TextView textView2 = this.f1513a;
                    Drawable drawable7 = compoundDrawablesRelative2[0];
                    if (drawable2 == null) {
                        drawable2 = compoundDrawablesRelative2[1];
                    }
                    Drawable drawable8 = compoundDrawablesRelative2[2];
                    if (drawable4 == null) {
                        drawable4 = compoundDrawablesRelative2[3];
                    }
                    textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                    return;
                }
            }
            Drawable[] compoundDrawables = this.f1513a.getCompoundDrawables();
            TextView textView3 = this.f1513a;
            if (drawable == null) {
                drawable = compoundDrawables[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawables[1];
            }
            if (drawable3 == null) {
                drawable3 = compoundDrawables[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawables[3];
            }
            textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }

    private void a(Drawable drawable, ad adVar) {
        if (drawable != null && adVar != null) {
            f.a(drawable, adVar, this.f1513a.getDrawableState());
        }
    }

    private void b(int i2, float f2) {
        this.f1521i.a(i2, f2);
    }

    private void l() {
        ad adVar = this.f1520h;
        this.f1514b = adVar;
        this.f1515c = adVar;
        this.f1516d = adVar;
        this.f1517e = adVar;
        this.f1518f = adVar;
        this.f1519g = adVar;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        b();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        this.f1521i.a(i2);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, float f2) {
        if (!b.f3067d && !d()) {
            b(i2, f2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        this.f1521i.a(i2, i3, i4, i5);
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, int i2) {
        String d2;
        ColorStateList e2;
        ColorStateList e3;
        ColorStateList e4;
        af a2 = af.a(context, i2, R.styleable.TextAppearance);
        if (a2.g(R.styleable.TextAppearance_textAllCaps)) {
            a(a2.a(R.styleable.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (a2.g(R.styleable.TextAppearance_android_textColor) && (e4 = a2.e(R.styleable.TextAppearance_android_textColor)) != null) {
                this.f1513a.setTextColor(e4);
            }
            if (a2.g(R.styleable.TextAppearance_android_textColorLink) && (e3 = a2.e(R.styleable.TextAppearance_android_textColorLink)) != null) {
                this.f1513a.setLinkTextColor(e3);
            }
            if (a2.g(R.styleable.TextAppearance_android_textColorHint) && (e2 = a2.e(R.styleable.TextAppearance_android_textColorHint)) != null) {
                this.f1513a.setHintTextColor(e2);
            }
        }
        if (a2.g(R.styleable.TextAppearance_android_textSize) && a2.e(R.styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f1513a.setTextSize(0, 0.0f);
        }
        a(context, a2);
        if (Build.VERSION.SDK_INT >= 26 && a2.g(R.styleable.TextAppearance_fontVariationSettings) && (d2 = a2.d(R.styleable.TextAppearance_fontVariationSettings)) != null) {
            this.f1513a.setFontVariationSettings(d2);
        }
        a2.b();
        Typeface typeface = this.f1524l;
        if (typeface != null) {
            this.f1513a.setTypeface(typeface, this.f1522j);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        if (this.f1520h == null) {
            this.f1520h = new ad();
        }
        this.f1520h.f1400a = colorStateList;
        this.f1520h.f1403d = colorStateList != null;
        l();
    }

    /* access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        if (this.f1520h == null) {
            this.f1520h = new ad();
        }
        this.f1520h.f1401b = mode;
        this.f1520h.f1402c = mode != null;
        l();
    }

    /* access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i2) {
        ColorStateList colorStateList;
        String str;
        ColorStateList colorStateList2;
        boolean z2;
        boolean z3;
        String str2;
        ColorStateList colorStateList3;
        boolean z4;
        int i3;
        AttributeSet attributeSet2 = attributeSet;
        int i4 = i2;
        Context context = this.f1513a.getContext();
        f b2 = f.b();
        af a2 = af.a(context, attributeSet2, R.styleable.AppCompatTextHelper, i4, 0);
        TextView textView = this.f1513a;
        ac.a(textView, textView.getContext(), R.styleable.AppCompatTextHelper, attributeSet, a2.a(), i2, 0);
        int g2 = a2.g(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
        if (a2.g(R.styleable.AppCompatTextHelper_android_drawableLeft)) {
            this.f1514b = a(context, b2, a2.g(R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a2.g(R.styleable.AppCompatTextHelper_android_drawableTop)) {
            this.f1515c = a(context, b2, a2.g(R.styleable.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a2.g(R.styleable.AppCompatTextHelper_android_drawableRight)) {
            this.f1516d = a(context, b2, a2.g(R.styleable.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a2.g(R.styleable.AppCompatTextHelper_android_drawableBottom)) {
            this.f1517e = a(context, b2, a2.g(R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (a2.g(R.styleable.AppCompatTextHelper_android_drawableStart)) {
                this.f1518f = a(context, b2, a2.g(R.styleable.AppCompatTextHelper_android_drawableStart, 0));
            }
            if (a2.g(R.styleable.AppCompatTextHelper_android_drawableEnd)) {
                this.f1519g = a(context, b2, a2.g(R.styleable.AppCompatTextHelper_android_drawableEnd, 0));
            }
        }
        a2.b();
        boolean z5 = this.f1513a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (g2 != -1) {
            af a3 = af.a(context, g2, R.styleable.TextAppearance);
            if (z5 || !a3.g(R.styleable.TextAppearance_textAllCaps)) {
                z3 = false;
                z2 = false;
            } else {
                z3 = a3.a(R.styleable.TextAppearance_textAllCaps, false);
                z2 = true;
            }
            a(context, a3);
            if (Build.VERSION.SDK_INT < 23) {
                colorStateList = a3.g(R.styleable.TextAppearance_android_textColor) ? a3.e(R.styleable.TextAppearance_android_textColor) : null;
                colorStateList3 = a3.g(R.styleable.TextAppearance_android_textColorHint) ? a3.e(R.styleable.TextAppearance_android_textColorHint) : null;
                colorStateList2 = a3.g(R.styleable.TextAppearance_android_textColorLink) ? a3.e(R.styleable.TextAppearance_android_textColorLink) : null;
            } else {
                colorStateList3 = null;
                colorStateList2 = null;
                colorStateList = null;
            }
            str = a3.g(R.styleable.TextAppearance_textLocale) ? a3.d(R.styleable.TextAppearance_textLocale) : null;
            str2 = (Build.VERSION.SDK_INT < 26 || !a3.g(R.styleable.TextAppearance_fontVariationSettings)) ? null : a3.d(R.styleable.TextAppearance_fontVariationSettings);
            a3.b();
        } else {
            colorStateList3 = null;
            str2 = null;
            z3 = false;
            z2 = false;
            colorStateList2 = null;
            str = null;
            colorStateList = null;
        }
        af a4 = af.a(context, attributeSet2, R.styleable.TextAppearance, i4, 0);
        if (z5 || !a4.g(R.styleable.TextAppearance_textAllCaps)) {
            z4 = z2;
        } else {
            z3 = a4.a(R.styleable.TextAppearance_textAllCaps, false);
            z4 = true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (a4.g(R.styleable.TextAppearance_android_textColor)) {
                colorStateList = a4.e(R.styleable.TextAppearance_android_textColor);
            }
            if (a4.g(R.styleable.TextAppearance_android_textColorHint)) {
                colorStateList3 = a4.e(R.styleable.TextAppearance_android_textColorHint);
            }
            if (a4.g(R.styleable.TextAppearance_android_textColorLink)) {
                colorStateList2 = a4.e(R.styleable.TextAppearance_android_textColorLink);
            }
        }
        if (a4.g(R.styleable.TextAppearance_textLocale)) {
            str = a4.d(R.styleable.TextAppearance_textLocale);
        }
        if (Build.VERSION.SDK_INT >= 26 && a4.g(R.styleable.TextAppearance_fontVariationSettings)) {
            str2 = a4.d(R.styleable.TextAppearance_fontVariationSettings);
        }
        if (Build.VERSION.SDK_INT >= 28 && a4.g(R.styleable.TextAppearance_android_textSize) && a4.e(R.styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f1513a.setTextSize(0, 0.0f);
        }
        a(context, a4);
        a4.b();
        if (colorStateList != null) {
            this.f1513a.setTextColor(colorStateList);
        }
        if (colorStateList3 != null) {
            this.f1513a.setHintTextColor(colorStateList3);
        }
        if (colorStateList2 != null) {
            this.f1513a.setLinkTextColor(colorStateList2);
        }
        if (!z5 && z4) {
            a(z3);
        }
        Typeface typeface = this.f1524l;
        if (typeface != null) {
            if (this.f1523k == -1) {
                this.f1513a.setTypeface(typeface, this.f1522j);
            } else {
                this.f1513a.setTypeface(typeface);
            }
        }
        if (str2 != null) {
            this.f1513a.setFontVariationSettings(str2);
        }
        if (str != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.f1513a.setTextLocales(LocaleList.forLanguageTags(str));
            } else if (Build.VERSION.SDK_INT >= 21) {
                this.f1513a.setTextLocale(Locale.forLanguageTag(str.substring(0, str.indexOf(44))));
            }
        }
        this.f1521i.a(attributeSet2, i4);
        if (b.f3067d && this.f1521i.a() != 0) {
            int[] e2 = this.f1521i.e();
            if (e2.length > 0) {
                if (((float) this.f1513a.getAutoSizeStepGranularity()) != -1.0f) {
                    this.f1513a.setAutoSizeTextTypeUniformWithConfiguration(this.f1521i.c(), this.f1521i.d(), this.f1521i.b(), 0);
                } else {
                    this.f1513a.setAutoSizeTextTypeUniformWithPresetSizes(e2, 0);
                }
            }
        }
        af a5 = af.a(context, attributeSet2, R.styleable.AppCompatTextView);
        int g3 = a5.g(R.styleable.AppCompatTextView_drawableLeftCompat, -1);
        Drawable a6 = g3 != -1 ? b2.a(context, g3) : null;
        int g4 = a5.g(R.styleable.AppCompatTextView_drawableTopCompat, -1);
        Drawable a7 = g4 != -1 ? b2.a(context, g4) : null;
        int g5 = a5.g(R.styleable.AppCompatTextView_drawableRightCompat, -1);
        Drawable a8 = g5 != -1 ? b2.a(context, g5) : null;
        int g6 = a5.g(R.styleable.AppCompatTextView_drawableBottomCompat, -1);
        Drawable a9 = g6 != -1 ? b2.a(context, g6) : null;
        int g7 = a5.g(R.styleable.AppCompatTextView_drawableStartCompat, -1);
        Drawable a10 = g7 != -1 ? b2.a(context, g7) : null;
        int g8 = a5.g(R.styleable.AppCompatTextView_drawableEndCompat, -1);
        a(a6, a7, a8, a9, a10, g8 != -1 ? b2.a(context, g8) : null);
        if (a5.g(R.styleable.AppCompatTextView_drawableTint)) {
            j.a(this.f1513a, a5.e(R.styleable.AppCompatTextView_drawableTint));
        }
        if (a5.g(R.styleable.AppCompatTextView_drawableTintMode)) {
            i3 = -1;
            j.a(this.f1513a, q.a(a5.a(R.styleable.AppCompatTextView_drawableTintMode, -1), (PorterDuff.Mode) null));
        } else {
            i3 = -1;
        }
        int e3 = a5.e(R.styleable.AppCompatTextView_firstBaselineToTopHeight, i3);
        int e4 = a5.e(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, i3);
        int e5 = a5.e(R.styleable.AppCompatTextView_lineHeight, i3);
        a5.b();
        if (e3 != i3) {
            j.b(this.f1513a, e3);
        }
        if (e4 != i3) {
            j.c(this.f1513a, e4);
        }
        if (e5 != i3) {
            j.d(this.f1513a, e5);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT < 30 && inputConnection != null) {
            a.a(editorInfo, textView.getText());
        }
    }

    /* access modifiers changed from: package-private */
    public void a(WeakReference<TextView> weakReference, final Typeface typeface) {
        if (this.f1525m) {
            this.f1524l = typeface;
            final TextView textView = (TextView) weakReference.get();
            if (textView == null) {
                return;
            }
            if (ac.J(textView)) {
                final int i2 = this.f1522j;
                textView.post(new Runnable() {
                    public void run() {
                        textView.setTypeface(typeface, i2);
                    }
                });
                return;
            }
            textView.setTypeface(typeface, this.f1522j);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        this.f1513a.setAllCaps(z2);
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2, int i2, int i3, int i4, int i5) {
        if (!b.f3067d) {
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int[] iArr, int i2) throws IllegalArgumentException {
        this.f1521i.a(iArr, i2);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        if (!(this.f1514b == null && this.f1515c == null && this.f1516d == null && this.f1517e == null)) {
            Drawable[] compoundDrawables = this.f1513a.getCompoundDrawables();
            a(compoundDrawables[0], this.f1514b);
            a(compoundDrawables[1], this.f1515c);
            a(compoundDrawables[2], this.f1516d);
            a(compoundDrawables[3], this.f1517e);
        }
        if (Build.VERSION.SDK_INT < 17) {
            return;
        }
        if (this.f1518f != null || this.f1519g != null) {
            Drawable[] compoundDrawablesRelative = this.f1513a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f1518f);
            a(compoundDrawablesRelative[2], this.f1519g);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.f1521i.f();
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f1521i.g();
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f1521i.a();
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f1521i.b();
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.f1521i.c();
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.f1521i.d();
    }

    /* access modifiers changed from: package-private */
    public int[] i() {
        return this.f1521i.e();
    }

    /* access modifiers changed from: package-private */
    public ColorStateList j() {
        ad adVar = this.f1520h;
        if (adVar != null) {
            return adVar.f1400a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode k() {
        ad adVar = this.f1520h;
        if (adVar != null) {
            return adVar.f1401b;
        }
        return null;
    }
}
