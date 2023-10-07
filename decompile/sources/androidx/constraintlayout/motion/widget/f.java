package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import java.util.HashSet;

public class f extends c {
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f1827g = null;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public int f1828h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f1829i = -1;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public float f1830j = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public float f1831k = 0.0f;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public float f1832l = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public int f1833m = -1;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public float f1834n = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public float f1835o = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public float f1836p = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public float f1837q = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public float f1838r = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public float f1839s = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public float f1840t = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public float f1841u = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public float f1842v = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public float f1843w = Float.NaN;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public float f1844x = Float.NaN;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f1845a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1845a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyCycle_motionTarget, 1);
            f1845a.append(R.styleable.KeyCycle_framePosition, 2);
            f1845a.append(R.styleable.KeyCycle_transitionEasing, 3);
            f1845a.append(R.styleable.KeyCycle_curveFit, 4);
            f1845a.append(R.styleable.KeyCycle_waveShape, 5);
            f1845a.append(R.styleable.KeyCycle_wavePeriod, 6);
            f1845a.append(R.styleable.KeyCycle_waveOffset, 7);
            f1845a.append(R.styleable.KeyCycle_waveVariesBy, 8);
            f1845a.append(R.styleable.KeyCycle_android_alpha, 9);
            f1845a.append(R.styleable.KeyCycle_android_elevation, 10);
            f1845a.append(R.styleable.KeyCycle_android_rotation, 11);
            f1845a.append(R.styleable.KeyCycle_android_rotationX, 12);
            f1845a.append(R.styleable.KeyCycle_android_rotationY, 13);
            f1845a.append(R.styleable.KeyCycle_transitionPathRotate, 14);
            f1845a.append(R.styleable.KeyCycle_android_scaleX, 15);
            f1845a.append(R.styleable.KeyCycle_android_scaleY, 16);
            f1845a.append(R.styleable.KeyCycle_android_translationX, 17);
            f1845a.append(R.styleable.KeyCycle_android_translationY, 18);
            f1845a.append(R.styleable.KeyCycle_android_translationZ, 19);
            f1845a.append(R.styleable.KeyCycle_motionProgress, 20);
        }

        /* access modifiers changed from: private */
        public static void b(f fVar, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                switch (f1845a.get(index)) {
                    case 1:
                        if (!MotionLayout.f1692a) {
                            if (typedArray.peekValue(index).type != 3) {
                                fVar.f1804c = typedArray.getResourceId(index, fVar.f1804c);
                                break;
                            }
                        } else {
                            fVar.f1804c = typedArray.getResourceId(index, fVar.f1804c);
                            if (fVar.f1804c != -1) {
                                break;
                            }
                        }
                        fVar.f1805d = typedArray.getString(index);
                        break;
                    case 2:
                        fVar.f1803b = typedArray.getInt(index, fVar.f1803b);
                        break;
                    case 3:
                        String unused = fVar.f1827g = typedArray.getString(index);
                        break;
                    case 4:
                        int unused2 = fVar.f1828h = typedArray.getInteger(index, fVar.f1828h);
                        break;
                    case 5:
                        int unused3 = fVar.f1829i = typedArray.getInt(index, fVar.f1829i);
                        break;
                    case 6:
                        float unused4 = fVar.f1830j = typedArray.getFloat(index, fVar.f1830j);
                        break;
                    case 7:
                        float unused5 = fVar.f1831k = typedArray.peekValue(index).type == 5 ? typedArray.getDimension(index, fVar.f1831k) : typedArray.getFloat(index, fVar.f1831k);
                        break;
                    case 8:
                        int unused6 = fVar.f1833m = typedArray.getInt(index, fVar.f1833m);
                        break;
                    case 9:
                        float unused7 = fVar.f1834n = typedArray.getFloat(index, fVar.f1834n);
                        break;
                    case 10:
                        float unused8 = fVar.f1835o = typedArray.getDimension(index, fVar.f1835o);
                        break;
                    case 11:
                        float unused9 = fVar.f1836p = typedArray.getFloat(index, fVar.f1836p);
                        break;
                    case 12:
                        float unused10 = fVar.f1838r = typedArray.getFloat(index, fVar.f1838r);
                        break;
                    case 13:
                        float unused11 = fVar.f1839s = typedArray.getFloat(index, fVar.f1839s);
                        break;
                    case 14:
                        float unused12 = fVar.f1837q = typedArray.getFloat(index, fVar.f1837q);
                        break;
                    case 15:
                        float unused13 = fVar.f1840t = typedArray.getFloat(index, fVar.f1840t);
                        break;
                    case 16:
                        float unused14 = fVar.f1841u = typedArray.getFloat(index, fVar.f1841u);
                        break;
                    case 17:
                        float unused15 = fVar.f1842v = typedArray.getDimension(index, fVar.f1842v);
                        break;
                    case 18:
                        float unused16 = fVar.f1843w = typedArray.getDimension(index, fVar.f1843w);
                        break;
                    case 19:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            float unused17 = fVar.f1844x = typedArray.getDimension(index, fVar.f1844x);
                            break;
                        }
                    case 20:
                        float unused18 = fVar.f1832l = typedArray.getFloat(index, fVar.f1832l);
                        break;
                    default:
                        Log.e("KeyCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + f1845a.get(index));
                        break;
                }
            }
        }
    }

    public f() {
        this.f1806e = 4;
        this.f1807f = new HashMap();
    }

    public void a(Context context, AttributeSet attributeSet) {
        a.b(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyCycle));
    }

    public void a(HashMap<String, r> hashMap) {
        int i2;
        float f2;
        a.a("KeyCycle", "add " + hashMap.size() + " values", 2);
        for (String next : hashMap.keySet()) {
            r rVar = hashMap.get(next);
            next.hashCode();
            char c2 = 65535;
            switch (next.hashCode()) {
                case -1249320806:
                    if (next.equals("rotationX")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case -1249320805:
                    if (next.equals("rotationY")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case -1225497657:
                    if (next.equals("translationX")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case -1225497656:
                    if (next.equals("translationY")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case -1225497655:
                    if (next.equals("translationZ")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case -1001078227:
                    if (next.equals("progress")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case -908189618:
                    if (next.equals("scaleX")) {
                        c2 = 6;
                        break;
                    }
                    break;
                case -908189617:
                    if (next.equals("scaleY")) {
                        c2 = 7;
                        break;
                    }
                    break;
                case -40300674:
                    if (next.equals("rotation")) {
                        c2 = 8;
                        break;
                    }
                    break;
                case -4379043:
                    if (next.equals("elevation")) {
                        c2 = 9;
                        break;
                    }
                    break;
                case 37232917:
                    if (next.equals("transitionPathRotate")) {
                        c2 = 10;
                        break;
                    }
                    break;
                case 92909918:
                    if (next.equals("alpha")) {
                        c2 = 11;
                        break;
                    }
                    break;
                case 156108012:
                    if (next.equals("waveOffset")) {
                        c2 = 12;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    i2 = this.f1803b;
                    f2 = this.f1838r;
                    break;
                case 1:
                    i2 = this.f1803b;
                    f2 = this.f1839s;
                    break;
                case 2:
                    i2 = this.f1803b;
                    f2 = this.f1842v;
                    break;
                case 3:
                    i2 = this.f1803b;
                    f2 = this.f1843w;
                    break;
                case 4:
                    i2 = this.f1803b;
                    f2 = this.f1844x;
                    break;
                case 5:
                    i2 = this.f1803b;
                    f2 = this.f1832l;
                    break;
                case 6:
                    i2 = this.f1803b;
                    f2 = this.f1840t;
                    break;
                case 7:
                    i2 = this.f1803b;
                    f2 = this.f1841u;
                    break;
                case 8:
                    i2 = this.f1803b;
                    f2 = this.f1836p;
                    break;
                case 9:
                    i2 = this.f1803b;
                    f2 = this.f1835o;
                    break;
                case 10:
                    i2 = this.f1803b;
                    f2 = this.f1837q;
                    break;
                case 11:
                    i2 = this.f1803b;
                    f2 = this.f1834n;
                    break;
                case 12:
                    i2 = this.f1803b;
                    f2 = this.f1831k;
                    break;
                default:
                    Log.v("KeyCycle", "WARNING KeyCycle UNKNOWN  " + next);
                    continue;
            }
            rVar.a(i2, f2);
        }
    }

    public void a(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f1834n)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f1835o)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.f1836p)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.f1838r)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.f1839s)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.f1840t)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.f1841u)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.f1837q)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.f1842v)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.f1843w)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.f1844x)) {
            hashSet.add("translationZ");
        }
        if (this.f1807f.size() > 0) {
            for (String str : this.f1807f.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    public float b(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    c2 = 4;
                    break;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c2 = 5;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c2 = 6;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c2 = 7;
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c2 = 8;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c2 = 9;
                    break;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    c2 = 10;
                    break;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    c2 = 11;
                    break;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c2 = 12;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return this.f1838r;
            case 1:
                return this.f1839s;
            case 2:
                return this.f1842v;
            case 3:
                return this.f1843w;
            case 4:
                return this.f1844x;
            case 5:
                return this.f1832l;
            case 6:
                return this.f1840t;
            case 7:
                return this.f1841u;
            case 8:
                return this.f1836p;
            case 9:
                return this.f1835o;
            case 10:
                return this.f1837q;
            case 11:
                return this.f1834n;
            case 12:
                return this.f1831k;
            default:
                Log.v("KeyCycle", "WARNING! KeyCycle UNKNOWN  " + str);
                return Float.NaN;
        }
    }

    public void c(HashMap<String, g> hashMap) {
        HashMap<String, g> hashMap2 = hashMap;
        for (String next : hashMap.keySet()) {
            if (next.startsWith("CUSTOM")) {
                ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.f1807f.get(next.substring(7));
                if (constraintAttribute != null && constraintAttribute.a() == ConstraintAttribute.AttributeType.FLOAT_TYPE) {
                    hashMap2.get(next).a(this.f1803b, this.f1829i, this.f1833m, this.f1830j, this.f1831k, constraintAttribute.c(), constraintAttribute);
                }
            } else {
                float b2 = b(next);
                if (!Float.isNaN(b2)) {
                    hashMap2.get(next).a(this.f1803b, this.f1829i, this.f1833m, this.f1830j, this.f1831k, b2);
                }
            }
        }
    }
}
