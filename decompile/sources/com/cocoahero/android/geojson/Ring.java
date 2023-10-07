package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONArray;

public class Ring extends PositionList {
    public static final Parcelable.Creator<Ring> CREATOR = new Parcelable.Creator<Ring>() {
        /* renamed from: a */
        public Ring createFromParcel(Parcel parcel) {
            return new Ring(parcel);
        }

        /* renamed from: a */
        public Ring[] newArray(int i2) {
            return new Ring[i2];
        }
    };

    public Ring() {
    }

    protected Ring(Parcel parcel) {
        super(parcel);
    }

    public Ring(JSONArray jSONArray) {
        super(jSONArray);
    }
}
