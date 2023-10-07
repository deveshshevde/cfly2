package com.xeagle.android.widgets.wheelView.common;

import java.io.Serializable;

public class WheelData implements Serializable {
    private static final long serialVersionUID = 1;

    /* renamed from: a  reason: collision with root package name */
    private int f26142a;

    /* renamed from: b  reason: collision with root package name */
    private String f26143b;

    public int a() {
        return this.f26142a;
    }

    public String b() {
        return this.f26143b;
    }

    public String toString() {
        return "WheelData{" + "id=" + this.f26142a + ", name='" + this.f26143b + '\'' + '}';
    }
}
