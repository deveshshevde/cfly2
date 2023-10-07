package rx.internal.util;

import java.io.PrintStream;
import java.util.Queue;
import ok.i;
import op.j;
import op.r;
import rx.internal.operators.b;

public class d implements i {

    /* renamed from: a  reason: collision with root package name */
    static int f34385a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f34386b = f34385a;

    /* renamed from: c  reason: collision with root package name */
    public static a<Queue<Object>> f34387c = new a<Queue<Object>>() {
        /* access modifiers changed from: protected */
        /* renamed from: c */
        public r<Object> b() {
            return new r<>(d.f34386b);
        }
    };

    /* renamed from: d  reason: collision with root package name */
    public static a<Queue<Object>> f34388d = new a<Queue<Object>>() {
        /* access modifiers changed from: protected */
        /* renamed from: c */
        public j<Object> b() {
            return new j<>(d.f34386b);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private static final b<Object> f34389e = b.a();

    /* renamed from: f  reason: collision with root package name */
    private Queue<Object> f34390f;

    /* renamed from: g  reason: collision with root package name */
    private final a<Queue<Object>> f34391g;

    static {
        f34385a = 128;
        if (b.a()) {
            f34385a = 16;
        }
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                f34385a = Integer.parseInt(property);
            } catch (Exception e2) {
                PrintStream printStream = System.err;
                printStream.println("Failed to set 'rx.buffer.size' with value " + property + " => " + e2.getMessage());
            }
        }
    }

    public synchronized void a() {
        Queue<Object> queue = this.f34390f;
        a<Queue<Object>> aVar = this.f34391g;
        if (!(aVar == null || queue == null)) {
            queue.clear();
            this.f34390f = null;
            aVar.a(queue);
        }
    }

    public boolean isUnsubscribed() {
        return this.f34390f == null;
    }

    public void unsubscribe() {
        a();
    }
}
