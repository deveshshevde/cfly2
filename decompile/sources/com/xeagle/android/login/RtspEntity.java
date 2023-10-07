package com.xeagle.android.login;

import kotlin.jvm.internal.h;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public final class RtspEntity {
    private String transport;
    private String url;

    public RtspEntity(String str, String str2) {
        h.d(str, IjkMediaPlayer.OnNativeInvokeListener.ARG_URL);
        h.d(str2, "transport");
        this.url = str;
        this.transport = str2;
    }

    public static /* synthetic */ RtspEntity copy$default(RtspEntity rtspEntity, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = rtspEntity.url;
        }
        if ((i2 & 2) != 0) {
            str2 = rtspEntity.transport;
        }
        return rtspEntity.copy(str, str2);
    }

    public final String component1() {
        return this.url;
    }

    public final String component2() {
        return this.transport;
    }

    public final RtspEntity copy(String str, String str2) {
        h.d(str, IjkMediaPlayer.OnNativeInvokeListener.ARG_URL);
        h.d(str2, "transport");
        return new RtspEntity(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RtspEntity)) {
            return false;
        }
        RtspEntity rtspEntity = (RtspEntity) obj;
        return h.a((Object) this.url, (Object) rtspEntity.url) && h.a((Object) this.transport, (Object) rtspEntity.transport);
    }

    public final String getTransport() {
        return this.transport;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.url;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.transport;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final void setTransport(String str) {
        h.d(str, "<set-?>");
        this.transport = str;
    }

    public final void setUrl(String str) {
        h.d(str, "<set-?>");
        this.url = str;
    }

    public String toString() {
        return "RtspEntity(url=" + this.url + ", transport=" + this.transport + ")";
    }
}
