package com.liulishuo.filedownloader.services;

import android.util.SparseArray;
import com.liulishuo.filedownloader.download.DownloadLaunchRunnable;
import iq.b;
import iq.d;
import iq.e;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

class h {

    /* renamed from: a  reason: collision with root package name */
    private SparseArray<DownloadLaunchRunnable> f21465a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private ThreadPoolExecutor f21466b;

    /* renamed from: c  reason: collision with root package name */
    private final String f21467c = "Network";

    /* renamed from: d  reason: collision with root package name */
    private int f21468d;

    /* renamed from: e  reason: collision with root package name */
    private int f21469e = 0;

    h(int i2) {
        this.f21466b = b.a(i2, "Network");
        this.f21468d = i2;
    }

    private synchronized void c() {
        SparseArray<DownloadLaunchRunnable> sparseArray = new SparseArray<>();
        int size = this.f21465a.size();
        for (int i2 = 0; i2 < size; i2++) {
            int keyAt = this.f21465a.keyAt(i2);
            DownloadLaunchRunnable downloadLaunchRunnable = this.f21465a.get(keyAt);
            if (downloadLaunchRunnable != null && downloadLaunchRunnable.e()) {
                sparseArray.put(keyAt, downloadLaunchRunnable);
            }
        }
        this.f21465a = sparseArray;
    }

    public synchronized int a() {
        c();
        return this.f21465a.size();
    }

    public synchronized int a(String str, int i2) {
        if (str == null) {
            return 0;
        }
        int size = this.f21465a.size();
        for (int i3 = 0; i3 < size; i3++) {
            DownloadLaunchRunnable valueAt = this.f21465a.valueAt(i3);
            if (valueAt != null) {
                if (valueAt.e() && valueAt.d() != i2 && str.equals(valueAt.f())) {
                    return valueAt.d();
                }
            }
        }
        return 0;
    }

    public void a(DownloadLaunchRunnable downloadLaunchRunnable) {
        int i2;
        downloadLaunchRunnable.b();
        synchronized (this) {
            this.f21465a.put(downloadLaunchRunnable.d(), downloadLaunchRunnable);
        }
        this.f21466b.execute(downloadLaunchRunnable);
        int i3 = this.f21469e;
        if (i3 >= 600) {
            c();
            i2 = 0;
        } else {
            i2 = i3 + 1;
        }
        this.f21469e = i2;
    }

    public synchronized boolean a(int i2) {
        if (a() > 0) {
            d.d(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
            return false;
        }
        int a2 = e.a(i2);
        if (d.f29057a) {
            d.c(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.f21468d), Integer.valueOf(a2));
        }
        List<Runnable> shutdownNow = this.f21466b.shutdownNow();
        this.f21466b = b.a(a2, "Network");
        if (shutdownNow.size() > 0) {
            d.d(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(shutdownNow.size()));
        }
        this.f21468d = a2;
        return true;
    }

    public synchronized List<Integer> b() {
        ArrayList arrayList;
        c();
        arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f21465a.size(); i2++) {
            SparseArray<DownloadLaunchRunnable> sparseArray = this.f21465a;
            arrayList.add(Integer.valueOf(sparseArray.get(sparseArray.keyAt(i2)).d()));
        }
        return arrayList;
    }

    public void b(int i2) {
        c();
        synchronized (this) {
            DownloadLaunchRunnable downloadLaunchRunnable = this.f21465a.get(i2);
            if (downloadLaunchRunnable != null) {
                downloadLaunchRunnable.a();
                boolean remove = this.f21466b.remove(downloadLaunchRunnable);
                if (d.f29057a) {
                    d.c(this, "successful cancel %d %B", Integer.valueOf(i2), Boolean.valueOf(remove));
                }
            }
            this.f21465a.remove(i2);
        }
    }

    public synchronized boolean c(int i2) {
        DownloadLaunchRunnable downloadLaunchRunnable;
        downloadLaunchRunnable = this.f21465a.get(i2);
        return downloadLaunchRunnable != null && downloadLaunchRunnable.e();
    }
}
