package com.xeagle.android.widgets.wheelView.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.xeagle.android.widgets.wheelView.common.WheelViewException;
import java.util.HashMap;
import java.util.List;

public class WheelView<T> extends ListView {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public int f26153a = 0;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int f26154b = 3;

    /* renamed from: c  reason: collision with root package name */
    private boolean f26155c = false;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public List<T> f26156d = null;

    /* renamed from: e  reason: collision with root package name */
    private int f26157e = -1;

    /* renamed from: f  reason: collision with root package name */
    private String f26158f;

    /* renamed from: g  reason: collision with root package name */
    private int f26159g;

    /* renamed from: h  reason: collision with root package name */
    private int f26160h;

    /* renamed from: i  reason: collision with root package name */
    private int f26161i;

    /* renamed from: j  reason: collision with root package name */
    private int f26162j = 0;

    /* renamed from: k  reason: collision with root package name */
    private boolean f26163k = false;

    /* renamed from: l  reason: collision with root package name */
    private Paint f26164l;

    /* renamed from: m  reason: collision with root package name */
    private Skin f26165m = Skin.None;

    /* renamed from: n  reason: collision with root package name */
    private c f26166n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public WheelView f26167o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public HashMap<String, List<T>> f26168p;

    /* renamed from: q  reason: collision with root package name */
    private lm.b<T> f26169q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public b<T> f26170r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public a<T> f26171s;

