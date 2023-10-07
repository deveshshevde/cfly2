package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import l.f;

public class af {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1405a;

    /* renamed from: b  reason: collision with root package name */
    private final TypedArray f1406b;

    /* renamed from: c  reason: collision with root package name */
    private TypedValue f1407c;

    private af(Context context, TypedArray typedArray) {
        this.f1405a = context;
        this.f1406b = typedArray;
    }

    public static af a(Context context, int i2, int[] iArr) {
        return new af(context, context.obtainStyledAttributes(i2, iArr));
    }

    public static af a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new af(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static af a(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3) {
        return new af(context, context.obtainStyledAttributes(attributeSet, iArr, i2, i3));
    }

    public float a(int i2, float f2) {
        return this.f1406b.getFloat(i2, f2);
    }

    public int a(int i2, int i3) {
        return this.f1406b.getInt(i2, i3);
    }

    public TypedArray a() {
        return this.f1406b;
    }

    public Typeface a(int i2, int i3, f.c cVar) {
        int resourceId = this.f1406b.getResourceId(i2, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1407c == null) {
            this.f1407c = new TypedValue();
        }
        return f.a(this.f1405a, resourceId, this.f1407c, i3, cVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r2.f1406b.getResourceId(r3, 0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.drawable.Drawable a(int r3) {
        /*
            r2 = this;
            android.content.res.TypedArray r0 = r2.f1406b
            boolean r0 = r0.hasValue(r3)
            if (r0 == 0) goto L_0x0018
            android.content.res.TypedArray r0 = r2.f1406b
            r1 = 0
            int r0 = r0.getResourceId(r3, r1)
            if (r0 == 0) goto L_0x0018
            android.content.Context r3 = r2.f1405a
            android.graphics.drawable.Drawable r3 = c.a.b(r3, r0)
            return r3
        L_0x0018:
            android.content.res.TypedArray r0 = r2.f1406b
            android.graphics.drawable.Drawable r3 = r0.getDrawable(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.af.a(int):android.graphics.drawable.Drawable");
    }

    public boolean a(int i2, boolean z2) {
        return this.f1406b.getBoolean(i2, z2);
    }

    public float b(int i2, float f2) {
        return this.f1406b.getDimension(i2, f2);
    }

    public int b(int i2, int i3) {
        return this.f1406b.getColor(i2, i3);
    }

    public Drawable b(int i2) {
        int resourceId;
        if (!this.f1406b.hasValue(i2) || (resourceId = this.f1406b.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return f.b().a(this.f1405a, resourceId, true);
    }

    public void b() {
        this.f1406b.recycle();
    }

    public int c(int i2, int i3) {
        return this.f1406b.getInteger(i2, i3);
    }

    public CharSequence c(int i2) {
        return this.f1406b.getText(i2);
    }

    public int d(int i2, int i3) {
        return this.f1406b.getDimensionPixelOffset(i2, i3);
    }

    public String d(int i2) {
        return this.f1406b.getString(i2);
    }

    public int e(int i2, int i3) {
        return this.f1406b.getDimensionPixelSize(i2, i3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r0 = c.a.a(r2.f1405a, (r0 = r2.f1406b.getResourceId(r3, 0)));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.content.res.ColorStateList e(int r3) {
        /*
            r2 = this;
            android.content.res.TypedArray r0 = r2.f1406b
            boolean r0 = r0.hasValue(r3)
            if (r0 == 0) goto L_0x001a
            android.content.res.TypedArray r0 = r2.f1406b
            r1 = 0
            int r0 = r0.getResourceId(r3, r1)
            if (r0 == 0) goto L_0x001a
            android.content.Context r1 = r2.f1405a
            android.content.res.ColorStateList r0 = c.a.a(r1, r0)
            if (r0 == 0) goto L_0x001a
            return r0
        L_0x001a:
            android.content.res.TypedArray r0 = r2.f1406b
            android.content.res.ColorStateList r3 = r0.getColorStateList(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.af.e(int):android.content.res.ColorStateList");
    }

    public int f(int i2, int i3) {
        return this.f1406b.getLayoutDimension(i2, i3);
    }

    public CharSequence[] f(int i2) {
        return this.f1406b.getTextArray(i2);
    }

    public int g(int i2, int i3) {
        return this.f1406b.getResourceId(i2, i3);
    }

    public boolean g(int i2) {
        return this.f1406b.hasValue(i2);
    }
}
