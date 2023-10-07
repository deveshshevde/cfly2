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

public class d extends c {
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f1808g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f1809h = -1;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1810i = false;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public float f1811j = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public float f1812k = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public float f1813l = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public float f1814m = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public float f1815n = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public float f1816o = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public float f1817p = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public float f1818q = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public float f1819r = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public float f1820s = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public float f1821t = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public float f1822u = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public float f1823v = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public float f1824w = Float.NaN;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f1825a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1825a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyAttribute_android_alpha, 1);
            f1825a.append(R.styleable.KeyAttribute_android_elevation, 2);
            f1825a.append(R.styleable.KeyAttribute_android_rotation, 4);
            f1825a.append(R.styleable.KeyAttribute_android_rotationX, 5);
            f1825a.append(R.styleable.KeyAttribute_android_rotationY, 6);
            f1825a.append(R.styleable.KeyAttribute_android_transformPivotX, 19);
            f1825a.append(R.styleable.KeyAttribute_android_transformPivotY, 20);
            f1825a.append(R.styleable.KeyAttribute_android_scaleX, 7);
            f1825a.append(R.styleable.KeyAttribute_transitionPathRotate, 8);
            f1825a.append(R.styleable.KeyAttribute_transitionEasing, 9);
            f1825a.append(R.styleable.KeyAttribute_motionTarget, 10);
            f1825a.append(R.styleable.KeyAttribute_framePosition, 12);
            f1825a.append(R.styleable.KeyAttribute_curveFit, 13);
            f1825a.append(R.styleable.KeyAttribute_android_scaleY, 14);
            f1825a.append(R.styleable.KeyAttribute_android_translationX, 15);
            f1825a.append(R.styleable.KeyAttribute_android_translationY, 16);
            f1825a.append(R.styleable.KeyAttribute_android_translationZ, 17);
            f1825a.append(R.styleable.KeyAttribute_motionProgress, 18);
        }

        public static void a(d dVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                switch (f1825a.get(index)) {
                    case 1:
                        float unused = dVar.f1811j = typedArray.getFloat(index, dVar.f1811j);
                        break;
                    case 2:
                        float unused2 = dVar.f1812k = typedArray.getDimension(index, dVar.f1812k);
                        break;
                    case 4:
                        float unused3 = dVar.f1813l = typedArray.getFloat(index, dVar.f1813l);
                        break;
                    case 5:
                        float unused4 = dVar.f1814m = typedArray.getFloat(index, dVar.f1814m);
                        break;
                    case 6:
                        float unused5 = dVar.f1815n = typedArray.getFloat(index, dVar.f1815n);
                        break;
                    case 7:
                        float unused6 = dVar.f1819r = typedArray.getFloat(index, dVar.f1819r);
                        break;
                    case 8:
                        float unused7 = dVar.f1818q = typedArray.getFloat(index, dVar.f1818q);
                        break;
                    case 9:
                        String unused8 = dVar.f1808g = typedArray.getString(index);
                        break;
                    case 10:
                        if (!MotionLayout.f1692a) {
                            if (typedArray.peekValue(index).type != 3) {
                                dVar.f1804c = typedArray.getResourceId(index, dVar.f1804c);
                                break;
                            }
                        } else {
                            dVar.f1804c = typedArray.getResourceId(index, dVar.f1804c);
                            if (dVar.f1804c != -1) {
                                break;
                            }
                        }
                        dVar.f1805d = typedArray.getString(index);
                        break;
                    case 12:
                        dVar.f1803b = typedArray.getInt(index, dVar.f1803b);
                        break;
                    case 13:
                        int unused9 = dVar.f1809h = typedArray.getInteger(index, dVar.f1809h);
                        break;
                    case 14:
                        float unused10 = dVar.f1820s = typedArray.getFloat(index, dVar.f1820s);
                        break;
                    case 15:
                        float unused11 = dVar.f1821t = typedArray.getDimension(index, dVar.f1821t);
                        break;
                    case 16:
                        float unused12 = dVar.f1822u = typedArray.getDimension(index, dVar.f1822u);
                        break;
                    case 17:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            float unused13 = dVar.f1823v = typedArray.getDimension(index, dVar.f1823v);
                            break;
                        }
                    case 18:
                        float unused14 = dVar.f1824w = typedArray.getFloat(index, dVar.f1824w);
                        break;
                    case 19:
                        float unused15 = dVar.f1816o = typedArray.getDimension(index, dVar.f1816o);
                        break;
                    case 20:
                        float unused16 = dVar.f1817p = typedArray.getDimension(index, dVar.f1817p);
                        break;
                    default:
                        Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(index) + "   " + f1825a.get(index));
                        break;
                }
            }
        }
    }

    public d() {
        this.f1806e = 1;
        this.f1807f = new HashMap();
    }

    public void a(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyAttribute));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009a, code lost:
        if (r1.equals("scaleY") == false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0119, code lost:
        r2.a(r1, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.widget.r> r7) {
        /*
            r6 = this;
            java.util.Set r0 = r7.keySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x0008:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01cb
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r7.get(r1)
            androidx.constraintlayout.motion.widget.r r2 = (androidx.constraintlayout.motion.widget.r) r2
            java.lang.String r3 = "CUSTOM"
            boolean r3 = r1.startsWith(r3)
            r4 = 7
            if (r3 == 0) goto L_0x0039
            java.lang.String r1 = r1.substring(r4)
            java.util.HashMap r3 = r6.f1807f
            java.lang.Object r1 = r3.get(r1)
            androidx.constraintlayout.widget.ConstraintAttribute r1 = (androidx.constraintlayout.widget.ConstraintAttribute) r1
            if (r1 == 0) goto L_0x0008
            androidx.constraintlayout.motion.widget.r$b r2 = (androidx.constraintlayout.motion.widget.r.b) r2
            int r3 = r6.f1803b
            r2.a((int) r3, (androidx.constraintlayout.widget.ConstraintAttribute) r1)
            goto L_0x0008
        L_0x0039:
            r1.hashCode()
            r3 = -1
            int r5 = r1.hashCode()
            switch(r5) {
                case -1249320806: goto L_0x00e2;
                case -1249320805: goto L_0x00d6;
                case -1225497657: goto L_0x00ca;
                case -1225497656: goto L_0x00be;
                case -1225497655: goto L_0x00b3;
                case -1001078227: goto L_0x00a8;
                case -908189618: goto L_0x009d;
                case -908189617: goto L_0x0094;
                case -760884510: goto L_0x0088;
                case -760884509: goto L_0x007b;
                case -40300674: goto L_0x006e;
                case -4379043: goto L_0x0061;
                case 37232917: goto L_0x0054;
                case 92909918: goto L_0x0047;
                default: goto L_0x0044;
            }
        L_0x0044:
            r4 = -1
            goto L_0x00ed
        L_0x0047:
            java.lang.String r4 = "alpha"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0050
            goto L_0x0044
        L_0x0050:
            r4 = 13
            goto L_0x00ed
        L_0x0054:
            java.lang.String r4 = "transitionPathRotate"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x005d
            goto L_0x0044
        L_0x005d:
            r4 = 12
            goto L_0x00ed
        L_0x0061:
            java.lang.String r4 = "elevation"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x006a
            goto L_0x0044
        L_0x006a:
            r4 = 11
            goto L_0x00ed
        L_0x006e:
            java.lang.String r4 = "rotation"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0077
            goto L_0x0044
        L_0x0077:
            r4 = 10
            goto L_0x00ed
        L_0x007b:
            java.lang.String r4 = "transformPivotY"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0084
            goto L_0x0044
        L_0x0084:
            r4 = 9
            goto L_0x00ed
        L_0x0088:
            java.lang.String r4 = "transformPivotX"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x0091
            goto L_0x0044
        L_0x0091:
            r4 = 8
            goto L_0x00ed
        L_0x0094:
            java.lang.String r5 = "scaleY"
            boolean r5 = r1.equals(r5)
            if (r5 != 0) goto L_0x00ed
            goto L_0x0044
        L_0x009d:
            java.lang.String r4 = "scaleX"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00a6
            goto L_0x0044
        L_0x00a6:
            r4 = 6
            goto L_0x00ed
        L_0x00a8:
            java.lang.String r4 = "progress"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00b1
            goto L_0x0044
        L_0x00b1:
            r4 = 5
            goto L_0x00ed
        L_0x00b3:
            java.lang.String r4 = "translationZ"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00bc
            goto L_0x0044
        L_0x00bc:
            r4 = 4
            goto L_0x00ed
        L_0x00be:
            java.lang.String r4 = "translationY"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00c8
            goto L_0x0044
        L_0x00c8:
            r4 = 3
            goto L_0x00ed
        L_0x00ca:
            java.lang.String r4 = "translationX"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00d4
            goto L_0x0044
        L_0x00d4:
            r4 = 2
            goto L_0x00ed
        L_0x00d6:
            java.lang.String r4 = "rotationY"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00e0
            goto L_0x0044
        L_0x00e0:
            r4 = 1
            goto L_0x00ed
        L_0x00e2:
            java.lang.String r4 = "rotationX"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x00ec
            goto L_0x0044
        L_0x00ec:
            r4 = 0
        L_0x00ed:
            switch(r4) {
                case 0: goto L_0x01bd;
                case 1: goto L_0x01af;
                case 2: goto L_0x01a1;
                case 3: goto L_0x0193;
                case 4: goto L_0x0186;
                case 5: goto L_0x0179;
                case 6: goto L_0x016c;
                case 7: goto L_0x015f;
                case 8: goto L_0x0152;
                case 9: goto L_0x0145;
                case 10: goto L_0x0138;
                case 11: goto L_0x012b;
                case 12: goto L_0x011e;
                case 13: goto L_0x010d;
                default: goto L_0x00f0;
            }
        L_0x00f0:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "UNKNOWN addValues \""
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = "\""
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "KeyAttributes"
            android.util.Log.v(r2, r1)
            goto L_0x0008
        L_0x010d:
            float r1 = r6.f1811j
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1803b
            float r3 = r6.f1811j
        L_0x0119:
            r2.a((int) r1, (float) r3)
            goto L_0x0008
        L_0x011e:
            float r1 = r6.f1818q
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1803b
            float r3 = r6.f1818q
            goto L_0x0119
        L_0x012b:
            float r1 = r6.f1812k
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1803b
            float r3 = r6.f1812k
            goto L_0x0119
        L_0x0138:
            float r1 = r6.f1813l
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1803b
            float r3 = r6.f1813l
            goto L_0x0119
        L_0x0145:
            float r1 = r6.f1815n
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1803b
            float r3 = r6.f1817p
            goto L_0x0119
        L_0x0152:
            float r1 = r6.f1814m
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1803b
            float r3 = r6.f1816o
            goto L_0x0119
        L_0x015f:
            float r1 = r6.f1820s
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1803b
            float r3 = r6.f1820s
            goto L_0x0119
        L_0x016c:
            float r1 = r6.f1819r
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1803b
            float r3 = r6.f1819r
            goto L_0x0119
        L_0x0179:
            float r1 = r6.f1824w
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1803b
            float r3 = r6.f1824w
            goto L_0x0119
        L_0x0186:
            float r1 = r6.f1823v
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1803b
            float r3 = r6.f1823v
            goto L_0x0119
        L_0x0193:
            float r1 = r6.f1822u
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1803b
            float r3 = r6.f1822u
            goto L_0x0119
        L_0x01a1:
            float r1 = r6.f1821t
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1803b
            float r3 = r6.f1821t
            goto L_0x0119
        L_0x01af:
            float r1 = r6.f1815n
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1803b
            float r3 = r6.f1815n
            goto L_0x0119
        L_0x01bd:
            float r1 = r6.f1814m
            boolean r1 = java.lang.Float.isNaN(r1)
            if (r1 != 0) goto L_0x0008
            int r1 = r6.f1803b
            float r3 = r6.f1814m
            goto L_0x0119
        L_0x01cb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.d.a(java.util.HashMap):void");
    }

    public void a(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f1811j)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f1812k)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f1813l)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f1814m)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f1815n)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f1816o)) {
            hashSet.add("transformPivotX");
        }
        if (!Float.isNaN(this.f1817p)) {
            hashSet.add("transformPivotY");
        }
        if (!Float.isNaN(this.f1821t)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f1822u)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f1823v)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.f1818q)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f1819r)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f1820s)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f1824w)) {
            hashSet.add("progress");
        }
        if (this.f1807f.size() > 0) {
            for (String str : this.f1807f.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    public void b(HashMap<String, Integer> hashMap) {
        if (this.f1809h != -1) {
            if (!Float.isNaN(this.f1811j)) {
                hashMap.put("alpha", Integer.valueOf(this.f1809h));
            }
            if (!Float.isNaN(this.f1812k)) {
                hashMap.put("elevation", Integer.valueOf(this.f1809h));
            }
            if (!Float.isNaN(this.f1813l)) {
                hashMap.put("rotation", Integer.valueOf(this.f1809h));
            }
            if (!Float.isNaN(this.f1814m)) {
                hashMap.put("rotationX", Integer.valueOf(this.f1809h));
            }
            if (!Float.isNaN(this.f1815n)) {
                hashMap.put("rotationY", Integer.valueOf(this.f1809h));
            }
            if (!Float.isNaN(this.f1816o)) {
                hashMap.put("transformPivotX", Integer.valueOf(this.f1809h));
            }
            if (!Float.isNaN(this.f1817p)) {
                hashMap.put("transformPivotY", Integer.valueOf(this.f1809h));
            }
            if (!Float.isNaN(this.f1821t)) {
                hashMap.put("translationX", Integer.valueOf(this.f1809h));
            }
            if (!Float.isNaN(this.f1822u)) {
                hashMap.put("translationY", Integer.valueOf(this.f1809h));
            }
            if (!Float.isNaN(this.f1823v)) {
                hashMap.put("translationZ", Integer.valueOf(this.f1809h));
            }
            if (!Float.isNaN(this.f1818q)) {
                hashMap.put("transitionPathRotate", Integer.valueOf(this.f1809h));
            }
            if (!Float.isNaN(this.f1819r)) {
                hashMap.put("scaleX", Integer.valueOf(this.f1809h));
            }
            if (!Float.isNaN(this.f1820s)) {
                hashMap.put("scaleY", Integer.valueOf(this.f1809h));
            }
            if (!Float.isNaN(this.f1824w)) {
                hashMap.put("progress", Integer.valueOf(this.f1809h));
            }
            if (this.f1807f.size() > 0) {
                for (String str : this.f1807f.keySet()) {
                    hashMap.put("CUSTOM," + str, Integer.valueOf(this.f1809h));
                }
            }
        }
    }
}
