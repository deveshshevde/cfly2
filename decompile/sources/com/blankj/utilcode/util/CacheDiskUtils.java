package com.blankj.utilcode.util;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.Log;
import com.blankj.utilcode.constant.CacheConstants;
import java.io.File;
import java.io.FilenameFilter;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

public final class CacheDiskUtils implements CacheConstants {
    private static final Map<String, CacheDiskUtils> CACHE_MAP = new HashMap();
    private static final String CACHE_PREFIX = "cdu_";
    private static final int DEFAULT_MAX_COUNT = Integer.MAX_VALUE;
    private static final long DEFAULT_MAX_SIZE = Long.MAX_VALUE;
    private static final String TYPE_BITMAP = "bi_";
    private static final String TYPE_BYTE = "by_";
    private static final String TYPE_DRAWABLE = "dr_";
    private static final String TYPE_JSON_ARRAY = "ja_";
    private static final String TYPE_JSON_OBJECT = "jo_";
    private static final String TYPE_PARCELABLE = "pa_";
    private static final String TYPE_SERIALIZABLE = "se_";
    private static final String TYPE_STRING = "st_";
    private final File mCacheDir;
    private final String mCacheKey;
    private DiskCacheManager mDiskCacheManager;
    private final int mMaxCount;
    private final long mMaxSize;

    private static final class DiskCacheHelper {
        static final int TIME_INFO_LEN = 14;

        private DiskCacheHelper() {
        }

        private static byte[] copyOfRange(byte[] bArr, int i2, int i3) {
            int i4 = i3 - i2;
            if (i4 >= 0) {
                byte[] bArr2 = new byte[i4];
                System.arraycopy(bArr, i2, bArr2, 0, Math.min(bArr.length - i2, i4));
                return bArr2;
            }
            throw new IllegalArgumentException(i2 + " > " + i3);
        }

        private static String createDueTime(int i2) {
            return String.format(Locale.getDefault(), "_$%010d$_", new Object[]{Long.valueOf((System.currentTimeMillis() / 1000) + ((long) i2))});
        }

        /* access modifiers changed from: private */
        public static byte[] getDataWithoutDueTime(byte[] bArr) {
            return hasTimeInfo(bArr) ? copyOfRange(bArr, 14, bArr.length) : bArr;
        }

        private static long getDueTime(byte[] bArr) {
            if (hasTimeInfo(bArr)) {
                try {
                    return Long.parseLong(new String(copyOfRange(bArr, 2, 12))) * 1000;
                } catch (NumberFormatException unused) {
                }
            }
            return -1;
        }

        private static boolean hasTimeInfo(byte[] bArr) {
            return bArr != null && bArr.length >= 14 && bArr[0] == 95 && bArr[1] == 36 && bArr[12] == 36 && bArr[13] == 95;
        }

        /* access modifiers changed from: private */
        public static boolean isDue(byte[] bArr) {
            long dueTime = getDueTime(bArr);
            return dueTime != -1 && System.currentTimeMillis() > dueTime;
        }

        /* access modifiers changed from: private */
        public static byte[] newByteArrayWithTime(int i2, byte[] bArr) {
            byte[] bytes = createDueTime(i2).getBytes();
            byte[] bArr2 = new byte[(bytes.length + bArr.length)];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
            return bArr2;
        }
    }

    private static final class DiskCacheManager {
        /* access modifiers changed from: private */
        public final AtomicInteger cacheCount;
        private final File cacheDir;
        /* access modifiers changed from: private */
        public final AtomicLong cacheSize;
        private final int countLimit;
        /* access modifiers changed from: private */
        public final Map<File, Long> lastUsageDates;
        private final Thread mThread;
        private final long sizeLimit;

