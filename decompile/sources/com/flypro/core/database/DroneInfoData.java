package com.flypro.core.database;

import java.util.Objects;
import org.litepal.crud.LitePalSupport;

public class DroneInfoData extends LitePalSupport {
    private String droneActiveTime;
    private String droneSnId;
    private String insuranceTime = "-";
    private String uId = "-";

    public DroneInfoData() {
    }

    public DroneInfoData(String str, String str2, String str3, String str4) {
        this.droneSnId = str;
        this.droneActiveTime = str2;
        this.uId = str3;
        this.insuranceTime = str4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.droneSnId, ((DroneInfoData) obj).droneSnId);
    }

    public String getDroneActiveTime() {
        return this.droneActiveTime;
    }

    public String getDroneSnId() {
        return this.droneSnId;
    }

    public String getInsuranceTime() {
        return this.insuranceTime;
    }

    public String getuId() {
        return this.uId;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.droneSnId, this.droneActiveTime});
    }

    public void setDroneActiveTime(String str) {
        this.droneActiveTime = str;
    }

    public void setDroneSnId(String str) {
        this.droneSnId = str;
    }

    public void setInsuranceTime(String str) {
        this.insuranceTime = str;
    }

    public void setuId(String str) {
        this.uId = str;
    }

    public String toString() {
        return "DroneInfoData{droneSnId='" + this.droneSnId + '\'' + ", droneActiveTime='" + this.droneActiveTime + '\'' + '}';
    }
}
