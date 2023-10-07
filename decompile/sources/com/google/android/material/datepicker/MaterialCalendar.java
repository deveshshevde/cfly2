package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.t;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;
import s.d;
import t.ac;
import u.c;

public final class MaterialCalendar<S> extends l<S> {

    /* renamed from: a  reason: collision with root package name */
    static final Object f18884a = "MONTHS_VIEW_GROUP_TAG";

    /* renamed from: b  reason: collision with root package name */
    static final Object f18885b = "NAVIGATION_PREV_TAG";

    /* renamed from: c  reason: collision with root package name */
    static final Object f18886c = "NAVIGATION_NEXT_TAG";

    /* renamed from: d  reason: collision with root package name */
    static final Object f18887d = "SELECTOR_TOGGLE_TAG";

    /* renamed from: f  reason: collision with root package name */
    private int f18888f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public DateSelector<S> f18889g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public CalendarConstraints f18890h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public Month f18891i;

    /* renamed from: j  reason: collision with root package name */
    private CalendarSelector f18892j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public b f18893k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public RecyclerView f18894l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public RecyclerView f18895m;

    /* renamed from: n  reason: collision with root package name */
    private View f18896n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public View f18897o;

    enum CalendarSelector {
        DAY,
        YEAR
    }

    interface a {
        void a(long j2);
    }

