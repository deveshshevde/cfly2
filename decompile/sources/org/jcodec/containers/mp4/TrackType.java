package org.jcodec.containers.mp4;

public enum TrackType {
    VIDEO("vide"),
    SOUND("soun"),
    TIMECODE("tmcd"),
    HINT("hint"),
    TEXT("text"),
    HYPER_TEXT("wtxt"),
    CC("clcp"),
    SUB("sbtl"),
    MUSIC("musi"),
    MPEG1("MPEG"),
    SPRITE("sprt"),
    TWEEN("twen"),
    CHAPTERS("chap"),
    THREE_D("qd3d"),
    STREAMING("strm"),
    OBJECTS("obje");
    

    /* renamed from: q  reason: collision with root package name */
    private String f33279q;

    private TrackType(String str) {
        this.f33279q = str;
    }

    public String a() {
        return this.f33279q;
    }
}
