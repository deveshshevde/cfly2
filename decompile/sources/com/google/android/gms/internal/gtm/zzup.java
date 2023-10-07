package com.google.android.gms.internal.gtm;

public enum zzup {
    DOUBLE(0, 1, zzvl.DOUBLE),
    FLOAT(1, 1, zzvl.FLOAT),
    INT64(2, 1, zzvl.LONG),
    UINT64(3, 1, zzvl.LONG),
    INT32(4, 1, zzvl.INT),
    FIXED64(5, 1, zzvl.LONG),
    FIXED32(6, 1, zzvl.INT),
    BOOL(7, 1, zzvl.BOOLEAN),
    STRING(8, 1, zzvl.STRING),
    MESSAGE(9, 1, zzvl.MESSAGE),
    BYTES(10, 1, zzvl.BYTE_STRING),
    UINT32(11, 1, zzvl.INT),
    ENUM(12, 1, zzvl.ENUM),
    SFIXED32(13, 1, zzvl.INT),
    SFIXED64(14, 1, zzvl.LONG),
    SINT32(15, 1, zzvl.INT),
    SINT64(16, 1, zzvl.LONG),
    GROUP(17, 1, zzvl.MESSAGE),
    DOUBLE_LIST(18, 2, zzvl.DOUBLE),
    FLOAT_LIST(19, 2, zzvl.FLOAT),
    INT64_LIST(20, 2, zzvl.LONG),
    UINT64_LIST(21, 2, zzvl.LONG),
    INT32_LIST(22, 2, zzvl.INT),
    FIXED64_LIST(23, 2, zzvl.LONG),
    FIXED32_LIST(24, 2, zzvl.INT),
    BOOL_LIST(25, 2, zzvl.BOOLEAN),
    STRING_LIST(26, 2, zzvl.STRING),
    MESSAGE_LIST(27, 2, zzvl.MESSAGE),
    BYTES_LIST(28, 2, zzvl.BYTE_STRING),
    UINT32_LIST(29, 2, zzvl.INT),
    ENUM_LIST(30, 2, zzvl.ENUM),
    SFIXED32_LIST(31, 2, zzvl.INT),
    SFIXED64_LIST(32, 2, zzvl.LONG),
    SINT32_LIST(33, 2, zzvl.INT),
    SINT64_LIST(34, 2, zzvl.LONG),
    DOUBLE_LIST_PACKED(35, 3, zzvl.DOUBLE),
    FLOAT_LIST_PACKED(36, 3, zzvl.FLOAT),
    INT64_LIST_PACKED(37, 3, zzvl.LONG),
    UINT64_LIST_PACKED(38, 3, zzvl.LONG),
    INT32_LIST_PACKED(39, 3, zzvl.INT),
    FIXED64_LIST_PACKED(40, 3, zzvl.LONG),
    FIXED32_LIST_PACKED(41, 3, zzvl.INT),
    BOOL_LIST_PACKED(42, 3, zzvl.BOOLEAN),
    UINT32_LIST_PACKED(43, 3, zzvl.INT),
    ENUM_LIST_PACKED(44, 3, zzvl.ENUM),
    SFIXED32_LIST_PACKED(45, 3, zzvl.INT),
    SFIXED64_LIST_PACKED(46, 3, zzvl.LONG),
    SINT32_LIST_PACKED(47, 3, zzvl.INT),
    SINT64_LIST_PACKED(48, 3, zzvl.LONG),
    GROUP_LIST(49, 2, zzvl.MESSAGE),
    MAP(50, 4, zzvl.VOID);
    
    private static final zzup[] zzZ = null;
    private final zzvl zzab;
    private final int zzac;
    private final Class<?> zzad;

    static {
        int i2;
        zzZ = new zzup[r1];
        for (zzup zzup : values()) {
            zzZ[zzup.zzac] = zzup;
        }
    }

    private zzup(int i2, int i3, zzvl zzvl) {
        this.zzac = i2;
        this.zzab = zzvl;
        zzvl zzvl2 = zzvl.VOID;
        int i4 = i3 - 1;
        this.zzad = (i4 == 1 || i4 == 3) ? zzvl.zza() : null;
        if (i3 == 1) {
            zzvl.ordinal();
        }
    }

    public final int zza() {
        return this.zzac;
    }
}
