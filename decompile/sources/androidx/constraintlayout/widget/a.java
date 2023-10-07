package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class a {

    /* renamed from: a  reason: collision with root package name */
    b f2615a;

    /* renamed from: b  reason: collision with root package name */
    int f2616b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f2617c = -1;

    /* renamed from: d  reason: collision with root package name */
    private final ConstraintLayout f2618d;

    /* renamed from: e  reason: collision with root package name */
    private SparseArray<C0023a> f2619e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    private SparseArray<b> f2620f = new SparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    private c f2621g = null;

    /* renamed from: androidx.constraintlayout.widget.a$a  reason: collision with other inner class name */
    static class C0023a {

        /* renamed from: a  reason: collision with root package name */
        int f2622a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<b> f2623b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        int f2624c = -1;

        /* renamed from: d  reason: collision with root package name */
        b f2625d;

        public C0023a(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.State_android_id) {
                    this.f2622a = obtainStyledAttributes.getResourceId(index, this.f2622a);
                } else if (index == R.styleable.State_constraints) {
                    this.f2624c = obtainStyledAttributes.getResourceId(index, this.f2624c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f2624c);
                    context.getResources().getResourceName(this.f2624c);
                    if ("layout".equals(resourceTypeName)) {
                        b bVar = new b();
                        this.f2625d = bVar;
                        bVar.a(context, this.f2624c);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public int a(float f2, float f3) {
            for (int i2 = 0; i2 < this.f2623b.size(); i2++) {
                if (this.f2623b.get(i2).a(f2, f3)) {
                    return i2;
                }
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public void a(b bVar) {
            this.f2623b.add(bVar);
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        float f2626a = Float.NaN;

        /* renamed from: b  reason: collision with root package name */
        float f2627b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        float f2628c = Float.NaN;

        /* renamed from: d  reason: collision with root package name */
        float f2629d = Float.NaN;

        /* renamed from: e  reason: collision with root package name */
        int f2630e = -1;

        /* renamed from: f  reason: collision with root package name */
        b f2631f;

        public b(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.Variant_constraints) {
                    this.f2630e = obtainStyledAttributes.getResourceId(index, this.f2630e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f2630e);
                    context.getResources().getResourceName(this.f2630e);
                    if ("layout".equals(resourceTypeName)) {
                        b bVar = new b();
                        this.f2631f = bVar;
                        bVar.a(context, this.f2630e);
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.f2629d = obtainStyledAttributes.getDimension(index, this.f2629d);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.f2627b = obtainStyledAttributes.getDimension(index, this.f2627b);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.f2628c = obtainStyledAttributes.getDimension(index, this.f2628c);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.f2626a = obtainStyledAttributes.getDimension(index, this.f2626a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public boolean a(float f2, float f3) {
            if (!Float.isNaN(this.f2626a) && f2 < this.f2626a) {
                return false;
            }
            if (!Float.isNaN(this.f2627b) && f3 < this.f2627b) {
                return false;
            }
            if (Float.isNaN(this.f2628c) || f2 <= this.f2628c) {
                return Float.isNaN(this.f2629d) || f3 <= this.f2629d;
            }
            return false;
        }
    }

    a(Context context, ConstraintLayout constraintLayout, int i2) {
        this.f2618d = constraintLayout;
        a(context, i2);
    }

    private void a(Context context, int i2) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        C0023a aVar = null;
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    char c2 = 65535;
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                c2 = 4;
                                break;
                            }
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                c2 = 1;
                                break;
                            }
                            break;
                        case 1657696882:
                            if (name.equals("layoutDescription")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                c2 = 3;
                                break;
                            }
                            break;
                    }
                    if (!(c2 == 0 || c2 == 1)) {
                        if (c2 == 2) {
                            aVar = new C0023a(context, xml);
                            this.f2619e.put(aVar.f2622a, aVar);
                        } else if (c2 == 3) {
                            b bVar = new b(context, xml);
                            if (aVar != null) {
                                aVar.a(bVar);
                            }
                        } else if (c2 != 4) {
                            Log.v("ConstraintLayoutStates", "unknown tag " + name);
                        } else {
                            a(context, (XmlPullParser) xml);
                        }
                    }
                }
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    private void a(Context context, XmlPullParser xmlPullParser) {
        int i2;
        b bVar = new b();
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i3 = 0; i3 < attributeCount; i3++) {
            if ("id".equals(xmlPullParser.getAttributeName(i3))) {
                String attributeValue = xmlPullParser.getAttributeValue(i3);
                if (attributeValue.contains("/")) {
                    i2 = context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName());
                } else {
                    i2 = -1;
                }
                if (i2 == -1) {
                    if (attributeValue == null || attributeValue.length() <= 1) {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    } else {
                        i2 = Integer.parseInt(attributeValue.substring(1));
                    }
                }
                bVar.a(context, xmlPullParser);
                this.f2620f.put(i2, bVar);
                return;
            }
        }
    }

    public void a(int i2, float f2, float f3) {
        int a2;
        int i3 = this.f2616b;
        if (i3 == i2) {
            C0023a aVar = (C0023a) (i2 == -1 ? this.f2619e.valueAt(0) : this.f2619e.get(i3));
            if ((this.f2617c == -1 || !aVar.f2623b.get(this.f2617c).a(f2, f3)) && this.f2617c != (a2 = aVar.a(f2, f3))) {
                b bVar = a2 == -1 ? this.f2615a : aVar.f2623b.get(a2).f2631f;
                int i4 = a2 == -1 ? aVar.f2624c : aVar.f2623b.get(a2).f2630e;
                if (bVar != null) {
                    this.f2617c = a2;
                    c cVar = this.f2621g;
                    if (cVar != null) {
                        cVar.a(-1, i4);
                    }
                    bVar.c(this.f2618d);
                    c cVar2 = this.f2621g;
                    if (cVar2 != null) {
                        cVar2.b(-1, i4);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.f2616b = i2;
        C0023a aVar2 = this.f2619e.get(i2);
        int a3 = aVar2.a(f2, f3);
        b bVar2 = a3 == -1 ? aVar2.f2625d : aVar2.f2623b.get(a3).f2631f;
        int i5 = a3 == -1 ? aVar2.f2624c : aVar2.f2623b.get(a3).f2630e;
        if (bVar2 == null) {
            Log.v("ConstraintLayoutStates", "NO Constraint set found ! id=" + i2 + ", dim =" + f2 + ", " + f3);
            return;
        }
        this.f2617c = a3;
        c cVar3 = this.f2621g;
        if (cVar3 != null) {
            cVar3.a(i2, i5);
        }
        bVar2.c(this.f2618d);
        c cVar4 = this.f2621g;
        if (cVar4 != null) {
            cVar4.b(i2, i5);
        }
    }

    public void a(c cVar) {
        this.f2621g = cVar;
    }
}
