package lg;

import android.content.Context;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import li.b;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class d extends b {

    /* renamed from: c  reason: collision with root package name */
    private List<String> f30836c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private List<b> f30837d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private String f30838e;

    /* renamed from: f  reason: collision with root package name */
    private String f30839f;

    /* renamed from: g  reason: collision with root package name */
    private String f30840g;

    public d() {
    }

    public d(String str, Context context, int i2) {
        try {
            a(str);
        } catch (FileNotFoundException e2) {
            a(context, i2);
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    private void b(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "label");
        if (attributeValue == null) {
            attributeValue = "Unknown";
        }
        this.f30836c.add(attributeValue);
        PrintStream printStream = System.out;
        printStream.println("Category - " + attributeValue);
    }

    private void c(XmlPullParser xmlPullParser) {
        String name = xmlPullParser.getName();
        if (this.f30836c.size() != 0 && name != null) {
            this.f30837d.add(new b(xmlPullParser.getName()));
            List<b> list = this.f30837d;
            b bVar = list.get(list.size() - 1);
            bVar.c(xmlPullParser.getDepth());
            bVar.b(this.f30836c.size() - 1);
            bVar.a(xmlPullParser.getAttributeValue((String) null, "title"));
            bVar.b(xmlPullParser.getAttributeValue((String) null, "description"));
            bVar.k(xmlPullParser.getAttributeValue((String) null, "unit"));
            bVar.l(xmlPullParser.getAttributeValue((String) null, "on_label"));
            bVar.m(xmlPullParser.getAttributeValue((String) null, "off_label"));
            bVar.c(xmlPullParser.getAttributeValue((String) null, "system_tag"));
            bVar.d(xmlPullParser.getAttributeValue((String) null, "editable"));
            bVar.e(xmlPullParser.getAttributeValue((String) null, "mandatory"));
            bVar.g(xmlPullParser.getAttributeValue((String) null, "nominal_val"));
            bVar.f(xmlPullParser.getAttributeValue((String) null, "minimum_val"));
            bVar.h(xmlPullParser.getAttributeValue((String) null, "maximum_val"));
            bVar.n(xmlPullParser.getAttributeValue((String) null, "value"));
            bVar.i(xmlPullParser.getAttributeValue((String) null, "selectindex"));
            bVar.j(xmlPullParser.getAttributeValue((String) null, "optionlist"));
        }
    }

    public List<String> a() {
        return this.f30836c;
    }

    public void a(b.a aVar) {
        this.f30847a = aVar;
    }

    public void a(XmlPullParser xmlPullParser) {
        if (xmlPullParser.getName().equalsIgnoreCase("category")) {
            b(xmlPullParser);
        } else if (xmlPullParser.getName().contains("_item")) {
            c(xmlPullParser);
        } else if (xmlPullParser.getDepth() == 1) {
            this.f30838e = xmlPullParser.getAttributeValue((String) null, "title");
            this.f30839f = xmlPullParser.getAttributeValue((String) null, "type");
            this.f30840g = xmlPullParser.getAttributeValue((String) null, "version");
        }
    }

    public List<b> b() {
        return this.f30837d;
    }

    public void c() {
    }

    public void d() {
    }

    public void e() {
    }

    public void f() {
    }
}
