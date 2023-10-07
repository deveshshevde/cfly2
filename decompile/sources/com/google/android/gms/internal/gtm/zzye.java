package com.google.android.gms.internal.gtm;

public enum zzye {
    DOUBLE(zzyf.DOUBLE, 1),
    FLOAT(zzyf.FLOAT, 5),
    INT64(zzyf.LONG, 0),
    UINT64(zzyf.LONG, 0),
    INT32(zzyf.INT, 0),
    FIXED64(zzyf.LONG, 1),
    FIXED32(zzyf.INT, 5),
    BOOL(zzyf.BOOLEAN, 0),
    STRING(zzyf.STRING, 2),
    GROUP(zzyf.MESSAGE, 3),
    MESSAGE(zzyf.MESSAGE, 2),
    BYTES(zzyf.BYTE_STRING, 2),
    UINT32(zzyf.INT, 0),
    ENUM(zzyf.ENUM, 0),
    SFIXED32(zzyf.INT, 5),
    SFIXED64(zzyf.LONG, 1),
    SINT32(zzyf.INT, 0),
    SINT64(zzyf.LONG, 0);
    
    private final zzyf zzt;

    private zzye(zzyf zzyf, int i2) {
        this.zzt = zzyf;
    }

    public final zzyf zza() {
        return this.zzt;
    }
}
