package com.cocoahero.android.geojson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class Geometry extends GeoJSONObject {
    public Geometry() {
    }

    public Geometry(JSONObject jSONObject) {
        super(jSONObject);
    }

    public JSONObject b() throws JSONException {
        JSONObject b2 = super.b();
        b2.put("coordinates", new JSONArray());
        return b2;
    }
}
