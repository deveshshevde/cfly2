package cr;

import org.json.JSONObject;

public class a {
    public static String a(JSONObject jSONObject, String str) {
        return a(jSONObject, str, (String) null);
    }

    public static String a(JSONObject jSONObject, String str, String str2) {
        if (jSONObject != null) {
            return !jSONObject.isNull(str) ? jSONObject.optString(str, str2) : str2;
        }
        return null;
    }
}
