package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import bl.e;
import bl.f;
import bq.a;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.g;
import java.io.IOException;

public final class d implements g<ImageDecoder.Source, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final e f10463a = new f();

    public s<Bitmap> a(ImageDecoder.Source source, int i2, int i3, com.bumptech.glide.load.f fVar) throws IOException {
        Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, new a(i2, i3, fVar));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            Log.v("BitmapImageDecoder", "Decoded [" + decodeBitmap.getWidth() + "x" + decodeBitmap.getHeight() + "] for [" + i2 + "x" + i3 + "]");
        }
        return new e(decodeBitmap, this.f10463a);
    }

    public boolean a(ImageDecoder.Source source, com.bumptech.glide.load.f fVar) throws IOException {
        return true;
    }
}
