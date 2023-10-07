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

public class ak extends d {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int[] f26337b = {-1};

    /* renamed from: c  reason: collision with root package name */
    private int f26338c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f26339d = -1;

    /* renamed from: q  reason: collision with root package name */
    private int f26340q;

    public ak() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", a.a(R.raw.tender));
    }

    public void a() {
        super.a();
        GLES20.glDeleteTextures(2, new int[]{this.f26337b[0], this.f26339d}, 0);
        this.f26337b[0] = -1;
        this.f26339d = -1;
    }

    public void b() {
        if (this.f26337b[0] != -1) {
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33984);
        }
        if (this.f26339d != -1) {
            GLES20.glActiveTexture(33988);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33984);
        }
    }

    public void c() {
        if (this.f26337b[0] != -1) {
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(3553, this.f26337b[0]);
            GLES20.glUniform1i(this.f26338c, 3);
        }
        if (this.f26339d != -1) {
            GLES20.glActiveTexture(33988);
            GLES20.glBindTexture(3553, this.f26339d);
            GLES20.glUniform1i(this.f26340q, 4);
        }
    }

    public void d() {
        super.d();
        this.f26338c = GLES20.glGetUniformLocation(j(), "curve");
        this.f26340q = GLES20.glGetUniformLocation(j(), "grey1Frame");
    }

    public void e() {
        super.e();
        a((Runnable) new Runnable() {
            public void run() {
                GLES20.glGenTextures(1, ak.this.f26337b, 0);
                GLES20.glBindTexture(3553, ak.this.f26337b[0]);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
                byte[] bArr = new byte[1024];
                int[] iArr = {10, 12, 14, 15, 17, 19, 21, 22, 24, 26, 28, 29, 31, 33, 35, 38, 40, 41, 43, 45, 47, 48, 50, 52, 53, 55, 57, 58, 60, 61, 63, 65, 66, 68, 69, 71, 72, 74, 75, 77, 79, 80, 81, 83, 84, 86, 87, 89, 92, 93, 94, 96, 97, 99, 100, 101, 103, 104, 105, 107, 108, 109, 110, 112, 113, 114, 116, 117, 118, 119, 120, 122, 123, 124, 125, 126, 127, IChannelListener.CMD_CHANNEL_ERROR_INVALID_TOKEN, IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR, IChannelListener.CMD_CHANNEL_ERROR_BLE_DISABLED, IChannelListener.CMD_CHANNEL_ERROR_BROKEN_CHANNEL, IChannelListener.CMD_CHANNEL_ERROR_WAKEUP, IChannelListener.CMD_CHANNEL_ERROR_CONNECT, IChannelListener.CMD_CHANNEL_NO_MORE_SPACE, IChannelListener.CMD_CHANNEL_CARD_PROTECTED, 138, 139, 140, 141, 142, 143, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 158, 159, GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL, 161, 162, 163, 164, 165, 166, 166, 167, 168, 169, 170, 171, 171, 172, 173, 174, 175, 175, 176, 177, 178, 179, 179, 180, 181, 182, 182, 183, 184, 184, 185, 186, 187, 187, 188, 189, 189, 190, 191, 191, 192, 193, 193, 194, 195, 195, 196, 196, 197, 198, 198, 199, 200, 200, 201, 201, 202, 202, 203, 204, 204, 205, 205, 206, 206, 207, 207, 208, 209, 209, 210, 210, 211, 211, 212, 212, 213, 213, 214, 214, 215, 215, 216, 216, 216, 217, 217, 218, 218, 219, 219, 219, 220, 220, 221, 221, AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 223, 223, 224, 224, 224, 225, 225, 226, 226, 227, 227, 227, 228, 228, 229, 229, 230, 230, 230, 231, 231, 232, 232, 232, 233, 233, 234, 234, 234, 234, 235, 235, 236, 236, 236, 237, 237, 238, 238, 238, 239, 239, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 241, 241, 242, 242};
                int[] iArr2 = {10, 12, 14, 15, 17, 19, 19, 21, 22, 24, 26, 28, 29, 31, 33, 35, 36, 36, 38, 40, 41, 43, 45, 47, 48, 50, 52, 52, 53, 55, 57, 58, 60, 61, 63, 65, 66, 68, 69, 69, 71, 72, 74, 75, 77, 79, 80, 81, 83, 84, 86, 86, 87, 89, 90, 92, 93, 94, 96, 97, 99, 100, 101, 103, 103, 104, 105, 107, 108, 109, 110, 112, 113, 114, 116, 117, 118, 119, 120, 122, 122, 123, 124, 125, 126, 127, IChannelListener.CMD_CHANNEL_ERROR_INVALID_TOKEN, IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR, IChannelListener.CMD_CHANNEL_ERROR_BLE_DISABLED, IChannelListener.CMD_CHANNEL_ERROR_BROKEN_CHANNEL, IChannelListener.CMD_CHANNEL_ERROR_WAKEUP, IChannelListener.CMD_CHANNEL_ERROR_CONNECT, IChannelListener.CMD_CHANNEL_NO_MORE_SPACE, IChannelListener.CMD_CHANNEL_CARD_PROTECTED, 138, 139, 140, 141, 142, 143, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 158, 159, GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL, 161, 162, 163, 164, 165, 166, 166, 167, 168, 169, 170, 171, 171, 172, 173, 174, 175, 175, 176, 177, 178, 179, 179, 180, 181, 182, 182, 183, 184, 184, 185, 186, 187, 187, 188, 189, 190, 191, 191, 192, 193, 193, 194, 195, 195, 196, 196, 197, 198, 198, 199, 200, 200, 201, 201, 202, 202, 204, 204, 205, 205, 206, 206, 207, 207, 208, 209, 209, 210, 210, 211, 211, 212, 213, 213, 214, 214, 215, 215, 216, 216, 217, 217, 218, 218, 219, 219, 220, 220, 221, 221, AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 223, 223, 224, 224, 224, 225, 226, 226, 227, 227, 227, 228, 228, 229, 229, 230, 230, 231, 231, 232, 232, 232, 233, 233, 234, 234, 234, 235, 236, 236, 236, 237, 237, 238, 238, 238, 239, 239, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 241, 241, 242, 242};
                int[] iArr3 = {10, 12, 12, 14, 15, 15, 17, 17, 19, 21, 21, 22, 24, 24, 26, 28, 28, 29, 31, 31, 33, 33, 35, 36, 36, 38, 40, 40, 41, 43, 43, 45, 47, 47, 48, 50, 52, 52, 53, 55, 55, 57, 58, 58, 60, 61, 63, 63, 65, 66, 68, 68, 69, 71, 71, 72, 74, 75, 77, 77, 79, 80, 81, 81, 83, 84, 86, 87, 87, 89, 90, 92, 93, 94, 94, 96, 97, 99, 100, 101, 103, 103, 104, 105, 107, 108, 109, 110, 112, 113, 113, 114, 116, 117, 118, 119, 120, 122, 123, 124, 125, 126, 127, IChannelListener.CMD_CHANNEL_ERROR_INVALID_TOKEN, IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR, IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR, IChannelListener.CMD_CHANNEL_ERROR_BLE_DISABLED, IChannelListener.CMD_CHANNEL_ERROR_BROKEN_CHANNEL, IChannelListener.CMD_CHANNEL_ERROR_WAKEUP, IChannelListener.CMD_CHANNEL_ERROR_CONNECT, IChannelListener.CMD_CHANNEL_NO_MORE_SPACE, IChannelListener.CMD_CHANNEL_CARD_PROTECTED, 138, 139, 140, 141, 142, 143, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 145, 146, 147, 148, 149, 150, 151, 152, 154, 155, 156, 157, 158, 158, 159, GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL, 161, 162, 163, 164, 165, 166, 166, 167, 169, 170, 171, 171, 172, 173, 174, 175, 175, 176, 178, 179, 179, 180, 181, 182, 182, 183, 184, 185, 186, 187, 187, 188, 189, 190, 191, 191, 192, 193, 193, 195, 195, 196, 196, 197, 198, 199, 200, 200, 201, 201, 202, 203, 204, 204, 205, 206, 206, 207, 207, 209, 209, 210, 210, 211, 212, 212, 213, 213, 214, 215, 215, 216, 217, 217, 218, 218, 219, 219, 220, 220, 221, AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 223, 223, 224, 224, 225, 225, 226, 227, 227, 227, 228, 229, 229, 230, 230, 231, 231, 232, 232, 233, 233, 234, 234, 235, 235, 236, 236, 237, 238, 238, 238, 239, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 241, 242, 242};
                int[] iArr4 = {0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8, 8, 9, 9, 10, 10, 10, 11, 11, 11, 12, 12, 13, 13, 13, 14, 14, 14, 15, 15, 16, 16, 16, 17, 17, 17, 18, 18, 18, 19, 19, 20, 20, 20, 21, 21, 21, 22, 22, 23, 23, 23, 24, 24, 24, 25, 25, 25, 25, 26, 26, 27, 27, 28, 28, 28, 28, 29, 29, 30, 29, 31, 31, 31, 31, 32, 32, 33, 33, 34, 34, 34, 34, 35, 35, 36, 36, 37, 37, 37, 38, 38, 39, 39, 39, 40, 40, 40, 41, 42, 42, 43, 43, 44, 44, 45, 45, 45, 46, 47, 47, 48, 48, 49, 50, 51, 51, 52, 52, 53, 53, 54, 55, 55, 56, 57, 57, 58, 59, 60, 60, 61, 62, 63, 63, 64, 65, 66, 67, 68, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 88, 89, 90, 91, 93, 94, 95, 96, 97, 98, 100, 101, 103, 104, 105, 107, 108, 110, 111, 113, 115, 116, 118, 119, 120, 122, 123, 125, 127, 128, IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR, IChannelListener.CMD_CHANNEL_ERROR_BROKEN_CHANNEL, IChannelListener.CMD_CHANNEL_ERROR_CONNECT, IChannelListener.CMD_CHANNEL_NO_MORE_SPACE, IChannelListener.CMD_CHANNEL_START_SESSION_FAILED, 139, 141, 143, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 146, 148, 150, 152, 154, 156, 158, GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL, 163, 165, 167, 169, 171, 173, 175, 178, 180, 182, 185, 187, 189, 192, 194, 197, 199, 201, 204, 206, 209, 211, 214, 216, 219, 221, 224, 226, 229, 232, 234, 236, 239, 241, 245, 247, 250, 252, 255};
                for (int i2 = 0; i2 < 256; i2++) {
                    int i3 = i2 * 4;
                    bArr[i3] = (byte) iArr[i2];
                    bArr[i3 + 1] = (byte) iArr2[i2];
                    bArr[i3 + 2] = (byte) iArr3[i2];
                    bArr[i3 + 3] = (byte) iArr4[i2];
                }
                GLES20.glTexImage2D(3553, 0, 6408, 256, 1, 0, 6408, 5121, ByteBuffer.wrap(bArr));
                int unused = ak.this.f26339d = a.a(b.f10869a, "filter/bluevintage_mask1.jpg");
            }
        });
    }
}
