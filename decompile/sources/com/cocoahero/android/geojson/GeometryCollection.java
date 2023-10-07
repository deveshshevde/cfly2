package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GeometryCollection extends Geometry {
    public static final Parcelable.Creator<GeometryCollection> CREATOR = new Parcelable.Creator<GeometryCollection>() {
        /* renamed from: a */
        public GeometryCollection createFromParcel(Parcel parcel) {
            return (GeometryCollection) GeoJSONObject.a(parcel);
        }

        /* renamed from: a */
        public GeometryCollection[] newArray(int i2) {
            return new GeometryCollection[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final List<Geometry> f10763a = new ArrayList();

    public GeometryCollection() {
    }

    public GeometryCollection(JSONObject jSONObject) {
        super(jSONObject);
        JSONArray optJSONArray = jSONObject.optJSONArray("geometries");
        if (optJSONArray != null) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject != null) {
                    this.f10763a.add((Geometry) a.a(optJSONObject));
                }
            }
        }
    }

    public String a() {
        return "GeometryCollection";
    }

    public JSONObject b() throws JSONException {
        JSONObject b2 = super.b();
        JSONArray jSONArray = new JSONArray();
        for (Geometry b3 : this.f10763a) {
            jSONArray.put(b3.b());
        }
        b2.put("geometries", jSONArray);
        return b2;
    }
}
