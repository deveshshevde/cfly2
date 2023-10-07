package com.facebook.imagepipeline.memory;

import android.util.Log;
import com.facebook.imagepipeline.nativecode.a;
import java.io.Closeable;

public class NativeMemoryChunk implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final long f11351a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final int f11352b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11353c = true;

    static {
        a.a();
    }

    private static native long nativeAllocate(int i2);

    private static native void nativeCopyFromByteArray(long j2, byte[] bArr, int i2, int i3);

    private static native void nativeCopyToByteArray(long j2, byte[] bArr, int i2, int i3);

    private static native void nativeFree(long j2);

    private static native void nativeMemcpy(long j2, long j3, int i2);

    private static native byte nativeReadByte(long j2);

    public synchronized boolean a() {
        return this.f11353c;
    }

    public synchronized void close() {
        if (!this.f11353c) {
            this.f11353c = true;
            nativeFree(this.f11351a);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        if (!a()) {
            Log.w("NativeMemoryChunk", "finalize: Chunk " + Integer.toHexString(System.identityHashCode(this)) + " still active. ");
            try {
                close();
            } finally {
                super.finalize();
            }
        }
    }
}
