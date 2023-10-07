package com.autonavi.base.ae.gmap.gloverlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.util.TypedValue;
import com.amap.api.mapcore.util.dl;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CrossOverlay;
import com.autonavi.ae.gmap.gloverlay.AVectorCrossAttr;
import com.autonavi.amap.mapcore.interfaces.IAMap;
import com.autonavi.amap.mapcore.interfaces.ICrossVectorOverlay;

public class CrossVectorOverlay extends BaseMapOverlay<GLCrossVector, Object> implements ICrossVectorOverlay {
    AVectorCrossAttr attr = null;
    private CrossOverlay.GenerateCrossImageListener imageListener;
    /* access modifiers changed from: private */
    public boolean isImageMode = false;
    /* access modifiers changed from: private */
    public CrossOverlay.OnCrossVectorUpdateListener updateListener;

    public CrossVectorOverlay(int i2, Context context, IAMap iAMap) {
        super(i2, context, iAMap);
    }

    /* access modifiers changed from: private */
    public void drawVectorFailed(int i2) {
        CrossOverlay.GenerateCrossImageListener generateCrossImageListener;
        if (this.isImageMode && (generateCrossImageListener = this.imageListener) != null) {
            generateCrossImageListener.onGenerateComplete((Bitmap) null, i2);
        }
        if (this.updateListener != null) {
            CrossOverlay.UpdateItem updateItem = new CrossOverlay.UpdateItem();
            updateItem.dataUpdateFlag = i2;
            this.updateListener.onUpdate(0, updateItem);
        }
    }

    /* access modifiers changed from: private */
    public void initImageMode(boolean z2) {
        if (this.mGLOverlay != null) {
            ((GLCrossVector) this.mGLOverlay).initTextureCallback(this, z2);
        }
    }

    public void addItem(Object obj) {
    }

    public void addOverlayTexture(Bitmap bitmap, int i2, int i3) {
        GLTextureProperty gLTextureProperty = new GLTextureProperty();
        gLTextureProperty.mId = i2;
        gLTextureProperty.mAnchor = i3;
        gLTextureProperty.mBitmap = bitmap;
        gLTextureProperty.mXRatio = 0.0f;
        gLTextureProperty.mYRatio = 0.0f;
        gLTextureProperty.isGenMimps = true;
        this.mMapView.addOverlayTexture(this.mEngineID, gLTextureProperty);
    }

    public int dipToPixel(Context context, int i2) {
        if (context == null) {
            return i2;
        }
        try {
            return (int) TypedValue.applyDimension(1, (float) i2, context.getResources().getDisplayMetrics());
        } catch (Exception unused) {
            return i2;
        }
    }

    public void imageContentResult(int[] iArr, int i2, int i3) {
        int i4 = -1;
        if (iArr == null) {
            drawVectorFailed(-1);
        } else if (this.imageListener != null) {
            Bitmap a2 = dl.a(iArr, i2, i3);
            CrossOverlay.GenerateCrossImageListener generateCrossImageListener = this.imageListener;
            if (a2 != null) {
                i4 = 0;
            }
            generateCrossImageListener.onGenerateComplete(a2, i4);
        }
    }

    /* access modifiers changed from: protected */
    public void iniGLOverlay() {
        if (this.mMapView != null) {
            this.mMapView.queueEvent(new Runnable() {
                public void run() {
                    CrossVectorOverlay crossVectorOverlay = CrossVectorOverlay.this;
                    crossVectorOverlay.mGLOverlay = new GLCrossVector(crossVectorOverlay.mEngineID, CrossVectorOverlay.this.mMapView, hashCode());
                }
            });
        }
    }

    public void remove() {
        this.imageListener = null;
        setVisible(false);
        if (this.mMapView != null) {
            this.mMapView.queueEvent(new Runnable() {
                public void run() {
                    CrossVectorOverlay.this.releaseInstance();
                }
            });
        }
    }

