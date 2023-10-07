package com.amap.api.maps.model;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public abstract class UrlTileProvider implements TileProvider {
    private final int height;
    private final int width;

    public UrlTileProvider(int i2, int i3) {
        this.width = i2;
        this.height = i3;
    }

    private static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j2 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j2;
            }
            outputStream.write(bArr, 0, read);
            j2 += (long) read;
        }
    }

    private static byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public final Tile getTile(int i2, int i3, int i4) {
        URL tileUrl = getTileUrl(i2, i3, i4);
        if (tileUrl == null) {
            return NO_TILE;
        }
        try {
            return Tile.obtain(this.width, this.height, a(tileUrl.openStream()));
        } catch (IOException e2) {
            Tile tile = NO_TILE;
            e2.printStackTrace();
            return tile;
        }
    }

    public int getTileHeight() {
        return this.height;
    }

    public abstract URL getTileUrl(int i2, int i3, int i4);

    public int getTileWidth() {
        return this.width;
    }
}
