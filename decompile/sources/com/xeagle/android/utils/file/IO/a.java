package com.xeagle.android.utils.file.IO;

import android.util.Xml;
import java.io.IOException;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private XmlPullParser f24397a;

    /* renamed from: b  reason: collision with root package name */
    private eo.a f24398b = new eo.a();

    private String a(String str) throws IOException, XmlPullParserException {
        this.f24397a.require(2, (String) null, str);
        String c2 = c();
        this.f24397a.require(3, (String) null, str);
        return c2;
    }

    private Double b(String str) throws IOException, XmlPullParserException {
        this.f24397a.require(2, (String) null, str);
        Double valueOf = Double.valueOf(c());
        this.f24397a.require(3, (String) null, str);
        return valueOf;
    }

    private void b() throws XmlPullParserException, IOException {
        this.f24397a.require(2, (String) null, "cameraInfo");
        while (this.f24397a.next() != 3) {
            if (this.f24397a.getEventType() == 2) {
                String name = this.f24397a.getName();
                if (name.equals("SensorWidth")) {
                    this.f24398b.f26932b = b("SensorWidth");
                } else if (name.equals("SensorHeight")) {
                    this.f24398b.f26933c = b("SensorHeight");
                } else if (name.equals("SensorResolution")) {
                    this.f24398b.f26934d = b("SensorResolution");
                } else if (name.equals("FocalLength")) {
                    this.f24398b.f26935e = b("FocalLength");
                } else if (name.equals("Overlap")) {
                    this.f24398b.f26936f = b("Overlap");
                } else if (name.equals("Sidelap")) {
                    this.f24398b.f26937g = b("Sidelap");
                } else if (name.equals("Name")) {
                    this.f24398b.f26931a = a("Name");
                } else if (name.equals("Orientation")) {
                    this.f24398b.f26938h = !c().equals("Portrait");
                } else {
                    d();
                }
            }
        }
    }

    private String c() throws IOException, XmlPullParserException {
        if (this.f24397a.next() != 4) {
            return "";
        }
        String text = this.f24397a.getText();
        this.f24397a.nextTag();
        return text;
    }

    private void d() throws XmlPullParserException, IOException {
        if (this.f24397a.getEventType() == 2) {
            int i2 = 1;
            while (i2 != 0) {
                int next = this.f24397a.next();
                if (next == 2) {
                    i2++;
                } else if (next == 3) {
                    i2--;
                }
            }
            return;
        }
        throw new IllegalStateException();
    }

    public eo.a a() {
        return this.f24398b;
    }

    public void a(InputStream inputStream) throws Exception {
        b(inputStream);
        inputStream.close();
    }

    public void b(InputStream inputStream) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = Xml.newPullParser();
        this.f24397a = newPullParser;
        newPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
        this.f24397a.setInput(inputStream, (String) null);
        this.f24397a.nextTag();
        b();
    }
}
