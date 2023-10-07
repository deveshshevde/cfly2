package oe;

import com.blankj.utilcode.constant.MemoryConstants;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.jcodec.common.i;
import org.jcodec.common.j;
import org.jcodec.common.model.e;
import org.jcodec.containers.mp4.Brand;
import org.jcodec.containers.mp4.TrackType;
import org.jcodec.containers.mp4.b;
import org.jcodec.containers.mp4.boxes.ae;
import org.jcodec.containers.mp4.boxes.aj;
import org.jcodec.containers.mp4.boxes.al;
import org.jcodec.containers.mp4.boxes.bj;
import org.jcodec.containers.mp4.boxes.s;
import org.jcodec.containers.mp4.boxes.y;

public class c {

    /* renamed from: a  reason: collision with root package name */
    protected long f31713a;

    /* renamed from: b  reason: collision with root package name */
    protected j f31714b;

    /* renamed from: c  reason: collision with root package name */
    private List<a> f31715c;

    /* renamed from: d  reason: collision with root package name */
    private int f31716d;

    public c(j jVar, Brand brand) throws IOException {
        this(jVar, brand.a());
    }

    public c(j jVar, s sVar) throws IOException {
        this.f31715c = new ArrayList();
        this.f31716d = 1;
        this.f31714b = jVar;
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        sVar.b(allocate);
        new y("wide", 8).a(allocate);
        new y("mdat", 1).a(allocate);
        this.f31713a = (long) allocate.position();
        allocate.putLong(0);
        allocate.flip();
        jVar.write(allocate);
    }

    private aj a(al alVar) {
        int b2 = this.f31715c.get(0).b();
        long a2 = this.f31715c.get(0).a();
        a c2 = c();
        if (c2 != null) {
            b2 = c2.b();
            a2 = c2.a();
        }
        return new aj(b2, a2, 1.0f, 1.0f, new Date().getTime(), new Date().getTime(), new int[]{65536, 0, 0, 0, 65536, 0, 0, 0, MemoryConstants.GB}, this.f31716d);
    }

    public static bj a(String str, e eVar, String str2) {
        return new bj(new y(str), 0, 0, "jcod", 0, 768, (short) eVar.a(), (short) eVar.b(), 72, 72, 1, str2 != null ? str2 : "jcodec", 24, 1, -1);
    }

    public b a(TrackType trackType, int i2) {
        j jVar = this.f31714b;
        int i3 = this.f31716d;
        this.f31716d = i3 + 1;
        b bVar = new b(jVar, i3, trackType, i2);
        this.f31715c.add(bVar);
        return bVar;
    }

    public void a() throws IOException {
        a(b());
    }

    public void a(ae aeVar) throws IOException {
        b.a(this.f31714b, aeVar);
        this.f31714b.a(this.f31713a);
        i.a((WritableByteChannel) this.f31714b, (this.f31714b.a() - this.f31713a) + 8);
    }

    public ae b() throws IOException {
        ae aeVar = new ae();
        aj a2 = a((al) aeVar);
        aeVar.a(a2);
        for (a a3 : this.f31715c) {
            org.jcodec.containers.mp4.boxes.c a4 = a3.a(a2);
            if (a4 != null) {
                aeVar.a(a4);
            }
        }
        return aeVar;
    }

    public a c() {
        for (a next : this.f31715c) {
            if (next.c()) {
                return next;
            }
        }
        return null;
    }
}
