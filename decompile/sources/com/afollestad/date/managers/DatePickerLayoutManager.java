package com.afollestad.date.managers;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import as.e;
import as.f;
import as.i;
import com.afollestad.date.R;
import com.afollestad.date.controllers.c;
import com.blankj.utilcode.constant.MemoryConstants;
import java.util.Calendar;
import kotlin.jvm.internal.h;
import kotlin.l;

public final class DatePickerLayoutManager {

    /* renamed from: a  reason: collision with root package name */
    public static final a f7429a = new a((f) null);

    /* renamed from: b  reason: collision with root package name */
    private final int f7430b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7431c;

    /* renamed from: d  reason: collision with root package name */
    private final Typeface f7432d;

    /* renamed from: e  reason: collision with root package name */
    private final Typeface f7433e;

    /* renamed from: f  reason: collision with root package name */
    private final int f7434f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f7435g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f7436h;

    /* renamed from: i  reason: collision with root package name */
    private ImageView f7437i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f7438j;

    /* renamed from: k  reason: collision with root package name */
    private ImageView f7439k;

    /* renamed from: l  reason: collision with root package name */
    private View f7440l;

    /* renamed from: m  reason: collision with root package name */
    private RecyclerView f7441m;

    /* renamed from: n  reason: collision with root package name */
    private RecyclerView f7442n;

    /* renamed from: o  reason: collision with root package name */
    private RecyclerView f7443o;

    /* renamed from: p  reason: collision with root package name */
    private final int f7444p;

    /* renamed from: q  reason: collision with root package name */
    private final int f7445q;

    /* renamed from: r  reason: collision with root package name */
    private final int f7446r;

    /* renamed from: s  reason: collision with root package name */
    private final int f7447s;

    /* renamed from: t  reason: collision with root package name */
    private final int f7448t;

    /* renamed from: u  reason: collision with root package name */
    private final com.afollestad.date.data.a f7449u = new com.afollestad.date.data.a();

    /* renamed from: v  reason: collision with root package name */
    private final b f7450v = new b(0, 0);

    /* renamed from: w  reason: collision with root package name */
    private final Orientation f7451w;

    /* renamed from: x  reason: collision with root package name */
    private final c f7452x;

    public enum Mode {
        CALENDAR,
        MONTH_LIST,
        YEAR_LIST
    }

    public enum Orientation {
        PORTRAIT,
        LANDSCAPE;
        

        /* renamed from: c  reason: collision with root package name */
        public static final a f7462c = null;

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(f fVar) {
                this();
            }

            public final Orientation a(Context context) {
                h.c(context, "context");
                Resources resources = context.getResources();
                h.a((Object) resources, "context.resources");
                return resources.getConfiguration().orientation == 1 ? Orientation.PORTRAIT : Orientation.LANDSCAPE;
            }
        }

