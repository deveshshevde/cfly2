package ar;

import java.util.Calendar;
import java.util.Locale;
import kotlin.jvm.internal.h;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final int f5558a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5559b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5560c;

    public a(int i2, int i3, int i4) {
        this.f5558a = i2;
        this.f5559b = i3;
        this.f5560c = i4;
    }

    public final int a(a aVar) {
        h.c(aVar, "other");
        int i2 = this.f5558a;
        int i3 = aVar.f5558a;
        if (i2 == i3 && this.f5560c == aVar.f5560c && this.f5559b == aVar.f5559b) {
            return 0;
        }
        int i4 = this.f5560c;
        int i5 = aVar.f5560c;
        if (i4 < i5) {
            return -1;
        }
        if (i4 != i5 || i2 >= i3) {
            return (i4 == i5 && i2 == i3 && this.f5559b < aVar.f5559b) ? -1 : 1;
        }
        return -1;
    }

    public final Calendar a() {
        int i2 = this.f5558a;
        int i3 = this.f5559b;
        int i4 = this.f5560c;
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        h.a((Object) instance, "this");
        com.afollestad.date.a.a(instance, i4);
        com.afollestad.date.a.b(instance, i2);
        com.afollestad.date.a.c(instance, i3);
        h.a((Object) instance, "Calendar.getInstance(Loc…fMonth = newDay\n        }");
        return instance;
    }

    public final int b() {
        return this.f5558a;
    }

    public final int c() {
        return this.f5559b;
    }

    public final int d() {
        return this.f5560c;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.f5558a == aVar.f5558a) {
                    if (this.f5559b == aVar.f5559b) {
                        if (this.f5560c == aVar.f5560c) {
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
        return (((this.f5558a * 31) + this.f5559b) * 31) + this.f5560c;
    }

    public String toString() {
        return "DateSnapshot(month=" + this.f5558a + ", day=" + this.f5559b + ", year=" + this.f5560c + ")";
    }
}
