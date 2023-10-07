package com.amap.api.maps.model;

public class AMapPara {
    public static final int DOTTEDLINE_TYPE_CIRCLE = 1;
    public static final int DOTTEDLINE_TYPE_DEFAULT = -1;
    public static final int DOTTEDLINE_TYPE_SQUARE = 0;

    public enum LineCapType {
        LineCapButt(0),
        LineCapSquare(1),
        LineCapArrow(2),
        LineCapRound(3);
        
        private int type;

        private LineCapType(int i2) {
            this.type = i2;
        }

        public static LineCapType valueOf(int i2) {
            LineCapType[] values = values();
            return values[Math.max(0, Math.min(i2, values.length))];
        }

        public final int getTypeValue() {
            return this.type;
        }
    }

    public enum LineJoinType {
        LineJoinBevel(0),
        LineJoinMiter(1),
        LineJoinRound(2);
        
        private int type;

        private LineJoinType(int i2) {
            this.type = i2;
        }

        public static LineJoinType valueOf(int i2) {
            LineJoinType[] values = values();
            return values[Math.max(0, Math.min(i2, values.length))];
        }

        public final int getTypeValue() {
            return this.type;
        }
    }
}
