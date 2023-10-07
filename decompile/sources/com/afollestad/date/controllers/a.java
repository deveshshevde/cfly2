package com.afollestad.date.controllers;

import ar.c;
import ar.d;
import com.afollestad.date.data.e;
import com.afollestad.date.data.f;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.l;
import mm.b;
import mm.m;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private boolean f7382a;

    /* renamed from: b  reason: collision with root package name */
    private final List<m<Calendar, Calendar, l>> f7383b;

    /* renamed from: c  reason: collision with root package name */
    private c f7384c;

    /* renamed from: d  reason: collision with root package name */
    private e f7385d;

    /* renamed from: e  reason: collision with root package name */
    private ar.a f7386e;

    /* renamed from: f  reason: collision with root package name */
    private Calendar f7387f;

    /* renamed from: g  reason: collision with root package name */
    private final c f7388g;

    /* renamed from: h  reason: collision with root package name */
    private final b f7389h;

    /* renamed from: i  reason: collision with root package name */
    private final m<Calendar, Calendar, l> f7390i;

    /* renamed from: j  reason: collision with root package name */
    private final b<List<? extends f>, l> f7391j;

    /* renamed from: k  reason: collision with root package name */
    private final b<Boolean, l> f7392k;

    /* renamed from: l  reason: collision with root package name */
    private final b<Boolean, l> f7393l;

    /* renamed from: m  reason: collision with root package name */
    private final mm.a<l> f7394m;

    /* renamed from: n  reason: collision with root package name */
    private final mm.a<Calendar> f7395n;

    public a(c cVar, b bVar, m<? super Calendar, ? super Calendar, l> mVar, b<? super List<? extends f>, l> bVar2, b<? super Boolean, l> bVar3, b<? super Boolean, l> bVar4, mm.a<l> aVar, mm.a<? extends Calendar> aVar2) {
        h.c(cVar, "vibrator");
        h.c(bVar, "minMaxController");
        h.c(mVar, "renderHeaders");
        h.c(bVar2, "renderMonthItems");
        h.c(bVar3, "goBackVisibility");
        h.c(bVar4, "goForwardVisibility");
        h.c(aVar, "switchToDaysOfMonthMode");
        h.c(aVar2, "getNow");
        this.f7388g = cVar;
        this.f7389h = bVar;
        this.f7390i = mVar;
        this.f7391j = bVar2;
        this.f7392k = bVar3;
        this.f7393l = bVar4;
        this.f7394m = aVar;
        this.f7395n = aVar2;
        this.f7383b = new ArrayList();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(c cVar, b bVar, m mVar, b bVar2, b bVar3, b bVar4, mm.a aVar, mm.a aVar2, int i2, f fVar) {
        this(cVar, bVar, mVar, bVar2, bVar3, bVar4, aVar, (i2 & 128) != 0 ? DatePickerController$1.f7379a : aVar2);
    }

    public static /* synthetic */ void a(a aVar, Integer num, int i2, Integer num2, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = null;
        }
        if ((i3 & 4) != 0) {
            num2 = null;
        }
        if ((i3 & 8) != 0) {
            z2 = true;
        }
        aVar.a(num, i2, num2, z2);
    }

    public static /* synthetic */ void a(a aVar, Calendar calendar, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        aVar.a(calendar, z2);
    }

    private final void a(Calendar calendar) {
        this.f7384c = d.a(calendar);
        this.f7385d = new e(calendar);
    }

    private final void a(Calendar calendar, mm.a<? extends Calendar> aVar) {
        if (!this.f7383b.isEmpty()) {
            Calendar calendar2 = (Calendar) aVar.e_();
            ar.a a2 = ar.b.a(calendar2);
            if (!this.f7389h.a(a2) && !this.f7389h.c(a2)) {
                for (m a3 : this.f7383b) {
                    a3.a(calendar, calendar2);
                }
            }
        }
    }

    private final void b(Calendar calendar) {
        m<Calendar, Calendar, l> mVar = this.f7390i;
        Calendar calendar2 = this.f7387f;
        if (calendar2 == null) {
            h.a();
        }
        mVar.a(calendar, calendar2);
        b<List<? extends f>, l> bVar = this.f7391j;
        e eVar = this.f7385d;
        if (eVar == null) {
            h.a();
        }
        ar.a aVar = this.f7386e;
        if (aVar == null) {
            h.a();
        }
        bVar.invoke(eVar.a(aVar));
        this.f7392k.invoke(Boolean.valueOf(this.f7389h.c(calendar)));
        this.f7393l.invoke(Boolean.valueOf(this.f7389h.d(calendar)));
    }

    private final Calendar e() {
        Calendar calendar = this.f7387f;
        return calendar != null ? calendar : this.f7395n.e_();
    }

    public final void a() {
        if (!this.f7382a) {
            Calendar e_ = this.f7395n.e_();
            ar.a a2 = ar.b.a(e_);
            if (!this.f7389h.c(a2) ? !(!this.f7389h.a(a2) || (e_ = this.f7389h.a()) != null) : (e_ = this.f7389h.b()) == null) {
                h.a();
            }
            a(e_, false);
        }
    }

    public final void a(int i2) {
        this.f7394m.e_();
        c cVar = this.f7384c;
        if (cVar == null) {
            h.a();
        }
        Calendar a2 = d.a(cVar, 1);
        com.afollestad.date.a.b(a2, i2);
        a(a2);
        b(a2);
        this.f7388g.a();
    }

    public final void a(ar.a aVar) {
        this.f7386e = aVar;
        this.f7387f = aVar != null ? aVar.a() : null;
    }

    public final void a(Integer num, int i2, Integer num2, boolean z2) {
        Calendar e_ = this.f7395n.e_();
        if (num != null) {
            com.afollestad.date.a.a(e_, num.intValue());
        }
        com.afollestad.date.a.b(e_, i2);
        if (num2 != null) {
            com.afollestad.date.a.c(e_, num2.intValue());
        }
        a(e_, z2);
    }

    public final void a(Calendar calendar, boolean z2) {
        h.c(calendar, "calendar");
        Calendar e2 = e();
        this.f7382a = true;
        a(ar.b.a(calendar));
        if (z2) {
            a(e2, (mm.a<? extends Calendar>) new DatePickerController$setFullDate$1(calendar));
        }
        a(calendar);
        b(calendar);
    }

    public final void b() {
        this.f7394m.e_();
        c cVar = this.f7384c;
        if (cVar == null) {
            h.a();
        }
        Calendar f2 = com.afollestad.date.a.f(d.a(cVar, 1));
        a(f2);
        b(f2);
        this.f7388g.a();
    }

    public final void b(int i2) {
        if (!this.f7382a) {
            Calendar e_ = this.f7395n.e_();
            com.afollestad.date.a.c(e_, i2);
            a(this, e_, false, 2, (Object) null);
            return;
        }
        Calendar e2 = e();
        c cVar = this.f7384c;
        if (cVar == null) {
            h.a();
        }
        Calendar a2 = d.a(cVar, i2);
        a(ar.b.a(a2));
        this.f7388g.a();
        a(e2, (mm.a<? extends Calendar>) new DatePickerController$setDayOfMonth$2(a2));
        b(a2);
    }

    public final void c() {
        this.f7394m.e_();
        c cVar = this.f7384c;
        if (cVar == null) {
            h.a();
        }
        Calendar e2 = com.afollestad.date.a.e(d.a(cVar, 1));
        a(e2);
        b(e2);
        this.f7388g.a();
    }

    public final void c(int i2) {
        int b2;
        c cVar = this.f7384c;
        if (cVar != null) {
            b2 = cVar.a();
        } else {
            ar.a aVar = this.f7386e;
            if (aVar == null) {
                h.a();
            }
            b2 = aVar.b();
        }
        int i3 = b2;
        Integer valueOf = Integer.valueOf(i2);
        ar.a aVar2 = this.f7386e;
        a(this, valueOf, i3, aVar2 != null ? Integer.valueOf(aVar2.c()) : null, false, 8, (Object) null);
        this.f7394m.e_();
    }

    public final Calendar d() {
        if (this.f7389h.a(this.f7386e) || this.f7389h.c(this.f7386e)) {
            return null;
        }
        return this.f7387f;
    }
}
