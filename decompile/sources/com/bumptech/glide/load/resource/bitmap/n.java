package com.bumptech.glide.load.resource.bitmap;

import bl.b;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import z.a;

public final class n implements ImageHeaderParser {
    public int a(InputStream inputStream, b bVar) throws IOException {
        int a2 = new a(inputStream).a("Orientation", 1);
        if (a2 == 0) {
            return -1;
        }
        return a2;
    }

    public int a(ByteBuffer byteBuffer, b bVar) throws IOException {
        return a(cc.a.b(byteBuffer), bVar);
    }

    public ImageHeaderParser.ImageType a(InputStream inputStream) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public ImageHeaderParser.ImageType a(ByteBuffer byteBuffer) {
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
