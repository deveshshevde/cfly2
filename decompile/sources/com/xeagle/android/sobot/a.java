package com.xeagle.android.sobot;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private View f24328a;

    /* renamed from: b  reason: collision with root package name */
    private int f24329b;

    /* renamed from: c  reason: collision with root package name */
    private FrameLayout.LayoutParams f24330c = ((FrameLayout.LayoutParams) this.f24328a.getLayoutParams());

    private a(Activity activity) {
        View childAt = ((FrameLayout) activity.findViewById(16908290)).getChildAt(0);
        this.f24328a = childAt;
        childAt.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                a.this.a();
            }
        });
    }

    /* access modifiers changed from: private */
    public void a() {
        int b2 = b();
        if (b2 != this.f24329b) {
            int height = this.f24328a.getRootView().getHeight();
            int i2 = height - b2;
            if (i2 > height / 4) {
                this.f24330c.height = height - i2;
            } else {
                this.f24330c.height = height;
            }
            this.f24328a.requestLayout();
            this.f24329b = b2;
        }
    }

    public static void a(Activity activity) {
        new a(activity);
    }

    private int b() {
        Rect rect = new Rect();
        this.f24328a.getWindowVisibleDisplayFrame(rect);
        return rect.bottom - rect.top;
    }
}
