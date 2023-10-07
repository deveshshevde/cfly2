package com.autonavi.base.amap.mapcore;

import android.opengl.Matrix;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import fg.i;
import java.util.concurrent.atomic.AtomicInteger;

public class MapConfig implements IMapConfig, Cloneable {
    public static final int DEFAULT_RATIO = 1;
    private static final int GEO_POINT_ZOOM = 20;
    public static final float MAX_ZOOM = 20.0f;
    public static final float MAX_ZOOM_INDOOR = 20.0f;
    public static final float MIN_ZOOM = 3.0f;
    public static final int MSG_ACTION_ONBASEPOICLICK = 20;
    public static final int MSG_ACTION_ONMAPCLICK = 19;
    public static final int MSG_AUTH_FAILURE = 2;
    public static final int MSG_CALLBACK_MAPLOADED = 16;
    public static final int MSG_CALLBACK_ONTOUCHEVENT = 14;
    public static final int MSG_CALLBACK_SCREENSHOT = 15;
    public static final int MSG_CAMERAUPDATE_CHANGE = 10;
    public static final int MSG_CAMERAUPDATE_FINISH = 11;
    public static final int MSG_COMPASSVIEW_CHANGESTATE = 13;
    public static final int MSG_INFOWINDOW_UPDATE = 18;
    public static final int MSG_TILEOVERLAY_REFRESH = 17;
    public static final int MSG_ZOOMVIEW_CHANGESTATE = 12;
    private static final int TILE_SIZE_POW = 8;
    private int abroadState = 1;
    private int anchorX = 0;
    private int anchorY = 0;
    private volatile double changeGridRatio = 1.0d;
    private volatile double changeRatio = 1.0d;
    private AtomicInteger changedCounter = new AtomicInteger(0);
    private int customBackgroundColor = -1;
    private String customTextureResourcePath;
    private Rectangle geoRectangle = new Rectangle();
    private int gridX = 0;
    private int gridY = 0;
    private boolean isAbroadEnable = false;
    private boolean isBearingChanged = false;
    private boolean isBuildingEnable = true;
    private boolean isCenterChanged = false;
    private boolean isCustomStyleEnabled = false;
    private boolean isHideLogoEnable = false;
    private boolean isIndoorEnable = false;
    private boolean isMapTextEnable = true;
    private boolean isNeedUpdateMapRectNextFrame = false;
    private boolean isNeedUpdateZoomControllerState = false;
    private boolean isProFunctionAuthEnable = true;
    private boolean isSetLimitZoomLevel;
    private boolean isTerrainEnable = false;
    private boolean isTiltChanged = false;
    private boolean isTouchPoiEnable = true;
    private boolean isTrafficEnabled = false;
    private boolean isUseProFunction = false;
    private boolean isWorldMapEnable = false;
    private boolean isZoomChanged = false;
    MapConfig lastMapconfig = null;
    private IPoint[] limitIPoints;
    private LatLngBounds limitLatLngBounds;
    private String mCustomStyleID;
    private String mCustomStylePath;
    private String mMapLanguage = "zh_cn";
    private int mMapStyleMode = 0;
    private int mMapStyleState = 0;
    private int mMapStyleTime = 0;
    private boolean mapEnable = true;
    private DPoint mapGeoCenter = new DPoint(this.sX, this.sY);
    private int mapHeight;
    private float mapPerPixelUnitLength;
    private FPoint[] mapRect = null;
    private int mapWidth;
    private float mapZoomScale = 1.0f;
    public float maxZoomLevel = 20.0f;
    public float minZoomLevel = 3.0f;
    float[] mvpMatrix = new float[16];
    float[] projectionMatrix = new float[16];
    private float sC = 0.0f;
    private float sR = 0.0f;
    private double sX = 2.21010267E8d;
    private double sY = 1.01697799E8d;
    private float sZ = 10.0f;
    private float skyHeight;
    private int[] tilsIDs = new int[100];
    float[] viewMatrix = new float[16];

    public MapConfig(boolean z2) {
        if (z2) {
            MapConfig mapConfig = new MapConfig(false);
            this.lastMapconfig = mapConfig;
            mapConfig.setGridXY(0, 0);
            this.lastMapconfig.setSX(i.f27244a);
            this.lastMapconfig.setSY(i.f27244a);
            this.lastMapconfig.setSZ(0.0f);
            this.lastMapconfig.setSC(0.0f);
            this.lastMapconfig.setSR(0.0f);
        }
    }

