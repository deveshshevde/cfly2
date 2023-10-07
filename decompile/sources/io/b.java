package io;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.liulishuo.filedownloader.model.FileDownloadHeader;

public interface b extends IInterface {

    public static abstract class a extends Binder implements b {

        /* renamed from: io.b$a$a  reason: collision with other inner class name */
        private static class C0192a implements b {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f28668a;

            C0192a(IBinder iBinder) {
                this.f28668a = iBinder;
            }

            public void a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    this.f28668a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(int i2, Notification notification) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i2);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f28668a.transact(12, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f28668a.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(String str, String str2, boolean z2, int i2, int i3, int i4, boolean z3, FileDownloadHeader fileDownloadHeader, boolean z4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    int i5 = 1;
                    obtain.writeInt(z2 ? 1 : 0);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeInt(z3 ? 1 : 0);
                    if (fileDownloadHeader != null) {
                        obtain.writeInt(1);
                        fileDownloadHeader.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!z4) {
                        i5 = 0;
                    }
                    obtain.writeInt(i5);
                    this.f28668a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void a(boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(z2 ? 1 : 0);
                    this.f28668a.transact(13, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public boolean a(int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i2);
                    boolean z2 = false;
                    this.f28668a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z2 = true;
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean a(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    boolean z2 = false;
                    this.f28668a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z2 = true;
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IBinder asBinder() {
                return this.f28668a;
            }

            public void b(a aVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeStrongBinder(aVar != null ? aVar.asBinder() : null);
                    this.f28668a.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public boolean b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    boolean z2 = false;
                    this.f28668a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z2 = true;
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean b(int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i2);
                    boolean z2 = false;
                    this.f28668a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z2 = true;
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public long c(int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i2);
                    this.f28668a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    this.f28668a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public long d(int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i2);
                    this.f28668a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public byte e(int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i2);
                    this.f28668a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readByte();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean f(int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
                    obtain.writeInt(i2);
                    boolean z2 = false;
                    this.f28668a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z2 = true;
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.liulishuo.filedownloader.i.IFileDownloadIPCService");
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.liulishuo.filedownloader.i.IFileDownloadIPCService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new C0192a(iBinder) : (b) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: android.app.Notification} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r17, android.os.Parcel r18, android.os.Parcel r19, int r20) throws android.os.RemoteException {
            /*
                r16 = this;
                r10 = r16
                r0 = r17
                r1 = r18
                r11 = r19
                r2 = 1598968902(0x5f4e5446, float:1.4867585E19)
                r12 = 1
                java.lang.String r3 = "com.liulishuo.filedownloader.i.IFileDownloadIPCService"
                if (r0 == r2) goto L_0x0159
                r2 = 0
                r4 = 0
                switch(r0) {
                    case 1: goto L_0x014a;
                    case 2: goto L_0x013b;
                    case 3: goto L_0x0125;
                    case 4: goto L_0x00d0;
                    case 5: goto L_0x00be;
                    case 6: goto L_0x00b4;
                    case 7: goto L_0x00a2;
                    case 8: goto L_0x0090;
                    case 9: goto L_0x007e;
                    case 10: goto L_0x006c;
                    case 11: goto L_0x005e;
                    case 12: goto L_0x0044;
                    case 13: goto L_0x0036;
                    case 14: goto L_0x0024;
                    case 15: goto L_0x001a;
                    default: goto L_0x0015;
                }
            L_0x0015:
                boolean r0 = super.onTransact(r17, r18, r19, r20)
                return r0
            L_0x001a:
                r1.enforceInterface(r3)
                r16.c()
                r19.writeNoException()
                return r12
            L_0x0024:
                r1.enforceInterface(r3)
                int r0 = r18.readInt()
                boolean r0 = r10.f(r0)
                r19.writeNoException()
                r11.writeInt(r0)
                return r12
            L_0x0036:
                r1.enforceInterface(r3)
                int r0 = r18.readInt()
                if (r0 == 0) goto L_0x0040
                r4 = 1
            L_0x0040:
                r10.a((boolean) r4)
                return r12
            L_0x0044:
                r1.enforceInterface(r3)
                int r0 = r18.readInt()
                int r3 = r18.readInt()
                if (r3 == 0) goto L_0x005a
                android.os.Parcelable$Creator r2 = android.app.Notification.CREATOR
                java.lang.Object r1 = r2.createFromParcel(r1)
                r2 = r1
                android.app.Notification r2 = (android.app.Notification) r2
            L_0x005a:
                r10.a((int) r0, (android.app.Notification) r2)
                return r12
            L_0x005e:
                r1.enforceInterface(r3)
                boolean r0 = r16.b()
                r19.writeNoException()
                r11.writeInt(r0)
                return r12
            L_0x006c:
                r1.enforceInterface(r3)
                int r0 = r18.readInt()
                byte r0 = r10.e(r0)
                r19.writeNoException()
                r11.writeByte(r0)
                return r12
            L_0x007e:
                r1.enforceInterface(r3)
                int r0 = r18.readInt()
                long r0 = r10.d(r0)
                r19.writeNoException()
                r11.writeLong(r0)
                return r12
            L_0x0090:
                r1.enforceInterface(r3)
                int r0 = r18.readInt()
                long r0 = r10.c(r0)
                r19.writeNoException()
                r11.writeLong(r0)
                return r12
            L_0x00a2:
                r1.enforceInterface(r3)
                int r0 = r18.readInt()
                boolean r0 = r10.b((int) r0)
                r19.writeNoException()
                r11.writeInt(r0)
                return r12
            L_0x00b4:
                r1.enforceInterface(r3)
                r16.a()
                r19.writeNoException()
                return r12
            L_0x00be:
                r1.enforceInterface(r3)
                int r0 = r18.readInt()
                boolean r0 = r10.a((int) r0)
                r19.writeNoException()
                r11.writeInt(r0)
                return r12
            L_0x00d0:
                r1.enforceInterface(r3)
                java.lang.String r3 = r18.readString()
                java.lang.String r5 = r18.readString()
                int r0 = r18.readInt()
                if (r0 == 0) goto L_0x00e3
                r6 = 1
                goto L_0x00e4
            L_0x00e3:
                r6 = 0
            L_0x00e4:
                int r7 = r18.readInt()
                int r8 = r18.readInt()
                int r9 = r18.readInt()
                int r0 = r18.readInt()
                if (r0 == 0) goto L_0x00f8
                r13 = 1
                goto L_0x00f9
            L_0x00f8:
                r13 = 0
            L_0x00f9:
                int r0 = r18.readInt()
                if (r0 == 0) goto L_0x0109
                android.os.Parcelable$Creator<com.liulishuo.filedownloader.model.FileDownloadHeader> r0 = com.liulishuo.filedownloader.model.FileDownloadHeader.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r1)
                com.liulishuo.filedownloader.model.FileDownloadHeader r0 = (com.liulishuo.filedownloader.model.FileDownloadHeader) r0
                r14 = r0
                goto L_0x010a
            L_0x0109:
                r14 = r2
            L_0x010a:
                int r0 = r18.readInt()
                if (r0 == 0) goto L_0x0112
                r15 = 1
                goto L_0x0113
            L_0x0112:
                r15 = 0
            L_0x0113:
                r0 = r16
                r1 = r3
                r2 = r5
                r3 = r6
                r4 = r7
                r5 = r8
                r6 = r9
                r7 = r13
                r8 = r14
                r9 = r15
                r0.a(r1, r2, r3, r4, r5, r6, r7, r8, r9)
                r19.writeNoException()
                return r12
            L_0x0125:
                r1.enforceInterface(r3)
                java.lang.String r0 = r18.readString()
                java.lang.String r1 = r18.readString()
                boolean r0 = r10.a((java.lang.String) r0, (java.lang.String) r1)
                r19.writeNoException()
                r11.writeInt(r0)
                return r12
            L_0x013b:
                r1.enforceInterface(r3)
                android.os.IBinder r0 = r18.readStrongBinder()
                io.a r0 = io.a.C0190a.a(r0)
                r10.b((io.a) r0)
                return r12
            L_0x014a:
                r1.enforceInterface(r3)
                android.os.IBinder r0 = r18.readStrongBinder()
                io.a r0 = io.a.C0190a.a(r0)
                r10.a((io.a) r0)
                return r12
            L_0x0159:
                r11.writeString(r3)
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: io.b.a.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void a() throws RemoteException;

    void a(int i2, Notification notification) throws RemoteException;

    void a(a aVar) throws RemoteException;

    void a(String str, String str2, boolean z2, int i2, int i3, int i4, boolean z3, FileDownloadHeader fileDownloadHeader, boolean z4) throws RemoteException;

    void a(boolean z2) throws RemoteException;

    boolean a(int i2) throws RemoteException;

    boolean a(String str, String str2) throws RemoteException;

    void b(a aVar) throws RemoteException;

    boolean b() throws RemoteException;

    boolean b(int i2) throws RemoteException;

    long c(int i2) throws RemoteException;

    void c() throws RemoteException;

    long d(int i2) throws RemoteException;

    byte e(int i2) throws RemoteException;

    boolean f(int i2) throws RemoteException;
}
