package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Polygon extends Geometry {
    public static final Parcelable.Creator<Polygon> CREATOR = new Parcelable.Creator<Polygon>() {
        /* renamed from: a */
        public Polygon createFromParcel(Parcel parcel) {
            return (Polygon) GeoJSONObject.a(parcel);
        }

        /* renamed from: a */
        public Polygon[] newArray(int i2) {
            return new Polygon[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final List<Ring> f10769a = new ArrayList();

    public Polygon() {
    }

    public Polygon(JSONArray jSONArray) {
        a(jSONArray);
    }

    public Polygon(JSONObject jSONObject) {
        super(jSONObject);
        a(jSONObject.optJSONArray("coordinates"));
    }

    public String a() {
        return "Polygon";
    }

    public void a(JSONArray jSONArray) {
        this.f10769a.clear();
        if (jSONArray != null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONArray optJSONArray = jSONArray.optJSONArray(i2);
                if (optJSONArray != null) {
                    this.f10769a.add(new Ring(optJSONArray));
                }
            }
        }
    }

    public JSONObject b() throws JSONException {
        JSONObject b2 = super.b();
        JSONArray jSONArray = new JSONArray();
        for (Ring b3 : this.f10769a) {
            jSONArray.put(b3.b());
        }
        b2.put("coordinates", jSONArray);
        return b2;
    }

    public List<Ring> c() {
        return this.f10769a;
    }
}
