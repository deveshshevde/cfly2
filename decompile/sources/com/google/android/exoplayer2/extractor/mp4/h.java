package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.q;
import java.nio.ByteBuffer;
import java.util.UUID;

public final class h {

    private static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final UUID f15621a;

        /* renamed from: b  reason: collision with root package name */
        private final int f15622b;

        /* renamed from: c  reason: collision with root package name */
        private final byte[] f15623c;

        public a(UUID uuid, int i2, byte[] bArr) {
            this.f15621a = uuid;
            this.f15622b = i2;
            this.f15623c = bArr;
        }
    }

    public static UUID a(byte[] bArr) {
        a b2 = b(bArr);
        if (b2 == null) {
            return null;
        }
        return b2.f15621a;
    }

    public static byte[] a(UUID uuid, byte[] bArr) {
        return a(uuid, (UUID[]) null, bArr);
    }

    public static byte[] a(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length += (uuidArr.length * 16) + 4;
        }
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length);
        allocate.putInt(1886614376);
        allocate.putInt(uuidArr != null ? 16777216 : 0);
        allocate.putLong(uuid.getMostSignificantBits());
        allocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            allocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                allocate.putLong(uuid2.getMostSignificantBits());
                allocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (!(bArr == null || bArr.length == 0)) {
            allocate.putInt(bArr.length);
            allocate.put(bArr);
        }
        return allocate.array();
    }

    private static a b(byte[] bArr) {
        q qVar = new q(bArr);
        if (qVar.c() < 32) {
            return null;
        }
        qVar.c(0);
        if (qVar.p() != qVar.b() + 4 || qVar.p() != 1886614376) {
            return null;
        }
        int a2 = a.a(qVar.p());
        if (a2 > 1) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Unsupported pssh version: ");
            sb.append(a2);
            k.c("PsshAtomUtil", sb.toString());
            return null;
        }
        UUID uuid = new UUID(qVar.r(), qVar.r());
        if (a2 == 1) {
            qVar.d(qVar.v() * 16);
        }
        int v2 = qVar.v();
        if (v2 != qVar.b()) {
            return null;
        }
        byte[] bArr2 = new byte[v2];
        qVar.a(bArr2, 0, v2);
        return new a(uuid, a2, bArr2);
    }
}
