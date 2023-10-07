package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.c;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImageManager f17726a;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f17727b;

    /* renamed from: c  reason: collision with root package name */
    private final Bitmap f17728c;

    /* renamed from: d  reason: collision with root package name */
    private final CountDownLatch f17729d;

    public b(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z2, CountDownLatch countDownLatch) {
        this.f17726a = imageManager;
        this.f17727b = uri;
        this.f17728c = bitmap;
        this.f17729d = countDownLatch;
    }

    public final void run() {
        c.a("OnBitmapLoadedRunnable must be executed in the main thread");
        Bitmap bitmap = this.f17728c;
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) this.f17726a.f17714h.remove(this.f17727b);
        if (imageReceiver != null) {
            ArrayList a2 = imageReceiver.f17718c;
            int size = a2.size();
            for (int i2 = 0; i2 < size; i2++) {
                e eVar = (e) a2.get(i2);
                Bitmap bitmap2 = this.f17728c;
                if (bitmap2 == null || bitmap == null) {
                    this.f17726a.f17715i.put(this.f17727b, Long.valueOf(SystemClock.elapsedRealtime()));
                    ImageManager imageManager = this.f17726a;
                    eVar.a(imageManager.f17709c, imageManager.f17712f, false);
                } else {
                    eVar.a(this.f17726a.f17709c, bitmap2, false);
                }
                if (!(eVar instanceof d)) {
                    this.f17726a.f17713g.remove(eVar);
                }
            }
        }
        this.f17729d.countDown();
        synchronized (ImageManager.f17707a) {
            ImageManager.f17708b.remove(this.f17727b);
        }
    }
}
