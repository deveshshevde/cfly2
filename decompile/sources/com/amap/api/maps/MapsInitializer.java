package com.amap.api.maps;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.mapcore.util.ew;
import com.amap.api.mapcore.util.ez;
import com.amap.api.mapcore.util.gw;
import com.amap.api.mapcore.util.p;

public final class MapsInitializer {
    public static final int HTTP = 1;
    public static final int HTTPS = 2;
    private static boolean closeTileOverlay = false;
    private static ExceptionLogger exceptionLogger = null;
    private static boolean isLoadWorldGridMap = false;
    private static boolean isNeedDownloadCoordinateConvertLibrary = true;
    private static boolean isNetWorkEnable = true;
    private static boolean isPolyline2Enable = true;
    private static boolean isSupportRecycleView = true;
    private static boolean isTerrainEnable = false;
    private static boolean isTextureDestroyedRender = false;
    private static boolean isTextureSizeChangedInvoked = false;
    private static boolean isTextureViewDestorySync = true;
    private static boolean isloadWorldVectorMap = true;
    private static int mProtocol = 1;
    private static String mWorldVectorOfflineMapStyleAssetsPath = "";
    private static String mWorldVectorOfflineMapStyleFilePath = "";
    public static String sdcardDir = "";

    public static void disableCachedMapDataUpdate(boolean z2) {
    }

    public static ExceptionLogger getExceptionLogger() {
        return exceptionLogger;
    }

    public static boolean getNetWorkEnable() {
        return isNetWorkEnable;
    }

    public static boolean getPolyline2Enable() {
        return true;
    }

    public static int getProtocol() {
        return mProtocol;
    }

    public static boolean getTextureDestroyRender() {
        return isTextureDestroyedRender;
    }

    public static boolean getTextureSizeChangedInvoked() {
        return isTextureSizeChangedInvoked;
    }

    public static boolean getTextureViewDestorySync() {
        return isTextureViewDestorySync;
    }

    public static String getVersion() {
        return "8.0.0";
    }

    public static String getWorldVectorOfflineMapStyleAssetsPath() {
        return mWorldVectorOfflineMapStyleAssetsPath;
    }

    public static String getWorldVectorOfflineMapStyleFilePath() {
        return mWorldVectorOfflineMapStyleFilePath;
    }

    public static void initialize(Context context) throws RemoteException {
        if (context != null) {
            p.f9676a = context.getApplicationContext();
        } else {
            Log.w("MapsInitializer", "the context is null");
        }
    }

    public static boolean isDisableCachedMapDataUpdate() {
        return false;
    }

    public static boolean isDownloadCoordinateConvertLibrary() {
        return isNeedDownloadCoordinateConvertLibrary;
    }

    public static boolean isLoadWorldGridMap() {
        return isLoadWorldGridMap;
    }

    public static boolean isLoadWorldVectorMap() {
        return isloadWorldVectorMap;
    }

    public static boolean isSupportRecycleView() {
        return isSupportRecycleView;
    }

    public static boolean isTerrainEnable() {
        return isTerrainEnable;
    }

    public static void loadWorldGridMap(boolean z2) {
        isLoadWorldGridMap = z2;
    }

    public static void loadWorldVectorMap(boolean z2) {
        isloadWorldVectorMap = z2;
    }

    public static void setApiKey(String str) {
        if (str != null && str.trim().length() > 0) {
            ew.a(p.f9676a, str);
        }
    }

    public static void setBuildingHeight(int i2) {
    }

    public static void setDownloadCoordinateConvertLibrary(boolean z2) {
        isNeedDownloadCoordinateConvertLibrary = z2;
    }

    public static void setExceptionLogger(ExceptionLogger exceptionLogger2) {
        exceptionLogger = exceptionLogger2;
    }

    public static void setHost(String str) {
        if (TextUtils.isEmpty(str)) {
            gw.f8981a = -1;
            str = "";
        } else {
            gw.f8981a = 1;
        }
        gw.f8982b = str;
    }

    public static void setNetWorkEnable(boolean z2) {
        isNetWorkEnable = z2;
    }

    public static void setPolyline2Enable(boolean z2) {
    }

    public static void setProtocol(int i2) {
        mProtocol = i2;
    }

    public static void setSupportRecycleView(boolean z2) {
        isSupportRecycleView = z2;
    }

    public static void setTerrainEnable(boolean z2) {
        isTerrainEnable = z2;
    }

    public static void setTextureDestroyedRender(boolean z2) {
        isTextureDestroyedRender = z2;
    }

    public static void setTextureSizeChangedInvoked(boolean z2) {
        isTextureSizeChangedInvoked = z2;
    }

    public static void setTextureViewDestorySync(boolean z2) {
        isTextureViewDestorySync = z2;
    }

    public static void setWorldVectorOfflineMapStyleAssetsPath(String str) {
        mWorldVectorOfflineMapStyleAssetsPath = str;
    }

    public static void setWorldVectorOfflineMapStyleFilePath(String str) {
        mWorldVectorOfflineMapStyleFilePath = str;
    }

    public final String getDeviceId(Context context) {
        return ez.v(context);
    }
}
