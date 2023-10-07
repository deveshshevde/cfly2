package bm;

import cc.k;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, a> f5793a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final b f5794b = new b();

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        final Lock f5795a = new ReentrantLock();

        /* renamed from: b  reason: collision with root package name */
        int f5796b;

        a() {
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<a> f5797a = new ArrayDeque();

        b() {
        }

        /* access modifiers changed from: package-private */
        public a a() {
            a poll;
            synchronized (this.f5797a) {
                poll = this.f5797a.poll();
            }
            return poll == null ? new a() : poll;
        }

        /* access modifiers changed from: package-private */
        public void a(a aVar) {
            synchronized (this.f5797a) {
                if (this.f5797a.size() < 10) {
                    this.f5797a.offer(aVar);
                }
            }
        }
    }

    c() {
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        a aVar;
        synchronized (this) {
            aVar = this.f5793a.get(str);
            if (aVar == null) {
                aVar = this.f5794b.a();
                this.f5793a.put(str, aVar);
            }
            aVar.f5796b++;
        }
        aVar.f5795a.lock();
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) k.a(this.f5793a.get(str));
            if (aVar.f5796b >= 1) {
                aVar.f5796b--;
                if (aVar.f5796b == 0) {
                    a remove = this.f5793a.remove(str);
                    if (remove.equals(aVar)) {
                        this.f5794b.a(remove);
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f5796b);
            }
        }
        aVar.f5795a.unlock();
    }
}
