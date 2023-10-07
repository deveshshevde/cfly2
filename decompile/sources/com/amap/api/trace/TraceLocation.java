package com.amap.api.trace;

public class TraceLocation {

    /* renamed from: a  reason: collision with root package name */
    private double f9852a;

    /* renamed from: b  reason: collision with root package name */
    private double f9853b;

    /* renamed from: c  reason: collision with root package name */
    private float f9854c;

    /* renamed from: d  reason: collision with root package name */
    private float f9855d;

    /* renamed from: e  reason: collision with root package name */
    private long f9856e;

    public TraceLocation() {
    }

    public TraceLocation(double d2, double d3, float f2, float f3, long j2) {
        this.f9852a = a(d2);
        this.f9853b = a(d3);
        this.f9854c = (float) ((int) ((f2 * 3600.0f) / 1000.0f));
        this.f9855d = (float) ((int) f3);
        this.f9856e = j2;
    }

    private static double a(double d2) {
        double round = (double) Math.round(d2 * 1000000.0d);
        Double.isNaN(round);
        return round / 1000000.0d;
    }

    public TraceLocation copy() {
        TraceLocation traceLocation = new TraceLocation();
        traceLocation.f9855d = this.f9855d;
        traceLocation.f9852a = this.f9852a;
        traceLocation.f9853b = this.f9853b;
        traceLocation.f9854c = this.f9854c;
        traceLocation.f9856e = this.f9856e;
        return traceLocation;
    }

    public float getBearing() {
        return this.f9855d;
    }

    public double getLatitude() {
        return this.f9852a;
    }

    public double getLongitude() {
        return this.f9853b;
    }

    public float getSpeed() {
        return this.f9854c;
    }

    public long getTime() {
        return this.f9856e;
    }

    public void setBearing(float f2) {
        this.f9855d = (float) ((int) f2);
    }

    public void setLatitude(double d2) {
        this.f9852a = a(d2);
    }

    public void setLongitude(double d2) {
        this.f9853b = a(d2);
    }

    public void setSpeed(float f2) {
        this.f9854c = (float) ((int) ((f2 * 3600.0f) / 1000.0f));
    }

    public void setTime(long j2) {
        this.f9856e = j2;
    }

    public String toString() {
        return this.f9852a + ",longtitude " + this.f9853b + ",speed " + this.f9854c + ",bearing " + this.f9855d + ",time " + this.f9856e;
    }
}
