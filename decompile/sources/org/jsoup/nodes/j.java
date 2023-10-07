package org.jsoup.nodes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import oh.c;
import org.jsoup.SerializationException;
import org.jsoup.nodes.Document;
import org.jsoup.select.d;
import org.jsoup.select.e;

public abstract class j implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    j f33667b;

    /* renamed from: c  reason: collision with root package name */
    int f33668c;

    private static class a implements e {

        /* renamed from: a  reason: collision with root package name */
        private Appendable f33669a;

        /* renamed from: b  reason: collision with root package name */
        private Document.OutputSettings f33670b;

        a(Appendable appendable, Document.OutputSettings outputSettings) {
            this.f33669a = appendable;
            this.f33670b = outputSettings;
            outputSettings.c();
        }

        public void a(j jVar, int i2) {
            try {
                jVar.a(this.f33669a, i2, this.f33670b);
            } catch (IOException e2) {
                throw new SerializationException(e2);
            }
        }

        public void b(j jVar, int i2) {
            if (!jVar.a().equals("#text")) {
                try {
                    jVar.b(this.f33669a, i2, this.f33670b);
                } catch (IOException e2) {
                    throw new SerializationException(e2);
                }
            }
        }
    }

    protected j() {
    }

    private void a(int i2) {
        List<j> n2 = n();
        while (i2 < n2.size()) {
            n2.get(i2).c(i2);
            i2++;
        }
    }

    public String E_() {
        StringBuilder a2 = c.a();
        b((Appendable) a2);
        return c.a(a2);
    }

    public j J() {
        j jVar = this;
        while (true) {
            j jVar2 = jVar.f33667b;
            if (jVar2 == null) {
                return jVar;
            }
            jVar = jVar2;
        }
    }

    public j K() {
        return this.f33667b;
    }

    public boolean L() {
        return this.f33667b != null;
    }

    public List<j> M() {
        return Collections.unmodifiableList(n());
    }

    public final j N() {
        return this.f33667b;
    }

    public Document O() {
        j J = J();
        if (J instanceof Document) {
            return (Document) J;
        }
        return null;
    }

    public void P() {
        org.jsoup.helper.c.a((Object) this.f33667b);
        this.f33667b.h(this);
    }

    public List<j> Q() {
        j jVar = this.f33667b;
        if (jVar == null) {
            return Collections.emptyList();
        }
        List<j> n2 = jVar.n();
        ArrayList arrayList = new ArrayList(n2.size() - 1);
        for (j next : n2) {
            if (next != this) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public j R() {
        j jVar = this.f33667b;
        if (jVar == null) {
            return null;
        }
        List<j> n2 = jVar.n();
        int i2 = this.f33668c + 1;
        if (n2.size() > i2) {
            return n2.get(i2);
        }
        return null;
    }

    public j S() {
        j jVar = this.f33667b;
        if (jVar != null && this.f33668c > 0) {
            return jVar.n().get(this.f33668c - 1);
        }
        return null;
    }

    public int T() {
        return this.f33668c;
    }

    public <T extends Appendable> T a(T t2) {
        b((Appendable) t2);
        return t2;
    }

    public abstract String a();

    public String a(String str) {
        org.jsoup.helper.c.a(str);
        return !b(str) ? "" : c.a(i(), c(str));
    }

    public j a(String str, String str2) {
        p().c(k.b(this).b().b(str), str2);
        return this;
    }

    /* access modifiers changed from: protected */
    public void a(int i2, j... jVarArr) {
        org.jsoup.helper.c.a((Object) jVarArr);
        if (jVarArr.length != 0) {
            List<j> n2 = n();
            j K = jVarArr[0].K();
            if (K == null || K.h() != jVarArr.length) {
                org.jsoup.helper.c.a((Object[]) jVarArr);
                for (j k2 : jVarArr) {
                    k(k2);
                }
                n2.addAll(i2, Arrays.asList(jVarArr));
                a(i2);
                return;
            }
            List<j> M = K.M();
            int length = jVarArr.length;
            while (true) {
                int i3 = length - 1;
                if (length <= 0 || jVarArr[i3] != M.get(i3)) {
                    K.g();
                    n2.addAll(i2, Arrays.asList(jVarArr));
                    int length2 = jVarArr.length;
                } else {
                    length = i3;
                }
            }
            K.g();
            n2.addAll(i2, Arrays.asList(jVarArr));
            int length22 = jVarArr.length;
            while (true) {
                int i4 = length22 - 1;
                if (length22 > 0) {
                    jVarArr[i4].f33667b = this;
                    length22 = i4;
                } else {
                    a(i2);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public abstract void a(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException;

    /* access modifiers changed from: protected */
    public void a(j jVar, j jVar2) {
        org.jsoup.helper.c.a(jVar.f33667b == this);
        org.jsoup.helper.c.a((Object) jVar2);
        j jVar3 = jVar2.f33667b;
        if (jVar3 != null) {
            jVar3.h(jVar2);
        }
        int i2 = jVar.f33668c;
        n().set(i2, jVar2);
        jVar2.f33667b = this;
        jVar2.c(i2);
        jVar.f33667b = null;
    }

    public j b(int i2) {
        return n().get(i2);
    }

    /* access modifiers changed from: protected */
    public void b(Appendable appendable) {
        d.a((e) new a(appendable, k.a(this)), this);
    }

    /* access modifiers changed from: package-private */
    public abstract void b(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException;

    public boolean b(String str) {
        org.jsoup.helper.c.a((Object) str);
        if (str.startsWith("abs:")) {
            String substring = str.substring(4);
            if (p().f(substring) && !a(substring).equals("")) {
                return true;
            }
        }
        return p().f(str);
    }

    public String c(String str) {
        org.jsoup.helper.c.a((Object) str);
        if (!o()) {
            return "";
        }
        String d2 = p().d(str);
        return d2.length() > 0 ? d2 : str.startsWith("abs:") ? a(str.substring(4)) : "";
    }

    /* access modifiers changed from: protected */
    public void c(int i2) {
        this.f33668c = i2;
    }

    /* access modifiers changed from: protected */
    public void c(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        appendable.append(10).append(c.a(i2 * outputSettings.h()));
    }

    /* renamed from: d */
    public j clone() {
        j f2 = f((j) null);
        LinkedList linkedList = new LinkedList();
        linkedList.add(f2);
        while (!linkedList.isEmpty()) {
            j jVar = (j) linkedList.remove();
            int h2 = jVar.h();
            for (int i2 = 0; i2 < h2; i2++) {
                List<j> n2 = jVar.n();
                j f3 = n2.get(i2).f(jVar);
                n2.set(i2, f3);
                linkedList.add(f3);
            }
        }
        return f2;
    }

    /* access modifiers changed from: protected */
    public abstract void d(String str);

    public boolean equals(Object obj) {
        return this == obj;
    }

    /* access modifiers changed from: protected */
    public j f(j jVar) {
        try {
            j jVar2 = (j) super.clone();
            jVar2.f33667b = jVar;
            jVar2.f33668c = jVar == null ? 0 : this.f33668c;
            return jVar2;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public abstract j g();

    public j g(j jVar) {
        org.jsoup.helper.c.a((Object) jVar);
        org.jsoup.helper.c.a((Object) this.f33667b);
        this.f33667b.a(this.f33668c, jVar);
        return this;
    }

    public abstract int h();

    /* access modifiers changed from: protected */
    public void h(j jVar) {
        org.jsoup.helper.c.a(jVar.f33667b == this);
        int i2 = jVar.f33668c;
        n().remove(i2);
        a(i2);
        jVar.f33667b = null;
    }

    public abstract String i();

    public void i(String str) {
        org.jsoup.helper.c.a((Object) str);
        d(str);
    }

    public void i(j jVar) {
        org.jsoup.helper.c.a((Object) jVar);
        org.jsoup.helper.c.a((Object) this.f33667b);
        this.f33667b.a(this, jVar);
    }

    /* access modifiers changed from: protected */
    public void j(j jVar) {
        org.jsoup.helper.c.a((Object) jVar);
        j jVar2 = this.f33667b;
        if (jVar2 != null) {
            jVar2.h(this);
        }
        this.f33667b = jVar;
    }

    /* access modifiers changed from: protected */
    public void k(j jVar) {
        jVar.j(this);
    }

    /* access modifiers changed from: protected */
    public abstract List<j> n();

    /* access modifiers changed from: protected */
    public abstract boolean o();

    public abstract b p();

    public String toString() {
        return E_();
    }

    /* access modifiers changed from: package-private */
    public void x() {
    }
}
