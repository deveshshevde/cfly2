package r;

import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import java.util.concurrent.Executor;

public class c implements Spannable {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f34178a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static Executor f34179b;

    /* renamed from: c  reason: collision with root package name */
    private final Spannable f34180c;

    /* renamed from: d  reason: collision with root package name */
    private final a f34181d;

    /* renamed from: e  reason: collision with root package name */
    private final PrecomputedText f34182e;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final PrecomputedText.Params f34183a;

        /* renamed from: b  reason: collision with root package name */
        private final TextPaint f34184b;

        /* renamed from: c  reason: collision with root package name */
        private final TextDirectionHeuristic f34185c;

        /* renamed from: d  reason: collision with root package name */
        private final int f34186d;

        /* renamed from: e  reason: collision with root package name */
        private final int f34187e;

        /* renamed from: r.c$a$a  reason: collision with other inner class name */
        public static class C0252a {

            /* renamed from: a  reason: collision with root package name */
            private final TextPaint f34188a;

            /* renamed from: b  reason: collision with root package name */
            private TextDirectionHeuristic f34189b;

            /* renamed from: c  reason: collision with root package name */
            private int f34190c;

            /* renamed from: d  reason: collision with root package name */
            private int f34191d;

            public C0252a(TextPaint textPaint) {
                this.f34188a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f34190c = 1;
                    this.f34191d = 1;
                } else {
                    this.f34191d = 0;
                    this.f34190c = 0;
                }
                this.f34189b = Build.VERSION.SDK_INT >= 18 ? TextDirectionHeuristics.FIRSTSTRONG_LTR : null;
            }

            public C0252a a(int i2) {
                this.f34190c = i2;
                return this;
            }

            public C0252a a(TextDirectionHeuristic textDirectionHeuristic) {
                this.f34189b = textDirectionHeuristic;
                return this;
            }

            public a a() {
                return new a(this.f34188a, this.f34189b, this.f34190c, this.f34191d);
            }

