package id;

import android.util.Xml;
import com.huawei.android.multiscreen.dlna.sdk.dlnamanager.b;
import com.huawei.android.multiscreen.dlna.sdk.jni.DlnaDmsShareDir;
import ie.a;
import java.io.IOException;
import java.io.StringWriter;
import org.xmlpull.v1.XmlSerializer;

public class g extends h {

    /* renamed from: c  reason: collision with root package name */
    private static g f13540c;

    protected g() {
        this.f13541a = b.a().d();
        this.f13542b = new f();
    }

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            g gVar2 = f13540c;
            if (gVar2 == null || gVar2.f13541a == null) {
                f13540c = new g();
            }
            gVar = f13540c;
        }
        return gVar;
    }

    private synchronized String a(DlnaDmsShareDir dlnaDmsShareDir) {
        String str;
        String str2;
        String str3;
        str = "";
        XmlSerializer newSerializer = Xml.newSerializer();
        StringWriter stringWriter = new StringWriter();
        try {
            newSerializer.setOutput(stringWriter);
            newSerializer.startDocument("UTF-8", true);
            newSerializer.startTag("", "fileShare");
            a(newSerializer, dlnaDmsShareDir);
            newSerializer.endTag("", "fileShare");
            newSerializer.endDocument();
            str = stringWriter.toString();
            try {
                stringWriter.close();
            } catch (IOException e2) {
                e = e2;
                String str4 = "XMLManager";
                String str5 = "IOException when close StringWriter after convert SHARE TREE to XML.";
            }
        } catch (IOException e3) {
            try {
                a.a("XMLManager", "IOException when convert SHARE TREE to XML.", e3);
            } finally {
                try {
                    stringWriter.close();
                } catch (IOException e4) {
                    str2 = "XMLManager";
                    str3 = "IOException when close StringWriter after convert SHARE TREE to XML.";
                    a.a(str2, str3, e4);
                }
            }
        }
        return str;
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.xmlpull.v1.XmlSerializer r6, com.huawei.android.multiscreen.dlna.sdk.jni.a r7) {
        /*
            r5 = this;
            java.lang.String r0 = "filePath"
            java.lang.String r1 = "XMLManager"
            java.lang.String r2 = ""
            int r3 = r7.b()
            com.huawei.android.multiscreen.dlna.sdk.dms.ShareStateEnum r4 = com.huawei.android.multiscreen.dlna.sdk.dms.ShareStateEnum.ALL_SHARE_FLAG
            int r4 = r4.a()
            if (r3 != r4) goto L_0x0030
            r6.startTag(r2, r0)     // Catch:{ IllegalArgumentException -> 0x002a, IllegalStateException -> 0x0026, IOException -> 0x0022 }
            java.lang.String r3 = "path"
            java.lang.String r4 = r7.j()     // Catch:{ IllegalArgumentException -> 0x002a, IllegalStateException -> 0x0026, IOException -> 0x0022 }
            r6.attribute(r2, r3, r4)     // Catch:{ IllegalArgumentException -> 0x002a, IllegalStateException -> 0x0026, IOException -> 0x0022 }
            r6.endTag(r2, r0)     // Catch:{ IllegalArgumentException -> 0x002a, IllegalStateException -> 0x0026, IOException -> 0x0022 }
            goto L_0x0030
        L_0x0022:
            r0 = move-exception
            java.lang.String r2 = "IOException when convert SHARE TREE to serializer."
            goto L_0x002d
        L_0x0026:
            r0 = move-exception
            java.lang.String r2 = "IllegalStateException when convert SHARE TREE to serializer."
            goto L_0x002d
        L_0x002a:
            r0 = move-exception
            java.lang.String r2 = "IllegalArgumentException when convert SHARE TREE to serializer."
        L_0x002d:
            ie.a.a(r1, r2, r0)
        L_0x0030:
            boolean r0 = r7.d()
            if (r0 == 0) goto L_0x0055
            com.huawei.android.multiscreen.dlna.sdk.jni.DlnaDmsShareDir r7 = (com.huawei.android.multiscreen.dlna.sdk.jni.DlnaDmsShareDir) r7
            java.util.concurrent.ConcurrentHashMap r7 = r7.c()
            java.util.Collection r7 = r7.values()
            java.util.Iterator r7 = r7.iterator()
        L_0x0044:
            boolean r0 = r7.hasNext()
            if (r0 != 0) goto L_0x004b
            goto L_0x0055
        L_0x004b:
            java.lang.Object r0 = r7.next()
            com.huawei.android.multiscreen.dlna.sdk.jni.a r0 = (com.huawei.android.multiscreen.dlna.sdk.jni.a) r0
            r5.a(r6, r0)
            goto L_0x0044
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.g.a(org.xmlpull.v1.XmlSerializer, com.huawei.android.multiscreen.dlna.sdk.jni.a):void");
    }

    public void b() {
        a("dlna_share_file_configuration.xml", a(d.a().d()));
    }
}
