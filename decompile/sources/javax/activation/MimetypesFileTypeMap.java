package javax.activation;

import com.sun.activation.registries.LogSupport;
import com.sun.activation.registries.MimeTypeFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

public class MimetypesFileTypeMap extends FileTypeMap {
    private static final int PROG = 0;
    private static MimeTypeFile defDB = null;
    private static String defaultType = "application/octet-stream";
    private MimeTypeFile[] DB;

    public MimetypesFileTypeMap() {
        Vector vector = new Vector(5);
        vector.addElement((Object) null);
        LogSupport.log("MimetypesFileTypeMap: load HOME");
        try {
            String property = System.getProperty("user.home");
            if (property != null) {
                MimeTypeFile loadFile = loadFile(String.valueOf(property) + File.separator + ".mime.types");
                if (loadFile != null) {
                    vector.addElement(loadFile);
                }
            }
        } catch (SecurityException unused) {
        }
        LogSupport.log("MimetypesFileTypeMap: load SYS");
        try {
            MimeTypeFile loadFile2 = loadFile(String.valueOf(System.getProperty("java.home")) + File.separator + "lib" + File.separator + "mime.types");
            if (loadFile2 != null) {
                vector.addElement(loadFile2);
            }
        } catch (SecurityException unused2) {
        }
        LogSupport.log("MimetypesFileTypeMap: load JAR");
        loadAllResources(vector, "mime.types");
        LogSupport.log("MimetypesFileTypeMap: load DEF");
        synchronized (MimetypesFileTypeMap.class) {
            if (defDB == null) {
                defDB = loadResource("/mimetypes.default");
            }
        }
        MimeTypeFile mimeTypeFile = defDB;
        if (mimeTypeFile != null) {
            vector.addElement(mimeTypeFile);
        }
        MimeTypeFile[] mimeTypeFileArr = new MimeTypeFile[vector.size()];
        this.DB = mimeTypeFileArr;
        vector.copyInto(mimeTypeFileArr);
    }

    public MimetypesFileTypeMap(InputStream inputStream) {
        this();
        try {
            this.DB[0] = new MimeTypeFile(inputStream);
        } catch (IOException unused) {
        }
    }

