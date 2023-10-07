package androidx.work;

import android.content.Context;
import androidx.work.impl.j;
import java.util.Collections;
import java.util.List;

public abstract class p {
    protected p() {
    }

    public static p a(Context context) {
        return j.b(context);
    }

    public static void a(Context context, a aVar) {
        j.b(context, aVar);
    }

    public final l a(q qVar) {
        return a((List<? extends q>) Collections.singletonList(qVar));
    }

    public abstract l a(List<? extends q> list);
}
