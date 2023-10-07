package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.imagepipeline.memory.a;
import com.facebook.imagepipeline.memory.b;

public abstract class DalvikPurgeableDecoder {

    /* renamed from: a  reason: collision with root package name */
    protected static final byte[] f11362a = {-1, -39};

    /* renamed from: b  reason: collision with root package name */
    private final a f11363b = b.a();

    private static class OreoUtils {
        private OreoUtils() {
        }
    }

    static {
        a.a();
    }

    protected DalvikPurgeableDecoder() {
    }

    private static native void nativePinBitmap(Bitmap bitmap);
}
