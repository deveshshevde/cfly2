package com.amap.api.mapcore.util;

import android.opengl.GLES20;

public class cd {

    /* renamed from: a  reason: collision with root package name */
    public int f8126a;

    /* renamed from: b  reason: collision with root package name */
    public int f8127b;

    /* renamed from: c  reason: collision with root package name */
    public int f8128c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8129d;

    public final void a() {
        int i2 = this.f8126a;
        if (i2 >= 0) {
            GLES20.glDeleteProgram(i2);
        }
        int i3 = this.f8127b;
        if (i3 >= 0) {
            GLES20.glDeleteShader(i3);
        }
        int i4 = this.f8128c;
        if (i4 >= 0) {
            GLES20.glDeleteShader(i4);
        }
        this.f8129d = true;
    }
}
