package com.liulishuo.filedownloader;

import com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.liulishuo.filedownloader.event.b;
import com.liulishuo.filedownloader.event.c;

public abstract class e extends c {

    /* renamed from: a  reason: collision with root package name */
    private DownloadServiceConnectChangedEvent.ConnectStatus f21327a;

    public abstract void a();

    public boolean a(b bVar) {
        if (!(bVar instanceof DownloadServiceConnectChangedEvent)) {
            return false;
        }
        DownloadServiceConnectChangedEvent.ConnectStatus a2 = ((DownloadServiceConnectChangedEvent) bVar).a();
        this.f21327a = a2;
        if (a2 == DownloadServiceConnectChangedEvent.ConnectStatus.connected) {
            a();
            return false;
        }
        b();
        return false;
    }

    public abstract void b();

    public DownloadServiceConnectChangedEvent.ConnectStatus c() {
        return this.f21327a;
    }
}
