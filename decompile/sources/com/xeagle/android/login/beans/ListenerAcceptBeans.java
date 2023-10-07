package com.xeagle.android.login.beans;

public class ListenerAcceptBeans {
    private String fileName;
    private float fileSize;
    private float flieUrl;
    private double flightMileage;
    private String flightTime;
    private String startTime;

    public ListenerAcceptBeans() {
    }

    public ListenerAcceptBeans(String str, String str2, double d2, String str3, float f2, float f3) {
        this.startTime = str;
        this.flightTime = str2;
        this.flightMileage = d2;
        this.fileName = str3;
        this.fileSize = f2;
        this.flieUrl = f3;
    }

    public String getFileName() {
        return this.fileName;
    }

    public float getFileSize() {
        return this.fileSize;
    }

    public float getFlieUrl() {
        return this.flieUrl;
    }

    public double getFlightMileage() {
        return this.flightMileage;
    }

    public String getFlightTime() {
        return this.flightTime;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public void setFileSize(float f2) {
        this.fileSize = f2;
    }

    public void setFlieUrl(float f2) {
        this.flieUrl = f2;
    }

    public void setFlightMileage(double d2) {
        this.flightMileage = d2;
    }

    public void setFlightTime(String str) {
        this.flightTime = str;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public String toString() {
        return "ListenerAcceptBeans{startTime='" + this.startTime + '\'' + ", flightTime='" + this.flightTime + '\'' + ", flightMileage=" + this.flightMileage + ", fileName='" + this.fileName + '\'' + ", fileSize=" + this.fileSize + ", flieUrl=" + this.flieUrl + '}';
    }
}
