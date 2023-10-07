package com.liulishuo.filedownloader;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.RemoteException;
import io.b;
import iq.c;
import iq.d;
import java.io.File;
import java.io.IOException;

public class ab implements Handler.Callback {

    /* renamed from: a  reason: collision with root package name */
    private static File f21160a;

    /* renamed from: b  reason: collision with root package name */
    private static final Long f21161b = 1000L;

    /* renamed from: c  reason: collision with root package name */
    private HandlerThread f21162c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f21163d;

    /* renamed from: e  reason: collision with root package name */
    private final b f21164e;

    public ab(b bVar) {
        this.f21164e = bVar;
    }

    public static void a() {
        Class<ab> cls = ab.class;
        File e2 = e();
        if (!e2.getParentFile().exists()) {
            e2.getParentFile().mkdirs();
        }
        if (e2.exists()) {
            d.d(cls, "marker file " + e2.getAbsolutePath() + " exists", new Object[0]);
            return;
        }
        try {
            boolean createNewFile = e2.createNewFile();
            d.c(cls, "create marker file" + e2.getAbsolutePath() + " " + createNewFile, new Object[0]);
        } catch (IOException e3) {
            d.a(cls, "create marker file failed", e3);
        }
    }

    public static void b() {
        File e2 = e();
        if (e2.exists()) {
            d.c(ab.class, "delete marker file " + e2.delete(), new Object[0]);
        }
    }

    private static File e() {
        if (f21160a == null) {
            Context a2 = c.a();
            f21160a = new File(a2.getCacheDir() + File.separator + ".filedownloader_pause_all_marker.b");
        }
        return f21160a;
    }

    private static boolean f() {
        return e().exists();
    }

    public void c() {
        HandlerThread handlerThread = new HandlerThread("PauseAllChecker");
        this.f21162c = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(this.f21162c.getLooper(), this);
        this.f21163d = handler;
        handler.sendEmptyMessageDelayed(0, f21161b.longValue());
    }

    public void d() {
        this.f21163d.removeMessages(0);
        this.f21162c.quit();
    }

    public boolean handleMessage(Message message) {
        if (f()) {
            try {
                this.f21164e.a();
            } catch (RemoteException e2) {
                d.a((Object) this, (Throwable) e2, "pause all failed", new Object[0]);
            } catch (Throwable th) {
                b();
                throw th;
            }
            b();
        }
        this.f21163d.sendEmptyMessageDelayed(0, f21161b.longValue());
        return true;
    }
}
