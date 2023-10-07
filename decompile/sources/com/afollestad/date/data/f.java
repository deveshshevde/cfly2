package com.afollestad.date.data;

import ar.c;
import kotlin.jvm.internal.h;

public abstract class f {

    public static final class a extends f {

        /* renamed from: a  reason: collision with root package name */
        private final DayOfWeek f7422a;

        /* renamed from: b  reason: collision with root package name */
        private final c f7423b;

        /* renamed from: c  reason: collision with root package name */
        private final int f7424c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f7425d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DayOfWeek dayOfWeek, c cVar, int i2, boolean z2) {
            super((f) null);
            h.c(dayOfWeek, "dayOfWeek");
            h.c(cVar, "month");
            this.f7422a = dayOfWeek;
            this.f7423b = cVar;
            this.f7424c = i2;
            this.f7425d = z2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(DayOfWeek dayOfWeek, c cVar, int i2, boolean z2, int i3, f fVar) {
            this(dayOfWeek, cVar, (i3 & 4) != 0 ? -1 : i2, (i3 & 8) != 0 ? false : z2);
        }

        public final DayOfWeek a() {
            return this.f7422a;
        }

        public final c b() {
            return this.f7423b;
        }

        public final int c() {
            return this.f7424c;
        }

        public final boolean d() {
            return this.f7425d;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (h.a((Object) this.f7422a, (Object) aVar.f7422a) && h.a((Object) this.f7423b, (Object) aVar.f7423b)) {
                        if (this.f7424c == aVar.f7424c) {
                            if (this.f7425d == aVar.f7425d) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            DayOfWeek dayOfWeek = this.f7422a;
            int i2 = 0;
            int hashCode = (dayOfWeek != null ? dayOfWeek.hashCode() : 0) * 31;
            c cVar = this.f7423b;
            if (cVar != null) {
                i2 = cVar.hashCode();
            }
            int i3 = (((hashCode + i2) * 31) + this.f7424c) * 31;
            boolean z2 = this.f7425d;
            if (z2) {
                z2 = true;
            }
            return i3 + (z2 ? 1 : 0);
        }

        public String toString() {
            return "DayOfMonth(dayOfWeek=" + this.f7422a + ", month=" + this.f7423b + ", date=" + this.f7424c + ", isSelected=" + this.f7425d + ")";
        }
    }

    public static final class b extends f {

        /* renamed from: a  reason: collision with root package name */
        private final DayOfWeek f7426a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(DayOfWeek dayOfWeek) {
            super((f) null);
            h.c(dayOfWeek, "dayOfWeek");
            this.f7426a = dayOfWeek;
        }

        public final DayOfWeek a() {
            return this.f7426a;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof b) && h.a((Object) this.f7426a, (Object) ((b) obj).f7426a);
            }
            return true;
        }

        public int hashCode() {
            DayOfWeek dayOfWeek = this.f7426a;
            if (dayOfWeek != null) {
                return dayOfWeek.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "WeekHeader(dayOfWeek=" + this.f7426a + ")";
        }
    }

    private f() {
    }

    public /* synthetic */ f(f fVar) {
        this();
    }
}
