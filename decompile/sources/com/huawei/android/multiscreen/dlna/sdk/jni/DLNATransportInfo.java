package com.huawei.android.multiscreen.dlna.sdk.jni;

public class DLNATransportInfo {

    /* renamed from: a  reason: collision with root package name */
    private int f20848a;

    /* renamed from: b  reason: collision with root package name */
    private int f20849b;

    /* renamed from: c  reason: collision with root package name */
    private int f20850c;

    /* renamed from: d  reason: collision with root package name */
    private String f20851d;

    public enum DlnaTransportStateEnum {
        INVALID,
        STOPPED,
        PLAYING,
        PAUSED_PLAYBACK,
        PAUSED_RECODING,
        NO_MEDIA_PRESENT
    }

    public enum DlnaTransportStatusEnum {
        INVALID,
        OK,
        ERROR_OCCURRED
    }

    public DlnaTransportStateEnum a() {
        int i2 = this.f20849b;
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? DlnaTransportStateEnum.INVALID : DlnaTransportStateEnum.NO_MEDIA_PRESENT : DlnaTransportStateEnum.PAUSED_RECODING : DlnaTransportStateEnum.PAUSED_PLAYBACK : DlnaTransportStateEnum.PLAYING : DlnaTransportStateEnum.STOPPED;
    }

    public DlnaTransportStatusEnum b() {
        int i2 = this.f20850c;
        return i2 != 0 ? i2 != 1 ? DlnaTransportStatusEnum.INVALID : DlnaTransportStatusEnum.ERROR_OCCURRED : DlnaTransportStatusEnum.OK;
    }

    public String toString() {
        return "DLNATransportInfo [returnValue=" + this.f20848a + ", tranState=" + a() + ", tranStatus=" + b() + ", source=" + this.f20851d + "]";
    }
}
