package com.blankj.utilcode.util;

import com.blankj.utilcode.constant.CacheConstants;
import j.e;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class CacheMemoryUtils implements CacheConstants {
    private static final Map<String, CacheMemoryUtils> CACHE_MAP = new HashMap();
    private static final int DEFAULT_MAX_COUNT = 256;
    private final String mCacheKey;
    private final e<String, CacheValue> mMemoryCache;

    private static final class CacheValue {
        long dueTime;
        Object value;

        CacheValue(long j2, Object obj) {
            this.dueTime = j2;
            this.value = obj;
        }
    }

    private CacheMemoryUtils(String str, e<String, CacheValue> eVar) {
        this.mCacheKey = str;
        this.mMemoryCache = eVar;
    }

    public static CacheMemoryUtils getInstance() {
        return getInstance(256);
    }

    public static CacheMemoryUtils getInstance(int i2) {
        return getInstance(String.valueOf(i2), i2);
    }

    public static CacheMemoryUtils getInstance(String str, int i2) {
        Map<String, CacheMemoryUtils> map = CACHE_MAP;
        CacheMemoryUtils cacheMemoryUtils = map.get(str);
        if (cacheMemoryUtils == null) {
            synchronized (CacheMemoryUtils.class) {
                cacheMemoryUtils = map.get(str);
                if (cacheMemoryUtils == null) {
                    cacheMemoryUtils = new CacheMemoryUtils(str, new e(i2));
                    map.put(str, cacheMemoryUtils);
                }
            }
        }
        return cacheMemoryUtils;
    }

    public void clear() {
        this.mMemoryCache.evictAll();
    }

    public <T> T get(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return get(str, (Object) null);
    }

    public <T> T get(String str, T t2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        CacheValue cacheValue = this.mMemoryCache.get(str);
        if (cacheValue == null) {
            return t2;
        }
        if (cacheValue.dueTime == -1 || cacheValue.dueTime >= System.currentTimeMillis()) {
            return cacheValue.value;
        }
        this.mMemoryCache.remove(str);
        return t2;
    }

    public int getCacheCount() {
        return this.mMemoryCache.size();
    }

    public void put(String str, Object obj) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, obj, -1);
    }

    public void put(String str, Object obj, int i2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (obj != null) {
            this.mMemoryCache.put(str, new CacheValue(i2 < 0 ? -1 : System.currentTimeMillis() + ((long) (i2 * 1000)), obj));
        }
    }

    public Object remove(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        CacheValue remove = this.mMemoryCache.remove(str);
        if (remove == null) {
            return null;
        }
        return remove.value;
    }

    public String toString() {
        return this.mCacheKey + "@" + Integer.toHexString(hashCode());
    }
}
