package com.xeagle.android.login.beans;

public class ListenerListBeans {
    private int code;
    private ListenerDataBean data;
    private boolean status;

    public int getCode() {
        return this.code;
    }

    public ListenerDataBean getData() {
        return this.data;
    }

    public boolean isStatus() {
        return this.status;
    }

    public void setCode(int i2) {
        this.code = i2;
    }

    public void setData(ListenerDataBean listenerDataBean) {
        this.data = listenerDataBean;
    }

    public void setStatus(boolean z2) {
        this.status = z2;
    }

    public String toString() {
        return "ListenerListBeans{status=" + this.status + ", code=" + this.code + ", data=" + this.data.toString() + '}';
    }
}
