package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import java.util.HashSet;

public class k extends c {
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f1889g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f1890h = -1;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public float f1891i = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public float f1892j = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public float f1893k = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public float f1894l = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public float f1895m = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public float f1896n = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public float f1897o = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public float f1898p = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public float f1899q = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public float f1900r = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public float f1901s = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public float f1902t = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public int f1903u = 0;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public float f1904v = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public float f1905w = 0.0f;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f1906a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1906a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyTimeCycle_android_alpha, 1);
            f1906a.append(R.styleable.KeyTimeCycle_android_elevation, 2);
            f1906a.append(R.styleable.KeyTimeCycle_android_rotation, 4);
            f1906a.append(R.styleable.KeyTimeCycle_android_rotationX, 5);
            f1906a.append(R.styleable.KeyTimeCycle_android_rotationY, 6);
            f1906a.append(R.styleable.KeyTimeCycle_android_scaleX, 7);
            f1906a.append(R.styleable.KeyTimeCycle_transitionPathRotate, 8);
            f1906a.append(R.styleable.KeyTimeCycle_transitionEasing, 9);
            f1906a.append(R.styleable.KeyTimeCycle_motionTarget, 10);
            f1906a.append(R.styleable.KeyTimeCycle_framePosition, 12);
            f1906a.append(R.styleable.KeyTimeCycle_curveFit, 13);
            f1906a.append(R.styleable.KeyTimeCycle_android_scaleY, 14);
            f1906a.append(R.styleable.KeyTimeCycle_android_translationX, 15);
            f1906a.append(R.styleable.KeyTimeCycle_android_translationY, 16);
            f1906a.append(R.styleable.KeyTimeCycle_android_translationZ, 17);
            f1906a.append(R.styleable.KeyTimeCycle_motionProgress, 18);
            f1906a.append(R.styleable.KeyTimeCycle_wavePeriod, 20);
            f1906a.append(R.styleable.KeyTimeCycle_waveOffset, 21);
            f1906a.append(R.styleable.KeyTimeCycle_waveShape, 19);
        }

        public static void a(k kVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                switch (f1906a.get(index)) {
                    case 1:
                        float unused = kVar.f1891i = typedArray.getFloat(index, kVar.f1891i);
                        break;
                    case 2:
                        float unused2 = kVar.f1892j = typedArray.getDimension(index, kVar.f1892j);
                        break;
                    case 4:
                        float unused3 = kVar.f1893k = typedArray.getFloat(index, kVar.f1893k);
                        break;
                    case 5:
                        float unused4 = kVar.f1894l = typedArray.getFloat(index, kVar.f1894l);
                        break;
                    case 6:
                        float unused5 = kVar.f1895m = typedArray.getFloat(index, kVar.f1895m);
                        break;
                    case 7:
                        float unused6 = kVar.f1897o = typedArray.getFloat(index, kVar.f1897o);
                        break;
                    case 8:
                        float unused7 = kVar.f1896n = typedArray.getFloat(index, kVar.f1896n);
                        break;
                    case 9:
                        String unused8 = kVar.f1889g = typedArray.getString(index);
                        break;
                    case 10:
                        if (!MotionLayout.f1692a) {
                            if (typedArray.peekValue(index).type != 3) {
                                kVar.f1804c = typedArray.getResourceId(index, kVar.f1804c);
                                break;
                            }
                        } else {
                            kVar.f1804c = typedArray.getResourceId(index, kVar.f1804c);
                            if (kVar.f1804c != -1) {
                                break;
                            }
                        }
                        kVar.f1805d = typedArray.getString(index);
                        break;
                    case 12:
                        kVar.f1803b = typedArray.getInt(index, kVar.f1803b);
                        break;
                    case 13:
                        int unused9 = kVar.f1890h = typedArray.getInteger(index, kVar.f1890h);
                        break;
                    case 14:
                        float unused10 = kVar.f1898p = typedArray.getFloat(index, kVar.f1898p);
                        break;
                    case 15:
                        float unused11 = kVar.f1899q = typedArray.getDimension(index, kVar.f1899q);
                        break;
                    case 16:
                        float unused12 = kVar.f1900r = typedArray.getDimension(index, kVar.f1900r);
                        break;
                    case 17:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            float unused13 = kVar.f1901s = typedArray.getDimension(index, kVar.f1901s);
                            break;
                        }
                    case 18:
                        float unused14 = kVar.f1902t = typedArray.getFloat(index, kVar.f1902t);
                        break;
                    case 19:
                        int unused15 = kVar.f1903u = typedArray.getInt(index, kVar.f1903u);
                        break;
                    case 20:
                        float unused16 = kVar.f1904v = typedArray.getFloat(index, kVar.f1904v);
                        break;
                    case 21:
                        float unused17 = kVar.f1905w = typedArray.peekValue(index).type == 5 ? typedArray.getDimension(index, kVar.f1905w) : typedArray.getFloat(index, kVar.f1905w);
                        break;
                    default:
                        Log.e("KeyTimeCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + f1906a.get(index));
                        break;
                }
            }
        }
    }

    public k() {
        this.f1806e = 3;
        this.f1807f = new HashMap();
    }

    public void a(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyTimeCycle));
    }

    public void a(HashMap<String, r> hashMap) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    public void a(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f1891i)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f1892j)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f1893k)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f1894l)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f1895m)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f1899q)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f1900r)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f1901s)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f1896n)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f1897o)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f1898p)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f1902t)) {
            hashSet.add("progress");
        }
        if (this.f1807f.size() > 0) {
            for (String str : this.f1807f.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    public void b(HashMap<String, Integer> hashMap) {
        if (this.f1890h != -1) {
            if (!Float.isNaN(this.f1891i)) {
                hashMap.put("alpha", Integer.valueOf(this.f1890h));
            }
            if (!Float.isNaN(this.f1892j)) {
                hashMap.put("elevation", Integer.valueOf(this.f1890h));
            }
            if (!Float.isNaN(this.f1893k)) {
                hashMap.put("rotation", Integer.valueOf(this.f1890h));
            }
            if (!Float.isNaN(this.f1894l)) {
                hashMap.put("rotationX", Integer.valueOf(this.f1890h));
            }
            if (!Float.isNaN(this.f1895m)) {
                hashMap.put("rotationY", Integer.valueOf(this.f1890h));
            }
            if (!Float.isNaN(this.f1899q)) {
                hashMap.put("translationX", Integer.valueOf(this.f1890h));
            }
            if (!Float.isNaN(this.f1900r)) {
                hashMap.put("translationY", Integer.valueOf(this.f1890h));
            }
            if (!Float.isNaN(this.f1901s)) {
                hashMap.put("translationZ", Integer.valueOf(this.f1890h));
            }
            if (!Float.isNaN(this.f1896n)) {
                hashMap.put("transitionPathRotate", Integer.valueOf(this.f1890h));
            }
            if (!Float.isNaN(this.f1897o)) {
                hashMap.put("scaleX", Integer.valueOf(this.f1890h));
            }
            if (!Float.isNaN(this.f1897o)) {
                hashMap.put("scaleY", Integer.valueOf(this.f1890h));
            }
            if (!Float.isNaN(this.f1902t)) {
                hashMap.put("progress", Integer.valueOf(this.f1890h));
            }
            if (this.f1807f.size() > 0) {
                for (String str : this.f1807f.keySet()) {
                    hashMap.put("CUSTOM," + str, Integer.valueOf(this.f1890h));
                }
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0089, code lost:
        if (r1.equals("scaleY") == false) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0105, code lost:
        r3.a(r4, r5, r10.f1904v, r10.f1903u, r10.f1905w);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.s> r11) {
        /*
            r10 = this;
            java.util.Set r0 = r11.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01a1
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r11.get(r1)
            r3 = r2
            androidx.constraintlayout.motion.widget.s r3 = (androidx.constraintlayout.motion.widget.s) r3
            java.lang.String r2 = "CUSTOM"
            boolean r2 = r1.startsWith(r2)
            r4 = 7
            if (r2 == 0) goto L_0x0042
            java.lang.String r1 = r1.substring(r4)
            java.util.HashMap r2 = r10.f1807f
            java.lang.Object r1 = r2.get(r1)
            r6 = r1
            androidx.constraintlayout.widget.ConstraintAttribute r6 = (androidx.constraintlayout.widget.ConstraintAttribute) r6
            if (r6 == 0) goto L_0x0008
            r4 = r3
            androidx.constraintlayout.motion.widget.s$b r4 = (androidx.constraintlayout.motion.widget.s.b) r4
            int r5 = r10.f1803b
            float r7 = r10.f1904v
            int r8 = r10.f1903u
            float r9 = r10.f1905w
            r4.a((int) r5, (androidx.constraintlayout.widget.ConstraintAttribute) r6, (float) r7, (int) r8, (float) r9)
            goto L_0x0008
        L_0x0042:
            r1.hashCode()
            r2 = -1
            int r5 = r1.hashCode()
            switch(r5) {
                case -1249320806: goto L_0x00ce;
                case -1249320805: goto L_0x00c3;
                case -1225497657: goto L_0x00b8;
                case -1225497656: goto L_0x00ad;
                case -1225497655: goto L_0x00a2;
                case -1001078227: goto L_0x0097;
                case -908189618: goto L_0x008c;
                case -908189617: goto L_0x0083;
                case -40300674: goto L_0x0077;
                case -4379043: goto L_0x006a;
                case 37232917: goto L_0x005d;
                case 92909918: goto L_0x0050;
                default: goto L_0x004d;
            }
        L_0x004d:
            r4 = -1
            goto L_0x00d9
        L_0x0050:
            java.lang.String r4 = "alpha"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0059
            goto L_0x004d
        L_0x0059:
            r4 = 11
            goto L_0x00d9
        L_0x005d:
            java.lang.String r4 = "transitionPathRotate"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0066
            goto L_0x004d
        L_0x0066:
            r4 = 10
            goto L_0x00d9
        L_0x006a:
            java.lang.String r4 = "elevation"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0073
            goto L_0x004d
        L_0x0073:
            r4 = 9
            goto L_0x00d9
        L_0x0077:
            java.lang.String r4 = "rotation"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0080
            goto L_0x004d
        L_0x0080:
            r4 = 8
            goto L_0x00d9
        L_0x0083:
            java.lang.String r5 = "scaleY"
            boolean r5 = r1.equals(r5)
            if (r5 != 0) goto L_0x00d9
            goto L_0x004d
        L_0x008c:
            java.lang.String r4 = "scaleX"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0095
            goto L_0x004d
        L_0x0095:
            r4 = 6
            goto L_0x00d9
        L_0x0097:
            java.lang.String r4 = "progress"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00a0
            goto L_0x004d
        L_0x00a0:
            r4 = 5
            goto L_0x00d9
        L_0x00a2:
            java.lang.String r4 = "translationZ"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00ab
            goto L_0x004d
        L_0x00ab:
            r4 = 4
            goto L_0x00d9
        L_0x00ad:
            java.lang.String r4 = "translationY"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00b6
            goto L_0x004d
        L_0x00b6:
            r4 = 3
            goto L_0x00d9
        L_0x00b8:
            java.lang.String r4 = "translationX"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00c1
            goto L_0x004d
        L_0x00c1:
            r4 = 2
            goto L_0x00d9
        L_0x00c3:
            java.lang.String r4 = "rotationY"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00cc
            goto L_0x004d
        L_0x00cc:
            r4 = 1
            goto L_0x00d9
        L_0x00ce:
            java.lang.String r4 = "rotationX"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00d8
            goto L_0x004d
        L_0x00d8:
            r4 = 0
        L_0x00d9:
            switch(r4) {
                case 0: goto L_0x0193;
                case 1: goto L_0x0185;
                case 2: goto L_0x0178;
                case 3: goto L_0x016b;
                case 4: goto L_0x015e;
                case 5: goto L_0x0151;
                case 6: goto L_0x0144;
                case 7: goto L_0x0137;
                case 8: goto L_0x012a;
                case 9: goto L_0x011d;
                case 10: goto L_0x0110;
                case 11: goto L_0x00f9;
                default: goto L_0x00dc;
            }
        L_0x00dc:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "UNKNOWN addValues \""
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = "\""
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "KeyTimeCycles"
            android.util.Log.e(r2, r1)
            goto L_0x0008
        L_0x00f9:
            float r1 = r10.f1891i
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f1803b
            float r5 = r10.f1891i
        L_0x0105:
            float r6 = r10.f1904v
            int r7 = r10.f1903u
            float r8 = r10.f1905w
            r3.a(r4, r5, r6, r7, r8)
            goto L_0x0008
        L_0x0110:
            float r1 = r10.f1896n
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f1803b
            float r5 = r10.f1896n
            goto L_0x0105
        L_0x011d:
            float r1 = r10.f1892j
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f1803b
            float r5 = r10.f1892j
            goto L_0x0105
        L_0x012a:
            float r1 = r10.f1893k
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f1803b
            float r5 = r10.f1893k
            goto L_0x0105
        L_0x0137:
            float r1 = r10.f1898p
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f1803b
            float r5 = r10.f1898p
            goto L_0x0105
        L_0x0144:
            float r1 = r10.f1897o
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f1803b
            float r5 = r10.f1897o
            goto L_0x0105
        L_0x0151:
            float r1 = r10.f1902t
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f1803b
            float r5 = r10.f1902t
            goto L_0x0105
        L_0x015e:
            float r1 = r10.f1901s
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f1803b
            float r5 = r10.f1901s
            goto L_0x0105
        L_0x016b:
            float r1 = r10.f1900r
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f1803b
            float r5 = r10.f1900r
            goto L_0x0105
        L_0x0178:
            float r1 = r10.f1899q
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f1803b
            float r5 = r10.f1899q
            goto L_0x0105
        L_0x0185:
            float r1 = r10.f1895m
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f1803b
            float r5 = r10.f1895m
            goto L_0x0105
        L_0x0193:
            float r1 = r10.f1894l
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r4 = r10.f1803b
            float r5 = r10.f1894l
            goto L_0x0105
        L_0x01a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.k.c(java.util.HashMap):void");
    }
}
