package tv.danmaku.ijk.media.player.misc;

import java.io.IOException;

public interface IMediaDataSource {
    void close() throws IOException;

    long getSize() throws IOException;

    int readAt(long j2, byte[] bArr, int i2, int i3) throws IOException;
}
