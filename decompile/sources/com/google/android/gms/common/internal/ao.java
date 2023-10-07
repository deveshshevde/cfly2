package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

final class ao implements k {

    /* renamed from: a  reason: collision with root package name */
    private final IBinder f17783a;

    ao(IBinder iBinder) {
        this.f17783a = iBinder;
    }

    public final void a(j jVar, GetServiceRequest getServiceRequest) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder(jVar != null ? jVar.asBinder() : null);
            if (getServiceRequest != null) {
                obtain.writeInt(1);
                bd.a(getServiceRequest, obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            this.f17783a.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f17783a;
    }
}
