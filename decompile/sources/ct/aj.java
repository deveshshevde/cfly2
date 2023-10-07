package ct;

import android.opengl.GLES20;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.ctoo.mediaedit.R;
import com.ctoo.mediaedit.filter.a;
import com.ctoo.mediaedit.filter.gpu.b;
import com.xeagle.android.login.amba.connectivity.IChannelListener;
import java.nio.ByteBuffer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public class aj extends d {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int[] f26331b = {-1};

    /* renamed from: c  reason: collision with root package name */
    private int f26332c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f26333d = -1;

    /* renamed from: q  reason: collision with root package name */
    private int f26334q;

    /* renamed from: r  reason: collision with root package name */
    private int f26335r;

    public aj() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", a.a(R.raw.sweets));
    }

    public void a() {
        super.a();
        GLES20.glDeleteTextures(2, new int[]{this.f26331b[0], this.f26333d}, 0);
        this.f26331b[0] = -1;
        this.f26333d = -1;
    }

    public void b() {
        if (this.f26331b[0] != -1) {
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33984);
        }
        if (this.f26333d != -1) {
            GLES20.glActiveTexture(33988);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33984);
        }
    }

    public void c() {
        if (this.f26331b[0] != -1) {
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(3553, this.f26331b[0]);
            GLES20.glUniform1i(this.f26332c, 3);
        }
        if (this.f26333d != -1) {
            GLES20.glActiveTexture(33988);
            GLES20.glBindTexture(3553, this.f26333d);
            GLES20.glUniform1i(this.f26334q, 4);
        }
    }

    public void d() {
        super.d();
        this.f26332c = GLES20.glGetUniformLocation(j(), "curve");
        this.f26334q = GLES20.glGetUniformLocation(j(), "grey1Frame");
        int glGetUniformLocation = GLES20.glGetUniformLocation(j(), "lowPerformance");
        this.f26335r = glGetUniformLocation;
        b(glGetUniformLocation, 1);
    }

    public void e() {
        super.e();
        a((Runnable) new Runnable() {
            public void run() {
                GLES20.glGenTextures(1, aj.this.f26331b, 0);
                GLES20.glBindTexture(3553, aj.this.f26331b[0]);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
                byte[] bArr = new byte[1024];
                int[] iArr = {0, 1, 2, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10, 10, 11, 12, 13, 14, 14, 15, 16, 17, 18, 19, 19, 20, 21, 22, 23, 24, 24, 25, 26, 27, 28, 29, 30, 30, 31, 32, 33, 34, 35, 36, 37, 38, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 71, 72, 73, 74, 75, 76, 77, 79, 80, 81, 82, 83, 84, 86, 87, 88, 89, 90, 92, 93, 94, 95, 96, 98, 99, 100, 101, 103, 104, 105, 106, 108, 109, 110, 111, 113, 114, 115, 116, 118, 119, 120, 121, 123, 124, 125, 126, 128, IChannelListener.CMD_CHANNEL_ERROR_INVALID_TOKEN, IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR, IChannelListener.CMD_CHANNEL_ERROR_BROKEN_CHANNEL, IChannelListener.CMD_CHANNEL_ERROR_WAKEUP, IChannelListener.CMD_CHANNEL_ERROR_CONNECT, IChannelListener.CMD_CHANNEL_NO_MORE_SPACE, IChannelListener.CMD_CHANNEL_START_SESSION_FAILED, 138, 139, 140, 142, 143, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 145, 147, 148, 149, 150, 152, 153, 154, 155, 157, 158, 159, GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL, 161, 163, 164, 165, 166, 167, 169, 170, 171, 172, 173, 174, 176, 177, 178, 179, 180, 181, 182, 183, 184, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 209, 210, 211, 212, 213, 214, 215, 216, 217, 217, 218, 219, 220, 221, AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 223, 224, 225, 226, 227, 227, 228, 229, 230, 230, 231, 232, 233, 234, 234, 235, 236, 237, 237, 238, 239, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 241, 242, 243, 243, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 245, 246, 246, 247, 248, 248, 249, 250, 251, 251, 252, 253, 254, 254, 255};
                for (int i2 = 0; i2 < 256; i2++) {
                    int i3 = i2 * 4;
                    bArr[i3] = (byte) iArr[i2];
                    bArr[i3 + 1] = (byte) iArr[i2];
                    bArr[i3 + 2] = (byte) iArr[i2];
                    bArr[i3 + 3] = (byte) i2;
                }
                GLES20.glTexImage2D(3553, 0, 6408, 256, 1, 0, 6408, 5121, ByteBuffer.wrap(bArr));
                int unused = aj.this.f26333d = a.a(b.f10869a, "filter/rise_mask2.jpg");
            }
        });
    }
}
