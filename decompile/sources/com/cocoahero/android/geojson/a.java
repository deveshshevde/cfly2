package com.cocoahero.android.geojson;

import org.json.JSONException;
import org.json.JSONObject;

public class a {
    public static GeoJSONObject a(String str) throws JSONException {
        return a(new JSONObject(str));
    }

    public static GeoJSONObject a(JSONObject jSONObject) {
        String a2 = cr.a.a(jSONObject, "type");
        if ("Point".equalsIgnoreCase(a2)) {
            return new Point(jSONObject);
        }
        if ("MultiPoint".equalsIgnoreCase(a2)) {
            return new MultiPoint(jSONObject);
        }
        if ("LineString".equalsIgnoreCase(a2)) {
            return new LineString(jSONObject);
        }
        if ("MultiLineString".equalsIgnoreCase(a2)) {
            return new MultiLineString(jSONObject);
        }
        if ("Polygon".equalsIgnoreCase(a2)) {
            return new Polygon(jSONObject);
        }
        if ("MultiPolygon".equalsIgnoreCase(a2)) {
            return new MultiPolygon(jSONObject);
        }
        if ("GeometryCollection".equalsIgnoreCase(a2)) {
            return new GeometryCollection(jSONObject);
        }
        if ("Feature".equalsIgnoreCase(a2)) {
            return new Feature(jSONObject);
        }
        if ("FeatureCollection".equalsIgnoreCase(a2)) {
            return new FeatureCollection(jSONObject);
        }
        throw new IllegalArgumentException("The type '" + a2 + "' is not a valid GeoJSON type.");
    }
}
