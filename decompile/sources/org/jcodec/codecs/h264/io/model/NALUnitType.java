package org.jcodec.codecs.h264.io.model;

import java.util.EnumSet;
import java.util.Iterator;

public enum NALUnitType {
    NON_IDR_SLICE(1, "non IDR slice"),
    SLICE_PART_A(2, "slice part a"),
    SLICE_PART_B(3, "slice part b"),
    SLICE_PART_C(4, "slice part c"),
    IDR_SLICE(5, "idr slice"),
    SEI(6, "sei"),
    SPS(7, "sequence parameter set"),
    PPS(8, "picture parameter set"),
    ACC_UNIT_DELIM(9, "access unit delimiter"),
    END_OF_SEQ(10, "end of sequence"),
    END_OF_STREAM(11, "end of stream"),
    FILLER_DATA(12, "filter data"),
    SEQ_PAR_SET_EXT(13, "sequence parameter set extension"),
    AUX_SLICE(19, "auxilary slice");
    

    /* renamed from: o  reason: collision with root package name */
    private static final NALUnitType[] f32975o = null;

    /* renamed from: p  reason: collision with root package name */
    private final int f32977p;

    /* renamed from: q  reason: collision with root package name */
    private final String f32978q;

    static {
        f32975o = new NALUnitType[256];
        Iterator it2 = EnumSet.allOf(NALUnitType.class).iterator();
        while (it2.hasNext()) {
            NALUnitType nALUnitType = (NALUnitType) it2.next();
            f32975o[nALUnitType.f32977p] = nALUnitType;
        }
    }

    private NALUnitType(int i2, String str) {
        this.f32977p = i2;
        this.f32978q = str;
    }

    public static NALUnitType a(int i2) {
        NALUnitType[] nALUnitTypeArr = f32975o;
        if (i2 < nALUnitTypeArr.length) {
            return nALUnitTypeArr[i2];
        }
        return null;
    }

    public int a() {
        return this.f32977p;
    }
}
