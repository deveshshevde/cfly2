package com.afollestad.date;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.afollestad.date.adapters.e;
import com.afollestad.date.controllers.b;
import com.afollestad.date.controllers.c;
import com.afollestad.date.data.f;
import com.afollestad.date.managers.DatePickerLayoutManager;
import com.afollestad.date.view.DatePickerSavedState;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.TypeCastException;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import kotlin.l;
import mm.m;

public final class DatePicker extends ViewGroup {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final a f7341a = new a((f) null);

    /* renamed from: b  reason: collision with root package name */
    private final com.afollestad.date.controllers.a f7342b;

    /* renamed from: c  reason: collision with root package name */
    private final b f7343c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final DatePickerLayoutManager f7344d;

    /* renamed from: e  reason: collision with root package name */
    private final com.afollestad.date.adapters.b f7345e;

    /* renamed from: f  reason: collision with root package name */
    private final e f7346f;

    /* renamed from: g  reason: collision with root package name */
    private final com.afollestad.date.adapters.a f7347g;

    /* renamed from: h  reason: collision with root package name */
    private final com.afollestad.date.renderers.a f7348h;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Context context2 = context;
        h.c(context2, "context");
        b bVar = new b();
        this.f7343c = bVar;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.DatePicker);
        try {
            DatePickerLayoutManager.a aVar = DatePickerLayoutManager.f7429a;
            h.a((Object) obtainStyledAttributes, "ta");
            DatePickerLayoutManager a2 = aVar.a(context2, obtainStyledAttributes, this);
            this.f7344d = a2;
            DatePickerLayoutManager datePickerLayoutManager = a2;
            com.afollestad.date.controllers.a aVar2 = r3;
            com.afollestad.date.controllers.a aVar3 = new com.afollestad.date.controllers.a(new c(context2, obtainStyledAttributes), bVar, new m<Calendar, Calendar, l>(a2) {
                public /* bridge */ /* synthetic */ Object a(Object obj, Object obj2) {
                    a((Calendar) obj, (Calendar) obj2);
                    return l.f30254a;
                }

                public final ms.c a() {
                    return j.b(DatePickerLayoutManager.class);
                }

                public final void a(Calendar calendar, Calendar calendar2) {
                    h.c(calendar, "p1");
                    h.c(calendar2, "p2");
                    ((DatePickerLayoutManager) this.f30227a).a(calendar, calendar2);
                }

                public final String b() {
                    return "setHeadersContent";
                }

                public final String c() {
                    return "setHeadersContent(Ljava/util/Calendar;Ljava/util/Calendar;)V";
                }
            }, new mm.b<List<? extends f>, l>(this) {
                public final ms.c a() {
                    return j.b(DatePicker.class);
                }

                public final void a(List<? extends f> list) {
                    h.c(list, "p1");
                    ((DatePicker) this.f30227a).a(list);
                }

                public final String b() {
                    return "renderMonthItems";
                }

                public final String c() {
                    return "renderMonthItems(Ljava/util/List;)V";
                }

                public /* synthetic */ Object invoke(Object obj) {
                    a((List) obj);
                    return l.f30254a;
                }
            }, new mm.b<Boolean, l>(a2) {
                public final ms.c a() {
                    return j.b(DatePickerLayoutManager.class);
                }

                public final void a(boolean z2) {
                    ((DatePickerLayoutManager) this.f30227a).a(z2);
                }

                public final String b() {
                    return "showOrHideGoPrevious";
                }

                public final String c() {
                    return "showOrHideGoPrevious(Z)V";
                }

                public /* synthetic */ Object invoke(Object obj) {
                    a(((Boolean) obj).booleanValue());
                    return l.f30254a;
                }
            }, new mm.b<Boolean, l>(a2) {
                public final ms.c a() {
                    return j.b(DatePickerLayoutManager.class);
                }

                public final void a(boolean z2) {
                    ((DatePickerLayoutManager) this.f30227a).b(z2);
                }

                public final String b() {
                    return "showOrHideGoNext";
                }

                public final String c() {
                    return "showOrHideGoNext(Z)V";
                }

                public /* synthetic */ Object invoke(Object obj) {
                    a(((Boolean) obj).booleanValue());
                    return l.f30254a;
                }
            }, new mm.a<l>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ DatePicker f7350a;

                {
                    this.f7350a = r1;
                }

                public final void b() {
                    this.f7350a.f7344d.a(DatePickerLayoutManager.Mode.CALENDAR);
                }

                public /* synthetic */ Object e_() {
                    b();
                    return l.f30254a;
                }
            }, (mm.a) null, 128, (f) null);
            this.f7342b = aVar2;
            Typeface a3 = as.a.a(obtainStyledAttributes, context2, R.styleable.DatePicker_date_picker_medium_font, AnonymousClass6.f7351a);
            Typeface a4 = as.a.a(obtainStyledAttributes, context2, R.styleable.DatePicker_date_picker_normal_font, AnonymousClass7.f7352a);
            com.afollestad.date.renderers.a aVar4 = new com.afollestad.date.renderers.a(context2, obtainStyledAttributes, a4, bVar);
            this.f7348h = aVar4;
            obtainStyledAttributes.recycle();
            com.afollestad.date.adapters.b bVar2 = new com.afollestad.date.adapters.b(aVar4, new mm.b<f.a, l>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ DatePicker f7353a;

                {
                    this.f7353a = r1;
                }

                public final void a(f.a aVar) {
                    h.c(aVar, "it");
                    this.f7353a.getController$com_afollestad_date_picker().b(aVar.c());
                }

                public /* synthetic */ Object invoke(Object obj) {
                    a((f.a) obj);
                    return l.f30254a;
                }
            });
            this.f7345e = bVar2;
            e eVar = new e(a4, a3, datePickerLayoutManager.a(), new mm.b<Integer, l>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ DatePicker f7354a;

                {
                    this.f7354a = r1;
                }

                public final void a(int i2) {
                    this.f7354a.getController$com_afollestad_date_picker().c(i2);
                }

                public /* synthetic */ Object invoke(Object obj) {
                    a(((Number) obj).intValue());
                    return l.f30254a;
                }
            });
            this.f7346f = eVar;
            com.afollestad.date.adapters.a aVar5 = new com.afollestad.date.adapters.a(datePickerLayoutManager.a(), a4, a3, new com.afollestad.date.data.a(), new mm.b<Integer, l>(this) {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ DatePicker f7349a;

                {
                    this.f7349a = r1;
                }

                public final void a(int i2) {
                    this.f7349a.getController$com_afollestad_date_picker().a(i2);
                }

                public /* synthetic */ Object invoke(Object obj) {
                    a(((Number) obj).intValue());
                    return l.f30254a;
                }
            });
            this.f7347g = aVar5;
            datePickerLayoutManager.a(bVar2, eVar, aVar5);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* access modifiers changed from: private */
    public final void a(List<? extends f> list) {
        for (Object next : list) {
            if (((f) next) instanceof f.a) {
                if (next != null) {
                    f.a aVar = (f.a) next;
                    this.f7346f.a(Integer.valueOf(aVar.b().b()));
                    Integer a2 = this.f7346f.a();
                    if (a2 != null) {
                        this.f7344d.a(a2.intValue());
                    }
                    this.f7347g.a(Integer.valueOf(aVar.b().a()));
                    Integer a3 = this.f7347g.a();
                    if (a3 != null) {
                        this.f7344d.b(a3.intValue());
                    }
                    this.f7345e.a(list);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.afollestad.date.data.MonthItem.DayOfMonth");
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final com.afollestad.date.controllers.a getController$com_afollestad_date_picker() {
        return this.f7342b;
    }

    public final Calendar getDate() {
        return this.f7342b.d();
    }

    public final Calendar getMaxDate() {
        return this.f7343c.b();
    }

    public final Calendar getMinDate() {
        return this.f7343c.a();
    }

    public final b getMinMaxController$com_afollestad_date_picker() {
        return this.f7343c;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f7342b.a();
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f7344d.a((mm.a<l>) new DatePicker$onFinishInflate$1(this.f7342b), (mm.a<l>) new DatePicker$onFinishInflate$2(this.f7342b));
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        this.f7344d.a(i2, i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        DatePickerLayoutManager.b a2 = this.f7344d.a(i2, i3);
        setMeasuredDimension(a2.a(), a2.b());
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof DatePickerSavedState) {
            DatePickerSavedState datePickerSavedState = (DatePickerSavedState) parcelable;
            super.onRestoreInstanceState(datePickerSavedState.getSuperState());
            Calendar a2 = datePickerSavedState.a();
            if (a2 != null) {
                this.f7342b.a(a2, false);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        return new DatePickerSavedState(getDate(), super.onSaveInstanceState());
    }

    public final void setMaxDate(Calendar calendar) {
        h.c(calendar, "calendar");
        this.f7343c.b(calendar);
    }

    public final void setMinDate(Calendar calendar) {
        h.c(calendar, "calendar");
        this.f7343c.a(calendar);
    }
}
