package gh;

import com.google.android.gms.common.internal.m;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class b implements ThreadFactory {

    /* renamed from: a  reason: collision with root package name */
    private final String f28505a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicInteger f28506b = new AtomicInteger();

    /* renamed from: c  reason: collision with root package name */
    private final ThreadFactory f28507c = Executors.defaultThreadFactory();

    public b(String str) {
        m.a(str, (Object) "Name must not be null");
        this.f28505a = str;
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = this.f28507c.newThread(new c(runnable, 0));
        String str = this.f28505a;
        int andIncrement = this.f28506b.getAndIncrement();
        StringBuilder sb = new StringBuilder(str.length() + 13);
        sb.append(str);
        sb.append("[");
        sb.append(andIncrement);
        sb.append("]");
        newThread.setName(sb.toString());
        return newThread;
    }
}
