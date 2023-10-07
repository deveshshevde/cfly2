package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.b;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.internal.d;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.common.internal.zav;

public class a extends f<f> implements gk.f {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f18326a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f18327b = true;

    /* renamed from: c  reason: collision with root package name */
    private final e f18328c;

    /* renamed from: d  reason: collision with root package name */
    private final Bundle f18329d;

    /* renamed from: e  reason: collision with root package name */
    private final Integer f18330e;

    public a(Context context, Looper looper, boolean z2, e eVar, Bundle bundle, d.b bVar, d.c cVar) {
        super(context, looper, 44, eVar, bVar, cVar);
        this.f18328c = eVar;
        this.f18329d = bundle;
        this.f18330e = eVar.g();
    }

    public static Bundle a(e eVar) {
        eVar.f();
        Integer g2 = eVar.g();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", eVar.a());
        if (g2 != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", g2.intValue());
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        bundle.putString("com.google.android.gms.signin.internal.serverClientId", (String) null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        bundle.putString("com.google.android.gms.signin.internal.hostedDomain", (String) null);
        bundle.putString("com.google.android.gms.signin.internal.logSessionId", (String) null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle;
    }

    public final void a() {
        try {
            ((f) getService()).a(((Integer) m.a(this.f18330e)).intValue());
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    public final void a(h hVar, boolean z2) {
        try {
            ((f) getService()).a(hVar, ((Integer) m.a(this.f18330e)).intValue(), z2);
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public final void a(e eVar) {
        m.a(eVar, (Object) "Expecting a valid ISignInCallbacks");
        try {
            Account b2 = this.f18328c.b();
            ((f) getService()).a(new zai(1, new zat(b2, ((Integer) m.a(this.f18330e)).intValue(), com.google.android.gms.common.internal.d.DEFAULT_ACCOUNT.equals(b2.name) ? b.a(getContext()).a() : null)), eVar);
        } catch (RemoteException e2) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                eVar.a(new zak(1, new ConnectionResult(8, (PendingIntent) null), (zav) null));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e2);
            }
        }
    }

    public final void b() {
        connect(new d.C0122d());
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof f ? (f) queryLocalInterface : new f(iBinder);
    }

    /* access modifiers changed from: protected */
    public final Bundle getGetServiceRequestExtraArgs() {
        if (!getContext().getPackageName().equals(this.f18328c.c())) {
            this.f18329d.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f18328c.c());
        }
        return this.f18329d;
    }

    public final int getMinApkVersion() {
        return com.google.android.gms.common.f.f17696b;
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.android.gms.signin.service.START";
    }

    public final boolean requiresSignIn() {
        return this.f18327b;
    }
}