    static int a(Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height);
    }

    public static <T> MaterialCalendar<T> a(DateSelector<T> dateSelector, int i2, CalendarConstraints calendarConstraints) {
        MaterialCalendar<T> materialCalendar = new MaterialCalendar<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i2);
        bundle.putParcelable("GRID_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        bundle.putParcelable("CURRENT_MONTH_KEY", calendarConstraints.d());
        materialCalendar.setArguments(bundle);
        return materialCalendar;
    }

    private void a(final int i2) {
        this.f18895m.post(new Runnable() {
            public void run() {
                MaterialCalendar.this.f18895m.c(i2);
            }
        });
    }

    private void a(View view, final j jVar) {
        final MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.month_navigation_fragment_toggle);
        materialButton.setTag(f18887d);
        ac.a((View) materialButton, (t.a) new t.a() {
            public void a(View view, c cVar) {
                MaterialCalendar materialCalendar;
                int i2;
                super.a(view, cVar);
                if (MaterialCalendar.this.f18897o.getVisibility() == 0) {
                    materialCalendar = MaterialCalendar.this;
                    i2 = R.string.mtrl_picker_toggle_to_year_selection;
                } else {
                    materialCalendar = MaterialCalendar.this;
                    i2 = R.string.mtrl_picker_toggle_to_day_selection;
                }
                cVar.g((CharSequence) materialCalendar.getString(i2));
            }
        });
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.month_navigation_previous);
        materialButton2.setTag(f18885b);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(R.id.month_navigation_next);
        materialButton3.setTag(f18886c);
        this.f18896n = view.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.f18897o = view.findViewById(R.id.mtrl_calendar_day_selector_frame);
        a(CalendarSelector.DAY);
        materialButton.setText(this.f18891i.a(view.getContext()));
        this.f18895m.a((RecyclerView.l) new RecyclerView.l() {
            public void a(RecyclerView recyclerView, int i2) {
                if (i2 == 0) {
                    CharSequence text = materialButton.getText();
                    if (Build.VERSION.SDK_INT >= 16) {
                        recyclerView.announceForAccessibility(text);
                    } else {
                        recyclerView.sendAccessibilityEvent(2048);
                    }
                }
            }

            public void a(RecyclerView recyclerView, int i2, int i3) {
                LinearLayoutManager f2 = MaterialCalendar.this.f();
                int o2 = i2 < 0 ? f2.o() : f2.q();
                Month unused = MaterialCalendar.this.f18891i = jVar.b(o2);
                materialButton.setText(jVar.a(o2));
            }
        });
        materialButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MaterialCalendar.this.e();
            }
        });
        materialButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int o2 = MaterialCalendar.this.f().o() + 1;
                if (o2 < MaterialCalendar.this.f18895m.getAdapter().getItemCount()) {
                    MaterialCalendar.this.a(jVar.b(o2));
                }
            }
        });
        materialButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int q2 = MaterialCalendar.this.f().q() - 1;
                if (q2 >= 0) {
                    MaterialCalendar.this.a(jVar.b(q2));
                }
            }
        });
    }

    private RecyclerView.g h() {
        return new RecyclerView.g() {

            /* renamed from: b  reason: collision with root package name */
            private final Calendar f18907b = o.c();

            /* renamed from: c  reason: collision with root package name */
            private final Calendar f18908c = o.c();

            public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
                if ((recyclerView.getAdapter() instanceof p) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                    p pVar = (p) recyclerView.getAdapter();
                    GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
                    for (d next : MaterialCalendar.this.f18889g.d()) {
                        if (!(next.f34394a == null || next.f34395b == null)) {
                            this.f18907b.setTimeInMillis(((Long) next.f34394a).longValue());
                            this.f18908c.setTimeInMillis(((Long) next.f34395b).longValue());
                            int a2 = pVar.a(this.f18907b.get(1));
                            int a3 = pVar.a(this.f18908c.get(1));
                            View c2 = gridLayoutManager.c(a2);
                            View c3 = gridLayoutManager.c(a3);
                            int b2 = a2 / gridLayoutManager.b();
                            int b3 = a3 / gridLayoutManager.b();
                            int i2 = b2;
                            while (i2 <= b3) {
                                View c4 = gridLayoutManager.c(gridLayoutManager.b() * i2);
                                if (c4 != null) {
                                    canvas.drawRect((float) (i2 == b2 ? c2.getLeft() + (c2.getWidth() / 2) : 0), (float) (c4.getTop() + MaterialCalendar.this.f18893k.f18955d.a()), (float) (i2 == b3 ? c3.getLeft() + (c3.getWidth() / 2) : recyclerView.getWidth()), (float) (c4.getBottom() - MaterialCalendar.this.f18893k.f18955d.b()), MaterialCalendar.this.f18893k.f18959h);
                                }
                                i2++;
                            }
                        }
                    }
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Month a() {
        return this.f18891i;
    }

    /* access modifiers changed from: package-private */
    public void a(CalendarSelector calendarSelector) {
        this.f18892j = calendarSelector;
        if (calendarSelector == CalendarSelector.YEAR) {
            this.f18894l.getLayoutManager().e(((p) this.f18894l.getAdapter()).a(this.f18891i.f18923b));
            this.f18896n.setVisibility(0);
            this.f18897o.setVisibility(8);
        } else if (calendarSelector == CalendarSelector.DAY) {
            this.f18896n.setVisibility(8);
            this.f18897o.setVisibility(0);
            a(this.f18891i);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Month month) {
        RecyclerView recyclerView;
        int i2;
        j jVar = (j) this.f18895m.getAdapter();
        int a2 = jVar.a(month);
        int a3 = a2 - jVar.a(this.f18891i);
        boolean z2 = true;
        boolean z3 = Math.abs(a3) > 3;
        if (a3 <= 0) {
            z2 = false;
        }
        this.f18891i = month;
        if (!z3 || !z2) {
            if (z3) {
                recyclerView = this.f18895m;
                i2 = a2 + 3;
            }
            a(a2);
        }
        recyclerView = this.f18895m;
        i2 = a2 - 3;
        recyclerView.a(i2);
        a(a2);
    }

    public boolean a(k<S> kVar) {
        return super.a(kVar);
    }

    /* access modifiers changed from: package-private */
    public CalendarConstraints b() {
        return this.f18890h;
    }

    public DateSelector<S> c() {
        return this.f18889g;
    }

    /* access modifiers changed from: package-private */
    public b d() {
        return this.f18893k;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        CalendarSelector calendarSelector;
        if (this.f18892j == CalendarSelector.YEAR) {
            calendarSelector = CalendarSelector.DAY;
        } else if (this.f18892j == CalendarSelector.DAY) {
            calendarSelector = CalendarSelector.YEAR;
        } else {
            return;
        }
        a(calendarSelector);
    }

    /* access modifiers changed from: package-private */
    public LinearLayoutManager f() {
        return (LinearLayoutManager) this.f18895m.getLayoutManager();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f18888f = bundle.getInt("THEME_RES_ID_KEY");
        this.f18889g = (DateSelector) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.f18890h = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f18891i = (Month) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final int i2;
        int i3;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f18888f);
        this.f18893k = new b(contextThemeWrapper);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        Month b2 = this.f18890h.b();
        if (f.a((Context) contextThemeWrapper)) {
            i3 = R.layout.mtrl_calendar_vertical;
            i2 = 1;
        } else {
            i3 = R.layout.mtrl_calendar_horizontal;
            i2 = 0;
        }
        View inflate = cloneInContext.inflate(i3, viewGroup, false);
        GridView gridView = (GridView) inflate.findViewById(R.id.mtrl_calendar_days_of_week);
        ac.a((View) gridView, (t.a) new t.a() {
            public void a(View view, c cVar) {
                super.a(view, cVar);
                cVar.a((Object) null);
            }
        });
        gridView.setAdapter(new e());
        gridView.setNumColumns(b2.f18924c);
        gridView.setEnabled(false);
        this.f18895m = (RecyclerView) inflate.findViewById(R.id.mtrl_calendar_months);
        this.f18895m.setLayoutManager(new m(getContext(), i2, false) {
            /* access modifiers changed from: protected */
            public void a(RecyclerView.s sVar, int[] iArr) {
                if (i2 == 0) {
                    iArr[0] = MaterialCalendar.this.f18895m.getWidth();
                    iArr[1] = MaterialCalendar.this.f18895m.getWidth();
                    return;
                }
                iArr[0] = MaterialCalendar.this.f18895m.getHeight();
                iArr[1] = MaterialCalendar.this.f18895m.getHeight();
            }
        });
        this.f18895m.setTag(f18884a);
        j jVar = new j(contextThemeWrapper, this.f18889g, this.f18890h, new a() {
            public void a(long j2) {
                if (MaterialCalendar.this.f18890h.a().a(j2)) {
                    MaterialCalendar.this.f18889g.a(j2);
                    Iterator it2 = MaterialCalendar.this.f19017e.iterator();
                    while (it2.hasNext()) {
                        ((k) it2.next()).a(MaterialCalendar.this.f18889g.a());
                    }
                    MaterialCalendar.this.f18895m.getAdapter().notifyDataSetChanged();
                    if (MaterialCalendar.this.f18894l != null) {
                        MaterialCalendar.this.f18894l.getAdapter().notifyDataSetChanged();
                    }
                }
            }
        });
        this.f18895m.setAdapter(jVar);
        int integer = contextThemeWrapper.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.f18894l = recyclerView;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.f18894l.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.f18894l.setAdapter(new p(this));
            this.f18894l.a(h());
        }
        if (inflate.findViewById(R.id.month_navigation_fragment_toggle) != null) {
            a(inflate, jVar);
        }
        if (!f.a((Context) contextThemeWrapper)) {
            new t().a(this.f18895m);
        }
        this.f18895m.a(jVar.a(this.f18891i));
        return inflate;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f18888f);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.f18889g);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f18890h);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.f18891i);
    }
}
