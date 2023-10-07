package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

public final class bm extends zza implements h {
    bm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    public final Account a() throws RemoteException {
        Parcel zzB = zzB(2, zza());
        Account account = (Account) zzc.zza(zzB, Account.CREATOR);
        zzB.recycle();
        return account;
    }
}