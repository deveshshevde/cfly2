package org.jsoup.parser;

import oh.b;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f33827a = new d(false, false);

    /* renamed from: b  reason: collision with root package name */
    public static final d f33828b = new d(true, true);

    /* renamed from: c  reason: collision with root package name */
    private final boolean f33829c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f33830d;

    public d(boolean z2, boolean z3) {
        this.f33829c = z2;
        this.f33830d = z3;
    }

    public String a(String str) {
        String trim = str.trim();
        return !this.f33829c ? b.a(trim) : trim;
    }

    /* access modifiers changed from: package-private */
    public org.jsoup.nodes.b a(org.jsoup.nodes.b bVar) {
        if (bVar != null && !this.f33830d) {
            bVar.f();
        }
        return bVar;
    }

    public boolean a() {
        return this.f33829c;
    }

    public String b(String str) {
        String trim = str.trim();
        return !this.f33830d ? b.a(trim) : trim;
    }

    public boolean b() {
        return this.f33830d;
    }
}