    public MimetypesFileTypeMap(String str) throws IOException {
        this();
        this.DB[0] = new MimeTypeFile(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ce, code lost:
        if (r5 == null) goto L_0x00d7;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x00e3 */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a3 A[Catch:{ IOException -> 0x00b5, SecurityException -> 0x0099, all -> 0x0097, all -> 0x00dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b4 A[Catch:{ IOException -> 0x00b5, SecurityException -> 0x0099, all -> 0x0097, all -> 0x00dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00bf A[Catch:{ IOException -> 0x00b5, SecurityException -> 0x0099, all -> 0x0097, all -> 0x00dc }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00e0 A[SYNTHETIC, Splitter:B:67:0x00e0] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void loadAllResources(java.util.Vector r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "MimetypesFileTypeMap: can't load "
            r1 = 0
            java.lang.ClassLoader r2 = javax.activation.SecuritySupport.getContextClassLoader()     // Catch:{ Exception -> 0x00e7 }
            if (r2 != 0) goto L_0x0011
            java.lang.Class r2 = r9.getClass()     // Catch:{ Exception -> 0x00e7 }
            java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch:{ Exception -> 0x00e7 }
        L_0x0011:
            if (r2 == 0) goto L_0x0018
            java.net.URL[] r2 = javax.activation.SecuritySupport.getResources(r2, r11)     // Catch:{ Exception -> 0x00e7 }
            goto L_0x001c
        L_0x0018:
            java.net.URL[] r2 = javax.activation.SecuritySupport.getSystemResources(r11)     // Catch:{ Exception -> 0x00e7 }
        L_0x001c:
            if (r2 == 0) goto L_0x00fd
            boolean r3 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch:{ Exception -> 0x00e7 }
            if (r3 == 0) goto L_0x0029
            java.lang.String r3 = "MimetypesFileTypeMap: getResources"
            com.sun.activation.registries.LogSupport.log(r3)     // Catch:{ Exception -> 0x00e7 }
        L_0x0029:
            r3 = 0
        L_0x002a:
            int r4 = r2.length     // Catch:{ Exception -> 0x00e4 }
            if (r1 < r4) goto L_0x0030
            r1 = r3
            goto L_0x00fd
        L_0x0030:
            r4 = r2[r1]     // Catch:{ Exception -> 0x00e4 }
            r5 = 0
            boolean r6 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch:{ Exception -> 0x00e4 }
            if (r6 == 0) goto L_0x004a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r7 = "MimetypesFileTypeMap: URL "
            r6.<init>(r7)     // Catch:{ Exception -> 0x00e4 }
            r6.append(r4)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00e4 }
            com.sun.activation.registries.LogSupport.log(r6)     // Catch:{ Exception -> 0x00e4 }
        L_0x004a:
            r6 = 1
            java.io.InputStream r5 = javax.activation.SecuritySupport.openStream(r4)     // Catch:{ IOException -> 0x00b5, SecurityException -> 0x0099, all -> 0x0097 }
            if (r5 == 0) goto L_0x007a
            com.sun.activation.registries.MimeTypeFile r7 = new com.sun.activation.registries.MimeTypeFile     // Catch:{ IOException -> 0x00b5, SecurityException -> 0x0099, all -> 0x0097 }
            r7.<init>((java.io.InputStream) r5)     // Catch:{ IOException -> 0x00b5, SecurityException -> 0x0099, all -> 0x0097 }
            r10.addElement(r7)     // Catch:{ IOException -> 0x00b5, SecurityException -> 0x0099, all -> 0x0097 }
            boolean r3 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch:{ IOException -> 0x0078, SecurityException -> 0x0076, all -> 0x0072 }
            if (r3 == 0) goto L_0x0070
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0078, SecurityException -> 0x0076, all -> 0x0072 }
            java.lang.String r7 = "MimetypesFileTypeMap: successfully loaded mime types from URL: "
            r3.<init>(r7)     // Catch:{ IOException -> 0x0078, SecurityException -> 0x0076, all -> 0x0072 }
            r3.append(r4)     // Catch:{ IOException -> 0x0078, SecurityException -> 0x0076, all -> 0x0072 }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x0078, SecurityException -> 0x0076, all -> 0x0072 }
            com.sun.activation.registries.LogSupport.log(r3)     // Catch:{ IOException -> 0x0078, SecurityException -> 0x0076, all -> 0x0072 }
        L_0x0070:
            r3 = 1
            goto L_0x0091
        L_0x0072:
            r1 = move-exception
            r3 = 1
            goto L_0x00de
        L_0x0076:
            r3 = move-exception
            goto L_0x009d
        L_0x0078:
            r3 = move-exception
            goto L_0x00b9
        L_0x007a:
            boolean r6 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch:{ IOException -> 0x00b5, SecurityException -> 0x0099, all -> 0x0097 }
            if (r6 == 0) goto L_0x0091
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b5, SecurityException -> 0x0099, all -> 0x0097 }
            java.lang.String r7 = "MimetypesFileTypeMap: not loading mime types from URL: "
            r6.<init>(r7)     // Catch:{ IOException -> 0x00b5, SecurityException -> 0x0099, all -> 0x0097 }
            r6.append(r4)     // Catch:{ IOException -> 0x00b5, SecurityException -> 0x0099, all -> 0x0097 }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x00b5, SecurityException -> 0x0099, all -> 0x0097 }
            com.sun.activation.registries.LogSupport.log(r6)     // Catch:{ IOException -> 0x00b5, SecurityException -> 0x0099, all -> 0x0097 }
        L_0x0091:
            if (r5 == 0) goto L_0x00d8
            r5.close()     // Catch:{ IOException -> 0x00d8 }
            goto L_0x00d8
        L_0x0097:
            r1 = move-exception
            goto L_0x00de
        L_0x0099:
            r6 = move-exception
            r8 = r6
            r6 = r3
            r3 = r8
        L_0x009d:
            boolean r7 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch:{ all -> 0x00dc }
            if (r7 == 0) goto L_0x00b2
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dc }
            r7.<init>(r0)     // Catch:{ all -> 0x00dc }
            r7.append(r4)     // Catch:{ all -> 0x00dc }
            java.lang.String r4 = r7.toString()     // Catch:{ all -> 0x00dc }
            com.sun.activation.registries.LogSupport.log(r4, r3)     // Catch:{ all -> 0x00dc }
        L_0x00b2:
            if (r5 == 0) goto L_0x00d7
            goto L_0x00d0
        L_0x00b5:
            r6 = move-exception
            r8 = r6
            r6 = r3
            r3 = r8
        L_0x00b9:
            boolean r7 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch:{ all -> 0x00dc }
            if (r7 == 0) goto L_0x00ce
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dc }
            r7.<init>(r0)     // Catch:{ all -> 0x00dc }
            r7.append(r4)     // Catch:{ all -> 0x00dc }
            java.lang.String r4 = r7.toString()     // Catch:{ all -> 0x00dc }
            com.sun.activation.registries.LogSupport.log(r4, r3)     // Catch:{ all -> 0x00dc }
        L_0x00ce:
            if (r5 == 0) goto L_0x00d7
        L_0x00d0:
            r5.close()     // Catch:{ IOException -> 0x00d7, Exception -> 0x00d4 }
            goto L_0x00d7
        L_0x00d4:
            r2 = move-exception
            r1 = r6
            goto L_0x00e8
        L_0x00d7:
            r3 = r6
        L_0x00d8:
            int r1 = r1 + 1
            goto L_0x002a
        L_0x00dc:
            r1 = move-exception
            r3 = r6
        L_0x00de:
            if (r5 == 0) goto L_0x00e3
            r5.close()     // Catch:{ IOException -> 0x00e3 }
        L_0x00e3:
            throw r1     // Catch:{ Exception -> 0x00e4 }
        L_0x00e4:
            r2 = move-exception
            r1 = r3
            goto L_0x00e8
        L_0x00e7:
            r2 = move-exception
        L_0x00e8:
            boolean r3 = com.sun.activation.registries.LogSupport.isLoggable()
            if (r3 == 0) goto L_0x00fd
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r0)
            r3.append(r11)
            java.lang.String r0 = r3.toString()
            com.sun.activation.registries.LogSupport.log(r0, r2)
        L_0x00fd:
            if (r1 != 0) goto L_0x011b
            java.lang.String r0 = "MimetypesFileTypeMap: !anyLoaded"
            com.sun.activation.registries.LogSupport.log(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "/"
            r0.<init>(r1)
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            com.sun.activation.registries.MimeTypeFile r11 = r9.loadResource(r11)
            if (r11 == 0) goto L_0x011b
            r10.addElement(r11)
        L_0x011b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MimetypesFileTypeMap.loadAllResources(java.util.Vector, java.lang.String):void");
    }

    private MimeTypeFile loadFile(String str) {
        try {
            return new MimeTypeFile(str);
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0046, code lost:
        if (r2 != null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0083, code lost:
        if (r2 == null) goto L_0x0086;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005a A[Catch:{ IOException -> 0x006c, SecurityException -> 0x0052, all -> 0x0050, all -> 0x0087 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006b A[Catch:{ IOException -> 0x006c, SecurityException -> 0x0052, all -> 0x0050, all -> 0x0087 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074 A[Catch:{ IOException -> 0x006c, SecurityException -> 0x0052, all -> 0x0050, all -> 0x0087 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008b A[SYNTHETIC, Splitter:B:42:0x008b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.sun.activation.registries.MimeTypeFile loadResource(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "MimetypesFileTypeMap: can't load "
            r1 = 0
            java.lang.Class r2 = r6.getClass()     // Catch:{ IOException -> 0x006c, SecurityException -> 0x0052, all -> 0x0050 }
            java.io.InputStream r2 = javax.activation.SecuritySupport.getResourceAsStream(r2, r7)     // Catch:{ IOException -> 0x006c, SecurityException -> 0x0052, all -> 0x0050 }
            if (r2 == 0) goto L_0x002f
            com.sun.activation.registries.MimeTypeFile r3 = new com.sun.activation.registries.MimeTypeFile     // Catch:{ IOException -> 0x004e, SecurityException -> 0x004c }
            r3.<init>((java.io.InputStream) r2)     // Catch:{ IOException -> 0x004e, SecurityException -> 0x004c }
            boolean r4 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch:{ IOException -> 0x004e, SecurityException -> 0x004c }
            if (r4 == 0) goto L_0x0029
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x004e, SecurityException -> 0x004c }
            java.lang.String r5 = "MimetypesFileTypeMap: successfully loaded mime types file: "
            r4.<init>(r5)     // Catch:{ IOException -> 0x004e, SecurityException -> 0x004c }
            r4.append(r7)     // Catch:{ IOException -> 0x004e, SecurityException -> 0x004c }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x004e, SecurityException -> 0x004c }
            com.sun.activation.registries.LogSupport.log(r4)     // Catch:{ IOException -> 0x004e, SecurityException -> 0x004c }
        L_0x0029:
            if (r2 == 0) goto L_0x002e
            r2.close()     // Catch:{ IOException -> 0x002e }
        L_0x002e:
            return r3
        L_0x002f:
            boolean r3 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch:{ IOException -> 0x004e, SecurityException -> 0x004c }
            if (r3 == 0) goto L_0x0046
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x004e, SecurityException -> 0x004c }
            java.lang.String r4 = "MimetypesFileTypeMap: not loading mime types file: "
            r3.<init>(r4)     // Catch:{ IOException -> 0x004e, SecurityException -> 0x004c }
            r3.append(r7)     // Catch:{ IOException -> 0x004e, SecurityException -> 0x004c }
            java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x004e, SecurityException -> 0x004c }
            com.sun.activation.registries.LogSupport.log(r3)     // Catch:{ IOException -> 0x004e, SecurityException -> 0x004c }
        L_0x0046:
            if (r2 == 0) goto L_0x0086
        L_0x0048:
            r2.close()     // Catch:{ IOException -> 0x0086 }
            goto L_0x0086
        L_0x004c:
            r3 = move-exception
            goto L_0x0054
        L_0x004e:
            r3 = move-exception
            goto L_0x006e
        L_0x0050:
            r7 = move-exception
            goto L_0x0089
        L_0x0052:
            r3 = move-exception
            r2 = r1
        L_0x0054:
            boolean r4 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch:{ all -> 0x0087 }
            if (r4 == 0) goto L_0x0069
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            r4.<init>(r0)     // Catch:{ all -> 0x0087 }
            r4.append(r7)     // Catch:{ all -> 0x0087 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x0087 }
            com.sun.activation.registries.LogSupport.log(r7, r3)     // Catch:{ all -> 0x0087 }
        L_0x0069:
            if (r2 == 0) goto L_0x0086
            goto L_0x0048
        L_0x006c:
            r3 = move-exception
            r2 = r1
        L_0x006e:
            boolean r4 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch:{ all -> 0x0087 }
            if (r4 == 0) goto L_0x0083
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            r4.<init>(r0)     // Catch:{ all -> 0x0087 }
            r4.append(r7)     // Catch:{ all -> 0x0087 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x0087 }
            com.sun.activation.registries.LogSupport.log(r7, r3)     // Catch:{ all -> 0x0087 }
        L_0x0083:
            if (r2 == 0) goto L_0x0086
            goto L_0x0048
        L_0x0086:
            return r1
        L_0x0087:
            r7 = move-exception
            r1 = r2
        L_0x0089:
            if (r1 == 0) goto L_0x008e
            r1.close()     // Catch:{ IOException -> 0x008e }
        L_0x008e:
            goto L_0x0090
        L_0x008f:
            throw r7
        L_0x0090:
            goto L_0x008f
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MimetypesFileTypeMap.loadResource(java.lang.String):com.sun.activation.registries.MimeTypeFile");
    }

    public synchronized void addMimeTypes(String str) {
        MimeTypeFile[] mimeTypeFileArr = this.DB;
        if (mimeTypeFileArr[0] == null) {
            mimeTypeFileArr[0] = new MimeTypeFile();
        }
        this.DB[0].appendToRegistry(str);
    }

    public String getContentType(File file) {
        return getContentType(file.getName());
    }

    public synchronized String getContentType(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0) {
            return defaultType;
        }
        String substring = str.substring(lastIndexOf + 1);
        if (substring.length() == 0) {
            return defaultType;
        }
        int i2 = 0;
        while (true) {
            MimeTypeFile[] mimeTypeFileArr = this.DB;
            if (i2 >= mimeTypeFileArr.length) {
                return defaultType;
            }
            if (mimeTypeFileArr[i2] != null) {
                String mIMETypeString = mimeTypeFileArr[i2].getMIMETypeString(substring);
                if (mIMETypeString != null) {
                    return mIMETypeString;
                }
            }
            i2++;
        }
    }
}
