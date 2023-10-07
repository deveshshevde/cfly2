package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class dt extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    public static final String f8292a = "dt";

    /* renamed from: b  reason: collision with root package name */
    int f8293b = 1;

    /* renamed from: c  reason: collision with root package name */
    private Context f8294c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f8295d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f8296e = 0;

    /* renamed from: f  reason: collision with root package name */
    private List<String> f8297f;

    /* renamed from: g  reason: collision with root package name */
    private int f8298g = -1;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f8299h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public Bitmap f8300i = null;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public int f8301j = Color.parseColor("#eeffffff");
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public int f8302k = Color.parseColor("#44383838");
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public int f8303l = 4;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public int f8304m = 1;

    /* renamed from: n  reason: collision with root package name */
    private int f8305n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public int f8306o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public Runnable f8307p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public int f8308q = 50;

    /* renamed from: r  reason: collision with root package name */
    private a f8309r;

    public interface a {
        void a(int i2);
    }

    public dt(Context context) {
        super(context);
        a(context);
    }

    private static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static int a(View view) {
        b(view);
        return view.getMeasuredHeight();
    }

    private void a(int i2) {
        int i3 = this.f8296e;
        if (i3 != 0) {
            int i4 = this.f8304m;
            int i5 = (i2 / i3) + i4;
            int i6 = i2 % i3;
            int i7 = i2 / i3;
            if (i6 == 0) {
                i5 = i7 + i4;
            } else if (i6 > i3 / 2) {
                i5 = i7 + i4 + 1;
            }
            int childCount = this.f8295d.getChildCount();
            int i8 = 0;
            while (i8 < childCount) {
                TextView textView = (TextView) this.f8295d.getChildAt(i8);
                if (textView != null) {
                    textView.setTextColor(Color.parseColor(i5 == i8 ? "#0288ce" : "#bbbbbb"));
                    i8++;
                } else {
                    return;
                }
            }
        }
    }

    private void a(Context context) {
        this.f8294c = context;
        setVerticalScrollBarEnabled(false);
        try {
            if (this.f8300i == null) {
                InputStream open = df.a(context).open("map_indoor_select.png");
                this.f8300i = BitmapFactory.decodeStream(open);
                open.close();
            }
        } catch (Throwable unused) {
        }
        LinearLayout linearLayout = new LinearLayout(context);
        this.f8295d = linearLayout;
        linearLayout.setOrientation(1);
        addView(this.f8295d);
        this.f8307p = new Runnable() {
            public final void run() {
                int a2 = dt.this.f8306o - dt.this.getScrollY();
                dt dtVar = dt.this;
                if (a2 != 0) {
                    int unused = dtVar.f8306o = dtVar.getScrollY();
                    dt dtVar2 = dt.this;
                    dtVar2.postDelayed(dtVar2.f8307p, (long) dt.this.f8308q);
                } else if (dtVar.f8296e != 0) {
                    final int a3 = dt.this.f8306o % dt.this.f8296e;
                    final int a4 = dt.this.f8306o / dt.this.f8296e;
                    if (a3 == 0) {
                        dt dtVar3 = dt.this;
                        dtVar3.f8293b = a4 + dtVar3.f8304m;
                        dt.this.f();
                    } else if (a3 > dt.this.f8296e / 2) {
                        dt.this.post(new Runnable() {
                            public final void run() {
                                dt.this.smoothScrollTo(0, (dt.this.f8306o - a3) + dt.this.f8296e);
                                dt.this.f8293b = a4 + dt.this.f8304m + 1;
                                dt.this.f();
                            }
                        });
                    } else {
                        dt.this.post(new Runnable() {
                            public final void run() {
                                dt.this.smoothScrollTo(0, dt.this.f8306o - a3);
                                dt.this.f8293b = a4 + dt.this.f8304m;
                                dt.this.f();
                            }
                        });
                    }
                }
            }
        };
    }

    private TextView b(String str) {
        TextView textView = new TextView(this.f8294c);
        textView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        textView.setSingleLine(true);
        textView.setTextSize(2, 16.0f);
        textView.setText(str);
        textView.setGravity(17);
        textView.getPaint().setFakeBoldText(true);
        int a2 = a(this.f8294c, 8.0f);
        int a3 = a(this.f8294c, 6.0f);
        textView.setPadding(a2, a3, a2, a3);
        if (this.f8296e == 0) {
            this.f8296e = a((View) textView);
            this.f8295d.setLayoutParams(new FrameLayout.LayoutParams(-2, this.f8296e * this.f8305n));
            setLayoutParams(new LinearLayout.LayoutParams(-2, this.f8296e * this.f8305n));
        }
        return textView;
    }

    private static void b(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    private void c() {
        this.f8306o = getScrollY();
        postDelayed(this.f8307p, (long) this.f8308q);
    }

    private void d() {
        List<String> list = this.f8297f;
        if (list != null && list.size() != 0) {
            this.f8295d.removeAllViews();
            this.f8305n = (this.f8304m * 2) + 1;
            for (int size = this.f8297f.size() - 1; size >= 0; size--) {
                this.f8295d.addView(b(this.f8297f.get(size)));
            }
            a(0);
        }
    }

    /* access modifiers changed from: private */
    public int[] e() {
        int i2 = this.f8296e;
        int i3 = this.f8304m;
        return new int[]{i2 * i3, i2 * (i3 + 1)};
    }

    /* access modifiers changed from: private */
    public void f() {
        a aVar = this.f8309r;
        if (aVar != null) {
            try {
                aVar.a(g());
            } catch (Throwable unused) {
            }
        }
    }

    private int g() {
        List<String> list = this.f8297f;
        if (list == null || list.size() == 0) {
            return 0;
        }
        return Math.min(this.f8297f.size() - (this.f8304m * 2), Math.max(0, ((this.f8297f.size() - 1) - this.f8293b) - this.f8304m));
    }

    public final void a() {
        Bitmap bitmap = this.f8300i;
        if (bitmap != null && !bitmap.isRecycled()) {
            dl.a(this.f8300i);
            this.f8300i = null;
        }
        if (this.f8309r != null) {
            this.f8309r = null;
        }
    }

    public final void a(a aVar) {
        this.f8309r = aVar;
    }

    public final void a(String str) {
        List<String> list = this.f8297f;
        if (list != null && list.size() != 0) {
            int indexOf = this.f8297f.indexOf(str);
            int size = this.f8297f.size();
            int i2 = this.f8304m;
            final int i3 = ((size - i2) - 1) - indexOf;
            this.f8293b = i2 + i3;
            post(new Runnable() {
                public final void run() {
                    dt dtVar = dt.this;
                    dtVar.smoothScrollTo(0, i3 * dtVar.f8296e);
                }
            });
        }
    }

    public final void a(boolean z2) {
        setVisibility(z2 ? 0 : 8);
    }

    public final void a(String[] strArr) {
        if (this.f8297f == null) {
            this.f8297f = new ArrayList();
        }
        this.f8297f.clear();
        for (String add : strArr) {
            this.f8297f.add(add);
        }
        for (int i2 = 0; i2 < this.f8304m; i2++) {
            this.f8297f.add(0, "");
            this.f8297f.add("");
        }
        d();
    }

    public final boolean b() {
        return getVisibility() == 0;
    }

    public void fling(int i2) {
        super.fling(i2 / 3);
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i2, int i3, int i4, int i5) {
        super.onScrollChanged(i2, i3, i4, i5);
        a(i3);
        this.f8298g = i3 > i5 ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f8299h = i2;
        try {
            setBackgroundDrawable((Drawable) null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            c();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBackgroundColor(int i2) {
        this.f8301j = i2;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f8299h == 0) {
            try {
                WindowManager windowManager = (WindowManager) this.f8294c.getSystemService("window");
                if (windowManager != null) {
                    this.f8299h = windowManager.getDefaultDisplay().getWidth();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        super.setBackgroundDrawable(new Drawable() {
            private void a(Canvas canvas) {
                canvas.drawColor(dt.this.f8301j);
            }

            private void b(Canvas canvas) {
                Paint paint = new Paint();
                Rect rect = new Rect();
                Rect rect2 = new Rect();
                rect.left = 0;
                rect.top = 0;
                rect.right = dt.this.f8300i.getWidth() + 0;
                rect.bottom = dt.this.f8300i.getHeight() + 0;
                rect2.left = 0;
                rect2.top = dt.this.e()[0];
                rect2.right = dt.this.f8299h + 0;
                rect2.bottom = dt.this.e()[1];
                canvas.drawBitmap(dt.this.f8300i, rect, rect2, paint);
            }

            private void c(Canvas canvas) {
                Paint paint = new Paint();
                Rect clipBounds = canvas.getClipBounds();
                paint.setColor(dt.this.f8302k);
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth((float) dt.this.f8303l);
                canvas.drawRect(clipBounds, paint);
            }

            public final void draw(Canvas canvas) {
                try {
                    a(canvas);
                    b(canvas);
                    c(canvas);
                } catch (Throwable unused) {
                }
            }

            public final int getOpacity() {
                return 0;
            }

            public final void setAlpha(int i2) {
            }

            public final void setColorFilter(ColorFilter colorFilter) {
            }
        });
    }
}