    public void resumeMarker(final Bitmap bitmap) {
        if (this.mMapView != null) {
            this.mMapView.queueEvent(new Runnable() {
                public void run() {
                    CrossVectorOverlay.this.addOverlayTexture(bitmap, 12345, 4);
                    ((GLCrossVector) CrossVectorOverlay.this.mGLOverlay).setArrowResId(false, 12345);
                    ((GLCrossVector) CrossVectorOverlay.this.mGLOverlay).setCarResId(12345);
                    BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset("cross/crossing_nigth_bk.data");
                    CrossVectorOverlay.this.addOverlayTexture(fromAsset != null ? fromAsset.getBitmap() : null, 54321, 0);
                    ((GLCrossVector) CrossVectorOverlay.this.mGLOverlay).setBackgroundResId(54321);
                }
            });
        }
    }

    public void setAttribute(AVectorCrossAttr aVectorCrossAttr) {
        this.attr = aVectorCrossAttr;
    }

    public int setData(final byte[] bArr) {
        if (Build.VERSION.SDK_INT < 21) {
            drawVectorFailed(-1);
            return -1;
        }
        if (this.attr == null) {
            AVectorCrossAttr aVectorCrossAttr = new AVectorCrossAttr();
            this.attr = aVectorCrossAttr;
            aVectorCrossAttr.stAreaRect = new Rect(0, 0, this.mMapView.getMapWidth(), (this.mMapView.getMapHeight() * 4) / 11);
            this.attr.stAreaColor = Color.argb(217, 95, 95, 95);
            this.attr.fArrowBorderWidth = dipToPixel(this.mContext, 22);
            this.attr.stArrowBorderColor = Color.argb(0, 0, 50, 20);
            this.attr.fArrowLineWidth = dipToPixel(this.mContext, 18);
            this.attr.stArrowLineColor = Color.argb(255, 255, 253, 65);
            this.attr.dayMode = false;
        }
        if (!(bArr == null || this.attr == null || this.mMapView == null)) {
            this.mMapView.queueEvent(new Runnable() {
                public void run() {
                    CrossVectorOverlay crossVectorOverlay = CrossVectorOverlay.this;
                    crossVectorOverlay.initImageMode(crossVectorOverlay.isImageMode);
                    AVectorCrossAttr aVectorCrossAttr = CrossVectorOverlay.this.attr;
                    byte[] bArr = bArr;
                    int addVectorItem = ((GLCrossVector) CrossVectorOverlay.this.mGLOverlay).addVectorItem(aVectorCrossAttr, bArr, bArr.length);
                    CrossVectorOverlay crossVectorOverlay2 = CrossVectorOverlay.this;
                    if (addVectorItem != 0) {
                        crossVectorOverlay2.drawVectorFailed(addVectorItem);
                    } else if (crossVectorOverlay2.updateListener != null) {
                        CrossOverlay.UpdateItem updateItem = new CrossOverlay.UpdateItem();
                        updateItem.dataUpdateFlag = addVectorItem;
                        CrossVectorOverlay.this.updateListener.onUpdate(0, updateItem);
                    }
                }
            });
        }
        return -1;
    }

    public void setGenerateCrossImageListener(CrossOverlay.GenerateCrossImageListener generateCrossImageListener) {
        this.imageListener = generateCrossImageListener;
    }

    public void setImageMode(boolean z2) {
        this.isImageMode = z2;
    }

    public void setOnCrossVectorUpdateListener(CrossOverlay.OnCrossVectorUpdateListener onCrossVectorUpdateListener) {
        this.updateListener = onCrossVectorUpdateListener;
    }

    public void setVisible(final boolean z2) {
        if (this.mMapView != null) {
            this.mMapView.queueEvent(new Runnable() {
                public void run() {
                    if (CrossVectorOverlay.this.mGLOverlay != null) {
                        ((GLCrossVector) CrossVectorOverlay.this.mGLOverlay).setVisible(z2);
                    }
                }
            });
        }
    }
}
