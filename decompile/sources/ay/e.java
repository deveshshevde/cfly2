package ay;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.TextView;
import kotlin.Pair;
import kotlin.jvm.internal.h;
import kotlin.l;
import mm.b;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f5573a = new e();

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f5574a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f5575b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f5576c;

        a(T t2, b bVar) {
            this.f5574a = t2;
            this.f5575b = bVar;
        }

        public void onGlobalLayout() {
            Integer num = this.f5576c;
            if (num != null) {
                int measuredWidth = this.f5574a.getMeasuredWidth();
                if (num != null && num.intValue() == measuredWidth) {
                    this.f5574a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    return;
                }
            }
            if (this.f5574a.getMeasuredWidth() > 0 && this.f5574a.getMeasuredHeight() > 0) {
                Integer num2 = this.f5576c;
                int measuredWidth2 = this.f5574a.getMeasuredWidth();
                if (num2 == null || num2.intValue() != measuredWidth2) {
                    this.f5576c = Integer.valueOf(this.f5574a.getMeasuredWidth());
                    this.f5575b.invoke(this.f5574a);
                }
            }
        }
    }

    private e() {
    }

    public static /* synthetic */ int a(e eVar, Context context, Integer num, Integer num2, mm.a aVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            num2 = null;
        }
        if ((i2 & 8) != 0) {
            aVar = null;
        }
        return eVar.a(context, num, num2, (mm.a<Integer>) aVar);
    }

    public static /* synthetic */ Drawable a(e eVar, Context context, Integer num, Integer num2, Drawable drawable, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            num = null;
        }
        if ((i2 & 4) != 0) {
            num2 = null;
        }
        if ((i2 & 8) != 0) {
            drawable = null;
        }
        return eVar.a(context, num, num2, drawable);
    }

    public static /* synthetic */ void a(e eVar, View view, int i2, int i3, int i4, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i2 = view != null ? view.getPaddingLeft() : 0;
        }
        int i7 = i2;
        if ((i6 & 2) != 0) {
            i3 = view != null ? view.getPaddingTop() : 0;
        }
        int i8 = i3;
        if ((i6 & 4) != 0) {
            i4 = view != null ? view.getPaddingRight() : 0;
        }
        int i9 = i4;
        if ((i6 & 8) != 0) {
            i5 = view != null ? view.getPaddingBottom() : 0;
        }
        eVar.a(view, i7, i8, i9, i5);
    }

    public static /* synthetic */ boolean a(e eVar, int i2, double d2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            d2 = 0.5d;
        }
        return eVar.a(i2, d2);
    }

    public final float a(Context context, int i2, mm.a<Float> aVar) {
        float f2;
        h.c(context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i2});
        if (aVar != null) {
            try {
                Float e_ = aVar.e_();
                if (e_ != null) {
                    f2 = e_.floatValue();
                    float dimension = obtainStyledAttributes.getDimension(0, f2);
                    obtainStyledAttributes.recycle();
                    return dimension;
                }
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        }
        f2 = 0.0f;
        float dimension2 = obtainStyledAttributes.getDimension(0, f2);
        obtainStyledAttributes.recycle();
        return dimension2;
    }

    public final int a(Context context, int i2, int i3) {
        h.c(context, "context");
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{i2});
        try {
            return obtainStyledAttributes.getInt(0, i3);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final int a(Context context, Integer num, Integer num2, mm.a<Integer> aVar) {
        h.c(context, "context");
        int i2 = 0;
        if (num2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{num2.intValue()});
            try {
                int color = obtainStyledAttributes.getColor(0, 0);
                if (color == 0 && aVar != null) {
                    return aVar.e_().intValue();
                }
                obtainStyledAttributes.recycle();
                return color;
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            if (num != null) {
                i2 = num.intValue();
            }
            return androidx.core.content.b.c(context, i2);
        }
    }

    public final <T extends View> int a(T t2, int i2) {
        h.c(t2, "$this$dimenPx");
        Context context = t2.getContext();
        h.a((Object) context, "context");
        return context.getResources().getDimensionPixelSize(i2);
    }

    public final int a(TextView textView) {
        h.c(textView, "$this$additionalPaddingForFont");
        TextPaint paint = textView.getPaint();
        h.a((Object) paint, "paint");
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f2 = fontMetrics.descent - fontMetrics.ascent;
        if (f2 > ((float) textView.getMeasuredHeight())) {
            return (int) (f2 - ((float) textView.getMeasuredHeight()));
        }
        return 0;
    }

    public final Drawable a(Context context, Integer num, Integer num2, Drawable drawable) {
        h.c(context, "context");
        if (num2 == null) {
            return num == null ? drawable : androidx.core.content.b.a(context, num.intValue());
        }
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{num2.intValue()});
        try {
            Drawable drawable2 = obtainStyledAttributes.getDrawable(0);
            if (drawable2 != null || drawable == null) {
                drawable = drawable2;
            }
            return drawable;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final Pair<Integer, Integer> a(WindowManager windowManager) {
        h.c(windowManager, "$this$getWidthAndHeight");
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        return new Pair<>(Integer.valueOf(point.x), Integer.valueOf(point.y));
    }

    public final <T extends View> void a(T t2, int i2, int i3, int i4, int i5) {
        if ((t2 == null || i2 != t2.getPaddingLeft() || i3 != t2.getPaddingTop() || i4 != t2.getPaddingRight() || i5 != t2.getPaddingBottom()) && t2 != null) {
            t2.setPadding(i2, i3, i4, i5);
        }
    }

    public final <T extends View> void a(T t2, b<? super T, l> bVar) {
        h.c(t2, "$this$waitForWidth");
        h.c(bVar, "block");
        if (t2.getMeasuredWidth() <= 0 || t2.getMeasuredHeight() <= 0) {
            t2.getViewTreeObserver().addOnGlobalLayoutListener(new a(t2, bVar));
        } else {
            bVar.invoke(t2);
        }
    }

    public final void a(String str, Object obj, Integer num) {
        h.c(str, "method");
        if (num == null && obj == null) {
            throw new IllegalArgumentException(str + ": You must specify a resource ID or literal value");
        }
    }

    public final boolean a(int i2, double d2) {
        if (i2 == 0) {
            return false;
        }
        double d3 = (double) 1;
        double red = (double) Color.red(i2);
        Double.isNaN(red);
        double green = (double) Color.green(i2);
        Double.isNaN(green);
        double d4 = (red * 0.299d) + (green * 0.587d);
        double blue = (double) Color.blue(i2);
        Double.isNaN(blue);
        double d5 = (double) 255;
        Double.isNaN(d5);
        Double.isNaN(d3);
        return d3 - ((d4 + (blue * 0.114d)) / d5) >= d2;
    }
}
