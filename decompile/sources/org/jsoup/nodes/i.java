package org.jsoup.nodes;

import java.util.Collections;
import java.util.List;
import org.jsoup.helper.c;

abstract class i extends j {

    /* renamed from: d  reason: collision with root package name */
    private static final List<j> f33665d = Collections.emptyList();

    /* renamed from: a  reason: collision with root package name */
    Object f33666a;

    i() {
    }

    private void b() {
        if (!o()) {
            Object obj = this.f33666a;
            b bVar = new b();
            this.f33666a = bVar;
            if (obj != null) {
                bVar.b(a(), (String) obj);
            }
        }
    }

    public String a(String str) {
        b();
        return super.a(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public i f(j jVar) {
        i iVar = (i) super.f(jVar);
        if (o()) {
            iVar.f33666a = ((b) this.f33666a).clone();
        }
        return iVar;
    }

    public j a(String str, String str2) {
        if (o() || !str.equals(a())) {
            b();
            super.a(str, str2);
        } else {
            this.f33666a = str2;
        }
        return this;
    }

    public boolean b(String str) {
        b();
        return super.b(str);
    }

    public String c(String str) {
        c.a((Object) str);
        return !o() ? str.equals(a()) ? (String) this.f33666a : "" : super.c(str);
    }

    /* access modifiers changed from: protected */
    public void d(String str) {
    }

    public j g() {
        return this;
    }

    public int h() {
        return 0;
    }

    public String i() {
        return L() ? K().i() : "";
    }

    /* access modifiers changed from: package-private */
    public String j() {
        return c(a());
    }

    /* access modifiers changed from: protected */
    public List<j> n() {
        return f33665d;
    }

    /* access modifiers changed from: protected */
    public final boolean o() {
        return this.f33666a instanceof b;
    }

    public final b p() {
        b();
        return (b) this.f33666a;
    }
}
