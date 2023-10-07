package javax.activation;

import com.sun.activation.registries.LogSupport;
import com.sun.activation.registries.MailcapFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class MailcapCommandMap extends CommandMap {
    private static final int PROG = 0;
    private static MailcapFile defDB;
    private MailcapFile[] DB;

    public MailcapCommandMap() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add((Object) null);
        LogSupport.log("MailcapCommandMap: load HOME");
        try {
            String property = System.getProperty("user.home");
            if (property != null) {
                MailcapFile loadFile = loadFile(String.valueOf(property) + File.separator + ".mailcap");
                if (loadFile != null) {
                    arrayList.add(loadFile);
                }
            }
        } catch (SecurityException unused) {
        }
        LogSupport.log("MailcapCommandMap: load SYS");
        try {
            MailcapFile loadFile2 = loadFile(String.valueOf(System.getProperty("java.home")) + File.separator + "lib" + File.separator + "mailcap");
            if (loadFile2 != null) {
                arrayList.add(loadFile2);
            }
        } catch (SecurityException unused2) {
        }
        LogSupport.log("MailcapCommandMap: load JAR");
        loadAllResources(arrayList, "mailcap");
        LogSupport.log("MailcapCommandMap: load DEF");
        synchronized (MailcapCommandMap.class) {
            if (defDB == null) {
                defDB = loadResource("mailcap.default");
            }
        }
        MailcapFile mailcapFile = defDB;
        if (mailcapFile != null) {
            arrayList.add(mailcapFile);
        }
        MailcapFile[] mailcapFileArr = new MailcapFile[arrayList.size()];
        this.DB = mailcapFileArr;
        this.DB = (MailcapFile[]) arrayList.toArray(mailcapFileArr);
    }

    public MailcapCommandMap(InputStream inputStream) {
        this();
        LogSupport.log("MailcapCommandMap: load PROG");
        MailcapFile[] mailcapFileArr = this.DB;
        if (mailcapFileArr[0] == null) {
            try {
                mailcapFileArr[0] = new MailcapFile(inputStream);
            } catch (IOException unused) {
            }
        }
    }

    public MailcapCommandMap(String str) throws IOException {
        this();
        if (LogSupport.isLoggable()) {
            LogSupport.log("MailcapCommandMap: load PROG from " + str);
        }
        MailcapFile[] mailcapFileArr = this.DB;
        if (mailcapFileArr[0] == null) {
            mailcapFileArr[0] = new MailcapFile(str);
        }
    }

    private void appendCmdsToList(Map map, List list) {
        for (String str : map.keySet()) {
            for (String commandInfo : (List) map.get(str)) {
                list.add(new CommandInfo(str, commandInfo));
            }
        }
    }

    private void appendPrefCmdsToList(Map map, List list) {
        for (String str : map.keySet()) {
            if (!checkForVerb(list, str)) {
                list.add(new CommandInfo(str, (String) ((List) map.get(str)).get(0)));
            }
        }
    }

    private boolean checkForVerb(List list, String str) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            if (((CommandInfo) it2.next()).getCommandName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r1 = java.lang.Class.forName(r4);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0037 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private javax.activation.DataContentHandler getDataContentHandler(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r0 = "Can't load DCH "
            boolean r1 = com.sun.activation.registries.LogSupport.isLoggable()
            if (r1 == 0) goto L_0x000d
            java.lang.String r1 = "    got content-handler"
            com.sun.activation.registries.LogSupport.log(r1)
        L_0x000d:
            boolean r1 = com.sun.activation.registries.LogSupport.isLoggable()
            if (r1 == 0) goto L_0x0024
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "      class "
            r1.<init>(r2)
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            com.sun.activation.registries.LogSupport.log(r1)
        L_0x0024:
            java.lang.ClassLoader r1 = javax.activation.SecuritySupport.getContextClassLoader()     // Catch:{ IllegalAccessException -> 0x005e, ClassNotFoundException -> 0x0051, InstantiationException -> 0x0044 }
            if (r1 != 0) goto L_0x0032
            java.lang.Class r1 = r3.getClass()     // Catch:{ IllegalAccessException -> 0x005e, ClassNotFoundException -> 0x0051, InstantiationException -> 0x0044 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ IllegalAccessException -> 0x005e, ClassNotFoundException -> 0x0051, InstantiationException -> 0x0044 }
        L_0x0032:
            java.lang.Class r1 = r1.loadClass(r4)     // Catch:{ Exception -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            java.lang.Class r1 = java.lang.Class.forName(r4)     // Catch:{ IllegalAccessException -> 0x005e, ClassNotFoundException -> 0x0051, InstantiationException -> 0x0044 }
        L_0x003b:
            if (r1 == 0) goto L_0x0074
            java.lang.Object r1 = r1.newInstance()     // Catch:{ IllegalAccessException -> 0x005e, ClassNotFoundException -> 0x0051, InstantiationException -> 0x0044 }
            javax.activation.DataContentHandler r1 = (javax.activation.DataContentHandler) r1     // Catch:{ IllegalAccessException -> 0x005e, ClassNotFoundException -> 0x0051, InstantiationException -> 0x0044 }
            return r1
        L_0x0044:
            r1 = move-exception
            boolean r2 = com.sun.activation.registries.LogSupport.isLoggable()
            if (r2 == 0) goto L_0x0074
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            goto L_0x006a
        L_0x0051:
            r1 = move-exception
            boolean r2 = com.sun.activation.registries.LogSupport.isLoggable()
            if (r2 == 0) goto L_0x0074
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            goto L_0x006a
        L_0x005e:
            r1 = move-exception
            boolean r2 = com.sun.activation.registries.LogSupport.isLoggable()
            if (r2 == 0) goto L_0x0074
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
        L_0x006a:
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            com.sun.activation.registries.LogSupport.log(r4, r1)
        L_0x0074:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MailcapCommandMap.getDataContentHandler(java.lang.String):javax.activation.DataContentHandler");
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
    /* JADX WARNING: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void loadAllResources(java.util.List r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "MailcapCommandMap: can't load "
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
            java.lang.String r3 = "MailcapCommandMap: getResources"
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
            java.lang.String r7 = "MailcapCommandMap: URL "
            r6.<init>(r7)     // Catch:{ Exception -> 0x00e4 }
            r6.append(r4)     // Catch:{ Exception -> 0x00e4 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00e4 }
            com.sun.activation.registries.LogSupport.log(r6)     // Catch:{ Exception -> 0x00e4 }
        L_0x004a:
            r6 = 1
            java.io.InputStream r5 = javax.activation.SecuritySupport.openStream(r4)     // Catch:{ IOException -> 0x00b5, SecurityException -> 0x0099, all -> 0x0097 }
            if (r5 == 0) goto L_0x007a
            com.sun.activation.registries.MailcapFile r7 = new com.sun.activation.registries.MailcapFile     // Catch:{ IOException -> 0x00b5, SecurityException -> 0x0099, all -> 0x0097 }
            r7.<init>((java.io.InputStream) r5)     // Catch:{ IOException -> 0x00b5, SecurityException -> 0x0099, all -> 0x0097 }
            r10.add(r7)     // Catch:{ IOException -> 0x00b5, SecurityException -> 0x0099, all -> 0x0097 }
            boolean r3 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch:{ IOException -> 0x0078, SecurityException -> 0x0076, all -> 0x0072 }
            if (r3 == 0) goto L_0x0070
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0078, SecurityException -> 0x0076, all -> 0x0072 }
            java.lang.String r7 = "MailcapCommandMap: successfully loaded mailcap file from URL: "
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
            java.lang.String r7 = "MailcapCommandMap: not loading mailcap file from URL: "
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
            if (r1 != 0) goto L_0x0121
            boolean r0 = com.sun.activation.registries.LogSupport.isLoggable()
            if (r0 == 0) goto L_0x010a
            java.lang.String r0 = "MailcapCommandMap: !anyLoaded"
            com.sun.activation.registries.LogSupport.log(r0)
        L_0x010a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "/"
            r0.<init>(r1)
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            com.sun.activation.registries.MailcapFile r11 = r9.loadResource(r11)
            if (r11 == 0) goto L_0x0121
            r10.add(r11)
        L_0x0121:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MailcapCommandMap.loadAllResources(java.util.List, java.lang.String):void");
    }

    private MailcapFile loadFile(String str) {
        try {
            return new MailcapFile(str);
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
    private com.sun.activation.registries.MailcapFile loadResource(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "MailcapCommandMap: can't load "
            r1 = 0
            java.lang.Class r2 = r6.getClass()     // Catch:{ IOException -> 0x006c, SecurityException -> 0x0052, all -> 0x0050 }
            java.io.InputStream r2 = javax.activation.SecuritySupport.getResourceAsStream(r2, r7)     // Catch:{ IOException -> 0x006c, SecurityException -> 0x0052, all -> 0x0050 }
            if (r2 == 0) goto L_0x002f
            com.sun.activation.registries.MailcapFile r3 = new com.sun.activation.registries.MailcapFile     // Catch:{ IOException -> 0x004e, SecurityException -> 0x004c }
            r3.<init>((java.io.InputStream) r2)     // Catch:{ IOException -> 0x004e, SecurityException -> 0x004c }
            boolean r4 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch:{ IOException -> 0x004e, SecurityException -> 0x004c }
            if (r4 == 0) goto L_0x0029
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x004e, SecurityException -> 0x004c }
            java.lang.String r5 = "MailcapCommandMap: successfully loaded mailcap file: "
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
            java.lang.String r4 = "MailcapCommandMap: not loading mailcap file: "
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
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MailcapCommandMap.loadResource(java.lang.String):com.sun.activation.registries.MailcapFile");
    }

    public synchronized void addMailcap(String str) {
        LogSupport.log("MailcapCommandMap: add to PROG");
        MailcapFile[] mailcapFileArr = this.DB;
        if (mailcapFileArr[0] == null) {
            mailcapFileArr[0] = new MailcapFile();
        }
        this.DB[0].appendToMailcap(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
        r2 = r4.DB;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        if (r1 < r2.length) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0032, code lost:
        if (r2[r1] != null) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0039, code lost:
        if (com.sun.activation.registries.LogSupport.isLoggable() == false) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003b, code lost:
        com.sun.activation.registries.LogSupport.log("  search fallback DB #" + r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004c, code lost:
        r2 = r4.DB[r1].getMailcapFallbackList(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0054, code lost:
        if (r2 == null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0056, code lost:
        r2 = (java.util.List) r2.get("content-handler");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x005e, code lost:
        if (r2 == null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0060, code lost:
        r2 = getDataContentHandler((java.lang.String) r2.get(0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006a, code lost:
        if (r2 == null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006d, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x006e, code lost:
        r1 = r1 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized javax.activation.DataContentHandler createDataContentHandler(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch:{ all -> 0x00b3 }
            if (r0 == 0) goto L_0x0018
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b3 }
            java.lang.String r1 = "MailcapCommandMap: createDataContentHandler for "
            r0.<init>(r1)     // Catch:{ all -> 0x00b3 }
            r0.append(r5)     // Catch:{ all -> 0x00b3 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00b3 }
            com.sun.activation.registries.LogSupport.log(r0)     // Catch:{ all -> 0x00b3 }
        L_0x0018:
            if (r5 == 0) goto L_0x0020
            java.util.Locale r0 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x00b3 }
            java.lang.String r5 = r5.toLowerCase(r0)     // Catch:{ all -> 0x00b3 }
        L_0x0020:
            r0 = 0
            r1 = 0
        L_0x0022:
            com.sun.activation.registries.MailcapFile[] r2 = r4.DB     // Catch:{ all -> 0x00b3 }
            int r3 = r2.length     // Catch:{ all -> 0x00b3 }
            if (r1 < r3) goto L_0x0071
            r1 = 0
        L_0x0028:
            com.sun.activation.registries.MailcapFile[] r2 = r4.DB     // Catch:{ all -> 0x00b3 }
            int r3 = r2.length     // Catch:{ all -> 0x00b3 }
            if (r1 < r3) goto L_0x0030
            r5 = 0
            monitor-exit(r4)
            return r5
        L_0x0030:
            r2 = r2[r1]     // Catch:{ all -> 0x00b3 }
            if (r2 != 0) goto L_0x0035
            goto L_0x006e
        L_0x0035:
            boolean r2 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch:{ all -> 0x00b3 }
            if (r2 == 0) goto L_0x004c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b3 }
            java.lang.String r3 = "  search fallback DB #"
            r2.<init>(r3)     // Catch:{ all -> 0x00b3 }
            r2.append(r1)     // Catch:{ all -> 0x00b3 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00b3 }
            com.sun.activation.registries.LogSupport.log(r2)     // Catch:{ all -> 0x00b3 }
        L_0x004c:
            com.sun.activation.registries.MailcapFile[] r2 = r4.DB     // Catch:{ all -> 0x00b3 }
            r2 = r2[r1]     // Catch:{ all -> 0x00b3 }
            java.util.Map r2 = r2.getMailcapFallbackList(r5)     // Catch:{ all -> 0x00b3 }
            if (r2 == 0) goto L_0x006e
            java.lang.String r3 = "content-handler"
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x00b3 }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x00b3 }
            if (r2 == 0) goto L_0x006e
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x00b3 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00b3 }
            javax.activation.DataContentHandler r2 = r4.getDataContentHandler(r2)     // Catch:{ all -> 0x00b3 }
            if (r2 == 0) goto L_0x006e
            monitor-exit(r4)
            return r2
        L_0x006e:
            int r1 = r1 + 1
            goto L_0x0028
        L_0x0071:
            r2 = r2[r1]     // Catch:{ all -> 0x00b3 }
            if (r2 != 0) goto L_0x0076
            goto L_0x00af
        L_0x0076:
            boolean r2 = com.sun.activation.registries.LogSupport.isLoggable()     // Catch:{ all -> 0x00b3 }
            if (r2 == 0) goto L_0x008d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b3 }
            java.lang.String r3 = "  search DB #"
            r2.<init>(r3)     // Catch:{ all -> 0x00b3 }
            r2.append(r1)     // Catch:{ all -> 0x00b3 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00b3 }
            com.sun.activation.registries.LogSupport.log(r2)     // Catch:{ all -> 0x00b3 }
        L_0x008d:
            com.sun.activation.registries.MailcapFile[] r2 = r4.DB     // Catch:{ all -> 0x00b3 }
            r2 = r2[r1]     // Catch:{ all -> 0x00b3 }
            java.util.Map r2 = r2.getMailcapList(r5)     // Catch:{ all -> 0x00b3 }
            if (r2 == 0) goto L_0x00af
            java.lang.String r3 = "content-handler"
            java.lang.Object r2 = r2.get(r3)     // Catch:{ all -> 0x00b3 }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x00b3 }
            if (r2 == 0) goto L_0x00af
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x00b3 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00b3 }
            javax.activation.DataContentHandler r2 = r4.getDataContentHandler(r2)     // Catch:{ all -> 0x00b3 }
            if (r2 == 0) goto L_0x00af
            monitor-exit(r4)
            return r2
        L_0x00af:
            int r1 = r1 + 1
            goto L_0x0022
        L_0x00b3:
            r5 = move-exception
            monitor-exit(r4)
            goto L_0x00b7
        L_0x00b6:
            throw r5
        L_0x00b7:
            goto L_0x00b6
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MailcapCommandMap.createDataContentHandler(java.lang.String):javax.activation.DataContentHandler");
    }

    public synchronized CommandInfo[] getAllCommands(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (str != null) {
            str = str.toLowerCase(Locale.ENGLISH);
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            MailcapFile[] mailcapFileArr = this.DB;
            if (i3 >= mailcapFileArr.length) {
                break;
            }
            if (mailcapFileArr[i3] != null) {
                Map mailcapList = mailcapFileArr[i3].getMailcapList(str);
                if (mailcapList != null) {
                    appendCmdsToList(mailcapList, arrayList);
                }
            }
            i3++;
        }
        while (true) {
            MailcapFile[] mailcapFileArr2 = this.DB;
            if (i2 >= mailcapFileArr2.length) {
            } else {
                if (mailcapFileArr2[i2] != null) {
                    Map mailcapFallbackList = mailcapFileArr2[i2].getMailcapFallbackList(str);
                    if (mailcapFallbackList != null) {
                        appendCmdsToList(mailcapFallbackList, arrayList);
                    }
                }
                i2++;
            }
        }
        return (CommandInfo[]) arrayList.toArray(new CommandInfo[arrayList.size()]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
        r2 = r4.DB;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        if (r1 < r2.length) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001b, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001e, code lost:
        if (r2[r1] != null) goto L_0x0021;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0021, code lost:
        r2 = r2[r1].getMailcapFallbackList(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0027, code lost:
        if (r2 == null) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0029, code lost:
        r2 = (java.util.List) r2.get(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002f, code lost:
        if (r2 == null) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0031, code lost:
        r2 = (java.lang.String) r2.get(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0037, code lost:
        if (r2 == null) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003f, code lost:
        return new javax.activation.CommandInfo(r6, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0040, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        r1 = 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized javax.activation.CommandInfo getCommand(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 == 0) goto L_0x000c
            java.util.Locale r0 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x000a }
            java.lang.String r5 = r5.toLowerCase(r0)     // Catch:{ all -> 0x000a }
            goto L_0x000c
        L_0x000a:
            r5 = move-exception
            goto L_0x006a
        L_0x000c:
            r0 = 0
            r1 = 0
        L_0x000e:
            com.sun.activation.registries.MailcapFile[] r2 = r4.DB     // Catch:{ all -> 0x000a }
            int r3 = r2.length     // Catch:{ all -> 0x000a }
            if (r1 < r3) goto L_0x0043
            r1 = 0
        L_0x0014:
            com.sun.activation.registries.MailcapFile[] r2 = r4.DB     // Catch:{ all -> 0x000a }
            int r3 = r2.length     // Catch:{ all -> 0x000a }
            if (r1 < r3) goto L_0x001c
            r5 = 0
            monitor-exit(r4)
            return r5
        L_0x001c:
            r3 = r2[r1]     // Catch:{ all -> 0x000a }
            if (r3 != 0) goto L_0x0021
            goto L_0x0040
        L_0x0021:
            r2 = r2[r1]     // Catch:{ all -> 0x000a }
            java.util.Map r2 = r2.getMailcapFallbackList(r5)     // Catch:{ all -> 0x000a }
            if (r2 == 0) goto L_0x0040
            java.lang.Object r2 = r2.get(r6)     // Catch:{ all -> 0x000a }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x000a }
            if (r2 == 0) goto L_0x0040
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x000a }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x000a }
            if (r2 == 0) goto L_0x0040
            javax.activation.CommandInfo r5 = new javax.activation.CommandInfo     // Catch:{ all -> 0x000a }
            r5.<init>(r6, r2)     // Catch:{ all -> 0x000a }
            monitor-exit(r4)
            return r5
        L_0x0040:
            int r1 = r1 + 1
            goto L_0x0014
        L_0x0043:
            r3 = r2[r1]     // Catch:{ all -> 0x000a }
            if (r3 != 0) goto L_0x0048
            goto L_0x0067
        L_0x0048:
            r2 = r2[r1]     // Catch:{ all -> 0x000a }
            java.util.Map r2 = r2.getMailcapList(r5)     // Catch:{ all -> 0x000a }
            if (r2 == 0) goto L_0x0067
            java.lang.Object r2 = r2.get(r6)     // Catch:{ all -> 0x000a }
            java.util.List r2 = (java.util.List) r2     // Catch:{ all -> 0x000a }
            if (r2 == 0) goto L_0x0067
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x000a }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x000a }
            if (r2 == 0) goto L_0x0067
            javax.activation.CommandInfo r5 = new javax.activation.CommandInfo     // Catch:{ all -> 0x000a }
            r5.<init>(r6, r2)     // Catch:{ all -> 0x000a }
            monitor-exit(r4)
            return r5
        L_0x0067:
            int r1 = r1 + 1
            goto L_0x000e
        L_0x006a:
            monitor-exit(r4)
            goto L_0x006d
        L_0x006c:
            throw r5
        L_0x006d:
            goto L_0x006c
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MailcapCommandMap.getCommand(java.lang.String, java.lang.String):javax.activation.CommandInfo");
    }

    public synchronized String[] getMimeTypes() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            MailcapFile[] mailcapFileArr = this.DB;
            if (i2 >= mailcapFileArr.length) {
            } else {
                if (mailcapFileArr[i2] != null) {
                    String[] mimeTypes = mailcapFileArr[i2].getMimeTypes();
                    if (mimeTypes != null) {
                        for (int i3 = 0; i3 < mimeTypes.length; i3++) {
                            if (!arrayList.contains(mimeTypes[i3])) {
                                arrayList.add(mimeTypes[i3]);
                            }
                        }
                    }
                }
                i2++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public synchronized String[] getNativeCommands(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (str != null) {
            str = str.toLowerCase(Locale.ENGLISH);
        }
        int i2 = 0;
        while (true) {
            MailcapFile[] mailcapFileArr = this.DB;
            if (i2 >= mailcapFileArr.length) {
            } else {
                if (mailcapFileArr[i2] != null) {
                    String[] nativeCommands = mailcapFileArr[i2].getNativeCommands(str);
                    if (nativeCommands != null) {
                        for (int i3 = 0; i3 < nativeCommands.length; i3++) {
                            if (!arrayList.contains(nativeCommands[i3])) {
                                arrayList.add(nativeCommands[i3]);
                            }
                        }
                    }
                }
                i2++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public synchronized CommandInfo[] getPreferredCommands(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (str != null) {
            str = str.toLowerCase(Locale.ENGLISH);
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            MailcapFile[] mailcapFileArr = this.DB;
            if (i3 >= mailcapFileArr.length) {
                break;
            }
            if (mailcapFileArr[i3] != null) {
                Map mailcapList = mailcapFileArr[i3].getMailcapList(str);
                if (mailcapList != null) {
                    appendPrefCmdsToList(mailcapList, arrayList);
                }
            }
            i3++;
        }
        while (true) {
            MailcapFile[] mailcapFileArr2 = this.DB;
            if (i2 >= mailcapFileArr2.length) {
            } else {
                if (mailcapFileArr2[i2] != null) {
                    Map mailcapFallbackList = mailcapFileArr2[i2].getMailcapFallbackList(str);
                    if (mailcapFallbackList != null) {
                        appendPrefCmdsToList(mailcapFallbackList, arrayList);
                    }
                }
                i2++;
            }
        }
        return (CommandInfo[]) arrayList.toArray(new CommandInfo[arrayList.size()]);
    }
}
