package com.liulishuo.filedownloader.services;

import android.app.Notification;
import android.content.Intent;
import android.os.IBinder;
import com.liulishuo.filedownloader.m;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import io.b;
import java.lang.ref.WeakReference;

public class e extends b.a implements j {

    /* renamed from: a  reason: collision with root package name */
    private final g f21461a;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<FileDownloadService> f21462b;

    public interface a {
        void a(e eVar);
    }

    e(WeakReference<FileDownloadService> weakReference, g gVar) {
        this.f21462b = weakReference;
        this.f21461a = gVar;
    }

    public IBinder a(Intent intent) {
        return null;
    }

    public void a() {
        this.f21461a.a();
    }

    public void a(int i2, Notification notification) {
        WeakReference<FileDownloadService> weakReference = this.f21462b;
        if (weakReference != null && weakReference.get() != null) {
            ((FileDownloadService) this.f21462b.get()).startForeground(i2, notification);
        }
    }

    public void a(Intent intent, int i2, int i3) {
        m.b().a(this);
    }

    public void a(io.a aVar) {
    }

    public void a(String str, String str2, boolean z2, int i2, int i3, int i4, boolean z3, FileDownloadHeader fileDownloadHeader, boolean z4) {
        this.f21461a.a(str, str2, z2, i2, i3, i4, z3, fileDownloadHeader, z4);
    }

    public void a(boolean z2) {
        WeakReference<FileDownloadService> weakReference = this.f21462b;
        if (weakReference != null && weakReference.get() != null) {
            ((FileDownloadService) this.f21462b.get()).stopForeground(z2);
        }
    }

    public boolean a(int i2) {
        return this.f21461a.b(i2);
    }

    public boolean a(String str, String str2) {
        return this.f21461a.a(str, str2);
    }

    public void b(io.a aVar) {
    }

    public boolean b() {
        return this.f21461a.b();
    }

    public boolean b(int i2) {
        return this.f21461a.f(i2);
    }

    public long c(int i2) {
        return this.f21461a.c(i2);
    }

    public void c() {
        this.f21461a.c();
    }

    public long d(int i2) {
        return this.f21461a.d(i2);
    }

    public byte e(int i2) {
        return this.f21461a.e(i2);
    }

    public boolean f(int i2) {
        return this.f21461a.g(i2);
    }
}
