package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;

public class ap extends al {

    /* renamed from: a  reason: collision with root package name */
    public static final a f33335a = new a();

    public static class a extends d {
        public a() {
            b();
            a("ap4h", bj.class);
            a("apch", bj.class);
            a("apcn", bj.class);
            a("apcs", bj.class);
            a("apco", bj.class);
            a("avc1", bj.class);
            a("cvid", bj.class);
            a("jpeg", bj.class);
            a("smc ", bj.class);
            a("rle ", bj.class);
            a("rpza", bj.class);
            a("kpcd", bj.class);
            a("png ", bj.class);
            a("mjpa", bj.class);
            a("mjpb", bj.class);
            a("SVQ1", bj.class);
            a("SVQ3", bj.class);
            a("mp4v", bj.class);
            a("dvc ", bj.class);
            a("dvcp", bj.class);
            a("gif ", bj.class);
            a("h263", bj.class);
            a("tiff", bj.class);
            a("raw ", bj.class);
            a("2vuY", bj.class);
            a("yuv2", bj.class);
            a("v308", bj.class);
            a("v408", bj.class);
            a("v216", bj.class);
            a("v410", bj.class);
            a("v210", bj.class);
            a("m2v1", bj.class);
            a("m1v1", bj.class);
            a("xd5b", bj.class);
            a("dv5n", bj.class);
            a("jp2h", bj.class);
            a("mjp2", bj.class);
            a("ac-3", b.class);
            a("cac3", b.class);
            a("ima4", b.class);
            a("aac ", b.class);
            a("celp", b.class);
            a("hvxc", b.class);
            a("twvq", b.class);
            a(".mp1", b.class);
            a(".mp2", b.class);
            a("midi", b.class);
            a("apvs", b.class);
            a("alac", b.class);
            a("aach", b.class);
            a("aacl", b.class);
            a("aace", b.class);
            a("aacf", b.class);
            a("aacp", b.class);
            a("aacs", b.class);
            a("samr", b.class);
            a("AUDB", b.class);
            a("ilbc", b.class);
            a("ms\u0000\u0011", b.class);
            a("ms\u00001", b.class);
            a("aes3", b.class);
            a("NONE", b.class);
            a("raw ", b.class);
            a("twos", b.class);
            a("sowt", b.class);
            a("MAC3 ", b.class);
            a("MAC6 ", b.class);
            a("ima4", b.class);
            a("fl32", b.class);
            a("fl64", b.class);
            a("in24", b.class);
            a("in32", b.class);
            a("ulaw", b.class);
            a("alaw", b.class);
            a("dvca", b.class);
            a("QDMC", b.class);
            a("QDM2", b.class);
            a("Qclp", b.class);
            a(".mp3", b.class);
            a("mp4a", b.class);
            a("lpcm", b.class);
            a("tmcd", az.class);
            a("time", az.class);
            a("c608", aq.class);
            a("c708", aq.class);
            a("text", aq.class);
        }
    }

    public ap() {
        this(new y(a()));
    }

    public ap(y yVar) {
        super(yVar);
        this.f33332k = f33335a;
    }

    public ap(aq... aqVarArr) {
        this();
        for (aq add : aqVarArr) {
            this.f33331j.add(add);
        }
    }

    public static String a() {
        return "stsd";
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.putInt(0);
        byteBuffer.putInt(this.f33331j.size());
        super.a(byteBuffer);
    }
}
