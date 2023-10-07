package com.google.protobuf;

public class j {

    /* renamed from: b  reason: collision with root package name */
    private static final f f20145b = f.b();

    /* renamed from: a  reason: collision with root package name */
    protected volatile k f20146a;

    /* renamed from: c  reason: collision with root package name */
    private ByteString f20147c;

    /* renamed from: d  reason: collision with root package name */
    private f f20148d;

    /* renamed from: e  reason: collision with root package name */
    private volatile ByteString f20149e;

    public k a(k kVar) {
        c(kVar);
        return this.f20146a;
    }

    public ByteString b() {
        if (this.f20149e != null) {
            return this.f20149e;
        }
        ByteString byteString = this.f20147c;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            if (this.f20149e != null) {
                ByteString byteString2 = this.f20149e;
                return byteString2;
            }
            this.f20149e = this.f20146a == null ? ByteString.f20030a : this.f20146a.a();
            ByteString byteString3 = this.f20149e;
            return byteString3;
        }
    }

    public k b(k kVar) {
        k kVar2 = this.f20146a;
        this.f20147c = null;
        this.f20149e = null;
        this.f20146a = kVar;
        return kVar2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:15|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3.f20146a = r4;
        r3.f20149e = com.google.protobuf.ByteString.f20030a;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(com.google.protobuf.k r4) {
        /*
            r3 = this;
            com.google.protobuf.k r0 = r3.f20146a
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r3)
            com.google.protobuf.k r0 = r3.f20146a     // Catch:{ all -> 0x0032 }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r3)     // Catch:{ all -> 0x0032 }
            return
        L_0x000c:
            com.google.protobuf.ByteString r0 = r3.f20147c     // Catch:{ InvalidProtocolBufferException -> 0x002a }
            if (r0 == 0) goto L_0x0025
            com.google.protobuf.n r0 = r4.d()     // Catch:{ InvalidProtocolBufferException -> 0x002a }
            com.google.protobuf.ByteString r1 = r3.f20147c     // Catch:{ InvalidProtocolBufferException -> 0x002a }
            com.google.protobuf.f r2 = r3.f20148d     // Catch:{ InvalidProtocolBufferException -> 0x002a }
            java.lang.Object r0 = r0.c(r1, r2)     // Catch:{ InvalidProtocolBufferException -> 0x002a }
            com.google.protobuf.k r0 = (com.google.protobuf.k) r0     // Catch:{ InvalidProtocolBufferException -> 0x002a }
            r3.f20146a = r0     // Catch:{ InvalidProtocolBufferException -> 0x002a }
            com.google.protobuf.ByteString r0 = r3.f20147c     // Catch:{ InvalidProtocolBufferException -> 0x002a }
        L_0x0022:
            r3.f20149e = r0     // Catch:{ InvalidProtocolBufferException -> 0x002a }
            goto L_0x0030
        L_0x0025:
            r3.f20146a = r4     // Catch:{ InvalidProtocolBufferException -> 0x002a }
            com.google.protobuf.ByteString r0 = com.google.protobuf.ByteString.f20030a     // Catch:{ InvalidProtocolBufferException -> 0x002a }
            goto L_0x0022
        L_0x002a:
            r3.f20146a = r4     // Catch:{ all -> 0x0032 }
            com.google.protobuf.ByteString r4 = com.google.protobuf.ByteString.f20030a     // Catch:{ all -> 0x0032 }
            r3.f20149e = r4     // Catch:{ all -> 0x0032 }
        L_0x0030:
            monitor-exit(r3)     // Catch:{ all -> 0x0032 }
            return
        L_0x0032:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0032 }
            goto L_0x0036
        L_0x0035:
            throw r4
        L_0x0036:
            goto L_0x0035
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.j.c(com.google.protobuf.k):void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        k kVar = this.f20146a;
        k kVar2 = jVar.f20146a;
        return (kVar == null && kVar2 == null) ? b().equals(jVar.b()) : (kVar == null || kVar2 == null) ? kVar != null ? kVar.equals(jVar.a(kVar.k())) : a(kVar2.k()).equals(kVar2) : kVar.equals(kVar2);
    }

    public int hashCode() {
        return 1;
    }
}
