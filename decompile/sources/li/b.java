package li;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    protected a f30847a;

    /* renamed from: b  reason: collision with root package name */
    protected XmlPullParser f30848b;

    public interface a {
        void b();
    }

    private void b(XmlPullParser xmlPullParser) {
        int i2;
        try {
            i2 = xmlPullParser.getEventType();
        } catch (XmlPullParserException e2) {
            if (this.f30847a != null) {
                this.f30847a.b();
            }
            e2.printStackTrace();
            i2 = 0;
        }
        while (i2 != 1) {
            if (i2 == 0) {
                c();
            } else if (i2 == 1) {
                d();
            } else if (i2 == 2) {
                a(xmlPullParser);
            } else if (i2 == 3) {
                e();
            } else if (i2 == 4) {
                f();
            }
            try {
                i2 = xmlPullParser.next();
            } catch (XmlPullParserException e3) {
                if (this.f30847a != null) {
                    this.f30847a.b();
                }
                e3.printStackTrace();
            } catch (IOException e4) {
                if (this.f30847a != null) {
                    this.f30847a.b();
                }
                e4.printStackTrace();
            }
        }
    }

    public void a(Context context, int i2) {
        a(context.getResources().getXml(i2));
    }

    public void a(XmlResourceParser xmlResourceParser) {
        this.f30848b = xmlResourceParser;
        b(xmlResourceParser);
    }

    public void a(String str) throws FileNotFoundException, XmlPullParserException {
        FileInputStream fileInputStream = new FileInputStream(new File(Environment.getExternalStorageDirectory() + "/DroidPlanner/Checklists/" + str));
        XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
        newInstance.setNamespaceAware(true);
        XmlPullParser newPullParser = newInstance.newPullParser();
        this.f30848b = newPullParser;
        newPullParser.setInput(new InputStreamReader(fileInputStream));
        b(this.f30848b);
    }

    public void a(a aVar) {
        this.f30847a = aVar;
    }

    public abstract void a(XmlPullParser xmlPullParser);

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();
}
