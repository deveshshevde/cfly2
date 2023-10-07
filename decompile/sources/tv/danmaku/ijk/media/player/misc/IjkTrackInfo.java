package tv.danmaku.ijk.media.player.misc;

import android.text.TextUtils;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public class IjkTrackInfo implements ITrackInfo {
    private IjkMediaMeta.IjkStreamMeta mStreamMeta;
    private int mTrackType = 0;

    public IjkTrackInfo(IjkMediaMeta.IjkStreamMeta ijkStreamMeta) {
        this.mStreamMeta = ijkStreamMeta;
    }

    public IMediaFormat getFormat() {
        return new IjkMediaFormat(this.mStreamMeta);
    }

    public String getInfoInline() {
        String str;
        StringBuilder sb = new StringBuilder(128);
        int i2 = this.mTrackType;
        if (i2 == 1) {
            sb.append("VIDEO");
            sb.append(", ");
            sb.append(this.mStreamMeta.getCodecShortNameInline());
            sb.append(", ");
            sb.append(this.mStreamMeta.getBitrateInline());
            sb.append(", ");
            str = this.mStreamMeta.getResolutionInline();
        } else if (i2 == 2) {
            sb.append("AUDIO");
            sb.append(", ");
            sb.append(this.mStreamMeta.getCodecShortNameInline());
            sb.append(", ");
            sb.append(this.mStreamMeta.getBitrateInline());
            sb.append(", ");
            str = this.mStreamMeta.getSampleRateInline();
        } else if (i2 != 3) {
            str = i2 != 4 ? "UNKNOWN" : "SUBTITLE";
        } else {
            sb.append("TIMEDTEXT");
            sb.append(", ");
            str = this.mStreamMeta.mLanguage;
        }
        sb.append(str);
        return sb.toString();
    }

    public String getLanguage() {
        IjkMediaMeta.IjkStreamMeta ijkStreamMeta = this.mStreamMeta;
        return (ijkStreamMeta == null || TextUtils.isEmpty(ijkStreamMeta.mLanguage)) ? "und" : this.mStreamMeta.mLanguage;
    }

    public int getTrackType() {
        return this.mTrackType;
    }

    public void setMediaMeta(IjkMediaMeta.IjkStreamMeta ijkStreamMeta) {
        this.mStreamMeta = ijkStreamMeta;
    }

    public void setTrackType(int i2) {
        this.mTrackType = i2;
    }

    public String toString() {
        return getClass().getSimpleName() + '{' + getInfoInline() + "}";
    }
}
