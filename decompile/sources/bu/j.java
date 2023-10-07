package bu;

import android.util.Log;
import bl.b;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.f;
import com.bumptech.glide.load.g;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class j implements g<InputStream, c> {

    /* renamed from: a  reason: collision with root package name */
    private final List<ImageHeaderParser> f6039a;

    /* renamed from: b  reason: collision with root package name */
    private final g<ByteBuffer, c> f6040b;

    /* renamed from: c  reason: collision with root package name */
    private final b f6041c;

    public j(List<ImageHeaderParser> list, g<ByteBuffer, c> gVar, b bVar) {
        this.f6039a = list;
        this.f6040b = gVar;
        this.f6041c = bVar;
    }

    private static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e2) {
            if (!Log.isLoggable("StreamGifDecoder", 5)) {
                return null;
            }
            Log.w("StreamGifDecoder", "Error reading data from stream", e2);
            return null;
        }
    }

    public s<c> a(InputStream inputStream, int i2, int i3, f fVar) throws IOException {
        byte[] a2 = a(inputStream);
        if (a2 == null) {
            return null;
        }
        return this.f6040b.a(ByteBuffer.wrap(a2), i2, i3, fVar);
    }

    public boolean a(InputStream inputStream, f fVar) throws IOException {
        return !((Boolean) fVar.a(i.f6038b)).booleanValue() && com.bumptech.glide.load.b.a(this.f6039a, inputStream, this.f6041c) == ImageHeaderParser.ImageType.GIF;
    }
}
