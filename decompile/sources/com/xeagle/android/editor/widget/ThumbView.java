package com.xeagle.android.editor.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import com.blankj.utilcode.constant.MemoryConstants;

public class ThumbView extends View {

    /* renamed from: a  reason: collision with root package name */
    private final int f22916a;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f22917b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f22918c;

    /* renamed from: d  reason: collision with root package name */
    private int f22919d;

    /* renamed from: e  reason: collision with root package name */
    private int f22920e;

    public ThumbView(Context context, Drawable drawable, int i2) {
        super(context);
        this.f22919d = i2;
        this.f22917b = drawable;
        this.f22916a = (int) TypedValue.applyDimension(1, 15.0f, context.getResources().getDisplayMetrics());
        setBackground(this.f22917b);
    }

    public boolean a(int i2, int i3) {
        Rect rect = new Rect();
        getHitRect(rect);
        rect.left -= this.f22916a;
        rect.right += this.f22916a;
        rect.top -= this.f22916a;
        rect.bottom += this.f22916a;
        return rect.contains(i2, i3);
    }

    public int getRangeIndex() {
        return this.f22920e;
    }

    public boolean isPressed() {
        return this.f22918c;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.f22919d, MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), MemoryConstants.GB));
        this.f22917b.setBounds(0, 0, this.f22919d, getMeasuredHeight());
    }

    public void setPressed(boolean z2) {
        this.f22918c = z2;
    }

    public void setThumbDrawable(Drawable drawable) {
        this.f22917b = drawable;
    }

    public void setThumbWidth(int i2) {
        this.f22919d = i2;
    }

    public void setTickIndex(int i2) {
        this.f22920e = i2;
    }
}
