package oa;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import org.jcodec.common.i;
import org.jcodec.containers.mp4.boxes.c;
import org.jcodec.containers.mp4.boxes.y;

public class a extends c {

    /* renamed from: a  reason: collision with root package name */
    private int f31658a;

    /* renamed from: b  reason: collision with root package name */
    private int f31659b;

    /* renamed from: c  reason: collision with root package name */
    private int f31660c;

    /* renamed from: d  reason: collision with root package name */
    private int f31661d;

    /* renamed from: e  reason: collision with root package name */
    private List<ByteBuffer> f31662e;

    /* renamed from: f  reason: collision with root package name */
    private List<ByteBuffer> f31663f;

    public a() {
        super(new y(a()));
        this.f31662e = new ArrayList();
        this.f31663f = new ArrayList();
    }

    public a(int i2, int i3, int i4, int i5, List<ByteBuffer> list, List<ByteBuffer> list2) {
        this();
        this.f31658a = i2;
        this.f31659b = i3;
        this.f31660c = i4;
        this.f31661d = i5;
        this.f31662e = list;
        this.f31663f = list2;
    }

    public static String a() {
        return "avcC";
    }

    public void a(ByteBuffer byteBuffer) {
        byteBuffer.put((byte) 1);
        byteBuffer.put((byte) this.f31658a);
        byteBuffer.put((byte) this.f31659b);
        byteBuffer.put((byte) this.f31660c);
        byteBuffer.put((byte) -1);
        byteBuffer.put((byte) (this.f31662e.size() | 224));
        for (ByteBuffer next : this.f31662e) {
            byteBuffer.putShort((short) (next.remaining() + 1));
            byteBuffer.put((byte) 103);
            i.a(byteBuffer, next);
        }
        byteBuffer.put((byte) this.f31663f.size());
        for (ByteBuffer next2 : this.f31663f) {
            byteBuffer.putShort((short) ((byte) (next2.remaining() + 1)));
            byteBuffer.put((byte) 104);
            i.a(byteBuffer, next2);
        }
    }

    public List<ByteBuffer> b() {
        return this.f31662e;
    }
}
