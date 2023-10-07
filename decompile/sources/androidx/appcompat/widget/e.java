package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import androidx.core.graphics.drawable.a;
import androidx.core.widget.c;

class e {

    /* renamed from: a  reason: collision with root package name */
    private final CompoundButton f1482a;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f1483b = null;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f1484c = null;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1485d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1486e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1487f;

    e(CompoundButton compoundButton) {
        this.f1482a = compoundButton;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = androidx.core.widget.c.b(r2.f1482a);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(int r3) {
        /*
            r2 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 17
            if (r0 >= r1) goto L_0x0013
            android.widget.CompoundButton r0 = r2.f1482a
            android.graphics.drawable.Drawable r0 = androidx.core.widget.c.b(r0)
            if (r0 == 0) goto L_0x0013
            int r0 = r0.getIntrinsicWidth()
            int r3 = r3 + r0
        L_0x0013:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.e.a(int):int");
    }

    /* access modifiers changed from: package-private */
    public ColorStateList a() {
        return this.f1483b;
    }

    /* access modifiers changed from: package-private */
    public void a(ColorStateList colorStateList) {
        this.f1483b = colorStateList;
        this.f1485d = true;
        d();
    }

    /* access modifiers changed from: package-private */
    public void a(PorterDuff.Mode mode) {
        this.f1484c = mode;
        this.f1486e = true;
        d();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041 A[SYNTHETIC, Splitter:B:12:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0066 A[Catch:{ all -> 0x008e }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0079 A[Catch:{ all -> 0x008e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.util.AttributeSet r11, int r12) {
        /*
            r10 = this;
            android.widget.CompoundButton r0 = r10.f1482a
            android.content.Context r0 = r0.getContext()
            int[] r1 = androidx.appcompat.R.styleable.CompoundButton
            r2 = 0
            androidx.appcompat.widget.af r0 = androidx.appcompat.widget.af.a(r0, r11, r1, r12, r2)
            android.widget.CompoundButton r3 = r10.f1482a
            android.content.Context r4 = r3.getContext()
            int[] r5 = androidx.appcompat.R.styleable.CompoundButton
            android.content.res.TypedArray r7 = r0.a()
            r9 = 0
            r6 = r11
            r8 = r12
            t.ac.a(r3, r4, r5, r6, r7, r8, r9)
            int r11 = androidx.appcompat.R.styleable.CompoundButton_buttonCompat     // Catch:{ all -> 0x008e }
            boolean r11 = r0.g(r11)     // Catch:{ all -> 0x008e }
            if (r11 == 0) goto L_0x003e
            int r11 = androidx.appcompat.R.styleable.CompoundButton_buttonCompat     // Catch:{ all -> 0x008e }
            int r11 = r0.g(r11, r2)     // Catch:{ all -> 0x008e }
            if (r11 == 0) goto L_0x003e
            android.widget.CompoundButton r12 = r10.f1482a     // Catch:{ NotFoundException -> 0x003e }
            android.content.Context r1 = r12.getContext()     // Catch:{ NotFoundException -> 0x003e }
            android.graphics.drawable.Drawable r11 = c.a.b(r1, r11)     // Catch:{ NotFoundException -> 0x003e }
            r12.setButtonDrawable(r11)     // Catch:{ NotFoundException -> 0x003e }
            r11 = 1
            goto L_0x003f
        L_0x003e:
            r11 = 0
        L_0x003f:
            if (r11 != 0) goto L_0x005e
            int r11 = androidx.appcompat.R.styleable.CompoundButton_android_button     // Catch:{ all -> 0x008e }
            boolean r11 = r0.g(r11)     // Catch:{ all -> 0x008e }
            if (r11 == 0) goto L_0x005e
            int r11 = androidx.appcompat.R.styleable.CompoundButton_android_button     // Catch:{ all -> 0x008e }
            int r11 = r0.g(r11, r2)     // Catch:{ all -> 0x008e }
            if (r11 == 0) goto L_0x005e
            android.widget.CompoundButton r12 = r10.f1482a     // Catch:{ all -> 0x008e }
            android.content.Context r1 = r12.getContext()     // Catch:{ all -> 0x008e }
            android.graphics.drawable.Drawable r11 = c.a.b(r1, r11)     // Catch:{ all -> 0x008e }
            r12.setButtonDrawable(r11)     // Catch:{ all -> 0x008e }
        L_0x005e:
            int r11 = androidx.appcompat.R.styleable.CompoundButton_buttonTint     // Catch:{ all -> 0x008e }
            boolean r11 = r0.g(r11)     // Catch:{ all -> 0x008e }
            if (r11 == 0) goto L_0x0071
            android.widget.CompoundButton r11 = r10.f1482a     // Catch:{ all -> 0x008e }
            int r12 = androidx.appcompat.R.styleable.CompoundButton_buttonTint     // Catch:{ all -> 0x008e }
            android.content.res.ColorStateList r12 = r0.e(r12)     // Catch:{ all -> 0x008e }
            androidx.core.widget.c.a((android.widget.CompoundButton) r11, (android.content.res.ColorStateList) r12)     // Catch:{ all -> 0x008e }
        L_0x0071:
            int r11 = androidx.appcompat.R.styleable.CompoundButton_buttonTintMode     // Catch:{ all -> 0x008e }
            boolean r11 = r0.g(r11)     // Catch:{ all -> 0x008e }
            if (r11 == 0) goto L_0x008a
            android.widget.CompoundButton r11 = r10.f1482a     // Catch:{ all -> 0x008e }
            int r12 = androidx.appcompat.R.styleable.CompoundButton_buttonTintMode     // Catch:{ all -> 0x008e }
            r1 = -1
            int r12 = r0.a((int) r12, (int) r1)     // Catch:{ all -> 0x008e }
            r1 = 0
            android.graphics.PorterDuff$Mode r12 = androidx.appcompat.widget.q.a(r12, r1)     // Catch:{ all -> 0x008e }
            androidx.core.widget.c.a((android.widget.CompoundButton) r11, (android.graphics.PorterDuff.Mode) r12)     // Catch:{ all -> 0x008e }
        L_0x008a:
            r0.b()
            return
        L_0x008e:
            r11 = move-exception
            r0.b()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.e.a(android.util.AttributeSet, int):void");
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode b() {
        return this.f1484c;
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.f1487f) {
            this.f1487f = false;
            return;
        }
        this.f1487f = true;
        d();
    }

    /* access modifiers changed from: package-private */
    public void d() {
        Drawable b2 = c.b(this.f1482a);
        if (b2 == null) {
            return;
        }
        if (this.f1485d || this.f1486e) {
            Drawable mutate = a.g(b2).mutate();
            if (this.f1485d) {
                a.a(mutate, this.f1483b);
            }
            if (this.f1486e) {
                a.a(mutate, this.f1484c);
            }
            if (mutate.isStateful()) {
                mutate.setState(this.f1482a.getDrawableState());
            }
            this.f1482a.setButtonDrawable(mutate);
        }
    }
}
