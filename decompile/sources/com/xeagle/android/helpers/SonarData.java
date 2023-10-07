package com.xeagle.android.helpers;

import java.io.Serializable;

public class SonarData implements Serializable {
    private static final long serialVersionUID = -6528574664112064945L;
    private float bar_alt;
    private float bar_dest;
    private float bar_vel;
    private float sonar_alt;
    private float sonar_dest;
    private float sonar_vel;

    public SonarData(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.bar_alt = f2;
        this.bar_vel = f3;
        this.bar_dest = f4;
        this.sonar_alt = f5;
        this.sonar_vel = f6;
        this.sonar_dest = f7;
    }

    public float getBar_alt() {
        return this.bar_alt;
    }

    public float getBar_dest() {
        return this.bar_dest;
    }

    public float getBar_vel() {
        return this.bar_vel;
    }

    public float getSonar_alt() {
        return this.sonar_alt;
    }

    public float getSonar_dest() {
        return this.sonar_dest;
    }

    public float getSonar_vel() {
        return this.sonar_vel;
    }

    public void setBar_alt(float f2) {
        this.bar_alt = f2;
    }

    public void setBar_dest(float f2) {
        this.bar_dest = f2;
    }

    public void setBar_vel(float f2) {
        this.bar_vel = f2;
    }

    public void setSonar_alt(float f2) {
        this.sonar_alt = f2;
    }

    public void setSonar_dest(float f2) {
        this.sonar_dest = f2;
    }

    public void setSonar_vel(float f2) {
        this.sonar_vel = f2;
    }
}
