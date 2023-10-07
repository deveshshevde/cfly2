package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class h extends RecyclerView.g {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f4187a = {16843284};

    /* renamed from: b  reason: collision with root package name */
    private Drawable f4188b;

    /* renamed from: c  reason: collision with root package name */
    private int f4189c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f4190d = new Rect();

    public h(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f4187a);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        this.f4188b = drawable;
        if (drawable == null) {
            Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        obtainStyledAttributes.recycle();
        a(i2);
    }

    private void a(Canvas canvas, RecyclerView recyclerView) {
        int i2;
        int i3;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i3 = recyclerView.getPaddingLeft();
            i2 = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(i3, recyclerView.getPaddingTop(), i2, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            i2 = recyclerView.getWidth();
            i3 = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = recyclerView.getChildAt(i4);
            recyclerView.a(childAt, this.f4190d);
            int round = this.f4190d.bottom + Math.round(childAt.getTranslationY());
            this.f4188b.setBounds(i3, round - this.f4188b.getIntrinsicHeight(), i2, round);
            this.f4188b.draw(canvas);
        }
        canvas.restore();
    }

    private void b(Canvas canvas, RecyclerView recyclerView) {
        int i2;
        int i3;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i3 = recyclerView.getPaddingTop();
            i2 = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), i3, recyclerView.getWidth() - recyclerView.getPaddingRight(), i2);
        } else {
            i2 = recyclerView.getHeight();
            i3 = 0;
        }
        int childCount = recyclerView.getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = recyclerView.getChildAt(i4);
            recyclerView.getLayoutManager().a(childAt, this.f4190d);
            int round = this.f4190d.right + Math.round(childAt.getTranslationX());
            this.f4188b.setBounds(round - this.f4188b.getIntrinsicWidth(), i3, round, i2);
            this.f4188b.draw(canvas);
        }
        canvas.restore();
    }

    public void a(int i2) {
        if (i2 == 0 || i2 == 1) {
            this.f4189c = i2;
            return;
        }
        throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        Drawable drawable = this.f4188b;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.f4189c == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        if (recyclerView.getLayoutManager() != null && this.f4188b != null) {
            if (this.f4189c == 1) {
                a(canvas, recyclerView);
            } else {
                b(canvas, recyclerView);
            }
        }
    }
}
