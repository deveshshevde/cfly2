package com.cfly.customeui.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.app.AppCompatActivity;

public class a implements PopupWindow.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    private Context f10642a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f10643b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f10644c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f10645d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10646e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f10647f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public View f10648g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public PopupWindow f10649h;

    /* renamed from: i  reason: collision with root package name */
    private int f10650i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10651j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10652k;

    /* renamed from: l  reason: collision with root package name */
    private int f10653l;

    /* renamed from: m  reason: collision with root package name */
    private PopupWindow.OnDismissListener f10654m;

    /* renamed from: n  reason: collision with root package name */
    private int f10655n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f10656o;

    /* renamed from: p  reason: collision with root package name */
    private View.OnTouchListener f10657p;

    /* renamed from: q  reason: collision with root package name */
    private Window f10658q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public boolean f10659r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public float f10660s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public boolean f10661t;

    /* renamed from: com.cfly.customeui.widget.a$a  reason: collision with other inner class name */
    public static class C0082a {

        /* renamed from: a  reason: collision with root package name */
        private a f10669a;

        public C0082a(Context context) {
            this.f10669a = new a(context);
        }

        public C0082a a(float f2) {
            float unused = this.f10669a.f10660s = f2;
            return this;
        }

        public C0082a a(int i2, int i3) {
            int unused = this.f10669a.f10643b = i2;
            int unused2 = this.f10669a.f10644c = i3;
            return this;
        }

        public C0082a a(View view) {
            View unused = this.f10669a.f10648g = view;
            int unused2 = this.f10669a.f10647f = -1;
            return this;
        }

        public C0082a a(boolean z2) {
            boolean unused = this.f10669a.f10659r = z2;
            return this;
        }

        public a a() {
            PopupWindow unused = this.f10669a.b();
            return this.f10669a;
        }

        public C0082a b(boolean z2) {
            boolean unused = this.f10669a.f10661t = z2;
            return this;
        }
    }

    private a(Context context) {
        this.f10645d = true;
        this.f10646e = true;
        this.f10647f = -1;
        this.f10650i = -1;
        this.f10651j = true;
        this.f10652k = false;
        this.f10653l = -1;
        this.f10655n = -1;
        this.f10656o = true;
        this.f10659r = false;
        this.f10660s = 0.0f;
        this.f10661t = true;
        this.f10642a = context;
    }

    private void a(PopupWindow popupWindow) {
        popupWindow.setClippingEnabled(this.f10651j);
        if (this.f10652k) {
            popupWindow.setIgnoreCheekPress();
        }
        int i2 = this.f10653l;
        if (i2 != -1) {
            popupWindow.setInputMethodMode(i2);
        }
        int i3 = this.f10655n;
        if (i3 != -1) {
            popupWindow.setSoftInputMode(i3);
        }
        PopupWindow.OnDismissListener onDismissListener = this.f10654m;
        if (onDismissListener != null) {
            popupWindow.setOnDismissListener(onDismissListener);
        }
        View.OnTouchListener onTouchListener = this.f10657p;
        if (onTouchListener != null) {
            popupWindow.setTouchInterceptor(onTouchListener);
        }
        popupWindow.setTouchable(this.f10656o);
    }

    /* access modifiers changed from: private */
    public PopupWindow b() {
        if (this.f10648g == null) {
            this.f10648g = LayoutInflater.from(this.f10642a).inflate(this.f10647f, (ViewGroup) null);
        }
        AppCompatActivity appCompatActivity = (AppCompatActivity) this.f10648g.getContext();
        if (appCompatActivity != null && this.f10659r) {
            float f2 = this.f10660s;
            if (f2 <= 0.0f || f2 >= 1.0f) {
                f2 = 0.7f;
            }
            Window window = appCompatActivity.getWindow();
            this.f10658q = window;
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = f2;
            this.f10658q.addFlags(2);
            this.f10658q.setAttributes(attributes);
        }
        this.f10649h = (this.f10643b == 0 || this.f10644c == 0) ? new PopupWindow(this.f10648g, -2, -2) : new PopupWindow(this.f10648g, this.f10643b, this.f10644c);
        int i2 = this.f10650i;
        if (i2 != -1) {
            this.f10649h.setAnimationStyle(i2);
        }
        a(this.f10649h);
        if (this.f10643b == 0 || this.f10644c == 0) {
            this.f10649h.getContentView().measure(0, 0);
            this.f10643b = this.f10649h.getContentView().getMeasuredWidth();
            this.f10644c = this.f10649h.getContentView().getMeasuredHeight();
        }
        this.f10649h.setOnDismissListener(this);
        if (!this.f10661t) {
            this.f10649h.setFocusable(true);
            this.f10649h.setOutsideTouchable(false);
            this.f10649h.setBackgroundDrawable((Drawable) null);
            this.f10649h.getContentView().setFocusable(true);
            this.f10649h.getContentView().setFocusableInTouchMode(true);
            this.f10649h.getContentView().setOnKeyListener(new View.OnKeyListener() {
                public boolean onKey(View view, int i2, KeyEvent keyEvent) {
                    if (i2 != 4) {
                        return false;
                    }
                    a.this.f10649h.dismiss();
                    return true;
                }
            });
            this.f10649h.setTouchInterceptor(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    String str;
                    int x2 = (int) motionEvent.getX();
                    int y2 = (int) motionEvent.getY();
                    if (motionEvent.getAction() == 0 && (x2 < 0 || x2 >= a.this.f10643b || y2 < 0 || y2 >= a.this.f10644c)) {
                        Log.e("CustomPopWindow", "out side ");
                        str = "width:" + a.this.f10649h.getWidth() + "height:" + a.this.f10649h.getHeight() + " x:" + x2 + " y  :" + y2;
                    } else if (motionEvent.getAction() != 4) {
                        return false;
                    } else {
                        str = "out side ...";
                    }
                    Log.e("CustomPopWindow", str);
                    return true;
                }
            });
        } else {
            this.f10649h.setFocusable(this.f10645d);
            this.f10649h.setBackgroundDrawable(new ColorDrawable(0));
            this.f10649h.setOutsideTouchable(this.f10646e);
        }
        this.f10649h.update();
        return this.f10649h;
    }

    public a a(View view, int i2, int i3, int i4) {
        if (this.f10649h != null) {
            if (view.getWindowToken() != null) {
                this.f10649h.showAtLocation(view, i2, i3, i4);
            } else {
                final View view2 = view;
                final int i5 = i2;
                final int i6 = i3;
                final int i7 = i4;
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                    public void run() {
                        if (view2.getWindowToken() != null) {
                            a.this.f10649h.showAtLocation(view2, i5, i6, i7);
                        }
                    }
                }, 200);
            }
        }
        return this;
    }

    public void a() {
        PopupWindow.OnDismissListener onDismissListener = this.f10654m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
        Window window = this.f10658q;
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.alpha = 1.0f;
            this.f10658q.setAttributes(attributes);
        }
        PopupWindow popupWindow = this.f10649h;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.f10649h.dismiss();
        }
    }

    public void onDismiss() {
        a();
    }
}
