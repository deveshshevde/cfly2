package au;

import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.l;
import mm.b;

public final class a {
    public static final void a(List<b<com.afollestad.materialdialogs.b, l>> list, com.afollestad.materialdialogs.b bVar) {
        h.c(list, "$this$invokeAll");
        h.c(bVar, "dialog");
        for (b<com.afollestad.materialdialogs.b, l> invoke : list) {
            invoke.invoke(bVar);
        }
    }
}
