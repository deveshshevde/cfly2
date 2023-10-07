package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class GeoJSONObject implements Parcelable {
    public static final Parcelable.Creator<GeoJSONObject> CREATOR = new Parcelable.Creator<GeoJSONObject>() {
        /* renamed from: a */
        public GeoJSONObject createFromParcel(Parcel parcel) {
            return GeoJSONObject.a(parcel);
        }

        /* renamed from: a */
        public GeoJSONObject[] newArray(int i2) {
            return new GeoJSONObject[i2];
        }
    };

    public GeoJSONObject() {
    }

    public GeoJSONObject(JSONObject jSONObject) {
    }

    protected static GeoJSONObject a(Parcel parcel) {
        try {
            return a.a(parcel.readString());
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }

    public abstract String a();

    public JSONObject b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", a());
        return jSONObject;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        try {
            parcel.writeString(b().toString());
        } catch (JSONException e2) {
            throw new RuntimeException(e2);
        }
    }
}
