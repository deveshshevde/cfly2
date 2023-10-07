package com.amap.api.maps.model;

public class BaseOptions {
    protected Object Field1;
    protected Object Field2;
    protected String type;

    public static class BaseUpdateFlags {
        protected boolean zIndexUpdate = false;

        public void reset() {
            this.zIndexUpdate = false;
        }
    }

    /* access modifiers changed from: protected */
    public BaseUpdateFlags getUpdateFlags() {
        return null;
    }

    /* access modifiers changed from: protected */
    public Object method1(Object... objArr) {
        return null;
    }

    /* access modifiers changed from: protected */
    public Object method2(Object... objArr) {
        return null;
    }

    public void resetUpdateFlags() {
    }
}