    private void changeRatio() {
        double sx = this.lastMapconfig.getSX();
        double sy = this.lastMapconfig.getSY();
        float sz = this.lastMapconfig.getSZ();
        float sc = this.lastMapconfig.getSC();
        float sr = this.lastMapconfig.getSR();
        this.changeRatio = Math.abs(this.sX - sx) + Math.abs(this.sY - sy);
        double d2 = 1.0d;
        this.changeRatio = this.changeRatio == i.f27244a ? 1.0d : this.changeRatio * 2.0d;
        double d3 = this.changeRatio;
        float f2 = this.sZ;
        this.changeRatio = d3 * (sz == f2 ? 1.0d : (double) Math.abs(sz - f2));
        float f3 = this.sC;
        float f4 = 1.0f;
        float abs = sc == f3 ? 1.0f : Math.abs(sc - f3);
        float f5 = this.sR;
        if (sr != f5) {
            f4 = Math.abs(sr - f5);
        }
        double d4 = this.changeRatio;
        double d5 = (double) abs;
        Double.isNaN(d5);
        this.changeRatio = d4 * d5;
        double d6 = this.changeRatio;
        double d7 = (double) f4;
        Double.isNaN(d7);
        this.changeRatio = d6 * d7;
        this.changeGridRatio = (double) (Math.abs(this.lastMapconfig.getGridX() - this.gridX) + (this.lastMapconfig.getGridY() - this.gridY));
        if (this.changeGridRatio != i.f27244a) {
            d2 = this.changeGridRatio * 2.0d;
        }
        this.changeGridRatio = d2;
        double d8 = this.changeGridRatio;
        Double.isNaN(d5);
        this.changeGridRatio = d8 * d5;
        double d9 = this.changeGridRatio;
        Double.isNaN(d7);
        this.changeGridRatio = d9 * d7;
    }

    public void addChangedCounter() {
        this.changedCounter.incrementAndGet();
    }

    public int getAbroadState() {
        return this.abroadState;
    }

    public int getAnchorX() {
        return this.anchorX;
    }

    public int getAnchorY() {
        return this.anchorY;
    }

    public double getChangeGridRatio() {
        return this.changeGridRatio;
    }

    public double getChangeRatio() {
        return this.changeRatio;
    }

    public int getChangedCounter() {
        return this.changedCounter.get();
    }

    public int[] getCurTileIds() {
        return this.tilsIDs;
    }

    public int getCustomBackgroundColor() {
        return this.customBackgroundColor;
    }

    public String getCustomStyleID() {
        return this.mCustomStyleID;
    }

    public String getCustomStylePath() {
        return this.mCustomStylePath;
    }

    public String getCustomTextureResourcePath() {
        return this.customTextureResourcePath;
    }

    public Rectangle getGeoRectangle() {
        return this.geoRectangle;
    }

    /* access modifiers changed from: protected */
    public int getGridX() {
        return this.gridX;
    }

    /* access modifiers changed from: protected */
    public int getGridY() {
        return this.gridY;
    }

    public IPoint[] getLimitIPoints() {
        return this.limitIPoints;
    }

    public LatLngBounds getLimitLatLngBounds() {
        return this.limitLatLngBounds;
    }

    public DPoint getMapGeoCenter() {
        return this.mapGeoCenter;
    }

    public int getMapHeight() {
        return this.mapHeight;
    }

    public String getMapLanguage() {
        return this.mMapLanguage;
    }

    public float getMapPerPixelUnitLength() {
        return this.mapPerPixelUnitLength;
    }

    public FPoint[] getMapRect() {
        return this.mapRect;
    }

    public int getMapStyleMode() {
        return this.mMapStyleMode;
    }

    public int getMapStyleState() {
        return this.mMapStyleState;
    }

    public int getMapStyleTime() {
        return this.mMapStyleTime;
    }

    public int getMapWidth() {
        return this.mapWidth;
    }

    public float getMapZoomScale() {
        return this.mapZoomScale;
    }

    public float getMaxZoomLevel() {
        return this.maxZoomLevel;
    }

    public float getMinZoomLevel() {
        return this.minZoomLevel;
    }

    public float[] getMvpMatrix() {
        return this.mvpMatrix;
    }

    public float[] getProjectionMatrix() {
        return this.projectionMatrix;
    }

    public float getSC() {
        return this.sC;
    }

    public float getSR() {
        return this.sR;
    }

    public double getSX() {
        return this.sX;
    }

    public double getSY() {
        return this.sY;
    }

    public float getSZ() {
        return this.sZ;
    }

    public float getSkyHeight() {
        return this.skyHeight;
    }

