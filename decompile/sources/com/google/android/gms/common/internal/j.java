package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;

public interface j extends IInterface {
    void a(int i2, Bundle bundle) throws RemoteException;

    void a(int i2, IBinder iBinder, Bundle bundle) throws RemoteException;

    void a(int i2, IBinder iBinder, zzj zzj) throws RemoteException;
}
