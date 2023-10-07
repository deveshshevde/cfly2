package com.liulishuo.filedownloader.services;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.liulishuo.filedownloader.message.MessageSnapshot;
import com.liulishuo.filedownloader.message.c;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import io.a;
import io.b;
import java.lang.ref.WeakReference;

public class d extends b.a implements c.b, j {

    /* renamed from: a  reason: collision with root package name */
    private final RemoteCallbackList<a> f21458a = new RemoteCallbackList<>();

    /* renamed from: b  reason: collision with root package name */
    private final g f21459b;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<FileDownloadService> f21460c;

    d(WeakReference<FileDownloadService> weakReference, g gVar) {
        this.f21460c = weakReference;
        this.f21459b = gVar;
        c.a().a((c.b) this);
    }

    private synchronized int b(MessageSnapshot messageSnapshot) {
        int beginBroadcast;
        RemoteCallbackList<a> remoteCallbackList;
        beginBroadcast = this.f21458a.beginBroadcast();
        int i2 = 0;
        while (i2 < beginBroadcast) {
            try {
                this.f21458a.getBroadcastItem(i2).a(messageSnapshot);
                i2++;
            } catch (RemoteException e2) {
                try {
                    iq.d.a((Object) this, (Throwable) e2, "callback error", new Object[0]);
                    remoteCallbackList = this.f21458a;
                } catch (Throwable th) {
                    this.f21458a.finishBroadcast();
                    throw th;
                }
            }
        }
        remoteCallbackList = this.f21458a;
        remoteCallbackList.finishBroadcast();
        return beginBroadcast;
    }

    public IBinder a(Intent intent) {
        return this;
    }

    public void a() throws RemoteException {
        this.f21459b.a();
    }

    public void a(int i2, Notification notification) throws RemoteException {
        WeakReference<FileDownloadService> weakReference = this.f21460c;
        if (weakReference != null && weakReference.get() != null) {
            ((FileDownloadService) this.f21460c.get()).startForeground(i2, notification);
        }
    }

    public void a(Intent intent, int i2, int i3) {
    }

    public void a(MessageSnapshot messageSnapshot) {
        b(messageSnapshot);
    }

    public void a(a aVar) throws RemoteException {
        this.f21458a.register(aVar);
    }

    public void a(String str, String str2, boolean z2, int i2, int i3, int i4, boolean z3, FileDownloadHeader fileDownloadHeader, boolean z4) throws RemoteException {
        this.f21459b.a(str, str2, z2, i2, i3, i4, z3, fileDownloadHeader, z4);
    }

    public void a(boolean z2) throws RemoteException {
        WeakReference<FileDownloadService> weakReference = this.f21460c;
        if (weakReference != null && weakReference.get() != null) {
            ((FileDownloadService) this.f21460c.get()).stopForeground(z2);
        }
    }

    public boolean a(int i2) throws RemoteException {
        return this.f21459b.b(i2);
    }

    public boolean a(String str, String str2) throws RemoteException {
        return this.f21459b.a(str, str2);
    }

    public void b(a aVar) throws RemoteException {
        this.f21458a.unregister(aVar);
    }

    public boolean b() throws RemoteException {
        return this.f21459b.b();
    }

    public boolean b(int i2) throws RemoteException {
        return this.f21459b.f(i2);
    }

    public long c(int i2) throws RemoteException {
        return this.f21459b.c(i2);
    }

    public void c() throws RemoteException {
        this.f21459b.c();
    }

    public long d(int i2) throws RemoteException {
        return this.f21459b.d(i2);
    }

    public byte e(int i2) throws RemoteException {
        return this.f21459b.e(i2);
    }

    public boolean f(int i2) throws RemoteException {
        return this.f21459b.g(i2);
    }
}
