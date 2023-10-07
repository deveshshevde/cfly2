package com.xeagle.android.login.database;

import java.util.Objects;
import org.litepal.crud.LitePalSupport;

public class BatteryInfoData extends LitePalSupport {
    private String batteryActiveTime;
    private String batterySnId;
    private String batteryType;
    private String batteryVersion;

    public BatteryInfoData() {
    }

    public BatteryInfoData(String str, String str2, String str3, String str4) {
        this.batterySnId = str;
        this.batteryActiveTime = str2;
        this.batteryVersion = str3;
        this.batteryType = str4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.batterySnId, ((BatteryInfoData) obj).batterySnId);
    }

    public String getBatteryActiveTime() {
        return this.batteryActiveTime;
    }

    public String getBatterySnId() {
        return this.batterySnId;
    }

    public String getBatteryType() {
        return this.batteryType;
    }

    public String getBatteryVersion() {
        return this.batteryVersion;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.batterySnId, this.batteryActiveTime, this.batteryVersion, this.batteryType});
    }

    public void setBatteryActiveTime(String str) {
        this.batteryActiveTime = str;
    }

    public void setBatterySnId(String str) {
        this.batterySnId = str;
    }

    public void setBatteryType(String str) {
        this.batteryType = str;
    }

    public void setBatteryVersion(String str) {
        this.batteryVersion = str;
    }

    public String toString() {
        return "BatteryInfoData{batterySnId='" + this.batterySnId + '\'' + ", batteryActiveTime='" + this.batteryActiveTime + '\'' + ", batteryVersion='" + this.batteryVersion + '\'' + ", batteryType='" + this.batteryType + '\'' + '}';
    }
}
