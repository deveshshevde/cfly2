package nu;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;
import oe.c;
import og.f;
import org.jcodec.common.i;
import org.jcodec.common.j;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.b;
import org.jcodec.containers.mp4.Brand;
import org.jcodec.containers.mp4.TrackType;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private j f31634a;

    /* renamed from: b  reason: collision with root package name */
    private b f31635b;

    /* renamed from: c  reason: collision with root package name */
    private f f31636c = og.b.a(ColorSpace.RGB, this.f31637d.b()[0]);

    /* renamed from: d  reason: collision with root package name */
    private org.jcodec.codecs.h264.b f31637d = new org.jcodec.codecs.h264.b();

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<ByteBuffer> f31638e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<ByteBuffer> f31639f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private oe.b f31640g;

    /* renamed from: h  reason: collision with root package name */
    private ByteBuffer f31641h = ByteBuffer.allocate(12441600);

    /* renamed from: i  reason: collision with root package name */
    private int f31642i;

    /* renamed from: j  reason: collision with root package name */
    private c f31643j;

    public a(File file) throws IOException {
        org.jcodec.common.c a2 = i.a(file);
        this.f31634a = a2;
        c cVar = new c((j) a2, Brand.MP4);
        this.f31643j = cVar;
        this.f31640g = cVar.a(TrackType.VIDEO, 25);
    }

    public void a() throws IOException {
        this.f31640g.a(org.jcodec.codecs.h264.c.a((List<ByteBuffer>) this.f31638e, (List<ByteBuffer>) this.f31639f, 4));
        this.f31643j.a();
        i.a((ReadableByteChannel) this.f31634a);
    }

    public void a(b bVar) throws IOException {
        if (this.f31635b == null) {
            this.f31635b = b.a(bVar.a(), bVar.b(), this.f31637d.b()[0]);
        }
        this.f31636c.a(bVar, this.f31635b);
        this.f31641h.clear();
        ByteBuffer a2 = this.f31637d.a(this.f31635b, this.f31641h);
        this.f31638e.clear();
        this.f31639f.clear();
        org.jcodec.codecs.h264.c.a(a2, (List<ByteBuffer>) this.f31638e, (List<ByteBuffer>) this.f31639f);
        org.jcodec.codecs.h264.c.e(a2);
        oe.b bVar2 = this.f31640g;
        int i2 = this.f31642i;
        bVar2.a(new org.jcodec.containers.mp4.a(a2, (long) i2, 25, 1, (long) i2, true, (org.jcodec.common.model.f) null, (long) i2, 0));
        this.f31642i++;
    }
}