        static {
            f7462c = new a((f) null);
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final DatePickerLayoutManager a(Context context, TypedArray typedArray, ViewGroup viewGroup) {
            h.c(context, "context");
            h.c(typedArray, "typedArray");
            h.c(viewGroup, "container");
            View.inflate(context, R.layout.date_picker, viewGroup);
            return new DatePickerLayoutManager(context, typedArray, viewGroup, new c(context, typedArray));
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private int f7464a;

        /* renamed from: b  reason: collision with root package name */
        private int f7465b;

        public b(int i2, int i3) {
            this.f7464a = i2;
            this.f7465b = i3;
        }

        public final int a() {
            return this.f7464a;
        }

        public final void a(int i2) {
            this.f7464a = i2;
        }

        public final int b() {
            return this.f7465b;
        }

        public final void b(int i2) {
            this.f7465b = i2;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof b) {
                    b bVar = (b) obj;
                    if (this.f7464a == bVar.f7464a) {
                        if (this.f7465b == bVar.f7465b) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f7464a * 31) + this.f7465b;
        }

        public String toString() {
            return "Size(width=" + this.f7464a + ", height=" + this.f7465b + ")";
        }
    }

    public DatePickerLayoutManager(Context context, TypedArray typedArray, ViewGroup viewGroup, c cVar) {
        h.c(context, "context");
        h.c(typedArray, "typedArray");
        h.c(viewGroup, "root");
        h.c(cVar, "vibrator");
        this.f7452x = cVar;
        this.f7430b = as.a.a(typedArray, R.styleable.DatePicker_date_picker_selection_color, new DatePickerLayoutManager$selectionColor$1(context));
        this.f7431c = as.a.a(typedArray, R.styleable.DatePicker_date_picker_header_background_color, new DatePickerLayoutManager$headerBackgroundColor$1(context));
        this.f7432d = as.a.a(typedArray, context, R.styleable.DatePicker_date_picker_normal_font, DatePickerLayoutManager$normalFont$1.f7468a);
        this.f7433e = as.a.a(typedArray, context, R.styleable.DatePicker_date_picker_medium_font, DatePickerLayoutManager$mediumFont$1.f7467a);
        this.f7434f = typedArray.getDimensionPixelSize(R.styleable.DatePicker_date_picker_calendar_horizontal_padding, 0);
        View findViewById = viewGroup.findViewById(R.id.current_year);
        h.a((Object) findViewById, "root.findViewById(R.id.current_year)");
        this.f7435g = (TextView) findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.current_date);
        h.a((Object) findViewById2, "root.findViewById(R.id.current_date)");
        this.f7436h = (TextView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.left_chevron);
        h.a((Object) findViewById3, "root.findViewById(R.id.left_chevron)");
        this.f7437i = (ImageView) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.current_month);
        h.a((Object) findViewById4, "root.findViewById(R.id.current_month)");
        this.f7438j = (TextView) findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.right_chevron);
        h.a((Object) findViewById5, "root.findViewById(R.id.right_chevron)");
        this.f7439k = (ImageView) findViewById5;
        View findViewById6 = viewGroup.findViewById(R.id.year_month_list_divider);
        h.a((Object) findViewById6, "root.findViewById(R.id.year_month_list_divider)");
        this.f7440l = findViewById6;
        View findViewById7 = viewGroup.findViewById(R.id.day_list);
        h.a((Object) findViewById7, "root.findViewById(R.id.day_list)");
        this.f7441m = (RecyclerView) findViewById7;
        View findViewById8 = viewGroup.findViewById(R.id.year_list);
        h.a((Object) findViewById8, "root.findViewById(R.id.year_list)");
        this.f7442n = (RecyclerView) findViewById8;
        View findViewById9 = viewGroup.findViewById(R.id.month_list);
        h.a((Object) findViewById9, "root.findViewById(R.id.month_list)");
        this.f7443o = (RecyclerView) findViewById9;
        this.f7444p = context.getResources().getDimensionPixelSize(R.dimen.current_month_top_margin);
        this.f7445q = context.getResources().getDimensionPixelSize(R.dimen.chevrons_top_margin);
        this.f7446r = context.getResources().getDimensionPixelSize(R.dimen.current_month_header_height);
        this.f7447s = context.getResources().getDimensionPixelSize(R.dimen.divider_height);
        this.f7448t = context.getResources().getInteger(R.integer.headers_width_factor);
        this.f7451w = Orientation.f7462c.a(context);
        b();
        c();
        d();
    }

    private final void b() {
        TextView textView = this.f7435g;
        textView.setBackground(new ColorDrawable(this.f7431c));
        textView.setTypeface(this.f7432d);
        e.a(textView, new DatePickerLayoutManager$setupHeaderViews$$inlined$apply$lambda$1(this));
        TextView textView2 = this.f7436h;
        textView2.setSelected(true);
        textView2.setBackground(new ColorDrawable(this.f7431c));
        textView2.setTypeface(this.f7433e);
        e.a(textView2, new DatePickerLayoutManager$setupHeaderViews$$inlined$apply$lambda$2(this));
    }

    private final void c() {
        this.f7437i.setBackground(as.h.f5572a.a(this.f7430b));
        TextView textView = this.f7438j;
        textView.setTypeface(this.f7433e);
        e.a(textView, new DatePickerLayoutManager$setupNavigationViews$$inlined$apply$lambda$1(this));
        this.f7439k.setBackground(as.h.f5572a.a(this.f7430b));
    }

    private final void d() {
        RecyclerView recyclerView = this.f7441m;
        recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), recyclerView.getResources().getInteger(R.integer.day_grid_span)));
        f.a(recyclerView, this.f7440l);
        int i2 = this.f7434f;
        i.a(recyclerView, i2, 0, i2, 0, 10, (Object) null);
        RecyclerView recyclerView2 = this.f7442n;
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
        recyclerView2.a((RecyclerView.g) new androidx.recyclerview.widget.h(recyclerView2.getContext(), 1));
        f.a(recyclerView2, this.f7440l);
        RecyclerView recyclerView3 = this.f7443o;
        recyclerView3.setLayoutManager(new LinearLayoutManager(recyclerView3.getContext()));
        recyclerView3.a((RecyclerView.g) new androidx.recyclerview.widget.h(recyclerView3.getContext(), 1));
        f.a(recyclerView3, this.f7440l);
    }

    public final int a() {
        return this.f7430b;
    }

    public final b a(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int i4 = size / this.f7448t;
        this.f7435g.measure(View.MeasureSpec.makeMeasureSpec(i4, MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.f7436h.measure(View.MeasureSpec.makeMeasureSpec(i4, MemoryConstants.GB), (size2 <= 0 || this.f7451w == Orientation.PORTRAIT) ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec(size2 - this.f7435g.getMeasuredHeight(), MemoryConstants.GB));
        int i5 = this.f7451w == Orientation.PORTRAIT ? size : size - i4;
        this.f7438j.measure(View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(this.f7446r, MemoryConstants.GB));
        this.f7440l.measure(View.MeasureSpec.makeMeasureSpec(i5, MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec(this.f7447s, MemoryConstants.GB));
        int measuredHeight = (this.f7451w == Orientation.PORTRAIT ? this.f7435g.getMeasuredHeight() + this.f7436h.getMeasuredHeight() + this.f7438j.getMeasuredHeight() : this.f7438j.getMeasuredHeight()) + this.f7440l.getMeasuredHeight();
        int i6 = i5 - (this.f7434f * 2);
        this.f7441m.measure(View.MeasureSpec.makeMeasureSpec(i6, MemoryConstants.GB), size2 > 0 ? View.MeasureSpec.makeMeasureSpec(size2 - measuredHeight, Integer.MIN_VALUE) : View.MeasureSpec.makeMeasureSpec(0, 0));
        int i7 = i6 / 7;
        this.f7437i.measure(View.MeasureSpec.makeMeasureSpec(i7, MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec(i7, MemoryConstants.GB));
        this.f7439k.measure(View.MeasureSpec.makeMeasureSpec(i7, MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec(i7, MemoryConstants.GB));
        this.f7442n.measure(View.MeasureSpec.makeMeasureSpec(this.f7441m.getMeasuredWidth(), MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec(this.f7441m.getMeasuredHeight(), MemoryConstants.GB));
        this.f7443o.measure(View.MeasureSpec.makeMeasureSpec(this.f7441m.getMeasuredWidth(), MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec(this.f7441m.getMeasuredHeight(), MemoryConstants.GB));
        b bVar = this.f7450v;
        bVar.a(size);
        bVar.b(measuredHeight + this.f7441m.getMeasuredHeight() + this.f7445q + this.f7444p);
        return bVar;
    }

    public final void a(int i2) {
        this.f7442n.a(i2 - 2);
    }

    public final void a(int i2, int i3, int i4) {
        i.b(this.f7435g, i3, 0, 0, 0, 14, (Object) null);
        i.b(this.f7436h, this.f7435g.getBottom(), 0, 0, 0, 14, (Object) null);
        if (this.f7451w != Orientation.PORTRAIT) {
            i2 = this.f7436h.getRight();
        }
        TextView textView = this.f7438j;
        i.b(textView, this.f7451w == Orientation.PORTRAIT ? this.f7436h.getBottom() + this.f7444p : this.f7444p, (i4 - ((i4 - i2) / 2)) - (textView.getMeasuredWidth() / 2), 0, 0, 12, (Object) null);
        i.b(this.f7440l, this.f7438j.getBottom(), i2, 0, 0, 12, (Object) null);
        i.b(this.f7441m, this.f7440l.getBottom(), i2 + this.f7434f, 0, 0, 12, (Object) null);
        int bottom = ((this.f7438j.getBottom() - (this.f7438j.getMeasuredHeight() / 2)) - (this.f7437i.getMeasuredHeight() / 2)) + this.f7445q;
        i.b(this.f7437i, bottom, this.f7441m.getLeft() + this.f7434f, 0, 0, 12, (Object) null);
        i.b(this.f7439k, bottom, (this.f7441m.getRight() - this.f7439k.getMeasuredWidth()) - this.f7434f, 0, 0, 12, (Object) null);
        this.f7442n.layout(this.f7441m.getLeft(), this.f7441m.getTop(), this.f7441m.getRight(), this.f7441m.getBottom());
        this.f7443o.layout(this.f7441m.getLeft(), this.f7441m.getTop(), this.f7441m.getRight(), this.f7441m.getBottom());
    }

    public final void a(com.afollestad.date.adapters.b bVar, com.afollestad.date.adapters.e eVar, com.afollestad.date.adapters.a aVar) {
        h.c(bVar, "monthItemAdapter");
        h.c(eVar, "yearAdapter");
        h.c(aVar, "monthAdapter");
        this.f7441m.setAdapter(bVar);
        this.f7442n.setAdapter(eVar);
        this.f7443o.setAdapter(aVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0078  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.afollestad.date.managers.DatePickerLayoutManager.Mode r5) {
        /*
            r4 = this;
            java.lang.String r0 = "mode"
            kotlin.jvm.internal.h.c(r5, r0)
            androidx.recyclerview.widget.RecyclerView r0 = r4.f7441m
            android.view.View r0 = (android.view.View) r0
            com.afollestad.date.managers.DatePickerLayoutManager$Mode r1 = com.afollestad.date.managers.DatePickerLayoutManager.Mode.CALENDAR
            r2 = 0
            r3 = 1
            if (r5 != r1) goto L_0x0011
            r1 = 1
            goto L_0x0012
        L_0x0011:
            r1 = 0
        L_0x0012:
            as.i.b(r0, r1)
            androidx.recyclerview.widget.RecyclerView r0 = r4.f7442n
            android.view.View r0 = (android.view.View) r0
            com.afollestad.date.managers.DatePickerLayoutManager$Mode r1 = com.afollestad.date.managers.DatePickerLayoutManager.Mode.YEAR_LIST
            if (r5 != r1) goto L_0x001f
            r1 = 1
            goto L_0x0020
        L_0x001f:
            r1 = 0
        L_0x0020:
            as.i.b(r0, r1)
            androidx.recyclerview.widget.RecyclerView r0 = r4.f7443o
            android.view.View r0 = (android.view.View) r0
            com.afollestad.date.managers.DatePickerLayoutManager$Mode r1 = com.afollestad.date.managers.DatePickerLayoutManager.Mode.MONTH_LIST
            if (r5 != r1) goto L_0x002d
            r1 = 1
            goto L_0x002e
        L_0x002d:
            r1 = 0
        L_0x002e:
            as.i.b(r0, r1)
            int[] r0 = com.afollestad.date.managers.a.f7472a
            int r1 = r5.ordinal()
            r0 = r0[r1]
            if (r0 == r3) goto L_0x0048
            r1 = 2
            if (r0 == r1) goto L_0x0045
            r1 = 3
            if (r0 == r1) goto L_0x0042
            goto L_0x004f
        L_0x0042:
            androidx.recyclerview.widget.RecyclerView r0 = r4.f7442n
            goto L_0x004a
        L_0x0045:
            androidx.recyclerview.widget.RecyclerView r0 = r4.f7443o
            goto L_0x004a
        L_0x0048:
            androidx.recyclerview.widget.RecyclerView r0 = r4.f7441m
        L_0x004a:
            android.view.View r1 = r4.f7440l
            as.f.b(r0, r1)
        L_0x004f:
            android.widget.TextView r0 = r4.f7435g
            com.afollestad.date.managers.DatePickerLayoutManager$Mode r1 = com.afollestad.date.managers.DatePickerLayoutManager.Mode.YEAR_LIST
            if (r5 != r1) goto L_0x0057
            r1 = 1
            goto L_0x0058
        L_0x0057:
            r1 = 0
        L_0x0058:
            r0.setSelected(r1)
            com.afollestad.date.managers.DatePickerLayoutManager$Mode r1 = com.afollestad.date.managers.DatePickerLayoutManager.Mode.YEAR_LIST
            if (r5 != r1) goto L_0x0062
            android.graphics.Typeface r1 = r4.f7433e
            goto L_0x0064
        L_0x0062:
            android.graphics.Typeface r1 = r4.f7432d
        L_0x0064:
            r0.setTypeface(r1)
            android.widget.TextView r0 = r4.f7436h
            com.afollestad.date.managers.DatePickerLayoutManager$Mode r1 = com.afollestad.date.managers.DatePickerLayoutManager.Mode.CALENDAR
            if (r5 != r1) goto L_0x006e
            r2 = 1
        L_0x006e:
            r0.setSelected(r2)
            com.afollestad.date.managers.DatePickerLayoutManager$Mode r1 = com.afollestad.date.managers.DatePickerLayoutManager.Mode.CALENDAR
            if (r5 != r1) goto L_0x0078
            android.graphics.Typeface r5 = r4.f7433e
            goto L_0x007a
        L_0x0078:
            android.graphics.Typeface r5 = r4.f7432d
        L_0x007a:
            r0.setTypeface(r5)
            com.afollestad.date.controllers.c r5 = r4.f7452x
            r5.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.afollestad.date.managers.DatePickerLayoutManager.a(com.afollestad.date.managers.DatePickerLayoutManager$Mode):void");
    }

    public final void a(Calendar calendar, Calendar calendar2) {
        h.c(calendar, "currentMonth");
        h.c(calendar2, "selectedDate");
        this.f7438j.setText(this.f7449u.a(calendar));
        this.f7435g.setText(this.f7449u.b(calendar2));
        this.f7436h.setText(this.f7449u.c(calendar2));
    }

    public final void a(mm.a<l> aVar, mm.a<l> aVar2) {
        h.c(aVar, "onGoToPrevious");
        h.c(aVar2, "onGoToNext");
        e.a(this.f7437i, new DatePickerLayoutManager$onNavigate$1(aVar));
        e.a(this.f7439k, new DatePickerLayoutManager$onNavigate$2(aVar2));
    }

    public final void a(boolean z2) {
        i.b(this.f7437i, z2);
    }

    public final void b(int i2) {
        this.f7443o.a(i2 - 2);
    }

    public final void b(boolean z2) {
        i.b(this.f7439k, z2);
    }
}
