package com.davemorrissey.labs.subscaleview.decoder;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.xeagle.android.login.common.StorageUtil;
import java.io.File;
import java.io.FileFilter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;

public class SkiaPooledImageRegionDecoder implements ImageRegionDecoder {
    private static final String ASSET_PREFIX = "file:///android_asset/";
    private static final String FILE_PREFIX = "file://";
    private static final String RESOURCE_PREFIX = "android.resource://";
    private static final String TAG = "SkiaPooledImageRegionDecoder";
    private static boolean debug = false;
    private final Bitmap.Config bitmapConfig;
    private Context context;
    private final ReadWriteLock decoderLock;
    /* access modifiers changed from: private */
    public DecoderPool decoderPool;
    /* access modifiers changed from: private */
    public long fileLength;
    private final Point imageDimensions;
    private final AtomicBoolean lazyInited;
    private Uri uri;

    private static class DecoderPool {
        private final Semaphore available;
        private final Map<BitmapRegionDecoder, Boolean> decoders;

        private DecoderPool() {
            this.available = new Semaphore(0, true);
            this.decoders = new ConcurrentHashMap();
        }

        /* access modifiers changed from: private */
        public BitmapRegionDecoder acquire() {
            this.available.acquireUninterruptibly();
            return getNextAvailable();
        }

        /* access modifiers changed from: private */
        public synchronized void add(BitmapRegionDecoder bitmapRegionDecoder) {
            this.decoders.put(bitmapRegionDecoder, false);
            this.available.release();
        }

        private synchronized BitmapRegionDecoder getNextAvailable() {
            for (Map.Entry next : this.decoders.entrySet()) {
                if (!((Boolean) next.getValue()).booleanValue()) {
                    next.setValue(true);
                    return (BitmapRegionDecoder) next.getKey();
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        public synchronized boolean isEmpty() {
            return this.decoders.isEmpty();
        }

        private synchronized boolean markAsUnused(BitmapRegionDecoder bitmapRegionDecoder) {
            for (Map.Entry next : this.decoders.entrySet()) {
                if (bitmapRegionDecoder == next.getKey()) {
                    if (!((Boolean) next.getValue()).booleanValue()) {
                        return false;
                    }
                    next.setValue(false);
                    return true;
                }
            }
            return false;
        }

        /* access modifiers changed from: private */
        public synchronized void recycle() {
            while (!this.decoders.isEmpty()) {
                BitmapRegionDecoder acquire = acquire();
                acquire.recycle();
                this.decoders.remove(acquire);
            }
        }

        /* access modifiers changed from: private */
        public void release(BitmapRegionDecoder bitmapRegionDecoder) {
            if (markAsUnused(bitmapRegionDecoder)) {
                this.available.release();
            }
        }

        /* access modifiers changed from: private */
        public synchronized int size() {
            return this.decoders.size();
        }
    }

    public SkiaPooledImageRegionDecoder() {
        this((Bitmap.Config) null);
    }

    public SkiaPooledImageRegionDecoder(Bitmap.Config config) {
        this.decoderPool = new DecoderPool();
        this.decoderLock = new ReentrantReadWriteLock(true);
        this.fileLength = Long.MAX_VALUE;
        this.imageDimensions = new Point(0, 0);
        this.lazyInited = new AtomicBoolean(false);
        Bitmap.Config preferredBitmapConfig = SubsamplingScaleImageView.getPreferredBitmapConfig();
        if (config == null) {
            if (preferredBitmapConfig != null) {
                this.bitmapConfig = preferredBitmapConfig;
                return;
            }
            config = Bitmap.Config.RGB_565;
        }
        this.bitmapConfig = config;
    }

    /* access modifiers changed from: private */
    public void debug(String str) {
        if (debug) {
            Log.d(TAG, str);
        }
    }

    private int getNumCoresOldPhones() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new FileFilter() {
                public boolean accept(File file) {
                    return Pattern.matches("cpu[0-9]+", file.getName());
                }
            }).length;
        } catch (Exception unused) {
            return 1;
        }
    }

