package com.xeagle.android.vjoystick.IWidgets.wheelView;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.p;
import com.xeagle.R;

public class WheelView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f24723a = -16777216;

    /* renamed from: b  reason: collision with root package name */
    private int f24724b = -65536;

    /* renamed from: c  reason: collision with root package name */
    private int f24725c = -16777216;

    /* renamed from: d  reason: collision with root package name */
    private float f24726d = 36.0f;

    /* renamed from: e  reason: collision with root package name */
    private float f24727e = 40.0f;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f24728f = 3;

    /* renamed from: g  reason: collision with root package name */
    private int f24729g = 90;

    /* renamed from: h  reason: collision with root package name */
    private int f24730h = 90;

    /* renamed from: i  reason: collision with root package name */
    private int f24731i = 1;

    /* renamed from: j  reason: collision with root package name */
    private int f24732j = 2;

    /* renamed from: k  reason: collision with root package name */
    private RecyclerView f24733k;

    /* renamed from: l  reason: collision with root package name */
    private LinearLayoutManager f24734l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public b f24735m;

    /* renamed from: n  reason: collision with root package name */
    private e f24736n;

    /* renamed from: o  reason: collision with root package name */
    private c f24737o;

    /* renamed from: p  reason: collision with root package name */
    private d f24738p;

    /* renamed from: q  reason: collision with root package name */
    private c f24739q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public int f24740r = -1;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public int f24741s = -1;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public b f24742t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public a f24743u;

    public interface a {
        void a(WheelView wheelView, int i2);
    }

    public interface b {
        void a(WheelView wheelView, int i2);
    }

    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        private DataSetObserver f24746a;

        /* access modifiers changed from: protected */
        public abstract int a();

        /* access modifiers changed from: protected */
        public abstract String a(int i2);

        /* access modifiers changed from: package-private */
        public void a(DataSetObserver dataSetObserver) {
            synchronized (this) {
                this.f24746a = dataSetObserver;
            }
        }
    }

    private class d extends DataSetObserver {
        private d() {
        }

        public void onChanged() {
            WheelView.this.a();
        }

        public void onInvalidated() {
            WheelView.this.a();
        }
    }

    public WheelView(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public WheelView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    /* access modifiers changed from: private */
    public void a() {
        this.f24736n.notifyDataSetChanged();
    }

    private void a(Context context) {
        RecyclerView recyclerView = new RecyclerView(context);
        this.f24733k = recyclerView;
        recyclerView.setOverScrollMode(2);
        int i2 = 1;
        int i3 = ((this.f24728f * 2) + 1) * this.f24729g;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        this.f24734l = linearLayoutManager;
        if (this.f24731i != 1) {
            i2 = 0;
        }
        linearLayoutManager.b(i2);
        this.f24733k.setLayoutManager(this.f24734l);
        new p().a(this.f24733k);
        addView(this.f24733k, d.a(this.f24731i, i3));
        e eVar = new e(this.f24734l, this.f24731i, this.f24729g, this.f24728f);
        this.f24736n = eVar;
        a aVar = new a(eVar, this.f24732j, this.f24723a, this.f24727e, this.f24724b, this.f24726d, this.f24725c, this.f24730h);
        this.f24735m = aVar;
        this.f24733k.a((RecyclerView.g) aVar);
        this.f24733k.a((RecyclerView.l) new RecyclerView.l() {
            public void a(RecyclerView recyclerView, int i2) {
                if (WheelView.this.f24742t != null && WheelView.this.f24735m != null && WheelView.this.f24735m.f24766j != -1 && i2 == 0) {
                    WheelView wheelView = WheelView.this;
                    int unused = wheelView.f24741s = wheelView.f24735m.f24766j;
                    if (WheelView.this.f24741s != WheelView.this.f24740r) {
                        b a2 = WheelView.this.f24742t;
                        WheelView wheelView2 = WheelView.this;
                        a2.a(wheelView2, wheelView2.f24741s);
                        WheelView wheelView3 = WheelView.this;
                        int unused2 = wheelView3.f24740r = wheelView3.f24741s;
                    }
                }
            }
        });
        this.f24733k.setAdapter(this.f24736n);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WheelView);
            this.f24728f = obtainStyledAttributes.getInt(4, this.f24728f);
            this.f24723a = obtainStyledAttributes.getColor(7, this.f24723a);
            this.f24724b = obtainStyledAttributes.getColor(8, this.f24724b);
            this.f24725c = obtainStyledAttributes.getColor(1, this.f24725c);
            this.f24727e = obtainStyledAttributes.getDimension(10, this.f24727e);
            this.f24726d = obtainStyledAttributes.getDimension(9, this.f24726d);
            this.f24729g = obtainStyledAttributes.getDimensionPixelOffset(5, this.f24729g);
            this.f24730h = obtainStyledAttributes.getDimensionPixelOffset(2, this.f24730h);
            this.f24731i = obtainStyledAttributes.getInt(6, this.f24731i);
            this.f24732j = obtainStyledAttributes.getInt(3, this.f24732j);
            obtainStyledAttributes.recycle();
        }
        a(context);
    }

    public c getAdapter() {
        return this.f24737o;
    }

    public int getCurrentItem() {
        int J = this.f24734l.J();
        if (this.f24735m.f24766j >= J) {
            return 0;
        }
        int i2 = J - (this.f24728f * 2);
        return this.f24735m.f24766j >= i2 ? i2 - 1 : this.f24735m.f24766j;
    }

    public void setAdapter(c cVar) {
        c cVar2 = this.f24737o;
        if (cVar2 != null) {
            cVar2.a((DataSetObserver) null);
        }
        this.f24737o = cVar;
        if (cVar != null) {
            if (this.f24738p == null) {
                this.f24738p = new d();
            }
            this.f24737o.a((DataSetObserver) this.f24738p);
            this.f24741s = -1;
            this.f24740r = -1;
            this.f24736n.f24772d = cVar;
            this.f24736n.notifyDataSetChanged();
        }
    }

    public void setCurrentItem(int i2) {
        this.f24734l.b(i2, 0);
    }

    public void setOnItemClickListener(a aVar) {
        if (this.f24739q == null) {
            AnonymousClass2 r0 = new c(getContext()) {
                /* access modifiers changed from: package-private */
                public void a(int i2) {
                    int e2 = i2 - WheelView.this.f24728f;
                    if (WheelView.this.f24743u != null && e2 == WheelView.this.getCurrentItem()) {
                        WheelView.this.f24743u.a(WheelView.this, e2);
                    }
                }
            };
            this.f24739q = r0;
            this.f24733k.a((RecyclerView.k) r0);
        }
        this.f24743u = aVar;
    }

    public void setOnItemSelectedListener(b bVar) {
        this.f24742t = bVar;
    }
}
