package com.facebook.soloader;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

public final class d implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final FileOutputStream f11400a;

    /* renamed from: b  reason: collision with root package name */
    private final FileLock f11401b;

    private d(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        this.f11400a = fileOutputStream;
        try {
            FileLock lock = fileOutputStream.getChannel().lock();
            if (lock == null) {
                fileOutputStream.close();
            }
            this.f11401b = lock;
        } catch (Throwable th) {
            this.f11400a.close();
            throw th;
        }
    }

    public static d a(File file) throws IOException {
        return new d(file);
    }

    public void close() throws IOException {
        try {
            FileLock fileLock = this.f11401b;
            if (fileLock != null) {
                fileLock.release();
            }
        } finally {
            this.f11400a.close();
        }
    }
}
