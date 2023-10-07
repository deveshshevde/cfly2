package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.R;
import com.blankj.utilcode.constant.MemoryConstants;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import t.ac;

class n {

    /* renamed from: a  reason: collision with root package name */
    private static final RectF f1534a = new RectF();

    /* renamed from: b  reason: collision with root package name */
    private static ConcurrentHashMap<String, Method> f1535b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static ConcurrentHashMap<String, Field> f1536c = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private int f1537d = 0;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1538e = false;

    /* renamed from: f  reason: collision with root package name */
    private float f1539f = -1.0f;

    /* renamed from: g  reason: collision with root package name */
    private float f1540g = -1.0f;

    /* renamed from: h  reason: collision with root package name */
    private float f1541h = -1.0f;

    /* renamed from: i  reason: collision with root package name */
    private int[] f1542i = new int[0];

    /* renamed from: j  reason: collision with root package name */
    private boolean f1543j = false;

    /* renamed from: k  reason: collision with root package name */
    private TextPaint f1544k;

    /* renamed from: l  reason: collision with root package name */
    private final TextView f1545l;

    /* renamed from: m  reason: collision with root package name */
    private final Context f1546m;

    /* renamed from: n  reason: collision with root package name */
    private final a f1547n;

    private static class a {
        a() {
        }

        /* access modifiers changed from: package-private */
        public void a(StaticLayout.Builder builder, TextView textView) {
        }

        /* access modifiers changed from: package-private */
        public boolean a(TextView textView) {
            return ((Boolean) n.a((Object) textView, "getHorizontallyScrolling", false)).booleanValue();
        }
    }

    private static class b extends a {
        b() {
        }

        /* access modifiers changed from: package-private */
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) n.a((Object) textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    private static class c extends b {
        c() {
        }

        /* access modifiers changed from: package-private */
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }

        /* access modifiers changed from: package-private */
        public boolean a(TextView textView) {
            return textView.isHorizontallyScrollable();
        }
    }

    n(TextView textView) {
        this.f1545l = textView;
        this.f1546m = textView.getContext();
        this.f1547n = Build.VERSION.SDK_INT >= 29 ? new c() : Build.VERSION.SDK_INT >= 23 ? new b() : new a();
    }

    private int a(RectF rectF) {
        int length = this.f1542i.length;
        if (length != 0) {
            int i2 = length - 1;
            int i3 = 1;
            int i4 = 0;
            while (i3 <= i2) {
                int i5 = (i3 + i2) / 2;
                if (a(this.f1542i[i5], rectF)) {
                    int i6 = i5 + 1;
                    i4 = i3;
                    i3 = i6;
                } else {
                    i4 = i5 - 1;
                    i2 = i4;
                }
            }
            return this.f1542i[i4];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    private StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i2) {
        return new StaticLayout(charSequence, this.f1544k, i2, alignment, this.f1545l.getLineSpacingMultiplier(), this.f1545l.getLineSpacingExtra(), this.f1545l.getIncludeFontPadding());
    }

    static <T> T a(Object obj, String str, T t2) {
        try {
            return a(str).invoke(obj, new Object[0]);
        } catch (Exception e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e2);
            return t2;
        }
    }

