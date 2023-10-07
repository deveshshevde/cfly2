package androidx.work;

import android.content.Context;
import androidx.startup.b;
import androidx.work.a;
import java.util.Collections;
import java.util.List;

public final class WorkManagerInitializer implements b<p> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5084a = j.a("WrkMgrInitializer");

    public List<Class<? extends b<?>>> a() {
        return Collections.emptyList();
    }

    /* renamed from: b */
    public p a(Context context) {
        j.a().b(f5084a, "Initializing WorkManager with default configuration.", new Throwable[0]);
        p.a(context, new a.C0044a().a());
        return p.a(context);
    }
}
