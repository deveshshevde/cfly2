package org.jcodec.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public class i {
    public static c a(File file) throws FileNotFoundException {
        return new c(new FileOutputStream(file).getChannel());
    }

    public static void a(ByteBuffer byteBuffer, String str) {
        byteBuffer.put((byte) str.length());
        byteBuffer.put(g.a(str));
    }

    public static void a(ByteBuffer byteBuffer, String str, int i2) {
        byteBuffer.put((byte) str.length());
        byteBuffer.put(g.a(str));
        b(byteBuffer, i2 - str.length());
    }

    public static void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (byteBuffer2.hasArray()) {
            byteBuffer.put(byteBuffer2.array(), byteBuffer2.arrayOffset() + byteBuffer2.position(), Math.min(byteBuffer.remaining(), byteBuffer2.remaining()));
        } else {
            byteBuffer.put(a(byteBuffer2, byteBuffer.remaining()));
        }
    }

    public static void a(ReadableByteChannel readableByteChannel) {
        if (readableByteChannel != null) {
            try {
                readableByteChannel.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void a(WritableByteChannel writableByteChannel, long j2) throws IOException {
        writableByteChannel.write((ByteBuffer) ByteBuffer.allocate(8).putLong(j2).flip());
    }

    public static byte[] a(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.duplicate().get(bArr);
        return bArr;
    }

    public static byte[] a(ByteBuffer byteBuffer, int i2) {
        byte[] bArr = new byte[Math.min(byteBuffer.remaining(), i2)];
        byteBuffer.duplicate().get(bArr);
        return bArr;
    }

    public static int b(ByteBuffer byteBuffer, int i2) {
        int min = Math.min(byteBuffer.remaining(), i2);
        byteBuffer.position(byteBuffer.position() + min);
        return min;
    }

    public static ByteBuffer b(ByteBuffer byteBuffer) {
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        allocate.put(byteBuffer.duplicate());
        allocate.flip();
        return allocate;
    }
}
