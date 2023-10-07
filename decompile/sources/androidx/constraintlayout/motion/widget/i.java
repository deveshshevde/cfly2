package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import k.c;

public class i extends j {

    /* renamed from: g  reason: collision with root package name */
    String f1875g = null;

    /* renamed from: h  reason: collision with root package name */
    int f1876h = f1802a;

    /* renamed from: i  reason: collision with root package name */
    int f1877i = 0;

    /* renamed from: j  reason: collision with root package name */
    float f1878j = Float.NaN;

    /* renamed from: k  reason: collision with root package name */
    float f1879k = Float.NaN;

    /* renamed from: l  reason: collision with root package name */
    float f1880l = Float.NaN;

    /* renamed from: m  reason: collision with root package name */
    float f1881m = Float.NaN;

    /* renamed from: n  reason: collision with root package name */
    float f1882n = Float.NaN;

    /* renamed from: o  reason: collision with root package name */
    float f1883o = Float.NaN;

    /* renamed from: p  reason: collision with root package name */
    int f1884p = 0;

    /* renamed from: r  reason: collision with root package name */
    private float f1885r = Float.NaN;

    /* renamed from: s  reason: collision with root package name */
    private float f1886s = Float.NaN;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f1887a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1887a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyPosition_motionTarget, 1);
            f1887a.append(R.styleable.KeyPosition_framePosition, 2);
            f1887a.append(R.styleable.KeyPosition_transitionEasing, 3);
            f1887a.append(R.styleable.KeyPosition_curveFit, 4);
            f1887a.append(R.styleable.KeyPosition_drawPath, 5);
            f1887a.append(R.styleable.KeyPosition_percentX, 6);
            f1887a.append(R.styleable.KeyPosition_percentY, 7);
            f1887a.append(R.styleable.KeyPosition_keyPositionType, 9);
            f1887a.append(R.styleable.KeyPosition_sizePercent, 8);
            f1887a.append(R.styleable.KeyPosition_percentWidth, 11);
            f1887a.append(R.styleable.KeyPosition_percentHeight, 12);
            f1887a.append(R.styleable.KeyPosition_pathMotionArc, 10);
        }

        /* access modifiers changed from: private */
        public static void b(i iVar, TypedArray typedArray) {
            float f2;
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                switch (f1887a.get(index)) {
                    case 1:
                        if (MotionLayout.f1692a) {
                            iVar.f1804c = typedArray.getResourceId(index, iVar.f1804c);
                            if (iVar.f1804c != -1) {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type != 3) {
                            iVar.f1804c = typedArray.getResourceId(index, iVar.f1804c);
                            continue;
                        }
                        iVar.f1805d = typedArray.getString(index);
                        break;
                    case 2:
                        iVar.f1803b = typedArray.getInt(index, iVar.f1803b);
                        continue;
                    case 3:
                        iVar.f1875g = typedArray.peekValue(index).type == 3 ? typedArray.getString(index) : c.f29910c[typedArray.getInteger(index, 0)];
                        continue;
                    case 4:
                        iVar.f1888q = typedArray.getInteger(index, iVar.f1888q);
                        continue;
                    case 5:
                        iVar.f1877i = typedArray.getInt(index, iVar.f1877i);
                        continue;
                    case 6:
                        iVar.f1880l = typedArray.getFloat(index, iVar.f1880l);
                        continue;
                    case 7:
                        iVar.f1881m = typedArray.getFloat(index, iVar.f1881m);
                        continue;
                    case 8:
                        f2 = typedArray.getFloat(index, iVar.f1879k);
                        iVar.f1878j = f2;
                        break;
                    case 9:
                        iVar.f1884p = typedArray.getInt(index, iVar.f1884p);
                        continue;
                    case 10:
                        iVar.f1876h = typedArray.getInt(index, iVar.f1876h);
                        continue;
                    case 11:
                        iVar.f1878j = typedArray.getFloat(index, iVar.f1878j);
                        continue;
                    case 12:
                        f2 = typedArray.getFloat(index, iVar.f1879k);
                        break;
                    default:
                        Log.e("KeyPosition", "unused attribute 0x" + Integer.toHexString(index) + "   " + f1887a.get(index));
                        continue;
                }
                iVar.f1879k = f2;
            }
            if (iVar.f1803b == -1) {
                Log.e("KeyPosition", "no frame position");
            }
        }
    }

    public i() {
        this.f1806e = 2;
    }

    public void a(Context context, AttributeSet attributeSet) {
        a.b(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyPosition));
    }

    public void a(HashMap<String, r> hashMap) {
    }
}
