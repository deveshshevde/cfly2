package com.autonavi.base.amap.mapcore;

public class LinkInfo {
    private int length = 0;
    private int state = 0;
    private int time = 0;

    public int getLength() {
        return this.length;
    }

    public int getState() {
        return this.state;
    }

    public int getTime() {
        return this.time;
    }

    public void setLength(int i2) {
        this.length = i2;
    }

    public void setState(int i2) {
        this.state = i2;
    }

    public void setTime(int i2) {
        this.time = i2;
    }

    public String toString() {
        return "状态：" + this.state + "|" + "时间：" + this.time + "|" + "长度：" + this.length;
    }
}
