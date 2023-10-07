package l;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f30651a = new ThreadLocal<>();

    private static int a(int i2, float f2) {
        return (i2 & 16777215) | (Math.round(((float) Color.alpha(i2)) * f2) << 24);
    }

    public static ColorStateList a(Resources resources, int i2, Resources.Theme theme) {
        try {
            return a(resources, (XmlPullParser) resources.getXml(i2), theme);
        } catch (Exception e2) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e2);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0011  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.res.ColorStateList a(android.content.res.Resources r4, org.xmlpull.v1.XmlPullParser r5, android.content.res.Resources.Theme r6) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r5)
        L_0x0004:
            int r1 = r5.next()
            r2 = 2
            if (r1 == r2) goto L_0x000f
            r3 = 1
            if (r1 == r3) goto L_0x000f
            goto L_0x0004
        L_0x000f:
            if (r1 != r2) goto L_0x0016
            android.content.res.ColorStateList r4 = a((android.content.res.Resources) r4, (org.xmlpull.v1.XmlPullParser) r5, (android.util.AttributeSet) r0, (android.content.res.Resources.Theme) r6)
            return r4
        L_0x0016:
            org.xmlpull.v1.XmlPullParserException r4 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r5 = "No start tag found"
            r4.<init>(r5)
            goto L_0x001f
        L_0x001e:
            throw r4
        L_0x001f:
            goto L_0x001e
        */
        throw new UnsupportedOperationException("Method not decompiled: l.a.a(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }

    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return b(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    private static TypedArray a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private static TypedValue a() {
        ThreadLocal<TypedValue> threadLocal = f30651a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    private static boolean a(Resources resources, int i2) {
        TypedValue a2 = a();
        resources.getValue(i2, a2, true);
        return a2.type >= 28 && a2.type <= 31;
    }

    /* JADX WARNING: type inference failed for: r4v4, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList b(android.content.res.Resources r17, org.xmlpull.v1.XmlPullParser r18, android.util.AttributeSet r19, android.content.res.Resources.Theme r20) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r0 = r17
            r1 = r19
            r2 = r20
            int r3 = r18.getDepth()
            r4 = 1
            int r3 = r3 + r4
            r5 = 20
            int[][] r6 = new int[r5][]
            int[] r5 = new int[r5]
            r7 = 0
            r8 = 0
        L_0x0014:
            int r9 = r18.next()
            if (r9 == r4) goto L_0x00c5
            int r10 = r18.getDepth()
            if (r10 >= r3) goto L_0x0023
            r11 = 3
            if (r9 == r11) goto L_0x00c5
        L_0x0023:
            r11 = 2
            if (r9 != r11) goto L_0x00c2
            if (r10 > r3) goto L_0x00c2
            java.lang.String r9 = r18.getName()
            java.lang.String r10 = "item"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x0036
            goto L_0x00c2
        L_0x0036:
            int[] r9 = androidx.core.R.styleable.ColorStateListItem
            android.content.res.TypedArray r9 = a((android.content.res.Resources) r0, (android.content.res.Resources.Theme) r2, (android.util.AttributeSet) r1, (int[]) r9)
            int r10 = androidx.core.R.styleable.ColorStateListItem_android_color
            r11 = -1
            int r10 = r9.getResourceId(r10, r11)
            r12 = -65281(0xffffffffffff00ff, float:NaN)
            if (r10 == r11) goto L_0x005b
            boolean r11 = a((android.content.res.Resources) r0, (int) r10)
            if (r11 != 0) goto L_0x005b
            android.content.res.XmlResourceParser r10 = r0.getXml(r10)     // Catch:{ Exception -> 0x005b }
            android.content.res.ColorStateList r10 = a((android.content.res.Resources) r0, (org.xmlpull.v1.XmlPullParser) r10, (android.content.res.Resources.Theme) r2)     // Catch:{ Exception -> 0x005b }
            int r10 = r10.getDefaultColor()     // Catch:{ Exception -> 0x005b }
            goto L_0x0061
        L_0x005b:
            int r10 = androidx.core.R.styleable.ColorStateListItem_android_color
            int r10 = r9.getColor(r10, r12)
        L_0x0061:
            r11 = 1065353216(0x3f800000, float:1.0)
            int r12 = androidx.core.R.styleable.ColorStateListItem_android_alpha
            boolean r12 = r9.hasValue(r12)
            if (r12 == 0) goto L_0x0072
            int r12 = androidx.core.R.styleable.ColorStateListItem_android_alpha
        L_0x006d:
            float r11 = r9.getFloat(r12, r11)
            goto L_0x007d
        L_0x0072:
            int r12 = androidx.core.R.styleable.ColorStateListItem_alpha
            boolean r12 = r9.hasValue(r12)
            if (r12 == 0) goto L_0x007d
            int r12 = androidx.core.R.styleable.ColorStateListItem_alpha
            goto L_0x006d
        L_0x007d:
            r9.recycle()
            int r9 = r19.getAttributeCount()
            int[] r12 = new int[r9]
            r13 = 0
            r14 = 0
        L_0x0088:
            if (r13 >= r9) goto L_0x00ad
            int r15 = r1.getAttributeNameResource(r13)
            r4 = 16843173(0x10101a5, float:2.3694738E-38)
            if (r15 == r4) goto L_0x00a9
            r4 = 16843551(0x101031f, float:2.3695797E-38)
            if (r15 == r4) goto L_0x00a9
            int r4 = androidx.core.R.attr.alpha
            if (r15 == r4) goto L_0x00a9
            int r4 = r14 + 1
            boolean r16 = r1.getAttributeBooleanValue(r13, r7)
            if (r16 == 0) goto L_0x00a5
            goto L_0x00a6
        L_0x00a5:
            int r15 = -r15
        L_0x00a6:
            r12[r14] = r15
            r14 = r4
        L_0x00a9:
            int r13 = r13 + 1
            r4 = 1
            goto L_0x0088
        L_0x00ad:
            int[] r4 = android.util.StateSet.trimStateSet(r12, r14)
            int r9 = a((int) r10, (float) r11)
            int[] r5 = l.e.a((int[]) r5, (int) r8, (int) r9)
            java.lang.Object[] r4 = l.e.a((T[]) r6, (int) r8, r4)
            r6 = r4
            int[][] r6 = (int[][]) r6
            int r8 = r8 + 1
        L_0x00c2:
            r4 = 1
            goto L_0x0014
        L_0x00c5:
            int[] r0 = new int[r8]
            int[][] r1 = new int[r8][]
            java.lang.System.arraycopy(r5, r7, r0, r7, r8)
            java.lang.System.arraycopy(r6, r7, r1, r7, r8)
            android.content.res.ColorStateList r2 = new android.content.res.ColorStateList
            r2.<init>(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: l.a.b(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }
}