    public float[] getViewMatrix() {
        return this.viewMatrix;
    }

    public boolean isAbroadEnable() {
        return this.isAbroadEnable;
    }

    public boolean isBearingChanged() {
        return this.isBearingChanged;
    }

    public boolean isBuildingEnable() {
        return this.isBuildingEnable;
    }

    public boolean isCustomStyleEnable() {
        return this.isCustomStyleEnabled;
    }

    public boolean isHideLogoEnable() {
        return this.isHideLogoEnable;
    }

    public boolean isIndoorEnable() {
        return this.isIndoorEnable;
    }

    public boolean isMapEnable() {
        return this.mapEnable;
    }

    public boolean isMapStateChange() {
        MapConfig mapConfig = this.lastMapconfig;
        boolean z2 = false;
        if (mapConfig != null) {
            double sx = mapConfig.getSX();
            double sy = this.lastMapconfig.getSY();
            float sz = this.lastMapconfig.getSZ();
            float sc = this.lastMapconfig.getSC();
            float sr = this.lastMapconfig.getSR();
            double d2 = this.sX;
            boolean z3 = sx != d2;
            this.isCenterChanged = z3;
            double d3 = this.sY;
            if (sy != d3) {
                z3 = true;
            }
            this.isCenterChanged = z3;
            float f2 = this.sZ;
            boolean z4 = sz != f2;
            this.isZoomChanged = z4;
            if (z4) {
                float f3 = this.minZoomLevel;
                if (sz > f3 && f2 > f3) {
                    float f4 = this.maxZoomLevel;
                    if (sz < f4 && f2 < f4) {
                        this.isNeedUpdateZoomControllerState = false;
                    }
                }
                this.isNeedUpdateZoomControllerState = true;
            }
            boolean z5 = sc != this.sC;
            this.isTiltChanged = z5;
            boolean z6 = sr != this.sR;
            this.isBearingChanged = z6;
            boolean z7 = z3 || z4 || z5 || z6 || this.isNeedUpdateMapRectNextFrame;
            if (z7) {
                this.isNeedUpdateMapRectNextFrame = false;
                int i2 = (20 - ((int) f2)) + 8;
                setGridXY(((int) d2) >> i2, ((int) d3) >> i2);
                changeRatio();
            }
            z2 = z7;
        }
        if (this.sC < 45.0f || this.skyHeight != 0.0f) {
            return z2;
        }
        return true;
    }

    public boolean isMapTextEnable() {
        return this.isMapTextEnable;
    }

    public boolean isNeedUpdateZoomControllerState() {
        return this.isNeedUpdateZoomControllerState;
    }

    public boolean isProFunctionAuthEnable() {
        return this.isProFunctionAuthEnable;
    }

    public boolean isSetLimitZoomLevel() {
        return this.isSetLimitZoomLevel;
    }

    public boolean isTerrainEnable() {
        return this.isTerrainEnable;
    }

    public boolean isTiltChanged() {
        return this.isTiltChanged;
    }

    public boolean isTouchPoiEnable() {
        return this.isTouchPoiEnable;
    }

    public boolean isTrafficEnabled() {
        return this.isTrafficEnabled;
    }

    public boolean isUseProFunction() {
        return this.isUseProFunction;
    }

    public boolean isWorldMapEnable() {
        return this.isWorldMapEnable;
    }

    public boolean isZoomChanged() {
        return this.isZoomChanged;
    }

    public void resetChangedCounter() {
        this.changedCounter.set(0);
    }

    public void resetMinMaxZoomPreference() {
        this.minZoomLevel = 3.0f;
        this.maxZoomLevel = 20.0f;
        this.isSetLimitZoomLevel = false;
    }

    public void setAbroadEnable(boolean z2) {
        this.isAbroadEnable = z2;
    }

    public void setAbroadState(int i2) {
        this.abroadState = i2;
    }

    public void setAnchorX(int i2) {
        this.anchorX = i2;
    }

    public void setAnchorY(int i2) {
        this.anchorY = i2;
    }

    public void setBuildingEnable(boolean z2) {
        this.isBuildingEnable = z2;
    }

    public void setCustomBackgroundColor(int i2) {
        this.customBackgroundColor = i2;
    }

    public void setCustomStyleEnable(boolean z2) {
        this.isCustomStyleEnabled = z2;
    }

    public void setCustomStyleID(String str) {
        this.mCustomStyleID = str;
    }

    public void setCustomStylePath(String str) {
        this.mCustomStylePath = str;
    }

    public void setCustomTextureResourcePath(String str) {
        this.customTextureResourcePath = str;
    }

