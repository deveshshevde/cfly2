package org.jcodec.containers.mp4.boxes;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.jcodec.common.g;
import org.jcodec.common.i;

public class a extends u {
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public static Set<Integer> f33287w;

    /* renamed from: c  reason: collision with root package name */
    private String f33288c;

    /* renamed from: d  reason: collision with root package name */
    private short f33289d;

    /* renamed from: e  reason: collision with root package name */
    private short f33290e;

    /* renamed from: f  reason: collision with root package name */
    private short f33291f;

    /* renamed from: g  reason: collision with root package name */
    private String f33292g;

    /* renamed from: h  reason: collision with root package name */
    private int f33293h;

    /* renamed from: j  reason: collision with root package name */
    private short f33294j;

    /* renamed from: k  reason: collision with root package name */
    private short f33295k;

    /* renamed from: l  reason: collision with root package name */
    private int f33296l;

    /* renamed from: m  reason: collision with root package name */
    private String f33297m;

    /* renamed from: n  reason: collision with root package name */
    private int f33298n;

    /* renamed from: o  reason: collision with root package name */
    private int f33299o;

    /* renamed from: p  reason: collision with root package name */
    private String f33300p;

    /* renamed from: q  reason: collision with root package name */
    private String f33301q;

    /* renamed from: r  reason: collision with root package name */
    private short f33302r;

    /* renamed from: s  reason: collision with root package name */
    private short f33303s;

    /* renamed from: t  reason: collision with root package name */
    private int f33304t;

    /* renamed from: u  reason: collision with root package name */
    private short f33305u;

    /* renamed from: v  reason: collision with root package name */
    private List<C0242a> f33306v;

    /* renamed from: org.jcodec.containers.mp4.boxes.a$a  reason: collision with other inner class name */
    public static class C0242a {

        /* renamed from: a  reason: collision with root package name */
        short f33307a;

        /* renamed from: b  reason: collision with root package name */
        int f33308b;

        /* renamed from: c  reason: collision with root package name */
        byte[] f33309c;

        public String toString() {
            try {
                return new String(this.f33309c, 0, this.f33308b, a.f33287w.contains(Short.valueOf(this.f33307a)) ? "UTF-16" : "UTF-8");
            } catch (UnsupportedEncodingException unused) {
                return null;
            }
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f33287w = hashSet;
        hashSet.add(14);
        f33287w.add(15);
    }

    public a() {
        super(new y(a(), 0));
    }

    public static String a() {
        return "alis";
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        if ((this.f33539b & 1) == 0) {
            byteBuffer.put(g.a(this.f33288c), 0, 4);
            byteBuffer.putShort(this.f33289d);
            byteBuffer.putShort(this.f33290e);
            byteBuffer.putShort(this.f33291f);
            i.a(byteBuffer, this.f33292g, 27);
            byteBuffer.putInt(this.f33293h);
            byteBuffer.putShort(this.f33294j);
            byteBuffer.putShort(this.f33295k);
            byteBuffer.putInt(this.f33296l);
            i.a(byteBuffer, this.f33297m, 63);
            byteBuffer.putInt(this.f33298n);
            byteBuffer.putInt(this.f33299o);
            byteBuffer.put(g.a(this.f33300p), 0, 4);
            byteBuffer.put(g.a(this.f33301q), 0, 4);
            byteBuffer.putShort(this.f33302r);
            byteBuffer.putShort(this.f33303s);
            byteBuffer.putInt(this.f33304t);
            byteBuffer.putShort(this.f33305u);
            byteBuffer.put(new byte[10]);
            for (C0242a next : this.f33306v) {
                byteBuffer.putShort(next.f33307a);
                byteBuffer.putShort((short) next.f33308b);
                byteBuffer.put(next.f33309c);
            }
            byteBuffer.putShort(-1);
            byteBuffer.putShort(0);
        }
    }
}
