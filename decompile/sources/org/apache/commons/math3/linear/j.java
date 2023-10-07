package org.apache.commons.math3.linear;

import fg.i;
import java.util.Iterator;
import java.util.NoSuchElementException;
import nj.c;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public abstract class j {

    protected class a {

        /* renamed from: b  reason: collision with root package name */
        private int f32722b;

        public a() {
            a(0);
        }

        public double a() {
            return j.this.a(b());
        }

        public void a(double d2) {
            j.this.a(b(), d2);
        }

        public void a(int i2) {
            this.f32722b = i2;
        }

        public int b() {
            return this.f32722b;
        }
    }

    protected class b implements Iterator<a> {

        /* renamed from: b  reason: collision with root package name */
        private final int f32724b;

        /* renamed from: c  reason: collision with root package name */
        private a f32725c;

        /* renamed from: d  reason: collision with root package name */
        private a f32726d;

        protected b() {
            this.f32724b = j.this.c();
            this.f32725c = new a();
            a aVar = new a();
            this.f32726d = aVar;
            if (aVar.a() == i.f27244a) {
                a(this.f32726d);
            }
        }

        /* renamed from: a */
        public a next() {
            int b2 = this.f32726d.b();
            if (b2 >= 0) {
                this.f32725c.a(b2);
                a(this.f32726d);
                return this.f32725c;
            }
            throw new NoSuchElementException();
        }

        /* access modifiers changed from: protected */
        public void a(a aVar) {
            if (aVar != null) {
                do {
                    aVar.a(aVar.b() + 1);
                    if (aVar.b() >= this.f32724b || aVar.a() != i.f27244a) {
                    }
                    aVar.a(aVar.b() + 1);
                    break;
                } while (aVar.a() != i.f27244a);
                if (aVar.b() >= this.f32724b) {
                    aVar.a(-1);
                }
            }
        }

        public boolean hasNext() {
            return this.f32726d.b() >= 0;
        }

        public void remove() {
            throw new MathUnsupportedOperationException();
        }
    }

    public abstract double a(int i2);

    public j a(double d2) {
        return d2 != i.f27244a ? b(nj.b.a(new nk.a(), d2)) : this;
    }

    public abstract j a(int i2, int i3);

    public abstract void a(int i2, double d2);

    public j b(c cVar) {
        a next;
        Iterator<a> e2 = cVar.a(i.f27244a) == i.f27244a ? e() : f();
        while (e2.hasNext() && (next = e2.next()) != null) {
            next.a(cVar.a(next.a()));
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void b(int i2) {
        if (i2 < 0 || i2 >= c()) {
            throw new OutOfRangeException(LocalizedFormats.INDEX, Integer.valueOf(i2), 0, Integer.valueOf(c() - 1));
        }
    }

    public abstract int c();

    public abstract boolean d();

    public Iterator<a> e() {
        return new b();
    }

    public Iterator<a> f() {
        final int c2 = c();
        return new Iterator<a>() {

            /* renamed from: c  reason: collision with root package name */
            private int f32719c = 0;

            /* renamed from: d  reason: collision with root package name */
            private a f32720d;

            {
                this.f32720d = new a();
            }

            /* renamed from: a */
            public a next() {
                a aVar = this.f32720d;
                int i2 = this.f32719c;
                this.f32719c = i2 + 1;
                aVar.a(i2);
                return this.f32720d;
            }

            public boolean hasNext() {
                return this.f32719c < c2;
            }

            public void remove() {
                throw new MathUnsupportedOperationException();
            }
        };
    }
}