        private DiskCacheManager(final File file, long j2, int i2) {
            this.lastUsageDates = Collections.synchronizedMap(new HashMap());
            this.cacheDir = file;
            this.sizeLimit = j2;
            this.countLimit = i2;
            this.cacheSize = new AtomicLong();
            this.cacheCount = new AtomicInteger();
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    File[] listFiles = file.listFiles(new FilenameFilter() {
                        public boolean accept(File file, String str) {
                            return str.startsWith(CacheDiskUtils.CACHE_PREFIX);
                        }
                    });
                    if (listFiles != null) {
                        int i2 = 0;
                        int i3 = 0;
                        for (File file : listFiles) {
                            i2 = (int) (((long) i2) + file.length());
                            i3++;
                            DiskCacheManager.this.lastUsageDates.put(file, Long.valueOf(file.lastModified()));
                        }
                        DiskCacheManager.this.cacheSize.getAndAdd((long) i2);
                        DiskCacheManager.this.cacheCount.getAndAdd(i3);
                    }
                }
            });
            this.mThread = thread;
            thread.start();
        }

        /* access modifiers changed from: private */
        public boolean clear() {
            File[] listFiles = this.cacheDir.listFiles(new FilenameFilter() {
                public boolean accept(File file, String str) {
                    return str.startsWith(CacheDiskUtils.CACHE_PREFIX);
                }
            });
            boolean z2 = true;
            if (listFiles != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    if (!file.delete()) {
                        z2 = false;
                    } else {
                        this.cacheSize.addAndGet(-file.length());
                        this.cacheCount.addAndGet(-1);
                        this.lastUsageDates.remove(file);
                    }
                }
                if (z2) {
                    this.lastUsageDates.clear();
                    this.cacheSize.set(0);
                    this.cacheCount.set(0);
                }
            }
            return z2;
        }

        /* access modifiers changed from: private */
        public int getCacheCount() {
            wait2InitOk();
            return this.cacheCount.get();
        }

        private String getCacheNameByKey(String str) {
            return CacheDiskUtils.CACHE_PREFIX + str.substring(0, 3) + str.substring(3).hashCode();
        }

        /* access modifiers changed from: private */
        public long getCacheSize() {
            wait2InitOk();
            return this.cacheSize.get();
        }

        /* access modifiers changed from: private */
        public File getFileBeforePut(String str) {
            wait2InitOk();
            File file = new File(this.cacheDir, getCacheNameByKey(str));
            if (file.exists()) {
                this.cacheCount.addAndGet(-1);
                this.cacheSize.addAndGet(-file.length());
            }
            return file;
        }

        /* access modifiers changed from: private */
        public File getFileIfExists(String str) {
            File file = new File(this.cacheDir, getCacheNameByKey(str));
            if (!file.exists()) {
                return null;
            }
            return file;
        }

        /* access modifiers changed from: private */
        public void put(File file) {
            this.cacheCount.addAndGet(1);
            this.cacheSize.addAndGet(file.length());
            while (true) {
                if (this.cacheCount.get() > this.countLimit || this.cacheSize.get() > this.sizeLimit) {
                    this.cacheSize.addAndGet(-removeOldest());
                    this.cacheCount.addAndGet(-1);
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: private */
        public boolean removeByKey(String str) {
            File fileIfExists = getFileIfExists(str);
            if (fileIfExists == null) {
                return true;
            }
            if (!fileIfExists.delete()) {
                return false;
            }
            this.cacheSize.addAndGet(-fileIfExists.length());
            this.cacheCount.addAndGet(-1);
            this.lastUsageDates.remove(fileIfExists);
            return true;
        }

        private long removeOldest() {
            if (this.lastUsageDates.isEmpty()) {
                return 0;
            }
            Long valueOf = Long.valueOf(CacheDiskUtils.DEFAULT_MAX_SIZE);
            File file = null;
            Set<Map.Entry<File, Long>> entrySet = this.lastUsageDates.entrySet();
            synchronized (this.lastUsageDates) {
                for (Map.Entry next : entrySet) {
                    Long l2 = (Long) next.getValue();
                    if (l2.longValue() < valueOf.longValue()) {
                        file = (File) next.getKey();
                        valueOf = l2;
                    }
                }
            }
            if (file == null) {
                return 0;
            }
            long length = file.length();
            if (!file.delete()) {
                return 0;
            }
            this.lastUsageDates.remove(file);
            return length;
        }

        /* access modifiers changed from: private */
        public void updateModify(File file) {
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            file.setLastModified(valueOf.longValue());
            this.lastUsageDates.put(file, valueOf);
        }

        private void wait2InitOk() {
            try {
                this.mThread.join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    private CacheDiskUtils(String str, File file, long j2, int i2) {
        this.mCacheKey = str;
        this.mCacheDir = file;
        this.mMaxSize = j2;
        this.mMaxCount = i2;
    }

    private DiskCacheManager getDiskCacheManager() {
        DiskCacheManager diskCacheManager;
        if (this.mCacheDir.exists()) {
            if (this.mDiskCacheManager == null) {
                diskCacheManager = new DiskCacheManager(this.mCacheDir, this.mMaxSize, this.mMaxCount);
            }
            return this.mDiskCacheManager;
        } else if (this.mCacheDir.mkdirs()) {
            diskCacheManager = new DiskCacheManager(this.mCacheDir, this.mMaxSize, this.mMaxCount);
        } else {
            Log.e("CacheDiskUtils", "can't make dirs in " + this.mCacheDir.getAbsolutePath());
            return this.mDiskCacheManager;
        }
        this.mDiskCacheManager = diskCacheManager;
        return this.mDiskCacheManager;
    }

    public static CacheDiskUtils getInstance() {
        return getInstance("", (long) DEFAULT_MAX_SIZE, Integer.MAX_VALUE);
    }

    public static CacheDiskUtils getInstance(long j2, int i2) {
        return getInstance("", j2, i2);
    }

    public static CacheDiskUtils getInstance(File file) {
        Objects.requireNonNull(file, "Argument 'cacheDir' of type File (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getInstance(file, (long) DEFAULT_MAX_SIZE, Integer.MAX_VALUE);
    }

    public static CacheDiskUtils getInstance(File file, long j2, int i2) {
        Objects.requireNonNull(file, "Argument 'cacheDir' of type File (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        String str = file.getAbsoluteFile() + "_" + j2 + "_" + i2;
        Map<String, CacheDiskUtils> map = CACHE_MAP;
        CacheDiskUtils cacheDiskUtils = map.get(str);
        if (cacheDiskUtils == null) {
            synchronized (CacheDiskUtils.class) {
                cacheDiskUtils = map.get(str);
                if (cacheDiskUtils == null) {
                    CacheDiskUtils cacheDiskUtils2 = new CacheDiskUtils(str, file, j2, i2);
                    map.put(str, cacheDiskUtils2);
                    cacheDiskUtils = cacheDiskUtils2;
                }
            }
        }
        return cacheDiskUtils;
    }

    public static CacheDiskUtils getInstance(String str) {
        return getInstance(str, (long) DEFAULT_MAX_SIZE, Integer.MAX_VALUE);
    }

    public static CacheDiskUtils getInstance(String str, long j2, int i2) {
        if (UtilsBridge.isSpace(str)) {
            str = "cacheUtils";
        }
        return getInstance(new File(Utils.getApp().getCacheDir(), str), j2, i2);
    }

    private byte[] realGetBytes(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return realGetBytes(str, (byte[]) null);
    }

    private byte[] realGetBytes(String str, byte[] bArr) {
        File access$500;
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        DiskCacheManager diskCacheManager = getDiskCacheManager();
        if (diskCacheManager == null || (access$500 = diskCacheManager.getFileIfExists(str)) == null) {
            return bArr;
        }
        byte[] readFile2Bytes = UtilsBridge.readFile2Bytes(access$500);
        if (DiskCacheHelper.isDue(readFile2Bytes)) {
            boolean unused = diskCacheManager.removeByKey(str);
            return bArr;
        }
        diskCacheManager.updateModify(access$500);
        return DiskCacheHelper.getDataWithoutDueTime(readFile2Bytes);
    }

    private void realPutBytes(String str, byte[] bArr, int i2) {
        DiskCacheManager diskCacheManager;
        if (bArr != null && (diskCacheManager = getDiskCacheManager()) != null) {
            if (i2 >= 0) {
                bArr = DiskCacheHelper.newByteArrayWithTime(i2, bArr);
            }
            File access$200 = diskCacheManager.getFileBeforePut(str);
            UtilsBridge.writeFileFromBytes(access$200, bArr);
            diskCacheManager.updateModify(access$200);
            diskCacheManager.put(access$200);
        }
    }

    public boolean clear() {
        DiskCacheManager diskCacheManager = getDiskCacheManager();
        if (diskCacheManager == null) {
            return true;
        }
        return diskCacheManager.clear();
    }

    public Bitmap getBitmap(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getBitmap(str, (Bitmap) null);
    }

    public Bitmap getBitmap(String str, Bitmap bitmap) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        byte[] realGetBytes = realGetBytes(TYPE_BITMAP + str);
        return realGetBytes == null ? bitmap : UtilsBridge.bytes2Bitmap(realGetBytes);
    }

    public byte[] getBytes(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getBytes(str, (byte[]) null);
    }

    public byte[] getBytes(String str, byte[] bArr) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return realGetBytes(TYPE_BYTE + str, bArr);
    }

    public int getCacheCount() {
        DiskCacheManager diskCacheManager = getDiskCacheManager();
        if (diskCacheManager == null) {
            return 0;
        }
        return diskCacheManager.getCacheCount();
    }

    public long getCacheSize() {
        DiskCacheManager diskCacheManager = getDiskCacheManager();
        if (diskCacheManager == null) {
            return 0;
        }
        return diskCacheManager.getCacheSize();
    }

    public Drawable getDrawable(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getDrawable(str, (Drawable) null);
    }

    public Drawable getDrawable(String str, Drawable drawable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        byte[] realGetBytes = realGetBytes(TYPE_DRAWABLE + str);
        return realGetBytes == null ? drawable : UtilsBridge.bytes2Drawable(realGetBytes);
    }

    public JSONArray getJSONArray(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getJSONArray(str, (JSONArray) null);
    }

    public JSONArray getJSONArray(String str, JSONArray jSONArray) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        byte[] realGetBytes = realGetBytes(TYPE_JSON_ARRAY + str);
        return realGetBytes == null ? jSONArray : UtilsBridge.bytes2JSONArray(realGetBytes);
    }

    public JSONObject getJSONObject(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getJSONObject(str, (JSONObject) null);
    }

    public JSONObject getJSONObject(String str, JSONObject jSONObject) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        byte[] realGetBytes = realGetBytes(TYPE_JSON_OBJECT + str);
        return realGetBytes == null ? jSONObject : UtilsBridge.bytes2JSONObject(realGetBytes);
    }

    public <T> T getParcelable(String str, Parcelable.Creator<T> creator) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(creator, "Argument 'creator' of type Parcelable.Creator<T> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getParcelable(str, creator, (Object) null);
    }

    public <T> T getParcelable(String str, Parcelable.Creator<T> creator, T t2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(creator, "Argument 'creator' of type Parcelable.Creator<T> (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        byte[] realGetBytes = realGetBytes(TYPE_PARCELABLE + str);
        return realGetBytes == null ? t2 : UtilsBridge.bytes2Parcelable(realGetBytes, creator);
    }

    public Object getSerializable(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getSerializable(str, (Object) null);
    }

    public Object getSerializable(String str, Object obj) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        byte[] realGetBytes = realGetBytes(TYPE_SERIALIZABLE + str);
        return realGetBytes == null ? obj : UtilsBridge.bytes2Object(realGetBytes);
    }

    public String getString(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return getString(str, (String) null);
    }

    public String getString(String str, String str2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        byte[] realGetBytes = realGetBytes(TYPE_STRING + str);
        return realGetBytes == null ? str2 : UtilsBridge.bytes2String(realGetBytes);
    }

    public void put(String str, Bitmap bitmap) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, bitmap, -1);
    }

    public void put(String str, Bitmap bitmap, int i2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        realPutBytes(TYPE_BITMAP + str, UtilsBridge.bitmap2Bytes(bitmap), i2);
    }

    public void put(String str, Drawable drawable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, drawable, -1);
    }

    public void put(String str, Drawable drawable, int i2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        realPutBytes(TYPE_DRAWABLE + str, UtilsBridge.drawable2Bytes(drawable), i2);
    }

    public void put(String str, Parcelable parcelable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, parcelable, -1);
    }

    public void put(String str, Parcelable parcelable, int i2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        realPutBytes(TYPE_PARCELABLE + str, UtilsBridge.parcelable2Bytes(parcelable), i2);
    }

    public void put(String str, Serializable serializable) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, serializable, -1);
    }

    public void put(String str, Serializable serializable, int i2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        realPutBytes(TYPE_SERIALIZABLE + str, UtilsBridge.serializable2Bytes(serializable), i2);
    }

    public void put(String str, String str2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, str2, -1);
    }

    public void put(String str, String str2, int i2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        realPutBytes(TYPE_STRING + str, UtilsBridge.string2Bytes(str2), i2);
    }

    public void put(String str, JSONArray jSONArray) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, jSONArray, -1);
    }

    public void put(String str, JSONArray jSONArray, int i2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        realPutBytes(TYPE_JSON_ARRAY + str, UtilsBridge.jsonArray2Bytes(jSONArray), i2);
    }

    public void put(String str, JSONObject jSONObject) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, jSONObject, -1);
    }

    public void put(String str, JSONObject jSONObject, int i2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        realPutBytes(TYPE_JSON_OBJECT + str, UtilsBridge.jsonObject2Bytes(jSONObject), i2);
    }

    public void put(String str, byte[] bArr) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        put(str, bArr, -1);
    }

    public void put(String str, byte[] bArr, int i2) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        realPutBytes(TYPE_BYTE + str, bArr, i2);
    }

    public boolean remove(String str) {
        Objects.requireNonNull(str, "Argument 'key' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        DiskCacheManager diskCacheManager = getDiskCacheManager();
        if (diskCacheManager == null) {
            return true;
        }
        if (diskCacheManager.removeByKey(TYPE_BYTE + str)) {
            if (diskCacheManager.removeByKey(TYPE_STRING + str)) {
                if (diskCacheManager.removeByKey(TYPE_JSON_OBJECT + str)) {
                    if (diskCacheManager.removeByKey(TYPE_JSON_ARRAY + str)) {
                        if (diskCacheManager.removeByKey(TYPE_BITMAP + str)) {
                            if (diskCacheManager.removeByKey(TYPE_DRAWABLE + str)) {
                                if (diskCacheManager.removeByKey(TYPE_PARCELABLE + str)) {
                                    if (diskCacheManager.removeByKey(TYPE_SERIALIZABLE + str)) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public String toString() {
        return this.mCacheKey + "@" + Integer.toHexString(hashCode());
    }
}
