package org.jcodec.codecs.h264.io.model;

public enum SliceType {
    P,
    B,
    I,
    SP,
    SI;

    public boolean a() {
        return (this == I || this == SI) ? false : true;
    }
}
