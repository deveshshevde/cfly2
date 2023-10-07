package com.xeagle.android.login.beans;

public class FlightAcceptBeans {
    private int flightCount;
    private double flightMileage;
    private String flightTime;

    public FlightAcceptBeans() {
    }

    public FlightAcceptBeans(String str, double d2, int i2) {
        this.flightTime = str;
        this.flightMileage = d2;
        this.flightCount = i2;
    }

    public int getFlightCount() {
        return this.flightCount;
    }

    public double getFlightMileage() {
        return this.flightMileage;
    }

    public String getFlightTime() {
        return this.flightTime;
    }

    public void setFlightCount(int i2) {
        this.flightCount = i2;
    }

    public void setFlightMileage(double d2) {
        this.flightMileage = d2;
    }

    public void setFlightTime(String str) {
        this.flightTime = str;
    }

    public String toString() {
        return "FlightAcceptBeans{flightTime='" + this.flightTime + '\'' + ", flightMileage=" + this.flightMileage + ", flightCount=" + this.flightCount + '}';
    }
}
