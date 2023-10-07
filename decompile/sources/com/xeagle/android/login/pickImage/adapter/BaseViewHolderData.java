package com.xeagle.android.login.pickImage.adapter;

public class BaseViewHolderData<T> {
    public static final int DEFAULT_FOOTER_TYPE = -3;
    public static final int DEFAULT_HEADER_TYPE = -2;
    public static final int DEFAULT_VIEW_TYPE = -1;
    private T data;
    private int viewType;

    public BaseViewHolderData() {
        this.viewType = -1;
    }

    public BaseViewHolderData(int i2) {
        this.viewType = i2;
    }

    public BaseViewHolderData(int i2, T t2) {
        this.viewType = i2;
        this.data = t2;
    }

    public T getData() {
        return this.data;
    }

    public int getViewType() {
        return this.viewType;
    }

    public void setData(T t2) {
        this.data = t2;
    }

    public void setViewType(int i2) {
        this.viewType = i2;
    }
}
