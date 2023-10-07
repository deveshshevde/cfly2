package com.cocoahero.android.geojson;

import android.os.Parcel;
import android.os.Parcelable;
import cr.a;
import org.json.JSONException;
import org.json.JSONObject;

public class Feature extends GeoJSONObject {
    public static final Parcelable.Creator<Feature> CREATOR = new Parcelable.Creator<Feature>() {
        /* renamed from: a */
        public Feature createFromParcel(Parcel parcel) {
            return (Feature) GeoJSONObject.a(parcel);
        }

        /* renamed from: a */
        public Feature[] newArray(int i2) {
            return new Feature[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f10759a;

    /* renamed from: b  reason: collision with root package name */
    private Geometry f10760b;

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f10761c;

    public Feature() {
    }

    public Feature(JSONObject jSONObject) {
        super(jSONObject);
        this.f10759a = a.a(jSONObject, "id");
        JSONObject optJSONObject = jSONObject.optJSONObject("geometry");
        if (optJSONObject != null) {
            this.f10760b = (Geometry) a.a(optJSONObject);
        }
        this.f10761c = jSONObject.optJSONObject("properties");
    }

    public String a() {
        return "Feature";
    }

    public JSONObject b() throws JSONException {
        JSONObject b2 = super.b();
        b2.put("id", this.f10759a);
        Geometry geometry = this.f10760b;
        b2.put("geometry", geometry != null ? geometry.b() : JSONObject.NULL);
        Object obj = this.f10761c;
        if (obj == null) {
            obj = JSONObject.NULL;
        }
        b2.put("properties", obj);
        return b2;
    }
}
