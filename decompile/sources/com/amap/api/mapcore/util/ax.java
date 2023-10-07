package com.amap.api.mapcore.util;

@ge(a = "update_item_download_info")
class ax {
    @gf(a = "mAdcode", b = 6)

    /* renamed from: a  reason: collision with root package name */
    private String f7877a = "";
    @gf(a = "fileLength", b = 5)

    /* renamed from: b  reason: collision with root package name */
    private long f7878b = 0;
    @gf(a = "splitter", b = 2)

    /* renamed from: c  reason: collision with root package name */
    private int f7879c = 0;
    @gf(a = "startPos", b = 5)

    /* renamed from: d  reason: collision with root package name */
    private long f7880d = 0;
    @gf(a = "endPos", b = 5)

    /* renamed from: e  reason: collision with root package name */
    private long f7881e = 0;

    public ax() {
    }

    public ax(String str, long j2, int i2, long j3, long j4) {
        this.f7877a = str;
        this.f7878b = j2;
        this.f7879c = i2;
        this.f7880d = j3;
        this.f7881e = j4;
    }

    public static String a(String str) {
        return "mAdcode" + "='" + str + "'";
    }
}
