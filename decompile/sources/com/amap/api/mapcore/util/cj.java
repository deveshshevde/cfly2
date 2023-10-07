package com.amap.api.mapcore.util;

import android.text.TextUtils;
import com.blankj.utilcode.util.NotificationUtils;
import com.xeagle.android.login.pickImage.Constants;
import com.xeagle.android.login.retrofitLogin.CameraGlobal;

public final class cj {

    /* renamed from: a  reason: collision with root package name */
    int f8157a;

    /* renamed from: b  reason: collision with root package name */
    int[] f8158b;

    /* renamed from: c  reason: collision with root package name */
    int f8159c;

    /* renamed from: d  reason: collision with root package name */
    int f8160d;

    /* renamed from: e  reason: collision with root package name */
    String f8161e;

    /* renamed from: f  reason: collision with root package name */
    String f8162f;

    /* renamed from: g  reason: collision with root package name */
    String f8163g;

    public cj(int i2, int[] iArr, String str, String str2, String str3) {
        int i3;
        this.f8157a = i2;
        this.f8158b = iArr;
        this.f8161e = str;
        this.f8162f = str2;
        this.f8163g = str3;
        str = TextUtils.isEmpty(str) ? str2 : str;
        this.f8159c = NotificationUtils.IMPORTANCE_UNSPECIFIED;
        if ("regions".equals(str)) {
            i3 = 1001;
        } else if ("water".equals(str)) {
            i3 = 1002;
        } else if ("buildings".equals(str)) {
            i3 = 1003;
        } else if ("roads".equals(str)) {
            i3 = CameraGlobal.SET_VIDEO_EXPROTION;
        } else if ("labels".equals(str)) {
            i3 = 1005;
        } else {
            if ("borders".equals(str)) {
                i3 = Constants.RESULT_CODE_RECORD_VIDEO;
            }
            this.f8160d = (i2 * 1000) + iArr.hashCode();
        }
        this.f8159c = i3;
        this.f8160d = (i2 * 1000) + iArr.hashCode();
    }
}
