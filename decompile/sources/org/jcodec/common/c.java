package org.jcodec.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class c implements j {

    /* renamed from: a  reason: collision with root package name */
    private FileChannel f33148a;

    public c(FileChannel fileChannel) throws FileNotFoundException {
        this.f33148a = fileChannel;
    }

    public long a() throws IOException {
        return this.f33148a.position();
    }

    public j a(long j2) throws IOException {
        this.f33148a.position(j2);
        return this;
    }

    public void close() throws IOException {
        this.f33148a.close();
    }

    public boolean isOpen() {
        return this.f33148a.isOpen();
    }

    public int read(ByteBuffer byteBuffer) throws IOException {
        return this.f33148a.read(byteBuffer);
    }

    public int write(ByteBuffer byteBuffer) throws IOException {
        return this.f33148a.write(byteBuffer);
    }
}
