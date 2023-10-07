package com.ctoo.mediaedit.utils;

import android.opengl.GLES20;
import java.nio.Buffer;

public enum EasyGlUtils {
    ;

    public static void a() {
        GLES20.glTexParameterf(3553, 10241, 9728.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
    }

    public static void a(int i2, int i3) {
        GLES20.glBindFramebuffer(36160, i2);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i3, 0);
    }

    public static void a(int i2, int[] iArr, int i3, int i4, int i5, int i6) {
        GLES20.glGenTextures(i2, iArr, i3);
        for (int i7 = 0; i7 < i2; i7++) {
            GLES20.glBindTexture(3553, iArr[i7]);
            GLES20.glTexImage2D(3553, 0, i4, i5, i6, 0, i4, 5121, (Buffer) null);
            a();
        }
        GLES20.glBindTexture(3553, 0);
    }

    public static void b() {
        GLES20.glBindFramebuffer(36160, 0);
    }
}
