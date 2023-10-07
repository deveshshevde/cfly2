package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class h {

    /* renamed from: a  reason: collision with root package name */
    static HashMap<String, Constructor<? extends c>> f1873a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<Integer, ArrayList<c>> f1874b = new HashMap<>();

    static {
        HashMap<String, Constructor<? extends c>> hashMap = new HashMap<>();
        f1873a = hashMap;
        try {
            hashMap.put("KeyAttribute", d.class.getConstructor(new Class[0]));
            f1873a.put("KeyPosition", i.class.getConstructor(new Class[0]));
            f1873a.put("KeyCycle", f.class.getConstructor(new Class[0]));
            f1873a.put("KeyTimeCycle", k.class.getConstructor(new Class[0]));
            f1873a.put("KeyTrigger", l.class.getConstructor(new Class[0]));
        } catch (NoSuchMethodException e2) {
            Log.e("KeyFrames", "unable to load", e2);
        }
    }

    public h(Context context, XmlPullParser xmlPullParser) {
        c cVar;
        Exception e2;
        c cVar2 = null;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (f1873a.containsKey(name)) {
                        try {
                            cVar = (c) f1873a.get(name).newInstance(new Object[0]);
                            try {
                                cVar.a(context, Xml.asAttributeSet(xmlPullParser));
                                a(cVar);
                            } catch (Exception e3) {
                                e2 = e3;
                            }
                        } catch (Exception e4) {
                            Exception exc = e4;
                            cVar = cVar2;
                            e2 = exc;
                            Log.e("KeyFrames", "unable to create ", e2);
                            cVar2 = cVar;
                            eventType = xmlPullParser.next();
                        }
                        cVar2 = cVar;
                    } else if (!(!name.equalsIgnoreCase("CustomAttribute") || cVar2 == null || cVar2.f1807f == null)) {
                        ConstraintAttribute.a(context, xmlPullParser, cVar2.f1807f);
                    }
                } else if (eventType == 3) {
                    if ("KeyFrameSet".equals(xmlPullParser.getName())) {
                        return;
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (XmlPullParserException e5) {
            e5.printStackTrace();
        } catch (IOException e6) {
            e6.printStackTrace();
        }
    }

    private void a(c cVar) {
        if (!this.f1874b.containsKey(Integer.valueOf(cVar.f1804c))) {
            this.f1874b.put(Integer.valueOf(cVar.f1804c), new ArrayList());
        }
        this.f1874b.get(Integer.valueOf(cVar.f1804c)).add(cVar);
    }

    public void a(n nVar) {
        ArrayList arrayList = this.f1874b.get(Integer.valueOf(nVar.f1955b));
        if (arrayList != null) {
            nVar.a((ArrayList<c>) arrayList);
        }
        ArrayList arrayList2 = this.f1874b.get(-1);
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                c cVar = (c) it2.next();
                if (cVar.a(((ConstraintLayout.LayoutParams) nVar.f1954a.getLayoutParams()).V)) {
                    nVar.a(cVar);
                }
            }
        }
    }
}
