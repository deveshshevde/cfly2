package org.jsoup.select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import oh.c;
import org.jsoup.nodes.Element;

abstract class b extends c {

    /* renamed from: a  reason: collision with root package name */
    final ArrayList<c> f33895a;

    /* renamed from: b  reason: collision with root package name */
    int f33896b;

    static final class a extends b {
        a(Collection<c> collection) {
            super(collection);
        }

        a(c... cVarArr) {
            this((Collection<c>) Arrays.asList(cVarArr));
        }

        public boolean a(Element element, Element element2) {
            for (int i2 = 0; i2 < this.f33896b; i2++) {
                if (!((c) this.f33895a.get(i2)).a(element, element2)) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return c.a((Collection) this.f33895a, " ");
        }
    }

    /* renamed from: org.jsoup.select.b$b  reason: collision with other inner class name */
    static final class C0246b extends b {
        C0246b() {
        }

        C0246b(Collection<c> collection) {
            if (this.f33896b > 1) {
                this.f33895a.add(new a(collection));
            } else {
                this.f33895a.addAll(collection);
            }
            b();
        }

        C0246b(c... cVarArr) {
            this((Collection<c>) Arrays.asList(cVarArr));
        }

        public boolean a(Element element, Element element2) {
            for (int i2 = 0; i2 < this.f33896b; i2++) {
                if (((c) this.f33895a.get(i2)).a(element, element2)) {
                    return true;
                }
            }
            return false;
        }

        public void b(c cVar) {
            this.f33895a.add(cVar);
            b();
        }

        public String toString() {
            return c.a((Collection) this.f33895a, ", ");
        }
    }

    b() {
        this.f33896b = 0;
        this.f33895a = new ArrayList<>();
    }

    b(Collection<c> collection) {
        this();
        this.f33895a.addAll(collection);
        b();
    }

    /* access modifiers changed from: package-private */
    public c a() {
        int i2 = this.f33896b;
        if (i2 > 0) {
            return this.f33895a.get(i2 - 1);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a(c cVar) {
        this.f33895a.set(this.f33896b - 1, cVar);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f33896b = this.f33895a.size();
    }
}
