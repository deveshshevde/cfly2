package ar;

import com.afollestad.date.a;
import java.util.Calendar;
import java.util.Locale;
import kotlin.jvm.internal.h;

public final class d {
    public static final c a(Calendar calendar) {
        h.c(calendar, "$this$snapshotMonth");
        return new c(a.b(calendar), a.a(calendar));
    }

    public static final Calendar a(c cVar, int i2) {
        h.c(cVar, "$this$asCalendar");
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        h.a((Object) instance, "this");
        a.a(instance, cVar.b());
        a.b(instance, cVar.a());
        a.c(instance, i2);
        h.a((Object) instance, "Calendar.getInstance(Loc….dayOfMonth = day\n      }");
        return instance;
    }
}
