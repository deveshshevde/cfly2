package com.amap.api.maps.model.particle;

import java.util.Random;

public class RandomVelocityBetweenTwoConstants extends VelocityGenerate {
    private Random random = new Random();
    private float x1;
    private float x2;
    private float y1;
    private float y2;
    private float z1;
    private float z2;

    public RandomVelocityBetweenTwoConstants(float f2, float f3, float f4, float f5, float f6, float f7) {
        this.x1 = f2;
        this.y1 = f3;
        this.z1 = f4;
        this.x2 = f5;
        this.y2 = f6;
        this.z2 = f7;
        this.type = 0;
    }

    public float getX() {
        float nextFloat = this.random.nextFloat();
        float f2 = this.x2;
        float f3 = this.x1;
        return (nextFloat * (f2 - f3)) + f3;
    }

    public float getY() {
        float nextFloat = this.random.nextFloat();
        float f2 = this.y2;
        float f3 = this.y1;
        return (nextFloat * (f2 - f3)) + f3;
    }

    public float getZ() {
        float nextFloat = this.random.nextFloat();
        float f2 = this.z2;
        float f3 = this.z1;
        return (nextFloat * (f2 - f3)) + f3;
    }
}
