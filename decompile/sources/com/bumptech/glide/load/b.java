package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class b {

    private interface a {
        int a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    /* renamed from: com.bumptech.glide.load.b$b  reason: collision with other inner class name */
    private interface C0080b {
        ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    private static int a(List<ImageHeaderParser> list, a aVar) throws IOException {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            int a2 = aVar.a(list.get(i2));
            if (a2 != -1) {
                return a2;
            }
        }
        return -1;
    }

    public static int a(List<ImageHeaderParser> list, final ByteBuffer byteBuffer, final bl.b bVar) throws IOException {
        if (byteBuffer == null) {
            return -1;
        }
        return a(list, (a) new a() {
            public int a(ImageHeaderParser imageHeaderParser) throws IOException {
                return imageHeaderParser.a(byteBuffer, bVar);
            }
        });
    }

    private static ImageHeaderParser.ImageType a(List<ImageHeaderParser> list, C0080b bVar) throws IOException {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageHeaderParser.ImageType a2 = bVar.a(list.get(i2));
            if (a2 != ImageHeaderParser.ImageType.UNKNOWN) {
                return a2;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public static ImageHeaderParser.ImageType a(List<ImageHeaderParser> list, final ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, final bl.b bVar) throws IOException {
        return a(list, (C0080b) new C0080b() {
            /* JADX WARNING: Removed duplicated region for block: B:14:0x002a A[SYNTHETIC, Splitter:B:14:0x002a] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public com.bumptech.glide.load.ImageHeaderParser.ImageType a(com.bumptech.glide.load.ImageHeaderParser r5) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream r1 = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream     // Catch:{ all -> 0x0027 }
                    java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0027 }
                    com.bumptech.glide.load.data.ParcelFileDescriptorRewinder r3 = com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.this     // Catch:{ all -> 0x0027 }
                    android.os.ParcelFileDescriptor r3 = r3.a()     // Catch:{ all -> 0x0027 }
                    java.io.FileDescriptor r3 = r3.getFileDescriptor()     // Catch:{ all -> 0x0027 }
                    r2.<init>(r3)     // Catch:{ all -> 0x0027 }
                    bl.b r3 = r3     // Catch:{ all -> 0x0027 }
                    r1.<init>(r2, r3)     // Catch:{ all -> 0x0027 }
                    com.bumptech.glide.load.ImageHeaderParser$ImageType r5 = r5.a((java.io.InputStream) r1)     // Catch:{ all -> 0x0024 }
                    r1.close()     // Catch:{ IOException -> 0x001e }
                L_0x001e:
                    com.bumptech.glide.load.data.ParcelFileDescriptorRewinder r0 = com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.this
                    r0.a()
                    return r5
                L_0x0024:
                    r5 = move-exception
                    r0 = r1
                    goto L_0x0028
                L_0x0027:
                    r5 = move-exception
                L_0x0028:
                    if (r0 == 0) goto L_0x002d
                    r0.close()     // Catch:{ IOException -> 0x002d }
                L_0x002d:
                    com.bumptech.glide.load.data.ParcelFileDescriptorRewinder r0 = com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.this
                    r0.a()
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.b.AnonymousClass3.a(com.bumptech.glide.load.ImageHeaderParser):com.bumptech.glide.load.ImageHeaderParser$ImageType");
            }
        });
    }

    public static ImageHeaderParser.ImageType a(List<ImageHeaderParser> list, final InputStream inputStream, bl.b bVar) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return a(list, (C0080b) new C0080b() {
            public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
                try {
                    return imageHeaderParser.a(inputStream);
                } finally {
                    inputStream.reset();
                }
            }
        });
    }

    public static ImageHeaderParser.ImageType a(List<ImageHeaderParser> list, final ByteBuffer byteBuffer) throws IOException {
        return byteBuffer == null ? ImageHeaderParser.ImageType.UNKNOWN : a(list, (C0080b) new C0080b() {
            public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
                return imageHeaderParser.a(byteBuffer);
            }
        });
    }

    public static int b(List<ImageHeaderParser> list, final ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, final bl.b bVar) throws IOException {
        return a(list, (a) new a() {
            /* JADX WARNING: Removed duplicated region for block: B:14:0x002c A[SYNTHETIC, Splitter:B:14:0x002c] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public int a(com.bumptech.glide.load.ImageHeaderParser r5) throws java.io.IOException {
                /*
                    r4 = this;
                    r0 = 0
                    com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream r1 = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream     // Catch:{ all -> 0x0029 }
                    java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0029 }
                    com.bumptech.glide.load.data.ParcelFileDescriptorRewinder r3 = com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.this     // Catch:{ all -> 0x0029 }
                    android.os.ParcelFileDescriptor r3 = r3.a()     // Catch:{ all -> 0x0029 }
                    java.io.FileDescriptor r3 = r3.getFileDescriptor()     // Catch:{ all -> 0x0029 }
                    r2.<init>(r3)     // Catch:{ all -> 0x0029 }
                    bl.b r3 = r3     // Catch:{ all -> 0x0029 }
                    r1.<init>(r2, r3)     // Catch:{ all -> 0x0029 }
                    bl.b r0 = r3     // Catch:{ all -> 0x0026 }
                    int r5 = r5.a((java.io.InputStream) r1, (bl.b) r0)     // Catch:{ all -> 0x0026 }
                    r1.close()     // Catch:{ IOException -> 0x0020 }
                L_0x0020:
                    com.bumptech.glide.load.data.ParcelFileDescriptorRewinder r0 = com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.this
                    r0.a()
                    return r5
                L_0x0026:
                    r5 = move-exception
                    r0 = r1
                    goto L_0x002a
                L_0x0029:
                    r5 = move-exception
                L_0x002a:
                    if (r0 == 0) goto L_0x002f
                    r0.close()     // Catch:{ IOException -> 0x002f }
                L_0x002f:
                    com.bumptech.glide.load.data.ParcelFileDescriptorRewinder r0 = com.bumptech.glide.load.data.ParcelFileDescriptorRewinder.this
                    r0.a()
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.b.AnonymousClass6.a(com.bumptech.glide.load.ImageHeaderParser):int");
            }
        });
    }

    public static int b(List<ImageHeaderParser> list, final InputStream inputStream, final bl.b bVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return a(list, (a) new a() {
            public int a(ImageHeaderParser imageHeaderParser) throws IOException {
                try {
                    return imageHeaderParser.a(inputStream, bVar);
                } finally {
                    inputStream.reset();
                }
            }
        });
    }
}
