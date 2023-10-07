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

public class ao extends d {
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public int[] f26351b = {-1};

    /* renamed from: c  reason: collision with root package name */
    private int f26352c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f26353d = -1;

    /* renamed from: q  reason: collision with root package name */
    private int f26354q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public int f26355r = -1;

    /* renamed from: s  reason: collision with root package name */
    private int f26356s;

    public ao() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", a.a(R.raw.warm));
    }

    public void a() {
        super.a();
        GLES20.glDeleteTextures(3, new int[]{this.f26351b[0], this.f26353d, this.f26355r}, 0);
        this.f26351b[0] = -1;
        this.f26353d = -1;
        this.f26355r = -1;
    }

    public void b() {
        if (this.f26351b[0] != -1) {
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33984);
        }
        if (this.f26353d != -1) {
            GLES20.glActiveTexture(33988);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33984);
        }
        if (this.f26355r != -1) {
            GLES20.glActiveTexture(33989);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33984);
        }
    }

    public void c() {
        if (this.f26351b[0] != -1) {
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(3553, this.f26351b[0]);
            GLES20.glUniform1i(this.f26352c, 3);
        }
        if (this.f26353d != -1) {
            GLES20.glActiveTexture(33988);
            GLES20.glBindTexture(3553, this.f26353d);
            GLES20.glUniform1i(this.f26354q, 4);
        }
        if (this.f26355r != -1) {
            GLES20.glActiveTexture(33989);
            GLES20.glBindTexture(3553, this.f26355r);
            GLES20.glUniform1i(this.f26356s, 5);
        }
    }

    public void d() {
        super.d();
        this.f26352c = GLES20.glGetUniformLocation(j(), "curve");
        this.f26354q = GLES20.glGetUniformLocation(j(), "layerImage");
        this.f26356s = GLES20.glGetUniformLocation(j(), "greyFrame");
    }

    public void e() {
        super.e();
        a((Runnable) new Runnable() {
            public void run() {
                GLES20.glGenTextures(1, ao.this.f26351b, 0);
                GLES20.glBindTexture(3553, ao.this.f26351b[0]);
                GLES20.glTexParameterf(3553, 10240, 9729.0f);
                GLES20.glTexParameterf(3553, 10241, 9729.0f);
                GLES20.glTexParameterf(3553, 10242, 33071.0f);
                GLES20.glTexParameterf(3553, 10243, 33071.0f);
                byte[] bArr = new byte[2048];
                int[] iArr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 6, 9, 12, 14, 17, 20, 23, 25, 28, 31, 33, 35, 38, 40, 42, 44, 46, 48, 50, 52, 53, 55, 57, 58, 60, 61, 63, 64, 65, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 80, 81, 82, 83, 83, 84, 85, 85, 86, 87, 87, 88, 88, 89, 90, 90, 91, 91, 92, 93, 93, 94, 94, 95, 96, 96, 97, 98, 99, 99, 100, 101, 102, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 114, 115, 116, 117, 119, 120, 121, 123, 124, 126, 127, 128, IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR, IChannelListener.CMD_CHANNEL_ERROR_BLE_DISABLED, IChannelListener.CMD_CHANNEL_ERROR_WAKEUP, IChannelListener.CMD_CHANNEL_NO_MORE_SPACE, IChannelListener.CMD_CHANNEL_CARD_PROTECTED, 138, 139, 141, 143, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 146, 148, 149, 151, 153, 154, 156, 158, 159, 161, 163, 165, 166, 168, 170, 172, 173, 175, 177, 179, 180, 182, 184, 185, 187, 189, 190, 192, 194, 195, 197, 199, 200, 202, 203, 205, 207, 208, 210, 211, 213, 214, 215, 217, 218, 219, 221, AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 223, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 238, 239, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 241, 241, 242, 243, 243, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 245, 245, 246, 246, 247, 247, 248, 248, 249, 249, 249, 250, 250, 250, 251, 251, 251, 251, 252, 252, 252, 252, 253, 253, 253, 253, 253, 253, 254, 254, 254, 254, 254, 254, 254, 254, 255, 255, 255, 255, 255, 255};
                int[] iArr2 = {0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 87, 88, 89, 90, 91, 92, 93, 94, 95, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 123, 124, 125, 126, 127, 128, IChannelListener.CMD_CHANNEL_ERROR_INVALID_TOKEN, IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR, IChannelListener.CMD_CHANNEL_ERROR_BLE_DISABLED, IChannelListener.CMD_CHANNEL_ERROR_BROKEN_CHANNEL, IChannelListener.CMD_CHANNEL_ERROR_WAKEUP, IChannelListener.CMD_CHANNEL_ERROR_CONNECT, IChannelListener.CMD_CHANNEL_ERROR_CONNECT, IChannelListener.CMD_CHANNEL_NO_MORE_SPACE, IChannelListener.CMD_CHANNEL_CARD_PROTECTED, IChannelListener.CMD_CHANNEL_START_SESSION_FAILED, 138, 139, 140, 141, 142, 143, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 145, 146, 147, 148, 149, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 219, 220, 221, AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 235, 236, 237, 238, 239, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 241, 242};
                int[] iArr3 = {9, 10, 11, 11, 12, 13, 14, 15, 16, 16, 17, 18, 19, 20, 21, 21, 22, 23, 24, 25, 26, 26, 27, 28, 29, 30, 31, 31, 32, 33, 34, 35, 36, 36, 37, 38, 39, 40, 40, 41, 42, 43, 44, 45, 45, 46, 47, 48, 49, 50, 50, 51, 52, 53, 54, 55, 55, 56, 57, 58, 59, 60, 60, 61, 62, 63, 64, 65, 66, 66, 67, 68, 69, 70, 71, 71, 72, 73, 74, 75, 76, 76, 77, 78, 79, 80, 81, 81, 82, 83, 84, 85, 86, 87, 87, 88, 89, 90, 91, 92, 93, 93, 94, 95, 96, 97, 98, 98, 99, 100, 101, 102, 103, 104, 104, 105, 106, 107, 108, 109, 110, 110, 111, 112, 113, 114, 115, 116, 116, 117, 118, 119, 120, 121, 122, 123, 123, 124, 125, 126, 127, 128, IChannelListener.CMD_CHANNEL_ERROR_INVALID_TOKEN, IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR, IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR, IChannelListener.CMD_CHANNEL_ERROR_BLE_DISABLED, IChannelListener.CMD_CHANNEL_ERROR_BROKEN_CHANNEL, IChannelListener.CMD_CHANNEL_ERROR_WAKEUP, IChannelListener.CMD_CHANNEL_ERROR_CONNECT, IChannelListener.CMD_CHANNEL_NO_MORE_SPACE, IChannelListener.CMD_CHANNEL_CARD_PROTECTED, IChannelListener.CMD_CHANNEL_START_SESSION_FAILED, IChannelListener.CMD_CHANNEL_START_SESSION_FAILED, 138, 139, 140, 141, 142, 143, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 145, 146, 147, 148, 149, 150, 151, 152, 152, 153, 154, 155, 156, 157, 158, 159, GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL, GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL, 161, 162, 163, 164, 165, 166, 167, 168, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 215, 216, 217, 218, 219, 220, 221, AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 223, 224, 225, 225, 226, 227, 228, 229, 230};
                int[] iArr4 = {0, 0, 1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6, 7, 7, 8, 9, 9, 10, 11, 12, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 28, 29, 30, 31, 33, 34, 35, 37, 38, 40, 41, 42, 44, 45, 47, 48, 50, 51, 53, 54, 56, 58, 59, 61, 62, 64, 65, 67, 69, 70, 72, 73, 75, 77, 78, 80, 82, 83, 85, 86, 88, 90, 91, 93, 94, 96, 98, 99, 101, 102, 104, 105, 107, 108, 110, 111, 113, 114, 116, 117, 119, 120, 122, 123, 124, 126, 127, IChannelListener.CMD_CHANNEL_ERROR_INVALID_TOKEN, IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR, IChannelListener.CMD_CHANNEL_ERROR_BLE_DISABLED, IChannelListener.CMD_CHANNEL_ERROR_WAKEUP, IChannelListener.CMD_CHANNEL_ERROR_CONNECT, IChannelListener.CMD_CHANNEL_CARD_PROTECTED, IChannelListener.CMD_CHANNEL_START_SESSION_FAILED, 138, 140, 141, 142, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 145, 146, 147, 149, 150, 151, 153, 154, 155, 156, 157, 159, GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL, 161, 162, 163, 165, 166, 167, 168, 169, 170, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 203, 204, 205, 206, 207, 208, 208, 209, 210, 211, 212, 212, 213, 214, 215, 216, 216, 217, 218, 218, 219, 220, 221, 221, AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 223, 223, 224, 225, 225, 226, 227, 227, 228, 228, 229, 230, 230, 231, 231, 232, 233, 233, 234, 234, 235, 235, 236, 236, 237, 238, 238, 239, 239, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 241, 241, 242, 242, 243, 243, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 245, 245, 246, 246, 247, 247, 248, 248, 249, 249, 249, 250, 250, 251, 251, 252, 252, 253, 253, 254, 254, 255, 255};
                for (int i2 = 0; i2 < 256; i2++) {
                    int i3 = i2 * 4;
                    bArr[i3] = (byte) iArr[i2];
                    bArr[i3 + 1] = (byte) iArr2[i2];
                    bArr[i3 + 2] = (byte) iArr3[i2];
                    bArr[i3 + 3] = (byte) iArr4[i2];
                }
                int[] iArr5 = {0, 1, 1, 2, 3, 4, 4, 5, 6, 6, 7, 8, 8, 9, 10, 11, 11, 11, 12, 13, 13, 14, 15, 15, 16, 17, 18, 18, 19, 20, 21, 21, 22, 23, 24, 24, 25, 26, 27, 28, 28, 28, 29, 30, 31, 31, 32, 33, 34, 35, 36, 36, 37, 38, 39, 39, 40, 41, 41, 42, 43, 44, 45, 46, 47, 47, 48, 49, 50, 51, 52, 53, 54, 55, 55, 56, 57, 58, 59, 60, 61, 62, 63, 63, 64, 65, 66, 68, 69, 70, 71, 71, 72, 73, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 86, 87, 88, 89, 90, 92, 93, 94, 95, 95, 97, 98, 99, 100, 102, 103, 104, 105, 106, 108, 109, 110, 111, 112, 114, 115, 116, 117, 118, 119, 122, 123, 124, 125, 126, 127, IChannelListener.CMD_CHANNEL_ERROR_INVALID_TOKEN, IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR, IChannelListener.CMD_CHANNEL_ERROR_BLE_DISABLED, IChannelListener.CMD_CHANNEL_ERROR_BROKEN_CHANNEL, IChannelListener.CMD_CHANNEL_ERROR_WAKEUP, IChannelListener.CMD_CHANNEL_ERROR_CONNECT, IChannelListener.CMD_CHANNEL_NO_MORE_SPACE, IChannelListener.CMD_CHANNEL_START_SESSION_FAILED, 138, 139, 141, 142, 143, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 145, 146, 148, 149, 150, 151, 152, 154, 155, 156, 157, 158, 159, 161, 162, 164, 165, 166, 167, 168, 169, 170, 171, 173, 174, 175, 176, 177, 178, 179, 180, 183, 184, 185, 186, 187, 188, 190, 191, 192, 193, 194, 195, 196, 198, 199, 200, 201, 202, 203, 205, 206, 207, 208, 209, 210, 212, 213, 214, 215, 216, 217, 219, 220, 221, AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 223, 224, 226, 227, 228, 229, 230, 231, 233, 234, 235, 236, 237, 239, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 241, 242, 243, 243, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 246, 247, 248, 249, 250, 251, 253, 254, 255, 255, 255, 255, 255, 255, 255, 255};
                int[] iArr6 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 11, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 28, 29, 30, 31, 32, 33, 34, 35, 37, 38, 39, 39, 40, 41, 42, 43, 44, 45, 46, 47, 47, 48, 49, 50, 51, 52, 53, 54, 55, 55, 56, 57, 58, 60, 61, 62, 63, 63, 64, 65, 66, 67, 68, 69, 70, 71, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 80, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 122, 123, 124, 125, 126, 127, 128, IChannelListener.CMD_CHANNEL_ERROR_INVALID_TOKEN, IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR, IChannelListener.CMD_CHANNEL_ERROR_BLE_DISABLED, IChannelListener.CMD_CHANNEL_ERROR_WAKEUP, IChannelListener.CMD_CHANNEL_ERROR_CONNECT, IChannelListener.CMD_CHANNEL_NO_MORE_SPACE, IChannelListener.CMD_CHANNEL_CARD_PROTECTED, IChannelListener.CMD_CHANNEL_START_SESSION_FAILED, 138, 139, 141, 142, 143, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 145, 146, 147, 148, 149, 150, 151, 152, 154, 155, 156, 157, 158, 159, 161, 162, 164, 165, 166, 167, 168, 169, 170, 171, 173, 174, 175, 176, 177, 178, 179, 180, 182, 183, 184, 185, 186, 187, 190, 191, 192, 193, 194, 195, 196, 198, 199, 200, 201, 202, 203, 205, 206, 207, 208, 209, 210, 212, 213, 214, 215, 216, 217, 220, 221, AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 223, 224, 226, 227, 228, 229, 230, 231, 233, 234, 235, 236, 237, 239, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 241, 242, 243, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 246, 247, 249, 250, 251, 253, 254, 255, 255, 255, 255, 255, 255, 255, 255};
                int[] iArr7 = {45, 45, 46, 46, 47, 47, 47, 47, 48, 48, 49, 49, 50, 50, 50, 51, 51, 52, 52, 53, 53, 54, 54, 55, 55, 55, 55, 56, 56, 57, 57, 58, 58, 59, 59, 60, 60, 61, 61, 62, 62, 63, 63, 63, 63, 64, 64, 65, 65, 66, 66, 67, 67, 68, 69, 69, 70, 70, 71, 71, 71, 72, 72, 73, 73, 74, 75, 75, 76, 76, 77, 78, 78, 79, 79, 80, 80, 80, 81, 82, 82, 83, 84, 84, 85, 86, 87, 87, 88, 89, 89, 90, 91, 92, 92, 93, 94, 95, 95, 95, 96, 97, 98, 98, 99, 100, 101, 102, 103, 103, 104, 105, 106, 107, 108, 109, 110, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 122, 123, 124, 125, 126, 127, 128, IChannelListener.CMD_CHANNEL_ERROR_INVALID_TOKEN, IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR, IChannelListener.CMD_CHANNEL_ERROR_BLE_DISABLED, IChannelListener.CMD_CHANNEL_ERROR_BROKEN_CHANNEL, IChannelListener.CMD_CHANNEL_ERROR_WAKEUP, IChannelListener.CMD_CHANNEL_NO_MORE_SPACE, IChannelListener.CMD_CHANNEL_CARD_PROTECTED, IChannelListener.CMD_CHANNEL_START_SESSION_FAILED, 138, 139, 141, 142, 143, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 146, 147, 148, 149, 150, 151, 152, 154, 156, 157, 158, 159, GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL, 161, 162, 165, 166, 167, 168, 169, 170, 171, 173, 175, 176, 177, 178, 179, 180, 182, 183, 184, 186, 187, 188, 190, 191, 192, 193, 194, 195, 196, 198, 199, 200, 201, 202, 203, 205, 206, 207, 208, 209, 210, 212, 213, 214, 215, 216, 217, 217, 219, 220, 221, AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 223, 224, 226, 227, 227, 228, 229, 230, 231, 233, 234, 235, 235, 236, 237, 239, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 241, 241, 242, 243, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 246, 246, 247, 248, 249, 250, 251, 251, 253, 254, 255, 255, 255, 255, 255, 255, 255, 255, 255, 255};
                int[] iArr8 = {0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 8, 8, 8, 9, 9, 10, 10, 10, 11, 11, 11, 12, 12, 13, 13, 13, 14, 14, 14, 15, 15, 16, 16, 16, 17, 17, 17, 18, 18, 18, 19, 19, 20, 20, 20, 21, 21, 21, 22, 22, 23, 23, 23, 24, 24, 24, 25, 25, 25, 25, 26, 26, 27, 27, 28, 28, 28, 28, 29, 29, 30, 29, 31, 31, 31, 31, 32, 32, 33, 33, 34, 34, 34, 34, 35, 35, 36, 36, 37, 37, 37, 38, 38, 39, 39, 39, 40, 40, 40, 41, 42, 42, 43, 43, 44, 44, 45, 45, 45, 46, 47, 47, 48, 48, 49, 50, 51, 51, 52, 52, 53, 53, 54, 55, 55, 56, 57, 57, 58, 59, 60, 60, 61, 62, 63, 63, 64, 65, 66, 67, 68, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 88, 89, 90, 91, 93, 94, 95, 96, 97, 98, 100, 101, 103, 104, 105, 107, 108, 110, 111, 113, 115, 116, 118, 119, 120, 122, 123, 125, 127, 128, IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR, IChannelListener.CMD_CHANNEL_ERROR_BROKEN_CHANNEL, IChannelListener.CMD_CHANNEL_ERROR_CONNECT, IChannelListener.CMD_CHANNEL_NO_MORE_SPACE, IChannelListener.CMD_CHANNEL_START_SESSION_FAILED, 139, 141, 143, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 146, 148, 150, 152, 154, 156, 158, GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL, 163, 165, 167, 169, 171, 173, 175, 178, 180, 182, 185, 187, 189, 192, 194, 197, 199, 201, 204, 206, 209, 211, 214, 216, 219, 221, 224, 226, 229, 232, 234, 236, 239, 241, 245, 247, 250, 252, 255};
                for (int i4 = 0; i4 < 256; i4++) {
                    int i5 = (i4 * 4) + 1024;
                    bArr[i5] = (byte) iArr5[i4];
                    bArr[i5 + 1] = (byte) iArr6[i4];
                    bArr[i5 + 2] = (byte) iArr7[i4];
                    bArr[i5 + 3] = (byte) iArr8[i4];
                }
                GLES20.glTexImage2D(3553, 0, 6408, 256, 2, 0, 6408, 5121, ByteBuffer.wrap(bArr));
                int unused = ao.this.f26353d = a.a(b.f10869a, "filter/warm_layer1.jpg");
                int unused2 = ao.this.f26355r = a.a(b.f10869a, "filter/bluevintage_mask1.jpg");
            }
        });
    }
}
