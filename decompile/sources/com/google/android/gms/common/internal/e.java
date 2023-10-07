package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.d;
import j.b;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final Account f17827a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Scope> f17828b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Scope> f17829c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<com.google.android.gms.common.api.a<?>, v> f17830d;

    /* renamed from: e  reason: collision with root package name */
    private final int f17831e;

    /* renamed from: f  reason: collision with root package name */
    private final View f17832f;

    /* renamed from: g  reason: collision with root package name */
    private final String f17833g;

    /* renamed from: h  reason: collision with root package name */
    private final String f17834h;

    /* renamed from: i  reason: collision with root package name */
    private final gk.a f17835i;

    /* renamed from: j  reason: collision with root package name */
    private Integer f17836j;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private Account f17837a;

        /* renamed from: b  reason: collision with root package name */
        private b<Scope> f17838b;

        /* renamed from: c  reason: collision with root package name */
        private String f17839c;

        /* renamed from: d  reason: collision with root package name */
        private String f17840d;

        /* renamed from: e  reason: collision with root package name */
        private gk.a f17841e = gk.a.f28517a;

        public final a a(Account account) {
            this.f17837a = account;
            return this;
        }

        public a a(String str) {
            this.f17839c = str;
            return this;
        }

        public final a a(Collection<Scope> collection) {
            if (this.f17838b == null) {
                this.f17838b = new b<>();
            }
            this.f17838b.addAll(collection);
            return this;
        }

        public e a() {
            return new e(this.f17837a, this.f17838b, (Map<com.google.android.gms.common.api.a<?>, v>) null, 0, (View) null, this.f17839c, this.f17840d, this.f17841e, false);
        }

        public final a b(String str) {
            this.f17840d = str;
            return this;
        }
    }

    public e(Account account, Set<Scope> set, Map<com.google.android.gms.common.api.a<?>, v> map, int i2, View view, String str, String str2, gk.a aVar, boolean z2) {
        this.f17827a = account;
        Set<Scope> emptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f17828b = emptySet;
        map = map == null ? Collections.emptyMap() : map;
        this.f17830d = map;
        this.f17832f = view;
        this.f17831e = i2;
        this.f17833g = str;
        this.f17834h = str2;
        this.f17835i = aVar == null ? gk.a.f28517a : aVar;
        HashSet hashSet = new HashSet(emptySet);
        for (v vVar : map.values()) {
            hashSet.addAll(vVar.f17855a);
        }
        this.f17829c = Collections.unmodifiableSet(hashSet);
    }

    public static e a(Context context) {
        return new d.a(context).b();
    }

    public Account a() {
        return this.f17827a;
    }

    public final void a(Integer num) {
        this.f17836j = num;
    }

    public Account b() {
        Account account = this.f17827a;
        return account != null ? account : new Account(d.DEFAULT_ACCOUNT, "com.google");
    }

    public String c() {
        return this.f17833g;
    }

    public Set<Scope> d() {
        return this.f17829c;
    }

    public Set<Scope> e() {
        return this.f17828b;
    }

    public final gk.a f() {
        return this.f17835i;
    }

    public final Integer g() {
        return this.f17836j;
    }

    public final String h() {
        return this.f17834h;
    }

    public final Map<com.google.android.gms.common.api.a<?>, v> i() {
        return this.f17830d;
    }
}
