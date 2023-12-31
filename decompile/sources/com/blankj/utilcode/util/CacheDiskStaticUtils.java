package com.blankj.utilcode.util;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

public final class CacheDiskStaticUtils {
    private static CacheDiskUtils sDefaultCacheDiskUtils;

    public static boolean clear() {
        return clear(getDefaultCacheDiskUtils());
    }

    public static boolean clear(CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDiskUtils.clear();
    }

    public static Bitmap getBitmap(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getBitmap(str, getDefaultCacheDiskUtils());
    }

    public static Bitmap getBitmap(String str, Bitmap bitmap) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getBitmap(str, bitmap, getDefaultCacheDiskUtils());
    }

    public static Bitmap getBitmap(String str, Bitmap bitmap, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDiskUtils.getBitmap(str, bitmap);
    }

    public static Bitmap getBitmap(String str, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDiskUtils.getBitmap(str);
    }

    public static byte[] getBytes(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getBytes(str, getDefaultCacheDiskUtils());
    }

    public static byte[] getBytes(String str, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDiskUtils.getBytes(str);
    }

    public static byte[] getBytes(String str, byte[] bArr) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getBytes(str, bArr, getDefaultCacheDiskUtils());
    }

    public static byte[] getBytes(String str, byte[] bArr, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDiskUtils.getBytes(str, bArr);
    }

    public static int getCacheCount() {
        return getCacheCount(getDefaultCacheDiskUtils());
    }

    public static int getCacheCount(CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDiskUtils.getCacheCount();
    }

    public static long getCacheSize() {
        return getCacheSize(getDefaultCacheDiskUtils());
    }

    public static long getCacheSize(CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDiskUtils.getCacheSize();
    }

    private static CacheDiskUtils getDefaultCacheDiskUtils() {
        CacheDiskUtils cacheDiskUtils = sDefaultCacheDiskUtils;
        if (cacheDiskUtils == null) {
            cacheDiskUtils = CacheDiskUtils.getInstance();
        }
        Objects.requireNonNull(cacheDiskUtils, "Detected an attempt to return null from a method com.blankj.utilcode.util.CacheDiskStaticUtils.getDefaultCacheDiskUtils() marked by @androidx.annotation.NonNull");
        return cacheDiskUtils;
    }

    public static Drawable getDrawable(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getDrawable(str, getDefaultCacheDiskUtils());
    }

    public static Drawable getDrawable(String str, Drawable drawable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getDrawable(str, drawable, getDefaultCacheDiskUtils());
    }

    public static Drawable getDrawable(String str, Drawable drawable, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDiskUtils.getDrawable(str, drawable);
    }

    public static Drawable getDrawable(String str, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDiskUtils.getDrawable(str);
    }

    public static JSONArray getJSONArray(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getJSONArray(str, getDefaultCacheDiskUtils());
    }

    public static JSONArray getJSONArray(String str, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDiskUtils.getJSONArray(str);
    }

    public static JSONArray getJSONArray(String str, JSONArray jSONArray) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getJSONArray(str, jSONArray, getDefaultCacheDiskUtils());
    }

    public static JSONArray getJSONArray(String str, JSONArray jSONArray, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDiskUtils.getJSONArray(str, jSONArray);
    }

    public static JSONObject getJSONObject(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getJSONObject(str, getDefaultCacheDiskUtils());
    }

    public static JSONObject getJSONObject(String str, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDiskUtils.getJSONObject(str);
    }

    public static JSONObject getJSONObject(String str, JSONObject jSONObject) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getJSONObject(str, jSONObject, getDefaultCacheDiskUtils());
    }

    public static JSONObject getJSONObject(String str, JSONObject jSONObject, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDiskUtils.getJSONObject(str, jSONObject);
    }

    public static <T> T getParcelable(String str, Parcelable.Creator<T> creator) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(creator, "Argument 'creator' of type Parcelable.Creator<T> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getParcelable(str, creator, getDefaultCacheDiskUtils());
    }

    public static <T> T getParcelable(String str, Parcelable.Creator<T> creator, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(creator, "Argument 'creator' of type Parcelable.Creator<T> (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDiskUtils.getParcelable(str, creator);
    }

    public static <T> T getParcelable(String str, Parcelable.Creator<T> creator, T t2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(creator, "Argument 'creator' of type Parcelable.Creator<T> (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getParcelable(str, creator, t2, getDefaultCacheDiskUtils());
    }

    public static <T> T getParcelable(String str, Parcelable.Creator<T> creator, T t2, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(creator, "Argument 'creator' of type Parcelable.Creator<T> (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDiskUtils.getParcelable(str, creator, t2);
    }

    public static Object getSerializable(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getSerializable(str, getDefaultCacheDiskUtils());
    }

    public static Object getSerializable(String str, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDiskUtils.getSerializable(str);
    }

    public static Object getSerializable(String str, Object obj) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getSerializable(str, obj, getDefaultCacheDiskUtils());
    }

    public static Object getSerializable(String str, Object obj, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDiskUtils.getSerializable(str, obj);
    }

    public static String getString(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getString(str, getDefaultCacheDiskUtils());
    }

    public static String getString(String str, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDiskUtils.getString(str);
    }

    public static String getString(String str, String str2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getString(str, str2, getDefaultCacheDiskUtils());
    }

    public static String getString(String str, String str2, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDiskUtils.getString(str, str2);
    }

    public static void put(String str, Bitmap bitmap) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, bitmap, getDefaultCacheDiskUtils());
    }

    public static void put(String str, Bitmap bitmap, int i2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, bitmap, i2, getDefaultCacheDiskUtils());
    }

    public static void put(String str, Bitmap bitmap, int i2, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDiskUtils.put(str, bitmap, i2);
    }

    public static void put(String str, Bitmap bitmap, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDiskUtils.put(str, bitmap);
    }

    public static void put(String str, Drawable drawable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, drawable, getDefaultCacheDiskUtils());
    }

    public static void put(String str, Drawable drawable, int i2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, drawable, i2, getDefaultCacheDiskUtils());
    }

    public static void put(String str, Drawable drawable, int i2, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDiskUtils.put(str, drawable, i2);
    }

    public static void put(String str, Drawable drawable, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDiskUtils.put(str, drawable);
    }

    public static void put(String str, Parcelable parcelable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, parcelable, getDefaultCacheDiskUtils());
    }

    public static void put(String str, Parcelable parcelable, int i2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, parcelable, i2, getDefaultCacheDiskUtils());
    }

    public static void put(String str, Parcelable parcelable, int i2, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDiskUtils.put(str, parcelable, i2);
    }

    public static void put(String str, Parcelable parcelable, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDiskUtils.put(str, parcelable);
    }

    public static void put(String str, Serializable serializable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, serializable, getDefaultCacheDiskUtils());
    }

    public static void put(String str, Serializable serializable, int i2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, serializable, i2, getDefaultCacheDiskUtils());
    }

    public static void put(String str, Serializable serializable, int i2, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDiskUtils.put(str, serializable, i2);
    }

    public static void put(String str, Serializable serializable, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDiskUtils.put(str, serializable);
    }

    public static void put(String str, String str2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, str2, getDefaultCacheDiskUtils());
    }

    public static void put(String str, String str2, int i2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, str2, i2, getDefaultCacheDiskUtils());
    }

    public static void put(String str, String str2, int i2, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDiskUtils.put(str, str2, i2);
    }

    public static void put(String str, String str2, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDiskUtils.put(str, str2);
    }

    public static void put(String str, JSONArray jSONArray) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, jSONArray, getDefaultCacheDiskUtils());
    }

    public static void put(String str, JSONArray jSONArray, int i2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, jSONArray, i2, getDefaultCacheDiskUtils());
    }

    public static void put(String str, JSONArray jSONArray, int i2, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDiskUtils.put(str, jSONArray, i2);
    }

    public static void put(String str, JSONArray jSONArray, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDiskUtils.put(str, jSONArray);
    }

    public static void put(String str, JSONObject jSONObject) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, jSONObject, getDefaultCacheDiskUtils());
    }

    public static void put(String str, JSONObject jSONObject, int i2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, jSONObject, i2, getDefaultCacheDiskUtils());
    }

    public static void put(String str, JSONObject jSONObject, int i2, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDiskUtils.put(str, jSONObject, i2);
    }

    public static void put(String str, JSONObject jSONObject, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDiskUtils.put(str, jSONObject);
    }

    public static void put(String str, byte[] bArr) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, bArr, getDefaultCacheDiskUtils());
    }

    public static void put(String str, byte[] bArr, int i2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, bArr, i2, getDefaultCacheDiskUtils());
    }

    public static void put(String str, byte[] bArr, int i2, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDiskUtils.put(str, bArr, i2);
    }

    public static void put(String str, byte[] bArr, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        cacheDiskUtils.put(str, bArr);
    }

    public static boolean remove(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return remove(str, getDefaultCacheDiskUtils());
    }

    public static boolean remove(String str, CacheDiskUtils cacheDiskUtils) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(cacheDiskUtils, "Argument 'cacheDiskUtils' of type CacheDiskUtils (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return cacheDiskUtils.remove(str);
    }

    public static void setDefaultCacheDiskUtils(CacheDiskUtils cacheDiskUtils) {
        sDefaultCacheDiskUtils = cacheDiskUtils;
    }
}
