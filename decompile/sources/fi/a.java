package fi;

import com.autonavi.amap.mapcore.AMapEngineUtils;

public abstract class a {
    private int flags;

    public final void addFlag(int i2) {
        this.flags = i2 | this.flags;
    }

    public void clear() {
        this.flags = 0;
    }

    public final void clearFlag(int i2) {
        this.flags = (i2 ^ -1) & this.flags;
    }

    /* access modifiers changed from: protected */
    public final boolean getFlag(int i2) {
        return (this.flags & i2) == i2;
    }

    public final boolean hasSupplementalData() {
        return getFlag(AMapEngineUtils.MAX_P20_WIDTH);
    }

    public final boolean isDecodeOnly() {
        return getFlag(Integer.MIN_VALUE);
    }

    public final boolean isEndOfStream() {
        return getFlag(4);
    }

    public final boolean isKeyFrame() {
        return getFlag(1);
    }

    public final void setFlags(int i2) {
        this.flags = i2;
    }
}
