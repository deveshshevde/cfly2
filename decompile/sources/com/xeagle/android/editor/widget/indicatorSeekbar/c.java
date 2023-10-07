package com.xeagle.android.editor.widget.indicatorSeekbar;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.cfly.uav_pro.R;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final int f23130a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f23131b = new int[2];

    /* renamed from: c  reason: collision with root package name */
    private ArrowView f23132c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f23133d;

    /* renamed from: e  reason: collision with root package name */
    private PopupWindow f23134e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f23135f;

    /* renamed from: g  reason: collision with root package name */
    private int f23136g;

    /* renamed from: h  reason: collision with root package name */
    private int f23137h;

    /* renamed from: i  reason: collision with root package name */
    private Context f23138i;

    /* renamed from: j  reason: collision with root package name */
    private int f23139j;

    /* renamed from: k  reason: collision with root package name */
    private IndicatorSeekBar f23140k;

    /* renamed from: l  reason: collision with root package name */
    private View f23141l;

    /* renamed from: m  reason: collision with root package name */
    private View f23142m;

    /* renamed from: n  reason: collision with root package name */
    private View f23143n;

    /* renamed from: o  reason: collision with root package name */
    private float f23144o;

    /* renamed from: p  reason: collision with root package name */
    private int f23145p;

    public c(Context context, IndicatorSeekBar indicatorSeekBar, int i2, int i3, int i4, int i5, View view, View view2) {
        this.f23138i = context;
        this.f23140k = indicatorSeekBar;
        this.f23137h = i2;
        this.f23139j = i3;
        this.f23142m = view;
        this.f23143n = view2;
        this.f23144o = (float) i4;
        this.f23145p = i5;
        this.f23130a = h();
        this.f23136g = f.a(this.f23138i, 2.0f);
        f();
    }

    private void a(View view, int i2, int i3, int i4, int i5) {
        if (view != null && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (i2 == -1) {
                i2 = marginLayoutParams.leftMargin;
            }
            if (i3 == -1) {
                i3 = marginLayoutParams.topMargin;
            }
            if (i4 == -1) {
                i4 = marginLayoutParams.rightMargin;
            }
            if (i5 == -1) {
                i5 = marginLayoutParams.bottomMargin;
            }
            marginLayoutParams.setMargins(i2, i3, i4, i5);
            view.requestLayout();
        }
    }

    private void c(float f2) {
        ArrowView arrowView;
        int measuredWidth;
        int i2 = this.f23139j;
        if (i2 != 4 && i2 != 1) {
            int i3 = i();
            if (((float) i3) + f2 < ((float) (this.f23134e.getContentView().getMeasuredWidth() / 2))) {
                arrowView = this.f23132c;
                measuredWidth = -((int) (((float) ((this.f23134e.getContentView().getMeasuredWidth() / 2) - i3)) - f2));
            } else if (((float) (this.f23130a - i3)) - f2 < ((float) (this.f23134e.getContentView().getMeasuredWidth() / 2))) {
                arrowView = this.f23132c;
                measuredWidth = (int) (((float) (this.f23134e.getContentView().getMeasuredWidth() / 2)) - (((float) (this.f23130a - i3)) - f2));
            } else {
                a(this.f23132c, 0, 0, 0, 0);
                return;
            }
            a(arrowView, measuredWidth, -1, -1, -1);
        }
    }

    private void f() {
        View findViewById;
        View findViewById2;
        int i2 = this.f23139j;
        if (i2 == 4) {
            View view = this.f23142m;
            if (view != null) {
                this.f23141l = view;
                int identifier = this.f23138i.getResources().getIdentifier("isb_progress", "id", this.f23138i.getApplicationContext().getPackageName());
                if (identifier > 0 && (findViewById2 = this.f23141l.findViewById(identifier)) != null) {
                    if (findViewById2 instanceof TextView) {
                        TextView textView = (TextView) findViewById2;
                        this.f23133d = textView;
                        textView.setText(this.f23140k.getIndicatorTextString());
                        this.f23133d.setTextSize((float) f.c(this.f23138i, this.f23144o));
                        this.f23133d.setTextColor(this.f23145p);
                        return;
                    }
                    throw new ClassCastException("the view identified by isb_progress in indicator custom layout can not be cast to TextView");
                }
                return;
            }
            throw new IllegalArgumentException("the attr：indicator_custom_layout must be set while you set the indicator type to CUSTOM.");
        } else if (i2 == 1) {
            CircleBubbleView circleBubbleView = new CircleBubbleView(this.f23138i, this.f23144o, this.f23145p, this.f23137h, "1000");
            this.f23141l = circleBubbleView;
            circleBubbleView.setProgress(this.f23140k.getIndicatorTextString());
        } else {
            View inflate = View.inflate(this.f23138i, R.layout.isb_indicator, (ViewGroup) null);
            this.f23141l = inflate;
            this.f23135f = (LinearLayout) inflate.findViewById(R.id.indicator_container);
            ArrowView arrowView = (ArrowView) this.f23141l.findViewById(R.id.indicator_arrow);
            this.f23132c = arrowView;
            arrowView.setColor(this.f23137h);
            TextView textView2 = (TextView) this.f23141l.findViewById(R.id.isb_progress);
            this.f23133d = textView2;
            textView2.setText(this.f23140k.getIndicatorTextString());
            this.f23133d.setTextSize((float) f.c(this.f23138i, this.f23144o));
            this.f23133d.setTextColor(this.f23145p);
            if (Build.VERSION.SDK_INT >= 16) {
                this.f23135f.setBackground(g());
            } else {
                this.f23135f.setBackgroundDrawable(g());
            }
            if (this.f23143n != null) {
                int identifier2 = this.f23138i.getResources().getIdentifier("isb_progress", "id", this.f23138i.getApplicationContext().getPackageName());
                View view2 = this.f23143n;
                if (identifier2 <= 0 || (findViewById = view2.findViewById(identifier2)) == null || !(findViewById instanceof TextView)) {
                    a(view2);
                } else {
                    a(view2, (TextView) findViewById);
                }
            }
        }
    }

    private GradientDrawable g() {
        int i2;
        Resources resources;
        if (this.f23139j == 2) {
            resources = this.f23138i.getResources();
            i2 = R.drawable.isb_indicator_rounded_corners;
        } else {
            resources = this.f23138i.getResources();
            i2 = R.drawable.isb_indicator_square_corners;
        }
        GradientDrawable gradientDrawable = (GradientDrawable) resources.getDrawable(i2);
        gradientDrawable.setColor(this.f23137h);
        return gradientDrawable;
    }

    private int h() {
        WindowManager windowManager = (WindowManager) this.f23138i.getSystemService("window");
        if (windowManager != null) {
            return windowManager.getDefaultDisplay().getWidth();
        }
        return 0;
    }

    private int i() {
        this.f23140k.getLocationOnScreen(this.f23131b);
        return this.f23131b[0];
    }

    /* access modifiers changed from: package-private */
    public void a() {
        View view;
        if (this.f23134e == null && this.f23139j != 0 && (view = this.f23141l) != null) {
            view.measure(0, 0);
            this.f23134e = new PopupWindow(this.f23141l, -2, -2, false);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        if (this.f23140k.isEnabled() && this.f23140k.getVisibility() == 0) {
            c();
            PopupWindow popupWindow = this.f23134e;
            if (popupWindow != null) {
                popupWindow.getContentView().measure(0, 0);
                PopupWindow popupWindow2 = this.f23134e;
                popupWindow2.update(this.f23140k, (int) (f2 - ((float) (popupWindow2.getContentView().getMeasuredWidth() / 2))), -(((this.f23140k.getMeasuredHeight() + this.f23134e.getContentView().getMeasuredHeight()) - this.f23140k.getPaddingTop()) + this.f23136g), -1, -1);
                c(f2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        a(this.f23141l, i2, -1, -1, -1);
    }

    public void a(View view) {
        a(view, (TextView) null);
    }

    public void a(View view, TextView textView) {
        this.f23133d = textView;
        this.f23135f.removeAllViews();
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(g());
        } else {
            view.setBackgroundDrawable(g());
        }
        this.f23135f.addView(view);
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        View view = this.f23141l;
        if (view instanceof CircleBubbleView) {
            ((CircleBubbleView) view).setProgress(str);
            return;
        }
        TextView textView = this.f23133d;
        if (textView != null) {
            textView.setText(str);
        }
    }

    /* access modifiers changed from: package-private */
    public View b() {
        return this.f23141l;
    }

    /* access modifiers changed from: package-private */
    public void b(float f2) {
        if (this.f23140k.isEnabled() && this.f23140k.getVisibility() == 0) {
            c();
            PopupWindow popupWindow = this.f23134e;
            if (popupWindow != null) {
                popupWindow.getContentView().measure(0, 0);
                PopupWindow popupWindow2 = this.f23134e;
                popupWindow2.showAsDropDown(this.f23140k, (int) (f2 - (((float) popupWindow2.getContentView().getMeasuredWidth()) / 2.0f)), -(((this.f23140k.getMeasuredHeight() + this.f23134e.getContentView().getMeasuredHeight()) - this.f23140k.getPaddingTop()) + this.f23136g));
                c(f2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        a(this.f23132c, i2, -1, -1, -1);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        String indicatorTextString = this.f23140k.getIndicatorTextString();
        View view = this.f23141l;
        if (view instanceof CircleBubbleView) {
            ((CircleBubbleView) view).setProgress(indicatorTextString);
            return;
        }
        TextView textView = this.f23133d;
        if (textView != null) {
            textView.setText(indicatorTextString);
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        PopupWindow popupWindow = this.f23134e;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        PopupWindow popupWindow = this.f23134e;
        return popupWindow != null && popupWindow.isShowing();
    }
}
