package com.hoho.android.usbserial.driver;

import android.util.Pair;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProbeTable {
    private final Map<Pair<Integer, Integer>, Class<? extends UsbSerialDriver>> mProbeTable = new LinkedHashMap();

    /* access modifiers changed from: package-private */
    public ProbeTable addDriver(Class<? extends UsbSerialDriver> cls) {
        try {
            try {
                for (Map.Entry entry : ((Map) cls.getMethod("getSupportedDevices", new Class[0]).invoke((Object) null, new Object[0])).entrySet()) {
                    int intValue = ((Integer) entry.getKey()).intValue();
                    for (int addProduct : (int[]) entry.getValue()) {
                        addProduct(intValue, addProduct, cls);
                    }
                }
                return this;
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                throw new RuntimeException(e2);
            }
        } catch (NoSuchMethodException | SecurityException e3) {
            throw new RuntimeException(e3);
        }
    }

    public ProbeTable addProduct(int i2, int i3, Class<? extends UsbSerialDriver> cls) {
        this.mProbeTable.put(Pair.create(Integer.valueOf(i2), Integer.valueOf(i3)), cls);
        return this;
    }

    public Class<? extends UsbSerialDriver> findDriver(int i2, int i3) {
        return this.mProbeTable.get(Pair.create(Integer.valueOf(i2), Integer.valueOf(i3)));
    }
}
