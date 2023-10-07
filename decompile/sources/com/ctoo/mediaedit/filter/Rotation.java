package com.ctoo.mediaedit.filter;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public enum Rotation {
    NORMAL(0),
    ROTATION_90(90),
    ROTATION_180(180),
    ROTATION_270(SubsamplingScaleImageView.ORIENTATION_270);
    

    /* renamed from: e  reason: collision with root package name */
    private final int f10840e;

    private Rotation(int i2) {
        this.f10840e = i2;
    }
}
