package jp.co.cyberagent.android.gpuimage;

import android.graphics.Bitmap;
import android.hardware.Camera;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import java.nio.IntBuffer;

public class f {
    public static int a(Bitmap bitmap, int i2, boolean z2) {
        int[] iArr = new int[1];
        if (i2 == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        } else {
            GLES20.glBindTexture(3553, i2);
            GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
            iArr[0] = i2;
        }
        if (z2) {
            bitmap.recycle();
        }
        return iArr[0];
    }

    public static int a(String str, int i2) {
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i2);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        Log.d("Load Shader Failed", "Compilation\n" + GLES20.glGetShaderInfoLog(glCreateShader));
        return 0;
    }

    public static int a(String str, String str2) {
        String str3;
        int[] iArr = new int[1];
        int a2 = a(str, 35633);
        if (a2 == 0) {
            str3 = "Vertex Shader Failed";
        } else {
            int a3 = a(str2, 35632);
            if (a3 == 0) {
                str3 = "Fragment Shader Failed";
            } else {
                int glCreateProgram = GLES20.glCreateProgram();
                GLES20.glAttachShader(glCreateProgram, a2);
                GLES20.glAttachShader(glCreateProgram, a3);
                GLES20.glLinkProgram(glCreateProgram);
                GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
                if (iArr[0] <= 0) {
                    str3 = "Linking Failed";
                } else {
                    GLES20.glDeleteShader(a2);
                    GLES20.glDeleteShader(a3);
                    return glCreateProgram;
                }
            }
        }
        Log.d("Load Program", str3);
        return 0;
    }

    public static int a(IntBuffer intBuffer, Camera.Size size, int i2) {
        Camera.Size size2 = size;
        int i3 = i2;
        int[] iArr = new int[1];
        if (i3 == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glTexImage2D(3553, 0, 6408, size2.width, size2.height, 0, 6408, 5121, intBuffer);
        } else {
            GLES20.glBindTexture(3553, i3);
            GLES20.glTexSubImage2D(3553, 0, 0, 0, size2.width, size2.height, 6408, 5121, intBuffer);
            iArr[0] = i3;
        }
        return iArr[0];
    }
}
