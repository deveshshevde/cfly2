package com.xeagle.android.maps.providers;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import fg.i;
import java.util.ArrayList;
import java.util.List;

public class b {
    public static void a(Context context, double d2, double d3) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("google.navigation:q=" + d2 + "," + d3 + "&mode=w"));
        intent.setPackage("com.google.android.apps.maps");
        intent.setFlags(AMapEngineUtils.MAX_P20_WIDTH);
        context.startActivity(intent);
    }

    public static void a(Context context, double d2, double d3, String str, double d4, double d5, String str2) {
        StringBuilder sb = new StringBuilder("amapuri://route/plan?sourceApplication=C-FLY2");
        if (d2 != i.f27244a) {
            sb.append("&sname=");
            sb.append(str);
            sb.append("&slat=");
            sb.append(d2);
            sb.append("&slon=");
            sb.append(d3);
        }
        sb.append("&dlat=");
        sb.append(d4);
        sb.append("&dlon=");
        sb.append(d5);
        sb.append("&dname=");
        sb.append(str2);
        sb.append("&dev=0");
        sb.append("&t=2");
        String sb2 = sb.toString();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setPackage("com.autonavi.minimap");
        intent.setFlags(AMapEngineUtils.MAX_P20_WIDTH);
        intent.setData(Uri.parse(sb2));
        context.startActivity(intent);
    }

    public static boolean a(Context context) {
        return a(context, "com.autonavi.minimap");
    }

    public static boolean a(Context context, String str) {
        List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(0);
        ArrayList arrayList = new ArrayList();
        if (installedPackages != null) {
            for (int i2 = 0; i2 < installedPackages.size(); i2++) {
                arrayList.add(installedPackages.get(i2).packageName);
            }
        }
        return arrayList.contains(str);
    }

    public static void b(Context context, double d2, double d3, String str, double d4, double d5, String str2) {
        StringBuilder sb = new StringBuilder("qqmap://map/routeplan?type=walk&policy=0&referer=C-FLY2");
        if (d2 != i.f27244a) {
            sb.append("&from=");
            sb.append(str);
            sb.append("&fromcoord=");
            sb.append(d2);
            sb.append(",");
            sb.append(d3);
        }
        sb.append("&to=");
        sb.append(str2);
        sb.append("&tocoord=");
        sb.append(d4);
        sb.append(",");
        sb.append(d5);
        String sb2 = sb.toString();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setPackage("com.tencent.map");
        intent.setFlags(AMapEngineUtils.MAX_P20_WIDTH);
        intent.setData(Uri.parse(sb2));
        context.startActivity(intent);
    }

    public static boolean b(Context context) {
        return a(context, "com.baidu.BaiduMap");
    }

    public static void c(Context context, double d2, double d3, String str, double d4, double d5, String str2) {
        StringBuilder sb = new StringBuilder("baidumap://map/direction?mode=walking&");
        if (d2 != i.f27244a) {
            sb.append("origin=latlng:");
            sb.append(d2);
            sb.append(",");
            double d6 = d3;
            sb.append(d3);
            sb.append("|name:");
            String str3 = str;
            sb.append(str);
        }
        sb.append("&destination=latlng:");
        double d7 = d4;
        sb.append(d4);
        sb.append(",");
        sb.append(d5);
        sb.append("|name:");
        sb.append(str2);
        sb.append("&coord_type=wgs84");
        sb.append("&src=com.cfly.uav_pro");
        String sb2 = sb.toString();
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(AMapEngineUtils.MAX_P20_WIDTH);
        intent.setPackage("com.baidu.BaiduMap");
        intent.setData(Uri.parse(sb2));
        Context context2 = context;
        context.startActivity(intent);
    }

    public static boolean c(Context context) {
        return a(context, "com.tencent.map");
    }

    public static boolean d(Context context) {
        return a(context, "com.google.android.apps.maps");
    }
}
