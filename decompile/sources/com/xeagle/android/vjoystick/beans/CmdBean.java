package com.xeagle.android.vjoystick.beans;

public final class CmdBean {

    /* renamed from: info  reason: collision with root package name */
    private int f24985info;
    private int zoom;

    public CmdBean() {
        this(0, 0, 3, (f) null);
    }

    public CmdBean(int i2, int i3) {
        this.f24985info = i2;
        this.zoom = i3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CmdBean(int i2, int i3, int i4, f fVar) {
        this((i4 & 1) != 0 ? 0 : i2, (i4 & 2) != 0 ? 0 : i3);
    }

    public static /* synthetic */ CmdBean copy$default(CmdBean cmdBean, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = cmdBean.f24985info;
        }
        if ((i4 & 2) != 0) {
            i3 = cmdBean.zoom;
        }
        return cmdBean.copy(i2, i3);
    }

    public final int component1() {
        return this.f24985info;
    }

    public final int component2() {
        return this.zoom;
    }

    public final CmdBean copy(int i2, int i3) {
        return new CmdBean(i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CmdBean)) {
            return false;
        }
        CmdBean cmdBean = (CmdBean) obj;
        return this.f24985info == cmdBean.f24985info && this.zoom == cmdBean.zoom;
    }

    public final int getInfo() {
        return this.f24985info;
    }

    public final int getZoom() {
        return this.zoom;
    }

    public int hashCode() {
        return (this.f24985info * 31) + this.zoom;
    }

    public final void setInfo(int i2) {
        this.f24985info = i2;
    }

    public final void setZoom(int i2) {
        this.zoom = i2;
    }

    public String toString() {
        return "CmdBean(info=" + this.f24985info + ", zoom=" + this.zoom + ")";
    }
}
