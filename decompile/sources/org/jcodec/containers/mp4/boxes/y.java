package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import org.jcodec.common.g;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public class y {

    /* renamed from: a  reason: collision with root package name */
    private String f33552a;

    /* renamed from: b  reason: collision with root package name */
    private long f33553b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f33554c;

    public y(String str) {
        this.f33552a = str;
    }

    public y(String str, long j2) {
        this.f33553b = j2;
        this.f33552a = str;
    }

    public long a() {
        return (this.f33554c || this.f33553b > IjkMediaMeta.AV_CH_WIDE_RIGHT) ? 16 : 8;
    }

    public void a(int i2) {
        this.f33553b = ((long) i2) + a();
    }

    public void a(ByteBuffer byteBuffer) {
        long j2 = this.f33553b;
        if (j2 > IjkMediaMeta.AV_CH_WIDE_RIGHT) {
            byteBuffer.putInt(1);
        } else {
            byteBuffer.putInt((int) j2);
        }
        byteBuffer.put(g.a(this.f33552a));
        long j3 = this.f33553b;
        if (j3 > IjkMediaMeta.AV_CH_WIDE_RIGHT) {
            byteBuffer.putLong(j3);
        }
    }

    public String b() {
        return this.f33552a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.f33552a;
        String str2 = ((y) obj).f33552a;
        if (str == null) {
            if (str2 != null) {
                return false;
            }
        } else if (!str.equals(str2)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f33552a;
        return 31 + (str == null ? 0 : str.hashCode());
    }
}
