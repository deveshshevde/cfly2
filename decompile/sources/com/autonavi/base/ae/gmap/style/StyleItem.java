package com.autonavi.base.ae.gmap.style;

import java.util.HashMap;
import java.util.Map;

public class StyleItem {
    public int mainKey;
    private Map<Integer, StyleElement> styleElements = new HashMap();
    private int styleTypeId;
    public int[] subKey;

    public StyleItem(int i2) {
        this.styleTypeId = i2;
    }

    public StyleElement get(int i2) {
        return this.styleElements.get(Integer.valueOf(i2));
    }

    public StyleElement[] getStyleElements() {
        Map<Integer, StyleElement> map = this.styleElements;
        if (map == null || map.size() <= 0) {
            return null;
        }
        return (StyleElement[]) this.styleElements.values().toArray(new StyleElement[this.styleElements.size()]);
    }

    public boolean isValid() {
        return this.styleElements.size() > 0 && this.styleTypeId >= 0;
    }

    public void put(int i2, StyleElement styleElement) {
        this.styleElements.put(Integer.valueOf(i2), styleElement);
    }

    public String toString() {
        return "styleTypeId:" + this.styleTypeId + "\n" + "styleElements.size :" + this.styleElements.size();
    }
}
