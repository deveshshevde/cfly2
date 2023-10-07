package com.davemorrissey.labs.subscaleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.davemorrissey.labs.subscaleview.decoder.CompatDecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.DecoderFactory;
import com.davemorrissey.labs.subscaleview.decoder.ImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageDecoder;
import com.davemorrissey.labs.subscaleview.decoder.SkiaImageRegionDecoder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SubsamplingScaleImageView extends View {
    public static final int EASE_IN_OUT_QUAD = 2;
    public static final int EASE_OUT_QUAD = 1;
    private static final int MESSAGE_LONG_CLICK = 1;
    public static final int ORIENTATION_0 = 0;
    public static final int ORIENTATION_180 = 180;
    public static final int ORIENTATION_270 = 270;
    public static final int ORIENTATION_90 = 90;
    public static final int ORIENTATION_USE_EXIF = -1;
    public static final int ORIGIN_ANIM = 1;
    public static final int ORIGIN_DOUBLE_TAP_ZOOM = 4;
    public static final int ORIGIN_FLING = 3;
    public static final int ORIGIN_TOUCH = 2;
    public static final int PAN_LIMIT_CENTER = 3;
    public static final int PAN_LIMIT_INSIDE = 1;
    public static final int PAN_LIMIT_OUTSIDE = 2;
    public static final int SCALE_TYPE_CENTER_CROP = 2;
    public static final int SCALE_TYPE_CENTER_INSIDE = 1;
    public static final int SCALE_TYPE_CUSTOM = 3;
    public static final int SCALE_TYPE_START = 4;
    /* access modifiers changed from: private */
    public static final String TAG = "SubsamplingScaleImageView";
    public static final int TILE_SIZE_AUTO = Integer.MAX_VALUE;
    /* access modifiers changed from: private */
    public static final List<Integer> VALID_EASING_STYLES = Arrays.asList(new Integer[]{2, 1});
    private static final List<Integer> VALID_ORIENTATIONS = Arrays.asList(new Integer[]{0, 90, 180, Integer.valueOf(ORIENTATION_270), -1});
    private static final List<Integer> VALID_PAN_LIMITS = Arrays.asList(new Integer[]{1, 2, 3});
    private static final List<Integer> VALID_SCALE_TYPES = Arrays.asList(new Integer[]{2, 1, 3, 4});
    private static final List<Integer> VALID_ZOOM_STYLES = Arrays.asList(new Integer[]{1, 2, 3});
    public static final int ZOOM_FOCUS_CENTER = 2;
    public static final int ZOOM_FOCUS_CENTER_IMMEDIATE = 3;
    public static final int ZOOM_FOCUS_FIXED = 1;
    private static Bitmap.Config preferredBitmapConfig;
    /* access modifiers changed from: private */
    public Anim anim;
    private Bitmap bitmap;
    private DecoderFactory<? extends ImageDecoder> bitmapDecoderFactory;
    private boolean bitmapIsCached;
    private boolean bitmapIsPreview;
    private Paint bitmapPaint;
    private boolean debug;
    private Paint debugLinePaint;
    private Paint debugTextPaint;
    private ImageRegionDecoder decoder;
    /* access modifiers changed from: private */
    public final ReadWriteLock decoderLock;
    private final float density;
    private GestureDetector detector;
    private int doubleTapZoomDuration;
    private float doubleTapZoomScale;
    private int doubleTapZoomStyle;
    private final float[] dstArray;
    private boolean eagerLoadingEnabled;
    private Executor executor;
    private int fullImageSampleSize;
    private final Handler handler;
    private boolean imageLoadedSent;
    private boolean isPanning;
    /* access modifiers changed from: private */
    public boolean isQuickScaling;
    /* access modifiers changed from: private */
    public boolean isZooming;
    private Matrix matrix;
    private float maxScale;
    private int maxTileHeight;
    private int maxTileWidth;
    /* access modifiers changed from: private */
    public int maxTouchCount;
    private float minScale;
    private int minimumScaleType;
    private int minimumTileDpi;
    /* access modifiers changed from: private */
    public OnImageEventListener onImageEventListener;
    /* access modifiers changed from: private */
    public View.OnLongClickListener onLongClickListener;
    private OnStateChangedListener onStateChangedListener;
    private int orientation;
    private Rect pRegion;
    /* access modifiers changed from: private */
    public boolean panEnabled;
    private int panLimit;
    private Float pendingScale;
    /* access modifiers changed from: private */
    public boolean quickScaleEnabled;
    /* access modifiers changed from: private */
    public float quickScaleLastDistance;
    /* access modifiers changed from: private */
    public boolean quickScaleMoved;
    /* access modifiers changed from: private */
    public PointF quickScaleSCenter;
    private final float quickScaleThreshold;
    /* access modifiers changed from: private */
    public PointF quickScaleVLastPoint;
    /* access modifiers changed from: private */
    public PointF quickScaleVStart;
    /* access modifiers changed from: private */
    public boolean readySent;
    private DecoderFactory<? extends ImageRegionDecoder> regionDecoderFactory;
    private int sHeight;
    private int sOrientation;
    private PointF sPendingCenter;
    private RectF sRect;
    /* access modifiers changed from: private */
    public Rect sRegion;
    private PointF sRequestedCenter;
    private int sWidth;
    private ScaleAndTranslate satTemp;
    /* access modifiers changed from: private */
    public float scale;
    /* access modifiers changed from: private */
    public float scaleStart;
    private GestureDetector singleDetector;
    private final float[] srcArray;
    private Paint tileBgPaint;
    private Map<Integer, List<Tile>> tileMap;
    private Uri uri;
    /* access modifiers changed from: private */
    public PointF vCenterStart;
    private float vDistStart;
    /* access modifiers changed from: private */
    public PointF vTranslate;
    private PointF vTranslateBefore;
    /* access modifiers changed from: private */
    public PointF vTranslateStart;
    /* access modifiers changed from: private */
    public boolean zoomEnabled;

    private static class Anim {
        /* access modifiers changed from: private */
        public long duration;
        /* access modifiers changed from: private */
        public int easing;
        /* access modifiers changed from: private */
        public boolean interruptible;
        /* access modifiers changed from: private */
        public OnAnimationEventListener listener;
        /* access modifiers changed from: private */
        public int origin;
        /* access modifiers changed from: private */
        public PointF sCenterEnd;
        /* access modifiers changed from: private */
        public PointF sCenterEndRequested;
        /* access modifiers changed from: private */
        public PointF sCenterStart;
        /* access modifiers changed from: private */
        public float scaleEnd;
        /* access modifiers changed from: private */
        public float scaleStart;
        /* access modifiers changed from: private */
        public long time;
        /* access modifiers changed from: private */
        public PointF vFocusEnd;
        /* access modifiers changed from: private */
        public PointF vFocusStart;

        private Anim() {
            this.duration = 500;
            this.interruptible = true;
            this.easing = 2;
            this.origin = 1;
            this.time = System.currentTimeMillis();
        }
    }

    public final class AnimationBuilder {
        private long duration;
        private int easing;
        private boolean interruptible;
        private OnAnimationEventListener listener;
        private int origin;
        private boolean panLimited;
        private final PointF targetSCenter;
        private final float targetScale;
        private final PointF vFocus;

        private AnimationBuilder(float f2) {
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f2;
            this.targetSCenter = SubsamplingScaleImageView.this.getCenter();
            this.vFocus = null;
        }

        private AnimationBuilder(float f2, PointF pointF) {
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f2;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        private AnimationBuilder(float f2, PointF pointF, PointF pointF2) {
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = f2;
            this.targetSCenter = pointF;
            this.vFocus = pointF2;
        }

        private AnimationBuilder(PointF pointF) {
            this.duration = 500;
            this.easing = 2;
            this.origin = 1;
            this.interruptible = true;
            this.panLimited = true;
            this.targetScale = SubsamplingScaleImageView.this.scale;
            this.targetSCenter = pointF;
            this.vFocus = null;
        }

        /* access modifiers changed from: private */
        public AnimationBuilder withOrigin(int i2) {
            this.origin = i2;
            return this;
        }

        /* access modifiers changed from: private */
        public AnimationBuilder withPanLimited(boolean z2) {
            this.panLimited = z2;
            return this;
        }

        public void start() {
            if (!(SubsamplingScaleImageView.this.anim == null || SubsamplingScaleImageView.this.anim.listener == null)) {
                try {
                    SubsamplingScaleImageView.this.anim.listener.onInterruptedByNewAnim();
                } catch (Exception e2) {
                    Log.w(SubsamplingScaleImageView.TAG, "Error thrown by animation listener", e2);
                }
            }
            int paddingLeft = SubsamplingScaleImageView.this.getPaddingLeft() + (((SubsamplingScaleImageView.this.getWidth() - SubsamplingScaleImageView.this.getPaddingRight()) - SubsamplingScaleImageView.this.getPaddingLeft()) / 2);
            int paddingTop = SubsamplingScaleImageView.this.getPaddingTop() + (((SubsamplingScaleImageView.this.getHeight() - SubsamplingScaleImageView.this.getPaddingBottom()) - SubsamplingScaleImageView.this.getPaddingTop()) / 2);
            float access$6500 = SubsamplingScaleImageView.this.limitedScale(this.targetScale);
            PointF access$6600 = this.panLimited ? SubsamplingScaleImageView.this.limitedSCenter(this.targetSCenter.x, this.targetSCenter.y, access$6500, new PointF()) : this.targetSCenter;
            Anim unused = SubsamplingScaleImageView.this.anim = new Anim();
            float unused2 = SubsamplingScaleImageView.this.anim.scaleStart = SubsamplingScaleImageView.this.scale;
            float unused3 = SubsamplingScaleImageView.this.anim.scaleEnd = access$6500;
            long unused4 = SubsamplingScaleImageView.this.anim.time = System.currentTimeMillis();
            PointF unused5 = SubsamplingScaleImageView.this.anim.sCenterEndRequested = access$6600;
            PointF unused6 = SubsamplingScaleImageView.this.anim.sCenterStart = SubsamplingScaleImageView.this.getCenter();
            PointF unused7 = SubsamplingScaleImageView.this.anim.sCenterEnd = access$6600;
            PointF unused8 = SubsamplingScaleImageView.this.anim.vFocusStart = SubsamplingScaleImageView.this.sourceToViewCoord(access$6600);
            PointF unused9 = SubsamplingScaleImageView.this.anim.vFocusEnd = new PointF((float) paddingLeft, (float) paddingTop);
            long unused10 = SubsamplingScaleImageView.this.anim.duration = this.duration;
            boolean unused11 = SubsamplingScaleImageView.this.anim.interruptible = this.interruptible;
            int unused12 = SubsamplingScaleImageView.this.anim.easing = this.easing;
            int unused13 = SubsamplingScaleImageView.this.anim.origin = this.origin;
            long unused14 = SubsamplingScaleImageView.this.anim.time = System.currentTimeMillis();
            OnAnimationEventListener unused15 = SubsamplingScaleImageView.this.anim.listener = this.listener;
            PointF pointF = this.vFocus;
            if (pointF != null) {
                float f2 = pointF.x - (SubsamplingScaleImageView.this.anim.sCenterStart.x * access$6500);
                float f3 = this.vFocus.y - (SubsamplingScaleImageView.this.anim.sCenterStart.y * access$6500);
                ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(access$6500, new PointF(f2, f3));
                SubsamplingScaleImageView.this.fitToBounds(true, scaleAndTranslate);
                PointF unused16 = SubsamplingScaleImageView.this.anim.vFocusEnd = new PointF(this.vFocus.x + (scaleAndTranslate.vTranslate.x - f2), this.vFocus.y + (scaleAndTranslate.vTranslate.y - f3));
            }
            SubsamplingScaleImageView.this.invalidate();
        }

        public AnimationBuilder withDuration(long j2) {
            this.duration = j2;
            return this;
        }

        public AnimationBuilder withEasing(int i2) {
            if (SubsamplingScaleImageView.VALID_EASING_STYLES.contains(Integer.valueOf(i2))) {
                this.easing = i2;
                return this;
            }
            throw new IllegalArgumentException("Unknown easing type: " + i2);
        }

        public AnimationBuilder withInterruptible(boolean z2) {
            this.interruptible = z2;
            return this;
        }

        public AnimationBuilder withOnAnimationEventListener(OnAnimationEventListener onAnimationEventListener) {
            this.listener = onAnimationEventListener;
            return this;
        }
    }

    private static class BitmapLoadTask extends AsyncTask<Void, Void, Integer> {
        private Bitmap bitmap;
        private final WeakReference<Context> contextRef;
        private final WeakReference<DecoderFactory<? extends ImageDecoder>> decoderFactoryRef;
        private Exception exception;
        private final boolean preview;
        private final Uri source;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        BitmapLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageDecoder> decoderFactory, Uri uri, boolean z2) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
            this.source = uri;
            this.preview = z2;
        }

        /* access modifiers changed from: protected */
        public Integer doInBackground(Void... voidArr) {
            try {
                String uri = this.source.toString();
                Context context = (Context) this.contextRef.get();
                DecoderFactory decoderFactory = (DecoderFactory) this.decoderFactoryRef.get();
                SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.viewRef.get();
                if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.debug("BitmapLoadTask.doInBackground", new Object[0]);
                this.bitmap = ((ImageDecoder) decoderFactory.make()).decode(context, this.source);
                return Integer.valueOf(subsamplingScaleImageView.getExifOrientation(context, uri));
            } catch (Exception e2) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to load bitmap", e2);
                this.exception = e2;
                return null;
            } catch (OutOfMemoryError e3) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to load bitmap - OutOfMemoryError", e3);
                this.exception = new RuntimeException(e3);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Integer num) {
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.viewRef.get();
            if (subsamplingScaleImageView != null) {
                Bitmap bitmap2 = this.bitmap;
                if (bitmap2 == null || num == null) {
                    if (this.exception != null && subsamplingScaleImageView.onImageEventListener != null) {
                        if (this.preview) {
                            subsamplingScaleImageView.onImageEventListener.onPreviewLoadError(this.exception);
                        } else {
                            subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                        }
                    }
                } else if (this.preview) {
                    subsamplingScaleImageView.onPreviewLoaded(bitmap2);
                } else {
                    subsamplingScaleImageView.onImageLoaded(bitmap2, num.intValue(), false);
                }
            }
        }
    }

    public static class DefaultOnAnimationEventListener implements OnAnimationEventListener {
        public void onComplete() {
        }

        public void onInterruptedByNewAnim() {
        }

        public void onInterruptedByUser() {
        }
    }

    public static class DefaultOnImageEventListener implements OnImageEventListener {
        public void onImageLoadError(Exception exc) {
        }

        public void onImageLoaded() {
        }

        public void onPreviewLoadError(Exception exc) {
        }

        public void onPreviewReleased() {
        }

        public void onReady() {
        }

        public void onTileLoadError(Exception exc) {
        }
    }

    public static class DefaultOnStateChangedListener implements OnStateChangedListener {
        public void onCenterChanged(PointF pointF, int i2) {
        }

        public void onScaleChanged(float f2, int i2) {
        }
    }

    public interface OnAnimationEventListener {
        void onComplete();

        void onInterruptedByNewAnim();

        void onInterruptedByUser();
    }

    public interface OnImageEventListener {
        void onImageLoadError(Exception exc);

        void onImageLoaded();

        void onPreviewLoadError(Exception exc);

        void onPreviewReleased();

        void onReady();

        void onTileLoadError(Exception exc);
    }

    public interface OnStateChangedListener {
        void onCenterChanged(PointF pointF, int i2);

        void onScaleChanged(float f2, int i2);
    }

    private static class ScaleAndTranslate {
        /* access modifiers changed from: private */
        public float scale;
        /* access modifiers changed from: private */
        public final PointF vTranslate;

        private ScaleAndTranslate(float f2, PointF pointF) {
            this.scale = f2;
            this.vTranslate = pointF;
        }
    }

    private static class Tile {
        /* access modifiers changed from: private */
        public Bitmap bitmap;
        /* access modifiers changed from: private */
        public Rect fileSRect;
        /* access modifiers changed from: private */
        public boolean loading;
        /* access modifiers changed from: private */
        public Rect sRect;
        /* access modifiers changed from: private */
        public int sampleSize;
        /* access modifiers changed from: private */
        public Rect vRect;
        /* access modifiers changed from: private */
        public boolean visible;

        private Tile() {
        }
    }

    private static class TileLoadTask extends AsyncTask<Void, Void, Bitmap> {
        private final WeakReference<ImageRegionDecoder> decoderRef;
        private Exception exception;
        private final WeakReference<Tile> tileRef;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        TileLoadTask(SubsamplingScaleImageView subsamplingScaleImageView, ImageRegionDecoder imageRegionDecoder, Tile tile) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.decoderRef = new WeakReference<>(imageRegionDecoder);
            this.tileRef = new WeakReference<>(tile);
            boolean unused = tile.loading = true;
        }

        /* access modifiers changed from: protected */
        public Bitmap doInBackground(Void... voidArr) {
            SubsamplingScaleImageView subsamplingScaleImageView;
            try {
                subsamplingScaleImageView = (SubsamplingScaleImageView) this.viewRef.get();
                ImageRegionDecoder imageRegionDecoder = (ImageRegionDecoder) this.decoderRef.get();
                Tile tile = (Tile) this.tileRef.get();
                if (imageRegionDecoder != null && tile != null && subsamplingScaleImageView != null && imageRegionDecoder.isReady() && tile.visible) {
                    subsamplingScaleImageView.debug("TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", tile.sRect, Integer.valueOf(tile.sampleSize));
                    subsamplingScaleImageView.decoderLock.readLock().lock();
                    if (imageRegionDecoder.isReady()) {
                        subsamplingScaleImageView.fileSRect(tile.sRect, tile.fileSRect);
                        if (subsamplingScaleImageView.sRegion != null) {
                            tile.fileSRect.offset(subsamplingScaleImageView.sRegion.left, subsamplingScaleImageView.sRegion.top);
                        }
                        Bitmap decodeRegion = imageRegionDecoder.decodeRegion(tile.fileSRect, tile.sampleSize);
                        subsamplingScaleImageView.decoderLock.readLock().unlock();
                        return decodeRegion;
                    }
                    boolean unused = tile.loading = false;
                    subsamplingScaleImageView.decoderLock.readLock().unlock();
                    return null;
                } else if (tile == null) {
                    return null;
                } else {
                    boolean unused2 = tile.loading = false;
                    return null;
                }
            } catch (Exception e2) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to decode tile", e2);
                this.exception = e2;
                return null;
            } catch (OutOfMemoryError e3) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to decode tile - OutOfMemoryError", e3);
                this.exception = new RuntimeException(e3);
                return null;
            } catch (Throwable th) {
                subsamplingScaleImageView.decoderLock.readLock().unlock();
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Bitmap bitmap) {
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.viewRef.get();
            Tile tile = (Tile) this.tileRef.get();
            if (subsamplingScaleImageView != null && tile != null) {
                if (bitmap != null) {
                    Bitmap unused = tile.bitmap = bitmap;
                    boolean unused2 = tile.loading = false;
                    subsamplingScaleImageView.onTileLoaded();
                } else if (this.exception != null && subsamplingScaleImageView.onImageEventListener != null) {
                    subsamplingScaleImageView.onImageEventListener.onTileLoadError(this.exception);
                }
            }
        }
    }

    private static class TilesInitTask extends AsyncTask<Void, Void, int[]> {
        private final WeakReference<Context> contextRef;
        private ImageRegionDecoder decoder;
        private final WeakReference<DecoderFactory<? extends ImageRegionDecoder>> decoderFactoryRef;
        private Exception exception;
        private final Uri source;
        private final WeakReference<SubsamplingScaleImageView> viewRef;

        TilesInitTask(SubsamplingScaleImageView subsamplingScaleImageView, Context context, DecoderFactory<? extends ImageRegionDecoder> decoderFactory, Uri uri) {
            this.viewRef = new WeakReference<>(subsamplingScaleImageView);
            this.contextRef = new WeakReference<>(context);
            this.decoderFactoryRef = new WeakReference<>(decoderFactory);
            this.source = uri;
        }

        /* access modifiers changed from: protected */
        public int[] doInBackground(Void... voidArr) {
            try {
                String uri = this.source.toString();
                Context context = (Context) this.contextRef.get();
                DecoderFactory decoderFactory = (DecoderFactory) this.decoderFactoryRef.get();
                SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.viewRef.get();
                if (context == null || decoderFactory == null || subsamplingScaleImageView == null) {
                    return null;
                }
                subsamplingScaleImageView.debug("TilesInitTask.doInBackground", new Object[0]);
                ImageRegionDecoder imageRegionDecoder = (ImageRegionDecoder) decoderFactory.make();
                this.decoder = imageRegionDecoder;
                Point init = imageRegionDecoder.init(context, this.source);
                int i2 = init.x;
                int i3 = init.y;
                int access$5200 = subsamplingScaleImageView.getExifOrientation(context, uri);
                if (subsamplingScaleImageView.sRegion != null) {
                    subsamplingScaleImageView.sRegion.left = Math.max(0, subsamplingScaleImageView.sRegion.left);
                    subsamplingScaleImageView.sRegion.top = Math.max(0, subsamplingScaleImageView.sRegion.top);
                    subsamplingScaleImageView.sRegion.right = Math.min(i2, subsamplingScaleImageView.sRegion.right);
                    subsamplingScaleImageView.sRegion.bottom = Math.min(i3, subsamplingScaleImageView.sRegion.bottom);
                    i2 = subsamplingScaleImageView.sRegion.width();
                    i3 = subsamplingScaleImageView.sRegion.height();
                }
                return new int[]{i2, i3, access$5200};
            } catch (Exception e2) {
                Log.e(SubsamplingScaleImageView.TAG, "Failed to initialise bitmap decoder", e2);
                this.exception = e2;
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(int[] iArr) {
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.viewRef.get();
            if (subsamplingScaleImageView != null) {
                ImageRegionDecoder imageRegionDecoder = this.decoder;
                if (imageRegionDecoder != null && iArr != null && iArr.length == 3) {
                    subsamplingScaleImageView.onTilesInited(imageRegionDecoder, iArr[0], iArr[1], iArr[2]);
                } else if (this.exception != null && subsamplingScaleImageView.onImageEventListener != null) {
                    subsamplingScaleImageView.onImageEventListener.onImageLoadError(this.exception);
                }
            }
        }
    }

    public SubsamplingScaleImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int resourceId;
        String string;
        this.orientation = 0;
        this.maxScale = 2.0f;
        this.minScale = minScale();
        this.minimumTileDpi = -1;
        this.panLimit = 1;
        this.minimumScaleType = 1;
        this.maxTileWidth = TILE_SIZE_AUTO;
        this.maxTileHeight = TILE_SIZE_AUTO;
        this.executor = AsyncTask.THREAD_POOL_EXECUTOR;
        this.eagerLoadingEnabled = true;
        this.panEnabled = true;
        this.zoomEnabled = true;
        this.quickScaleEnabled = true;
        this.doubleTapZoomScale = 1.0f;
        this.doubleTapZoomStyle = 1;
        this.doubleTapZoomDuration = 500;
        this.decoderLock = new ReentrantReadWriteLock(true);
        this.bitmapDecoderFactory = new CompatDecoderFactory(SkiaImageDecoder.class);
        this.regionDecoderFactory = new CompatDecoderFactory(SkiaImageRegionDecoder.class);
        this.srcArray = new float[8];
        this.dstArray = new float[8];
        this.density = getResources().getDisplayMetrics().density;
        setMinimumDpi(GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL);
        setDoubleTapZoomDpi(GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL);
        setMinimumTileDpi(GlMapUtil.DEVICE_DISPLAY_DPI_HIGH);
        setGestureDetector(context);
        this.handler = new Handler(new Handler.Callback() {
            public boolean handleMessage(Message message) {
                if (message.what == 1 && SubsamplingScaleImageView.this.onLongClickListener != null) {
                    int unused = SubsamplingScaleImageView.this.maxTouchCount = 0;
                    SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                    SubsamplingScaleImageView.super.setOnLongClickListener(subsamplingScaleImageView.onLongClickListener);
                    SubsamplingScaleImageView.this.performLongClick();
                    SubsamplingScaleImageView.super.setOnLongClickListener((View.OnLongClickListener) null);
                }
                return true;
            }
        });
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SubsamplingScaleImageView);
            if (obtainStyledAttributes.hasValue(R.styleable.SubsamplingScaleImageView_assetName) && (string = obtainStyledAttributes.getString(R.styleable.SubsamplingScaleImageView_assetName)) != null && string.length() > 0) {
                setImage(ImageSource.asset(string).tilingEnabled());
            }
            if (obtainStyledAttributes.hasValue(R.styleable.SubsamplingScaleImageView_src) && (resourceId = obtainStyledAttributes.getResourceId(R.styleable.SubsamplingScaleImageView_src, 0)) > 0) {
                setImage(ImageSource.resource(resourceId).tilingEnabled());
            }
            if (obtainStyledAttributes.hasValue(R.styleable.SubsamplingScaleImageView_panEnabled)) {
                setPanEnabled(obtainStyledAttributes.getBoolean(R.styleable.SubsamplingScaleImageView_panEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.SubsamplingScaleImageView_zoomEnabled)) {
                setZoomEnabled(obtainStyledAttributes.getBoolean(R.styleable.SubsamplingScaleImageView_zoomEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.SubsamplingScaleImageView_quickScaleEnabled)) {
                setQuickScaleEnabled(obtainStyledAttributes.getBoolean(R.styleable.SubsamplingScaleImageView_quickScaleEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(R.styleable.SubsamplingScaleImageView_tileBackgroundColor)) {
                setTileBackgroundColor(obtainStyledAttributes.getColor(R.styleable.SubsamplingScaleImageView_tileBackgroundColor, Color.argb(0, 0, 0, 0)));
            }
            obtainStyledAttributes.recycle();
        }
        this.quickScaleThreshold = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    private int calculateInSampleSize(float f2) {
        int i2;
        if (this.minimumTileDpi > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f2 *= ((float) this.minimumTileDpi) / ((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f);
        }
        int sWidth2 = (int) (((float) sWidth()) * f2);
        int sHeight2 = (int) (((float) sHeight()) * f2);
        if (sWidth2 == 0 || sHeight2 == 0) {
            return 32;
        }
        int i3 = 1;
        if (sHeight() > sHeight2 || sWidth() > sWidth2) {
            i2 = Math.round(((float) sHeight()) / ((float) sHeight2));
            int round = Math.round(((float) sWidth()) / ((float) sWidth2));
            if (i2 >= round) {
                i2 = round;
            }
        } else {
            i2 = 1;
        }
        while (true) {
            int i4 = i3 * 2;
            if (i4 >= i2) {
                return i3;
            }
            i3 = i4;
        }
    }

    private boolean checkImageLoaded() {
        boolean isBaseLayerReady = isBaseLayerReady();
        if (!this.imageLoadedSent && isBaseLayerReady) {
            preDraw();
            this.imageLoadedSent = true;
            onImageLoaded();
            OnImageEventListener onImageEventListener2 = this.onImageEventListener;
            if (onImageEventListener2 != null) {
                onImageEventListener2.onImageLoaded();
            }
        }
        return isBaseLayerReady;
    }

    private boolean checkReady() {
        boolean z2 = getWidth() > 0 && getHeight() > 0 && this.sWidth > 0 && this.sHeight > 0 && (this.bitmap != null || isBaseLayerReady());
        if (!this.readySent && z2) {
            preDraw();
            this.readySent = true;
            onReady();
            OnImageEventListener onImageEventListener2 = this.onImageEventListener;
            if (onImageEventListener2 != null) {
                onImageEventListener2.onReady();
            }
        }
        return z2;
    }

    private void createPaints() {
        if (this.bitmapPaint == null) {
            Paint paint = new Paint();
            this.bitmapPaint = paint;
            paint.setAntiAlias(true);
            this.bitmapPaint.setFilterBitmap(true);
            this.bitmapPaint.setDither(true);
        }
        if ((this.debugTextPaint == null || this.debugLinePaint == null) && this.debug) {
            Paint paint2 = new Paint();
            this.debugTextPaint = paint2;
            paint2.setTextSize((float) px(12));
            this.debugTextPaint.setColor(-65281);
            this.debugTextPaint.setStyle(Paint.Style.FILL);
            Paint paint3 = new Paint();
            this.debugLinePaint = paint3;
            paint3.setColor(-65281);
            this.debugLinePaint.setStyle(Paint.Style.STROKE);
            this.debugLinePaint.setStrokeWidth((float) px(1));
        }
    }

    /* access modifiers changed from: private */
    public void debug(String str, Object... objArr) {
        if (this.debug) {
            Log.d(TAG, String.format(str, objArr));
        }
    }

    private float distance(float f2, float f3, float f4, float f5) {
        float f6 = f2 - f3;
        float f7 = f4 - f5;
        return (float) Math.sqrt((double) ((f6 * f6) + (f7 * f7)));
    }

    /* access modifiers changed from: private */
    public void doubleTapZoom(PointF pointF, PointF pointF2) {
        AnimationBuilder animationBuilder;
        float f2;
        if (!this.panEnabled) {
            PointF pointF3 = this.sRequestedCenter;
            if (pointF3 != null) {
                pointF.x = pointF3.x;
                f2 = this.sRequestedCenter.y;
            } else {
                pointF.x = (float) (sWidth() / 2);
                f2 = (float) (sHeight() / 2);
            }
            pointF.y = f2;
        }
        float min = Math.min(this.maxScale, this.doubleTapZoomScale);
        float f3 = this.scale;
        double d2 = (double) min;
        Double.isNaN(d2);
        boolean z2 = ((double) f3) <= d2 * 0.9d || f3 == this.minScale;
        if (!z2) {
            min = minScale();
        }
        float f4 = min;
        int i2 = this.doubleTapZoomStyle;
        if (i2 == 3) {
            setScaleAndCenter(f4, pointF);
        } else {
            if (i2 == 2 || !z2 || !this.panEnabled) {
                animationBuilder = new AnimationBuilder(f4, pointF).withInterruptible(false);
            } else if (i2 == 1) {
                animationBuilder = new AnimationBuilder(f4, pointF, pointF2).withInterruptible(false);
            }
            animationBuilder.withDuration((long) this.doubleTapZoomDuration).withOrigin(4).start();
        }
        invalidate();
    }

    private float ease(int i2, long j2, float f2, float f3, long j3) {
        if (i2 == 1) {
            return easeOutQuad(j2, f2, f3, j3);
        }
        if (i2 == 2) {
            return easeInOutQuad(j2, f2, f3, j3);
        }
        throw new IllegalStateException("Unexpected easing type: " + i2);
    }

    private float easeInOutQuad(long j2, float f2, float f3, long j3) {
        float f4;
        float f5 = ((float) j2) / (((float) j3) / 2.0f);
        if (f5 < 1.0f) {
            f4 = (f3 / 2.0f) * f5;
        } else {
            float f6 = f5 - 1.0f;
            f4 = (-f3) / 2.0f;
            f5 = (f6 * (f6 - 2.0f)) - 1.0f;
        }
        return (f4 * f5) + f2;
    }

    private float easeOutQuad(long j2, float f2, float f3, long j3) {
        float f4 = ((float) j2) / ((float) j3);
        return ((-f3) * f4 * (f4 - 2.0f)) + f2;
    }

    private void execute(AsyncTask<Void, Void, ?> asyncTask) {
        asyncTask.executeOnExecutor(this.executor, new Void[0]);
    }

    /* access modifiers changed from: private */
    public void fileSRect(Rect rect, Rect rect2) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (getRequiredRotation() == 0) {
            rect2.set(rect);
            return;
        }
        if (getRequiredRotation() == 90) {
            i2 = rect.top;
            i3 = this.sHeight - rect.right;
            i4 = rect.bottom;
            i5 = this.sHeight;
            i6 = rect.left;
        } else if (getRequiredRotation() == 180) {
            i2 = this.sWidth - rect.right;
            i3 = this.sHeight - rect.bottom;
            i4 = this.sWidth - rect.left;
            i5 = this.sHeight;
            i6 = rect.top;
        } else {
            rect2.set(this.sWidth - rect.bottom, rect.left, this.sWidth - rect.top, rect.right);
            return;
        }
        rect2.set(i2, i3, i4, i5 - i6);
    }

    private void fitToBounds(boolean z2) {
        boolean z3;
        if (this.vTranslate == null) {
            z3 = true;
            this.vTranslate = new PointF(0.0f, 0.0f);
        } else {
            z3 = false;
        }
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        }
        float unused = this.satTemp.scale = this.scale;
        this.satTemp.vTranslate.set(this.vTranslate);
        fitToBounds(z2, this.satTemp);
        this.scale = this.satTemp.scale;
        this.vTranslate.set(this.satTemp.vTranslate);
        if (z3 && this.minimumScaleType != 4) {
            this.vTranslate.set(vTranslateForSCenter((float) (sWidth() / 2), (float) (sHeight() / 2), this.scale));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ce  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void fitToBounds(boolean r12, com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.ScaleAndTranslate r13) {
        /*
            r11 = this;
            int r0 = r11.panLimit
            r1 = 0
            r2 = 2
            if (r0 != r2) goto L_0x000d
            boolean r0 = r11.isReady()
            if (r0 == 0) goto L_0x000d
            r12 = 0
        L_0x000d:
            android.graphics.PointF r0 = r13.vTranslate
            float r3 = r13.scale
            float r3 = r11.limitedScale(r3)
            int r4 = r11.sWidth()
            float r4 = (float) r4
            float r4 = r4 * r3
            int r5 = r11.sHeight()
            float r5 = (float) r5
            float r5 = r5 * r3
            int r6 = r11.panLimit
            r7 = 3
            if (r6 != r7) goto L_0x0049
            boolean r6 = r11.isReady()
            if (r6 == 0) goto L_0x0049
            float r6 = r0.x
            int r8 = r11.getWidth()
            int r8 = r8 / r2
            float r8 = (float) r8
            float r8 = r8 - r4
            float r6 = java.lang.Math.max(r6, r8)
            r0.x = r6
            float r6 = r0.y
            int r8 = r11.getHeight()
            int r8 = r8 / r2
            goto L_0x005f
        L_0x0049:
            float r6 = r0.x
            if (r12 == 0) goto L_0x0062
            int r8 = r11.getWidth()
            float r8 = (float) r8
            float r8 = r8 - r4
            float r6 = java.lang.Math.max(r6, r8)
            r0.x = r6
            float r6 = r0.y
            int r8 = r11.getHeight()
        L_0x005f:
            float r8 = (float) r8
            float r8 = r8 - r5
            goto L_0x006c
        L_0x0062:
            float r8 = -r4
            float r6 = java.lang.Math.max(r6, r8)
            r0.x = r6
            float r6 = r0.y
            float r8 = -r5
        L_0x006c:
            float r6 = java.lang.Math.max(r6, r8)
            r0.y = r6
            int r6 = r11.getPaddingLeft()
            r8 = 1056964608(0x3f000000, float:0.5)
            if (r6 > 0) goto L_0x0084
            int r6 = r11.getPaddingRight()
            if (r6 <= 0) goto L_0x0081
            goto L_0x0084
        L_0x0081:
            r6 = 1056964608(0x3f000000, float:0.5)
            goto L_0x0094
        L_0x0084:
            int r6 = r11.getPaddingLeft()
            float r6 = (float) r6
            int r9 = r11.getPaddingLeft()
            int r10 = r11.getPaddingRight()
            int r9 = r9 + r10
            float r9 = (float) r9
            float r6 = r6 / r9
        L_0x0094:
            int r9 = r11.getPaddingTop()
            if (r9 > 0) goto L_0x00a0
            int r9 = r11.getPaddingBottom()
            if (r9 <= 0) goto L_0x00b0
        L_0x00a0:
            int r8 = r11.getPaddingTop()
            float r8 = (float) r8
            int r9 = r11.getPaddingTop()
            int r10 = r11.getPaddingBottom()
            int r9 = r9 + r10
            float r9 = (float) r9
            float r8 = r8 / r9
        L_0x00b0:
            int r9 = r11.panLimit
            if (r9 != r7) goto L_0x00ce
            boolean r7 = r11.isReady()
            if (r7 == 0) goto L_0x00ce
            int r12 = r11.getWidth()
            int r12 = r12 / r2
            int r12 = java.lang.Math.max(r1, r12)
            float r12 = (float) r12
            int r4 = r11.getHeight()
            int r4 = r4 / r2
            int r1 = java.lang.Math.max(r1, r4)
            goto L_0x00fb
        L_0x00ce:
            if (r12 == 0) goto L_0x00ea
            int r12 = r11.getWidth()
            float r12 = (float) r12
            float r12 = r12 - r4
            float r12 = r12 * r6
            r1 = 0
            float r12 = java.lang.Math.max(r1, r12)
            int r2 = r11.getHeight()
            float r2 = (float) r2
            float r2 = r2 - r5
            float r2 = r2 * r8
            float r1 = java.lang.Math.max(r1, r2)
            goto L_0x00fc
        L_0x00ea:
            int r12 = r11.getWidth()
            int r12 = java.lang.Math.max(r1, r12)
            float r12 = (float) r12
            int r2 = r11.getHeight()
            int r1 = java.lang.Math.max(r1, r2)
        L_0x00fb:
            float r1 = (float) r1
        L_0x00fc:
            float r2 = r0.x
            float r12 = java.lang.Math.min(r2, r12)
            r0.x = r12
            float r12 = r0.y
            float r12 = java.lang.Math.min(r12, r1)
            r0.y = r12
            float unused = r13.scale = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.fitToBounds(boolean, com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$ScaleAndTranslate):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0059, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        android.util.Log.w(TAG, "Could not get orientation of image from media store");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0065, code lost:
        if (r0 != null) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0067, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006a, code lost:
        throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return 0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x005b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getExifOrientation(android.content.Context r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "content"
            boolean r0 = r11.startsWith(r0)
            r1 = 0
            if (r0 == 0) goto L_0x006b
            r0 = 0
            java.lang.String r2 = "orientation"
            java.lang.String[] r5 = new java.lang.String[]{r2}     // Catch:{ Exception -> 0x005b }
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ Exception -> 0x005b }
            android.net.Uri r4 = android.net.Uri.parse(r11)     // Catch:{ Exception -> 0x005b }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r0 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x005b }
            if (r0 == 0) goto L_0x0052
            boolean r10 = r0.moveToFirst()     // Catch:{ Exception -> 0x005b }
            if (r10 == 0) goto L_0x0052
            int r10 = r0.getInt(r1)     // Catch:{ Exception -> 0x005b }
            java.util.List<java.lang.Integer> r11 = VALID_ORIENTATIONS     // Catch:{ Exception -> 0x005b }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x005b }
            boolean r11 = r11.contains(r2)     // Catch:{ Exception -> 0x005b }
            if (r11 == 0) goto L_0x003c
            r11 = -1
            if (r10 == r11) goto L_0x003c
            r1 = r10
            goto L_0x0052
        L_0x003c:
            java.lang.String r11 = TAG     // Catch:{ Exception -> 0x005b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005b }
            r2.<init>()     // Catch:{ Exception -> 0x005b }
            java.lang.String r3 = "Unsupported orientation: "
            r2.append(r3)     // Catch:{ Exception -> 0x005b }
            r2.append(r10)     // Catch:{ Exception -> 0x005b }
            java.lang.String r10 = r2.toString()     // Catch:{ Exception -> 0x005b }
            android.util.Log.w(r11, r10)     // Catch:{ Exception -> 0x005b }
        L_0x0052:
            if (r0 == 0) goto L_0x00c8
        L_0x0054:
            r0.close()
            goto L_0x00c8
        L_0x0059:
            r10 = move-exception
            goto L_0x0065
        L_0x005b:
            java.lang.String r10 = TAG     // Catch:{ all -> 0x0059 }
            java.lang.String r11 = "Could not get orientation of image from media store"
            android.util.Log.w(r10, r11)     // Catch:{ all -> 0x0059 }
            if (r0 == 0) goto L_0x00c8
            goto L_0x0054
        L_0x0065:
            if (r0 == 0) goto L_0x006a
            r0.close()
        L_0x006a:
            throw r10
        L_0x006b:
            java.lang.String r10 = "file:///"
            boolean r10 = r11.startsWith(r10)
            if (r10 == 0) goto L_0x00c8
            java.lang.String r10 = "file:///android_asset/"
            boolean r10 = r11.startsWith(r10)
            if (r10 != 0) goto L_0x00c8
            z.a r10 = new z.a     // Catch:{ Exception -> 0x00c1 }
            r0 = 7
            java.lang.String r11 = r11.substring(r0)     // Catch:{ Exception -> 0x00c1 }
            r10.<init>((java.lang.String) r11)     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r11 = "Orientation"
            r0 = 1
            int r10 = r10.a((java.lang.String) r11, (int) r0)     // Catch:{ Exception -> 0x00c1 }
            if (r10 == r0) goto L_0x00c8
            if (r10 != 0) goto L_0x0091
            goto L_0x00c8
        L_0x0091:
            r11 = 6
            if (r10 != r11) goto L_0x0099
            r10 = 90
            r1 = 90
            goto L_0x00c8
        L_0x0099:
            r11 = 3
            if (r10 != r11) goto L_0x00a1
            r10 = 180(0xb4, float:2.52E-43)
            r1 = 180(0xb4, float:2.52E-43)
            goto L_0x00c8
        L_0x00a1:
            r11 = 8
            if (r10 != r11) goto L_0x00aa
            r10 = 270(0x10e, float:3.78E-43)
            r1 = 270(0x10e, float:3.78E-43)
            goto L_0x00c8
        L_0x00aa:
            java.lang.String r11 = TAG     // Catch:{ Exception -> 0x00c1 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00c1 }
            r0.<init>()     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r2 = "Unsupported EXIF orientation: "
            r0.append(r2)     // Catch:{ Exception -> 0x00c1 }
            r0.append(r10)     // Catch:{ Exception -> 0x00c1 }
            java.lang.String r10 = r0.toString()     // Catch:{ Exception -> 0x00c1 }
            android.util.Log.w(r11, r10)     // Catch:{ Exception -> 0x00c1 }
            goto L_0x00c8
        L_0x00c1:
            java.lang.String r10 = TAG
            java.lang.String r11 = "Could not get EXIF orientation of image"
            android.util.Log.w(r10, r11)
        L_0x00c8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.getExifOrientation(android.content.Context, java.lang.String):int");
    }

    private Point getMaxBitmapDimensions(Canvas canvas) {
        return new Point(Math.min(canvas.getMaximumBitmapWidth(), this.maxTileWidth), Math.min(canvas.getMaximumBitmapHeight(), this.maxTileHeight));
    }

    public static Bitmap.Config getPreferredBitmapConfig() {
        return preferredBitmapConfig;
    }

    private int getRequiredRotation() {
        int i2 = this.orientation;
        return i2 == -1 ? this.sOrientation : i2;
    }

    private synchronized void initialiseBaseLayer(Point point) {
        debug("initialiseBaseLayer maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        ScaleAndTranslate scaleAndTranslate = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        this.satTemp = scaleAndTranslate;
        fitToBounds(true, scaleAndTranslate);
        int calculateInSampleSize = calculateInSampleSize(this.satTemp.scale);
        this.fullImageSampleSize = calculateInSampleSize;
        if (calculateInSampleSize > 1) {
            this.fullImageSampleSize = calculateInSampleSize / 2;
        }
        if (this.fullImageSampleSize != 1 || this.sRegion != null || sWidth() >= point.x || sHeight() >= point.y) {
            initialiseTileMap(point);
            for (Tile tileLoadTask : this.tileMap.get(Integer.valueOf(this.fullImageSampleSize))) {
                execute(new TileLoadTask(this, this.decoder, tileLoadTask));
            }
            refreshRequiredTiles(true);
        } else {
            this.decoder.recycle();
            this.decoder = null;
            execute(new BitmapLoadTask(this, getContext(), this.bitmapDecoderFactory, this.uri, false));
        }
    }

    private void initialiseTileMap(Point point) {
        Point point2 = point;
        int i2 = 1;
        debug("initialiseTileMap maxTileDimensions=%dx%d", Integer.valueOf(point2.x), Integer.valueOf(point2.y));
        this.tileMap = new LinkedHashMap();
        int i3 = this.fullImageSampleSize;
        int i4 = 1;
        int i5 = 1;
        while (true) {
            int sWidth2 = sWidth() / i4;
            int sHeight2 = sHeight() / i5;
            int i6 = sWidth2 / i3;
            int i7 = sHeight2 / i3;
            while (true) {
                if (i6 + i4 + i2 <= point2.x) {
                    double d2 = (double) i6;
                    double width = (double) getWidth();
                    Double.isNaN(width);
                    if (d2 <= width * 1.25d || i3 >= this.fullImageSampleSize) {
                    }
                }
                i4++;
                sWidth2 = sWidth() / i4;
                i6 = sWidth2 / i3;
                i2 = 1;
            }
            while (true) {
                if (i7 + i5 + i2 <= point2.y) {
                    double height = (double) getHeight();
                    Double.isNaN(height);
                    if (((double) i7) <= height * 1.25d || i3 >= this.fullImageSampleSize) {
                        ArrayList arrayList = new ArrayList(i4 * i5);
                        int i8 = 0;
                    }
                }
                i5++;
                sHeight2 = sHeight() / i5;
                i7 = sHeight2 / i3;
                i2 = 1;
            }
            ArrayList arrayList2 = new ArrayList(i4 * i5);
            int i82 = 0;
            while (i82 < i4) {
                int i9 = 0;
                while (i9 < i5) {
                    Tile tile = new Tile();
                    int unused = tile.sampleSize = i3;
                    boolean unused2 = tile.visible = i3 == this.fullImageSampleSize;
                    Rect unused3 = tile.sRect = new Rect(i82 * sWidth2, i9 * sHeight2, i82 == i4 + -1 ? sWidth() : (i82 + 1) * sWidth2, i9 == i5 + -1 ? sHeight() : (i9 + 1) * sHeight2);
                    Rect unused4 = tile.vRect = new Rect(0, 0, 0, 0);
                    Rect unused5 = tile.fileSRect = new Rect(tile.sRect);
                    arrayList2.add(tile);
                    i9++;
                }
                i82++;
            }
            this.tileMap.put(Integer.valueOf(i3), arrayList2);
            if (i3 != 1) {
                i3 /= 2;
                i2 = 1;
            } else {
                return;
            }
        }
    }

    private boolean isBaseLayerReady() {
        boolean z2 = true;
        if (this.bitmap != null && !this.bitmapIsPreview) {
            return true;
        }
        Map<Integer, List<Tile>> map = this.tileMap;
        if (map == null) {
            return false;
        }
        for (Map.Entry next : map.entrySet()) {
            if (((Integer) next.getKey()).intValue() == this.fullImageSampleSize) {
                for (Tile tile : (List) next.getValue()) {
                    if (tile.loading || tile.bitmap == null) {
                        z2 = false;
                    }
                }
            }
        }
        return z2;
    }

    /* access modifiers changed from: private */
    public PointF limitedSCenter(float f2, float f3, float f4, PointF pointF) {
        PointF vTranslateForSCenter = vTranslateForSCenter(f2, f3, f4);
        pointF.set((((float) (getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2))) - vTranslateForSCenter.x) / f4, (((float) (getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2))) - vTranslateForSCenter.y) / f4);
        return pointF;
    }

    /* access modifiers changed from: private */
    public float limitedScale(float f2) {
        return Math.min(this.maxScale, Math.max(minScale(), f2));
    }

    private float minScale() {
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int i2 = this.minimumScaleType;
        if (i2 == 2 || i2 == 4) {
            return Math.max(((float) (getWidth() - paddingLeft)) / ((float) sWidth()), ((float) (getHeight() - paddingBottom)) / ((float) sHeight()));
        }
        if (i2 == 3) {
            float f2 = this.minScale;
            if (f2 > 0.0f) {
                return f2;
            }
        }
        return Math.min(((float) (getWidth() - paddingLeft)) / ((float) sWidth()), ((float) (getHeight() - paddingBottom)) / ((float) sHeight()));
    }

    /* access modifiers changed from: private */
    public synchronized void onImageLoaded(Bitmap bitmap2, int i2, boolean z2) {
        OnImageEventListener onImageEventListener2;
        debug("onImageLoaded", new Object[0]);
        int i3 = this.sWidth;
        if (i3 > 0 && this.sHeight > 0 && !(i3 == bitmap2.getWidth() && this.sHeight == bitmap2.getHeight())) {
            reset(false);
        }
        Bitmap bitmap3 = this.bitmap;
        if (bitmap3 != null && !this.bitmapIsCached) {
            bitmap3.recycle();
        }
        if (!(this.bitmap == null || !this.bitmapIsCached || (onImageEventListener2 = this.onImageEventListener) == null)) {
            onImageEventListener2.onPreviewReleased();
        }
        this.bitmapIsPreview = false;
        this.bitmapIsCached = z2;
        this.bitmap = bitmap2;
        this.sWidth = bitmap2.getWidth();
        this.sHeight = bitmap2.getHeight();
        this.sOrientation = i2;
        boolean checkReady = checkReady();
        boolean checkImageLoaded = checkImageLoaded();
        if (checkReady || checkImageLoaded) {
            invalidate();
            requestLayout();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onPreviewLoaded(android.graphics.Bitmap r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "onPreviewLoaded"
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0044 }
            r4.debug(r0, r1)     // Catch:{ all -> 0x0044 }
            android.graphics.Bitmap r0 = r4.bitmap     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x003f
            boolean r0 = r4.imageLoadedSent     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0012
            goto L_0x003f
        L_0x0012:
            android.graphics.Rect r0 = r4.pRegion     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x002c
            int r0 = r0.left     // Catch:{ all -> 0x0044 }
            android.graphics.Rect r1 = r4.pRegion     // Catch:{ all -> 0x0044 }
            int r1 = r1.top     // Catch:{ all -> 0x0044 }
            android.graphics.Rect r2 = r4.pRegion     // Catch:{ all -> 0x0044 }
            int r2 = r2.width()     // Catch:{ all -> 0x0044 }
            android.graphics.Rect r3 = r4.pRegion     // Catch:{ all -> 0x0044 }
            int r3 = r3.height()     // Catch:{ all -> 0x0044 }
            android.graphics.Bitmap r5 = android.graphics.Bitmap.createBitmap(r5, r0, r1, r2, r3)     // Catch:{ all -> 0x0044 }
        L_0x002c:
            r4.bitmap = r5     // Catch:{ all -> 0x0044 }
            r5 = 1
            r4.bitmapIsPreview = r5     // Catch:{ all -> 0x0044 }
            boolean r5 = r4.checkReady()     // Catch:{ all -> 0x0044 }
            if (r5 == 0) goto L_0x003d
            r4.invalidate()     // Catch:{ all -> 0x0044 }
            r4.requestLayout()     // Catch:{ all -> 0x0044 }
        L_0x003d:
            monitor-exit(r4)
            return
        L_0x003f:
            r5.recycle()     // Catch:{ all -> 0x0044 }
            monitor-exit(r4)
            return
        L_0x0044:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.onPreviewLoaded(android.graphics.Bitmap):void");
    }

    /* access modifiers changed from: private */
    public synchronized void onTileLoaded() {
        Bitmap bitmap2;
        debug("onTileLoaded", new Object[0]);
        checkReady();
        checkImageLoaded();
        if (isBaseLayerReady() && (bitmap2 = this.bitmap) != null) {
            if (!this.bitmapIsCached) {
                bitmap2.recycle();
            }
            this.bitmap = null;
            OnImageEventListener onImageEventListener2 = this.onImageEventListener;
            if (onImageEventListener2 != null && this.bitmapIsCached) {
                onImageEventListener2.onPreviewReleased();
            }
            this.bitmapIsPreview = false;
            this.bitmapIsCached = false;
        }
        invalidate();
    }

    /* access modifiers changed from: private */
    public synchronized void onTilesInited(ImageRegionDecoder imageRegionDecoder, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        debug("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.orientation));
        int i8 = this.sWidth;
        if (i8 > 0 && (i7 = this.sHeight) > 0 && !(i8 == i2 && i7 == i3)) {
            reset(false);
            Bitmap bitmap2 = this.bitmap;
            if (bitmap2 != null) {
                if (!this.bitmapIsCached) {
                    bitmap2.recycle();
                }
                this.bitmap = null;
                OnImageEventListener onImageEventListener2 = this.onImageEventListener;
                if (onImageEventListener2 != null && this.bitmapIsCached) {
                    onImageEventListener2.onPreviewReleased();
                }
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            }
        }
        this.decoder = imageRegionDecoder;
        this.sWidth = i2;
        this.sHeight = i3;
        this.sOrientation = i4;
        checkReady();
        if (!checkImageLoaded() && (i5 = this.maxTileWidth) > 0 && i5 != Integer.MAX_VALUE && (i6 = this.maxTileHeight) > 0 && i6 != Integer.MAX_VALUE && getWidth() > 0 && getHeight() > 0) {
            initialiseBaseLayer(new Point(this.maxTileWidth, this.maxTileHeight));
        }
        invalidate();
        requestLayout();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        if (r1 != 262) goto L_0x03ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0127, code lost:
        if ((r12.scale * ((float) sWidth())) >= ((float) getWidth())) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x028c, code lost:
        if ((r12.scale * ((float) sWidth())) >= ((float) getWidth())) goto L_0x028e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x03e5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean onTouchEventInternal(android.view.MotionEvent r13) {
        /*
            r12 = this;
            int r0 = r13.getPointerCount()
            int r1 = r13.getAction()
            r2 = 1073741824(0x40000000, float:2.0)
            r3 = 2
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x045a
            if (r1 == r5) goto L_0x03ef
            if (r1 == r3) goto L_0x0023
            r6 = 5
            if (r1 == r6) goto L_0x045a
            r6 = 6
            if (r1 == r6) goto L_0x03ef
            r6 = 261(0x105, float:3.66E-43)
            if (r1 == r6) goto L_0x045a
            r2 = 262(0x106, float:3.67E-43)
            if (r1 == r2) goto L_0x03ef
            goto L_0x03ee
        L_0x0023:
            int r1 = r12.maxTouchCount
            if (r1 <= 0) goto L_0x03e2
            r1 = 1084227584(0x40a00000, float:5.0)
            if (r0 < r3) goto L_0x0192
            float r0 = r13.getX(r4)
            float r6 = r13.getX(r5)
            float r7 = r13.getY(r4)
            float r8 = r13.getY(r5)
            float r0 = r12.distance(r0, r6, r7, r8)
            float r6 = r13.getX(r4)
            float r7 = r13.getX(r5)
            float r6 = r6 + r7
            float r6 = r6 / r2
            float r7 = r13.getY(r4)
            float r13 = r13.getY(r5)
            float r7 = r7 + r13
            float r7 = r7 / r2
            boolean r13 = r12.zoomEnabled
            if (r13 == 0) goto L_0x03e2
            android.graphics.PointF r13 = r12.vCenterStart
            float r13 = r13.x
            android.graphics.PointF r2 = r12.vCenterStart
            float r2 = r2.y
            float r13 = r12.distance(r13, r6, r2, r7)
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 > 0) goto L_0x0077
            float r13 = r12.vDistStart
            float r13 = r0 - r13
            float r13 = java.lang.Math.abs(r13)
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 > 0) goto L_0x0077
            boolean r13 = r12.isPanning
            if (r13 == 0) goto L_0x03e2
        L_0x0077:
            r12.isZooming = r5
            r12.isPanning = r5
            float r13 = r12.scale
            double r1 = (double) r13
            float r13 = r12.maxScale
            float r8 = r12.vDistStart
            float r8 = r0 / r8
            float r9 = r12.scaleStart
            float r8 = r8 * r9
            float r13 = java.lang.Math.min(r13, r8)
            r12.scale = r13
            float r8 = r12.minScale()
            int r13 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r13 > 0) goto L_0x00ac
            r12.vDistStart = r0
            float r13 = r12.minScale()
            r12.scaleStart = r13
            android.graphics.PointF r13 = r12.vCenterStart
            r13.set(r6, r7)
            android.graphics.PointF r13 = r12.vTranslateStart
            android.graphics.PointF r0 = r12.vTranslate
            r13.set(r0)
            goto L_0x02fb
        L_0x00ac:
            boolean r13 = r12.panEnabled
            if (r13 == 0) goto L_0x0140
            android.graphics.PointF r13 = r12.vCenterStart
            float r13 = r13.x
            android.graphics.PointF r3 = r12.vTranslateStart
            float r3 = r3.x
            float r13 = r13 - r3
            android.graphics.PointF r3 = r12.vCenterStart
            float r3 = r3.y
            android.graphics.PointF r8 = r12.vTranslateStart
            float r8 = r8.y
            float r3 = r3 - r8
            float r8 = r12.scale
            float r9 = r12.scaleStart
            float r10 = r8 / r9
            float r13 = r13 * r10
            float r8 = r8 / r9
            float r3 = r3 * r8
            android.graphics.PointF r8 = r12.vTranslate
            float r13 = r6 - r13
            r8.x = r13
            android.graphics.PointF r13 = r12.vTranslate
            float r3 = r7 - r3
            r13.y = r3
            int r13 = r12.sHeight()
            double r8 = (double) r13
            java.lang.Double.isNaN(r1)
            java.lang.Double.isNaN(r8)
            double r8 = r8 * r1
            int r13 = r12.getHeight()
            double r10 = (double) r13
            int r13 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r13 >= 0) goto L_0x0101
            float r13 = r12.scale
            int r3 = r12.sHeight()
            float r3 = (float) r3
            float r13 = r13 * r3
            int r3 = r12.getHeight()
            float r3 = (float) r3
            int r13 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r13 >= 0) goto L_0x0129
        L_0x0101:
            int r13 = r12.sWidth()
            double r8 = (double) r13
            java.lang.Double.isNaN(r1)
            java.lang.Double.isNaN(r8)
            double r1 = r1 * r8
            int r13 = r12.getWidth()
            double r8 = (double) r13
            int r13 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r13 >= 0) goto L_0x02fb
            float r13 = r12.scale
            int r1 = r12.sWidth()
            float r1 = (float) r1
            float r13 = r13 * r1
            int r1 = r12.getWidth()
            float r1 = (float) r1
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 < 0) goto L_0x02fb
        L_0x0129:
            r12.fitToBounds(r5)
            android.graphics.PointF r13 = r12.vCenterStart
            r13.set(r6, r7)
            android.graphics.PointF r13 = r12.vTranslateStart
            android.graphics.PointF r1 = r12.vTranslate
            r13.set(r1)
            float r13 = r12.scale
            r12.scaleStart = r13
            r12.vDistStart = r0
            goto L_0x02fb
        L_0x0140:
            android.graphics.PointF r13 = r12.sRequestedCenter
            if (r13 == 0) goto L_0x0166
            android.graphics.PointF r13 = r12.vTranslate
            int r0 = r12.getWidth()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r12.scale
            android.graphics.PointF r2 = r12.sRequestedCenter
            float r2 = r2.x
            float r1 = r1 * r2
            float r0 = r0 - r1
            r13.x = r0
            android.graphics.PointF r13 = r12.vTranslate
            int r0 = r12.getHeight()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r12.scale
            android.graphics.PointF r2 = r12.sRequestedCenter
            float r2 = r2.y
            goto L_0x018b
        L_0x0166:
            android.graphics.PointF r13 = r12.vTranslate
            int r0 = r12.getWidth()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r12.scale
            int r2 = r12.sWidth()
            int r2 = r2 / r3
            float r2 = (float) r2
            float r1 = r1 * r2
            float r0 = r0 - r1
            r13.x = r0
            android.graphics.PointF r13 = r12.vTranslate
            int r0 = r12.getHeight()
            int r0 = r0 / r3
            float r0 = (float) r0
            float r1 = r12.scale
            int r2 = r12.sHeight()
            int r2 = r2 / r3
            float r2 = (float) r2
        L_0x018b:
            float r1 = r1 * r2
            float r0 = r0 - r1
            r13.y = r0
            goto L_0x02fb
        L_0x0192:
            boolean r0 = r12.isQuickScaling
            if (r0 == 0) goto L_0x0306
            android.graphics.PointF r0 = r12.quickScaleVStart
            float r0 = r0.y
            float r1 = r13.getY()
            float r0 = r0 - r1
            float r0 = java.lang.Math.abs(r0)
            float r0 = r0 * r2
            float r1 = r12.quickScaleThreshold
            float r0 = r0 + r1
            float r1 = r12.quickScaleLastDistance
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x01b2
            r12.quickScaleLastDistance = r0
        L_0x01b2:
            float r1 = r13.getY()
            android.graphics.PointF r2 = r12.quickScaleVLastPoint
            float r2 = r2.y
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x01c0
            r1 = 1
            goto L_0x01c1
        L_0x01c0:
            r1 = 0
        L_0x01c1:
            android.graphics.PointF r2 = r12.quickScaleVLastPoint
            float r13 = r13.getY()
            r6 = 0
            r2.set(r6, r13)
            float r13 = r12.quickScaleLastDistance
            float r13 = r0 / r13
            r2 = 1065353216(0x3f800000, float:1.0)
            float r13 = r2 - r13
            float r13 = java.lang.Math.abs(r13)
            r7 = 1056964608(0x3f000000, float:0.5)
            float r13 = r13 * r7
            r7 = 1022739087(0x3cf5c28f, float:0.03)
            int r7 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r7 > 0) goto L_0x01e6
            boolean r7 = r12.quickScaleMoved
            if (r7 == 0) goto L_0x02f9
        L_0x01e6:
            r12.quickScaleMoved = r5
            float r7 = r12.quickScaleLastDistance
            int r7 = (r7 > r6 ? 1 : (r7 == r6 ? 0 : -1))
            if (r7 <= 0) goto L_0x01f4
            if (r1 == 0) goto L_0x01f3
            float r13 = r13 + r2
            r2 = r13
            goto L_0x01f4
        L_0x01f3:
            float r2 = r2 - r13
        L_0x01f4:
            float r13 = r12.scale
            double r7 = (double) r13
            float r13 = r12.minScale()
            float r1 = r12.maxScale
            float r9 = r12.scale
            float r9 = r9 * r2
            float r1 = java.lang.Math.min(r1, r9)
            float r13 = java.lang.Math.max(r13, r1)
            r12.scale = r13
            boolean r13 = r12.panEnabled
            if (r13 == 0) goto L_0x02a9
            android.graphics.PointF r13 = r12.vCenterStart
            float r13 = r13.x
            android.graphics.PointF r1 = r12.vTranslateStart
            float r1 = r1.x
            float r13 = r13 - r1
            android.graphics.PointF r1 = r12.vCenterStart
            float r1 = r1.y
            android.graphics.PointF r2 = r12.vTranslateStart
            float r2 = r2.y
            float r1 = r1 - r2
            float r2 = r12.scale
            float r3 = r12.scaleStart
            float r9 = r2 / r3
            float r13 = r13 * r9
            float r2 = r2 / r3
            float r1 = r1 * r2
            android.graphics.PointF r2 = r12.vTranslate
            android.graphics.PointF r3 = r12.vCenterStart
            float r3 = r3.x
            float r3 = r3 - r13
            r2.x = r3
            android.graphics.PointF r13 = r12.vTranslate
            android.graphics.PointF r2 = r12.vCenterStart
            float r2 = r2.y
            float r2 = r2 - r1
            r13.y = r2
            int r13 = r12.sHeight()
            double r1 = (double) r13
            java.lang.Double.isNaN(r7)
            java.lang.Double.isNaN(r1)
            double r1 = r1 * r7
            int r13 = r12.getHeight()
            double r9 = (double) r13
            int r13 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r13 >= 0) goto L_0x0266
            float r13 = r12.scale
            int r1 = r12.sHeight()
            float r1 = (float) r1
            float r13 = r13 * r1
            int r1 = r12.getHeight()
            float r1 = (float) r1
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 >= 0) goto L_0x028e
        L_0x0266:
            int r13 = r12.sWidth()
            double r1 = (double) r13
            java.lang.Double.isNaN(r7)
            java.lang.Double.isNaN(r1)
            double r7 = r7 * r1
            int r13 = r12.getWidth()
            double r1 = (double) r13
            int r13 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r13 >= 0) goto L_0x02f9
            float r13 = r12.scale
            int r1 = r12.sWidth()
            float r1 = (float) r1
            float r13 = r13 * r1
            int r1 = r12.getWidth()
            float r1 = (float) r1
            int r13 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r13 < 0) goto L_0x02f9
        L_0x028e:
            r12.fitToBounds(r5)
            android.graphics.PointF r13 = r12.vCenterStart
            android.graphics.PointF r0 = r12.quickScaleSCenter
            android.graphics.PointF r0 = r12.sourceToViewCoord(r0)
            r13.set(r0)
            android.graphics.PointF r13 = r12.vTranslateStart
            android.graphics.PointF r0 = r12.vTranslate
            r13.set(r0)
            float r13 = r12.scale
            r12.scaleStart = r13
            r0 = 0
            goto L_0x02f9
        L_0x02a9:
            android.graphics.PointF r13 = r12.sRequestedCenter
            if (r13 == 0) goto L_0x02cf
            android.graphics.PointF r13 = r12.vTranslate
            int r1 = r12.getWidth()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r12.scale
            android.graphics.PointF r6 = r12.sRequestedCenter
            float r6 = r6.x
            float r2 = r2 * r6
            float r1 = r1 - r2
            r13.x = r1
            android.graphics.PointF r13 = r12.vTranslate
            int r1 = r12.getHeight()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r12.scale
            android.graphics.PointF r3 = r12.sRequestedCenter
            float r3 = r3.y
            goto L_0x02f4
        L_0x02cf:
            android.graphics.PointF r13 = r12.vTranslate
            int r1 = r12.getWidth()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r12.scale
            int r6 = r12.sWidth()
            int r6 = r6 / r3
            float r6 = (float) r6
            float r2 = r2 * r6
            float r1 = r1 - r2
            r13.x = r1
            android.graphics.PointF r13 = r12.vTranslate
            int r1 = r12.getHeight()
            int r1 = r1 / r3
            float r1 = (float) r1
            float r2 = r12.scale
            int r6 = r12.sHeight()
            int r6 = r6 / r3
            float r3 = (float) r6
        L_0x02f4:
            float r2 = r2 * r3
            float r1 = r1 - r2
            r13.y = r1
        L_0x02f9:
            r12.quickScaleLastDistance = r0
        L_0x02fb:
            r12.fitToBounds(r5)
        L_0x02fe:
            boolean r13 = r12.eagerLoadingEnabled
            r12.refreshRequiredTiles(r13)
            r13 = 1
            goto L_0x03e3
        L_0x0306:
            boolean r0 = r12.isZooming
            if (r0 != 0) goto L_0x03e2
            float r0 = r13.getX()
            android.graphics.PointF r2 = r12.vCenterStart
            float r2 = r2.x
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            float r2 = r13.getY()
            android.graphics.PointF r3 = r12.vCenterStart
            float r3 = r3.y
            float r2 = r2 - r3
            float r2 = java.lang.Math.abs(r2)
            float r3 = r12.density
            float r3 = r3 * r1
            int r1 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0334
            int r1 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0334
            boolean r1 = r12.isPanning
            if (r1 == 0) goto L_0x03e2
        L_0x0334:
            android.graphics.PointF r1 = r12.vTranslate
            android.graphics.PointF r6 = r12.vTranslateStart
            float r6 = r6.x
            float r7 = r13.getX()
            android.graphics.PointF r8 = r12.vCenterStart
            float r8 = r8.x
            float r7 = r7 - r8
            float r6 = r6 + r7
            r1.x = r6
            android.graphics.PointF r1 = r12.vTranslate
            android.graphics.PointF r6 = r12.vTranslateStart
            float r6 = r6.y
            float r13 = r13.getY()
            android.graphics.PointF r7 = r12.vCenterStart
            float r7 = r7.y
            float r13 = r13 - r7
            float r6 = r6 + r13
            r1.y = r6
            android.graphics.PointF r13 = r12.vTranslate
            float r13 = r13.x
            android.graphics.PointF r1 = r12.vTranslate
            float r1 = r1.y
            r12.fitToBounds(r5)
            android.graphics.PointF r6 = r12.vTranslate
            float r6 = r6.x
            int r13 = (r13 > r6 ? 1 : (r13 == r6 ? 0 : -1))
            if (r13 == 0) goto L_0x036d
            r13 = 1
            goto L_0x036e
        L_0x036d:
            r13 = 0
        L_0x036e:
            android.graphics.PointF r6 = r12.vTranslate
            float r6 = r6.y
            int r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x0378
            r6 = 1
            goto L_0x0379
        L_0x0378:
            r6 = 0
        L_0x0379:
            if (r13 == 0) goto L_0x0385
            int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r7 <= 0) goto L_0x0385
            boolean r7 = r12.isPanning
            if (r7 != 0) goto L_0x0385
            r7 = 1
            goto L_0x0386
        L_0x0385:
            r7 = 0
        L_0x0386:
            if (r6 == 0) goto L_0x0392
            int r8 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r8 <= 0) goto L_0x0392
            boolean r8 = r12.isPanning
            if (r8 != 0) goto L_0x0392
            r8 = 1
            goto L_0x0393
        L_0x0392:
            r8 = 0
        L_0x0393:
            android.graphics.PointF r9 = r12.vTranslate
            float r9 = r9.y
            int r1 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r1 != 0) goto L_0x03a5
            r1 = 1077936128(0x40400000, float:3.0)
            float r1 = r1 * r3
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x03a5
            r1 = 1
            goto L_0x03a6
        L_0x03a5:
            r1 = 0
        L_0x03a6:
            if (r7 != 0) goto L_0x03b7
            if (r8 != 0) goto L_0x03b7
            if (r13 == 0) goto L_0x03b4
            if (r6 == 0) goto L_0x03b4
            if (r1 != 0) goto L_0x03b4
            boolean r13 = r12.isPanning
            if (r13 == 0) goto L_0x03b7
        L_0x03b4:
            r12.isPanning = r5
            goto L_0x03c9
        L_0x03b7:
            int r13 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r13 > 0) goto L_0x03bf
            int r13 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r13 <= 0) goto L_0x03c9
        L_0x03bf:
            r12.maxTouchCount = r4
            android.os.Handler r13 = r12.handler
            r13.removeMessages(r5)
            r12.requestDisallowInterceptTouchEvent(r4)
        L_0x03c9:
            boolean r13 = r12.panEnabled
            if (r13 != 0) goto L_0x02fe
            android.graphics.PointF r13 = r12.vTranslate
            android.graphics.PointF r0 = r12.vTranslateStart
            float r0 = r0.x
            r13.x = r0
            android.graphics.PointF r13 = r12.vTranslate
            android.graphics.PointF r0 = r12.vTranslateStart
            float r0 = r0.y
            r13.y = r0
            r12.requestDisallowInterceptTouchEvent(r4)
            goto L_0x02fe
        L_0x03e2:
            r13 = 0
        L_0x03e3:
            if (r13 == 0) goto L_0x03ee
            android.os.Handler r13 = r12.handler
            r13.removeMessages(r5)
            r12.invalidate()
            return r5
        L_0x03ee:
            return r4
        L_0x03ef:
            android.os.Handler r1 = r12.handler
            r1.removeMessages(r5)
            boolean r1 = r12.isQuickScaling
            if (r1 == 0) goto L_0x0405
            r12.isQuickScaling = r4
            boolean r1 = r12.quickScaleMoved
            if (r1 != 0) goto L_0x0405
            android.graphics.PointF r1 = r12.quickScaleSCenter
            android.graphics.PointF r2 = r12.vCenterStart
            r12.doubleTapZoom(r1, r2)
        L_0x0405:
            int r1 = r12.maxTouchCount
            if (r1 <= 0) goto L_0x0451
            boolean r1 = r12.isZooming
            if (r1 != 0) goto L_0x0411
            boolean r2 = r12.isPanning
            if (r2 == 0) goto L_0x0451
        L_0x0411:
            if (r1 == 0) goto L_0x0442
            if (r0 != r3) goto L_0x0442
            r12.isPanning = r5
            android.graphics.PointF r1 = r12.vTranslateStart
            android.graphics.PointF r2 = r12.vTranslate
            float r2 = r2.x
            android.graphics.PointF r6 = r12.vTranslate
            float r6 = r6.y
            r1.set(r2, r6)
            int r1 = r13.getActionIndex()
            if (r1 != r5) goto L_0x0435
            android.graphics.PointF r1 = r12.vCenterStart
            float r2 = r13.getX(r4)
            float r13 = r13.getY(r4)
            goto L_0x043f
        L_0x0435:
            android.graphics.PointF r1 = r12.vCenterStart
            float r2 = r13.getX(r5)
            float r13 = r13.getY(r5)
        L_0x043f:
            r1.set(r2, r13)
        L_0x0442:
            r13 = 3
            if (r0 >= r13) goto L_0x0447
            r12.isZooming = r4
        L_0x0447:
            if (r0 >= r3) goto L_0x044d
            r12.isPanning = r4
            r12.maxTouchCount = r4
        L_0x044d:
            r12.refreshRequiredTiles(r5)
            return r5
        L_0x0451:
            if (r0 != r5) goto L_0x0459
            r12.isZooming = r4
            r12.isPanning = r4
            r12.maxTouchCount = r4
        L_0x0459:
            return r5
        L_0x045a:
            r1 = 0
            r12.anim = r1
            r12.requestDisallowInterceptTouchEvent(r5)
            int r1 = r12.maxTouchCount
            int r1 = java.lang.Math.max(r1, r0)
            r12.maxTouchCount = r1
            if (r0 < r3) goto L_0x04b7
            boolean r0 = r12.zoomEnabled
            if (r0 == 0) goto L_0x04af
            float r0 = r13.getX(r4)
            float r1 = r13.getX(r5)
            float r3 = r13.getY(r4)
            float r6 = r13.getY(r5)
            float r0 = r12.distance(r0, r1, r3, r6)
            float r1 = r12.scale
            r12.scaleStart = r1
            r12.vDistStart = r0
            android.graphics.PointF r0 = r12.vTranslateStart
            android.graphics.PointF r1 = r12.vTranslate
            float r1 = r1.x
            android.graphics.PointF r3 = r12.vTranslate
            float r3 = r3.y
            r0.set(r1, r3)
            android.graphics.PointF r0 = r12.vCenterStart
            float r1 = r13.getX(r4)
            float r3 = r13.getX(r5)
            float r1 = r1 + r3
            float r1 = r1 / r2
            float r3 = r13.getY(r4)
            float r13 = r13.getY(r5)
            float r3 = r3 + r13
            float r3 = r3 / r2
            r0.set(r1, r3)
            goto L_0x04b1
        L_0x04af:
            r12.maxTouchCount = r4
        L_0x04b1:
            android.os.Handler r13 = r12.handler
            r13.removeMessages(r5)
            goto L_0x04dc
        L_0x04b7:
            boolean r0 = r12.isQuickScaling
            if (r0 != 0) goto L_0x04dc
            android.graphics.PointF r0 = r12.vTranslateStart
            android.graphics.PointF r1 = r12.vTranslate
            float r1 = r1.x
            android.graphics.PointF r2 = r12.vTranslate
            float r2 = r2.y
            r0.set(r1, r2)
            android.graphics.PointF r0 = r12.vCenterStart
            float r1 = r13.getX()
            float r13 = r13.getY()
            r0.set(r1, r13)
            android.os.Handler r13 = r12.handler
            r0 = 600(0x258, double:2.964E-321)
            r13.sendEmptyMessageDelayed(r5, r0)
        L_0x04dc:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.onTouchEventInternal(android.view.MotionEvent):boolean");
    }

    private void preDraw() {
        Float f2;
        if (getWidth() != 0 && getHeight() != 0 && this.sWidth > 0 && this.sHeight > 0) {
            if (!(this.sPendingCenter == null || (f2 = this.pendingScale) == null)) {
                this.scale = f2.floatValue();
                if (this.vTranslate == null) {
                    this.vTranslate = new PointF();
                }
                this.vTranslate.x = ((float) (getWidth() / 2)) - (this.scale * this.sPendingCenter.x);
                this.vTranslate.y = ((float) (getHeight() / 2)) - (this.scale * this.sPendingCenter.y);
                this.sPendingCenter = null;
                this.pendingScale = null;
                fitToBounds(true);
                refreshRequiredTiles(true);
            }
            fitToBounds(false);
        }
    }

    private int px(int i2) {
        return (int) (this.density * ((float) i2));
    }

    private void refreshRequiredTiles(boolean z2) {
        if (this.decoder != null && this.tileMap != null) {
            int min = Math.min(this.fullImageSampleSize, calculateInSampleSize(this.scale));
            for (Map.Entry<Integer, List<Tile>> value : this.tileMap.entrySet()) {
                for (Tile tile : (List) value.getValue()) {
                    if (tile.sampleSize < min || (tile.sampleSize > min && tile.sampleSize != this.fullImageSampleSize)) {
                        boolean unused = tile.visible = false;
                        if (tile.bitmap != null) {
                            tile.bitmap.recycle();
                            Bitmap unused2 = tile.bitmap = null;
                        }
                    }
                    if (tile.sampleSize == min) {
                        if (tileVisible(tile)) {
                            boolean unused3 = tile.visible = true;
                            if (!tile.loading && tile.bitmap == null && z2) {
                                execute(new TileLoadTask(this, this.decoder, tile));
                            }
                        } else if (tile.sampleSize != this.fullImageSampleSize) {
                            boolean unused4 = tile.visible = false;
                            if (tile.bitmap != null) {
                                tile.bitmap.recycle();
                                Bitmap unused5 = tile.bitmap = null;
                            }
                        }
                    } else if (tile.sampleSize == this.fullImageSampleSize) {
                        boolean unused6 = tile.visible = true;
                    }
                }
            }
        }
    }

    private void requestDisallowInterceptTouchEvent(boolean z2) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z2);
        }
    }

    /* JADX INFO: finally extract failed */
    private void reset(boolean z2) {
        OnImageEventListener onImageEventListener2;
        debug("reset newImage=" + z2, new Object[0]);
        this.scale = 0.0f;
        this.scaleStart = 0.0f;
        this.vTranslate = null;
        this.vTranslateStart = null;
        this.vTranslateBefore = null;
        this.pendingScale = Float.valueOf(0.0f);
        this.sPendingCenter = null;
        this.sRequestedCenter = null;
        this.isZooming = false;
        this.isPanning = false;
        this.isQuickScaling = false;
        this.maxTouchCount = 0;
        this.fullImageSampleSize = 0;
        this.vCenterStart = null;
        this.vDistStart = 0.0f;
        this.quickScaleLastDistance = 0.0f;
        this.quickScaleMoved = false;
        this.quickScaleSCenter = null;
        this.quickScaleVLastPoint = null;
        this.quickScaleVStart = null;
        this.anim = null;
        this.satTemp = null;
        this.matrix = null;
        this.sRect = null;
        if (z2) {
            this.uri = null;
            this.decoderLock.writeLock().lock();
            try {
                ImageRegionDecoder imageRegionDecoder = this.decoder;
                if (imageRegionDecoder != null) {
                    imageRegionDecoder.recycle();
                    this.decoder = null;
                }
                this.decoderLock.writeLock().unlock();
                Bitmap bitmap2 = this.bitmap;
                if (bitmap2 != null && !this.bitmapIsCached) {
                    bitmap2.recycle();
                }
                if (!(this.bitmap == null || !this.bitmapIsCached || (onImageEventListener2 = this.onImageEventListener) == null)) {
                    onImageEventListener2.onPreviewReleased();
                }
                this.sWidth = 0;
                this.sHeight = 0;
                this.sOrientation = 0;
                this.sRegion = null;
                this.pRegion = null;
                this.readySent = false;
                this.imageLoadedSent = false;
                this.bitmap = null;
                this.bitmapIsPreview = false;
                this.bitmapIsCached = false;
            } catch (Throwable th) {
                this.decoderLock.writeLock().unlock();
                throw th;
            }
        }
        Map<Integer, List<Tile>> map = this.tileMap;
        if (map != null) {
            for (Map.Entry<Integer, List<Tile>> value : map.entrySet()) {
                for (Tile tile : (List) value.getValue()) {
                    boolean unused = tile.visible = false;
                    if (tile.bitmap != null) {
                        tile.bitmap.recycle();
                        Bitmap unused2 = tile.bitmap = null;
                    }
                }
            }
            this.tileMap = null;
        }
        setGestureDetector(getContext());
    }

    private void restoreState(ImageViewState imageViewState) {
        if (imageViewState != null && VALID_ORIENTATIONS.contains(Integer.valueOf(imageViewState.getOrientation()))) {
            this.orientation = imageViewState.getOrientation();
            this.pendingScale = Float.valueOf(imageViewState.getScale());
            this.sPendingCenter = imageViewState.getCenter();
            invalidate();
        }
    }

    private int sHeight() {
        int requiredRotation = getRequiredRotation();
        return (requiredRotation == 90 || requiredRotation == 270) ? this.sWidth : this.sHeight;
    }

    private int sWidth() {
        int requiredRotation = getRequiredRotation();
        return (requiredRotation == 90 || requiredRotation == 270) ? this.sHeight : this.sWidth;
    }

    private void sendStateChanged(float f2, PointF pointF, int i2) {
        OnStateChangedListener onStateChangedListener2 = this.onStateChangedListener;
        if (onStateChangedListener2 != null) {
            float f3 = this.scale;
            if (f3 != f2) {
                onStateChangedListener2.onScaleChanged(f3, i2);
            }
        }
        if (this.onStateChangedListener != null && !this.vTranslate.equals(pointF)) {
            this.onStateChangedListener.onCenterChanged(getCenter(), i2);
        }
    }

    /* access modifiers changed from: private */
    public void setGestureDetector(final Context context) {
        this.detector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (!SubsamplingScaleImageView.this.zoomEnabled || !SubsamplingScaleImageView.this.readySent || SubsamplingScaleImageView.this.vTranslate == null) {
                    return super.onDoubleTapEvent(motionEvent);
                }
                SubsamplingScaleImageView.this.setGestureDetector(context);
                if (SubsamplingScaleImageView.this.quickScaleEnabled) {
                    PointF unused = SubsamplingScaleImageView.this.vCenterStart = new PointF(motionEvent.getX(), motionEvent.getY());
                    PointF unused2 = SubsamplingScaleImageView.this.vTranslateStart = new PointF(SubsamplingScaleImageView.this.vTranslate.x, SubsamplingScaleImageView.this.vTranslate.y);
                    SubsamplingScaleImageView subsamplingScaleImageView = SubsamplingScaleImageView.this;
                    float unused3 = subsamplingScaleImageView.scaleStart = subsamplingScaleImageView.scale;
                    boolean unused4 = SubsamplingScaleImageView.this.isQuickScaling = true;
                    boolean unused5 = SubsamplingScaleImageView.this.isZooming = true;
                    float unused6 = SubsamplingScaleImageView.this.quickScaleLastDistance = -1.0f;
                    SubsamplingScaleImageView subsamplingScaleImageView2 = SubsamplingScaleImageView.this;
                    PointF unused7 = subsamplingScaleImageView2.quickScaleSCenter = subsamplingScaleImageView2.viewToSourceCoord(subsamplingScaleImageView2.vCenterStart);
                    PointF unused8 = SubsamplingScaleImageView.this.quickScaleVStart = new PointF(motionEvent.getX(), motionEvent.getY());
                    PointF unused9 = SubsamplingScaleImageView.this.quickScaleVLastPoint = new PointF(SubsamplingScaleImageView.this.quickScaleSCenter.x, SubsamplingScaleImageView.this.quickScaleSCenter.y);
                    boolean unused10 = SubsamplingScaleImageView.this.quickScaleMoved = false;
                    return false;
                }
                SubsamplingScaleImageView subsamplingScaleImageView3 = SubsamplingScaleImageView.this;
                subsamplingScaleImageView3.doubleTapZoom(subsamplingScaleImageView3.viewToSourceCoord(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
                return true;
            }

            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (!SubsamplingScaleImageView.this.panEnabled || !SubsamplingScaleImageView.this.readySent || SubsamplingScaleImageView.this.vTranslate == null || motionEvent == null || motionEvent2 == null || ((Math.abs(motionEvent.getX() - motionEvent2.getX()) <= 50.0f && Math.abs(motionEvent.getY() - motionEvent2.getY()) <= 50.0f) || ((Math.abs(f2) <= 500.0f && Math.abs(f3) <= 500.0f) || SubsamplingScaleImageView.this.isZooming))) {
                    return super.onFling(motionEvent, motionEvent2, f2, f3);
                }
                PointF pointF = new PointF(SubsamplingScaleImageView.this.vTranslate.x + (f2 * 0.25f), SubsamplingScaleImageView.this.vTranslate.y + (f3 * 0.25f));
                new AnimationBuilder(new PointF((((float) (SubsamplingScaleImageView.this.getWidth() / 2)) - pointF.x) / SubsamplingScaleImageView.this.scale, (((float) (SubsamplingScaleImageView.this.getHeight() / 2)) - pointF.y) / SubsamplingScaleImageView.this.scale)).withEasing(1).withPanLimited(false).withOrigin(3).start();
                return true;
            }

            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                SubsamplingScaleImageView.this.performClick();
                return true;
            }
        });
        this.singleDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                SubsamplingScaleImageView.this.performClick();
                return true;
            }
        });
    }

    private void setMatrixArray(float[] fArr, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[2] = f4;
        fArr[3] = f5;
        fArr[4] = f6;
        fArr[5] = f7;
        fArr[6] = f8;
        fArr[7] = f9;
    }

    public static void setPreferredBitmapConfig(Bitmap.Config config) {
        preferredBitmapConfig = config;
    }

    private void sourceToViewRect(Rect rect, Rect rect2) {
        rect2.set((int) sourceToViewX((float) rect.left), (int) sourceToViewY((float) rect.top), (int) sourceToViewX((float) rect.right), (int) sourceToViewY((float) rect.bottom));
    }

    private float sourceToViewX(float f2) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 * this.scale) + pointF.x;
    }

    private float sourceToViewY(float f2) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 * this.scale) + pointF.y;
    }

    private boolean tileVisible(Tile tile) {
        return viewToSourceX(0.0f) <= ((float) tile.sRect.right) && ((float) tile.sRect.left) <= viewToSourceX((float) getWidth()) && viewToSourceY(0.0f) <= ((float) tile.sRect.bottom) && ((float) tile.sRect.top) <= viewToSourceY((float) getHeight());
    }

    private PointF vTranslateForSCenter(float f2, float f3, float f4) {
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.satTemp == null) {
            this.satTemp = new ScaleAndTranslate(0.0f, new PointF(0.0f, 0.0f));
        }
        float unused = this.satTemp.scale = f4;
        this.satTemp.vTranslate.set(((float) paddingLeft) - (f2 * f4), ((float) paddingTop) - (f3 * f4));
        fitToBounds(true, this.satTemp);
        return this.satTemp.vTranslate;
    }

    private float viewToSourceX(float f2) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 - pointF.x) / this.scale;
    }

    private float viewToSourceY(float f2) {
        PointF pointF = this.vTranslate;
        if (pointF == null) {
            return Float.NaN;
        }
        return (f2 - pointF.y) / this.scale;
    }

    public AnimationBuilder animateCenter(PointF pointF) {
        if (!isReady()) {
            return null;
        }
        return new AnimationBuilder(pointF);
    }

    public AnimationBuilder animateScale(float f2) {
        if (!isReady()) {
            return null;
        }
        return new AnimationBuilder(f2);
    }

    public AnimationBuilder animateScaleAndCenter(float f2, PointF pointF) {
        if (!isReady()) {
            return null;
        }
        return new AnimationBuilder(f2, pointF);
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    public final PointF getCenter() {
        return viewToSourceCoord((float) (getWidth() / 2), (float) (getHeight() / 2));
    }

    public float getMaxScale() {
        return this.maxScale;
    }

    public final float getMinScale() {
        return minScale();
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final void getPanRemaining(RectF rectF) {
        float max;
        float f2;
        if (isReady()) {
            float sWidth2 = this.scale * ((float) sWidth());
            float sHeight2 = this.scale * ((float) sHeight());
            int i2 = this.panLimit;
            if (i2 == 3) {
                rectF.top = Math.max(0.0f, -(this.vTranslate.y - ((float) (getHeight() / 2))));
                rectF.left = Math.max(0.0f, -(this.vTranslate.x - ((float) (getWidth() / 2))));
                rectF.bottom = Math.max(0.0f, this.vTranslate.y - (((float) (getHeight() / 2)) - sHeight2));
                f2 = this.vTranslate.x - (((float) (getWidth() / 2)) - sWidth2);
            } else if (i2 == 2) {
                rectF.top = Math.max(0.0f, -(this.vTranslate.y - ((float) getHeight())));
                rectF.left = Math.max(0.0f, -(this.vTranslate.x - ((float) getWidth())));
                rectF.bottom = Math.max(0.0f, this.vTranslate.y + sHeight2);
                f2 = this.vTranslate.x + sWidth2;
            } else {
                rectF.top = Math.max(0.0f, -this.vTranslate.y);
                rectF.left = Math.max(0.0f, -this.vTranslate.x);
                rectF.bottom = Math.max(0.0f, (sHeight2 + this.vTranslate.y) - ((float) getHeight()));
                max = Math.max(0.0f, (sWidth2 + this.vTranslate.x) - ((float) getWidth()));
                rectF.right = max;
            }
            max = Math.max(0.0f, f2);
            rectF.right = max;
        }
    }

    public final int getSHeight() {
        return this.sHeight;
    }

    public final int getSWidth() {
        return this.sWidth;
    }

    public final float getScale() {
        return this.scale;
    }

    public final ImageViewState getState() {
        if (this.vTranslate == null || this.sWidth <= 0 || this.sHeight <= 0) {
            return null;
        }
        return new ImageViewState(getScale(), getCenter(), getOrientation());
    }

    public boolean hasImage() {
        return (this.uri == null && this.bitmap == null) ? false : true;
    }

    public final boolean isImageLoaded() {
        return this.imageLoadedSent;
    }

    public final boolean isPanEnabled() {
        return this.panEnabled;
    }

    public final boolean isQuickScaleEnabled() {
        return this.quickScaleEnabled;
    }

    public final boolean isReady() {
        return this.readySent;
    }

    public final boolean isZoomEnabled() {
        return this.zoomEnabled;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0424  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x048e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r32) {
        /*
            r31 = this;
            r11 = r31
            r12 = r32
            super.onDraw(r32)
            r31.createPaints()
            int r0 = r11.sWidth
            if (r0 == 0) goto L_0x0778
            int r0 = r11.sHeight
            if (r0 == 0) goto L_0x0778
            int r0 = r31.getWidth()
            if (r0 == 0) goto L_0x0778
            int r0 = r31.getHeight()
            if (r0 != 0) goto L_0x0020
            goto L_0x0778
        L_0x0020:
            java.util.Map<java.lang.Integer, java.util.List<com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Tile>> r0 = r11.tileMap
            if (r0 != 0) goto L_0x002f
            com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder r0 = r11.decoder
            if (r0 == 0) goto L_0x002f
            android.graphics.Point r0 = r31.getMaxBitmapDimensions(r32)
            r11.initialiseBaseLayer(r0)
        L_0x002f:
            boolean r0 = r31.checkReady()
            if (r0 != 0) goto L_0x0036
            return
        L_0x0036:
            r31.preDraw()
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r0 = r11.anim
            r9 = 0
            if (r0 == 0) goto L_0x016f
            android.graphics.PointF r0 = r0.vFocusStart
            if (r0 == 0) goto L_0x016f
            float r0 = r11.scale
            android.graphics.PointF r1 = r11.vTranslateBefore
            if (r1 != 0) goto L_0x0051
            android.graphics.PointF r1 = new android.graphics.PointF
            r1.<init>(r9, r9)
            r11.vTranslateBefore = r1
        L_0x0051:
            android.graphics.PointF r1 = r11.vTranslateBefore
            android.graphics.PointF r2 = r11.vTranslate
            r1.set(r2)
            long r1 = java.lang.System.currentTimeMillis()
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r3 = r11.anim
            long r3 = r3.time
            long r1 = r1 - r3
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r3 = r11.anim
            long r3 = r3.duration
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x006f
            r10 = 1
            goto L_0x0070
        L_0x006f:
            r10 = 0
        L_0x0070:
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r3 = r11.anim
            long r3 = r3.duration
            long r15 = java.lang.Math.min(r1, r3)
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            int r2 = r1.easing
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            float r5 = r1.scaleStart
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            float r1 = r1.scaleEnd
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r3 = r11.anim
            float r3 = r3.scaleStart
            float r6 = r1 - r3
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            long r7 = r1.duration
            r1 = r31
            r3 = r15
            float r1 = r1.ease(r2, r3, r5, r6, r7)
            r11.scale = r1
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            int r2 = r1.easing
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            android.graphics.PointF r1 = r1.vFocusStart
            float r5 = r1.x
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            android.graphics.PointF r1 = r1.vFocusEnd
            float r1 = r1.x
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r3 = r11.anim
            android.graphics.PointF r3 = r3.vFocusStart
            float r3 = r3.x
            float r6 = r1 - r3
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            long r7 = r1.duration
            r1 = r31
            r3 = r15
            float r17 = r1.ease(r2, r3, r5, r6, r7)
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            int r2 = r1.easing
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            android.graphics.PointF r1 = r1.vFocusStart
            float r5 = r1.y
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            android.graphics.PointF r1 = r1.vFocusEnd
            float r1 = r1.y
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r3 = r11.anim
            android.graphics.PointF r3 = r3.vFocusStart
            float r3 = r3.y
            float r6 = r1 - r3
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            long r7 = r1.duration
            r1 = r31
            r3 = r15
            float r1 = r1.ease(r2, r3, r5, r6, r7)
            android.graphics.PointF r2 = r11.vTranslate
            float r3 = r2.x
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r4 = r11.anim
            android.graphics.PointF r4 = r4.sCenterEnd
            float r4 = r4.x
            float r4 = r11.sourceToViewX(r4)
            float r4 = r4 - r17
            float r3 = r3 - r4
            r2.x = r3
            android.graphics.PointF r2 = r11.vTranslate
            float r3 = r2.y
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r4 = r11.anim
            android.graphics.PointF r4 = r4.sCenterEnd
            float r4 = r4.y
            float r4 = r11.sourceToViewY(r4)
            float r4 = r4 - r1
            float r3 = r3 - r4
            r2.y = r3
            if (r10 != 0) goto L_0x013b
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r1 = r11.anim
            float r1 = r1.scaleStart
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r2 = r11.anim
            float r2 = r2.scaleEnd
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x0139
            goto L_0x013b
        L_0x0139:
            r1 = 0
            goto L_0x013c
        L_0x013b:
            r1 = 1
        L_0x013c:
            r11.fitToBounds(r1)
            android.graphics.PointF r1 = r11.vTranslateBefore
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r2 = r11.anim
            int r2 = r2.origin
            r11.sendStateChanged(r0, r1, r2)
            r11.refreshRequiredTiles(r10)
            if (r10 == 0) goto L_0x016c
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r0 = r11.anim
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$OnAnimationEventListener r0 = r0.listener
            if (r0 == 0) goto L_0x0169
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r0 = r11.anim     // Catch:{ Exception -> 0x0161 }
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$OnAnimationEventListener r0 = r0.listener     // Catch:{ Exception -> 0x0161 }
            r0.onComplete()     // Catch:{ Exception -> 0x0161 }
            goto L_0x0169
        L_0x0161:
            r0 = move-exception
            java.lang.String r1 = TAG
            java.lang.String r2 = "Error thrown by animation listener"
            android.util.Log.w(r1, r2, r0)
        L_0x0169:
            r0 = 0
            r11.anim = r0
        L_0x016c:
            r31.invalidate()
        L_0x016f:
            java.util.Map<java.lang.Integer, java.util.List<com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Tile>> r0 = r11.tileMap
            r15 = 270(0x10e, float:3.78E-43)
            r10 = 35
            r8 = 90
            r7 = 180(0xb4, float:2.52E-43)
            if (r0 == 0) goto L_0x04a6
            boolean r0 = r31.isBaseLayerReady()
            if (r0 == 0) goto L_0x04a6
            int r0 = r11.fullImageSampleSize
            float r1 = r11.scale
            int r1 = r11.calculateInSampleSize(r1)
            int r0 = java.lang.Math.min(r0, r1)
            java.util.Map<java.lang.Integer, java.util.List<com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Tile>> r1 = r11.tileMap
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
            r16 = 0
        L_0x0199:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x01dc
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            if (r3 != r0) goto L_0x0199
            java.lang.Object r2 = r2.getValue()
            java.util.List r2 = (java.util.List) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x01bb:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0199
            java.lang.Object r3 = r2.next()
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Tile r3 = (com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Tile) r3
            boolean r4 = r3.visible
            if (r4 == 0) goto L_0x01bb
            boolean r4 = r3.loading
            if (r4 != 0) goto L_0x01d9
            android.graphics.Bitmap r3 = r3.bitmap
            if (r3 != 0) goto L_0x01bb
        L_0x01d9:
            r16 = 1
            goto L_0x01bb
        L_0x01dc:
            java.util.Map<java.lang.Integer, java.util.List<com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Tile>> r1 = r11.tileMap
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r17 = r1.iterator()
        L_0x01e6:
            boolean r1 = r17.hasNext()
            if (r1 == 0) goto L_0x04a0
            java.lang.Object r1 = r17.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r2 == r0) goto L_0x020b
            if (r16 == 0) goto L_0x0201
            goto L_0x020b
        L_0x0201:
            r3 = 35
            r5 = 15
            r13 = 180(0xb4, float:2.52E-43)
            r14 = 90
            goto L_0x0498
        L_0x020b:
            java.lang.Object r1 = r1.getValue()
            java.util.List r1 = (java.util.List) r1
            java.util.Iterator r18 = r1.iterator()
        L_0x0215:
            boolean r1 = r18.hasNext()
            if (r1 == 0) goto L_0x0201
            java.lang.Object r1 = r18.next()
            r19 = r1
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Tile r19 = (com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.Tile) r19
            android.graphics.Rect r1 = r19.sRect
            android.graphics.Rect r2 = r19.vRect
            r11.sourceToViewRect(r1, r2)
            boolean r1 = r19.loading
            if (r1 != 0) goto L_0x03e7
            android.graphics.Bitmap r1 = r19.bitmap
            if (r1 == 0) goto L_0x03e7
            android.graphics.Paint r1 = r11.tileBgPaint
            if (r1 == 0) goto L_0x0247
            android.graphics.Rect r1 = r19.vRect
            android.graphics.Paint r2 = r11.tileBgPaint
            r12.drawRect(r1, r2)
        L_0x0247:
            android.graphics.Matrix r1 = r11.matrix
            if (r1 != 0) goto L_0x0252
            android.graphics.Matrix r1 = new android.graphics.Matrix
            r1.<init>()
            r11.matrix = r1
        L_0x0252:
            android.graphics.Matrix r1 = r11.matrix
            r1.reset()
            float[] r2 = r11.srcArray
            r3 = 0
            r4 = 0
            android.graphics.Bitmap r1 = r19.bitmap
            int r1 = r1.getWidth()
            float r9 = (float) r1
            r20 = 0
            android.graphics.Bitmap r1 = r19.bitmap
            int r1 = r1.getWidth()
            float r1 = (float) r1
            android.graphics.Bitmap r21 = r19.bitmap
            int r5 = r21.getHeight()
            float r5 = (float) r5
            r21 = 0
            android.graphics.Bitmap r23 = r19.bitmap
            int r6 = r23.getHeight()
            float r6 = (float) r6
            r23 = r1
            r1 = r31
            r22 = r5
            r14 = 5
            r5 = r9
            r24 = r6
            r9 = 15
            r6 = r20
            r13 = 180(0xb4, float:2.52E-43)
            r7 = r23
            r14 = 90
            r8 = r22
            r9 = r21
            r10 = r24
            r1.setMatrixArray(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            int r1 = r31.getRequiredRotation()
            if (r1 != 0) goto L_0x02e7
            float[] r2 = r11.dstArray
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.left
            float r3 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.top
            float r4 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.right
            float r5 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.top
            float r6 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.right
            float r7 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.bottom
            float r8 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.left
            float r9 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.bottom
            float r10 = (float) r1
            r1 = r31
            r1.setMatrixArray(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x03b9
        L_0x02e7:
            int r1 = r31.getRequiredRotation()
            if (r1 != r14) goto L_0x032e
            float[] r2 = r11.dstArray
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.right
            float r3 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.top
            float r4 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.right
            float r5 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.bottom
            float r6 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.left
            float r7 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.bottom
            float r8 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.left
            float r9 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.top
            float r10 = (float) r1
            r1 = r31
            r1.setMatrixArray(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x03b9
        L_0x032e:
            int r1 = r31.getRequiredRotation()
            if (r1 != r13) goto L_0x0374
            float[] r2 = r11.dstArray
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.right
            float r3 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.bottom
            float r4 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.left
            float r5 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.bottom
            float r6 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.left
            float r7 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.top
            float r8 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.right
            float r9 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.top
            float r10 = (float) r1
            r1 = r31
            r1.setMatrixArray(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            goto L_0x03b9
        L_0x0374:
            int r1 = r31.getRequiredRotation()
            if (r1 != r15) goto L_0x03b9
            float[] r2 = r11.dstArray
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.left
            float r3 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.bottom
            float r4 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.left
            float r5 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.top
            float r6 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.right
            float r7 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.top
            float r8 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.right
            float r9 = (float) r1
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.bottom
            float r10 = (float) r1
            r1 = r31
            r1.setMatrixArray(r2, r3, r4, r5, r6, r7, r8, r9, r10)
        L_0x03b9:
            android.graphics.Matrix r1 = r11.matrix
            float[] r2 = r11.srcArray
            r27 = 0
            float[] r3 = r11.dstArray
            r29 = 0
            r30 = 4
            r25 = r1
            r26 = r2
            r28 = r3
            r25.setPolyToPoly(r26, r27, r28, r29, r30)
            android.graphics.Bitmap r1 = r19.bitmap
            android.graphics.Matrix r2 = r11.matrix
            android.graphics.Paint r3 = r11.bitmapPaint
            r12.drawBitmap(r1, r2, r3)
            boolean r1 = r11.debug
            if (r1 == 0) goto L_0x0418
            android.graphics.Rect r1 = r19.vRect
            android.graphics.Paint r2 = r11.debugLinePaint
            r12.drawRect(r1, r2)
            goto L_0x0418
        L_0x03e7:
            r13 = 180(0xb4, float:2.52E-43)
            r14 = 90
            boolean r1 = r19.loading
            if (r1 == 0) goto L_0x0418
            boolean r1 = r11.debug
            if (r1 == 0) goto L_0x0418
            android.graphics.Rect r1 = r19.vRect
            int r1 = r1.left
            r2 = 5
            int r3 = r11.px(r2)
            int r1 = r1 + r3
            float r1 = (float) r1
            android.graphics.Rect r2 = r19.vRect
            int r2 = r2.top
            r3 = 35
            int r4 = r11.px(r3)
            int r2 = r2 + r4
            float r2 = (float) r2
            android.graphics.Paint r4 = r11.debugTextPaint
            java.lang.String r5 = "LOADING"
            r12.drawText(r5, r1, r2, r4)
            goto L_0x041a
        L_0x0418:
            r3 = 35
        L_0x041a:
            boolean r1 = r19.visible
            if (r1 == 0) goto L_0x048e
            boolean r1 = r11.debug
            if (r1 == 0) goto L_0x048e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "ISS "
            r1.append(r2)
            int r2 = r19.sampleSize
            r1.append(r2)
            java.lang.String r2 = " RECT "
            r1.append(r2)
            android.graphics.Rect r2 = r19.sRect
            int r2 = r2.top
            r1.append(r2)
            java.lang.String r2 = ","
            r1.append(r2)
            android.graphics.Rect r4 = r19.sRect
            int r4 = r4.left
            r1.append(r4)
            r1.append(r2)
            android.graphics.Rect r4 = r19.sRect
            int r4 = r4.bottom
            r1.append(r4)
            r1.append(r2)
            android.graphics.Rect r2 = r19.sRect
            int r2 = r2.right
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.graphics.Rect r2 = r19.vRect
            int r2 = r2.left
            r4 = 5
            int r5 = r11.px(r4)
            int r2 = r2 + r5
            float r2 = (float) r2
            android.graphics.Rect r4 = r19.vRect
            int r4 = r4.top
            r5 = 15
            int r6 = r11.px(r5)
            int r4 = r4 + r6
            float r4 = (float) r4
            android.graphics.Paint r6 = r11.debugTextPaint
            r12.drawText(r1, r2, r4, r6)
            goto L_0x0490
        L_0x048e:
            r5 = 15
        L_0x0490:
            r7 = 180(0xb4, float:2.52E-43)
            r8 = 90
            r10 = 35
            goto L_0x0215
        L_0x0498:
            r7 = 180(0xb4, float:2.52E-43)
            r8 = 90
            r10 = 35
            goto L_0x01e6
        L_0x04a0:
            r3 = 35
            r5 = 15
            goto L_0x0584
        L_0x04a6:
            r3 = 35
            r5 = 15
            r13 = 180(0xb4, float:2.52E-43)
            r14 = 90
            android.graphics.Bitmap r0 = r11.bitmap
            if (r0 == 0) goto L_0x0584
            float r1 = r11.scale
            boolean r2 = r11.bitmapIsPreview
            if (r2 == 0) goto L_0x04d3
            int r2 = r11.sWidth
            float r2 = (float) r2
            int r0 = r0.getWidth()
            float r0 = (float) r0
            float r2 = r2 / r0
            float r1 = r1 * r2
            float r0 = r11.scale
            int r2 = r11.sHeight
            float r2 = (float) r2
            android.graphics.Bitmap r4 = r11.bitmap
            int r4 = r4.getHeight()
            float r4 = (float) r4
            float r2 = r2 / r4
            float r0 = r0 * r2
            goto L_0x04d4
        L_0x04d3:
            r0 = r1
        L_0x04d4:
            android.graphics.Matrix r2 = r11.matrix
            if (r2 != 0) goto L_0x04df
            android.graphics.Matrix r2 = new android.graphics.Matrix
            r2.<init>()
            r11.matrix = r2
        L_0x04df:
            android.graphics.Matrix r2 = r11.matrix
            r2.reset()
            android.graphics.Matrix r2 = r11.matrix
            r2.postScale(r1, r0)
            android.graphics.Matrix r0 = r11.matrix
            int r1 = r31.getRequiredRotation()
            float r1 = (float) r1
            r0.postRotate(r1)
            android.graphics.Matrix r0 = r11.matrix
            android.graphics.PointF r1 = r11.vTranslate
            float r1 = r1.x
            android.graphics.PointF r2 = r11.vTranslate
            float r2 = r2.y
            r0.postTranslate(r1, r2)
            int r0 = r31.getRequiredRotation()
            if (r0 != r13) goto L_0x0518
            android.graphics.Matrix r0 = r11.matrix
            float r1 = r11.scale
            int r2 = r11.sWidth
            float r2 = (float) r2
            float r2 = r2 * r1
            int r4 = r11.sHeight
            float r4 = (float) r4
            float r1 = r1 * r4
            r0.postTranslate(r2, r1)
            goto L_0x053d
        L_0x0518:
            int r0 = r31.getRequiredRotation()
            if (r0 != r14) goto L_0x052b
            android.graphics.Matrix r0 = r11.matrix
            float r1 = r11.scale
            int r2 = r11.sHeight
            float r2 = (float) r2
            float r1 = r1 * r2
            r0.postTranslate(r1, r9)
            goto L_0x053d
        L_0x052b:
            int r0 = r31.getRequiredRotation()
            if (r0 != r15) goto L_0x053d
            android.graphics.Matrix r0 = r11.matrix
            float r1 = r11.scale
            int r2 = r11.sWidth
            float r2 = (float) r2
            float r1 = r1 * r2
            r0.postTranslate(r9, r1)
        L_0x053d:
            android.graphics.Paint r0 = r11.tileBgPaint
            if (r0 == 0) goto L_0x057b
            android.graphics.RectF r0 = r11.sRect
            if (r0 != 0) goto L_0x054c
            android.graphics.RectF r0 = new android.graphics.RectF
            r0.<init>()
            r11.sRect = r0
        L_0x054c:
            android.graphics.RectF r0 = r11.sRect
            boolean r1 = r11.bitmapIsPreview
            if (r1 == 0) goto L_0x0559
            android.graphics.Bitmap r1 = r11.bitmap
            int r1 = r1.getWidth()
            goto L_0x055b
        L_0x0559:
            int r1 = r11.sWidth
        L_0x055b:
            float r1 = (float) r1
            boolean r2 = r11.bitmapIsPreview
            if (r2 == 0) goto L_0x0567
            android.graphics.Bitmap r2 = r11.bitmap
            int r2 = r2.getHeight()
            goto L_0x0569
        L_0x0567:
            int r2 = r11.sHeight
        L_0x0569:
            float r2 = (float) r2
            r0.set(r9, r9, r1, r2)
            android.graphics.Matrix r0 = r11.matrix
            android.graphics.RectF r1 = r11.sRect
            r0.mapRect(r1)
            android.graphics.RectF r0 = r11.sRect
            android.graphics.Paint r1 = r11.tileBgPaint
            r12.drawRect(r0, r1)
        L_0x057b:
            android.graphics.Bitmap r0 = r11.bitmap
            android.graphics.Matrix r1 = r11.matrix
            android.graphics.Paint r2 = r11.bitmapPaint
            r12.drawBitmap(r0, r1, r2)
        L_0x0584:
            boolean r0 = r11.debug
            if (r0 == 0) goto L_0x0778
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Scale: "
            r0.append(r1)
            java.util.Locale r1 = java.util.Locale.ENGLISH
            r2 = 1
            java.lang.Object[] r4 = new java.lang.Object[r2]
            float r6 = r11.scale
            java.lang.Float r6 = java.lang.Float.valueOf(r6)
            r7 = 0
            r4[r7] = r6
            java.lang.String r6 = "%.2f"
            java.lang.String r1 = java.lang.String.format(r1, r6, r4)
            r0.append(r1)
            java.lang.String r1 = " ("
            r0.append(r1)
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.Object[] r4 = new java.lang.Object[r2]
            float r8 = r31.minScale()
            java.lang.Float r8 = java.lang.Float.valueOf(r8)
            r4[r7] = r8
            java.lang.String r1 = java.lang.String.format(r1, r6, r4)
            r0.append(r1)
            java.lang.String r1 = " - "
            r0.append(r1)
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.Object[] r4 = new java.lang.Object[r2]
            float r2 = r11.maxScale
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r4[r7] = r2
            java.lang.String r1 = java.lang.String.format(r1, r6, r4)
            r0.append(r1)
            java.lang.String r1 = ")"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 5
            int r2 = r11.px(r1)
            float r1 = (float) r2
            int r2 = r11.px(r5)
            float r2 = (float) r2
            android.graphics.Paint r4 = r11.debugTextPaint
            r12.drawText(r0, r1, r2, r4)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Translate: "
            r0.append(r1)
            java.util.Locale r1 = java.util.Locale.ENGLISH
            r2 = 1
            java.lang.Object[] r4 = new java.lang.Object[r2]
            android.graphics.PointF r5 = r11.vTranslate
            float r5 = r5.x
            java.lang.Float r5 = java.lang.Float.valueOf(r5)
            r7 = 0
            r4[r7] = r5
            java.lang.String r1 = java.lang.String.format(r1, r6, r4)
            r0.append(r1)
            java.lang.String r1 = ":"
            r0.append(r1)
            java.util.Locale r4 = java.util.Locale.ENGLISH
            java.lang.Object[] r5 = new java.lang.Object[r2]
            android.graphics.PointF r2 = r11.vTranslate
            float r2 = r2.y
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r5[r7] = r2
            java.lang.String r2 = java.lang.String.format(r4, r6, r5)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r2 = 5
            int r4 = r11.px(r2)
            float r2 = (float) r4
            r4 = 30
            int r5 = r11.px(r4)
            float r5 = (float) r5
            android.graphics.Paint r7 = r11.debugTextPaint
            r12.drawText(r0, r2, r5, r7)
            android.graphics.PointF r0 = r31.getCenter()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "Source center: "
            r2.append(r5)
            java.util.Locale r5 = java.util.Locale.ENGLISH
            r7 = 1
            java.lang.Object[] r8 = new java.lang.Object[r7]
            float r9 = r0.x
            java.lang.Float r9 = java.lang.Float.valueOf(r9)
            r10 = 0
            r8[r10] = r9
            java.lang.String r5 = java.lang.String.format(r5, r6, r8)
            r2.append(r5)
            r2.append(r1)
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.Object[] r5 = new java.lang.Object[r7]
            float r0 = r0.y
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            r5[r10] = r0
            java.lang.String r0 = java.lang.String.format(r1, r6, r5)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1 = 5
            int r1 = r11.px(r1)
            float r1 = (float) r1
            r2 = 45
            int r2 = r11.px(r2)
            float r2 = (float) r2
            android.graphics.Paint r5 = r11.debugTextPaint
            r12.drawText(r0, r1, r2, r5)
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r0 = r11.anim
            r1 = -16711681(0xffffffffff00ffff, float:-1.714704E38)
            r2 = -16776961(0xffffffffff0000ff, float:-1.7014636E38)
            r5 = 20
            r6 = -65536(0xffffffffffff0000, float:NaN)
            if (r0 == 0) goto L_0x0713
            android.graphics.PointF r0 = r0.sCenterStart
            android.graphics.PointF r0 = r11.sourceToViewCoord(r0)
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r7 = r11.anim
            android.graphics.PointF r7 = r7.sCenterEndRequested
            android.graphics.PointF r7 = r11.sourceToViewCoord(r7)
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$Anim r8 = r11.anim
            android.graphics.PointF r8 = r8.sCenterEnd
            android.graphics.PointF r8 = r11.sourceToViewCoord(r8)
            float r9 = r0.x
            float r0 = r0.y
            r10 = 10
            int r10 = r11.px(r10)
            float r10 = (float) r10
            android.graphics.Paint r13 = r11.debugLinePaint
            r12.drawCircle(r9, r0, r10, r13)
            android.graphics.Paint r0 = r11.debugLinePaint
            r0.setColor(r6)
            float r0 = r7.x
            float r7 = r7.y
            int r9 = r11.px(r5)
            float r9 = (float) r9
            android.graphics.Paint r10 = r11.debugLinePaint
            r12.drawCircle(r0, r7, r9, r10)
            android.graphics.Paint r0 = r11.debugLinePaint
            r0.setColor(r2)
            float r0 = r8.x
            float r7 = r8.y
            r8 = 25
            int r8 = r11.px(r8)
            float r8 = (float) r8
            android.graphics.Paint r9 = r11.debugLinePaint
            r12.drawCircle(r0, r7, r8, r9)
            android.graphics.Paint r0 = r11.debugLinePaint
            r0.setColor(r1)
            int r0 = r31.getWidth()
            int r0 = r0 / 2
            float r0 = (float) r0
            int r7 = r31.getHeight()
            int r7 = r7 / 2
            float r7 = (float) r7
            int r8 = r11.px(r4)
            float r8 = (float) r8
            android.graphics.Paint r9 = r11.debugLinePaint
            r12.drawCircle(r0, r7, r8, r9)
        L_0x0713:
            android.graphics.PointF r0 = r11.vCenterStart
            if (r0 == 0) goto L_0x072e
            android.graphics.Paint r0 = r11.debugLinePaint
            r0.setColor(r6)
            android.graphics.PointF r0 = r11.vCenterStart
            float r0 = r0.x
            android.graphics.PointF r6 = r11.vCenterStart
            float r6 = r6.y
            int r5 = r11.px(r5)
            float r5 = (float) r5
            android.graphics.Paint r7 = r11.debugLinePaint
            r12.drawCircle(r0, r6, r5, r7)
        L_0x072e:
            android.graphics.PointF r0 = r11.quickScaleSCenter
            if (r0 == 0) goto L_0x0751
            android.graphics.Paint r0 = r11.debugLinePaint
            r0.setColor(r2)
            android.graphics.PointF r0 = r11.quickScaleSCenter
            float r0 = r0.x
            float r0 = r11.sourceToViewX(r0)
            android.graphics.PointF r2 = r11.quickScaleSCenter
            float r2 = r2.y
            float r2 = r11.sourceToViewY(r2)
            int r3 = r11.px(r3)
            float r3 = (float) r3
            android.graphics.Paint r5 = r11.debugLinePaint
            r12.drawCircle(r0, r2, r3, r5)
        L_0x0751:
            android.graphics.PointF r0 = r11.quickScaleVStart
            if (r0 == 0) goto L_0x0770
            boolean r0 = r11.isQuickScaling
            if (r0 == 0) goto L_0x0770
            android.graphics.Paint r0 = r11.debugLinePaint
            r0.setColor(r1)
            android.graphics.PointF r0 = r11.quickScaleVStart
            float r0 = r0.x
            android.graphics.PointF r1 = r11.quickScaleVStart
            float r1 = r1.y
            int r2 = r11.px(r4)
            float r2 = (float) r2
            android.graphics.Paint r3 = r11.debugLinePaint
            r12.drawCircle(r0, r1, r2, r3)
        L_0x0770:
            android.graphics.Paint r0 = r11.debugLinePaint
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            r0.setColor(r1)
        L_0x0778:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.onDraw(android.graphics.Canvas):void");
    }

    /* access modifiers changed from: protected */
    public void onImageLoaded() {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        boolean z2 = true;
        boolean z3 = mode != 1073741824;
        if (mode2 == 1073741824) {
            z2 = false;
        }
        if (this.sWidth > 0 && this.sHeight > 0) {
            if (z3 && z2) {
                size = sWidth();
                size2 = sHeight();
            } else if (z2) {
                double sHeight2 = (double) sHeight();
                double sWidth2 = (double) sWidth();
                Double.isNaN(sHeight2);
                Double.isNaN(sWidth2);
                double d2 = sHeight2 / sWidth2;
                double d3 = (double) size;
                Double.isNaN(d3);
                size2 = (int) (d2 * d3);
            } else if (z3) {
                double sWidth3 = (double) sWidth();
                double sHeight3 = (double) sHeight();
                Double.isNaN(sWidth3);
                Double.isNaN(sHeight3);
                double d4 = sWidth3 / sHeight3;
                double d5 = (double) size2;
                Double.isNaN(d5);
                size = (int) (d4 * d5);
            }
        }
        setMeasuredDimension(Math.max(size, getSuggestedMinimumWidth()), Math.max(size2, getSuggestedMinimumHeight()));
    }

    /* access modifiers changed from: protected */
    public void onReady() {
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        debug("onSizeChanged %dx%d -> %dx%d", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3));
        PointF center = getCenter();
        if (this.readySent && center != null) {
            this.anim = null;
            this.pendingScale = Float.valueOf(this.scale);
            this.sPendingCenter = center;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector;
        Anim anim2 = this.anim;
        if (anim2 == null || anim2.interruptible) {
            Anim anim3 = this.anim;
            if (!(anim3 == null || anim3.listener == null)) {
                try {
                    this.anim.listener.onInterruptedByUser();
                } catch (Exception e2) {
                    Log.w(TAG, "Error thrown by animation listener", e2);
                }
            }
            this.anim = null;
            if (this.vTranslate == null) {
                GestureDetector gestureDetector2 = this.singleDetector;
                if (gestureDetector2 != null) {
                    gestureDetector2.onTouchEvent(motionEvent);
                }
                return true;
            } else if (this.isQuickScaling || ((gestureDetector = this.detector) != null && !gestureDetector.onTouchEvent(motionEvent))) {
                if (this.vTranslateStart == null) {
                    this.vTranslateStart = new PointF(0.0f, 0.0f);
                }
                if (this.vTranslateBefore == null) {
                    this.vTranslateBefore = new PointF(0.0f, 0.0f);
                }
                if (this.vCenterStart == null) {
                    this.vCenterStart = new PointF(0.0f, 0.0f);
                }
                float f2 = this.scale;
                this.vTranslateBefore.set(this.vTranslate);
                boolean onTouchEventInternal = onTouchEventInternal(motionEvent);
                sendStateChanged(f2, this.vTranslateBefore, 2);
                return onTouchEventInternal || super.onTouchEvent(motionEvent);
            } else {
                this.isZooming = false;
                this.isPanning = false;
                this.maxTouchCount = 0;
                return true;
            }
        } else {
            requestDisallowInterceptTouchEvent(true);
            return true;
        }
    }

    public void recycle() {
        reset(true);
        this.bitmapPaint = null;
        this.debugTextPaint = null;
        this.debugLinePaint = null;
        this.tileBgPaint = null;
    }

    public final void resetScaleAndCenter() {
        this.anim = null;
        this.pendingScale = Float.valueOf(limitedScale(0.0f));
        if (isReady()) {
            this.sPendingCenter = new PointF((float) (sWidth() / 2), (float) (sHeight() / 2));
        } else {
            this.sPendingCenter = new PointF(0.0f, 0.0f);
        }
        invalidate();
    }

    public final void setBitmapDecoderClass(Class<? extends ImageDecoder> cls) {
        if (cls != null) {
            this.bitmapDecoderFactory = new CompatDecoderFactory(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setBitmapDecoderFactory(DecoderFactory<? extends ImageDecoder> decoderFactory) {
        if (decoderFactory != null) {
            this.bitmapDecoderFactory = decoderFactory;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setDebug(boolean z2) {
        this.debug = z2;
    }

    public final void setDoubleTapZoomDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / ((float) i2));
    }

    public final void setDoubleTapZoomDuration(int i2) {
        this.doubleTapZoomDuration = Math.max(0, i2);
    }

    public final void setDoubleTapZoomScale(float f2) {
        this.doubleTapZoomScale = f2;
    }

    public final void setDoubleTapZoomStyle(int i2) {
        if (VALID_ZOOM_STYLES.contains(Integer.valueOf(i2))) {
            this.doubleTapZoomStyle = i2;
            return;
        }
        throw new IllegalArgumentException("Invalid zoom style: " + i2);
    }

    public void setEagerLoadingEnabled(boolean z2) {
        this.eagerLoadingEnabled = z2;
    }

    public void setExecutor(Executor executor2) {
        Objects.requireNonNull(executor2, "Executor must not be null");
        this.executor = executor2;
    }

    public final void setImage(ImageSource imageSource) {
        setImage(imageSource, (ImageSource) null, (ImageViewState) null);
    }

    public final void setImage(ImageSource imageSource, ImageSource imageSource2) {
        setImage(imageSource, imageSource2, (ImageViewState) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$TilesInitTask} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$BitmapLoadTask} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$BitmapLoadTask} */
    /* JADX WARNING: type inference failed for: r9v2, types: [android.os.AsyncTask] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setImage(com.davemorrissey.labs.subscaleview.ImageSource r9, com.davemorrissey.labs.subscaleview.ImageSource r10, com.davemorrissey.labs.subscaleview.ImageViewState r11) {
        /*
            r8 = this;
            java.lang.String r0 = "imageSource must not be null"
            java.util.Objects.requireNonNull(r9, r0)
            r0 = 1
            r8.reset(r0)
            if (r11 == 0) goto L_0x000e
            r8.restoreState(r11)
        L_0x000e:
            java.lang.String r11 = "/"
            java.lang.String r0 = "android.resource://"
            if (r10 == 0) goto L_0x00a0
            android.graphics.Bitmap r1 = r9.getBitmap()
            if (r1 != 0) goto L_0x0098
            int r1 = r9.getSWidth()
            if (r1 <= 0) goto L_0x0090
            int r1 = r9.getSHeight()
            if (r1 <= 0) goto L_0x0090
            int r1 = r9.getSWidth()
            r8.sWidth = r1
            int r1 = r9.getSHeight()
            r8.sHeight = r1
            android.graphics.Rect r1 = r10.getSRegion()
            r8.pRegion = r1
            android.graphics.Bitmap r1 = r10.getBitmap()
            if (r1 == 0) goto L_0x004c
            boolean r1 = r10.isCached()
            r8.bitmapIsCached = r1
            android.graphics.Bitmap r10 = r10.getBitmap()
            r8.onPreviewLoaded(r10)
            goto L_0x00a0
        L_0x004c:
            android.net.Uri r1 = r10.getUri()
            if (r1 != 0) goto L_0x007d
            java.lang.Integer r2 = r10.getResource()
            if (r2 == 0) goto L_0x007d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            android.content.Context r2 = r8.getContext()
            java.lang.String r2 = r2.getPackageName()
            r1.append(r2)
            r1.append(r11)
            java.lang.Integer r10 = r10.getResource()
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            android.net.Uri r1 = android.net.Uri.parse(r10)
        L_0x007d:
            r6 = r1
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$BitmapLoadTask r10 = new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$BitmapLoadTask
            android.content.Context r4 = r8.getContext()
            com.davemorrissey.labs.subscaleview.decoder.DecoderFactory<? extends com.davemorrissey.labs.subscaleview.decoder.ImageDecoder> r5 = r8.bitmapDecoderFactory
            r7 = 1
            r2 = r10
            r3 = r8
            r2.<init>(r3, r4, r5, r6, r7)
            r8.execute(r10)
            goto L_0x00a0
        L_0x0090:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Preview image cannot be used unless dimensions are provided for the main image"
            r9.<init>(r10)
            throw r9
        L_0x0098:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Preview image cannot be used when a bitmap is provided for the main image"
            r9.<init>(r10)
            throw r9
        L_0x00a0:
            android.graphics.Bitmap r10 = r9.getBitmap()
            r1 = 0
            if (r10 == 0) goto L_0x00d6
            android.graphics.Rect r10 = r9.getSRegion()
            if (r10 == 0) goto L_0x00d6
            android.graphics.Bitmap r10 = r9.getBitmap()
            android.graphics.Rect r11 = r9.getSRegion()
            int r11 = r11.left
            android.graphics.Rect r0 = r9.getSRegion()
            int r0 = r0.top
            android.graphics.Rect r2 = r9.getSRegion()
            int r2 = r2.width()
            android.graphics.Rect r9 = r9.getSRegion()
            int r9 = r9.height()
            android.graphics.Bitmap r9 = android.graphics.Bitmap.createBitmap(r10, r11, r0, r2, r9)
            r8.onImageLoaded(r9, r1, r1)
            goto L_0x014f
        L_0x00d6:
            android.graphics.Bitmap r10 = r9.getBitmap()
            if (r10 == 0) goto L_0x00e8
            android.graphics.Bitmap r10 = r9.getBitmap()
            boolean r9 = r9.isCached()
            r8.onImageLoaded(r10, r1, r9)
            goto L_0x014f
        L_0x00e8:
            android.graphics.Rect r10 = r9.getSRegion()
            r8.sRegion = r10
            android.net.Uri r10 = r9.getUri()
            r8.uri = r10
            if (r10 != 0) goto L_0x0123
            java.lang.Integer r10 = r9.getResource()
            if (r10 == 0) goto L_0x0123
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            r10.append(r0)
            android.content.Context r0 = r8.getContext()
            java.lang.String r0 = r0.getPackageName()
            r10.append(r0)
            r10.append(r11)
            java.lang.Integer r11 = r9.getResource()
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            android.net.Uri r10 = android.net.Uri.parse(r10)
            r8.uri = r10
        L_0x0123:
            boolean r9 = r9.getTile()
            if (r9 != 0) goto L_0x013f
            android.graphics.Rect r9 = r8.sRegion
            if (r9 == 0) goto L_0x012e
            goto L_0x013f
        L_0x012e:
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$BitmapLoadTask r9 = new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$BitmapLoadTask
            android.content.Context r2 = r8.getContext()
            com.davemorrissey.labs.subscaleview.decoder.DecoderFactory<? extends com.davemorrissey.labs.subscaleview.decoder.ImageDecoder> r3 = r8.bitmapDecoderFactory
            android.net.Uri r4 = r8.uri
            r5 = 0
            r0 = r9
            r1 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x014c
        L_0x013f:
            com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$TilesInitTask r9 = new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$TilesInitTask
            android.content.Context r10 = r8.getContext()
            com.davemorrissey.labs.subscaleview.decoder.DecoderFactory<? extends com.davemorrissey.labs.subscaleview.decoder.ImageRegionDecoder> r11 = r8.regionDecoderFactory
            android.net.Uri r0 = r8.uri
            r9.<init>(r8, r10, r11, r0)
        L_0x014c:
            r8.execute(r9)
        L_0x014f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.setImage(com.davemorrissey.labs.subscaleview.ImageSource, com.davemorrissey.labs.subscaleview.ImageSource, com.davemorrissey.labs.subscaleview.ImageViewState):void");
    }

    public final void setImage(ImageSource imageSource, ImageViewState imageViewState) {
        setImage(imageSource, (ImageSource) null, imageViewState);
    }

    public final void setMaxScale(float f2) {
        this.maxScale = f2;
    }

    public void setMaxTileSize(int i2) {
        this.maxTileWidth = i2;
        this.maxTileHeight = i2;
    }

    public void setMaxTileSize(int i2, int i3) {
        this.maxTileWidth = i2;
        this.maxTileHeight = i3;
    }

    public final void setMaximumDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / ((float) i2));
    }

    public final void setMinScale(float f2) {
        this.minScale = f2;
    }

    public final void setMinimumDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f) / ((float) i2));
    }

    public final void setMinimumScaleType(int i2) {
        if (VALID_SCALE_TYPES.contains(Integer.valueOf(i2))) {
            this.minimumScaleType = i2;
            if (isReady()) {
                fitToBounds(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid scale type: " + i2);
    }

    public void setMinimumTileDpi(int i2) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.minimumTileDpi = (int) Math.min((displayMetrics.xdpi + displayMetrics.ydpi) / 2.0f, (float) i2);
        if (isReady()) {
            reset(false);
            invalidate();
        }
    }

    public void setOnImageEventListener(OnImageEventListener onImageEventListener2) {
        this.onImageEventListener = onImageEventListener2;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener2) {
        this.onLongClickListener = onLongClickListener2;
    }

    public void setOnStateChangedListener(OnStateChangedListener onStateChangedListener2) {
        this.onStateChangedListener = onStateChangedListener2;
    }

    public final void setOrientation(int i2) {
        if (VALID_ORIENTATIONS.contains(Integer.valueOf(i2))) {
            this.orientation = i2;
            reset(false);
            invalidate();
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Invalid orientation: " + i2);
    }

    public final void setPanEnabled(boolean z2) {
        PointF pointF;
        this.panEnabled = z2;
        if (!z2 && (pointF = this.vTranslate) != null) {
            pointF.x = ((float) (getWidth() / 2)) - (this.scale * ((float) (sWidth() / 2)));
            this.vTranslate.y = ((float) (getHeight() / 2)) - (this.scale * ((float) (sHeight() / 2)));
            if (isReady()) {
                refreshRequiredTiles(true);
                invalidate();
            }
        }
    }

    public final void setPanLimit(int i2) {
        if (VALID_PAN_LIMITS.contains(Integer.valueOf(i2))) {
            this.panLimit = i2;
            if (isReady()) {
                fitToBounds(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid pan limit: " + i2);
    }

    public final void setQuickScaleEnabled(boolean z2) {
        this.quickScaleEnabled = z2;
    }

    public final void setRegionDecoderClass(Class<? extends ImageRegionDecoder> cls) {
        if (cls != null) {
            this.regionDecoderFactory = new CompatDecoderFactory(cls);
            return;
        }
        throw new IllegalArgumentException("Decoder class cannot be set to null");
    }

    public final void setRegionDecoderFactory(DecoderFactory<? extends ImageRegionDecoder> decoderFactory) {
        if (decoderFactory != null) {
            this.regionDecoderFactory = decoderFactory;
            return;
        }
        throw new IllegalArgumentException("Decoder factory cannot be set to null");
    }

    public final void setScaleAndCenter(float f2, PointF pointF) {
        this.anim = null;
        this.pendingScale = Float.valueOf(f2);
        this.sPendingCenter = pointF;
        this.sRequestedCenter = pointF;
        invalidate();
    }

    public final void setTileBackgroundColor(int i2) {
        if (Color.alpha(i2) == 0) {
            this.tileBgPaint = null;
        } else {
            Paint paint = new Paint();
            this.tileBgPaint = paint;
            paint.setStyle(Paint.Style.FILL);
            this.tileBgPaint.setColor(i2);
        }
        invalidate();
    }

    public final void setZoomEnabled(boolean z2) {
        this.zoomEnabled = z2;
    }

    public final PointF sourceToViewCoord(float f2, float f3) {
        return sourceToViewCoord(f2, f3, new PointF());
    }

    public final PointF sourceToViewCoord(float f2, float f3, PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(sourceToViewX(f2), sourceToViewY(f3));
        return pointF;
    }

    public final PointF sourceToViewCoord(PointF pointF) {
        return sourceToViewCoord(pointF.x, pointF.y, new PointF());
    }

    public final PointF sourceToViewCoord(PointF pointF, PointF pointF2) {
        return sourceToViewCoord(pointF.x, pointF.y, pointF2);
    }

    public void viewToFileRect(Rect rect, Rect rect2) {
        if (this.vTranslate != null && this.readySent) {
            rect2.set((int) viewToSourceX((float) rect.left), (int) viewToSourceY((float) rect.top), (int) viewToSourceX((float) rect.right), (int) viewToSourceY((float) rect.bottom));
            fileSRect(rect2, rect2);
            rect2.set(Math.max(0, rect2.left), Math.max(0, rect2.top), Math.min(this.sWidth, rect2.right), Math.min(this.sHeight, rect2.bottom));
            Rect rect3 = this.sRegion;
            if (rect3 != null) {
                rect2.offset(rect3.left, this.sRegion.top);
            }
        }
    }

    public final PointF viewToSourceCoord(float f2, float f3) {
        return viewToSourceCoord(f2, f3, new PointF());
    }

    public final PointF viewToSourceCoord(float f2, float f3, PointF pointF) {
        if (this.vTranslate == null) {
            return null;
        }
        pointF.set(viewToSourceX(f2), viewToSourceY(f3));
        return pointF;
    }

    public final PointF viewToSourceCoord(PointF pointF) {
        return viewToSourceCoord(pointF.x, pointF.y, new PointF());
    }

    public final PointF viewToSourceCoord(PointF pointF, PointF pointF2) {
        return viewToSourceCoord(pointF.x, pointF.y, pointF2);
    }

    public void visibleFileRect(Rect rect) {
        if (this.vTranslate != null && this.readySent) {
            rect.set(0, 0, getWidth(), getHeight());
            viewToFileRect(rect, rect);
        }
    }
}