    private static Method a(String str) {
        try {
            Method method = f1535b.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                f1535b.put(str, method);
            }
            return method;
        } catch (Exception e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e2);
            return null;
        }
    }

    private void a(float f2) {
        if (f2 != this.f1545l.getPaint().getTextSize()) {
            this.f1545l.getPaint().setTextSize(f2);
            boolean isInLayout = Build.VERSION.SDK_INT >= 18 ? this.f1545l.isInLayout() : false;
            if (this.f1545l.getLayout() != null) {
                this.f1538e = false;
                try {
                    Method a2 = a("nullLayouts");
                    if (a2 != null) {
                        a2.invoke(this.f1545l, new Object[0]);
                    }
                } catch (Exception e2) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e2);
                }
                if (!isInLayout) {
                    this.f1545l.requestLayout();
                } else {
                    this.f1545l.forceLayout();
                }
                this.f1545l.invalidate();
            }
        }
    }

    private void a(float f2, float f3, float f4) throws IllegalArgumentException {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f2 + "px) is less or equal to (0px)");
        } else if (f3 <= f2) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f3 + "px) is less or equal to minimum auto-size text size (" + f2 + "px)");
        } else if (f4 > 0.0f) {
            this.f1537d = 1;
            this.f1540g = f2;
            this.f1541h = f3;
            this.f1539f = f4;
            this.f1543j = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f4 + "px) is less or equal to (0px)");
        }
    }

    private void a(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = typedArray.getDimensionPixelSize(i2, -1);
            }
            this.f1542i = a(iArr);
            h();
        }
    }

    private boolean a(int i2, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f1545l.getText();
        TransformationMethod transformationMethod = this.f1545l.getTransformationMethod();
        if (!(transformationMethod == null || (transformation = transformationMethod.getTransformation(text, this.f1545l)) == null)) {
            text = transformation;
        }
        int maxLines = Build.VERSION.SDK_INT >= 16 ? this.f1545l.getMaxLines() : -1;
        b(i2);
        StaticLayout a2 = a(text, (Layout.Alignment) a((Object) this.f1545l, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (a2.getLineCount() <= maxLines && a2.getLineEnd(a2.getLineCount() - 1) == text.length())) && ((float) a2.getHeight()) <= rectF.bottom;
    }

    private int[] a(int[] iArr) {
        if (r0 == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            if (i2 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i2)) < 0) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        if (r0 == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr2[i3] = ((Integer) arrayList.get(i3)).intValue();
        }
        return iArr2;
    }

    private StaticLayout b(CharSequence charSequence, Layout.Alignment alignment, int i2) {
        return new StaticLayout(charSequence, this.f1544k, i2, alignment, ((Float) b((Object) this.f1545l, "mSpacingMult", Float.valueOf(1.0f))).floatValue(), ((Float) b((Object) this.f1545l, "mSpacingAdd", Float.valueOf(0.0f))).floatValue(), ((Boolean) b((Object) this.f1545l, "mIncludePad", true)).booleanValue());
    }

    private StaticLayout b(CharSequence charSequence, Layout.Alignment alignment, int i2, int i3) {
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.f1544k, i2);
        StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(this.f1545l.getLineSpacingExtra(), this.f1545l.getLineSpacingMultiplier()).setIncludePad(this.f1545l.getIncludeFontPadding()).setBreakStrategy(this.f1545l.getBreakStrategy()).setHyphenationFrequency(this.f1545l.getHyphenationFrequency());
        if (i3 == -1) {
            i3 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        }
        hyphenationFrequency.setMaxLines(i3);
        try {
            this.f1547n.a(obtain, this.f1545l);
        } catch (ClassCastException unused) {
            Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        return obtain.build();
    }

    private static <T> T b(Object obj, String str, T t2) {
        try {
            Field b2 = b(str);
            return b2 == null ? t2 : b2.get(obj);
        } catch (IllegalAccessException e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e2);
            return t2;
        }
    }

    private static Field b(String str) {
        try {
            Field field = f1536c.get(str);
            if (field == null && (field = TextView.class.getDeclaredField(str)) != null) {
                field.setAccessible(true);
                f1536c.put(str, field);
            }
            return field;
        } catch (NoSuchFieldException e2) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e2);
            return null;
        }
    }

    private boolean h() {
        int[] iArr = this.f1542i;
        int length = iArr.length;
        boolean z2 = length > 0;
        this.f1543j = z2;
        if (z2) {
            this.f1537d = 1;
            this.f1540g = (float) iArr[0];
            this.f1541h = (float) iArr[length - 1];
            this.f1539f = -1.0f;
        }
        return z2;
    }

    private boolean i() {
        if (!k() || this.f1537d != 1) {
            this.f1538e = false;
        } else {
            if (!this.f1543j || this.f1542i.length == 0) {
                int floor = ((int) Math.floor((double) ((this.f1541h - this.f1540g) / this.f1539f))) + 1;
                int[] iArr = new int[floor];
                for (int i2 = 0; i2 < floor; i2++) {
                    iArr[i2] = Math.round(this.f1540g + (((float) i2) * this.f1539f));
                }
                this.f1542i = a(iArr);
            }
            this.f1538e = true;
        }
        return this.f1538e;
    }

    private void j() {
        this.f1537d = 0;
        this.f1540g = -1.0f;
        this.f1541h = -1.0f;
        this.f1539f = -1.0f;
        this.f1542i = new int[0];
        this.f1538e = false;
    }

    private boolean k() {
        return !(this.f1545l instanceof AppCompatEditText);
    }

    /* access modifiers changed from: package-private */
    public int a() {
        return this.f1537d;
    }

    /* access modifiers changed from: package-private */
    public StaticLayout a(CharSequence charSequence, Layout.Alignment alignment, int i2, int i3) {
        return Build.VERSION.SDK_INT >= 23 ? b(charSequence, alignment, i2, i3) : Build.VERSION.SDK_INT >= 16 ? a(charSequence, alignment, i2) : b(charSequence, alignment, i2);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        if (!k()) {
            return;
        }
        if (i2 == 0) {
            j();
        } else if (i2 == 1) {
            DisplayMetrics displayMetrics = this.f1546m.getResources().getDisplayMetrics();
            a(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (i()) {
                f();
            }
        } else {
            throw new IllegalArgumentException("Unknown auto-size text type: " + i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, float f2) {
        Context context = this.f1546m;
        a(TypedValue.applyDimension(i2, f2, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, int i4, int i5) throws IllegalArgumentException {
        if (k()) {
            DisplayMetrics displayMetrics = this.f1546m.getResources().getDisplayMetrics();
            a(TypedValue.applyDimension(i5, (float) i2, displayMetrics), TypedValue.applyDimension(i5, (float) i3, displayMetrics), TypedValue.applyDimension(i5, (float) i4, displayMetrics));
            if (i()) {
                f();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i2) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.f1546m.obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i2, 0);
        TextView textView = this.f1545l;
        ac.a(textView, textView.getContext(), R.styleable.AppCompatTextView, attributeSet, obtainStyledAttributes, i2, 0);
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeTextType)) {
            this.f1537d = obtainStyledAttributes.getInt(R.styleable.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeStepGranularity) ? obtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeMinTextSize) ? obtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizeMaxTextSize) ? obtainStyledAttributes.getDimension(R.styleable.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_autoSizePresetSizes) && (resourceId = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            a(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!k()) {
            this.f1537d = 0;
        } else if (this.f1537d == 1) {
            if (!this.f1543j) {
                DisplayMetrics displayMetrics = this.f1546m.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                a(dimension2, dimension3, dimension);
            }
            i();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int[] iArr, int i2) throws IllegalArgumentException {
        if (k()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i2 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f1546m.getResources().getDisplayMetrics();
                    for (int i3 = 0; i3 < length; i3++) {
                        iArr2[i3] = Math.round(TypedValue.applyDimension(i2, (float) iArr[i3], displayMetrics));
                    }
                }
                this.f1542i = a(iArr2);
                if (!h()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f1543j = false;
            }
            if (i()) {
                f();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return Math.round(this.f1539f);
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        TextPaint textPaint = this.f1544k;
        if (textPaint == null) {
            this.f1544k = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f1544k.set(this.f1545l.getPaint());
        this.f1544k.setTextSize((float) i2);
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return Math.round(this.f1540g);
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return Math.round(this.f1541h);
    }

    /* access modifiers changed from: package-private */
    public int[] e() {
        return this.f1542i;
    }

    /* access modifiers changed from: package-private */
    public void f() {
        if (g()) {
            if (this.f1538e) {
                if (this.f1545l.getMeasuredHeight() > 0 && this.f1545l.getMeasuredWidth() > 0) {
                    int measuredWidth = this.f1547n.a(this.f1545l) ? MemoryConstants.MB : (this.f1545l.getMeasuredWidth() - this.f1545l.getTotalPaddingLeft()) - this.f1545l.getTotalPaddingRight();
                    int height = (this.f1545l.getHeight() - this.f1545l.getCompoundPaddingBottom()) - this.f1545l.getCompoundPaddingTop();
                    if (measuredWidth > 0 && height > 0) {
                        RectF rectF = f1534a;
                        synchronized (rectF) {
                            rectF.setEmpty();
                            rectF.right = (float) measuredWidth;
                            rectF.bottom = (float) height;
                            float a2 = (float) a(rectF);
                            if (a2 != this.f1545l.getTextSize()) {
                                a(0, a2);
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f1538e = true;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return k() && this.f1537d != 0;
    }
}
