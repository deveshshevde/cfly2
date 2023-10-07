package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable;
import fg.i;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;

public class Position implements Parcelable {
    public static final Parcelable.Creator<Position> CREATOR = new Parcelable.Creator<Position>() {
        /* renamed from: a */
        public Position createFromParcel(Parcel parcel) {
            return new Position(parcel);
        }

        /* renamed from: a */
        public Position[] newArray(int i2) {
            return new Position[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final double[] f10770a;

    private Position(Parcel parcel) {
        this(parcel.createDoubleArray());
    }

    public Position(JSONArray jSONArray) {
        double[] dArr = new double[3];
        this.f10770a = dArr;
        dArr[0] = jSONArray.optDouble(0, i.f27244a);
        dArr[1] = jSONArray.optDouble(1, i.f27244a);
        dArr[2] = jSONArray.optDouble(2, i.f27244a);
    }

    public Position(double[] dArr) {
        double[] dArr2 = new double[3];
        this.f10770a = dArr2;
        if (dArr.length == 2) {
            dArr2[0] = dArr[0];
            dArr2[1] = dArr[1];
        } else if (dArr.length == 3) {
            dArr2[0] = dArr[0];
            dArr2[1] = dArr[1];
            dArr2[2] = dArr[2];
        }
    }

    public double a() {
        return this.f10770a[1];
    }

    public double b() {
        return this.f10770a[0];
    }

    public double c() {
        return this.f10770a[2];
    }

    public JSONArray d() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(1, a());
        jSONArray.put(0, b());
        jSONArray.put(2, c());
        return jSONArray;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Position)) {
            return false;
        }
        return Arrays.equals(this.f10770a, ((Position) obj).f10770a);
    }

    public int hashCode() {
        return Arrays.hashCode(this.f10770a);
    }

    public String toString() {
        return Arrays.toString(this.f10770a);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeDoubleArray(this.f10770a);
    }
}
