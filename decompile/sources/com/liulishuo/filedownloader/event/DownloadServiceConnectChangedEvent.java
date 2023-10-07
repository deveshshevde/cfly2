package com.liulishuo.filedownloader.event;

public class DownloadServiceConnectChangedEvent extends b {

    /* renamed from: c  reason: collision with root package name */
    private final ConnectStatus f21328c;

    /* renamed from: d  reason: collision with root package name */
    private final Class<?> f21329d;

    public enum ConnectStatus {
        connected,
        disconnected,
        lost
    }

    public DownloadServiceConnectChangedEvent(ConnectStatus connectStatus, Class<?> cls) {
        super("event.service.connect.changed");
        this.f21328c = connectStatus;
        this.f21329d = cls;
    }

    public ConnectStatus a() {
        return this.f21328c;
    }
}
