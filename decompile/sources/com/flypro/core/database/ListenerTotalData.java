package com.flypro.core.database;

import org.litepal.crud.LitePalSupport;

public class ListenerTotalData extends LitePalSupport {
    private String totalDegree;
    private String totalFlightTime;
    private String totalMileage;

    public String getTotalDegree() {
        return this.totalDegree;
    }

    public String getTotalFlightTime() {
        return this.totalFlightTime;
    }

    public String getTotalMileage() {
        return this.totalMileage;
    }

    public void setTotalDegree(String str) {
        this.totalDegree = str;
    }

    public void setTotalFlightTime(String str) {
        this.totalFlightTime = str;
    }

    public void setTotalMileage(String str) {
        this.totalMileage = str;
    }

    public String toString() {
        return "ListenerTotalData{totalDegree='" + this.totalDegree + '\'' + ", totalMileage='" + this.totalMileage + '\'' + ", totalFlightTime='" + this.totalFlightTime + '\'' + '}';
    }
}
