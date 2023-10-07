package androidx.constraintlayout.motion.widget;

import java.util.Arrays;
import java.util.HashMap;

public class e {

    /* renamed from: a  reason: collision with root package name */
    HashMap<Object, HashMap<String, float[]>> f1826a = new HashMap<>();

    /* access modifiers changed from: package-private */
    public float a(Object obj, String str, int i2) {
        if (!this.f1826a.containsKey(obj)) {
            return Float.NaN;
        }
        HashMap hashMap = this.f1826a.get(obj);
        if (!hashMap.containsKey(str)) {
            return Float.NaN;
        }
        float[] fArr = (float[]) hashMap.get(str);
        if (fArr.length > i2) {
            return fArr[i2];
        }
        return Float.NaN;
    }

    /* access modifiers changed from: package-private */
    public void a(Object obj, String str, int i2, float f2) {
        HashMap hashMap;
        if (!this.f1826a.containsKey(obj)) {
            hashMap = new HashMap();
            float[] fArr = new float[(i2 + 1)];
            fArr[i2] = f2;
            hashMap.put(str, fArr);
        } else {
            hashMap = this.f1826a.get(obj);
            if (!hashMap.containsKey(str)) {
                float[] fArr2 = new float[(i2 + 1)];
                fArr2[i2] = f2;
                hashMap.put(str, fArr2);
            } else {
                float[] fArr3 = (float[]) hashMap.get(str);
                if (fArr3.length <= i2) {
                    fArr3 = Arrays.copyOf(fArr3, i2 + 1);
                }
                fArr3[i2] = f2;
                hashMap.put(str, fArr3);
                return;
            }
        }
        this.f1826a.put(obj, hashMap);
    }
}
