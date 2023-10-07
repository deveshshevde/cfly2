package fg;

import android.graphics.Color;
import com.xeagle.android.login.amba.connectivity.IChannelListener;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f27208a = {Color.rgb(207, 248, 246), Color.rgb(148, 212, 212), Color.rgb(IChannelListener.CMD_CHANNEL_CARD_PROTECTED, 180, 187), Color.rgb(118, 174, 175), Color.rgb(42, 109, IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR)};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f27209b = {Color.rgb(217, 80, 138), Color.rgb(254, 149, 7), Color.rgb(254, 247, 120), Color.rgb(106, 167, IChannelListener.CMD_CHANNEL_ERROR_CONNECT), Color.rgb(53, 194, 209)};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f27210c = {Color.rgb(64, 89, 128), Color.rgb(149, 165, 124), Color.rgb(217, 184, 162), Color.rgb(191, IChannelListener.CMD_CHANNEL_ERROR_CONNECT, IChannelListener.CMD_CHANNEL_ERROR_CONNECT), Color.rgb(179, 48, 80)};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f27211d = {Color.rgb(193, 37, 82), Color.rgb(255, 102, 0), Color.rgb(245, 199, 0), Color.rgb(106, 150, 31), Color.rgb(179, 100, 53)};

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f27212e = {Color.rgb(192, 255, 140), Color.rgb(255, 247, 140), Color.rgb(255, 208, 140), Color.rgb(140, 234, 255), Color.rgb(255, 140, 157)};

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f27213f = {a("#2ecc71"), a("#f1c40f"), a("#e74c3c"), a("#3498db"), a("#55d8ff"), a("#b9ff53"), a("#00A1AF")};

    public static int a(int i2, int i3) {
        return (i2 & 16777215) | ((i3 & 255) << 24);
    }

    public static int a(String str) {
        int parseLong = (int) Long.parseLong(str.replace("#", ""), 16);
        return Color.rgb((parseLong >> 16) & 255, (parseLong >> 8) & 255, (parseLong >> 0) & 255);
    }
}
