package com.amap.api.mapcore.util;

import com.amap.api.maps.AMapException;
import com.autonavi.base.amap.mapcore.tools.GLMapStaticValue;
import com.xeagle.android.login.pickImage.Constants;
import com.xeagle.android.login.retrofitLogin.CameraGlobal;

public final class em extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private String f8537a = "";

    /* renamed from: b  reason: collision with root package name */
    private int f8538b = 1000;

    public em() {
    }

    public em(String str) {
        super(str);
        this.f8537a = str;
        a(str);
    }

    private void a(String str) {
        this.f8538b = "用户签名未通过".equals(str) ? 1001 : "用户key不正确或过期".equals(str) ? 1002 : "请求服务不存在".equals(str) ? 1003 : "访问已超出日访问量".equals(str) ? CameraGlobal.SET_VIDEO_EXPROTION : "用户访问过于频繁".equals(str) ? 1005 : "用户IP无效".equals(str) ? Constants.RESULT_CODE_RECORD_VIDEO : "用户域名无效".equals(str) ? Constants.RESULT_CODE_CHOOSE_VIDEO : "用户MD5安全码未通过".equals(str) ? Constants.RESULT_CODE_CONFIRM_VIDEO : "请求key与绑定平台不符".equals(str) ? Constants.RESULT_CODE_CONFIRM_IMAGE : "IP访问超限".equals(str) ? Constants.RESULT_CODE_GET_IMAGE : "服务不支持https请求".equals(str) ? GLMapStaticValue.AM_PARAMETERNAME_RASTER_ENABLE : "权限不足，服务请求被拒绝".equals(str) ? CameraGlobal.SET_LIGHT_FRQUENCR : "开发者删除了key，key被删除后无法正常使用".equals(str) ? CameraGlobal.SET_FORMAT_SDCARD : "请求服务响应错误".equals(str) ? 1100 : "引擎返回数据异常".equals(str) ? CameraGlobal.SET_REMOTE_TAKEPHOTO : "服务端请求链接超时".equals(str) ? CameraGlobal.SHUT_RTSP : "读取服务结果超时".equals(str) ? 1103 : "请求参数非法".equals(str) ? 1200 : "缺少必填参数".equals(str) ? 1201 : "请求协议非法".equals(str) ? 1202 : "其他未知错误".equals(str) ? 1203 : AMapException.ERROR_PROTOCOL.equals(str) ? 1801 : AMapException.ERROR_SOCKE_TIME_OUT.equals(str) ? 1802 : AMapException.ERROR_URL.equals(str) ? 1803 : AMapException.ERROR_UNKNOW_HOST.equals(str) ? 1804 : "未知错误".equals(str) ? 1900 : AMapException.ERROR_INVALID_PARAMETER.equals(str) ? 1901 : "http或socket连接失败 - ConnectionException".equals(str) ? 1806 : AMapException.ERROR_IO.equals(str) ? 1902 : AMapException.ERROR_NULL_PARAMETER.equals(str) ? 1903 : 1800;
    }

    public final String a() {
        return this.f8537a;
    }
}
