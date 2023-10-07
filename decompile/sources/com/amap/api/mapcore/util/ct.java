package com.amap.api.mapcore.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Locale;
import java.util.Map;

public abstract class ct extends cp {
    public ct() {
        setProxy(fe.a(p.f9676a));
        setConnectionTimeout(5000);
        setSoTimeout(50000);
    }

    protected static String a(String str) {
        String b2 = b(str);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        String a2 = ey.a();
        stringBuffer.append("&ts=".concat(String.valueOf(a2)));
        stringBuffer.append("&scode=" + ey.a(p.f9676a, a2, b2));
        return stringBuffer.toString();
    }

    private static String b(String str) {
        String[] split = str.split("&");
        Arrays.sort(split);
        StringBuffer stringBuffer = new StringBuffer();
        for (String c2 : split) {
            stringBuffer.append(c(c2));
            stringBuffer.append("&");
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.length() > 1 ? (String) stringBuffer2.subSequence(0, stringBuffer2.length() - 1) : str;
    }

    private static String c(String str) {
        String str2;
        if (str == null) {
            return str;
        }
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e2) {
            e = e2;
            str2 = "strReEncoder";
            fz.c(e, "AbstractProtocalHandler", str2);
            return "";
        } catch (Exception e3) {
            e = e3;
            str2 = "strReEncoderException";
            fz.c(e, "AbstractProtocalHandler", str2);
            return "";
        }
    }

    public String getIPV6URL() {
        String url = getURL();
        return (url == null || !url.contains("http://restsdk.amap.com/v4/gridmap?")) ? url : dl.a(url);
    }

    public Map<String, String> getParams() {
        return null;
    }

    public Map<String, String> getRequestHead() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("User-Agent", l.f9556c);
        hashtable.put("Accept-Encoding", "gzip");
        hashtable.put("platinfo", String.format(Locale.US, "platform=Android&sdkversion=%s&product=%s", new Object[]{"8.0.0", "3dmap"}));
        hashtable.put("x-INFO", ey.a(p.f9676a));
        hashtable.put("key", ev.f(p.f9676a));
        hashtable.put("logversion", "2.1");
        return hashtable;
    }

    public boolean isSupportIPV6() {
        String url = getURL();
        return url != null && url.contains("http://restsdk.amap.com/v4/gridmap?");
    }
}
