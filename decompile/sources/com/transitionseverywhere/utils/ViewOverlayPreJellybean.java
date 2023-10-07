package com.transitionseverywhere.utils;

import android.animation.LayoutTransition;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.transitionseverywhere.R;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class ViewOverlayPreJellybean extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final Field f21944a = i.a(View.class, "mParent");

    /* renamed from: b  reason: collision with root package name */
    private List<Drawable> f21945b;

    public ViewOverlayPreJellybean(Context context) {
        super(context);
        a();
    }

    public ViewOverlayPreJellybean(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public ViewOverlayPreJellybean(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    public static ViewOverlayPreJellybean a(ViewGroup viewGroup) {
        ViewGroup viewGroup2 = viewGroup;
        while (viewGroup2.getId() != 16908290 && viewGroup2.getParent() != null && (viewGroup2.getParent() instanceof ViewGroup)) {
            viewGroup2 = (ViewGroup) viewGroup2.getParent();
        }
        for (int i2 = 0; i2 < viewGroup2.getChildCount(); i2++) {
            View childAt = viewGroup2.getChildAt(i2);
            if (childAt instanceof ViewOverlayPreJellybean) {
                return (ViewOverlayPreJellybean) childAt;
            }
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 119;
        ViewOverlayPreJellybean viewOverlayPreJellybean = new ViewOverlayPreJellybean(viewGroup.getContext());
        viewGroup2.addView(viewOverlayPreJellybean, layoutParams);
        return viewOverlayPreJellybean;
    }

    private void a() {
        this.f21945b = new ArrayList();
    }

    private FrameLayout.LayoutParams b(View view, int i2, int i3) {
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        int i4 = i2 - iArr[0];
        int i5 = i3 - iArr[1];
        layoutParams.leftMargin = i4;
        layoutParams.topMargin = i5;
        view.setLeft(i4);
        view.setTop(i5);
        if (view.getMeasuredWidth() != 0) {
            layoutParams.width = view.getMeasuredWidth();
            view.setRight(i4 + layoutParams.width);
        }
        if (view.getMeasuredHeight() != 0) {
            layoutParams.height = view.getMeasuredHeight();
            view.setBottom(i5 + layoutParams.height);
        }
        return layoutParams;
    }

    public synchronized void a(Drawable drawable) {
        this.f21945b.add(drawable);
        invalidate();
    }

    public void a(View view, int i2, int i3) {
        if (view.getParent() == this) {
            view.setLayoutParams(b(view, i2, i3));
        }
    }

    public void addView(View view, int i2, int i3) {
        LayoutTransition layoutTransition;
        Field field;
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup.getLayoutTransition() != null) {
                layoutTransition = viewGroup.getLayoutTransition();
                viewGroup.setLayoutTransition((LayoutTransition) null);
            } else {
                layoutTransition = null;
            }
            viewGroup.removeView(view);
            if (layoutTransition != null) {
                viewGroup.setLayoutTransition(layoutTransition);
            }
            if (view.getParent() != null) {
                k.a(viewGroup);
                if (!(view.getParent() == null || (field = f21944a) == null)) {
                    i.a((Object) view, field, (Object) null);
                }
            }
            if (view.getParent() != null) {
                return;
            }
        }
        view.setTag(R.id.overlay_layout_params_backup, view.getLayoutParams());
        addView(view, b(view, i2, i3));
        invalidate();
    }

    public synchronized void b(Drawable drawable) {
        this.f21945b.remove(drawable);
        invalidate();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Drawable draw : this.f21945b) {
            draw.draw(canvas);
        }
    }

    public void removeView(View view) {
        super.removeView(view);
        m.a(view, (ViewGroup.LayoutParams) view.getTag(R.id.overlay_layout_params_backup));
        view.setTag(R.id.overlay_layout_params_backup, (Object) null);
    }
}
