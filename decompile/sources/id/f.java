package id;

import com.xeagle.android.login.pickImage.data.GLImage;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class f extends DefaultHandler {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<String> f13539a = new ArrayList<>();

    public ArrayList<String> a() {
        return this.f13539a;
    }

    public void b() {
        ArrayList<String> arrayList = this.f13539a;
        if (arrayList != null && arrayList.size() > 0) {
            this.f13539a.clear();
        }
    }

    public void endDocument() throws SAXException {
        super.endDocument();
    }

    public void endElement(String str, String str2, String str3) throws SAXException {
    }

    public void startDocument() throws SAXException {
        super.startDocument();
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        if (str2 != null && str2.equals("filePath") && attributes != null) {
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                if (attributes.getLocalName(i2) != null && attributes.getLocalName(i2).equals(GLImage.KEY_PATH)) {
                    this.f13539a.add(attributes.getValue(i2));
                }
            }
        }
    }
}
