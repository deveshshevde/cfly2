package com.google.android.gms.maps.model;

public final class CustomCap extends Cap {

    /* renamed from: a  reason: collision with root package name */
    public final a f18209a;

    /* renamed from: b  reason: collision with root package name */
    public final float f18210b;

    public final String toString() {
        String valueOf = String.valueOf(this.f18209a);
        float f2 = this.f18210b;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 55);
        sb.append("[CustomCap: bitmapDescriptor=");
        sb.append(valueOf);
        sb.append(" refWidth=");
        sb.append(f2);
        sb.append("]");
        return sb.toString();
    }
}
