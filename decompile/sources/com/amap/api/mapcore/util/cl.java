package com.amap.api.mapcore.util;

public enum cl {
    STYLE_ELEMENT_LABELFILL_OLD("labels.text.fill", 0),
    STYLE_ELEMENT_LABELSTROKE_OLD("labels.text.stroke", 1),
    STYLE_ELEMENT_GEOMETRYSTROKE_OLD("geometry.stroke", 2),
    STYLE_ELEMENT_GEOMETRYFILL_OLD("geometry.fill", 3),
    STYLE_ELEMENT_LABELFILL("textFillColor", 0),
    STYLE_ELEMENT_LABELSTROKE("textStrokeColor", 1),
    STYLE_ELEMENT_GEOMETRYSTROKE("strokeColor", 2),
    STYLE_ELEMENT_GEOMETRYFILL("fillColor", 3),
    STYLE_ELEMENT_GEOMETRYFILL1("color", 3),
    STYLE_ELEMENT_GEOMETRYFILL2("textureName", 3),
    STYLE_ELEMENT_BACKGROUNDFILL("backgroundColor", 4),
    STYLE_ELEMENT_VISIBLE("visible", 5);
    

    /* renamed from: m  reason: collision with root package name */
    private String f8181m;

    /* renamed from: n  reason: collision with root package name */
    private int f8182n;

    private cl(String str, int i2) {
        this.f8181m = str;
        this.f8182n = i2;
    }

    public static int a(String str) {
        for (cl clVar : values()) {
            if (clVar.a().equals(str)) {
                return clVar.f8182n;
            }
        }
        return -1;
    }

    private String a() {
        return this.f8181m;
    }
}
