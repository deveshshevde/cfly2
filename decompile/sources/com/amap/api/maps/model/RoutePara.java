package com.amap.api.maps.model;

public class RoutePara {
    private int drivingRouteStyle = 0;
    private String endName;
    private LatLng endPoint;
    private String startName;
    private LatLng startPoint;
    private int transitRouteStyle = 0;

    public int getDrivingRouteStyle() {
        return this.drivingRouteStyle;
    }

    public String getEndName() {
        return this.endName;
    }

    public LatLng getEndPoint() {
        return this.endPoint;
    }

    public String getStartName() {
        return this.startName;
    }

    public LatLng getStartPoint() {
        return this.startPoint;
    }

    public int getTransitRouteStyle() {
        return this.transitRouteStyle;
    }

    public void setDrivingRouteStyle(int i2) {
        if (i2 >= 0 && i2 < 9) {
            this.drivingRouteStyle = i2;
        }
    }

    public void setEndName(String str) {
        this.endName = str;
    }

    public void setEndPoint(LatLng latLng) {
        this.endPoint = latLng;
    }

    public void setStartName(String str) {
        this.startName = str;
    }

    public void setStartPoint(LatLng latLng) {
        this.startPoint = latLng;
    }

    public void setTransitRouteStyle(int i2) {
        if (i2 >= 0 && i2 < 6) {
            this.transitRouteStyle = i2;
        }
    }
}
