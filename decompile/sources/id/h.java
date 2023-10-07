package id;

import android.content.Context;

public class h {

    /* renamed from: a  reason: collision with root package name */
    protected Context f13541a;

    /* renamed from: b  reason: collision with root package name */
    protected f f13542b;

    /* JADX WARNING: Code restructure failed: missing block: B:89:0x00c9, code lost:
        return null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x006c A[SYNTHETIC, Splitter:B:45:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0080 A[SYNTHETIC, Splitter:B:54:0x0080] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0094 A[SYNTHETIC, Splitter:B:63:0x0094] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00a7 A[SYNTHETIC, Splitter:B:72:0x00a7] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00bb A[SYNTHETIC, Splitter:B:81:0x00bb] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<java.lang.String> a(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            android.content.Context r0 = r3.f13541a     // Catch:{ all -> 0x00ca }
            r1 = 0
            if (r0 == 0) goto L_0x00c8
            id.f r2 = r3.f13542b     // Catch:{ all -> 0x00ca }
            if (r2 != 0) goto L_0x000c
            goto L_0x00c8
        L_0x000c:
            java.io.FileInputStream r4 = r0.openFileInput(r4)     // Catch:{ FileNotFoundException -> 0x009e, IOException -> 0x008a, ParserConfigurationException -> 0x0076, SAXException -> 0x0062 }
            javax.xml.parsers.SAXParserFactory r0 = javax.xml.parsers.SAXParserFactory.newInstance()     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005b, ParserConfigurationException -> 0x0058, SAXException -> 0x0055, all -> 0x0051 }
            javax.xml.parsers.SAXParser r0 = r0.newSAXParser()     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005b, ParserConfigurationException -> 0x0058, SAXException -> 0x0055, all -> 0x0051 }
            if (r0 != 0) goto L_0x002a
            if (r4 == 0) goto L_0x0028
            r4.close()     // Catch:{ IOException -> 0x0020 }
            goto L_0x0028
        L_0x0020:
            r4 = move-exception
            java.lang.String r0 = "XMLManager"
            java.lang.String r2 = "IOException when close InputStrean after reading the SHARE XML FILE."
            ie.a.a(r0, r2, r4)     // Catch:{ all -> 0x00ca }
        L_0x0028:
            monitor-exit(r3)
            return r1
        L_0x002a:
            org.xml.sax.XMLReader r0 = r0.getXMLReader()     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005b, ParserConfigurationException -> 0x0058, SAXException -> 0x0055, all -> 0x0051 }
            org.xml.sax.InputSource r1 = new org.xml.sax.InputSource     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005b, ParserConfigurationException -> 0x0058, SAXException -> 0x0055, all -> 0x0051 }
            r1.<init>(r4)     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005b, ParserConfigurationException -> 0x0058, SAXException -> 0x0055, all -> 0x0051 }
            id.f r2 = r3.f13542b     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005b, ParserConfigurationException -> 0x0058, SAXException -> 0x0055, all -> 0x0051 }
            r2.b()     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005b, ParserConfigurationException -> 0x0058, SAXException -> 0x0055, all -> 0x0051 }
            id.f r2 = r3.f13542b     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005b, ParserConfigurationException -> 0x0058, SAXException -> 0x0055, all -> 0x0051 }
            r0.setContentHandler(r2)     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005b, ParserConfigurationException -> 0x0058, SAXException -> 0x0055, all -> 0x0051 }
            r0.parse(r1)     // Catch:{ FileNotFoundException -> 0x005e, IOException -> 0x005b, ParserConfigurationException -> 0x0058, SAXException -> 0x0055, all -> 0x0051 }
            if (r4 == 0) goto L_0x00b1
            r4.close()     // Catch:{ IOException -> 0x0047 }
            goto L_0x00b1
        L_0x0047:
            r4 = move-exception
            java.lang.String r0 = "XMLManager"
            java.lang.String r1 = "IOException when close InputStrean after reading the SHARE XML FILE."
        L_0x004c:
            ie.a.a(r0, r1, r4)     // Catch:{ all -> 0x00ca }
            goto L_0x00b1
        L_0x0051:
            r0 = move-exception
            r1 = r4
            goto L_0x00b9
        L_0x0055:
            r0 = move-exception
            r1 = r4
            goto L_0x0063
        L_0x0058:
            r0 = move-exception
            r1 = r4
            goto L_0x0077
        L_0x005b:
            r0 = move-exception
            r1 = r4
            goto L_0x008b
        L_0x005e:
            r1 = r4
            goto L_0x009e
        L_0x0060:
            r0 = move-exception
            goto L_0x00b9
        L_0x0062:
            r0 = move-exception
        L_0x0063:
            java.lang.String r4 = "XMLManager"
            java.lang.String r2 = "SAXException when reading the SHARE XML FILE."
            ie.a.a(r4, r2, r0)     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x00b1
            r1.close()     // Catch:{ IOException -> 0x0070 }
            goto L_0x00b1
        L_0x0070:
            r4 = move-exception
            java.lang.String r0 = "XMLManager"
            java.lang.String r1 = "IOException when close InputStrean after reading the SHARE XML FILE."
            goto L_0x004c
        L_0x0076:
            r0 = move-exception
        L_0x0077:
            java.lang.String r4 = "XMLManager"
            java.lang.String r2 = "ParserConfigurationException when reading the SHARE XML FILE."
            ie.a.a(r4, r2, r0)     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x00b1
            r1.close()     // Catch:{ IOException -> 0x0084 }
            goto L_0x00b1
        L_0x0084:
            r4 = move-exception
            java.lang.String r0 = "XMLManager"
            java.lang.String r1 = "IOException when close InputStrean after reading the SHARE XML FILE."
            goto L_0x004c
        L_0x008a:
            r0 = move-exception
        L_0x008b:
            java.lang.String r4 = "XMLManager"
            java.lang.String r2 = "IOException when reading the SHARE XML FILE."
            ie.a.a(r4, r2, r0)     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x00b1
            r1.close()     // Catch:{ IOException -> 0x0098 }
            goto L_0x00b1
        L_0x0098:
            r4 = move-exception
            java.lang.String r0 = "XMLManager"
            java.lang.String r1 = "IOException when close InputStrean after reading the SHARE XML FILE."
            goto L_0x004c
        L_0x009e:
            java.lang.String r4 = "XMLManager"
            java.lang.String r0 = "FileNotFoundException: There is no XML Share File Found. It's normal."
            ie.a.b(r4, r0)     // Catch:{ all -> 0x0060 }
            if (r1 == 0) goto L_0x00b1
            r1.close()     // Catch:{ IOException -> 0x00ab }
            goto L_0x00b1
        L_0x00ab:
            r4 = move-exception
            java.lang.String r0 = "XMLManager"
            java.lang.String r1 = "IOException when close InputStrean after reading the SHARE XML FILE."
            goto L_0x004c
        L_0x00b1:
            id.f r4 = r3.f13542b     // Catch:{ all -> 0x00ca }
            java.util.ArrayList r4 = r4.a()     // Catch:{ all -> 0x00ca }
            monitor-exit(r3)
            return r4
        L_0x00b9:
            if (r1 == 0) goto L_0x00c7
            r1.close()     // Catch:{ IOException -> 0x00bf }
            goto L_0x00c7
        L_0x00bf:
            r4 = move-exception
            java.lang.String r1 = "XMLManager"
            java.lang.String r2 = "IOException when close InputStrean after reading the SHARE XML FILE."
            ie.a.a(r1, r2, r4)     // Catch:{ all -> 0x00ca }
        L_0x00c7:
            throw r0     // Catch:{ all -> 0x00ca }
        L_0x00c8:
            monitor-exit(r3)
            return r1
        L_0x00ca:
            r4 = move-exception
            monitor-exit(r3)
            goto L_0x00ce
        L_0x00cd:
            throw r4
        L_0x00ce:
            goto L_0x00cd
        */
        throw new UnsupportedOperationException("Method not decompiled: id.h.a(java.lang.String):java.util.List");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:100:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:?, code lost:
        ie.a.d("XMLManager", "IOException when closing strean after writing the SHARE XML FILE.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x00b6, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        ie.a.d("XMLManager", "IOException when closing strean after writing the SHARE XML FILE.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x009b, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x009c, code lost:
        if (r2 != null) goto L_0x009e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:?, code lost:
        ie.a.d("XMLManager", "IOException when closing strean after writing the SHARE XML FILE.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x00a9, code lost:
        if (r4 != null) goto L_0x00ab;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:14:0x0017, B:37:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0042 A[SYNTHETIC, Splitter:B:40:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x004f A[SYNTHETIC, Splitter:B:47:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0062 A[SYNTHETIC, Splitter:B:58:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x006f A[SYNTHETIC, Splitter:B:65:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0082 A[SYNTHETIC, Splitter:B:76:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x008f A[SYNTHETIC, Splitter:B:83:0x008f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean a(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            android.content.Context r0 = r3.f13541a     // Catch:{ all -> 0x00b7 }
            r1 = 0
            if (r0 != 0) goto L_0x0008
            monitor-exit(r3)
            return r1
        L_0x0008:
            r2 = 0
            java.io.FileOutputStream r4 = r0.openFileOutput(r4, r1)     // Catch:{ FileNotFoundException -> 0x0078, IOException -> 0x0058, all -> 0x0038 }
            java.io.OutputStreamWriter r0 = new java.io.OutputStreamWriter     // Catch:{ FileNotFoundException -> 0x0079, IOException -> 0x0059, all -> 0x0039 }
            java.lang.String r1 = "utf-8"
            r0.<init>(r4, r1)     // Catch:{ FileNotFoundException -> 0x0079, IOException -> 0x0059, all -> 0x0039 }
            r0.write(r5)     // Catch:{ FileNotFoundException -> 0x0036, IOException -> 0x0034, all -> 0x0032 }
            r0.close()     // Catch:{ IOException -> 0x001b }
            goto L_0x0022
        L_0x001b:
            java.lang.String r5 = "XMLManager"
            java.lang.String r0 = "IOException when closing strean after writing the SHARE XML FILE."
            ie.a.d(r5, r0)     // Catch:{ all -> 0x00b7 }
        L_0x0022:
            if (r4 == 0) goto L_0x0098
            r4.close()     // Catch:{ IOException -> 0x0029 }
            goto L_0x0098
        L_0x0029:
            java.lang.String r4 = "XMLManager"
            java.lang.String r5 = "IOException when closing strean after writing the SHARE XML FILE."
        L_0x002d:
            ie.a.d(r4, r5)     // Catch:{ all -> 0x00b7 }
            goto L_0x0098
        L_0x0032:
            r2 = r0
            goto L_0x0039
        L_0x0034:
            r2 = r0
            goto L_0x0059
        L_0x0036:
            r2 = r0
            goto L_0x0079
        L_0x0038:
            r4 = r2
        L_0x0039:
            java.lang.String r5 = "XMLManager"
            java.lang.String r0 = "Throwable when writing the SHARE XML FILE."
            ie.a.d(r5, r0)     // Catch:{ all -> 0x009b }
            if (r2 == 0) goto L_0x004d
            r2.close()     // Catch:{ IOException -> 0x0046 }
            goto L_0x004d
        L_0x0046:
            java.lang.String r5 = "XMLManager"
            java.lang.String r0 = "IOException when closing strean after writing the SHARE XML FILE."
            ie.a.d(r5, r0)     // Catch:{ all -> 0x00b7 }
        L_0x004d:
            if (r4 == 0) goto L_0x0098
            r4.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x0098
        L_0x0053:
            java.lang.String r4 = "XMLManager"
            java.lang.String r5 = "IOException when closing strean after writing the SHARE XML FILE."
            goto L_0x002d
        L_0x0058:
            r4 = r2
        L_0x0059:
            java.lang.String r5 = "XMLManager"
            java.lang.String r0 = "IOException when writing the SHARE XML FILE."
            ie.a.d(r5, r0)     // Catch:{ all -> 0x009b }
            if (r2 == 0) goto L_0x006d
            r2.close()     // Catch:{ IOException -> 0x0066 }
            goto L_0x006d
        L_0x0066:
            java.lang.String r5 = "XMLManager"
            java.lang.String r0 = "IOException when closing strean after writing the SHARE XML FILE."
            ie.a.d(r5, r0)     // Catch:{ all -> 0x00b7 }
        L_0x006d:
            if (r4 == 0) goto L_0x0098
            r4.close()     // Catch:{ IOException -> 0x0073 }
            goto L_0x0098
        L_0x0073:
            java.lang.String r4 = "XMLManager"
            java.lang.String r5 = "IOException when closing strean after writing the SHARE XML FILE."
            goto L_0x002d
        L_0x0078:
            r4 = r2
        L_0x0079:
            java.lang.String r5 = "XMLManager"
            java.lang.String r0 = "FileNotFoundException when writing the SHARE XML FILE."
            ie.a.d(r5, r0)     // Catch:{ all -> 0x009b }
            if (r2 == 0) goto L_0x008d
            r2.close()     // Catch:{ IOException -> 0x0086 }
            goto L_0x008d
        L_0x0086:
            java.lang.String r5 = "XMLManager"
            java.lang.String r0 = "IOException when closing strean after writing the SHARE XML FILE."
            ie.a.d(r5, r0)     // Catch:{ all -> 0x00b7 }
        L_0x008d:
            if (r4 == 0) goto L_0x0098
            r4.close()     // Catch:{ IOException -> 0x0093 }
            goto L_0x0098
        L_0x0093:
            java.lang.String r4 = "XMLManager"
            java.lang.String r5 = "IOException when closing strean after writing the SHARE XML FILE."
            goto L_0x002d
        L_0x0098:
            r4 = 1
            monitor-exit(r3)
            return r4
        L_0x009b:
            r5 = move-exception
            if (r2 == 0) goto L_0x00a9
            r2.close()     // Catch:{ IOException -> 0x00a2 }
            goto L_0x00a9
        L_0x00a2:
            java.lang.String r0 = "XMLManager"
            java.lang.String r1 = "IOException when closing strean after writing the SHARE XML FILE."
            ie.a.d(r0, r1)     // Catch:{ all -> 0x00b7 }
        L_0x00a9:
            if (r4 == 0) goto L_0x00b6
            r4.close()     // Catch:{ IOException -> 0x00af }
            goto L_0x00b6
        L_0x00af:
            java.lang.String r4 = "XMLManager"
            java.lang.String r0 = "IOException when closing strean after writing the SHARE XML FILE."
            ie.a.d(r4, r0)     // Catch:{ all -> 0x00b7 }
        L_0x00b6:
            throw r5     // Catch:{ all -> 0x00b7 }
        L_0x00b7:
            r4 = move-exception
            monitor-exit(r3)
            goto L_0x00bb
        L_0x00ba:
            throw r4
        L_0x00bb:
            goto L_0x00ba
        */
        throw new UnsupportedOperationException("Method not decompiled: id.h.a(java.lang.String, java.lang.String):boolean");
    }
}
