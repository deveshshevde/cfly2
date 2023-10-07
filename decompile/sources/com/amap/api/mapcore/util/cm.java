package com.amap.api.mapcore.util;

import android.text.TextUtils;
import com.amap.api.maps.AMap;

public final class cm {

    /* renamed from: a  reason: collision with root package name */
    public static final int[][] f8183a = {new int[]{0, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, new int[]{12}, new int[]{1}, new int[]{13}, new int[]{14}, new int[]{15, 16}, new int[]{17, 18, 19, 20, 21, 26, 27, 28}, new int[]{22, 23}, new int[]{24, 25}, new int[]{39, 40, 41}, new int[]{29, 30, 31}, new int[]{32, 33, 34, 35, 36, 37, 38}};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f8184b = {"land", "water", "green", "building", "highway", "arterial", AMap.LOCAL, "railway", "subway", "boundary", "poilabel", "districtlable"};

    /* renamed from: c  reason: collision with root package name */
    public static final String[][] f8185c = {new String[]{"land", "edu", "public", "traffic", "scenicSpot", "culture", "health", "sports", "business", "parkingLot", "subway"}, new String[]{"water"}, new String[]{"green"}, new String[]{"buildings"}, new String[]{"highWay"}, new String[]{"ringRoad", "nationalRoad"}, new String[]{"provincialRoad", "secondaryRoad", "levelThreeRoad", "levelFourRoad", "roadsBeingBuilt", "overPass", "underPass", "other"}, new String[]{"railway", "highSpeedRailway"}, new String[]{"subwayline", "subwayBeingBuilt"}, new String[]{"China", "foreign", "provincial"}, new String[]{"guideBoards", "pois", "aois"}, new String[]{"continent", "country", "province", "city", "district", "town", "village"}};

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f8186d = {"regions", "water", "regions", "buildings", "roads", "roads", "roads", "roads", "roads", "borders", "labels", "labels"};

    public static String[] a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i2 = -1;
        int i3 = 0;
        while (true) {
            String[] strArr = f8184b;
            if (i3 >= strArr.length) {
                break;
            } else if (strArr[i3].equals(str)) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 >= 0) {
            return f8185c[i2];
        }
        return null;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int i2 = -1;
        int i3 = 0;
        while (true) {
            String[] strArr = f8184b;
            if (i3 >= strArr.length) {
                break;
            } else if (strArr[i3].equals(str)) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        if (i2 >= 0) {
            return f8186d[i2];
        }
        return null;
    }
}
