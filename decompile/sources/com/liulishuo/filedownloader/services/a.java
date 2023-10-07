package com.liulishuo.filedownloader.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.liulishuo.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.liulishuo.filedownloader.f;
import com.liulishuo.filedownloader.u;
import iq.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class a<CALLBACK extends Binder, INTERFACE extends IInterface> implements ServiceConnection, u {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f21443a = false;

    /* renamed from: b  reason: collision with root package name */
    private final CALLBACK f21444b;

    /* renamed from: c  reason: collision with root package name */
    private volatile INTERFACE f21445c;

    /* renamed from: d  reason: collision with root package name */
    private final Class<?> f21446d;

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<String, Object> f21447e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private final List<Context> f21448f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final ArrayList<Runnable> f21449g = new ArrayList<>();

    protected a(Class<?> cls) {
        this.f21446d = cls;
        this.f21444b = b();
    }

    private void b(boolean z2) {
        if (!z2 && this.f21445c != null) {
            try {
                a(this.f21445c, this.f21444b);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        if (d.f29057a) {
            d.c(this, "release connect resources %s", this.f21445c);
        }
        this.f21445c = null;
        f.a().b(new DownloadServiceConnectChangedEvent(z2 ? DownloadServiceConnectChangedEvent.ConnectStatus.lost : DownloadServiceConnectChangedEvent.ConnectStatus.disconnected, this.f21446d));
    }

    public void a(Context context) {
        a(context, (Runnable) null);
    }

    public void a(Context context, Runnable runnable) {
        if (!iq.f.a(context)) {
            if (d.f29057a) {
                d.c(this, "bindStartByContext %s", context.getClass().getSimpleName());
            }
            Intent intent = new Intent(context, this.f21446d);
            if (runnable != null && !this.f21449g.contains(runnable)) {
                this.f21449g.add(runnable);
            }
            if (!this.f21448f.contains(context)) {
                this.f21448f.add(context);
            }
            boolean d2 = iq.f.d(context);
            this.f21443a = d2;
            intent.putExtra("is_foreground", d2);
            context.bindService(intent, this, 1);
            if (this.f21443a) {
                if (d.f29057a) {
                    d.c(this, "start foreground service", new Object[0]);
                }
                if (Build.VERSION.SDK_INT >= 26) {
                    context.startForegroundService(intent);
                    return;
                }
                return;
            }
            context.startService(intent);
            return;
        }
        throw new IllegalStateException("Fatal-Exception: You can't bind the FileDownloadService in :filedownloader process.\n It's the invalid operation and is likely to cause unexpected problems.\n Maybe you want to use non-separate process mode for FileDownloader, More detail about non-separate mode, please move to wiki manually: https://github.com/lingochamp/FileDownloader/wiki/filedownloader.properties");
    }

    /* access modifiers changed from: protected */
    public abstract void a(INTERFACE interfaceR, CALLBACK callback) throws RemoteException;

    /* access modifiers changed from: protected */
    public abstract CALLBACK b();

    /* access modifiers changed from: protected */
    public abstract INTERFACE b(IBinder iBinder);

    public void b(Context context) {
        if (this.f21448f.contains(context)) {
            if (d.f29057a) {
                d.c(this, "unbindByContext %s", context);
            }
            this.f21448f.remove(context);
            if (this.f21448f.isEmpty()) {
                b(false);
            }
            Intent intent = new Intent(context, this.f21446d);
            context.unbindService(this);
            context.stopService(intent);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void b(INTERFACE interfaceR, CALLBACK callback) throws RemoteException;

    public boolean d() {
        return g() != null;
    }

    public boolean f() {
        return this.f21443a;
    }

    /* access modifiers changed from: protected */
    public INTERFACE g() {
        return this.f21445c;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f21445c = b(iBinder);
        if (d.f29057a) {
            d.c(this, "onServiceConnected %s %s", componentName, this.f21445c);
        }
        try {
            b(this.f21445c, this.f21444b);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
        this.f21449g.clear();
        for (Runnable run : (List) this.f21449g.clone()) {
            run.run();
        }
        f.a().b(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, this.f21446d));
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (d.f29057a) {
            d.c(this, "onServiceDisconnected %s %s", componentName, this.f21445c);
        }
        b(true);
    }
}