    private int getNumberOfCores() {
        return Build.VERSION.SDK_INT >= 17 ? Runtime.getRuntime().availableProcessors() : getNumCoresOldPhones();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0121 A[Catch:{ all -> 0x012e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initialiseDecoder() throws java.lang.Exception {
        /*
            r10 = this;
            android.net.Uri r0 = r10.uri
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "android.resource://"
            boolean r1 = r0.startsWith(r1)
            r2 = 1
            r3 = 0
            r4 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r1 == 0) goto L_0x0091
            android.net.Uri r0 = r10.uri
            java.lang.String r0 = r0.getAuthority()
            android.content.Context r1 = r10.context
            java.lang.String r1 = r1.getPackageName()
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x002e
            android.content.Context r1 = r10.context
            android.content.res.Resources r1 = r1.getResources()
            goto L_0x0038
        L_0x002e:
            android.content.Context r1 = r10.context
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            android.content.res.Resources r1 = r1.getResourcesForApplication(r0)
        L_0x0038:
            android.net.Uri r6 = r10.uri
            java.util.List r6 = r6.getPathSegments()
            int r7 = r6.size()
            r8 = 2
            if (r7 != r8) goto L_0x005e
            java.lang.Object r8 = r6.get(r3)
            java.lang.String r8 = (java.lang.String) r8
            java.lang.String r9 = "drawable"
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x005e
            java.lang.Object r2 = r6.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            int r0 = r1.getIdentifier(r2, r9, r0)
            goto L_0x0078
        L_0x005e:
            if (r7 != r2) goto L_0x0077
            java.lang.Object r0 = r6.get(r3)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isDigitsOnly(r0)
            if (r0 == 0) goto L_0x0077
            java.lang.Object r0 = r6.get(r3)     // Catch:{ NumberFormatException -> 0x0077 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ NumberFormatException -> 0x0077 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0077 }
            goto L_0x0078
        L_0x0077:
            r0 = 0
        L_0x0078:
            android.content.Context r1 = r10.context     // Catch:{ Exception -> 0x0086 }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x0086 }
            android.content.res.AssetFileDescriptor r1 = r1.openRawResourceFd(r0)     // Catch:{ Exception -> 0x0086 }
            long r4 = r1.getLength()     // Catch:{ Exception -> 0x0086 }
        L_0x0086:
            android.content.Context r1 = r10.context
            android.content.res.Resources r1 = r1.getResources()
            java.io.InputStream r0 = r1.openRawResource(r0)
            goto L_0x00b7
        L_0x0091:
            java.lang.String r1 = "file:///android_asset/"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L_0x00bc
            r1 = 22
            java.lang.String r0 = r0.substring(r1)
            android.content.Context r1 = r10.context     // Catch:{ Exception -> 0x00ad }
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch:{ Exception -> 0x00ad }
            android.content.res.AssetFileDescriptor r1 = r1.openFd(r0)     // Catch:{ Exception -> 0x00ad }
            long r4 = r1.getLength()     // Catch:{ Exception -> 0x00ad }
        L_0x00ad:
            android.content.Context r1 = r10.context
            android.content.res.AssetManager r1 = r1.getAssets()
            java.io.InputStream r0 = r1.open(r0, r2)
        L_0x00b7:
            android.graphics.BitmapRegionDecoder r0 = android.graphics.BitmapRegionDecoder.newInstance(r0, r3)
            goto L_0x0105
        L_0x00bc:
            java.lang.String r1 = "file://"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L_0x00de
            r1 = 7
            java.lang.String r1 = r0.substring(r1)
            android.graphics.BitmapRegionDecoder r1 = android.graphics.BitmapRegionDecoder.newInstance(r1, r3)
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x00dc }
            r2.<init>(r0)     // Catch:{ Exception -> 0x00dc }
            boolean r0 = r2.exists()     // Catch:{ Exception -> 0x00dc }
            if (r0 == 0) goto L_0x00dc
            long r4 = r2.length()     // Catch:{ Exception -> 0x00dc }
        L_0x00dc:
            r0 = r1
            goto L_0x0105
        L_0x00de:
            r0 = 0
            android.content.Context r1 = r10.context     // Catch:{ all -> 0x0139 }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ all -> 0x0139 }
            android.net.Uri r2 = r10.uri     // Catch:{ all -> 0x0139 }
            java.io.InputStream r0 = r1.openInputStream(r2)     // Catch:{ all -> 0x0139 }
            android.graphics.BitmapRegionDecoder r2 = android.graphics.BitmapRegionDecoder.newInstance(r0, r3)     // Catch:{ all -> 0x0139 }
            android.net.Uri r3 = r10.uri     // Catch:{ Exception -> 0x00fe }
            java.lang.String r6 = "r"
            android.content.res.AssetFileDescriptor r1 = r1.openAssetFileDescriptor(r3, r6)     // Catch:{ Exception -> 0x00fe }
            if (r1 == 0) goto L_0x00ff
            long r4 = r1.getLength()     // Catch:{ Exception -> 0x00fe }
            goto L_0x00ff
        L_0x00fe:
        L_0x00ff:
            if (r0 == 0) goto L_0x0104
            r0.close()     // Catch:{ Exception -> 0x0104 }
        L_0x0104:
            r0 = r2
        L_0x0105:
            r10.fileLength = r4
            android.graphics.Point r1 = r10.imageDimensions
            int r2 = r0.getWidth()
            int r3 = r0.getHeight()
            r1.set(r2, r3)
            java.util.concurrent.locks.ReadWriteLock r1 = r10.decoderLock
            java.util.concurrent.locks.Lock r1 = r1.writeLock()
            r1.lock()
            com.davemorrissey.labs.subscaleview.decoder.SkiaPooledImageRegionDecoder$DecoderPool r1 = r10.decoderPool     // Catch:{ all -> 0x012e }
            if (r1 == 0) goto L_0x0124
            r1.add(r0)     // Catch:{ all -> 0x012e }
        L_0x0124:
            java.util.concurrent.locks.ReadWriteLock r0 = r10.decoderLock
            java.util.concurrent.locks.Lock r0 = r0.writeLock()
            r0.unlock()
            return
        L_0x012e:
            r0 = move-exception
            java.util.concurrent.locks.ReadWriteLock r1 = r10.decoderLock
            java.util.concurrent.locks.Lock r1 = r1.writeLock()
            r1.unlock()
            throw r0
        L_0x0139:
            r1 = move-exception
            if (r0 == 0) goto L_0x013f
            r0.close()     // Catch:{ Exception -> 0x013f }
        L_0x013f:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.decoder.SkiaPooledImageRegionDecoder.initialiseDecoder():void");
    }

    private boolean isLowMemory() {
        ActivityManager activityManager = (ActivityManager) this.context.getSystemService("activity");
        if (activityManager == null) {
            return true;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.lowMemory;
    }

    private void lazyInit() {
        if (this.lazyInited.compareAndSet(false, true) && this.fileLength < Long.MAX_VALUE) {
            debug("Starting lazy init of additional decoders");
            new Thread() {
                public void run() {
                    while (SkiaPooledImageRegionDecoder.this.decoderPool != null) {
                        SkiaPooledImageRegionDecoder skiaPooledImageRegionDecoder = SkiaPooledImageRegionDecoder.this;
                        if (skiaPooledImageRegionDecoder.allowAdditionalDecoder(skiaPooledImageRegionDecoder.decoderPool.size(), SkiaPooledImageRegionDecoder.this.fileLength)) {
                            try {
                                if (SkiaPooledImageRegionDecoder.this.decoderPool != null) {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    SkiaPooledImageRegionDecoder.this.debug("Starting decoder");
                                    SkiaPooledImageRegionDecoder.this.initialiseDecoder();
                                    long currentTimeMillis2 = System.currentTimeMillis();
                                    SkiaPooledImageRegionDecoder skiaPooledImageRegionDecoder2 = SkiaPooledImageRegionDecoder.this;
                                    skiaPooledImageRegionDecoder2.debug("Started decoder, took " + (currentTimeMillis2 - currentTimeMillis) + "ms");
                                }
                            } catch (Exception e2) {
                                SkiaPooledImageRegionDecoder skiaPooledImageRegionDecoder3 = SkiaPooledImageRegionDecoder.this;
                                skiaPooledImageRegionDecoder3.debug("Failed to start decoder: " + e2.getMessage());
                            }
                        } else {
                            return;
                        }
                    }
                }
            }.start();
        }
    }

    public static void setDebug(boolean z2) {
        debug = z2;
    }

    /* access modifiers changed from: protected */
    public boolean allowAdditionalDecoder(int i2, long j2) {
        String str;
        if (i2 >= 4) {
            str = "No additional decoders allowed, reached hard limit (4)";
        } else {
            long j3 = ((long) i2) * j2;
            if (j3 > 20971520) {
                str = "No additional encoders allowed, reached hard memory limit (20Mb)";
            } else if (i2 >= getNumberOfCores()) {
                str = "No additional encoders allowed, limited by CPU cores (" + getNumberOfCores() + ")";
            } else if (isLowMemory()) {
                str = "No additional encoders allowed, memory is low";
            } else {
                debug("Additional decoder allowed, current count is " + i2 + ", estimated native memory " + (j3 / StorageUtil.M) + "Mb");
                return true;
            }
        }
        debug(str);
        return false;
    }

    public Bitmap decodeRegion(Rect rect, int i2) {
        BitmapRegionDecoder access$700;
        debug("Decode region " + rect + " on thread " + Thread.currentThread().getName());
        if (rect.width() < this.imageDimensions.x || rect.height() < this.imageDimensions.y) {
            lazyInit();
        }
        this.decoderLock.readLock().lock();
        try {
            DecoderPool decoderPool2 = this.decoderPool;
            if (decoderPool2 != null) {
                access$700 = decoderPool2.acquire();
                if (access$700 != null) {
                    if (!access$700.isRecycled()) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = i2;
                        options.inPreferredConfig = this.bitmapConfig;
                        Bitmap decodeRegion = access$700.decodeRegion(rect, options);
                        if (decodeRegion != null) {
                            if (access$700 != null) {
                                this.decoderPool.release(access$700);
                            }
                            this.decoderLock.readLock().unlock();
                            return decodeRegion;
                        }
                        throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
                    }
                }
                if (access$700 != null) {
                    this.decoderPool.release(access$700);
                }
            }
            throw new IllegalStateException("Cannot decode region after decoder has been recycled");
        } catch (Throwable th) {
            this.decoderLock.readLock().unlock();
            throw th;
        }
    }

    public Point init(Context context2, Uri uri2) throws Exception {
        this.context = context2;
        this.uri = uri2;
        initialiseDecoder();
        return this.imageDimensions;
    }

    public synchronized boolean isReady() {
        DecoderPool decoderPool2;
        decoderPool2 = this.decoderPool;
        return decoderPool2 != null && !decoderPool2.isEmpty();
    }

    public synchronized void recycle() {
        this.decoderLock.writeLock().lock();
        try {
            DecoderPool decoderPool2 = this.decoderPool;
            if (decoderPool2 != null) {
                decoderPool2.recycle();
                this.decoderPool = null;
                this.context = null;
                this.uri = null;
            }
        } finally {
            this.decoderLock.writeLock().unlock();
        }
    }
}
