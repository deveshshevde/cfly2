package com.amap.api.maps.model;

import java.util.ArrayList;
import java.util.List;

public class GL3DModelOptions extends BaseOptions {
    private BitmapDescriptor bitmapDescriptor;
    private int fixedLength = 50;
    private boolean isModeltUpdate = false;
    private LatLng latLng;
    private String modelData;
    private float rotate;
    private String snippet;
    private List<Float> textrueList = new ArrayList();
    private String title;
    private List<Float> vertextList = new ArrayList();
    private boolean visibile = true;

    public GL3DModelOptions() {
        this.type = "GL3DModelOptions";
    }

    public GL3DModelOptions angle(float f2) {
        this.rotate = f2;
        return this;
    }

    public float getAngle() {
        return this.rotate;
    }

    public BitmapDescriptor getBitmapDescriptor() {
        return this.bitmapDescriptor;
    }

    public LatLng getLatLng() {
        return this.latLng;
    }

    public int getModelFixedLength() {
        return this.fixedLength;
    }

    public String getSnippet() {
        return this.snippet;
    }

    public List<Float> getTextrue() {
        return this.textrueList;
    }

    public String getTitle() {
        return this.title;
    }

    public List<Float> getVertext() {
        return this.vertextList;
    }

    public boolean isVisible() {
        return this.visibile;
    }

    public GL3DModelOptions position(LatLng latLng2) {
        this.latLng = latLng2;
        return this;
    }

    public GL3DModelOptions setModelFixedLength(int i2) {
        this.fixedLength = i2;
        return this;
    }

    public GL3DModelOptions setVisible(boolean z2) {
        this.visibile = z2;
        return this;
    }

    public GL3DModelOptions snippet(String str) {
        this.snippet = str;
        return this;
    }

    public GL3DModelOptions textureDrawable(BitmapDescriptor bitmapDescriptor2) {
        this.bitmapDescriptor = bitmapDescriptor2;
        return this;
    }

    public GL3DModelOptions title(String str) {
        this.title = str;
        return this;
    }

    public GL3DModelOptions vertexData(String str) {
        if (str != null && str.length() > 0) {
            this.modelData = str;
            this.isModeltUpdate = true;
        }
        return this;
    }

    public GL3DModelOptions vertexData(List<Float> list, List<Float> list2) {
        this.vertextList = list;
        this.textrueList = list2;
        StringBuilder sb = new StringBuilder();
        if (this.vertextList != null) {
            for (int i2 = 0; i2 < this.vertextList.size() - 3; i2 += 3) {
                sb.append("v ");
                sb.append(this.vertextList.get(i2));
                sb.append(" ");
                sb.append(this.vertextList.get(i2 + 1));
                sb.append(" ");
                sb.append(this.vertextList.get(i2 + 2));
                sb.append("\n");
            }
        }
        if (this.textrueList != null) {
            for (int i3 = 0; i3 < this.textrueList.size() - 2; i3 += 2) {
                sb.append("vt ");
                sb.append(this.textrueList.get(i3));
                sb.append(" ");
                sb.append(1.0f - this.textrueList.get(i3 + 1).floatValue());
                sb.append("\n");
            }
        }
        vertexData(sb.toString());
        return this;
    }
}
