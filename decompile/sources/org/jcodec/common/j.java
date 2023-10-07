package org.jcodec.common;

import java.io.Closeable;
import java.io.IOException;
import java.nio.channels.ByteChannel;
import java.nio.channels.Channel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

public interface j extends Closeable, ByteChannel, Channel, ReadableByteChannel, WritableByteChannel {
    long a() throws IOException;

    j a(long j2) throws IOException;
}
