package com.autonavi.amap.mapcore;

import com.amap.api.mapcore.util.io;

public class Inner_3dMap_locationOption implements Cloneable {
    static String APIKEY = "";
    private static Inner_3dMap_Enum_LocationProtocol locationProtocol = Inner_3dMap_Enum_LocationProtocol.HTTP;
    private long httpTimeOut = ((long) io.f9335i);
    private long interval = 2000;
    private boolean isGpsFirst = false;
    private boolean isKillProcess = false;
    private boolean isLocationCacheEnable = true;
    private boolean isMockEnable = false;
    private boolean isNeedAddress = true;
    private boolean isOffset = true;
    private boolean isOnceLocation = false;
    private boolean isOnceLocationLatest = false;
    private boolean isWifiActiveScan = true;
    private boolean isWifiScan = true;
    private boolean lastWifiActiveScan = true;
    private Inner_3dMap_Enum_LocationMode locationMode = Inner_3dMap_Enum_LocationMode.Hight_Accuracy;
    private boolean sensorEnable = false;

    public enum Inner_3dMap_Enum_LocationMode {
        Battery_Saving,
        Device_Sensors,
        Hight_Accuracy
    }

    public enum Inner_3dMap_Enum_LocationProtocol {
        HTTP(0),
        HTTPS(1);
        
        private int value;

        private Inner_3dMap_Enum_LocationProtocol(int i2) {
            this.value = i2;
        }

        public final int getValue() {
            return this.value;
        }
    }

    private Inner_3dMap_locationOption clone(Inner_3dMap_locationOption inner_3dMap_locationOption) {
        this.interval = inner_3dMap_locationOption.interval;
        this.isOnceLocation = inner_3dMap_locationOption.isOnceLocation;
        this.locationMode = inner_3dMap_locationOption.locationMode;
        this.isMockEnable = inner_3dMap_locationOption.isMockEnable;
        this.isKillProcess = inner_3dMap_locationOption.isKillProcess;
        this.isGpsFirst = inner_3dMap_locationOption.isGpsFirst;
        this.isNeedAddress = inner_3dMap_locationOption.isNeedAddress;
        this.isWifiActiveScan = inner_3dMap_locationOption.isWifiActiveScan;
        this.httpTimeOut = inner_3dMap_locationOption.httpTimeOut;
        this.isOffset = inner_3dMap_locationOption.isOffset;
        this.isLocationCacheEnable = inner_3dMap_locationOption.isLocationCacheEnable;
        this.isOnceLocationLatest = inner_3dMap_locationOption.isOnceLocationLatest;
        this.sensorEnable = inner_3dMap_locationOption.isSensorEnable();
        this.isWifiScan = inner_3dMap_locationOption.isWifiScan();
        return this;
    }

    public static String getAPIKEY() {
        return APIKEY;
    }

    public static void setLocationProtocol(Inner_3dMap_Enum_LocationProtocol inner_3dMap_Enum_LocationProtocol) {
        locationProtocol = inner_3dMap_Enum_LocationProtocol;
    }

    public Inner_3dMap_locationOption clone() {
        try {
            super.clone();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return new Inner_3dMap_locationOption().clone(this);
    }

    public long getHttpTimeOut() {
        return this.httpTimeOut;
    }

    public long getInterval() {
        return this.interval;
    }

    public Inner_3dMap_Enum_LocationMode getLocationMode() {
        return this.locationMode;
    }

    public Inner_3dMap_Enum_LocationProtocol getLocationProtocol() {
        return locationProtocol;
    }

    public boolean isGpsFirst() {
        return this.isGpsFirst;
    }

    public boolean isKillProcess() {
        return this.isKillProcess;
    }

    public boolean isLocationCacheEnable() {
        return this.isLocationCacheEnable;
    }

    public boolean isMockEnable() {
        return this.isMockEnable;
    }

    public boolean isNeedAddress() {
        return this.isNeedAddress;
    }

    public boolean isOffset() {
        return this.isOffset;
    }

    public boolean isOnceLocation() {
        if (this.isOnceLocationLatest) {
            return true;
        }
        return this.isOnceLocation;
    }

    public boolean isOnceLocationLatest() {
        return this.isOnceLocationLatest;
    }

    public boolean isSensorEnable() {
        return this.sensorEnable;
    }

    public boolean isWifiActiveScan() {
        return this.isWifiActiveScan;
    }

    public boolean isWifiScan() {
        return this.isWifiScan;
    }

    public Inner_3dMap_locationOption setGpsFirst(boolean z2) {
        this.isGpsFirst = z2;
        return this;
    }

    public void setHttpTimeOut(long j2) {
        this.httpTimeOut = j2;
    }

    public Inner_3dMap_locationOption setInterval(long j2) {
        if (j2 <= 800) {
            j2 = 800;
        }
        this.interval = j2;
        return this;
    }

    public Inner_3dMap_locationOption setKillProcess(boolean z2) {
        this.isKillProcess = z2;
        return this;
    }

    public void setLocationCacheEnable(boolean z2) {
        this.isLocationCacheEnable = z2;
    }

    public Inner_3dMap_locationOption setLocationMode(Inner_3dMap_Enum_LocationMode inner_3dMap_Enum_LocationMode) {
        this.locationMode = inner_3dMap_Enum_LocationMode;
        return this;
    }

    public void setMockEnable(boolean z2) {
        this.isMockEnable = z2;
    }

    public Inner_3dMap_locationOption setNeedAddress(boolean z2) {
        this.isNeedAddress = z2;
        return this;
    }

    public Inner_3dMap_locationOption setOffset(boolean z2) {
        this.isOffset = z2;
        return this;
    }

    public Inner_3dMap_locationOption setOnceLocation(boolean z2) {
        this.isOnceLocation = z2;
        return this;
    }

    public void setOnceLocationLatest(boolean z2) {
        this.isOnceLocationLatest = z2;
    }

    public void setSensorEnable(boolean z2) {
        this.sensorEnable = z2;
    }

    public void setWifiActiveScan(boolean z2) {
        this.isWifiActiveScan = z2;
        this.lastWifiActiveScan = z2;
    }

    public void setWifiScan(boolean z2) {
        this.isWifiScan = z2;
        this.isWifiActiveScan = z2 ? this.lastWifiActiveScan : false;
    }

    public String toString() {
        return "interval:" + String.valueOf(this.interval) + "#" + "isOnceLocation:" + String.valueOf(this.isOnceLocation) + "#" + "locationMode:" + String.valueOf(this.locationMode) + "#" + "isMockEnable:" + String.valueOf(this.isMockEnable) + "#" + "isKillProcess:" + String.valueOf(this.isKillProcess) + "#" + "isGpsFirst:" + String.valueOf(this.isGpsFirst) + "#" + "isNeedAddress:" + String.valueOf(this.isNeedAddress) + "#" + "isWifiActiveScan:" + String.valueOf(this.isWifiActiveScan) + "#" + "httpTimeOut:" + String.valueOf(this.httpTimeOut) + "#" + "isOffset:" + String.valueOf(this.isOffset) + "#" + "isLocationCacheEnable:" + String.valueOf(this.isLocationCacheEnable) + "#" + "isLocationCacheEnable:" + String.valueOf(this.isLocationCacheEnable) + "#" + "isOnceLocationLatest:" + String.valueOf(this.isOnceLocationLatest) + "#" + "sensorEnable:" + String.valueOf(this.sensorEnable) + "#";
    }
}
