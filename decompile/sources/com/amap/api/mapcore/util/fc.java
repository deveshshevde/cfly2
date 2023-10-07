package com.amap.api.mapcore.util;

import android.net.Uri;
import android.text.TextUtils;

public abstract class fc extends hd {
    public String getIPV6URL() {
        Uri.Builder buildUpon;
        String str;
        if (TextUtils.isEmpty(getURL())) {
            return getURL();
        }
        String url = getURL();
        Uri parse = Uri.parse(url);
        if (parse.getAuthority().startsWith("dualstack-")) {
            return url;
        }
        if (parse.getAuthority().startsWith("restsdk.amap.com")) {
            buildUpon = parse.buildUpon();
            str = "dualstack-arestapi.amap.com";
        } else {
            buildUpon = parse.buildUpon();
            str = "dualstack-" + parse.getAuthority();
        }
        return buildUpon.authority(str).build().toString();
    }

    public boolean isSupportIPV6() {
        return true;
    }
}
