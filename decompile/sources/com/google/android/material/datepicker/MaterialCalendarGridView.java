package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.google.android.material.R;
import com.google.android.material.internal.s;
import java.util.Calendar;
import s.d;
import t.a;
import t.ac;
import u.c;

final class MaterialCalendarGridView extends GridView {

    /* renamed from: a  reason: collision with root package name */
    private final Calendar f18919a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f18920b;

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f18919a = o.c();
        if (f.a(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        this.f18920b = f.b(getContext());
        ac.a((View) this, (a) new a() {
            public void a(View view, c cVar) {
                super.a(view, cVar);
                cVar.a((Object) null);
            }
        });
    }

    private static int a(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private void a(int i2, Rect rect) {
        int a2;
        if (i2 == 33) {
            a2 = getAdapter().b();
        } else if (i2 == 130) {
            a2 = getAdapter().a();
        } else {
            super.onFocusChanged(true, i2, rect);
            return;
        }
        setSelection(a2);
    }

    private static boolean a(Long l2, Long l3, Long l4, Long l5) {
        return l2 == null || l3 == null || l4 == null || l5 == null || l4.longValue() > l3.longValue() || l5.longValue() < l2.longValue();
    }

    /* renamed from: a */
    public i getAdapter() {
        return (i) super.getAdapter();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        i a2 = getAdapter();
        DateSelector<?> dateSelector = a2.f19004c;
        b bVar = a2.f19005d;
        Long a3 = a2.getItem(a2.a());
        Long a4 = a2.getItem(a2.b());
        for (d next : dateSelector.d()) {
            if (next.f34394a != null) {
                if (next.f34395b != null) {
                    long longValue = ((Long) next.f34394a).longValue();
                    long longValue2 = ((Long) next.f34395b).longValue();
                    if (!a(a3, a4, Long.valueOf(longValue), Long.valueOf(longValue2))) {
                        boolean a5 = s.a(this);
                        if (longValue < a3.longValue()) {
                            i3 = a2.a();
                            if (a2.e(i3)) {
                                i2 = 0;
                            } else {
                                View childAt = materialCalendarGridView.getChildAt(i3 - 1);
                                i2 = !a5 ? childAt.getRight() : childAt.getLeft();
                            }
                        } else {
                            materialCalendarGridView.f18919a.setTimeInMillis(longValue);
                            i3 = a2.c(materialCalendarGridView.f18919a.get(5));
                            i2 = a(materialCalendarGridView.getChildAt(i3));
                        }
                        if (longValue2 > a4.longValue()) {
                            i5 = Math.min(a2.b(), getChildCount() - 1);
                            if (a2.f(i5)) {
                                i4 = getWidth();
                            } else {
                                View childAt2 = materialCalendarGridView.getChildAt(i5);
                                i4 = !a5 ? childAt2.getRight() : childAt2.getLeft();
                            }
                        } else {
                            materialCalendarGridView.f18919a.setTimeInMillis(longValue2);
                            i5 = a2.c(materialCalendarGridView.f18919a.get(5));
                            i4 = a(materialCalendarGridView.getChildAt(i5));
                        }
                        int itemId = (int) a2.getItemId(i3);
                        int itemId2 = (int) a2.getItemId(i5);
                        while (itemId <= itemId2) {
                            int numColumns = getNumColumns() * itemId;
                            int numColumns2 = (getNumColumns() + numColumns) - 1;
                            View childAt3 = materialCalendarGridView.getChildAt(numColumns);
                            int top = childAt3.getTop() + bVar.f18952a.a();
                            int bottom = childAt3.getBottom() - bVar.f18952a.b();
                            if (!a5) {
                                i7 = numColumns > i3 ? 0 : i2;
                                i6 = i5 > numColumns2 ? getWidth() : i4;
                            } else {
                                int i8 = i5 > numColumns2 ? 0 : i4;
                                i6 = numColumns > i3 ? getWidth() : i2;
                                i7 = i8;
                            }
                            canvas.drawRect((float) i7, (float) top, (float) i6, (float) bottom, bVar.f18959h);
                            itemId++;
                            materialCalendarGridView = this;
                            a2 = a2;
                        }
                    }
                }
            }
            materialCalendarGridView = this;
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z2, int i2, Rect rect) {
        if (z2) {
            a(i2, rect);
        } else {
            super.onFocusChanged(false, i2, rect);
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (!super.onKeyDown(i2, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter().a()) {
            return true;
        }
        if (19 != i2) {
            return false;
        }
        setSelection(getAdapter().a());
        return true;
    }

    public void onMeasure(int i2, int i3) {
        if (this.f18920b) {
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i2, i3);
    }

    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof i) {
            super.setAdapter(listAdapter);
        } else {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", new Object[]{MaterialCalendarGridView.class.getCanonicalName(), i.class.getCanonicalName()}));
        }
    }

    public void setSelection(int i2) {
        if (i2 < getAdapter().a()) {
            i2 = getAdapter().a();
        }
        super.setSelection(i2);
    }
}
