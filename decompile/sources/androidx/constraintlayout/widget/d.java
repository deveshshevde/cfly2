package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class d {

    /* renamed from: a  reason: collision with root package name */
    int f2708a = -1;

    /* renamed from: b  reason: collision with root package name */
    int f2709b = -1;

    /* renamed from: c  reason: collision with root package name */
    int f2710c = -1;

    /* renamed from: d  reason: collision with root package name */
    private SparseArray<a> f2711d = new SparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    private SparseArray<b> f2712e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    private c f2713f = null;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        int f2714a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<b> f2715b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        int f2716c = -1;

        /* renamed from: d  reason: collision with root package name */
        boolean f2717d;

        public a(Context context, XmlPullParser xmlPullParser) {
            this.f2717d = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.State_android_id) {
                    this.f2714a = obtainStyledAttributes.getResourceId(index, this.f2714a);
                } else if (index == R.styleable.State_constraints) {
                    this.f2716c = obtainStyledAttributes.getResourceId(index, this.f2716c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f2716c);
                    context.getResources().getResourceName(this.f2716c);
                    if ("layout".equals(resourceTypeName)) {
                        this.f2717d = true;
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public int a(float f2, float f3) {
            for (int i2 = 0; i2 < this.f2715b.size(); i2++) {
                if (this.f2715b.get(i2).a(f2, f3)) {
                    return i2;
                }
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public void a(b bVar) {
            this.f2715b.add(bVar);
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        float f2718a = Float.NaN;

        /* renamed from: b  reason: collision with root package name */
        float f2719b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        float f2720c = Float.NaN;

        /* renamed from: d  reason: collision with root package name */
        float f2721d = Float.NaN;

        /* renamed from: e  reason: collision with root package name */
        int f2722e = -1;

        /* renamed from: f  reason: collision with root package name */
        boolean f2723f;

        public b(Context context, XmlPullParser xmlPullParser) {
            this.f2723f = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.Variant_constraints) {
                    this.f2722e = obtainStyledAttributes.getResourceId(index, this.f2722e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f2722e);
                    context.getResources().getResourceName(this.f2722e);
                    if ("layout".equals(resourceTypeName)) {
                        this.f2723f = true;
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.f2721d = obtainStyledAttributes.getDimension(index, this.f2721d);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.f2719b = obtainStyledAttributes.getDimension(index, this.f2719b);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.f2720c = obtainStyledAttributes.getDimension(index, this.f2720c);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.f2718a = obtainStyledAttributes.getDimension(index, this.f2718a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public boolean a(float f2, float f3) {
            if (!Float.isNaN(this.f2718a) && f2 < this.f2718a) {
                return false;
            }
            if (!Float.isNaN(this.f2719b) && f3 < this.f2719b) {
                return false;
            }
            if (Float.isNaN(this.f2720c) || f2 <= this.f2720c) {
                return Float.isNaN(this.f2721d) || f3 <= this.f2721d;
            }
            return false;
        }
    }

    public d(Context context, XmlPullParser xmlPullParser) {
        a(context, xmlPullParser);
    }

    private void a(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.StateSet);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.StateSet_defaultState) {
                this.f2708a = obtainStyledAttributes.getResourceId(index, this.f2708a);
            }
        }
        obtainStyledAttributes.recycle();
        a aVar = null;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 0) {
                    xmlPullParser.getName();
                } else if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    char c2 = 65535;
                    switch (name.hashCode()) {
                        case 80204913:
                            if (name.equals("State")) {
                                c2 = 2;
                                break;
                            }
                            break;
                        case 1301459538:
                            if (name.equals("LayoutDescription")) {
                                c2 = 0;
                                break;
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                c2 = 1;
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
                            aVar = new a(context, xmlPullParser);
                            this.f2711d.put(aVar.f2714a, aVar);
                        } else if (c2 != 3) {
                            Log.v("ConstraintLayoutStates", "unknown tag " + name);
                        } else {
                            b bVar = new b(context, xmlPullParser);
                            if (aVar != null) {
                                aVar.a(bVar);
                            }
                        }
                    }
                } else if (eventType != 3) {
                    continue;
                } else if ("StateSet".equals(xmlPullParser.getName())) {
                    return;
                }
                eventType = xmlPullParser.next();
            }
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public int a(int i2, int i3, float f2, float f3) {
        a aVar = this.f2711d.get(i3);
        if (aVar == null) {
            return i3;
        }
        if (f2 != -1.0f && f3 != -1.0f) {
            b bVar = null;
            Iterator<b> it2 = aVar.f2715b.iterator();
            while (it2.hasNext()) {
                b next = it2.next();
                if (next.a(f2, f3)) {
                    if (i2 == next.f2722e) {
                        return i2;
                    }
                    bVar = next;
                }
            }
            return bVar != null ? bVar.f2722e : aVar.f2716c;
        } else if (aVar.f2716c == i2) {
            return i2;
        } else {
            Iterator<b> it3 = aVar.f2715b.iterator();
            while (it3.hasNext()) {
                if (i2 == it3.next().f2722e) {
                    return i2;
                }
            }
            return aVar.f2716c;
        }
    }

    public int a(int i2, int i3, int i4) {
        return b(-1, i2, (float) i3, (float) i4);
    }

    public int b(int i2, int i3, float f2, float f3) {
        int a2;
        if (i2 == i3) {
            a aVar = (a) (i3 == -1 ? this.f2711d.valueAt(0) : this.f2711d.get(this.f2709b));
            if (aVar == null) {
                return -1;
            }
            return ((this.f2710c == -1 || !aVar.f2715b.get(i2).a(f2, f3)) && i2 != (a2 = aVar.a(f2, f3))) ? a2 == -1 ? aVar.f2716c : aVar.f2715b.get(a2).f2722e : i2;
        }
        a aVar2 = this.f2711d.get(i3);
        if (aVar2 == null) {
            return -1;
        }
        int a3 = aVar2.a(f2, f3);
        return a3 == -1 ? aVar2.f2716c : aVar2.f2715b.get(a3).f2722e;
    }
}