    /* renamed from: t  reason: collision with root package name */
    private Handler f26172t = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 256) {
                if (WheelView.this.f26170r != null) {
                    WheelView.this.f26170r.a(WheelView.this.getCurrentPosition(), WheelView.this.getSelectionItem());
                }
                if (WheelView.this.f26167o == null) {
                    return;
                }
                if (!WheelView.this.f26168p.isEmpty()) {
                    WheelView.this.f26167o.a((List) WheelView.this.f26168p.get(WheelView.this.f26156d.get(WheelView.this.getCurrentPosition())));
                    return;
                }
                throw new WheelViewException("JoinList is error.");
            }
        }
    };

    /* renamed from: u  reason: collision with root package name */
    private AdapterView.OnItemClickListener f26173u = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            if (WheelView.this.f26171s != null) {
                WheelView.this.f26171s.a(WheelView.this.getCurrentPosition(), WheelView.this.getSelectionItem());
            }
        }
    };

    /* renamed from: v  reason: collision with root package name */
    private View.OnTouchListener f26174v = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }
    };

    /* renamed from: w  reason: collision with root package name */
    private AbsListView.OnScrollListener f26175w = new AbsListView.OnScrollListener() {
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            if (i3 != 0) {
                WheelView.this.a(false);
            }
        }

        public void onScrollStateChanged(AbsListView absListView, int i2) {
            View childAt;
            int i3;
            if (i2 == 0 && (childAt = WheelView.this.getChildAt(0)) != null) {
                float y2 = childAt.getY();
                if (y2 != 0.0f && WheelView.this.f26153a != 0) {
                    if (Math.abs(y2) < ((float) (WheelView.this.f26153a / 2))) {
                        i3 = WheelView.this.a(y2);
                    } else {
                        WheelView wheelView = WheelView.this;
                        i3 = wheelView.a(((float) wheelView.f26153a) + y2);
                    }
                    WheelView.this.smoothScrollBy(i3, 50);
                }
            }
        }
    };

    public enum Skin {
        Common,
        Holo,
        None
    }

    public interface a<T> {
        void a(int i2, T t2);
    }

    public interface b<T> {
        void a(int i2, T t2);
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f26189a = -1;

        /* renamed from: b  reason: collision with root package name */
        public int f26190b = -1;

        /* renamed from: c  reason: collision with root package name */
        public int f26191c = -1;

        /* renamed from: d  reason: collision with root package name */
        public int f26192d = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f26193e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f26194f = -1;

        /* renamed from: g  reason: collision with root package name */
        public int f26195g = -1;

        /* renamed from: h  reason: collision with root package name */
        public float f26196h = -1.0f;

        /* renamed from: i  reason: collision with root package name */
        public float f26197i = -1.0f;
    }

    public WheelView(Context context) {
        super(context);
        a();
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public WheelView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    /* access modifiers changed from: private */
    public int a(float f2) {
        return Math.abs(f2) <= 2.0f ? (int) f2 : Math.abs(f2) < 12.0f ? f2 > 0.0f ? 2 : -2 : (int) (f2 / 6.0f);
    }

    /* access modifiers changed from: private */
    public int a(int i2) {
        if (lo.a.a(this.f26156d)) {
            return 0;
        }
        return this.f26155c ? (i2 + ((1073741823 / this.f26156d.size()) * this.f26156d.size())) - (this.f26154b / 2) : i2;
    }

    private void a() {
        if (this.f26166n == null) {
            this.f26166n = new c();
        }
        this.f26164l = new Paint(1);
        setTag("com.wx.wheelview");
        setVerticalScrollBarEnabled(false);
        setScrollingCacheEnabled(false);
        setCacheColorHint(0);
        setFadingEdgeLength(0);
        setOverScrollMode(2);
        setDividerHeight(0);
        setOnItemClickListener(this.f26173u);
        setOnScrollListener(this.f26175w);
        setOnTouchListener(this.f26174v);
        if (Build.VERSION.SDK_INT >= 21) {
            setNestedScrollingEnabled(true);
        }
        b();
    }

    /* access modifiers changed from: private */
    public void a(int i2, int i3, int i4) {
        TextView textView;
        for (int i5 = i3 - i4; i5 <= i3 + i4; i5++) {
            View childAt = getChildAt(i5 - i2);
            if (childAt != null) {
                lm.b<T> bVar = this.f26169q;
                if ((bVar instanceof lm.a) || (bVar instanceof lm.c)) {
                    textView = (TextView) childAt.findViewWithTag(101);
                } else {
                    textView = lo.a.a(childAt);
                    if (textView == null) {
                    }
                }
                a(i5, i3, childAt, textView);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0028  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r11, int r12, android.view.View r13, android.widget.TextView r14) {
        /*
            r10 = this;
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r1 = 1098907648(0x41800000, float:16.0)
            r2 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r3 = -1
            if (r12 != r11) goto L_0x004c
            com.xeagle.android.widgets.wheelView.widget.WheelView$c r11 = r10.f26166n
            int r11 = r11.f26193e
            if (r11 == r3) goto L_0x0015
            com.xeagle.android.widgets.wheelView.widget.WheelView$c r11 = r10.f26166n
            int r2 = r11.f26193e
        L_0x0013:
            r7 = r2
            goto L_0x0022
        L_0x0015:
            com.xeagle.android.widgets.wheelView.widget.WheelView$c r11 = r10.f26166n
            int r11 = r11.f26192d
            if (r11 == r3) goto L_0x0020
            com.xeagle.android.widgets.wheelView.widget.WheelView$c r11 = r10.f26166n
            int r2 = r11.f26192d
            goto L_0x0013
        L_0x0020:
            r7 = -16777216(0xffffffffff000000, float:-1.7014118E38)
        L_0x0022:
            com.xeagle.android.widgets.wheelView.widget.WheelView$c r11 = r10.f26166n
            int r11 = r11.f26194f
            if (r11 == r3) goto L_0x002d
            com.xeagle.android.widgets.wheelView.widget.WheelView$c r11 = r10.f26166n
            int r11 = r11.f26194f
            float r1 = (float) r11
        L_0x002d:
            com.xeagle.android.widgets.wheelView.widget.WheelView$c r11 = r10.f26166n
            int r11 = r11.f26195g
            if (r11 == r3) goto L_0x003a
            com.xeagle.android.widgets.wheelView.widget.WheelView$c r11 = r10.f26166n
            int r11 = r11.f26195g
            float r11 = (float) r11
            r8 = r11
            goto L_0x0049
        L_0x003a:
            com.xeagle.android.widgets.wheelView.widget.WheelView$c r11 = r10.f26166n
            float r11 = r11.f26197i
            int r11 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r11 == 0) goto L_0x0048
            com.xeagle.android.widgets.wheelView.widget.WheelView$c r11 = r10.f26166n
            float r11 = r11.f26197i
            float r1 = r1 * r11
        L_0x0048:
            r8 = r1
        L_0x0049:
            r9 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0087
        L_0x004c:
            com.xeagle.android.widgets.wheelView.widget.WheelView$c r4 = r10.f26166n
            int r4 = r4.f26192d
            if (r4 == r3) goto L_0x0058
            com.xeagle.android.widgets.wheelView.widget.WheelView$c r2 = r10.f26166n
            int r2 = r2.f26192d
            r7 = r2
            goto L_0x005a
        L_0x0058:
            r7 = -16777216(0xffffffffff000000, float:-1.7014118E38)
        L_0x005a:
            com.xeagle.android.widgets.wheelView.widget.WheelView$c r2 = r10.f26166n
            int r2 = r2.f26194f
            if (r2 == r3) goto L_0x0067
            com.xeagle.android.widgets.wheelView.widget.WheelView$c r1 = r10.f26166n
            int r1 = r1.f26194f
            float r1 = (float) r1
            r8 = r1
            goto L_0x0069
        L_0x0067:
            r8 = 1098907648(0x41800000, float:16.0)
        L_0x0069:
            int r11 = r11 - r12
            int r11 = java.lang.Math.abs(r11)
            com.xeagle.android.widgets.wheelView.widget.WheelView$c r12 = r10.f26166n
            float r12 = r12.f26196h
            int r12 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r12 == 0) goto L_0x007c
            com.xeagle.android.widgets.wheelView.widget.WheelView$c r12 = r10.f26166n
            float r12 = r12.f26196h
            double r0 = (double) r12
            goto L_0x0081
        L_0x007c:
            r0 = 4604480258916220928(0x3fe6666660000000, double:0.699999988079071)
        L_0x0081:
            double r11 = (double) r11
            double r11 = java.lang.Math.pow(r0, r11)
            float r9 = (float) r11
        L_0x0087:
            r4 = r10
            r5 = r13
            r6 = r14
            r4.a(r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.widgets.wheelView.widget.WheelView.a(int, int, android.view.View, android.widget.TextView):void");
    }

    private void a(View view, TextView textView, int i2, float f2, float f3) {
        textView.setTextColor(i2);
        textView.setTextSize(1, f2);
        view.setAlpha(f3);
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        if (getChildAt(0) != null && this.f26153a != 0) {
            int firstVisiblePosition = getFirstVisiblePosition();
            if (!this.f26155c || firstVisiblePosition != 0) {
                int i2 = Math.abs(getChildAt(0).getY()) <= ((float) (this.f26153a / 2)) ? firstVisiblePosition : firstVisiblePosition + 1;
                int i3 = this.f26154b;
                a(firstVisiblePosition, (i3 / 2) + i2, i3 / 2);
                if (this.f26155c) {
                    i2 = (i2 + (this.f26154b / 2)) % getWheelCount();
                }
                if (i2 != this.f26157e || z2) {
                    this.f26157e = i2;
                    this.f26169q.a(i2);
                    this.f26172t.removeMessages(256);
                    this.f26172t.sendEmptyMessageDelayed(256, 300);
                }
            }
        }
    }

    private void b() {
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT >= 16) {
                    WheelView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    WheelView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
                if (WheelView.this.getChildCount() > 0 && WheelView.this.f26153a == 0) {
                    WheelView wheelView = WheelView.this;
                    int unused = wheelView.f26153a = wheelView.getChildAt(0).getHeight();
                    if (WheelView.this.f26153a != 0) {
                        WheelView.this.getLayoutParams().height = WheelView.this.f26153a * WheelView.this.f26154b;
                        WheelView wheelView2 = WheelView.this;
                        wheelView2.a(wheelView2.getFirstVisiblePosition(), WheelView.this.getCurrentPosition() + (WheelView.this.f26154b / 2), WheelView.this.f26154b / 2);
                        WheelView.this.c();
                        return;
                    }
                    throw new WheelViewException("wheel item is error.");
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void c() {
        Skin skin = this.f26165m;
        int width = getWidth();
        int i2 = this.f26153a;
        int i3 = this.f26154b;
        Drawable a2 = ln.b.a(skin, width, i2 * i3, this.f26166n, i3, i2);
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(a2);
        } else {
            setBackgroundDrawable(a2);
        }
    }

    public void a(final List<T> list) {
        if (!lo.a.a(list)) {
            postDelayed(new Runnable() {
                public void run() {
                    WheelView.this.setWheelData(list);
                    WheelView.super.setSelection(0);
                    WheelView.this.a(true);
                }
            }, 10);
            return;
        }
        throw new WheelViewException("join map data is error.");
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (!TextUtils.isEmpty(this.f26158f)) {
            Rect rect = new Rect(0, this.f26153a * (this.f26154b / 2), getWidth(), this.f26153a * ((this.f26154b / 2) + 1));
            this.f26164l.setTextSize((float) this.f26160h);
            this.f26164l.setColor(this.f26159g);
            Paint.FontMetricsInt fontMetricsInt = this.f26164l.getFontMetricsInt();
            this.f26164l.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(this.f26158f, (float) (rect.centerX() + this.f26161i), (float) ((((rect.bottom + rect.top) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2), this.f26164l);
        }
    }

    public int getCurrentPosition() {
        return this.f26157e;
    }

    public int getSelection() {
        return this.f26162j;
    }

    public T getSelectionItem() {
        int currentPosition = getCurrentPosition();
        if (currentPosition < 0) {
            currentPosition = 0;
        }
        List<T> list = this.f26156d;
        if (list == null || list.size() <= currentPosition) {
            return null;
        }
        return this.f26156d.get(currentPosition);
    }

    public Skin getSkin() {
        return this.f26165m;
    }

    public c getStyle() {
        return this.f26166n;
    }

    public int getWheelCount() {
        if (!lo.a.a(this.f26156d)) {
            return this.f26156d.size();
        }
        return 0;
    }

    @Deprecated
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter == null || !(listAdapter instanceof lm.b)) {
            throw new WheelViewException("please invoke setWheelAdapter method.");
        }
        setWheelAdapter((lm.b) listAdapter);
    }

    public void setLoop(boolean z2) {
        if (z2 != this.f26155c) {
            this.f26155c = z2;
            setSelection(0);
            lm.b<T> bVar = this.f26169q;
            if (bVar != null) {
                bVar.b(z2);
            }
        }
    }

    public void setOnWheelItemClickListener(a<T> aVar) {
        this.f26171s = aVar;
    }

    public void setOnWheelItemSelectedListener(b<T> bVar) {
        this.f26170r = bVar;
    }

    public void setSelection(final int i2) {
        this.f26162j = i2;
        setVisibility(4);
        postDelayed(new Runnable() {
            public void run() {
                WheelView wheelView = WheelView.this;
                WheelView.super.setSelection(wheelView.a(i2));
                WheelView.this.a(false);
                WheelView.this.setVisibility(0);
            }
        }, 500);
    }

    public void setSkin(Skin skin) {
        this.f26165m = skin;
    }

    public void setStyle(c cVar) {
        this.f26166n = cVar;
    }

    public void setWheelAdapter(lm.b<T> bVar) {
        super.setAdapter(bVar);
        this.f26169q = bVar;
        bVar.a(this.f26156d).b(this.f26154b).b(this.f26155c).a(this.f26163k);
    }

    public void setWheelClickable(boolean z2) {
        if (z2 != this.f26163k) {
            this.f26163k = z2;
            lm.b<T> bVar = this.f26169q;
            if (bVar != null) {
                bVar.a(z2);
            }
        }
    }

    public void setWheelData(List<T> list) {
        if (!lo.a.a(list)) {
            this.f26156d = list;
            lm.b<T> bVar = this.f26169q;
            if (bVar != null) {
                bVar.a(list);
                return;
            }
            return;
        }
        throw new WheelViewException("wheel datas are error.");
    }

    public void setWheelSize(int i2) {
        if ((i2 & 1) != 0) {
            this.f26154b = i2;
            lm.b<T> bVar = this.f26169q;
            if (bVar != null) {
                bVar.b(i2);
                return;
            }
            return;
        }
        throw new WheelViewException("wheel size must be an odd number.");
    }
}
