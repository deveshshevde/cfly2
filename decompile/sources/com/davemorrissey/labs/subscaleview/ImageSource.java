package com.davemorrissey.labs.subscaleview;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Objects;

public final class ImageSource {
    static final String ASSET_SCHEME = "file:///android_asset/";
    static final String FILE_SCHEME = "file:///";
    private final Bitmap bitmap;
    private boolean cached;
    private final Integer resource;
    private int sHeight;
    private Rect sRegion;
    private int sWidth;
    private boolean tile;
    private final Uri uri;

    private ImageSource(int i2) {
        this.bitmap = null;
        this.uri = null;
        this.resource = Integer.valueOf(i2);
        this.tile = true;
    }

    private ImageSource(Bitmap bitmap2, boolean z2) {
        this.bitmap = bitmap2;
        this.uri = null;
        this.resource = null;
        this.tile = false;
        this.sWidth = bitmap2.getWidth();
        this.sHeight = bitmap2.getHeight();
        this.cached = z2;
    }

    private ImageSource(Uri uri2) {
        String uri3 = uri2.toString();
        if (uri3.startsWith(FILE_SCHEME) && !new File(uri3.substring(7)).exists()) {
            try {
                uri2 = Uri.parse(URLDecoder.decode(uri3, "UTF-8"));
            } catch (UnsupportedEncodingException unused) {
            }
        }
        this.bitmap = null;
        this.uri = uri2;
        this.resource = null;
        this.tile = true;
    }

    public static ImageSource asset(String str) {
        Objects.requireNonNull(str, "Asset name must not be null");
        return uri(ASSET_SCHEME + str);
    }

    public static ImageSource bitmap(Bitmap bitmap2) {
        Objects.requireNonNull(bitmap2, "Bitmap must not be null");
        return new ImageSource(bitmap2, false);
    }

    public static ImageSource cachedBitmap(Bitmap bitmap2) {
        Objects.requireNonNull(bitmap2, "Bitmap must not be null");
        return new ImageSource(bitmap2, true);
    }

    public static ImageSource resource(int i2) {
        return new ImageSource(i2);
    }

    private void setInvariants() {
        Rect rect = this.sRegion;
        if (rect != null) {
            this.tile = true;
            this.sWidth = rect.width();
            this.sHeight = this.sRegion.height();
        }
    }

    public static ImageSource uri(Uri uri2) {
        Objects.requireNonNull(uri2, "Uri must not be null");
        return new ImageSource(uri2);
    }

    public static ImageSource uri(String str) {
        Objects.requireNonNull(str, "Uri must not be null");
        if (!str.contains("://")) {
            if (str.startsWith("/")) {
                str = str.substring(1);
            }
            str = FILE_SCHEME + str;
        }
        return new ImageSource(Uri.parse(str));
    }

    public ImageSource dimensions(int i2, int i3) {
        if (this.bitmap == null) {
            this.sWidth = i2;
            this.sHeight = i3;
        }
        setInvariants();
        return this;
    }

    /* access modifiers changed from: protected */
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    /* access modifiers changed from: protected */
    public final Integer getResource() {
        return this.resource;
    }

    /* access modifiers changed from: protected */
    public final int getSHeight() {
        return this.sHeight;
    }

    /* access modifiers changed from: protected */
    public final Rect getSRegion() {
        return this.sRegion;
    }

    /* access modifiers changed from: protected */
    public final int getSWidth() {
        return this.sWidth;
    }

    /* access modifiers changed from: protected */
    public final boolean getTile() {
        return this.tile;
    }

    /* access modifiers changed from: protected */
    public final Uri getUri() {
        return this.uri;
    }

    /* access modifiers changed from: protected */
    public final boolean isCached() {
        return this.cached;
    }

    public ImageSource region(Rect rect) {
        this.sRegion = rect;
        setInvariants();
        return this;
    }

    public ImageSource tiling(boolean z2) {
        this.tile = z2;
        return this;
    }

    public ImageSource tilingDisabled() {
        return tiling(false);
    }

    public ImageSource tilingEnabled() {
        return tiling(true);
    }
}
