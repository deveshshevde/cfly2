package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.m;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class a implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    boolean f17367a = false;

    /* renamed from: b  reason: collision with root package name */
    private final BlockingQueue<IBinder> f17368b = new LinkedBlockingQueue();

    public IBinder a(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        m.c("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (!this.f17367a) {
            this.f17367a = true;
            IBinder poll = this.f17368b.poll(j2, timeUnit);
            if (poll != null) {
                return poll;
            }
            throw new TimeoutException("Timed out waiting for the service connection");
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f17368b.add(iBinder);
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
