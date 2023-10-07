package org.jcodec.common.tools;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.xeagle.android.login.amba.connectivity.IChannelListener;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f33254a = {0, 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f33255b = {0, 128, 64, 192, 32, GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL, 96, 224, 16, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 80, 208, 48, 176, 112, GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN, 8, IChannelListener.CMD_CHANNEL_CARD_PROTECTED, 72, 200, 40, 168, 104, 232, 24, 152, 88, 216, 56, 184, 120, 248, 4, IChannelListener.CMD_CHANNEL_ERROR_BROKEN_CHANNEL, 68, 196, 36, 164, 100, 228, 20, 148, 84, 212, 52, 180, 116, IjkMediaMeta.FF_PROFILE_H264_HIGH_444_PREDICTIVE, 12, 140, 76, 204, 44, 172, 108, 236, 28, 156, 92, 220, 60, 188, 124, 252, 2, IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR, 66, 194, 34, 162, 98, 226, 18, 146, 82, 210, 50, 178, 114, 242, 10, 138, 74, 202, 42, 170, 106, 234, 26, 154, 90, 218, 58, 186, 122, 250, 6, IChannelListener.CMD_CHANNEL_ERROR_CONNECT, 70, 198, 38, 166, 102, 230, 22, 150, 86, 214, 54, 182, 118, 246, 14, 142, 78, 206, 46, 174, 110, 238, 30, 158, 94, AMapEngineUtils.ARROW_LINE_OUTER_TEXTURE_ID, 62, 190, 126, 254, 1, IChannelListener.CMD_CHANNEL_ERROR_INVALID_TOKEN, 65, 193, 33, 161, 97, 225, 17, 145, 81, 209, 49, 177, 113, 241, 9, IChannelListener.CMD_CHANNEL_START_SESSION_FAILED, 73, 201, 41, 169, 105, 233, 25, 153, 89, 217, 57, 185, 121, 249, 5, IChannelListener.CMD_CHANNEL_ERROR_WAKEUP, 69, 197, 37, 165, 101, 229, 21, 149, 85, 213, 53, 181, 117, 245, 13, 141, 77, 205, 45, 173, 109, 237, 29, 157, 93, 221, 61, 189, 125, 253, 3, IChannelListener.CMD_CHANNEL_ERROR_BLE_DISABLED, 67, 195, 35, 163, 99, 227, 19, 147, 83, 211, 51, 179, 115, 243, 11, 139, 75, 203, 43, 171, 107, 235, 27, 155, 91, 219, 59, 187, 123, 251, 7, IChannelListener.CMD_CHANNEL_NO_MORE_SPACE, 71, 199, 39, 167, 103, 231, 23, 151, 87, 215, 55, 183, 119, 247, 15, 143, 79, 207, 47, 175, 111, 239, 31, 159, 95, 223, 63, 191, 127, 255};

    public static final int a(int i2) {
        int i3 = i2 >> 31;
        return (i2 ^ i3) - i3;
    }

    public static final int a(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    public static final int b(int i2) {
        if (i2 == 0) {
            return 0;
        }
        return (a(i2) << 1) - ((i2 ^ -1) >>> 31);
    }
}
