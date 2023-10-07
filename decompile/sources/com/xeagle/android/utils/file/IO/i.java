package com.xeagle.android.utils.file.IO;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Xml;
import com.flypro.core.firmware.FirmwareType;
import dz.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import kx.a;
import kx.d;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class i {
    private static int a(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static b a(Context context, FirmwareType firmwareType) {
        String str = firmwareType + ".xml";
        String str2 = "VehicleProfiles" + File.separator + str;
        try {
            b bVar = new b();
            File file = new File(d.a(context) + str2);
            if (file.exists()) {
                a(bVar, file);
            } else {
                a(context, str, str2, bVar);
            }
            return bVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static void a(Context context, String str, String str2, b bVar) throws IOException, XmlPullParserException {
        AssetManager assets = context.getAssets();
        if (a.a(assets, "VehicleProfiles", str)) {
            a(assets.open(str2), bVar);
        }
    }

    private static void a(b bVar, File file) throws FileNotFoundException, XmlPullParserException, IOException {
        a((InputStream) new FileInputStream(file), bVar);
    }

    private static void a(InputStream inputStream, b bVar) throws XmlPullParserException, IOException {
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            newPullParser.setInput(inputStream, (String) null);
            a(newPullParser, bVar);
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    private static void a(XmlPullParser xmlPullParser, b.a aVar) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "wpNavSpeed");
        if (attributeValue != null) {
            aVar.a(a(attributeValue));
        }
        String attributeValue2 = xmlPullParser.getAttributeValue((String) null, "maxAltitude");
        if (attributeValue2 != null) {
            aVar.b(a(attributeValue2));
        }
    }

    private static void a(XmlPullParser xmlPullParser, b bVar) throws XmlPullParserException, IOException {
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            String name = xmlPullParser.getName();
            if (eventType == 2) {
                if (name.equals("ParameterMetadataType")) {
                    String attributeValue = xmlPullParser.getAttributeValue((String) null, "type");
                    if (attributeValue != null) {
                        bVar.a(attributeValue);
                    }
                } else if (name.equals("Default")) {
                    a(xmlPullParser, bVar.b());
                }
            }
            eventType = xmlPullParser.next();
        }
    }
}
