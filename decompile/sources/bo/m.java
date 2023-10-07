package bo;

import cc.h;
import cc.l;
import java.util.Queue;

public class m<A, B> {

    /* renamed from: a  reason: collision with root package name */
    private final h<a<A>, B> f5895a;

    static final class a<A> {

        /* renamed from: a  reason: collision with root package name */
        private static final Queue<a<?>> f5897a = l.a(0);

        /* renamed from: b  reason: collision with root package name */
        private int f5898b;

        /* renamed from: c  reason: collision with root package name */
        private int f5899c;

        /* renamed from: d  reason: collision with root package name */
        private A f5900d;

        private a() {
        }

        static <A> a<A> a(A a2, int i2, int i3) {
            a<A> poll;
            Queue<a<?>> queue = f5897a;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new a<>();
            }
            poll.b(a2, i2, i3);
            return poll;
        }

        private void b(A a2, int i2, int i3) {
            this.f5900d = a2;
            this.f5899c = i2;
            this.f5898b = i3;
        }

        public void a() {
            Queue<a<?>> queue = f5897a;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f5899c == aVar.f5899c && this.f5898b == aVar.f5898b && this.f5900d.equals(aVar.f5900d);
        }

        public int hashCode() {
            return (((this.f5898b * 31) + this.f5899c) * 31) + this.f5900d.hashCode();
        }
    }

    public m() {
        this(250);
    }

    public m(long j2) {
        this.f5895a = new h<a<A>, B>(j2) {
            /* access modifiers changed from: protected */
            public void a(a<A> aVar, B b2) {
                aVar.a();
            }
        };
    }

    public B a(A a2, int i2, int i3) {
        a a3 = a.a(a2, i2, i3);
        B b2 = this.f5895a.b(a3);
        a3.a();
        return b2;
    }

    public void a(A a2, int i2, int i3, B b2) {
        this.f5895a.b(a.a(a2, i2, i3), b2);
    }
}
