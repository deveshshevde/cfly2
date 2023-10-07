package com.afollestad.date.data;

import java.util.Calendar;
import java.util.List;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import mo.c;
import ms.g;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ g[] f7416a = {j.a((MutablePropertyReference1) new MutablePropertyReference1Impl(j.b(e.class), "daysInMonth", "getDaysInMonth()I"))};
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final a f7417b = new a((f) null);

    /* renamed from: c  reason: collision with root package name */
    private final c f7418c = mo.a.f31211a.a();

    /* renamed from: d  reason: collision with root package name */
    private DayOfWeek f7419d;

    /* renamed from: e  reason: collision with root package name */
    private List<? extends DayOfWeek> f7420e;

    /* renamed from: f  reason: collision with root package name */
    private final Calendar f7421f;

    private static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public e(Calendar calendar) {
        h.c(calendar, "calendar");
        this.f7421f = calendar;
        com.afollestad.date.a.c(calendar, 1);
        a(com.afollestad.date.a.d(calendar));
        this.f7419d = com.afollestad.date.a.g(calendar);
        this.f7420e = c.a(c.a(calendar.getFirstDayOfWeek()));
    }

    public final int a() {
        return ((Number) this.f7418c.a(this, f7416a[0])).intValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: com.afollestad.date.data.DayOfWeek} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.afollestad.date.data.f> a(ar.a r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            java.lang.String r2 = "selectedDate"
            kotlin.jvm.internal.h.c(r1, r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
            java.util.Calendar r3 = r0.f7421f
            ar.c r3 = ar.d.a(r3)
            java.util.List<? extends com.afollestad.date.data.DayOfWeek> r4 = r0.f7420e
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r5 = new java.util.ArrayList
            r11 = 10
            int r6 = kotlin.collections.h.a(r4, r11)
            r5.<init>(r6)
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r4 = r4.iterator()
        L_0x002b:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0040
            java.lang.Object r6 = r4.next()
            com.afollestad.date.data.DayOfWeek r6 = (com.afollestad.date.data.DayOfWeek) r6
            com.afollestad.date.data.f$b r7 = new com.afollestad.date.data.f$b
            r7.<init>(r6)
            r5.add(r7)
            goto L_0x002b
        L_0x0040:
            java.util.List r5 = (java.util.List) r5
            java.util.Collection r5 = (java.util.Collection) r5
            r2.addAll(r5)
            java.util.List<? extends com.afollestad.date.data.DayOfWeek> r4 = r0.f7420e
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r4 = r4.iterator()
        L_0x0054:
            boolean r6 = r4.hasNext()
            r13 = 1
            if (r6 == 0) goto L_0x0070
            java.lang.Object r6 = r4.next()
            r7 = r6
            com.afollestad.date.data.DayOfWeek r7 = (com.afollestad.date.data.DayOfWeek) r7
            com.afollestad.date.data.DayOfWeek r8 = r0.f7419d
            if (r7 == r8) goto L_0x0068
            r7 = 1
            goto L_0x0069
        L_0x0068:
            r7 = 0
        L_0x0069:
            if (r7 != 0) goto L_0x006c
            goto L_0x0070
        L_0x006c:
            r5.add(r6)
            goto L_0x0054
        L_0x0070:
            java.util.List r5 = (java.util.List) r5
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r4 = new java.util.ArrayList
            int r6 = kotlin.collections.h.a(r5, r11)
            r4.<init>(r6)
            r14 = r4
            java.util.Collection r14 = (java.util.Collection) r14
            java.util.Iterator r15 = r5.iterator()
        L_0x0084:
            boolean r4 = r15.hasNext()
            if (r4 == 0) goto L_0x00a5
            java.lang.Object r4 = r15.next()
            r5 = r4
            com.afollestad.date.data.DayOfWeek r5 = (com.afollestad.date.data.DayOfWeek) r5
            com.afollestad.date.data.f$a r10 = new com.afollestad.date.data.f$a
            r7 = 0
            r8 = 0
            r9 = 12
            r16 = 0
            r4 = r10
            r6 = r3
            r12 = r10
            r10 = r16
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r14.add(r12)
            goto L_0x0084
        L_0x00a5:
            java.util.List r14 = (java.util.List) r14
            java.util.Collection r14 = (java.util.Collection) r14
            r2.addAll(r14)
            int r4 = r17.a()
            if (r13 > r4) goto L_0x00e0
            r5 = 1
        L_0x00b3:
            java.util.Calendar r6 = r0.f7421f
            com.afollestad.date.a.c(r6, r5)
            com.afollestad.date.data.f$a r6 = new com.afollestad.date.data.f$a
            java.util.Calendar r7 = r0.f7421f
            com.afollestad.date.data.DayOfWeek r7 = com.afollestad.date.a.g(r7)
            ar.a r8 = new ar.a
            java.util.Calendar r9 = r0.f7421f
            int r9 = com.afollestad.date.a.b(r9)
            java.util.Calendar r10 = r0.f7421f
            int r10 = com.afollestad.date.a.a(r10)
            r8.<init>(r9, r5, r10)
            boolean r8 = kotlin.jvm.internal.h.a((java.lang.Object) r1, (java.lang.Object) r8)
            r6.<init>(r7, r3, r5, r8)
            r2.add(r6)
            if (r5 == r4) goto L_0x00e0
            int r5 = r5 + 1
            goto L_0x00b3
        L_0x00e0:
            int r1 = r2.size()
            r12 = 49
            if (r1 >= r12) goto L_0x016c
            java.util.List<? extends com.afollestad.date.data.DayOfWeek> r1 = r0.f7420e
            java.lang.Object r1 = kotlin.collections.h.e(r1)
            com.afollestad.date.data.DayOfWeek r1 = (com.afollestad.date.data.DayOfWeek) r1
            com.afollestad.date.data.DayOfWeek r1 = com.afollestad.date.data.c.b(r1)
            java.lang.Object r4 = kotlin.collections.h.e(r2)
            if (r4 == 0) goto L_0x0164
            com.afollestad.date.data.f$a r4 = (com.afollestad.date.data.f.a) r4
            com.afollestad.date.data.DayOfWeek r4 = r4.a()
            com.afollestad.date.data.DayOfWeek r4 = com.afollestad.date.data.c.b(r4)
            java.util.List r4 = com.afollestad.date.data.c.a((com.afollestad.date.data.DayOfWeek) r4)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r4 = r4.iterator()
        L_0x0113:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x012c
            java.lang.Object r6 = r4.next()
            r7 = r6
            com.afollestad.date.data.DayOfWeek r7 = (com.afollestad.date.data.DayOfWeek) r7
            if (r7 == r1) goto L_0x0124
            r7 = 1
            goto L_0x0125
        L_0x0124:
            r7 = 0
        L_0x0125:
            if (r7 != 0) goto L_0x0128
            goto L_0x012c
        L_0x0128:
            r5.add(r6)
            goto L_0x0113
        L_0x012c:
            java.util.List r5 = (java.util.List) r5
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.ArrayList r1 = new java.util.ArrayList
            int r4 = kotlin.collections.h.a(r5, r11)
            r1.<init>(r4)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r14 = r5.iterator()
        L_0x013f:
            boolean r4 = r14.hasNext()
            if (r4 == 0) goto L_0x015c
            java.lang.Object r4 = r14.next()
            r5 = r4
            com.afollestad.date.data.DayOfWeek r5 = (com.afollestad.date.data.DayOfWeek) r5
            com.afollestad.date.data.f$a r15 = new com.afollestad.date.data.f$a
            r7 = 0
            r8 = 0
            r9 = 12
            r10 = 0
            r4 = r15
            r6 = r3
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r1.add(r15)
            goto L_0x013f
        L_0x015c:
            java.util.List r1 = (java.util.List) r1
            java.util.Collection r1 = (java.util.Collection) r1
            r2.addAll(r1)
            goto L_0x016c
        L_0x0164:
            kotlin.TypeCastException r1 = new kotlin.TypeCastException
            java.lang.String r2 = "null cannot be cast to non-null type com.afollestad.date.data.MonthItem.DayOfMonth"
            r1.<init>(r2)
            throw r1
        L_0x016c:
            int r1 = r2.size()
            if (r1 >= r12) goto L_0x01ab
            java.util.List<? extends com.afollestad.date.data.DayOfWeek> r1 = r0.f7420e
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r4 = new java.util.ArrayList
            int r5 = kotlin.collections.h.a(r1, r11)
            r4.<init>(r5)
            r14 = r4
            java.util.Collection r14 = (java.util.Collection) r14
            java.util.Iterator r1 = r1.iterator()
        L_0x0186:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x01a3
            java.lang.Object r4 = r1.next()
            r5 = r4
            com.afollestad.date.data.DayOfWeek r5 = (com.afollestad.date.data.DayOfWeek) r5
            com.afollestad.date.data.f$a r15 = new com.afollestad.date.data.f$a
            r7 = -1
            r8 = 0
            r9 = 8
            r10 = 0
            r4 = r15
            r6 = r3
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r14.add(r15)
            goto L_0x0186
        L_0x01a3:
            java.util.List r14 = (java.util.List) r14
            java.util.Collection r14 = (java.util.Collection) r14
            r2.addAll(r14)
            goto L_0x016c
        L_0x01ab:
            int r1 = r2.size()
            if (r1 != r12) goto L_0x01b3
            r12 = 1
            goto L_0x01b4
        L_0x01b3:
            r12 = 0
        L_0x01b4:
            if (r12 == 0) goto L_0x01b7
            return r2
        L_0x01b7:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            int r2 = r2.size()
            r1.append(r2)
            java.lang.String r2 = " must equal 49"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.String r1 = r1.toString()
            r2.<init>(r1)
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            goto L_0x01d9
        L_0x01d8:
            throw r2
        L_0x01d9:
            goto L_0x01d8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.afollestad.date.data.e.a(ar.a):java.util.List");
    }

    public final void a(int i2) {
        this.f7418c.a(this, f7416a[0], Integer.valueOf(i2));
    }
}
