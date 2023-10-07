package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MultiPoint extends Geometry {
    public static final Parcelable.Creator<MultiPoint> CREATOR = new Parcelable.Creator<MultiPoint>() {
        /* renamed from: a */
        public MultiPoint createFromParcel(Parcel parcel) {
            return (MultiPoint) GeoJSONObject.a(parcel);
        }

        /* renamed from: a */
        public MultiPoint[] newArray(int i2) {
            return new MultiPoint[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final PositionList f10766a = new PositionList();

    public MultiPoint() {
    }

    public MultiPoint(JSONObject jSONObject) {
        super(jSONObject);
        a(jSONObject.optJSONArray("coordinates"));
    }

    public String a() {
        return "MultiPoint";
    }

    public void a(JSONArray jSONArray) {
        this.f10766a.a(jSONArray);
    }

    public JSONObject b() throws JSONException {
        JSONObject b2 = super.b();
        b2.put("coordinates", this.f10766a.b());
        return b2;
    }
}
