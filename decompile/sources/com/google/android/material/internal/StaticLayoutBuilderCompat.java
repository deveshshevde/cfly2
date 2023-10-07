package com.google.android.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.lang.reflect.Constructor;
import s.f;

final class StaticLayoutBuilderCompat {

    /* renamed from: a  reason: collision with root package name */
    static final int f19214a = (Build.VERSION.SDK_INT >= 23 ? 1 : 0);

    /* renamed from: b  reason: collision with root package name */
    private static boolean f19215b;

    /* renamed from: c  reason: collision with root package name */
    private static Constructor<StaticLayout> f19216c;

    /* renamed from: d  reason: collision with root package name */
    private static Object f19217d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f19218e;

    /* renamed from: f  reason: collision with root package name */
    private final TextPaint f19219f;

    /* renamed from: g  reason: collision with root package name */
    private final int f19220g;

    /* renamed from: h  reason: collision with root package name */
    private int f19221h = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f19222i;

    /* renamed from: j  reason: collision with root package name */
    private Layout.Alignment f19223j;

    /* renamed from: k  reason: collision with root package name */
    private int f19224k;

    /* renamed from: l  reason: collision with root package name */
    private float f19225l;

    /* renamed from: m  reason: collision with root package name */
    private float f19226m;

    /* renamed from: n  reason: collision with root package name */
    private int f19227n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f19228o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f19229p;

    /* renamed from: q  reason: collision with root package name */
    private TextUtils.TruncateAt f19230q;

    static class StaticLayoutBuilderCompatException extends Exception {
        StaticLayoutBuilderCompatException(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }

    private StaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i2) {
        this.f19218e = charSequence;
        this.f19219f = textPaint;
        this.f19220g = i2;
        this.f19222i = charSequence.length();
        this.f19223j = Layout.Alignment.ALIGN_NORMAL;
        this.f19224k = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        this.f19225l = 0.0f;
        this.f19226m = 1.0f;
        this.f19227n = f19214a;
        this.f19228o = true;
        this.f19230q = null;
    }

    public static StaticLayoutBuilderCompat a(CharSequence charSequence, TextPaint textPaint, int i2) {
        return new StaticLayoutBuilderCompat(charSequence, textPaint, i2);
    }

    private void b() throws StaticLayoutBuilderCompatException {
        Class cls;
        if (!f19215b) {
            try {
                boolean z2 = this.f19229p && Build.VERSION.SDK_INT >= 23;
                if (Build.VERSION.SDK_INT >= 18) {
                    cls = TextDirectionHeuristic.class;
                    f19217d = z2 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
                } else {
                    ClassLoader classLoader = StaticLayoutBuilderCompat.class.getClassLoader();
                    String str = this.f19229p ? "RTL" : "LTR";
                    Class<?> loadClass = classLoader.loadClass("android.text.TextDirectionHeuristic");
                    Class<?> loadClass2 = classLoader.loadClass("android.text.TextDirectionHeuristics");
                    f19217d = loadClass2.getField(str).get(loadClass2);
                    cls = loadClass;
                }
                Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(new Class[]{CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, cls, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils.TruncateAt.class, Integer.TYPE, Integer.TYPE});
                f19216c = declaredConstructor;
                declaredConstructor.setAccessible(true);
                f19215b = true;
            } catch (Exception e2) {
                throw new StaticLayoutBuilderCompatException(e2);
            }
        }
    }

    public StaticLayout a() throws StaticLayoutBuilderCompatException {
        if (this.f19218e == null) {
            this.f19218e = "";
        }
        int max = Math.max(0, this.f19220g);
        CharSequence charSequence = this.f19218e;
        if (this.f19224k == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.f19219f, (float) max, this.f19230q);
        }
        this.f19222i = Math.min(charSequence.length(), this.f19222i);
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.f19229p && this.f19224k == 1) {
                this.f19223j = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, this.f19221h, this.f19222i, this.f19219f, max);
            obtain.setAlignment(this.f19223j);
            obtain.setIncludePad(this.f19228o);
            obtain.setTextDirection(this.f19229p ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            TextUtils.TruncateAt truncateAt = this.f19230q;
            if (truncateAt != null) {
                obtain.setEllipsize(truncateAt);
            }
            obtain.setMaxLines(this.f19224k);
            float f2 = this.f19225l;
            if (!(f2 == 0.0f && this.f19226m == 1.0f)) {
                obtain.setLineSpacing(f2, this.f19226m);
            }
            if (this.f19224k > 1) {
                obtain.setHyphenationFrequency(this.f19227n);
            }
            return obtain.build();
        }
        b();
        try {
            return (StaticLayout) ((Constructor) f.a(f19216c)).newInstance(new Object[]{charSequence, Integer.valueOf(this.f19221h), Integer.valueOf(this.f19222i), this.f19219f, Integer.valueOf(max), this.f19223j, f.a(f19217d), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f19228o), null, Integer.valueOf(max), Integer.valueOf(this.f19224k)});
        } catch (Exception e2) {
            throw new StaticLayoutBuilderCompatException(e2);
        }
    }

    public StaticLayoutBuilderCompat a(float f2, float f3) {
        this.f19225l = f2;
        this.f19226m = f3;
        return this;
    }

    public StaticLayoutBuilderCompat a(int i2) {
        this.f19224k = i2;
        return this;
    }

    public StaticLayoutBuilderCompat a(Layout.Alignment alignment) {
        this.f19223j = alignment;
        return this;
    }

    public StaticLayoutBuilderCompat a(TextUtils.TruncateAt truncateAt) {
        this.f19230q = truncateAt;
        return this;
    }

    public StaticLayoutBuilderCompat a(boolean z2) {
        this.f19228o = z2;
        return this;
    }

    public StaticLayoutBuilderCompat b(int i2) {
        this.f19227n = i2;
        return this;
    }

    public StaticLayoutBuilderCompat b(boolean z2) {
        this.f19229p = z2;
        return this;
    }
}
