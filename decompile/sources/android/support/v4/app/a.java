package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface a extends IInterface {

    /* renamed from: android.support.v4.app.a$a  reason: collision with other inner class name */
    public static abstract class C0005a extends Binder implements a {

        /* renamed from: android.support.v4.app.a$a$a  reason: collision with other inner class name */
        private static class C0006a implements a {

            /* renamed from: a  reason: collision with root package name */
            public static a f277a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f278b;

            C0006a(IBinder iBinder) {
                this.f278b = iBinder;
            }

            public void a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    if (this.f278b.transact(3, obtain, (Parcel) null, 1) || C0005a.a() == null) {
                        obtain.recycle();
                    } else {
                        C0005a.a().a(str);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void a(String str, int i2, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    obtain.writeString(str2);
                    if (this.f278b.transact(2, obtain, (Parcel) null, 1) || C0005a.a() == null) {
                        obtain.recycle();
                    } else {
                        C0005a.a().a(str, i2, str2);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public void a(String str, int i2, String str2, Notification notification) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    obtain.writeString(str2);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.f278b.transact(1, obtain, (Parcel) null, 1) || C0005a.a() == null) {
                        obtain.recycle();
                    } else {
                        C0005a.a().a(str, i2, str2, notification);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f278b;
            }
        }

        public static a a() {
            return C0006a.f277a;
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0006a(iBinder) : (a) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("android.support.v4.app.INotificationSideChannel");
                a(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0 ? (Notification) Notification.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i2 == 2) {
                parcel.enforceInterface("android.support.v4.app.INotificationSideChannel");
                a(parcel.readString(), parcel.readInt(), parcel.readString());
                return true;
            } else if (i2 == 3) {
                parcel.enforceInterface("android.support.v4.app.INotificationSideChannel");
                a(parcel.readString());
                return true;
            } else if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                parcel2.writeString("android.support.v4.app.INotificationSideChannel");
                return true;
            }
        }
    }

    void a(String str) throws RemoteException;

    void a(String str, int i2, String str2) throws RemoteException;

    void a(String str, int i2, String str2, Notification notification) throws RemoteException;
}
