package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.R;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

public class l extends c {

    /* renamed from: g  reason: collision with root package name */
    float f1907g = 0.1f;

    /* renamed from: h  reason: collision with root package name */
    RectF f1908h = new RectF();

    /* renamed from: i  reason: collision with root package name */
    RectF f1909i = new RectF();

    /* renamed from: j  reason: collision with root package name */
    private int f1910j = -1;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public String f1911k = null;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public int f1912l = f1802a;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public String f1913m = null;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public String f1914n = null;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public int f1915o = f1802a;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public int f1916p = f1802a;

    /* renamed from: q  reason: collision with root package name */
    private View f1917q = null;

    /* renamed from: r  reason: collision with root package name */
    private boolean f1918r = true;

    /* renamed from: s  reason: collision with root package name */
    private boolean f1919s = true;

    /* renamed from: t  reason: collision with root package name */
    private boolean f1920t = true;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public float f1921u = Float.NaN;

    /* renamed from: v  reason: collision with root package name */
    private Method f1922v;

    /* renamed from: w  reason: collision with root package name */
    private Method f1923w;

    /* renamed from: x  reason: collision with root package name */
    private Method f1924x;

    /* renamed from: y  reason: collision with root package name */
    private float f1925y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public boolean f1926z = false;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f1927a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f1927a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyTrigger_framePosition, 8);
            f1927a.append(R.styleable.KeyTrigger_onCross, 4);
            f1927a.append(R.styleable.KeyTrigger_onNegativeCross, 1);
            f1927a.append(R.styleable.KeyTrigger_onPositiveCross, 2);
            f1927a.append(R.styleable.KeyTrigger_motionTarget, 7);
            f1927a.append(R.styleable.KeyTrigger_triggerId, 6);
            f1927a.append(R.styleable.KeyTrigger_triggerSlack, 5);
            f1927a.append(R.styleable.KeyTrigger_motion_triggerOnCollision, 9);
            f1927a.append(R.styleable.KeyTrigger_motion_postLayoutCollision, 10);
            f1927a.append(R.styleable.KeyTrigger_triggerReceiver, 11);
        }

        public static void a(l lVar, TypedArray typedArray, Context context) {
            int indexCount = typedArray.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArray.getIndex(i2);
                switch (f1927a.get(index)) {
                    case 1:
                        String unused = lVar.f1913m = typedArray.getString(index);
                        continue;
                    case 2:
                        String unused2 = lVar.f1914n = typedArray.getString(index);
                        continue;
                    case 4:
                        String unused3 = lVar.f1911k = typedArray.getString(index);
                        continue;
                    case 5:
                        lVar.f1907g = typedArray.getFloat(index, lVar.f1907g);
                        continue;
                    case 6:
                        int unused4 = lVar.f1915o = typedArray.getResourceId(index, lVar.f1915o);
                        continue;
                    case 7:
                        if (!MotionLayout.f1692a) {
                            if (typedArray.peekValue(index).type != 3) {
                                lVar.f1804c = typedArray.getResourceId(index, lVar.f1804c);
                                break;
                            }
                        } else {
                            lVar.f1804c = typedArray.getResourceId(index, lVar.f1804c);
                            if (lVar.f1804c != -1) {
                                continue;
                            }
                        }
                        lVar.f1805d = typedArray.getString(index);
                        break;
                    case 8:
                        lVar.f1803b = typedArray.getInteger(index, lVar.f1803b);
                        float unused5 = lVar.f1921u = (((float) lVar.f1803b) + 0.5f) / 100.0f;
                        continue;
                    case 9:
                        int unused6 = lVar.f1916p = typedArray.getResourceId(index, lVar.f1916p);
                        continue;
                    case 10:
                        boolean unused7 = lVar.f1926z = typedArray.getBoolean(index, lVar.f1926z);
                        continue;
                    case 11:
                        int unused8 = lVar.f1912l = typedArray.getResourceId(index, lVar.f1912l);
                        break;
                }
                Log.e("KeyTrigger", "unused attribute 0x" + Integer.toHexString(index) + "   " + f1927a.get(index));
            }
        }
    }

    public l() {
        this.f1806e = 5;
        this.f1807f = new HashMap();
    }

    private void a(RectF rectF, View view, boolean z2) {
        rectF.top = (float) view.getTop();
        rectF.bottom = (float) view.getBottom();
        rectF.left = (float) view.getLeft();
        rectF.right = (float) view.getRight();
        if (z2) {
            view.getMatrix().mapRect(rectF);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b7  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x011a A[SYNTHETIC, Splitter:B:73:0x011a] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0193 A[SYNTHETIC, Splitter:B:86:0x0193] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0208  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(float r11, android.view.View r12) {
        /*
            r10 = this;
            int r0 = r10.f1916p
            int r1 = f1802a
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L_0x0062
            android.view.View r0 = r10.f1917q
            if (r0 != 0) goto L_0x001a
            android.view.ViewParent r0 = r12.getParent()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            int r1 = r10.f1916p
            android.view.View r0 = r0.findViewById(r1)
            r10.f1917q = r0
        L_0x001a:
            android.graphics.RectF r0 = r10.f1908h
            android.view.View r1 = r10.f1917q
            boolean r4 = r10.f1926z
            r10.a(r0, r1, r4)
            android.graphics.RectF r0 = r10.f1909i
            boolean r1 = r10.f1926z
            r10.a(r0, r12, r1)
            android.graphics.RectF r0 = r10.f1908h
            android.graphics.RectF r1 = r10.f1909i
            boolean r0 = r0.intersect(r1)
            if (r0 == 0) goto L_0x004c
            boolean r0 = r10.f1918r
            if (r0 == 0) goto L_0x003c
            r10.f1918r = r3
            r0 = 1
            goto L_0x003d
        L_0x003c:
            r0 = 0
        L_0x003d:
            boolean r1 = r10.f1920t
            if (r1 == 0) goto L_0x0045
            r10.f1920t = r3
            r1 = 1
            goto L_0x0046
        L_0x0045:
            r1 = 0
        L_0x0046:
            r10.f1919s = r2
            r2 = r1
            r1 = 0
            goto L_0x00e0
        L_0x004c:
            boolean r0 = r10.f1918r
            if (r0 != 0) goto L_0x0054
            r10.f1918r = r2
            r0 = 1
            goto L_0x0055
        L_0x0054:
            r0 = 0
        L_0x0055:
            boolean r1 = r10.f1919s
            if (r1 == 0) goto L_0x005d
            r10.f1919s = r3
            r1 = 1
            goto L_0x005e
        L_0x005d:
            r1 = 0
        L_0x005e:
            r10.f1920t = r2
            goto L_0x00df
        L_0x0062:
            boolean r0 = r10.f1918r
            r1 = 0
            if (r0 == 0) goto L_0x0078
            float r0 = r10.f1921u
            float r4 = r11 - r0
            float r5 = r10.f1925y
            float r5 = r5 - r0
            float r4 = r4 * r5
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0088
            r10.f1918r = r3
            r0 = 1
            goto L_0x0089
        L_0x0078:
            float r0 = r10.f1921u
            float r0 = r11 - r0
            float r0 = java.lang.Math.abs(r0)
            float r4 = r10.f1907g
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0088
            r10.f1918r = r2
        L_0x0088:
            r0 = 0
        L_0x0089:
            boolean r4 = r10.f1919s
            if (r4 == 0) goto L_0x00a2
            float r4 = r10.f1921u
            float r5 = r11 - r4
            float r6 = r10.f1925y
            float r6 = r6 - r4
            float r6 = r6 * r5
            int r4 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x00b2
            int r4 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x00b2
            r10.f1919s = r3
            r4 = 1
            goto L_0x00b3
        L_0x00a2:
            float r4 = r10.f1921u
            float r4 = r11 - r4
            float r4 = java.lang.Math.abs(r4)
            float r5 = r10.f1907g
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x00b2
            r10.f1919s = r2
        L_0x00b2:
            r4 = 0
        L_0x00b3:
            boolean r5 = r10.f1920t
            if (r5 == 0) goto L_0x00ce
            float r5 = r10.f1921u
            float r6 = r11 - r5
            float r7 = r10.f1925y
            float r7 = r7 - r5
            float r7 = r7 * r6
            int r5 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r5 >= 0) goto L_0x00cb
            int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x00cb
            r10.f1920t = r3
            goto L_0x00cc
        L_0x00cb:
            r2 = 0
        L_0x00cc:
            r1 = r4
            goto L_0x00e0
        L_0x00ce:
            float r1 = r10.f1921u
            float r1 = r11 - r1
            float r1 = java.lang.Math.abs(r1)
            float r5 = r10.f1907g
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x00de
            r10.f1920t = r2
        L_0x00de:
            r1 = r4
        L_0x00df:
            r2 = 0
        L_0x00e0:
            r10.f1925y = r11
            if (r1 != 0) goto L_0x00e8
            if (r0 != 0) goto L_0x00e8
            if (r2 == 0) goto L_0x00f3
        L_0x00e8:
            android.view.ViewParent r4 = r12.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r4 = (androidx.constraintlayout.motion.widget.MotionLayout) r4
            int r5 = r10.f1915o
            r4.a((int) r5, (boolean) r2, (float) r11)
        L_0x00f3:
            int r11 = r10.f1912l
            int r4 = f1802a
            if (r11 != r4) goto L_0x00fa
            goto L_0x0106
        L_0x00fa:
            android.view.ViewParent r11 = r12.getParent()
            androidx.constraintlayout.motion.widget.MotionLayout r11 = (androidx.constraintlayout.motion.widget.MotionLayout) r11
            int r12 = r10.f1912l
            android.view.View r12 = r11.findViewById(r12)
        L_0x0106:
            java.lang.String r11 = "Could not find method \""
            java.lang.String r4 = "Exception in call \""
            java.lang.String r5 = " "
            java.lang.String r6 = "\"on class "
            java.lang.String r7 = "KeyTrigger"
            if (r1 == 0) goto L_0x0189
            java.lang.String r1 = r10.f1913m
            if (r1 == 0) goto L_0x0189
            java.lang.reflect.Method r1 = r10.f1923w
            if (r1 != 0) goto L_0x0155
            java.lang.Class r1 = r12.getClass()     // Catch:{ NoSuchMethodException -> 0x0129 }
            java.lang.String r8 = r10.f1913m     // Catch:{ NoSuchMethodException -> 0x0129 }
            java.lang.Class[] r9 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x0129 }
            java.lang.reflect.Method r1 = r1.getMethod(r8, r9)     // Catch:{ NoSuchMethodException -> 0x0129 }
            r10.f1923w = r1     // Catch:{ NoSuchMethodException -> 0x0129 }
            goto L_0x0155
        L_0x0129:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r11)
            java.lang.String r8 = r10.f1913m
            r1.append(r8)
            r1.append(r6)
            java.lang.Class r8 = r12.getClass()
            java.lang.String r8 = r8.getSimpleName()
            r1.append(r8)
            r1.append(r5)
            java.lang.String r8 = androidx.constraintlayout.motion.widget.a.a(r12)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r7, r1)
        L_0x0155:
            java.lang.reflect.Method r1 = r10.f1923w     // Catch:{ Exception -> 0x015d }
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x015d }
            r1.invoke(r12, r8)     // Catch:{ Exception -> 0x015d }
            goto L_0x0189
        L_0x015d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r8 = r10.f1913m
            r1.append(r8)
            r1.append(r6)
            java.lang.Class r8 = r12.getClass()
            java.lang.String r8 = r8.getSimpleName()
            r1.append(r8)
            r1.append(r5)
            java.lang.String r8 = androidx.constraintlayout.motion.widget.a.a(r12)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r7, r1)
        L_0x0189:
            if (r2 == 0) goto L_0x0202
            java.lang.String r1 = r10.f1914n
            if (r1 == 0) goto L_0x0202
            java.lang.reflect.Method r1 = r10.f1924x
            if (r1 != 0) goto L_0x01ce
            java.lang.Class r1 = r12.getClass()     // Catch:{ NoSuchMethodException -> 0x01a2 }
            java.lang.String r2 = r10.f1914n     // Catch:{ NoSuchMethodException -> 0x01a2 }
            java.lang.Class[] r8 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x01a2 }
            java.lang.reflect.Method r1 = r1.getMethod(r2, r8)     // Catch:{ NoSuchMethodException -> 0x01a2 }
            r10.f1924x = r1     // Catch:{ NoSuchMethodException -> 0x01a2 }
            goto L_0x01ce
        L_0x01a2:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r11)
            java.lang.String r2 = r10.f1914n
            r1.append(r2)
            r1.append(r6)
            java.lang.Class r2 = r12.getClass()
            java.lang.String r2 = r2.getSimpleName()
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = androidx.constraintlayout.motion.widget.a.a(r12)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r7, r1)
        L_0x01ce:
            java.lang.reflect.Method r1 = r10.f1924x     // Catch:{ Exception -> 0x01d6 }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01d6 }
            r1.invoke(r12, r2)     // Catch:{ Exception -> 0x01d6 }
            goto L_0x0202
        L_0x01d6:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            java.lang.String r2 = r10.f1914n
            r1.append(r2)
            r1.append(r6)
            java.lang.Class r2 = r12.getClass()
            java.lang.String r2 = r2.getSimpleName()
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = androidx.constraintlayout.motion.widget.a.a(r12)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r7, r1)
        L_0x0202:
            if (r0 == 0) goto L_0x027b
            java.lang.String r0 = r10.f1911k
            if (r0 == 0) goto L_0x027b
            java.lang.reflect.Method r0 = r10.f1922v
            if (r0 != 0) goto L_0x0247
            java.lang.Class r0 = r12.getClass()     // Catch:{ NoSuchMethodException -> 0x021b }
            java.lang.String r1 = r10.f1911k     // Catch:{ NoSuchMethodException -> 0x021b }
            java.lang.Class[] r2 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x021b }
            java.lang.reflect.Method r0 = r0.getMethod(r1, r2)     // Catch:{ NoSuchMethodException -> 0x021b }
            r10.f1922v = r0     // Catch:{ NoSuchMethodException -> 0x021b }
            goto L_0x0247
        L_0x021b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            java.lang.String r11 = r10.f1911k
            r0.append(r11)
            r0.append(r6)
            java.lang.Class r11 = r12.getClass()
            java.lang.String r11 = r11.getSimpleName()
            r0.append(r11)
            r0.append(r5)
            java.lang.String r11 = androidx.constraintlayout.motion.widget.a.a(r12)
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            android.util.Log.e(r7, r11)
        L_0x0247:
            java.lang.reflect.Method r11 = r10.f1922v     // Catch:{ Exception -> 0x024f }
            java.lang.Object[] r0 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x024f }
            r11.invoke(r12, r0)     // Catch:{ Exception -> 0x024f }
            goto L_0x027b
        L_0x024f:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r4)
            java.lang.String r0 = r10.f1911k
            r11.append(r0)
            r11.append(r6)
            java.lang.Class r0 = r12.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r11.append(r0)
            r11.append(r5)
            java.lang.String r12 = androidx.constraintlayout.motion.widget.a.a(r12)
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            android.util.Log.e(r7, r11)
        L_0x027b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.l.a(float, android.view.View):void");
    }

    public void a(Context context, AttributeSet attributeSet) {
        a.a(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyTrigger), context);
    }

    public void a(HashMap<String, r> hashMap) {
    }

    public void a(HashSet<String> hashSet) {
    }
}
