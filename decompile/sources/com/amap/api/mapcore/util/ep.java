package com.amap.api.mapcore.util;

import com.amap.api.maps.AMapException;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public final class ep {

    /* renamed from: a  reason: collision with root package name */
    private static String[] f8544a = {"com.amap.api.trace", "com.amap.api.trace.core"};

    public static int a(List<LatLng> list) {
        int i2 = 0;
        if (list == null || list.size() == 0) {
            return 0;
        }
        int i3 = 0;
        while (i2 < list.size() - 1) {
            LatLng latLng = list.get(i2);
            i2++;
            LatLng latLng2 = list.get(i2);
            if (latLng == null || latLng2 == null) {
                break;
            }
            i3 = (int) (((float) i3) + AMapUtils.calculateLineDistance(latLng, latLng2));
        }
        return i3;
    }

    private static void a(int i2, String str) throws em {
        if (i2 != 0) {
            switch (i2) {
                case 10000:
                    return;
                case 10001:
                    throw new em("用户key不正确或过期");
                case 10002:
                    throw new em("请求服务不存在");
                case 10003:
                    throw new em("访问已超出日访问量");
                case IMediaPlayer.MEDIA_INFO_VIDEO_DECODED_START /*10004*/:
                    throw new em("用户访问过于频繁");
                case IMediaPlayer.MEDIA_INFO_OPEN_INPUT /*10005*/:
                    throw new em("用户IP无效");
                case IMediaPlayer.MEDIA_INFO_FIND_STREAM_INFO /*10006*/:
                    throw new em("用户域名无效");
                case 10007:
                    throw new em("用户签名未通过");
                case 10008:
                    throw new em("用户MD5安全码未通过");
                case IMediaPlayer.MEDIA_INFO_AUDIO_SEEK_RENDERING_START /*10009*/:
                    throw new em("请求key与绑定平台不符");
                case 10010:
                    throw new em("IP访问超限");
                case 10011:
                    throw new em("服务不支持https请求");
                case 10012:
                    throw new em("权限不足，服务请求被拒绝");
                case 10013:
                    throw new em("开发者删除了key，key被删除后无法正常使用");
                default:
                    switch (i2) {
                        case 20000:
                            throw new em("请求参数非法");
                        case IjkMediaPlayer.FFP_PROP_INT64_SELECTED_VIDEO_STREAM /*20001*/:
                            throw new em("缺少必填参数");
                        case IjkMediaPlayer.FFP_PROP_INT64_SELECTED_AUDIO_STREAM /*20002*/:
                            throw new em("请求协议非法");
                        case IjkMediaPlayer.FFP_PROP_INT64_VIDEO_DECODER /*20003*/:
                            throw new em("其他未知错误");
                        default:
                            switch (i2) {
                                case 30000:
                                    throw new em("请求服务响应错误");
                                case 30001:
                                    throw new em("引擎返回数据异常");
                                case 30002:
                                    throw new em("服务端请求链接超时");
                                case 30003:
                                    throw new em("读取服务结果超时");
                                default:
                                    throw new em(str);
                            }
                    }
            }
        }
    }

    public static void a(String str) throws em {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("errcode")) {
                a(jSONObject.getInt("errcode"), jSONObject.getString("errmsg"));
            } else if (!jSONObject.has("status")) {
            } else {
                if (jSONObject.has("infocode")) {
                    String string = jSONObject.getString("status");
                    int i2 = jSONObject.getInt("infocode");
                    if (!"1".equals(string)) {
                        String string2 = jSONObject.getString("info");
                        if ("0".equals(string)) {
                            a(i2, string2);
                        }
                    }
                }
            }
        } catch (JSONException unused) {
            throw new em(AMapException.ERROR_PROTOCOL);
        }
    }
}
