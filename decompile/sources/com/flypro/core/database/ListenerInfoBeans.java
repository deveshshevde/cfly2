package com.flypro.core.database;

public class ListenerInfoBeans {
    private String fly_total_time;
    private String flying_off;

    /* renamed from: id  reason: collision with root package name */
    private int f14147id;
    private boolean isUpload = true;
    private double mileage;
    private String name;
    private float size;

    public String getFly_total_time() {
        return this.fly_total_time;
    }

    public String getFlying_off() {
        return this.flying_off;
    }

    public int getId() {
        return this.f14147id;
    }

    public double getMileage() {
        return this.mileage;
    }

    public String getName() {
        return this.name;
    }

    public float getSize() {
        return this.size;
    }

    public boolean isUpload() {
        return this.isUpload;
    }

    public void setFly_total_time(String str) {
        this.fly_total_time = str;
    }

    public void setFlying_off(String str) {
        this.flying_off = str;
    }

    public void setId(int i2) {
        this.f14147id = i2;
    }

    public void setMileage(double d2) {
        this.mileage = d2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSize(float f2) {
        this.size = f2;
    }

    public void setUpload(boolean z2) {
        this.isUpload = z2;
    }

    public String toString() {
        return "ListenerInfoBeans{id=" + this.f14147id + ", name='" + this.name + '\'' + ", flying_off='" + this.flying_off + '\'' + ", fly_total_time='" + this.fly_total_time + '\'' + ", mileage=" + this.mileage + ", size=" + this.size + '}';
    }
}
