package org.jcodec.codecs.h264;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import nz.b;
import oa.a;
import org.jcodec.codecs.h264.io.model.NALUnitType;
import org.jcodec.codecs.h264.io.model.i;
import org.jcodec.common.model.e;
import org.jcodec.containers.mp4.boxes.aq;
import org.jcodec.containers.mp4.boxes.bj;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static nw.c f32933a = new nw.c();

    /* renamed from: b  reason: collision with root package name */
    private static b f32934b = new b();

    public static int a(int i2) {
        int i3 = i2 & 1;
        return ((i2 >> 1) + i3) * ((i3 << 1) - 1);
    }

    public static int a(i iVar) {
        return (iVar.f33055i + 1) << (iVar.f33072z ^ true ? 1 : 0);
    }

    public static ByteBuffer a(ByteBuffer byteBuffer) {
        b(byteBuffer);
        return c(byteBuffer);
    }

    public static aq a(List<ByteBuffer> list, List<ByteBuffer> list2, int i2) {
        i f2 = f(org.jcodec.common.i.b(list.get(0)));
        return a(new a(f2.f33060n, 0, f2.f33065s, i2, list, list2));
    }

    public static aq a(a aVar) {
        i a2 = i.a(aVar.b().get(0).duplicate());
        int i2 = (a2.f33056j + 1) << 4;
        int a3 = a(a2) << 4;
        if (a2.A) {
            i2 -= (a2.C + a2.B) << a2.f33052f.f33208n[1];
        }
        if (a2.A) {
            a3 -= (a2.E + a2.D) << a2.f33052f.f33209o[1];
        }
        bj a4 = oe.c.a("avc1", new e(i2, a3), "JCodec");
        a4.a((org.jcodec.containers.mp4.boxes.c) aVar);
        return a4;
    }

    public static final void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        byte b2 = byteBuffer.get();
        byte b3 = byteBuffer.get();
        byteBuffer2.put(b2);
        byteBuffer2.put(b3);
        while (byteBuffer.hasRemaining()) {
            byte b4 = byteBuffer.get();
            if (b2 == 0 && b3 == 0 && (b4 & 255) <= 3) {
                byteBuffer2.put((byte) 3);
                b2 = 3;
            } else {
                b2 = b3;
            }
            byteBuffer2.put(b4);
            b3 = b4;
        }
    }

    public static void a(ByteBuffer byteBuffer, List<ByteBuffer> list, List<ByteBuffer> list2) {
        ByteBuffer a2;
        ByteBuffer duplicate = byteBuffer.duplicate();
        while (duplicate.hasRemaining() && (a2 = a(duplicate)) != null) {
            org.jcodec.codecs.h264.io.model.c a3 = org.jcodec.codecs.h264.io.model.c.a(a2);
            if (a3.f33008a == NALUnitType.PPS) {
                if (list2 != null) {
                    list2.add(a2);
                }
            } else if (a3.f33008a == NALUnitType.SPS) {
                if (list != null) {
                    list.add(a2);
                }
            } else if (a3.f33008a == NALUnitType.IDR_SLICE || a3.f33008a == NALUnitType.NON_IDR_SLICE) {
                return;
            }
            byteBuffer.position(duplicate.position());
        }
    }

    public static final void b(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            byte b2 = -1;
            while (byteBuffer.hasRemaining()) {
                b2 = (b2 << 8) | (byteBuffer.get() & 255);
                if ((16777215 & b2) == 1) {
                    byteBuffer.position(byteBuffer.position());
                    return;
                }
            }
        }
    }

    public static final ByteBuffer c(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            return null;
        }
        int position = byteBuffer.position();
        ByteBuffer slice = byteBuffer.slice();
        slice.order(ByteOrder.BIG_ENDIAN);
        byte b2 = -1;
        while (true) {
            if (!byteBuffer.hasRemaining()) {
                break;
            }
            b2 = (b2 << 8) | (byteBuffer.get() & 255);
            if ((16777215 & b2) == 1) {
                byteBuffer.position(byteBuffer.position() - (b2 == 1 ? 4 : 3));
                slice.limit(byteBuffer.position() - position);
            }
        }
        return slice;
    }

    public static final void d(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() >= 2) {
            ByteBuffer duplicate = byteBuffer.duplicate();
            ByteBuffer duplicate2 = byteBuffer.duplicate();
            byte b2 = duplicate.get();
            duplicate2.put(b2);
            byte b3 = duplicate.get();
            duplicate2.put(b3);
            while (duplicate.hasRemaining()) {
                byte b4 = duplicate.get();
                if (b2 != 0 || b3 != 0 || b4 != 3) {
                    duplicate2.put(b4);
                }
                b2 = b3;
                b3 = b4;
            }
            byteBuffer.limit(duplicate2.position());
        }
    }

    public static void e(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        ByteBuffer duplicate2 = byteBuffer.duplicate();
        int position = duplicate2.position();
        while (true) {
            ByteBuffer a2 = a(duplicate);
            if (a2 != null) {
                duplicate2.position(position);
                duplicate2.putInt(a2.remaining());
                position += a2.remaining() + 4;
            } else {
                return;
            }
        }
    }

    public static i f(ByteBuffer byteBuffer) {
        ByteBuffer b2 = org.jcodec.common.i.b(byteBuffer);
        d(b2);
        return i.a(b2);
    }
}
