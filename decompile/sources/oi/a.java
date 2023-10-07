package oi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface a extends IInterface {

    /* renamed from: oi.a$a  reason: collision with other inner class name */
    public static abstract class C0232a extends Binder implements a {

        /* renamed from: oi.a$a$a  reason: collision with other inner class name */
        private static class C0233a implements a {

            /* renamed from: a  reason: collision with root package name */
            public static a f31767a;

            /* renamed from: b  reason: collision with root package name */
            private IBinder f31768b;

            C0233a(IBinder iBinder) {
                this.f31768b = iBinder;
            }

            public int a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("org.opencv.engine.OpenCVEngineInterface");
                    if (!this.f31768b.transact(1, obtain, obtain2, 0) && C0232a.b() != null) {
                        return C0232a.b().a();
                    }
                    obtain2.readException();
                    int readInt = obtain2.readInt();
                    obtain2.recycle();
                    obtain.recycle();
                    return readInt;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String a(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("org.opencv.engine.OpenCVEngineInterface");
                    obtain.writeString(str);
                    if (!this.f31768b.transact(2, obtain, obtain2, 0) && C0232a.b() != null) {
                        return C0232a.b().a(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f31768b;
            }

            public boolean b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("org.opencv.engine.OpenCVEngineInterface");
                    obtain.writeString(str);
                    boolean z2 = false;
                    if (!this.f31768b.transact(3, obtain, obtain2, 0) && C0232a.b() != null) {
                        return C0232a.b().b(str);
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z2 = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String c(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("org.opencv.engine.OpenCVEngineInterface");
                    obtain.writeString(str);
                    if (!this.f31768b.transact(4, obtain, obtain2, 0) && C0232a.b() != null) {
                        return C0232a.b().c(str);
                    }
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("org.opencv.engine.OpenCVEngineInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0233a(iBinder) : (a) queryLocalInterface;
        }

        public static a b() {
            return C0233a.f31767a;
        }

        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface("org.opencv.engine.OpenCVEngineInterface");
                int a2 = a();
                parcel2.writeNoException();
                parcel2.writeInt(a2);
                return true;
            } else if (i2 == 2) {
                parcel.enforceInterface("org.opencv.engine.OpenCVEngineInterface");
                String a3 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a3);
                return true;
            } else if (i2 == 3) {
                parcel.enforceInterface("org.opencv.engine.OpenCVEngineInterface");
                boolean b2 = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(b2 ? 1 : 0);
                return true;
            } else if (i2 == 4) {
                parcel.enforceInterface("org.opencv.engine.OpenCVEngineInterface");
                String c2 = c(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(c2);
                return true;
            } else if (i2 != 1598968902) {
                return super.onTransact(i2, parcel, parcel2, i3);
            } else {
                parcel2.writeString("org.opencv.engine.OpenCVEngineInterface");
                return true;
            }
        }
    }

    int a() throws RemoteException;

    String a(String str) throws RemoteException;

    boolean b(String str) throws RemoteException;

    String c(String str) throws RemoteException;
}
