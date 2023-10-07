package by;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final List<ImageHeaderParser> f6112a = new ArrayList();

    public synchronized List<ImageHeaderParser> a() {
        return this.f6112a;
    }

    public synchronized void a(ImageHeaderParser imageHeaderParser) {
        this.f6112a.add(imageHeaderParser);
    }
}
