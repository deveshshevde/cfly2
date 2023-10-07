package org.xmlpull.v1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;

public abstract class XmlPullParserFactory {
    private static final boolean DEBUG = false;
    private static final String DEFAULT_KXML_IMPL_FACTORY_CLASS_NAME = "org.kxml2.io.XmlReader";
    public static final String DEFAULT_PROPERTY_NAME = "org.xmlpull.v1.XmlPullParserFactory";
    private static final String DEFAULT_RESOURCE_NAME = "/META-INF/services/org.xmlpull.v1.XmlPullParserFactory";
    private static final String DEFAULT_XPP_IMPL_FACTORY_CLASS_NAME = "org.xmlpull.xpp3.factory.Xpp3Factory";
    private static Object MY_REF = new XmlPullParserException();
    private static final String PREFIX = "DEBUG XMLPULL factory: ";
    private static String foundFactoryClassName = null;
    protected Hashtable features = new Hashtable();

    protected XmlPullParserFactory() {
    }

    private static void debug(String str) {
        throw new RuntimeException("only when DEBUG enabled can print messages");
    }

    private static void findFactoryClassName(Class cls) {
        if (foundFactoryClassName == null) {
            InputStream inputStream = null;
            if (cls != null) {
                try {
                    inputStream = cls.getResourceAsStream(DEFAULT_RESOURCE_NAME);
                } catch (Exception unused) {
                    if (inputStream == null) {
                        return;
                    }
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            }
            if (inputStream == null) {
                inputStream = MY_REF.getClass().getResourceAsStream(DEFAULT_RESOURCE_NAME);
            }
            if (inputStream != null) {
                foundFactoryClassName = readLine(inputStream);
            }
            if (inputStream == null) {
                return;
            }
            try {
                inputStream.close();
            } catch (Exception unused3) {
            }
        } else {
            throw new RuntimeException("internal XMLPULL initialization error");
        }
    }

    public static XmlPullParserFactory newInstance() throws XmlPullParserException {
        return newInstance((Class) null, (String) null);
    }

    public static XmlPullParserFactory newInstance(Class cls) throws XmlPullParserException {
        return newInstance(cls, (String) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: org.xmlpull.v1.XmlPullParserFactory} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.xmlpull.v1.XmlPullParserFactory newInstance(java.lang.Class r3, java.lang.String r4) throws org.xmlpull.v1.XmlPullParserException {
        /*
            if (r4 == 0) goto L_0x0032
            java.lang.Class r0 = java.lang.Class.forName(r4)     // Catch:{ Exception -> 0x000d }
            java.lang.Object r0 = r0.newInstance()     // Catch:{ Exception -> 0x000d }
            org.xmlpull.v1.XmlPullParserFactory r0 = (org.xmlpull.v1.XmlPullParserFactory) r0     // Catch:{ Exception -> 0x000d }
            goto L_0x0033
        L_0x000d:
            r3 = move-exception
            org.xmlpull.v1.XmlPullParserException r0 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            java.lang.String r2 = "could not create instance of XMLPULL factory for class "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = " (root exception:"
            r1.append(r4)
            r1.append(r3)
            java.lang.String r4 = ")"
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>((java.lang.String) r4, (java.lang.Throwable) r3)
            throw r0
        L_0x0032:
            r0 = 0
        L_0x0033:
            if (r0 != 0) goto L_0x004d
            java.lang.String r4 = foundFactoryClassName
            if (r4 != 0) goto L_0x003c
            findFactoryClassName(r3)
        L_0x003c:
            java.lang.String r4 = foundFactoryClassName
            if (r4 == 0) goto L_0x004d
            java.lang.Class r4 = java.lang.Class.forName(r4)     // Catch:{ Exception -> 0x004c }
            java.lang.Object r4 = r4.newInstance()     // Catch:{ Exception -> 0x004c }
            org.xmlpull.v1.XmlPullParserFactory r4 = (org.xmlpull.v1.XmlPullParserFactory) r4     // Catch:{ Exception -> 0x004c }
            r0 = r4
            goto L_0x004d
        L_0x004c:
        L_0x004d:
            if (r0 != 0) goto L_0x0077
            java.lang.String r4 = "org.xmlpull.xpp3.factory.Xpp3Factory"
            java.lang.Class r0 = java.lang.Class.forName(r4)     // Catch:{ Exception -> 0x005e }
            java.lang.Object r0 = r0.newInstance()     // Catch:{ Exception -> 0x005e }
            org.xmlpull.v1.XmlPullParserFactory r0 = (org.xmlpull.v1.XmlPullParserFactory) r0     // Catch:{ Exception -> 0x005e }
            foundFactoryClassName = r4     // Catch:{ Exception -> 0x005e }
            goto L_0x0077
        L_0x005e:
            java.lang.String r4 = "org.kxml2.io.XmlReader"
            java.lang.Class r3 = java.lang.Class.forName(r4)     // Catch:{ Exception -> 0x006e }
            java.lang.Object r3 = r3.newInstance()     // Catch:{ Exception -> 0x006e }
            r0 = r3
            org.xmlpull.v1.XmlPullParserFactory r0 = (org.xmlpull.v1.XmlPullParserFactory) r0     // Catch:{ Exception -> 0x006e }
            foundFactoryClassName = r4     // Catch:{ Exception -> 0x006e }
            goto L_0x0077
        L_0x006e:
            r3 = move-exception
            org.xmlpull.v1.XmlPullParserException r4 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r0 = "could not load any factory class (even small or full default implementation)"
            r4.<init>((java.lang.String) r0, (java.lang.Throwable) r3)
            throw r4
        L_0x0077:
            if (r0 == 0) goto L_0x007a
            return r0
        L_0x007a:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException
            java.lang.String r4 = "XMLPULL: internal parser factory error"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xmlpull.v1.XmlPullParserFactory.newInstance(java.lang.Class, java.lang.String):org.xmlpull.v1.XmlPullParserFactory");
    }

    public static XmlPullParserFactory newInstance(String str) throws XmlPullParserException {
        return newInstance((Class) null, str);
    }

    private static String readLine(InputStream inputStream) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int read = inputStream.read();
            if (read >= 0 && read != 10) {
                stringBuffer.append((char) read);
            }
        }
        int length = stringBuffer.length();
        if (length > 0) {
            int i2 = length - 1;
            if (stringBuffer.charAt(i2) == 13) {
                stringBuffer.setLength(i2);
            }
        }
        return stringBuffer.toString();
    }

    public boolean getFeature(String str) {
        Boolean bool = (Boolean) this.features.get(str);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public boolean isNamespaceAware() {
        Boolean bool = (Boolean) this.features.get(XmlPullParser.FEATURE_PROCESS_NAMESPACES);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public boolean isValidating() {
        Boolean bool = (Boolean) this.features.get(XmlPullParser.FEATURE_VALIDATION);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public abstract XmlPullParser newPullParser() throws XmlPullParserException;

    public void setFeature(String str, boolean z2) throws XmlPullParserException {
        this.features.put(str, new Boolean(z2));
    }

    public void setNamespaceAware(boolean z2) throws XmlPullParserException {
        this.features.put(XmlPullParser.FEATURE_PROCESS_NAMESPACES, new Boolean(z2));
    }

    public void setValidating(boolean z2) throws XmlPullParserException {
        this.features.put(XmlPullParser.FEATURE_VALIDATION, new Boolean(z2));
    }
}
