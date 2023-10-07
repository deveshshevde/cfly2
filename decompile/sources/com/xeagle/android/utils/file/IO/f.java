package com.xeagle.android.utils.file.IO;

import android.content.Context;
import android.util.Xml;
import com.flypro.core.parameters.ParameterMetadata;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import kx.d;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class f {
    private static ParameterMetadataMap a(InputStream inputStream, String str) throws XmlPullParserException, IOException {
        try {
            XmlPullParser newPullParser = Xml.newPullParser();
            newPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            newPullParser.setInput(inputStream, (String) null);
            return a(newPullParser, str);
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    private static ParameterMetadataMap a(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        ParameterMetadataMap parameterMetadataMap = new ParameterMetadataMap();
        int eventType = xmlPullParser.getEventType();
        boolean z2 = false;
        ParameterMetadata parameterMetadata = null;
        while (eventType != 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (str.equals(name)) {
                    z2 = true;
                } else if (z2) {
                    if (parameterMetadata == null) {
                        parameterMetadata = new ParameterMetadata();
                        parameterMetadata.a(name);
                    } else {
                        a(parameterMetadata, name, xmlPullParser.nextText());
                    }
                }
            } else if (eventType != 3) {
                continue;
            } else {
                String name2 = xmlPullParser.getName();
                if (str.equals(name2)) {
                    return parameterMetadataMap;
                }
                if (parameterMetadata != null && parameterMetadata.a().equals(name2)) {
                    parameterMetadataMap.put(parameterMetadata.a(), parameterMetadata);
                    parameterMetadata = null;
                }
            }
            eventType = xmlPullParser.next();
        }
        return null;
    }

    public static Map<String, ParameterMetadata> a(Context context, String str) throws IOException, XmlPullParserException {
        File file = new File(d.a(context) + "Parameters/ParameterMetaData.xml");
        return a(file.exists() ? new FileInputStream(file) : context.getAssets().open("Parameters/ParameterMetaData.xml"), str);
    }

    private static void a(ParameterMetadata parameterMetadata, String str, String str2) {
        if (str.equals("DisplayName")) {
            parameterMetadata.b(str2);
        } else if (str.equals("Description")) {
            parameterMetadata.c(str2);
        } else if (str.equals("Units")) {
            parameterMetadata.d(str2);
        } else if (str.equals("Range")) {
            parameterMetadata.e(str2);
        } else if (str.equals("Values")) {
            parameterMetadata.f(str2);
        }
    }
}
