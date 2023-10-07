package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.google.android.gms.common.internal.c;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ImageManager f17723a;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f17724b;

    /* renamed from: c  reason: collision with root package name */
    private final ParcelFileDescriptor f17725c;

    public a(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
        this.f17723a = imageManager;
        this.f17724b = uri;
        this.f17725c = parcelFileDescriptor;
    }

    public final void run() {
        boolean z2;
        Bitmap bitmap;
        c.b("LoadBitmapFromDiskRunnable can't be executed in the main thread");
        ParcelFileDescriptor parcelFileDescriptor = this.f17725c;
        Bitmap bitmap2 = null;
        boolean z3 = false;
        if (parcelFileDescriptor != null) {
            try {
                bitmap2 = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
            } catch (OutOfMemoryError e2) {
                String valueOf = String.valueOf(this.f17724b);
                String.valueOf(valueOf).length();
                Log.e("ImageManager", "OOM while loading bitmap for uri: ".concat(String.valueOf(valueOf)), e2);
                z3 = true;
            }
            try {
                this.f17725c.close();
            } catch (IOException e3) {
                Log.e("ImageManager", "closed failed", e3);
            }
            bitmap = bitmap2;
            z2 = z3;
        } else {
            bitmap = null;
            z2 = false;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ImageManager imageManager = this.f17723a;
        imageManager.f17710d.post(new b(imageManager, this.f17724b, bitmap, z2, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
            String valueOf2 = String.valueOf(this.f17724b);
            String.valueOf(valueOf2).length();
            Log.w("ImageManager", "Latch interrupted while posting ".concat(String.valueOf(valueOf2)));
        }
    }
}
