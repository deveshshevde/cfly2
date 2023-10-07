package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FeatureCollection extends GeoJSONObject {
    public static final Parcelable.Creator<FeatureCollection> CREATOR = new Parcelable.Creator<FeatureCollection>() {
        /* renamed from: a */
        public FeatureCollection createFromParcel(Parcel parcel) {
            return (FeatureCollection) GeoJSONObject.a(parcel);
        }

        /* renamed from: a */
        public FeatureCollection[] newArray(int i2) {
            return new FeatureCollection[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final List<Feature> f10762a = new ArrayList();

    public FeatureCollection() {
    }

    public FeatureCollection(JSONObject jSONObject) {
        super(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("features");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    this.f10762a.add(new Feature(optJSONObject));
                }
            }
        }
    }

    public String a() {
        return "FeatureCollection";
    }

    public JSONObject b() throws JSONException {
        JSONObject b2 = super.b();
        JSONArray jSONArray = new JSONArray();
        for (Feature b3 : this.f10762a) {
            jSONArray.put(b3.b());
        }
        b2.put("features", jSONArray);
        return b2;
    }
}
