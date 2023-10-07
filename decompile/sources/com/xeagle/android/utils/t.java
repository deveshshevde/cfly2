package com.xeagle.android.utils;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;
import nv.a;
import oe.c;
import og.f;
import org.jcodec.common.i;
import org.jcodec.common.j;
import org.jcodec.common.model.ColorSpace;
import org.jcodec.common.model.b;
import org.jcodec.containers.mp4.Brand;
import org.jcodec.containers.mp4.TrackType;

public class t extends a {

    /* renamed from: a  reason: collision with root package name */
    private int f24522a = 10;

    /* renamed from: b  reason: collision with root package name */
    private j f24523b;

    /* renamed from: c  reason: collision with root package name */
    private b f24524c;

    /* renamed from: d  reason: collision with root package name */
    private f f24525d;

    /* renamed from: e  reason: collision with root package name */
    private org.jcodec.codecs.h264.b f24526e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<ByteBuffer> f24527f;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<ByteBuffer> f24528g;

    /* renamed from: h  reason: collision with root package name */
    private oe.b f24529h;

    /* renamed from: i  reason: collision with root package name */
    private ByteBuffer f24530i;

    /* renamed from: j  reason: collision with root package name */
    private int f24531j;

    /* renamed from: k  reason: collision with root package name */
    private c f24532k;

    public t(File file, int i2) throws IOException {
        super(file);
        this.f24522a = i2;
        org.jcodec.common.c a2 = i.a(file);
        this.f24523b = a2;
        c cVar = new c((j) a2, Brand.MP4);
        this.f24532k = cVar;
        this.f24529h = cVar.a(TrackType.VIDEO, i2);
        this.f24530i = ByteBuffer.allocate(12441600);
        this.f24526e = new org.jcodec.codecs.h264.b();
        this.f24525d = og.b.a(ColorSpace.RGB, this.f24526e.b()[0]);
        this.f24527f = new ArrayList<>();
        this.f24528g = new ArrayList<>();
    }

    public void a() throws IOException {
        this.f24529h.a(org.jcodec.codecs.h264.c.a((List<ByteBuffer>) this.f24527f, (List<ByteBuffer>) this.f24528g, 4));
        this.f24532k.a();
        i.a((ReadableByteChannel) this.f24523b);
    }

    public void a(b bVar) throws IOException {
        if (this.f24524c == null) {
            this.f24524c = b.a(bVar.a(), bVar.b(), this.f24526e.b()[0]);
        }
        this.f24525d.a(bVar, this.f24524c);
        this.f24530i.clear();
        ByteBuffer a2 = this.f24526e.a(this.f24524c, this.f24530i);
        this.f24527f.clear();
        this.f24528g.clear();
        org.jcodec.codecs.h264.c.a(a2, (List<ByteBuffer>) this.f24527f, (List<ByteBuffer>) this.f24528g);
        org.jcodec.codecs.h264.c.e(a2);
        oe.b bVar2 = this.f24529h;
        int i2 = this.f24531j;
        bVar2.a(new org.jcodec.containers.mp4.a(a2, (long) i2, (long) this.f24522a, 1, (long) i2, true, (org.jcodec.common.model.f) null, (long) i2, 0));
        this.f24531j++;
    }
}
