package com.liulishuo.filedownloader;

import android.os.IBinder;
import android.os.RemoteException;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.liulishuo.filedownloader.message.c;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.services.FileDownloadService;
import io.a;
import io.b;

class o extends com.liulishuo.filedownloader.services.a<a, b> {

    protected static class a extends a.C0190a {
        protected a() {
        }

        public void a(MessageSnapshot messageSnapshot) throws RemoteException {
            c.a().a(messageSnapshot);
        }
    }

    o() {
        super(FileDownloadService.SeparateProcessService.class);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public a b() {
        return new a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public b b(IBinder iBinder) {
        return b.a.a(iBinder);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void b(b bVar, a aVar) throws RemoteException {
        bVar.a((io.a) aVar);
    }

    public void a(boolean z2) {
        if (!d()) {
            iq.a.a(z2);
            return;
        }
        try {
            ((b) g()).a(z2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            this.f21443a = false;
            throw th;
        }
        this.f21443a = false;
    }

    public boolean a(int i2) {
        if (!d()) {
            return iq.a.a(i2);
        }
        try {
            return ((b) g()).a(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public boolean a(String str, String str2, boolean z2, int i2, int i3, int i4, boolean z3, FileDownloadHeader fileDownloadHeader, boolean z4) {
        if (!d()) {
            return iq.a.a(str, str2, z2);
        }
        try {
            ((b) g()).a(str, str2, z2, i2, i3, i4, z3, fileDownloadHeader, z4);
            return true;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public byte b(int i2) {
        if (!d()) {
            return iq.a.b(i2);
        }
        try {
            return ((b) g()).e(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void a(b bVar, a aVar) throws RemoteException {
        bVar.b((io.a) aVar);
    }

    public void c() {
        if (!d()) {
            iq.a.a();
            return;
        }
        try {
            ((b) g()).a();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    public boolean c(int i2) {
        if (!d()) {
            return iq.a.c(i2);
        }
        try {
            return ((b) g()).b(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public void e() {
        if (!d()) {
            iq.a.b();
            return;
        }
        try {
            ((b) g()).c();
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }
}