    /* access modifiers changed from: protected */
    public void setGridXY(int i2, int i3) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setGridXY(this.gridX, this.gridY);
        }
        this.gridX = i2;
        this.gridY = i3;
    }

    public void setHideLogoEnble(boolean z2) {
        this.isHideLogoEnable = z2;
    }

    public void setIndoorEnable(boolean z2) {
        this.isIndoorEnable = z2;
    }

    public void setLimitIPoints(IPoint[] iPointArr) {
        this.limitIPoints = iPointArr;
    }

    public void setLimitLatLngBounds(LatLngBounds latLngBounds) {
        this.limitLatLngBounds = latLngBounds;
        if (latLngBounds == null) {
            resetMinMaxZoomPreference();
        }
    }

    public void setMapEnable(boolean z2) {
        this.mapEnable = z2;
    }

    public void setMapHeight(int i2) {
        this.mapHeight = i2;
    }

    public void setMapLanguage(String str) {
        this.mMapLanguage = str;
    }

    public void setMapPerPixelUnitLength(float f2) {
        this.mapPerPixelUnitLength = f2;
    }

    public void setMapRect(FPoint[] fPointArr) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setMapRect(fPointArr);
        }
        this.mapRect = fPointArr;
    }

    public void setMapStyleMode(int i2) {
        this.mMapStyleMode = i2;
    }

    public void setMapStyleState(int i2) {
        this.mMapStyleState = i2;
    }

    public void setMapStyleTime(int i2) {
        this.mMapStyleTime = i2;
    }

    public void setMapTextEnable(boolean z2) {
        this.isMapTextEnable = z2;
    }

    public void setMapWidth(int i2) {
        this.mapWidth = i2;
    }

    public void setMapZoomScale(float f2) {
        this.mapZoomScale = f2;
    }

    public void setMaxZoomLevel(float f2) {
        if (f2 > 20.0f) {
            f2 = 20.0f;
        }
        if (f2 < 3.0f) {
            f2 = 3.0f;
        }
        if (f2 < getMinZoomLevel()) {
            f2 = getMinZoomLevel();
        }
        this.isSetLimitZoomLevel = true;
        this.maxZoomLevel = f2;
    }

    public void setMinZoomLevel(float f2) {
        if (f2 < 3.0f) {
            f2 = 3.0f;
        }
        if (f2 > 20.0f) {
            f2 = 20.0f;
        }
        if (f2 > getMaxZoomLevel()) {
            f2 = getMaxZoomLevel();
        }
        this.isSetLimitZoomLevel = true;
        this.minZoomLevel = f2;
    }

    public void setProFunctionAuthEnable(boolean z2) {
        this.isProFunctionAuthEnable = z2;
    }

    public void setSC(float f2) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSC(this.sC);
        }
        this.sC = f2;
    }

    public void setSR(float f2) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSR(this.sR);
        }
        this.sR = f2;
    }

    public void setSX(double d2) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSX(this.sX);
        }
        this.sX = d2;
        this.mapGeoCenter.f10009x = d2;
    }

    public void setSY(double d2) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSY(this.sY);
        }
        this.sY = d2;
        this.mapGeoCenter.f10009x = d2;
    }

    public void setSZ(float f2) {
        MapConfig mapConfig = this.lastMapconfig;
        if (mapConfig != null) {
            mapConfig.setSZ(this.sZ);
        }
        this.sZ = f2;
    }

    public void setSkyHeight(float f2) {
        this.skyHeight = f2;
    }

    public void setTerrainEnable(boolean z2) {
        this.isTerrainEnable = z2;
    }

    public void setTouchPoiEnable(boolean z2) {
        this.isTouchPoiEnable = z2;
    }

    public void setTrafficEnabled(boolean z2) {
        this.isTrafficEnabled = z2;
    }

    public void setUseProFunction(boolean z2) {
        this.isUseProFunction = z2;
    }

    public void setWorldMapEnable(boolean z2) {
        this.isWorldMapEnable = z2;
    }

    public String toString() {
        return " sX: " + this.sX + " sY: " + this.sY + " sZ: " + this.sZ + " sC: " + this.sC + " sR: " + this.sR + " skyHeight: " + this.skyHeight;
    }

    public void updateFinalMatrix() {
        Matrix.multiplyMM(this.mvpMatrix, 0, this.projectionMatrix, 0, this.viewMatrix, 0);
    }

    public void updateMapRectNextFrame(boolean z2) {
        this.isNeedUpdateMapRectNextFrame = z2;
    }
}
