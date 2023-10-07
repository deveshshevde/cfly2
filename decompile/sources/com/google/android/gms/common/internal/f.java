package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.common.api.internal.m;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.d;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

public abstract class f<T extends IInterface> extends d<T> implements a.f, ad {
    private static volatile Executor zaa;
    private final e zab;
    private final Set<Scope> zac;
    private final Account zad;

    protected f(Context context, Handler handler, int i2, e eVar) {
        super(context, handler, g.a(context), c.a(), i2, (d.a) null, (d.b) null);
        this.zab = (e) m.a(eVar);
        this.zad = eVar.a();
        this.zac = zaa(eVar.d());
    }

    protected f(Context context, Looper looper, int i2, e eVar) {
        this(context, looper, g.a(context), c.a(), i2, eVar, (e) null, (m) null);
    }

    @Deprecated
    protected f(Context context, Looper looper, int i2, e eVar, d.b bVar, d.c cVar) {
        this(context, looper, i2, eVar, (e) bVar, (m) cVar);
    }

    protected f(Context context, Looper looper, int i2, e eVar, e eVar2, m mVar) {
        this(context, looper, g.a(context), c.a(), i2, eVar, (e) m.a(eVar2), (m) m.a(mVar));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected f(android.content.Context r11, android.os.Looper r12, com.google.android.gms.common.internal.g r13, com.google.android.gms.common.c r14, int r15, com.google.android.gms.common.internal.e r16, com.google.android.gms.common.api.internal.e r17, com.google.android.gms.common.api.internal.m r18) {
        /*
            r10 = this;
            r9 = r10
            r0 = r17
            r1 = r18
            r2 = 0
            if (r0 != 0) goto L_0x000a
            r6 = r2
            goto L_0x0010
        L_0x000a:
            com.google.android.gms.common.internal.ab r3 = new com.google.android.gms.common.internal.ab
            r3.<init>(r0)
            r6 = r3
        L_0x0010:
            if (r1 != 0) goto L_0x0014
            r7 = r2
            goto L_0x001a
        L_0x0014:
            com.google.android.gms.common.internal.ac r0 = new com.google.android.gms.common.internal.ac
            r0.<init>(r1)
            r7 = r0
        L_0x001a:
            java.lang.String r8 = r16.h()
            r0 = r10
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = r16
            r9.zab = r0
            android.accounts.Account r1 = r16.a()
            r9.zad = r1
            java.util.Set r0 = r16.d()
            java.util.Set r0 = r10.zaa(r0)
            r9.zac = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.f.<init>(android.content.Context, android.os.Looper, com.google.android.gms.common.internal.g, com.google.android.gms.common.c, int, com.google.android.gms.common.internal.e, com.google.android.gms.common.api.internal.e, com.google.android.gms.common.api.internal.m):void");
    }

    private final Set<Scope> zaa(Set<Scope> set) {
        Set<Scope> validateScopes = validateScopes(set);
        for (Scope contains : validateScopes) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return validateScopes;
    }

    public final Account getAccount() {
        return this.zad;
    }

    /* access modifiers changed from: protected */
    public final Executor getBindServiceExecutor() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final e getClientSettings() {
        return this.zab;
    }

    public Feature[] getRequiredFeatures() {
        return new Feature[0];
    }

    /* access modifiers changed from: protected */
    public final Set<Scope> getScopes() {
        return this.zac;
    }

    public Set<Scope> getScopesForConnectionlessNonSignIn() {
        return requiresSignIn() ? this.zac : Collections.emptySet();
    }

    /* access modifiers changed from: protected */
    public Set<Scope> validateScopes(Set<Scope> set) {
        return set;
    }
}