            public C0252a b(int i2) {
                this.f34191d = i2;
                return this;
            }
        }

        public a(PrecomputedText.Params params) {
            this.f34184b = params.getTextPaint();
            this.f34185c = params.getTextDirection();
            this.f34186d = params.getBreakStrategy();
            this.f34187e = params.getHyphenationFrequency();
            this.f34183a = Build.VERSION.SDK_INT < 29 ? null : params;
        }

        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i2, int i3) {
            this.f34183a = Build.VERSION.SDK_INT >= 29 ? new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i2).setHyphenationFrequency(i3).setTextDirection(textDirectionHeuristic).build() : null;
            this.f34184b = textPaint;
            this.f34185c = textDirectionHeuristic;
            this.f34186d = i2;
            this.f34187e = i3;
        }

        public TextPaint a() {
            return this.f34184b;
        }

        public boolean a(a aVar) {
            if ((Build.VERSION.SDK_INT >= 23 && (this.f34186d != aVar.c() || this.f34187e != aVar.d())) || this.f34184b.getTextSize() != aVar.a().getTextSize() || this.f34184b.getTextScaleX() != aVar.a().getTextScaleX() || this.f34184b.getTextSkewX() != aVar.a().getTextSkewX()) {
                return false;
            }
            if ((Build.VERSION.SDK_INT >= 21 && (this.f34184b.getLetterSpacing() != aVar.a().getLetterSpacing() || !TextUtils.equals(this.f34184b.getFontFeatureSettings(), aVar.a().getFontFeatureSettings()))) || this.f34184b.getFlags() != aVar.a().getFlags()) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                if (!this.f34184b.getTextLocales().equals(aVar.a().getTextLocales())) {
                    return false;
                }
            } else if (Build.VERSION.SDK_INT >= 17 && !this.f34184b.getTextLocale().equals(aVar.a().getTextLocale())) {
                return false;
            }
            return this.f34184b.getTypeface() == null ? aVar.a().getTypeface() == null : this.f34184b.getTypeface().equals(aVar.a().getTypeface());
        }

        public TextDirectionHeuristic b() {
            return this.f34185c;
        }

        public int c() {
            return this.f34186d;
        }

        public int d() {
            return this.f34187e;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!a(aVar)) {
                return false;
            }
            return Build.VERSION.SDK_INT < 18 || this.f34185c == aVar.b();
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT >= 24) {
                return s.c.a(Float.valueOf(this.f34184b.getTextSize()), Float.valueOf(this.f34184b.getTextScaleX()), Float.valueOf(this.f34184b.getTextSkewX()), Float.valueOf(this.f34184b.getLetterSpacing()), Integer.valueOf(this.f34184b.getFlags()), this.f34184b.getTextLocales(), this.f34184b.getTypeface(), Boolean.valueOf(this.f34184b.isElegantTextHeight()), this.f34185c, Integer.valueOf(this.f34186d), Integer.valueOf(this.f34187e));
            } else if (Build.VERSION.SDK_INT >= 21) {
                return s.c.a(Float.valueOf(this.f34184b.getTextSize()), Float.valueOf(this.f34184b.getTextScaleX()), Float.valueOf(this.f34184b.getTextSkewX()), Float.valueOf(this.f34184b.getLetterSpacing()), Integer.valueOf(this.f34184b.getFlags()), this.f34184b.getTextLocale(), this.f34184b.getTypeface(), Boolean.valueOf(this.f34184b.isElegantTextHeight()), this.f34185c, Integer.valueOf(this.f34186d), Integer.valueOf(this.f34187e));
            } else if (Build.VERSION.SDK_INT >= 18) {
                return s.c.a(Float.valueOf(this.f34184b.getTextSize()), Float.valueOf(this.f34184b.getTextScaleX()), Float.valueOf(this.f34184b.getTextSkewX()), Integer.valueOf(this.f34184b.getFlags()), this.f34184b.getTextLocale(), this.f34184b.getTypeface(), this.f34185c, Integer.valueOf(this.f34186d), Integer.valueOf(this.f34187e));
            } else if (Build.VERSION.SDK_INT >= 17) {
                return s.c.a(Float.valueOf(this.f34184b.getTextSize()), Float.valueOf(this.f34184b.getTextScaleX()), Float.valueOf(this.f34184b.getTextSkewX()), Integer.valueOf(this.f34184b.getFlags()), this.f34184b.getTextLocale(), this.f34184b.getTypeface(), this.f34185c, Integer.valueOf(this.f34186d), Integer.valueOf(this.f34187e));
            } else {
                return s.c.a(Float.valueOf(this.f34184b.getTextSize()), Float.valueOf(this.f34184b.getTextScaleX()), Float.valueOf(this.f34184b.getTextSkewX()), Integer.valueOf(this.f34184b.getFlags()), this.f34184b.getTypeface(), this.f34185c, Integer.valueOf(this.f34186d), Integer.valueOf(this.f34187e));
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x00e5  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String toString() {
            /*
                r4 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "{"
                r0.<init>(r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "textSize="
                r1.append(r2)
                android.text.TextPaint r2 = r4.f34184b
                float r2 = r2.getTextSize()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ", textScaleX="
                r1.append(r2)
                android.text.TextPaint r2 = r4.f34184b
                float r2 = r2.getTextScaleX()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ", textSkewX="
                r1.append(r2)
                android.text.TextPaint r2 = r4.f34184b
                float r2 = r2.getTextSkewX()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
                int r1 = android.os.Build.VERSION.SDK_INT
                r2 = 21
                if (r1 < r2) goto L_0x008f
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ", letterSpacing="
                r1.append(r2)
                android.text.TextPaint r2 = r4.f34184b
                float r2 = r2.getLetterSpacing()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ", elegantTextHeight="
                r1.append(r2)
                android.text.TextPaint r2 = r4.f34184b
                boolean r2 = r2.isElegantTextHeight()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
            L_0x008f:
                int r1 = android.os.Build.VERSION.SDK_INT
                r2 = 24
                java.lang.String r3 = ", textLocale="
                if (r1 < r2) goto L_0x00b0
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r3)
                android.text.TextPaint r2 = r4.f34184b
                android.os.LocaleList r2 = r2.getTextLocales()
            L_0x00a5:
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
                goto L_0x00c5
            L_0x00b0:
                int r1 = android.os.Build.VERSION.SDK_INT
                r2 = 17
                if (r1 < r2) goto L_0x00c5
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                r1.append(r3)
                android.text.TextPaint r2 = r4.f34184b
                java.util.Locale r2 = r2.getTextLocale()
                goto L_0x00a5
            L_0x00c5:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ", typeface="
                r1.append(r2)
                android.text.TextPaint r2 = r4.f34184b
                android.graphics.Typeface r2 = r2.getTypeface()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
                int r1 = android.os.Build.VERSION.SDK_INT
                r2 = 26
                if (r1 < r2) goto L_0x00ff
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ", variationSettings="
                r1.append(r2)
                android.text.TextPaint r2 = r4.f34184b
                java.lang.String r2 = r2.getFontVariationSettings()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
            L_0x00ff:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ", textDir="
                r1.append(r2)
                android.text.TextDirectionHeuristic r2 = r4.f34185c
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ", breakStrategy="
                r1.append(r2)
                int r2 = r4.f34186d
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ", hyphenationFrequency="
                r1.append(r2)
                int r2 = r4.f34187e
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
                java.lang.String r1 = "}"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: r.c.a.toString():java.lang.String");
        }
    }

    public PrecomputedText a() {
        Spannable spannable = this.f34180c;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    public a b() {
        return this.f34181d;
    }

    public char charAt(int i2) {
        return this.f34180c.charAt(i2);
    }

    public int getSpanEnd(Object obj) {
        return this.f34180c.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.f34180c.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        return this.f34180c.getSpanStart(obj);
    }

    public <T> T[] getSpans(int i2, int i3, Class<T> cls) {
        return Build.VERSION.SDK_INT >= 29 ? this.f34182e.getSpans(i2, i3, cls) : this.f34180c.getSpans(i2, i3, cls);
    }

    public int length() {
        return this.f34180c.length();
    }

    public int nextSpanTransition(int i2, int i3, Class cls) {
        return this.f34180c.nextSpanTransition(i2, i3, cls);
    }

    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.f34182e.removeSpan(obj);
        } else {
            this.f34180c.removeSpan(obj);
        }
    }

    public void setSpan(Object obj, int i2, int i3, int i4) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.f34182e.setSpan(obj, i2, i3, i4);
        } else {
            this.f34180c.setSpan(obj, i2, i3, i4);
        }
    }

    public CharSequence subSequence(int i2, int i3) {
        return this.f34180c.subSequence(i2, i3);
    }

    public String toString() {
        return this.f34180c.toString();
    }
}
