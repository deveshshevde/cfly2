package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.h;

public class a extends h.a {
    public static Account a(h hVar) {
        Account account = null;
        if (hVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                account = hVar.a();
            } catch (RemoteException unused) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } catch (Throwable th) {
                Binder.restoreCallingIdentity(clearCallingIdentity);
                throw th;
            }
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
        return account;
    }

    public final Account a() {
        throw null;
    }

    public final boolean equals(Object obj) {
        throw null;
    }
}
