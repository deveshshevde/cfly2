package com.blankj.utilcode.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsonUtils {
    private static final byte TYPE_BOOLEAN = 0;
    private static final byte TYPE_DOUBLE = 3;
    private static final byte TYPE_INT = 1;
    private static final byte TYPE_JSON_ARRAY = 6;
    private static final byte TYPE_JSON_OBJECT = 5;
    private static final byte TYPE_LONG = 2;
    private static final byte TYPE_STRING = 4;

    private JsonUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String formatJson(String str) {
        return formatJson(str, 4);
    }

    public static String formatJson(String str, int i2) {
        try {
            int length = str.length();
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = str.charAt(i3);
                if (charAt == '{') {
                    return new JSONObject(str).toString(i2);
                }
                if (charAt == '[') {
                    return new JSONArray(str).toString(i2);
                }
                if (!Character.isWhitespace(charAt)) {
                    return str;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return str;
    }

    public static boolean getBoolean(String str, String str2) {
        return getBoolean(str, str2, false);
    }

    public static boolean getBoolean(String str, String str2, boolean z2) {
        return ((Boolean) getValueByType(str, str2, Boolean.valueOf(z2), (byte) 0)).booleanValue();
    }

    public static boolean getBoolean(JSONObject jSONObject, String str) {
        return getBoolean(jSONObject, str, false);
    }

    public static boolean getBoolean(JSONObject jSONObject, String str, boolean z2) {
        return ((Boolean) getValueByType(jSONObject, str, Boolean.valueOf(z2), (byte) 0)).booleanValue();
    }

    public static double getDouble(String str, String str2) {
        return getDouble(str, str2, -1.0d);
    }

    public static double getDouble(String str, String str2, double d2) {
        return ((Double) getValueByType(str, str2, Double.valueOf(d2), (byte) 3)).doubleValue();
    }

    public static double getDouble(JSONObject jSONObject, String str) {
        return getDouble(jSONObject, str, -1.0d);
    }

    public static double getDouble(JSONObject jSONObject, String str, double d2) {
        return ((Double) getValueByType(jSONObject, str, Double.valueOf(d2), (byte) 3)).doubleValue();
    }

    public static int getInt(String str, String str2) {
        return getInt(str, str2, -1);
    }

    public static int getInt(String str, String str2, int i2) {
        return ((Integer) getValueByType(str, str2, Integer.valueOf(i2), (byte) 1)).intValue();
    }

    public static int getInt(JSONObject jSONObject, String str) {
        return getInt(jSONObject, str, -1);
    }

    public static int getInt(JSONObject jSONObject, String str, int i2) {
        return ((Integer) getValueByType(jSONObject, str, Integer.valueOf(i2), (byte) 1)).intValue();
    }

    public static JSONArray getJSONArray(String str, String str2, JSONArray jSONArray) {
        return (JSONArray) getValueByType(str, str2, jSONArray, (byte) 6);
    }

    public static JSONArray getJSONArray(JSONObject jSONObject, String str, JSONArray jSONArray) {
        return (JSONArray) getValueByType(jSONObject, str, jSONArray, (byte) 6);
    }

    public static JSONObject getJSONObject(String str, String str2, JSONObject jSONObject) {
        return (JSONObject) getValueByType(str, str2, jSONObject, (byte) 5);
    }

    public static JSONObject getJSONObject(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        return (JSONObject) getValueByType(jSONObject, str, jSONObject2, (byte) 5);
    }

    public static long getLong(String str, String str2) {
        return getLong(str, str2, -1);
    }

    public static long getLong(String str, String str2, long j2) {
        return ((Long) getValueByType(str, str2, Long.valueOf(j2), (byte) 2)).longValue();
    }

    public static long getLong(JSONObject jSONObject, String str) {
        return getLong(jSONObject, str, -1);
    }

    public static long getLong(JSONObject jSONObject, String str, long j2) {
        return ((Long) getValueByType(jSONObject, str, Long.valueOf(j2), (byte) 2)).longValue();
    }

    public static String getString(String str, String str2) {
        return getString(str, str2, "");
    }

    public static String getString(String str, String str2, String str3) {
        return (String) getValueByType(str, str2, str3, (byte) 4);
    }

    public static String getString(JSONObject jSONObject, String str) {
        return getString(jSONObject, str, "");
    }

    public static String getString(JSONObject jSONObject, String str, String str2) {
        return (String) getValueByType(jSONObject, str, str2, (byte) 4);
    }

    private static <T> T getValueByType(String str, String str2, T t2, byte b2) {
        if (!(str == null || str.length() == 0 || str2 == null || str2.length() == 0)) {
            try {
                return getValueByType(new JSONObject(str), str2, t2, b2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return t2;
    }

    private static <T> T getValueByType(JSONObject jSONObject, String str, T t2, byte b2) {
        if (!(jSONObject == null || str == null || str.length() == 0)) {
            if (b2 == 0) {
                try {
                    return Boolean.valueOf(jSONObject.getBoolean(str));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            } else if (b2 == 1) {
                return Integer.valueOf(jSONObject.getInt(str));
            } else {
                if (b2 == 2) {
                    return Long.valueOf(jSONObject.getLong(str));
                }
                if (b2 == 3) {
                    return Double.valueOf(jSONObject.getDouble(str));
                }
                if (b2 == 4) {
                    return jSONObject.getString(str);
                }
                if (b2 == 5) {
                    return jSONObject.getJSONObject(str);
                }
                if (b2 == 6) {
                    return jSONObject.getJSONArray(str);
                }
            }
        }
        return t2;
    }
}
